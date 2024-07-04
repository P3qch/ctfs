package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.a.a.b.b;
import b.b.a.a.b.i;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public final i c;
    public final i d;

    public FabTransformationScrimBehavior() {
        this.c = new i(75L, 150L);
        this.d = new i(0L, 150L);
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.c = new i(75L, 150L);
        this.d = new i(0L, 150L);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof FloatingActionButton;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout parent, View child, MotionEvent ev) {
        super.D(parent, child, ev);
        return false;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet J(View dependency, View child, boolean expanded, boolean isAnimating) {
        List<Animator> animations = new ArrayList<>();
        new ArrayList();
        K(child, expanded, isAnimating, animations);
        AnimatorSet set = new AnimatorSet();
        b.a(set, animations);
        set.addListener(new a(this, expanded, child));
        return set;
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1219a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1220b;

        public a(FabTransformationScrimBehavior this$0, boolean z, View view) {
            this.f1219a = z;
            this.f1220b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            if (this.f1219a) {
                this.f1220b.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (!this.f1219a) {
                this.f1220b.setVisibility(4);
            }
        }
    }

    public final void K(View child, boolean expanded, boolean currentlyAnimating, List list) {
        ObjectAnimator ofFloat;
        i timing = expanded ? this.c : this.d;
        if (expanded) {
            if (!currentlyAnimating) {
                child.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(child, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(child, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        timing.a(ofFloat);
        list.add(ofFloat);
    }
}
