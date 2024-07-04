package a.e;

import a.e.f;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f239b = new int[0];
    public static final Object[] c = new Object[0];
    public static Object[] d;
    public static int e;
    public static Object[] f;
    public static int g;
    public int[] h;
    public Object[] i;
    public int j;
    public f<E, E> k;

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public final int f(Object key, int hash) {
        int N = this.j;
        if (N == 0) {
            return -1;
        }
        int index = c.a(this.h, N, hash);
        if (index < 0) {
            return index;
        }
        if (key.equals(this.i[index])) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.h[end] == hash) {
            if (key.equals(this.i[end])) {
                return end;
            }
            end++;
        }
        for (int i = index - 1; i >= 0 && this.h[i] == hash; i--) {
            if (key.equals(this.i[i])) {
                return i;
            }
        }
        int i2 = end ^ (-1);
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public final int g() {
        int N = this.j;
        if (N == 0) {
            return -1;
        }
        int index = c.a(this.h, N, 0);
        if (index < 0) {
            return index;
        }
        if (this.i[index] == null) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.h[end] == 0) {
            if (this.i[end] == null) {
                return end;
            }
            end++;
        }
        for (int i = index - 1; i >= 0 && this.h[i] == 0; i--) {
            if (this.i[i] == null) {
                return i;
            }
        }
        int i2 = end ^ (-1);
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public final void a(int size) {
        if (size == 8) {
            synchronized (b.class) {
                Object[] array = f;
                if (array != null) {
                    this.i = array;
                    f = (Object[]) array[0];
                    this.h = (int[]) array[1];
                    array[1] = null;
                    array[0] = null;
                    g--;
                    return;
                }
            }
        } else if (size == 4) {
            synchronized (b.class) {
                Object[] array2 = d;
                if (array2 != null) {
                    this.i = array2;
                    d = (Object[]) array2[0];
                    this.h = (int[]) array2[1];
                    array2[1] = null;
                    array2[0] = null;
                    e--;
                    return;
                }
            }
        }
        this.h = new int[size];
        this.i = new Object[size];
    }

    public static void c(int[] hashes, Object[] array, int size) {
        if (hashes.length == 8) {
            synchronized (b.class) {
                if (g < 10) {
                    array[0] = f;
                    array[1] = hashes;
                    for (int i = size - 1; i >= 2; i--) {
                        array[i] = null;
                    }
                    f = array;
                    g++;
                }
            }
            return;
        }
        if (hashes.length == 4) {
            synchronized (b.class) {
                if (e < 10) {
                    array[0] = d;
                    array[1] = hashes;
                    for (int i2 = size - 1; i2 >= 2; i2--) {
                        array[i2] = null;
                    }
                    d = array;
                    e++;
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public b() {
        this(0);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public b(int capacity) {
        if (capacity == 0) {
            this.h = f239b;
            this.i = c;
        } else {
            a(capacity);
        }
        this.j = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.j;
        if (i != 0) {
            c(this.h, this.i, i);
            this.h = f239b;
            this.i = c;
            this.j = 0;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public void b(int minimumCapacity) {
        if (this.h.length < minimumCapacity) {
            int[] ohashes = this.h;
            Object[] oarray = this.i;
            a(minimumCapacity);
            int i = this.j;
            if (i > 0) {
                System.arraycopy(ohashes, 0, this.h, 0, i);
                System.arraycopy(oarray, 0, this.i, 0, this.j);
            }
            c(ohashes, oarray, this.j);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object key) {
        return e(key) >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public int e(Object key) {
        return key == null ? g() : f(key, key.hashCode());
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public E i(int i) {
        return (E) this.i[i];
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.j <= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean add(E value) {
        int hash;
        int index;
        if (value == null) {
            hash = 0;
            index = g();
        } else {
            hash = value.hashCode();
            index = f(value, hash);
        }
        if (index >= 0) {
            return false;
        }
        int index2 = index ^ (-1);
        int i = this.j;
        if (i >= this.h.length) {
            int i2 = 4;
            if (i >= 8) {
                i2 = (i >> 1) + i;
            } else if (i >= 4) {
                i2 = 8;
            }
            int n = i2;
            int[] ohashes = this.h;
            Object[] oarray = this.i;
            a(n);
            int[] iArr = this.h;
            if (iArr.length > 0) {
                System.arraycopy(ohashes, 0, iArr, 0, ohashes.length);
                System.arraycopy(oarray, 0, this.i, 0, oarray.length);
            }
            c(ohashes, oarray, this.j);
        }
        int i3 = this.j;
        if (index2 < i3) {
            int[] iArr2 = this.h;
            System.arraycopy(iArr2, index2, iArr2, index2 + 1, i3 - index2);
            Object[] objArr = this.i;
            System.arraycopy(objArr, index2, objArr, index2 + 1, this.j - index2);
        }
        this.h[index2] = hash;
        this.i[index2] = value;
        this.j++;
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object object) {
        int index = e(object);
        if (index >= 0) {
            h(index);
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public E h(int i) {
        Object[] objArr = this.i;
        E e2 = (E) objArr[i];
        int i2 = this.j;
        if (i2 <= 1) {
            c(this.h, objArr, i2);
            this.h = f239b;
            this.i = c;
            this.j = 0;
        } else {
            int[] iArr = this.h;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                int i3 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                int[] iArr2 = this.h;
                Object[] objArr2 = this.i;
                a(i3);
                this.j--;
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.h, 0, i);
                    System.arraycopy(objArr2, 0, this.i, 0, i);
                }
                int i4 = this.j;
                if (i < i4) {
                    System.arraycopy(iArr2, i + 1, this.h, i, i4 - i);
                    System.arraycopy(objArr2, i + 1, this.i, i, this.j - i);
                }
            } else {
                int i5 = i2 - 1;
                this.j = i5;
                if (i < i5) {
                    System.arraycopy(iArr, i + 1, iArr, i, i5 - i);
                    Object[] objArr3 = this.i;
                    System.arraycopy(objArr3, i + 1, objArr3, i, this.j - i);
                }
                this.i[this.j] = null;
            }
        }
        return e2;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.j;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.j;
        Object[] result = new Object[i];
        System.arraycopy(this.i, 0, result, 0, i);
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object[]] */
    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] array) {
        if (array.length < this.j) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), this.j);
        }
        System.arraycopy(this.i, 0, array, 0, this.j);
        int length = array.length;
        int i = this.j;
        if (length > i) {
            array[i] = null;
        }
        return array;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set<?> set = (Set) object;
        if (size() != set.size()) {
            return false;
        }
        for (int i = 0; i < this.j; i++) {
            try {
                E mine = i(i);
                if (!set.contains(mine)) {
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

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] hashes = this.h;
        int result = 0;
        int s = this.j;
        for (int i = 0; i < s; i++) {
            result += hashes[i];
        }
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.j * 14);
        buffer.append('{');
        for (int i = 0; i < this.j; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            Object value = i(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Set)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }

    /* loaded from: classes.dex */
    public class a extends f<E, E> {
        public a() {
        }

        @Override // a.e.f
        public int d() {
            return b.this.j;
        }

        @Override // a.e.f
        public Object b(int index, int offset) {
            return b.this.i[index];
        }

        @Override // a.e.f
        public int e(Object key) {
            return b.this.e(key);
        }

        @Override // a.e.f
        public int f(Object value) {
            return b.this.e(value);
        }

        @Override // a.e.f
        public Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // a.e.f
        public void g(E key, E value) {
            b.this.add(key);
        }

        @Override // a.e.f
        public E i(int index, E value) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // a.e.f
        public void h(int index) {
            b.this.h(index);
        }

        @Override // a.e.f
        public void a() {
            b.this.clear();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    public final f<E, E> d() {
        if (this.k == null) {
            this.k = new a();
        }
        return this.k;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return ((f.c) d().m()).iterator();
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        for (Object item : collection) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.j + collection.size());
        boolean added = false;
        for (E value : collection) {
            added |= add(value);
        }
        return added;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean removed = false;
        for (Object value : collection) {
            removed |= remove(value);
        }
        return removed;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.b != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean removed = false;
        for (int i = this.j - 1; i >= 0; i--) {
            if (!collection.contains(this.i[i])) {
                h(i);
                removed = true;
            }
        }
        return removed;
    }
}
