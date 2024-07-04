package a.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class f<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public f<K, V>.b f245a;

    /* renamed from: b, reason: collision with root package name */
    public f<K, V>.c f246b;
    public f<K, V>.e c;

    public abstract void a();

    public abstract Object b(int i, int i2);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k, V v);

    public abstract void h(int i);

    public abstract V i(int i, V v);

    /* loaded from: classes.dex */
    public final class a<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public final int f247b;
        public int c;
        public int d;
        public boolean e = false;

        /* JADX WARN: Generic types in debug info not equals: a.e.f$a != androidx.collection.MapCollections<K, V>$ArrayIterator<T> */
        public a(int offset) {
            this.f247b = offset;
            this.c = f.this.d();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$a != androidx.collection.MapCollections<K, V>$ArrayIterator<T> */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d < this.c;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$a != androidx.collection.MapCollections<K, V>$ArrayIterator<T> */
        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) f.this.b(this.d, this.f247b);
            this.d++;
            this.e = true;
            return t;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$a != androidx.collection.MapCollections<K, V>$ArrayIterator<T> */
        @Override // java.util.Iterator
        public void remove() {
            if (!this.e) {
                throw new IllegalStateException();
            }
            int i = this.d - 1;
            this.d = i;
            this.c--;
            this.e = false;
            f.this.h(i);
        }
    }

    /* loaded from: classes.dex */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public int f250b;
        public boolean d = false;
        public int c = -1;

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            a();
            return this;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        public d() {
            this.f250b = f.this.d() - 1;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c < this.f250b;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        public Map.Entry<K, V> a() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.c++;
            this.d = true;
            return this;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Iterator
        public void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            f.this.h(this.c);
            this.c--;
            this.f250b--;
            this.d = false;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Map.Entry
        public K getKey() {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) f.this.b(this.c, 0);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Map.Entry
        public V getValue() {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) f.this.b(this.c, 1);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) f.this.i(this.c, v);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Map.Entry
        public boolean equals(Object o) {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            return a.e.c.c(e.getKey(), f.this.b(this.c, 0)) && a.e.c.c(e.getValue(), f.this.b(this.c, 1));
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object key = f.this.b(this.c, 0);
            Object value = f.this.b(this.c, 1);
            return (value != null ? value.hashCode() : 0) ^ (key == null ? 0 : key.hashCode());
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$d != androidx.collection.MapCollections<K, V>$MapIterator */
        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes.dex */
    public final class b implements Set<Map.Entry<K, V>> {
        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        public b() {
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a();
            throw null;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        public boolean a() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int oldSize = f.this.d();
            for (Map.Entry<K, V> entry : collection) {
                f.this.g(entry.getKey(), entry.getValue());
            }
            return oldSize != f.this.d();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            int index = f.this.e(e.getKey());
            if (index < 0) {
                return false;
            }
            Object foundVal = f.this.b(index, 1);
            return a.e.c.c(foundVal, e.getValue());
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] array) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object object) {
            return f.k(this, object);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int result = 0;
            for (int i = f.this.d() - 1; i >= 0; i--) {
                int i2 = 0;
                Object key = f.this.b(i, 0);
                Object value = f.this.b(i, 1);
                int hashCode = key == null ? 0 : key.hashCode();
                if (value != null) {
                    i2 = value.hashCode();
                }
                result += i2 ^ hashCode;
            }
            return result;
        }
    }

    /* loaded from: classes.dex */
    public final class c implements Set<K> {
        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        public c() {
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean add(K object) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object object) {
            return f.this.e(object) >= 0;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return f.j(f.this.c(), collection);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object object) {
            int index = f.this.e(object);
            if (index >= 0) {
                f.this.h(index);
                return true;
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return f.o(f.this.c(), collection);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return f.p(f.this.c(), collection);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return f.this.q(0);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.r(tArr, 0);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object object) {
            return f.k(this, object);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int result = 0;
            for (int i = f.this.d() - 1; i >= 0; i--) {
                int i2 = 0;
                Object obj = f.this.b(i, 0);
                if (obj != null) {
                    i2 = obj.hashCode();
                }
                result += i2;
            }
            return result;
        }
    }

    /* loaded from: classes.dex */
    public final class e implements Collection<V> {
        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        public e() {
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean add(V object) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public void clear() {
            f.this.a();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean contains(Object object) {
            return f.this.f(object) >= 0;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean remove(Object object) {
            int index = f.this.f(object);
            if (index >= 0) {
                f.this.h(index);
                return true;
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int N = f.this.d();
            boolean changed = false;
            int i = 0;
            while (i < N) {
                Object cur = f.this.b(i, 1);
                if (collection.contains(cur)) {
                    f.this.h(i);
                    i--;
                    N--;
                    changed = true;
                }
                i++;
            }
            return changed;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int N = f.this.d();
            boolean changed = false;
            int i = 0;
            while (i < N) {
                Object cur = f.this.b(i, 1);
                if (!collection.contains(cur)) {
                    f.this.h(i);
                    i--;
                    N--;
                    changed = true;
                }
                i++;
            }
            return changed;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public int size() {
            return f.this.d();
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public Object[] toArray() {
            return f.this.q(1);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.f$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int oldSize = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return oldSize != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int oldSize = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return oldSize != map.size();
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.f != androidx.collection.MapCollections<K, V> */
    public Object[] q(int offset) {
        int N = d();
        Object[] result = new Object[N];
        for (int i = 0; i < N; i++) {
            result[i] = b(i, offset);
        }
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.f != androidx.collection.MapCollections<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    public <T> T[] r(T[] tArr, int i) {
        int d2 = d();
        if (tArr.length < d2) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), d2);
        }
        for (int i2 = 0; i2 < d2; i2++) {
            tArr[i2] = b(i2, i);
        }
        if (tArr.length > d2) {
            tArr[d2] = 0;
        }
        return tArr;
    }

    public static <T> boolean k(Set<T> set, Object object) {
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set<?> s = (Set) object;
        try {
            if (set.size() == s.size()) {
                if (set.containsAll(s)) {
                    return true;
                }
            }
            return false;
        } catch (ClassCastException e2) {
            return false;
        } catch (NullPointerException e3) {
            return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.f != androidx.collection.MapCollections<K, V> */
    public Set<Map.Entry<K, V>> l() {
        if (this.f245a == null) {
            this.f245a = new b();
        }
        return this.f245a;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.f != androidx.collection.MapCollections<K, V> */
    public Set<K> m() {
        if (this.f246b == null) {
            this.f246b = new c();
        }
        return this.f246b;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.f != androidx.collection.MapCollections<K, V> */
    public Collection<V> n() {
        if (this.c == null) {
            this.c = new e();
        }
        return this.c;
    }
}
