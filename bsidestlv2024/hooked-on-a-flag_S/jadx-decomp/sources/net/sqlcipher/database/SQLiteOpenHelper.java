package net.sqlcipher.database;

import android.content.Context;
import android.util.Log;
import java.io.File;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public abstract class SQLiteOpenHelper {
    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mDeferSetWriteAheadLoggingEnabled;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version, null, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, SQLiteDatabaseHook hook) {
        this(context, name, factory, version, hook, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, SQLiteDatabaseHook hook, DatabaseErrorHandler errorHandler) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (version < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + version);
        }
        if (errorHandler == null) {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        }
        this.mContext = context;
        this.mName = name;
        this.mFactory = factory;
        this.mNewVersion = version;
        this.mHook = hook;
        this.mErrorHandler = errorHandler;
    }

    public synchronized SQLiteDatabase getWritableDatabase(String password) {
        return getWritableDatabase(password == null ? null : password.toCharArray());
    }

    public synchronized SQLiteDatabase getWritableDatabase(char[] password) {
        return getWritableDatabase(password == null ? null : SQLiteDatabase.getBytes(password));
    }

    public synchronized SQLiteDatabase getWritableDatabase(byte[] password) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
            return this.mDatabase;
        }
        if (this.mIsInitializing) {
            throw new IllegalStateException("getWritableDatabase called recursively");
        }
        SQLiteDatabase db = null;
        SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
        if (sQLiteDatabase2 != null) {
            sQLiteDatabase2.lock();
        }
        try {
            this.mIsInitializing = true;
            String str = this.mName;
            if (str == null) {
                db = SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null, BuildConfig.FLAVOR);
            } else {
                String path = this.mContext.getDatabasePath(str).getPath();
                File dbPathFile = new File(path);
                if (!dbPathFile.exists()) {
                    dbPathFile.getParentFile().mkdirs();
                }
                db = SQLiteDatabase.openOrCreateDatabase(path, password, this.mFactory, this.mHook, this.mErrorHandler);
            }
            if (this.mDeferSetWriteAheadLoggingEnabled) {
                this.mEnableWriteAheadLogging = db.enableWriteAheadLogging();
            }
            onConfigure(db);
            int version = db.getVersion();
            if (version != this.mNewVersion) {
                db.beginTransaction();
                try {
                    if (version == 0) {
                        onCreate(db);
                    } else {
                        int i = this.mNewVersion;
                        if (version > i) {
                            onDowngrade(db, version, i);
                        } else {
                            onUpgrade(db, version, i);
                        }
                    }
                    db.setVersion(this.mNewVersion);
                    db.setTransactionSuccessful();
                    db.endTransaction();
                } catch (Throwable th) {
                    db.endTransaction();
                    throw th;
                }
            }
            onOpen(db);
            this.mIsInitializing = false;
            if (1 != 0) {
                SQLiteDatabase sQLiteDatabase3 = this.mDatabase;
                if (sQLiteDatabase3 != null) {
                    try {
                        sQLiteDatabase3.close();
                    } catch (Exception e) {
                    }
                    this.mDatabase.unlock();
                }
                this.mDatabase = db;
            } else {
                SQLiteDatabase sQLiteDatabase4 = this.mDatabase;
                if (sQLiteDatabase4 != null) {
                    sQLiteDatabase4.unlock();
                }
                db.close();
            }
            return db;
        } catch (Throwable th2) {
            this.mIsInitializing = false;
            if (0 != 0) {
                SQLiteDatabase sQLiteDatabase5 = this.mDatabase;
                if (sQLiteDatabase5 != null) {
                    try {
                        sQLiteDatabase5.close();
                    } catch (Exception e2) {
                    }
                    this.mDatabase.unlock();
                }
                this.mDatabase = db;
            } else {
                SQLiteDatabase sQLiteDatabase6 = this.mDatabase;
                if (sQLiteDatabase6 != null) {
                    sQLiteDatabase6.unlock();
                }
                if (db != null) {
                    db.close();
                }
            }
            throw th2;
        }
    }

    public synchronized SQLiteDatabase getReadableDatabase(String password) {
        return getReadableDatabase(password == null ? null : password.toCharArray());
    }

    public synchronized SQLiteDatabase getReadableDatabase(char[] password) {
        return getReadableDatabase(password == null ? null : SQLiteDatabase.getBytes(password));
    }

    public synchronized SQLiteDatabase getReadableDatabase(byte[] password) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return this.mDatabase;
        }
        if (this.mIsInitializing) {
            throw new IllegalStateException("getReadableDatabase called recursively");
        }
        try {
            return getWritableDatabase(password);
        } catch (SQLiteException e) {
            if (this.mName == null) {
                throw e;
            }
            String str = TAG;
            Log.e(str, "Couldn't open " + this.mName + " for writing (will try read-only):", e);
            SQLiteDatabase db = null;
            try {
                this.mIsInitializing = true;
                String path = this.mContext.getDatabasePath(this.mName).getPath();
                File databasePath = new File(path);
                File databasesDirectory = new File(this.mContext.getDatabasePath(this.mName).getParent());
                if (!databasesDirectory.exists()) {
                    databasesDirectory.mkdirs();
                }
                if (!databasePath.exists()) {
                    this.mIsInitializing = false;
                    SQLiteDatabase db2 = getWritableDatabase(password);
                    this.mIsInitializing = true;
                    db2.close();
                }
                SQLiteDatabase db3 = SQLiteDatabase.openDatabase(path, password, this.mFactory, 1, this.mHook, this.mErrorHandler);
                if (db3.getVersion() != this.mNewVersion) {
                    throw new SQLiteException("Can't upgrade read-only database from version " + db3.getVersion() + " to " + this.mNewVersion + ": " + path);
                }
                onOpen(db3);
                Log.w(str, "Opened " + this.mName + " in read-only mode");
                this.mDatabase = db3;
                this.mIsInitializing = false;
                if (db3 != db3) {
                    db3.close();
                }
                return db3;
            } catch (Throwable th) {
                this.mIsInitializing = false;
                if (0 != 0 && null != this.mDatabase) {
                    db.close();
                }
                throw th;
            }
        }
    }

    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        }
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public void setWriteAheadLoggingEnabled(boolean enabled) {
        synchronized (this) {
            if (this.mEnableWriteAheadLogging != enabled) {
                SQLiteDatabase sQLiteDatabase = this.mDatabase;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                    if (enabled) {
                        this.mDatabase.enableWriteAheadLogging();
                    } else {
                        this.mDatabase.disableWriteAheadLogging();
                    }
                    this.mEnableWriteAheadLogging = enabled;
                } else {
                    this.mDeferSetWriteAheadLoggingEnabled = enabled;
                }
            }
        }
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new SQLiteException("Can't downgrade database from version " + oldVersion + " to " + newVersion);
    }

    public void onConfigure(SQLiteDatabase db) {
    }

    public void onOpen(SQLiteDatabase db) {
    }
}
