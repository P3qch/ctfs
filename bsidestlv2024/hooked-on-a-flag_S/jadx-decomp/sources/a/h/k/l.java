package a.h.k;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f470a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f471b;
    public final View c;
    public boolean d;
    public int[] e;

    public l(View view) {
        this.c = view;
    }

    public void m(boolean enabled) {
        if (this.d) {
            v.F0(this.c);
        }
        this.d = enabled;
    }

    public boolean l() {
        return this.d;
    }

    public boolean j() {
        return k(0);
    }

    public boolean k(int type) {
        return h(type) != null;
    }

    public boolean o(int axes) {
        return p(axes, 0);
    }

    public boolean p(int axes, int type) {
        if (k(type)) {
            return true;
        }
        if (l()) {
            View child = this.c;
            for (ViewParent p = this.c.getParent(); p != null; p = p.getParent()) {
                if (y.f(p, child, this.c, axes, type)) {
                    n(type, p);
                    y.e(p, child, this.c, axes, type);
                    return true;
                }
                if (p instanceof View) {
                    child = (View) p;
                }
            }
            return false;
        }
        return false;
    }

    public void q() {
        r(0);
    }

    public void r(int type) {
        ViewParent parent = h(type);
        if (parent != null) {
            y.g(parent, this.c, type);
            n(type, null);
        }
    }

    public boolean f(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return g(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, 0, null);
    }

    public void e(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        g(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed);
    }

    public final boolean g(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        ViewParent parent;
        int startX;
        int startY;
        int[] consumed2;
        if (!l() || (parent = h(type)) == null) {
            return false;
        }
        if (dxConsumed != 0 || dyConsumed != 0 || dxUnconsumed != 0 || dyUnconsumed != 0) {
            if (offsetInWindow == null) {
                startX = 0;
                startY = 0;
            } else {
                this.c.getLocationInWindow(offsetInWindow);
                int startX2 = offsetInWindow[0];
                int startY2 = offsetInWindow[1];
                startX = startX2;
                startY = startY2;
            }
            if (consumed != null) {
                consumed2 = consumed;
            } else {
                int[] consumed3 = i();
                consumed3[0] = 0;
                consumed3[1] = 0;
                consumed2 = consumed3;
            }
            y.d(parent, this.c, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed2);
            if (offsetInWindow != null) {
                this.c.getLocationInWindow(offsetInWindow);
                offsetInWindow[0] = offsetInWindow[0] - startX;
                offsetInWindow[1] = offsetInWindow[1] - startY;
            }
            return true;
        }
        if (offsetInWindow != null) {
            offsetInWindow[0] = 0;
            offsetInWindow[1] = 0;
        }
        return false;
    }

    public boolean c(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return d(dx, dy, consumed, offsetInWindow, 0);
    }

    public boolean d(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        ViewParent parent;
        int startX;
        int startY;
        int[] consumed2;
        if (!l() || (parent = h(type)) == null) {
            return false;
        }
        if (dx != 0 || dy != 0) {
            if (offsetInWindow == null) {
                startX = 0;
                startY = 0;
            } else {
                this.c.getLocationInWindow(offsetInWindow);
                int startX2 = offsetInWindow[0];
                int startY2 = offsetInWindow[1];
                startX = startX2;
                startY = startY2;
            }
            if (consumed != null) {
                consumed2 = consumed;
            } else {
                consumed2 = i();
            }
            consumed2[0] = 0;
            consumed2[1] = 0;
            y.c(parent, this.c, dx, dy, consumed2, type);
            if (offsetInWindow != null) {
                this.c.getLocationInWindow(offsetInWindow);
                offsetInWindow[0] = offsetInWindow[0] - startX;
                offsetInWindow[1] = offsetInWindow[1] - startY;
            }
            return (consumed2[0] == 0 && consumed2[1] == 0) ? false : true;
        }
        if (offsetInWindow != null) {
            offsetInWindow[0] = 0;
            offsetInWindow[1] = 0;
        }
        return false;
    }

    public boolean a(float velocityX, float velocityY, boolean consumed) {
        ViewParent parent;
        if (!l() || (parent = h(0)) == null) {
            return false;
        }
        return y.a(parent, this.c, velocityX, velocityY, consumed);
    }

    public boolean b(float velocityX, float velocityY) {
        ViewParent parent;
        if (!l() || (parent = h(0)) == null) {
            return false;
        }
        return y.b(parent, this.c, velocityX, velocityY);
    }

    public final ViewParent h(int type) {
        switch (type) {
            case 0:
                return this.f470a;
            case 1:
                return this.f471b;
            default:
                return null;
        }
    }

    public final void n(int type, ViewParent p) {
        switch (type) {
            case 0:
                this.f470a = p;
                return;
            case 1:
                this.f471b = p;
                return;
            default:
                return;
        }
    }

    public final int[] i() {
        if (this.e == null) {
            this.e = new int[2];
        }
        return this.e;
    }
}
