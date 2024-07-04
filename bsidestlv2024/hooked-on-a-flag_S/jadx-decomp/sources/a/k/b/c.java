package a.k.b;

import a.e.f;
import a.h.g.b;
import a.k.b.b0;
import a.k.b.f;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class c extends b0 {
    public c(ViewGroup container) {
        super(container);
    }

    @Override // a.k.b.b0
    public void f(List<b0.d> list, boolean isPop) {
        b0.d firstOut = null;
        b0.d lastIn = null;
        for (b0.d operation : list) {
            b0.d.c currentState = b0.d.c.c(operation.f().I);
            switch (operation.e()) {
                case REMOVED:
                case GONE:
                case INVISIBLE:
                    if (currentState == b0.d.c.VISIBLE && firstOut == null) {
                        firstOut = operation;
                        break;
                    }
                    break;
                case VISIBLE:
                    if (currentState != b0.d.c.VISIBLE) {
                        lastIn = operation;
                        break;
                    } else {
                        break;
                    }
            }
        }
        List<DefaultSpecialEffectsController.AnimationInfo> animations = new ArrayList<>();
        List<DefaultSpecialEffectsController.TransitionInfo> transitions = new ArrayList<>();
        List<SpecialEffectsController.Operation> awaitingContainerChanges = new ArrayList<>(list);
        Iterator<b0.d> it = list.iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                b0.d operation2 = it.next();
                a.h.g.b animCancellationSignal = new a.h.g.b();
                operation2.j(animCancellationSignal);
                animations.add(new j(operation2, animCancellationSignal, isPop));
                a.h.g.b transitionCancellationSignal = new a.h.g.b();
                operation2.j(transitionCancellationSignal);
                if (isPop) {
                    if (operation2 == firstOut) {
                        transitions.add(new l(operation2, transitionCancellationSignal, isPop, z));
                        operation2.a(new a(awaitingContainerChanges, operation2));
                    }
                    z = false;
                    transitions.add(new l(operation2, transitionCancellationSignal, isPop, z));
                    operation2.a(new a(awaitingContainerChanges, operation2));
                } else {
                    if (operation2 == lastIn) {
                        transitions.add(new l(operation2, transitionCancellationSignal, isPop, z));
                        operation2.a(new a(awaitingContainerChanges, operation2));
                    }
                    z = false;
                    transitions.add(new l(operation2, transitionCancellationSignal, isPop, z));
                    operation2.a(new a(awaitingContainerChanges, operation2));
                }
            } else {
                Map<b0.d, Boolean> x = x(transitions, awaitingContainerChanges, isPop, firstOut, lastIn);
                boolean startedAnyTransition = x.containsValue(true);
                w(animations, awaitingContainerChanges, startedAnyTransition, x);
                Iterator<b0.d> it2 = awaitingContainerChanges.iterator();
                while (it2.hasNext()) {
                    s(it2.next());
                }
                awaitingContainerChanges.clear();
                return;
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f525b;
        public final /* synthetic */ b0.d c;

        public a(List list, b0.d dVar) {
            this.f525b = list;
            this.c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f525b.contains(this.c)) {
                this.f525b.remove(this.c);
                c.this.s(this.c);
            }
        }
    }

    public final void w(List<j> list, List<b0.d> list2, boolean startedAnyTransition, Map<b0.d, Boolean> map) {
        ViewGroup container = m();
        Context context = container.getContext();
        ArrayList<DefaultSpecialEffectsController.AnimationInfo> animationsToRun = new ArrayList<>();
        boolean startedAnyAnimator = false;
        Iterator<j> it = list.iterator();
        while (it.hasNext()) {
            j animationInfo = it.next();
            if (animationInfo.d()) {
                animationInfo.a();
            } else {
                f.d anim = animationInfo.e(context);
                if (anim == null) {
                    animationInfo.a();
                } else {
                    Animator animator = anim.f555b;
                    if (animator == null) {
                        animationsToRun.add(animationInfo);
                    } else {
                        b0.d operation = animationInfo.b();
                        Fragment fragment = operation.f();
                        boolean startedTransition = Boolean.TRUE.equals(map.get(operation));
                        if (startedTransition) {
                            if (n.A0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo.a();
                        } else {
                            boolean isHideOperation = operation.e() == b0.d.c.GONE;
                            if (isHideOperation) {
                                list2.remove(operation);
                            }
                            View viewToAnimate = fragment.I;
                            container.startViewTransition(viewToAnimate);
                            animator.addListener(new b(this, container, viewToAnimate, isHideOperation, operation, animationInfo));
                            animator.setTarget(viewToAnimate);
                            animator.start();
                            a.h.g.b signal = animationInfo.c();
                            signal.c(new C0041c(this, animator));
                            startedAnyAnimator = true;
                            it = it;
                        }
                    }
                }
            }
        }
        Iterator<DefaultSpecialEffectsController.AnimationInfo> it2 = animationsToRun.iterator();
        while (it2.hasNext()) {
            j animationInfo2 = (j) it2.next();
            b0.d operation2 = animationInfo2.b();
            Fragment fragment2 = operation2.f();
            if (startedAnyTransition) {
                if (n.A0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.a();
            } else if (startedAnyAnimator) {
                if (n.A0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.a();
            } else {
                View viewToAnimate2 = fragment2.I;
                f.d e2 = animationInfo2.e(context);
                a.h.j.i.e(e2);
                Animation animation = e2.f554a;
                a.h.j.i.e(animation);
                Animation anim2 = animation;
                b0.d.c finalState = operation2.e();
                if (finalState != b0.d.c.REMOVED) {
                    viewToAnimate2.startAnimation(anim2);
                    animationInfo2.a();
                } else {
                    container.startViewTransition(viewToAnimate2);
                    Animation animation2 = new f.e(anim2, container, viewToAnimate2);
                    animation2.setAnimationListener(new d(this, container, viewToAnimate2, animationInfo2));
                    viewToAnimate2.startAnimation(animation2);
                }
                a.h.g.b signal2 = animationInfo2.c();
                signal2.c(new e(this, viewToAnimate2, container, animationInfo2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f526a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f527b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ b0.d d;
        public final /* synthetic */ j e;

        public b(c this$0, ViewGroup viewGroup, View view, boolean z, b0.d dVar, j jVar) {
            this.f526a = viewGroup;
            this.f527b = view;
            this.c = z;
            this.d = dVar;
            this.e = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator anim) {
            this.f526a.endViewTransition(this.f527b);
            if (this.c) {
                this.d.e().a(this.f527b);
            }
            this.e.a();
        }
    }

    /* renamed from: a.k.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0041c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator f528a;

        public C0041c(c this$0, Animator animator) {
            this.f528a = animator;
        }

        @Override // a.h.g.b.a
        public void a() {
            this.f528a.end();
        }
    }

    /* loaded from: classes.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f529a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f530b;
        public final /* synthetic */ j c;

        public d(c this$0, ViewGroup viewGroup, View view, j jVar) {
            this.f529a = viewGroup;
            this.f530b = view;
            this.c = jVar;
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
                d dVar = d.this;
                dVar.f529a.endViewTransition(dVar.f530b);
                d.this.c.a();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f529a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f532a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f533b;
        public final /* synthetic */ j c;

        public e(c this$0, View view, ViewGroup viewGroup, j jVar) {
            this.f532a = view;
            this.f533b = viewGroup;
            this.c = jVar;
        }

        @Override // a.h.g.b.a
        public void a() {
            this.f532a.clearAnimation();
            this.f533b.endViewTransition(this.f532a);
            this.c.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:180:0x050f, code lost:
    
        if (r11 == r43) goto L151;
     */
    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0564  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<a.k.b.b0.d, java.lang.Boolean> x(java.util.List<a.k.b.c.l> r39, java.util.List<a.k.b.b0.d> r40, boolean r41, a.k.b.b0.d r42, a.k.b.b0.d r43) {
        /*
            Method dump skipped, instructions count: 1467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.k.b.c.x(java.util.List, java.util.List, boolean, a.k.b.b0$d, a.k.b.b0$d):java.util.Map");
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b0.d f534b;
        public final /* synthetic */ b0.d c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ a.e.a e;

        public f(c this$0, b0.d dVar, b0.d dVar2, boolean z, a.e.a aVar) {
            this.f534b = dVar;
            this.c = dVar2;
            this.d = z;
            this.e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.f(this.f534b.f(), this.c.f(), this.d, this.e, false);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f535b;
        public final /* synthetic */ View c;
        public final /* synthetic */ Rect d;

        public g(c this$0, y yVar, View view, Rect rect) {
            this.f535b = yVar;
            this.c = view;
            this.d = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f535b.k(this.c, this.d);
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f536b;

        public h(c this$0, ArrayList arrayList) {
            this.f536b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.B(this.f536b, 4);
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f537b;

        public i(c this$0, l lVar) {
            this.f537b = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f537b.a();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public void v(a.e.a<String, View> aVar, Collection<String> transitionNames) {
        Iterator<Map.Entry<String, View>> iterator = ((f.b) aVar.entrySet()).iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, View> entry = iterator.next();
            if (!transitionNames.contains(a.h.k.v.L(entry.getValue()))) {
                iterator.remove();
            }
        }
    }

    public void t(ArrayList<View> transitioningViews, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (a.h.k.x.a(viewGroup)) {
                if (!transitioningViews.contains(view)) {
                    transitioningViews.add(viewGroup);
                    return;
                }
                return;
            }
            int count = viewGroup.getChildCount();
            for (int i2 = 0; i2 < count; i2++) {
                View child = viewGroup.getChildAt(i2);
                if (child.getVisibility() == 0) {
                    t(transitioningViews, child);
                }
            }
            return;
        }
        if (!transitioningViews.contains(view)) {
            transitioningViews.add(view);
        }
    }

    public void u(Map<String, View> namedViews, View view) {
        String transitionName = a.h.k.v.L(view);
        if (transitionName != null) {
            namedViews.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int count = viewGroup.getChildCount();
            for (int i2 = 0; i2 < count; i2++) {
                View child = viewGroup.getChildAt(i2);
                if (child.getVisibility() == 0) {
                    u(namedViews, child);
                }
            }
        }
    }

    public void s(b0.d operation) {
        View view = operation.f().I;
        operation.e().a(view);
    }

    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public final b0.d f538a;

        /* renamed from: b, reason: collision with root package name */
        public final a.h.g.b f539b;

        public k(b0.d operation, a.h.g.b signal) {
            this.f538a = operation;
            this.f539b = signal;
        }

        public b0.d b() {
            return this.f538a;
        }

        public a.h.g.b c() {
            return this.f539b;
        }

        public boolean d() {
            b0.d.c cVar;
            b0.d.c currentState = b0.d.c.c(this.f538a.f().I);
            b0.d.c finalState = this.f538a.e();
            return currentState == finalState || !(currentState == (cVar = b0.d.c.VISIBLE) || finalState == cVar);
        }

        public void a() {
            this.f538a.d(this.f539b);
        }
    }

    /* loaded from: classes.dex */
    public static class j extends k {
        public boolean c;
        public boolean d;
        public f.d e;

        public j(b0.d operation, a.h.g.b signal, boolean isPop) {
            super(operation, signal);
            this.d = false;
            this.c = isPop;
        }

        public f.d e(Context context) {
            if (this.d) {
                return this.e;
            }
            f.d c = a.k.b.f.c(context, b().f(), b().e() == b0.d.c.VISIBLE, this.c);
            this.e = c;
            this.d = true;
            return c;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends k {
        public final Object c;
        public final boolean d;
        public final Object e;

        public l(b0.d operation, a.h.g.b signal, boolean isPop, boolean providesSharedElementTransition) {
            super(operation, signal);
            Object obj;
            Object obj2;
            if (operation.e() == b0.d.c.VISIBLE) {
                if (isPop) {
                    obj2 = operation.f().I();
                } else {
                    operation.f().s();
                    obj2 = null;
                }
                this.c = obj2;
                if (isPop) {
                    operation.f().l();
                } else {
                    operation.f().k();
                }
                this.d = true;
            } else {
                if (isPop) {
                    obj = operation.f().K();
                } else {
                    operation.f().v();
                    obj = null;
                }
                this.c = obj;
                this.d = true;
            }
            if (providesSharedElementTransition) {
                if (isPop) {
                    this.e = operation.f().M();
                    return;
                } else {
                    operation.f().L();
                    this.e = null;
                    return;
                }
            }
            this.e = null;
        }

        public Object h() {
            return this.c;
        }

        public boolean j() {
            return this.d;
        }

        public boolean i() {
            return this.e != null;
        }

        public Object g() {
            return this.e;
        }

        public y e() {
            y transitionImpl = f(this.c);
            y sharedElementTransitionImpl = f(this.e);
            if (transitionImpl == null || sharedElementTransitionImpl == null || transitionImpl == sharedElementTransitionImpl) {
                return transitionImpl != null ? transitionImpl : sharedElementTransitionImpl;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.c + " which uses a different Transition  type than its shared element transition " + this.e);
        }

        public final y f(Object transition) {
            if (transition == null) {
                return null;
            }
            y yVar = w.f592b;
            if (yVar != null && yVar.e(transition)) {
                return yVar;
            }
            y yVar2 = w.c;
            if (yVar2 != null && yVar2.e(transition)) {
                return yVar2;
            }
            throw new IllegalArgumentException("Transition " + transition + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
