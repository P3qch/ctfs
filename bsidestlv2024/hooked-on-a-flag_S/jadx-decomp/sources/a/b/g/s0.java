package a.b.g;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes.dex */
public class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f191a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f192b = {-16842910};
    public static final int[] c = {R.attr.state_focused};
    public static final int[] d;
    public static final int[] e;
    public static final int[] f;
    public static final int[] g;

    static {
        new int[1][0] = 16843518;
        d = new int[]{R.attr.state_pressed};
        e = new int[]{R.attr.state_checked};
        new int[1][0] = 16842913;
        int[] iArr = {-16842919, -16842908};
        f = new int[0];
        g = new int[1];
    }

    public static int c(Context context, int attr) {
        int[] iArr = g;
        iArr[0] = attr;
        x0 a2 = x0.u(context, null, iArr);
        try {
            return a2.b(0, 0);
        } finally {
            a2.w();
        }
    }

    public static ColorStateList e(Context context, int attr) {
        int[] iArr = g;
        iArr[0] = attr;
        x0 a2 = x0.u(context, null, iArr);
        try {
            return a2.c(0);
        } finally {
            a2.w();
        }
    }

    public static int b(Context context, int attr) {
        ColorStateList csl = e(context, attr);
        if (csl != null && csl.isStateful()) {
            return csl.getColorForState(f192b, csl.getDefaultColor());
        }
        TypedValue tv = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, tv, true);
        float disabledAlpha = tv.getFloat();
        return d(context, attr, disabledAlpha);
    }

    public static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f191a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    public static int d(Context context, int attr, float alpha) {
        int color = c(context, attr);
        int originalAlpha = Color.alpha(color);
        return a.h.d.a.d(color, Math.round(originalAlpha * alpha));
    }

    public static void a(View view, Context context) {
        TypedArray a2 = context.obtainStyledAttributes(a.b.a.j);
        try {
            int[] iArr = a.b.a.f11a;
            if (!a2.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            a2.recycle();
        }
    }
}
