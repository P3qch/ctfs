package a.c.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b, reason: collision with root package name */
    public c<K, V> f228b;
    public c<K, V> c;
    public WeakHashMap<f<K, V>, Boolean> d = new WeakHashMap<>();
    public int e = 0;

    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
    public c<K, V> c(K k) {
        c<K, V> cVar = this.f228b;
        while (cVar != null && !cVar.f229b.equals(k)) {
            cVar = cVar.d;
        }
        return cVar;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
    public V g(K key, V v) {
        c<K, V> c2 = c(key);
        if (c2 != null) {
            return c2.c;
        }
        f(key, v);
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
    public c<K, V> f(K key, V v) {
        c<K, V> cVar = new c<>(key, v);
        this.e++;
        c<K, V> cVar2 = this.c;
        if (cVar2 == null) {
            this.f228b = cVar;
            this.c = cVar;
            return cVar;
        }
        cVar2.d = cVar;
        cVar.e = cVar2;
        this.c = cVar;
        return cVar;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$f != androidx.arch.core.internal.SafeIterableMap$SupportRemove<K, V> */
    public V h(K key) {
        c<K, V> c2 = c(key);
        if (c2 == null) {
            return null;
        }
        this.e--;
        if (!this.d.isEmpty()) {
            Iterator<f<K, V>> it = this.d.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(c2);
            }
        }
        c<K, V> cVar = c2.e;
        if (cVar != null) {
            cVar.d = c2.d;
        } else {
            this.f228b = c2.d;
        }
        c<K, V> cVar2 = c2.d;
        if (cVar2 != null) {
            cVar2.e = cVar;
        } else {
            this.c = cVar;
        }
        c2.d = null;
        c2.e = null;
        return c2.c;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public int size() {
        return this.e;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f228b, this.c);
        this.d.put(aVar, false);
        return aVar;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$b != androidx.arch.core.internal.SafeIterableMap$DescendingIterator<K, V> */
    public Iterator<Map.Entry<K, V>> a() {
        C0010b c0010b = new C0010b(this.c, this.f228b);
        this.d.put(c0010b, false);
        return c0010b;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$d != androidx.arch.core.internal.SafeIterableMap<K, V>$IteratorWithAdditions */
    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.d.put(dVar, false);
        return dVar;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public Map.Entry<K, V> b() {
        return this.f228b;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public Map.Entry<K, V> e() {
        return this.c;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b map = (b) obj;
        if (size() != map.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> iterator1 = iterator();
        Iterator iterator2 = map.iterator();
        while (((e) iterator1).hasNext() && ((e) iterator2).hasNext()) {
            Map.Entry<K, V> next1 = (Map.Entry) ((e) iterator1).next();
            Object next2 = ((e) iterator2).next();
            if ((next1 == null && next2 != null) || (next1 != null && !next1.equals(next2))) {
                return false;
            }
        }
        return (((e) iterator1).hasNext() || ((e) iterator2).hasNext()) ? false : true;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public int hashCode() {
        int h = 0;
        Iterator<Map.Entry<K, V>> i = iterator();
        while (((e) i).hasNext()) {
            h += ((Map.Entry) ((e) i).next()).hashCode();
        }
        return h;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Iterator<Map.Entry<K, V>> iterator = iterator();
        while (((e) iterator).hasNext()) {
            builder.append(((Map.Entry) ((e) iterator).next()).toString());
            if (((e) iterator).hasNext()) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /* loaded from: classes.dex */
    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public c<K, V> f231b;
        public c<K, V> c;

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f231b = cVar2;
            this.c = cVar;
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
        @Override // a.c.a.b.b.f
        public void a(c<K, V> cVar) {
            if (this.f231b == cVar && cVar == this.c) {
                this.c = null;
                this.f231b = null;
            }
            c<K, V> cVar2 = this.f231b;
            if (cVar2 == cVar) {
                this.f231b = b(cVar2);
            }
            if (this.c == cVar) {
                this.c = e();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
        public final c<K, V> e() {
            c<K, V> cVar = this.c;
            c<K, V> cVar2 = this.f231b;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> result = this.c;
            this.c = e();
            return result;
        }
    }

    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$a != androidx.arch.core.internal.SafeIterableMap$AscendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$a != androidx.arch.core.internal.SafeIterableMap$AscendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // a.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.d;
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$a != androidx.arch.core.internal.SafeIterableMap$AscendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // a.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.e;
        }
    }

    /* renamed from: a.c.a.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010b<K, V> extends e<K, V> {
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$b != androidx.arch.core.internal.SafeIterableMap$DescendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        public C0010b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$b != androidx.arch.core.internal.SafeIterableMap$DescendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // a.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.e;
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$b != androidx.arch.core.internal.SafeIterableMap$DescendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // a.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public c<K, V> f230b;
        public boolean c = true;

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$d != androidx.arch.core.internal.SafeIterableMap<K, V>$IteratorWithAdditions */
        public d() {
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$d != androidx.arch.core.internal.SafeIterableMap<K, V>$IteratorWithAdditions */
        @Override // a.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f230b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.e;
                this.f230b = cVar3;
                this.c = cVar3 == null;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$d != androidx.arch.core.internal.SafeIterableMap<K, V>$IteratorWithAdditions */
        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c) {
                return b.this.f228b != null;
            }
            c<K, V> cVar = this.f230b;
            return (cVar == null || cVar.d == null) ? false : true;
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$d != androidx.arch.core.internal.SafeIterableMap<K, V>$IteratorWithAdditions */
        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.c) {
                this.c = false;
                this.f230b = b.this.f228b;
            } else {
                c<K, V> cVar = this.f230b;
                this.f230b = cVar != null ? cVar.d : null;
            }
            return this.f230b;
        }
    }

    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f229b;
        public final V c;
        public c<K, V> d;
        public c<K, V> e;

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        public c(K key, V value) {
            this.f229b = key;
            this.c = value;
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f229b;
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // java.util.Map.Entry
        public V getValue() {
            return this.c;
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // java.util.Map.Entry
        public V setValue(V value) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        public String toString() {
            return this.f229b + "=" + this.c;
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c entry = (c) obj;
            return this.f229b.equals(entry.f229b) && this.c.equals(entry.c);
        }

        /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f229b.hashCode() ^ this.c.hashCode();
        }
    }
}
