package a.s;

import a.s.a;
import a.s.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public abstract class g0 extends k {
    public static final String[] I = {"android:visibility:visibility", "android:visibility:parent"};
    public int J = 3;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f713a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f714b;
        public int c;
        public int d;
        public ViewGroup e;
        public ViewGroup f;
    }

    public abstract Animator e0(ViewGroup viewGroup, View view, q qVar, q qVar2);

    public abstract Animator g0(ViewGroup viewGroup, View view, q qVar, q qVar2);

    public void i0(int mode) {
        if ((mode & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.J = mode;
    }

    @Override // a.s.k
    public String[] D() {
        return I;
    }

    public final void c0(q transitionValues) {
        int visibility = transitionValues.f735b.getVisibility();
        transitionValues.f734a.put("android:visibility:visibility", Integer.valueOf(visibility));
        transitionValues.f734a.put("android:visibility:parent", transitionValues.f735b.getParent());
        int[] loc = new int[2];
        transitionValues.f735b.getLocationOnScreen(loc);
        transitionValues.f734a.put("android:visibility:screenLocation", loc);
    }

    @Override // a.s.k
    public void j(q transitionValues) {
        c0(transitionValues);
    }

    @Override // a.s.k
    public void g(q transitionValues) {
        c0(transitionValues);
    }

    public final b d0(q startValues, q endValues) {
        b visInfo = new b();
        visInfo.f713a = false;
        visInfo.f714b = false;
        if (startValues != null && startValues.f734a.containsKey("android:visibility:visibility")) {
            visInfo.c = ((Integer) startValues.f734a.get("android:visibility:visibility")).intValue();
            visInfo.e = (ViewGroup) startValues.f734a.get("android:visibility:parent");
        } else {
            visInfo.c = -1;
            visInfo.e = null;
        }
        if (endValues != null && endValues.f734a.containsKey("android:visibility:visibility")) {
            visInfo.d = ((Integer) endValues.f734a.get("android:visibility:visibility")).intValue();
            visInfo.f = (ViewGroup) endValues.f734a.get("android:visibility:parent");
        } else {
            visInfo.d = -1;
            visInfo.f = null;
        }
        if (startValues != null && endValues != null) {
            int i = visInfo.c;
            int i2 = visInfo.d;
            if (i == i2 && visInfo.e == visInfo.f) {
                return visInfo;
            }
            if (i != i2) {
                if (i == 0) {
                    visInfo.f714b = false;
                    visInfo.f713a = true;
                } else if (i2 == 0) {
                    visInfo.f714b = true;
                    visInfo.f713a = true;
                }
            } else if (visInfo.f == null) {
                visInfo.f714b = false;
                visInfo.f713a = true;
            } else if (visInfo.e == null) {
                visInfo.f714b = true;
                visInfo.f713a = true;
            }
        } else if (startValues == null && visInfo.d == 0) {
            visInfo.f714b = true;
            visInfo.f713a = true;
        } else if (endValues == null && visInfo.c == 0) {
            visInfo.f714b = false;
            visInfo.f713a = true;
        }
        return visInfo;
    }

    @Override // a.s.k
    public Animator n(ViewGroup sceneRoot, q startValues, q endValues) {
        b visInfo = d0(startValues, endValues);
        if (!visInfo.f713a) {
            return null;
        }
        if (visInfo.e != null || visInfo.f != null) {
            if (visInfo.f714b) {
                return f0(sceneRoot, startValues, endValues);
            }
            return h0(sceneRoot, startValues, endValues, visInfo.d);
        }
        return null;
    }

    public Animator f0(ViewGroup sceneRoot, q startValues, q endValues) {
        if ((this.J & 1) != 1 || endValues == null) {
            return null;
        }
        if (startValues == null) {
            View endParent = (View) endValues.f735b.getParent();
            q startParentValues = t(endParent, false);
            q endParentValues = E(endParent, false);
            b parentVisibilityInfo = d0(startParentValues, endParentValues);
            if (parentVisibilityInfo.f713a) {
                return null;
            }
        }
        return e0(sceneRoot, endValues.f735b, startValues, endValues);
    }

    public Animator h0(ViewGroup sceneRoot, q startValues, q endValues, int endVisibility) {
        if ((this.J & 2) != 2 || startValues == null) {
            return null;
        }
        View startView = startValues.f735b;
        View endView = endValues != null ? endValues.f735b : null;
        View overlayView = null;
        View viewToKeep = null;
        boolean reusingOverlayView = false;
        View savedOverlayView = (View) startView.getTag(R.id.save_overlay_view);
        if (savedOverlayView != null) {
            overlayView = savedOverlayView;
            reusingOverlayView = true;
        } else {
            boolean needOverlayForStartView = false;
            if (endView == null || endView.getParent() == null) {
                if (endView != null) {
                    overlayView = endView;
                } else {
                    needOverlayForStartView = true;
                }
            } else if (endVisibility == 4) {
                viewToKeep = endView;
            } else if (startView == endView) {
                viewToKeep = endView;
            } else {
                needOverlayForStartView = true;
            }
            if (needOverlayForStartView) {
                if (startView.getParent() == null) {
                    overlayView = startView;
                } else if (startView.getParent() instanceof View) {
                    View startParent = (View) startView.getParent();
                    q startParentValues = E(startParent, true);
                    q endParentValues = t(startParent, true);
                    b parentVisibilityInfo = d0(startParentValues, endParentValues);
                    if (!parentVisibilityInfo.f713a) {
                        overlayView = p.a(sceneRoot, startView, startParent);
                    } else {
                        int id = startParent.getId();
                        if (startParent.getParent() != null || id == -1 || sceneRoot.findViewById(id) != null) {
                        }
                    }
                }
            }
        }
        if (overlayView != null) {
            if (!reusingOverlayView) {
                int[] screenLoc = (int[]) startValues.f734a.get("android:visibility:screenLocation");
                int screenX = screenLoc[0];
                int screenY = screenLoc[1];
                int[] loc = new int[2];
                sceneRoot.getLocationOnScreen(loc);
                overlayView.offsetLeftAndRight((screenX - loc[0]) - overlayView.getLeft());
                overlayView.offsetTopAndBottom((screenY - loc[1]) - overlayView.getTop());
                v.a(sceneRoot).b(overlayView);
            }
            Animator animator = g0(sceneRoot, overlayView, startValues, endValues);
            if (!reusingOverlayView) {
                if (animator == null) {
                    v.a(sceneRoot).a(overlayView);
                } else {
                    startView.setTag(R.id.save_overlay_view, overlayView);
                    View finalOverlayView = overlayView;
                    a(new f0(this, sceneRoot, finalOverlayView, startView));
                }
            }
            return animator;
        }
        if (viewToKeep != null) {
            int originalVisibility = viewToKeep.getVisibility();
            y.g(viewToKeep, 0);
            Animator animator2 = g0(sceneRoot, viewToKeep, startValues, endValues);
            if (animator2 != null) {
                a disappearListener = new a(viewToKeep, endVisibility, true);
                animator2.addListener(disappearListener);
                a.s.a.a(animator2, disappearListener);
                a(disappearListener);
            } else {
                y.g(viewToKeep, originalVisibility);
            }
            return animator2;
        }
        return null;
    }

    @Override // a.s.k
    public boolean F(q startValues, q newValues) {
        if (startValues == null && newValues == null) {
            return false;
        }
        if (startValues != null && newValues != null && newValues.f734a.containsKey("android:visibility:visibility") != startValues.f734a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b changeInfo = d0(startValues, newValues);
        if (changeInfo.f713a) {
            return changeInfo.c == 0 || changeInfo.d == 0;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements k.f, a.InterfaceC0050a {

        /* renamed from: a, reason: collision with root package name */
        public final View f711a;

        /* renamed from: b, reason: collision with root package name */
        public final int f712b;
        public final ViewGroup c;
        public final boolean d;
        public boolean e;
        public boolean f = false;

        public a(View view, int finalVisibility, boolean suppressLayout) {
            this.f711a = view;
            this.f712b = finalVisibility;
            this.c = (ViewGroup) view.getParent();
            this.d = suppressLayout;
            g(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.s.a.InterfaceC0050a
        public void onAnimationPause(Animator animation) {
            if (!this.f) {
                y.g(this.f711a, this.f712b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.s.a.InterfaceC0050a
        public void onAnimationResume(Animator animation) {
            if (!this.f) {
                y.g(this.f711a, 0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            f();
        }

        @Override // a.s.k.f
        public void a(k transition) {
        }

        @Override // a.s.k.f
        public void c(k transition) {
            f();
            transition.P(this);
        }

        @Override // a.s.k.f
        public void b(k transition) {
        }

        @Override // a.s.k.f
        public void d(k transition) {
            g(false);
        }

        @Override // a.s.k.f
        public void e(k transition) {
            g(true);
        }

        public final void f() {
            if (!this.f) {
                y.g(this.f711a, this.f712b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean suppress) {
            ViewGroup viewGroup;
            if (this.d && this.e != suppress && (viewGroup = this.c) != null) {
                this.e = suppress;
                v.c(viewGroup, suppress);
            }
        }
    }
}
