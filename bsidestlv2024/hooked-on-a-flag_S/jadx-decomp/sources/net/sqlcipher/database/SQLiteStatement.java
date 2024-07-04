package net.sqlcipher.database;

import a.q.a.e;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class SQLiteStatement extends SQLiteProgram implements e {
    private final native long native_1x1_long();

    private final native String native_1x1_string();

    private final native void native_execute();

    public SQLiteStatement(SQLiteDatabase db, String sql) {
        super(db, sql);
    }

    public void execute() {
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();
        try {
            native_execute();
        } finally {
            releaseReference();
            this.mDatabase.unlock();
        }
    }

    public long executeInsert() {
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();
        try {
            native_execute();
            return this.mDatabase.lastChangeCount() > 0 ? this.mDatabase.lastInsertRow() : -1L;
        } finally {
            releaseReference();
            this.mDatabase.unlock();
        }
    }

    public int executeUpdateDelete() {
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();
        try {
            native_execute();
            return this.mDatabase.lastChangeCount();
        } finally {
            releaseReference();
            this.mDatabase.unlock();
        }
    }

    public long simpleQueryForLong() {
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();
        try {
            long retValue = native_1x1_long();
            return retValue;
        } finally {
            releaseReference();
            this.mDatabase.unlock();
        }
    }

    public String simpleQueryForString() {
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();
        try {
            String retValue = native_1x1_string();
            return retValue;
        } finally {
            releaseReference();
            this.mDatabase.unlock();
        }
    }
}
