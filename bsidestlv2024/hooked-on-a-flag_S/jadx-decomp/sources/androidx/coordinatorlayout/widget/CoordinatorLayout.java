package androidx.coordinatorlayout.widget;

import a.h.k.d0;
import a.h.k.m;
import a.h.k.n;
import a.h.k.p;
import a.h.k.q;
import a.h.k.v;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sqlcipher.R;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements m, n {

    /* renamed from: b, reason: collision with root package name */
    public static final String f841b;
    public static final Class<?>[] c;
    public static final ThreadLocal<Map<String, Constructor<c>>> d;
    public static final Comparator<View> e;
    public static final a.h.j.f<Rect> f;
    public final List<View> g;
    public final a.g.b.a<View> h;
    public final List<View> i;
    public final List<View> j;
    public Paint k;
    public final int[] l;
    public final int[] m;
    public boolean n;
    public boolean o;
    public int[] p;
    public View q;
    public View r;
    public g s;
    public boolean t;
    public d0 u;
    public boolean v;
    public Drawable w;
    public ViewGroup.OnHierarchyChangeListener x;
    public q y;
    public final p z;

    /* loaded from: classes.dex */
    public interface b {
        c getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface d {
        Class<? extends c> value();
    }

    static {
        Package pkg = CoordinatorLayout.class.getPackage();
        f841b = pkg != null ? pkg.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            e = new i();
        } else {
            e = null;
        }
        c = new Class[]{Context.class, AttributeSet.class};
        d = new ThreadLocal<>();
        f = new a.h.j.h(12);
    }

    public static Rect a() {
        Rect rect = f.b();
        if (rect == null) {
            return new Rect();
        }
        return rect;
    }

    public static void O(Rect rect) {
        rect.setEmpty();
        f.a(rect);
    }

    public CoordinatorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a2;
        this.g = new ArrayList();
        this.h = new a.g.b.a<>();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.l = new int[2];
        this.m = new int[2];
        this.z = new p();
        if (defStyleAttr == 0) {
            a2 = context.obtainStyledAttributes(attrs, a.g.a.f331a, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            a2 = context.obtainStyledAttributes(attrs, a.g.a.f331a, defStyleAttr, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (defStyleAttr == 0) {
                saveAttributeDataForStyleable(context, a.g.a.f331a, attrs, a2, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, a.g.a.f331a, attrs, a2, defStyleAttr, 0);
            }
        }
        int[] iArr = a.g.a.f331a;
        int keylineArrayRes = a2.getResourceId(0, 0);
        if (keylineArrayRes != 0) {
            Resources res = context.getResources();
            this.p = res.getIntArray(keylineArrayRes);
            float density = res.getDisplayMetrics().density;
            int count = this.p.length;
            for (int i2 = 0; i2 < count; i2++) {
                this.p[i2] = (int) (r6[i2] * density);
            }
        }
        int[] iArr2 = a.g.a.f331a;
        this.w = a2.getDrawable(1);
        a2.recycle();
        X();
        super.setOnHierarchyChangeListener(new e());
        if (v.A(this) == 0) {
            v.x0(this, 1);
        }
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.x = onHierarchyChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q(false);
        if (this.t) {
            if (this.s == null) {
                this.s = new g();
            }
            ViewTreeObserver vto = getViewTreeObserver();
            vto.addOnPreDrawListener(this.s);
        }
        if (this.u == null && v.z(this)) {
            v.l0(this);
        }
        this.o = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q(false);
        if (this.t && this.s != null) {
            ViewTreeObserver vto = getViewTreeObserver();
            vto.removeOnPreDrawListener(this.s);
        }
        View view = this.r;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.o = false;
    }

    public void setStatusBarBackground(Drawable bg) {
        Drawable drawable = this.w;
        if (drawable != bg) {
            if (drawable != null) {
                drawable.setCallback(null);
            }
            Drawable mutate = bg != null ? bg.mutate() : null;
            this.w = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.w.setState(getDrawableState());
                }
                a.h.d.l.a.m(this.w, v.C(this));
                this.w.setVisible(getVisibility() == 0, false);
                this.w.setCallback(this);
            }
            v.f0(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.w;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        boolean changed = false;
        Drawable d2 = this.w;
        if (d2 != null && d2.isStateful()) {
            changed = false | d2.setState(state);
        }
        if (changed) {
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.w;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        boolean visible = visibility == 0;
        Drawable drawable = this.w;
        if (drawable != null && drawable.isVisible() != visible) {
            this.w.setVisible(visible, false);
        }
    }

    public void setStatusBarBackgroundResource(int resId) {
        setStatusBarBackground(resId != 0 ? a.h.c.a.d(getContext(), resId) : null);
    }

    public void setStatusBarBackgroundColor(int color) {
        setStatusBarBackground(new ColorDrawable(color));
    }

    public final d0 W(d0 insets) {
        if (!a.h.j.d.a(this.u, insets)) {
            this.u = insets;
            boolean z = insets != null && insets.i() > 0;
            this.v = z;
            setWillNotDraw(!z && getBackground() == null);
            d0 insets2 = e(insets);
            requestLayout();
            return insets2;
        }
        return insets;
    }

    public final d0 getLastWindowInsets() {
        return this.u;
    }

    public final void Q(boolean notifyOnInterceptTouchEvent) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = getChildAt(i2);
            f lp = (f) child.getLayoutParams();
            c b2 = lp.f();
            if (b2 != null) {
                long now = SystemClock.uptimeMillis();
                MotionEvent cancelEvent = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
                if (notifyOnInterceptTouchEvent) {
                    b2.k(this, child, cancelEvent);
                } else {
                    b2.D(this, child, cancelEvent);
                }
                cancelEvent.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            f lp2 = (f) getChildAt(i3).getLayoutParams();
            lp2.m();
        }
        this.q = null;
        this.n = false;
    }

    public final void z(List<View> out) {
        out.clear();
        boolean useCustomOrder = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            int childIndex = useCustomOrder ? getChildDrawingOrder(childCount, i2) : i2;
            View child = getChildAt(childIndex);
            out.add(child);
        }
        Comparator<View> comparator = e;
        if (comparator != null) {
            Collections.sort(out, comparator);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0064, code lost:
    
        if (r2 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0066, code lost:
    
        r22.q = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean L(android.view.MotionEvent r23, int r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = 0
            r3 = 0
            r4 = 0
            int r5 = r23.getActionMasked()
            java.util.List<android.view.View> r6 = r0.i
            r0.z(r6)
            int r7 = r6.size()
            r8 = 0
        L15:
            if (r8 >= r7) goto L80
            java.lang.Object r9 = r6.get(r8)
            android.view.View r9 = (android.view.View) r9
            android.view.ViewGroup$LayoutParams r10 = r9.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r10 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r10
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r11 = r10.f()
            if (r2 != 0) goto L2b
            if (r3 == 0) goto L52
        L2b:
            if (r5 == 0) goto L52
            if (r11 == 0) goto L7d
            if (r4 != 0) goto L45
            long r20 = android.os.SystemClock.uptimeMillis()
            r16 = 3
            r17 = 0
            r18 = 0
            r19 = 0
            r12 = r20
            r14 = r20
            android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r12, r14, r16, r17, r18, r19)
        L45:
            switch(r24) {
                case 0: goto L4d;
                case 1: goto L49;
                default: goto L48;
            }
        L48:
            goto L51
        L49:
            r11.D(r0, r9, r4)
            goto L51
        L4d:
            r11.k(r0, r9, r4)
        L51:
            goto L7d
        L52:
            if (r2 != 0) goto L68
            if (r11 == 0) goto L68
            switch(r24) {
                case 0: goto L5f;
                case 1: goto L5a;
                default: goto L59;
            }
        L59:
            goto L64
        L5a:
            boolean r2 = r11.D(r0, r9, r1)
            goto L64
        L5f:
            boolean r2 = r11.k(r0, r9, r1)
        L64:
            if (r2 == 0) goto L68
            r0.q = r9
        L68:
            boolean r12 = r10.c()
            boolean r13 = r10.i(r0, r9)
            if (r13 == 0) goto L76
            if (r12 != 0) goto L76
            r14 = 1
            goto L77
        L76:
            r14 = 0
        L77:
            r3 = r14
            if (r13 == 0) goto L7d
            if (r3 != 0) goto L7d
            goto L80
        L7d:
            int r8 = r8 + 1
            goto L15
        L80:
            r6.clear()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.L(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 0) {
            Q(true);
        }
        boolean intercepted = L(ev, 0);
        if (action == 1 || action == 3) {
            Q(true);
        }
        return intercepted;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
    
        if (r6 != false) goto L6;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 0
            r3 = 0
            r4 = 0
            int r5 = r19.getActionMasked()
            android.view.View r6 = r0.q
            r7 = 1
            if (r6 != 0) goto L17
            boolean r6 = r0.L(r1, r7)
            r3 = r6
            if (r6 == 0) goto L2b
        L17:
            android.view.View r6 = r0.q
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r8 = r6.f()
            if (r8 == 0) goto L2b
            android.view.View r9 = r0.q
            boolean r2 = r8.D(r0, r9, r1)
        L2b:
            android.view.View r6 = r0.q
            if (r6 != 0) goto L35
            boolean r6 = super.onTouchEvent(r19)
            r2 = r2 | r6
            goto L4c
        L35:
            if (r3 == 0) goto L4c
            if (r4 != 0) goto L49
            long r16 = android.os.SystemClock.uptimeMillis()
            r12 = 3
            r13 = 0
            r14 = 0
            r15 = 0
            r8 = r16
            r10 = r16
            android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r8, r10, r12, r13, r14, r15)
        L49:
            super.onTouchEvent(r4)
        L4c:
            if (r4 == 0) goto L51
            r4.recycle()
        L51:
            if (r5 == r7) goto L56
            r6 = 3
            if (r5 != r6) goto L5a
        L56:
            r6 = 0
            r0.Q(r6)
        L5a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        if (disallowIntercept && !this.n) {
            Q(false);
            this.n = true;
        }
    }

    public final int w(int index) {
        int[] iArr = this.p;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + index);
            return 0;
        }
        if (index < 0 || index >= iArr.length) {
            Log.e("CoordinatorLayout", "Keyline index " + index + " out of range for " + this);
            return 0;
        }
        return iArr[index];
    }

    public static c K(Context context, AttributeSet attrs, String name) {
        String fullName;
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        if (name.startsWith(".")) {
            fullName = context.getPackageName() + name;
        } else if (name.indexOf(46) >= 0) {
            fullName = name;
        } else {
            String str = f841b;
            if (TextUtils.isEmpty(str)) {
                fullName = name;
            } else {
                fullName = str + '.' + name;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = d;
            Map<String, Constructor<c>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<c> constructor = map.get(fullName);
            if (constructor == null) {
                Class<Behavior> clazz = Class.forName(fullName, false, context.getClassLoader());
                constructor = clazz.getConstructor(c);
                constructor.setAccessible(true);
                map.put(fullName, constructor);
            }
            return constructor.newInstance(context, attrs);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + fullName, e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f y(View view) {
        f result = (f) view.getLayoutParams();
        if (!result.f845b) {
            if (view instanceof b) {
                c attachedBehavior = ((b) view).getBehavior();
                if (attachedBehavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                result.o(attachedBehavior);
                result.f845b = true;
            } else {
                d defaultBehavior = null;
                for (Class<?> childClass = view.getClass(); childClass != null; childClass = childClass.getSuperclass()) {
                    d dVar = (d) childClass.getAnnotation(d.class);
                    defaultBehavior = dVar;
                    if (dVar != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        result.o(defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                result.f845b = true;
            }
        }
        return result;
    }

    public final void M() {
        this.g.clear();
        this.h.c();
        int count = getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View view = getChildAt(i2);
            f lp = y(view);
            lp.d(this, view);
            this.h.b(view);
            for (int j = 0; j < count; j++) {
                if (j != i2) {
                    View other = getChildAt(j);
                    if (lp.b(this, view, other)) {
                        if (!this.h.d(other)) {
                            this.h.b(other);
                        }
                        this.h.a(other, view);
                    }
                }
            }
        }
        this.g.addAll(this.h.i());
        Collections.reverse(this.g);
    }

    public void t(View descendant, Rect out) {
        a.g.b.b.a(this, descendant, out);
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void J(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0139, code lost:
    
        if (r29.m(r35, r21, r3, r4, r5, 0) == false) goto L48;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r36, int r37) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public final d0 e(d0 insets) {
        if (insets.l()) {
            return insets;
        }
        int z = getChildCount();
        for (int i2 = 0; i2 < z; i2++) {
            View child = getChildAt(i2);
            if (v.z(child)) {
                f lp = (f) child.getLayoutParams();
                c b2 = lp.f();
                if (b2 != null) {
                    insets = b2.f(insets);
                    if (insets.l()) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return insets;
    }

    public void I(View child, int layoutDirection) {
        f lp = (f) child.getLayoutParams();
        if (lp.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view = lp.k;
        if (view != null) {
            D(child, view, layoutDirection);
            return;
        }
        int i2 = lp.e;
        if (i2 >= 0) {
            E(child, i2, layoutDirection);
        } else {
            C(child, layoutDirection);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        int layoutDirection = v.C(this);
        int childCount = this.g.size();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = this.g.get(i2);
            if (child.getVisibility() != 8) {
                f lp = (f) child.getLayoutParams();
                c behavior = lp.f();
                if (behavior == null || !behavior.l(this, child, layoutDirection)) {
                    I(child, layoutDirection);
                }
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas c2) {
        super.onDraw(c2);
        if (this.v && this.w != null) {
            d0 d0Var = this.u;
            int inset = d0Var != null ? d0Var.i() : 0;
            if (inset > 0) {
                this.w.setBounds(0, 0, getWidth(), inset);
                this.w.draw(c2);
            }
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        super.setFitsSystemWindows(fitSystemWindows);
        X();
    }

    public void N(View child, Rect r) {
        f lp = (f) child.getLayoutParams();
        lp.q(r);
    }

    public void x(View child, Rect out) {
        f lp = (f) child.getLayoutParams();
        out.set(lp.h());
    }

    public void q(View child, boolean transform, Rect out) {
        if (child.isLayoutRequested() || child.getVisibility() == 8) {
            out.setEmpty();
        } else if (transform) {
            t(child, out);
        } else {
            out.set(child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
        }
    }

    public final void v(int layoutDirection, Rect anchorRect, Rect out, f lp, int childWidth, int childHeight) {
        int left;
        int top;
        int absGravity = a.h.k.e.b(R(lp.c), layoutDirection);
        int absAnchorGravity = a.h.k.e.b(S(lp.d), layoutDirection);
        int hgrav = absGravity & 7;
        int vgrav = absGravity & 112;
        int anchorHgrav = absAnchorGravity & 7;
        int anchorVgrav = absAnchorGravity & 112;
        switch (anchorHgrav) {
            case 1:
                int left2 = anchorRect.left;
                left = left2 + (anchorRect.width() / 2);
                break;
            case 5:
                left = anchorRect.right;
                break;
            default:
                left = anchorRect.left;
                break;
        }
        switch (anchorVgrav) {
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                int top2 = anchorRect.top;
                top = top2 + (anchorRect.height() / 2);
                break;
            case 80:
                top = anchorRect.bottom;
                break;
            default:
                top = anchorRect.top;
                break;
        }
        switch (hgrav) {
            case 1:
                left -= childWidth / 2;
                break;
            case 5:
                break;
            default:
                left -= childWidth;
                break;
        }
        switch (vgrav) {
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                top -= childHeight / 2;
                break;
            case 80:
                break;
            default:
                top -= childHeight;
                break;
        }
        out.set(left, top, left + childWidth, top + childHeight);
    }

    public final void d(f lp, Rect out, int childWidth, int childHeight) {
        int width = getWidth();
        int height = getHeight();
        int left = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) lp).leftMargin, Math.min(out.left, ((width - getPaddingRight()) - childWidth) - ((ViewGroup.MarginLayoutParams) lp).rightMargin));
        int top = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) lp).topMargin, Math.min(out.top, ((height - getPaddingBottom()) - childHeight) - ((ViewGroup.MarginLayoutParams) lp).bottomMargin));
        out.set(left, top, left + childWidth, top + childHeight);
    }

    public void u(View child, int layoutDirection, Rect anchorRect, Rect out) {
        f lp = (f) child.getLayoutParams();
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        v(layoutDirection, anchorRect, out, lp, childWidth, childHeight);
        d(lp, out, childWidth, childHeight);
    }

    public final void D(View child, View anchor, int layoutDirection) {
        Rect anchorRect = a();
        Rect childRect = a();
        try {
            t(anchor, anchorRect);
            u(child, layoutDirection, anchorRect, childRect);
            child.layout(childRect.left, childRect.top, childRect.right, childRect.bottom);
        } finally {
            O(anchorRect);
            O(childRect);
        }
    }

    public final void E(View child, int keyline, int layoutDirection) {
        int keyline2;
        f lp = (f) child.getLayoutParams();
        int absGravity = a.h.k.e.b(T(lp.c), layoutDirection);
        int hgrav = absGravity & 7;
        int vgrav = absGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        if (layoutDirection != 1) {
            keyline2 = keyline;
        } else {
            keyline2 = width - keyline;
        }
        int left = w(keyline2) - childWidth;
        int top = 0;
        switch (hgrav) {
            case 1:
                left += childWidth / 2;
                break;
            case 5:
                left += childWidth;
                break;
        }
        switch (vgrav) {
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                top = 0 + (childHeight / 2);
                break;
            case 80:
                top = 0 + childHeight;
                break;
        }
        int left2 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) lp).leftMargin, Math.min(left, ((width - getPaddingRight()) - childWidth) - ((ViewGroup.MarginLayoutParams) lp).rightMargin));
        int top2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) lp).topMargin, Math.min(top, ((height - getPaddingBottom()) - childHeight) - ((ViewGroup.MarginLayoutParams) lp).bottomMargin));
        child.layout(left2, top2, left2 + childWidth, top2 + childHeight);
    }

    public final void C(View child, int layoutDirection) {
        f lp = (f) child.getLayoutParams();
        Rect parent = a();
        parent.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) lp).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) lp).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) lp).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) lp).bottomMargin);
        if (this.u != null && v.z(this) && !v.z(child)) {
            parent.left += this.u.g();
            parent.top += this.u.i();
            parent.right -= this.u.h();
            parent.bottom -= this.u.f();
        }
        Rect out = a();
        a.h.k.e.a(S(lp.c), child.getMeasuredWidth(), child.getMeasuredHeight(), parent, out, layoutDirection);
        child.layout(out.left, out.top, out.right, out.bottom);
        O(parent);
        O(out);
    }

    public static int S(int gravity) {
        if ((gravity & 7) == 0) {
            gravity |= 8388611;
        }
        if ((gravity & 112) == 0) {
            return gravity | 48;
        }
        return gravity;
    }

    public static int T(int gravity) {
        if (gravity == 0) {
            return 8388661;
        }
        return gravity;
    }

    public static int R(int gravity) {
        if (gravity == 0) {
            return 17;
        }
        return gravity;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        f lp = (f) child.getLayoutParams();
        c cVar = lp.f844a;
        if (cVar != null) {
            float scrimAlpha = cVar.d();
            if (scrimAlpha > 0.0f) {
                if (this.k == null) {
                    this.k = new Paint();
                }
                this.k.setColor(lp.f844a.c());
                this.k.setAlpha(c(Math.round(255.0f * scrimAlpha), 0, 255));
                int saved = canvas.save();
                if (child.isOpaque()) {
                    canvas.clipRect(child.getLeft(), child.getTop(), child.getRight(), child.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.k);
                canvas.restoreToCount(saved);
            }
        }
        return super.drawChild(canvas, child, drawingTime);
    }

    public static int c(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x005e. Please report as an issue. */
    public final void H(int type) {
        boolean handled;
        int layoutDirection = v.C(this);
        int childCount = this.g.size();
        Rect inset = a();
        Rect drawRect = a();
        Rect lastDrawRect = a();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = this.g.get(i2);
            f lp = (f) child.getLayoutParams();
            if (type != 0 || child.getVisibility() != 8) {
                for (int j = 0; j < i2; j++) {
                    if (lp.l == this.g.get(j)) {
                        G(child, layoutDirection);
                    }
                }
                q(child, true, drawRect);
                if (lp.g != 0 && !drawRect.isEmpty()) {
                    int absInsetEdge = a.h.k.e.b(lp.g, layoutDirection);
                    switch (absInsetEdge & 112) {
                        case 48:
                            inset.top = Math.max(inset.top, drawRect.bottom);
                            break;
                        case 80:
                            inset.bottom = Math.max(inset.bottom, getHeight() - drawRect.top);
                            break;
                    }
                    switch (absInsetEdge & 7) {
                        case 3:
                            inset.left = Math.max(inset.left, drawRect.right);
                            break;
                        case 5:
                            inset.right = Math.max(inset.right, getWidth() - drawRect.left);
                            break;
                    }
                }
                if (lp.h != 0 && child.getVisibility() == 0) {
                    F(child, inset, layoutDirection);
                }
                if (type != 2) {
                    x(child, lastDrawRect);
                    if (!lastDrawRect.equals(drawRect)) {
                        N(child, drawRect);
                    }
                }
                for (int j2 = i2 + 1; j2 < childCount; j2++) {
                    View checkChild = this.g.get(j2);
                    f checkLp = (f) checkChild.getLayoutParams();
                    c b2 = checkLp.f();
                    if (b2 != null && b2.e(this, checkChild, child)) {
                        if (type == 0 && checkLp.g()) {
                            checkLp.k();
                        } else {
                            switch (type) {
                                case 2:
                                    b2.i(this, checkChild, child);
                                    handled = true;
                                    break;
                                default:
                                    handled = b2.h(this, checkChild, child);
                                    break;
                            }
                            if (type == 1) {
                                checkLp.p(handled);
                            }
                        }
                    }
                }
            }
        }
        O(inset);
        O(drawRect);
        O(lastDrawRect);
    }

    public final void F(View child, Rect inset, int layoutDirection) {
        int distance;
        int i2;
        int distance2;
        int i3;
        int distance3;
        int i4;
        int distance4;
        int i5;
        if (!v.T(child) || child.getWidth() <= 0 || child.getHeight() <= 0) {
            return;
        }
        f lp = (f) child.getLayoutParams();
        c behavior = lp.f();
        Rect dodgeRect = a();
        Rect bounds = a();
        bounds.set(child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
        if (behavior != null && behavior.b(this, child, dodgeRect)) {
            if (!bounds.contains(dodgeRect)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + dodgeRect.toShortString() + " | Bounds:" + bounds.toShortString());
            }
        } else {
            dodgeRect.set(bounds);
        }
        O(bounds);
        if (dodgeRect.isEmpty()) {
            O(dodgeRect);
            return;
        }
        int absDodgeInsetEdges = a.h.k.e.b(lp.h, layoutDirection);
        boolean offsetY = false;
        if ((absDodgeInsetEdges & 48) == 48 && (distance4 = (dodgeRect.top - ((ViewGroup.MarginLayoutParams) lp).topMargin) - lp.j) < (i5 = inset.top)) {
            V(child, i5 - distance4);
            offsetY = true;
        }
        int distance5 = absDodgeInsetEdges & 80;
        if (distance5 == 80 && (distance3 = ((getHeight() - dodgeRect.bottom) - ((ViewGroup.MarginLayoutParams) lp).bottomMargin) + lp.j) < (i4 = inset.bottom)) {
            V(child, distance3 - i4);
            offsetY = true;
        }
        if (!offsetY) {
            V(child, 0);
        }
        boolean offsetX = false;
        if ((absDodgeInsetEdges & 3) == 3 && (distance2 = (dodgeRect.left - ((ViewGroup.MarginLayoutParams) lp).leftMargin) - lp.i) < (i3 = inset.left)) {
            U(child, i3 - distance2);
            offsetX = true;
        }
        int distance6 = absDodgeInsetEdges & 5;
        if (distance6 == 5 && (distance = ((getWidth() - dodgeRect.right) - ((ViewGroup.MarginLayoutParams) lp).rightMargin) + lp.i) < (i2 = inset.right)) {
            U(child, distance - i2);
            offsetX = true;
        }
        if (!offsetX) {
            U(child, 0);
        }
        O(dodgeRect);
    }

    public final void U(View child, int offsetX) {
        f lp = (f) child.getLayoutParams();
        int i2 = lp.i;
        if (i2 != offsetX) {
            int dx = offsetX - i2;
            v.Y(child, dx);
            lp.i = offsetX;
        }
    }

    public final void V(View child, int offsetY) {
        f lp = (f) child.getLayoutParams();
        int i2 = lp.j;
        if (i2 != offsetY) {
            int dy = offsetY - i2;
            v.Z(child, dy);
            lp.j = offsetY;
        }
    }

    public void f(View view) {
        List<View> dependents = this.h.g(view);
        if (dependents != null && !dependents.isEmpty()) {
            for (int i2 = 0; i2 < dependents.size(); i2++) {
                View child = dependents.get(i2);
                f lp = (f) child.getLayoutParams();
                c b2 = lp.f();
                if (b2 != null) {
                    b2.h(this, child, view);
                }
            }
        }
    }

    public List<View> r(View child) {
        List<View> dependencies = this.h.h(child);
        this.j.clear();
        if (dependencies != null) {
            this.j.addAll(dependencies);
        }
        return this.j;
    }

    public List<View> s(View child) {
        List<View> edges = this.h.g(child);
        this.j.clear();
        if (edges != null) {
            this.j.addAll(edges);
        }
        return this.j;
    }

    public final List<View> getDependencySortedChildren() {
        M();
        return Collections.unmodifiableList(this.g);
    }

    public void g() {
        boolean hasDependencies = false;
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View child = getChildAt(i2);
            if (!A(child)) {
                i2++;
            } else {
                hasDependencies = true;
                break;
            }
        }
        if (hasDependencies != this.t) {
            if (hasDependencies) {
                b();
            } else {
                P();
            }
        }
    }

    public final boolean A(View child) {
        return this.h.j(child);
    }

    public void b() {
        if (this.o) {
            if (this.s == null) {
                this.s = new g();
            }
            ViewTreeObserver vto = getViewTreeObserver();
            vto.addOnPreDrawListener(this.s);
        }
        this.t = true;
    }

    public void P() {
        if (this.o && this.s != null) {
            ViewTreeObserver vto = getViewTreeObserver();
            vto.removeOnPreDrawListener(this.s);
        }
        this.t = false;
    }

    public void G(View child, int layoutDirection) {
        c b2;
        f lp = (f) child.getLayoutParams();
        if (lp.k != null) {
            Rect anchorRect = a();
            Rect childRect = a();
            Rect desiredChildRect = a();
            t(lp.k, anchorRect);
            q(child, false, childRect);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            v(layoutDirection, anchorRect, desiredChildRect, lp, childWidth, childHeight);
            boolean changed = (desiredChildRect.left == childRect.left && desiredChildRect.top == childRect.top) ? false : true;
            d(lp, desiredChildRect, childWidth, childHeight);
            int dx = desiredChildRect.left - childRect.left;
            int dy = desiredChildRect.top - childRect.top;
            if (dx != 0) {
                v.Y(child, dx);
            }
            if (dy != 0) {
                v.Z(child, dy);
            }
            if (changed && (b2 = lp.f()) != null) {
                b2.h(this, child, lp.k);
            }
            O(anchorRect);
            O(childRect);
            O(desiredChildRect);
        }
    }

    public boolean B(View child, int x, int y) {
        Rect r = a();
        t(child, r);
        try {
            return r.contains(x, y);
        } finally {
            O(r);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attrs) {
        return new f(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams p) {
        if (p instanceof f) {
            return new f((f) p);
        }
        if (p instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) p);
        }
        return new f(p);
    }

    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return (p instanceof f) && super.checkLayoutParams(p);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return o(child, target, nestedScrollAxes, 0);
    }

    @Override // a.h.k.m
    public boolean o(View child, View target, int axes, int type) {
        int childCount = getChildCount();
        boolean handled = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = getChildAt(i2);
            if (view.getVisibility() != 8) {
                f lp = (f) view.getLayoutParams();
                c viewBehavior = lp.f();
                if (viewBehavior == null) {
                    lp.r(type, false);
                } else {
                    boolean accepted = viewBehavior.A(this, view, child, target, axes, type);
                    lp.r(type, accepted);
                    handled |= accepted;
                }
            }
        }
        return handled;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        i(child, target, nestedScrollAxes, 0);
    }

    @Override // a.h.k.m
    public void i(View child, View target, int nestedScrollAxes, int type) {
        c viewBehavior;
        this.z.b(nestedScrollAxes, type);
        this.r = target;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = getChildAt(i2);
            f lp = (f) view.getLayoutParams();
            if (lp.j(type) && (viewBehavior = lp.f()) != null) {
                viewBehavior.v(this, view, child, target, nestedScrollAxes, type);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onStopNestedScroll(View target) {
        m(target, 0);
    }

    @Override // a.h.k.m
    public void m(View target, int type) {
        this.z.d(type);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = getChildAt(i2);
            f lp = (f) view.getLayoutParams();
            if (lp.j(type)) {
                c viewBehavior = lp.f();
                if (viewBehavior != null) {
                    viewBehavior.C(this, view, target, type);
                }
                lp.l(type);
                lp.k();
            }
        }
        this.r = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        l(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, 0);
    }

    @Override // a.h.k.m
    public void l(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        k(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, 0, this.m);
    }

    @Override // a.h.k.n
    public void k(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        int childCount;
        int childCount2 = getChildCount();
        boolean accepted = false;
        int xConsumed = 0;
        int yConsumed = 0;
        int i2 = 0;
        while (i2 < childCount2) {
            View view = getChildAt(i2);
            if (view.getVisibility() == 8) {
                childCount = childCount2;
            } else {
                f lp = (f) view.getLayoutParams();
                if (!lp.j(type)) {
                    childCount = childCount2;
                } else {
                    c viewBehavior = lp.f();
                    if (viewBehavior != null) {
                        int[] iArr = this.l;
                        iArr[0] = 0;
                        iArr[1] = 0;
                        childCount = childCount2;
                        viewBehavior.t(this, view, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, iArr);
                        int[] iArr2 = this.l;
                        int xConsumed2 = dxUnconsumed > 0 ? Math.max(xConsumed, iArr2[0]) : Math.min(xConsumed, iArr2[0]);
                        int[] iArr3 = this.l;
                        xConsumed = xConsumed2;
                        yConsumed = dyUnconsumed > 0 ? Math.max(yConsumed, iArr3[1]) : Math.min(yConsumed, iArr3[1]);
                        accepted = true;
                    } else {
                        childCount = childCount2;
                    }
                }
            }
            i2++;
            childCount2 = childCount;
        }
        consumed[0] = consumed[0] + xConsumed;
        consumed[1] = consumed[1] + yConsumed;
        if (accepted) {
            H(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        n(target, dx, dy, consumed, 0);
    }

    @Override // a.h.k.m
    public void n(View target, int dx, int dy, int[] consumed, int type) {
        c viewBehavior;
        int childCount = getChildCount();
        int xConsumed = 0;
        int yConsumed = 0;
        boolean accepted = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = getChildAt(i2);
            if (view.getVisibility() != 8) {
                f lp = (f) view.getLayoutParams();
                if (lp.j(type) && (viewBehavior = lp.f()) != null) {
                    int[] iArr = this.l;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    viewBehavior.q(this, view, target, dx, dy, iArr, type);
                    int[] iArr2 = this.l;
                    int xConsumed2 = dx > 0 ? Math.max(xConsumed, iArr2[0]) : Math.min(xConsumed, iArr2[0]);
                    int[] iArr3 = this.l;
                    xConsumed = xConsumed2;
                    yConsumed = dy > 0 ? Math.max(yConsumed, iArr3[1]) : Math.min(yConsumed, iArr3[1]);
                    accepted = true;
                }
            }
        }
        consumed[0] = xConsumed;
        consumed[1] = yConsumed;
        if (accepted) {
            H(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        c viewBehavior;
        boolean handled = false;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = getChildAt(i2);
            if (view.getVisibility() != 8) {
                f lp = (f) view.getLayoutParams();
                if (lp.j(0) && (viewBehavior = lp.f()) != null) {
                    handled |= viewBehavior.n();
                }
            }
        }
        if (handled) {
            H(1);
        }
        return handled;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        c viewBehavior;
        boolean handled = false;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = getChildAt(i2);
            if (view.getVisibility() != 8) {
                f lp = (f) view.getLayoutParams();
                if (lp.j(0) && (viewBehavior = lp.f()) != null) {
                    handled |= viewBehavior.o(this, view, target, velocityX, velocityY);
                }
            }
        }
        return handled;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.z.a();
    }

    /* loaded from: classes.dex */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.H(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View lhs, View rhs) {
            float lz = v.N(lhs);
            float rz = v.N(rhs);
            if (lz > rz) {
                return -1;
            }
            if (lz < rz) {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c<V extends View> {
        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public c() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public c(Context context, AttributeSet attrs) {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public void g(f params) {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public void j() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean k(CoordinatorLayout parent, V child, MotionEvent ev) {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean D(CoordinatorLayout parent, V child, MotionEvent ev) {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public int c() {
            return -16777216;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public float d() {
            return 0.0f;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean a(CoordinatorLayout parent, V child) {
            return d() > 0.0f;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean e(CoordinatorLayout parent, V child, View dependency) {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean h(CoordinatorLayout parent, V child, View dependency) {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public void i(CoordinatorLayout parent, V child, View dependency) {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean m(CoordinatorLayout parent, V child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean l(CoordinatorLayout parent, V child, int layoutDirection) {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        @Deprecated
        public boolean z() {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean A(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int axes, int type) {
            if (type == 0) {
                return z();
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        @Deprecated
        public void u() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public void v(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int axes, int type) {
            if (type == 0) {
                u();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        @Deprecated
        public void B() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public void C(CoordinatorLayout coordinatorLayout, V child, View target, int type) {
            if (type == 0) {
                B();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        @Deprecated
        public void r() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        @Deprecated
        public void s(CoordinatorLayout coordinatorLayout, V child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
            if (type == 0) {
                r();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public void t(CoordinatorLayout coordinatorLayout, V child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
            consumed[0] = consumed[0] + dxUnconsumed;
            consumed[1] = consumed[1] + dyUnconsumed;
            s(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        @Deprecated
        public void p() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public void q(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed, int type) {
            if (type == 0) {
                p();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean n() {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean o(CoordinatorLayout coordinatorLayout, V child, View target, float velocityX, float velocityY) {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public d0 f(d0 insets) {
            return insets;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean w(CoordinatorLayout coordinatorLayout, V child, Rect rectangle, boolean immediate) {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public void x(CoordinatorLayout parent, V child, Parcelable state) {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public Parcelable y(CoordinatorLayout parent, V child) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.coordinatorlayout.widget.CoordinatorLayout$c != androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior<V extends android.view.View> */
        public boolean b(CoordinatorLayout parent, V child, Rect rect) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public c f844a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f845b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public View k;
        public View l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q;

        public f(int width, int height) {
            super(width, height);
            this.f845b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public f(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.f845b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
            TypedArray a2 = context.obtainStyledAttributes(attrs, a.g.a.f332b);
            int[] iArr = a.g.a.f331a;
            this.c = a2.getInteger(0, 0);
            this.f = a2.getResourceId(1, -1);
            this.d = a2.getInteger(2, 0);
            this.e = a2.getInteger(6, -1);
            this.g = a2.getInt(5, 0);
            this.h = a2.getInt(4, 0);
            boolean hasValue = a2.hasValue(3);
            this.f845b = hasValue;
            if (hasValue) {
                this.f844a = CoordinatorLayout.K(context, attrs, a2.getString(3));
            }
            a2.recycle();
            c cVar = this.f844a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(f p) {
            super((ViewGroup.MarginLayoutParams) p);
            this.f845b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams p) {
            super(p);
            this.f845b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.LayoutParams p) {
            super(p);
            this.f845b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public int e() {
            return this.f;
        }

        public c f() {
            return this.f844a;
        }

        public void o(c behavior) {
            c cVar = this.f844a;
            if (cVar != behavior) {
                if (cVar != null) {
                    cVar.j();
                }
                this.f844a = behavior;
                this.f845b = true;
                if (behavior != null) {
                    behavior.g(this);
                }
            }
        }

        public void q(Rect r) {
            this.q.set(r);
        }

        public Rect h() {
            return this.q;
        }

        public boolean a() {
            return this.k == null && this.f != -1;
        }

        public boolean c() {
            if (this.f844a == null) {
                this.m = false;
            }
            return this.m;
        }

        public boolean i(CoordinatorLayout parent, View child) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            c cVar = this.f844a;
            boolean a2 = z | (cVar != null ? cVar.a(parent, child) : false);
            this.m = a2;
            return a2;
        }

        public void m() {
            this.m = false;
        }

        public void l(int type) {
            r(type, false);
        }

        public void r(int type, boolean accept) {
            switch (type) {
                case 0:
                    this.n = accept;
                    return;
                case 1:
                    this.o = accept;
                    return;
                default:
                    return;
            }
        }

        public boolean j(int type) {
            switch (type) {
                case 0:
                    return this.n;
                case 1:
                    return this.o;
                default:
                    return false;
            }
        }

        public boolean g() {
            return this.p;
        }

        public void p(boolean changed) {
            this.p = changed;
        }

        public void k() {
            this.p = false;
        }

        public boolean b(CoordinatorLayout parent, View child, View dependency) {
            c cVar;
            return dependency == this.l || s(dependency, v.C(parent)) || ((cVar = this.f844a) != null && cVar.e(parent, child, dependency));
        }

        public View d(CoordinatorLayout parent, View forChild) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !t(forChild, parent)) {
                n(forChild, parent);
            }
            return this.k;
        }

        public final void n(View forChild, CoordinatorLayout parent) {
            View findViewById = parent.findViewById(this.f);
            this.k = findViewById;
            if (findViewById != null) {
                if (findViewById == parent) {
                    if (parent.isInEditMode()) {
                        this.l = null;
                        this.k = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                View directChild = this.k;
                for (ViewParent p = findViewById.getParent(); p != parent && p != null; p = p.getParent()) {
                    if (p == forChild) {
                        if (parent.isInEditMode()) {
                            this.l = null;
                            this.k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (p instanceof View) {
                        directChild = (View) p;
                    }
                }
                this.l = directChild;
                return;
            }
            if (parent.isInEditMode()) {
                this.l = null;
                this.k = null;
                return;
            }
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + parent.getResources().getResourceName(this.f) + " to anchor view " + forChild);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.view.ViewParent] */
        public final boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            CoordinatorLayout coordinatorLayout2 = this.k;
            for (CoordinatorLayout coordinatorLayout3 = this.k.getParent(); coordinatorLayout3 != coordinatorLayout; coordinatorLayout3 = coordinatorLayout3.getParent()) {
                if (coordinatorLayout3 == null || coordinatorLayout3 == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (coordinatorLayout3 instanceof View) {
                    coordinatorLayout2 = coordinatorLayout3;
                }
            }
            this.l = coordinatorLayout2;
            return true;
        }

        public final boolean s(View other, int layoutDirection) {
            f lp = (f) other.getLayoutParams();
            int absInset = a.h.k.e.b(lp.g, layoutDirection);
            return absInset != 0 && (a.h.k.e.b(this.h, layoutDirection) & absInset) == absInset;
        }
    }

    /* loaded from: classes.dex */
    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View parent, View child) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.x;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(parent, child);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View parent, View child) {
            CoordinatorLayout.this.H(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.x;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(parent, child);
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Parcelable savedState;
        if (!(state instanceof h)) {
            super.onRestoreInstanceState(state);
            return;
        }
        h ss = (h) state;
        super.onRestoreInstanceState(ss.j());
        SparseArray<Parcelable> behaviorStates = ss.d;
        int count = getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View child = getChildAt(i2);
            int childId = child.getId();
            f lp = y(child);
            c b2 = lp.f();
            if (childId != -1 && b2 != null && (savedState = behaviorStates.get(childId)) != null) {
                b2.x(this, child, savedState);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable state;
        h ss = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> behaviorStates = new SparseArray<>();
        int count = getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View child = getChildAt(i2);
            int childId = child.getId();
            f lp = (f) child.getLayoutParams();
            c b2 = lp.f();
            if (childId != -1 && b2 != null && (state = b2.y(this, child)) != null) {
                behaviorStates.append(childId, state);
            }
        }
        ss.d = behaviorStates;
        return ss;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        f lp = (f) child.getLayoutParams();
        c behavior = lp.f();
        if (behavior != null && behavior.w(this, child, rectangle, immediate)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(child, rectangle, immediate);
    }

    public final void X() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (v.z(this)) {
            if (this.y == null) {
                this.y = new a();
            }
            v.z0(this, this.y);
            setSystemUiVisibility(1280);
            return;
        }
        v.z0(this, null);
    }

    /* loaded from: classes.dex */
    public class a implements q {
        public a() {
        }

        @Override // a.h.k.q
        public d0 a(View v, d0 insets) {
            return CoordinatorLayout.this.W(insets);
        }
    }

    /* loaded from: classes.dex */
    public static class h extends a.j.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public SparseArray<Parcelable> d;

        public h(Parcel source, ClassLoader loader) {
            super(source, loader);
            int size = source.readInt();
            int[] ids = new int[size];
            source.readIntArray(ids);
            Parcelable[] states = source.readParcelableArray(loader);
            this.d = new SparseArray<>(size);
            for (int i = 0; i < size; i++) {
                this.d.append(ids[i], states[i]);
            }
        }

        public h(Parcelable superState) {
            super(superState);
        }

        @Override // a.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            SparseArray<Parcelable> sparseArray = this.d;
            int size = sparseArray != null ? sparseArray.size() : 0;
            dest.writeInt(size);
            int[] ids = new int[size];
            Parcelable[] states = new Parcelable[size];
            for (int i = 0; i < size; i++) {
                ids[i] = this.d.keyAt(i);
                states[i] = this.d.valueAt(i);
            }
            dest.writeIntArray(ids);
            dest.writeParcelableArray(states, flags);
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
                return new h(in, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int size) {
                return new h[size];
            }
        }
    }
}
