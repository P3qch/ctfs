package b.b.a.a.c;

import a.h.k.v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public abstract class a<V extends View> extends c<V> {
    public Runnable d;
    public OverScroller e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public VelocityTracker j;

    public abstract boolean H(V v);

    public abstract int K(V v);

    public abstract int L(V v);

    public abstract int M();

    public abstract void N(CoordinatorLayout coordinatorLayout, V v);

    public abstract int Q(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.a != com.google.android.material.appbar.HeaderBehavior<V extends android.view.View> */
    public a() {
        this.g = -1;
        this.i = -1;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.a != com.google.android.material.appbar.HeaderBehavior<V extends android.view.View> */
    public a(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.g = -1;
        this.i = -1;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.a != com.google.android.material.appbar.HeaderBehavior<V extends android.view.View> */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout parent, V child, MotionEvent ev) {
        int pointerIndex;
        if (this.i < 0) {
            this.i = ViewConfiguration.get(parent.getContext()).getScaledTouchSlop();
        }
        if (ev.getActionMasked() == 2 && this.f) {
            int i = this.g;
            if (i == -1 || (pointerIndex = ev.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) ev.getY(pointerIndex);
            int yDiff = Math.abs(y - this.h);
            if (yDiff > this.i) {
                this.h = y;
                return true;
            }
        }
        if (ev.getActionMasked() == 0) {
            this.g = -1;
            int x = (int) ev.getX();
            int y2 = (int) ev.getY();
            boolean z = H(child) && parent.B(child, x, y2);
            this.f = z;
            if (z) {
                this.h = y2;
                this.g = ev.getPointerId(0);
                I();
                OverScroller overScroller = this.e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(ev);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.a != com.google.android.material.appbar.HeaderBehavior<V extends android.view.View> */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean D(androidx.coordinatorlayout.widget.CoordinatorLayout r13, V r14, android.view.MotionEvent r15) {
        /*
            r12 = this;
            r0 = 0
            int r1 = r15.getActionMasked()
            r2 = 1
            r3 = -1
            r4 = 0
            switch(r1) {
                case 1: goto L47;
                case 2: goto L27;
                case 3: goto L6b;
                case 4: goto Lb;
                case 5: goto Lb;
                case 6: goto Ld;
                default: goto Lb;
            }
        Lb:
            goto L79
        Ld:
            int r1 = r15.getActionIndex()
            if (r1 != 0) goto L15
            r1 = 1
            goto L16
        L15:
            r1 = 0
        L16:
            int r3 = r15.getPointerId(r1)
            r12.g = r3
            float r3 = r15.getY(r1)
            r5 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r5
            int r3 = (int) r3
            r12.h = r3
            goto L79
        L27:
            int r1 = r12.g
            int r1 = r15.findPointerIndex(r1)
            if (r1 != r3) goto L30
            return r4
        L30:
            float r3 = r15.getY(r1)
            int r3 = (int) r3
            int r5 = r12.h
            int r5 = r5 - r3
            r12.h = r3
            int r10 = r12.K(r14)
            r11 = 0
            r6 = r12
            r7 = r13
            r8 = r14
            r9 = r5
            r6.O(r7, r8, r9, r10, r11)
            goto L79
        L47:
            android.view.VelocityTracker r1 = r12.j
            if (r1 == 0) goto L6b
            r0 = 1
            r1.addMovement(r15)
            android.view.VelocityTracker r1 = r12.j
            r5 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r5)
            android.view.VelocityTracker r1 = r12.j
            int r5 = r12.g
            float r1 = r1.getYVelocity(r5)
            int r5 = r12.L(r14)
            int r9 = -r5
            r10 = 0
            r6 = r12
            r7 = r13
            r8 = r14
            r11 = r1
            r6.J(r7, r8, r9, r10, r11)
        L6b:
            r12.f = r4
            r12.g = r3
            android.view.VelocityTracker r1 = r12.j
            if (r1 == 0) goto L79
            r1.recycle()
            r1 = 0
            r12.j = r1
        L79:
            android.view.VelocityTracker r1 = r12.j
            if (r1 == 0) goto L80
            r1.addMovement(r15)
        L80:
            boolean r1 = r12.f
            if (r1 != 0) goto L88
            if (r0 == 0) goto L87
            goto L88
        L87:
            r2 = 0
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.a.c.a.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.a != com.google.android.material.appbar.HeaderBehavior<V extends android.view.View> */
    public int P(CoordinatorLayout parent, V header, int newOffset) {
        return Q(parent, header, newOffset, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.a != com.google.android.material.appbar.HeaderBehavior<V extends android.view.View> */
    public final int O(CoordinatorLayout coordinatorLayout, V header, int dy, int minOffset, int maxOffset) {
        return Q(coordinatorLayout, header, M() - dy, minOffset, maxOffset);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.a != com.google.android.material.appbar.HeaderBehavior<V extends android.view.View> */
    public final boolean J(CoordinatorLayout coordinatorLayout, V layout, int minOffset, int maxOffset, float velocityY) {
        Runnable runnable = this.d;
        if (runnable != null) {
            layout.removeCallbacks(runnable);
            this.d = null;
        }
        if (this.e == null) {
            this.e = new OverScroller(layout.getContext());
        }
        this.e.fling(0, E(), 0, Math.round(velocityY), 0, 0, minOffset, maxOffset);
        if (this.e.computeScrollOffset()) {
            RunnableC0062a runnableC0062a = new RunnableC0062a(coordinatorLayout, layout);
            this.d = runnableC0062a;
            v.g0(layout, runnableC0062a);
            return true;
        }
        N(coordinatorLayout, layout);
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.a != com.google.android.material.appbar.HeaderBehavior<V extends android.view.View> */
    public final void I() {
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    /* renamed from: b.b.a.a.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0062a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final CoordinatorLayout f994b;
        public final V c;

        /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.a$a != com.google.android.material.appbar.HeaderBehavior<V>$FlingRunnable */
        public RunnableC0062a(CoordinatorLayout parent, V layout) {
            this.f994b = parent;
            this.c = layout;
        }

        /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.a$a != com.google.android.material.appbar.HeaderBehavior<V>$FlingRunnable */
        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.c != null && (overScroller = a.this.e) != null) {
                if (overScroller.computeScrollOffset()) {
                    a aVar = a.this;
                    aVar.P(this.f994b, this.c, aVar.e.getCurrY());
                    v.g0(this.c, this);
                    return;
                }
                a.this.N(this.f994b, this.c);
            }
        }
    }
}
