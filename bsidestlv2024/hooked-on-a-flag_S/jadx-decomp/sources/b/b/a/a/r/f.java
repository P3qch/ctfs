package b.b.a.a.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f1065a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public b f1066b = null;
    public ValueAnimator c = null;
    public final Animator.AnimatorListener d = new a();

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            if (fVar.c == animator) {
                fVar.c = null;
            }
        }
    }

    public void a(int[] specs, ValueAnimator animator) {
        b tuple = new b(specs, animator);
        animator.addListener(this.d);
        this.f1065a.add(tuple);
    }

    public void d(int[] state) {
        b match = null;
        int count = this.f1065a.size();
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            }
            b tuple = this.f1065a.get(i);
            if (!StateSet.stateSetMatches(tuple.f1068a, state)) {
                i++;
            } else {
                match = tuple;
                break;
            }
        }
        b bVar = this.f1066b;
        if (match == bVar) {
            return;
        }
        if (bVar != null) {
            b();
        }
        this.f1066b = match;
        if (match != null) {
            e(match);
        }
    }

    public final void e(b match) {
        ValueAnimator valueAnimator = match.f1069b;
        this.c = valueAnimator;
        valueAnimator.start();
    }

    public final void b() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.c = null;
        }
    }

    public void c() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.c = null;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f1068a;

        /* renamed from: b, reason: collision with root package name */
        public final ValueAnimator f1069b;

        public b(int[] specs, ValueAnimator animator) {
            this.f1068a = specs;
            this.f1069b = animator;
        }
    }
}
