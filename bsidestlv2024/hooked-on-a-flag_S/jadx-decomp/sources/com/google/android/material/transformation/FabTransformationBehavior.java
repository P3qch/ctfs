package com.google.android.material.transformation;

import a.h.k.v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.a.a.b.h;
import b.b.a.a.b.i;
import b.b.a.a.b.j;
import b.b.a.a.j.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.R;
import net.sqlcipher.database.SQLiteDatabase;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final Rect c;
    public final RectF d;
    public final RectF e;
    public final int[] f;
    public float g;
    public float h;

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public h f1217a;

        /* renamed from: b, reason: collision with root package name */
        public j f1218b;
    }

    public abstract e e0(Context context, boolean z);

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout parent, View child, View dependency) {
        if (child.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(dependency instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) dependency).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == child.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f lp) {
        if (lp.h == 0) {
            lp.h = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet J(View dependency, View child, boolean expanded, boolean isAnimating) {
        e spec = e0(child.getContext(), expanded);
        if (expanded) {
            this.g = dependency.getTranslationX();
            this.h = dependency.getTranslationY();
        }
        List<Animator> animations = new ArrayList<>();
        List<Animator.AnimatorListener> listeners = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 21) {
            X(dependency, child, expanded, isAnimating, spec, animations);
        }
        RectF childBounds = this.d;
        c0(dependency, child, expanded, isAnimating, spec, animations, childBounds);
        float childWidth = childBounds.width();
        float childHeight = childBounds.height();
        W(dependency, child, expanded, spec, animations);
        Z(dependency, child, expanded, isAnimating, spec, animations, listeners);
        Y(dependency, child, expanded, isAnimating, spec, childWidth, childHeight, animations, listeners);
        V(dependency, child, expanded, isAnimating, spec, animations);
        U(child, expanded, isAnimating, spec, animations);
        AnimatorSet set = new AnimatorSet();
        b.b.a.a.b.b.a(set, animations);
        set.addListener(new a(this, expanded, child, dependency));
        int count = listeners.size();
        for (int i = 0; i < count; i++) {
            set.addListener(listeners.get(i));
        }
        return set;
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1211a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1212b;
        public final /* synthetic */ View c;

        public a(FabTransformationBehavior this$0, boolean z, View view, View view2) {
            this.f1211a = z;
            this.f1212b = view;
            this.c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            if (this.f1211a) {
                this.f1212b.setVisibility(0);
                this.c.setAlpha(0.0f);
                this.c.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (!this.f1211a) {
                this.f1212b.setVisibility(4);
                this.c.setAlpha(1.0f);
                this.c.setVisibility(0);
            }
        }
    }

    @TargetApi(21)
    public final void X(View dependency, View child, boolean expanded, boolean currentlyAnimating, e spec, List list) {
        ObjectAnimator ofFloat;
        float translationZ = v.w(child) - v.w(dependency);
        if (expanded) {
            if (!currentlyAnimating) {
                child.setTranslationZ(-translationZ);
            }
            ofFloat = ObjectAnimator.ofFloat(child, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(child, (Property<View, Float>) View.TRANSLATION_Z, -translationZ);
        }
        i timing = spec.f1217a.e("elevation");
        timing.a(ofFloat);
        list.add(ofFloat);
    }

    public final void W(View dependency, View child, boolean expanded, e spec, List<Animator> animations) {
        float translationX = Q(dependency, child, spec.f1218b);
        float translationY = R(dependency, child, spec.f1218b);
        Pair<i, i> N = N(translationX, translationY, expanded, spec);
        i translationXTiming = (i) N.first;
        i translationYTiming = (i) N.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        fArr[0] = expanded ? translationX : this.g;
        ValueAnimator translationXAnimator = ObjectAnimator.ofFloat(dependency, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        fArr2[0] = expanded ? translationY : this.h;
        ValueAnimator translationYAnimator = ObjectAnimator.ofFloat(dependency, (Property<View, Float>) property2, fArr2);
        translationXTiming.a(translationXAnimator);
        translationYTiming.a(translationYAnimator);
        animations.add(translationXAnimator);
        animations.add(translationYAnimator);
    }

    public final void c0(View dependency, View child, boolean expanded, boolean currentlyAnimating, e spec, List list, RectF childBounds) {
        i translationYTiming;
        i translationXTiming;
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float translationX = Q(dependency, child, spec.f1218b);
        float translationY = R(dependency, child, spec.f1218b);
        Pair<i, i> N = N(translationX, translationY, expanded, spec);
        i translationXTiming2 = (i) N.first;
        i translationYTiming2 = (i) N.second;
        if (expanded) {
            if (!currentlyAnimating) {
                child.setTranslationX(-translationX);
                child.setTranslationY(-translationY);
            }
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(child, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(child, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            translationYTiming = translationYTiming2;
            translationXTiming = translationXTiming2;
            L(child, spec, translationXTiming2, translationYTiming2, -translationX, -translationY, 0.0f, 0.0f, childBounds);
            ofFloat = ofFloat3;
            ofFloat2 = ofFloat4;
        } else {
            translationYTiming = translationYTiming2;
            translationXTiming = translationXTiming2;
            ofFloat = ObjectAnimator.ofFloat(child, (Property<View, Float>) View.TRANSLATION_X, -translationX);
            ofFloat2 = ObjectAnimator.ofFloat(child, (Property<View, Float>) View.TRANSLATION_Y, -translationY);
        }
        translationXTiming.a(ofFloat);
        translationYTiming.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z(View dependency, View view, boolean expanded, boolean currentlyAnimating, e spec, List<Animator> animations, List<Animator.AnimatorListener> listeners) {
        ObjectAnimator animator;
        if (!(view instanceof b.b.a.a.j.d) || !(dependency instanceof ImageView)) {
            return;
        }
        b.b.a.a.j.d circularRevealChild = (b.b.a.a.j.d) view;
        ImageView dependencyImageView = (ImageView) dependency;
        Drawable icon = dependencyImageView.getDrawable();
        if (icon == null) {
            return;
        }
        icon.mutate();
        if (expanded) {
            if (!currentlyAnimating) {
                icon.setAlpha(255);
            }
            animator = ObjectAnimator.ofInt(icon, b.b.a.a.b.e.f981a, 0);
        } else {
            animator = ObjectAnimator.ofInt(icon, b.b.a.a.b.e.f981a, 255);
        }
        animator.addUpdateListener(new b(this, view));
        i timing = spec.f1217a.e("iconFade");
        timing.a(animator);
        animations.add(animator);
        listeners.add(new c(this, circularRevealChild, icon));
    }

    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1213a;

        public b(FabTransformationBehavior this$0, View view) {
            this.f1213a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            this.f1213a.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b.b.a.a.j.d f1214a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Drawable f1215b;

        public c(FabTransformationBehavior this$0, b.b.a.a.j.d dVar, Drawable drawable) {
            this.f1214a = dVar;
            this.f1215b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f1214a.setCircularRevealOverlayDrawable(this.f1215b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f1214a.setCircularRevealOverlayDrawable(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(View dependency, View view, boolean expanded, boolean currentlyAnimating, e spec, float childWidth, float childHeight, List<Animator> animations, List<Animator.AnimatorListener> listeners) {
        i timing;
        b.b.a.a.j.d circularRevealChild;
        Animator animator;
        if (!(view instanceof b.b.a.a.j.d)) {
            return;
        }
        b.b.a.a.j.d circularRevealChild2 = (b.b.a.a.j.d) view;
        float revealCenterX = O(dependency, view, spec.f1218b);
        float revealCenterY = P(dependency, view, spec.f1218b);
        ((FloatingActionButton) dependency).h(this.c);
        float dependencyRadius = this.c.width() / 2.0f;
        i timing2 = spec.f1217a.e("expansion");
        if (expanded) {
            if (!currentlyAnimating) {
                circularRevealChild2.setRevealInfo(new d.e(revealCenterX, revealCenterY, dependencyRadius));
            }
            float fromRadius = currentlyAnimating ? circularRevealChild2.getRevealInfo().c : dependencyRadius;
            float toRadius = b.b.a.a.s.a.b(revealCenterX, revealCenterY, 0.0f, 0.0f, childWidth, childHeight);
            Animator animator2 = b.b.a.a.j.a.a(circularRevealChild2, revealCenterX, revealCenterY, toRadius);
            animator2.addListener(new d(this, circularRevealChild2));
            timing = timing2;
            b0(view, timing2.c(), (int) revealCenterX, (int) revealCenterY, fromRadius, animations);
            circularRevealChild = circularRevealChild2;
            animator = animator2;
        } else {
            timing = timing2;
            float fromRadius2 = circularRevealChild2.getRevealInfo().c;
            Animator animator3 = b.b.a.a.j.a.a(circularRevealChild2, revealCenterX, revealCenterY, dependencyRadius);
            b0(view, timing.c(), (int) revealCenterX, (int) revealCenterY, fromRadius2, animations);
            circularRevealChild = circularRevealChild2;
            a0(view, timing.c(), timing.d(), spec.f1217a.f(), (int) revealCenterX, (int) revealCenterY, dependencyRadius, animations);
            animator = animator3;
        }
        timing.a(animator);
        animations.add(animator);
        listeners.add(b.b.a.a.j.a.b(circularRevealChild));
    }

    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b.b.a.a.j.d f1216a;

        public d(FabTransformationBehavior this$0, b.b.a.a.j.d dVar) {
            this.f1216a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            d.e revealInfo = this.f1216a.getRevealInfo();
            revealInfo.c = Float.MAX_VALUE;
            this.f1216a.setRevealInfo(revealInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V(View dependency, View view, boolean expanded, boolean currentlyAnimating, e spec, List list) {
        ObjectAnimator animator;
        if (!(view instanceof b.b.a.a.j.d)) {
            return;
        }
        b.b.a.a.j.d circularRevealChild = (b.b.a.a.j.d) view;
        int tint = d0(dependency);
        int transparent = 16777215 & tint;
        if (expanded) {
            if (!currentlyAnimating) {
                circularRevealChild.setCircularRevealScrimColor(tint);
            }
            animator = ObjectAnimator.ofInt(circularRevealChild, d.C0067d.f1012a, transparent);
        } else {
            animator = ObjectAnimator.ofInt(circularRevealChild, d.C0067d.f1012a, tint);
        }
        animator.setEvaluator(b.b.a.a.b.c.b());
        i timing = spec.f1217a.e("color");
        timing.a(animator);
        list.add(animator);
    }

    public final void U(View child, boolean expanded, boolean currentlyAnimating, e spec, List list) {
        ViewGroup childContentContainer;
        ObjectAnimator ofFloat;
        if (!(child instanceof ViewGroup)) {
            return;
        }
        if (((child instanceof b.b.a.a.j.d) && b.b.a.a.j.c.f1008a == 0) || (childContentContainer = K(child)) == null) {
            return;
        }
        if (expanded) {
            if (!currentlyAnimating) {
                b.b.a.a.b.d.f980a.set(childContentContainer, Float.valueOf(0.0f));
            }
            ofFloat = ObjectAnimator.ofFloat(childContentContainer, b.b.a.a.b.d.f980a, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(childContentContainer, b.b.a.a.b.d.f980a, 0.0f);
        }
        i timing = spec.f1217a.e("contentFade");
        timing.a(ofFloat);
        list.add(ofFloat);
    }

    public final Pair<i, i> N(float translationX, float translationY, boolean expanded, e spec) {
        i translationXTiming;
        i translationYTiming;
        if (translationX == 0.0f || translationY == 0.0f) {
            translationXTiming = spec.f1217a.e("translationXLinear");
            translationYTiming = spec.f1217a.e("translationYLinear");
        } else if ((expanded && translationY < 0.0f) || (!expanded && translationY > 0.0f)) {
            translationXTiming = spec.f1217a.e("translationXCurveUpwards");
            translationYTiming = spec.f1217a.e("translationYCurveUpwards");
        } else {
            translationXTiming = spec.f1217a.e("translationXCurveDownwards");
            translationYTiming = spec.f1217a.e("translationYCurveDownwards");
        }
        return new Pair<>(translationXTiming, translationYTiming);
    }

    public final float Q(View dependency, View child, j positioning) {
        RectF dependencyBounds = this.d;
        RectF childBounds = this.e;
        M(dependency, dependencyBounds);
        T(child, childBounds);
        float translationX = 0.0f;
        switch (positioning.f990a & 7) {
            case 1:
                translationX = childBounds.centerX() - dependencyBounds.centerX();
                break;
            case 3:
                translationX = childBounds.left - dependencyBounds.left;
                break;
            case 5:
                translationX = childBounds.right - dependencyBounds.right;
                break;
        }
        return translationX + positioning.f991b;
    }

    public final float R(View dependency, View child, j positioning) {
        RectF dependencyBounds = this.d;
        RectF childBounds = this.e;
        M(dependency, dependencyBounds);
        T(child, childBounds);
        float translationY = 0.0f;
        switch (positioning.f990a & 112) {
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                translationY = childBounds.centerY() - dependencyBounds.centerY();
                break;
            case 48:
                translationY = childBounds.top - dependencyBounds.top;
                break;
            case 80:
                translationY = childBounds.bottom - dependencyBounds.bottom;
                break;
        }
        return translationY + positioning.c;
    }

    public final void T(View view, RectF rect) {
        rect.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] windowLocation = this.f;
        view.getLocationInWindow(windowLocation);
        rect.offsetTo(windowLocation[0], windowLocation[1]);
        rect.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final void M(View view, RectF rect) {
        T(view, rect);
        rect.offset(this.g, this.h);
    }

    public final float O(View dependency, View child, j positioning) {
        RectF dependencyBounds = this.d;
        RectF childBounds = this.e;
        M(dependency, dependencyBounds);
        T(child, childBounds);
        float translationX = Q(dependency, child, positioning);
        childBounds.offset(-translationX, 0.0f);
        return dependencyBounds.centerX() - childBounds.left;
    }

    public final float P(View dependency, View child, j positioning) {
        RectF dependencyBounds = this.d;
        RectF childBounds = this.e;
        M(dependency, dependencyBounds);
        T(child, childBounds);
        float translationY = R(dependency, child, positioning);
        childBounds.offset(0.0f, -translationY);
        return dependencyBounds.centerY() - childBounds.top;
    }

    public final void L(View child, e spec, i translationXTiming, i translationYTiming, float fromX, float fromY, float toX, float toY, RectF childBounds) {
        float translationX = S(spec, translationXTiming, fromX, toX);
        float translationY = S(spec, translationYTiming, fromY, toY);
        Rect window = this.c;
        child.getWindowVisibleDisplayFrame(window);
        RectF windowF = this.d;
        windowF.set(window);
        RectF childVisibleBounds = this.e;
        T(child, childVisibleBounds);
        childVisibleBounds.offset(translationX, translationY);
        childVisibleBounds.intersect(windowF);
        childBounds.set(childVisibleBounds);
    }

    public final float S(e spec, i timing, float from, float to) {
        long delay = timing.c();
        long duration = timing.d();
        i expansionTiming = spec.f1217a.e("expansion");
        long expansionEnd = expansionTiming.c() + expansionTiming.d();
        float fraction = ((float) ((expansionEnd + 17) - delay)) / ((float) duration);
        return b.b.a.a.b.a.a(from, to, timing.e().getInterpolation(fraction));
    }

    public final ViewGroup K(View view) {
        View childContentContainer = view.findViewById(R.id.mtrl_child_content_container);
        if (childContentContainer != null) {
            return f0(childContentContainer);
        }
        if ((view instanceof b.b.a.a.d0.b) || (view instanceof b.b.a.a.d0.a)) {
            return f0(((ViewGroup) view).getChildAt(0));
        }
        return f0(view);
    }

    public final ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public final int d0(View view) {
        ColorStateList tintList = v.s(view);
        if (tintList != null) {
            return tintList.getColorForState(view.getDrawableState(), tintList.getDefaultColor());
        }
        return 0;
    }

    public final void b0(View child, long delay, int revealCenterX, int revealCenterY, float fromRadius, List<Animator> animations) {
        if (Build.VERSION.SDK_INT >= 21 && delay > 0) {
            Animator animator = ViewAnimationUtils.createCircularReveal(child, revealCenterX, revealCenterY, fromRadius, fromRadius);
            animator.setStartDelay(0L);
            animator.setDuration(delay);
            animations.add(animator);
        }
    }

    public final void a0(View child, long delay, long duration, long totalDuration, int revealCenterX, int revealCenterY, float toRadius, List<Animator> animations) {
        if (Build.VERSION.SDK_INT >= 21 && delay + duration < totalDuration) {
            Animator animator = ViewAnimationUtils.createCircularReveal(child, revealCenterX, revealCenterY, toRadius, toRadius);
            animator.setStartDelay(delay + duration);
            animator.setDuration(totalDuration - (delay + duration));
            animations.add(animator);
        }
    }
}
