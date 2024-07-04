package a.j.b;

import a.h.k.v;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Interpolator f509a = new a();

    /* renamed from: b, reason: collision with root package name */
    public int f510b;
    public int c;
    public float[] e;
    public float[] f;
    public float[] g;
    public float[] h;
    public int[] i;
    public int[] j;
    public int[] k;
    public int l;
    public VelocityTracker m;
    public float n;
    public float o;
    public int p;
    public OverScroller q;
    public final AbstractC0040c r;
    public View s;
    public boolean t;
    public final ViewGroup u;
    public int d = -1;
    public final Runnable v = new b();

    /* renamed from: a.j.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0040c {
        public abstract int a(View view, int i, int i2);

        public abstract int b(View view, int i, int i2);

        public abstract void j(int i);

        public abstract void k(View view, int i, int i2, int i3, int i4);

        public abstract void l(View view, float f, float f2);

        public abstract boolean m(View view, int i);

        public void i(View capturedChild, int activePointerId) {
        }

        public void h() {
        }

        public boolean g() {
            return false;
        }

        public void f() {
        }

        public int c(int index) {
            return index;
        }

        public int d(View child) {
            return 0;
        }

        public int e(View child) {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float t) {
            float t2 = t - 1.0f;
            return (t2 * t2 * t2 * t2 * t2) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.D(0);
        }
    }

    public static c l(ViewGroup forParent, AbstractC0040c cb) {
        return new c(forParent.getContext(), forParent, cb);
    }

    public c(Context context, ViewGroup forParent, AbstractC0040c cb) {
        if (forParent == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cb == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = forParent;
        this.r = cb;
        ViewConfiguration vc = ViewConfiguration.get(context);
        float density = context.getResources().getDisplayMetrics().density;
        this.p = (int) ((20.0f * density) + 0.5f);
        this.c = vc.getScaledTouchSlop();
        this.n = vc.getScaledMaximumFlingVelocity();
        this.o = vc.getScaledMinimumFlingVelocity();
        this.q = new OverScroller(context, f509a);
    }

    public void b(View childView, int activePointerId) {
        if (childView.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = childView;
        this.d = activePointerId;
        this.r.i(childView, activePointerId);
        D(1);
    }

    public int t() {
        return this.c;
    }

    public void a() {
        this.d = -1;
        g();
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    public boolean G(View child, int finalLeft, int finalTop) {
        this.s = child;
        this.d = -1;
        boolean continueSliding = r(finalLeft, finalTop, 0, 0);
        if (!continueSliding && this.f510b == 0 && this.s != null) {
            this.s = null;
        }
        return continueSliding;
    }

    public boolean E(int finalLeft, int finalTop) {
        if (!this.t) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return r(finalLeft, finalTop, (int) this.m.getXVelocity(this.d), (int) this.m.getYVelocity(this.d));
    }

    public final boolean r(int finalLeft, int finalTop, int xvel, int yvel) {
        int startLeft = this.s.getLeft();
        int startTop = this.s.getTop();
        int dx = finalLeft - startLeft;
        int dy = finalTop - startTop;
        if (dx == 0 && dy == 0) {
            this.q.abortAnimation();
            D(0);
            return false;
        }
        int duration = j(this.s, dx, dy, xvel, yvel);
        this.q.startScroll(startLeft, startTop, dx, dy, duration);
        D(2);
        return true;
    }

    public final int j(View child, int dx, int dy, int xvel, int yvel) {
        float f;
        float f2;
        float f3;
        float f4;
        int xvel2 = f(xvel, (int) this.o, (int) this.n);
        int yvel2 = f(yvel, (int) this.o, (int) this.n);
        int absDx = Math.abs(dx);
        int absDy = Math.abs(dy);
        int absXVel = Math.abs(xvel2);
        int absYVel = Math.abs(yvel2);
        int addedVel = absXVel + absYVel;
        int addedDistance = absDx + absDy;
        if (xvel2 != 0) {
            f = absXVel;
            f2 = addedVel;
        } else {
            f = absDx;
            f2 = addedDistance;
        }
        float xweight = f / f2;
        if (yvel2 != 0) {
            f3 = absYVel;
            f4 = addedVel;
        } else {
            f3 = absDy;
            f4 = addedDistance;
        }
        float yweight = f3 / f4;
        int xduration = i(dx, xvel2, this.r.d(child));
        int yduration = i(dy, yvel2, this.r.e(child));
        return (int) ((xduration * xweight) + (yduration * yweight));
    }

    public final int i(int delta, int velocity, int motionRange) {
        int duration;
        if (delta == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        int halfWidth = width / 2;
        float distanceRatio = Math.min(1.0f, Math.abs(delta) / width);
        float distance = halfWidth + (halfWidth * n(distanceRatio));
        int velocity2 = Math.abs(velocity);
        if (velocity2 > 0) {
            duration = Math.round(Math.abs(distance / velocity2) * 1000.0f) * 4;
        } else {
            float range = Math.abs(delta) / motionRange;
            duration = (int) ((1.0f + range) * 256.0f);
        }
        return Math.min(duration, 600);
    }

    public final int f(int value, int absMin, int absMax) {
        int absValue = Math.abs(value);
        if (absValue < absMin) {
            return 0;
        }
        if (absValue > absMax) {
            return value > 0 ? absMax : -absMax;
        }
        return value;
    }

    public final float e(float value, float absMin, float absMax) {
        float absValue = Math.abs(value);
        if (absValue < absMin) {
            return 0.0f;
        }
        if (absValue > absMax) {
            return value > 0.0f ? absMax : -absMax;
        }
        return value;
    }

    public final float n(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    public boolean k(boolean deferCallbacks) {
        if (this.f510b == 2) {
            boolean keepGoing = this.q.computeScrollOffset();
            int x = this.q.getCurrX();
            int y = this.q.getCurrY();
            int dx = x - this.s.getLeft();
            int dy = y - this.s.getTop();
            if (dx != 0) {
                v.Y(this.s, dx);
            }
            if (dy != 0) {
                v.Z(this.s, dy);
            }
            if (dx != 0 || dy != 0) {
                this.r.k(this.s, x, y, dx, dy);
            }
            if (keepGoing && x == this.q.getFinalX() && y == this.q.getFinalY()) {
                this.q.abortAnimation();
                keepGoing = false;
            }
            if (!keepGoing) {
                if (deferCallbacks) {
                    this.u.post(this.v);
                } else {
                    D(0);
                }
            }
        }
        return this.f510b == 2;
    }

    public final void m(float xvel, float yvel) {
        this.t = true;
        this.r.l(this.s, xvel, yvel);
        this.t = false;
        if (this.f510b == 1) {
            D(0);
        }
    }

    public final void g() {
        float[] fArr = this.e;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0.0f);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        Arrays.fill(this.k, 0);
        this.l = 0;
    }

    public final void h(int pointerId) {
        if (this.e == null || !v(pointerId)) {
            return;
        }
        this.e[pointerId] = 0.0f;
        this.f[pointerId] = 0.0f;
        this.g[pointerId] = 0.0f;
        this.h[pointerId] = 0.0f;
        this.i[pointerId] = 0;
        this.j[pointerId] = 0;
        this.k[pointerId] = 0;
        this.l &= (1 << pointerId) ^ (-1);
    }

    public final void p(int pointerId) {
        float[] fArr = this.e;
        if (fArr == null || fArr.length <= pointerId) {
            float[] imx = new float[pointerId + 1];
            float[] imy = new float[pointerId + 1];
            float[] lmx = new float[pointerId + 1];
            float[] lmy = new float[pointerId + 1];
            int[] iit = new int[pointerId + 1];
            int[] edip = new int[pointerId + 1];
            int[] edl = new int[pointerId + 1];
            if (fArr != null) {
                System.arraycopy(fArr, 0, imx, 0, fArr.length);
                float[] fArr2 = this.f;
                System.arraycopy(fArr2, 0, imy, 0, fArr2.length);
                float[] fArr3 = this.g;
                System.arraycopy(fArr3, 0, lmx, 0, fArr3.length);
                float[] fArr4 = this.h;
                System.arraycopy(fArr4, 0, lmy, 0, fArr4.length);
                int[] iArr = this.i;
                System.arraycopy(iArr, 0, iit, 0, iArr.length);
                int[] iArr2 = this.j;
                System.arraycopy(iArr2, 0, edip, 0, iArr2.length);
                int[] iArr3 = this.k;
                System.arraycopy(iArr3, 0, edl, 0, iArr3.length);
            }
            this.e = imx;
            this.f = imy;
            this.g = lmx;
            this.h = lmy;
            this.i = iit;
            this.j = edip;
            this.k = edl;
        }
    }

    public final void B(float x, float y, int pointerId) {
        p(pointerId);
        float[] fArr = this.e;
        this.g[pointerId] = x;
        fArr[pointerId] = x;
        float[] fArr2 = this.f;
        this.h[pointerId] = y;
        fArr2[pointerId] = y;
        this.i[pointerId] = s((int) x, (int) y);
        this.l |= 1 << pointerId;
    }

    public final void C(MotionEvent ev) {
        int pointerCount = ev.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = ev.getPointerId(i);
            if (w(pointerId)) {
                float x = ev.getX(i);
                float y = ev.getY(i);
                this.g[pointerId] = x;
                this.h[pointerId] = y;
            }
        }
    }

    public boolean v(int pointerId) {
        return (this.l & (1 << pointerId)) != 0;
    }

    public void D(int state) {
        this.u.removeCallbacks(this.v);
        if (this.f510b != state) {
            this.f510b = state;
            this.r.j(state);
            if (this.f510b == 0) {
                this.s = null;
            }
        }
    }

    public boolean H(View toCapture, int pointerId) {
        if (toCapture == this.s && this.d == pointerId) {
            return true;
        }
        if (toCapture != null && this.r.m(toCapture, pointerId)) {
            this.d = pointerId;
            b(toCapture, pointerId);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fa, code lost:
    
        if (r2 != r15) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean F(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.j.b.c.F(android.view.MotionEvent):boolean");
    }

    public void y(MotionEvent ev) {
        int action = ev.getActionMasked();
        int actionIndex = ev.getActionIndex();
        if (action == 0) {
            a();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(ev);
        switch (action) {
            case 0:
                float x = ev.getX();
                float y = ev.getY();
                int pointerId = ev.getPointerId(0);
                View toCapture = q((int) x, (int) y);
                B(x, y, pointerId);
                H(toCapture, pointerId);
                int edgesTouched = this.i[pointerId];
                if ((edgesTouched & 0) != 0) {
                    this.r.h();
                    return;
                }
                return;
            case 1:
                if (this.f510b == 1) {
                    z();
                }
                a();
                return;
            case 2:
                if (this.f510b == 1) {
                    if (w(this.d)) {
                        int index = ev.findPointerIndex(this.d);
                        float x2 = ev.getX(index);
                        float y2 = ev.getY(index);
                        float[] fArr = this.g;
                        int i = this.d;
                        int idx = (int) (x2 - fArr[i]);
                        int idy = (int) (y2 - this.h[i]);
                        o(this.s.getLeft() + idx, this.s.getTop() + idy, idx, idy);
                        C(ev);
                        return;
                    }
                    return;
                }
                int pointerCount = ev.getPointerCount();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    int pointerId2 = ev.getPointerId(i2);
                    if (w(pointerId2)) {
                        float x3 = ev.getX(i2);
                        float y3 = ev.getY(i2);
                        float dx = x3 - this.e[pointerId2];
                        float dy = y3 - this.f[pointerId2];
                        A(dx, dy, pointerId2);
                        if (this.f510b != 1) {
                            View toCapture2 = q((int) x3, (int) y3);
                            if (d(toCapture2, dx, dy) && H(toCapture2, pointerId2)) {
                            }
                        }
                        C(ev);
                        return;
                    }
                }
                C(ev);
                return;
            case 3:
                if (this.f510b == 1) {
                    m(0.0f, 0.0f);
                }
                a();
                return;
            case 4:
            default:
                return;
            case 5:
                int pointerId3 = ev.getPointerId(actionIndex);
                float x4 = ev.getX(actionIndex);
                float y4 = ev.getY(actionIndex);
                B(x4, y4, pointerId3);
                if (this.f510b == 0) {
                    View toCapture3 = q((int) x4, (int) y4);
                    H(toCapture3, pointerId3);
                    int edgesTouched2 = this.i[pointerId3];
                    if ((edgesTouched2 & 0) != 0) {
                        this.r.h();
                        return;
                    }
                    return;
                }
                if (u((int) x4, (int) y4)) {
                    H(this.s, pointerId3);
                    return;
                }
                return;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                int pointerId4 = ev.getPointerId(actionIndex);
                if (this.f510b == 1 && pointerId4 == this.d) {
                    int newActivePointer = -1;
                    int pointerCount2 = ev.getPointerCount();
                    int i3 = 0;
                    while (true) {
                        if (i3 < pointerCount2) {
                            int id = ev.getPointerId(i3);
                            if (id != this.d) {
                                View q = q((int) ev.getX(i3), (int) ev.getY(i3));
                                View view = this.s;
                                if (q == view && H(view, id)) {
                                    newActivePointer = this.d;
                                }
                            }
                            i3++;
                        }
                    }
                    if (newActivePointer == -1) {
                        z();
                    }
                }
                h(pointerId4);
                return;
        }
    }

    public final void A(float dx, float dy, int pointerId) {
        int dragsStarted = 0;
        if (c(dx, dy, pointerId, 1)) {
            dragsStarted = 0 | 1;
        }
        if (c(dy, dx, pointerId, 4)) {
            dragsStarted |= 4;
        }
        if (c(dx, dy, pointerId, 2)) {
            dragsStarted |= 2;
        }
        if (c(dy, dx, pointerId, 8)) {
            dragsStarted |= 8;
        }
        if (dragsStarted != 0) {
            int[] iArr = this.j;
            iArr[pointerId] = iArr[pointerId] | dragsStarted;
            this.r.f();
        }
    }

    public final boolean c(float delta, float odelta, int pointerId, int edge) {
        float absDelta = Math.abs(delta);
        float absODelta = Math.abs(odelta);
        if ((this.i[pointerId] & edge) == edge && (0 & edge) != 0 && (this.k[pointerId] & edge) != edge && (this.j[pointerId] & edge) != edge) {
            int i = this.c;
            if (absDelta > i || absODelta > i) {
                if (absDelta < 0.5f * absODelta) {
                    this.r.g();
                }
                return (this.j[pointerId] & edge) == 0 && absDelta > ((float) this.c);
            }
        }
        return false;
    }

    public final boolean d(View child, float dx, float dy) {
        if (child == null) {
            return false;
        }
        boolean checkHorizontal = this.r.d(child) > 0;
        boolean checkVertical = this.r.e(child) > 0;
        if (!checkHorizontal || !checkVertical) {
            return checkHorizontal ? Math.abs(dx) > ((float) this.c) : checkVertical && Math.abs(dy) > ((float) this.c);
        }
        float f = (dx * dx) + (dy * dy);
        int i = this.c;
        return f > ((float) (i * i));
    }

    public final void z() {
        this.m.computeCurrentVelocity(1000, this.n);
        float xvel = e(this.m.getXVelocity(this.d), this.o, this.n);
        float yvel = e(this.m.getYVelocity(this.d), this.o, this.n);
        m(xvel, yvel);
    }

    public final void o(int left, int top, int dx, int dy) {
        int clampedX = left;
        int clampedY = top;
        int oldLeft = this.s.getLeft();
        int oldTop = this.s.getTop();
        if (dx != 0) {
            clampedX = this.r.a(this.s, left, dx);
            v.Y(this.s, clampedX - oldLeft);
        }
        if (dy != 0) {
            clampedY = this.r.b(this.s, top, dy);
            v.Z(this.s, clampedY - oldTop);
        }
        if (dx != 0 || dy != 0) {
            int clampedDx = clampedX - oldLeft;
            int clampedDy = clampedY - oldTop;
            this.r.k(this.s, clampedX, clampedY, clampedDx, clampedDy);
        }
    }

    public boolean u(int x, int y) {
        return x(this.s, x, y);
    }

    public boolean x(View view, int x, int y) {
        return view != null && x >= view.getLeft() && x < view.getRight() && y >= view.getTop() && y < view.getBottom();
    }

    public View q(int x, int y) {
        int childCount = this.u.getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            ViewGroup viewGroup = this.u;
            this.r.c(i);
            View child = viewGroup.getChildAt(i);
            if (x >= child.getLeft() && x < child.getRight() && y >= child.getTop() && y < child.getBottom()) {
                return child;
            }
        }
        return null;
    }

    public final int s(int x, int y) {
        int result = x < this.u.getLeft() + this.p ? 0 | 1 : 0;
        if (y < this.u.getTop() + this.p) {
            result |= 4;
        }
        if (x > this.u.getRight() - this.p) {
            result |= 2;
        }
        return y > this.u.getBottom() - this.p ? result | 8 : result;
    }

    public final boolean w(int pointerId) {
        if (!v(pointerId)) {
            Log.e("ViewDragHelper", "Ignoring pointerId=" + pointerId + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            return false;
        }
        return true;
    }
}
