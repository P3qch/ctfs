package net.sqlcipher.database;

import a.q.a.b;

/* loaded from: classes.dex */
public class SupportFactory {
    private final boolean clearPassphrase;
    private final SQLiteDatabaseHook hook;
    private final byte[] passphrase;

    public SupportFactory(byte[] passphrase) {
        this(passphrase, null);
    }

    public SupportFactory(byte[] passphrase, SQLiteDatabaseHook hook) {
        this(passphrase, hook, true);
    }

    public SupportFactory(byte[] passphrase, SQLiteDatabaseHook hook, boolean clearPassphrase) {
        this.passphrase = passphrase;
        this.hook = hook;
        this.clearPassphrase = clearPassphrase;
    }

    public b create(b.a configuration) {
        return new SupportHelper(configuration, this.passphrase, this.hook, this.clearPassphrase);
    }
}
