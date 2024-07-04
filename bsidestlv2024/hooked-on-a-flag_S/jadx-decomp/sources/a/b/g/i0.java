package a.b.g;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class i0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public final float f155b;
    public final int c;
    public final int d;
    public final View e;
    public Runnable f;
    public Runnable g;
    public boolean h;
    public int i;
    public final int[] j = new int[2];

    public abstract a.b.f.j.p b();

    public abstract boolean c();

    public i0(View src) {
        this.e = src;
        src.setLongClickable(true);
        src.addOnAttachStateChangeListener(this);
        this.f155b = ViewConfiguration.get(src.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.c = tapTimeout;
        this.d = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        boolean forwarding;
        boolean wasForwarding = this.h;
        if (wasForwarding) {
            forwarding = f(event) || !d();
        } else {
            forwarding = g(event) && c();
            if (forwarding) {
                long now = SystemClock.uptimeMillis();
                MotionEvent e = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
                this.e.onTouchEvent(e);
                e.recycle();
            }
        }
        this.h = forwarding;
        return forwarding || wasForwarding;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        this.h = false;
        this.i = -1;
        Runnable runnable = this.f;
        if (runnable != null) {
            this.e.removeCallbacks(runnable);
        }
    }

    public boolean d() {
        a.b.f.j.p popup = b();
        if (popup != null && popup.a()) {
            popup.dismiss();
            return true;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean g(MotionEvent srcEvent) {
        View src = this.e;
        if (!src.isEnabled()) {
            return false;
        }
        int actionMasked = srcEvent.getActionMasked();
        switch (actionMasked) {
            case 0:
                this.i = srcEvent.getPointerId(0);
                if (this.f == null) {
                    this.f = new a();
                }
                src.postDelayed(this.f, this.c);
                if (this.g == null) {
                    this.g = new b();
                }
                src.postDelayed(this.g, this.d);
                return false;
            case 1:
            case 3:
                a();
                return false;
            case 2:
                int activePointerIndex = srcEvent.findPointerIndex(this.i);
                if (activePointerIndex >= 0) {
                    float x = srcEvent.getX(activePointerIndex);
                    float y = srcEvent.getY(activePointerIndex);
                    if (!h(src, x, y, this.f155b)) {
                        a();
                        src.getParent().requestDisallowInterceptTouchEvent(true);
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public final void a() {
        Runnable runnable = this.g;
        if (runnable != null) {
            this.e.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f;
        if (runnable2 != null) {
            this.e.removeCallbacks(runnable2);
        }
    }

    public void e() {
        a();
        View src = this.e;
        if (!src.isEnabled() || src.isLongClickable() || !c()) {
            return;
        }
        src.getParent().requestDisallowInterceptTouchEvent(true);
        long now = SystemClock.uptimeMillis();
        MotionEvent e = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
        src.onTouchEvent(e);
        e.recycle();
        this.h = true;
    }

    public final boolean f(MotionEvent srcEvent) {
        g0 dst;
        View src = this.e;
        a.b.f.j.p popup = b();
        if (popup == null || !popup.a() || (dst = (g0) popup.e()) == null || !dst.isShown()) {
            return false;
        }
        MotionEvent dstEvent = MotionEvent.obtainNoHistory(srcEvent);
        i(src, dstEvent);
        j(dst, dstEvent);
        boolean handled = dst.e(dstEvent, this.i);
        dstEvent.recycle();
        int action = srcEvent.getActionMasked();
        boolean keepForwarding = (action == 1 || action == 3) ? false : true;
        return handled && keepForwarding;
    }

    public static boolean h(View view, float localX, float localY, float slop) {
        return localX >= (-slop) && localY >= (-slop) && localX < ((float) (view.getRight() - view.getLeft())) + slop && localY < ((float) (view.getBottom() - view.getTop())) + slop;
    }

    public final boolean j(View view, MotionEvent event) {
        int[] loc = this.j;
        view.getLocationOnScreen(loc);
        event.offsetLocation(-loc[0], -loc[1]);
        return true;
    }

    public final boolean i(View view, MotionEvent event) {
        int[] loc = this.j;
        view.getLocationOnScreen(loc);
        event.offsetLocation(loc[0], loc[1]);
        return true;
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = i0.this.e.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.this.e();
        }
    }
}
