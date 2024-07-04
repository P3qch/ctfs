package a.u;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final a.e.a<String, Method> f766a;

    /* renamed from: b, reason: collision with root package name */
    public final a.e.a<String, Method> f767b;
    public final a.e.a<String, Class> c;

    public abstract void A(byte[] bArr);

    public abstract void C(CharSequence charSequence);

    public abstract void E(int i);

    public abstract void G(Parcelable parcelable);

    public abstract void I(String str);

    public abstract void a();

    public abstract a b();

    public abstract boolean g();

    public abstract byte[] i();

    public abstract CharSequence k();

    public abstract boolean m(int i);

    public abstract int o();

    public abstract <T extends Parcelable> T q();

    public abstract String s();

    public abstract void w(int i);

    public abstract void y(boolean z);

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.Class> */
    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> */
    public a(a.e.a<String, Method> aVar, a.e.a<String, Method> aVar2, a.e.a<String, Class> aVar3) {
        this.f766a = aVar;
        this.f767b = aVar2;
        this.c = aVar3;
    }

    public boolean f() {
        return false;
    }

    public void x() {
    }

    public void z(boolean val, int fieldId) {
        w(fieldId);
        y(val);
    }

    public void B(byte[] b2, int fieldId) {
        w(fieldId);
        A(b2);
    }

    public void D(CharSequence val, int fieldId) {
        w(fieldId);
        C(val);
    }

    public void F(int val, int fieldId) {
        w(fieldId);
        E(val);
    }

    public void J(String val, int fieldId) {
        w(fieldId);
        I(val);
    }

    public void H(Parcelable p, int fieldId) {
        w(fieldId);
        G(p);
    }

    public boolean h(boolean def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return g();
    }

    public int p(int def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return o();
    }

    public String t(String def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return s();
    }

    public byte[] j(byte[] def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return i();
    }

    public <T extends Parcelable> T r(T t, int i) {
        if (!m(i)) {
            return t;
        }
        return (T) q();
    }

    public CharSequence l(CharSequence def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return k();
    }

    public void M(c p, int fieldId) {
        w(fieldId);
        L(p);
    }

    public void L(c p) {
        if (p == null) {
            I(null);
            return;
        }
        N(p);
        a subParcel = b();
        K(p, subParcel);
        subParcel.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(c p) {
        try {
            Class name = c(p.getClass());
            I(name.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(p.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    public <T extends c> T v(T t, int i) {
        if (!m(i)) {
            return t;
        }
        return (T) u();
    }

    public <T extends c> T u() {
        String s = s();
        if (s == null) {
            return null;
        }
        return (T) n(s, b());
    }

    public <T extends c> T n(String parcelCls, a versionedParcel) {
        try {
            Method m = d(parcelCls);
            return (T) m.invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public <T extends c> void K(T val, a versionedParcel) {
        try {
            Method m = e(val.getClass());
            m.invoke(null, val, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public final Method d(String parcelCls) {
        Method m = this.f766a.get(parcelCls);
        if (m == null) {
            System.currentTimeMillis();
            Class cls = Class.forName(parcelCls, true, a.class.getClassLoader());
            Method m2 = cls.getDeclaredMethod("read", a.class);
            this.f766a.put(parcelCls, m2);
            return m2;
        }
        return m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method e(Class baseCls) {
        Method m = this.f767b.get(baseCls.getName());
        if (m == null) {
            Class c = c(baseCls);
            System.currentTimeMillis();
            Method m2 = c.getDeclaredMethod("write", baseCls, a.class);
            this.f767b.put(baseCls.getName(), m2);
            return m2;
        }
        return m;
    }

    public final Class c(Class<? extends c> cls) {
        Class ret = this.c.get(cls.getName());
        if (ret == null) {
            String pkg = cls.getPackage().getName();
            String c = String.format("%s.%sParcelizer", pkg, cls.getSimpleName());
            Class ret2 = Class.forName(c, false, cls.getClassLoader());
            this.c.put(cls.getName(), ret2);
            return ret2;
        }
        return ret;
    }
}
