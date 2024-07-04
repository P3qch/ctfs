package a.m;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static Map<Class<?>, Integer> f625a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map<Class<?>, List<Constructor<? extends c>>> f626b = new HashMap();

    public static e f(Object object) {
        boolean isLifecycleEventObserver = object instanceof e;
        boolean isFullLifecycleObserver = object instanceof b;
        if (isLifecycleEventObserver && isFullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((b) object, (e) object);
        }
        if (isFullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((b) object, null);
        }
        if (isLifecycleEventObserver) {
            return (e) object;
        }
        Class<?> klass = object.getClass();
        int type = d(klass);
        if (type == 2) {
            List<Constructor<? extends c>> list = f626b.get(klass);
            if (list.size() == 1) {
                c generatedAdapter = a(list.get(0), object);
                return new SingleGeneratedAdapterObserver(generatedAdapter);
            }
            c[] adapters = new c[list.size()];
            for (int i = 0; i < list.size(); i++) {
                adapters[i] = a(list.get(i), object);
            }
            return new CompositeGeneratedAdaptersObserver(adapters);
        }
        return new ReflectiveGenericLifecycleObserver(object);
    }

    public static c a(Constructor<? extends c> constructor, Object object) {
        try {
            return constructor.newInstance(object);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static Constructor<? extends c> b(Class<?> klass) {
        String str;
        try {
            Package aPackage = klass.getPackage();
            String name = klass.getCanonicalName();
            String fullPackage = aPackage != null ? aPackage.getName() : BuildConfig.FLAVOR;
            String adapterName = c(fullPackage.isEmpty() ? name : name.substring(fullPackage.length() + 1));
            if (fullPackage.isEmpty()) {
                str = adapterName;
            } else {
                str = fullPackage + "." + adapterName;
            }
            Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(klass);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static int d(Class<?> klass) {
        Integer callbackCache = f625a.get(klass);
        if (callbackCache != null) {
            return callbackCache.intValue();
        }
        int type = g(klass);
        f625a.put(klass, Integer.valueOf(type));
        return type;
    }

    public static int g(Class<?> klass) {
        if (klass.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends c> b2 = b(klass);
        if (b2 != null) {
            f626b.put(klass, Collections.singletonList(b2));
            return 2;
        }
        boolean hasLifecycleMethods = a.f614a.d(klass);
        if (hasLifecycleMethods) {
            return 1;
        }
        Class<?> superclass = klass.getSuperclass();
        List<Constructor<? extends GeneratedAdapter>> adapterConstructors = null;
        if (e(superclass)) {
            if (d(superclass) == 1) {
                return 1;
            }
            adapterConstructors = new ArrayList<>(f626b.get(superclass));
        }
        for (Class<?> intrface : klass.getInterfaces()) {
            if (e(intrface)) {
                if (d(intrface) == 1) {
                    return 1;
                }
                if (adapterConstructors == null) {
                    adapterConstructors = new ArrayList<>();
                }
                adapterConstructors.addAll(f626b.get(intrface));
            }
        }
        if (adapterConstructors == null) {
            return 1;
        }
        f626b.put(klass, adapterConstructors);
        return 2;
    }

    public static boolean e(Class<?> klass) {
        return klass != null && f.class.isAssignableFrom(klass);
    }

    public static String c(String className) {
        return className.replace(".", "_") + "_LifecycleAdapter";
    }
}
