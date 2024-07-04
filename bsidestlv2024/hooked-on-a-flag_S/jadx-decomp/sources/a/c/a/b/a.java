package a.c.a.b;

import a.c.a.b.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {
    public HashMap<K, b.c<K, V>> f = new HashMap<>();

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.a != androidx.arch.core.internal.FastSafeIterableMap<K, V> */
    @Override // a.c.a.b.b
    public b.c<K, V> c(K k) {
        return this.f.get(k);
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.a != androidx.arch.core.internal.FastSafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.b$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
    @Override // a.c.a.b.b
    public V g(K key, V v) {
        b.c<K, V> c = c(key);
        if (c != null) {
            return c.c;
        }
        this.f.put(key, f(key, v));
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.a != androidx.arch.core.internal.FastSafeIterableMap<K, V> */
    @Override // a.c.a.b.b
    public V h(K k) {
        V v = (V) super.h(k);
        this.f.remove(k);
        return v;
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.a != androidx.arch.core.internal.FastSafeIterableMap<K, V> */
    public boolean contains(K key) {
        return this.f.containsKey(key);
    }

    /* JADX WARN: Generic types in debug info not equals: a.c.a.b.a != androidx.arch.core.internal.FastSafeIterableMap<K, V> */
    public Map.Entry<K, V> i(K k) {
        if (contains(k)) {
            return this.f.get(k).e;
        }
        return null;
    }
}
