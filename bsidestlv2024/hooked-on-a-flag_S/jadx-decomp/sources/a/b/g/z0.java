package a.b.g;

import a.b.f.j.m;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class z0 implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f219a;

    /* renamed from: b, reason: collision with root package name */
    public int f220b;
    public View c;
    public View d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public c n;
    public int o;
    public int p;
    public Drawable q;

    public z0(Toolbar toolbar, boolean style) {
        this(toolbar, style, R.string.abc_action_bar_up_description);
    }

    public z0(Toolbar toolbar, boolean style, int defaultNavigationContentDescription) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f219a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        x0 a2 = x0.v(toolbar.getContext(), null, a.b.a.f11a, R.attr.actionBarStyle, 0);
        int[] iArr = a.b.a.f11a;
        this.q = a2.g(15);
        if (style) {
            CharSequence title = a2.p(27);
            if (!TextUtils.isEmpty(title)) {
                E(title);
            }
            CharSequence subtitle = a2.p(25);
            if (!TextUtils.isEmpty(subtitle)) {
                D(subtitle);
            }
            Drawable logo = a2.g(20);
            if (logo != null) {
                z(logo);
            }
            Drawable icon = a2.g(17);
            if (icon != null) {
                setIcon(icon);
            }
            if (this.g == null && (drawable = this.q) != null) {
                C(drawable);
            }
            u(a2.k(10, 0));
            int customNavId = a2.n(9, 0);
            if (customNavId != 0) {
                x(LayoutInflater.from(this.f219a.getContext()).inflate(customNavId, (ViewGroup) this.f219a, false));
                u(this.f220b | 16);
            }
            int height = a2.m(13, 0);
            if (height > 0) {
                ViewGroup.LayoutParams lp = this.f219a.getLayoutParams();
                lp.height = height;
                this.f219a.setLayoutParams(lp);
            }
            int contentInsetStart = a2.e(7, -1);
            int contentInsetEnd = a2.e(3, -1);
            if (contentInsetStart >= 0 || contentInsetEnd >= 0) {
                this.f219a.H(Math.max(contentInsetStart, 0), Math.max(contentInsetEnd, 0));
            }
            int titleTextStyle = a2.n(28, 0);
            if (titleTextStyle != 0) {
                Toolbar toolbar2 = this.f219a;
                toolbar2.K(toolbar2.getContext(), titleTextStyle);
            }
            int subtitleTextStyle = a2.n(26, 0);
            if (subtitleTextStyle != 0) {
                Toolbar toolbar3 = this.f219a;
                toolbar3.J(toolbar3.getContext(), subtitleTextStyle);
            }
            int popupTheme = a2.n(22, 0);
            if (popupTheme != 0) {
                this.f219a.setPopupTheme(popupTheme);
            }
        } else {
            this.f220b = w();
        }
        a2.w();
        y(defaultNavigationContentDescription);
        this.k = this.f219a.getNavigationContentDescription();
        this.f219a.setNavigationOnClickListener(new y0(this));
    }

    public void y(int defaultNavigationContentDescription) {
        if (defaultNavigationContentDescription == this.p) {
            return;
        }
        this.p = defaultNavigationContentDescription;
        if (TextUtils.isEmpty(this.f219a.getNavigationContentDescription())) {
            A(this.p);
        }
    }

    public final int w() {
        if (this.f219a.getNavigationIcon() == null) {
            return 11;
        }
        int opts = 11 | 4;
        this.q = this.f219a.getNavigationIcon();
        return opts;
    }

    @Override // a.b.g.e0
    public ViewGroup p() {
        return this.f219a;
    }

    @Override // a.b.g.e0
    public Context t() {
        return this.f219a.getContext();
    }

    @Override // a.b.g.e0
    public boolean m() {
        return this.f219a.v();
    }

    @Override // a.b.g.e0
    public void collapseActionView() {
        this.f219a.e();
    }

    @Override // a.b.g.e0
    public void setWindowCallback(Window.Callback cb) {
        this.l = cb;
    }

    @Override // a.b.g.e0
    public void setWindowTitle(CharSequence title) {
        if (!this.h) {
            F(title);
        }
    }

    @Override // a.b.g.e0
    public CharSequence getTitle() {
        return this.f219a.getTitle();
    }

    public void E(CharSequence title) {
        this.h = true;
        F(title);
    }

    public final void F(CharSequence title) {
        this.i = title;
        if ((this.f220b & 8) != 0) {
            this.f219a.setTitle(title);
        }
    }

    public void D(CharSequence subtitle) {
        this.j = subtitle;
        if ((this.f220b & 8) != 0) {
            this.f219a.setSubtitle(subtitle);
        }
    }

    @Override // a.b.g.e0
    public void l() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // a.b.g.e0
    public void r() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // a.b.g.e0
    public void setIcon(int resId) {
        setIcon(resId != 0 ? a.b.c.a.a.d(t(), resId) : null);
    }

    @Override // a.b.g.e0
    public void setIcon(Drawable d) {
        this.e = d;
        I();
    }

    @Override // a.b.g.e0
    public void n(int resId) {
        z(resId != 0 ? a.b.c.a.a.d(t(), resId) : null);
    }

    public void z(Drawable d) {
        this.f = d;
        I();
    }

    public final void I() {
        Drawable logo = null;
        int i = this.f220b;
        if ((i & 2) != 0) {
            if ((i & 1) != 0) {
                Drawable drawable = this.f;
                if (drawable == null) {
                    drawable = this.e;
                }
                logo = drawable;
            } else {
                logo = this.e;
            }
        }
        this.f219a.setLogo(logo);
    }

    @Override // a.b.g.e0
    public boolean f() {
        return this.f219a.d();
    }

    @Override // a.b.g.e0
    public boolean e() {
        return this.f219a.A();
    }

    @Override // a.b.g.e0
    public boolean c() {
        return this.f219a.z();
    }

    @Override // a.b.g.e0
    public boolean a() {
        return this.f219a.N();
    }

    @Override // a.b.g.e0
    public boolean g() {
        return this.f219a.w();
    }

    @Override // a.b.g.e0
    public void d() {
        this.m = true;
    }

    @Override // a.b.g.e0
    public void b(Menu menu, m.a cb) {
        if (this.n == null) {
            c cVar = new c(this.f219a.getContext());
            this.n = cVar;
            cVar.p(R.id.action_menu_presenter);
        }
        this.n.d(cb);
        this.f219a.I((a.b.f.j.g) menu, this.n);
    }

    @Override // a.b.g.e0
    public void h() {
        this.f219a.f();
    }

    @Override // a.b.g.e0
    public int j() {
        return this.f220b;
    }

    @Override // a.b.g.e0
    public void u(int newOpts) {
        View view;
        int oldOpts = this.f220b;
        int changed = oldOpts ^ newOpts;
        this.f220b = newOpts;
        if (changed != 0) {
            if ((changed & 4) != 0) {
                if ((newOpts & 4) != 0) {
                    G();
                }
                H();
            }
            if ((changed & 3) != 0) {
                I();
            }
            if ((changed & 8) != 0) {
                if ((newOpts & 8) != 0) {
                    this.f219a.setTitle(this.i);
                    this.f219a.setSubtitle(this.j);
                } else {
                    this.f219a.setTitle((CharSequence) null);
                    this.f219a.setSubtitle((CharSequence) null);
                }
            }
            if ((changed & 16) != 0 && (view = this.d) != null) {
                if ((newOpts & 16) != 0) {
                    this.f219a.addView(view);
                } else {
                    this.f219a.removeView(view);
                }
            }
        }
    }

    @Override // a.b.g.e0
    public void o(q0 tabView) {
        View view = this.c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f219a;
            if (parent == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = tabView;
        if (tabView != null) {
        }
    }

    @Override // a.b.g.e0
    public void s(boolean collapsible) {
        this.f219a.setCollapsible(collapsible);
    }

    @Override // a.b.g.e0
    public void q(boolean enable) {
    }

    @Override // a.b.g.e0
    public int v() {
        return 0;
    }

    public void x(View view) {
        View view2 = this.d;
        if (view2 != null && (this.f220b & 16) != 0) {
            this.f219a.removeView(view2);
        }
        this.d = view;
        if (view != null && (this.f220b & 16) != 0) {
            this.f219a.addView(view);
        }
    }

    @Override // a.b.g.e0
    public a.h.k.z i(int visibility, long duration) {
        a.h.k.z d = a.h.k.v.d(this.f219a);
        d.a(visibility == 0 ? 1.0f : 0.0f);
        d.d(duration);
        d.f(new a(visibility));
        return d;
    }

    /* loaded from: classes.dex */
    public class a extends a.h.k.b0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f221a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f222b;

        public a(int i) {
            this.f222b = i;
        }

        @Override // a.h.k.b0, a.h.k.a0
        public void b(View view) {
            z0.this.f219a.setVisibility(0);
        }

        @Override // a.h.k.a0
        public void a(View view) {
            if (!this.f221a) {
                z0.this.f219a.setVisibility(this.f222b);
            }
        }

        @Override // a.h.k.b0, a.h.k.a0
        public void c(View view) {
            this.f221a = true;
        }
    }

    public void C(Drawable icon) {
        this.g = icon;
        H();
    }

    public final void H() {
        if ((this.f220b & 4) != 0) {
            Toolbar toolbar = this.f219a;
            Drawable drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f219a.setNavigationIcon((Drawable) null);
    }

    public void B(CharSequence description) {
        this.k = description;
        G();
    }

    public void A(int resId) {
        B(resId == 0 ? null : t().getString(resId));
    }

    public final void G() {
        if ((this.f220b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.f219a.setNavigationContentDescription(this.p);
            } else {
                this.f219a.setNavigationContentDescription(this.k);
            }
        }
    }

    @Override // a.b.g.e0
    public void k(int visible) {
        this.f219a.setVisibility(visible);
    }
}
