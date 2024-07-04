package a.b.b;

import a.b.f.b;
import a.b.f.f;
import a.b.f.j.e;
import a.b.f.j.g;
import a.b.f.j.m;
import a.b.g.d0;
import a.b.g.d1;
import a.b.g.e1;
import a.b.g.h0;
import a.b.g.x0;
import a.h.c.c.f;
import a.h.k.b0;
import a.h.k.f;
import a.h.k.v;
import a.h.k.z;
import a.m.d;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import java.lang.Thread;
import java.util.List;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteCursor;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class f extends a.b.b.e implements g.a, LayoutInflater.Factory2 {
    public static final a.e.g<String, Integer> e = new a.e.g<>();
    public static final boolean f;
    public static final int[] g;
    public static final boolean h;
    public static final boolean i;
    public static boolean j;
    public boolean A;
    public boolean B;
    public ViewGroup C;
    public TextView D;
    public View E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public t[] N;
    public t O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public p Y;
    public p Z;
    public boolean a0;
    public int b0;
    public final Runnable c0;
    public boolean d0;
    public Rect e0;
    public Rect f0;
    public a.b.b.h g0;
    public a.b.b.i h0;
    public final Object k;
    public final Context l;
    public Window m;
    public n n;
    public final a.b.b.d o;
    public a.b.b.a p;
    public MenuInflater q;
    public CharSequence r;
    public d0 s;
    public h t;
    public u u;
    public a.b.f.b v;
    public ActionBarContextView w;
    public PopupWindow x;
    public Runnable y;
    public z z;

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = i2 < 21;
        f = z;
        g = new int[]{R.attr.windowBackground};
        h = !"robolectric".equals(Build.FINGERPRINT);
        i = i2 >= 17;
        if (z && !j) {
            Thread.UncaughtExceptionHandler defHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new a(defHandler));
            j = true;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f19a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f19a = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable throwable) {
            if (a(throwable)) {
                Throwable wrapped = new Resources.NotFoundException(throwable.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                wrapped.initCause(throwable.getCause());
                wrapped.setStackTrace(throwable.getStackTrace());
                this.f19a.uncaughtException(thread, wrapped);
                return;
            }
            this.f19a.uncaughtException(thread, throwable);
        }

        public final boolean a(Throwable throwable) {
            String message;
            if (!(throwable instanceof Resources.NotFoundException) || (message = throwable.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            if ((fVar.b0 & 1) != 0) {
                fVar.U(0);
            }
            f fVar2 = f.this;
            if ((fVar2.b0 & 4096) != 0) {
                fVar2.U(108);
            }
            f fVar3 = f.this;
            fVar3.a0 = false;
            fVar3.b0 = 0;
        }
    }

    public f(Activity activity, a.b.b.d callback) {
        this(activity, null, callback, activity);
    }

    public f(Dialog dialog, a.b.b.d callback) {
        this(dialog.getContext(), dialog.getWindow(), callback, dialog);
    }

    public f(Context context, Window window, a.b.b.d callback, Object host) {
        a.e.g<String, Integer> gVar;
        Integer value;
        a.b.b.c activity;
        this.z = null;
        this.A = true;
        this.U = -100;
        this.c0 = new b();
        this.l = context;
        this.o = callback;
        this.k = host;
        if (this.U == -100 && (host instanceof Dialog) && (activity = I0()) != null) {
            this.U = activity.z().k();
        }
        if (this.U == -100 && (value = (gVar = e).get(host.getClass().getName())) != null) {
            this.U = value.intValue();
            gVar.remove(host.getClass().getName());
        }
        if (window != null) {
            I(window);
        }
        a.b.g.j.h();
    }

    @Override // a.b.b.e
    public Context f(Context baseContext) {
        boolean needsThemeRebase = true;
        this.Q = true;
        int modeToApply = n0(baseContext, J());
        if (i && (baseContext instanceof ContextThemeWrapper)) {
            Configuration config = P(baseContext, modeToApply, null);
            try {
                r.a((ContextThemeWrapper) baseContext, config);
                return baseContext;
            } catch (IllegalStateException e2) {
            }
        }
        if (baseContext instanceof a.b.f.d) {
            Configuration config2 = P(baseContext, modeToApply, null);
            try {
                ((a.b.f.d) baseContext).a(config2);
                return baseContext;
            } catch (IllegalStateException e3) {
            }
        }
        if (!h) {
            super.f(baseContext);
            return baseContext;
        }
        Configuration configOverlay = null;
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration overrideConfig = new Configuration();
            overrideConfig.uiMode = -1;
            overrideConfig.fontScale = 0.0f;
            Configuration referenceConfig = j.a(baseContext, overrideConfig).getResources().getConfiguration();
            Configuration baseConfig = baseContext.getResources().getConfiguration();
            referenceConfig.uiMode = baseConfig.uiMode;
            if (!referenceConfig.equals(baseConfig)) {
                configOverlay = Z(referenceConfig, baseConfig);
            }
        }
        Configuration config3 = P(baseContext, modeToApply, configOverlay);
        a.b.f.d wrappedContext = new a.b.f.d(baseContext, net.sqlcipher.R.style.Theme_AppCompat_Empty);
        wrappedContext.a(config3);
        try {
            if (baseContext.getTheme() == null) {
                needsThemeRebase = false;
            }
        } catch (NullPointerException e4) {
            needsThemeRebase = false;
        }
        if (needsThemeRebase) {
            f.b.a(wrappedContext.getTheme());
        }
        super.f(wrappedContext);
        return wrappedContext;
    }

    /* loaded from: classes.dex */
    public static class r {
        public static void a(ContextThemeWrapper context, Configuration overrideConfiguration) {
            context.applyOverrideConfiguration(overrideConfiguration);
        }
    }

    @Override // a.b.b.e
    public void q(Bundle savedInstanceState) {
        this.Q = true;
        G(false);
        X();
        Object obj = this.k;
        if (obj instanceof Activity) {
            String parentActivityName = null;
            try {
                parentActivityName = a.h.b.e.c((Activity) obj);
            } catch (IllegalArgumentException e2) {
            }
            if (parentActivityName != null) {
                a.b.b.a ab = y0();
                if (ab == null) {
                    this.d0 = true;
                } else {
                    ab.l(true);
                }
            }
            a.b.b.e.c(this);
        }
        this.R = true;
    }

    @Override // a.b.b.e
    public void s(Bundle savedInstanceState) {
        W();
    }

    @Override // a.b.b.e
    public a.b.b.a m() {
        g0();
        return this.p;
    }

    public final a.b.b.a y0() {
        return this.p;
    }

    public final Window.Callback f0() {
        return this.m.getCallback();
    }

    public final void g0() {
        W();
        if (!this.H || this.p != null) {
            return;
        }
        Object obj = this.k;
        if (obj instanceof Activity) {
            this.p = new a.b.b.m((Activity) this.k, this.I);
        } else if (obj instanceof Dialog) {
            this.p = new a.b.b.m((Dialog) this.k);
        }
        a.b.b.a aVar = this.p;
        if (aVar != null) {
            aVar.l(this.d0);
        }
    }

    public final Context a0() {
        Context context = null;
        a.b.b.a ab = m();
        if (ab != null) {
            context = ab.e();
        }
        if (context == null) {
            Context context2 = this.l;
            return context2;
        }
        return context;
    }

    @Override // a.b.b.e
    public MenuInflater l() {
        if (this.q == null) {
            g0();
            a.b.b.a aVar = this.p;
            this.q = new a.b.f.g(aVar != null ? aVar.e() : this.l);
        }
        return this.q;
    }

    @Override // a.b.b.e
    public <T extends View> T i(int i2) {
        W();
        return (T) this.m.findViewById(i2);
    }

    @Override // a.b.b.e
    public void p(Configuration newConfig) {
        a.b.b.a ab;
        if (this.H && this.B && (ab = m()) != null) {
            ab.g(newConfig);
        }
        a.b.g.j.b().g(this.l);
        G(false);
    }

    @Override // a.b.b.e
    public void v() {
        this.S = true;
        F();
    }

    @Override // a.b.b.e
    public void w() {
        this.S = false;
        a.b.b.a ab = m();
        if (ab != null) {
            ab.m(false);
        }
    }

    @Override // a.b.b.e
    public void t() {
        a.b.b.a ab = m();
        if (ab != null) {
            ab.m(true);
        }
    }

    @Override // a.b.b.e
    public void B(View v) {
        W();
        ViewGroup contentParent = (ViewGroup) this.C.findViewById(R.id.content);
        contentParent.removeAllViews();
        contentParent.addView(v);
        this.n.a().onContentChanged();
    }

    @Override // a.b.b.e
    public void A(int resId) {
        W();
        ViewGroup contentParent = (ViewGroup) this.C.findViewById(R.id.content);
        contentParent.removeAllViews();
        LayoutInflater.from(this.l).inflate(resId, contentParent);
        this.n.a().onContentChanged();
    }

    @Override // a.b.b.e
    public void C(View v, ViewGroup.LayoutParams lp) {
        W();
        ViewGroup contentParent = (ViewGroup) this.C.findViewById(R.id.content);
        contentParent.removeAllViews();
        contentParent.addView(v, lp);
        this.n.a().onContentChanged();
    }

    @Override // a.b.b.e
    public void d(View v, ViewGroup.LayoutParams lp) {
        W();
        ViewGroup contentParent = (ViewGroup) this.C.findViewById(R.id.content);
        contentParent.addView(v, lp);
        this.n.a().onContentChanged();
    }

    @Override // a.b.b.e
    public void u(Bundle outState) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    @Override // a.b.b.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.k
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            a.b.b.e.x(r3)
        L9:
            boolean r0 = r3.a0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.m
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.c0
            r0.removeCallbacks(r1)
        L18:
            r0 = 0
            r3.S = r0
            r0 = 1
            r3.T = r0
            int r0 = r3.U
            r1 = -100
            if (r0 == r1) goto L48
            java.lang.Object r0 = r3.k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L48
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L48
            a.e.g<java.lang.String, java.lang.Integer> r0 = a.b.b.f.e
            java.lang.Object r1 = r3.k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.U
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L57
        L48:
            a.e.g<java.lang.String, java.lang.Integer> r0 = a.b.b.f.e
            java.lang.Object r1 = r3.k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L57:
            a.b.b.a r0 = r3.p
            if (r0 == 0) goto L5e
            r0.h()
        L5e:
            r3.M()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.f.r():void");
    }

    public final void M() {
        p pVar = this.Y;
        if (pVar != null) {
            pVar.a();
        }
        p pVar2 = this.Z;
        if (pVar2 != null) {
            pVar2.a();
        }
    }

    @Override // a.b.b.e
    public void D(int themeResId) {
        this.V = themeResId;
    }

    public final void X() {
        if (this.m == null) {
            Object obj = this.k;
            if (obj instanceof Activity) {
                I(((Activity) obj).getWindow());
            }
        }
        if (this.m == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final void I(Window window) {
        if (this.m != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof n) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        n nVar = new n(callback);
        this.n = nVar;
        window.setCallback(nVar);
        x0 a2 = x0.u(this.l, null, g);
        Drawable winBg = a2.h(0);
        if (winBg != null) {
            window.setBackgroundDrawable(winBg);
        }
        a2.w();
        this.m = window;
    }

    public final void W() {
        if (!this.B) {
            this.C = Q();
            CharSequence title = e0();
            if (!TextUtils.isEmpty(title)) {
                d0 d0Var = this.s;
                if (d0Var != null) {
                    d0Var.setWindowTitle(title);
                } else if (y0() != null) {
                    y0().n(title);
                } else {
                    TextView textView = this.D;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
            H();
            w0();
            this.B = true;
            t st = d0(0);
            if (!this.T && st.h == null) {
                k0(108);
            }
        }
    }

    public final ViewGroup Q() {
        Context themedContext;
        TypedArray a2 = this.l.obtainStyledAttributes(a.b.a.j);
        int[] iArr = a.b.a.f11a;
        if (!a2.hasValue(117)) {
            a2.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (a2.getBoolean(126, false)) {
            z(1);
        } else if (a2.getBoolean(117, false)) {
            z(108);
        }
        if (a2.getBoolean(118, false)) {
            z(109);
        }
        if (a2.getBoolean(119, false)) {
            z(10);
        }
        this.K = a2.getBoolean(0, false);
        a2.recycle();
        X();
        this.m.getDecorView();
        LayoutInflater inflater = LayoutInflater.from(this.l);
        ViewGroup subDecor = null;
        if (!this.L) {
            if (this.K) {
                subDecor = (ViewGroup) inflater.inflate(net.sqlcipher.R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.I = false;
                this.H = false;
            } else if (this.H) {
                TypedValue outValue = new TypedValue();
                this.l.getTheme().resolveAttribute(net.sqlcipher.R.attr.actionBarTheme, outValue, true);
                if (outValue.resourceId != 0) {
                    themedContext = new a.b.f.d(this.l, outValue.resourceId);
                } else {
                    themedContext = this.l;
                }
                subDecor = (ViewGroup) LayoutInflater.from(themedContext).inflate(net.sqlcipher.R.layout.abc_screen_toolbar, (ViewGroup) null);
                d0 d0Var = (d0) subDecor.findViewById(net.sqlcipher.R.id.decor_content_parent);
                this.s = d0Var;
                d0Var.setWindowCallback(f0());
                if (this.I) {
                    this.s.h(109);
                }
                if (this.F) {
                    this.s.h(2);
                }
                if (this.G) {
                    this.s.h(5);
                }
            }
        } else {
            subDecor = this.J ? (ViewGroup) inflater.inflate(net.sqlcipher.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) inflater.inflate(net.sqlcipher.R.layout.abc_screen_simple, (ViewGroup) null);
        }
        if (subDecor == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.H + ", windowActionBarOverlay: " + this.I + ", android:windowIsFloating: " + this.K + ", windowActionModeOverlay: " + this.J + ", windowNoTitle: " + this.L + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            v.z0(subDecor, new c());
        } else if (subDecor instanceof h0) {
            ((h0) subDecor).setOnFitSystemWindowsListener(new d());
        }
        if (this.s == null) {
            this.D = (TextView) subDecor.findViewById(net.sqlcipher.R.id.title);
        }
        e1.c(subDecor);
        ContentFrameLayout contentView = (ContentFrameLayout) subDecor.findViewById(net.sqlcipher.R.id.action_bar_activity_content);
        ViewGroup windowContentView = (ViewGroup) this.m.findViewById(R.id.content);
        if (windowContentView != null) {
            while (windowContentView.getChildCount() > 0) {
                View child = windowContentView.getChildAt(0);
                windowContentView.removeViewAt(0);
                contentView.addView(child);
            }
            windowContentView.setId(-1);
            contentView.setId(R.id.content);
            if (windowContentView instanceof FrameLayout) {
                ((FrameLayout) windowContentView).setForeground(null);
            }
        }
        this.m.setContentView(subDecor);
        contentView.setAttachListener(new e());
        return subDecor;
    }

    /* loaded from: classes.dex */
    public class c implements a.h.k.q {
        public c() {
        }

        @Override // a.h.k.q
        public a.h.k.d0 a(View v, a.h.k.d0 insets) {
            int top = insets.i();
            int newTop = f.this.L0(insets, null);
            if (top != newTop) {
                insets = insets.m(insets.g(), newTop, insets.h(), insets.f());
            }
            return v.a0(v, insets);
        }
    }

    /* loaded from: classes.dex */
    public class d implements h0.a {
        public d() {
        }

        public void a(Rect insets) {
            insets.top = f.this.L0(null, insets);
        }
    }

    /* loaded from: classes.dex */
    public class e implements ContentFrameLayout.a {
        public e() {
        }

        public void a() {
        }

        public void b() {
            f.this.S();
        }
    }

    public void w0() {
    }

    public final void H() {
        ContentFrameLayout cfl = (ContentFrameLayout) this.C.findViewById(R.id.content);
        View windowDecor = this.m.getDecorView();
        cfl.b(windowDecor.getPaddingLeft(), windowDecor.getPaddingTop(), windowDecor.getPaddingRight(), windowDecor.getPaddingBottom());
        TypedArray a2 = this.l.obtainStyledAttributes(a.b.a.j);
        int[] iArr = a.b.a.f11a;
        a2.getValue(124, cfl.getMinWidthMajor());
        a2.getValue(125, cfl.getMinWidthMinor());
        if (a2.hasValue(122)) {
            a2.getValue(122, cfl.getFixedWidthMajor());
        }
        if (a2.hasValue(123)) {
            a2.getValue(123, cfl.getFixedWidthMinor());
        }
        if (a2.hasValue(120)) {
            a2.getValue(120, cfl.getFixedHeightMajor());
        }
        if (a2.hasValue(121)) {
            a2.getValue(121, cfl.getFixedHeightMinor());
        }
        a2.recycle();
        cfl.requestLayout();
    }

    @Override // a.b.b.e
    public boolean z(int featureId) {
        int featureId2 = C0(featureId);
        if (this.L && featureId2 == 108) {
            return false;
        }
        if (this.H && featureId2 == 1) {
            this.H = false;
        }
        switch (featureId2) {
            case 1:
                H0();
                this.L = true;
                return true;
            case 2:
                H0();
                this.F = true;
                return true;
            case 5:
                H0();
                this.G = true;
                return true;
            case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                H0();
                this.J = true;
                return true;
            case 108:
                H0();
                this.H = true;
                return true;
            case 109:
                H0();
                this.I = true;
                return true;
            default:
                return this.m.requestFeature(featureId2);
        }
    }

    @Override // a.b.b.e
    public final void E(CharSequence title) {
        this.r = title;
        d0 d0Var = this.s;
        if (d0Var != null) {
            d0Var.setWindowTitle(title);
            return;
        }
        if (y0() != null) {
            y0().n(title);
            return;
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(title);
        }
    }

    public final CharSequence e0() {
        Object obj = this.k;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.r;
    }

    public void v0(int featureId) {
        if (featureId == 108) {
            a.b.b.a ab = m();
            if (ab != null) {
                ab.c(false);
                return;
            }
            return;
        }
        if (featureId == 0) {
            t st = d0(featureId);
            if (st.m) {
                O(st, false);
            }
        }
    }

    public void u0(int featureId) {
        a.b.b.a ab;
        if (featureId == 108 && (ab = m()) != null) {
            ab.c(true);
        }
    }

    @Override // a.b.f.j.g.a
    public boolean b(a.b.f.j.g menu, MenuItem item) {
        t panel;
        Window.Callback cb = f0();
        if (cb != null && !this.T && (panel = Y(menu.D())) != null) {
            return cb.onMenuItemSelected(panel.f34a, item);
        }
        return false;
    }

    @Override // a.b.f.j.g.a
    public void a(a.b.f.j.g menu) {
        B0(true);
    }

    public a.b.f.b F0(b.a callback) {
        a.b.b.d dVar;
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        a.b.f.b bVar = this.v;
        if (bVar != null) {
            bVar.c();
        }
        b.a wrappedCallback = new i(callback);
        a.b.b.a ab = m();
        if (ab != null) {
            a.b.f.b o2 = ab.o(wrappedCallback);
            this.v = o2;
            if (o2 != null && (dVar = this.o) != null) {
                dVar.b(o2);
            }
        }
        if (this.v == null) {
            this.v = G0(wrappedCallback);
        }
        return this.v;
    }

    @Override // a.b.b.e
    public void o() {
        a.b.b.a ab = m();
        if (ab != null) {
            ab.f();
        }
        k0(0);
    }

    public a.b.f.b G0(b.a callback) {
        Context actionBarContext;
        a.b.b.d dVar;
        V();
        a.b.f.b bVar = this.v;
        if (bVar != null) {
            bVar.c();
        }
        if (!(callback instanceof i)) {
            callback = new i(callback);
        }
        a.b.f.b mode = null;
        a.b.b.d dVar2 = this.o;
        if (dVar2 != null && !this.T) {
            try {
                mode = dVar2.h(callback);
            } catch (AbstractMethodError e2) {
            }
        }
        if (mode != null) {
            this.v = mode;
        } else {
            if (this.w == null) {
                if (this.K) {
                    TypedValue outValue = new TypedValue();
                    Resources.Theme baseTheme = this.l.getTheme();
                    baseTheme.resolveAttribute(net.sqlcipher.R.attr.actionBarTheme, outValue, true);
                    if (outValue.resourceId != 0) {
                        Resources.Theme actionBarTheme = this.l.getResources().newTheme();
                        actionBarTheme.setTo(baseTheme);
                        actionBarTheme.applyStyle(outValue.resourceId, true);
                        actionBarContext = new a.b.f.d(this.l, 0);
                        actionBarContext.getTheme().setTo(actionBarTheme);
                    } else {
                        actionBarContext = this.l;
                    }
                    this.w = new ActionBarContextView(actionBarContext);
                    PopupWindow popupWindow = new PopupWindow(actionBarContext, (AttributeSet) null, net.sqlcipher.R.attr.actionModePopupWindowStyle);
                    this.x = popupWindow;
                    a.h.l.h.b(popupWindow, 2);
                    this.x.setContentView(this.w);
                    this.x.setWidth(-1);
                    actionBarContext.getTheme().resolveAttribute(net.sqlcipher.R.attr.actionBarSize, outValue, true);
                    int height = TypedValue.complexToDimensionPixelSize(outValue.data, actionBarContext.getResources().getDisplayMetrics());
                    this.w.setContentHeight(height);
                    this.x.setHeight(-2);
                    this.y = new RunnableC0002f();
                } else {
                    ViewStubCompat stub = (ViewStubCompat) this.C.findViewById(net.sqlcipher.R.id.action_mode_bar_stub);
                    if (stub != null) {
                        stub.setLayoutInflater(LayoutInflater.from(a0()));
                        this.w = (ActionBarContextView) stub.a();
                    }
                }
            }
            if (this.w != null) {
                V();
                this.w.k();
                a.b.f.b mode2 = new a.b.f.e(this.w.getContext(), this.w, callback, this.x == null);
                if (callback.d(mode2, mode2.e())) {
                    mode2.k();
                    this.w.h(mode2);
                    this.v = mode2;
                    if (D0()) {
                        this.w.setAlpha(0.0f);
                        z d2 = v.d(this.w);
                        d2.a(1.0f);
                        this.z = d2;
                        d2.f(new g());
                    } else {
                        this.w.setAlpha(1.0f);
                        this.w.setVisibility(0);
                        this.w.sendAccessibilityEvent(32);
                        if (this.w.getParent() instanceof View) {
                            v.l0((View) this.w.getParent());
                        }
                    }
                    if (this.x != null) {
                        this.m.getDecorView().post(this.y);
                    }
                } else {
                    this.v = null;
                }
            }
        }
        a.b.f.b bVar2 = this.v;
        if (bVar2 != null && (dVar = this.o) != null) {
            dVar.b(bVar2);
        }
        return this.v;
    }

    /* renamed from: a.b.b.f$f, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0002f implements Runnable {
        public RunnableC0002f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.x.showAtLocation(fVar.w, 55, 0, 0);
            f.this.V();
            if (f.this.D0()) {
                f.this.w.setAlpha(0.0f);
                f fVar2 = f.this;
                z d = v.d(fVar2.w);
                d.a(1.0f);
                fVar2.z = d;
                f.this.z.f(new a());
                return;
            }
            f.this.w.setAlpha(1.0f);
            f.this.w.setVisibility(0);
        }

        /* renamed from: a.b.b.f$f$a */
        /* loaded from: classes.dex */
        public class a extends b0 {
            public a() {
            }

            @Override // a.h.k.b0, a.h.k.a0
            public void b(View view) {
                f.this.w.setVisibility(0);
            }

            @Override // a.h.k.a0
            public void a(View view) {
                f.this.w.setAlpha(1.0f);
                f.this.z.f(null);
                f.this.z = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends b0 {
        public g() {
        }

        @Override // a.h.k.b0, a.h.k.a0
        public void b(View view) {
            f.this.w.setVisibility(0);
            f.this.w.sendAccessibilityEvent(32);
            if (f.this.w.getParent() instanceof View) {
                v.l0((View) f.this.w.getParent());
            }
        }

        @Override // a.h.k.a0
        public void a(View view) {
            f.this.w.setAlpha(1.0f);
            f.this.z.f(null);
            f.this.z = null;
        }
    }

    public final boolean D0() {
        ViewGroup viewGroup;
        return this.B && (viewGroup = this.C) != null && v.T(viewGroup);
    }

    public boolean m0() {
        return this.A;
    }

    public void V() {
        z zVar = this.z;
        if (zVar != null) {
            zVar.b();
        }
    }

    public boolean o0() {
        a.b.f.b bVar = this.v;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        a.b.b.a ab = m();
        return ab != null && ab.b();
    }

    public boolean r0(int keyCode, KeyEvent ev) {
        a.b.b.a ab = m();
        if (ab != null && ab.i(keyCode, ev)) {
            return true;
        }
        t tVar = this.O;
        if (tVar != null) {
            boolean handled = z0(tVar, ev.getKeyCode(), ev, 1);
            if (handled) {
                t tVar2 = this.O;
                if (tVar2 != null) {
                    tVar2.l = true;
                }
                return true;
            }
        }
        if (this.O == null) {
            t st = d0(0);
            A0(st, ev);
            boolean handled2 = z0(st, ev.getKeyCode(), ev, 1);
            st.k = false;
            if (handled2) {
                return true;
            }
        }
        return false;
    }

    public boolean T(KeyEvent event) {
        View root;
        Object obj = this.k;
        if (((obj instanceof f.a) || (obj instanceof a.b.b.g)) && (root = this.m.getDecorView()) != null && a.h.k.f.d(root, event)) {
            return true;
        }
        if (event.getKeyCode() == 82 && this.n.a().dispatchKeyEvent(event)) {
            return true;
        }
        int keyCode = event.getKeyCode();
        int action = event.getAction();
        boolean isDown = action == 0;
        return isDown ? p0(keyCode, event) : s0(keyCode, event);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0023 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean s0(int r6, android.view.KeyEvent r7) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            switch(r6) {
                case 4: goto La;
                case 82: goto L6;
                default: goto L5;
            }
        L5:
            goto L23
        L6:
            r5.t0(r1, r7)
            return r0
        La:
            boolean r2 = r5.P
            r5.P = r1
            a.b.b.f$t r3 = r5.d0(r1)
            boolean r4 = r3.m
            if (r4 == 0) goto L1c
            if (r2 != 0) goto L1b
            r5.O(r3, r0)
        L1b:
            return r0
        L1c:
            boolean r4 = r5.o0()
            if (r4 == 0) goto L23
            return r0
        L23:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.f.s0(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean p0(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 4:
                this.P = (event.getFlags() & 128) != 0;
                return false;
            case 82:
                q0(0, event);
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View R(View view, String name, Context context, AttributeSet attrs) {
        boolean z = false;
        if (this.g0 == null) {
            TypedArray a2 = this.l.obtainStyledAttributes(a.b.a.j);
            int[] iArr = a.b.a.f11a;
            String viewInflaterClassName = a2.getString(116);
            if (viewInflaterClassName == null) {
                this.g0 = new a.b.b.h();
            } else {
                try {
                    Class<?> viewInflaterClass = Class.forName(viewInflaterClassName);
                    this.g0 = (a.b.b.h) viewInflaterClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable t2) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + viewInflaterClassName + ". Falling back to default.", t2);
                    this.g0 = new a.b.b.h();
                }
            }
        }
        boolean inheritContext = false;
        boolean z2 = f;
        if (z2) {
            if (this.h0 == null) {
                this.h0 = new a.b.b.i();
            }
            if (this.h0.a(attrs)) {
                inheritContext = true;
            } else {
                if (attrs instanceof XmlPullParser) {
                    if (((XmlPullParser) attrs).getDepth() > 1) {
                        z = true;
                    }
                } else {
                    z = E0((ViewParent) view);
                }
                inheritContext = z;
            }
        }
        a.b.b.h hVar = this.g0;
        d1.b();
        return hVar.q(view, name, context, attrs, inheritContext, z2, true, false);
    }

    public final boolean E0(ViewParent parent) {
        if (parent == null) {
            return false;
        }
        View windowDecor = this.m.getDecorView();
        while (parent != null) {
            if (parent == windowDecor || !(parent instanceof View) || v.S((View) parent)) {
                return false;
            }
            parent = parent.getParent();
        }
        return true;
    }

    @Override // a.b.b.e
    public void n() {
        LayoutInflater layoutInflater = LayoutInflater.from(this.l);
        if (layoutInflater.getFactory() == null) {
            a.h.k.g.b(layoutInflater, this);
        } else if (!(layoutInflater.getFactory2() instanceof f)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return R(parent, name, context, attrs);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return onCreateView(null, name, context, attrs);
    }

    public final a.b.b.c I0() {
        for (Context context = this.l; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof a.b.b.c) {
                return (a.b.b.c) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
        }
        return null;
    }

    public final void x0(t st, KeyEvent event) {
        ViewGroup.LayoutParams lp;
        if (st.m || this.T) {
            return;
        }
        if (st.f34a == 0) {
            Configuration config = this.l.getResources().getConfiguration();
            boolean isXLarge = (config.screenLayout & 15) == 4;
            if (isXLarge) {
                return;
            }
        }
        Window.Callback cb = f0();
        if (cb != null && !cb.onMenuOpened(st.f34a, st.h)) {
            O(st, true);
            return;
        }
        WindowManager wm = (WindowManager) this.l.getSystemService("window");
        if (wm == null || !A0(st, event)) {
            return;
        }
        int width = -2;
        ViewGroup viewGroup = st.e;
        if (viewGroup == null || st.o) {
            if (viewGroup == null) {
                i0(st);
                if (st.e == null) {
                    return;
                }
            } else if (st.o && viewGroup.getChildCount() > 0) {
                st.e.removeAllViews();
            }
            if (!h0(st) || !st.b()) {
                st.o = true;
                return;
            }
            ViewGroup.LayoutParams lp2 = st.f.getLayoutParams();
            if (lp2 == null) {
                lp2 = new ViewGroup.LayoutParams(-2, -2);
            }
            int backgroundResId = st.f35b;
            st.e.setBackgroundResource(backgroundResId);
            ViewParent shownPanelParent = st.f.getParent();
            if (shownPanelParent instanceof ViewGroup) {
                ((ViewGroup) shownPanelParent).removeView(st.f);
            }
            st.e.addView(st.f, lp2);
            if (!st.f.hasFocus()) {
                st.f.requestFocus();
            }
        } else {
            View view = st.g;
            if (view != null && (lp = view.getLayoutParams()) != null && lp.width == -1) {
                width = -1;
            }
        }
        st.l = false;
        st.getClass();
        st.getClass();
        WindowManager.LayoutParams lp3 = new WindowManager.LayoutParams(width, -2, 0, 0, 1002, 8519680, -3);
        lp3.gravity = st.c;
        lp3.windowAnimations = st.d;
        wm.addView(st.e, lp3);
        st.m = true;
    }

    public final boolean i0(t st) {
        st.d(a0());
        st.e = new s(st.j);
        st.c = 81;
        return true;
    }

    public final void B0(boolean toggleMenuMode) {
        d0 d0Var = this.s;
        if (d0Var != null && d0Var.f() && (!ViewConfiguration.get(this.l).hasPermanentMenuKey() || this.s.c())) {
            Window.Callback cb = f0();
            if (!this.s.e() || !toggleMenuMode) {
                if (cb != null && !this.T) {
                    if (this.a0 && (1 & this.b0) != 0) {
                        this.m.getDecorView().removeCallbacks(this.c0);
                        this.c0.run();
                    }
                    t st = d0(0);
                    a.b.f.j.g gVar = st.h;
                    if (gVar != null && !st.p && cb.onPreparePanel(0, st.g, gVar)) {
                        cb.onMenuOpened(108, st.h);
                        this.s.a();
                        return;
                    }
                    return;
                }
                return;
            }
            this.s.g();
            if (!this.T) {
                cb.onPanelClosed(108, d0(0).h);
                return;
            }
            return;
        }
        t st2 = d0(0);
        st2.o = true;
        O(st2, false);
        x0(st2, null);
    }

    public final boolean j0(t st) {
        Context context = this.l;
        int i2 = st.f34a;
        if ((i2 == 0 || i2 == 108) && this.s != null) {
            TypedValue outValue = new TypedValue();
            Resources.Theme baseTheme = context.getTheme();
            baseTheme.resolveAttribute(net.sqlcipher.R.attr.actionBarTheme, outValue, true);
            Resources.Theme widgetTheme = null;
            if (outValue.resourceId != 0) {
                widgetTheme = context.getResources().newTheme();
                widgetTheme.setTo(baseTheme);
                widgetTheme.applyStyle(outValue.resourceId, true);
                widgetTheme.resolveAttribute(net.sqlcipher.R.attr.actionBarWidgetTheme, outValue, true);
            } else {
                baseTheme.resolveAttribute(net.sqlcipher.R.attr.actionBarWidgetTheme, outValue, true);
            }
            if (outValue.resourceId != 0) {
                if (widgetTheme == null) {
                    widgetTheme = context.getResources().newTheme();
                    widgetTheme.setTo(baseTheme);
                }
                widgetTheme.applyStyle(outValue.resourceId, true);
            }
            if (widgetTheme != null) {
                context = new a.b.f.d(context, 0);
                context.getTheme().setTo(widgetTheme);
            }
        }
        a.b.f.j.g menu = new a.b.f.j.g(context);
        menu.R(this);
        st.c(menu);
        return true;
    }

    public final boolean h0(t st) {
        View view = st.g;
        if (view != null) {
            st.f = view;
            return true;
        }
        if (st.h == null) {
            return false;
        }
        if (this.u == null) {
            this.u = new u();
        }
        View view2 = (View) st.a(this.u);
        st.f = view2;
        return view2 != null;
    }

    public final boolean A0(t st, KeyEvent event) {
        d0 d0Var;
        d0 d0Var2;
        d0 d0Var3;
        if (this.T) {
            return false;
        }
        if (st.k) {
            return true;
        }
        t tVar = this.O;
        if (tVar != null && tVar != st) {
            O(tVar, false);
        }
        Window.Callback cb = f0();
        if (cb != null) {
            st.g = cb.onCreatePanelView(st.f34a);
        }
        int i2 = st.f34a;
        boolean isActionBarMenu = i2 == 0 || i2 == 108;
        if (isActionBarMenu && (d0Var3 = this.s) != null) {
            d0Var3.d();
        }
        if (st.g == null) {
            if (isActionBarMenu) {
                y0();
            }
            a.b.f.j.g gVar = st.h;
            if (gVar == null || st.p) {
                if (gVar == null) {
                    j0(st);
                    if (st.h == null) {
                        return false;
                    }
                }
                if (isActionBarMenu && this.s != null) {
                    if (this.t == null) {
                        this.t = new h();
                    }
                    this.s.b(st.h, this.t);
                }
                st.h.d0();
                if (!cb.onCreatePanelMenu(st.f34a, st.h)) {
                    st.c(null);
                    if (isActionBarMenu && (d0Var = this.s) != null) {
                        d0Var.b(null, this.t);
                    }
                    return false;
                }
                st.p = false;
            }
            st.h.d0();
            Bundle bundle = st.q;
            if (bundle != null) {
                st.h.P(bundle);
                st.q = null;
            }
            if (!cb.onPreparePanel(0, st.g, st.h)) {
                if (isActionBarMenu && (d0Var2 = this.s) != null) {
                    d0Var2.b(null, this.t);
                }
                st.h.c0();
                return false;
            }
            KeyCharacterMap kmap = KeyCharacterMap.load(event != null ? event.getDeviceId() : -1);
            boolean z = kmap.getKeyboardType() != 1;
            st.n = z;
            st.h.setQwertyMode(z);
            st.h.c0();
        }
        st.k = true;
        st.l = false;
        this.O = st;
        return true;
    }

    public void L(a.b.f.j.g menu) {
        if (this.M) {
            return;
        }
        this.M = true;
        this.s.j();
        Window.Callback cb = f0();
        if (cb != null && !this.T) {
            cb.onPanelClosed(108, menu);
        }
        this.M = false;
    }

    public void N(int featureId) {
        O(d0(featureId), true);
    }

    public void O(t st, boolean doCallback) {
        ViewGroup viewGroup;
        d0 d0Var;
        if (doCallback && st.f34a == 0 && (d0Var = this.s) != null && d0Var.e()) {
            L(st.h);
            return;
        }
        WindowManager wm = (WindowManager) this.l.getSystemService("window");
        if (wm != null && st.m && (viewGroup = st.e) != null) {
            wm.removeView(viewGroup);
            if (doCallback) {
                K(st.f34a, st, null);
            }
        }
        st.k = false;
        st.l = false;
        st.m = false;
        st.f = null;
        st.o = true;
        if (this.O == st) {
            this.O = null;
        }
    }

    public final boolean q0(int featureId, KeyEvent event) {
        if (event.getRepeatCount() == 0) {
            t st = d0(featureId);
            if (!st.m) {
                return A0(st, event);
            }
            return false;
        }
        return false;
    }

    public final boolean t0(int featureId, KeyEvent event) {
        d0 d0Var;
        if (this.v != null) {
            return false;
        }
        boolean handled = false;
        t st = d0(featureId);
        if (featureId == 0 && (d0Var = this.s) != null && d0Var.f() && !ViewConfiguration.get(this.l).hasPermanentMenuKey()) {
            if (!this.s.e()) {
                if (!this.T && A0(st, event)) {
                    handled = this.s.a();
                }
            } else {
                handled = this.s.g();
            }
        } else if (st.m || st.l) {
            handled = st.m;
            O(st, true);
        } else if (st.k) {
            boolean show = true;
            if (st.p) {
                st.k = false;
                show = A0(st, event);
            }
            if (show) {
                x0(st, event);
                handled = true;
            }
        }
        if (handled) {
            AudioManager audioManager = (AudioManager) this.l.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return handled;
    }

    public void K(int featureId, t panel, Menu menu) {
        if (menu == null) {
            if (panel == null && featureId >= 0) {
                t[] tVarArr = this.N;
                if (featureId < tVarArr.length) {
                    panel = tVarArr[featureId];
                }
            }
            if (panel != null) {
                menu = panel.h;
            }
        }
        if ((panel == null || panel.m) && !this.T) {
            this.n.a().onPanelClosed(featureId, menu);
        }
    }

    public t Y(Menu menu) {
        t[] panels = this.N;
        int N = panels != null ? panels.length : 0;
        for (int i2 = 0; i2 < N; i2++) {
            t panel = panels[i2];
            if (panel != null && panel.h == menu) {
                return panel;
            }
        }
        return null;
    }

    public t d0(int featureId) {
        t[] tVarArr = this.N;
        t[] ar = tVarArr;
        if (tVarArr == null || ar.length <= featureId) {
            t[] nar = new t[featureId + 1];
            if (ar != null) {
                System.arraycopy(ar, 0, nar, 0, ar.length);
            }
            ar = nar;
            this.N = nar;
        }
        t st = ar[featureId];
        if (st == null) {
            t st2 = new t(featureId);
            ar[featureId] = st2;
            return st2;
        }
        return st;
    }

    public final boolean z0(t st, int keyCode, KeyEvent event, int flags) {
        a.b.f.j.g gVar;
        if (event.isSystem()) {
            return false;
        }
        boolean handled = false;
        if ((st.k || A0(st, event)) && (gVar = st.h) != null) {
            handled = gVar.performShortcut(keyCode, event, flags);
        }
        if (handled && (flags & 1) == 0 && this.s == null) {
            O(st, true);
        }
        return handled;
    }

    public final void k0(int featureId) {
        this.b0 |= 1 << featureId;
        if (!this.a0) {
            v.g0(this.m.getDecorView(), this.c0);
            this.a0 = true;
        }
    }

    public void U(int featureId) {
        t st = d0(featureId);
        if (st.h != null) {
            Bundle savedActionViewStates = new Bundle();
            st.h.Q(savedActionViewStates);
            if (savedActionViewStates.size() > 0) {
                st.q = savedActionViewStates;
            }
            st.h.d0();
            st.h.clear();
        }
        st.p = true;
        st.o = true;
        if ((featureId == 108 || featureId == 0) && this.s != null) {
            t st2 = d0(0);
            st2.k = false;
            A0(st2, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int L0(a.h.k.d0 r18, android.graphics.Rect r19) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.f.L0(a.h.k.d0, android.graphics.Rect):int");
    }

    public final void M0(View v) {
        int b2;
        boolean lightStatusBar = (v.M(v) & 8192) != 0;
        if (lightStatusBar) {
            b2 = a.h.c.a.b(this.l, net.sqlcipher.R.color.abc_decor_view_status_guard_light);
        } else {
            b2 = a.h.c.a.b(this.l, net.sqlcipher.R.color.abc_decor_view_status_guard);
        }
        v.setBackgroundColor(b2);
    }

    public final void H0() {
        if (this.B) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int C0(int featureId) {
        if (featureId == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (featureId == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
        return featureId;
    }

    public void S() {
        d0 d0Var = this.s;
        if (d0Var != null) {
            d0Var.j();
        }
        if (this.x != null) {
            this.m.getDecorView().removeCallbacks(this.y);
            if (this.x.isShowing()) {
                try {
                    this.x.dismiss();
                } catch (IllegalArgumentException e2) {
                }
            }
            this.x = null;
        }
        V();
        t st = d0(0);
        a.b.f.j.g gVar = st.h;
        if (gVar != null) {
            gVar.close();
        }
    }

    public boolean F() {
        return G(true);
    }

    public final boolean G(boolean allowRecreation) {
        if (this.T) {
            return false;
        }
        int nightMode = J();
        int modeToApply = n0(this.l, nightMode);
        boolean applied = J0(modeToApply, allowRecreation);
        if (nightMode == 0) {
            c0(this.l).e();
        } else {
            p pVar = this.Y;
            if (pVar != null) {
                pVar.a();
            }
        }
        if (nightMode == 3) {
            b0(this.l).e();
        } else {
            p pVar2 = this.Z;
            if (pVar2 != null) {
                pVar2.a();
            }
        }
        return applied;
    }

    @Override // a.b.b.e
    public int k() {
        return this.U;
    }

    public int n0(Context context, int mode) {
        switch (mode) {
            case -100:
                return -1;
            case SQLiteCursor.NO_COUNT /* -1 */:
            case 1:
            case 2:
                return mode;
            case 0:
                if (Build.VERSION.SDK_INT >= 23) {
                    UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
                    if (uiModeManager.getNightMode() == 0) {
                        return -1;
                    }
                }
                return c0(context).c();
            case 3:
                return b0(context).c();
            default:
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        }
    }

    public final int J() {
        int i2 = this.U;
        if (i2 != -100) {
            return i2;
        }
        a.b.b.e.j();
        return -100;
    }

    public final Configuration P(Context context, int mode, Configuration configOverlay) {
        int newNightMode;
        switch (mode) {
            case 1:
                newNightMode = 16;
                break;
            case 2:
                newNightMode = 32;
                break;
            default:
                Configuration appConfig = context.getApplicationContext().getResources().getConfiguration();
                newNightMode = appConfig.uiMode & 48;
                break;
        }
        Configuration overrideConf = new Configuration();
        overrideConf.fontScale = 0.0f;
        if (configOverlay != null) {
            overrideConf.setTo(configOverlay);
        }
        overrideConf.uiMode = (overrideConf.uiMode & (-49)) | newNightMode;
        return overrideConf;
    }

    public final boolean J0(int mode, boolean allowRecreation) {
        boolean handled = false;
        Configuration overrideConfig = P(this.l, mode, null);
        boolean activityHandlingUiMode = l0();
        int currentNightMode = this.l.getResources().getConfiguration().uiMode & 48;
        int newNightMode = overrideConfig.uiMode & 48;
        if (currentNightMode != newNightMode && allowRecreation && !activityHandlingUiMode && this.Q && (h || this.R)) {
            Object obj = this.k;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                a.h.b.a.g((Activity) this.k);
                handled = true;
            }
        }
        if (!handled && currentNightMode != newNightMode) {
            K0(newNightMode, activityHandlingUiMode, null);
            handled = true;
        }
        if (handled) {
            Object obj2 = this.k;
            if (obj2 instanceof a.b.b.c) {
                ((a.b.b.c) obj2).D();
            }
        }
        return handled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K0(int uiModeNightModeValue, boolean callOnConfigChange, Configuration configOverlay) {
        Resources res = this.l.getResources();
        Configuration conf = new Configuration(res.getConfiguration());
        if (configOverlay != null) {
            conf.updateFrom(configOverlay);
        }
        conf.uiMode = (res.getConfiguration().uiMode & (-49)) | uiModeNightModeValue;
        res.updateConfiguration(conf, null);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            a.b.b.j.a(res);
        }
        int i3 = this.V;
        if (i3 != 0) {
            this.l.setTheme(i3);
            if (i2 >= 23) {
                this.l.getTheme().applyStyle(this.V, true);
            }
        }
        if (callOnConfigChange) {
            Object obj = this.k;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof a.m.g) {
                    a.m.d lifecycle = ((a.m.g) activity).a();
                    if (lifecycle.b().a(d.b.STARTED)) {
                        activity.onConfigurationChanged(conf);
                        return;
                    }
                    return;
                }
                if (this.S) {
                    activity.onConfigurationChanged(conf);
                }
            }
        }
    }

    public final p c0(Context context) {
        if (this.Y == null) {
            this.Y = new q(a.b.b.l.a(context));
        }
        return this.Y;
    }

    public final p b0(Context context) {
        if (this.Z == null) {
            this.Z = new o(context);
        }
        return this.Z;
    }

    public final boolean l0() {
        if (!this.X && (this.k instanceof Activity)) {
            PackageManager pm = this.l.getPackageManager();
            if (pm == null) {
                return false;
            }
            int flags = 0;
            try {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 29) {
                    flags = 269221888;
                } else if (i2 >= 24) {
                    flags = 786432;
                }
                ActivityInfo info = pm.getActivityInfo(new ComponentName(this.l, this.k.getClass()), flags);
                this.W = (info == null || (info.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.W = false;
            }
        }
        this.X = true;
        return this.W;
    }

    /* loaded from: classes.dex */
    public class i implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public b.a f28a;

        public i(b.a wrapped) {
            this.f28a = wrapped;
        }

        @Override // a.b.f.b.a
        public boolean d(a.b.f.b mode, Menu menu) {
            return this.f28a.d(mode, menu);
        }

        @Override // a.b.f.b.a
        public boolean a(a.b.f.b mode, Menu menu) {
            v.l0(f.this.C);
            return this.f28a.a(mode, menu);
        }

        @Override // a.b.f.b.a
        public boolean c(a.b.f.b mode, MenuItem item) {
            return this.f28a.c(mode, item);
        }

        @Override // a.b.f.b.a
        public void b(a.b.f.b mode) {
            this.f28a.b(mode);
            f fVar = f.this;
            if (fVar.x != null) {
                fVar.m.getDecorView().removeCallbacks(f.this.y);
            }
            f fVar2 = f.this;
            if (fVar2.w != null) {
                fVar2.V();
                f fVar3 = f.this;
                z d = v.d(fVar3.w);
                d.a(0.0f);
                fVar3.z = d;
                f.this.z.f(new a());
            }
            f fVar4 = f.this;
            a.b.b.d dVar = fVar4.o;
            if (dVar != null) {
                dVar.f(fVar4.v);
            }
            f fVar5 = f.this;
            fVar5.v = null;
            v.l0(fVar5.C);
        }

        /* loaded from: classes.dex */
        public class a extends b0 {
            public a() {
            }

            @Override // a.h.k.a0
            public void a(View view) {
                f.this.w.setVisibility(8);
                f fVar = f.this;
                PopupWindow popupWindow = fVar.x;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (fVar.w.getParent() instanceof View) {
                    v.l0((View) f.this.w.getParent());
                }
                f.this.w.k();
                f.this.z.f(null);
                f fVar2 = f.this;
                fVar2.z = null;
                v.l0(fVar2.C);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class u implements m.a {
        public u() {
        }

        @Override // a.b.f.j.m.a
        public void b(a.b.f.j.g menu, boolean allMenusAreClosing) {
            Menu parentMenu = menu.D();
            boolean isSubMenu = parentMenu != menu;
            t panel = f.this.Y(isSubMenu ? parentMenu : menu);
            if (panel != null) {
                if (isSubMenu) {
                    f.this.K(panel.f34a, panel, parentMenu);
                    f.this.O(panel, true);
                } else {
                    f.this.O(panel, allMenusAreClosing);
                }
            }
        }

        @Override // a.b.f.j.m.a
        public boolean c(a.b.f.j.g subMenu) {
            Window.Callback cb;
            if (subMenu == subMenu.D()) {
                f fVar = f.this;
                if (fVar.H && (cb = fVar.f0()) != null && !f.this.T) {
                    cb.onMenuOpened(108, subMenu);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class h implements m.a {
        public h() {
        }

        @Override // a.b.f.j.m.a
        public boolean c(a.b.f.j.g subMenu) {
            Window.Callback cb = f.this.f0();
            if (cb != null) {
                cb.onMenuOpened(108, subMenu);
                return true;
            }
            return true;
        }

        @Override // a.b.f.j.m.a
        public void b(a.b.f.j.g menu, boolean allMenusAreClosing) {
            f.this.L(menu);
        }
    }

    /* loaded from: classes.dex */
    public static final class t {

        /* renamed from: a, reason: collision with root package name */
        public int f34a;

        /* renamed from: b, reason: collision with root package name */
        public int f35b;
        public int c;
        public int d;
        public ViewGroup e;
        public View f;
        public View g;
        public a.b.f.j.g h;
        public a.b.f.j.e i;
        public Context j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o = false;
        public boolean p;
        public Bundle q;

        public t(int featureId) {
            this.f34a = featureId;
        }

        public boolean b() {
            if (this.f == null) {
                return false;
            }
            return this.g != null || ((e.a) this.i.a()).getCount() > 0;
        }

        public void d(Context context) {
            TypedValue outValue = new TypedValue();
            Resources.Theme widgetTheme = context.getResources().newTheme();
            widgetTheme.setTo(context.getTheme());
            widgetTheme.resolveAttribute(net.sqlcipher.R.attr.actionBarPopupTheme, outValue, true);
            int i = outValue.resourceId;
            if (i != 0) {
                widgetTheme.applyStyle(i, true);
            }
            widgetTheme.resolveAttribute(net.sqlcipher.R.attr.panelMenuListTheme, outValue, true);
            int i2 = outValue.resourceId;
            if (i2 != 0) {
                widgetTheme.applyStyle(i2, true);
            } else {
                widgetTheme.applyStyle(net.sqlcipher.R.style.Theme_AppCompat_CompactMenu, true);
            }
            Context context2 = new a.b.f.d(context, 0);
            context2.getTheme().setTo(widgetTheme);
            this.j = context2;
            TypedArray a2 = context2.obtainStyledAttributes(a.b.a.j);
            int[] iArr = a.b.a.f11a;
            this.f35b = a2.getResourceId(86, 0);
            this.d = a2.getResourceId(1, 0);
            a2.recycle();
        }

        public void c(a.b.f.j.g menu) {
            a.b.f.j.e eVar;
            a.b.f.j.g gVar = this.h;
            if (menu == gVar) {
                return;
            }
            if (gVar != null) {
                gVar.O(this.i);
            }
            this.h = menu;
            if (menu == null || (eVar = this.i) == null) {
                return;
            }
            menu.b(eVar);
        }

        public a.b.f.j.n a(m.a cb) {
            if (this.h == null) {
                return null;
            }
            if (this.i == null) {
                a.b.f.j.e eVar = new a.b.f.j.e(this.j, net.sqlcipher.R.layout.abc_list_menu_item_layout);
                this.i = eVar;
                eVar.d(cb);
                this.h.b(this.i);
            }
            a.b.f.j.n result = this.i.e(this.e);
            return result;
        }
    }

    /* loaded from: classes.dex */
    public class s extends ContentFrameLayout {
        public s(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent event) {
            return f.this.T(event) || super.dispatchKeyEvent(event);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent event) {
            int action = event.getAction();
            if (action == 0) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                if (c(x, y)) {
                    f.this.N(0);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(event);
        }

        @Override // android.view.View
        public void setBackgroundResource(int resid) {
            setBackgroundDrawable(a.b.c.a.a.d(getContext(), resid));
        }

        public final boolean c(int x, int y) {
            return x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5;
        }
    }

    /* loaded from: classes.dex */
    public class n extends a.b.f.i {
        public n(Window.Callback callback) {
            super(callback);
        }

        @Override // a.b.f.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent event) {
            return f.this.T(event) || super.dispatchKeyEvent(event);
        }

        @Override // a.b.f.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent event) {
            return super.dispatchKeyShortcutEvent(event) || f.this.r0(event.getKeyCode(), event);
        }

        @Override // a.b.f.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int featureId, Menu menu) {
            if (featureId == 0 && !(menu instanceof a.b.f.j.g)) {
                return false;
            }
            return super.onCreatePanelMenu(featureId, menu);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // a.b.f.i, android.view.Window.Callback
        public boolean onPreparePanel(int featureId, View view, Menu menu) {
            a.b.f.j.g mb = menu instanceof a.b.f.j.g ? (a.b.f.j.g) menu : null;
            if (featureId == 0 && mb == null) {
                return false;
            }
            if (mb != null) {
                mb.a0(true);
            }
            boolean handled = super.onPreparePanel(featureId, view, menu);
            if (mb != null) {
                mb.a0(false);
            }
            return handled;
        }

        @Override // a.b.f.i, android.view.Window.Callback
        public boolean onMenuOpened(int featureId, Menu menu) {
            super.onMenuOpened(featureId, menu);
            f.this.u0(featureId);
            return true;
        }

        @Override // a.b.f.i, android.view.Window.Callback
        public void onPanelClosed(int featureId, Menu menu) {
            super.onPanelClosed(featureId, menu);
            f.this.v0(featureId);
        }

        @Override // a.b.f.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (f.this.m0()) {
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        public final ActionMode b(ActionMode.Callback callback) {
            f.a callbackWrapper = new f.a(f.this.l, callback);
            a.b.f.b supportActionMode = f.this.F0(callbackWrapper);
            if (supportActionMode != null) {
                return callbackWrapper.e(supportActionMode);
            }
            return null;
        }

        @Override // a.b.f.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
            if (f.this.m0()) {
                switch (type) {
                    case 0:
                        return b(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, type);
        }

        @Override // a.b.f.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
            t panel = f.this.d0(0);
            a.b.f.j.g gVar = panel.h;
            if (gVar != null) {
                super.onProvideKeyboardShortcuts(data, gVar, deviceId);
            } else {
                super.onProvideKeyboardShortcuts(data, menu, deviceId);
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class p {

        /* renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f31a;

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public p() {
        }

        public void e() {
            a();
            IntentFilter filter = b();
            if (filter == null || filter.countActions() == 0) {
                return;
            }
            if (this.f31a == null) {
                this.f31a = new a();
            }
            f.this.l.registerReceiver(this.f31a, filter);
        }

        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                p.this.d();
            }
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f31a;
            if (broadcastReceiver != null) {
                try {
                    f.this.l.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException e) {
                }
                this.f31a = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class q extends p {
        public final a.b.b.l c;

        public q(a.b.b.l twilightManager) {
            super();
            this.c = twilightManager;
        }

        @Override // a.b.b.f.p
        public int c() {
            return this.c.d() ? 2 : 1;
        }

        @Override // a.b.b.f.p
        public void d() {
            f.this.F();
        }

        @Override // a.b.b.f.p
        public IntentFilter b() {
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.TIME_SET");
            filter.addAction("android.intent.action.TIMEZONE_CHANGED");
            filter.addAction("android.intent.action.TIME_TICK");
            return filter;
        }
    }

    /* loaded from: classes.dex */
    public class o extends p {
        public final PowerManager c;

        public o(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // a.b.b.f.p
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !k.a(this.c)) ? 1 : 2;
        }

        @Override // a.b.b.f.p
        public void d() {
            f.this.F();
        }

        @Override // a.b.b.f.p
        public IntentFilter b() {
            if (Build.VERSION.SDK_INT >= 21) {
                IntentFilter filter = new IntentFilter();
                filter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return filter;
            }
            return null;
        }
    }

    public static Configuration Z(Configuration base, Configuration change) {
        Configuration delta = new Configuration();
        delta.fontScale = 0.0f;
        if (change == null || base.diff(change) == 0) {
            return delta;
        }
        float f2 = base.fontScale;
        float f3 = change.fontScale;
        if (f2 != f3) {
            delta.fontScale = f3;
        }
        int i2 = base.mcc;
        int i3 = change.mcc;
        if (i2 != i3) {
            delta.mcc = i3;
        }
        int i4 = base.mnc;
        int i5 = change.mnc;
        if (i4 != i5) {
            delta.mnc = i5;
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 24) {
            l.a(base, change, delta);
        } else if (!a.h.j.d.a(base.locale, change.locale)) {
            delta.locale = change.locale;
        }
        int i7 = base.touchscreen;
        int i8 = change.touchscreen;
        if (i7 != i8) {
            delta.touchscreen = i8;
        }
        int i9 = base.keyboard;
        int i10 = change.keyboard;
        if (i9 != i10) {
            delta.keyboard = i10;
        }
        int i11 = base.keyboardHidden;
        int i12 = change.keyboardHidden;
        if (i11 != i12) {
            delta.keyboardHidden = i12;
        }
        int i13 = base.navigation;
        int i14 = change.navigation;
        if (i13 != i14) {
            delta.navigation = i14;
        }
        int i15 = base.navigationHidden;
        int i16 = change.navigationHidden;
        if (i15 != i16) {
            delta.navigationHidden = i16;
        }
        int i17 = base.orientation;
        int i18 = change.orientation;
        if (i17 != i18) {
            delta.orientation = i18;
        }
        int i19 = base.screenLayout & 15;
        int i20 = change.screenLayout;
        if (i19 != (i20 & 15)) {
            delta.screenLayout |= i20 & 15;
        }
        int i21 = base.screenLayout & 192;
        int i22 = change.screenLayout;
        if (i21 != (i22 & 192)) {
            delta.screenLayout |= i22 & 192;
        }
        int i23 = base.screenLayout & 48;
        int i24 = change.screenLayout;
        if (i23 != (i24 & 48)) {
            delta.screenLayout |= i24 & 48;
        }
        int i25 = base.screenLayout & 768;
        int i26 = change.screenLayout;
        if (i25 != (i26 & 768)) {
            delta.screenLayout |= i26 & 768;
        }
        if (i6 >= 26) {
            m.a(base, change, delta);
        }
        int i27 = base.uiMode & 15;
        int i28 = change.uiMode;
        if (i27 != (i28 & 15)) {
            delta.uiMode |= i28 & 15;
        }
        int i29 = base.uiMode & 48;
        int i30 = change.uiMode;
        if (i29 != (i30 & 48)) {
            delta.uiMode |= i30 & 48;
        }
        int i31 = base.screenWidthDp;
        int i32 = change.screenWidthDp;
        if (i31 != i32) {
            delta.screenWidthDp = i32;
        }
        int i33 = base.screenHeightDp;
        int i34 = change.screenHeightDp;
        if (i33 != i34) {
            delta.screenHeightDp = i34;
        }
        int i35 = base.smallestScreenWidthDp;
        int i36 = change.smallestScreenWidthDp;
        if (i35 != i36) {
            delta.smallestScreenWidthDp = i36;
        }
        if (i6 >= 17) {
            j.b(base, change, delta);
        }
        return delta;
    }

    /* loaded from: classes.dex */
    public static class j {
        public static void b(Configuration base, Configuration change, Configuration delta) {
            int i = base.densityDpi;
            int i2 = change.densityDpi;
            if (i != i2) {
                delta.densityDpi = i2;
            }
        }

        public static Context a(Context context, Configuration overrideConfiguration) {
            return context.createConfigurationContext(overrideConfiguration);
        }
    }

    /* loaded from: classes.dex */
    public static class k {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    /* loaded from: classes.dex */
    public static class l {
        public static void a(Configuration base, Configuration change, Configuration delta) {
            LocaleList baseLocales = base.getLocales();
            LocaleList changeLocales = change.getLocales();
            if (!baseLocales.equals(changeLocales)) {
                delta.setLocales(changeLocales);
                delta.locale = change.locale;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class m {
        public static void a(Configuration base, Configuration change, Configuration delta) {
            int i = base.colorMode & 3;
            int i2 = change.colorMode;
            if (i != (i2 & 3)) {
                delta.colorMode |= i2 & 3;
            }
            int i3 = base.colorMode & 12;
            int i4 = change.colorMode;
            if (i3 != (i4 & 12)) {
                delta.colorMode |= i4 & 12;
            }
        }
    }
}
