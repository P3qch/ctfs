package a.b.f.j;

import a.b.f.j.m;
import a.h.k.v;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final Context f120a;

    /* renamed from: b, reason: collision with root package name */
    public final g f121b;
    public final boolean c;
    public final int d;
    public final int e;
    public View f;
    public int g;
    public boolean h;
    public m.a i;
    public k j;
    public PopupWindow.OnDismissListener k;
    public final PopupWindow.OnDismissListener l;

    public l(Context context, g menu, View anchorView, boolean overflowOnly, int popupStyleAttr) {
        this(context, menu, anchorView, overflowOnly, popupStyleAttr, 0);
    }

    public l(Context context, g menu, View anchorView, boolean overflowOnly, int popupStyleAttr, int popupStyleRes) {
        this.g = 8388611;
        this.l = new a();
        this.f120a = context;
        this.f121b = menu;
        this.f = anchorView;
        this.c = overflowOnly;
        this.d = popupStyleAttr;
        this.e = popupStyleRes;
    }

    public void i(PopupWindow.OnDismissListener listener) {
        this.k = listener;
    }

    public void f(View anchor) {
        this.f = anchor;
    }

    public void g(boolean forceShowIcon) {
        this.h = forceShowIcon;
        k kVar = this.j;
        if (kVar != null) {
            kVar.r(forceShowIcon);
        }
    }

    public void h(int gravity) {
        this.g = gravity;
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public k c() {
        if (this.j == null) {
            this.j = a();
        }
        return this.j;
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int x, int y) {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(x, y, true, true);
        return true;
    }

    public final k a() {
        k popup;
        WindowManager windowManager = (WindowManager) this.f120a.getSystemService("window");
        Display display = windowManager.getDefaultDisplay();
        Point displaySize = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(displaySize);
        } else {
            display.getSize(displaySize);
        }
        int smallestWidth = Math.min(displaySize.x, displaySize.y);
        int minSmallestWidthCascading = this.f120a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width);
        boolean enableCascadingSubmenus = smallestWidth >= minSmallestWidthCascading;
        if (enableCascadingSubmenus) {
            popup = new d(this.f120a, this.f, this.d, this.e, this.c);
        } else {
            popup = new q(this.f120a, this.f121b, this.f, this.d, this.e, this.c);
        }
        popup.l(this.f121b);
        popup.u(this.l);
        popup.p(this.f);
        popup.d(this.i);
        popup.r(this.h);
        popup.s(this.g);
        return popup;
    }

    public final void l(int xOffset, int yOffset, boolean useOffsets, boolean showTitle) {
        k popup = c();
        popup.v(showTitle);
        if (useOffsets) {
            int hgrav = a.h.k.e.b(this.g, v.C(this.f)) & 7;
            if (hgrav == 5) {
                xOffset -= this.f.getWidth();
            }
            popup.t(xOffset);
            popup.w(yOffset);
            float density = this.f120a.getResources().getDisplayMetrics().density;
            int halfSize = (int) ((48.0f * density) / 2.0f);
            Rect epicenter = new Rect(xOffset - halfSize, yOffset - halfSize, xOffset + halfSize, yOffset + halfSize);
            popup.q(epicenter);
        }
        popup.i();
    }

    public void b() {
        if (d()) {
            this.j.dismiss();
        }
    }

    public void e() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean d() {
        k kVar = this.j;
        return kVar != null && kVar.a();
    }

    public void j(m.a cb) {
        this.i = cb;
        k kVar = this.j;
        if (kVar != null) {
            kVar.d(cb);
        }
    }

    /* loaded from: classes.dex */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.e();
        }
    }
}
