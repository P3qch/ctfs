package a.h.j;

/* loaded from: classes.dex */
public class g<T> implements f<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f429a;

    /* renamed from: b, reason: collision with root package name */
    public int f430b;

    /* JADX WARN: Generic types in debug info not equals: a.h.j.g != androidx.core.util.Pools$SimplePool<T> */
    public g(int maxPoolSize) {
        if (maxPoolSize <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f429a = new Object[maxPoolSize];
    }

    /* JADX WARN: Generic types in debug info not equals: a.h.j.g != androidx.core.util.Pools$SimplePool<T> */
    @Override // a.h.j.f
    public T b() {
        int i = this.f430b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f429a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f430b = i - 1;
        return t;
    }

    /* JADX WARN: Generic types in debug info not equals: a.h.j.g != androidx.core.util.Pools$SimplePool<T> */
    @Override // a.h.j.f
    public boolean a(T instance) {
        if (c(instance)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i = this.f430b;
        Object[] objArr = this.f429a;
        if (i < objArr.length) {
            objArr[i] = instance;
            this.f430b = i + 1;
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: a.h.j.g != androidx.core.util.Pools$SimplePool<T> */
    public final boolean c(T instance) {
        for (int i = 0; i < this.f430b; i++) {
            if (this.f429a[i] == instance) {
                return true;
            }
        }
        return false;
    }
}
