package com.google.android.material.bottomsheet;

import a.h.k.d0;
import a.h.k.e0.c;
import a.h.k.e0.f;
import a.h.k.v;
import a.j.b.c;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.a.a.r.l;
import b.b.a.a.x.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1157a = R.style.Widget_Design_BottomSheet_Modal;
    public int A;
    public float B;
    public int C;
    public float D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public a.j.b.c I;
    public boolean J;
    public int K;
    public boolean L;
    public int M;
    public int N;
    public int O;
    public WeakReference<V> P;
    public WeakReference<View> Q;
    public final ArrayList<g> R;
    public VelocityTracker S;
    public int T;
    public int U;
    public boolean V;
    public Map<View, Integer> W;
    public int X;
    public final c.AbstractC0040c Y;

    /* renamed from: b, reason: collision with root package name */
    public int f1158b;
    public boolean c;
    public boolean d;
    public float e;
    public int f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;
    public b.b.a.a.x.g k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public k u;
    public boolean v;
    public BottomSheetBehavior<V>.i w;
    public ValueAnimator x;
    public int y;
    public int z;

    /* loaded from: classes.dex */
    public static abstract class g {
        public abstract void a(View view, float f);

        public abstract void b(View view, int i);
    }

    public BottomSheetBehavior() {
        this.f1158b = 0;
        this.c = true;
        this.d = false;
        this.l = -1;
        this.w = null;
        this.B = 0.5f;
        this.D = -1.0f;
        this.G = true;
        this.H = 4;
        this.R = new ArrayList<>();
        this.X = -1;
        this.Y = new e();
    }

    public BottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        int i2;
        this.f1158b = 0;
        this.c = true;
        this.d = false;
        this.l = -1;
        this.w = null;
        this.B = 0.5f;
        this.D = -1.0f;
        this.G = true;
        this.H = 4;
        this.R = new ArrayList<>();
        this.X = -1;
        this.Y = new e();
        this.i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray a2 = context.obtainStyledAttributes(attrs, b.b.a.a.a.f943b);
        int[] iArr = b.b.a.a.a.f942a;
        this.j = a2.hasValue(16);
        boolean hasBackgroundTint = a2.hasValue(2);
        if (hasBackgroundTint) {
            ColorStateList bottomSheetColor = b.b.a.a.u.c.a(context, a2, 2);
            X(context, attrs, hasBackgroundTint, bottomSheetColor);
        } else {
            W(context, attrs, hasBackgroundTint);
        }
        Y();
        if (Build.VERSION.SDK_INT >= 21) {
            this.D = a2.getDimension(1, -1.0f);
        }
        if (a2.hasValue(0)) {
            n0(a2.getDimensionPixelSize(0, -1));
        }
        TypedValue value = a2.peekValue(8);
        if (value != null && (i2 = value.data) == -1) {
            o0(i2);
        } else {
            o0(a2.getDimensionPixelSize(8, -1));
        }
        m0(a2.getBoolean(7, false));
        k0(a2.getBoolean(11, false));
        j0(a2.getBoolean(5, true));
        r0(a2.getBoolean(10, false));
        h0(a2.getBoolean(3, true));
        q0(a2.getInt(9, 0));
        l0(a2.getFloat(6, 0.5f));
        TypedValue value2 = a2.peekValue(4);
        if (value2 != null && value2.type == 16) {
            i0(value2.data);
        } else {
            i0(a2.getDimensionPixelOffset(4, 0));
        }
        this.o = a2.getBoolean(12, false);
        this.p = a2.getBoolean(13, false);
        this.q = a2.getBoolean(14, false);
        this.r = a2.getBoolean(15, true);
        a2.recycle();
        ViewConfiguration configuration = ViewConfiguration.get(context);
        this.e = configuration.getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout parent, V child) {
        return new h(super.y(parent, child), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout parent, V child, Parcelable state) {
        h ss = (h) state;
        super.x(parent, child, ss.j());
        g0(ss);
        int i2 = ss.d;
        if (i2 == 1 || i2 == 2) {
            this.H = 4;
        } else {
            this.H = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f layoutParams) {
        super.g(layoutParams);
        this.P = null;
        this.I = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.P = null;
        this.I = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout parent, V child, int layoutDirection) {
        b.b.a.a.x.g gVar;
        if (v.z(parent) && !v.z(child)) {
            child.setFitsSystemWindows(true);
        }
        if (this.P == null) {
            this.h = parent.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            u0(child);
            this.P = new WeakReference<>(child);
            if (this.j && (gVar = this.k) != null) {
                v.r0(child, gVar);
            }
            b.b.a.a.x.g gVar2 = this.k;
            if (gVar2 != null) {
                float f2 = this.D;
                if (f2 == -1.0f) {
                    f2 = v.w(child);
                }
                gVar2.U(f2);
                boolean z = this.H == 3;
                this.v = z;
                this.k.W(z ? 0.0f : 1.0f);
            }
            z0();
            if (v.A(child) == 0) {
                v.x0(child, 1);
            }
            int width = child.getMeasuredWidth();
            int i2 = this.l;
            if (width > i2 && i2 != -1) {
                ViewGroup.LayoutParams lp = child.getLayoutParams();
                lp.width = this.l;
                child.post(new a(this, child, lp));
            }
        }
        if (this.I == null) {
            this.I = a.j.b.c.l(parent, this.Y);
        }
        int savedTop = child.getTop();
        parent.I(child, layoutDirection);
        this.N = parent.getWidth();
        this.O = parent.getHeight();
        int height = child.getHeight();
        this.M = height;
        int i3 = this.O;
        int i4 = i3 - height;
        int i5 = this.t;
        if (i4 < i5) {
            if (this.r) {
                this.M = i3;
            } else {
                this.M = i3 - i5;
            }
        }
        this.z = Math.max(0, i3 - this.M);
        T();
        S();
        int i6 = this.H;
        if (i6 == 3) {
            v.Z(child, b0());
        } else if (i6 == 6) {
            v.Z(child, this.A);
        } else if (this.E && i6 == 5) {
            v.Z(child, this.O);
        } else if (i6 == 4) {
            v.Z(child, this.C);
        } else if (i6 == 1 || i6 == 2) {
            v.Z(child, savedTop - child.getTop());
        }
        this.Q = new WeakReference<>(a0(child));
        return true;
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1159b;
        public final /* synthetic */ ViewGroup.LayoutParams c;

        public a(BottomSheetBehavior this$0, View view, ViewGroup.LayoutParams layoutParams) {
            this.f1159b = view;
            this.c = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1159b.setLayoutParams(this.c);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout parent, V child, MotionEvent event) {
        a.j.b.c cVar;
        if (!child.isShown() || !this.G) {
            this.J = true;
            return false;
        }
        int action = event.getActionMasked();
        if (action == 0) {
            f0();
        }
        if (this.S == null) {
            this.S = VelocityTracker.obtain();
        }
        this.S.addMovement(event);
        switch (action) {
            case 0:
                int initialX = (int) event.getX();
                this.U = (int) event.getY();
                if (this.H != 2) {
                    WeakReference<View> weakReference = this.Q;
                    View scroll = weakReference != null ? weakReference.get() : null;
                    if (scroll != null && parent.B(scroll, initialX, this.U)) {
                        this.T = event.getPointerId(event.getActionIndex());
                        this.V = true;
                    }
                }
                this.J = this.T == -1 && !parent.B(child, initialX, this.U);
                break;
            case 1:
            case 3:
                this.V = false;
                this.T = -1;
                if (this.J) {
                    this.J = false;
                    return false;
                }
                break;
        }
        if (!this.J && (cVar = this.I) != null && cVar.F(event)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.Q;
        View scroll2 = weakReference2 != null ? weakReference2.get() : null;
        return (action != 2 || scroll2 == null || this.J || this.H == 1 || parent.B(scroll2, (int) event.getX(), (int) event.getY()) || this.I == null || Math.abs(((float) this.U) - event.getY()) <= ((float) this.I.t())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!child.isShown()) {
            return false;
        }
        int action = event.getActionMasked();
        if (this.H == 1 && action == 0) {
            return true;
        }
        a.j.b.c cVar = this.I;
        if (cVar != null) {
            cVar.y(event);
        }
        if (action == 0) {
            f0();
        }
        if (this.S == null) {
            this.S = VelocityTracker.obtain();
        }
        this.S.addMovement(event);
        if (this.I != null && action == 2 && !this.J && Math.abs(this.U - event.getY()) > this.I.t()) {
            this.I.b(child, event.getPointerId(event.getActionIndex()));
        }
        return !this.J;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int axes, int type) {
        this.K = 0;
        this.L = false;
        return (axes & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed, int type) {
        if (type == 1) {
            return;
        }
        WeakReference<View> weakReference = this.Q;
        View scrollingChild = weakReference != null ? weakReference.get() : null;
        if (target != scrollingChild) {
            return;
        }
        int currentTop = child.getTop();
        int newTop = currentTop - dy;
        if (dy > 0) {
            if (newTop < b0()) {
                consumed[1] = currentTop - b0();
                v.Z(child, -consumed[1]);
                t0(3);
            } else {
                if (!this.G) {
                    return;
                }
                consumed[1] = dy;
                v.Z(child, -dy);
                t0(1);
            }
        } else if (dy < 0 && !target.canScrollVertically(-1)) {
            int i2 = this.C;
            if (newTop > i2 && !this.E) {
                consumed[1] = currentTop - i2;
                v.Z(child, -consumed[1]);
                t0(4);
            } else {
                if (!this.G) {
                    return;
                }
                consumed[1] = dy;
                v.Z(child, -dy);
                t0(1);
            }
        }
        Z(child.getTop());
        this.K = dy;
        this.L = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void C(CoordinatorLayout coordinatorLayout, V child, View target, int type) {
        int currentTop;
        int top;
        if (child.getTop() == b0()) {
            t0(3);
            return;
        }
        WeakReference<View> weakReference = this.Q;
        if (weakReference == null || target != weakReference.get() || !this.L) {
            return;
        }
        if (this.K > 0) {
            if (this.c) {
                currentTop = this.z;
                top = 3;
            } else if (child.getTop() > this.A) {
                int top2 = this.A;
                currentTop = top2;
                top = 6;
            } else {
                int top3 = b0();
                currentTop = top3;
                top = 3;
            }
        } else if (this.E && x0(child, c0())) {
            currentTop = this.O;
            top = 5;
        } else {
            int top4 = this.K;
            if (top4 == 0) {
                int currentTop2 = child.getTop();
                if (this.c) {
                    if (Math.abs(currentTop2 - this.z) < Math.abs(currentTop2 - this.C)) {
                        int top5 = this.z;
                        currentTop = top5;
                        top = 3;
                    } else {
                        int top6 = this.C;
                        currentTop = top6;
                        top = 4;
                    }
                } else {
                    int top7 = this.A;
                    if (currentTop2 < top7) {
                        if (currentTop2 < Math.abs(currentTop2 - this.C)) {
                            int top8 = b0();
                            currentTop = top8;
                            top = 3;
                        } else {
                            int top9 = this.A;
                            currentTop = top9;
                            top = 6;
                        }
                    } else if (Math.abs(currentTop2 - top7) < Math.abs(currentTop2 - this.C)) {
                        int top10 = this.A;
                        currentTop = top10;
                        top = 6;
                    } else {
                        int top11 = this.C;
                        currentTop = top11;
                        top = 4;
                    }
                }
            } else if (this.c) {
                currentTop = this.C;
                top = 4;
            } else {
                int currentTop3 = child.getTop();
                if (Math.abs(currentTop3 - this.A) < Math.abs(currentTop3 - this.C)) {
                    int top12 = this.A;
                    currentTop = top12;
                    top = 6;
                } else {
                    int top13 = this.C;
                    currentTop = top13;
                    top = 4;
                }
            }
        }
        y0(child, top, currentTop, false);
        this.L = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V child, View target, float velocityX, float velocityY) {
        WeakReference<View> weakReference = this.Q;
        if (weakReference == null || target != weakReference.get()) {
            return false;
        }
        if (this.H != 3) {
            return true;
        }
        super.o(coordinatorLayout, child, target, velocityX, velocityY);
        return false;
    }

    public void j0(boolean fitToContents) {
        if (this.c == fitToContents) {
            return;
        }
        this.c = fitToContents;
        if (this.P != null) {
            S();
        }
        t0((this.c && this.H == 6) ? 3 : this.H);
        z0();
    }

    public void n0(int maxWidth) {
        this.l = maxWidth;
    }

    public void o0(int peekHeight) {
        p0(peekHeight, false);
    }

    public final void p0(int peekHeight, boolean animate) {
        boolean layout = false;
        if (peekHeight == -1) {
            if (!this.g) {
                this.g = true;
                layout = true;
            }
        } else if (this.g || this.f != peekHeight) {
            this.g = false;
            this.f = Math.max(0, peekHeight);
            layout = true;
        }
        if (layout) {
            C0(animate);
        }
    }

    public final void C0(boolean animate) {
        V view;
        if (this.P != null) {
            S();
            if (this.H == 4 && (view = this.P.get()) != null) {
                if (animate) {
                    w0(this.H);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    public void l0(float ratio) {
        if (ratio <= 0.0f || ratio >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.B = ratio;
        if (this.P != null) {
            T();
        }
    }

    public void i0(int offset) {
        if (offset < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.y = offset;
    }

    public int b0() {
        if (this.c) {
            return this.z;
        }
        return Math.max(this.y, this.r ? 0 : this.t);
    }

    public void m0(boolean hideable) {
        if (this.E != hideable) {
            this.E = hideable;
            if (!hideable && this.H == 5) {
                s0(4);
            }
            z0();
        }
    }

    public void r0(boolean skipCollapsed) {
        this.F = skipCollapsed;
    }

    public void h0(boolean draggable) {
        this.G = draggable;
    }

    public void q0(int flags) {
        this.f1158b = flags;
    }

    public void s0(int state) {
        if (state == this.H) {
            return;
        }
        if (this.P == null) {
            if (state == 4 || state == 3 || state == 6 || (this.E && state == 5)) {
                this.H = state;
                return;
            }
            return;
        }
        w0(state);
    }

    public void k0(boolean gestureInsetBottomIgnored) {
        this.n = gestureInsetBottomIgnored;
    }

    public boolean d0() {
        return this.n;
    }

    public final void w0(int state) {
        V child = this.P.get();
        if (child == null) {
            return;
        }
        ViewParent parent = child.getParent();
        if (parent != null && parent.isLayoutRequested() && v.S(child)) {
            child.post(new b(child, state));
        } else {
            v0(child, state);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1160b;
        public final /* synthetic */ int c;

        public b(View view, int i) {
            this.f1160b = view;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.v0(this.f1160b, this.c);
        }
    }

    public void t0(int state) {
        View bottomSheet;
        if (this.H == state) {
            return;
        }
        this.H = state;
        WeakReference<V> weakReference = this.P;
        if (weakReference == null || (bottomSheet = weakReference.get()) == null) {
            return;
        }
        if (state == 3) {
            B0(true);
        } else if (state == 6 || state == 5 || state == 4) {
            B0(false);
        }
        A0(state);
        for (int i2 = 0; i2 < this.R.size(); i2++) {
            this.R.get(i2).b(bottomSheet, state);
        }
        z0();
    }

    public final void A0(int state) {
        ValueAnimator valueAnimator;
        if (state == 2) {
            return;
        }
        boolean expand = state == 3;
        if (this.v != expand) {
            this.v = expand;
            if (this.k != null && (valueAnimator = this.x) != null) {
                if (valueAnimator.isRunning()) {
                    this.x.reverse();
                    return;
                }
                float to = expand ? 0.0f : 1.0f;
                float from = 1.0f - to;
                this.x.setFloatValues(from, to);
                this.x.start();
            }
        }
    }

    public final int U() {
        int i2;
        if (this.g) {
            int desiredHeight = Math.max(this.h, this.O - ((this.N * 9) / 16));
            return Math.min(desiredHeight, this.M) + this.s;
        }
        if (!this.n && !this.o && (i2 = this.m) > 0) {
            return Math.max(this.f, i2 + this.i);
        }
        return this.f + this.s;
    }

    public final void S() {
        int peek = U();
        if (this.c) {
            this.C = Math.max(this.O - peek, this.z);
        } else {
            this.C = this.O - peek;
        }
    }

    public final void T() {
        this.A = (int) (this.O * (1.0f - this.B));
    }

    public final void f0() {
        this.T = -1;
        VelocityTracker velocityTracker = this.S;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.S = null;
        }
    }

    public final void g0(h ss) {
        int i2 = this.f1158b;
        if (i2 == 0) {
            return;
        }
        if (i2 == -1 || (i2 & 1) == 1) {
            this.f = ss.e;
        }
        if (i2 == -1 || (i2 & 2) == 2) {
            this.c = ss.f;
        }
        if (i2 == -1 || (i2 & 4) == 4) {
            this.E = ss.g;
        }
        if (i2 == -1 || (i2 & 8) == 8) {
            this.F = ss.h;
        }
    }

    public boolean x0(View child, float yvel) {
        if (this.F) {
            return true;
        }
        if (child.getTop() < this.C) {
            return false;
        }
        int peek = U();
        float newTop = child.getTop() + (0.1f * yvel);
        return Math.abs(newTop - ((float) this.C)) / ((float) peek) > 0.5f;
    }

    public View a0(View view) {
        if (v.U(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            int count = group.getChildCount();
            for (int i2 = 0; i2 < count; i2++) {
                View scrollingChild = a0(group.getChildAt(i2));
                if (scrollingChild != null) {
                    return scrollingChild;
                }
            }
            return null;
        }
        return null;
    }

    public final void W(Context context, AttributeSet attrs, boolean hasBackgroundTint) {
        X(context, attrs, hasBackgroundTint, null);
    }

    public final void X(Context context, AttributeSet attrs, boolean hasBackgroundTint, ColorStateList bottomSheetColor) {
        if (this.j) {
            this.u = k.e(context, attrs, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).m();
            b.b.a.a.x.g gVar = new b.b.a.a.x.g(this.u);
            this.k = gVar;
            gVar.L(context);
            if (hasBackgroundTint && bottomSheetColor != null) {
                this.k.V(bottomSheetColor);
                return;
            }
            TypedValue defaultColor = new TypedValue();
            context.getTheme().resolveAttribute(android.R.attr.colorBackground, defaultColor, true);
            this.k.setTint(defaultColor.data);
        }
    }

    public final void Y() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.x = ofFloat;
        ofFloat.setDuration(500L);
        this.x.addUpdateListener(new c());
    }

    /* loaded from: classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            float value = ((Float) animation.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.k != null) {
                BottomSheetBehavior.this.k.W(value);
            }
        }
    }

    public final void u0(View child) {
        boolean shouldHandleGestureInsets = (Build.VERSION.SDK_INT < 29 || d0() || this.g) ? false : true;
        if (!this.o && !this.p && !this.q && !shouldHandleGestureInsets) {
            return;
        }
        l.a(child, new d(shouldHandleGestureInsets));
    }

    /* loaded from: classes.dex */
    public class d implements l.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1162a;

        public d(boolean z) {
            this.f1162a = z;
        }

        public d0 a(View view, d0 insets, l.d initialPadding) {
            BottomSheetBehavior.this.t = insets.i();
            boolean isRtl = l.d(view);
            int bottomPadding = view.getPaddingBottom();
            int leftPadding = view.getPaddingLeft();
            int rightPadding = view.getPaddingRight();
            if (BottomSheetBehavior.this.o) {
                BottomSheetBehavior.this.s = insets.f();
                bottomPadding = initialPadding.d + BottomSheetBehavior.this.s;
            }
            if (BottomSheetBehavior.this.p) {
                int leftPadding2 = isRtl ? initialPadding.c : initialPadding.f1079a;
                leftPadding = leftPadding2 + insets.g();
            }
            if (BottomSheetBehavior.this.q) {
                int rightPadding2 = isRtl ? initialPadding.f1079a : initialPadding.c;
                rightPadding = rightPadding2 + insets.h();
            }
            view.setPadding(leftPadding, view.getPaddingTop(), rightPadding, bottomPadding);
            if (this.f1162a) {
                BottomSheetBehavior.this.m = insets.e().e;
            }
            if (BottomSheetBehavior.this.o || this.f1162a) {
                BottomSheetBehavior.this.C0(false);
            }
            return insets;
        }
    }

    public final float c0() {
        VelocityTracker velocityTracker = this.S;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.e);
        return this.S.getYVelocity(this.T);
    }

    public void v0(View child, int state) {
        int top;
        if (state == 4) {
            top = this.C;
        } else if (state == 6) {
            top = this.A;
            if (this.c && top <= this.z) {
                state = 3;
                top = this.z;
            }
        } else if (state == 3) {
            top = b0();
        } else if (this.E && state == 5) {
            top = this.O;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + state);
        }
        y0(child, state, top, false);
    }

    public void y0(View child, int state, int top, boolean settleFromViewDragHelper) {
        a.j.b.c cVar = this.I;
        boolean startedSettling = cVar != null && (!settleFromViewDragHelper ? !cVar.G(child, child.getLeft(), top) : !cVar.E(child.getLeft(), top));
        if (startedSettling) {
            t0(2);
            A0(state);
            if (this.w == null) {
                this.w = new i(child, state);
            }
            if (!this.w.c) {
                BottomSheetBehavior<V>.i iVar = this.w;
                iVar.d = state;
                v.g0(child, iVar);
                this.w.c = true;
                return;
            }
            this.w.d = state;
            return;
        }
        t0(state);
    }

    /* loaded from: classes.dex */
    public class e extends c.AbstractC0040c {
        public e() {
        }

        @Override // a.j.b.c.AbstractC0040c
        public boolean m(View child, int pointerId) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i = bottomSheetBehavior.H;
            if (i == 1 || bottomSheetBehavior.V) {
                return false;
            }
            if (i == 3 && bottomSheetBehavior.T == pointerId) {
                WeakReference<View> weakReference = bottomSheetBehavior.Q;
                View scroll = weakReference != null ? weakReference.get() : null;
                if (scroll != null && scroll.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.P;
            return weakReference2 != null && weakReference2.get() == child;
        }

        @Override // a.j.b.c.AbstractC0040c
        public void k(View changedView, int left, int top, int dx, int dy) {
            BottomSheetBehavior.this.Z(top);
        }

        @Override // a.j.b.c.AbstractC0040c
        public void j(int state) {
            if (state == 1 && BottomSheetBehavior.this.G) {
                BottomSheetBehavior.this.t0(1);
            }
        }

        public final boolean n(View child) {
            int top = child.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.O + bottomSheetBehavior.b0()) / 2;
        }

        @Override // a.j.b.c.AbstractC0040c
        public void l(View releasedChild, float xvel, float yvel) {
            int top;
            int targetState;
            if (yvel < 0.0f) {
                if (BottomSheetBehavior.this.c) {
                    top = BottomSheetBehavior.this.z;
                    targetState = 3;
                } else {
                    int currentTop = releasedChild.getTop();
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (currentTop > bottomSheetBehavior.A) {
                        int top2 = bottomSheetBehavior.A;
                        top = top2;
                        targetState = 6;
                    } else {
                        int top3 = bottomSheetBehavior.b0();
                        top = top3;
                        targetState = 3;
                    }
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                if (bottomSheetBehavior2.E && bottomSheetBehavior2.x0(releasedChild, yvel)) {
                    if ((Math.abs(xvel) >= Math.abs(yvel) || yvel <= 500.0f) && !n(releasedChild)) {
                        if (BottomSheetBehavior.this.c) {
                            top = BottomSheetBehavior.this.z;
                            targetState = 3;
                        } else {
                            int top4 = releasedChild.getTop();
                            if (Math.abs(top4 - BottomSheetBehavior.this.b0()) < Math.abs(releasedChild.getTop() - BottomSheetBehavior.this.A)) {
                                top = BottomSheetBehavior.this.b0();
                                targetState = 3;
                            } else {
                                top = BottomSheetBehavior.this.A;
                                targetState = 6;
                            }
                        }
                    } else {
                        top = BottomSheetBehavior.this.O;
                        targetState = 5;
                    }
                } else if (yvel != 0.0f && Math.abs(xvel) <= Math.abs(yvel)) {
                    if (BottomSheetBehavior.this.c) {
                        top = BottomSheetBehavior.this.C;
                        targetState = 4;
                    } else {
                        int currentTop2 = releasedChild.getTop();
                        if (Math.abs(currentTop2 - BottomSheetBehavior.this.A) < Math.abs(currentTop2 - BottomSheetBehavior.this.C)) {
                            int top5 = BottomSheetBehavior.this.A;
                            top = top5;
                            targetState = 6;
                        } else {
                            int top6 = BottomSheetBehavior.this.C;
                            top = top6;
                            targetState = 4;
                        }
                    }
                } else {
                    int currentTop3 = releasedChild.getTop();
                    if (BottomSheetBehavior.this.c) {
                        if (Math.abs(currentTop3 - BottomSheetBehavior.this.z) < Math.abs(currentTop3 - BottomSheetBehavior.this.C)) {
                            int top7 = BottomSheetBehavior.this.z;
                            top = top7;
                            targetState = 3;
                        } else {
                            int top8 = BottomSheetBehavior.this.C;
                            top = top8;
                            targetState = 4;
                        }
                    } else {
                        BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                        int targetState2 = bottomSheetBehavior3.A;
                        if (currentTop3 < targetState2) {
                            if (currentTop3 < Math.abs(currentTop3 - bottomSheetBehavior3.C)) {
                                int top9 = BottomSheetBehavior.this.b0();
                                top = top9;
                                targetState = 3;
                            } else {
                                int top10 = BottomSheetBehavior.this.A;
                                top = top10;
                                targetState = 6;
                            }
                        } else {
                            int top11 = currentTop3 - targetState2;
                            if (Math.abs(top11) < Math.abs(currentTop3 - BottomSheetBehavior.this.C)) {
                                int top12 = BottomSheetBehavior.this.A;
                                top = top12;
                                targetState = 6;
                            } else {
                                int top13 = BottomSheetBehavior.this.C;
                                top = top13;
                                targetState = 4;
                            }
                        }
                    }
                }
            }
            BottomSheetBehavior.this.y0(releasedChild, targetState, top, true);
        }

        @Override // a.j.b.c.AbstractC0040c
        public int b(View child, int top, int dy) {
            int b0 = BottomSheetBehavior.this.b0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return a.h.f.a.b(top, b0, bottomSheetBehavior.E ? bottomSheetBehavior.O : bottomSheetBehavior.C);
        }

        @Override // a.j.b.c.AbstractC0040c
        public int a(View child, int left, int dx) {
            return child.getLeft();
        }

        @Override // a.j.b.c.AbstractC0040c
        public int e(View child) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.E) {
                return bottomSheetBehavior.O;
            }
            return bottomSheetBehavior.C;
        }
    }

    public void Z(int top) {
        float f2;
        View bottomSheet = this.P.get();
        if (bottomSheet != null && !this.R.isEmpty()) {
            int i2 = this.C;
            if (top > i2 || i2 == b0()) {
                int i3 = this.C;
                f2 = (i3 - top) / (this.O - i3);
            } else {
                int i4 = this.C;
                f2 = (i4 - top) / (i4 - b0());
            }
            float slideOffset = f2;
            for (int i5 = 0; i5 < this.R.size(); i5++) {
                this.R.get(i5).a(bottomSheet, slideOffset);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final View f1167b;
        public boolean c;
        public int d;

        /* JADX WARN: Generic types in debug info not equals: com.google.android.material.bottomsheet.BottomSheetBehavior$i != com.google.android.material.bottomsheet.BottomSheetBehavior<V>$SettleRunnable */
        public i(View view, int targetState) {
            this.f1167b = view;
            this.d = targetState;
        }

        /* JADX WARN: Generic types in debug info not equals: com.google.android.material.bottomsheet.BottomSheetBehavior$i != com.google.android.material.bottomsheet.BottomSheetBehavior<V>$SettleRunnable */
        @Override // java.lang.Runnable
        public void run() {
            a.j.b.c cVar = BottomSheetBehavior.this.I;
            if (cVar != null && cVar.k(true)) {
                v.g0(this.f1167b, this);
            } else {
                BottomSheetBehavior.this.t0(this.d);
            }
            this.c = false;
        }
    }

    /* loaded from: classes.dex */
    public static class h extends a.j.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public final int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;

        public h(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.d = source.readInt();
            this.e = source.readInt();
            this.f = source.readInt() == 1;
            this.g = source.readInt() == 1;
            this.h = source.readInt() == 1;
        }

        public h(Parcelable superState, BottomSheetBehavior<?> behavior) {
            super(superState);
            this.d = behavior.H;
            this.e = behavior.f;
            this.f = behavior.c;
            this.g = behavior.E;
            this.h = behavior.F;
        }

        @Override // a.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f ? 1 : 0);
            parcel.writeInt(this.g ? 1 : 0);
            parcel.writeInt(this.h ? 1 : 0);
        }

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel in, ClassLoader loader) {
                return new h(in, loader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel in) {
                return new h(in, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int size) {
                return new h[size];
            }
        }
    }

    public final void B0(boolean expanded) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.P;
        if (weakReference == null) {
            return;
        }
        ViewParent viewParent = weakReference.get().getParent();
        if (!(viewParent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout parent = (CoordinatorLayout) viewParent;
        int childCount = parent.getChildCount();
        if (expanded) {
            if (this.W == null) {
                this.W = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = parent.getChildAt(i2);
            if (child != this.P.get()) {
                if (expanded) {
                    this.W.put(child, Integer.valueOf(child.getImportantForAccessibility()));
                    if (this.d) {
                        v.x0(child, 4);
                    }
                } else if (this.d && (map = this.W) != null && map.containsKey(child)) {
                    v.x0(child, this.W.get(child).intValue());
                }
            }
        }
        if (!expanded) {
            this.W = null;
        } else if (this.d) {
            this.P.get().sendAccessibilityEvent(8);
        }
    }

    public final void z0() {
        V child;
        WeakReference<V> weakReference = this.P;
        if (weakReference == null || (child = weakReference.get()) == null) {
            return;
        }
        v.i0(child, 524288);
        v.i0(child, 262144);
        v.i0(child, 1048576);
        int i2 = this.X;
        if (i2 != -1) {
            v.i0(child, i2);
        }
        if (!this.c && this.H != 6) {
            this.X = R(child, R.string.bottomsheet_action_expand_halfway, 6);
        }
        if (this.E && this.H != 5) {
            e0(child, c.a.f, 5);
        }
        switch (this.H) {
            case 3:
                int nextState = this.c ? 4 : 6;
                e0(child, c.a.e, nextState);
                return;
            case 4:
                int nextState2 = this.c ? 3 : 6;
                e0(child, c.a.d, nextState2);
                return;
            case 5:
            default:
                return;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                e0(child, c.a.e, 4);
                e0(child, c.a.d, 3);
                return;
        }
    }

    public final void e0(V child, c.a action, int state) {
        v.k0(child, action, null, V(state));
    }

    public final int R(V child, int stringResId, int state) {
        return v.b(child, child.getResources().getString(stringResId), V(state));
    }

    /* loaded from: classes.dex */
    public class f implements a.h.k.e0.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1165a;

        public f(int i) {
            this.f1165a = i;
        }

        @Override // a.h.k.e0.f
        public boolean a(View view, f.a arguments) {
            BottomSheetBehavior.this.s0(this.f1165a);
            return true;
        }
    }

    public final a.h.k.e0.f V(int state) {
        return new f(state);
    }
}
