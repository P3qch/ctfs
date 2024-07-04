package a.k.b;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class x extends y {
    @Override // a.k.b.y
    public boolean e(Object transition) {
        return transition instanceof Transition;
    }

    @Override // a.k.b.y
    public Object g(Object transition) {
        if (transition == null) {
            return null;
        }
        Transition copy = ((Transition) transition).clone();
        return copy;
    }

    @Override // a.k.b.y
    public Object B(Object transition) {
        if (transition == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) transition);
        return transitionSet;
    }

    @Override // a.k.b.y
    public void z(Object transitionObj, View nonExistentView, ArrayList<View> sharedViews) {
        TransitionSet transition = (TransitionSet) transitionObj;
        List<View> views = transition.getTargets();
        views.clear();
        int count = sharedViews.size();
        for (int i = 0; i < count; i++) {
            View view = sharedViews.get(i);
            y.d(views, view);
        }
        views.add(nonExistentView);
        sharedViews.add(nonExistentView);
        b(transition, sharedViews);
    }

    @Override // a.k.b.y
    public void v(Object transitionObj, View view) {
        if (view != null) {
            Transition transition = (Transition) transitionObj;
            Rect epicenter = new Rect();
            k(view, epicenter);
            transition.setEpicenterCallback(new a(this, epicenter));
        }
    }

    /* loaded from: classes.dex */
    public class a extends Transition.EpicenterCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f601a;

        public a(x this$0, Rect rect) {
            this.f601a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.f601a;
        }
    }

    @Override // a.k.b.y
    public void b(Object transitionObj, ArrayList<View> views) {
        Transition transition = (Transition) transitionObj;
        if (transition == null) {
            return;
        }
        if (transition instanceof TransitionSet) {
            TransitionSet set = (TransitionSet) transition;
            int numTransitions = set.getTransitionCount();
            for (int i = 0; i < numTransitions; i++) {
                Transition child = set.getTransitionAt(i);
                b(child, views);
            }
            return;
        }
        if (!C(transition)) {
            List<View> targets = transition.getTargets();
            if (y.l(targets)) {
                int numViews = views.size();
                for (int i2 = 0; i2 < numViews; i2++) {
                    transition.addTarget(views.get(i2));
                }
            }
        }
    }

    public static boolean C(Transition transition) {
        return (y.l(transition.getTargetIds()) && y.l(transition.getTargetNames()) && y.l(transition.getTargetTypes())) ? false : true;
    }

    @Override // a.k.b.y
    public Object n(Object transition1, Object transition2, Object transition3) {
        TransitionSet transitionSet = new TransitionSet();
        if (transition1 != null) {
            transitionSet.addTransition((Transition) transition1);
        }
        if (transition2 != null) {
            transitionSet.addTransition((Transition) transition2);
        }
        if (transition3 != null) {
            transitionSet.addTransition((Transition) transition3);
        }
        return transitionSet;
    }

    /* loaded from: classes.dex */
    public class b implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f602a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f603b;

        public b(x this$0, View view, ArrayList arrayList) {
            this.f602a = view;
            this.f603b = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f602a.setVisibility(8);
            int numViews = this.f603b.size();
            for (int i = 0; i < numViews; i++) {
                ((View) this.f603b.get(i)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }
    }

    @Override // a.k.b.y
    public void r(Object exitTransitionObj, View fragmentView, ArrayList<View> exitingViews) {
        Transition exitTransition = (Transition) exitTransitionObj;
        exitTransition.addListener(new b(this, fragmentView, exitingViews));
    }

    @Override // a.k.b.y
    public Object m(Object exitTransitionObj, Object enterTransitionObj, Object sharedElementTransitionObj) {
        Transition staggered = null;
        Transition exitTransition = (Transition) exitTransitionObj;
        Transition enterTransition = (Transition) enterTransitionObj;
        Transition sharedElementTransition = (Transition) sharedElementTransitionObj;
        if (exitTransition != null && enterTransition != null) {
            staggered = new TransitionSet().addTransition(exitTransition).addTransition(enterTransition).setOrdering(1);
        } else if (exitTransition != null) {
            staggered = exitTransition;
        } else if (enterTransition != null) {
            staggered = enterTransition;
        }
        if (sharedElementTransition != null) {
            TransitionSet together = new TransitionSet();
            if (staggered != null) {
                together.addTransition(staggered);
            }
            together.addTransition(sharedElementTransition);
            return together;
        }
        return staggered;
    }

    @Override // a.k.b.y
    public void c(ViewGroup sceneRoot, Object transition) {
        TransitionManager.beginDelayedTransition(sceneRoot, (Transition) transition);
    }

    /* loaded from: classes.dex */
    public class c implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f604a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f605b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ ArrayList f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f604a = obj;
            this.f605b = arrayList;
            this.c = obj2;
            this.d = arrayList2;
            this.e = obj3;
            this.f = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.f604a;
            if (obj != null) {
                x.this.q(obj, this.f605b, null);
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                x.this.q(obj2, this.d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                x.this.q(obj3, this.f, null);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }
    }

    @Override // a.k.b.y
    public void t(Object overallTransitionObj, Object enterTransition, ArrayList<View> enteringViews, Object exitTransition, ArrayList<View> exitingViews, Object sharedElementTransition, ArrayList<View> sharedElementsIn) {
        Transition overallTransition = (Transition) overallTransitionObj;
        overallTransition.addListener(new c(enterTransition, enteringViews, exitTransition, exitingViews, sharedElementTransition, sharedElementsIn));
    }

    /* loaded from: classes.dex */
    public class d implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f606a;

        public d(x this$0, Runnable runnable) {
            this.f606a = runnable;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.f606a.run();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }
    }

    @Override // a.k.b.y
    public void w(Fragment outFragment, Object transition, a.h.g.b signal, Runnable transitionCompleteRunnable) {
        ((Transition) transition).addListener(new d(this, transitionCompleteRunnable));
    }

    @Override // a.k.b.y
    public void A(Object sharedElementTransitionObj, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn) {
        TransitionSet sharedElementTransition = (TransitionSet) sharedElementTransitionObj;
        if (sharedElementTransition != null) {
            sharedElementTransition.getTargets().clear();
            sharedElementTransition.getTargets().addAll(sharedElementsIn);
            q(sharedElementTransition, sharedElementsOut, sharedElementsIn);
        }
    }

    @Override // a.k.b.y
    public void q(Object transitionObj, ArrayList<View> oldTargets, ArrayList<View> newTargets) {
        List<View> targets;
        Transition transition = (Transition) transitionObj;
        if (transition instanceof TransitionSet) {
            TransitionSet set = (TransitionSet) transition;
            int numTransitions = set.getTransitionCount();
            for (int i = 0; i < numTransitions; i++) {
                Transition child = set.getTransitionAt(i);
                q(child, oldTargets, newTargets);
            }
            return;
        }
        if (!C(transition) && (targets = transition.getTargets()) != null && targets.size() == oldTargets.size() && targets.containsAll(oldTargets)) {
            int targetCount = newTargets == null ? 0 : newTargets.size();
            for (int i2 = 0; i2 < targetCount; i2++) {
                transition.addTarget(newTargets.get(i2));
            }
            int i3 = oldTargets.size();
            for (int i4 = i3 - 1; i4 >= 0; i4--) {
                transition.removeTarget(oldTargets.get(i4));
            }
        }
    }

    @Override // a.k.b.y
    public void a(Object transitionObj, View view) {
        if (transitionObj != null) {
            Transition transition = (Transition) transitionObj;
            transition.addTarget(view);
        }
    }

    @Override // a.k.b.y
    public void p(Object transitionObj, View view) {
        if (transitionObj != null) {
            Transition transition = (Transition) transitionObj;
            transition.removeTarget(view);
        }
    }

    @Override // a.k.b.y
    public void u(Object transitionObj, Rect epicenter) {
        if (transitionObj != null) {
            Transition transition = (Transition) transitionObj;
            transition.setEpicenterCallback(new e(this, epicenter));
        }
    }

    /* loaded from: classes.dex */
    public class e extends Transition.EpicenterCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f607a;

        public e(x this$0, Rect rect) {
            this.f607a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f607a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f607a;
        }
    }
}
