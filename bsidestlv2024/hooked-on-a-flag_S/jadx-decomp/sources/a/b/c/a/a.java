package a.b.c.a;

import a.b.g.n0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f56a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Context, SparseArray<C0003a>> f57b = new WeakHashMap<>(0);
    public static final Object c = new Object();

    public static ColorStateList c(Context context, int resId) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(resId);
        }
        ColorStateList csl = b(context, resId);
        if (csl != null) {
            return csl;
        }
        ColorStateList csl2 = f(context, resId);
        if (csl2 != null) {
            a(context, resId, csl2);
            return csl2;
        }
        return a.h.c.a.c(context, resId);
    }

    public static Drawable d(Context context, int resId) {
        return n0.h().j(context, resId);
    }

    public static ColorStateList f(Context context, int resId) {
        if (g(context, resId)) {
            return null;
        }
        Resources r = context.getResources();
        XmlPullParser xml = r.getXml(resId);
        try {
            return a.h.c.c.a.a(r, xml, context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    public static ColorStateList b(Context context, int resId) {
        C0003a entry;
        synchronized (c) {
            SparseArray<C0003a> sparseArray = f57b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (entry = sparseArray.get(resId)) != null) {
                if (entry.f59b.equals(context.getResources().getConfiguration())) {
                    return entry.f58a;
                }
                sparseArray.remove(resId);
            }
            return null;
        }
    }

    public static void a(Context context, int resId, ColorStateList value) {
        synchronized (c) {
            WeakHashMap<Context, SparseArray<C0003a>> weakHashMap = f57b;
            SparseArray<C0003a> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(resId, new C0003a(value, context.getResources().getConfiguration()));
        }
    }

    public static boolean g(Context context, int resId) {
        Resources r = context.getResources();
        TypedValue value = e();
        r.getValue(resId, value, true);
        int i = value.type;
        return i >= 28 && i <= 31;
    }

    public static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = f56a;
        TypedValue tv = threadLocal.get();
        if (tv == null) {
            TypedValue tv2 = new TypedValue();
            threadLocal.set(tv2);
            return tv2;
        }
        return tv;
    }

    /* renamed from: a.b.c.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a {

        /* renamed from: a, reason: collision with root package name */
        public final ColorStateList f58a;

        /* renamed from: b, reason: collision with root package name */
        public final Configuration f59b;

        public C0003a(ColorStateList value, Configuration configuration) {
            this.f58a = value;
            this.f59b = configuration;
        }
    }
}
