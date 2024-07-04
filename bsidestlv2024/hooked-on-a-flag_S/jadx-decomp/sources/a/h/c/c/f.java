package a.h.c.c;

import a.h.j.i;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class f {
    public static Drawable b(Resources res, int id, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            return res.getDrawable(id, theme);
        }
        return res.getDrawable(id);
    }

    public static Typeface c(Context context, int id) {
        if (context.isRestricted()) {
            return null;
        }
        return f(context, id, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface a(Context context, int id) {
        if (context.isRestricted()) {
            return null;
        }
        return f(context, id, new TypedValue(), 0, null, null, false, true);
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void d(int i);

        public abstract void e(Typeface typeface);

        /* renamed from: a.h.c.c.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0020a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Typeface f359b;

            public RunnableC0020a(Typeface typeface) {
                this.f359b = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.e(this.f359b);
            }
        }

        public final void b(Typeface typeface, Handler handler) {
            c(handler).post(new RunnableC0020a(typeface));
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f360b;

            public b(int i) {
                this.f360b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.d(this.f360b);
            }
        }

        public final void a(int reason, Handler handler) {
            c(handler).post(new b(reason));
        }

        public static Handler c(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }
    }

    public static void e(Context context, int id, a fontCallback, Handler handler) {
        i.e(fontCallback);
        if (context.isRestricted()) {
            fontCallback.a(-4, handler);
        } else {
            f(context, id, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    public static Typeface d(Context context, int id, TypedValue value, int style, a fontCallback) {
        if (context.isRestricted()) {
            return null;
        }
        return f(context, id, value, style, fontCallback, null, true, false);
    }

    public static Typeface f(Context context, int id, TypedValue value, int style, a fontCallback, Handler handler, boolean isRequestFromLayoutInflator, boolean isCachedOnly) {
        Resources resources = context.getResources();
        resources.getValue(id, value, true);
        Typeface typeface = g(context, resources, value, id, style, fontCallback, handler, isRequestFromLayoutInflator, isCachedOnly);
        if (typeface == null && fontCallback == null && !isCachedOnly) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(id) + " could not be retrieved.");
        }
        return typeface;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface g(android.content.Context r19, android.content.res.Resources r20, android.util.TypedValue r21, int r22, int r23, a.h.c.c.f.a r24, android.os.Handler r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.h.c.c.f.g(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, a.h.c.c.f$a, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static void a(Resources.Theme theme) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                C0021b.a(theme);
            } else if (i >= 23) {
                a.a(theme);
            }
        }

        /* renamed from: a.h.c.c.f$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0021b {
            public static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final Object f361a = new Object();

            /* renamed from: b, reason: collision with root package name */
            public static Method f362b;
            public static boolean c;

            public static void a(Resources.Theme theme) {
                synchronized (f361a) {
                    if (!c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f362b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                        }
                        c = true;
                    }
                    Method method = f362b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                            f362b = null;
                        }
                    }
                }
            }
        }
    }
}
