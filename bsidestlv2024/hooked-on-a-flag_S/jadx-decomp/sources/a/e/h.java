package a.e;

/* loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f253b = new Object();
    public boolean c;
    public int[] d;
    public Object[] e;
    public int f;

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public h() {
        this(10);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public h(int initialCapacity) {
        this.c = false;
        if (initialCapacity == 0) {
            this.d = c.f240a;
            this.e = c.c;
        } else {
            int initialCapacity2 = c.e(initialCapacity);
            this.d = new int[initialCapacity2];
            this.e = new Object[initialCapacity2];
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.d = (int[]) this.d.clone();
            hVar.e = (Object[]) this.e.clone();
            return hVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public E e(int key) {
        return f(key, null);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public E f(int i, E e) {
        int a2 = c.a(this.d, this.f, i);
        if (a2 >= 0) {
            Object[] objArr = this.e;
            if (objArr[a2] != f253b) {
                return (E) objArr[a2];
            }
        }
        return e;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public final void d() {
        int n = this.f;
        int o = 0;
        int[] keys = this.d;
        Object[] values = this.e;
        for (int i = 0; i < n; i++) {
            Object val = values[i];
            if (val != f253b) {
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

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public void i(int key, E value) {
        int i = c.a(this.d, this.f, key);
        if (i >= 0) {
            this.e[i] = value;
            return;
        }
        int i2 = i ^ (-1);
        int i3 = this.f;
        if (i2 < i3) {
            Object[] objArr = this.e;
            if (objArr[i2] == f253b) {
                this.d[i2] = key;
                objArr[i2] = value;
                return;
            }
        }
        if (this.c && i3 >= this.d.length) {
            d();
            i2 = c.a(this.d, this.f, key) ^ (-1);
        }
        int i4 = this.f;
        if (i4 >= this.d.length) {
            int n = c.e(i4 + 1);
            int[] nkeys = new int[n];
            Object[] nvalues = new Object[n];
            int[] iArr = this.d;
            System.arraycopy(iArr, 0, nkeys, 0, iArr.length);
            Object[] objArr2 = this.e;
            System.arraycopy(objArr2, 0, nvalues, 0, objArr2.length);
            this.d = nkeys;
            this.e = nvalues;
        }
        int n2 = this.f;
        if (n2 - i2 != 0) {
            int[] iArr2 = this.d;
            System.arraycopy(iArr2, i2, iArr2, i2 + 1, n2 - i2);
            Object[] objArr3 = this.e;
            System.arraycopy(objArr3, i2, objArr3, i2 + 1, this.f - i2);
        }
        this.d[i2] = key;
        this.e[i2] = value;
        this.f++;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public int j() {
        if (this.c) {
            d();
        }
        return this.f;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public int h(int index) {
        if (this.c) {
            d();
        }
        return this.d[index];
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public E k(int i) {
        if (this.c) {
            d();
        }
        return (E) this.e[i];
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public int g(E value) {
        if (this.c) {
            d();
        }
        for (int i = 0; i < this.f; i++) {
            if (this.e[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public void b() {
        int n = this.f;
        Object[] values = this.e;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        this.f = 0;
        this.c = false;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public void a(int key, E value) {
        int i = this.f;
        if (i != 0 && key <= this.d[i - 1]) {
            i(key, value);
            return;
        }
        int pos = this.f;
        if (pos >= this.d.length) {
            int n = c.e(pos + 1);
            int[] nkeys = new int[n];
            Object[] nvalues = new Object[n];
            int[] iArr = this.d;
            System.arraycopy(iArr, 0, nkeys, 0, iArr.length);
            Object[] objArr = this.e;
            System.arraycopy(objArr, 0, nvalues, 0, objArr.length);
            this.d = nkeys;
            this.e = nvalues;
        }
        this.d[pos] = key;
        this.e[pos] = value;
        this.f = pos + 1;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<E> */
    public String toString() {
        if (j() <= 0) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.f * 28);
        buffer.append('{');
        for (int i = 0; i < this.f; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            int key = h(i);
            buffer.append(key);
            buffer.append('=');
            Object value = k(i);
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
