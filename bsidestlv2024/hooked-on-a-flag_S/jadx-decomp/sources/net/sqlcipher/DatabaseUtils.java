package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteAbortException;
import net.sqlcipher.database.SQLiteConstraintException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseCorruptException;
import net.sqlcipher.database.SQLiteDiskIOException;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteFullException;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

/* loaded from: classes.dex */
public class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "DatabaseUtils";
    private static final String[] countProjection = {"count(*)"};
    private static final char[] HEX_DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Collator mColl = null;

    public static final void writeExceptionToParcel(Parcel reply, Exception e) {
        int code;
        boolean logException = true;
        if (e instanceof FileNotFoundException) {
            code = 1;
            logException = false;
        } else if (e instanceof IllegalArgumentException) {
            code = 2;
        } else if (e instanceof UnsupportedOperationException) {
            code = 3;
        } else if (e instanceof SQLiteAbortException) {
            code = 4;
        } else if (e instanceof SQLiteConstraintException) {
            code = 5;
        } else if (e instanceof SQLiteDatabaseCorruptException) {
            code = 6;
        } else if (e instanceof SQLiteFullException) {
            code = 7;
        } else if (e instanceof SQLiteDiskIOException) {
            code = 8;
        } else if (e instanceof SQLiteException) {
            code = 9;
        } else if (e instanceof OperationApplicationException) {
            code = 10;
        } else {
            reply.writeException(e);
            Log.e(TAG, "Writing exception to parcel", e);
            return;
        }
        reply.writeInt(code);
        reply.writeString(e.getMessage());
        if (logException) {
            Log.e(TAG, "Writing exception to parcel", e);
        }
    }

    public static final void readExceptionFromParcel(Parcel reply) {
        int code = reply.readInt();
        if (code == 0) {
            return;
        }
        String msg = reply.readString();
        readExceptionFromParcel(reply, msg, code);
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel reply) {
        int code = reply.readInt();
        if (code == 0) {
            return;
        }
        String msg = reply.readString();
        if (code == 1) {
            throw new FileNotFoundException(msg);
        }
        readExceptionFromParcel(reply, msg, code);
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel reply) {
        int code = reply.readInt();
        if (code == 0) {
            return;
        }
        String msg = reply.readString();
        if (code == 10) {
            throw new OperationApplicationException(msg);
        }
        readExceptionFromParcel(reply, msg, code);
    }

    private static final void readExceptionFromParcel(Parcel reply, String msg, int code) {
        switch (code) {
            case 2:
                throw new IllegalArgumentException(msg);
            case 3:
                throw new UnsupportedOperationException(msg);
            case 4:
                throw new SQLiteAbortException(msg);
            case 5:
                throw new SQLiteConstraintException(msg);
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                throw new SQLiteDatabaseCorruptException(msg);
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                throw new SQLiteFullException(msg);
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                throw new SQLiteDiskIOException(msg);
            case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                throw new SQLiteException(msg);
            default:
                reply.readException(code, msg);
                return;
        }
    }

    public static void bindObjectToProgram(SQLiteProgram prog, int index, Object value) {
        if (value == null) {
            prog.bindNull(index);
            return;
        }
        if ((value instanceof Double) || (value instanceof Float)) {
            prog.bindDouble(index, ((Number) value).doubleValue());
            return;
        }
        if (value instanceof Number) {
            prog.bindLong(index, ((Number) value).longValue());
            return;
        }
        if (!(value instanceof Boolean)) {
            if (value instanceof byte[]) {
                prog.bindBlob(index, (byte[]) value);
                return;
            } else {
                prog.bindString(index, value.toString());
                return;
            }
        }
        Boolean bool = (Boolean) value;
        if (bool.booleanValue()) {
            prog.bindLong(index, 1L);
        } else {
            prog.bindLong(index, 0L);
        }
    }

    public static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        if ((obj instanceof Long) || (obj instanceof Integer)) {
            return 1;
        }
        return 3;
    }

    public static void appendEscapedSQLString(StringBuilder sb, String sqlString) {
        sb.append('\'');
        if (sqlString.indexOf(39) != -1) {
            int length = sqlString.length();
            for (int i = 0; i < length; i++) {
                char c = sqlString.charAt(i);
                if (c == '\'') {
                    sb.append('\'');
                }
                sb.append(c);
            }
        } else {
            sb.append(sqlString);
        }
        sb.append('\'');
    }

    public static String sqlEscapeString(String value) {
        StringBuilder escaper = new StringBuilder();
        appendEscapedSQLString(escaper, value);
        return escaper.toString();
    }

    public static final void appendValueToSql(StringBuilder sql, Object value) {
        if (value == null) {
            sql.append("NULL");
            return;
        }
        if (value instanceof Boolean) {
            Boolean bool = (Boolean) value;
            if (bool.booleanValue()) {
                sql.append('1');
                return;
            } else {
                sql.append('0');
                return;
            }
        }
        appendEscapedSQLString(sql, value.toString());
    }

    public static String concatenateWhere(String a2, String b2) {
        if (TextUtils.isEmpty(a2)) {
            return b2;
        }
        if (TextUtils.isEmpty(b2)) {
            return a2;
        }
        return "(" + a2 + ") AND (" + b2 + ")";
    }

    public static String getCollationKey(String name) {
        byte[] arr = getCollationKeyInBytes(name);
        try {
            return new String(arr, 0, getKeyLen(arr), "ISO8859_1");
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public static String getHexCollationKey(String name) {
        byte[] arr = getCollationKeyInBytes(name);
        char[] keys = encodeHex(arr, HEX_DIGITS_LOWER);
        return new String(keys, 0, getKeyLen(arr) * 2);
    }

    private static char[] encodeHex(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];
        int j = 0;
        for (int i = 0; i < l; i++) {
            int j2 = j + 1;
            out[j] = toDigits[(data[i] & 240) >>> 4];
            j = j2 + 1;
            out[j2] = toDigits[data[i] & 15];
        }
        return out;
    }

    private static int getKeyLen(byte[] arr) {
        if (arr[arr.length - 1] != 0) {
            return arr.length;
        }
        return arr.length - 1;
    }

    private static byte[] getCollationKeyInBytes(String name) {
        if (mColl == null) {
            Collator collator = Collator.getInstance();
            mColl = collator;
            collator.setStrength(0);
        }
        return mColl.getCollationKey(name).toByteArray();
    }

    public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    public static void dumpCursor(Cursor cursor, PrintStream stream) {
        stream.println(">>>>> Dumping cursor " + cursor);
        if (cursor != null) {
            int startPos = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, stream);
            }
            cursor.moveToPosition(startPos);
        }
        stream.println("<<<<<");
    }

    public static void dumpCursor(Cursor cursor, StringBuilder sb) {
        sb.append(">>>>> Dumping cursor " + cursor + "\n");
        if (cursor != null) {
            int startPos = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, sb);
            }
            cursor.moveToPosition(startPos);
        }
        sb.append("<<<<<\n");
    }

    public static String dumpCursorToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCursor(cursor, sb);
        return sb.toString();
    }

    public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    public static void dumpCurrentRow(Cursor cursor, PrintStream stream) {
        String value;
        String[] cols = cursor.getColumnNames();
        stream.println(BuildConfig.FLAVOR + cursor.getPosition() + " {");
        int length = cols.length;
        for (int i = 0; i < length; i++) {
            try {
                value = cursor.getString(i);
            } catch (SQLiteException e) {
                value = "<unprintable>";
            }
            stream.println("   " + cols[i] + '=' + value);
        }
        stream.println("}");
    }

    public static void dumpCurrentRow(Cursor cursor, StringBuilder sb) {
        String value;
        String[] cols = cursor.getColumnNames();
        sb.append(BuildConfig.FLAVOR + cursor.getPosition() + " {\n");
        int length = cols.length;
        for (int i = 0; i < length; i++) {
            try {
                value = cursor.getString(i);
            } catch (SQLiteException e) {
                value = "<unprintable>";
            }
            sb.append("   " + cols[i] + '=' + value + "\n");
        }
        sb.append("}\n");
    }

    public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCurrentRow(cursor, sb);
        return sb.toString();
    }

    public static void cursorStringToContentValues(Cursor cursor, String field, ContentValues values) {
        cursorStringToContentValues(cursor, field, values, field);
    }

    public static void cursorStringToInsertHelper(Cursor cursor, String field, InsertHelper inserter, int index) {
        inserter.bind(index, cursor.getString(cursor.getColumnIndexOrThrow(field)));
    }

    public static void cursorStringToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        values.put(key, cursor.getString(cursor.getColumnIndexOrThrow(field)));
    }

    public static void cursorIntToContentValues(Cursor cursor, String field, ContentValues values) {
        cursorIntToContentValues(cursor, field, values, field);
    }

    public static void cursorIntToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        int colIndex = cursor.getColumnIndex(field);
        if (!cursor.isNull(colIndex)) {
            values.put(key, Integer.valueOf(cursor.getInt(colIndex)));
        } else {
            values.put(key, (Integer) null);
        }
    }

    public static void cursorLongToContentValues(Cursor cursor, String field, ContentValues values) {
        cursorLongToContentValues(cursor, field, values, field);
    }

    public static void cursorLongToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        int colIndex = cursor.getColumnIndex(field);
        if (!cursor.isNull(colIndex)) {
            Long value = Long.valueOf(cursor.getLong(colIndex));
            values.put(key, value);
        } else {
            values.put(key, (Long) null);
        }
    }

    public static void cursorDoubleToCursorValues(Cursor cursor, String field, ContentValues values) {
        cursorDoubleToContentValues(cursor, field, values, field);
    }

    public static void cursorDoubleToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        int colIndex = cursor.getColumnIndex(field);
        if (!cursor.isNull(colIndex)) {
            values.put(key, Double.valueOf(cursor.getDouble(colIndex)));
        } else {
            values.put(key, (Double) null);
        }
    }

    public static void cursorRowToContentValues(Cursor cursor, ContentValues values) {
        AbstractWindowedCursor awc = cursor instanceof AbstractWindowedCursor ? (AbstractWindowedCursor) cursor : null;
        String[] columns = cursor.getColumnNames();
        int length = columns.length;
        for (int i = 0; i < length; i++) {
            if (awc != null && awc.isBlob(i)) {
                values.put(columns[i], cursor.getBlob(i));
            } else {
                values.put(columns[i], cursor.getString(i));
            }
        }
    }

    public static long queryNumEntries(SQLiteDatabase db, String table) {
        Cursor cursor = db.query(table, countProjection, null, null, null, null, null);
        try {
            cursor.moveToFirst();
            return cursor.getLong(0);
        } finally {
            cursor.close();
        }
    }

    public static long longForQuery(SQLiteDatabase db, String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return longForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    public static long longForQuery(SQLiteStatement prog, String[] selectionArgs) {
        if (selectionArgs != null) {
            int size = selectionArgs.length;
            for (int i = 0; i < size; i++) {
                bindObjectToProgram(prog, i + 1, selectionArgs[i]);
            }
        }
        long value = prog.simpleQueryForLong();
        return value;
    }

    public static String stringForQuery(SQLiteDatabase db, String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return stringForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    public static String stringForQuery(SQLiteStatement prog, String[] selectionArgs) {
        if (selectionArgs != null) {
            int size = selectionArgs.length;
            for (int i = 0; i < size; i++) {
                bindObjectToProgram(prog, i + 1, selectionArgs[i]);
            }
        }
        String value = prog.simpleQueryForString();
        return value;
    }

    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        int index = cursor.getColumnIndexOrThrow(column);
        if (!cursor.isNull(index)) {
            values.put(column, cursor.getString(index));
        }
    }

    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        int index = cursor.getColumnIndexOrThrow(column);
        if (!cursor.isNull(index)) {
            values.put(column, Long.valueOf(cursor.getLong(index)));
        }
    }

    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        int index = cursor.getColumnIndexOrThrow(column);
        if (!cursor.isNull(index)) {
            values.put(column, Short.valueOf(cursor.getShort(index)));
        }
    }

    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        int index = cursor.getColumnIndexOrThrow(column);
        if (!cursor.isNull(index)) {
            values.put(column, Integer.valueOf(cursor.getInt(index)));
        }
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        int index = cursor.getColumnIndexOrThrow(column);
        if (!cursor.isNull(index)) {
            values.put(column, Float.valueOf(cursor.getFloat(index)));
        }
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        int index = cursor.getColumnIndexOrThrow(column);
        if (!cursor.isNull(index)) {
            values.put(column, Double.valueOf(cursor.getDouble(index)));
        }
    }

    /* loaded from: classes.dex */
    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private final String mTableName;
        private String mInsertSQL = null;
        private SQLiteStatement mInsertStatement = null;
        private SQLiteStatement mReplaceStatement = null;
        private SQLiteStatement mPreparedStatement = null;

        public InsertHelper(SQLiteDatabase db, String tableName) {
            this.mDb = db;
            this.mTableName = tableName;
        }

        private void buildSQL() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("INSERT INTO ");
            sb.append(this.mTableName);
            sb.append(" (");
            StringBuilder sbv = new StringBuilder(128);
            sbv.append("VALUES (");
            int i = 1;
            Cursor cur = null;
            try {
                cur = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", (String[]) null);
                this.mColumns = new HashMap<>(cur.getCount());
                while (cur.moveToNext()) {
                    String columnName = cur.getString(1);
                    String defaultValue = cur.getString(4);
                    this.mColumns.put(columnName, Integer.valueOf(i));
                    sb.append("'");
                    sb.append(columnName);
                    sb.append("'");
                    if (defaultValue == null) {
                        sbv.append("?");
                    } else {
                        sbv.append("COALESCE(?, ");
                        sbv.append(defaultValue);
                        sbv.append(")");
                    }
                    sb.append(i == cur.getCount() ? ") " : ", ");
                    sbv.append(i == cur.getCount() ? ");" : ", ");
                    i++;
                }
                cur.close();
                sb.append((CharSequence) sbv);
                this.mInsertSQL = sb.toString();
            } catch (Throwable th) {
                if (cur != null) {
                    cur.close();
                }
                throw th;
            }
        }

        private SQLiteStatement getStatement(boolean allowReplace) {
            if (allowReplace) {
                if (this.mReplaceStatement == null) {
                    if (this.mInsertSQL == null) {
                        buildSQL();
                    }
                    String replaceSQL = "INSERT OR REPLACE" + this.mInsertSQL.substring(6);
                    this.mReplaceStatement = this.mDb.compileStatement(replaceSQL);
                }
                return this.mReplaceStatement;
            }
            if (this.mInsertStatement == null) {
                if (this.mInsertSQL == null) {
                    buildSQL();
                }
                this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
            }
            return this.mInsertStatement;
        }

        private synchronized long insertInternal(ContentValues values, boolean allowReplace) {
            SQLiteStatement stmt;
            try {
                stmt = getStatement(allowReplace);
                stmt.clearBindings();
                for (Map.Entry<String, Object> e : values.valueSet()) {
                    String key = e.getKey();
                    int i = getColumnIndex(key);
                    DatabaseUtils.bindObjectToProgram(stmt, i, e.getValue());
                }
            } catch (SQLException e2) {
                Log.e(DatabaseUtils.TAG, "Error inserting " + values + " into table  " + this.mTableName, e2);
                return -1L;
            }
            return stmt.executeInsert();
        }

        public int getColumnIndex(String key) {
            getStatement(false);
            Integer index = this.mColumns.get(key);
            if (index == null) {
                throw new IllegalArgumentException("column '" + key + "' is invalid");
            }
            return index.intValue();
        }

        public void bind(int index, double value) {
            this.mPreparedStatement.bindDouble(index, value);
        }

        public void bind(int index, float value) {
            this.mPreparedStatement.bindDouble(index, value);
        }

        public void bind(int index, long value) {
            this.mPreparedStatement.bindLong(index, value);
        }

        public void bind(int index, int value) {
            this.mPreparedStatement.bindLong(index, value);
        }

        public void bind(int index, boolean value) {
            this.mPreparedStatement.bindLong(index, value ? 1L : 0L);
        }

        public void bindNull(int index) {
            this.mPreparedStatement.bindNull(index);
        }

        public void bind(int index, byte[] value) {
            if (value == null) {
                this.mPreparedStatement.bindNull(index);
            } else {
                this.mPreparedStatement.bindBlob(index, value);
            }
        }

        public void bind(int index, String value) {
            if (value == null) {
                this.mPreparedStatement.bindNull(index);
            } else {
                this.mPreparedStatement.bindString(index, value);
            }
        }

        public long insert(ContentValues values) {
            return insertInternal(values, false);
        }

        public long execute() {
            SQLiteStatement sQLiteStatement = this.mPreparedStatement;
            if (sQLiteStatement == null) {
                throw new IllegalStateException("you must prepare this inserter before calling execute");
            }
            try {
                return sQLiteStatement.executeInsert();
            } catch (SQLException e) {
                Log.e(DatabaseUtils.TAG, "Error executing InsertHelper with table " + this.mTableName, e);
                return -1L;
            } finally {
                this.mPreparedStatement = null;
            }
        }

        public void prepareForInsert() {
            SQLiteStatement statement = getStatement(false);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public void prepareForReplace() {
            SQLiteStatement statement = getStatement(true);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public long replace(ContentValues values) {
            return insertInternal(values, true);
        }

        public void close() {
            SQLiteStatement sQLiteStatement = this.mInsertStatement;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
                this.mInsertStatement = null;
            }
            SQLiteStatement sQLiteStatement2 = this.mReplaceStatement;
            if (sQLiteStatement2 != null) {
                sQLiteStatement2.close();
                this.mReplaceStatement = null;
            }
            this.mInsertSQL = null;
            this.mColumns = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        r3 = r6.getType(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        switch(r3) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L15;
            case 4: goto L18;
            default: goto L15;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        r4 = r6.getString(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r4 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        r5 = r8.putString(r4, r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
    
        if (r5 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0071, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
    
        r8.freeLastRow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
    
        if (r6.moveToNext() != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        r5 = r8.putNull(r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        r4 = r6.getBlob(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        if (r4 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        r5 = r8.putBlob(r4, r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        r5 = r8.putNull(r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        r5 = r8.putDouble(r6.getDouble(r2), r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        r5 = r8.putLong(r6.getLong(r2), r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        r5 = r8.putNull(r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r6.moveToPosition(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001f, code lost:
    
        if (r6.moveToPosition(r7) != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
    
        if (r8.allocRow() != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r2 >= r1) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void cursorFillWindow(net.sqlcipher.Cursor r6, int r7, android.database.CursorWindow r8) {
        /*
            if (r7 < 0) goto L80
            int r0 = r6.getCount()
            if (r7 < r0) goto La
            goto L80
        La:
            int r0 = r6.getPosition()
            int r1 = r6.getColumnCount()
            r8.clear()
            r8.setStartPosition(r7)
            r8.setNumColumns(r1)
            boolean r2 = r6.moveToPosition(r7)
            if (r2 == 0) goto L7c
        L21:
            boolean r2 = r8.allocRow()
            if (r2 != 0) goto L28
            goto L7c
        L28:
            r2 = 0
        L29:
            if (r2 >= r1) goto L74
            int r3 = r6.getType(r2)
            switch(r3) {
                case 0: goto L60;
                case 1: goto L57;
                case 2: goto L4e;
                case 3: goto L32;
                case 4: goto L3d;
                default: goto L32;
            }
        L32:
            java.lang.String r4 = r6.getString(r2)
            if (r4 == 0) goto L65
            boolean r5 = r8.putString(r4, r7, r2)
            goto L69
        L3d:
            byte[] r4 = r6.getBlob(r2)
            if (r4 == 0) goto L48
            boolean r5 = r8.putBlob(r4, r7, r2)
            goto L4c
        L48:
            boolean r5 = r8.putNull(r7, r2)
        L4c:
            goto L6b
        L4e:
            double r4 = r6.getDouble(r2)
            boolean r5 = r8.putDouble(r4, r7, r2)
            goto L6b
        L57:
            long r4 = r6.getLong(r2)
            boolean r5 = r8.putLong(r4, r7, r2)
            goto L6b
        L60:
            boolean r5 = r8.putNull(r7, r2)
            goto L6b
        L65:
            boolean r5 = r8.putNull(r7, r2)
        L69:
        L6b:
            if (r5 != 0) goto L71
            r8.freeLastRow()
            goto L74
        L71:
            int r2 = r2 + 1
            goto L29
        L74:
            int r7 = r7 + 1
            boolean r2 = r6.moveToNext()
            if (r2 != 0) goto L21
        L7c:
            r6.moveToPosition(r0)
            return
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.DatabaseUtils.cursorFillWindow(net.sqlcipher.Cursor, int, android.database.CursorWindow):void");
    }
}
