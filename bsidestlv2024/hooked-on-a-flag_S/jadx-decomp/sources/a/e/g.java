package a.e;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class g<K, V> {

    /* renamed from: b, reason: collision with root package name */
    public static Object[] f252b;
    public static int c;
    public static Object[] d;
    public static int e;
    public int[] f;
    public Object[] g;
    public int h;

    public static int b(int[] hashes, int N, int hash) {
        try {
            return c.a(hashes, N, hash);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public int e(Object key, int hash) {
        int N = this.h;
        if (N == 0) {
            return -1;
        }
        int index = b(this.f, N, hash);
        if (index < 0) {
            return index;
        }
        if (key.equals(this.g[index << 1])) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.f[end] == hash) {
            if (key.equals(this.g[end << 1])) {
                return end;
            }
            end++;
        }
        for (int i = index - 1; i >= 0 && this.f[i] == hash; i--) {
            if (key.equals(this.g[i << 1])) {
                return i;
            }
        }
        int i2 = end ^ (-1);
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public int g() {
        int N = this.h;
        if (N == 0) {
            return -1;
        }
        int index = b(this.f, N, 0);
        if (index < 0) {
            return index;
        }
        if (this.g[index << 1] == null) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.f[end] == 0) {
            if (this.g[end << 1] == null) {
                return end;
            }
            end++;
        }
        for (int i = index - 1; i >= 0 && this.f[i] == 0; i--) {
            if (this.g[i << 1] == null) {
                return i;
            }
        }
        int i2 = end ^ (-1);
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public final void a(int size) {
        if (size == 8) {
            synchronized (g.class) {
                Object[] array = d;
                if (array != null) {
                    this.g = array;
                    d = (Object[]) array[0];
                    this.f = (int[]) array[1];
                    array[1] = null;
                    array[0] = null;
                    e--;
                    return;
                }
            }
        } else if (size == 4) {
            synchronized (g.class) {
                Object[] array2 = f252b;
                if (array2 != null) {
                    this.g = array2;
                    f252b = (Object[]) array2[0];
                    this.f = (int[]) array2[1];
                    array2[1] = null;
                    array2[0] = null;
                    c--;
                    return;
                }
            }
        }
        this.f = new int[size];
        this.g = new Object[size << 1];
    }

    public static void d(int[] hashes, Object[] array, int size) {
        if (hashes.length == 8) {
            synchronized (g.class) {
                if (e < 10) {
                    array[0] = d;
                    array[1] = hashes;
                    for (int i = (size << 1) - 1; i >= 2; i--) {
                        array[i] = null;
                    }
                    d = array;
                    e++;
                }
            }
            return;
        }
        if (hashes.length == 4) {
            synchronized (g.class) {
                if (c < 10) {
                    array[0] = f252b;
                    array[1] = hashes;
                    for (int i2 = (size << 1) - 1; i2 >= 2; i2--) {
                        array[i2] = null;
                    }
                    f252b = array;
                    c++;
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public g() {
        this.f = c.f240a;
        this.g = c.c;
        this.h = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public g(int capacity) {
        if (capacity == 0) {
            this.f = c.f240a;
            this.g = c.c;
        } else {
            a(capacity);
        }
        this.h = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(g<K, V> gVar) {
        this();
        if (gVar != 0) {
            j(gVar);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public void clear() {
        if (this.h > 0) {
            int[] ohashes = this.f;
            Object[] oarray = this.g;
            int osize = this.h;
            this.f = c.f240a;
            this.g = c.c;
            this.h = 0;
            d(ohashes, oarray, osize);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public void c(int minimumCapacity) {
        int osize = this.h;
        if (this.f.length < minimumCapacity) {
            int[] ohashes = this.f;
            Object[] oarray = this.g;
            a(minimumCapacity);
            if (this.h > 0) {
                System.arraycopy(ohashes, 0, this.f, 0, osize);
                System.arraycopy(oarray, 0, this.g, 0, osize << 1);
            }
            d(ohashes, oarray, osize);
        }
        if (this.h != osize) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public boolean containsKey(Object key) {
        return f(key) >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public int f(Object key) {
        return key == null ? g() : e(key, key.hashCode());
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public int h(Object value) {
        int N = this.h * 2;
        Object[] array = this.g;
        if (value == null) {
            for (int i = 1; i < N; i += 2) {
                if (array[i] == null) {
                    return i >> 1;
                }
            }
            return -1;
        }
        for (int i2 = 1; i2 < N; i2 += 2) {
            if (value.equals(array[i2])) {
                return i2 >> 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public boolean containsValue(Object value) {
        return h(value) >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public V get(Object key) {
        return getOrDefault(key, null);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public V getOrDefault(Object obj, V v) {
        int f = f(obj);
        return f >= 0 ? (V) this.g[(f << 1) + 1] : v;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public K i(int i) {
        return (K) this.g[i << 1];
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public V m(int i) {
        return (V) this.g[(i << 1) + 1];
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public V l(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.g;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public boolean isEmpty() {
        return this.h <= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public V put(K k, V v) {
        int hashCode;
        int e2;
        int i = this.h;
        if (k == null) {
            hashCode = 0;
            e2 = g();
        } else {
            hashCode = k.hashCode();
            e2 = e(k, hashCode);
        }
        if (e2 >= 0) {
            int i2 = (e2 << 1) + 1;
            Object[] objArr = this.g;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
        int i3 = e2 ^ (-1);
        if (i >= this.f.length) {
            int i4 = 4;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i >= 4) {
                i4 = 8;
            }
            int[] iArr = this.f;
            Object[] objArr2 = this.g;
            a(i4);
            if (i != this.h) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.g, 0, objArr2.length);
            }
            d(iArr, objArr2, i);
        }
        if (i3 < i) {
            int[] iArr3 = this.f;
            System.arraycopy(iArr3, i3, iArr3, i3 + 1, i - i3);
            Object[] objArr3 = this.g;
            System.arraycopy(objArr3, i3 << 1, objArr3, (i3 + 1) << 1, (this.h - i3) << 1);
        }
        int i5 = this.h;
        if (i == i5) {
            int[] iArr4 = this.f;
            if (i3 < iArr4.length) {
                iArr4[i3] = hashCode;
                Object[] objArr4 = this.g;
                objArr4[i3 << 1] = k;
                objArr4[(i3 << 1) + 1] = v;
                this.h = i5 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<? extends K, ? extends V> */
    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public void j(g<? extends K, ? extends V> gVar) {
        int N = gVar.h;
        c(this.h + N);
        if (this.h == 0) {
            if (N > 0) {
                System.arraycopy(gVar.f, 0, this.f, 0, N);
                System.arraycopy(gVar.g, 0, this.g, 0, N << 1);
                this.h = N;
                return;
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            put(gVar.i(i), gVar.m(i));
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public V putIfAbsent(K key, V value) {
        V mapValue = get(key);
        if (mapValue == null) {
            return put(key, value);
        }
        return mapValue;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public V remove(Object key) {
        int index = f(key);
        if (index >= 0) {
            return k(index);
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public boolean remove(Object key, Object value) {
        int index = f(key);
        if (index >= 0) {
            V mapValue = m(index);
            if (value == mapValue || (value != null && value.equals(mapValue))) {
                k(index);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public V k(int i) {
        int i2;
        Object[] objArr = this.g;
        V v = (V) objArr[(i << 1) + 1];
        int i3 = this.h;
        if (i3 <= 1) {
            d(this.f, objArr, i3);
            this.f = c.f240a;
            this.g = c.c;
            i2 = 0;
        } else {
            i2 = i3 - 1;
            int[] iArr = this.f;
            if (iArr.length > 8 && this.h < iArr.length / 3) {
                int i4 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr2 = this.f;
                Object[] objArr2 = this.g;
                a(i4);
                if (i3 != this.h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.f, 0, i);
                    System.arraycopy(objArr2, 0, this.g, 0, i << 1);
                }
                if (i < i2) {
                    System.arraycopy(iArr2, i + 1, this.f, i, i2 - i);
                    System.arraycopy(objArr2, (i + 1) << 1, this.g, i << 1, (i2 - i) << 1);
                }
            } else {
                if (i < i2) {
                    System.arraycopy(iArr, i + 1, iArr, i, i2 - i);
                    Object[] objArr3 = this.g;
                    System.arraycopy(objArr3, (i + 1) << 1, objArr3, i << 1, (i2 - i) << 1);
                }
                Object[] objArr4 = this.g;
                objArr4[i2 << 1] = null;
                objArr4[(i2 << 1) + 1] = null;
            }
        }
        if (i3 != this.h) {
            throw new ConcurrentModificationException();
        }
        this.h = i2;
        return v;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public V replace(K key, V value) {
        int index = f(key);
        if (index >= 0) {
            return l(index, value);
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public boolean replace(K key, V oldValue, V newValue) {
        int index = f(key);
        if (index >= 0) {
            V mapValue = m(index);
            if (mapValue == oldValue || (oldValue != null && oldValue.equals(mapValue))) {
                l(index, newValue);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public int size() {
        return this.h;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<?, ?> */
    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof g) {
            g gVar = (g) object;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i = 0; i < this.h; i++) {
                try {
                    K key = i(i);
                    V mine = m(i);
                    Object theirs = gVar.get(key);
                    if (mine == null) {
                        if (theirs != null || !gVar.containsKey(key)) {
                            return false;
                        }
                    } else if (!mine.equals(theirs)) {
                        return false;
                    }
                } catch (ClassCastException e2) {
                    return false;
                } catch (NullPointerException e3) {
                    return false;
                }
            }
            return true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        Map<?, ?> map = (Map) object;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            try {
                K key2 = i(i2);
                V mine2 = m(i2);
                Object theirs2 = map.get(key2);
                if (mine2 == null) {
                    if (theirs2 != null || !map.containsKey(key2)) {
                        return false;
                    }
                } else if (!mine2.equals(theirs2)) {
                    return false;
                }
            } catch (ClassCastException e4) {
                return false;
            } catch (NullPointerException e5) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public int hashCode() {
        int[] hashes = this.f;
        Object[] array = this.g;
        int result = 0;
        int i = 0;
        int v = 1;
        int s = this.h;
        while (i < s) {
            Object value = array[v];
            result += hashes[i] ^ (value == null ? 0 : value.hashCode());
            i++;
            v += 2;
        }
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<K, V> */
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.h * 28);
        buffer.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            Object key = i(i);
            if (key != this) {
                buffer.append(key);
            } else {
                buffer.append("(this Map)");
            }
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
