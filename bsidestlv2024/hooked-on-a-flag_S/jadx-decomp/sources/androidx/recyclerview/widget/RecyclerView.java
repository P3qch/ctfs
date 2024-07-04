package androidx.recyclerview.widget;

import a.h.k.e0.c;
import a.o.b.a;
import a.o.b.b;
import a.o.b.e;
import a.o.b.k;
import a.o.b.o;
import a.o.b.p;
import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements a.h.k.k {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f884b = {R.attr.nestedScrollingEnabled};
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static final boolean f;
    public static final boolean g;
    public static final Class<?>[] h;
    public static final Interpolator i;
    public boolean A;
    public final int[] A0;
    public boolean B;
    public final int[] B0;
    public boolean C;
    public final List<c0> C0;
    public int D;
    public Runnable D0;
    public boolean E;
    public final p.b E0;
    public boolean F;
    public boolean G;
    public int H;
    public boolean I;
    public final AccessibilityManager J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public k O;
    public EdgeEffect P;
    public EdgeEffect Q;
    public EdgeEffect R;
    public EdgeEffect S;
    public l T;
    public int U;
    public int V;
    public VelocityTracker W;
    public int a0;
    public int b0;
    public int c0;
    public int d0;
    public int e0;
    public q f0;
    public final int g0;
    public final int h0;
    public float i0;
    public final w j;
    public float j0;
    public final u k;
    public boolean k0;
    public x l;
    public final b0 l0;
    public a.o.b.a m;
    public a.o.b.e m0;
    public a.o.b.b n;
    public e.b n0;
    public final a.o.b.p o;
    public final z o0;
    public boolean p;
    public s p0;
    public final Rect q;
    public List<s> q0;
    public final Rect r;
    public boolean r0;
    public final RectF s;
    public boolean s0;
    public g t;
    public l.b t0;
    public o u;
    public boolean u0;
    public v v;
    public a.o.b.k v0;
    public final ArrayList<n> w;
    public j w0;
    public final ArrayList<r> x;
    public final int[] x0;
    public r y;
    public a.h.k.l y0;
    public boolean z;
    public final int[] z0;

    /* loaded from: classes.dex */
    public static abstract class a0 {
    }

    /* loaded from: classes.dex */
    public interface j {
        int a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public static abstract class q {
        public abstract boolean a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface r {
        void a(boolean z);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface v {
        void a(c0 c0Var);
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        c = i2 == 18 || i2 == 19 || i2 == 20;
        d = i2 >= 23;
        e = i2 >= 21;
        f = false;
        g = false;
        Class<?> cls = Integer.TYPE;
        h = new Class[]{Context.class, AttributeSet.class, cls, cls};
        i = new c();
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.C || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.z) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.F) {
                recyclerView2.E = true;
            } else {
                recyclerView2.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.T;
            if (lVar != null) {
                lVar.u();
            }
            RecyclerView.this.u0 = false;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float t) {
            float t2 = t - 1.0f;
            return (t2 * t2 * t2 * t2 * t2) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public class d implements p.b {
        public d() {
        }

        public void b(c0 viewHolder, l.c info, l.c postInfo) {
            RecyclerView.this.k.J(viewHolder);
            RecyclerView.this.n(viewHolder, info, postInfo);
        }

        public void a(c0 viewHolder, l.c preInfo, l.c info) {
            RecyclerView.this.l(viewHolder, preInfo, info);
        }

        public void c(c0 viewHolder, l.c preInfo, l.c postInfo) {
            viewHolder.G(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.K) {
                if (recyclerView.T.b(viewHolder, viewHolder, preInfo, postInfo)) {
                    RecyclerView.this.L0();
                }
            } else if (recyclerView.T.d(viewHolder, preInfo, postInfo)) {
                RecyclerView.this.L0();
            }
        }

        public void d(c0 viewHolder) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.u.m1(viewHolder.f889b, recyclerView.k);
        }
    }

    public RecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, net.sqlcipher.R.attr.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int i2;
        TypedArray a2;
        this.j = new w();
        this.k = new u();
        this.o = new a.o.b.p();
        new a();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new RectF();
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.D = 0;
        this.K = false;
        this.L = false;
        this.M = 0;
        this.N = 0;
        this.O = new k();
        this.T = new a.o.b.c();
        this.U = 0;
        this.V = -1;
        this.i0 = Float.MIN_VALUE;
        this.j0 = Float.MIN_VALUE;
        this.k0 = true;
        this.l0 = new b0();
        this.n0 = e ? new e.b() : null;
        this.o0 = new z();
        this.r0 = false;
        this.s0 = false;
        this.t0 = new m();
        this.u0 = false;
        this.x0 = new int[2];
        this.z0 = new int[2];
        this.A0 = new int[2];
        this.B0 = new int[2];
        this.C0 = new ArrayList();
        this.D0 = new b();
        this.E0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration vc = ViewConfiguration.get(context);
        this.e0 = vc.getScaledTouchSlop();
        this.i0 = a.h.k.w.b(vc, context);
        this.j0 = a.h.k.w.d(vc, context);
        this.g0 = vc.getScaledMinimumFlingVelocity();
        this.h0 = vc.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.T.v(this.t0);
        n0();
        p0();
        o0();
        if (a.h.k.v.A(this) == 0) {
            a.h.k.v.x0(this, 1);
        }
        this.J = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new a.o.b.k(this));
        int[] iArr = a.o.a.f635a;
        TypedArray a3 = context.obtainStyledAttributes(attrs, iArr, defStyleAttr, 0);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 29) {
            i2 = i3;
            a2 = a3;
        } else {
            i2 = i3;
            a2 = a3;
            saveAttributeDataForStyleable(context, iArr, attrs, a3, defStyleAttr, 0);
        }
        int[] iArr2 = a.o.a.f635a;
        String layoutManagerName = a2.getString(8);
        int descendantFocusability = a2.getInt(2, -1);
        if (descendantFocusability == -1) {
            setDescendantFocusability(262144);
        }
        this.p = a2.getBoolean(1, true);
        boolean z2 = a2.getBoolean(3, false);
        this.B = z2;
        if (z2) {
            StateListDrawable verticalThumbDrawable = (StateListDrawable) a2.getDrawable(6);
            Drawable verticalTrackDrawable = a2.getDrawable(7);
            StateListDrawable horizontalThumbDrawable = (StateListDrawable) a2.getDrawable(4);
            Drawable horizontalTrackDrawable = a2.getDrawable(5);
            q0(verticalThumbDrawable, verticalTrackDrawable, horizontalThumbDrawable, horizontalTrackDrawable);
        }
        a2.recycle();
        v(context, layoutManagerName, attrs, defStyleAttr, 0);
        boolean nestedScrollingEnabled = true;
        int i4 = i2;
        if (i4 >= 21) {
            int[] iArr3 = f884b;
            TypedArray a4 = context.obtainStyledAttributes(attrs, iArr3, defStyleAttr, 0);
            if (i4 >= 29) {
                saveAttributeDataForStyleable(context, iArr3, attrs, a4, defStyleAttr, 0);
            }
            nestedScrollingEnabled = a4.getBoolean(0, true);
            a4.recycle();
        }
        setNestedScrollingEnabled(nestedScrollingEnabled);
    }

    public String P() {
        return " " + super.toString() + ", adapter:" + this.t + ", layout:" + this.u + ", context:" + getContext();
    }

    @SuppressLint({"InlinedApi"})
    public final void o0() {
        if (a.h.k.v.B(this) == 0) {
            a.h.k.v.y0(this, 8);
        }
    }

    public a.o.b.k getCompatAccessibilityDelegate() {
        return this.v0;
    }

    public void setAccessibilityDelegateCompat(a.o.b.k accessibilityDelegate) {
        this.v0 = accessibilityDelegate;
        a.h.k.v.o0(this, accessibilityDelegate);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public final void v(Context context, String className, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        ClassLoader classLoader;
        Constructor<? extends LayoutManager> constructor;
        if (className != null) {
            String className2 = className.trim();
            if (!className2.isEmpty()) {
                String className3 = i0(context, className2);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(className3, false, classLoader).asSubclass(o.class);
                    Object[] constructorArgs = null;
                    try {
                        constructor = asSubclass.getConstructor(h);
                        constructorArgs = new Object[]{context, attrs, Integer.valueOf(defStyleAttr), Integer.valueOf(defStyleRes)};
                    } catch (NoSuchMethodException e2) {
                        try {
                            Constructor<? extends LayoutManager> constructor2 = asSubclass.getConstructor(new Class[0]);
                            constructor = constructor2;
                        } catch (NoSuchMethodException e1) {
                            e1.initCause(e2);
                            throw new IllegalStateException(attrs.getPositionDescription() + ": Error creating LayoutManager " + className3, e1);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((o) constructor.newInstance(constructorArgs));
                } catch (ClassCastException e3) {
                    throw new IllegalStateException(attrs.getPositionDescription() + ": Class is not a LayoutManager " + className3, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attrs.getPositionDescription() + ": Unable to find LayoutManager " + className3, e4);
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(attrs.getPositionDescription() + ": Cannot access non-public constructor " + className3, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attrs.getPositionDescription() + ": Could not instantiate the LayoutManager: " + className3, e6);
                } catch (InvocationTargetException e7) {
                    throw new IllegalStateException(attrs.getPositionDescription() + ": Could not instantiate the LayoutManager: " + className3, e7);
                }
            }
        }
    }

    public final String i0(Context context, String className) {
        if (className.charAt(0) == '.') {
            return context.getPackageName() + className;
        }
        if (className.contains(".")) {
            return className;
        }
        return RecyclerView.class.getPackage().getName() + '.' + className;
    }

    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0047b {
        public e() {
        }

        public int e() {
            return RecyclerView.this.getChildCount();
        }

        public void a(View child, int index) {
            RecyclerView.this.addView(child, index);
            RecyclerView.this.y(child);
        }

        public int g(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        public void k(int index) {
            View child = RecyclerView.this.getChildAt(index);
            if (child != null) {
                RecyclerView.this.z(child);
                child.clearAnimation();
            }
            RecyclerView.this.removeViewAt(index);
        }

        public View d(int offset) {
            return RecyclerView.this.getChildAt(offset);
        }

        public void j() {
            int count = e();
            for (int i = 0; i < count; i++) {
                View child = d(i);
                RecyclerView.this.z(child);
                child.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        public c0 f(View view) {
            return RecyclerView.f0(view);
        }

        public void b(View child, int index, ViewGroup.LayoutParams layoutParams) {
            c0 vh = RecyclerView.f0(child);
            if (vh != null) {
                if (!vh.x() && !vh.J()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + vh + RecyclerView.this.P());
                }
                vh.f();
            }
            RecyclerView.this.attachViewToParent(child, index, layoutParams);
        }

        public void c(int offset) {
            c0 vh;
            View view = d(offset);
            if (view != null && (vh = RecyclerView.f0(view)) != null) {
                if (vh.x() && !vh.J()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + vh + RecyclerView.this.P());
                }
                vh.b(256);
            }
            RecyclerView.this.detachViewFromParent(offset);
        }

        public void h(View child) {
            c0 vh = RecyclerView.f0(child);
            if (vh != null) {
                vh.B(RecyclerView.this);
            }
        }

        public void i(View child) {
            c0 vh = RecyclerView.f0(child);
            if (vh != null) {
                vh.C(RecyclerView.this);
            }
        }
    }

    public final void p0() {
        this.n = new a.o.b.b(new e());
    }

    /* loaded from: classes.dex */
    public class f implements a.InterfaceC0046a {
        public f() {
        }

        public c0 b(int position) {
            c0 vh = RecyclerView.this.Z(position, true);
            if (vh == null || RecyclerView.this.n.n(vh.f889b)) {
                return null;
            }
            return vh;
        }

        public void f(int start, int count) {
            RecyclerView.this.C0(start, count, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.r0 = true;
            recyclerView.o0.c += count;
        }

        public void g(int positionStart, int itemCount) {
            RecyclerView.this.C0(positionStart, itemCount, false);
            RecyclerView.this.r0 = true;
        }

        public void c(int positionStart, int itemCount, Object payload) {
            RecyclerView.this.v1(positionStart, itemCount, payload);
            RecyclerView.this.s0 = true;
        }

        public void h(a.b op) {
            a(op);
        }

        public void a(a.b op) {
            switch (op.f638a) {
                case 1:
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.u.R0(recyclerView, op.f639b, op.d);
                    return;
                case 2:
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.u.U0(recyclerView2, op.f639b, op.d);
                    return;
                case 4:
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.u.W0(recyclerView3, op.f639b, op.d, op.c);
                    return;
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.u.T0(recyclerView4, op.f639b, op.d, 1);
                    return;
                default:
                    return;
            }
        }

        public void i(a.b op) {
            a(op);
        }

        public void d(int positionStart, int itemCount) {
            RecyclerView.this.A0(positionStart, itemCount);
            RecyclerView.this.r0 = true;
        }

        public void e(int from, int to) {
            RecyclerView.this.B0(from, to);
            RecyclerView.this.r0 = true;
        }
    }

    public void n0() {
        this.m = new a.o.b.a(new f());
    }

    public void setHasFixedSize(boolean hasFixedSize) {
        this.A = hasFixedSize;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean clipToPadding) {
        if (clipToPadding != this.p) {
            r0();
        }
        this.p = clipToPadding;
        super.setClipToPadding(clipToPadding);
        if (this.C) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.p;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    public void setScrollingTouchSlop(int slopConstant) {
        ViewConfiguration vc = ViewConfiguration.get(getContext());
        switch (slopConstant) {
            case 0:
                this.e0 = vc.getScaledTouchSlop();
                return;
            case 1:
                this.e0 = vc.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + slopConstant + "; using default value");
                this.e0 = vc.getScaledTouchSlop();
                return;
        }
    }

    public void setAdapter(g adapter) {
        setLayoutFrozen(false);
        h1(adapter, false, true);
        O0(false);
        requestLayout();
    }

    public void T0() {
        l lVar = this.T;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.u;
        if (oVar != null) {
            oVar.k1(this.k);
            this.u.l1(this.k);
        }
        this.k.c();
    }

    public final void h1(g adapter, boolean compatibleWithPrevious, boolean removeAndRecycleViews) {
        g gVar = this.t;
        if (gVar != null) {
            gVar.t(this.j);
            this.t.m();
        }
        if (!compatibleWithPrevious || removeAndRecycleViews) {
            T0();
        }
        this.m.u();
        g oldAdapter = this.t;
        this.t = adapter;
        if (adapter != null) {
            adapter.r(this.j);
            adapter.i();
        }
        o oVar = this.u;
        if (oVar != null) {
            oVar.E0();
        }
        this.k.x(oldAdapter, this.t, compatibleWithPrevious);
        this.o0.f = true;
    }

    public g getAdapter() {
        return this.t;
    }

    public void setRecyclerListener(v listener) {
        this.v = listener;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.u;
        if (oVar != null) {
            oVar.G();
            return -1;
        }
        return super.getBaseline();
    }

    public void setLayoutManager(o layout) {
        if (layout == this.u) {
            return;
        }
        t1();
        if (this.u != null) {
            l lVar = this.T;
            if (lVar != null) {
                lVar.k();
            }
            this.u.k1(this.k);
            this.u.l1(this.k);
            this.k.c();
            if (this.z) {
                this.u.A(this, this.k);
            }
            this.u.E1(null);
            this.u = null;
        } else {
            this.k.c();
        }
        this.n.o();
        this.u = layout;
        if (layout != null) {
            if (layout.f901b != null) {
                throw new IllegalArgumentException("LayoutManager " + layout + " is already attached to a RecyclerView:" + layout.f901b.P());
            }
            layout.E1(this);
            if (this.z) {
                this.u.z(this);
            }
        }
        this.k.K();
        requestLayout();
    }

    public void setOnFlingListener(q onFlingListener) {
        this.f0 = onFlingListener;
    }

    public q getOnFlingListener() {
        return this.f0;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        x state = new x(super.onSaveInstanceState());
        x xVar = this.l;
        if (xVar != null) {
            state.k(xVar);
        } else {
            o oVar = this.u;
            if (oVar != null) {
                state.d = oVar.d1();
            } else {
                state.d = null;
            }
        }
        return state;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Parcelable parcelable;
        if (!(state instanceof x)) {
            super.onRestoreInstanceState(state);
            return;
        }
        x xVar = (x) state;
        this.l = xVar;
        super.onRestoreInstanceState(xVar.j());
        o oVar = this.u;
        if (oVar != null && (parcelable = this.l.d) != null) {
            oVar.c1(parcelable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    public final void g(c0 viewHolder) {
        View view = viewHolder.f889b;
        boolean alreadyParented = view.getParent() == this;
        this.k.J(e0(view));
        if (viewHolder.x()) {
            this.n.c(view, -1, view.getLayoutParams(), true);
        } else if (!alreadyParented) {
            this.n.b(view, true);
        } else {
            this.n.k(view);
        }
    }

    public boolean U0(View view) {
        p1();
        boolean removed = this.n.r(view);
        if (removed) {
            c0 viewHolder = f0(view);
            this.k.J(viewHolder);
            this.k.C(viewHolder);
        }
        r1(!removed);
        return removed;
    }

    public o getLayoutManager() {
        return this.u;
    }

    public t getRecycledViewPool() {
        return this.k.i();
    }

    public void setRecycledViewPool(t pool) {
        this.k.E(pool);
    }

    public void setViewCacheExtension(a0 extension) {
        this.k.F(extension);
    }

    public void setItemViewCacheSize(int size) {
        this.k.G(size);
    }

    public int getScrollState() {
        return this.U;
    }

    public void setScrollState(int state) {
        if (state == this.U) {
            return;
        }
        this.U = state;
        if (state != 2) {
            u1();
        }
        H(state);
    }

    public void i(n decor, int index) {
        o oVar = this.u;
        if (oVar != null) {
            oVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.w.isEmpty()) {
            setWillNotDraw(false);
        }
        if (index < 0) {
            this.w.add(decor);
        } else {
            this.w.add(index, decor);
        }
        w0();
        requestLayout();
    }

    public void h(n decor) {
        i(decor, -1);
    }

    public int getItemDecorationCount() {
        return this.w.size();
    }

    public void V0(n decor) {
        o oVar = this.u;
        if (oVar != null) {
            oVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.w.remove(decor);
        if (this.w.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        w0();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j childDrawingOrderCallback) {
        if (childDrawingOrderCallback == this.w0) {
            return;
        }
        this.w0 = childDrawingOrderCallback;
        setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
    }

    @Deprecated
    public void setOnScrollListener(s listener) {
        this.p0 = listener;
    }

    public void k(s listener) {
        if (this.q0 == null) {
            this.q0 = new ArrayList();
        }
        this.q0.add(listener);
    }

    public void X0(s listener) {
        List<s> list = this.q0;
        if (list != null) {
            list.remove(listener);
        }
    }

    public void g1(int position) {
        if (this.F) {
            return;
        }
        t1();
        o oVar = this.u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.x1(position);
            awakenScrollBars();
        }
    }

    public void v0(int position) {
        if (this.u == null) {
            return;
        }
        setScrollState(2);
        this.u.x1(position);
        awakenScrollBars();
    }

    public void o1(int position) {
        if (this.F) {
            return;
        }
        o oVar = this.u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.I1(this, this.o0, position);
        }
    }

    @Override // android.view.View
    public void scrollTo(int x2, int y2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int x2, int y2) {
        o oVar = this.u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.F) {
            return;
        }
        boolean canScrollHorizontal = oVar.k();
        boolean canScrollVertical = this.u.l();
        if (canScrollHorizontal || canScrollVertical) {
            e1(canScrollHorizontal ? x2 : 0, canScrollVertical ? y2 : 0, null);
        }
    }

    public void f1(int dx, int dy, int[] consumed) {
        p1();
        F0();
        a.h.g.c.a("RV Scroll");
        Q(this.o0);
        int consumedX = 0;
        int consumedY = 0;
        if (dx != 0) {
            consumedX = this.u.w1(dx, this.k, this.o0);
        }
        if (dy != 0) {
            consumedY = this.u.y1(dy, this.k, this.o0);
        }
        a.h.g.c.b();
        Y0();
        G0();
        r1(false);
        if (consumed != null) {
            consumed[0] = consumedX;
            consumed[1] = consumedY;
        }
    }

    public void u() {
        if (!this.C || this.K) {
            a.h.g.c.a("RV FullInvalidate");
            B();
            a.h.g.c.b();
            return;
        }
        if (!this.m.n()) {
            return;
        }
        if (this.m.m(4) && !this.m.m(11)) {
            a.h.g.c.a("RV PartialInvalidate");
            p1();
            F0();
            this.m.r();
            if (!this.E) {
                if (m0()) {
                    B();
                } else {
                    this.m.g();
                }
            }
            r1(true);
            G0();
            a.h.g.c.b();
            return;
        }
        if (this.m.n()) {
            a.h.g.c.a("RV FullInvalidate");
            B();
            a.h.g.c.b();
        }
    }

    public final boolean m0() {
        int childCount = this.n.g();
        for (int i2 = 0; i2 < childCount; i2++) {
            c0 holder = f0(this.n.f(i2));
            if (holder != null && !holder.J() && holder.y()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b8, code lost:
    
        if (r3 != 0) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e1(int r22, int r23, android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.e1(int, int, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.u;
        if (oVar != null && oVar.k()) {
            return this.u.r(this.o0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.u;
        if (oVar != null && oVar.k()) {
            return this.u.q(this.o0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.u;
        if (oVar != null && oVar.k()) {
            return this.u.s(this.o0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.u;
        if (oVar != null && oVar.l()) {
            return this.u.u(this.o0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.u;
        if (oVar != null && oVar.l()) {
            return this.u.t(this.o0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.u;
        if (oVar != null && oVar.l()) {
            return this.u.v(this.o0);
        }
        return 0;
    }

    public void p1() {
        int i2 = this.D + 1;
        this.D = i2;
        if (i2 == 1 && !this.F) {
            this.E = false;
        }
    }

    public void r1(boolean performLayoutChildren) {
        if (this.D < 1) {
            this.D = 1;
        }
        if (!performLayoutChildren && !this.F) {
            this.E = false;
        }
        if (this.D == 1) {
            if (performLayoutChildren && this.E && !this.F && this.u != null && this.t != null) {
                B();
            }
            if (!this.F) {
                this.E = false;
            }
        }
        this.D--;
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean suppress) {
        if (suppress != this.F) {
            o("Do not suppressLayout in layout or scroll");
            if (!suppress) {
                this.F = false;
                if (this.E && this.u != null && this.t != null) {
                    requestLayout();
                }
                this.E = false;
                return;
            }
            long now = SystemClock.uptimeMillis();
            MotionEvent cancelEvent = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
            onTouchEvent(cancelEvent);
            this.F = true;
            this.G = true;
            t1();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.F;
    }

    @Deprecated
    public void setLayoutFrozen(boolean frozen) {
        suppressLayout(frozen);
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition transition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (transition == null) {
                suppressLayout(false);
                return;
            } else if (transition.getAnimator(0) == null && transition.getAnimator(1) == null && transition.getAnimator(2) == null && transition.getAnimator(3) == null && transition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (transition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void k1(int dx, int dy) {
        l1(dx, dy, null);
    }

    public void l1(int dx, int dy, Interpolator interpolator) {
        m1(dx, dy, interpolator, Integer.MIN_VALUE);
    }

    public void m1(int dx, int dy, Interpolator interpolator, int duration) {
        n1(dx, dy, interpolator, duration, false);
    }

    public void n1(int dx, int dy, Interpolator interpolator, int duration, boolean withNestedScrolling) {
        o oVar = this.u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.F) {
            return;
        }
        if (!oVar.k()) {
            dx = 0;
        }
        if (!this.u.l()) {
            dy = 0;
        }
        if (dx != 0 || dy != 0) {
            boolean durationSuggestsAnimation = duration == Integer.MIN_VALUE || duration > 0;
            if (durationSuggestsAnimation) {
                if (withNestedScrolling) {
                    int nestedScrollAxis = 0;
                    if (dx != 0) {
                        nestedScrollAxis = 0 | 1;
                    }
                    if (dy != 0) {
                        nestedScrollAxis |= 2;
                    }
                    q1(nestedScrollAxis, 1);
                }
                this.l0.f(dx, dy, duration, interpolator);
                return;
            }
            scrollBy(dx, dy);
        }
    }

    public boolean a0(int velocityX, int velocityY) {
        o oVar = this.u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.F) {
            return false;
        }
        boolean canScrollHorizontal = oVar.k();
        boolean canScrollVertical = this.u.l();
        if (!canScrollHorizontal || Math.abs(velocityX) < this.g0) {
            velocityX = 0;
        }
        if (!canScrollVertical || Math.abs(velocityY) < this.g0) {
            velocityY = 0;
        }
        if ((velocityX != 0 || velocityY != 0) && !dispatchNestedPreFling(velocityX, velocityY)) {
            boolean canScroll = canScrollHorizontal || canScrollVertical;
            dispatchNestedFling(velocityX, velocityY, canScroll);
            q qVar = this.f0;
            if (qVar != null && qVar.a(velocityX, velocityY)) {
                return true;
            }
            if (canScroll) {
                int nestedScrollAxis = 0;
                if (canScrollHorizontal) {
                    nestedScrollAxis = 0 | 1;
                }
                if (canScrollVertical) {
                    nestedScrollAxis |= 2;
                }
                q1(nestedScrollAxis, 1);
                int i2 = this.h0;
                int velocityX2 = Math.max(-i2, Math.min(velocityX, i2));
                int i3 = this.h0;
                this.l0.c(velocityX2, Math.max(-i3, Math.min(velocityY, i3)));
                return true;
            }
        }
        return false;
    }

    public void t1() {
        setScrollState(0);
        u1();
    }

    public final void u1() {
        this.l0.g();
        o oVar = this.u;
        if (oVar != null) {
            oVar.K1();
        }
    }

    public int getMinFlingVelocity() {
        return this.g0;
    }

    public int getMaxFlingVelocity() {
        return this.h0;
    }

    public final void P0(float x2, float overscrollX, float y2, float overscrollY) {
        boolean invalidate = false;
        if (overscrollX < 0.0f) {
            M();
            a.h.l.d.a(this.P, (-overscrollX) / getWidth(), 1.0f - (y2 / getHeight()));
            invalidate = true;
        } else if (overscrollX > 0.0f) {
            N();
            a.h.l.d.a(this.R, overscrollX / getWidth(), y2 / getHeight());
            invalidate = true;
        }
        if (overscrollY < 0.0f) {
            O();
            a.h.l.d.a(this.Q, (-overscrollY) / getHeight(), x2 / getWidth());
            invalidate = true;
        } else if (overscrollY > 0.0f) {
            L();
            a.h.l.d.a(this.S, overscrollY / getHeight(), 1.0f - (x2 / getWidth()));
            invalidate = true;
        }
        if (invalidate || overscrollX != 0.0f || overscrollY != 0.0f) {
            a.h.k.v.f0(this);
        }
    }

    public final void S0() {
        boolean needsInvalidate = false;
        EdgeEffect edgeEffect = this.P;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            needsInvalidate = this.P.isFinished();
        }
        EdgeEffect edgeEffect2 = this.Q;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            needsInvalidate |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect3 = this.R;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            needsInvalidate |= this.R.isFinished();
        }
        EdgeEffect edgeEffect4 = this.S;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            needsInvalidate |= this.S.isFinished();
        }
        if (needsInvalidate) {
            a.h.k.v.f0(this);
        }
    }

    public void t(int dx, int dy) {
        boolean needsInvalidate = false;
        EdgeEffect edgeEffect = this.P;
        if (edgeEffect != null && !edgeEffect.isFinished() && dx > 0) {
            this.P.onRelease();
            needsInvalidate = this.P.isFinished();
        }
        EdgeEffect edgeEffect2 = this.R;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && dx < 0) {
            this.R.onRelease();
            needsInvalidate |= this.R.isFinished();
        }
        EdgeEffect edgeEffect3 = this.Q;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && dy > 0) {
            this.Q.onRelease();
            needsInvalidate |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect4 = this.S;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && dy < 0) {
            this.S.onRelease();
            needsInvalidate |= this.S.isFinished();
        }
        if (needsInvalidate) {
            a.h.k.v.f0(this);
        }
    }

    public void a(int velocityX, int velocityY) {
        if (velocityX < 0) {
            M();
            if (this.P.isFinished()) {
                this.P.onAbsorb(-velocityX);
            }
        } else if (velocityX > 0) {
            N();
            if (this.R.isFinished()) {
                this.R.onAbsorb(velocityX);
            }
        }
        if (velocityY < 0) {
            O();
            if (this.Q.isFinished()) {
                this.Q.onAbsorb(-velocityY);
            }
        } else if (velocityY > 0) {
            L();
            if (this.S.isFinished()) {
                this.S.onAbsorb(velocityY);
            }
        }
        if (velocityX != 0 || velocityY != 0) {
            a.h.k.v.f0(this);
        }
    }

    public void M() {
        if (this.P != null) {
            return;
        }
        EdgeEffect a2 = this.O.a(this);
        this.P = a2;
        if (this.p) {
            a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void N() {
        if (this.R != null) {
            return;
        }
        EdgeEffect a2 = this.O.a(this);
        this.R = a2;
        if (this.p) {
            a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void O() {
        if (this.Q != null) {
            return;
        }
        EdgeEffect a2 = this.O.a(this);
        this.Q = a2;
        if (this.p) {
            a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void L() {
        if (this.S != null) {
            return;
        }
        EdgeEffect a2 = this.O.a(this);
        this.S = a2;
        if (this.p) {
            a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void r0() {
        this.S = null;
        this.Q = null;
        this.R = null;
        this.P = null;
    }

    public void setEdgeEffectFactory(k edgeEffectFactory) {
        a.h.j.i.e(edgeEffectFactory);
        this.O = edgeEffectFactory;
        r0();
    }

    public k getEdgeEffectFactory() {
        return this.O;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View focused, int direction) {
        View result;
        View result2 = this.u.Q0();
        if (result2 != null) {
            return result2;
        }
        boolean canRunFocusFailure = (this.t == null || this.u == null || t0() || this.F) ? false : true;
        FocusFinder ff = FocusFinder.getInstance();
        if (canRunFocusFailure && (direction == 2 || direction == 1)) {
            boolean needsFocusFailureLayout = false;
            if (this.u.l()) {
                int absDir = direction == 2 ? 130 : 33;
                View found = ff.findNextFocus(this, focused, absDir);
                needsFocusFailureLayout = found == null;
            }
            if (!needsFocusFailureLayout && this.u.k()) {
                boolean rtl = this.u.Z() == 1;
                int absDir2 = (direction == 2) ^ rtl ? 66 : 17;
                View found2 = ff.findNextFocus(this, focused, absDir2);
                needsFocusFailureLayout = found2 == null;
            }
            if (needsFocusFailureLayout) {
                u();
                View focusedItemView = R(focused);
                if (focusedItemView == null) {
                    return null;
                }
                p1();
                this.u.J0(focused, direction, this.k, this.o0);
                r1(false);
            }
            result = ff.findNextFocus(this, focused, direction);
        } else {
            result = ff.findNextFocus(this, focused, direction);
            if (result == null && canRunFocusFailure) {
                u();
                View focusedItemView2 = R(focused);
                if (focusedItemView2 == null) {
                    return null;
                }
                p1();
                result = this.u.J0(focused, direction, this.k, this.o0);
                r1(false);
            }
        }
        if (result == null || result.hasFocusable()) {
            return u0(focused, result, direction) ? result : super.focusSearch(focused, direction);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(focused, direction);
        }
        Z0(result, null);
        return focused;
    }

    public final boolean u0(View focused, View next, int direction) {
        if (next == null || next == this || R(next) == null) {
            return false;
        }
        if (focused != null && R(focused) != null) {
            this.q.set(0, 0, focused.getWidth(), focused.getHeight());
            this.r.set(0, 0, next.getWidth(), next.getHeight());
            offsetDescendantRectToMyCoords(focused, this.q);
            offsetDescendantRectToMyCoords(next, this.r);
            int rtl = this.u.Z() == 1 ? -1 : 1;
            int rightness = 0;
            Rect rect = this.q;
            int i2 = rect.left;
            Rect rect2 = this.r;
            int i3 = rect2.left;
            if ((i2 < i3 || rect.right <= i3) && rect.right < rect2.right) {
                rightness = 1;
            } else {
                int i4 = rect.right;
                int i5 = rect2.right;
                if ((i4 > i5 || i2 >= i5) && i2 > i3) {
                    rightness = -1;
                }
            }
            int downness = 0;
            int i6 = rect.top;
            int i7 = rect2.top;
            if ((i6 < i7 || rect.bottom <= i7) && rect.bottom < rect2.bottom) {
                downness = 1;
            } else {
                int i8 = rect.bottom;
                int i9 = rect2.bottom;
                if ((i8 > i9 || i6 >= i9) && i6 > i7) {
                    downness = -1;
                }
            }
            switch (direction) {
                case 1:
                    return downness < 0 || (downness == 0 && rightness * rtl <= 0);
                case 2:
                    return downness > 0 || (downness == 0 && rightness * rtl >= 0);
                case 17:
                    return rightness < 0;
                case 33:
                    return downness < 0;
                case 66:
                    return rightness > 0;
                case 130:
                    return downness > 0;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + direction + P());
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        if (!this.u.b1(this, child, focused) && focused != null) {
            Z0(child, focused);
        }
        super.requestChildFocus(child, focused);
    }

    public final void Z0(View child, View focused) {
        View rectView = focused != null ? focused : child;
        this.q.set(0, 0, rectView.getWidth(), rectView.getHeight());
        ViewGroup.LayoutParams focusedLayoutParams = rectView.getLayoutParams();
        if (focusedLayoutParams instanceof p) {
            p lp = (p) focusedLayoutParams;
            if (!lp.c) {
                Rect insets = lp.f907b;
                Rect rect = this.q;
                rect.left -= insets.left;
                rect.right += insets.right;
                rect.top -= insets.top;
                rect.bottom += insets.bottom;
            }
        }
        if (focused != null) {
            offsetDescendantRectToMyCoords(focused, this.q);
            offsetRectIntoDescendantCoords(child, this.q);
        }
        this.u.s1(this, child, this.q, !this.C, focused == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
        return this.u.r1(this, child, rect, immediate);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        o oVar = this.u;
        if (oVar == null || !oVar.F0()) {
            super.addFocusables(views, direction, focusableMode);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        if (t0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.M = 0;
        this.z = true;
        this.C = this.C && !isLayoutRequested();
        o oVar = this.u;
        if (oVar != null) {
            oVar.z(this);
        }
        this.u0 = false;
        if (e) {
            ThreadLocal<a.o.b.e> threadLocal = a.o.b.e.f668b;
            a.o.b.e eVar = threadLocal.get();
            this.m0 = eVar;
            if (eVar == null) {
                this.m0 = new a.o.b.e();
                Display display = a.h.k.v.v(this);
                float refreshRate = 60.0f;
                if (!isInEditMode() && display != null) {
                    float displayRefreshRate = display.getRefreshRate();
                    if (displayRefreshRate >= 30.0f) {
                        refreshRate = displayRefreshRate;
                    }
                }
                a.o.b.e eVar2 = this.m0;
                eVar2.f = 1.0E9f / refreshRate;
                threadLocal.set(eVar2);
            }
            this.m0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        a.o.b.e eVar;
        super.onDetachedFromWindow();
        l lVar = this.T;
        if (lVar != null) {
            lVar.k();
        }
        t1();
        this.z = false;
        o oVar = this.u;
        if (oVar != null) {
            oVar.A(this, this.k);
        }
        this.C0.clear();
        removeCallbacks(this.D0);
        this.o.j();
        if (e && (eVar = this.m0) != null) {
            eVar.j(this);
            this.m0 = null;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.z;
    }

    public void o(String message) {
        if (t0()) {
            if (message == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + P());
            }
            throw new IllegalStateException(message);
        }
        if (this.N > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(BuildConfig.FLAVOR + P()));
        }
    }

    public void j(r listener) {
        this.x.add(listener);
    }

    public void W0(r listener) {
        this.x.remove(listener);
        if (this.y == listener) {
            this.y = null;
        }
    }

    public final boolean K(MotionEvent e2) {
        r rVar = this.y;
        if (rVar == null) {
            if (e2.getAction() == 0) {
                return false;
            }
            return T(e2);
        }
        rVar.c(this, e2);
        int action = e2.getAction();
        if (action == 3 || action == 1) {
            this.y = null;
        }
        return true;
    }

    public final boolean T(MotionEvent e2) {
        int action = e2.getAction();
        int listenerCount = this.x.size();
        for (int i2 = 0; i2 < listenerCount; i2++) {
            r listener = this.x.get(i2);
            if (listener.b(this, e2) && action != 3) {
                this.y = listener;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e2) {
        if (this.F) {
            return false;
        }
        this.y = null;
        if (T(e2)) {
            q();
            return true;
        }
        o oVar = this.u;
        if (oVar == null) {
            return false;
        }
        boolean canScrollHorizontally = oVar.k();
        boolean canScrollVertically = this.u.l();
        if (this.W == null) {
            this.W = VelocityTracker.obtain();
        }
        this.W.addMovement(e2);
        int action = e2.getActionMasked();
        int actionIndex = e2.getActionIndex();
        switch (action) {
            case 0:
                if (this.G) {
                    this.G = false;
                }
                this.V = e2.getPointerId(0);
                int x2 = (int) (e2.getX() + 0.5f);
                this.c0 = x2;
                this.a0 = x2;
                int y2 = (int) (e2.getY() + 0.5f);
                this.d0 = y2;
                this.b0 = y2;
                if (this.U == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    s1(1);
                }
                int[] iArr = this.A0;
                iArr[1] = 0;
                iArr[0] = 0;
                int nestedScrollAxis = 0;
                if (canScrollHorizontally) {
                    nestedScrollAxis = 0 | 1;
                }
                if (canScrollVertically) {
                    nestedScrollAxis |= 2;
                }
                q1(nestedScrollAxis, 0);
                break;
            case 1:
                this.W.clear();
                s1(0);
                break;
            case 2:
                int index = e2.findPointerIndex(this.V);
                if (index >= 0) {
                    int x3 = (int) (e2.getX(index) + 0.5f);
                    int y3 = (int) (e2.getY(index) + 0.5f);
                    if (this.U != 1) {
                        int dx = x3 - this.a0;
                        int dy = y3 - this.b0;
                        boolean startScroll = false;
                        if (canScrollHorizontally && Math.abs(dx) > this.e0) {
                            this.c0 = x3;
                            startScroll = true;
                        }
                        if (canScrollVertically && Math.abs(dy) > this.e0) {
                            this.d0 = y3;
                            startScroll = true;
                        }
                        if (startScroll) {
                            setScrollState(1);
                            break;
                        }
                    }
                } else {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.V + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                break;
            case 3:
                q();
                break;
            case 5:
                this.V = e2.getPointerId(actionIndex);
                int x4 = (int) (e2.getX(actionIndex) + 0.5f);
                this.c0 = x4;
                this.a0 = x4;
                int y4 = (int) (e2.getY(actionIndex) + 0.5f);
                this.d0 = y4;
                this.b0 = y4;
                break;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                I0(e2);
                break;
        }
        int nestedScrollAxis2 = this.U;
        return nestedScrollAxis2 == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        int listenerCount = this.x.size();
        for (int i2 = 0; i2 < listenerCount; i2++) {
            r listener = this.x.get(i2);
            listener.a(disallowIntercept);
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent e2) {
        int dx;
        int dy;
        char c2;
        int dx2;
        int dy2;
        if (this.F || this.G) {
            return false;
        }
        int i2 = 1;
        if (K(e2)) {
            q();
            return true;
        }
        o oVar = this.u;
        if (oVar == null) {
            return false;
        }
        boolean canScrollHorizontally = oVar.k();
        boolean canScrollVertically = this.u.l();
        if (this.W == null) {
            this.W = VelocityTracker.obtain();
        }
        boolean eventAddedToVelocityTracker = false;
        int action = e2.getActionMasked();
        int actionIndex = e2.getActionIndex();
        if (action == 0) {
            int[] iArr = this.A0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent vtev = MotionEvent.obtain(e2);
        int[] iArr2 = this.A0;
        vtev.offsetLocation(iArr2[0], iArr2[1]);
        switch (action) {
            case 0:
                this.V = e2.getPointerId(0);
                int x2 = (int) (e2.getX() + 0.5f);
                this.c0 = x2;
                this.a0 = x2;
                int y2 = (int) (e2.getY() + 0.5f);
                this.d0 = y2;
                this.b0 = y2;
                int nestedScrollAxis = 0;
                if (canScrollHorizontally) {
                    nestedScrollAxis = 0 | 1;
                }
                if (canScrollVertically) {
                    nestedScrollAxis |= 2;
                }
                q1(nestedScrollAxis, 0);
                break;
            case 1:
                this.W.addMovement(vtev);
                eventAddedToVelocityTracker = true;
                this.W.computeCurrentVelocity(1000, this.h0);
                float xvel = canScrollHorizontally ? -this.W.getXVelocity(this.V) : 0.0f;
                float yvel = canScrollVertically ? -this.W.getYVelocity(this.V) : 0.0f;
                if ((xvel == 0.0f && yvel == 0.0f) || !a0((int) xvel, (int) yvel)) {
                    setScrollState(0);
                }
                b1();
                break;
            case 2:
                int index = e2.findPointerIndex(this.V);
                if (index >= 0) {
                    int x3 = (int) (e2.getX(index) + 0.5f);
                    int y3 = (int) (e2.getY(index) + 0.5f);
                    int dx3 = this.c0 - x3;
                    int dy3 = this.d0 - y3;
                    if (this.U == 1) {
                        dx = dx3;
                        dy = dy3;
                    } else {
                        boolean startScroll = false;
                        if (canScrollHorizontally) {
                            if (dx3 > 0) {
                                dx3 = Math.max(0, dx3 - this.e0);
                            } else {
                                dx3 = Math.min(0, this.e0 + dx3);
                            }
                            if (dx3 != 0) {
                                startScroll = true;
                            }
                        }
                        if (canScrollVertically) {
                            if (dy3 > 0) {
                                dy3 = Math.max(0, dy3 - this.e0);
                            } else {
                                dy3 = Math.min(0, this.e0 + dy3);
                            }
                            if (dy3 != 0) {
                                startScroll = true;
                            }
                        }
                        if (!startScroll) {
                            i2 = 1;
                        } else {
                            i2 = 1;
                            setScrollState(1);
                        }
                        dx = dx3;
                        dy = dy3;
                    }
                    if (this.U != i2) {
                        break;
                    } else {
                        int[] iArr3 = this.B0;
                        iArr3[0] = 0;
                        iArr3[i2] = 0;
                        if (!F(canScrollHorizontally ? dx : 0, canScrollVertically ? dy : 0, iArr3, this.z0, 0)) {
                            c2 = 1;
                            dx2 = dx;
                            dy2 = dy;
                        } else {
                            int[] iArr4 = this.B0;
                            int dx4 = dx - iArr4[0];
                            c2 = 1;
                            int dy4 = dy - iArr4[1];
                            int[] iArr5 = this.A0;
                            int i3 = iArr5[0];
                            int[] iArr6 = this.z0;
                            iArr5[0] = i3 + iArr6[0];
                            iArr5[1] = iArr5[1] + iArr6[1];
                            getParent().requestDisallowInterceptTouchEvent(true);
                            dx2 = dx4;
                            dy2 = dy4;
                        }
                        int[] iArr7 = this.z0;
                        this.c0 = x3 - iArr7[0];
                        this.d0 = y3 - iArr7[c2];
                        if (e1(canScrollHorizontally ? dx2 : 0, canScrollVertically ? dy2 : 0, e2)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        a.o.b.e eVar = this.m0;
                        if (eVar != null && (dx2 != 0 || dy2 != 0)) {
                            eVar.f(this, dx2, dy2);
                            break;
                        }
                    }
                } else {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.V + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                break;
            case 3:
                q();
                break;
            case 5:
                this.V = e2.getPointerId(actionIndex);
                int x4 = (int) (e2.getX(actionIndex) + 0.5f);
                this.c0 = x4;
                this.a0 = x4;
                int y4 = (int) (e2.getY(actionIndex) + 0.5f);
                this.d0 = y4;
                this.b0 = y4;
                break;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                I0(e2);
                break;
        }
        if (!eventAddedToVelocityTracker) {
            this.W.addMovement(vtev);
        }
        vtev.recycle();
        return true;
    }

    public final void b1() {
        VelocityTracker velocityTracker = this.W;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        s1(0);
        S0();
    }

    public final void q() {
        b1();
        setScrollState(0);
    }

    public final void I0(MotionEvent e2) {
        int actionIndex = e2.getActionIndex();
        if (e2.getPointerId(actionIndex) == this.V) {
            int newIndex = actionIndex == 0 ? 1 : 0;
            this.V = e2.getPointerId(newIndex);
            int x2 = (int) (e2.getX(newIndex) + 0.5f);
            this.c0 = x2;
            this.a0 = x2;
            int y2 = (int) (e2.getY(newIndex) + 0.5f);
            this.d0 = y2;
            this.b0 = y2;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent event) {
        float vScroll;
        float hScroll;
        if (this.u != null && !this.F && event.getAction() == 8) {
            if ((event.getSource() & 2) != 0) {
                if (this.u.l()) {
                    vScroll = -event.getAxisValue(9);
                } else {
                    vScroll = 0.0f;
                }
                if (this.u.k()) {
                    hScroll = event.getAxisValue(10);
                } else {
                    hScroll = 0.0f;
                }
            } else if ((event.getSource() & 4194304) != 0) {
                float axisScroll = event.getAxisValue(26);
                if (this.u.l()) {
                    float vScroll2 = -axisScroll;
                    vScroll = vScroll2;
                    hScroll = 0.0f;
                } else if (this.u.k()) {
                    vScroll = 0.0f;
                    hScroll = axisScroll;
                } else {
                    vScroll = 0.0f;
                    hScroll = 0.0f;
                }
            } else {
                vScroll = 0.0f;
                hScroll = 0.0f;
            }
            if (vScroll != 0.0f || hScroll != 0.0f) {
                e1((int) (this.i0 * hScroll), (int) (this.j0 * vScroll), event);
            }
        }
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int widthSpec, int heightSpec) {
        o oVar = this.u;
        if (oVar == null) {
            w(widthSpec, heightSpec);
            return;
        }
        boolean measureSpecModeIsExactly = false;
        if (oVar.s0()) {
            int widthMode = View.MeasureSpec.getMode(widthSpec);
            int heightMode = View.MeasureSpec.getMode(heightSpec);
            this.u.Z0(widthSpec, heightSpec);
            if (widthMode == 1073741824 && heightMode == 1073741824) {
                measureSpecModeIsExactly = true;
            }
            if (measureSpecModeIsExactly || this.t == null) {
                return;
            }
            if (this.o0.d == 1) {
                C();
            }
            this.u.A1(widthSpec, heightSpec);
            this.o0.i = true;
            D();
            this.u.D1(widthSpec, heightSpec);
            if (this.u.G1()) {
                this.u.A1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.o0.i = true;
                D();
                this.u.D1(widthSpec, heightSpec);
                return;
            }
            return;
        }
        if (this.A) {
            this.u.Z0(widthSpec, heightSpec);
            return;
        }
        if (this.I) {
            p1();
            F0();
            N0();
            G0();
            z zVar = this.o0;
            if (zVar.k) {
                zVar.g = true;
            } else {
                this.m.h();
                this.o0.g = false;
            }
            this.I = false;
            r1(false);
        } else if (this.o0.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.t;
        if (gVar != null) {
            this.o0.e = gVar.c();
        } else {
            this.o0.e = 0;
        }
        p1();
        this.u.Z0(widthSpec, heightSpec);
        r1(false);
        this.o0.g = false;
    }

    public void w(int widthSpec, int heightSpec) {
        int width = o.n(widthSpec, getPaddingLeft() + getPaddingRight(), a.h.k.v.E(this));
        int height = o.n(heightSpec, getPaddingTop() + getPaddingBottom(), a.h.k.v.D(this));
        setMeasuredDimension(width, height);
    }

    @Override // android.view.View
    public void onSizeChanged(int w2, int h2, int oldw, int oldh) {
        super.onSizeChanged(w2, h2, oldw, oldh);
        if (w2 != oldw || h2 != oldh) {
            r0();
        }
    }

    public void setItemAnimator(l animator) {
        l lVar = this.T;
        if (lVar != null) {
            lVar.k();
            this.T.v(null);
        }
        this.T = animator;
        if (animator != null) {
            animator.v(this.t0);
        }
    }

    public void F0() {
        this.M++;
    }

    public void G0() {
        H0(true);
    }

    public void H0(boolean enableChangeEvents) {
        int i2 = this.M - 1;
        this.M = i2;
        if (i2 < 1) {
            this.M = 0;
            if (enableChangeEvents) {
                A();
                J();
            }
        }
    }

    public boolean s0() {
        AccessibilityManager accessibilityManager = this.J;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public final void A() {
        int flags = this.H;
        this.H = 0;
        if (flags != 0 && s0()) {
            AccessibilityEvent event = AccessibilityEvent.obtain();
            event.setEventType(2048);
            a.h.k.e0.b.b(event, flags);
            sendAccessibilityEventUnchecked(event);
        }
    }

    public boolean t0() {
        return this.M > 0;
    }

    public boolean j1(AccessibilityEvent event) {
        if (t0()) {
            int type = 0;
            if (event != null) {
                type = a.h.k.e0.b.a(event);
            }
            if (type == 0) {
                type = 0;
            }
            this.H |= type;
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        if (j1(event)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(event);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        return true;
    }

    public l getItemAnimator() {
        return this.T;
    }

    public void L0() {
        if (!this.u0 && this.z) {
            a.h.k.v.g0(this, this.D0);
            this.u0 = true;
        }
    }

    public final boolean M0() {
        return this.T != null && this.u.L1();
    }

    public final void N0() {
        boolean z2;
        if (this.K) {
            this.m.u();
            if (this.L) {
                this.u.S0(this);
            }
        }
        if (M0()) {
            this.m.r();
        } else {
            this.m.h();
        }
        boolean z3 = false;
        boolean animationTypeSupported = this.r0 || this.s0;
        this.o0.j = this.C && this.T != null && ((z2 = this.K) || animationTypeSupported || this.u.h) && (!z2 || this.t.g());
        z zVar = this.o0;
        if (zVar.j && animationTypeSupported && !this.K && M0()) {
            z3 = true;
        }
        zVar.k = z3;
    }

    public void B() {
        if (this.t == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.u == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        z zVar = this.o0;
        zVar.i = false;
        if (zVar.d == 1) {
            C();
            this.u.z1(this);
            D();
        } else if (this.m.o() || this.u.o0() != getWidth() || this.u.W() != getHeight()) {
            this.u.z1(this);
            D();
        } else {
            this.u.z1(this);
        }
        E();
    }

    public final void c1() {
        int j2;
        View child = null;
        if (this.k0 && hasFocus() && this.t != null) {
            child = getFocusedChild();
        }
        c0 focusedVh = child == null ? null : S(child);
        if (focusedVh == null) {
            a1();
            return;
        }
        this.o0.m = this.t.g() ? focusedVh.k() : -1L;
        z zVar = this.o0;
        if (this.K) {
            j2 = -1;
        } else {
            j2 = focusedVh.v() ? focusedVh.e : focusedVh.j();
        }
        zVar.l = j2;
        this.o0.n = h0(focusedVh.f889b);
    }

    public final void a1() {
        z zVar = this.o0;
        zVar.m = -1L;
        zVar.l = -1;
        zVar.n = -1;
    }

    public final View W() {
        c0 nextFocus;
        z zVar = this.o0;
        int startFocusSearchIndex = zVar.l;
        if (startFocusSearchIndex == -1) {
            startFocusSearchIndex = 0;
        }
        int itemCount = zVar.b();
        for (int i2 = startFocusSearchIndex; i2 < itemCount; i2++) {
            c0 nextFocus2 = X(i2);
            if (nextFocus2 == null) {
                break;
            }
            if (nextFocus2.f889b.hasFocusable()) {
                return nextFocus2.f889b;
            }
        }
        int limit = Math.min(itemCount, startFocusSearchIndex);
        for (int i3 = limit - 1; i3 >= 0 && (nextFocus = X(i3)) != null; i3--) {
            if (nextFocus.f889b.hasFocusable()) {
                return nextFocus.f889b;
            }
        }
        return null;
    }

    public final void R0() {
        View child;
        if (this.k0 && this.t != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() == 131072 && isFocused()) {
                return;
            }
            if (!isFocused()) {
                View focusedChild = getFocusedChild();
                if (!this.n.n(focusedChild)) {
                    return;
                }
            }
            c0 focusTarget = null;
            if (this.o0.m != -1 && this.t.g()) {
                focusTarget = Y(this.o0.m);
            }
            View viewToFocus = null;
            if (focusTarget == null || this.n.n(focusTarget.f889b) || !focusTarget.f889b.hasFocusable()) {
                if (this.n.g() > 0) {
                    viewToFocus = W();
                }
            } else {
                viewToFocus = focusTarget.f889b;
            }
            if (viewToFocus != null) {
                int i2 = this.o0.n;
                if (i2 != -1 && (child = viewToFocus.findViewById(i2)) != null && child.isFocusable()) {
                    viewToFocus = child;
                }
                viewToFocus.requestFocus();
            }
        }
    }

    public final int h0(View view) {
        int lastKnownId = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            int id = view.getId();
            if (id != -1) {
                lastKnownId = view.getId();
            }
        }
        return lastKnownId;
    }

    public final void Q(z state) {
        if (getScrollState() == 2) {
            OverScroller scroller = this.l0.d;
            scroller.getFinalX();
            scroller.getCurrX();
            state.getClass();
            scroller.getFinalY();
            scroller.getCurrY();
            state.getClass();
            return;
        }
        state.getClass();
        state.getClass();
    }

    public final void C() {
        this.o0.a(1);
        Q(this.o0);
        this.o0.i = false;
        p1();
        this.o.f();
        F0();
        N0();
        c1();
        z zVar = this.o0;
        zVar.h = zVar.j && this.s0;
        this.s0 = false;
        this.r0 = false;
        zVar.g = zVar.k;
        zVar.e = this.t.c();
        U(this.x0);
        if (this.o0.j) {
            int count = this.n.g();
            for (int i2 = 0; i2 < count; i2++) {
                c0 holder = f0(this.n.f(i2));
                if (!holder.J() && (!holder.t() || this.t.g())) {
                    l lVar = this.T;
                    l.e(holder);
                    holder.o();
                    this.o.e(holder, lVar.t(holder));
                    if (this.o0.h && holder.y() && !holder.v() && !holder.J() && !holder.t()) {
                        long key = c0(holder);
                        this.o.c(key, holder);
                    }
                }
            }
        }
        if (this.o0.k) {
            d1();
            z zVar2 = this.o0;
            boolean didStructureChange = zVar2.f;
            zVar2.f = false;
            this.u.X0(this.k, zVar2);
            this.o0.f = didStructureChange;
            for (int i3 = 0; i3 < this.n.g(); i3++) {
                View child = this.n.f(i3);
                c0 viewHolder = f0(child);
                if (!viewHolder.J() && !this.o.i(viewHolder)) {
                    int flags = l.e(viewHolder);
                    boolean wasHidden = viewHolder.p(8192);
                    if (!wasHidden) {
                        int i4 = flags | 4096;
                    }
                    l lVar2 = this.T;
                    viewHolder.o();
                    l.c animationInfo = lVar2.t(viewHolder);
                    if (wasHidden) {
                        Q0(viewHolder, animationInfo);
                    } else {
                        this.o.a(viewHolder, animationInfo);
                    }
                }
            }
            s();
        } else {
            s();
        }
        G0();
        r1(false);
        this.o0.d = 2;
    }

    public final void D() {
        p1();
        F0();
        this.o0.a(6);
        this.m.h();
        this.o0.e = this.t.c();
        z zVar = this.o0;
        zVar.c = 0;
        zVar.g = false;
        this.u.X0(this.k, zVar);
        z zVar2 = this.o0;
        zVar2.f = false;
        this.l = null;
        zVar2.j = zVar2.j && this.T != null;
        zVar2.d = 4;
        G0();
        r1(false);
    }

    public final void E() {
        this.o0.a(4);
        p1();
        F0();
        z zVar = this.o0;
        zVar.d = 1;
        if (zVar.j) {
            for (int i2 = this.n.g() - 1; i2 >= 0; i2--) {
                c0 holder = f0(this.n.f(i2));
                if (!holder.J()) {
                    long key = c0(holder);
                    l.c animationInfo = this.T.s(holder);
                    c0 oldChangeViewHolder = this.o.g(key);
                    if (oldChangeViewHolder != null && !oldChangeViewHolder.J()) {
                        boolean oldDisappearing = this.o.h(oldChangeViewHolder);
                        boolean newDisappearing = this.o.h(holder);
                        if (oldDisappearing && oldChangeViewHolder == holder) {
                            this.o.d(holder, animationInfo);
                        } else {
                            l.c preInfo = this.o.n(oldChangeViewHolder);
                            this.o.d(holder, animationInfo);
                            l.c postInfo = this.o.m(holder);
                            if (preInfo == null) {
                                k0(key, holder, oldChangeViewHolder);
                            } else {
                                m(oldChangeViewHolder, holder, preInfo, postInfo, oldDisappearing, newDisappearing);
                            }
                        }
                    } else {
                        this.o.d(holder, animationInfo);
                    }
                }
            }
            this.o.o(this.E0);
        }
        this.u.l1(this.k);
        z zVar2 = this.o0;
        zVar2.f920b = zVar2.e;
        this.K = false;
        this.L = false;
        zVar2.j = false;
        zVar2.k = false;
        this.u.h = false;
        ArrayList<c0> arrayList = this.k.f913b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.u;
        if (oVar.n) {
            oVar.m = 0;
            oVar.n = false;
            this.k.K();
        }
        this.u.Y0(this.o0);
        G0();
        r1(false);
        this.o.f();
        int[] iArr = this.x0;
        if (x(iArr[0], iArr[1])) {
            I(0, 0);
        }
        R0();
        a1();
    }

    public final void k0(long key, c0 holder, c0 oldChangeViewHolder) {
        int childCount = this.n.g();
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = this.n.f(i2);
            c0 other = f0(view);
            if (other != holder) {
                long otherKey = c0(other);
                if (otherKey == key) {
                    g gVar = this.t;
                    if (gVar != null && gVar.g()) {
                        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + other + " \n View Holder 2:" + holder + P());
                    }
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + other + " \n View Holder 2:" + holder + P());
                }
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + oldChangeViewHolder + " cannot be found but it is necessary for " + holder + P());
    }

    public void Q0(c0 viewHolder, l.c animationInfo) {
        viewHolder.F(0, 8192);
        if (this.o0.h && viewHolder.y() && !viewHolder.v() && !viewHolder.J()) {
            long key = c0(viewHolder);
            this.o.c(key, viewHolder);
        }
        this.o.e(viewHolder, animationInfo);
    }

    public final void U(int[] into) {
        int count = this.n.g();
        if (count == 0) {
            into[0] = -1;
            into[1] = -1;
            return;
        }
        int minPositionPreLayout = Integer.MAX_VALUE;
        int maxPositionPreLayout = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < count; i2++) {
            c0 holder = f0(this.n.f(i2));
            if (!holder.J()) {
                int pos = holder.m();
                if (pos < minPositionPreLayout) {
                    minPositionPreLayout = pos;
                }
                if (pos > maxPositionPreLayout) {
                    maxPositionPreLayout = pos;
                }
            }
        }
        into[0] = minPositionPreLayout;
        into[1] = maxPositionPreLayout;
    }

    public final boolean x(int minPositionPreLayout, int maxPositionPreLayout) {
        U(this.x0);
        int[] iArr = this.x0;
        return (iArr[0] == minPositionPreLayout && iArr[1] == maxPositionPreLayout) ? false : true;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View child, boolean animate) {
        c0 vh = f0(child);
        if (vh != null) {
            if (vh.x()) {
                vh.f();
            } else if (!vh.J()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + vh + P());
            }
        }
        child.clearAnimation();
        z(child);
        super.removeDetachedView(child, animate);
    }

    public long c0(c0 holder) {
        return this.t.g() ? holder.k() : holder.d;
    }

    public void l(c0 itemHolder, l.c preLayoutInfo, l.c postLayoutInfo) {
        itemHolder.G(false);
        if (this.T.a(itemHolder, preLayoutInfo, postLayoutInfo)) {
            L0();
        }
    }

    public void n(c0 holder, l.c preLayoutInfo, l.c postLayoutInfo) {
        g(holder);
        holder.G(false);
        if (this.T.c(holder, preLayoutInfo, postLayoutInfo)) {
            L0();
        }
    }

    public final void m(c0 oldHolder, c0 newHolder, l.c preInfo, l.c postInfo, boolean oldHolderDisappearing, boolean newHolderDisappearing) {
        oldHolder.G(false);
        if (oldHolderDisappearing) {
            g(oldHolder);
        }
        if (oldHolder != newHolder) {
            if (newHolderDisappearing) {
                g(newHolder);
            }
            oldHolder.i = newHolder;
            g(oldHolder);
            this.k.J(oldHolder);
            newHolder.G(false);
            newHolder.j = oldHolder;
        }
        if (this.T.b(oldHolder, newHolder, preInfo, postInfo)) {
            L0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l2, int t2, int r2, int b2) {
        a.h.g.c.a("RV OnLayout");
        B();
        a.h.g.c.b();
        this.C = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.D == 0 && !this.F) {
            super.requestLayout();
        } else {
            this.E = true;
        }
    }

    public void w0() {
        int childCount = this.n.j();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = this.n.i(i2);
            ((p) child.getLayoutParams()).c = true;
        }
        this.k.s();
    }

    @Override // android.view.View
    public void draw(Canvas c2) {
        super.draw(c2);
        int count = this.w.size();
        for (int i2 = 0; i2 < count; i2++) {
            this.w.get(i2).i(c2, this, this.o0);
        }
        int i3 = 0;
        EdgeEffect edgeEffect = this.P;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int restore = c2.save();
            int padding = this.p ? getPaddingBottom() : 0;
            c2.rotate(270.0f);
            c2.translate((-getHeight()) + padding, 0.0f);
            EdgeEffect edgeEffect2 = this.P;
            i3 = (edgeEffect2 == null || !edgeEffect2.draw(c2)) ? 0 : 1;
            c2.restoreToCount(restore);
        }
        EdgeEffect edgeEffect3 = this.Q;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int restore2 = c2.save();
            if (this.p) {
                c2.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.Q;
            i3 |= (edgeEffect4 == null || !edgeEffect4.draw(c2)) ? 0 : 1;
            c2.restoreToCount(restore2);
        }
        EdgeEffect edgeEffect5 = this.R;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int restore3 = c2.save();
            int width = getWidth();
            int padding2 = this.p ? getPaddingTop() : 0;
            c2.rotate(90.0f);
            c2.translate(-padding2, -width);
            EdgeEffect edgeEffect6 = this.R;
            i3 |= (edgeEffect6 == null || !edgeEffect6.draw(c2)) ? 0 : 1;
            c2.restoreToCount(restore3);
        }
        EdgeEffect edgeEffect7 = this.S;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int restore4 = c2.save();
            c2.rotate(180.0f);
            if (this.p) {
                c2.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                c2.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.S;
            i3 |= (edgeEffect8 == null || !edgeEffect8.draw(c2)) ? 0 : 1;
            c2.restoreToCount(restore4);
        }
        if (i3 == 0 && this.T != null && this.w.size() > 0 && this.T.p()) {
            i3 = 1;
        }
        if (i3 != 0) {
            a.h.k.v.f0(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas c2) {
        super.onDraw(c2);
        int count = this.w.size();
        for (int i2 = 0; i2 < count; i2++) {
            this.w.get(i2).g(c2, this, this.o0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p2) {
        return (p2 instanceof p) && this.u.m((p) p2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.u;
        if (oVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
        }
        return oVar.D();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        o oVar = this.u;
        if (oVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
        }
        return oVar.E(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p2) {
        o oVar = this.u;
        if (oVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
        }
        return oVar.F(p2);
    }

    public void d1() {
        int childCount = this.n.j();
        for (int i2 = 0; i2 < childCount; i2++) {
            c0 holder = f0(this.n.i(i2));
            if (!holder.J()) {
                holder.E();
            }
        }
    }

    public void s() {
        int childCount = this.n.j();
        for (int i2 = 0; i2 < childCount; i2++) {
            c0 holder = f0(this.n.i(i2));
            if (!holder.J()) {
                holder.c();
            }
        }
        this.k.d();
    }

    public void B0(int from, int to) {
        int start;
        int end;
        int inBetweenOffset;
        int i2;
        int childCount = this.n.j();
        if (from < to) {
            start = from;
            end = to;
            inBetweenOffset = -1;
        } else {
            start = to;
            end = from;
            inBetweenOffset = 1;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c0 holder = f0(this.n.i(i3));
            if (holder != null && (i2 = holder.d) >= start && i2 <= end) {
                if (i2 == from) {
                    holder.A(to - from, false);
                } else {
                    holder.A(inBetweenOffset, false);
                }
                this.o0.f = true;
            }
        }
        this.k.v(from, to);
        requestLayout();
    }

    public void A0(int positionStart, int itemCount) {
        int childCount = this.n.j();
        for (int i2 = 0; i2 < childCount; i2++) {
            c0 holder = f0(this.n.i(i2));
            if (holder != null && !holder.J() && holder.d >= positionStart) {
                holder.A(itemCount, false);
                this.o0.f = true;
            }
        }
        this.k.u(positionStart, itemCount);
        requestLayout();
    }

    public void C0(int positionStart, int itemCount, boolean applyToPreLayout) {
        int positionEnd = positionStart + itemCount;
        int childCount = this.n.j();
        for (int i2 = 0; i2 < childCount; i2++) {
            c0 holder = f0(this.n.i(i2));
            if (holder != null && !holder.J()) {
                int i3 = holder.d;
                if (i3 >= positionEnd) {
                    holder.A(-itemCount, applyToPreLayout);
                    this.o0.f = true;
                } else if (i3 >= positionStart) {
                    holder.i(positionStart - 1, -itemCount, applyToPreLayout);
                    this.o0.f = true;
                }
            }
        }
        this.k.w(positionStart, itemCount, applyToPreLayout);
        requestLayout();
    }

    public void v1(int positionStart, int itemCount, Object payload) {
        int i2;
        int childCount = this.n.j();
        int positionEnd = positionStart + itemCount;
        for (int i3 = 0; i3 < childCount; i3++) {
            View child = this.n.i(i3);
            c0 holder = f0(child);
            if (holder != null && !holder.J() && (i2 = holder.d) >= positionStart && i2 < positionEnd) {
                holder.b(2);
                holder.a(payload);
                ((p) child.getLayoutParams()).c = true;
            }
        }
        this.k.M(positionStart, itemCount);
    }

    public boolean p(c0 viewHolder) {
        l lVar = this.T;
        return lVar == null || lVar.g(viewHolder, viewHolder.o());
    }

    public void O0(boolean dispatchItemsChanged) {
        this.L |= dispatchItemsChanged;
        this.K = true;
        x0();
    }

    public void x0() {
        int childCount = this.n.j();
        for (int i2 = 0; i2 < childCount; i2++) {
            c0 holder = f0(this.n.i(i2));
            if (holder != null && !holder.J()) {
                holder.b(6);
            }
        }
        w0();
        this.k.t();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.k0;
    }

    public void setPreserveFocusAfterLayout(boolean preserveFocusAfterLayout) {
        this.k0 = preserveFocusAfterLayout;
    }

    public c0 e0(View child) {
        ViewParent parent = child.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + child + " is not a direct child of " + this);
        }
        return f0(child);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View R(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L18
            r1 = r3
            goto L19
        L18:
            r1 = 0
        L19:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.R(android.view.View):android.view.View");
    }

    public c0 S(View view) {
        View itemView = R(view);
        if (itemView == null) {
            return null;
        }
        return e0(itemView);
    }

    public static c0 f0(View child) {
        if (child == null) {
            return null;
        }
        return ((p) child.getLayoutParams()).f906a;
    }

    public int d0(View child) {
        c0 holder = f0(child);
        if (holder != null) {
            return holder.m();
        }
        return -1;
    }

    public c0 X(int position) {
        if (this.K) {
            return null;
        }
        int childCount = this.n.j();
        c0 hidden = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            c0 holder = f0(this.n.i(i2));
            if (holder != null && !holder.v() && b0(holder) == position) {
                if (this.n.n(holder.f889b)) {
                    hidden = holder;
                } else {
                    return holder;
                }
            }
        }
        return hidden;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.RecyclerView.c0 Z(int r7, boolean r8) {
        /*
            r6 = this;
            a.o.b.b r0 = r6.n
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            a.o.b.b r3 = r6.n
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$c0 r3 = f0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.v()
            if (r4 != 0) goto L37
            if (r8 == 0) goto L23
            int r4 = r3.d
            if (r4 == r7) goto L2a
            goto L37
        L23:
            int r4 = r3.m()
            if (r4 == r7) goto L2a
            goto L37
        L2a:
            a.o.b.b r4 = r6.n
            android.view.View r5 = r3.f889b
            boolean r4 = r4.n(r5)
            if (r4 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Z(int, boolean):androidx.recyclerview.widget.RecyclerView$c0");
    }

    public c0 Y(long id) {
        g gVar = this.t;
        if (gVar == null || !gVar.g()) {
            return null;
        }
        int childCount = this.n.j();
        c0 hidden = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            c0 holder = f0(this.n.i(i2));
            if (holder != null && !holder.v() && holder.k() == id) {
                if (this.n.n(holder.f889b)) {
                    hidden = holder;
                } else {
                    return holder;
                }
            }
        }
        return hidden;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        return super.drawChild(canvas, child, drawingTime);
    }

    public void z0(int dy) {
        int childCount = this.n.g();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.n.f(i2).offsetTopAndBottom(dy);
        }
    }

    public void D0() {
    }

    public void E0() {
    }

    public void y0(int dx) {
        int childCount = this.n.g();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.n.f(i2).offsetLeftAndRight(dx);
        }
    }

    public static void g0(View view, Rect outBounds) {
        p lp = (p) view.getLayoutParams();
        Rect insets = lp.f907b;
        outBounds.set((view.getLeft() - insets.left) - ((ViewGroup.MarginLayoutParams) lp).leftMargin, (view.getTop() - insets.top) - ((ViewGroup.MarginLayoutParams) lp).topMargin, view.getRight() + insets.right + ((ViewGroup.MarginLayoutParams) lp).rightMargin, view.getBottom() + insets.bottom + ((ViewGroup.MarginLayoutParams) lp).bottomMargin);
    }

    public Rect j0(View child) {
        p lp = (p) child.getLayoutParams();
        if (!lp.c) {
            return lp.f907b;
        }
        if (this.o0.e() && (lp.b() || lp.d())) {
            return lp.f907b;
        }
        Rect insets = lp.f907b;
        insets.set(0, 0, 0, 0);
        int decorCount = this.w.size();
        for (int i2 = 0; i2 < decorCount; i2++) {
            this.q.set(0, 0, 0, 0);
            this.w.get(i2).e(this.q, child, this);
            int i3 = insets.left;
            Rect rect = this.q;
            insets.left = i3 + rect.left;
            insets.top += rect.top;
            insets.right += rect.right;
            insets.bottom += rect.bottom;
        }
        lp.c = false;
        return insets;
    }

    public void K0() {
    }

    public void I(int hresult, int vresult) {
        this.N++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - hresult, scrollY - vresult);
        K0();
        s sVar = this.p0;
        if (sVar != null) {
            sVar.b(this, hresult, vresult);
        }
        List<s> list = this.q0;
        if (list != null) {
            for (int i2 = list.size() - 1; i2 >= 0; i2--) {
                this.q0.get(i2).b(this, hresult, vresult);
            }
        }
        int i3 = this.N;
        this.N = i3 - 1;
    }

    public void J0() {
    }

    public void H(int state) {
        o oVar = this.u;
        if (oVar != null) {
            oVar.e1(state);
        }
        J0();
        s sVar = this.p0;
        if (sVar != null) {
            sVar.a(this, state);
        }
        List<s> list = this.q0;
        if (list != null) {
            for (int i2 = list.size() - 1; i2 >= 0; i2--) {
                this.q0.get(i2).a(this, state);
            }
        }
    }

    public boolean l0() {
        return !this.C || this.K || this.m.n();
    }

    /* loaded from: classes.dex */
    public class b0 implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public int f887b;
        public int c;
        public OverScroller d;
        public Interpolator e;
        public boolean f;
        public boolean g;

        public b0() {
            Interpolator interpolator = RecyclerView.i;
            this.e = interpolator;
            this.f = false;
            this.g = false;
            this.d = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int, boolean] */
        /* JADX WARN: Type inference failed for: r2v6 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.u != null) {
                this.g = false;
                this.f = true;
                recyclerView.u();
                OverScroller scroller = this.d;
                if (scroller.computeScrollOffset()) {
                    int x = scroller.getCurrX();
                    int y = scroller.getCurrY();
                    int unconsumedX = x - this.f887b;
                    int unconsumedY = y - this.c;
                    this.f887b = x;
                    this.c = y;
                    int consumedX = 0;
                    int consumedY = 0;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    int[] iArr = recyclerView2.B0;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    if (recyclerView2.F(unconsumedX, unconsumedY, iArr, null, 1)) {
                        int[] iArr2 = RecyclerView.this.B0;
                        unconsumedX -= iArr2[0];
                        unconsumedY -= iArr2[1];
                    }
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.t(unconsumedX, unconsumedY);
                    }
                    RecyclerView recyclerView3 = RecyclerView.this;
                    if (recyclerView3.t != null) {
                        int[] iArr3 = recyclerView3.B0;
                        iArr3[0] = 0;
                        iArr3[1] = 0;
                        recyclerView3.f1(unconsumedX, unconsumedY, iArr3);
                        RecyclerView recyclerView4 = RecyclerView.this;
                        int[] iArr4 = recyclerView4.B0;
                        consumedX = iArr4[0];
                        consumedY = iArr4[1];
                        unconsumedX -= consumedX;
                        unconsumedY -= consumedY;
                        y smoothScroller = recyclerView4.u.g;
                        if (smoothScroller != null && !smoothScroller.g() && smoothScroller.h()) {
                            int adapterSize = RecyclerView.this.o0.b();
                            if (adapterSize == 0) {
                                smoothScroller.r();
                            } else if (smoothScroller.f() >= adapterSize) {
                                smoothScroller.p(adapterSize - 1);
                                smoothScroller.j(consumedX, consumedY);
                            } else {
                                smoothScroller.j(consumedX, consumedY);
                            }
                        }
                    }
                    if (!RecyclerView.this.w.isEmpty()) {
                        RecyclerView.this.invalidate();
                    }
                    RecyclerView recyclerView5 = RecyclerView.this;
                    int[] iArr5 = recyclerView5.B0;
                    iArr5[0] = 0;
                    iArr5[1] = 0;
                    recyclerView5.G(consumedX, consumedY, unconsumedX, unconsumedY, null, 1, iArr5);
                    RecyclerView recyclerView6 = RecyclerView.this;
                    int[] iArr6 = recyclerView6.B0;
                    int unconsumedX2 = unconsumedX - iArr6[0];
                    int unconsumedY2 = unconsumedY - iArr6[1];
                    if (consumedX != 0 || consumedY != 0) {
                        recyclerView6.I(consumedX, consumedY);
                    }
                    if (!RecyclerView.this.awakenScrollBars()) {
                        RecyclerView.this.invalidate();
                    }
                    boolean scrollerFinishedX = scroller.getCurrX() == scroller.getFinalX();
                    boolean scrollerFinishedY = scroller.getCurrY() == scroller.getFinalY();
                    boolean doneScrolling = scroller.isFinished() || ((scrollerFinishedX || unconsumedX2 != 0) && (scrollerFinishedY || unconsumedY2 != 0));
                    y smoothScroller2 = RecyclerView.this.u.g;
                    boolean smoothScrollerPending = smoothScroller2 != null && smoothScroller2.g();
                    if (!smoothScrollerPending && doneScrolling) {
                        if (RecyclerView.this.getOverScrollMode() != 2) {
                            int vel = (int) scroller.getCurrVelocity();
                            int velX = unconsumedX2 < 0 ? -vel : unconsumedX2 > 0 ? vel : 0;
                            int velY = unconsumedY2 < 0 ? -vel : unconsumedY2 > 0 ? vel : 0;
                            RecyclerView.this.a(velX, velY);
                        }
                        if (RecyclerView.e) {
                            RecyclerView.this.n0.b();
                        }
                    } else {
                        e();
                        RecyclerView recyclerView7 = RecyclerView.this;
                        a.o.b.e eVar = recyclerView7.m0;
                        if (eVar != null) {
                            eVar.f(recyclerView7, consumedX, consumedY);
                        }
                    }
                }
                y smoothScroller3 = RecyclerView.this.u.g;
                if (smoothScroller3 == null || !smoothScroller3.g()) {
                    r2 = 0;
                } else {
                    r2 = 0;
                    smoothScroller3.j(0, 0);
                }
                this.f = r2;
                if (this.g) {
                    d();
                    return;
                } else {
                    RecyclerView.this.setScrollState(r2);
                    RecyclerView.this.s1(1);
                    return;
                }
            }
            g();
        }

        public void e() {
            if (this.f) {
                this.g = true;
            } else {
                d();
            }
        }

        public final void d() {
            RecyclerView.this.removeCallbacks(this);
            a.h.k.v.g0(RecyclerView.this, this);
        }

        public void c(int velocityX, int velocityY) {
            RecyclerView.this.setScrollState(2);
            this.c = 0;
            this.f887b = 0;
            Interpolator interpolator = this.e;
            Interpolator interpolator2 = RecyclerView.i;
            if (interpolator != interpolator2) {
                this.e = interpolator2;
                this.d = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.d.fling(0, 0, velocityX, velocityY, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        public void f(int dx, int dy, int duration, Interpolator interpolator) {
            if (duration == Integer.MIN_VALUE) {
                duration = a(dx, dy, 0, 0);
            }
            if (interpolator == null) {
                interpolator = RecyclerView.i;
            }
            if (this.e != interpolator) {
                this.e = interpolator;
                this.d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.c = 0;
            this.f887b = 0;
            RecyclerView.this.setScrollState(2);
            this.d.startScroll(0, 0, dx, dy, duration);
            if (Build.VERSION.SDK_INT < 23) {
                this.d.computeScrollOffset();
            }
            e();
        }

        public final float b(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        public final int a(int dx, int dy, int vx, int vy) {
            int duration;
            int absDx = Math.abs(dx);
            int absDy = Math.abs(dy);
            boolean horizontal = absDx > absDy;
            int velocity = (int) Math.sqrt((vx * vx) + (vy * vy));
            int delta = (int) Math.sqrt((dx * dx) + (dy * dy));
            RecyclerView recyclerView = RecyclerView.this;
            int containerSize = horizontal ? recyclerView.getWidth() : recyclerView.getHeight();
            int halfContainerSize = containerSize / 2;
            float distanceRatio = Math.min(1.0f, (delta * 1.0f) / containerSize);
            float distance = halfContainerSize + (halfContainerSize * b(distanceRatio));
            if (velocity > 0) {
                duration = Math.round(Math.abs(distance / velocity) * 1000.0f) * 4;
            } else {
                float absDelta = horizontal ? absDx : absDy;
                duration = (int) (((absDelta / containerSize) + 1.0f) * 300.0f);
            }
            return Math.min(duration, 2000);
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.d.abortAnimation();
        }
    }

    public void Y0() {
        c0 c0Var;
        int count = this.n.g();
        for (int i2 = 0; i2 < count; i2++) {
            View view = this.n.f(i2);
            c0 holder = e0(view);
            if (holder != null && (c0Var = holder.j) != null) {
                View shadowingView = c0Var.f889b;
                int left = view.getLeft();
                int top = view.getTop();
                if (left != shadowingView.getLeft() || top != shadowingView.getTop()) {
                    shadowingView.layout(left, top, shadowingView.getWidth() + left, shadowingView.getHeight() + top);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class w extends i {
        public w() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.o(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.o0.f = true;
            recyclerView.O0(true);
            if (!RecyclerView.this.m.n()) {
                RecyclerView.this.requestLayout();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class k {
        public EdgeEffect a(RecyclerView view) {
            return new EdgeEffect(view.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static class t {

        /* renamed from: a, reason: collision with root package name */
        public SparseArray<a> f908a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        public int f909b = 0;

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final ArrayList<c0> f910a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            public int f911b = 5;
            public long c = 0;
            public long d = 0;
        }

        public void b() {
            for (int i = 0; i < this.f908a.size(); i++) {
                a data = this.f908a.valueAt(i);
                data.f910a.clear();
            }
        }

        public c0 f(int viewType) {
            a scrapData = this.f908a.get(viewType);
            if (scrapData != null && !scrapData.f910a.isEmpty()) {
                ArrayList<c0> arrayList = scrapData.f910a;
                for (int i = arrayList.size() - 1; i >= 0; i--) {
                    if (!arrayList.get(i).r()) {
                        return arrayList.remove(i);
                    }
                }
                return null;
            }
            return null;
        }

        public void i(c0 scrap) {
            int viewType = scrap.l();
            ArrayList<c0> arrayList = g(viewType).f910a;
            if (this.f908a.get(viewType).f911b <= arrayList.size()) {
                return;
            }
            scrap.D();
            arrayList.add(scrap);
        }

        public long j(long oldAverage, long newValue) {
            if (oldAverage == 0) {
                return newValue;
            }
            return ((oldAverage / 4) * 3) + (newValue / 4);
        }

        public void e(int viewType, long createTimeNs) {
            a scrapData = g(viewType);
            scrapData.c = j(scrapData.c, createTimeNs);
        }

        public void d(int viewType, long bindTimeNs) {
            a scrapData = g(viewType);
            scrapData.d = j(scrapData.d, bindTimeNs);
        }

        public boolean l(int viewType, long approxCurrentNs, long deadlineNs) {
            long expectedDurationNs = g(viewType).c;
            return expectedDurationNs == 0 || approxCurrentNs + expectedDurationNs < deadlineNs;
        }

        public boolean k(int viewType, long approxCurrentNs, long deadlineNs) {
            long expectedDurationNs = g(viewType).d;
            return expectedDurationNs == 0 || approxCurrentNs + expectedDurationNs < deadlineNs;
        }

        public void a() {
            this.f909b++;
        }

        public void c() {
            this.f909b--;
        }

        public void h(g oldAdapter, g newAdapter, boolean compatibleWithPrevious) {
            if (oldAdapter != null) {
                c();
            }
            if (!compatibleWithPrevious && this.f909b == 0) {
                b();
            }
            if (newAdapter != null) {
                a();
            }
        }

        public final a g(int viewType) {
            a scrapData = this.f908a.get(viewType);
            if (scrapData == null) {
                a scrapData2 = new a();
                this.f908a.put(viewType, scrapData2);
                return scrapData2;
            }
            return scrapData;
        }
    }

    public static RecyclerView V(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup parent = (ViewGroup) view;
        int count = parent.getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View child = parent.getChildAt(i2);
            RecyclerView descendant = V(child);
            if (descendant != null) {
                return descendant;
            }
        }
        return null;
    }

    public static void r(c0 holder) {
        WeakReference<RecyclerView> weakReference = holder.c;
        if (weakReference != null) {
            RecyclerView item = weakReference.get();
            while (item != null) {
                if (item == holder.f889b) {
                    return;
                }
                Object parent = item.getParent();
                if (parent instanceof View) {
                    item = (View) parent;
                } else {
                    item = null;
                }
            }
            holder.c = null;
        }
    }

    public long getNanoTime() {
        if (e) {
            return System.nanoTime();
        }
        return 0L;
    }

    /* loaded from: classes.dex */
    public final class u {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<c0> f912a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<c0> f913b;
        public final ArrayList<c0> c;
        public final List<c0> d;
        public int e;
        public int f;
        public t g;

        public u() {
            ArrayList<c0> arrayList = new ArrayList<>();
            this.f912a = arrayList;
            this.f913b = null;
            this.c = new ArrayList<>();
            this.d = Collections.unmodifiableList(arrayList);
            this.e = 2;
            this.f = 2;
        }

        public void c() {
            this.f912a.clear();
            z();
        }

        public void G(int viewCount) {
            this.e = viewCount;
            K();
        }

        public void K() {
            o oVar = RecyclerView.this.u;
            int extraCache = oVar != null ? oVar.m : 0;
            this.f = this.e + extraCache;
            for (int i = this.c.size() - 1; i >= 0 && this.c.size() > this.f; i--) {
                A(i);
            }
        }

        public List<c0> k() {
            return this.d;
        }

        public boolean L(c0 holder) {
            if (holder.v()) {
                return RecyclerView.this.o0.e();
            }
            int i = holder.d;
            if (i < 0 || i >= RecyclerView.this.t.c()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + holder + RecyclerView.this.P());
            }
            if (!RecyclerView.this.o0.e()) {
                RecyclerView.this.t.e();
                if (0 != holder.l()) {
                    return false;
                }
            }
            return !RecyclerView.this.t.g() || holder.k() == RecyclerView.this.t.d(holder.d);
        }

        public final boolean H(c0 holder, int offsetPosition, int position, long deadlineNs) {
            holder.s = RecyclerView.this;
            int viewType = holder.l();
            long startBindNs = RecyclerView.this.getNanoTime();
            if (deadlineNs != Long.MAX_VALUE && !this.g.k(viewType, startBindNs, deadlineNs)) {
                return false;
            }
            RecyclerView.this.t.a(holder, offsetPosition);
            long endBindNs = RecyclerView.this.getNanoTime();
            this.g.d(holder.l(), endBindNs - startBindNs);
            b(holder);
            if (RecyclerView.this.o0.e()) {
                holder.h = position;
                return true;
            }
            return true;
        }

        public int f(int position) {
            if (position < 0 || position >= RecyclerView.this.o0.b()) {
                throw new IndexOutOfBoundsException("invalid position " + position + ". State item count is " + RecyclerView.this.o0.b() + RecyclerView.this.P());
            }
            if (!RecyclerView.this.o0.e()) {
                return position;
            }
            return RecyclerView.this.m.k(position);
        }

        public View o(int position) {
            return p(position, false);
        }

        public View p(int position, boolean dryRun) {
            return I(position, dryRun, Long.MAX_VALUE).f889b;
        }

        public c0 I(int position, boolean dryRun, long deadlineNs) {
            boolean fromScrapOrHiddenOrCache;
            c0 holder;
            p rvLayoutParams;
            RecyclerView innerView;
            if (position < 0 || position >= RecyclerView.this.o0.b()) {
                throw new IndexOutOfBoundsException("Invalid item position " + position + "(" + position + "). Item count:" + RecyclerView.this.o0.b() + RecyclerView.this.P());
            }
            boolean fromScrapOrHiddenOrCache2 = false;
            c0 holder2 = null;
            if (RecyclerView.this.o0.e()) {
                holder2 = h(position);
                fromScrapOrHiddenOrCache2 = holder2 != null;
            }
            if (holder2 == null && (holder2 = m(position, dryRun)) != null) {
                if (!L(holder2)) {
                    if (!dryRun) {
                        holder2.b(4);
                        if (holder2.w()) {
                            RecyclerView.this.removeDetachedView(holder2.f889b, false);
                            holder2.K();
                        } else if (holder2.L()) {
                            holder2.e();
                        }
                        C(holder2);
                    }
                    holder2 = null;
                } else {
                    fromScrapOrHiddenOrCache2 = true;
                }
            }
            if (holder2 != null) {
                fromScrapOrHiddenOrCache = fromScrapOrHiddenOrCache2;
                holder = holder2;
            } else {
                int offsetPosition = RecyclerView.this.m.k(position);
                if (offsetPosition < 0 || offsetPosition >= RecyclerView.this.t.c()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + position + "(offset:" + offsetPosition + ").state:" + RecyclerView.this.o0.b() + RecyclerView.this.P());
                }
                RecyclerView.this.t.e();
                if (RecyclerView.this.t.g() && (holder2 = l(RecyclerView.this.t.d(offsetPosition), 0, dryRun)) != null) {
                    holder2.d = offsetPosition;
                    fromScrapOrHiddenOrCache2 = true;
                }
                if (holder2 == null) {
                }
                if (holder2 == null && (holder2 = i().f(0)) != null) {
                    holder2.D();
                    if (RecyclerView.c) {
                        r(holder2);
                    }
                }
                if (holder2 != null) {
                    fromScrapOrHiddenOrCache = fromScrapOrHiddenOrCache2;
                    holder = holder2;
                } else {
                    long start = RecyclerView.this.getNanoTime();
                    if (deadlineNs != Long.MAX_VALUE && !this.g.l(0, start, deadlineNs)) {
                        return null;
                    }
                    RecyclerView recyclerView = RecyclerView.this;
                    c0 holder3 = recyclerView.t.b(recyclerView, 0);
                    if (RecyclerView.e && (innerView = RecyclerView.V(holder3.f889b)) != null) {
                        holder3.c = new WeakReference<>(innerView);
                    }
                    long end = RecyclerView.this.getNanoTime();
                    this.g.e(0, end - start);
                    fromScrapOrHiddenOrCache = fromScrapOrHiddenOrCache2;
                    holder = holder3;
                }
            }
            if (fromScrapOrHiddenOrCache && !RecyclerView.this.o0.e() && holder.p(8192)) {
                holder.F(0, 8192);
                if (RecyclerView.this.o0.j) {
                    int changeFlags = l.e(holder);
                    int i = changeFlags | 4096;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    l lVar = recyclerView2.T;
                    z zVar = recyclerView2.o0;
                    holder.o();
                    l.c info = lVar.t(holder);
                    RecyclerView.this.Q0(holder, info);
                }
            }
            boolean bound = false;
            if (RecyclerView.this.o0.e() && holder.s()) {
                holder.h = position;
            } else if (!holder.s() || holder.z() || holder.t()) {
                bound = H(holder, RecyclerView.this.m.k(position), position, deadlineNs);
            }
            ViewGroup.LayoutParams lp = holder.f889b.getLayoutParams();
            if (lp == null) {
                rvLayoutParams = (p) RecyclerView.this.generateDefaultLayoutParams();
                holder.f889b.setLayoutParams(rvLayoutParams);
            } else if (!RecyclerView.this.checkLayoutParams(lp)) {
                rvLayoutParams = (p) RecyclerView.this.generateLayoutParams(lp);
                holder.f889b.setLayoutParams(rvLayoutParams);
            } else {
                rvLayoutParams = (p) lp;
            }
            rvLayoutParams.f906a = holder;
            rvLayoutParams.d = fromScrapOrHiddenOrCache && bound;
            return holder;
        }

        public final void b(c0 holder) {
            if (RecyclerView.this.s0()) {
                View itemView = holder.f889b;
                if (a.h.k.v.A(itemView) == 0) {
                    a.h.k.v.x0(itemView, 1);
                }
                a.o.b.k kVar = RecyclerView.this.v0;
                if (kVar == null) {
                    return;
                }
                a.h.k.a itemDelegate = kVar.n();
                if (itemDelegate instanceof k.a) {
                    ((k.a) itemDelegate).o(itemView);
                }
                a.h.k.v.o0(itemView, itemDelegate);
            }
        }

        public final void r(c0 holder) {
            View view = holder.f889b;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        public final void q(ViewGroup viewGroup, boolean invalidateThis) {
            for (int i = viewGroup.getChildCount() - 1; i >= 0; i--) {
                View view = viewGroup.getChildAt(i);
                if (view instanceof ViewGroup) {
                    q((ViewGroup) view, true);
                }
            }
            if (!invalidateThis) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
            } else {
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void B(View view) {
            c0 holder = RecyclerView.f0(view);
            if (holder.x()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (holder.w()) {
                holder.K();
            } else if (holder.L()) {
                holder.e();
            }
            C(holder);
            if (RecyclerView.this.T != null && !holder.u()) {
                RecyclerView.this.T.j(holder);
            }
        }

        public void z() {
            int count = this.c.size();
            for (int i = count - 1; i >= 0; i--) {
                A(i);
            }
            this.c.clear();
            if (RecyclerView.e) {
                RecyclerView.this.n0.b();
            }
        }

        public void A(int cachedViewIndex) {
            c0 viewHolder = this.c.get(cachedViewIndex);
            a(viewHolder, true);
            this.c.remove(cachedViewIndex);
        }

        public void C(c0 holder) {
            if (holder.w() || holder.f889b.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(holder.w());
                sb.append(" isAttached:");
                sb.append(holder.f889b.getParent() != null);
                sb.append(RecyclerView.this.P());
                throw new IllegalArgumentException(sb.toString());
            }
            if (holder.x()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + holder + RecyclerView.this.P());
            }
            if (holder.J()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.P());
            }
            boolean transientStatePreventsRecycling = holder.h();
            g gVar = RecyclerView.this.t;
            if (gVar != null && transientStatePreventsRecycling) {
                gVar.n();
            }
            boolean cached = false;
            boolean recycled = false;
            if (0 != 0 || holder.u()) {
                if (this.f > 0 && !holder.p(526)) {
                    int cachedViewSize = this.c.size();
                    if (cachedViewSize >= this.f && cachedViewSize > 0) {
                        A(0);
                        cachedViewSize--;
                    }
                    int targetCacheIndex = cachedViewSize;
                    if (RecyclerView.e && cachedViewSize > 0 && !RecyclerView.this.n0.d(holder.d)) {
                        int cacheIndex = cachedViewSize - 1;
                        while (cacheIndex >= 0) {
                            int cachedPos = this.c.get(cacheIndex).d;
                            if (!RecyclerView.this.n0.d(cachedPos)) {
                                break;
                            } else {
                                cacheIndex--;
                            }
                        }
                        targetCacheIndex = cacheIndex + 1;
                    }
                    this.c.add(targetCacheIndex, holder);
                    cached = true;
                }
                if (!cached) {
                    a(holder, true);
                    recycled = true;
                }
            }
            RecyclerView.this.o.q(holder);
            if (!cached && !recycled && transientStatePreventsRecycling) {
                holder.s = null;
            }
        }

        public void a(c0 holder, boolean dispatchRecycled) {
            RecyclerView.r(holder);
            View itemView = holder.f889b;
            a.o.b.k kVar = RecyclerView.this.v0;
            if (kVar != null) {
                a.h.k.a itemDelegate = kVar.n();
                a.h.k.a originalDelegate = null;
                if (itemDelegate instanceof k.a) {
                    originalDelegate = ((k.a) itemDelegate).n(itemView);
                }
                a.h.k.v.o0(itemView, originalDelegate);
            }
            if (dispatchRecycled) {
                g(holder);
            }
            holder.s = null;
            i().i(holder);
        }

        public void y(View view) {
            c0 holder = RecyclerView.f0(view);
            holder.o = null;
            holder.p = false;
            holder.e();
            C(holder);
        }

        public void D(View view) {
            c0 holder = RecyclerView.f0(view);
            if (holder.p(12) || !holder.y() || RecyclerView.this.p(holder)) {
                if (holder.t() && !holder.v() && !RecyclerView.this.t.g()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.P());
                }
                holder.H(this, false);
                this.f912a.add(holder);
                return;
            }
            if (this.f913b == null) {
                this.f913b = new ArrayList<>();
            }
            holder.H(this, true);
            this.f913b.add(holder);
        }

        public void J(c0 holder) {
            if (holder.p) {
                this.f913b.remove(holder);
            } else {
                this.f912a.remove(holder);
            }
            holder.o = null;
            holder.p = false;
            holder.e();
        }

        public int j() {
            return this.f912a.size();
        }

        public View n(int index) {
            return this.f912a.get(index).f889b;
        }

        public void e() {
            this.f912a.clear();
            ArrayList<c0> arrayList = this.f913b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public c0 h(int position) {
            int changedScrapSize;
            int offsetPosition;
            ArrayList<c0> arrayList = this.f913b;
            if (arrayList == null || (changedScrapSize = arrayList.size()) == 0) {
                return null;
            }
            for (int i = 0; i < changedScrapSize; i++) {
                c0 holder = this.f913b.get(i);
                if (!holder.L() && holder.m() == position) {
                    holder.b(32);
                    return holder;
                }
            }
            if (RecyclerView.this.t.g() && (offsetPosition = RecyclerView.this.m.k(position)) > 0 && offsetPosition < RecyclerView.this.t.c()) {
                long id = RecyclerView.this.t.d(offsetPosition);
                for (int i2 = 0; i2 < changedScrapSize; i2++) {
                    c0 holder2 = this.f913b.get(i2);
                    if (!holder2.L() && holder2.k() == id) {
                        holder2.b(32);
                        return holder2;
                    }
                }
            }
            return null;
        }

        public c0 m(int position, boolean dryRun) {
            View view;
            int scrapCount = this.f912a.size();
            for (int i = 0; i < scrapCount; i++) {
                c0 holder = this.f912a.get(i);
                if (!holder.L() && holder.m() == position && !holder.t() && (RecyclerView.this.o0.g || !holder.v())) {
                    holder.b(32);
                    return holder;
                }
            }
            if (!dryRun && (view = RecyclerView.this.n.e(position)) != null) {
                c0 vh = RecyclerView.f0(view);
                RecyclerView.this.n.s(view);
                int layoutIndex = RecyclerView.this.n.m(view);
                if (layoutIndex == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + vh + RecyclerView.this.P());
                }
                RecyclerView.this.n.d(layoutIndex);
                D(view);
                vh.b(8224);
                return vh;
            }
            int cacheSize = this.c.size();
            for (int i2 = 0; i2 < cacheSize; i2++) {
                c0 holder2 = this.c.get(i2);
                if (!holder2.t() && holder2.m() == position && !holder2.r()) {
                    if (!dryRun) {
                        this.c.remove(i2);
                    }
                    return holder2;
                }
            }
            return null;
        }

        public c0 l(long id, int type, boolean dryRun) {
            int count = this.f912a.size();
            for (int i = count - 1; i >= 0; i--) {
                c0 holder = this.f912a.get(i);
                if (holder.k() == id && !holder.L()) {
                    if (type == holder.l()) {
                        holder.b(32);
                        if (holder.v() && !RecyclerView.this.o0.e()) {
                            holder.F(2, 14);
                        }
                        return holder;
                    }
                    if (!dryRun) {
                        this.f912a.remove(i);
                        RecyclerView.this.removeDetachedView(holder.f889b, false);
                        y(holder.f889b);
                    }
                }
            }
            int cacheSize = this.c.size();
            for (int i2 = cacheSize - 1; i2 >= 0; i2--) {
                c0 holder2 = this.c.get(i2);
                if (holder2.k() == id && !holder2.r()) {
                    if (type == holder2.l()) {
                        if (!dryRun) {
                            this.c.remove(i2);
                        }
                        return holder2;
                    }
                    if (!dryRun) {
                        A(i2);
                        return null;
                    }
                }
            }
            return null;
        }

        public void g(c0 holder) {
            v vVar = RecyclerView.this.v;
            if (vVar != null) {
                vVar.a(holder);
            }
            g gVar = RecyclerView.this.t;
            if (gVar != null) {
                gVar.q();
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.o0 != null) {
                recyclerView.o.q(holder);
            }
        }

        public void x(g oldAdapter, g newAdapter, boolean compatibleWithPrevious) {
            c();
            i().h(oldAdapter, newAdapter, compatibleWithPrevious);
        }

        public void v(int from, int to) {
            int start;
            int end;
            int inBetweenOffset;
            int i;
            if (from < to) {
                start = from;
                end = to;
                inBetweenOffset = -1;
            } else {
                start = to;
                end = from;
                inBetweenOffset = 1;
            }
            int cachedCount = this.c.size();
            for (int i2 = 0; i2 < cachedCount; i2++) {
                c0 holder = this.c.get(i2);
                if (holder != null && (i = holder.d) >= start && i <= end) {
                    if (i == from) {
                        holder.A(to - from, false);
                    } else {
                        holder.A(inBetweenOffset, false);
                    }
                }
            }
        }

        public void u(int insertedAt, int count) {
            int cachedCount = this.c.size();
            for (int i = 0; i < cachedCount; i++) {
                c0 holder = this.c.get(i);
                if (holder != null && holder.d >= insertedAt) {
                    holder.A(count, true);
                }
            }
        }

        public void w(int removedFrom, int count, boolean applyToPreLayout) {
            int removedEnd = removedFrom + count;
            int cachedCount = this.c.size();
            for (int i = cachedCount - 1; i >= 0; i--) {
                c0 holder = this.c.get(i);
                if (holder != null) {
                    int i2 = holder.d;
                    if (i2 >= removedEnd) {
                        holder.A(-count, applyToPreLayout);
                    } else if (i2 >= removedFrom) {
                        holder.b(8);
                        A(i);
                    }
                }
            }
        }

        public void F(a0 extension) {
        }

        public void E(t pool) {
            t tVar = this.g;
            if (tVar != null) {
                tVar.c();
            }
            this.g = pool;
            if (pool != null && RecyclerView.this.getAdapter() != null) {
                this.g.a();
            }
        }

        public t i() {
            if (this.g == null) {
                this.g = new t();
            }
            return this.g;
        }

        public void M(int positionStart, int itemCount) {
            int pos;
            int positionEnd = positionStart + itemCount;
            int cachedCount = this.c.size();
            for (int i = cachedCount - 1; i >= 0; i--) {
                c0 holder = this.c.get(i);
                if (holder != null && (pos = holder.d) >= positionStart && pos < positionEnd) {
                    holder.b(2);
                    A(i);
                }
            }
        }

        public void t() {
            int cachedCount = this.c.size();
            for (int i = 0; i < cachedCount; i++) {
                c0 holder = this.c.get(i);
                if (holder != null) {
                    holder.b(6);
                    holder.a(null);
                }
            }
            g gVar = RecyclerView.this.t;
            if (gVar == null || !gVar.g()) {
                z();
            }
        }

        public void d() {
            int cachedCount = this.c.size();
            for (int i = 0; i < cachedCount; i++) {
                c0 holder = this.c.get(i);
                holder.c();
            }
            int scrapCount = this.f912a.size();
            for (int i2 = 0; i2 < scrapCount; i2++) {
                this.f912a.get(i2).c();
            }
            ArrayList<c0> arrayList = this.f913b;
            if (arrayList != null) {
                int changedScrapCount = arrayList.size();
                for (int i3 = 0; i3 < changedScrapCount; i3++) {
                    this.f913b.get(i3).c();
                }
            }
        }

        public void s() {
            int cachedCount = this.c.size();
            for (int i = 0; i < cachedCount; i++) {
                c0 holder = this.c.get(i);
                p layoutParams = (p) holder.f889b.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.c = true;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g<VH extends c0> {

        /* renamed from: a, reason: collision with root package name */
        public final h f893a = new h();

        /* renamed from: b, reason: collision with root package name */
        public boolean f894b = false;

        public abstract int c();

        public abstract void j(VH vh, int i);

        public abstract VH l(ViewGroup viewGroup, int i);

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        /* JADX WARN: Multi-variable type inference failed */
        public void k(c0 c0Var, int position) {
            j(c0Var, position);
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public final VH b(ViewGroup parent, int viewType) {
            try {
                a.h.g.c.a("RV CreateView");
                VH holder = l(parent, viewType);
                if (holder.f889b.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                holder.g = viewType;
                return holder;
            } finally {
                a.h.g.c.b();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public final void a(VH holder, int position) {
            holder.d = position;
            if (g()) {
                holder.f = d(position);
            }
            holder.F(1, 519);
            a.h.g.c.a("RV OnBindView");
            holder.o();
            k(holder, position);
            holder.d();
            ViewGroup.LayoutParams layoutParams = holder.f889b.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).c = true;
            }
            a.h.g.c.b();
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public int e() {
            return 0;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public void s(boolean hasStableIds) {
            if (f()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f894b = hasStableIds;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public long d(int position) {
            return -1L;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public final boolean g() {
            return this.f894b;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public void q() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public boolean n() {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public void o() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public void p() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public final boolean f() {
            return this.f893a.a();
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public void r(i observer) {
            this.f893a.registerObserver(observer);
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public void t(i observer) {
            this.f893a.unregisterObserver(observer);
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public void i() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public void m() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.recyclerview.widget.RecyclerView$g != androidx.recyclerview.widget.RecyclerView$Adapter<VH extends androidx.recyclerview.widget.RecyclerView$c0> */
        public final void h() {
            this.f893a.b();
        }
    }

    public void z(View child) {
        c0 viewHolder = f0(child);
        E0();
        g gVar = this.t;
        if (gVar != null && viewHolder != null) {
            gVar.p();
        }
    }

    public void y(View child) {
        c0 viewHolder = f0(child);
        D0();
        g gVar = this.t;
        if (gVar != null && viewHolder != null) {
            gVar.o();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class o {

        /* renamed from: a, reason: collision with root package name */
        public a.o.b.b f900a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView f901b;
        public final o.b c;
        public final o.b d;
        public a.o.b.o e;
        public a.o.b.o f;
        public y g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public int m;
        public boolean n;
        public int o;
        public int p;
        public int q;
        public int r;

        /* loaded from: classes.dex */
        public interface c {
        }

        /* loaded from: classes.dex */
        public static class d {

            /* renamed from: a, reason: collision with root package name */
            public int f904a;

            /* renamed from: b, reason: collision with root package name */
            public int f905b;
            public boolean c;
            public boolean d;
        }

        public abstract p D();

        public o() {
            a aVar = new a();
            this.c = aVar;
            b bVar = new b();
            this.d = bVar;
            this.e = new a.o.b.o(aVar);
            this.f = new a.o.b.o(bVar);
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = true;
            this.l = true;
        }

        /* loaded from: classes.dex */
        public class a implements o.b {
            public a() {
            }

            @Override // a.o.b.o.b
            public View e(int index) {
                return o.this.I(index);
            }

            @Override // a.o.b.o.b
            public int b() {
                return o.this.e0();
            }

            @Override // a.o.b.o.b
            public int a() {
                return o.this.o0() - o.this.f0();
            }

            @Override // a.o.b.o.b
            public int d(View view) {
                p params = (p) view.getLayoutParams();
                return o.this.Q(view) - ((ViewGroup.MarginLayoutParams) params).leftMargin;
            }

            @Override // a.o.b.o.b
            public int c(View view) {
                p params = (p) view.getLayoutParams();
                return o.this.T(view) + ((ViewGroup.MarginLayoutParams) params).rightMargin;
            }
        }

        /* loaded from: classes.dex */
        public class b implements o.b {
            public b() {
            }

            @Override // a.o.b.o.b
            public View e(int index) {
                return o.this.I(index);
            }

            @Override // a.o.b.o.b
            public int b() {
                return o.this.g0();
            }

            @Override // a.o.b.o.b
            public int a() {
                return o.this.W() - o.this.d0();
            }

            @Override // a.o.b.o.b
            public int d(View view) {
                p params = (p) view.getLayoutParams();
                return o.this.U(view) - ((ViewGroup.MarginLayoutParams) params).topMargin;
            }

            @Override // a.o.b.o.b
            public int c(View view) {
                p params = (p) view.getLayoutParams();
                return o.this.O(view) + ((ViewGroup.MarginLayoutParams) params).bottomMargin;
            }
        }

        public void E1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f901b = null;
                this.f900a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.f901b = recyclerView;
                this.f900a = recyclerView.n;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public void A1(int wSpec, int hSpec) {
            this.q = View.MeasureSpec.getSize(wSpec);
            int mode = View.MeasureSpec.getMode(wSpec);
            this.o = mode;
            if (mode == 0 && !RecyclerView.d) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(hSpec);
            int mode2 = View.MeasureSpec.getMode(hSpec);
            this.p = mode2;
            if (mode2 == 0 && !RecyclerView.d) {
                this.r = 0;
            }
        }

        public void D1(int widthSpec, int heightSpec) {
            int count = J();
            if (count == 0) {
                this.f901b.w(widthSpec, heightSpec);
                return;
            }
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                View child = I(i);
                Rect bounds = this.f901b.q;
                P(child, bounds);
                if (bounds.left < minX) {
                    minX = bounds.left;
                }
                if (bounds.right > maxX) {
                    maxX = bounds.right;
                }
                if (bounds.top < minY) {
                    minY = bounds.top;
                }
                if (bounds.bottom > maxY) {
                    maxY = bounds.bottom;
                }
            }
            this.f901b.q.set(minX, minY, maxX, maxY);
            C1(this.f901b.q, widthSpec, heightSpec);
        }

        public void C1(Rect childrenBounds, int wSpec, int hSpec) {
            int usedWidth = childrenBounds.width() + e0() + f0();
            int usedHeight = childrenBounds.height() + g0() + d0();
            int width = n(wSpec, usedWidth, c0());
            int height = n(hSpec, usedHeight, b0());
            B1(width, height);
        }

        public void t1() {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public static int n(int spec, int desired, int min) {
            int mode = View.MeasureSpec.getMode(spec);
            int size = View.MeasureSpec.getSize(spec);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(desired, min));
                case 1073741824:
                    return size;
                default:
                    return Math.max(desired, min);
            }
        }

        public void g(String message) {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView != null) {
                recyclerView.o(message);
            }
        }

        public boolean s0() {
            return false;
        }

        public boolean L1() {
            return false;
        }

        public final boolean u0() {
            return this.l;
        }

        public void o(int dx, int dy, z state, c layoutPrefetchRegistry) {
        }

        public void p(int adapterItemCount, c layoutPrefetchRegistry) {
        }

        public void z(RecyclerView view) {
            this.i = true;
            G0();
        }

        public void A(RecyclerView view, u recycler) {
            this.i = false;
            I0(view, recycler);
        }

        public boolean r0() {
            return this.i;
        }

        public boolean o1(Runnable action) {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(action);
            }
            return false;
        }

        public void G0() {
        }

        @Deprecated
        public void H0() {
        }

        public void I0(RecyclerView view, u recycler) {
            H0();
        }

        public boolean M() {
            RecyclerView recyclerView = this.f901b;
            return recyclerView != null && recyclerView.p;
        }

        public void X0(u recycler, z state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void Y0(z state) {
        }

        public boolean m(p lp) {
            return lp != null;
        }

        public p F(ViewGroup.LayoutParams lp) {
            if (lp instanceof p) {
                return new p((p) lp);
            }
            if (lp instanceof ViewGroup.MarginLayoutParams) {
                return new p((ViewGroup.MarginLayoutParams) lp);
            }
            return new p(lp);
        }

        public p E(Context c2, AttributeSet attrs) {
            return new p(c2, attrs);
        }

        public int w1(int dx, u recycler, z state) {
            return 0;
        }

        public int y1(int dy, u recycler, z state) {
            return 0;
        }

        public boolean k() {
            return false;
        }

        public boolean l() {
            return false;
        }

        public void x1(int position) {
        }

        public void I1(RecyclerView recyclerView, z state, int position) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void J1(y smoothScroller) {
            y yVar = this.g;
            if (yVar != null && smoothScroller != yVar && yVar.h()) {
                this.g.r();
            }
            this.g = smoothScroller;
            smoothScroller.q(this.f901b, this);
        }

        public boolean x0() {
            y yVar = this.g;
            return yVar != null && yVar.h();
        }

        public int Z() {
            return a.h.k.v.C(this.f901b);
        }

        public void b(View child) {
            c(child, -1);
        }

        public void c(View child, int index) {
            f(child, index, true);
        }

        public void d(View child) {
            e(child, -1);
        }

        public void e(View child, int index) {
            f(child, index, false);
        }

        public final void f(View child, int index, boolean disappearing) {
            c0 holder = RecyclerView.f0(child);
            if (disappearing || holder.v()) {
                this.f901b.o.b(holder);
            } else {
                this.f901b.o.p(holder);
            }
            p lp = (p) child.getLayoutParams();
            if (holder.L() || holder.w()) {
                if (holder.w()) {
                    holder.K();
                } else {
                    holder.e();
                }
                this.f900a.c(child, index, child.getLayoutParams(), false);
            } else if (child.getParent() == this.f901b) {
                int currentIndex = this.f900a.m(child);
                if (index == -1) {
                    index = this.f900a.g();
                }
                if (currentIndex == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f901b.indexOfChild(child) + this.f901b.P());
                }
                if (currentIndex != index) {
                    this.f901b.u.B0(currentIndex, index);
                }
            } else {
                this.f900a.a(child, index, false);
                lp.c = true;
                y yVar = this.g;
                if (yVar != null && yVar.h()) {
                    this.g.k(child);
                }
            }
            if (lp.d) {
                holder.f889b.invalidate();
                lp.d = false;
            }
        }

        public void p1(View child) {
            this.f900a.p(child);
        }

        public void q1(int index) {
            View child = I(index);
            if (child != null) {
                this.f900a.q(index);
            }
        }

        public int G() {
            return -1;
        }

        public int h0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        public View B(View view) {
            View found;
            RecyclerView recyclerView = this.f901b;
            if (recyclerView == null || (found = recyclerView.R(view)) == null || this.f900a.n(found)) {
                return null;
            }
            return found;
        }

        public View C(int position) {
            int childCount = J();
            for (int i = 0; i < childCount; i++) {
                View child = I(i);
                c0 vh = RecyclerView.f0(child);
                if (vh != null && vh.m() == position && !vh.J() && (this.f901b.o0.e() || !vh.v())) {
                    return child;
                }
            }
            return null;
        }

        public void x(int index) {
            I(index);
            y(index);
        }

        public final void y(int index) {
            this.f900a.d(index);
        }

        public void i(View child, int index, p lp) {
            c0 vh = RecyclerView.f0(child);
            if (vh.v()) {
                this.f901b.o.b(vh);
            } else {
                this.f901b.o.p(vh);
            }
            this.f900a.c(child, index, lp, vh.v());
        }

        public void h(View child, int index) {
            i(child, index, (p) child.getLayoutParams());
        }

        public void B0(int fromIndex, int toIndex) {
            View view = I(fromIndex);
            if (view == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + fromIndex + this.f901b.toString());
            }
            x(fromIndex);
            h(view, toIndex);
        }

        public void m1(View child, u recycler) {
            p1(child);
            recycler.B(child);
        }

        public void n1(int index, u recycler) {
            View view = I(index);
            q1(index);
            recycler.B(view);
        }

        public int J() {
            a.o.b.b bVar = this.f900a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public View I(int index) {
            a.o.b.b bVar = this.f900a;
            if (bVar != null) {
                return bVar.f(index);
            }
            return null;
        }

        public int p0() {
            return this.o;
        }

        public int X() {
            return this.p;
        }

        public int o0() {
            return this.q;
        }

        public int W() {
            return this.r;
        }

        public int e0() {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int g0() {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int f0() {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int d0() {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public View V() {
            View focused;
            RecyclerView recyclerView = this.f901b;
            if (recyclerView == null || (focused = recyclerView.getFocusedChild()) == null || this.f900a.n(focused)) {
                return null;
            }
            return focused;
        }

        public int Y() {
            RecyclerView recyclerView = this.f901b;
            g a2 = recyclerView != null ? recyclerView.getAdapter() : null;
            if (a2 != null) {
                return a2.c();
            }
            return 0;
        }

        public void C0(int dx) {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView != null) {
                recyclerView.y0(dx);
            }
        }

        public void D0(int dy) {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView != null) {
                recyclerView.z0(dy);
            }
        }

        public void w(u recycler) {
            int childCount = J();
            for (int i = childCount - 1; i >= 0; i--) {
                View v = I(i);
                v1(recycler, i, v);
            }
        }

        public final void v1(u recycler, int index, View view) {
            c0 viewHolder = RecyclerView.f0(view);
            if (viewHolder.J()) {
                return;
            }
            if (viewHolder.t() && !viewHolder.v() && !this.f901b.t.g()) {
                q1(index);
                recycler.C(viewHolder);
            } else {
                x(index);
                recycler.D(view);
                this.f901b.o.k(viewHolder);
            }
        }

        public void l1(u recycler) {
            int scrapCount = recycler.j();
            for (int i = scrapCount - 1; i >= 0; i--) {
                View scrap = recycler.n(i);
                c0 vh = RecyclerView.f0(scrap);
                if (!vh.J()) {
                    vh.G(false);
                    if (vh.x()) {
                        this.f901b.removeDetachedView(scrap, false);
                    }
                    l lVar = this.f901b.T;
                    if (lVar != null) {
                        lVar.j(vh);
                    }
                    vh.G(true);
                    recycler.y(scrap);
                }
            }
            recycler.e();
            if (scrapCount > 0) {
                this.f901b.invalidate();
            }
        }

        public boolean H1(View child, int widthSpec, int heightSpec, p lp) {
            return (this.k && w0(child.getMeasuredWidth(), widthSpec, ((ViewGroup.MarginLayoutParams) lp).width) && w0(child.getMeasuredHeight(), heightSpec, ((ViewGroup.MarginLayoutParams) lp).height)) ? false : true;
        }

        public boolean F1(View child, int widthSpec, int heightSpec, p lp) {
            return (!child.isLayoutRequested() && this.k && w0(child.getWidth(), widthSpec, ((ViewGroup.MarginLayoutParams) lp).width) && w0(child.getHeight(), heightSpec, ((ViewGroup.MarginLayoutParams) lp).height)) ? false : true;
        }

        public static boolean w0(int childSize, int spec, int dimension) {
            int specMode = View.MeasureSpec.getMode(spec);
            int specSize = View.MeasureSpec.getSize(spec);
            if (dimension > 0 && childSize != dimension) {
                return false;
            }
            switch (specMode) {
                case Integer.MIN_VALUE:
                    return specSize >= childSize;
                case 0:
                    return true;
                case 1073741824:
                    return specSize == childSize;
                default:
                    return false;
            }
        }

        public void A0(View child, int widthUsed, int heightUsed) {
            p lp = (p) child.getLayoutParams();
            Rect insets = this.f901b.j0(child);
            int widthUsed2 = widthUsed + insets.left + insets.right;
            int heightUsed2 = heightUsed + insets.top + insets.bottom;
            int widthSpec = K(o0(), p0(), e0() + f0() + ((ViewGroup.MarginLayoutParams) lp).leftMargin + ((ViewGroup.MarginLayoutParams) lp).rightMargin + widthUsed2, ((ViewGroup.MarginLayoutParams) lp).width, k());
            int heightSpec = K(W(), X(), g0() + d0() + ((ViewGroup.MarginLayoutParams) lp).topMargin + ((ViewGroup.MarginLayoutParams) lp).bottomMargin + heightUsed2, ((ViewGroup.MarginLayoutParams) lp).height, l());
            if (F1(child, widthSpec, heightSpec, lp)) {
                child.measure(widthSpec, heightSpec);
            }
        }

        public static int K(int parentSize, int parentMode, int padding, int childDimension, boolean canScroll) {
            int size = Math.max(0, parentSize - padding);
            int resultSize = 0;
            int resultMode = 0;
            if (canScroll) {
                if (childDimension >= 0) {
                    resultSize = childDimension;
                    resultMode = 1073741824;
                } else if (childDimension == -1) {
                    switch (parentMode) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            resultSize = size;
                            resultMode = parentMode;
                            break;
                        case 0:
                            resultSize = 0;
                            resultMode = 0;
                            break;
                    }
                } else if (childDimension == -2) {
                    resultSize = 0;
                    resultMode = 0;
                }
            } else if (childDimension >= 0) {
                resultSize = childDimension;
                resultMode = 1073741824;
            } else if (childDimension == -1) {
                resultSize = size;
                resultMode = parentMode;
            } else if (childDimension == -2) {
                resultSize = size;
                resultMode = (parentMode == Integer.MIN_VALUE || parentMode == 1073741824) ? Integer.MIN_VALUE : 0;
            }
            return View.MeasureSpec.makeMeasureSpec(resultSize, resultMode);
        }

        public int S(View child) {
            Rect insets = ((p) child.getLayoutParams()).f907b;
            return child.getMeasuredWidth() + insets.left + insets.right;
        }

        public int R(View child) {
            Rect insets = ((p) child.getLayoutParams()).f907b;
            return child.getMeasuredHeight() + insets.top + insets.bottom;
        }

        public void z0(View child, int left, int top, int right, int bottom) {
            p lp = (p) child.getLayoutParams();
            Rect insets = lp.f907b;
            child.layout(insets.left + left + ((ViewGroup.MarginLayoutParams) lp).leftMargin, insets.top + top + ((ViewGroup.MarginLayoutParams) lp).topMargin, (right - insets.right) - ((ViewGroup.MarginLayoutParams) lp).rightMargin, (bottom - insets.bottom) - ((ViewGroup.MarginLayoutParams) lp).bottomMargin);
        }

        public void n0(View child, boolean includeDecorInsets, Rect out) {
            Matrix childMatrix;
            if (includeDecorInsets) {
                Rect insets = ((p) child.getLayoutParams()).f907b;
                out.set(-insets.left, -insets.top, child.getWidth() + insets.right, child.getHeight() + insets.bottom);
            } else {
                out.set(0, 0, child.getWidth(), child.getHeight());
            }
            if (this.f901b != null && (childMatrix = child.getMatrix()) != null && !childMatrix.isIdentity()) {
                RectF tempRectF = this.f901b.s;
                tempRectF.set(out);
                childMatrix.mapRect(tempRectF);
                out.set((int) Math.floor(tempRectF.left), (int) Math.floor(tempRectF.top), (int) Math.ceil(tempRectF.right), (int) Math.ceil(tempRectF.bottom));
            }
            out.offset(child.getLeft(), child.getTop());
        }

        public void P(View view, Rect outBounds) {
            RecyclerView.g0(view, outBounds);
        }

        public int Q(View child) {
            return child.getLeft() - a0(child);
        }

        public int U(View child) {
            return child.getTop() - m0(child);
        }

        public int T(View child) {
            return child.getRight() + j0(child);
        }

        public int O(View child) {
            return child.getBottom() + H(child);
        }

        public void j(View child, Rect outRect) {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView == null) {
                outRect.set(0, 0, 0, 0);
            } else {
                Rect insets = recyclerView.j0(child);
                outRect.set(insets);
            }
        }

        public int m0(View child) {
            return ((p) child.getLayoutParams()).f907b.top;
        }

        public int H(View child) {
            return ((p) child.getLayoutParams()).f907b.bottom;
        }

        public int a0(View child) {
            return ((p) child.getLayoutParams()).f907b.left;
        }

        public int j0(View child) {
            return ((p) child.getLayoutParams()).f907b.right;
        }

        public View J0(View focused, int direction, u recycler, z state) {
            return null;
        }

        public View Q0() {
            return null;
        }

        public final int[] L(View child, Rect rect) {
            int dx;
            int[] out = new int[2];
            int parentLeft = e0();
            int parentTop = g0();
            int parentRight = o0() - f0();
            int parentBottom = W() - d0();
            int childLeft = (child.getLeft() + rect.left) - child.getScrollX();
            int childTop = (child.getTop() + rect.top) - child.getScrollY();
            int childRight = rect.width() + childLeft;
            int childBottom = rect.height() + childTop;
            int offScreenLeft = Math.min(0, childLeft - parentLeft);
            int offScreenTop = Math.min(0, childTop - parentTop);
            int offScreenRight = Math.max(0, childRight - parentRight);
            int offScreenBottom = Math.max(0, childBottom - parentBottom);
            if (Z() == 1) {
                dx = offScreenRight != 0 ? offScreenRight : Math.max(offScreenLeft, childRight - parentRight);
            } else {
                dx = offScreenLeft != 0 ? offScreenLeft : Math.min(childLeft - parentLeft, offScreenRight);
            }
            int dy = offScreenTop != 0 ? offScreenTop : Math.min(childTop - parentTop, offScreenBottom);
            out[0] = dx;
            out[1] = dy;
            return out;
        }

        public boolean r1(RecyclerView parent, View child, Rect rect, boolean immediate) {
            return s1(parent, child, rect, immediate, false);
        }

        public boolean s1(RecyclerView parent, View child, Rect rect, boolean immediate, boolean focusedChildVisible) {
            int[] scrollAmount = L(child, rect);
            int dx = scrollAmount[0];
            int dy = scrollAmount[1];
            if ((focusedChildVisible && !t0(parent, dx, dy)) || (dx == 0 && dy == 0)) {
                return false;
            }
            if (immediate) {
                parent.scrollBy(dx, dy);
            } else {
                parent.k1(dx, dy);
            }
            return true;
        }

        public boolean y0(View child, boolean completelyVisible) {
            boolean isViewFullyVisible = this.e.b(child, 24579) && this.f.b(child, 24579);
            if (completelyVisible) {
                return isViewFullyVisible;
            }
            return !isViewFullyVisible;
        }

        public final boolean t0(RecyclerView parent, int dx, int dy) {
            View focusedChild = parent.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int parentLeft = e0();
            int parentTop = g0();
            int parentRight = o0() - f0();
            int parentBottom = W() - d0();
            Rect bounds = this.f901b.q;
            P(focusedChild, bounds);
            if (bounds.left - dx >= parentRight || bounds.right - dx <= parentLeft || bounds.top - dy >= parentBottom || bounds.bottom - dy <= parentTop) {
                return false;
            }
            return true;
        }

        @Deprecated
        public boolean a1(RecyclerView parent) {
            return x0() || parent.t0();
        }

        public boolean b1(RecyclerView parent, View child, View focused) {
            return a1(parent);
        }

        public void E0() {
        }

        public boolean F0() {
            return false;
        }

        public void S0(RecyclerView recyclerView) {
        }

        public void R0(RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void U0(RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void V0() {
        }

        public void W0(RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
            V0();
        }

        public void T0(RecyclerView recyclerView, int from, int to, int itemCount) {
        }

        public int q(z state) {
            return 0;
        }

        public int r(z state) {
            return 0;
        }

        public int s(z state) {
            return 0;
        }

        public int t(z state) {
            return 0;
        }

        public int u(z state) {
            return 0;
        }

        public int v(z state) {
            return 0;
        }

        public void Z0(int widthSpec, int heightSpec) {
            this.f901b.w(widthSpec, heightSpec);
        }

        public void B1(int widthSize, int heightSize) {
            this.f901b.setMeasuredDimension(widthSize, heightSize);
        }

        public int c0() {
            return a.h.k.v.E(this.f901b);
        }

        public int b0() {
            return a.h.k.v.D(this.f901b);
        }

        public Parcelable d1() {
            return null;
        }

        public void c1(Parcelable state) {
        }

        public void K1() {
            y yVar = this.g;
            if (yVar != null) {
                yVar.r();
            }
        }

        public void f1(y smoothScroller) {
            if (this.g == smoothScroller) {
                this.g = null;
            }
        }

        public void e1(int state) {
        }

        public void k1(u recycler) {
            for (int i = J() - 1; i >= 0; i--) {
                View view = I(i);
                if (!RecyclerView.f0(view).J()) {
                    n1(i, recycler);
                }
            }
        }

        public void M0(a.h.k.e0.c info) {
            RecyclerView recyclerView = this.f901b;
            N0(recyclerView.k, recyclerView.o0, info);
        }

        public void N0(u recycler, z state, a.h.k.e0.c info) {
            if (this.f901b.canScrollVertically(-1) || this.f901b.canScrollHorizontally(-1)) {
                info.a(8192);
                info.n0(true);
            }
            if (this.f901b.canScrollVertically(1) || this.f901b.canScrollHorizontally(1)) {
                info.a(4096);
                info.n0(true);
            }
            c.b collectionInfo = c.b.a(k0(recycler, state), N(recycler, state), v0(), l0());
            info.Y(collectionInfo);
        }

        public void K0(AccessibilityEvent event) {
            RecyclerView recyclerView = this.f901b;
            u uVar = recyclerView.k;
            z zVar = recyclerView.o0;
            L0(event);
        }

        public void L0(AccessibilityEvent event) {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView == null || event == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f901b.canScrollVertically(-1) && !this.f901b.canScrollHorizontally(-1) && !this.f901b.canScrollHorizontally(1)) {
                z = false;
            }
            event.setScrollable(z);
            g gVar = this.f901b.t;
            if (gVar != null) {
                event.setItemCount(gVar.c());
            }
        }

        public void O0(View host, a.h.k.e0.c info) {
            c0 vh = RecyclerView.f0(host);
            if (vh != null && !vh.v() && !this.f900a.n(vh.f889b)) {
                RecyclerView recyclerView = this.f901b;
                P0(recyclerView.k, recyclerView.o0, host, info);
            }
        }

        public void P0(u recycler, z state, View host, a.h.k.e0.c info) {
            int rowIndexGuess = l() ? h0(host) : 0;
            int columnIndexGuess = k() ? h0(host) : 0;
            c.C0030c itemInfo = c.C0030c.a(rowIndexGuess, 1, columnIndexGuess, 1, false, false);
            info.Z(itemInfo);
        }

        public void u1() {
            this.h = true;
        }

        public int l0() {
            return 0;
        }

        public int k0(u recycler, z state) {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView == null || recyclerView.t == null || !l()) {
                return 1;
            }
            return this.f901b.t.c();
        }

        public int N(u recycler, z state) {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView == null || recyclerView.t == null || !k()) {
                return 1;
            }
            return this.f901b.t.c();
        }

        public boolean v0() {
            return false;
        }

        public boolean h1(int action, Bundle args) {
            RecyclerView recyclerView = this.f901b;
            u uVar = recyclerView.k;
            z zVar = recyclerView.o0;
            return g1(action);
        }

        public boolean g1(int action) {
            RecyclerView recyclerView = this.f901b;
            if (recyclerView == null) {
                return false;
            }
            int vScroll = 0;
            int hScroll = 0;
            switch (action) {
                case 4096:
                    if (recyclerView.canScrollVertically(1)) {
                        vScroll = (W() - g0()) - d0();
                    }
                    if (this.f901b.canScrollHorizontally(1)) {
                        hScroll = (o0() - e0()) - f0();
                        break;
                    }
                    break;
                case 8192:
                    if (recyclerView.canScrollVertically(-1)) {
                        vScroll = -((W() - g0()) - d0());
                    }
                    if (this.f901b.canScrollHorizontally(-1)) {
                        hScroll = -((o0() - e0()) - f0());
                        break;
                    }
                    break;
            }
            if (vScroll == 0 && hScroll == 0) {
                return false;
            }
            this.f901b.n1(hScroll, vScroll, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean j1(View view, int action, Bundle args) {
            RecyclerView recyclerView = this.f901b;
            u uVar = recyclerView.k;
            z zVar = recyclerView.o0;
            return i1();
        }

        public boolean i1() {
            return false;
        }

        public static d i0(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            d properties = new d();
            TypedArray a2 = context.obtainStyledAttributes(attrs, a.o.a.f635a, defStyleAttr, defStyleRes);
            int[] iArr = a.o.a.f635a;
            properties.f904a = a2.getInt(0, 1);
            properties.f905b = a2.getInt(10, 1);
            properties.c = a2.getBoolean(9, false);
            properties.d = a2.getBoolean(11, false);
            a2.recycle();
            return properties;
        }

        public void z1(RecyclerView recyclerView) {
            A1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public boolean G1() {
            return false;
        }

        public boolean q0() {
            int childCount = J();
            for (int i = 0; i < childCount; i++) {
                View child = I(i);
                ViewGroup.LayoutParams lp = child.getLayoutParams();
                if (lp.width < 0 && lp.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        public void g(Canvas c, RecyclerView parent, z state) {
            f();
        }

        @Deprecated
        public void f() {
        }

        public void i(Canvas c, RecyclerView parent, z state) {
            h();
        }

        @Deprecated
        public void h() {
        }

        @Deprecated
        public void d(Rect outRect) {
            outRect.set(0, 0, 0, 0);
        }

        public void e(Rect outRect, View view, RecyclerView parent) {
            ((p) view.getLayoutParams()).a();
            d(outRect);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class s {
        public void a(RecyclerView recyclerView, int newState) {
        }

        public void b(RecyclerView recyclerView, int dx, int dy) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c0 {

        /* renamed from: a, reason: collision with root package name */
        public static final List<Object> f888a = Collections.emptyList();

        /* renamed from: b, reason: collision with root package name */
        public final View f889b;
        public WeakReference<RecyclerView> c;
        public int k;
        public RecyclerView s;
        public int d = -1;
        public int e = -1;
        public long f = -1;
        public int g = -1;
        public int h = -1;
        public c0 i = null;
        public c0 j = null;
        public List<Object> l = null;
        public List<Object> m = null;
        public int n = 0;
        public u o = null;
        public boolean p = false;
        public int q = 0;
        public int r = -1;

        public c0(View itemView) {
            if (itemView == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f889b = itemView;
        }

        public void i(int mNewPosition, int offset, boolean applyToPreLayout) {
            b(8);
            A(offset, applyToPreLayout);
            this.d = mNewPosition;
        }

        public void A(int offset, boolean applyToPreLayout) {
            if (this.e == -1) {
                this.e = this.d;
            }
            if (this.h == -1) {
                this.h = this.d;
            }
            if (applyToPreLayout) {
                this.h += offset;
            }
            this.d += offset;
            if (this.f889b.getLayoutParams() != null) {
                ((p) this.f889b.getLayoutParams()).c = true;
            }
        }

        public void c() {
            this.e = -1;
            this.h = -1;
        }

        public void E() {
            if (this.e == -1) {
                this.e = this.d;
            }
        }

        public boolean J() {
            return (this.k & 128) != 0;
        }

        public final int m() {
            int i = this.h;
            return i == -1 ? this.d : i;
        }

        public final int j() {
            RecyclerView recyclerView = this.s;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.b0(this);
        }

        public final int n() {
            return this.e;
        }

        public final long k() {
            return this.f;
        }

        public final int l() {
            return this.g;
        }

        public boolean w() {
            return this.o != null;
        }

        public void K() {
            this.o.J(this);
        }

        public boolean L() {
            return (this.k & 32) != 0;
        }

        public void e() {
            this.k &= -33;
        }

        public void f() {
            this.k &= -257;
        }

        public void H(u recycler, boolean isChangeScrap) {
            this.o = recycler;
            this.p = isChangeScrap;
        }

        public boolean t() {
            return (this.k & 4) != 0;
        }

        public boolean z() {
            return (this.k & 2) != 0;
        }

        public boolean s() {
            return (this.k & 1) != 0;
        }

        public boolean v() {
            return (this.k & 8) != 0;
        }

        public boolean p(int flags) {
            return (this.k & flags) != 0;
        }

        public boolean x() {
            return (this.k & 256) != 0;
        }

        public boolean r() {
            return (this.f889b.getParent() == null || this.f889b.getParent() == this.s) ? false : true;
        }

        public boolean q() {
            return (this.k & 512) != 0 || t();
        }

        public void F(int flags, int mask) {
            this.k = (this.k & (mask ^ (-1))) | (flags & mask);
        }

        public void b(int flags) {
            this.k |= flags;
        }

        public void a(Object payload) {
            if (payload != null) {
                if ((1024 & this.k) == 0) {
                    g();
                    this.l.add(payload);
                    return;
                }
                return;
            }
            b(1024);
        }

        public final void g() {
            if (this.l == null) {
                ArrayList arrayList = new ArrayList();
                this.l = arrayList;
                this.m = Collections.unmodifiableList(arrayList);
            }
        }

        public void d() {
            List<Object> list = this.l;
            if (list != null) {
                list.clear();
            }
            this.k &= -1025;
        }

        public List<Object> o() {
            if ((this.k & 1024) == 0) {
                List<Object> list = this.l;
                if (list == null || list.size() == 0) {
                    return f888a;
                }
                return this.m;
            }
            return f888a;
        }

        public void D() {
            this.k = 0;
            this.d = -1;
            this.e = -1;
            this.f = -1L;
            this.h = -1;
            this.n = 0;
            this.i = null;
            this.j = null;
            d();
            this.q = 0;
            this.r = -1;
            RecyclerView.r(this);
        }

        public void B(RecyclerView parent) {
            int i = this.r;
            if (i != -1) {
                this.q = i;
            } else {
                this.q = a.h.k.v.A(this.f889b);
            }
            parent.i1(this, 4);
        }

        public void C(RecyclerView parent) {
            parent.i1(this, this.q);
            this.q = 0;
        }

        public String toString() {
            String className = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(className + "{" + Integer.toHexString(hashCode()) + " position=" + this.d + " id=" + this.f + ", oldPos=" + this.e + ", pLpos:" + this.h);
            if (w()) {
                sb.append(" scrap ");
                sb.append(this.p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (t()) {
                sb.append(" invalid");
            }
            if (!s()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (v()) {
                sb.append(" removed");
            }
            if (J()) {
                sb.append(" ignored");
            }
            if (x()) {
                sb.append(" tmpDetached");
            }
            if (!u()) {
                sb.append(" not recyclable(" + this.n + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.f889b.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void G(boolean recyclable) {
            int i = this.n;
            int i2 = recyclable ? i - 1 : i + 1;
            this.n = i2;
            if (i2 < 0) {
                this.n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!recyclable && i2 == 1) {
                this.k |= 16;
            } else if (recyclable && i2 == 0) {
                this.k &= -17;
            }
        }

        public final boolean u() {
            return (this.k & 16) == 0 && !a.h.k.v.Q(this.f889b);
        }

        public boolean I() {
            return (this.k & 16) != 0;
        }

        public boolean h() {
            return (this.k & 16) == 0 && a.h.k.v.Q(this.f889b);
        }

        public boolean y() {
            return (this.k & 2) != 0;
        }
    }

    public boolean i1(c0 viewHolder, int importantForAccessibility) {
        if (t0()) {
            viewHolder.r = importantForAccessibility;
            this.C0.add(viewHolder);
            return false;
        }
        a.h.k.v.x0(viewHolder.f889b, importantForAccessibility);
        return true;
    }

    public void J() {
        int state;
        for (int i2 = this.C0.size() - 1; i2 >= 0; i2--) {
            c0 viewHolder = this.C0.get(i2);
            if (viewHolder.f889b.getParent() == this && !viewHolder.J() && (state = viewHolder.r) != -1) {
                a.h.k.v.x0(viewHolder.f889b, state);
                viewHolder.r = -1;
            }
        }
        this.C0.clear();
    }

    public int b0(c0 viewHolder) {
        if (viewHolder.p(524) || !viewHolder.s()) {
            return -1;
        }
        return this.m.c(viewHolder.d);
    }

    public void q0(StateListDrawable verticalThumbDrawable, Drawable verticalTrackDrawable, StateListDrawable horizontalThumbDrawable, Drawable horizontalTrackDrawable) {
        if (verticalThumbDrawable == null || verticalTrackDrawable == null || horizontalThumbDrawable == null || horizontalTrackDrawable == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + P());
        }
        Resources resources = getContext().getResources();
        new a.o.b.d(this, verticalThumbDrawable, verticalTrackDrawable, horizontalThumbDrawable, horizontalTrackDrawable, resources.getDimensionPixelSize(net.sqlcipher.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(net.sqlcipher.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(net.sqlcipher.R.dimen.fastscroll_margin));
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean enabled) {
        getScrollingChildHelper().m(enabled);
    }

    @Override // android.view.View, a.h.k.k
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int axes) {
        return getScrollingChildHelper().o(axes);
    }

    public boolean q1(int axes, int type) {
        return getScrollingChildHelper().p(axes, type);
    }

    @Override // android.view.View, a.h.k.k
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    public void s1(int type) {
        getScrollingChildHelper().r(type);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return getScrollingChildHelper().f(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    public final void G(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        getScrollingChildHelper().e(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return getScrollingChildHelper().c(dx, dy, consumed, offsetInWindow);
    }

    public boolean F(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        return getScrollingChildHelper().d(dx, dy, consumed, offsetInWindow, type);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return getScrollingChildHelper().a(velocityX, velocityY, consumed);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return getScrollingChildHelper().b(velocityX, velocityY);
    }

    /* loaded from: classes.dex */
    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public c0 f906a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f907b;
        public boolean c;
        public boolean d;

        public p(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.f907b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(int width, int height) {
            super(width, height);
            this.f907b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.f907b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(ViewGroup.LayoutParams source) {
            super(source);
            this.f907b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(p source) {
            super((ViewGroup.LayoutParams) source);
            this.f907b = new Rect();
            this.c = true;
            this.d = false;
        }

        public boolean d() {
            return this.f906a.t();
        }

        public boolean c() {
            return this.f906a.v();
        }

        public boolean b() {
            return this.f906a.y();
        }

        public int a() {
            return this.f906a.m();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public void a() {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class y {

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView f916b;
        public o c;
        public boolean d;
        public boolean e;
        public View f;
        public boolean h;

        /* renamed from: a, reason: collision with root package name */
        public int f915a = -1;
        public final a g = new a(0, 0);

        /* loaded from: classes.dex */
        public interface b {
            PointF a(int i);
        }

        public abstract void l(int i, int i2, z zVar, a aVar);

        public abstract void m();

        public abstract void n();

        public abstract void o(View view, z zVar, a aVar);

        public void q(RecyclerView recyclerView, o layoutManager) {
            recyclerView.l0.g();
            if (this.h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f916b = recyclerView;
            this.c = layoutManager;
            int i = this.f915a;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.o0.f919a = i;
            this.e = true;
            this.d = true;
            this.f = b(f());
            m();
            this.f916b.l0.e();
            this.h = true;
        }

        public void p(int targetPosition) {
            this.f915a = targetPosition;
        }

        public PointF a(int targetPosition) {
            Object e = e();
            if (e instanceof b) {
                return ((b) e).a(targetPosition);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public o e() {
            return this.c;
        }

        public final void r() {
            if (!this.e) {
                return;
            }
            this.e = false;
            n();
            this.f916b.o0.f919a = -1;
            this.f = null;
            this.f915a = -1;
            this.d = false;
            this.c.f1(this);
            this.c = null;
            this.f916b = null;
        }

        public boolean g() {
            return this.d;
        }

        public boolean h() {
            return this.e;
        }

        public int f() {
            return this.f915a;
        }

        public void j(int dx, int dy) {
            PointF pointF;
            RecyclerView recyclerView = this.f916b;
            if (this.f915a == -1 || recyclerView == null) {
                r();
            }
            if (this.d && this.f == null && this.c != null && (pointF = a(this.f915a)) != null) {
                float f = pointF.x;
                if (f != 0.0f || pointF.y != 0.0f) {
                    recyclerView.f1((int) Math.signum(f), (int) Math.signum(pointF.y), null);
                }
            }
            this.d = false;
            View view = this.f;
            if (view != null) {
                if (d(view) == this.f915a) {
                    o(this.f, recyclerView.o0, this.g);
                    this.g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                l(dx, dy, recyclerView.o0, this.g);
                boolean hadJumpTarget = this.g.a();
                this.g.c(recyclerView);
                if (hadJumpTarget && this.e) {
                    this.d = true;
                    recyclerView.l0.e();
                }
            }
        }

        public int d(View view) {
            return this.f916b.d0(view);
        }

        public int c() {
            return this.f916b.u.J();
        }

        public View b(int position) {
            return this.f916b.u.C(position);
        }

        public void k(View child) {
            if (d(child) == f()) {
                this.f = child;
            }
        }

        public void i(PointF scrollVector) {
            float f = scrollVector.x;
            float f2 = scrollVector.y;
            float magnitude = (float) Math.sqrt((f * f) + (f2 * f2));
            scrollVector.x /= magnitude;
            scrollVector.y /= magnitude;
        }

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public int f917a;

            /* renamed from: b, reason: collision with root package name */
            public int f918b;
            public int c;
            public int d;
            public Interpolator e;
            public boolean f;
            public int g;

            public a(int dx, int dy) {
                this(dx, dy, Integer.MIN_VALUE, null);
            }

            public a(int dx, int dy, int duration, Interpolator interpolator) {
                this.d = -1;
                this.f = false;
                this.g = 0;
                this.f917a = dx;
                this.f918b = dy;
                this.c = duration;
                this.e = interpolator;
            }

            public void b(int targetPosition) {
                this.d = targetPosition;
            }

            public boolean a() {
                return this.d >= 0;
            }

            public void c(RecyclerView recyclerView) {
                if (this.d >= 0) {
                    int position = this.d;
                    this.d = -1;
                    recyclerView.v0(position);
                    this.f = false;
                    return;
                }
                if (this.f) {
                    e();
                    recyclerView.l0.f(this.f917a, this.f918b, this.c, this.e);
                    int i = this.g + 1;
                    this.g = i;
                    if (i > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                    return;
                }
                this.g = 0;
            }

            public final void e() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void d(int dx, int dy, int duration, Interpolator interpolator) {
                this.f917a = dx;
                this.f918b = dy;
                this.c = duration;
                this.e = interpolator;
                this.f = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h extends Observable<i> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int i = ((Observable) this).mObservers.size() - 1; i >= 0; i--) {
                ((i) ((Observable) this).mObservers.get(i)).a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class x extends a.j.a.a {
        public static final Parcelable.Creator<x> CREATOR = new a();
        public Parcelable d;

        public x(Parcel in, ClassLoader loader) {
            super(in, loader);
            this.d = in.readParcelable(loader != null ? loader : o.class.getClassLoader());
        }

        public x(Parcelable superState) {
            super(superState);
        }

        @Override // a.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeParcelable(this.d, 0);
        }

        public void k(x other) {
            this.d = other.d;
        }

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<x> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel in, ClassLoader loader) {
                return new x(in, loader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel in) {
                return new x(in, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public x[] newArray(int size) {
                return new x[size];
            }
        }
    }

    /* loaded from: classes.dex */
    public static class z {

        /* renamed from: a, reason: collision with root package name */
        public int f919a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f920b = 0;
        public int c = 0;
        public int d = 1;
        public int e = 0;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public int l;
        public long m;
        public int n;

        public void a(int accepted) {
            if ((this.d & accepted) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(accepted) + " but it is " + Integer.toBinaryString(this.d));
            }
        }

        public void f(g adapter) {
            this.d = 1;
            this.e = adapter.c();
            this.g = false;
            this.h = false;
            this.i = false;
        }

        public boolean e() {
            return this.g;
        }

        public boolean g() {
            return this.k;
        }

        public int c() {
            return this.f919a;
        }

        public boolean d() {
            return this.f919a != -1;
        }

        public int b() {
            return this.g ? this.f920b - this.c : this.e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f919a + ", mData=" + ((Object) null) + ", mItemCount=" + this.e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.f920b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }
    }

    /* loaded from: classes.dex */
    public class m implements l.b {
        public m() {
        }

        public void a(c0 item) {
            item.G(true);
            if (item.i != null && item.j == null) {
                item.i = null;
            }
            item.j = null;
            if (!item.I() && !RecyclerView.this.U0(item.f889b) && item.x()) {
                RecyclerView.this.removeDetachedView(item.f889b, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class l {

        /* renamed from: a, reason: collision with root package name */
        public b f895a = null;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<a> f896b = new ArrayList<>();
        public long c = 120;
        public long d = 120;
        public long e = 250;
        public long f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* loaded from: classes.dex */
        public interface b {
        }

        public abstract boolean a(c0 c0Var, c cVar, c cVar2);

        public abstract boolean b(c0 c0Var, c0 c0Var2, c cVar, c cVar2);

        public abstract boolean c(c0 c0Var, c cVar, c cVar2);

        public abstract boolean d(c0 c0Var, c cVar, c cVar2);

        public abstract boolean f(c0 c0Var);

        public abstract void j(c0 c0Var);

        public abstract void k();

        public abstract boolean p();

        public abstract void u();

        public long n() {
            return this.e;
        }

        public long l() {
            return this.c;
        }

        public long o() {
            return this.d;
        }

        public long m() {
            return this.f;
        }

        public void v(b listener) {
            this.f895a = listener;
        }

        public c t(c0 viewHolder) {
            c q = q();
            q.a(viewHolder);
            return q;
        }

        public c s(c0 viewHolder) {
            c q = q();
            q.a(viewHolder);
            return q;
        }

        public static int e(c0 viewHolder) {
            int flags = viewHolder.k & 14;
            if (viewHolder.t()) {
                return 4;
            }
            if ((flags & 4) == 0) {
                int oldPos = viewHolder.n();
                int pos = viewHolder.j();
                if (oldPos != -1 && pos != -1 && oldPos != pos) {
                    return flags | 2048;
                }
                return flags;
            }
            return flags;
        }

        public final void h(c0 viewHolder) {
            r();
            b bVar = this.f895a;
            if (bVar != null) {
                ((m) bVar).a(viewHolder);
            }
        }

        public void r() {
        }

        public boolean g(c0 viewHolder, List<Object> payloads) {
            return f(viewHolder);
        }

        public final void i() {
            int count = this.f896b.size();
            for (int i = 0; i < count; i++) {
                this.f896b.get(i).a();
            }
            this.f896b.clear();
        }

        public c q() {
            return new c();
        }

        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f897a;

            /* renamed from: b, reason: collision with root package name */
            public int f898b;

            public c a(c0 holder) {
                b(holder);
                return this;
            }

            public c b(c0 holder) {
                View view = holder.f889b;
                this.f897a = view.getLeft();
                this.f898b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int childCount, int i2) {
        j jVar = this.w0;
        if (jVar == null) {
            return super.getChildDrawingOrder(childCount, i2);
        }
        return jVar.a(childCount, i2);
    }

    private a.h.k.l getScrollingChildHelper() {
        if (this.y0 == null) {
            this.y0 = new a.h.k.l(this);
        }
        return this.y0;
    }
}
