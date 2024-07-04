package a.b.g;

import a.b.g.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import net.sqlcipher.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: b, reason: collision with root package name */
    public static n0 f176b;
    public WeakHashMap<Context, a.e.h<ColorStateList>> d;
    public a.e.g<String, e> e;
    public a.e.h<String> f;
    public final WeakHashMap<Context, a.e.d<WeakReference<Drawable.ConstantState>>> g = new WeakHashMap<>(0);
    public TypedValue h;
    public boolean i;
    public f j;

    /* renamed from: a, reason: collision with root package name */
    public static final PorterDuff.Mode f175a = PorterDuff.Mode.SRC_IN;
    public static final c c = new c(6);

    /* loaded from: classes.dex */
    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    public static synchronized n0 h() {
        n0 n0Var;
        synchronized (n0.class) {
            if (f176b == null) {
                n0 n0Var2 = new n0();
                f176b = n0Var2;
                p(n0Var2);
            }
            n0Var = f176b;
        }
        return n0Var;
    }

    public static void p(n0 manager) {
        if (Build.VERSION.SDK_INT < 24) {
            manager.a("vector", new g());
            manager.a("animated-vector", new b());
            manager.a("animated-selector", new a());
            manager.a("drawable", new d());
        }
    }

    public synchronized void t(f hooks) {
        this.j = hooks;
    }

    public synchronized Drawable j(Context context, int resId) {
        return k(context, resId, false);
    }

    public synchronized Drawable k(Context context, int resId, boolean failIfNotKnown) {
        Drawable drawable;
        d(context);
        drawable = r(context, resId);
        if (drawable == null) {
            drawable = f(context, resId);
        }
        if (drawable == null) {
            drawable = a.h.c.a.d(context, resId);
        }
        if (drawable != null) {
            drawable = u(context, resId, failIfNotKnown, drawable);
        }
        if (drawable != null) {
            f0.b(drawable);
        }
        return drawable;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>> */
    public synchronized void s(Context context) {
        a.e.d<WeakReference<Drawable.ConstantState>> dVar = this.g.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    public static long e(TypedValue tv) {
        return (tv.assetCookie << 32) | tv.data;
    }

    public final Drawable f(Context context, int resId) {
        if (this.h == null) {
            this.h = new TypedValue();
        }
        TypedValue tv = this.h;
        context.getResources().getValue(resId, tv, true);
        long key = e(tv);
        Drawable dr = i(context, key);
        if (dr != null) {
            return dr;
        }
        f fVar = this.j;
        Drawable dr2 = fVar == null ? null : ((j.a) fVar).f(this, context, resId);
        if (dr2 != null) {
            dr2.setChangingConfigurations(tv.changingConfigurations);
            b(context, key, dr2);
        }
        return dr2;
    }

    public final Drawable u(Context context, int resId, boolean failIfNotKnown, Drawable drawable) {
        ColorStateList tintList = m(context, resId);
        if (tintList != null) {
            if (f0.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawable2 = a.h.d.l.a.r(drawable);
            a.h.d.l.a.o(drawable2, tintList);
            PorterDuff.Mode tintMode = o(resId);
            if (tintMode != null) {
                a.h.d.l.a.p(drawable2, tintMode);
                return drawable2;
            }
            return drawable2;
        }
        f fVar = this.j;
        if (fVar == null || !((j.a) fVar).l(context, resId, drawable)) {
            boolean tinted = w(context, resId, drawable);
            if (!tinted && failIfNotKnown) {
                return null;
            }
            return drawable;
        }
        return drawable;
    }

    public final Drawable r(Context context, int resId) {
        int type;
        a.e.g<String, e> gVar = this.e;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        a.e.h<String> hVar = this.f;
        if (hVar != null) {
            String cachedTagName = hVar.e(resId);
            if ("appcompat_skip_skip".equals(cachedTagName) || (cachedTagName != null && this.e.get(cachedTagName) == null)) {
                return null;
            }
        } else {
            this.f = new a.e.h<>();
        }
        if (this.h == null) {
            this.h = new TypedValue();
        }
        TypedValue tv = this.h;
        Resources res = context.getResources();
        res.getValue(resId, tv, true);
        long key = e(tv);
        Drawable dr = i(context, key);
        if (dr != null) {
            return dr;
        }
        CharSequence charSequence = tv.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlPullParser parser = res.getXml(resId);
                AttributeSet attrs = Xml.asAttributeSet(parser);
                do {
                    type = parser.next();
                    if (type == 2) {
                        break;
                    }
                } while (type != 1);
                if (type != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String tagName = parser.getName();
                this.f.a(resId, tagName);
                e delegate = this.e.get(tagName);
                if (delegate != null) {
                    dr = delegate.a(context, parser, attrs, context.getTheme());
                }
                if (dr != null) {
                    dr.setChangingConfigurations(tv.changingConfigurations);
                    b(context, key, dr);
                }
            } catch (Exception e2) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (dr == null) {
            this.f.a(resId, "appcompat_skip_skip");
        }
        return dr;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>> */
    public final synchronized Drawable i(Context context, long key) {
        a.e.d<WeakReference<Drawable.ConstantState>> dVar = this.g.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> wr = dVar.e(key);
        if (wr != null) {
            Drawable.ConstantState entry = wr.get();
            if (entry != null) {
                return entry.newDrawable(context.getResources());
            }
            dVar.j(key);
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>> */
    public final synchronized boolean b(Context context, long key, Drawable drawable) {
        Drawable.ConstantState cs = drawable.getConstantState();
        if (cs != null) {
            a.e.d<WeakReference<Drawable.ConstantState>> dVar = this.g.get(context);
            if (dVar == null) {
                dVar = new a.e.d<>();
                this.g.put(context, dVar);
            }
            dVar.i(key, new WeakReference<>(cs));
            return true;
        }
        return false;
    }

    public boolean w(Context context, int resId, Drawable drawable) {
        f fVar = this.j;
        return fVar != null && ((j.a) fVar).m(context, resId, drawable);
    }

    public final void a(String tagName, e delegate) {
        if (this.e == null) {
            this.e = new a.e.g<>();
        }
        this.e.put(tagName, delegate);
    }

    public PorterDuff.Mode o(int resId) {
        f fVar = this.j;
        if (fVar == null) {
            return null;
        }
        return ((j.a) fVar).j(resId);
    }

    public synchronized ColorStateList m(Context context, int resId) {
        ColorStateList tint;
        tint = n(context, resId);
        if (tint == null) {
            f fVar = this.j;
            tint = fVar == null ? null : ((j.a) fVar).i(context, resId);
            if (tint != null) {
                c(context, resId, tint);
            }
        }
        return tint;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<android.content.res.ColorStateList> */
    public final ColorStateList n(Context context, int resId) {
        a.e.h<ColorStateList> hVar;
        WeakHashMap<Context, a.e.h<ColorStateList>> weakHashMap = this.d;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.e(resId);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<android.content.res.ColorStateList> */
    public final void c(Context context, int resId, ColorStateList tintList) {
        if (this.d == null) {
            this.d = new WeakHashMap<>();
        }
        a.e.h<ColorStateList> hVar = this.d.get(context);
        if (hVar == null) {
            hVar = new a.e.h<>();
            this.d.put(context, hVar);
        }
        hVar.a(resId, tintList);
    }

    /* loaded from: classes.dex */
    public static class c extends a.e.e<Integer, PorterDuffColorFilter> {
        public c(int maxSize) {
            super(maxSize);
        }

        public PorterDuffColorFilter i(int color, PorterDuff.Mode mode) {
            return c(Integer.valueOf(h(color, mode)));
        }

        public PorterDuffColorFilter j(int color, PorterDuff.Mode mode, PorterDuffColorFilter filter) {
            return d(Integer.valueOf(h(color, mode)), filter);
        }

        public static int h(int color, PorterDuff.Mode mode) {
            int hashCode = (1 * 31) + color;
            return (hashCode * 31) + mode.hashCode();
        }
    }

    public static void v(Drawable drawable, v0 tint, int[] state) {
        if (f0.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z = tint.d;
        if (z || tint.c) {
            drawable.setColorFilter(g(z ? tint.f198a : null, tint.c ? tint.f199b : f175a, state));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public static PorterDuffColorFilter g(ColorStateList tint, PorterDuff.Mode tintMode, int[] state) {
        if (tint == null || tintMode == null) {
            return null;
        }
        int color = tint.getColorForState(state, 0);
        return l(color, tintMode);
    }

    public static synchronized PorterDuffColorFilter l(int color, PorterDuff.Mode mode) {
        PorterDuffColorFilter filter;
        synchronized (n0.class) {
            c cVar = c;
            filter = cVar.i(color, mode);
            if (filter == null) {
                filter = new PorterDuffColorFilter(color, mode);
                cVar.j(color, mode, filter);
            }
        }
        return filter;
    }

    public final void d(Context context) {
        if (this.i) {
            return;
        }
        this.i = true;
        Drawable d2 = j(context, R.drawable.abc_vector_test);
        if (d2 == null || !q(d2)) {
            this.i = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public static boolean q(Drawable d2) {
        return (d2 instanceof a.t.a.a.h) || "android.graphics.drawable.VectorDrawable".equals(d2.getClass().getName());
    }

    /* loaded from: classes.dex */
    public static class g implements e {
        @Override // a.b.g.n0.e
        public Drawable a(Context context, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
            try {
                return a.t.a.a.h.c(context.getResources(), parser, attrs, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e {
        @Override // a.b.g.n0.e
        public Drawable a(Context context, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
            try {
                return a.t.a.a.b.a(context, context.getResources(), parser, attrs, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a implements e {
        @Override // a.b.g.n0.e
        public Drawable a(Context context, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
            try {
                return a.b.d.a.a.m(context, context.getResources(), parser, attrs, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements e {
        @Override // a.b.g.n0.e
        public Drawable a(Context context, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
            String className = attrs.getClassAttribute();
            if (className == null) {
                return null;
            }
            try {
                Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(className).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable.inflate(context.getResources(), parser, attrs, theme);
                } else {
                    drawable.inflate(context.getResources(), parser, attrs);
                }
                return drawable;
            } catch (Exception e) {
                Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
                return null;
            }
        }
    }
}
