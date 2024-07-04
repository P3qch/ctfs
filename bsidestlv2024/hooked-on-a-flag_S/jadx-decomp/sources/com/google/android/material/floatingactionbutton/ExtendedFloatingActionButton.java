package com.google.android.material.floatingactionbutton;

import a.h.k.v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.a.a.b.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    public boolean t;
    public boolean u;

    /* loaded from: classes.dex */
    public static abstract class f {
    }

    public static /* synthetic */ b.b.a.a.q.c l(ExtendedFloatingActionButton x0) {
        x0.getClass();
        return null;
    }

    public static /* synthetic */ b.b.a.a.q.c m(ExtendedFloatingActionButton x0) {
        x0.getClass();
        return null;
    }

    public static /* synthetic */ b.b.a.a.q.c o(ExtendedFloatingActionButton x0) {
        x0.getClass();
        return null;
    }

    public static /* synthetic */ b.b.a.a.q.c p(ExtendedFloatingActionButton x0) {
        x0.getClass();
        return null;
    }

    static {
        new b(Float.class, "width");
        new c(Float.class, "height");
        new d(Float.class, "paddingStart");
        new e(Float.class, "paddingEnd");
    }

    @Override // android.widget.TextView
    public void setTextColor(int color) {
        super.setTextColor(color);
        s();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colors) {
        super.setTextColor(colors);
        s();
    }

    public final void s() {
        getTextColors();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.t && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.t = false;
            b.b.a.a.q.c cVar = null;
            cVar.i();
            throw null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return null;
    }

    public void setExtended(boolean extended) {
        if (!extended) {
            return;
        }
        b.b.a.a.q.c motionStrategy = null;
        if (motionStrategy.d()) {
            return;
        }
        motionStrategy.i();
    }

    public void setAnimateShowBeforeLayout(boolean animateShowBeforeLayout) {
        this.u = animateShowBeforeLayout;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        super.setPaddingRelative(start, top, end, bottom);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
    }

    public h getShowMotionSpec() {
        b.b.a.a.q.c cVar = null;
        cVar.a();
        throw null;
    }

    public void setShowMotionSpec(h spec) {
        b.b.a.a.q.c cVar = null;
        cVar.g(spec);
        throw null;
    }

    public void setShowMotionSpecResource(int id) {
        setShowMotionSpec(h.c(getContext(), id));
    }

    public h getHideMotionSpec() {
        b.b.a.a.q.c cVar = null;
        cVar.a();
        throw null;
    }

    public void setHideMotionSpec(h spec) {
        b.b.a.a.q.c cVar = null;
        cVar.g(spec);
        throw null;
    }

    public void setHideMotionSpecResource(int id) {
        setHideMotionSpec(h.c(getContext(), id));
    }

    public h getExtendMotionSpec() {
        b.b.a.a.q.c cVar = null;
        cVar.a();
        throw null;
    }

    public void setExtendMotionSpec(h spec) {
        b.b.a.a.q.c cVar = null;
        cVar.g(spec);
        throw null;
    }

    public void setExtendMotionSpecResource(int id) {
        setExtendMotionSpec(h.c(getContext(), id));
    }

    public h getShrinkMotionSpec() {
        b.b.a.a.q.c cVar = null;
        cVar.a();
        throw null;
    }

    public void setShrinkMotionSpec(h spec) {
        b.b.a.a.q.c cVar = null;
        cVar.g(spec);
        throw null;
    }

    public void setShrinkMotionSpecResource(int id) {
        setShrinkMotionSpec(h.c(getContext(), id));
    }

    public final void r(b.b.a.a.q.c strategy, f callback) {
        if (strategy.d()) {
            return;
        }
        boolean shouldAnimate = t();
        if (!shouldAnimate) {
            strategy.i();
            strategy.b(callback);
            return;
        }
        measure(0, 0);
        Animator animator = strategy.c();
        animator.addListener(new a(this, strategy));
        for (Animator.AnimatorListener l : strategy.h()) {
            animator.addListener(l);
        }
        animator.start();
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1182a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b.b.a.a.q.c f1183b;

        public a(ExtendedFloatingActionButton this$0, b.b.a.a.q.c cVar) {
            this.f1183b = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f1183b.onAnimationStart(animation);
            this.f1182a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.f1182a = true;
            this.f1183b.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f1183b.e();
            if (!this.f1182a) {
                this.f1183b.b(null);
            }
        }
    }

    public final boolean q() {
        if (getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public final boolean t() {
        return (v.T(this) || (!q() && this.u)) && !isInEditMode();
    }

    /* loaded from: classes.dex */
    public static class b extends Property<View, Float> {
        public b(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View object, Float value) {
            object.getLayoutParams().width = value.intValue();
            object.requestLayout();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View object) {
            return Float.valueOf(object.getLayoutParams().width);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Property<View, Float> {
        public c(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View object, Float value) {
            object.getLayoutParams().height = value.intValue();
            object.requestLayout();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View object) {
            return Float.valueOf(object.getLayoutParams().height);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends Property<View, Float> {
        public d(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View object, Float value) {
            v.A0(object, value.intValue(), object.getPaddingTop(), v.H(object), object.getPaddingBottom());
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View object) {
            return Float.valueOf(v.I(object));
        }
    }

    /* loaded from: classes.dex */
    public static class e extends Property<View, Float> {
        public e(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View object, Float value) {
            v.A0(object, v.I(object), object.getPaddingTop(), value.intValue(), object.getPaddingBottom());
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View object) {
            return Float.valueOf(v.H(object));
        }
    }

    public int getCollapsedSize() {
        return 0;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    /* loaded from: classes.dex */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f1180a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1181b;
        public boolean c;

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            F(coordinatorLayout, (ExtendedFloatingActionButton) view, rect);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            H(coordinatorLayout, (ExtendedFloatingActionButton) view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            I(coordinatorLayout, (ExtendedFloatingActionButton) view, i);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior() {
            this.f1181b = false;
            this.c = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a2 = context.obtainStyledAttributes(attrs, b.b.a.a.a.g);
            int[] iArr = b.b.a.a.a.f942a;
            this.f1181b = a2.getBoolean(0, false);
            this.c = a2.getBoolean(1, true);
            a2.recycle();
        }

        public boolean F(CoordinatorLayout parent, ExtendedFloatingActionButton child, Rect rect) {
            super.b(parent, child, rect);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f lp) {
            if (lp.h == 0) {
                lp.h = 80;
            }
        }

        public boolean H(CoordinatorLayout parent, ExtendedFloatingActionButton child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                L(parent, (AppBarLayout) dependency, child);
                return false;
            }
            if (G(dependency)) {
                M(dependency, child);
                return false;
            }
            return false;
        }

        public static boolean G(View view) {
            ViewGroup.LayoutParams lp = view.getLayoutParams();
            if (lp instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) lp).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean J(View dependency, ExtendedFloatingActionButton child) {
            CoordinatorLayout.f lp = (CoordinatorLayout.f) child.getLayoutParams();
            return (this.f1181b || this.c) && lp.e() == dependency.getId();
        }

        public final boolean L(CoordinatorLayout parent, AppBarLayout appBarLayout, ExtendedFloatingActionButton child) {
            if (!J(appBarLayout, child)) {
                return false;
            }
            if (this.f1180a == null) {
                this.f1180a = new Rect();
            }
            Rect rect = this.f1180a;
            b.b.a.a.r.b.a(parent, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(child);
                return true;
            }
            E(child);
            return true;
        }

        public final boolean M(View bottomSheet, ExtendedFloatingActionButton child) {
            if (!J(bottomSheet, child)) {
                return false;
            }
            CoordinatorLayout.f lp = (CoordinatorLayout.f) child.getLayoutParams();
            if (bottomSheet.getTop() < (child.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) lp).topMargin) {
                K(child);
                return true;
            }
            E(child);
            return true;
        }

        public void K(ExtendedFloatingActionButton fab) {
            if (this.c) {
                ExtendedFloatingActionButton.l(fab);
            } else {
                ExtendedFloatingActionButton.m(fab);
            }
            fab.r(null, null);
        }

        public void E(ExtendedFloatingActionButton fab) {
            if (this.c) {
                ExtendedFloatingActionButton.o(fab);
            } else {
                ExtendedFloatingActionButton.p(fab);
            }
            fab.r(null, null);
        }

        public boolean I(CoordinatorLayout parent, ExtendedFloatingActionButton child, int layoutDirection) {
            List<View> dependencies = parent.r(child);
            int count = dependencies.size();
            for (int i = 0; i < count; i++) {
                View dependency = dependencies.get(i);
                if (dependency instanceof AppBarLayout) {
                    if (L(parent, (AppBarLayout) dependency, child)) {
                        break;
                    }
                } else {
                    if (G(dependency) && M(dependency, child)) {
                        break;
                    }
                }
            }
            parent.I(child, layoutDirection);
            return true;
        }
    }
}
