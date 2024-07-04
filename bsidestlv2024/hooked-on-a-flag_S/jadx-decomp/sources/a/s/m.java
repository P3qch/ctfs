package a.s;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.Transition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static k f725a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static ThreadLocal<WeakReference<a.e.a<ViewGroup, ArrayList<k>>>> f726b = new ThreadLocal<>();
    public static ArrayList<ViewGroup> c = new ArrayList<>();

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.Transition>> */
    public static a.e.a<ViewGroup, ArrayList<k>> b() {
        a.e.a<ViewGroup, ArrayList<k>> aVar;
        WeakReference<a.e.a<ViewGroup, ArrayList<k>>> weakReference = f726b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        a.e.a<ViewGroup, ArrayList<k>> aVar2 = new a.e.a<>();
        f726b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    public static void c(ViewGroup sceneRoot, k transition) {
        if (transition != null && sceneRoot != null) {
            a listener = new a(transition, sceneRoot);
            sceneRoot.addOnAttachStateChangeListener(listener);
            sceneRoot.getViewTreeObserver().addOnPreDrawListener(listener);
        }
    }

    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public k f727b;
        public ViewGroup c;

        public a(k transition, ViewGroup sceneRoot) {
            this.f727b = transition;
            this.c = sceneRoot;
        }

        public final void a() {
            this.c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.c.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            a();
            m.c.remove(this.c);
            ArrayList<k> arrayList = m.b().get(this.c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k runningTransition = it.next();
                    runningTransition.R(this.c);
                }
            }
            this.f727b.l(true);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.Transition>> */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!m.c.remove(this.c)) {
                return true;
            }
            a.e.a<ViewGroup, ArrayList<k>> b2 = m.b();
            ArrayList<k> arrayList = b2.get(this.c);
            ArrayList<Transition> previousRunningTransitions = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                b2.put(this.c, arrayList);
            } else if (arrayList.size() > 0) {
                previousRunningTransitions = new ArrayList<>(arrayList);
            }
            arrayList.add(this.f727b);
            this.f727b.a(new C0052a(b2));
            this.f727b.k(this.c, false);
            if (previousRunningTransitions != null) {
                Iterator<Transition> it = previousRunningTransitions.iterator();
                while (it.hasNext()) {
                    k runningTransition = (k) it.next();
                    runningTransition.R(this.c);
                }
            }
            this.f727b.O(this.c);
            return true;
        }

        /* renamed from: a.s.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0052a extends l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a.e.a f728a;

            public C0052a(a.e.a aVar) {
                this.f728a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // a.s.k.f
            public void c(k transition) {
                ArrayList<Transition> currentTransitions = (ArrayList) this.f728a.get(a.this.c);
                currentTransitions.remove(transition);
                transition.P(this);
            }
        }
    }

    public static void d(ViewGroup sceneRoot, k transition) {
        ArrayList<k> arrayList = b().get(sceneRoot);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<k> it = arrayList.iterator();
            while (it.hasNext()) {
                k runningTransition = it.next();
                runningTransition.N(sceneRoot);
            }
        }
        if (transition != null) {
            transition.k(sceneRoot, true);
        }
        j previousScene = j.b(sceneRoot);
        if (previousScene != null) {
            previousScene.a();
            throw null;
        }
    }

    public static void a(ViewGroup sceneRoot, k transition) {
        if (!c.contains(sceneRoot) && a.h.k.v.T(sceneRoot)) {
            c.add(sceneRoot);
            if (transition == null) {
                transition = f725a;
            }
            k transitionClone = transition.clone();
            d(sceneRoot, transitionClone);
            j.c(sceneRoot, null);
            c(sceneRoot, transitionClone);
        }
    }
}
