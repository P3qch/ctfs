package net.sqlcipher.database;

/* loaded from: classes.dex */
public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
