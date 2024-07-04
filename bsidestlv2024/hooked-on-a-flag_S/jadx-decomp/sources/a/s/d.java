package a.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class d extends g0 {
    public d(int fadingMode) {
        i0(fadingMode);
    }

    @Override // a.s.g0, a.s.k
    public void j(q transitionValues) {
        super.j(transitionValues);
        transitionValues.f734a.put("android:fade:transitionAlpha", Float.valueOf(y.b(transitionValues.f735b)));
    }

    public final Animator j0(View view, float startAlpha, float endAlpha) {
        if (startAlpha == endAlpha) {
            return null;
        }
        y.f(view, startAlpha);
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, y.f745b, endAlpha);
        b listener = new b(view);
        anim.addListener(listener);
        a(new a(this, view));
        return anim;
    }

    /* loaded from: classes.dex */
    public class a extends l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f700a;

        public a(d this$0, View view) {
            this.f700a = view;
        }

        @Override // a.s.k.f
        public void c(k transition) {
            y.f(this.f700a, 1.0f);
            y.a(this.f700a);
            transition.P(this);
        }
    }

    @Override // a.s.g0
    public Animator e0(ViewGroup sceneRoot, View view, q startValues, q endValues) {
        float startAlpha = k0(startValues, 0.0f);
        if (startAlpha == 1.0f) {
            startAlpha = 0.0f;
        }
        return j0(view, startAlpha, 1.0f);
    }

    @Override // a.s.g0
    public Animator g0(ViewGroup sceneRoot, View view, q startValues, q endValues) {
        y.d(view);
        float startAlpha = k0(startValues, 1.0f);
        return j0(view, startAlpha, 0.0f);
    }

    public static float k0(q startValues, float fallbackValue) {
        Float startAlphaFloat;
        if (startValues == null || (startAlphaFloat = (Float) startValues.f734a.get("android:fade:transitionAlpha")) == null) {
            return fallbackValue;
        }
        float startAlpha = startAlphaFloat.floatValue();
        return startAlpha;
    }

    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final View f701a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f702b = false;

        public b(View view) {
            this.f701a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            if (a.h.k.v.P(this.f701a) && this.f701a.getLayerType() == 0) {
                this.f702b = true;
                this.f701a.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            y.f(this.f701a, 1.0f);
            if (this.f702b) {
                this.f701a.setLayerType(0, null);
            }
        }
    }
}
