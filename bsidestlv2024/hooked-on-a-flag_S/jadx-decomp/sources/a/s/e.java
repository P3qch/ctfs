package a.s;

import a.s.k;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class e extends a.k.b.y {
    @Override // a.k.b.y
    public boolean e(Object transition) {
        return transition instanceof k;
    }

    @Override // a.k.b.y
    public Object g(Object transition) {
        if (transition == null) {
            return null;
        }
        k copy = ((k) transition).clone();
        return copy;
    }

    @Override // a.k.b.y
    public Object B(Object transition) {
        if (transition == null) {
            return null;
        }
        o transitionSet = new o();
        transitionSet.e0((k) transition);
        return transitionSet;
    }

    @Override // a.k.b.y
    public void z(Object transitionObj, View nonExistentView, ArrayList<View> sharedViews) {
        o transition = (o) transitionObj;
        List<View> views = transition.C();
        views.clear();
        int count = sharedViews.size();
        for (int i = 0; i < count; i++) {
            View view = sharedViews.get(i);
            a.k.b.y.d(views, view);
        }
        views.add(nonExistentView);
        sharedViews.add(nonExistentView);
        b(transition, sharedViews);
    }

    @Override // a.k.b.y
    public void v(Object transitionObj, View view) {
        if (view != null) {
            k transition = (k) transitionObj;
            Rect epicenter = new Rect();
            k(view, epicenter);
            transition.V(new a(this, epicenter));
        }
    }

    /* loaded from: classes.dex */
    public class a extends k.e {
        public a(e this$0, Rect rect) {
        }
    }

    @Override // a.k.b.y
    public void b(Object transitionObj, ArrayList<View> views) {
        k transition = (k) transitionObj;
        if (transition == null) {
            return;
        }
        if (transition instanceof o) {
            o set = (o) transition;
            int numTransitions = set.h0();
            for (int i = 0; i < numTransitions; i++) {
                k child = set.g0(i);
                b(child, views);
            }
            return;
        }
        if (!C(transition)) {
            List<View> targets = transition.C();
            if (a.k.b.y.l(targets)) {
                int numViews = views.size();
                for (int i2 = 0; i2 < numViews; i2++) {
                    transition.b(views.get(i2));
                }
            }
        }
    }

    public static boolean C(k transition) {
        if (a.k.b.y.l(transition.z())) {
            transition.A();
            if (a.k.b.y.l(null)) {
                transition.B();
                if (a.k.b.y.l(null)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // a.k.b.y
    public Object n(Object transition1, Object transition2, Object transition3) {
        o transitionSet = new o();
        if (transition1 != null) {
            transitionSet.e0((k) transition1);
        }
        if (transition2 != null) {
            transitionSet.e0((k) transition2);
        }
        if (transition3 != null) {
            transitionSet.e0((k) transition3);
        }
        return transitionSet;
    }

    /* loaded from: classes.dex */
    public class b implements k.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f703a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f704b;

        public b(e this$0, View view, ArrayList arrayList) {
            this.f703a = view;
            this.f704b = arrayList;
        }

        @Override // a.s.k.f
        public void a(k transition) {
        }

        @Override // a.s.k.f
        public void c(k transition) {
            transition.P(this);
            this.f703a.setVisibility(8);
            int numViews = this.f704b.size();
            for (int i = 0; i < numViews; i++) {
                ((View) this.f704b.get(i)).setVisibility(0);
            }
        }

        @Override // a.s.k.f
        public void b(k transition) {
        }

        @Override // a.s.k.f
        public void d(k transition) {
        }

        @Override // a.s.k.f
        public void e(k transition) {
        }
    }

    @Override // a.k.b.y
    public void r(Object exitTransitionObj, View fragmentView, ArrayList<View> exitingViews) {
        k exitTransition = (k) exitTransitionObj;
        exitTransition.a(new b(this, fragmentView, exitingViews));
    }

    @Override // a.k.b.y
    public Object m(Object exitTransitionObj, Object enterTransitionObj, Object sharedElementTransitionObj) {
        k staggered = null;
        k exitTransition = (k) exitTransitionObj;
        k enterTransition = (k) enterTransitionObj;
        k sharedElementTransition = (k) sharedElementTransitionObj;
        if (exitTransition != null && enterTransition != null) {
            o oVar = new o();
            oVar.e0(exitTransition);
            oVar.e0(enterTransition);
            staggered = oVar.m0(1);
        } else if (exitTransition != null) {
            staggered = exitTransition;
        } else if (enterTransition != null) {
            staggered = enterTransition;
        }
        if (sharedElementTransition != null) {
            o together = new o();
            if (staggered != null) {
                together.e0(staggered);
            }
            together.e0(sharedElementTransition);
            return together;
        }
        return staggered;
    }

    @Override // a.k.b.y
    public void c(ViewGroup sceneRoot, Object transition) {
        m.a(sceneRoot, (k) transition);
    }

    /* loaded from: classes.dex */
    public class c extends l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f705a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f706b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ ArrayList f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f705a = obj;
            this.f706b = arrayList;
            this.c = obj2;
            this.d = arrayList2;
            this.e = obj3;
            this.f = arrayList3;
        }

        @Override // a.s.l, a.s.k.f
        public void a(k transition) {
            Object obj = this.f705a;
            if (obj != null) {
                e.this.q(obj, this.f706b, null);
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                e.this.q(obj2, this.d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                e.this.q(obj3, this.f, null);
            }
        }

        @Override // a.s.k.f
        public void c(k transition) {
            transition.P(this);
        }
    }

    @Override // a.k.b.y
    public void t(Object overallTransitionObj, Object enterTransition, ArrayList<View> enteringViews, Object exitTransition, ArrayList<View> exitingViews, Object sharedElementTransition, ArrayList<View> sharedElementsIn) {
        k overallTransition = (k) overallTransitionObj;
        overallTransition.a(new c(enterTransition, enteringViews, exitTransition, exitingViews, sharedElementTransition, sharedElementsIn));
    }

    @Override // a.k.b.y
    public void A(Object sharedElementTransitionObj, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn) {
        o sharedElementTransition = (o) sharedElementTransitionObj;
        if (sharedElementTransition != null) {
            sharedElementTransition.C().clear();
            sharedElementTransition.C().addAll(sharedElementsIn);
            q(sharedElementTransition, sharedElementsOut, sharedElementsIn);
        }
    }

    @Override // a.k.b.y
    public void q(Object transitionObj, ArrayList<View> oldTargets, ArrayList<View> newTargets) {
        k transition = (k) transitionObj;
        if (transition instanceof o) {
            o set = (o) transition;
            int numTransitions = set.h0();
            for (int i = 0; i < numTransitions; i++) {
                k child = set.g0(i);
                q(child, oldTargets, newTargets);
            }
            return;
        }
        if (!C(transition)) {
            List<View> targets = transition.C();
            if (targets.size() == oldTargets.size() && targets.containsAll(oldTargets)) {
                int targetCount = newTargets == null ? 0 : newTargets.size();
                for (int i2 = 0; i2 < targetCount; i2++) {
                    transition.b(newTargets.get(i2));
                }
                int i3 = oldTargets.size();
                for (int i4 = i3 - 1; i4 >= 0; i4--) {
                    transition.Q(oldTargets.get(i4));
                }
            }
        }
    }

    @Override // a.k.b.y
    public void a(Object transitionObj, View view) {
        if (transitionObj != null) {
            k transition = (k) transitionObj;
            transition.b(view);
        }
    }

    @Override // a.k.b.y
    public void p(Object transitionObj, View view) {
        if (transitionObj != null) {
            k transition = (k) transitionObj;
            transition.Q(view);
        }
    }

    @Override // a.k.b.y
    public void u(Object transitionObj, Rect epicenter) {
        if (transitionObj != null) {
            k transition = (k) transitionObj;
            transition.V(new d(this, epicenter));
        }
    }

    /* loaded from: classes.dex */
    public class d extends k.e {
        public d(e this$0, Rect rect) {
        }
    }
}
