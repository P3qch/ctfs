package a.h.b;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f340a;

    /* renamed from: b, reason: collision with root package name */
    public static final Field f341b;
    public static final Field c;
    public static final Method d;
    public static final Method e;
    public static final Method f;
    public static final Handler g = new Handler(Looper.getMainLooper());

    static {
        Class<?> a2 = a();
        f340a = a2;
        f341b = b();
        c = f();
        d = d(a2);
        e = c(a2);
        f = e(a2);
    }

    public static boolean i(Activity activity) {
        Object activityThread;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f == null) {
            return false;
        }
        if (e == null && d == null) {
            return false;
        }
        try {
            Object token = c.get(activity);
            if (token == null || (activityThread = f341b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d callbacks = new d(activity);
            application.registerActivityLifecycleCallbacks(callbacks);
            Handler handler = g;
            handler.post(new a(callbacks, token));
            try {
                if (g()) {
                    f.invoke(activityThread, token, null, null, 0, false, null, null, false, false);
                } else {
                    activity.recreate();
                }
                handler.post(new RunnableC0018b(application, callbacks));
                return true;
            } catch (Throwable th) {
                g.post(new RunnableC0018b(application, callbacks));
                throw th;
            }
        } catch (Throwable th2) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f342b;
        public final /* synthetic */ Object c;

        public a(d dVar, Object obj) {
            this.f342b = dVar;
            this.c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f342b.f345a = this.c;
        }
    }

    /* renamed from: a.h.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0018b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Application f343b;
        public final /* synthetic */ d c;

        public RunnableC0018b(Application application, d dVar) {
            this.f343b = application;
            this.c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f343b.unregisterActivityLifecycleCallbacks(this.c);
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public Object f345a;

        /* renamed from: b, reason: collision with root package name */
        public Activity f346b;
        public final int c;
        public boolean d = false;
        public boolean e = false;
        public boolean f = false;

        public d(Activity aboutToRecreate) {
            this.f346b = aboutToRecreate;
            this.c = aboutToRecreate.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f346b == activity) {
                this.d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (this.e && !this.f && !this.d && b.h(this.f345a, this.c, activity)) {
                this.f = true;
                this.f345a = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f346b == activity) {
                this.f346b = null;
                this.e = true;
            }
        }
    }

    public static boolean h(Object currentlyRecreatingToken, int currentlyRecreatingHashCode, Activity activity) {
        try {
            Object token = c.get(activity);
            if (token == currentlyRecreatingToken && activity.hashCode() == currentlyRecreatingHashCode) {
                Object activityThread = f341b.get(activity);
                g.postAtFrontOfQueue(new c(activityThread, token));
                return true;
            }
            return false;
        } catch (Throwable t) {
            Log.e("ActivityRecreator", "Exception while fetching field values", t);
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f344b;
        public final /* synthetic */ Object c;

        public c(Object obj, Object obj2) {
            this.f344b = obj;
            this.c = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = b.d;
                if (method != null) {
                    method.invoke(this.f344b, this.c, false, "AppCompat recreation");
                } else {
                    b.e.invoke(this.f344b, this.c, false);
                }
            } catch (RuntimeException e) {
                if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                    throw e;
                }
            } catch (Throwable t) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", t);
            }
        }
    }

    public static Method d(Class<?> activityThreadClass) {
        if (activityThreadClass == null) {
            return null;
        }
        try {
            Method performStop = activityThreadClass.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            performStop.setAccessible(true);
            return performStop;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Method c(Class<?> activityThreadClass) {
        if (activityThreadClass == null) {
            return null;
        }
        try {
            Method performStop = activityThreadClass.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            performStop.setAccessible(true);
            return performStop;
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean g() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    public static Method e(Class<?> activityThreadClass) {
        if (!g() || activityThreadClass == null) {
            return null;
        }
        try {
            Class<?> cls = Boolean.TYPE;
            Method relaunch = activityThreadClass.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls, Configuration.class, Configuration.class, cls, cls);
            relaunch.setAccessible(true);
            return relaunch;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Field b() {
        try {
            Field mainThreadField = Activity.class.getDeclaredField("mMainThread");
            mainThreadField.setAccessible(true);
            return mainThreadField;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Field f() {
        try {
            Field tokenField = Activity.class.getDeclaredField("mToken");
            tokenField.setAccessible(true);
            return tokenField;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable th) {
            return null;
        }
    }
}
