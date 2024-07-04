package a.h.i;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static Method f414a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f415b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            try {
                Class<?> clazz = Class.forName("libcore.icu.ICU");
                f414a = clazz.getMethod("getScript", String.class);
                f415b = clazz.getMethod("addLikelySubtags", String.class);
                return;
            } catch (Exception e) {
                f414a = null;
                f415b = null;
                Log.w("ICUCompat", e);
                return;
            }
        }
        if (i < 24) {
            try {
                f415b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public static String c(Locale locale) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            ULocale uLocale = ULocale.addLikelySubtags(ULocale.forLocale(locale));
            return uLocale.getScript();
        }
        if (i >= 21) {
            try {
                Object[] args = {locale};
                return ((Locale) f415b.invoke(null, args)).getScript();
            } catch (IllegalAccessException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (InvocationTargetException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        }
        String localeWithSubtags = a(locale);
        if (localeWithSubtags != null) {
            return b(localeWithSubtags);
        }
        return null;
    }

    public static String b(String localeStr) {
        try {
            Method method = f414a;
            if (method != null) {
                Object[] args = {localeStr};
                return (String) method.invoke(null, args);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }

    public static String a(Locale locale) {
        String localeStr = locale.toString();
        try {
            Method method = f415b;
            if (method != null) {
                Object[] args = {localeStr};
                return (String) method.invoke(null, args);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return localeStr;
    }
}
