package a.e;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {
    public f<K, V> i;

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<K, V> */
    public a() {
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<K, V> */
    public a(int capacity) {
        super(capacity);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<K, V> */
    public a(g map) {
        super(map);
    }

    /* renamed from: a.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0011a extends f<K, V> {
        public C0011a() {
        }

        @Override // a.e.f
        public int d() {
            return a.this.h;
        }

        @Override // a.e.f
        public Object b(int index, int offset) {
            return a.this.g[(index << 1) + offset];
        }

        @Override // a.e.f
        public int e(Object key) {
            return a.this.f(key);
        }

        @Override // a.e.f
        public int f(Object value) {
            return a.this.h(value);
        }

        @Override // a.e.f
        public Map<K, V> c() {
            return a.this;
        }

        @Override // a.e.f
        public void g(K key, V value) {
            a.this.put(key, value);
        }

        @Override // a.e.f
        public V i(int index, V value) {
            return a.this.l(index, value);
        }

        @Override // a.e.f
        public void h(int index) {
            a.this.k(index);
        }

        @Override // a.e.f
        public void a() {
            a.this.clear();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<K, V> */
    public final f<K, V> n() {
        if (this.i == null) {
            this.i = new C0011a();
        }
        return this.i;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<K, V> */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<K, V> */
    public boolean o(Collection<?> collection) {
        return f.p(this, collection);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<K, V> */
    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<K, V> */
    @Override // java.util.Map
    public Set<K> keySet() {
        return n().m();
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<K, V> */
    @Override // java.util.Map
    public Collection<V> values() {
        return n().n();
    }
}
