package a.b.f.j;

import a.b.f.j.m;
import a.b.g.l0;
import a.b.g.m0;
import a.h.k.v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int c = R.layout.abc_cascading_menu_item_layout;
    public ViewTreeObserver A;
    public PopupWindow.OnDismissListener B;
    public boolean C;
    public final Context d;
    public final int e;
    public final int f;
    public final int g;
    public final boolean h;
    public final Handler i;
    public View q;
    public View r;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public boolean y;
    public m.a z;
    public final List<g> j = new ArrayList();
    public final List<C0006d> k = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener l = new a();
    public final View.OnAttachStateChangeListener m = new b();
    public final l0 n = new c();
    public int o = 0;
    public int p = 0;
    public boolean x = false;
    public int s = D();

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.a() && d.this.k.size() > 0 && !d.this.k.get(0).f102a.B()) {
                View anchor = d.this.r;
                if (anchor == null || !anchor.isShown()) {
                    d.this.dismiss();
                    return;
                }
                for (C0006d info : d.this.k) {
                    info.f102a.i();
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
            ViewTreeObserver viewTreeObserver = d.this.A;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.A = v.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.A.removeGlobalOnLayoutListener(dVar.l);
            }
            v.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    public class c implements l0 {
        public c() {
        }

        @Override // a.b.g.l0
        public void k(g menu, MenuItem item) {
            d.this.i.removeCallbacksAndMessages(menu);
        }

        @Override // a.b.g.l0
        public void g(g menu, MenuItem item) {
            C0006d nextInfo;
            d.this.i.removeCallbacksAndMessages(null);
            int menuIndex = -1;
            int i = 0;
            int count = d.this.k.size();
            while (true) {
                if (i >= count) {
                    break;
                }
                if (menu != d.this.k.get(i).f103b) {
                    i++;
                } else {
                    menuIndex = i;
                    break;
                }
            }
            if (menuIndex == -1) {
                return;
            }
            int nextIndex = menuIndex + 1;
            if (nextIndex < d.this.k.size()) {
                nextInfo = d.this.k.get(nextIndex);
            } else {
                nextInfo = null;
            }
            Runnable runnable = new a(nextInfo, item, menu);
            long uptimeMillis = SystemClock.uptimeMillis() + 200;
            d.this.i.postAtTime(runnable, menu, uptimeMillis);
        }

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0006d f101b;
            public final /* synthetic */ MenuItem c;
            public final /* synthetic */ g d;

            public a(C0006d c0006d, MenuItem menuItem, g gVar) {
                this.f101b = c0006d;
                this.c = menuItem;
                this.d = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0006d c0006d = this.f101b;
                if (c0006d != null) {
                    d.this.C = true;
                    c0006d.f103b.e(false);
                    d.this.C = false;
                }
                if (this.c.isEnabled() && this.c.hasSubMenu()) {
                    this.d.L(this.c, 4);
                }
            }
        }
    }

    public d(Context context, View anchor, int popupStyleAttr, int popupStyleRes, boolean overflowOnly) {
        this.d = context;
        this.q = anchor;
        this.f = popupStyleAttr;
        this.g = popupStyleRes;
        this.h = overflowOnly;
        Resources res = context.getResources();
        this.e = Math.max(res.getDisplayMetrics().widthPixels / 2, res.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.i = new Handler();
    }

    @Override // a.b.f.j.k
    public void r(boolean forceShow) {
        this.x = forceShow;
    }

    public final m0 z() {
        m0 popupWindow = new m0(this.d, null, this.f, this.g);
        popupWindow.T(this.n);
        popupWindow.L(this);
        popupWindow.K(this);
        popupWindow.D(this.q);
        popupWindow.G(this.p);
        popupWindow.J(true);
        popupWindow.I(2);
        return popupWindow;
    }

    @Override // a.b.f.j.p
    public void i() {
        if (a()) {
            return;
        }
        for (g menu : this.j) {
            F(menu);
        }
        this.j.clear();
        View view = this.q;
        this.r = view;
        if (view != null) {
            boolean addGlobalListener = this.A == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.A = viewTreeObserver;
            if (addGlobalListener) {
                viewTreeObserver.addOnGlobalLayoutListener(this.l);
            }
            this.r.addOnAttachStateChangeListener(this.m);
        }
    }

    @Override // a.b.f.j.p
    public void dismiss() {
        int length = this.k.size();
        if (length > 0) {
            C0006d[] addedMenus = (C0006d[]) this.k.toArray(new C0006d[length]);
            for (int i = length - 1; i >= 0; i--) {
                C0006d info = addedMenus[i];
                if (info.f102a.a()) {
                    info.f102a.dismiss();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == 1 && keyCode == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    public final int D() {
        int layoutDirection = v.C(this.q);
        return layoutDirection == 1 ? 0 : 1;
    }

    public final int E(int nextMenuWidth) {
        List<C0006d> list = this.k;
        ListView lastListView = list.get(list.size() - 1).a();
        int[] screenLocation = new int[2];
        lastListView.getLocationOnScreen(screenLocation);
        Rect displayFrame = new Rect();
        this.r.getWindowVisibleDisplayFrame(displayFrame);
        if (this.s == 1) {
            int right = screenLocation[0] + lastListView.getWidth() + nextMenuWidth;
            return right > displayFrame.right ? 0 : 1;
        }
        int right2 = screenLocation[0];
        int left = right2 - nextMenuWidth;
        return left < 0 ? 1 : 0;
    }

    @Override // a.b.f.j.k
    public void l(g menu) {
        menu.c(this, this.d);
        if (a()) {
            F(menu);
        } else {
            this.j.add(menu);
        }
    }

    public final void F(g menu) {
        C0006d parentInfo;
        View parentView;
        int parentOffsetX;
        int parentOffsetY;
        int x;
        LayoutInflater from = LayoutInflater.from(this.d);
        f adapter = new f(menu, from, this.h, R.layout.abc_cascading_menu_item_layout);
        if (!a() && this.x) {
            adapter.d(true);
        } else if (a()) {
            adapter.d(k.x(menu));
        }
        int menuWidth = k.o(adapter, null, this.d, this.e);
        m0 popupWindow = z();
        popupWindow.o(adapter);
        popupWindow.F(menuWidth);
        popupWindow.G(this.p);
        if (this.k.size() > 0) {
            List<C0006d> list = this.k;
            parentInfo = list.get(list.size() - 1);
            parentView = C(parentInfo, menu);
        } else {
            parentInfo = null;
            parentView = null;
        }
        if (parentView != null) {
            popupWindow.U(false);
            popupWindow.R(null);
            int nextMenuPosition = E(menuWidth);
            boolean showOnRight = nextMenuPosition == 1;
            this.s = nextMenuPosition;
            if (Build.VERSION.SDK_INT >= 26) {
                popupWindow.D(parentView);
                parentOffsetX = 0;
                parentOffsetY = 0;
            } else {
                int[] anchorScreenLocation = new int[2];
                this.q.getLocationOnScreen(anchorScreenLocation);
                int[] parentViewScreenLocation = new int[2];
                parentView.getLocationOnScreen(parentViewScreenLocation);
                if ((this.p & 7) == 5) {
                    anchorScreenLocation[0] = anchorScreenLocation[0] + this.q.getWidth();
                    parentViewScreenLocation[0] = parentViewScreenLocation[0] + parentView.getWidth();
                }
                parentOffsetX = parentViewScreenLocation[0] - anchorScreenLocation[0];
                parentOffsetY = parentViewScreenLocation[1] - anchorScreenLocation[1];
            }
            if ((this.p & 5) == 5) {
                if (showOnRight) {
                    x = parentOffsetX + menuWidth;
                } else {
                    int x2 = parentView.getWidth();
                    x = parentOffsetX - x2;
                }
            } else if (showOnRight) {
                x = parentView.getWidth() + parentOffsetX;
            } else {
                x = parentOffsetX - menuWidth;
            }
            popupWindow.c(x);
            popupWindow.M(true);
            popupWindow.m(parentOffsetY);
        } else {
            if (this.t) {
                popupWindow.c(this.v);
            }
            if (this.u) {
                popupWindow.m(this.w);
            }
            Rect epicenterBounds = n();
            popupWindow.H(epicenterBounds);
        }
        C0006d menuInfo = new C0006d(popupWindow, menu, this.s);
        this.k.add(menuInfo);
        popupWindow.i();
        ListView listView = popupWindow.e();
        listView.setOnKeyListener(this);
        if (parentInfo == null && this.y && menu.x() != null) {
            FrameLayout titleItemView = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView titleView = (TextView) titleItemView.findViewById(android.R.id.title);
            titleItemView.setEnabled(false);
            titleView.setText(menu.x());
            listView.addHeaderView(titleItemView, null, false);
            popupWindow.i();
        }
    }

    public final MenuItem B(g parent, g submenu) {
        int count = parent.size();
        for (int i = 0; i < count; i++) {
            MenuItem item = parent.getItem(i);
            if (item.hasSubMenu() && submenu == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View C(C0006d parentInfo, g submenu) {
        int headersCount;
        f menuAdapter;
        int ownerViewPosition;
        MenuItem owner = B(parentInfo.f103b, submenu);
        if (owner == null) {
            return null;
        }
        ListView listView = parentInfo.a();
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerAdapter = (HeaderViewListAdapter) listAdapter;
            headersCount = headerAdapter.getHeadersCount();
            menuAdapter = (f) headerAdapter.getWrappedAdapter();
        } else {
            headersCount = 0;
            menuAdapter = (f) listAdapter;
        }
        int ownerPosition = -1;
        int i = 0;
        int count = menuAdapter.getCount();
        while (true) {
            if (i >= count) {
                break;
            }
            if (owner != menuAdapter.getItem(i)) {
                i++;
            } else {
                ownerPosition = i;
                break;
            }
        }
        if (ownerPosition == -1 || (ownerViewPosition = (ownerPosition + headersCount) - listView.getFirstVisiblePosition()) < 0 || ownerViewPosition >= listView.getChildCount()) {
            return null;
        }
        return listView.getChildAt(ownerViewPosition);
    }

    @Override // a.b.f.j.p
    public boolean a() {
        return this.k.size() > 0 && this.k.get(0).f102a.a();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0006d dismissedInfo = null;
        int i = 0;
        int count = this.k.size();
        while (true) {
            if (i >= count) {
                break;
            }
            C0006d info = this.k.get(i);
            if (info.f102a.a()) {
                i++;
            } else {
                dismissedInfo = info;
                break;
            }
        }
        if (dismissedInfo != null) {
            dismissedInfo.f103b.e(false);
        }
    }

    @Override // a.b.f.j.m
    public void h(boolean cleared) {
        for (C0006d info : this.k) {
            k.y(info.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // a.b.f.j.m
    public void d(m.a cb) {
        this.z = cb;
    }

    @Override // a.b.f.j.m
    public boolean f(r subMenu) {
        for (C0006d info : this.k) {
            if (subMenu == info.f103b) {
                info.a().requestFocus();
                return true;
            }
        }
        if (subMenu.hasVisibleItems()) {
            l(subMenu);
            m.a aVar = this.z;
            if (aVar != null) {
                aVar.c(subMenu);
            }
            return true;
        }
        return false;
    }

    public final int A(g menu) {
        int count = this.k.size();
        for (int i = 0; i < count; i++) {
            C0006d info = this.k.get(i);
            if (menu == info.f103b) {
                return i;
            }
        }
        return -1;
    }

    @Override // a.b.f.j.m
    public void b(g menu, boolean allMenusAreClosing) {
        int menuIndex = A(menu);
        if (menuIndex < 0) {
            return;
        }
        int nextMenuIndex = menuIndex + 1;
        if (nextMenuIndex < this.k.size()) {
            C0006d childInfo = this.k.get(nextMenuIndex);
            childInfo.f103b.e(false);
        }
        C0006d info = this.k.remove(menuIndex);
        info.f103b.O(this);
        if (this.C) {
            info.f102a.S(null);
            info.f102a.E(0);
        }
        info.f102a.dismiss();
        int count = this.k.size();
        if (count > 0) {
            this.s = this.k.get(count - 1).c;
        } else {
            this.s = D();
        }
        if (count == 0) {
            dismiss();
            m.a aVar = this.z;
            if (aVar != null) {
                aVar.b(menu, true);
            }
            ViewTreeObserver viewTreeObserver = this.A;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.A.removeGlobalOnLayoutListener(this.l);
                }
                this.A = null;
            }
            this.r.removeOnAttachStateChangeListener(this.m);
            this.B.onDismiss();
            return;
        }
        if (allMenusAreClosing) {
            C0006d rootInfo = this.k.get(0);
            rootInfo.f103b.e(false);
        }
    }

    @Override // a.b.f.j.m
    public boolean g() {
        return false;
    }

    @Override // a.b.f.j.k
    public void s(int dropDownGravity) {
        if (this.o != dropDownGravity) {
            this.o = dropDownGravity;
            this.p = a.h.k.e.b(dropDownGravity, v.C(this.q));
        }
    }

    @Override // a.b.f.j.k
    public void p(View anchor) {
        if (this.q != anchor) {
            this.q = anchor;
            this.p = a.h.k.e.b(this.o, v.C(anchor));
        }
    }

    @Override // a.b.f.j.k
    public void u(PopupWindow.OnDismissListener listener) {
        this.B = listener;
    }

    @Override // a.b.f.j.p
    public ListView e() {
        if (this.k.isEmpty()) {
            return null;
        }
        return this.k.get(r0.size() - 1).a();
    }

    @Override // a.b.f.j.k
    public void t(int x) {
        this.t = true;
        this.v = x;
    }

    @Override // a.b.f.j.k
    public void w(int y) {
        this.u = true;
        this.w = y;
    }

    @Override // a.b.f.j.k
    public void v(boolean showTitle) {
        this.y = showTitle;
    }

    @Override // a.b.f.j.k
    public boolean m() {
        return false;
    }

    /* renamed from: a.b.f.j.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0006d {

        /* renamed from: a, reason: collision with root package name */
        public final m0 f102a;

        /* renamed from: b, reason: collision with root package name */
        public final g f103b;
        public final int c;

        public C0006d(m0 window, g menu, int position) {
            this.f102a = window;
            this.f103b = menu;
            this.c = position;
        }

        public ListView a() {
            return this.f102a.e();
        }
    }
}
