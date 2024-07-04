package a.r;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f692a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f693b;

    @SuppressLint({"NewApi"})
    public static boolean d() {
        try {
            if (f693b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError e) {
        } catch (NoSuchMethodError e2) {
        }
        return e();
    }

    public static void a(String label) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(label);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.b();
        }
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f693b == null) {
                    Field traceTagAppField = Trace.class.getField("TRACE_TAG_APP");
                    f692a = traceTagAppField.getLong(null);
                    f693b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) f693b.invoke(null, Long.valueOf(f692a))).booleanValue();
            } catch (Exception exception) {
                c("isTagEnabled", exception);
            }
        }
        return false;
    }

    public static void c(String methodName, Exception exception) {
        if (exception instanceof InvocationTargetException) {
            Throwable cause = exception.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + methodName + " via reflection", exception);
    }
}
