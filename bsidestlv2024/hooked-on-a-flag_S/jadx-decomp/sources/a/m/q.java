package a.m;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f628a = new HashMap();

    public void d() {
    }

    public final void a() {
        Map<String, Object> map = this.f628a;
        if (map != null) {
            synchronized (map) {
                for (Object value : this.f628a.values()) {
                    b(value);
                }
            }
        }
        d();
    }

    public <T> T c(String str) {
        T t;
        Map<String, Object> map = this.f628a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.f628a.get(str);
        }
        return t;
    }

    public static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
