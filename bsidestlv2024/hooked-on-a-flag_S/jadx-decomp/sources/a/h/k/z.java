package a.h.k;

import a.b.b.m;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<View> f485a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f486b = null;
    public Runnable c = null;
    public int d = -1;

    public z(View view) {
        this.f485a = new WeakReference<>(view);
    }

    public z d(long value) {
        View view = this.f485a.get();
        if (view != null) {
            view.animate().setDuration(value);
        }
        return this;
    }

    public z a(float value) {
        View view = this.f485a.get();
        if (view != null) {
            view.animate().alpha(value);
        }
        return this;
    }

    public z k(float value) {
        View view = this.f485a.get();
        if (view != null) {
            view.animate().translationY(value);
        }
        return this;
    }

    public long c() {
        View view = this.f485a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public z e(Interpolator value) {
        View view = this.f485a.get();
        if (view != null) {
            view.animate().setInterpolator(value);
        }
        return this;
    }

    public z h(long value) {
        View view = this.f485a.get();
        if (view != null) {
            view.animate().setStartDelay(value);
        }
        return this;
    }

    public void b() {
        View view = this.f485a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void j() {
        View view = this.f485a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public z f(a0 listener) {
        View view = this.f485a.get();
        if (view != null) {
            g(view, listener);
        }
        return this;
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f487a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f488b;

        public a(z this$0, a0 a0Var, View view) {
            this.f487a = a0Var;
            this.f488b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.f487a.c(this.f488b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f487a.a(this.f488b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f487a.b(this.f488b);
        }
    }

    public final void g(View view, a0 listener) {
        if (listener != null) {
            view.animate().setListener(new a(this, listener, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public z i(c0 listener) {
        View view = this.f485a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            ValueAnimator.AnimatorUpdateListener wrapped = null;
            if (listener != null) {
                wrapped = new b(this, listener, view);
            }
            view.animate().setUpdateListener(wrapped);
        }
        return this;
    }

    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f489a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f490b;

        public b(z this$0, c0 c0Var, View view) {
            this.f489a = c0Var;
            this.f490b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((m.c) this.f489a).a(this.f490b);
        }
    }
}
