package net.sqlcipher.database;

import a.q.a.a;
import a.q.a.b;
import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class SupportHelper implements b {
    private final boolean clearPassphrase;
    private byte[] passphrase;
    private SQLiteOpenHelper standardHelper;

    public SupportHelper(b.a configuration, byte[] passphrase, SQLiteDatabaseHook hook, boolean clearPassphrase) {
        configuration.getClass();
        SQLiteDatabaseHook hook2 = null;
        SQLiteDatabase.loadLibs(null);
        this.passphrase = passphrase;
        this.clearPassphrase = clearPassphrase;
        configuration.getClass();
        configuration.getClass();
        configuration.getClass();
        hook2.getClass();
        throw null;
    }

    /* renamed from: net.sqlcipher.database.SupportHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends SQLiteOpenHelper {
        public final /* synthetic */ b.a val$configuration;

        public AnonymousClass1(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, SQLiteDatabaseHook hook, b.a aVar) {
            super(context, name, factory, version, hook);
        }

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            this.val$configuration.getClass();
            throw null;
        }

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            this.val$configuration.getClass();
            throw null;
        }

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            this.val$configuration.getClass();
            throw null;
        }

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db) {
            this.val$configuration.getClass();
            throw null;
        }

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase db) {
            this.val$configuration.getClass();
            throw null;
        }
    }

    public String getDatabaseName() {
        return this.standardHelper.getDatabaseName();
    }

    public void setWriteAheadLoggingEnabled(boolean enabled) {
        this.standardHelper.setWriteAheadLoggingEnabled(enabled);
    }

    public a getWritableDatabase() {
        try {
            SQLiteDatabase result = this.standardHelper.getWritableDatabase(this.passphrase);
            if (this.clearPassphrase && this.passphrase != null) {
                int i = 0;
                while (true) {
                    byte[] bArr = this.passphrase;
                    if (i >= bArr.length) {
                        break;
                    }
                    bArr[i] = 0;
                    i++;
                }
            }
            return result;
        } catch (SQLiteException ex) {
            byte[] bArr2 = this.passphrase;
            if (bArr2 != null) {
                boolean isCleared = true;
                int length = bArr2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    byte b2 = bArr2[i2];
                    isCleared = isCleared && b2 == 0;
                }
                if (isCleared) {
                    throw new IllegalStateException("The passphrase appears to be cleared. This happens by default the first time you use the factory to open a database, so we can remove the cleartext passphrase from memory. If you close the database yourself, please use a fresh SupportFactory to reopen it. If something else (e.g., Room) closed the database, and you cannot control that, use SupportFactory boolean constructor option to opt out of the automatic password clearing step. See the project README for more information.", ex);
                }
            }
            throw ex;
        }
    }

    public a getReadableDatabase() {
        return getWritableDatabase();
    }

    public void close() {
        this.standardHelper.close();
    }
}
