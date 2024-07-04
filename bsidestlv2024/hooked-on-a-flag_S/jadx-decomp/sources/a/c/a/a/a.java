package a.c.a.a;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f223a;

    /* renamed from: b, reason: collision with root package name */
    public c f224b;
    public c c;

    static {
        new ExecutorC0009a();
        new b();
    }

    /* renamed from: a.c.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ExecutorC0009a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            a.d().c(command);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            a.d().a(command);
        }
    }

    public a() {
        a.c.a.a.b bVar = new a.c.a.a.b();
        this.c = bVar;
        this.f224b = bVar;
    }

    public static a d() {
        if (f223a != null) {
            return f223a;
        }
        synchronized (a.class) {
            if (f223a == null) {
                f223a = new a();
            }
        }
        return f223a;
    }

    @Override // a.c.a.a.c
    public void a(Runnable runnable) {
        this.f224b.a(runnable);
    }

    @Override // a.c.a.a.c
    public void c(Runnable runnable) {
        this.f224b.c(runnable);
    }

    @Override // a.c.a.a.c
    public boolean b() {
        return this.f224b.b();
    }
}
