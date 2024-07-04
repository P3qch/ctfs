package a.m;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public final a f629a;

    /* renamed from: b, reason: collision with root package name */
    public final s f630b;

    /* loaded from: classes.dex */
    public interface a {
        <T extends q> T a(Class<T> cls);
    }

    /* loaded from: classes.dex */
    public static class c {
        public void b() {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b extends c implements a {
        public abstract <T extends q> T c(String str, Class<T> cls);

        @Override // a.m.r.a
        public <T extends q> T a(Class<T> modelClass) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }
    }

    public r(s store, a factory) {
        this.f629a = factory;
        this.f630b = store;
    }

    public <T extends q> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public <T extends q> T b(String str, Class<T> cls) {
        T t;
        T t2 = (T) this.f630b.b(str);
        if (cls.isInstance(t2)) {
            Object obj = this.f629a;
            if (obj instanceof c) {
                ((c) obj).b();
            }
            return t2;
        }
        a aVar = this.f629a;
        if (aVar instanceof b) {
            t = (T) ((b) aVar).c(str, cls);
        } else {
            t = (T) aVar.a(cls);
        }
        this.f630b.d(str, t);
        return t;
    }
}
