package a.b.f.j;

import a.b.f.j.m;
import a.b.g.m0;
import a.h.k.v;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    public static final int c = R.layout.abc_popup_menu_item_layout;
    public final Context d;
    public final g e;
    public final f f;
    public final boolean g;
    public final int h;
    public final int i;
    public final int j;
    public final m0 k;
    public PopupWindow.OnDismissListener n;
    public View o;
    public View p;
    public m.a q;
    public ViewTreeObserver r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean w;
    public final ViewTreeObserver.OnGlobalLayoutListener l = new a();
    public final View.OnAttachStateChangeListener m = new b();
    public int v = 0;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (q.this.a() && !q.this.k.B()) {
                View anchor = q.this.p;
                if (anchor == null || !anchor.isShown()) {
                    q.this.dismiss();
                } else {
                    q.this.k.i();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            ViewTreeObserver viewTreeObserver = q.this.r;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.r = v.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.r.removeGlobalOnLayoutListener(qVar.l);
            }
            v.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g menu, View anchorView, int popupStyleAttr, int popupStyleRes, boolean overflowOnly) {
        this.d = context;
        this.e = menu;
        this.g = overflowOnly;
        LayoutInflater inflater = LayoutInflater.from(context);
        this.f = new f(menu, inflater, overflowOnly, R.layout.abc_popup_menu_item_layout);
        this.i = popupStyleAttr;
        this.j = popupStyleRes;
        Resources res = context.getResources();
        this.h = Math.max(res.getDisplayMetrics().widthPixels / 2, res.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.o = anchorView;
        this.k = new m0(context, null, popupStyleAttr, popupStyleRes);
        menu.c(this, context);
    }

    @Override // a.b.f.j.k
    public void r(boolean forceShow) {
        this.f.d(forceShow);
    }

    @Override // a.b.f.j.k
    public void s(int gravity) {
        this.v = gravity;
    }

    public final boolean z() {
        View view;
        if (a()) {
            return true;
        }
        if (this.s || (view = this.o) == null) {
            return false;
        }
        this.p = view;
        this.k.K(this);
        this.k.L(this);
        this.k.J(true);
        View anchor = this.p;
        boolean addGlobalListener = this.r == null;
        ViewTreeObserver viewTreeObserver = anchor.getViewTreeObserver();
        this.r = viewTreeObserver;
        if (addGlobalListener) {
            viewTreeObserver.addOnGlobalLayoutListener(this.l);
        }
        anchor.addOnAttachStateChangeListener(this.m);
        this.k.D(anchor);
        this.k.G(this.v);
        if (!this.t) {
            this.u = k.o(this.f, null, this.d, this.h);
            this.t = true;
        }
        this.k.F(this.u);
        this.k.I(2);
        this.k.H(n());
        this.k.i();
        ListView listView = this.k.e();
        listView.setOnKeyListener(this);
        if (this.w && this.e.x() != null) {
            FrameLayout titleItemView = (FrameLayout) LayoutInflater.from(this.d).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView titleView = (TextView) titleItemView.findViewById(android.R.id.title);
            if (titleView != null) {
                titleView.setText(this.e.x());
            }
            titleItemView.setEnabled(false);
            listView.addHeaderView(titleItemView, null, false);
        }
        this.k.o(this.f);
        this.k.i();
        return true;
    }

    @Override // a.b.f.j.p
    public void i() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // a.b.f.j.p
    public void dismiss() {
        if (a()) {
            this.k.dismiss();
        }
    }

    @Override // a.b.f.j.k
    public void l(g menu) {
    }

    @Override // a.b.f.j.p
    public boolean a() {
        return !this.s && this.k.a();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.s = true;
        this.e.close();
        ViewTreeObserver viewTreeObserver = this.r;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.r = this.p.getViewTreeObserver();
            }
            this.r.removeGlobalOnLayoutListener(this.l);
            this.r = null;
        }
        this.p.removeOnAttachStateChangeListener(this.m);
        PopupWindow.OnDismissListener onDismissListener = this.n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // a.b.f.j.m
    public void h(boolean cleared) {
        this.t = false;
        f fVar = this.f;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // a.b.f.j.m
    public void d(m.a cb) {
        this.q = cb;
    }

    @Override // a.b.f.j.m
    public boolean f(r subMenu) {
        if (subMenu.hasVisibleItems()) {
            l subPopup = new l(this.d, subMenu, this.p, this.g, this.i, this.j);
            subPopup.j(this.q);
            subPopup.g(k.x(subMenu));
            subPopup.i(this.n);
            this.n = null;
            this.e.e(false);
            int horizontalOffset = this.k.d();
            int verticalOffset = this.k.j();
            int hgrav = Gravity.getAbsoluteGravity(this.v, v.C(this.o)) & 7;
            if (hgrav == 5) {
                horizontalOffset += this.o.getWidth();
            }
            if (subPopup.n(horizontalOffset, verticalOffset)) {
                m.a aVar = this.q;
                if (aVar != null) {
                    aVar.c(subMenu);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // a.b.f.j.m
    public void b(g menu, boolean allMenusAreClosing) {
        if (menu != this.e) {
            return;
        }
        dismiss();
        m.a aVar = this.q;
        if (aVar != null) {
            aVar.b(menu, allMenusAreClosing);
        }
    }

    @Override // a.b.f.j.m
    public boolean g() {
        return false;
    }

    @Override // a.b.f.j.k
    public void p(View anchor) {
        this.o = anchor;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == 1 && keyCode == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // a.b.f.j.k
    public void u(PopupWindow.OnDismissListener listener) {
        this.n = listener;
    }

    @Override // a.b.f.j.p
    public ListView e() {
        return this.k.e();
    }

    @Override // a.b.f.j.k
    public void t(int x) {
        this.k.c(x);
    }

    @Override // a.b.f.j.k
    public void w(int y) {
        this.k.m(y);
    }

    @Override // a.b.f.j.k
    public void v(boolean showTitle) {
        this.w = showTitle;
    }
}
