package com.google.android.material.appbar;

import a.h.k.e0.c;
import a.h.k.e0.f;
import a.h.k.k;
import a.h.k.v;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.a.a.c.e;
import b.b.a.a.x.g;
import b.b.a.a.x.h;
import java.lang.ref.WeakReference;
import java.util.List;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: b, reason: collision with root package name */
    public int f1131b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public WeakReference<View> l;
    public ValueAnimator m;
    public int[] n;
    public Drawable o;

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.o = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                a.h.d.l.a.m(this.o, v.C(this));
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
            }
            u();
            v.f0(this);
        }
    }

    public void setStatusBarForegroundColor(int color) {
        setStatusBarForeground(new ColorDrawable(color));
    }

    public void setStatusBarForegroundResource(int resId) {
        setStatusBarForeground(a.b.c.a.a.d(getContext(), resId));
    }

    public Drawable getStatusBarForeground() {
        return this.o;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (q()) {
            int saveCount = canvas.save();
            canvas.translate(0.0f, -this.f1131b);
            this.o.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        Drawable d = this.o;
        if (d != null && d.isStateful() && d.setState(state)) {
            invalidateDrawable(d);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.o;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        boolean visible = visibility == 0;
        Drawable drawable = this.o;
        if (drawable != null) {
            drawable.setVisible(visible, false);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode != 1073741824 && v.z(this) && s()) {
            int newHeight = getMeasuredHeight();
            switch (heightMode) {
                case Integer.MIN_VALUE:
                    newHeight = a.h.f.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(heightMeasureSpec));
                    break;
                case 0:
                    newHeight += getTopInset();
                    break;
            }
            setMeasuredDimension(getMeasuredWidth(), newHeight);
        }
        i();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        boolean z = true;
        if (v.z(this) && s()) {
            int topInset = getTopInset();
            for (int z2 = getChildCount() - 1; z2 >= 0; z2--) {
                v.Z(getChildAt(z2), topInset);
            }
        }
        i();
        this.f = false;
        int i = 0;
        int z3 = getChildCount();
        while (true) {
            if (i >= z3) {
                break;
            }
            View child = getChildAt(i);
            b childLp = (b) child.getLayoutParams();
            Interpolator interpolator = childLp.b();
            if (interpolator == null) {
                i++;
            } else {
                this.f = true;
                break;
            }
        }
        Drawable drawable = this.o;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.j && !g()) {
            z = false;
        }
        o(z);
    }

    public final void u() {
        setWillNotDraw(!q());
    }

    public final boolean q() {
        return this.o != null && getTopInset() > 0;
    }

    public final boolean g() {
        int z = getChildCount();
        for (int i = 0; i < z; i++) {
            if (((b) getChildAt(i).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        this.c = -1;
        this.d = -1;
        this.e = -1;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int orientation) {
        if (orientation != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(orientation);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        h.d(this, elevation);
    }

    public void setExpanded(boolean expanded) {
        m(expanded, v.T(this));
    }

    public void m(boolean expanded, boolean animate) {
        n(expanded, animate, true);
    }

    public final void n(boolean expanded, boolean animate, boolean force) {
        this.g = (expanded ? 1 : 2) | (animate ? 4 : 0) | (force ? 8 : 0);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof b;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attrs) {
        return new b(getContext(), attrs);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams p) {
        if (Build.VERSION.SDK_INT >= 19 && (p instanceof LinearLayout.LayoutParams)) {
            return new b((LinearLayout.LayoutParams) p);
        }
        if (p instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) p);
        }
        return new b(p);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public boolean f() {
        return this.f;
    }

    public final int getTotalScrollRange() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int range = 0;
        int i2 = 0;
        int z = getChildCount();
        while (true) {
            if (i2 >= z) {
                break;
            }
            View child = getChildAt(i2);
            b lp = (b) child.getLayoutParams();
            int childHeight = child.getMeasuredHeight();
            int flags = lp.f1139a;
            if ((flags & 1) == 0) {
                break;
            }
            range += ((LinearLayout.LayoutParams) lp).topMargin + childHeight + ((LinearLayout.LayoutParams) lp).bottomMargin;
            if (i2 == 0 && v.z(child)) {
                range -= getTopInset();
            }
            if ((flags & 2) == 0) {
                i2++;
            } else {
                range -= v.D(child);
                break;
            }
        }
        int max = Math.max(0, range);
        this.c = max;
        return max;
    }

    public boolean h() {
        return getTotalScrollRange() != 0;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public int getDownNestedPreScrollRange() {
        int childRange;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int range = 0;
        for (int i2 = getChildCount() - 1; i2 >= 0; i2--) {
            View child = getChildAt(i2);
            b lp = (b) child.getLayoutParams();
            int childHeight = child.getMeasuredHeight();
            int flags = lp.f1139a;
            if ((flags & 5) == 5) {
                int childRange2 = ((LinearLayout.LayoutParams) lp).topMargin + ((LinearLayout.LayoutParams) lp).bottomMargin;
                if ((flags & 8) != 0) {
                    childRange = childRange2 + v.D(child);
                } else if ((flags & 2) != 0) {
                    childRange = childRange2 + (childHeight - v.D(child));
                } else {
                    childRange = childRange2 + childHeight;
                }
                if (i2 == 0 && v.z(child)) {
                    childRange = Math.min(childRange, childHeight - getTopInset());
                }
                range += childRange;
            } else if (range > 0) {
                break;
            }
        }
        int max = Math.max(0, range);
        this.d = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int range = 0;
        int i2 = 0;
        int z = getChildCount();
        while (true) {
            if (i2 >= z) {
                break;
            }
            View child = getChildAt(i2);
            b lp = (b) child.getLayoutParams();
            int childHeight = child.getMeasuredHeight();
            int childHeight2 = childHeight + ((LinearLayout.LayoutParams) lp).topMargin + ((LinearLayout.LayoutParams) lp).bottomMargin;
            int flags = lp.f1139a;
            if ((flags & 1) == 0) {
                break;
            }
            range += childHeight2;
            if ((flags & 2) == 0) {
                i2++;
            } else {
                range -= v.D(child);
                break;
            }
        }
        int max = Math.max(0, range);
        this.e = max;
        return max;
    }

    public void k(int offset) {
        this.f1131b = offset;
        if (!willNotDraw()) {
            v.f0(this);
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minHeight = v.D(this);
        if (minHeight != 0) {
            return (minHeight * 2) + topInset;
        }
        int childCount = getChildCount();
        int lastChildMinHeight = childCount >= 1 ? v.D(getChildAt(childCount - 1)) : 0;
        if (lastChildMinHeight != 0) {
            return (lastChildMinHeight * 2) + topInset;
        }
        return getHeight() / 3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        if (this.n == null) {
            this.n = new int[4];
        }
        int[] extraStates = this.n;
        int[] states = super.onCreateDrawableState(extraStates.length + extraSpace);
        boolean z = this.h;
        extraStates[0] = z ? R.attr.state_liftable : -2130903840;
        extraStates[1] = (z && this.i) ? R.attr.state_lifted : -2130903841;
        extraStates[2] = z ? R.attr.state_collapsible : -2130903838;
        extraStates[3] = (z && this.i) ? R.attr.state_collapsed : -2130903837;
        return LinearLayout.mergeDrawableStates(states, extraStates);
    }

    public final boolean o(boolean liftable) {
        if (this.h != liftable) {
            this.h = liftable;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    public boolean p(boolean lifted) {
        if (this.i != lifted) {
            this.i = lifted;
            refreshDrawableState();
            if (this.j && (getBackground() instanceof g)) {
                t((g) getBackground(), lifted);
                return true;
            }
            return true;
        }
        return false;
    }

    public final void t(g background, boolean lifted) {
        float appBarElevation = getResources().getDimension(R.dimen.design_appbar_elevation);
        float fromElevation = lifted ? 0.0f : appBarElevation;
        float toElevation = lifted ? appBarElevation : 0.0f;
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fromElevation, toElevation);
        this.m = ofFloat;
        ofFloat.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.m.setInterpolator(b.b.a.a.b.a.f977a);
        this.m.addUpdateListener(new a(this, background));
        this.m.start();
    }

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f1138a;

        public a(AppBarLayout this$0, g gVar) {
            this.f1138a = gVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f1138a.U(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public void setLiftOnScroll(boolean liftOnScroll) {
        this.j = liftOnScroll;
    }

    public boolean j() {
        return this.j;
    }

    public void setLiftOnScrollTargetViewId(int liftOnScrollTargetViewId) {
        this.k = liftOnScrollTargetViewId;
        a();
    }

    public int getLiftOnScrollTargetViewId() {
        return this.k;
    }

    public boolean r(View defaultScrollingView) {
        View scrollingView = b(defaultScrollingView);
        if (scrollingView == null) {
            scrollingView = defaultScrollingView;
        }
        return scrollingView != null && (scrollingView.canScrollVertically(-1) || scrollingView.getScrollY() > 0);
    }

    public final View b(View defaultScrollingView) {
        int i;
        if (this.l == null && (i = this.k) != -1) {
            View targetView = null;
            if (defaultScrollingView != null) {
                targetView = defaultScrollingView.findViewById(i);
            }
            if (targetView == null && (getParent() instanceof ViewGroup)) {
                targetView = ((ViewGroup) getParent()).findViewById(this.k);
            }
            if (targetView != null) {
                this.l = new WeakReference<>(targetView);
            }
        }
        WeakReference<View> weakReference = this.l;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void a() {
        WeakReference<View> weakReference = this.l;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.l = null;
    }

    @Deprecated
    public void setTargetElevation(float elevation) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.a(this, elevation);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public int getPendingAction() {
        return this.g;
    }

    public void l() {
        this.g = 0;
    }

    public final int getTopInset() {
        return 0;
    }

    public final boolean s() {
        if (getChildCount() <= 0) {
            return false;
        }
        View firstChild = getChildAt(0);
        return (firstChild.getVisibility() == 8 || v.z(firstChild)) ? false : true;
    }

    /* loaded from: classes.dex */
    public static class b extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f1139a;

        /* renamed from: b, reason: collision with root package name */
        public Interpolator f1140b;

        public b(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.f1139a = 1;
            TypedArray a2 = c.obtainStyledAttributes(attrs, b.b.a.a.a.f942a);
            int[] iArr = b.b.a.a.a.f942a;
            this.f1139a = a2.getInt(0, 0);
            if (a2.hasValue(1)) {
                int resId = a2.getResourceId(1, 0);
                this.f1140b = AnimationUtils.loadInterpolator(c, resId);
            }
            a2.recycle();
        }

        public b(int width, int height) {
            super(width, height);
            this.f1139a = 1;
        }

        public b(ViewGroup.LayoutParams p) {
            super(p);
            this.f1139a = 1;
        }

        public b(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.f1139a = 1;
        }

        public b(LinearLayout.LayoutParams source) {
            super(source);
            this.f1139a = 1;
        }

        public int a() {
            return this.f1139a;
        }

        public Interpolator b() {
            return this.f1140b;
        }

        public boolean c() {
            int i = this.f1139a;
            return (i & 1) == 1 && (i & 10) != 0;
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
    }

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends b.b.a.a.c.a<T> {
        public int k;
        public int l;
        public ValueAnimator m;
        public int n;
        public boolean o;
        public float p;
        public WeakReference<View> q;

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            return m0(coordinatorLayout, (AppBarLayout) view, view2, i, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b.b.a.a.c.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            g0(coordinatorLayout, (AppBarLayout) view, i);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            i0(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            j0(coordinatorLayout, (AppBarLayout) view, i4, iArr);
        }

        public BaseBehavior() {
            this.n = -1;
        }

        public BaseBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.n = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean m0(CoordinatorLayout parent, AppBarLayout appBarLayout, View directTargetChild, int nestedScrollAxes, int type) {
            ValueAnimator valueAnimator;
            boolean started = (nestedScrollAxes & 2) != 0 && (appBarLayout.j() || X(parent, appBarLayout, directTargetChild));
            if (started && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.l = type;
            return started;
        }

        public final boolean X(CoordinatorLayout parent, T child, View directTargetChild) {
            return child.h() && parent.getHeight() - directTargetChild.getHeight() <= child.getHeight();
        }

        public void i0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View target, int dy, int[] consumed) {
            int min;
            int max;
            if (dy != 0) {
                if (dy < 0) {
                    int min2 = -appBarLayout.getTotalScrollRange();
                    min = min2;
                    max = appBarLayout.getDownNestedPreScrollRange() + min2;
                } else {
                    int min3 = appBarLayout.getUpNestedPreScrollRange();
                    min = -min3;
                    max = 0;
                }
                if (min != max) {
                    consumed[1] = O(coordinatorLayout, appBarLayout, dy, min, max);
                }
            }
            if (appBarLayout.j()) {
                appBarLayout.p(appBarLayout.r(target));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void j0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int dyUnconsumed, int[] consumed) {
            if (dyUnconsumed < 0) {
                consumed[1] = O(coordinatorLayout, appBarLayout, dyUnconsumed, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (dyUnconsumed == 0) {
                r0(coordinatorLayout, appBarLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void C(CoordinatorLayout coordinatorLayout, T abl, View target, int type) {
            if (this.l == 0 || type == 1) {
                q0(coordinatorLayout, abl);
                if (abl.j()) {
                    abl.p(abl.r(target));
                }
            }
            this.q = new WeakReference<>(target);
        }

        public final void U(CoordinatorLayout coordinatorLayout, T child, int offset, float velocity) {
            int duration;
            int distance = Math.abs(M() - offset);
            float velocity2 = Math.abs(velocity);
            if (velocity2 > 0.0f) {
                duration = Math.round((distance / velocity2) * 1000.0f) * 3;
            } else {
                float distanceRatio = distance / child.getHeight();
                duration = (int) ((1.0f + distanceRatio) * 150.0f);
            }
            V(coordinatorLayout, child, offset, duration);
        }

        public final void V(CoordinatorLayout coordinatorLayout, T child, int offset, int duration) {
            int currentOffset = M();
            if (currentOffset == offset) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(b.b.a.a.b.a.e);
                this.m.addUpdateListener(new a(coordinatorLayout, child));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(duration, 600));
            this.m.setIntValues(currentOffset, offset);
            this.m.start();
        }

        /* loaded from: classes.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f1132a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f1133b;

            public a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f1132a = coordinatorLayout;
                this.f1133b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animator) {
                BaseBehavior.this.P(this.f1132a, this.f1133b, ((Integer) animator.getAnimatedValue()).intValue());
            }
        }

        public final int b0(T abl, int offset) {
            int count = abl.getChildCount();
            for (int i = 0; i < count; i++) {
                View child = abl.getChildAt(i);
                int top = child.getTop();
                int bottom = child.getBottom();
                b lp = (b) child.getLayoutParams();
                if (Y(lp.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) lp).topMargin;
                    bottom += ((LinearLayout.LayoutParams) lp).bottomMargin;
                }
                if (top <= (-offset) && bottom >= (-offset)) {
                    return i;
                }
            }
            return -1;
        }

        public final void q0(CoordinatorLayout coordinatorLayout, T abl) {
            int offset = M();
            int offsetChildIndex = b0(abl, offset);
            if (offsetChildIndex >= 0) {
                View offsetChild = abl.getChildAt(offsetChildIndex);
                b lp = (b) offsetChild.getLayoutParams();
                int flags = lp.a();
                if ((flags & 17) == 17) {
                    int snapTop = -offsetChild.getTop();
                    int snapBottom = -offsetChild.getBottom();
                    if (offsetChildIndex == abl.getChildCount() - 1) {
                        snapBottom += abl.getTopInset();
                    }
                    if (Y(flags, 2)) {
                        snapBottom += v.D(offsetChild);
                    } else if (Y(flags, 5)) {
                        int seam = v.D(offsetChild) + snapBottom;
                        if (offset < seam) {
                            snapTop = seam;
                        } else {
                            snapBottom = seam;
                        }
                    }
                    if (Y(flags, 32)) {
                        snapTop += ((LinearLayout.LayoutParams) lp).topMargin;
                        snapBottom -= ((LinearLayout.LayoutParams) lp).bottomMargin;
                    }
                    int newOffset = offset < (snapBottom + snapTop) / 2 ? snapBottom : snapTop;
                    U(coordinatorLayout, abl, a.h.f.a.b(newOffset, -abl.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public static boolean Y(int flags, int check) {
            return (flags & check) == check;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: h0, reason: merged with bridge method [inline-methods] */
        public boolean m(CoordinatorLayout parent, T child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
            CoordinatorLayout.f lp = (CoordinatorLayout.f) child.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) lp).height == -2) {
                parent.J(child, parentWidthMeasureSpec, widthUsed, View.MeasureSpec.makeMeasureSpec(0, 0), heightUsed);
                return true;
            }
            super.m(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
            return false;
        }

        public boolean g0(CoordinatorLayout parent, T abl, int layoutDirection) {
            int offset;
            super.l(parent, abl, layoutDirection);
            int pendingAction = abl.getPendingAction();
            int i = this.n;
            if (i >= 0 && (pendingAction & 8) == 0) {
                View child = abl.getChildAt(i);
                int offset2 = -child.getBottom();
                if (this.o) {
                    offset = offset2 + v.D(child) + abl.getTopInset();
                } else {
                    offset = offset2 + Math.round(child.getHeight() * this.p);
                }
                P(parent, abl, offset);
            } else if (pendingAction != 0) {
                boolean animate = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int offset3 = -abl.getUpNestedPreScrollRange();
                    if (animate) {
                        U(parent, abl, offset3, 0.0f);
                    } else {
                        P(parent, abl, offset3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (animate) {
                        U(parent, abl, 0, 0.0f);
                    } else {
                        P(parent, abl, 0);
                    }
                }
            }
            abl.l();
            this.n = -1;
            G(a.h.f.a.b(E(), -abl.getTotalScrollRange(), 0));
            s0(parent, abl, E(), 0, true);
            abl.k(E());
            r0(parent, abl);
            return true;
        }

        public final void r0(CoordinatorLayout coordinatorLayout, T appBarLayout) {
            v.i0(coordinatorLayout, c.a.f454b.b());
            v.i0(coordinatorLayout, c.a.c.b());
            View scrollingView = Z(coordinatorLayout);
            if (scrollingView == null || appBarLayout.getTotalScrollRange() == 0) {
                return;
            }
            CoordinatorLayout.f lp = (CoordinatorLayout.f) scrollingView.getLayoutParams();
            if (!(lp.f() instanceof ScrollingViewBehavior)) {
                return;
            }
            S(coordinatorLayout, appBarLayout, scrollingView);
        }

        public final void S(CoordinatorLayout coordinatorLayout, T appBarLayout, View scrollingView) {
            if (M() != (-appBarLayout.getTotalScrollRange()) && scrollingView.canScrollVertically(1)) {
                T(coordinatorLayout, appBarLayout, c.a.f454b, false);
            }
            if (M() != 0) {
                if (scrollingView.canScrollVertically(-1)) {
                    int dy = -appBarLayout.getDownNestedPreScrollRange();
                    if (dy != 0) {
                        v.k0(coordinatorLayout, c.a.c, null, new b(coordinatorLayout, appBarLayout, scrollingView, dy));
                        return;
                    }
                    return;
                }
                T(coordinatorLayout, appBarLayout, c.a.c, true);
            }
        }

        /* loaded from: classes.dex */
        public class b implements f {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f1134a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f1135b;
            public final /* synthetic */ View c;
            public final /* synthetic */ int d;

            public b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
                this.f1134a = coordinatorLayout;
                this.f1135b = appBarLayout;
                this.c = view;
                this.d = i;
            }

            @Override // a.h.k.e0.f
            public boolean a(View view, f.a arguments) {
                BaseBehavior.this.i0(this.f1134a, this.f1135b, this.c, this.d, new int[]{0, 0});
                return true;
            }
        }

        public final void T(CoordinatorLayout parent, T appBarLayout, c.a action, boolean expand) {
            v.k0(parent, action, null, new c(this, appBarLayout, expand));
        }

        /* loaded from: classes.dex */
        public class c implements f {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f1136a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f1137b;

            public c(BaseBehavior this$0, AppBarLayout appBarLayout, boolean z) {
                this.f1136a = appBarLayout;
                this.f1137b = z;
            }

            @Override // a.h.k.e0.f
            public boolean a(View view, f.a arguments) {
                this.f1136a.setExpanded(this.f1137b);
                return true;
            }
        }

        @Override // b.b.a.a.c.a
        /* renamed from: W, reason: merged with bridge method [inline-methods] */
        public boolean H(T view) {
            WeakReference<View> weakReference = this.q;
            if (weakReference == null) {
                return true;
            }
            View scrollingView = weakReference.get();
            return (scrollingView == null || !scrollingView.isShown() || scrollingView.canScrollVertically(-1)) ? false : true;
        }

        @Override // b.b.a.a.c.a
        /* renamed from: f0, reason: merged with bridge method [inline-methods] */
        public void N(CoordinatorLayout parent, T layout) {
            q0(parent, layout);
            if (layout.j()) {
                layout.p(layout.r(Z(parent)));
            }
        }

        @Override // b.b.a.a.c.a
        /* renamed from: c0, reason: merged with bridge method [inline-methods] */
        public int K(T view) {
            return -view.getDownNestedScrollRange();
        }

        @Override // b.b.a.a.c.a
        /* renamed from: d0, reason: merged with bridge method [inline-methods] */
        public int L(T view) {
            return view.getTotalScrollRange();
        }

        @Override // b.b.a.a.c.a
        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public int Q(CoordinatorLayout coordinatorLayout, T appBarLayout, int newOffset, int minOffset, int maxOffset) {
            int curOffset = M();
            int consumed = 0;
            if (minOffset != 0 && curOffset >= minOffset && curOffset <= maxOffset) {
                int newOffset2 = a.h.f.a.b(newOffset, minOffset, maxOffset);
                if (curOffset != newOffset2) {
                    int interpolatedOffset = appBarLayout.f() ? e0(appBarLayout, newOffset2) : newOffset2;
                    boolean offsetChanged = G(interpolatedOffset);
                    consumed = curOffset - newOffset2;
                    this.k = newOffset2 - interpolatedOffset;
                    if (!offsetChanged && appBarLayout.f()) {
                        coordinatorLayout.f(appBarLayout);
                    }
                    appBarLayout.k(E());
                    s0(coordinatorLayout, appBarLayout, newOffset2, newOffset2 < curOffset ? -1 : 1, false);
                }
            } else {
                this.k = 0;
            }
            r0(coordinatorLayout, appBarLayout);
            return consumed;
        }

        public final int e0(T layout, int offset) {
            int absOffset = Math.abs(offset);
            int i = 0;
            int z = layout.getChildCount();
            while (true) {
                if (i >= z) {
                    break;
                }
                View child = layout.getChildAt(i);
                b childLp = (b) child.getLayoutParams();
                Interpolator interpolator = childLp.b();
                if (absOffset < child.getTop() || absOffset > child.getBottom()) {
                    i++;
                } else if (interpolator != null) {
                    int childScrollableHeight = 0;
                    int flags = childLp.a();
                    if ((flags & 1) != 0) {
                        childScrollableHeight = 0 + child.getHeight() + ((LinearLayout.LayoutParams) childLp).topMargin + ((LinearLayout.LayoutParams) childLp).bottomMargin;
                        if ((flags & 2) != 0) {
                            childScrollableHeight -= v.D(child);
                        }
                    }
                    if (v.z(child)) {
                        childScrollableHeight -= layout.getTopInset();
                    }
                    if (childScrollableHeight > 0) {
                        int offsetForView = absOffset - child.getTop();
                        int interpolatedDiff = Math.round(childScrollableHeight * interpolator.getInterpolation(offsetForView / childScrollableHeight));
                        return Integer.signum(offset) * (child.getTop() + interpolatedDiff);
                    }
                }
            }
            return offset;
        }

        public final void s0(CoordinatorLayout parent, T layout, int offset, int direction, boolean forceJump) {
            View child = a0(layout, offset);
            if (child != null) {
                b childLp = (b) child.getLayoutParams();
                int flags = childLp.a();
                boolean lifted = false;
                if ((flags & 1) != 0) {
                    int minHeight = v.D(child);
                    if (direction > 0 && (flags & 12) != 0) {
                        lifted = (-offset) >= (child.getBottom() - minHeight) - layout.getTopInset();
                    } else if ((flags & 2) != 0) {
                        lifted = (-offset) >= (child.getBottom() - minHeight) - layout.getTopInset();
                    }
                }
                if (layout.j()) {
                    lifted = layout.r(Z(parent));
                }
                boolean changed = layout.p(lifted);
                if (forceJump || (changed && p0(parent, layout))) {
                    layout.jumpDrawablesToCurrentState();
                }
            }
        }

        public final boolean p0(CoordinatorLayout parent, T layout) {
            List<View> dependencies = parent.s(layout);
            int size = dependencies.size();
            for (int i = 0; i < size; i++) {
                View dependency = dependencies.get(i);
                CoordinatorLayout.f lp = (CoordinatorLayout.f) dependency.getLayoutParams();
                CoordinatorLayout.c behavior = lp.f();
                if (behavior instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behavior).K() != 0;
                }
            }
            return false;
        }

        public static View a0(AppBarLayout layout, int offset) {
            int absOffset = Math.abs(offset);
            int z = layout.getChildCount();
            for (int i = 0; i < z; i++) {
                View child = layout.getChildAt(i);
                if (absOffset >= child.getTop() && absOffset <= child.getBottom()) {
                    return child;
                }
            }
            return null;
        }

        public final View Z(CoordinatorLayout parent) {
            int z = parent.getChildCount();
            for (int i = 0; i < z; i++) {
                View child = parent.getChildAt(i);
                if ((child instanceof k) || (child instanceof ListView) || (child instanceof ScrollView)) {
                    return child;
                }
            }
            return null;
        }

        @Override // b.b.a.a.c.a
        public int M() {
            return E() + this.k;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public Parcelable y(CoordinatorLayout parent, T abl) {
            Parcelable superState = super.y(parent, abl);
            int offset = E();
            int count = abl.getChildCount();
            for (int i = 0; i < count; i++) {
                View child = abl.getChildAt(i);
                int visBottom = child.getBottom() + offset;
                if (child.getTop() + offset <= 0 && visBottom >= 0) {
                    d ss = new d(superState);
                    ss.d = i;
                    ss.f = visBottom == v.D(child) + abl.getTopInset();
                    ss.e = visBottom / child.getHeight();
                    return ss;
                }
            }
            return superState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void x(CoordinatorLayout parent, T appBarLayout, Parcelable state) {
            if (state instanceof d) {
                d ss = (d) state;
                super.x(parent, appBarLayout, ss.j());
                this.n = ss.d;
                this.p = ss.e;
                this.o = ss.f;
                return;
            }
            super.x(parent, appBarLayout, state);
            this.n = -1;
        }

        /* loaded from: classes.dex */
        public static class d extends a.j.a.a {
            public static final Parcelable.Creator<d> CREATOR = new a();
            public int d;
            public float e;
            public boolean f;

            public d(Parcel source, ClassLoader loader) {
                super(source, loader);
                this.d = source.readInt();
                this.e = source.readFloat();
                this.f = source.readByte() != 0;
            }

            public d(Parcelable superState) {
                super(superState);
            }

            @Override // a.j.a.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.d);
                parcel.writeFloat(this.e);
                parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
            }

            /* loaded from: classes.dex */
            public static class a implements Parcelable.ClassLoaderCreator<d> {
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public d createFromParcel(Parcel source, ClassLoader loader) {
                    return new d(source, loader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public d createFromParcel(Parcel source) {
                    return new d(source, null);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public d[] newArray(int size) {
                    return new d[size];
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends b.b.a.a.c.b {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a2 = context.obtainStyledAttributes(attrs, b.b.a.a.a.w);
            int[] iArr = b.b.a.a.a.f942a;
            O(a2.getDimensionPixelSize(0, 0));
            a2.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout parent, View child, View dependency) {
            return dependency instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout parent, View child, View dependency) {
            S(child, dependency);
            T(child, dependency);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void i(CoordinatorLayout parent, View child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                v.i0(parent, c.a.f454b.b());
                v.i0(parent, c.a.c.b());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean w(CoordinatorLayout parent, View child, Rect rectangle, boolean immediate) {
            AppBarLayout header = H(parent.r(child));
            if (header != null) {
                rectangle.offset(child.getLeft(), child.getTop());
                Rect parentRect = this.d;
                parentRect.set(0, 0, parent.getWidth(), parent.getHeight());
                if (!parentRect.contains(rectangle)) {
                    header.m(false, !immediate);
                    return true;
                }
            }
            return false;
        }

        public final void S(View child, View dependency) {
            CoordinatorLayout.c behavior = ((CoordinatorLayout.f) dependency.getLayoutParams()).f();
            if (behavior instanceof BaseBehavior) {
                BaseBehavior ablBehavior = (BaseBehavior) behavior;
                v.Z(child, (((dependency.getBottom() - child.getTop()) + ablBehavior.k) + M()) - I(dependency));
            }
        }

        @Override // b.b.a.a.c.b
        public float J(View header) {
            int availScrollRange;
            if (header instanceof AppBarLayout) {
                AppBarLayout abl = (AppBarLayout) header;
                int totalScrollRange = abl.getTotalScrollRange();
                int preScrollDown = abl.getDownNestedPreScrollRange();
                int offset = R(abl);
                if ((preScrollDown == 0 || totalScrollRange + offset > preScrollDown) && (availScrollRange = totalScrollRange - preScrollDown) != 0) {
                    return (offset / availScrollRange) + 1.0f;
                }
            }
            return 0.0f;
        }

        public static int R(AppBarLayout abl) {
            CoordinatorLayout.c behavior = ((CoordinatorLayout.f) abl.getLayoutParams()).f();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).M();
            }
            return 0;
        }

        @Override // b.b.a.a.c.b
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public AppBarLayout H(List<View> views) {
            int z = views.size();
            for (int i = 0; i < z; i++) {
                View view = views.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // b.b.a.a.c.b
        public int L(View v) {
            if (v instanceof AppBarLayout) {
                return ((AppBarLayout) v).getTotalScrollRange();
            }
            return super.L(v);
        }

        public final void T(View child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) dependency;
                if (appBarLayout.j()) {
                    appBarLayout.p(appBarLayout.r(child));
                }
            }
        }
    }
}
