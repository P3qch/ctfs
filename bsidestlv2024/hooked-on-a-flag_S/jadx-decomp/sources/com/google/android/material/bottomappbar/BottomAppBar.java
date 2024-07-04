package com.google.android.material.bottomappbar;

import a.h.k.v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.a.a.r.l;
import b.b.a.a.x.g;
import b.b.a.a.x.h;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public Animator O;
    public Animator P;
    public int Q;
    public int R;
    public boolean S;
    public int T;
    public int U;
    public boolean V;
    public Behavior W;

    public static /* synthetic */ boolean O(BottomAppBar x0, boolean x1) {
        x0.getClass();
        return x1;
    }

    public static /* synthetic */ void P(BottomAppBar x0) {
        x0.p0();
        throw null;
    }

    public int getFabAlignmentMode() {
        return this.Q;
    }

    public void setFabAlignmentMode(int fabAlignmentMode) {
        q0(fabAlignmentMode, 0);
    }

    public void q0(int fabAlignmentMode, int newMenu) {
        this.U = newMenu;
        l0(fabAlignmentMode, this.V);
        m0(fabAlignmentMode);
        this.Q = fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.R;
    }

    public void setFabAnimationMode(int fabAnimationMode) {
        this.R = fabAnimationMode;
    }

    public void setBackgroundTint(ColorStateList backgroundTint) {
        a.h.d.l.a.o(null, backgroundTint);
    }

    public ColorStateList getBackgroundTint() {
        g gVar = null;
        gVar.D();
        throw null;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().e();
    }

    public void setFabCradleMargin(float cradleMargin) {
        if (cradleMargin != getFabCradleMargin()) {
            getTopEdgeTreatment().i(cradleMargin);
            Drawable drawable = null;
            drawable.invalidateSelf();
            throw null;
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f();
    }

    public void setFabCradleRoundedCornerRadius(float roundedCornerRadius) {
        if (roundedCornerRadius != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().j(roundedCornerRadius);
            Drawable drawable = null;
            drawable.invalidateSelf();
            throw null;
        }
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public void setCradleVerticalOffset(float verticalOffset) {
        if (verticalOffset != getCradleVerticalOffset()) {
            getTopEdgeTreatment().g(verticalOffset);
            Drawable drawable = null;
            drawable.invalidateSelf();
            throw null;
        }
    }

    public boolean getHideOnScroll() {
        return this.S;
    }

    public void setHideOnScroll(boolean hide) {
        this.S = hide;
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        g gVar = null;
        gVar.U(elevation);
        throw null;
    }

    public void n0(int newMenu) {
        if (newMenu != 0) {
            this.U = 0;
            getMenu().clear();
            x(newMenu);
        }
    }

    public final void f0() {
        int i = this.T;
        this.T = i + 1;
        if (i == 0) {
        }
    }

    public final void e0() {
        int i = this.T - 1;
        this.T = i;
        if (i == 0) {
        }
    }

    public void setFabCornerSize(float radius) {
        if (radius != getTopEdgeTreatment().d()) {
            getTopEdgeTreatment().h(radius);
            Drawable drawable = null;
            drawable.invalidateSelf();
            throw null;
        }
    }

    public final void m0(int targetMode) {
        if (this.Q == targetMode || !v.T(this)) {
            return;
        }
        Animator animator = this.O;
        if (animator != null) {
            animator.cancel();
        }
        List<Animator> animators = new ArrayList<>();
        if (this.R == 1) {
            c0(targetMode, animators);
        } else {
            b0(targetMode);
        }
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animators);
        this.O = set;
        set.addListener(new a());
        this.O.start();
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            BottomAppBar.this.f0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            BottomAppBar.this.e0();
            BottomAppBar.this.O = null;
        }
    }

    public final FloatingActionButton g0() {
        View view = h0();
        if (view instanceof FloatingActionButton) {
            return (FloatingActionButton) view;
        }
        return null;
    }

    public final View h0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        List<View> dependents = ((CoordinatorLayout) getParent()).s(this);
        for (View v : dependents) {
            if ((v instanceof FloatingActionButton) || (v instanceof ExtendedFloatingActionButton)) {
                return v;
            }
        }
        return null;
    }

    public final boolean k0() {
        FloatingActionButton fab = g0();
        return fab != null && fab.n();
    }

    public void b0(int targetMode) {
        FloatingActionButton fab = g0();
        if (fab == null || fab.m()) {
            return;
        }
        f0();
        fab.k(new b.b.a.a.d.a(this, targetMode));
    }

    public final void c0(int targetMode, List<Animator> animators) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(g0(), "translationX", j0(targetMode));
        animator.setDuration(300L);
        animators.add(animator);
    }

    public final void l0(int targetMode, boolean newFabAttached) {
        if (!v.T(this)) {
            n0(this.U);
            return;
        }
        Animator animator = this.P;
        if (animator != null) {
            animator.cancel();
        }
        List<Animator> animators = new ArrayList<>();
        if (!k0()) {
            targetMode = 0;
            newFabAttached = false;
        }
        d0(targetMode, newFabAttached, animators);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animators);
        this.P = set;
        set.addListener(new b());
        this.P.start();
    }

    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            BottomAppBar.this.f0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            BottomAppBar.this.e0();
            BottomAppBar.O(BottomAppBar.this, false);
            BottomAppBar.this.P = null;
        }
    }

    public final void d0(int targetMode, boolean targetAttached, List<Animator> animators) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator fadeIn = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        float translationXDifference = actionMenuView.getTranslationX() - i0(actionMenuView, targetMode, targetAttached);
        if (Math.abs(translationXDifference) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                animators.add(fadeIn);
            }
        } else {
            Animator fadeOut = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            fadeOut.addListener(new c(actionMenuView, targetMode, targetAttached));
            AnimatorSet set = new AnimatorSet();
            set.setDuration(150L);
            set.playSequentially(fadeOut, fadeIn);
            animators.add(set);
        }
    }

    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1153a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f1154b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;

        public c(ActionMenuView actionMenuView, int i, boolean z) {
            this.f1154b = actionMenuView;
            this.c = i;
            this.d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.f1153a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (!this.f1153a) {
                boolean replaced = BottomAppBar.this.U != 0;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.n0(bottomAppBar.U);
                BottomAppBar.this.s0(this.f1154b, this.c, this.d, replaced);
            }
        }
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().c();
    }

    public final float j0(int fabAlignmentMode) {
        boolean isRtl = l.d(this);
        if (fabAlignmentMode == 1) {
            int totalEndInset = 0 + 0;
            return ((getMeasuredWidth() / 2) - totalEndInset) * (isRtl ? -1 : 1);
        }
        return 0.0f;
    }

    private float getFabTranslationX() {
        return j0(this.Q);
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof ActionMenuView) {
                return (ActionMenuView) view;
            }
        }
        return null;
    }

    public final void r0(ActionMenuView actionMenuView, int fabAlignmentMode, boolean fabAttached) {
        s0(actionMenuView, fabAlignmentMode, fabAttached, false);
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f1155b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;

        public d(ActionMenuView actionMenuView, int i, boolean z) {
            this.f1155b = actionMenuView;
            this.c = i;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1155b.setTranslationX(BottomAppBar.this.i0(r0, this.c, this.d));
        }
    }

    public final void s0(ActionMenuView actionMenuView, int fabAlignmentMode, boolean fabAttached, boolean shouldWaitForMenuReplacement) {
        Runnable runnable = new d(actionMenuView, fabAlignmentMode, fabAttached);
        if (shouldWaitForMenuReplacement) {
            actionMenuView.post(runnable);
        } else {
            runnable.run();
        }
    }

    public int i0(ActionMenuView actionMenuView, int fabAlignmentMode, boolean fabAttached) {
        int max;
        if (fabAlignmentMode != 1 || !fabAttached) {
            return 0;
        }
        boolean isRtl = l.d(this);
        int toolbarLeftContentEnd = isRtl ? getMeasuredWidth() : 0;
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            boolean isAlignedToStart = (view.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) view.getLayoutParams()).f13a & 8388615) == 8388611;
            if (isAlignedToStart) {
                if (isRtl) {
                    max = Math.min(toolbarLeftContentEnd, view.getLeft());
                } else {
                    max = Math.max(toolbarLeftContentEnd, view.getRight());
                }
                toolbarLeftContentEnd = max;
            }
        }
        int actionMenuViewStart = isRtl ? actionMenuView.getRight() : actionMenuView.getLeft();
        int end = actionMenuViewStart + 0;
        return toolbarLeftContentEnd - end;
    }

    public final void a0() {
        Animator animator = this.P;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.O;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        if (changed) {
            a0();
            p0();
            throw null;
        }
        o0();
    }

    private b.b.a.a.d.b getTopEdgeTreatment() {
        g gVar = null;
        gVar.B();
        throw null;
    }

    public final void p0() {
        getTopEdgeTreatment().k(getFabTranslationX());
        h0();
        g gVar = null;
        gVar.W((this.V && k0()) ? 1.0f : 0.0f);
        throw null;
    }

    public final void o0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.P == null) {
            actionMenuView.setAlpha(1.0f);
            if (!k0()) {
                r0(actionMenuView, 0, false);
            } else {
                r0(actionMenuView, this.Q, this.V);
            }
        }
    }

    public final void Z(FloatingActionButton fab) {
        fab.d(null);
        fab.e(new e());
        fab.f(null);
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            BottomAppBar.this.getClass();
            AnimatorListenerAdapter animatorListenerAdapter = null;
            animatorListenerAdapter.onAnimationStart(animation);
            throw null;
        }
    }

    private int getBottomInset() {
        return 0;
    }

    private int getRightInset() {
        return 0;
    }

    private int getLeftInset() {
        return 0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence title) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence subtitle) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.W == null) {
            this.W = new Behavior();
        }
        return this.W;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, null);
        throw null;
    }

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect e;
        public WeakReference<BottomAppBar> f;
        public int g;
        public final View.OnLayoutChangeListener h;

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            K(coordinatorLayout, (BottomAppBar) view, i);
            return false;
        }

        /* loaded from: classes.dex */
        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                BottomAppBar child = (BottomAppBar) Behavior.this.f.get();
                if (child == null || !(v instanceof FloatingActionButton)) {
                    v.removeOnLayoutChangeListener(this);
                } else {
                    FloatingActionButton fab = (FloatingActionButton) v;
                    fab.i(Behavior.this.e);
                    throw null;
                }
            }
        }

        public Behavior() {
            this.h = new a();
            this.e = new Rect();
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.h = new a();
            this.e = new Rect();
        }

        public boolean K(CoordinatorLayout parent, BottomAppBar child, int layoutDirection) {
            this.f = new WeakReference<>(child);
            View dependentView = child.h0();
            if (dependentView != null && !v.T(dependentView)) {
                CoordinatorLayout.f fabLayoutParams = (CoordinatorLayout.f) dependentView.getLayoutParams();
                fabLayoutParams.d = 49;
                this.g = ((ViewGroup.MarginLayoutParams) fabLayoutParams).bottomMargin;
                if (dependentView instanceof FloatingActionButton) {
                    FloatingActionButton fab = (FloatingActionButton) dependentView;
                    fab.addOnLayoutChangeListener(this.h);
                    child.Z(fab);
                }
                BottomAppBar.P(child);
                throw null;
            }
            parent.I(child, layoutDirection);
            super.l(parent, child, layoutDirection);
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, BottomAppBar child, View directTargetChild, View target, int axes, int type) {
            return child.getHideOnScroll() && super.A(coordinatorLayout, child, directTargetChild, target, axes, type);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        f savedState = new f(superState);
        savedState.d = this.Q;
        savedState.e = this.V;
        return savedState;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof f)) {
            super.onRestoreInstanceState(state);
            return;
        }
        f savedState = (f) state;
        super.onRestoreInstanceState(savedState.j());
        this.Q = savedState.d;
        this.V = savedState.e;
    }

    /* loaded from: classes.dex */
    public static class f extends a.j.a.a {
        public static final Parcelable.Creator<f> CREATOR = new a();
        public int d;
        public boolean e;

        public f(Parcelable superState) {
            super(superState);
        }

        public f(Parcel in, ClassLoader loader) {
            super(in, loader);
            this.d = in.readInt();
            this.e = in.readInt() != 0;
        }

        @Override // a.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e ? 1 : 0);
        }

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<f> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel in, ClassLoader loader) {
                return new f(in, loader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel in) {
                return new f(in, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int size) {
                return new f[size];
            }
        }
    }
}
