package a.m;

import a.m.d;
import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f614a = new a();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, C0044a> f615b = new HashMap();
    public final Map<Class<?>, Boolean> c = new HashMap();

    public boolean d(Class<?> klass) {
        Boolean hasLifecycleMethods = this.c.get(klass);
        if (hasLifecycleMethods != null) {
            return hasLifecycleMethods.booleanValue();
        }
        Method[] methods = b(klass);
        for (Method method : methods) {
            n annotation = (n) method.getAnnotation(n.class);
            if (annotation != null) {
                a(klass, methods);
                return true;
            }
        }
        this.c.put(klass, false);
        return false;
    }

    public final Method[] b(Class<?> klass) {
        try {
            return klass.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    public C0044a c(Class<?> klass) {
        C0044a existing = this.f615b.get(klass);
        if (existing != null) {
            return existing;
        }
        return a(klass, null);
    }

    public final void e(Map<b, d.a> map, b newHandler, d.a newEvent, Class<?> klass) {
        d.a event = map.get(newHandler);
        if (event != null && newEvent != event) {
            Method method = newHandler.f619b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + klass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event + ", new value " + newEvent);
        }
        if (event == null) {
            map.put(newHandler, newEvent);
        }
    }

    public final C0044a a(Class<?> klass, Method[] declaredMethods) {
        C0044a superInfo;
        Class<?> superclass = klass.getSuperclass();
        Map<ClassesInfoCache.MethodReference, Lifecycle.Event> handlerToEvent = new HashMap<>();
        if (superclass != null && (superInfo = c(superclass)) != null) {
            handlerToEvent.putAll(superInfo.f617b);
        }
        Class<?>[] interfaces = klass.getInterfaces();
        char c = 0;
        for (Class<?> intrfc : interfaces) {
            for (Map.Entry<b, d.a> entry : c(intrfc).f617b.entrySet()) {
                e(handlerToEvent, entry.getKey(), entry.getValue(), klass);
            }
        }
        Method[] methods = declaredMethods != null ? declaredMethods : b(klass);
        boolean hasLifecycleMethods = false;
        int length = methods.length;
        int i = 0;
        while (i < length) {
            Method method = methods[i];
            n annotation = (n) method.getAnnotation(n.class);
            if (annotation != null) {
                hasLifecycleMethods = true;
                Class<?>[] params = method.getParameterTypes();
                int callType = 0;
                if (params.length > 0) {
                    callType = 1;
                    if (!params[c].isAssignableFrom(g.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                }
                d.a event = annotation.value();
                if (params.length > 1) {
                    callType = 2;
                    if (!params[1].isAssignableFrom(d.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (event != d.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (params.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b methodReference = new b(callType, method);
                e(handlerToEvent, methodReference, event, klass);
            }
            i++;
            c = 0;
        }
        C0044a info = new C0044a(handlerToEvent);
        this.f615b.put(klass, info);
        this.c.put(klass, Boolean.valueOf(hasLifecycleMethods));
        return info;
    }

    /* renamed from: a.m.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0044a {

        /* renamed from: a, reason: collision with root package name */
        public final Map<d.a, List<b>> f616a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map<b, d.a> f617b;

        public C0044a(Map<b, d.a> map) {
            this.f617b = map;
            for (Map.Entry<b, d.a> entry : map.entrySet()) {
                d.a event = entry.getValue();
                List<b> list = this.f616a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f616a.put(event, list);
                }
                list.add(entry.getKey());
            }
        }

        public void a(g source, d.a event, Object target) {
            b(this.f616a.get(event), source, event, target);
            b(this.f616a.get(d.a.ON_ANY), source, event, target);
        }

        public static void b(List<b> list, g source, d.a event, Object mWrapped) {
            if (list != null) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    list.get(i).a(source, event, mWrapped);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f618a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f619b;

        public b(int callType, Method method) {
            this.f618a = callType;
            this.f619b = method;
            method.setAccessible(true);
        }

        public void a(g source, d.a event, Object target) {
            try {
                switch (this.f618a) {
                    case 0:
                        this.f619b.invoke(target, new Object[0]);
                        return;
                    case 1:
                        this.f619b.invoke(target, source);
                        return;
                    case 2:
                        this.f619b.invoke(target, source, event);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof b)) {
                return false;
            }
            b that = (b) o;
            return this.f618a == that.f618a && this.f619b.getName().equals(that.f619b.getName());
        }

        public int hashCode() {
            return (this.f618a * 31) + this.f619b.getName().hashCode();
        }
    }
}
