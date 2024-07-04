package a.b.g;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class b1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public static b1 f132b;
    public static b1 c;
    public final View d;
    public final CharSequence e;
    public final int f;
    public final Runnable g = new a();
    public final Runnable h = new b();
    public int i;
    public int j;
    public c1 k;
    public boolean l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b1.this.g(false);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b1.this.c();
        }
    }

    public static void f(View view, CharSequence tooltipText) {
        b1 b1Var = f132b;
        if (b1Var != null && b1Var.d == view) {
            e(null);
        }
        if (TextUtils.isEmpty(tooltipText)) {
            b1 b1Var2 = c;
            if (b1Var2 != null && b1Var2.d == view) {
                b1Var2.c();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new b1(view, tooltipText);
    }

    public b1(View anchor, CharSequence tooltipText) {
        this.d = anchor;
        this.e = tooltipText;
        this.f = a.h.k.w.c(ViewConfiguration.get(anchor.getContext()));
        b();
        anchor.setOnLongClickListener(this);
        anchor.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        this.i = v.getWidth() / 2;
        this.j = v.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View v, MotionEvent event) {
        if (this.k != null && this.l) {
            return false;
        }
        AccessibilityManager manager = (AccessibilityManager) this.d.getContext().getSystemService("accessibility");
        if (manager.isEnabled() && manager.isTouchExplorationEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                if (this.d.isEnabled() && this.k == null && h(event)) {
                    e(this);
                    break;
                }
                break;
            case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                b();
                c();
                break;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        c();
    }

    public void g(boolean fromTouch) {
        long timeout;
        if (!a.h.k.v.S(this.d)) {
            return;
        }
        e(null);
        b1 b1Var = c;
        if (b1Var != null) {
            b1Var.c();
        }
        c = this;
        this.l = fromTouch;
        c1 c1Var = new c1(this.d.getContext());
        this.k = c1Var;
        c1Var.e(this.d, this.i, this.j, this.l, this.e);
        this.d.addOnAttachStateChangeListener(this);
        if (this.l) {
            timeout = 2500;
        } else if ((a.h.k.v.M(this.d) & 1) == 1) {
            timeout = 3000 - ViewConfiguration.getLongPressTimeout();
        } else {
            timeout = 15000 - ViewConfiguration.getLongPressTimeout();
        }
        this.d.removeCallbacks(this.h);
        this.d.postDelayed(this.h, timeout);
    }

    public void c() {
        if (c == this) {
            c = null;
            c1 c1Var = this.k;
            if (c1Var != null) {
                c1Var.c();
                this.k = null;
                b();
                this.d.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f132b == this) {
            e(null);
        }
        this.d.removeCallbacks(this.h);
    }

    public static void e(b1 handler) {
        b1 b1Var = f132b;
        if (b1Var != null) {
            b1Var.a();
        }
        f132b = handler;
        if (handler != null) {
            handler.d();
        }
    }

    public final void d() {
        this.d.postDelayed(this.g, ViewConfiguration.getLongPressTimeout());
    }

    public final void a() {
        this.d.removeCallbacks(this.g);
    }

    public final boolean h(MotionEvent event) {
        int newAnchorX = (int) event.getX();
        int newAnchorY = (int) event.getY();
        if (Math.abs(newAnchorX - this.i) <= this.f && Math.abs(newAnchorY - this.j) <= this.f) {
            return false;
        }
        this.i = newAnchorX;
        this.j = newAnchorY;
        return true;
    }

    public final void b() {
        this.i = Integer.MAX_VALUE;
        this.j = Integer.MAX_VALUE;
    }
}
