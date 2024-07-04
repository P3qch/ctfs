package a.h.k;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final d0 f440a;

    /* renamed from: b, reason: collision with root package name */
    public final l f441b;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f440a = k.o;
        } else {
            f440a = l.f448a;
        }
    }

    public d0(WindowInsets insets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f441b = new k(this, insets);
            return;
        }
        if (i2 >= 29) {
            this.f441b = new j(this, insets);
            return;
        }
        if (i2 >= 28) {
            this.f441b = new i(this, insets);
            return;
        }
        if (i2 >= 21) {
            this.f441b = new h(this, insets);
        } else if (i2 >= 20) {
            this.f441b = new g(this, insets);
        } else {
            this.f441b = new l(this);
        }
    }

    public d0(d0 src) {
        if (src != null) {
            l srcImpl = src.f441b;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (srcImpl instanceof k)) {
                this.f441b = new k(this, (k) srcImpl);
            } else if (i2 >= 29 && (srcImpl instanceof j)) {
                this.f441b = new j(this, (j) srcImpl);
            } else if (i2 >= 28 && (srcImpl instanceof i)) {
                this.f441b = new i(this, (i) srcImpl);
            } else if (i2 >= 21 && (srcImpl instanceof h)) {
                this.f441b = new h(this, (h) srcImpl);
            } else if (i2 >= 20 && (srcImpl instanceof g)) {
                this.f441b = new g(this, (g) srcImpl);
            } else {
                this.f441b = new l(this);
            }
            srcImpl.e(this);
            return;
        }
        this.f441b = new l(this);
    }

    public static d0 s(WindowInsets insets) {
        return t(insets, null);
    }

    public static d0 t(WindowInsets insets, View view) {
        a.h.j.i.e(insets);
        d0 wic = new d0(insets);
        if (view != null && view.isAttachedToWindow()) {
            wic.p(v.J(view));
            wic.d(view.getRootView());
        }
        return wic;
    }

    @Deprecated
    public int g() {
        return this.f441b.i().f364b;
    }

    @Deprecated
    public int i() {
        return this.f441b.i().c;
    }

    @Deprecated
    public int h() {
        return this.f441b.i().d;
    }

    @Deprecated
    public int f() {
        return this.f441b.i().e;
    }

    public boolean l() {
        return this.f441b.k();
    }

    @Deprecated
    public d0 c() {
        return this.f441b.c();
    }

    @Deprecated
    public d0 m(int left, int top, int right, int bottom) {
        b bVar = new b(this);
        bVar.c(a.h.d.b.a(left, top, right, bottom));
        return bVar.a();
    }

    @Deprecated
    public d0 b() {
        return this.f441b.b();
    }

    @Deprecated
    public d0 a() {
        return this.f441b.a();
    }

    @Deprecated
    public a.h.d.b e() {
        return this.f441b.g();
    }

    public d0 j(int left, int top, int right, int bottom) {
        return this.f441b.j(left, top, right, bottom);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof d0)) {
            return false;
        }
        d0 other = (d0) o;
        return a.h.j.d.a(this.f441b, other.f441b);
    }

    public int hashCode() {
        l lVar = this.f441b;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public WindowInsets r() {
        l lVar = this.f441b;
        if (lVar instanceof g) {
            return ((g) lVar).i;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public static final d0 f448a = new b().a().a().b().c();

        /* renamed from: b, reason: collision with root package name */
        public final d0 f449b;

        public l(d0 host) {
            this.f449b = host;
        }

        public boolean l() {
            return false;
        }

        public boolean k() {
            return false;
        }

        public d0 c() {
            return this.f449b;
        }

        public d0 b() {
            return this.f449b;
        }

        public a.h.k.d f() {
            return null;
        }

        public d0 a() {
            return this.f449b;
        }

        public a.h.d.b i() {
            return a.h.d.b.f363a;
        }

        public a.h.d.b h() {
            return a.h.d.b.f363a;
        }

        public a.h.d.b g() {
            return i();
        }

        public d0 j(int left, int top, int right, int bottom) {
            return f448a;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof l)) {
                return false;
            }
            l impl = (l) o;
            return l() == impl.l() && k() == impl.k() && a.h.j.d.a(i(), impl.i()) && a.h.j.d.a(h(), impl.h()) && a.h.j.d.a(f(), impl.f());
        }

        public int hashCode() {
            return a.h.j.d.b(Boolean.valueOf(l()), Boolean.valueOf(k()), i(), h(), f());
        }

        public void o(d0 rootWindowInsets) {
        }

        public void n(a.h.d.b visibleInsets) {
        }

        public void d(View rootView) {
        }

        public void e(d0 other) {
        }

        public void m(a.h.d.b[] insetsTypeMask) {
        }

        public void p(a.h.d.b stableInsets) {
        }
    }

    /* loaded from: classes.dex */
    public static class g extends l {
        public static boolean c = false;
        public static Method d;
        public static Class<?> e;
        public static Class<?> f;
        public static Field g;
        public static Field h;
        public final WindowInsets i;
        public a.h.d.b j;
        public d0 k;
        public a.h.d.b l;

        public g(d0 host, WindowInsets insets) {
            super(host);
            this.j = null;
            this.i = insets;
        }

        public g(d0 host, g other) {
            this(host, new WindowInsets(other.i));
        }

        @Override // a.h.k.d0.l
        public boolean l() {
            return this.i.isRound();
        }

        @Override // a.h.k.d0.l
        public final a.h.d.b i() {
            if (this.j == null) {
                this.j = a.h.d.b.a(this.i.getSystemWindowInsetLeft(), this.i.getSystemWindowInsetTop(), this.i.getSystemWindowInsetRight(), this.i.getSystemWindowInsetBottom());
            }
            return this.j;
        }

        @Override // a.h.k.d0.l
        public d0 j(int left, int top, int right, int bottom) {
            b b2 = new b(d0.s(this.i));
            b2.c(d0.k(i(), left, top, right, bottom));
            b2.b(d0.k(h(), left, top, right, bottom));
            return b2.a();
        }

        @Override // a.h.k.d0.l
        public void e(d0 other) {
            other.p(this.k);
            other.o(this.l);
        }

        @Override // a.h.k.d0.l
        public void o(d0 rootWindowInsets) {
            this.k = rootWindowInsets;
        }

        @Override // a.h.k.d0.l
        public void n(a.h.d.b visibleInsets) {
            this.l = visibleInsets;
        }

        @Override // a.h.k.d0.l
        public void d(View rootView) {
            a.h.d.b visibleInsets = q(rootView);
            if (visibleInsets == null) {
                visibleInsets = a.h.d.b.f363a;
            }
            n(visibleInsets);
        }

        public final a.h.d.b q(View rootView) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!c) {
                r();
            }
            Method method = d;
            if (method == null || f == null || g == null) {
                return null;
            }
            try {
                Object viewRootImpl = method.invoke(rootView, new Object[0]);
                if (viewRootImpl == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Object mAttachInfo = h.get(viewRootImpl);
                Rect visibleRect = (Rect) g.get(mAttachInfo);
                if (visibleRect != null) {
                    return a.h.d.b.b(visibleRect);
                }
                return null;
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                return null;
            }
        }

        @Override // a.h.k.d0.l
        public void m(a.h.d.b[] insetsTypeMask) {
        }

        @SuppressLint({"PrivateApi"})
        public static void r() {
            try {
                d = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                e = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f = cls;
                g = cls.getDeclaredField("mVisibleInsets");
                h = e.getDeclaredField("mAttachInfo");
                g.setAccessible(true);
                h.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            c = true;
        }

        @Override // a.h.k.d0.l
        public boolean equals(Object o) {
            if (!super.equals(o)) {
                return false;
            }
            g impl20 = (g) o;
            return a.h.j.c.a(this.l, impl20.l);
        }
    }

    /* loaded from: classes.dex */
    public static class h extends g {
        public a.h.d.b m;

        public h(d0 host, WindowInsets insets) {
            super(host, insets);
            this.m = null;
        }

        public h(d0 host, h other) {
            super(host, other);
            this.m = null;
            this.m = other.m;
        }

        @Override // a.h.k.d0.l
        public boolean k() {
            return this.i.isConsumed();
        }

        @Override // a.h.k.d0.l
        public d0 b() {
            return d0.s(this.i.consumeStableInsets());
        }

        @Override // a.h.k.d0.l
        public d0 c() {
            return d0.s(this.i.consumeSystemWindowInsets());
        }

        @Override // a.h.k.d0.l
        public final a.h.d.b h() {
            if (this.m == null) {
                this.m = a.h.d.b.a(this.i.getStableInsetLeft(), this.i.getStableInsetTop(), this.i.getStableInsetRight(), this.i.getStableInsetBottom());
            }
            return this.m;
        }

        @Override // a.h.k.d0.l
        public void p(a.h.d.b stableInsets) {
            this.m = stableInsets;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        public i(d0 host, WindowInsets insets) {
            super(host, insets);
        }

        public i(d0 host, i other) {
            super(host, other);
        }

        @Override // a.h.k.d0.l
        public a.h.k.d f() {
            return a.h.k.d.a(this.i.getDisplayCutout());
        }

        @Override // a.h.k.d0.l
        public d0 a() {
            return d0.s(this.i.consumeDisplayCutout());
        }

        @Override // a.h.k.d0.g, a.h.k.d0.l
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof i)) {
                return false;
            }
            i otherImpl28 = (i) o;
            return a.h.j.c.a(this.i, otherImpl28.i) && a.h.j.c.a(this.l, otherImpl28.l);
        }

        @Override // a.h.k.d0.l
        public int hashCode() {
            return this.i.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static class j extends i {
        public a.h.d.b n;

        public j(d0 host, WindowInsets insets) {
            super(host, insets);
            this.n = null;
        }

        public j(d0 host, j other) {
            super(host, other);
            this.n = null;
        }

        @Override // a.h.k.d0.l
        public a.h.d.b g() {
            if (this.n == null) {
                this.n = a.h.d.b.c(this.i.getMandatorySystemGestureInsets());
            }
            return this.n;
        }

        @Override // a.h.k.d0.g, a.h.k.d0.l
        public d0 j(int left, int top, int right, int bottom) {
            return d0.s(this.i.inset(left, top, right, bottom));
        }

        @Override // a.h.k.d0.h, a.h.k.d0.l
        public void p(a.h.d.b stableInsets) {
        }
    }

    public static a.h.d.b k(a.h.d.b insets, int left, int top, int right, int bottom) {
        int newLeft = Math.max(0, insets.f364b - left);
        int newTop = Math.max(0, insets.c - top);
        int newRight = Math.max(0, insets.d - right);
        int newBottom = Math.max(0, insets.e - bottom);
        if (newLeft == left && newTop == top && newRight == right && newBottom == bottom) {
            return insets;
        }
        return a.h.d.b.a(newLeft, newTop, newRight, newBottom);
    }

    /* loaded from: classes.dex */
    public static class k extends j {
        public static final d0 o = d0.s(WindowInsets.CONSUMED);

        public k(d0 host, WindowInsets insets) {
            super(host, insets);
        }

        public k(d0 host, k other) {
            super(host, other);
        }

        @Override // a.h.k.d0.g, a.h.k.d0.l
        public final void d(View rootView) {
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final f f444a;

        public b() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.f444a = new e();
                return;
            }
            if (i >= 29) {
                this.f444a = new d();
            } else if (i >= 20) {
                this.f444a = new c();
            } else {
                this.f444a = new f();
            }
        }

        public b(d0 insets) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.f444a = new e(insets);
                return;
            }
            if (i >= 29) {
                this.f444a = new d(insets);
            } else if (i >= 20) {
                this.f444a = new c(insets);
            } else {
                this.f444a = new f(insets);
            }
        }

        @Deprecated
        public b c(a.h.d.b insets) {
            this.f444a.d(insets);
            return this;
        }

        @Deprecated
        public b b(a.h.d.b insets) {
            this.f444a.c(insets);
            return this;
        }

        public d0 a() {
            return this.f444a.b();
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final d0 f447a;

        public f() {
            this(new d0((d0) null));
        }

        public f(d0 insets) {
            this.f447a = insets;
        }

        public void d(a.h.d.b insets) {
        }

        public void c(a.h.d.b insets) {
        }

        public final void a() {
        }

        public d0 b() {
            a();
            return this.f447a;
        }
    }

    public void n(a.h.d.b[] insetsTypeMask) {
        this.f441b.m(insetsTypeMask);
    }

    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: b, reason: collision with root package name */
        public static Field f445b;
        public static Constructor<WindowInsets> d;
        public WindowInsets f;
        public a.h.d.b g;
        public static boolean c = false;
        public static boolean e = false;

        public c() {
            this.f = e();
        }

        public c(d0 insets) {
            this.f = insets.r();
        }

        @Override // a.h.k.d0.f
        public void d(a.h.d.b insets) {
            WindowInsets windowInsets = this.f;
            if (windowInsets != null) {
                this.f = windowInsets.replaceSystemWindowInsets(insets.f364b, insets.c, insets.d, insets.e);
            }
        }

        @Override // a.h.k.d0.f
        public void c(a.h.d.b insets) {
            this.g = insets;
        }

        @Override // a.h.k.d0.f
        public d0 b() {
            a();
            d0 windowInsetsCompat = d0.s(this.f);
            windowInsetsCompat.n(null);
            windowInsetsCompat.q(this.g);
            return windowInsetsCompat;
        }

        public static WindowInsets e() {
            if (!c) {
                try {
                    f445b = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                c = true;
            }
            Field field = f445b;
            if (field != null) {
                try {
                    WindowInsets consumed = (WindowInsets) field.get(null);
                    if (consumed != null) {
                        return new WindowInsets(consumed);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!e) {
                try {
                    d = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                e = true;
            }
            Constructor<WindowInsets> constructor = d;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }
    }

    public void q(a.h.d.b stableInsets) {
        this.f441b.p(stableInsets);
    }

    /* loaded from: classes.dex */
    public static class d extends f {

        /* renamed from: b, reason: collision with root package name */
        public final WindowInsets.Builder f446b;

        public d() {
            this.f446b = new WindowInsets.Builder();
        }

        public d(d0 insets) {
            WindowInsets.Builder builder;
            WindowInsets platInsets = insets.r();
            if (platInsets != null) {
                builder = new WindowInsets.Builder(platInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f446b = builder;
        }

        @Override // a.h.k.d0.f
        public void d(a.h.d.b insets) {
            this.f446b.setSystemWindowInsets(insets.d());
        }

        @Override // a.h.k.d0.f
        public void c(a.h.d.b insets) {
            this.f446b.setStableInsets(insets.d());
        }

        @Override // a.h.k.d0.f
        public d0 b() {
            a();
            d0 windowInsetsCompat = d0.s(this.f446b.build());
            windowInsetsCompat.n(null);
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends d {
        public e() {
        }

        public e(d0 insets) {
            super(insets);
        }
    }

    public void p(d0 rootWindowInsets) {
        this.f441b.o(rootWindowInsets);
    }

    public void o(a.h.d.b visibleInsets) {
        this.f441b.n(visibleInsets);
    }

    public void d(View rootView) {
        this.f441b.d(rootView);
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Field f442a;

        /* renamed from: b, reason: collision with root package name */
        public static Field f443b;
        public static Field c;
        public static boolean d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f442a = declaredField;
                declaredField.setAccessible(true);
                Class<?> sAttachInfoClass = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = sAttachInfoClass.getDeclaredField("mStableInsets");
                f443b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = sAttachInfoClass.getDeclaredField("mContentInsets");
                c = declaredField3;
                declaredField3.setAccessible(true);
                d = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public static d0 a(View v) {
            if (!d || !v.isAttachedToWindow()) {
                return null;
            }
            View rootView = v.getRootView();
            try {
                Object attachInfo = f442a.get(rootView);
                if (attachInfo != null) {
                    Rect stableInsets = (Rect) f443b.get(attachInfo);
                    Rect visibleInsets = (Rect) c.get(attachInfo);
                    if (stableInsets != null && visibleInsets != null) {
                        b bVar = new b();
                        bVar.b(a.h.d.b.b(stableInsets));
                        bVar.c(a.h.d.b.b(visibleInsets));
                        d0 insets = bVar.a();
                        insets.p(insets);
                        insets.d(v.getRootView());
                        return insets;
                    }
                }
            } catch (IllegalAccessException e) {
                Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            }
            return null;
        }
    }
}
