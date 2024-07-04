package a.s;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f744a;

    /* renamed from: b, reason: collision with root package name */
    public static final Property<View, Float> f745b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f744a = new d0();
        } else if (i >= 23) {
            f744a = new c0();
        } else if (i >= 22) {
            f744a = new b0();
        } else if (i >= 21) {
            f744a = new a0();
        } else if (i >= 19) {
            f744a = new z();
        } else {
            f744a = new e0();
        }
        f745b = new a(Float.class, "translationAlpha");
        new b(Rect.class, "clipBounds");
    }

    /* loaded from: classes.dex */
    public static class a extends Property<View, Float> {
        public a(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(y.b(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float alpha) {
            y.f(view, alpha.floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Property<View, Rect> {
        public b(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return a.h.k.v.u(view);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect clipBounds) {
            a.h.k.v.u0(view, clipBounds);
        }
    }

    public static j0 c(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new i0(view);
        }
        return new h0(view.getWindowToken());
    }

    public static void f(View view, float alpha) {
        f744a.f(view, alpha);
    }

    public static float b(View view) {
        return f744a.c(view);
    }

    public static void d(View view) {
        f744a.d(view);
    }

    public static void a(View view) {
        f744a.a(view);
    }

    public static void g(View view, int visibility) {
        f744a.g(view, visibility);
    }

    public static void h(View view, Matrix matrix) {
        f744a.h(view, matrix);
    }

    public static void i(View view, Matrix matrix) {
        f744a.i(view, matrix);
    }

    public static void e(View v, int left, int top, int right, int bottom) {
        f744a.e(v, left, top, right, bottom);
    }
}
