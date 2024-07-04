package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b, reason: collision with root package name */
    public AnimatorSet f1209b;

    public abstract AnimatorSet J(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean H(View dependency, View child, boolean expanded, boolean animated) {
        AnimatorSet animatorSet = this.f1209b;
        boolean currentlyAnimating = animatorSet != null;
        if (currentlyAnimating) {
            animatorSet.cancel();
        }
        AnimatorSet J = J(dependency, child, expanded, currentlyAnimating);
        this.f1209b = J;
        J.addListener(new a());
        this.f1209b.start();
        if (!animated) {
            this.f1209b.end();
        }
        return true;
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ExpandableTransformationBehavior.this.f1209b = null;
        }
    }
}
