package a.k.b;

import a.h.g.b;
import a.k.b.n;
import a.k.b.w;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.app.Fragment;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class f {
    public static d c(Context context, Fragment fragment, boolean enter, boolean isPop) {
        int transit = fragment.B();
        int nextAnim = b(fragment, enter, isPop);
        fragment.l1(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.H;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            fragment.H.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.H;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animation = fragment.k0();
        if (animation != null) {
            return new d(animation);
        }
        Animator animator = fragment.l0();
        if (animator != null) {
            return new d(animator);
        }
        if (nextAnim == 0 && transit != 0) {
            nextAnim = d(transit, enter);
        }
        if (nextAnim != 0) {
            String dir = context.getResources().getResourceTypeName(nextAnim);
            boolean isAnim = "anim".equals(dir);
            boolean successfulLoad = false;
            if (isAnim) {
                try {
                    Animation animation2 = AnimationUtils.loadAnimation(context, nextAnim);
                    if (animation2 != null) {
                        return new d(animation2);
                    }
                    successfulLoad = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException e3) {
                }
            }
            if (!successfulLoad) {
                try {
                    Animator animator2 = AnimatorInflater.loadAnimator(context, nextAnim);
                    if (animator2 != null) {
                        return new d(animator2);
                    }
                } catch (RuntimeException e4) {
                    if (isAnim) {
                        throw e4;
                    }
                    Animation animation3 = AnimationUtils.loadAnimation(context, nextAnim);
                    if (animation3 != null) {
                        return new d(animation3);
                    }
                }
            }
        }
        return null;
    }

    public static int b(Fragment fragment, boolean enter, boolean isPop) {
        if (isPop) {
            if (enter) {
                return fragment.F();
            }
            return fragment.G();
        }
        if (enter) {
            return fragment.r();
        }
        return fragment.u();
    }

    public static void a(Fragment fragment, d anim, w.g callback) {
        View viewToAnimate = fragment.I;
        ViewGroup container = fragment.H;
        container.startViewTransition(viewToAnimate);
        a.h.g.b signal = new a.h.g.b();
        signal.c(new a(fragment));
        ((n.d) callback).b(fragment, signal);
        if (anim.f554a != null) {
            Animation animation = new e(anim.f554a, container, viewToAnimate);
            fragment.k1(fragment.I);
            animation.setAnimationListener(new b(container, fragment, callback, signal));
            fragment.I.startAnimation(animation);
            return;
        }
        Animator animator = anim.f555b;
        fragment.m1(anim.f555b);
        animator.addListener(new c(container, viewToAnimate, fragment, callback, signal));
        animator.setTarget(fragment.I);
        animator.start();
    }

    /* loaded from: classes.dex */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f548a;

        public a(Fragment fragment) {
            this.f548a = fragment;
        }

        @Override // a.h.g.b.a
        public void a() {
            if (this.f548a.m() != null) {
                View v = this.f548a.m();
                this.f548a.k1(null);
                v.clearAnimation();
            }
            this.f548a.m1(null);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f549a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f550b;
        public final /* synthetic */ w.g c;
        public final /* synthetic */ a.h.g.b d;

        public b(ViewGroup viewGroup, Fragment fragment, w.g gVar, a.h.g.b bVar) {
            this.f549a = viewGroup;
            this.f550b = fragment;
            this.c = gVar;
            this.d = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f550b.m() != null) {
                    b.this.f550b.k1(null);
                    b bVar = b.this;
                    ((n.d) bVar.c).a(bVar.f550b, bVar.d);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f549a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f552a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f553b;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ w.g d;
        public final /* synthetic */ a.h.g.b e;

        public c(ViewGroup viewGroup, View view, Fragment fragment, w.g gVar, a.h.g.b bVar) {
            this.f552a = viewGroup;
            this.f553b = view;
            this.c = fragment;
            this.d = gVar;
            this.e = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator anim) {
            this.f552a.endViewTransition(this.f553b);
            Animator animator = this.c.n();
            this.c.m1(null);
            if (animator != null && this.f552a.indexOfChild(this.f553b) < 0) {
                ((n.d) this.d).a(this.c, this.e);
            }
        }
    }

    public static int d(int transit, boolean enter) {
        switch (transit) {
            case 4097:
                int animAttr = enter ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                return animAttr;
            case 4099:
                int animAttr2 = enter ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
                return animAttr2;
            case 8194:
                int animAttr3 = enter ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
                return animAttr3;
            default:
                return -1;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f554a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f555b;

        public d(Animation animation) {
            this.f554a = animation;
            this.f555b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public d(Animator animator) {
            this.f554a = null;
            this.f555b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends AnimationSet implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final ViewGroup f556b;
        public final View c;
        public boolean d;
        public boolean e;
        public boolean f;

        public e(Animation animation, ViewGroup parent, View child) {
            super(false);
            this.f = true;
            this.f556b = parent;
            this.c = child;
            addAnimation(animation);
            parent.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long currentTime, Transformation t) {
            this.f = true;
            if (this.d) {
                return true ^ this.e;
            }
            boolean more = super.getTransformation(currentTime, t);
            if (!more) {
                this.d = true;
                a.h.k.t.a(this.f556b, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long currentTime, Transformation outTransformation, float scale) {
            this.f = true;
            if (this.d) {
                return true ^ this.e;
            }
            boolean more = super.getTransformation(currentTime, outTransformation, scale);
            if (!more) {
                this.d = true;
                a.h.k.t.a(this.f556b, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.d && this.f) {
                this.f = false;
                this.f556b.post(this);
            } else {
                this.f556b.endViewTransition(this.c);
                this.e = true;
            }
        }
    }
}
