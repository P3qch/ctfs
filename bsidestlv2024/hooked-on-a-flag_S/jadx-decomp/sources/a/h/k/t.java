package a.h.k;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class t implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public final View f474b;
    public ViewTreeObserver c;
    public final Runnable d;

    public t(View view, Runnable runnable) {
        this.f474b = view;
        this.c = view.getViewTreeObserver();
        this.d = runnable;
    }

    public static t a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        t listener = new t(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(listener);
        view.addOnAttachStateChangeListener(listener);
        return listener;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.d.run();
        return true;
    }

    public void b() {
        if (this.c.isAlive()) {
            this.c.removeOnPreDrawListener(this);
        } else {
            this.f474b.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f474b.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        this.c = v.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        b();
    }
}
