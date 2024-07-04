package b.b.a.a.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import b.b.a.a.j.d;

/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static Animator a(d dVar, float centerX, float centerY, float endRadius) {
        Animator revealInfoAnimator = ObjectAnimator.ofObject(dVar, (Property<d, V>) d.c.f1011a, (TypeEvaluator) d.b.f1009a, (Object[]) new d.e[]{new d.e(centerX, centerY, endRadius)});
        if (Build.VERSION.SDK_INT >= 21) {
            d.e revealInfo = dVar.getRevealInfo();
            if (revealInfo == null) {
                throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
            }
            float startRadius = revealInfo.c;
            Animator circularRevealAnimator = ViewAnimationUtils.createCircularReveal((View) dVar, (int) centerX, (int) centerY, startRadius, endRadius);
            AnimatorSet set = new AnimatorSet();
            set.playTogether(revealInfoAnimator, circularRevealAnimator);
            return set;
        }
        return revealInfoAnimator;
    }

    /* renamed from: b.b.a.a.j.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0066a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f1007a;

        public C0066a(d dVar) {
            this.f1007a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f1007a.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f1007a.a();
        }
    }

    public static Animator.AnimatorListener b(d view) {
        return new C0066a(view);
    }
}
