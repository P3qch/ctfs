package net.sqlcipher.database;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SQLiteContentHelper {
    public static AssetFileDescriptor getBlobColumnAsAssetFile(SQLiteDatabase db, String sql, String[] selectionArgs) {
        ParcelFileDescriptor fd = null;
        try {
            MemoryFile file = simpleQueryForBlobMemoryFile(db, sql, selectionArgs);
            if (file == null) {
                throw new FileNotFoundException("No results.");
            }
            Class c = file.getClass();
            try {
                Method m = c.getDeclaredMethod("getParcelFileDescriptor", new Class[0]);
                m.setAccessible(true);
                fd = (ParcelFileDescriptor) m.invoke(file, new Object[0]);
            } catch (Exception e) {
                Log.i("SQLiteContentHelper", "SQLiteCursor.java: " + e);
            }
            AssetFileDescriptor afd = new AssetFileDescriptor(fd, 0L, file.length());
            return afd;
        } catch (IOException ex) {
            throw new FileNotFoundException(ex.toString());
        }
    }

    private static MemoryFile simpleQueryForBlobMemoryFile(SQLiteDatabase db, String sql, String[] selectionArgs) {
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor == null) {
            return null;
        }
        try {
            if (!cursor.moveToFirst()) {
                return null;
            }
            byte[] bytes = cursor.getBlob(0);
            if (bytes == null) {
                return null;
            }
            MemoryFile file = new MemoryFile(null, bytes.length);
            file.writeBytes(bytes, 0, 0, bytes.length);
            return file;
        } finally {
            cursor.close();
        }
    }
}
