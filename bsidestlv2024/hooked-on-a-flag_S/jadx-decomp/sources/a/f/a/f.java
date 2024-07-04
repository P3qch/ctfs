package a.f.a;

/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f262a;

    /* renamed from: b, reason: collision with root package name */
    public int f263b;

    /* JADX WARN: Generic types in debug info not equals: a.f.a.f != androidx.constraintlayout.core.Pools$SimplePool<T> */
    public f(int maxPoolSize) {
        if (maxPoolSize <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f262a = new Object[maxPoolSize];
    }

    /* JADX WARN: Generic types in debug info not equals: a.f.a.f != androidx.constraintlayout.core.Pools$SimplePool<T> */
    public T a() {
        int i = this.f263b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f262a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f263b = i - 1;
        return t;
    }

    /* JADX WARN: Generic types in debug info not equals: a.f.a.f != androidx.constraintlayout.core.Pools$SimplePool<T> */
    public boolean b(T instance) {
        int i = this.f263b;
        Object[] objArr = this.f262a;
        if (i < objArr.length) {
            objArr[i] = instance;
            this.f263b = i + 1;
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: a.f.a.f != androidx.constraintlayout.core.Pools$SimplePool<T> */
    public void c(T[] variables, int count) {
        if (count > variables.length) {
            count = variables.length;
        }
        for (int i = 0; i < count; i++) {
            T instance = variables[i];
            int i2 = this.f263b;
            Object[] objArr = this.f262a;
            if (i2 < objArr.length) {
                objArr[i2] = instance;
                this.f263b = i2 + 1;
            }
        }
    }
}
