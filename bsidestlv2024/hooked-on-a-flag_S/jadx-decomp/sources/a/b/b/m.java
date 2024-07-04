package a.b.b;

import a.b.b.a;
import a.b.f.b;
import a.b.f.j.g;
import a.b.g.e0;
import a.h.k.a0;
import a.h.k.b0;
import a.h.k.c0;
import a.h.k.v;
import a.h.k.z;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class m extends a.b.b.a implements ActionBarOverlayLayout.d {

    /* renamed from: a, reason: collision with root package name */
    public static final Interpolator f51a = new AccelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final Interpolator f52b = new DecelerateInterpolator();
    public final c0 A;
    public Context c;
    public Context d;
    public ActionBarOverlayLayout e;
    public ActionBarContainer f;
    public e0 g;
    public ActionBarContextView h;
    public View i;
    public boolean j;
    public d k;
    public a.b.f.b l;
    public b.a m;
    public boolean n;
    public ArrayList<a.b> o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public a.b.f.h v;
    public boolean w;
    public boolean x;
    public final a0 y;
    public final a0 z;

    /* loaded from: classes.dex */
    public class a extends b0 {
        public a() {
        }

        @Override // a.h.k.a0
        public void a(View view) {
            View view2;
            m mVar = m.this;
            if (mVar.r && (view2 = mVar.i) != null) {
                view2.setTranslationY(0.0f);
                m.this.f.setTranslationY(0.0f);
            }
            m.this.f.setVisibility(8);
            m.this.f.setTransitioning(false);
            m mVar2 = m.this;
            mVar2.v = null;
            mVar2.r();
            ActionBarOverlayLayout actionBarOverlayLayout = m.this.e;
            if (actionBarOverlayLayout != null) {
                v.l0(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends b0 {
        public b() {
        }

        @Override // a.h.k.a0
        public void a(View view) {
            m mVar = m.this;
            mVar.v = null;
            mVar.f.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public class c implements c0 {
        public c() {
        }

        public void a(View view) {
            ((View) m.this.f.getParent()).invalidate();
        }
    }

    public m(Activity activity, boolean overlayMode) {
        new ArrayList();
        this.o = new ArrayList<>();
        this.q = 0;
        this.r = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        Window window = activity.getWindow();
        View decor = window.getDecorView();
        z(decor);
        if (!overlayMode) {
            this.i = decor.findViewById(R.id.content);
        }
    }

    public m(Dialog dialog) {
        new ArrayList();
        this.o = new ArrayList<>();
        this.q = 0;
        this.r = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        z(dialog.getWindow().getDecorView());
    }

    public final void z(View decor) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decor.findViewById(net.sqlcipher.R.id.decor_content_parent);
        this.e = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.g = v(decor.findViewById(net.sqlcipher.R.id.action_bar));
        this.h = (ActionBarContextView) decor.findViewById(net.sqlcipher.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) decor.findViewById(net.sqlcipher.R.id.action_bar_container);
        this.f = actionBarContainer;
        e0 e0Var = this.g;
        if (e0Var == null || this.h == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.c = e0Var.t();
        int current = this.g.j();
        boolean homeAsUp = (current & 4) != 0;
        if (homeAsUp) {
            this.j = true;
        }
        a.b.f.a abp = a.b.f.a.b(this.c);
        I(abp.a() || homeAsUp);
        G(abp.g());
        TypedArray a2 = this.c.obtainStyledAttributes(null, a.b.a.f11a, net.sqlcipher.R.attr.actionBarStyle, 0);
        int[] iArr = a.b.a.f11a;
        if (a2.getBoolean(14, false)) {
            H(true);
        }
        int elevation = a2.getDimensionPixelSize(12, 0);
        if (elevation != 0) {
            F(elevation);
        }
        a2.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e0 v(View view) {
        if (view instanceof e0) {
            return (e0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public void F(float elevation) {
        v.v0(this.f, elevation);
    }

    @Override // a.b.b.a
    public void g(Configuration newConfig) {
        G(a.b.f.a.b(this.c).g());
    }

    public final void G(boolean hasEmbeddedTabs) {
        this.p = hasEmbeddedTabs;
        if (!hasEmbeddedTabs) {
            this.g.o(null);
            this.f.setTabContainer(null);
        } else {
            this.f.setTabContainer(null);
            this.g.o(null);
        }
        boolean isInTabMode = w() == 2;
        this.g.s(!this.p && isInTabMode);
        this.e.setHasNonEmbeddedTabs(!this.p && isInTabMode);
    }

    public void r() {
        b.a aVar = this.m;
        if (aVar != null) {
            aVar.b(this.l);
            this.l = null;
            this.m = null;
        }
    }

    public void C(int visibility) {
        this.q = visibility;
    }

    @Override // a.b.b.a
    public void m(boolean enabled) {
        a.b.f.h hVar;
        this.w = enabled;
        if (!enabled && (hVar = this.v) != null) {
            hVar.a();
        }
    }

    @Override // a.b.b.a
    public void c(boolean isVisible) {
        if (isVisible == this.n) {
            return;
        }
        this.n = isVisible;
        int count = this.o.size();
        for (int i = 0; i < count; i++) {
            this.o.get(i).a(isVisible);
        }
    }

    public void D(boolean showHomeAsUp) {
        E(showHomeAsUp ? 4 : 0, 4);
    }

    public void I(boolean enable) {
        this.g.q(enable);
    }

    @Override // a.b.b.a
    public void n(CharSequence title) {
        this.g.setWindowTitle(title);
    }

    public void E(int options, int mask) {
        int current = this.g.j();
        if ((mask & 4) != 0) {
            this.j = true;
        }
        this.g.u((options & mask) | ((mask ^ (-1)) & current));
    }

    public int w() {
        return this.g.v();
    }

    @Override // a.b.b.a
    public int d() {
        return this.g.j();
    }

    @Override // a.b.b.a
    public a.b.f.b o(b.a callback) {
        d dVar = this.k;
        if (dVar != null) {
            dVar.c();
        }
        this.e.setHideOnContentScrollEnabled(false);
        this.h.k();
        d mode = new d(this.h.getContext(), callback);
        if (mode.t()) {
            this.k = mode;
            mode.k();
            this.h.h(mode);
            p(true);
            this.h.sendAccessibilityEvent(32);
            return mode;
        }
        return null;
    }

    public void u(boolean enabled) {
        this.r = enabled;
    }

    public final void K() {
        if (!this.t) {
            this.t = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.e;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            M(false);
        }
    }

    public void L() {
        if (this.s) {
            this.s = false;
            M(true);
        }
    }

    public final void x() {
        if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.e;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    public void y() {
        if (!this.s) {
            this.s = true;
            M(true);
        }
    }

    public void H(boolean hideOnContentScroll) {
        if (hideOnContentScroll && !this.e.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.x = hideOnContentScroll;
        this.e.setHideOnContentScrollEnabled(hideOnContentScroll);
    }

    public static boolean q(boolean hiddenByApp, boolean hiddenBySystem, boolean showingForMode) {
        if (showingForMode) {
            return true;
        }
        if (!hiddenByApp && !hiddenBySystem) {
            return true;
        }
        return false;
    }

    public final void M(boolean fromSystem) {
        boolean shown = q(false, this.s, this.t);
        if (shown) {
            if (!this.u) {
                this.u = true;
                t(fromSystem);
                return;
            }
            return;
        }
        if (this.u) {
            this.u = false;
            s(fromSystem);
        }
    }

    public void t(boolean fromSystem) {
        View view;
        View view2;
        a.b.f.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        this.f.setVisibility(0);
        if (this.q == 0 && (this.w || fromSystem)) {
            this.f.setTranslationY(0.0f);
            float startingY = -this.f.getHeight();
            if (fromSystem) {
                int[] topLeft = {0, 0};
                this.f.getLocationInWindow(topLeft);
                startingY -= topLeft[1];
            }
            this.f.setTranslationY(startingY);
            a.b.f.h anim = new a.b.f.h();
            z a2 = v.d(this.f).k(0.0f);
            a2.i(this.A);
            anim.c(a2);
            if (this.r && (view2 = this.i) != null) {
                view2.setTranslationY(startingY);
                z d2 = v.d(this.i);
                d2.k(0.0f);
                anim.c(d2);
            }
            anim.f(f52b);
            anim.e(250L);
            anim.g(this.z);
            this.v = anim;
            anim.h();
        } else {
            this.f.setAlpha(1.0f);
            this.f.setTranslationY(0.0f);
            if (this.r && (view = this.i) != null) {
                view.setTranslationY(0.0f);
            }
            this.z.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.e;
        if (actionBarOverlayLayout != null) {
            v.l0(actionBarOverlayLayout);
        }
    }

    public void s(boolean fromSystem) {
        View view;
        a.b.f.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.q == 0 && (this.w || fromSystem)) {
            this.f.setAlpha(1.0f);
            this.f.setTransitioning(true);
            a.b.f.h anim = new a.b.f.h();
            float endingY = -this.f.getHeight();
            if (fromSystem) {
                int[] topLeft = {0, 0};
                this.f.getLocationInWindow(topLeft);
                endingY -= topLeft[1];
            }
            z a2 = v.d(this.f).k(endingY);
            a2.i(this.A);
            anim.c(a2);
            if (this.r && (view = this.i) != null) {
                z d2 = v.d(view);
                d2.k(endingY);
                anim.c(d2);
            }
            anim.f(f51a);
            anim.e(250L);
            anim.g(this.y);
            this.v = anim;
            anim.h();
            return;
        }
        this.y.a(null);
    }

    public void p(boolean toActionMode) {
        z fadeIn;
        z fadeOut;
        if (toActionMode) {
            K();
        } else {
            x();
        }
        if (J()) {
            if (toActionMode) {
                fadeOut = this.g.i(4, 100L);
                fadeIn = this.h.f(0, 200L);
            } else {
                fadeIn = this.g.i(0, 200L);
                fadeOut = this.h.f(8, 100L);
            }
            a.b.f.h set = new a.b.f.h();
            set.d(fadeOut, fadeIn);
            set.h();
            return;
        }
        if (toActionMode) {
            this.g.k(4);
            this.h.setVisibility(0);
        } else {
            this.g.k(0);
            this.h.setVisibility(8);
        }
    }

    public final boolean J() {
        return v.T(this.f);
    }

    @Override // a.b.b.a
    public Context e() {
        if (this.d == null) {
            TypedValue outValue = new TypedValue();
            Resources.Theme currentTheme = this.c.getTheme();
            currentTheme.resolveAttribute(net.sqlcipher.R.attr.actionBarWidgetTheme, outValue, true);
            int targetThemeRes = outValue.resourceId;
            if (targetThemeRes != 0) {
                this.d = new ContextThemeWrapper(this.c, targetThemeRes);
            } else {
                this.d = this.c;
            }
        }
        return this.d;
    }

    public void A() {
        a.b.f.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
            this.v = null;
        }
    }

    public void B() {
    }

    @Override // a.b.b.a
    public boolean b() {
        e0 e0Var = this.g;
        if (e0Var != null && e0Var.m()) {
            this.g.collapseActionView();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public class d extends a.b.f.b implements g.a {
        public final Context d;
        public final a.b.f.j.g e;
        public b.a f;
        public WeakReference<View> g;

        public d(Context context, b.a callback) {
            this.d = context;
            this.f = callback;
            a.b.f.j.g gVar = new a.b.f.j.g(context);
            gVar.S(1);
            this.e = gVar;
            gVar.R(this);
        }

        @Override // a.b.f.b
        public MenuInflater f() {
            return new a.b.f.g(this.d);
        }

        @Override // a.b.f.b
        public Menu e() {
            return this.e;
        }

        @Override // a.b.f.b
        public void c() {
            m mVar = m.this;
            if (mVar.k != this) {
                return;
            }
            mVar.getClass();
            if (!m.q(false, m.this.s, false)) {
                m mVar2 = m.this;
                mVar2.l = this;
                mVar2.m = this.f;
            } else {
                this.f.b(this);
            }
            this.f = null;
            m.this.p(false);
            m.this.h.g();
            m.this.g.p().sendAccessibilityEvent(32);
            m mVar3 = m.this;
            mVar3.e.setHideOnContentScrollEnabled(mVar3.x);
            m.this.k = null;
        }

        @Override // a.b.f.b
        public void k() {
            if (m.this.k != this) {
                return;
            }
            this.e.d0();
            try {
                this.f.a(this, this.e);
            } finally {
                this.e.c0();
            }
        }

        public boolean t() {
            this.e.d0();
            try {
                return this.f.d(this, this.e);
            } finally {
                this.e.c0();
            }
        }

        @Override // a.b.f.b
        public void m(View view) {
            m.this.h.setCustomView(view);
            this.g = new WeakReference<>(view);
        }

        @Override // a.b.f.b
        public void o(CharSequence subtitle) {
            m.this.h.setSubtitle(subtitle);
        }

        @Override // a.b.f.b
        public void r(CharSequence title) {
            m.this.h.setTitle(title);
        }

        @Override // a.b.f.b
        public void q(int resId) {
            r(m.this.c.getResources().getString(resId));
        }

        @Override // a.b.f.b
        public void n(int resId) {
            o(m.this.c.getResources().getString(resId));
        }

        @Override // a.b.f.b
        public CharSequence i() {
            return m.this.h.getTitle();
        }

        @Override // a.b.f.b
        public CharSequence g() {
            return m.this.h.getSubtitle();
        }

        @Override // a.b.f.b
        public void s(boolean titleOptional) {
            super.s(titleOptional);
            m.this.h.setTitleOptional(titleOptional);
        }

        @Override // a.b.f.b
        public boolean l() {
            return m.this.h.j();
        }

        @Override // a.b.f.b
        public View d() {
            WeakReference<View> weakReference = this.g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // a.b.f.j.g.a
        public boolean b(a.b.f.j.g menu, MenuItem item) {
            b.a aVar = this.f;
            if (aVar != null) {
                return aVar.c(this, item);
            }
            return false;
        }

        @Override // a.b.f.j.g.a
        public void a(a.b.f.j.g menu) {
            if (this.f == null) {
                return;
            }
            k();
            m.this.h.l();
        }
    }

    @Override // a.b.b.a
    public void l(boolean enable) {
        if (!this.j) {
            D(enable);
        }
    }

    @Override // a.b.b.a
    public boolean i(int keyCode, KeyEvent event) {
        Menu menu;
        d dVar = this.k;
        if (dVar == null || (menu = dVar.e()) == null) {
            return false;
        }
        KeyCharacterMap kmap = KeyCharacterMap.load(event != null ? event.getDeviceId() : -1);
        menu.setQwertyMode(kmap.getKeyboardType() != 1);
        return ((a.b.f.j.g) menu).performShortcut(keyCode, event, 0);
    }
}
