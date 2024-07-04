package a.h.j;

/* loaded from: classes.dex */
public class h<T> extends g<T> {
    public final Object c;

    /* JADX WARN: Generic types in debug info not equals: a.h.j.h != androidx.core.util.Pools$SynchronizedPool<T> */
    public h(int maxPoolSize) {
        super(maxPoolSize);
        this.c = new Object();
    }

    /* JADX WARN: Generic types in debug info not equals: a.h.j.h != androidx.core.util.Pools$SynchronizedPool<T> */
    @Override // a.h.j.g, a.h.j.f
    public T b() {
        T t;
        synchronized (this.c) {
            t = (T) super.b();
        }
        return t;
    }

    /* JADX WARN: Generic types in debug info not equals: a.h.j.h != androidx.core.util.Pools$SynchronizedPool<T> */
    @Override // a.h.j.g, a.h.j.f
    public boolean a(T element) {
        boolean a2;
        synchronized (this.c) {
            a2 = super.a(element);
        }
        return a2;
    }
}
