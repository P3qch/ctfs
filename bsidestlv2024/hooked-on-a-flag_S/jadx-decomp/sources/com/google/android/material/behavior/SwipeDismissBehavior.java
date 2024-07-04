package com.google.android.material.behavior;

import a.h.k.e0.c;
import a.h.k.e0.f;
import a.h.k.v;
import a.j.b.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public a.j.b.c f1144a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1145b;
    public float c = 0.0f;
    public int d = 2;
    public float e = 0.5f;
    public float f = 0.0f;
    public float g = 0.5f;
    public final c.AbstractC0040c h = new a();

    public void L(int direction) {
        this.d = direction;
    }

    public void K(float fraction) {
        this.f = F(0.0f, fraction, 1.0f);
    }

    public void J(float fraction) {
        this.g = F(0.0f, fraction, 1.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout parent, V child, int layoutDirection) {
        super.l(parent, child, layoutDirection);
        if (v.A(child) == 0) {
            v.x0(child, 1);
            M(child);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout parent, V child, MotionEvent event) {
        boolean dispatchEventToHelper = this.f1145b;
        switch (event.getActionMasked()) {
            case 0:
                this.f1145b = parent.B(child, (int) event.getX(), (int) event.getY());
                dispatchEventToHelper = this.f1145b;
                break;
            case 1:
            case 3:
                this.f1145b = false;
                break;
        }
        if (!dispatchEventToHelper) {
            return false;
        }
        H(parent);
        return this.f1144a.F(event);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout parent, V child, MotionEvent event) {
        a.j.b.c cVar = this.f1144a;
        if (cVar != null) {
            cVar.y(event);
            return true;
        }
        return false;
    }

    public boolean E(View view) {
        return true;
    }

    /* loaded from: classes.dex */
    public class a extends c.AbstractC0040c {

        /* renamed from: a, reason: collision with root package name */
        public int f1146a;

        /* renamed from: b, reason: collision with root package name */
        public int f1147b = -1;

        public a() {
        }

        @Override // a.j.b.c.AbstractC0040c
        public boolean m(View child, int pointerId) {
            int i = this.f1147b;
            return (i == -1 || i == pointerId) && SwipeDismissBehavior.this.E(child);
        }

        @Override // a.j.b.c.AbstractC0040c
        public void i(View capturedChild, int activePointerId) {
            this.f1147b = activePointerId;
            this.f1146a = capturedChild.getLeft();
            ViewParent parent = capturedChild.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // a.j.b.c.AbstractC0040c
        public void j(int state) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // a.j.b.c.AbstractC0040c
        public void l(View child, float xvel, float yvel) {
            int targetLeft;
            this.f1147b = -1;
            int childWidth = child.getWidth();
            boolean dismiss = false;
            if (n(child, xvel)) {
                int left = child.getLeft();
                int i = this.f1146a;
                targetLeft = left < i ? i - childWidth : i + childWidth;
                dismiss = true;
            } else {
                targetLeft = this.f1146a;
            }
            if (SwipeDismissBehavior.this.f1144a.E(targetLeft, child.getTop())) {
                v.g0(child, new c(child, dismiss));
            } else if (dismiss) {
                SwipeDismissBehavior.this.getClass();
            }
        }

        public final boolean n(View child, float xvel) {
            if (xvel != 0.0f) {
                boolean isRtl = v.C(child) == 1;
                int i = SwipeDismissBehavior.this.d;
                if (i == 2) {
                    return true;
                }
                if (i == 0) {
                    if (isRtl) {
                        if (xvel >= 0.0f) {
                            return false;
                        }
                    } else if (xvel <= 0.0f) {
                        return false;
                    }
                    return true;
                }
                if (i != 1) {
                    return false;
                }
                if (isRtl) {
                    if (xvel <= 0.0f) {
                        return false;
                    }
                } else if (xvel >= 0.0f) {
                    return false;
                }
                return true;
            }
            int distance = child.getLeft() - this.f1146a;
            int thresholdDistance = Math.round(child.getWidth() * SwipeDismissBehavior.this.e);
            return Math.abs(distance) >= thresholdDistance;
        }

        @Override // a.j.b.c.AbstractC0040c
        public int d(View child) {
            return child.getWidth();
        }

        @Override // a.j.b.c.AbstractC0040c
        public int a(View child, int left, int dx) {
            int min;
            int max;
            boolean isRtl = v.C(child) == 1;
            int max2 = SwipeDismissBehavior.this.d;
            if (max2 == 0) {
                if (isRtl) {
                    min = this.f1146a - child.getWidth();
                    max = this.f1146a;
                } else {
                    min = this.f1146a;
                    max = this.f1146a + child.getWidth();
                }
            } else if (max2 == 1) {
                if (isRtl) {
                    min = this.f1146a;
                    max = this.f1146a + child.getWidth();
                } else {
                    int min2 = this.f1146a;
                    min = min2 - child.getWidth();
                    max = this.f1146a;
                }
            } else {
                int min3 = this.f1146a;
                min = min3 - child.getWidth();
                max = this.f1146a + child.getWidth();
            }
            return SwipeDismissBehavior.G(min, left, max);
        }

        @Override // a.j.b.c.AbstractC0040c
        public int b(View child, int top, int dy) {
            return child.getTop();
        }

        @Override // a.j.b.c.AbstractC0040c
        public void k(View child, int left, int top, int dx, int dy) {
            float startAlphaDistance = this.f1146a + (child.getWidth() * SwipeDismissBehavior.this.f);
            float endAlphaDistance = this.f1146a + (child.getWidth() * SwipeDismissBehavior.this.g);
            if (left <= startAlphaDistance) {
                child.setAlpha(1.0f);
            } else if (left >= endAlphaDistance) {
                child.setAlpha(0.0f);
            } else {
                float distance = SwipeDismissBehavior.I(startAlphaDistance, endAlphaDistance, left);
                child.setAlpha(SwipeDismissBehavior.F(0.0f, 1.0f - distance, 1.0f));
            }
        }
    }

    public final void H(ViewGroup parent) {
        if (this.f1144a == null) {
            this.f1144a = a.j.b.c.l(parent, this.h);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final View f1149b;
        public final boolean c;

        /* JADX WARN: Generic types in debug info not equals: com.google.android.material.behavior.SwipeDismissBehavior$c != com.google.android.material.behavior.SwipeDismissBehavior<V>$SettleRunnable */
        public c(View view, boolean dismiss) {
            this.f1149b = view;
            this.c = dismiss;
        }

        /* JADX WARN: Generic types in debug info not equals: com.google.android.material.behavior.SwipeDismissBehavior$c != com.google.android.material.behavior.SwipeDismissBehavior<V>$SettleRunnable */
        @Override // java.lang.Runnable
        public void run() {
            a.j.b.c cVar = SwipeDismissBehavior.this.f1144a;
            if (cVar != null && cVar.k(true)) {
                v.g0(this.f1149b, this);
            } else if (this.c) {
                SwipeDismissBehavior.this.getClass();
            }
        }
    }

    public final void M(View child) {
        v.i0(child, 1048576);
        if (E(child)) {
            v.k0(child, c.a.f, null, new b());
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public b() {
        }

        @Override // a.h.k.e0.f
        public boolean a(View view, f.a arguments) {
            boolean dismissToLeft = false;
            if (!SwipeDismissBehavior.this.E(view)) {
                return false;
            }
            boolean isRtl = v.C(view) == 1;
            int i = SwipeDismissBehavior.this.d;
            if ((i == 0 && isRtl) || (i == 1 && !isRtl)) {
                dismissToLeft = true;
            }
            int offset = view.getWidth();
            if (dismissToLeft) {
                offset = -offset;
            }
            v.Y(view, offset);
            view.setAlpha(0.0f);
            SwipeDismissBehavior.this.getClass();
            return true;
        }
    }

    public static float F(float min, float value, float max) {
        return Math.min(Math.max(min, value), max);
    }

    public static int G(int min, int value, int max) {
        return Math.min(Math.max(min, value), max);
    }

    public static float I(float startValue, float endValue, float value) {
        return (value - startValue) / (endValue - startValue);
    }
}
