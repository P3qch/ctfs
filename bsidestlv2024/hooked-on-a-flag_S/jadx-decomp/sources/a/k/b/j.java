package a.k.b;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final a.e.g<ClassLoader, a.e.g<String, Class<?>>> f559a = new a.e.g<>();

    public Fragment a(ClassLoader classLoader, String str) {
        throw null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.g != androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Class<?>> */
    public static Class<?> c(ClassLoader classLoader, String className) {
        a.e.g<ClassLoader, a.e.g<String, Class<?>>> gVar = f559a;
        a.e.g<String, Class<?>> gVar2 = gVar.get(classLoader);
        if (gVar2 == null) {
            gVar2 = new a.e.g<>();
            gVar.put(classLoader, gVar2);
        }
        Class<?> clazz = gVar2.get(className);
        if (clazz == null) {
            Class<?> clazz2 = Class.forName(className, false, classLoader);
            gVar2.put(className, clazz2);
            return clazz2;
        }
        return clazz;
    }

    public static boolean b(ClassLoader classLoader, String className) {
        try {
            Class<?> clazz = c(classLoader, className);
            return Fragment.class.isAssignableFrom(clazz);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static Class<? extends Fragment> d(ClassLoader classLoader, String className) {
        try {
            return c(classLoader, className);
        } catch (ClassCastException e) {
            throw new Fragment.f("Unable to instantiate fragment " + className + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.f("Unable to instantiate fragment " + className + ": make sure class name exists", e2);
        }
    }
}
