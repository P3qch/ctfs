package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public int f1141a;

    /* renamed from: b, reason: collision with root package name */
    public int f1142b;
    public int c;
    public ViewPropertyAnimator d;

    public HideBottomViewOnScrollBehavior() {
        this.f1141a = 0;
        this.f1142b = 2;
        this.c = 0;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1141a = 0;
        this.f1142b = 2;
        this.c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout parent, V child, int layoutDirection) {
        ViewGroup.MarginLayoutParams paramsCompat = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        this.f1141a = child.getMeasuredHeight() + paramsCompat.bottomMargin;
        super.l(parent, child, layoutDirection);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int nestedScrollAxes, int type) {
        return nestedScrollAxes == 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (dyConsumed > 0) {
            G(child);
        } else if (dyConsumed < 0) {
            H(child);
        }
    }

    public void H(V child) {
        if (this.f1142b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            child.clearAnimation();
        }
        this.f1142b = 2;
        F(child, 0, 225L, b.b.a.a.b.a.d);
    }

    public void G(V child) {
        if (this.f1142b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            child.clearAnimation();
        }
        this.f1142b = 1;
        F(child, this.f1141a + this.c, 175L, b.b.a.a.b.a.c);
    }

    public final void F(V child, int targetY, long duration, TimeInterpolator interpolator) {
        this.d = child.animate().translationY(targetY).setInterpolator(interpolator).setDuration(duration).setListener(new a());
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            HideBottomViewOnScrollBehavior.this.d = null;
        }
    }
}
