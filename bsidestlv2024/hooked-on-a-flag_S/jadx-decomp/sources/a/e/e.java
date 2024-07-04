package a.e;

import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class e<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<K, V> f243a;

    /* renamed from: b, reason: collision with root package name */
    public int f244b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    /* JADX WARN: Generic types in debug info not equals: a.e.e != androidx.collection.LruCache<K, V> */
    public e(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = maxSize;
        this.f243a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.e != androidx.collection.LruCache<K, V> */
    public final V c(K key) {
        V mapValue;
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V mapValue2 = this.f243a.get(key);
            if (mapValue2 != null) {
                this.g++;
                return mapValue2;
            }
            this.h++;
            a();
            if (0 == 0) {
                return null;
            }
            synchronized (this) {
                this.e++;
                mapValue = this.f243a.put(key, null);
                if (mapValue != null) {
                    this.f243a.put(key, mapValue);
                } else {
                    int i = this.f244b;
                    e(key, null);
                    this.f244b = i + 1;
                }
            }
            if (mapValue != null) {
                b();
                return mapValue;
            }
            g(this.c);
            return null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.e != androidx.collection.LruCache<K, V> */
    public final V d(K key, V value) {
        V previous;
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            int i = this.f244b;
            e(key, value);
            this.f244b = i + 1;
            previous = this.f243a.put(key, value);
            if (previous != null) {
                int i2 = this.f244b;
                e(key, previous);
                this.f244b = i2 - 1;
            }
        }
        if (previous != null) {
            b();
        }
        g(this.c);
        return previous;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x006f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARN: Generic types in debug info not equals: a.e.e != androidx.collection.LruCache<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f244b     // Catch: java.lang.Throwable -> L70
            if (r0 < 0) goto L51
            java.util.LinkedHashMap<K, V> r0 = r4.f243a     // Catch: java.lang.Throwable -> L70
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L11
            int r0 = r4.f244b     // Catch: java.lang.Throwable -> L70
            if (r0 != 0) goto L51
        L11:
            int r0 = r4.f244b     // Catch: java.lang.Throwable -> L70
            if (r0 <= r5) goto L4f
            java.util.LinkedHashMap<K, V> r0 = r4.f243a     // Catch: java.lang.Throwable -> L70
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L1e
            goto L4f
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.f243a     // Catch: java.lang.Throwable -> L70
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L70
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L70
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L70
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L70
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L70
            java.lang.Object r2 = r0.getValue()     // Catch: java.lang.Throwable -> L70
            java.util.LinkedHashMap<K, V> r3 = r4.f243a     // Catch: java.lang.Throwable -> L70
            r3.remove(r1)     // Catch: java.lang.Throwable -> L70
            int r3 = r4.f244b     // Catch: java.lang.Throwable -> L70
            r4.e(r1, r2)     // Catch: java.lang.Throwable -> L70
            int r3 = r3 + (-1)
            r4.f244b = r3     // Catch: java.lang.Throwable -> L70
            int r3 = r4.f     // Catch: java.lang.Throwable -> L70
            int r3 = r3 + 1
            r4.f = r3     // Catch: java.lang.Throwable -> L70
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L70
            r4.b()
            goto L0
        L4f:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L70
            return
        L51:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L70
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
            r1.<init>()     // Catch: java.lang.Throwable -> L70
            java.lang.Class r2 = r4.getClass()     // Catch: java.lang.Throwable -> L70
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L70
            r1.append(r2)     // Catch: java.lang.Throwable -> L70
            java.lang.String r2 = ".sizeOf() is reporting inconsistent results!"
            r1.append(r2)     // Catch: java.lang.Throwable -> L70
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L70
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L70
            throw r0     // Catch: java.lang.Throwable -> L70
        L70:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L70
            goto L74
        L73:
            throw r0
        L74:
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.e.g(int):void");
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.e != androidx.collection.LruCache<K, V> */
    public void b() {
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.e != androidx.collection.LruCache<K, V> */
    public Object a() {
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.e != androidx.collection.LruCache<K, V> */
    public final int e(K key, V value) {
        f();
        if (1 >= 0) {
            return 1;
        }
        throw new IllegalStateException("Negative size: " + key + "=" + value);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.e != androidx.collection.LruCache<K, V> */
    public int f() {
        return 1;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.e != androidx.collection.LruCache<K, V> */
    public final synchronized String toString() {
        int hitPercent;
        int i = this.g;
        int accesses = this.h + i;
        hitPercent = accesses != 0 ? (i * 100) / accesses : 0;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(hitPercent));
    }
}
