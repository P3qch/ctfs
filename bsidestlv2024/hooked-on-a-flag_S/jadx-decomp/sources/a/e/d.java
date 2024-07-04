package a.e;

/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f242b = new Object();
    public boolean c;
    public long[] d;
    public Object[] e;
    public int f;

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public d() {
        this(10);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public d(int initialCapacity) {
        this.c = false;
        if (initialCapacity == 0) {
            this.d = c.f241b;
            this.e = c.c;
        } else {
            int initialCapacity2 = c.f(initialCapacity);
            this.d = new long[initialCapacity2];
            this.e = new Object[initialCapacity2];
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.d = (long[]) this.d.clone();
            dVar.e = (Object[]) this.e.clone();
            return dVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public E e(long key) {
        return f(key, null);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public E f(long j, E e) {
        int b2 = c.b(this.d, this.f, j);
        if (b2 >= 0) {
            Object[] objArr = this.e;
            if (objArr[b2] != f242b) {
                return (E) objArr[b2];
            }
        }
        return e;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public void j(long key) {
        int i = c.b(this.d, this.f, key);
        if (i >= 0) {
            Object[] objArr = this.e;
            Object obj = objArr[i];
            Object obj2 = f242b;
            if (obj != obj2) {
                objArr[i] = obj2;
                this.c = true;
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public void k(int index) {
        Object[] objArr = this.e;
        Object obj = objArr[index];
        Object obj2 = f242b;
        if (obj != obj2) {
            objArr[index] = obj2;
            this.c = true;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public final void d() {
        int n = this.f;
        int o = 0;
        long[] keys = this.d;
        Object[] values = this.e;
        for (int i = 0; i < n; i++) {
            Object val = values[i];
            if (val != f242b) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }
                o++;
            }
        }
        this.c = false;
        this.f = o;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public void i(long key, E value) {
        int i = c.b(this.d, this.f, key);
        if (i >= 0) {
            this.e[i] = value;
            return;
        }
        int i2 = i ^ (-1);
        int i3 = this.f;
        if (i2 < i3) {
            Object[] objArr = this.e;
            if (objArr[i2] == f242b) {
                this.d[i2] = key;
                objArr[i2] = value;
                return;
            }
        }
        if (this.c && i3 >= this.d.length) {
            d();
            i2 = c.b(this.d, this.f, key) ^ (-1);
        }
        int i4 = this.f;
        if (i4 >= this.d.length) {
            int n = c.f(i4 + 1);
            long[] nkeys = new long[n];
            Object[] nvalues = new Object[n];
            long[] jArr = this.d;
            System.arraycopy(jArr, 0, nkeys, 0, jArr.length);
            Object[] objArr2 = this.e;
            System.arraycopy(objArr2, 0, nvalues, 0, objArr2.length);
            this.d = nkeys;
            this.e = nvalues;
        }
        int n2 = this.f;
        if (n2 - i2 != 0) {
            long[] jArr2 = this.d;
            System.arraycopy(jArr2, i2, jArr2, i2 + 1, n2 - i2);
            Object[] objArr3 = this.e;
            System.arraycopy(objArr3, i2, objArr3, i2 + 1, this.f - i2);
        }
        this.d[i2] = key;
        this.e[i2] = value;
        this.f++;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public int l() {
        if (this.c) {
            d();
        }
        return this.f;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public long h(int index) {
        if (this.c) {
            d();
        }
        return this.d[index];
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public E m(int i) {
        if (this.c) {
            d();
        }
        return (E) this.e[i];
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public int g(long key) {
        if (this.c) {
            d();
        }
        return c.b(this.d, this.f, key);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public void b() {
        int n = this.f;
        Object[] values = this.e;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        this.f = 0;
        this.c = false;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public void a(long key, E value) {
        int i = this.f;
        if (i != 0 && key <= this.d[i - 1]) {
            i(key, value);
            return;
        }
        if (this.c && i >= this.d.length) {
            d();
        }
        int pos = this.f;
        if (pos >= this.d.length) {
            int n = c.f(pos + 1);
            long[] nkeys = new long[n];
            Object[] nvalues = new Object[n];
            long[] jArr = this.d;
            System.arraycopy(jArr, 0, nkeys, 0, jArr.length);
            Object[] objArr = this.e;
            System.arraycopy(objArr, 0, nvalues, 0, objArr.length);
            this.d = nkeys;
            this.e = nvalues;
        }
        this.d[pos] = key;
        this.e[pos] = value;
        this.f = pos + 1;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<E> */
    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.f * 28);
        buffer.append('{');
        for (int i = 0; i < this.f; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            long key = h(i);
            buffer.append(key);
            buffer.append('=');
            Object value = m(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Map)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }
}
