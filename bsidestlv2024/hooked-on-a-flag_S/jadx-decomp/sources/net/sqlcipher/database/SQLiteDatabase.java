package net.sqlcipher.database;

import a.q.a.a;
import a.q.a.d;
import android.content.ContentValues;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDebug;

/* loaded from: classes.dex */
public class SQLiteDatabase extends SQLiteClosable implements a {
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    public static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static final String KEY_ENCODING = "UTF-8";
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final String MEMORY = ":memory:";
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "4.5.0";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private int mCacheFullWarnings;
    public Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    public long mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    public int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private static final String[] CONFLICT_VALUES = {BuildConfig.FLAVOR, " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private static int sQueryLogTimeInMillis = 0;

    /* loaded from: classes.dex */
    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    /* loaded from: classes.dex */
    public interface LibraryLoader {
        void loadLibraries(String... strArr);
    }

    /* loaded from: classes.dex */
    public enum SQLiteDatabaseTransactionType {
        Deferred,
        Immediate,
        Exclusive
    }

    private native void dbclose();

    private native void dbopen(String str, int i);

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void key(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void key_mutf8(char[] cArr);

    private native int native_getDbLookaside();

    private native void native_rawExecSQL(String str);

    private native int native_status(int i, boolean z);

    private native void rekey(byte[] bArr);

    public static native int releaseMemory();

    public static native void setICURoot(String str);

    public native int lastChangeCount();

    public native long lastInsertRow();

    public native void native_execSQL(String str);

    public native void native_setLocale(String str, int i);

    public int status(int operation, boolean reset) {
        return native_status(operation, reset);
    }

    public void changePassword(String password) {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        if (password != null) {
            byte[] keyMaterial = getBytes(password.toCharArray());
            rekey(keyMaterial);
            Arrays.fill(keyMaterial, (byte) 0);
        }
    }

    public void changePassword(char[] password) {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        if (password != null) {
            byte[] keyMaterial = getBytes(password);
            rekey(keyMaterial);
            Arrays.fill(keyMaterial, (byte) 0);
        }
    }

    private static void loadICUData(Context context, File workingDir) {
        OutputStream out = null;
        ZipInputStream in = null;
        File icuDir = new File(workingDir, "icu");
        File icuDataFile = new File(icuDir, "icudt46l.dat");
        try {
            try {
                if (!icuDir.exists()) {
                    icuDir.mkdirs();
                }
                if (!icuDataFile.exists()) {
                    in = new ZipInputStream(context.getAssets().open("icudt46l.zip"));
                    in.getNextEntry();
                    out = new FileOutputStream(icuDataFile);
                    byte[] buf = new byte[1024];
                    while (true) {
                        int len = in.read(buf);
                        if (len <= 0) {
                            break;
                        } else {
                            out.write(buf, 0, len);
                        }
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ioe) {
                        throw new RuntimeException(ioe);
                    }
                }
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (Throwable th) {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ioe2) {
                        throw new RuntimeException(ioe2);
                    }
                }
                if (out != null) {
                    out.flush();
                    out.close();
                }
                throw th;
            }
        } catch (Exception ex) {
            if (icuDataFile.exists()) {
                icuDataFile.delete();
            }
            throw new RuntimeException(ex);
        }
    }

    public static synchronized void loadLibs(Context context) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir());
        }
    }

    public static synchronized void loadLibs(Context context, File workingDir) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, workingDir, new LibraryLoader() { // from class: net.sqlcipher.database.SQLiteDatabase.1
                @Override // net.sqlcipher.database.SQLiteDatabase.LibraryLoader
                public void loadLibraries(String... libNames) {
                    for (String libName : libNames) {
                        System.loadLibrary(libName);
                    }
                }
            });
        }
    }

    public static synchronized void loadLibs(Context context, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir(), libraryLoader);
        }
    }

    public static synchronized void loadLibs(Context context, File workingDir, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            libraryLoader.loadLibraries("sqlcipher");
        }
    }

    public void addSQLiteClosable(SQLiteClosable closable) {
        lock();
        try {
            this.mPrograms.put(closable, null);
        } finally {
            unlock();
        }
    }

    public void removeSQLiteClosable(SQLiteClosable closable) {
        lock();
        try {
            this.mPrograms.remove(closable);
        } finally {
            unlock();
        }
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    public void onAllReferencesReleased() {
        if (isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            dbclose();
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
        }
    }

    public void setLockingEnabled(boolean lockingEnabled) {
        this.mLockingEnabled = lockingEnabled;
    }

    public void onCorruption() {
        this.mErrorHandler.onCorruption(this);
    }

    public void lock() {
        if (this.mLockingEnabled) {
            this.mLock.lock();
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            }
        }
    }

    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        }
    }

    public void unlock() {
        if (this.mLockingEnabled) {
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                checkLockHoldTime();
            }
            this.mLock.unlock();
        }
    }

    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            checkLockHoldTime();
        }
        this.mLock.unlock();
    }

    private void checkLockHoldTime() {
        long elapsedTime = SystemClock.elapsedRealtime();
        long lockedTime = elapsedTime - this.mLockAcquiredWallTime;
        if ((lockedTime >= 2000 || Log.isLoggable(TAG, 2) || elapsedTime - this.mLastLockMessageTime >= 20000) && lockedTime > 300) {
            int threadTime = (int) ((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000);
            if (threadTime > LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS || lockedTime > 2000) {
                this.mLastLockMessageTime = elapsedTime;
                String str = "lock held on " + this.mPath + " for " + lockedTime + "ms. Thread time was " + threadTime + "ms";
                boolean z = SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE;
            }
        }
    }

    public boolean isDatabaseIntegrityOk() {
        Pair<Boolean, String> result = getResultFromPragma("PRAGMA integrity_check;");
        return ((Boolean) result.first).booleanValue() ? ((String) result.second).equals("ok") : ((Boolean) result.first).booleanValue();
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return getAttachedDbs(this);
    }

    public boolean enableWriteAheadLogging() {
        if (inTransaction()) {
            throw new IllegalStateException("Write Ahead Logging cannot be enabled while in a transaction");
        }
        List<Pair<String, String>> attachedDbs = getAttachedDbs(this);
        if ((attachedDbs != null && attachedDbs.size() > 1) || isReadOnly() || getPath().equals(MEMORY)) {
            return false;
        }
        rawExecSQL("PRAGMA journal_mode = WAL;");
        return true;
    }

    public void disableWriteAheadLogging() {
        if (inTransaction()) {
            throw new IllegalStateException("Write Ahead Logging cannot be disabled while in a transaction");
        }
        rawExecSQL("PRAGMA journal_mode = DELETE;");
    }

    public boolean isWriteAheadLoggingEnabled() {
        Pair<Boolean, String> result = getResultFromPragma("PRAGMA journal_mode;");
        return ((Boolean) result.first).booleanValue() ? ((String) result.second).equals("wal") : ((Boolean) result.first).booleanValue();
    }

    public void setForeignKeyConstraintsEnabled(boolean enable) {
        if (inTransaction()) {
            throw new IllegalStateException("Foreign key constraints may not be changed while in a transaction");
        }
        Object[] objArr = new Object[1];
        objArr[0] = enable ? "ON" : "OFF";
        String command = String.format("PRAGMA foreign_keys = %s;", objArr);
        execSQL(command);
    }

    public void beginTransaction() {
        beginTransactionWithListener((SQLiteTransactionListener) null);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        beginTransactionWithListenerInternal(transactionListener, SQLiteDatabaseTransactionType.Exclusive);
    }

    public void beginTransactionNonExclusive() {
        beginTransactionWithListenerInternal(null, SQLiteDatabaseTransactionType.Immediate);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener transactionListener) {
        beginTransactionWithListenerInternal(transactionListener, SQLiteDatabaseTransactionType.Immediate);
    }

    public void endTransaction() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        if (!this.mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        }
        try {
            if (this.mInnerTransactionIsSuccessful) {
                this.mInnerTransactionIsSuccessful = false;
            } else {
                this.mTransactionIsSuccessful = false;
            }
            if (this.mLock.getHoldCount() != 1) {
                return;
            }
            RuntimeException savedException = null;
            SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
            if (sQLiteTransactionListener != null) {
                try {
                    if (this.mTransactionIsSuccessful) {
                        sQLiteTransactionListener.onCommit();
                    } else {
                        sQLiteTransactionListener.onRollback();
                    }
                } catch (RuntimeException e) {
                    savedException = e;
                    this.mTransactionIsSuccessful = false;
                }
            }
            if (this.mTransactionIsSuccessful) {
                execSQL(COMMIT_SQL);
            } else {
                try {
                    execSQL("ROLLBACK;");
                    if (savedException != null) {
                        throw savedException;
                    }
                } catch (SQLException e2) {
                }
            }
        } finally {
            this.mTransactionListener = null;
            unlockForced();
        }
    }

    public void setTransactionSuccessful() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        if (!this.mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        }
        if (this.mInnerTransactionIsSuccessful) {
            throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
        }
        this.mInnerTransactionIsSuccessful = true;
    }

    public boolean inTransaction() {
        return this.mLock.getHoldCount() > 0;
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        return !this.mLock.isHeldByCurrentThread() && this.mLock.isLocked();
    }

    @Deprecated
    public boolean yieldIfContended() {
        if (isOpen()) {
            return yieldIfContendedHelper(false, -1L);
        }
        return false;
    }

    public boolean yieldIfContendedSafely() {
        if (isOpen()) {
            return yieldIfContendedHelper(true, -1L);
        }
        return false;
    }

    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        if (isOpen()) {
            return yieldIfContendedHelper(true, sleepAfterYieldDelay);
        }
        return false;
    }

    private boolean yieldIfContendedHelper(boolean checkFullyYielded, long sleepAfterYieldDelay) {
        long j;
        if (this.mLock.getQueueLength() == 0) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        SQLiteTransactionListener transactionListener = this.mTransactionListener;
        endTransaction();
        if (checkFullyYielded && isDbLockedByCurrentThread()) {
            throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
        }
        if (sleepAfterYieldDelay > 0) {
            long remainingDelay = sleepAfterYieldDelay;
            while (remainingDelay > 0) {
                if (remainingDelay >= 1000) {
                    j = 1000;
                } else {
                    j = remainingDelay;
                }
                try {
                    Thread.sleep(j);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
                remainingDelay -= 1000;
                if (this.mLock.getQueueLength() == 0) {
                    break;
                }
            }
        }
        beginTransactionWithListener(transactionListener);
        return true;
    }

    public Map<String, String> getSyncedTables() {
        HashMap<String, String> tables;
        synchronized (this.mSyncUpdateInfo) {
            tables = new HashMap<>();
            for (String table : this.mSyncUpdateInfo.keySet()) {
                SyncUpdateInfo info = this.mSyncUpdateInfo.get(table);
                String str = info.deletedTable;
                if (str != null) {
                    tables.put(table, str);
                }
            }
        }
        return tables;
    }

    /* loaded from: classes.dex */
    public static class SyncUpdateInfo {
        public String deletedTable;
        public String foreignKey;
        public String masterTable;

        public SyncUpdateInfo(String masterTable, String deletedTable, String foreignKey) {
            this.masterTable = masterTable;
            this.deletedTable = deletedTable;
            this.foreignKey = foreignKey;
        }
    }

    public static SQLiteDatabase openDatabase(String path, String password, CursorFactory factory, int flags) {
        return openDatabase(path, password, factory, flags, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openDatabase(String path, char[] password, CursorFactory factory, int flags) {
        return openDatabase(path, password, factory, flags, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String path, String password, CursorFactory factory, int flags, SQLiteDatabaseHook hook) {
        return openDatabase(path, password, factory, flags, hook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String path, char[] password, CursorFactory factory, int flags, SQLiteDatabaseHook hook) {
        return openDatabase(path, password, factory, flags, hook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String path, String password, CursorFactory factory, int flags, SQLiteDatabaseHook hook, DatabaseErrorHandler errorHandler) {
        return openDatabase(path, password == null ? null : password.toCharArray(), factory, flags, hook, errorHandler);
    }

    public static SQLiteDatabase openDatabase(String path, char[] password, CursorFactory factory, int flags, SQLiteDatabaseHook hook, DatabaseErrorHandler errorHandler) {
        byte[] keyMaterial = getBytes(password);
        return openDatabase(path, keyMaterial, factory, flags, hook, errorHandler);
    }

    public static SQLiteDatabase openDatabase(String path, byte[] password, CursorFactory factory, int flags, SQLiteDatabaseHook hook, DatabaseErrorHandler errorHandler) {
        SQLiteDatabase sqliteDatabase = null;
        DatabaseErrorHandler myErrorHandler = errorHandler != null ? errorHandler : new DefaultDatabaseErrorHandler();
        try {
            sqliteDatabase = new SQLiteDatabase(path, factory, flags, myErrorHandler);
            sqliteDatabase.openDatabaseInternal(password, hook);
        } catch (SQLiteDatabaseCorruptException e) {
            myErrorHandler.onCorruption(sqliteDatabase);
            sqliteDatabase = new SQLiteDatabase(path, factory, flags, myErrorHandler);
            sqliteDatabase.openDatabaseInternal(password, hook);
        }
        if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
            sqliteDatabase.enableSqlTracing(path);
        }
        if (SQLiteDebug.DEBUG_SQL_TIME) {
            sqliteDatabase.enableSqlProfiling(path);
        }
        synchronized (sActiveDatabases) {
            sActiveDatabases.put(sqliteDatabase, null);
        }
        return sqliteDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String password, CursorFactory factory, SQLiteDatabaseHook databaseHook) {
        return openOrCreateDatabase(file, password, factory, databaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String password, CursorFactory factory, SQLiteDatabaseHook databaseHook, DatabaseErrorHandler errorHandler) {
        return openOrCreateDatabase(file == null ? null : file.getPath(), password, factory, databaseHook, errorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, String password, CursorFactory factory, SQLiteDatabaseHook databaseHook) {
        return openDatabase(path, password, factory, CREATE_IF_NECESSARY, databaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, String password, CursorFactory factory, SQLiteDatabaseHook databaseHook, DatabaseErrorHandler errorHandler) {
        return openDatabase(path, password == null ? null : password.toCharArray(), factory, CREATE_IF_NECESSARY, databaseHook, errorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, char[] password, CursorFactory factory, SQLiteDatabaseHook databaseHook) {
        return openDatabase(path, password, factory, CREATE_IF_NECESSARY, databaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, char[] password, CursorFactory factory, SQLiteDatabaseHook databaseHook, DatabaseErrorHandler errorHandler) {
        return openDatabase(path, password, factory, CREATE_IF_NECESSARY, databaseHook, errorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, byte[] password, CursorFactory factory, SQLiteDatabaseHook databaseHook) {
        return openDatabase(path, password, factory, CREATE_IF_NECESSARY, databaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, byte[] password, CursorFactory factory, SQLiteDatabaseHook databaseHook, DatabaseErrorHandler errorHandler) {
        return openDatabase(path, password, factory, CREATE_IF_NECESSARY, databaseHook, errorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String password, CursorFactory factory) {
        return openOrCreateDatabase(file, password, factory, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, String password, CursorFactory factory) {
        return openDatabase(path, password, factory, CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, char[] password, CursorFactory factory) {
        return openDatabase(path, password, factory, CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, byte[] password, CursorFactory factory) {
        return openDatabase(path, password, factory, CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase create(CursorFactory factory, String password) {
        return openDatabase(MEMORY, password == null ? null : password.toCharArray(), factory, CREATE_IF_NECESSARY);
    }

    public static SQLiteDatabase create(CursorFactory factory, char[] password) {
        return openDatabase(MEMORY, password, factory, CREATE_IF_NECESSARY);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!isOpen()) {
            return;
        }
        lock();
        try {
            closeClosable();
            onAllReferencesReleased();
        } finally {
            unlock();
        }
    }

    private void closeClosable() {
        deallocCachedSqlStatements();
        for (Map.Entry<SQLiteClosable, Object> entry : this.mPrograms.entrySet()) {
            SQLiteClosable program = entry.getKey();
            if (program != null) {
                program.onAllReferencesReleasedFromContainer();
            }
        }
    }

    public int getVersion() {
        SQLiteStatement prog = null;
        lock();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            SQLiteStatement prog2 = new SQLiteStatement(this, "PRAGMA user_version;");
            long version = prog2.simpleQueryForLong();
            int i = (int) version;
            prog2.close();
            unlock();
            return i;
        } catch (Throwable th) {
            if (0 != 0) {
                prog.close();
            }
            unlock();
            throw th;
        }
    }

    public void setVersion(int version) {
        execSQL("PRAGMA user_version = " + version);
    }

    public long getMaximumSize() {
        SQLiteStatement prog = null;
        lock();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            SQLiteStatement prog2 = new SQLiteStatement(this, "PRAGMA max_page_count;");
            long pageCount = prog2.simpleQueryForLong();
            long pageSize = getPageSize() * pageCount;
            prog2.close();
            unlock();
            return pageSize;
        } catch (Throwable th) {
            if (0 != 0) {
                prog.close();
            }
            unlock();
            throw th;
        }
    }

    public long setMaximumSize(long numBytes) {
        SQLiteStatement prog = null;
        lock();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            long pageSize = getPageSize();
            long numPages = numBytes / pageSize;
            if (numBytes % pageSize != 0) {
                numPages++;
            }
            SQLiteStatement prog2 = new SQLiteStatement(this, "PRAGMA max_page_count = " + numPages);
            long newPageCount = prog2.simpleQueryForLong();
            long j = newPageCount * pageSize;
            prog2.close();
            unlock();
            return j;
        } catch (Throwable th) {
            if (0 != 0) {
                prog.close();
            }
            unlock();
            throw th;
        }
    }

    public long getPageSize() {
        SQLiteStatement prog = null;
        lock();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            SQLiteStatement prog2 = new SQLiteStatement(this, "PRAGMA page_size;");
            long size = prog2.simpleQueryForLong();
            prog2.close();
            unlock();
            return size;
        } catch (Throwable th) {
            if (0 != 0) {
                prog.close();
            }
            unlock();
            throw th;
        }
    }

    public void setPageSize(long numBytes) {
        execSQL("PRAGMA page_size = " + numBytes);
    }

    public void markTableSyncable(String table, String deletedTable) {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        markTableSyncable(table, "_id", table, deletedTable);
    }

    public void markTableSyncable(String table, String foreignKey, String updateTable) {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        markTableSyncable(table, foreignKey, updateTable, null);
    }

    private void markTableSyncable(String table, String foreignKey, String updateTable, String deletedTable) {
        lock();
        try {
            native_execSQL("SELECT _sync_dirty FROM " + updateTable + " LIMIT 0");
            native_execSQL("SELECT " + foreignKey + " FROM " + table + " LIMIT 0");
            unlock();
            SyncUpdateInfo info = new SyncUpdateInfo(updateTable, deletedTable, foreignKey);
            synchronized (this.mSyncUpdateInfo) {
                this.mSyncUpdateInfo.put(table, info);
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    public void rowUpdated(String table, long rowId) {
        SyncUpdateInfo info;
        synchronized (this.mSyncUpdateInfo) {
            info = this.mSyncUpdateInfo.get(table);
        }
        if (info != null) {
            execSQL("UPDATE " + info.masterTable + " SET _sync_dirty=1 WHERE _id=(SELECT " + info.foreignKey + " FROM " + table + " WHERE _id=" + rowId + ")");
        }
    }

    public static String findEditTable(String tables) {
        if (!TextUtils.isEmpty(tables)) {
            int spacepos = tables.indexOf(32);
            int commapos = tables.indexOf(44);
            if (spacepos > 0 && (spacepos < commapos || commapos < 0)) {
                return tables.substring(0, spacepos);
            }
            if (commapos > 0 && (commapos < spacepos || spacepos < 0)) {
                return tables.substring(0, commapos);
            }
            return tables;
        }
        throw new IllegalStateException("Invalid tables");
    }

    public SQLiteStatement compileStatement(String sql) {
        lock();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            return new SQLiteStatement(this, sql);
        } finally {
            unlock();
        }
    }

    public Cursor query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        return queryWithFactory(null, distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        String sql = SQLiteQueryBuilder.buildQueryString(distinct, table, columns, selection, groupBy, having, orderBy, limit);
        return rawQueryWithFactory(cursorFactory, sql, selectionArgs, findEditTable(table));
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return query(false, table, columns, selection, selectionArgs, groupBy, having, orderBy, null);
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        return query(false, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        return rawQueryWithFactory(null, sql, selectionArgs, null);
    }

    public SQLiteQueryStats getQueryStats(String sql, Object[] args) {
        try {
            String query = String.format("CREATE TABLE tempstat AS %s", sql);
            execSQL(query, args);
            Cursor cursor = rawQuery("SELECT sum(payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (cursor == null) {
                return new SQLiteQueryStats(0L, 0L);
            }
            cursor.moveToFirst();
            long totalPayload = cursor.getLong(0);
            cursor.close();
            Cursor cursor2 = rawQuery("SELECT max(mx_payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (cursor2 == null) {
                return new SQLiteQueryStats(totalPayload, 0L);
            }
            cursor2.moveToFirst();
            long largestIndividualPayload = cursor2.getLong(0);
            cursor2.close();
            execSQL("DROP TABLE tempstat;");
            return new SQLiteQueryStats(totalPayload, largestIndividualPayload);
        } catch (SQLiteException ex) {
            execSQL("DROP TABLE IF EXISTS tempstat;");
            throw ex;
        }
    }

    public Cursor rawQuery(String sql, Object[] args) {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        long timeStart = this.mSlowQueryThreshold != -1 ? System.currentTimeMillis() : 0L;
        SQLiteDirectCursorDriver driver = new SQLiteDirectCursorDriver(this, sql, null);
        Cursor cursor = null;
        try {
            try {
                Cursor cursor2 = driver.query(this.mFactory, args);
                if (this.mSlowQueryThreshold != -1) {
                    int count = cursor2 != null ? cursor2.getCount() : -1;
                    long duration = System.currentTimeMillis() - timeStart;
                    if (duration >= this.mSlowQueryThreshold) {
                        Log.v(TAG, "query (" + duration + " ms): " + driver.toString() + ", args are <redacted>, count is " + count);
                    }
                }
                return new CrossProcessCursorWrapper(cursor2);
            } catch (Throwable th) {
                th = th;
                if (this.mSlowQueryThreshold != -1) {
                    int count2 = 0 != 0 ? cursor.getCount() : -1;
                    long duration2 = System.currentTimeMillis() - timeStart;
                    if (duration2 >= this.mSlowQueryThreshold) {
                        Log.v(TAG, "query (" + duration2 + " ms): " + driver.toString() + ", args are <redacted>, count is " + count2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public net.sqlcipher.Cursor rawQueryWithFactory(net.sqlcipher.database.SQLiteDatabase.CursorFactory r18, java.lang.String r19, java.lang.String[] r20, java.lang.String r21) {
        /*
            r17 = this;
            r1 = r17
            boolean r0 = r17.isOpen()
            if (r0 == 0) goto Lb2
            r2 = 0
            int r0 = r1.mSlowQueryThreshold
            r4 = -1
            if (r0 == r4) goto L13
            long r2 = java.lang.System.currentTimeMillis()
        L13:
            net.sqlcipher.database.SQLiteDirectCursorDriver r0 = new net.sqlcipher.database.SQLiteDirectCursorDriver
            r5 = r19
            r6 = r21
            r0.<init>(r1, r5, r6)
            r7 = r0
            r8 = 0
            java.lang.String r9 = ", args are <redacted>, count is "
            java.lang.String r10 = " ms): "
            java.lang.String r11 = "query ("
            java.lang.String r12 = "Database"
            if (r18 == 0) goto L2c
            r0 = r18
            goto L2e
        L2c:
            net.sqlcipher.database.SQLiteDatabase$CursorFactory r0 = r1.mFactory     // Catch: java.lang.Throwable -> L75
        L2e:
            r13 = r20
            net.sqlcipher.Cursor r0 = r7.query(r0, r13)     // Catch: java.lang.Throwable -> L73
            int r8 = r1.mSlowQueryThreshold
            if (r8 == r4) goto L6d
            r4 = -1
            if (r0 == 0) goto L3f
            int r4 = r0.getCount()
        L3f:
            long r14 = java.lang.System.currentTimeMillis()
            long r14 = r14 - r2
            int r8 = r1.mSlowQueryThreshold
            long r5 = (long) r8
            int r8 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r8 < 0) goto L6d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            r5.append(r14)
            r5.append(r10)
            java.lang.String r6 = r7.toString()
            r5.append(r6)
            r5.append(r9)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            android.util.Log.v(r12, r5)
        L6d:
            net.sqlcipher.CrossProcessCursorWrapper r4 = new net.sqlcipher.CrossProcessCursorWrapper
            r4.<init>(r0)
            return r4
        L73:
            r0 = move-exception
            goto L78
        L75:
            r0 = move-exception
            r13 = r20
        L78:
            int r5 = r1.mSlowQueryThreshold
            if (r5 == r4) goto Lb1
            r4 = -1
            if (r8 == 0) goto L83
            int r4 = r8.getCount()
        L83:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r2
            int r14 = r1.mSlowQueryThreshold
            long r14 = (long) r14
            int r16 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r16 < 0) goto Lb1
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r11)
            r14.append(r5)
            r14.append(r10)
            java.lang.String r10 = r7.toString()
            r14.append(r10)
            r14.append(r9)
            r14.append(r4)
            java.lang.String r9 = r14.toString()
            android.util.Log.v(r12, r9)
        Lb1:
            throw r0
        Lb2:
            r13 = r20
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "database not open"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.rawQueryWithFactory(net.sqlcipher.database.SQLiteDatabase$CursorFactory, java.lang.String, java.lang.String[], java.lang.String):net.sqlcipher.Cursor");
    }

    public Cursor rawQuery(String sql, String[] selectionArgs, int initialRead, int maxRead) {
        CursorWrapper cursorWrapper = (CursorWrapper) rawQueryWithFactory(null, sql, selectionArgs, null);
        ((SQLiteCursor) cursorWrapper.getWrappedCursor()).setLoadStyle(initialRead, maxRead);
        return cursorWrapper;
    }

    public long insert(String table, String nullColumnHack, ContentValues values) {
        try {
            return insertWithOnConflict(table, nullColumnHack, values, 0);
        } catch (SQLException e) {
            return -1L;
        }
    }

    public long insertOrThrow(String table, String nullColumnHack, ContentValues values) {
        return insertWithOnConflict(table, nullColumnHack, values, 0);
    }

    public long replace(String table, String nullColumnHack, ContentValues initialValues) {
        try {
            return insertWithOnConflict(table, nullColumnHack, initialValues, 5);
        } catch (SQLException e) {
            return -1L;
        }
    }

    public long replaceOrThrow(String table, String nullColumnHack, ContentValues initialValues) {
        return insertWithOnConflict(table, nullColumnHack, initialValues, 5);
    }

    public long insertWithOnConflict(String table, String nullColumnHack, ContentValues initialValues, int conflictAlgorithm) {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        StringBuilder sql = new StringBuilder(152);
        sql.append("INSERT");
        sql.append(CONFLICT_VALUES[conflictAlgorithm]);
        sql.append(" INTO ");
        sql.append(table);
        StringBuilder values = new StringBuilder(40);
        Set<Map.Entry<String, Object>> entrySet = null;
        if (initialValues != null && initialValues.size() > 0) {
            entrySet = initialValues.valueSet();
            sql.append('(');
            boolean needSeparator = false;
            for (Map.Entry<String, Object> entry : entrySet) {
                if (needSeparator) {
                    sql.append(", ");
                    values.append(", ");
                }
                needSeparator = true;
                sql.append(entry.getKey());
                values.append('?');
            }
            sql.append(')');
        } else {
            sql.append("(" + nullColumnHack + ") ");
            values.append("NULL");
        }
        sql.append(" VALUES(");
        sql.append((CharSequence) values);
        sql.append(");");
        lock();
        SQLiteStatement statement = null;
        try {
            try {
                statement = compileStatement(sql.toString());
                if (entrySet != null) {
                    int size = entrySet.size();
                    Iterator<Map.Entry<String, Object>> entriesIter = entrySet.iterator();
                    for (int i = 0; i < size; i++) {
                        Map.Entry<String, Object> entry2 = entriesIter.next();
                        DatabaseUtils.bindObjectToProgram(statement, i + 1, entry2.getValue());
                    }
                }
                statement.execute();
                long insertedRowId = lastChangeCount() > 0 ? lastInsertRow() : -1L;
                statement.close();
                unlock();
                return insertedRowId;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            }
        } catch (Throwable th) {
            if (statement != null) {
                statement.close();
            }
            unlock();
            throw th;
        }
    }

    public int delete(String table, String whereClause, String[] whereArgs) {
        return delete(table, whereClause, (Object[]) whereArgs);
    }

    public int delete(String table, String whereClause, Object[] whereArgs) {
        SQLiteStatement statement = null;
        lock();
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                StringBuilder sb = new StringBuilder();
                sb.append("DELETE FROM ");
                sb.append(table);
                sb.append(TextUtils.isEmpty(whereClause) ? BuildConfig.FLAVOR : " WHERE " + whereClause);
                SQLiteStatement statement2 = compileStatement(sb.toString());
                if (whereArgs != null) {
                    int numArgs = whereArgs.length;
                    for (int i = 0; i < numArgs; i++) {
                        DatabaseUtils.bindObjectToProgram(statement2, i + 1, whereArgs[i]);
                    }
                }
                statement2.execute();
                int lastChangeCount = lastChangeCount();
                statement2.close();
                unlock();
                return lastChangeCount;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                statement.close();
            }
            unlock();
            throw th;
        }
    }

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        return updateWithOnConflict(table, values, whereClause, whereArgs, 0);
    }

    public int updateWithOnConflict(String table, ContentValues values, String whereClause, String[] whereArgs, int conflictAlgorithm) {
        if (values == null || values.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sql = new StringBuilder(120);
        sql.append("UPDATE ");
        sql.append(CONFLICT_VALUES[conflictAlgorithm]);
        sql.append(table);
        sql.append(" SET ");
        Set<Map.Entry<String, Object>> entrySet = values.valueSet();
        Iterator<Map.Entry<String, Object>> entriesIter = entrySet.iterator();
        while (entriesIter.hasNext()) {
            Map.Entry<String, Object> entry = entriesIter.next();
            sql.append(entry.getKey());
            sql.append("=?");
            if (entriesIter.hasNext()) {
                sql.append(", ");
            }
        }
        if (!TextUtils.isEmpty(whereClause)) {
            sql.append(" WHERE ");
            sql.append(whereClause);
        }
        SQLiteStatement statement = null;
        lock();
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                SQLiteStatement statement2 = compileStatement(sql.toString());
                int size = entrySet.size();
                Iterator<Map.Entry<String, Object>> entriesIter2 = entrySet.iterator();
                int bindArg = 1;
                for (int i = 0; i < size; i++) {
                    Map.Entry<String, Object> entry2 = entriesIter2.next();
                    DatabaseUtils.bindObjectToProgram(statement2, bindArg, entry2.getValue());
                    bindArg++;
                }
                if (whereArgs != null) {
                    for (String str : whereArgs) {
                        statement2.bindString(bindArg, str);
                        bindArg++;
                    }
                }
                statement2.execute();
                int numChangedRows = lastChangeCount();
                statement2.close();
                unlock();
                return numChangedRows;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (SQLException e2) {
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                statement.close();
            }
            unlock();
            throw th;
        }
    }

    public void execSQL(String sql) {
        SystemClock.uptimeMillis();
        lock();
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                native_execSQL(sql);
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            }
        } finally {
            unlock();
        }
    }

    public void rawExecSQL(String sql) {
        SystemClock.uptimeMillis();
        lock();
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                native_rawExecSQL(sql);
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            }
        } finally {
            unlock();
        }
    }

    public void execSQL(String sql, Object[] bindArgs) {
        SQLiteStatement statement = null;
        if (bindArgs == null) {
            throw new IllegalArgumentException("Empty bindArgs");
        }
        SystemClock.uptimeMillis();
        lock();
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                SQLiteStatement statement2 = compileStatement(sql);
                int numArgs = bindArgs.length;
                for (int i = 0; i < numArgs; i++) {
                    DatabaseUtils.bindObjectToProgram(statement2, i + 1, bindArgs[i]);
                }
                statement2.execute();
                statement2.close();
                unlock();
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                statement.close();
            }
            unlock();
            throw th;
        }
    }

    public void finalize() {
        if (isOpen()) {
            closeClosable();
            onAllReferencesReleased();
        }
    }

    public SQLiteDatabase(String path, char[] password, CursorFactory factory, int flags) {
        this(path, factory, flags, (DatabaseErrorHandler) null);
        openDatabaseInternal(password, (SQLiteDatabaseHook) null);
    }

    public SQLiteDatabase(String path, char[] password, CursorFactory factory, int flags, SQLiteDatabaseHook databaseHook) {
        this(path, factory, flags, (DatabaseErrorHandler) null);
        openDatabaseInternal(password, databaseHook);
    }

    public SQLiteDatabase(String path, byte[] password, CursorFactory factory, int flags, SQLiteDatabaseHook databaseHook) {
        this(path, factory, flags, (DatabaseErrorHandler) null);
        openDatabaseInternal(password, databaseHook);
    }

    private SQLiteDatabase(String path, CursorFactory factory, int flags, DatabaseErrorHandler errorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0L;
        this.mLockAcquiredThreadTime = 0L;
        this.mLastLockMessageTime = 0L;
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0L;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = MAX_SQL_CACHE_SIZE;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (path == null) {
            throw new IllegalArgumentException("path should not be null");
        }
        this.mFlags = flags;
        this.mPath = path;
        this.mSlowQueryThreshold = -1;
        this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        this.mFactory = factory;
        this.mPrograms = new WeakHashMap<>();
        this.mErrorHandler = errorHandler;
    }

    private void openDatabaseInternal(char[] password, SQLiteDatabaseHook hook) {
        byte[] keyMaterial = getBytes(password);
        openDatabaseInternal(keyMaterial, hook);
    }

    private void openDatabaseInternal(final byte[] password, SQLiteDatabaseHook hook) {
        dbopen(this.mPath, this.mFlags);
        try {
            try {
                keyDatabase(hook, new Runnable() { // from class: net.sqlcipher.database.SQLiteDatabase.2
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] bArr = password;
                        if (bArr != null && bArr.length > 0) {
                            SQLiteDatabase.this.key(bArr);
                        }
                    }
                });
            } catch (RuntimeException ex) {
                final char[] keyMaterial = getChars(password);
                if (!containsNull(keyMaterial)) {
                    throw ex;
                }
                keyDatabase(hook, new Runnable() { // from class: net.sqlcipher.database.SQLiteDatabase.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (password != null) {
                            SQLiteDatabase.this.key_mutf8(keyMaterial);
                        }
                    }
                });
                if (password != null && password.length > 0) {
                    rekey(password);
                }
                if (keyMaterial != null && keyMaterial.length > 0) {
                    Arrays.fill(keyMaterial, (char) 0);
                }
                if (0 == 0) {
                    return;
                }
                dbclose();
                if (!SQLiteDebug.DEBUG_SQL_CACHE) {
                    return;
                }
            }
            if (0 != 0) {
                dbclose();
                if (!SQLiteDebug.DEBUG_SQL_CACHE) {
                    return;
                }
                this.mTimeClosed = getTime();
            }
        } catch (Throwable th) {
            if (1 != 0) {
                dbclose();
                if (SQLiteDebug.DEBUG_SQL_CACHE) {
                    this.mTimeClosed = getTime();
                }
            }
            throw th;
        }
    }

    private boolean containsNull(char[] data) {
        if (data == null || data.length <= 0) {
            return false;
        }
        for (char datum : data) {
            if (datum == 0) {
                return true;
            }
        }
        return false;
    }

    private void keyDatabase(SQLiteDatabaseHook databaseHook, Runnable keyOperation) {
        if (databaseHook != null) {
            databaseHook.preKey(this);
        }
        if (keyOperation != null) {
            keyOperation.run();
        }
        if (databaseHook != null) {
            databaseHook.postKey(this);
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            this.mTimeOpened = getTime();
        }
        try {
            Cursor cursor = rawQuery("select count(*) from sqlite_master;", new String[0]);
            if (cursor != null) {
                cursor.moveToFirst();
                cursor.getInt(0);
                cursor.close();
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean isReadOnly() {
        return (this.mFlags & 1) == 1;
    }

    public boolean isOpen() {
        return this.mNativeHandle != 0;
    }

    public boolean needUpgrade(int newVersion) {
        return newVersion > getVersion();
    }

    public final String getPath() {
        return this.mPath;
    }

    private String getPathForLogs() {
        String str = this.mPathForLogs;
        if (str != null) {
            return str;
        }
        String str2 = this.mPath;
        if (str2 == null) {
            return null;
        }
        if (str2.indexOf(QUERY_LOG_SQL_LENGTH) == -1) {
            this.mPathForLogs = this.mPath;
        } else {
            this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        }
        return this.mPathForLogs;
    }

    public void setLocale(Locale locale) {
        lock();
        try {
            native_setLocale(locale.toString(), this.mFlags);
        } finally {
            unlock();
        }
    }

    public void addToCompiledQueries(String sql, SQLiteCompiledSql compiledStatement) {
        if (this.mMaxSqlCacheSize == 0) {
            boolean z = SQLiteDebug.DEBUG_SQL_CACHE;
            return;
        }
        synchronized (this.mCompiledQueries) {
            SQLiteCompiledSql compiledSql = this.mCompiledQueries.get(sql);
            if (compiledSql != null) {
                return;
            }
            if (this.mCompiledQueries.size() == this.mMaxSqlCacheSize) {
                this.mCacheFullWarnings++;
            } else {
                this.mCompiledQueries.put(sql, compiledStatement);
                boolean z2 = SQLiteDebug.DEBUG_SQL_CACHE;
            }
        }
    }

    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            for (SQLiteCompiledSql compiledSql : this.mCompiledQueries.values()) {
                compiledSql.releaseSqlStatement();
            }
            this.mCompiledQueries.clear();
        }
    }

    public SQLiteCompiledSql getCompiledStatementForSql(String sql) {
        synchronized (this.mCompiledQueries) {
            if (this.mMaxSqlCacheSize == 0) {
                boolean z = SQLiteDebug.DEBUG_SQL_CACHE;
                return null;
            }
            SQLiteCompiledSql compiledStatement = this.mCompiledQueries.get(sql);
            boolean cacheHit = compiledStatement != null;
            if (cacheHit) {
                this.mNumCacheHits++;
            } else {
                this.mNumCacheMisses++;
            }
            boolean z2 = SQLiteDebug.DEBUG_SQL_CACHE;
            return compiledStatement;
        }
    }

    public boolean isInCompiledSqlCache(String sql) {
        boolean containsKey;
        synchronized (this.mCompiledQueries) {
            containsKey = this.mCompiledQueries.containsKey(sql);
        }
        return containsKey;
    }

    public void purgeFromCompiledSqlCache(String sql) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(sql);
        }
    }

    public void resetCompiledSqlCache() {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.clear();
        }
    }

    public synchronized int getMaxSqlCacheSize() {
        return this.mMaxSqlCacheSize;
    }

    public synchronized void setMaxSqlCacheSize(int cacheSize) {
        if (cacheSize > 250 || cacheSize < 0) {
            throw new IllegalStateException("expected value between 0 and 250");
        }
        if (cacheSize < this.mMaxSqlCacheSize) {
            throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
        }
        this.mMaxSqlCacheSize = cacheSize;
    }

    public static byte[] getBytes(char[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        CharBuffer charBuffer = CharBuffer.wrap(data);
        ByteBuffer byteBuffer = Charset.forName(KEY_ENCODING).encode(charBuffer);
        byte[] result = new byte[byteBuffer.limit()];
        byteBuffer.get(result);
        return result;
    }

    public static char[] getChars(byte[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(data);
        CharBuffer charBuffer = Charset.forName(KEY_ENCODING).decode(byteBuffer);
        char[] result = new char[charBuffer.limit()];
        charBuffer.get(result);
        return result;
    }

    public android.database.Cursor query(String query) {
        return rawQuery(query, (String[]) null);
    }

    public android.database.Cursor query(String query, Object[] bindArgs) {
        return rawQuery(query, bindArgs);
    }

    public android.database.Cursor query(d query) {
        return query(query, (CancellationSignal) null);
    }

    public android.database.Cursor query(d supportQuery, CancellationSignal cancellationSignal) {
        String sql = supportQuery.a();
        int argumentCount = supportQuery.c();
        Object[] args = new Object[argumentCount];
        SQLiteDirectCursorDriver driver = new SQLiteDirectCursorDriver(this, sql, null);
        SQLiteQuery query = new SQLiteQuery(this, sql, 0, args);
        supportQuery.b(query);
        return new CrossProcessCursorWrapper(new SQLiteCursor(this, driver, null, query));
    }

    public long insert(String table, int conflictAlgorithm, ContentValues values) {
        return insertWithOnConflict(table, null, values, conflictAlgorithm);
    }

    public int update(String table, int conflictAlgorithm, ContentValues values, String whereClause, Object[] whereArgs) {
        String[] args = new String[whereArgs.length];
        for (int i = 0; i < whereArgs.length; i++) {
            args[i] = whereArgs[i].toString();
        }
        return updateWithOnConflict(table, values, whereClause, args, conflictAlgorithm);
    }

    public void beginTransactionWithListener(final android.database.sqlite.SQLiteTransactionListener transactionListener) {
        beginTransactionWithListener(new SQLiteTransactionListener() { // from class: net.sqlcipher.database.SQLiteDatabase.4
            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onBegin() {
                transactionListener.onBegin();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onCommit() {
                transactionListener.onCommit();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onRollback() {
                transactionListener.onRollback();
            }
        });
    }

    public void beginTransactionWithListenerNonExclusive(final android.database.sqlite.SQLiteTransactionListener transactionListener) {
        beginTransactionWithListenerNonExclusive(new SQLiteTransactionListener() { // from class: net.sqlcipher.database.SQLiteDatabase.5
            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onBegin() {
                transactionListener.onBegin();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onCommit() {
                transactionListener.onCommit();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onRollback() {
                transactionListener.onRollback();
            }
        });
    }

    private void beginTransactionWithListenerInternal(SQLiteTransactionListener transactionListener, SQLiteDatabaseTransactionType transactionType) {
        lockForced();
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        boolean ok = false;
        try {
            if (this.mLock.getHoldCount() > 1) {
                if (this.mInnerTransactionIsSuccessful) {
                    IllegalStateException e = new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                    throw e;
                }
                ok = true;
                if (!ok) {
                    return;
                } else {
                    return;
                }
            }
            if (transactionType == SQLiteDatabaseTransactionType.Exclusive) {
                execSQL("BEGIN EXCLUSIVE;");
            } else if (transactionType == SQLiteDatabaseTransactionType.Immediate) {
                execSQL("BEGIN IMMEDIATE;");
            } else if (transactionType == SQLiteDatabaseTransactionType.Deferred) {
                execSQL("BEGIN DEFERRED;");
            } else {
                String message = String.format("%s is an unsupported transaction type", transactionType);
                throw new IllegalArgumentException(message);
            }
            this.mTransactionListener = transactionListener;
            this.mTransactionIsSuccessful = true;
            this.mInnerTransactionIsSuccessful = false;
            if (transactionListener != null) {
                try {
                    transactionListener.onBegin();
                } catch (RuntimeException e2) {
                    execSQL("ROLLBACK;");
                    throw e2;
                }
            }
            if (1 == 0) {
                unlockForced();
            }
        } finally {
            if (!ok) {
                unlockForced();
            }
        }
    }

    public static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        String dbName;
        ArrayList<SQLiteDebug.DbStats> dbStatsList = new ArrayList<>();
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            SQLiteDatabase db = it.next();
            if (db != null && db.isOpen()) {
                int lookasideUsed = db.native_getDbLookaside();
                String path = db.getPath();
                int indx = path.lastIndexOf("/");
                String lastnode = path.substring(indx != -1 ? indx + 1 : 0);
                ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(db);
                if (attachedDbs != null) {
                    for (int i = 0; i < attachedDbs.size(); i++) {
                        Pair<String, String> p = attachedDbs.get(i);
                        long pageCount = getPragmaVal(db, ((String) p.first) + ".page_count;");
                        if (i == 0) {
                            dbName = lastnode;
                        } else {
                            lookasideUsed = 0;
                            dbName = "  (attached) " + ((String) p.first);
                            if (((String) p.second).trim().length() > 0) {
                                int idx = ((String) p.second).lastIndexOf("/");
                                StringBuilder sb = new StringBuilder();
                                sb.append(dbName);
                                sb.append(" : ");
                                sb.append(((String) p.second).substring(idx != -1 ? idx + 1 : 0));
                                dbName = sb.toString();
                            }
                        }
                        if (pageCount > 0) {
                            dbStatsList.add(new SQLiteDebug.DbStats(dbName, pageCount, db.getPageSize(), lookasideUsed));
                        }
                    }
                }
            }
        }
        return dbStatsList;
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> databases = new ArrayList<>();
        synchronized (sActiveDatabases) {
            databases.addAll(sActiveDatabases.keySet());
        }
        return databases;
    }

    private static long getPragmaVal(SQLiteDatabase db, String pragma) {
        if (!db.isOpen()) {
            return 0L;
        }
        SQLiteStatement prog = null;
        try {
            prog = new SQLiteStatement(db, "PRAGMA " + pragma);
            long val = prog.simpleQueryForLong();
            prog.close();
            return val;
        } catch (Throwable th) {
            if (prog != null) {
                prog.close();
            }
            throw th;
        }
    }

    private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase dbObj) {
        if (!dbObj.isOpen()) {
            return null;
        }
        ArrayList<Pair<String, String>> attachedDbs = new ArrayList<>();
        Cursor c = dbObj.rawQuery("pragma database_list;", (String[]) null);
        while (c.moveToNext()) {
            attachedDbs.add(new Pair<>(c.getString(1), c.getString(2)));
        }
        c.close();
        return attachedDbs;
    }

    private Pair<Boolean, String> getResultFromPragma(String command) {
        Cursor cursor = rawQuery(command, new Object[0]);
        if (cursor == null) {
            return new Pair<>(false, BuildConfig.FLAVOR);
        }
        cursor.moveToFirst();
        String value = cursor.getString(0);
        cursor.close();
        return new Pair<>(true, value);
    }
}
