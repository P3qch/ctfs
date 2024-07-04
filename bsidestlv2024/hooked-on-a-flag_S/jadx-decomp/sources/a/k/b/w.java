package a.k.b;

import a.k.b.n;
import a.k.b.v;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f591a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b, reason: collision with root package name */
    public static final y f592b;
    public static final y c;

    /* loaded from: classes.dex */
    public interface g {
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public Fragment f599a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f600b;
        public a.k.b.a c;
        public Fragment d;
        public boolean e;
        public a.k.b.a f;
    }

    static {
        x xVar;
        if (Build.VERSION.SDK_INT >= 21) {
            xVar = new x();
        } else {
            xVar = null;
        }
        f592b = xVar;
        c = x();
    }

    public static y x() {
        try {
            return (y) Class.forName("a.s.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static void C(Context context, a.k.b.g fragmentContainer, ArrayList<a.k.b.a> arrayList, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex, boolean isReordered, g callback) {
        ViewGroup container;
        SparseArray<FragmentTransition.FragmentContainerTransition> transitioningFragments = new SparseArray<>();
        for (int i = startIndex; i < endIndex; i++) {
            a.k.b.a record = arrayList.get(i);
            boolean isPop = isRecordPop.get(i).booleanValue();
            if (isPop) {
                e(record, transitioningFragments, isReordered);
            } else {
                c(record, transitioningFragments, isReordered);
            }
        }
        int i2 = transitioningFragments.size();
        if (i2 != 0) {
            View nonExistentView = new View(context);
            int numContainers = transitioningFragments.size();
            for (int i3 = 0; i3 < numContainers; i3++) {
                int containerId = transitioningFragments.keyAt(i3);
                a.e.a<String, String> d2 = d(containerId, arrayList, isRecordPop, startIndex, endIndex);
                h containerTransition = (h) transitioningFragments.valueAt(i3);
                if (fragmentContainer.i() && (container = (ViewGroup) fragmentContainer.h(containerId)) != null) {
                    if (isReordered) {
                        o(container, containerTransition, nonExistentView, d2, callback);
                    } else {
                        n(container, containerTransition, nonExistentView, d2, callback);
                    }
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static a.e.a<String, String> d(int containerId, ArrayList<a.k.b.a> arrayList, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex) {
        ArrayList<String> sources;
        ArrayList<String> targets;
        a.e.a<String, String> aVar = new a.e.a<>();
        for (int recordNum = endIndex - 1; recordNum >= startIndex; recordNum--) {
            a.k.b.a record = arrayList.get(recordNum);
            if (record.w(containerId)) {
                boolean isPop = isRecordPop.get(recordNum).booleanValue();
                ArrayList<String> arrayList2 = record.m;
                if (arrayList2 != null) {
                    int numSharedElements = arrayList2.size();
                    if (isPop) {
                        targets = record.m;
                        sources = record.n;
                    } else {
                        sources = record.m;
                        targets = record.n;
                    }
                    for (int i = 0; i < numSharedElements; i++) {
                        String sourceName = sources.get(i);
                        String targetName = targets.get(i);
                        String previousTarget = aVar.remove(targetName);
                        if (previousTarget != null) {
                            aVar.put(sourceName, previousTarget);
                        } else {
                            aVar.put(sourceName, targetName);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static void o(ViewGroup container, h fragments, View nonExistentView, a.e.a<String, String> aVar, g callback) {
        Object exitTransition;
        ArrayList<View> sharedElementsIn;
        Fragment inFragment = fragments.f599a;
        Fragment outFragment = fragments.d;
        y impl = j(outFragment, inFragment);
        if (impl == null) {
            return;
        }
        boolean inIsPop = fragments.f600b;
        boolean outIsPop = fragments.e;
        ArrayList<View> sharedElementsIn2 = new ArrayList<>();
        ArrayList<View> sharedElementsOut = new ArrayList<>();
        Object enterTransition = r(impl, inFragment, inIsPop);
        Object exitTransition2 = s(impl, outFragment, outIsPop);
        Object sharedElementTransition = m(impl, container, nonExistentView, aVar, fragments, sharedElementsOut, sharedElementsIn2, enterTransition, exitTransition2);
        if (enterTransition == null && sharedElementTransition == null) {
            exitTransition = exitTransition2;
            if (exitTransition == null) {
                return;
            }
        } else {
            exitTransition = exitTransition2;
        }
        ArrayList<View> exitingViews = k(impl, exitTransition, outFragment, sharedElementsOut, nonExistentView);
        ArrayList<View> enteringViews = k(impl, enterTransition, inFragment, sharedElementsIn2, nonExistentView);
        B(enteringViews, 4);
        Object transition = v(impl, enterTransition, exitTransition, sharedElementTransition, inFragment, inIsPop);
        if (outFragment == null || exitingViews == null) {
            sharedElementsIn = sharedElementsIn2;
        } else if (exitingViews.size() > 0 || sharedElementsOut.size() > 0) {
            a.h.g.b signal = new a.h.g.b();
            sharedElementsIn = sharedElementsIn2;
            ((n.d) callback).b(outFragment, signal);
            impl.w(outFragment, transition, signal, new a(callback, outFragment, signal));
        } else {
            sharedElementsIn = sharedElementsIn2;
        }
        if (transition != null) {
            w(impl, exitTransition, outFragment, exitingViews);
            ArrayList<String> inNames = impl.o(sharedElementsIn);
            ArrayList<View> sharedElementsIn3 = sharedElementsIn;
            impl.t(transition, enterTransition, enteringViews, exitTransition, exitingViews, sharedElementTransition, sharedElementsIn3);
            impl.c(container, transition);
            impl.y(container, sharedElementsOut, sharedElementsIn3, inNames, aVar);
            B(enteringViews, 0);
            impl.A(sharedElementTransition, sharedElementsOut, sharedElementsIn3);
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f593b;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ a.h.g.b d;

        public a(g gVar, Fragment fragment, a.h.g.b bVar) {
            this.f593b = gVar;
            this.c = fragment;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((n.d) this.f593b).a(this.c, this.d);
        }
    }

    public static void w(y impl, Object exitTransition, Fragment exitingFragment, ArrayList<View> exitingViews) {
        if (exitingFragment != null && exitTransition != null && exitingFragment.n && exitingFragment.B && exitingFragment.N) {
            exitingFragment.p1(true);
            impl.r(exitTransition, exitingFragment.R(), exitingViews);
            ViewGroup container = exitingFragment.H;
            a.h.k.t.a(container, new b(exitingViews));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f594b;

        public b(ArrayList arrayList) {
            this.f594b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.B(this.f594b, 4);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static void n(ViewGroup container, h fragments, View nonExistentView, a.e.a<String, String> aVar, g callback) {
        Object exitTransition;
        Fragment inFragment = fragments.f599a;
        Fragment outFragment = fragments.d;
        y impl = j(outFragment, inFragment);
        if (impl == null) {
            return;
        }
        boolean inIsPop = fragments.f600b;
        boolean outIsPop = fragments.e;
        Object enterTransition = r(impl, inFragment, inIsPop);
        Object exitTransition2 = s(impl, outFragment, outIsPop);
        ArrayList<View> sharedElementsOut = new ArrayList<>();
        ArrayList<View> sharedElementsIn = new ArrayList<>();
        Object sharedElementTransition = l(impl, container, nonExistentView, aVar, fragments, sharedElementsOut, sharedElementsIn, enterTransition, exitTransition2);
        if (enterTransition == null && sharedElementTransition == null) {
            exitTransition = exitTransition2;
            if (exitTransition == null) {
                return;
            }
        } else {
            exitTransition = exitTransition2;
        }
        ArrayList<View> exitingViews = k(impl, exitTransition, outFragment, sharedElementsOut, nonExistentView);
        Object exitTransition3 = (exitingViews == null || exitingViews.isEmpty()) ? null : exitTransition;
        impl.a(enterTransition, nonExistentView);
        Object transition = v(impl, enterTransition, exitTransition3, sharedElementTransition, inFragment, fragments.f600b);
        if (outFragment != null && exitingViews != null && (exitingViews.size() > 0 || sharedElementsOut.size() > 0)) {
            a.h.g.b signal = new a.h.g.b();
            ((n.d) callback).b(outFragment, signal);
            impl.w(outFragment, transition, signal, new c(callback, outFragment, signal));
        }
        if (transition != null) {
            ArrayList<View> enteringViews = new ArrayList<>();
            impl.t(transition, enterTransition, enteringViews, exitTransition3, exitingViews, sharedElementTransition, sharedElementsIn);
            z(impl, container, inFragment, nonExistentView, sharedElementsIn, enterTransition, enteringViews, exitTransition3, exitingViews);
            impl.x(container, sharedElementsIn, aVar);
            impl.c(container, transition);
            impl.s(container, sharedElementsIn, aVar);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f595b;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ a.h.g.b d;

        public c(g gVar, Fragment fragment, a.h.g.b bVar) {
            this.f595b = gVar;
            this.c = fragment;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((n.d) this.f595b).a(this.c, this.d);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f596b;
        public final /* synthetic */ y c;
        public final /* synthetic */ View d;
        public final /* synthetic */ Fragment e;
        public final /* synthetic */ ArrayList f;
        public final /* synthetic */ ArrayList g;
        public final /* synthetic */ ArrayList h;
        public final /* synthetic */ Object i;

        public d(Object obj, y yVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f596b = obj;
            this.c = yVar;
            this.d = view;
            this.e = fragment;
            this.f = arrayList;
            this.g = arrayList2;
            this.h = arrayList3;
            this.i = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f596b;
            if (obj != null) {
                this.c.p(obj, this.d);
                ArrayList<View> views = w.k(this.c, this.f596b, this.e, this.f, this.d);
                this.g.addAll(views);
            }
            ArrayList<View> views2 = this.h;
            if (views2 != null) {
                if (this.i != null) {
                    ArrayList<View> tempExiting = new ArrayList<>();
                    tempExiting.add(this.d);
                    this.c.q(this.i, this.h, tempExiting);
                }
                this.h.clear();
                this.h.add(this.d);
            }
        }
    }

    public static void z(y impl, ViewGroup sceneRoot, Fragment inFragment, View nonExistentView, ArrayList<View> sharedElementsIn, Object enterTransition, ArrayList<View> enteringViews, Object exitTransition, ArrayList<View> exitingViews) {
        a.h.k.t.a(sceneRoot, new d(enterTransition, impl, nonExistentView, inFragment, sharedElementsIn, enteringViews, exitingViews, exitTransition));
    }

    public static y j(Fragment outFragment, Fragment inFragment) {
        ArrayList<Object> transitions = new ArrayList<>();
        if (outFragment != null) {
            outFragment.v();
            if (0 != 0) {
                transitions.add(null);
            }
            Object returnTransition = outFragment.K();
            if (returnTransition != null) {
                transitions.add(returnTransition);
            }
            Object sharedReturnTransition = outFragment.M();
            if (sharedReturnTransition != null) {
                transitions.add(sharedReturnTransition);
            }
        }
        if (inFragment != null) {
            inFragment.s();
            if (0 != 0) {
                transitions.add(null);
            }
            Object reenterTransition = inFragment.I();
            if (reenterTransition != null) {
                transitions.add(reenterTransition);
            }
            inFragment.L();
            if (0 != 0) {
                transitions.add(null);
            }
        }
        if (transitions.isEmpty()) {
            return null;
        }
        y yVar = f592b;
        if (yVar != null && g(yVar, transitions)) {
            return yVar;
        }
        y yVar2 = c;
        if (yVar2 != null && g(yVar2, transitions)) {
            return yVar2;
        }
        if (yVar == null && yVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static boolean g(y impl, List<Object> transitions) {
        int size = transitions.size();
        for (int i = 0; i < size; i++) {
            if (!impl.e(transitions.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static Object u(y impl, Fragment inFragment, Fragment outFragment, boolean isPop) {
        Object obj = null;
        if (inFragment == null || outFragment == null) {
            return null;
        }
        if (isPop) {
            obj = outFragment.M();
        } else {
            inFragment.L();
        }
        Object transition = impl.g(obj);
        return impl.B(transition);
    }

    public static Object r(y impl, Fragment inFragment, boolean isPop) {
        Object obj = null;
        if (inFragment == null) {
            return null;
        }
        if (isPop) {
            obj = inFragment.I();
        } else {
            inFragment.s();
        }
        return impl.g(obj);
    }

    public static Object s(y impl, Fragment outFragment, boolean isPop) {
        Object obj = null;
        if (outFragment == null) {
            return null;
        }
        if (isPop) {
            obj = outFragment.K();
        } else {
            outFragment.v();
        }
        return impl.g(obj);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static Object m(y impl, ViewGroup sceneRoot, View nonExistentView, a.e.a<String, String> aVar, h fragments, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn, Object enterTransition, Object exitTransition) {
        Object sharedElementTransition;
        Object sharedElementTransition2;
        Object sharedElementTransition3;
        a.e.a<String, View> aVar2;
        Rect epicenter;
        View epicenterView;
        Fragment inFragment = fragments.f599a;
        Fragment outFragment = fragments.d;
        if (inFragment != null) {
            inFragment.g1().setVisibility(0);
        }
        if (inFragment != null && outFragment != null) {
            boolean inIsPop = fragments.f600b;
            if (aVar.isEmpty()) {
                sharedElementTransition = null;
            } else {
                sharedElementTransition = u(impl, inFragment, outFragment, inIsPop);
            }
            a.e.a<String, View> i = i(impl, aVar, sharedElementTransition, fragments);
            a.e.a<String, View> h2 = h(impl, aVar, sharedElementTransition, fragments);
            if (aVar.isEmpty()) {
                if (i != null) {
                    i.clear();
                }
                if (h2 != null) {
                    h2.clear();
                }
                sharedElementTransition2 = null;
            } else {
                a(sharedElementsOut, i, aVar.keySet());
                a(sharedElementsIn, h2, aVar.values());
                sharedElementTransition2 = sharedElementTransition;
            }
            if (enterTransition == null && exitTransition == null && sharedElementTransition2 == null) {
                return null;
            }
            f(inFragment, outFragment, inIsPop, i, true);
            if (sharedElementTransition2 != null) {
                sharedElementsIn.add(nonExistentView);
                impl.z(sharedElementTransition2, nonExistentView, sharedElementsOut);
                boolean outIsPop = fragments.e;
                a.k.b.a outTransaction = fragments.f;
                sharedElementTransition3 = sharedElementTransition2;
                aVar2 = h2;
                A(impl, sharedElementTransition2, exitTransition, i, outIsPop, outTransaction);
                Rect epicenter2 = new Rect();
                View epicenterView2 = t(aVar2, fragments, enterTransition, inIsPop);
                if (epicenterView2 != null) {
                    impl.u(enterTransition, epicenter2);
                }
                epicenter = epicenter2;
                epicenterView = epicenterView2;
            } else {
                sharedElementTransition3 = sharedElementTransition2;
                aVar2 = h2;
                epicenter = null;
                epicenterView = null;
            }
            a.h.k.t.a(sceneRoot, new e(inFragment, outFragment, inIsPop, aVar2, epicenterView, impl, epicenter));
            return sharedElementTransition3;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f597b;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ a.e.a e;
        public final /* synthetic */ View f;
        public final /* synthetic */ y g;
        public final /* synthetic */ Rect h;

        public e(Fragment fragment, Fragment fragment2, boolean z, a.e.a aVar, View view, y yVar, Rect rect) {
            this.f597b = fragment;
            this.c = fragment2;
            this.d = z;
            this.e = aVar;
            this.f = view;
            this.g = yVar;
            this.h = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.f(this.f597b, this.c, this.d, this.e, false);
            View view = this.f;
            if (view != null) {
                this.g.k(view, this.h);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public static void a(ArrayList<View> views, a.e.a<String, View> aVar, Collection<String> nameOverridesSet) {
        for (int i = aVar.size() - 1; i >= 0; i--) {
            View view = aVar.m(i);
            if (nameOverridesSet.contains(a.h.k.v.L(view))) {
                views.add(view);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static Object l(y impl, ViewGroup sceneRoot, View nonExistentView, a.e.a<String, String> aVar, h fragments, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn, Object enterTransition, Object exitTransition) {
        Object sharedElementTransition;
        Object sharedElementTransition2;
        Rect inEpicenter;
        Fragment inFragment = fragments.f599a;
        Fragment outFragment = fragments.d;
        if (inFragment != null && outFragment != null) {
            boolean inIsPop = fragments.f600b;
            if (aVar.isEmpty()) {
                sharedElementTransition = null;
            } else {
                sharedElementTransition = u(impl, inFragment, outFragment, inIsPop);
            }
            a.e.a<String, View> i = i(impl, aVar, sharedElementTransition, fragments);
            if (aVar.isEmpty()) {
                sharedElementTransition2 = null;
            } else {
                sharedElementsOut.addAll(i.values());
                sharedElementTransition2 = sharedElementTransition;
            }
            if (enterTransition == null && exitTransition == null && sharedElementTransition2 == null) {
                return null;
            }
            f(inFragment, outFragment, inIsPop, i, true);
            if (sharedElementTransition2 != null) {
                Rect inEpicenter2 = new Rect();
                impl.z(sharedElementTransition2, nonExistentView, sharedElementsOut);
                boolean outIsPop = fragments.e;
                a.k.b.a outTransaction = fragments.f;
                A(impl, sharedElementTransition2, exitTransition, i, outIsPop, outTransaction);
                if (enterTransition != null) {
                    impl.u(enterTransition, inEpicenter2);
                }
                inEpicenter = inEpicenter2;
            } else {
                inEpicenter = null;
            }
            Object finalSharedElementTransition = sharedElementTransition2;
            Object sharedElementTransition3 = sharedElementTransition2;
            a.h.k.t.a(sceneRoot, new f(impl, aVar, finalSharedElementTransition, fragments, sharedElementsIn, nonExistentView, inFragment, outFragment, inIsPop, sharedElementsOut, enterTransition, inEpicenter));
            return sharedElementTransition3;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f598b;
        public final /* synthetic */ a.e.a c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ h e;
        public final /* synthetic */ ArrayList f;
        public final /* synthetic */ View g;
        public final /* synthetic */ Fragment h;
        public final /* synthetic */ Fragment i;
        public final /* synthetic */ boolean j;
        public final /* synthetic */ ArrayList k;
        public final /* synthetic */ Object l;
        public final /* synthetic */ Rect m;

        public f(y yVar, a.e.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f598b = yVar;
            this.c = aVar;
            this.d = obj;
            this.e = hVar;
            this.f = arrayList;
            this.g = view;
            this.h = fragment;
            this.i = fragment2;
            this.j = z;
            this.k = arrayList2;
            this.l = obj2;
            this.m = rect;
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
        @Override // java.lang.Runnable
        public void run() {
            a.e.a<String, View> h = w.h(this.f598b, this.c, this.d, this.e);
            if (h != null) {
                this.f.addAll(h.values());
                this.f.add(this.g);
            }
            w.f(this.h, this.i, this.j, h, false);
            Object obj = this.d;
            if (obj != null) {
                this.f598b.A(obj, this.k, this.f);
                View inEpicenterView = w.t(h, this.e, this.l, this.j);
                if (inEpicenterView != null) {
                    this.f598b.k(inEpicenterView, this.m);
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static a.e.a<String, View> i(y yVar, a.e.a<String, String> aVar, Object sharedElementTransition, h fragments) {
        a.h.b.f sharedElementCallback;
        ArrayList<String> names;
        if (aVar.isEmpty() || sharedElementTransition == null) {
            aVar.clear();
            return null;
        }
        Fragment outFragment = fragments.d;
        ArrayMap<String, View> outSharedElements = new a.e.a<>();
        yVar.j(outSharedElements, outFragment.g1());
        a.k.b.a outTransaction = fragments.f;
        if (fragments.e) {
            outFragment.t();
            sharedElementCallback = null;
            names = outTransaction.n;
        } else {
            outFragment.w();
            sharedElementCallback = null;
            names = outTransaction.m;
        }
        if (names != null) {
            outSharedElements.o(names);
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.a(names, outSharedElements);
            for (int i = names.size() - 1; i >= 0; i--) {
                String name = names.get(i);
                View view = (View) outSharedElements.get(name);
                if (view == null) {
                    aVar.remove(name);
                } else if (!name.equals(a.h.k.v.L(view))) {
                    String targetValue = aVar.remove(name);
                    aVar.put(a.h.k.v.L(view), targetValue);
                }
            }
        } else {
            aVar.o(outSharedElements.keySet());
        }
        return outSharedElements;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static a.e.a<String, View> h(y yVar, a.e.a<String, String> aVar, Object sharedElementTransition, h fragments) {
        a.h.b.f sharedElementCallback;
        ArrayList<String> names;
        String key;
        Fragment inFragment = fragments.f599a;
        View fragmentView = inFragment.R();
        if (aVar.isEmpty() || sharedElementTransition == null || fragmentView == null) {
            aVar.clear();
            return null;
        }
        ArrayMap<String, View> inSharedElements = new a.e.a<>();
        yVar.j(inSharedElements, fragmentView);
        a.k.b.a inTransaction = fragments.c;
        if (fragments.f600b) {
            inFragment.w();
            sharedElementCallback = null;
            names = inTransaction.m;
        } else {
            inFragment.t();
            sharedElementCallback = null;
            names = inTransaction.n;
        }
        if (names != null) {
            inSharedElements.o(names);
            inSharedElements.o(aVar.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.a(names, inSharedElements);
            for (int i = names.size() - 1; i >= 0; i--) {
                String name = names.get(i);
                View view = (View) inSharedElements.get(name);
                if (view == null) {
                    String key2 = q(aVar, name);
                    if (key2 != null) {
                        aVar.remove(key2);
                    }
                } else if (!name.equals(a.h.k.v.L(view)) && (key = q(aVar, name)) != null) {
                    aVar.put(key, a.h.k.v.L(view));
                }
            }
        } else {
            y(aVar, inSharedElements);
        }
        return inSharedElements;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static String q(a.e.a<String, String> aVar, String value) {
        int numElements = aVar.size();
        for (int i = 0; i < numElements; i++) {
            if (value.equals(aVar.m(i))) {
                return aVar.i(i);
            }
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public static View t(a.e.a<String, View> aVar, h fragments, Object enterTransition, boolean inIsPop) {
        ArrayList<String> arrayList;
        a.k.b.a inTransaction = fragments.c;
        if (enterTransition != null && aVar != null && (arrayList = inTransaction.m) != null && !arrayList.isEmpty()) {
            String targetName = inIsPop ? inTransaction.m.get(0) : inTransaction.n.get(0);
            return aVar.get(targetName);
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public static void A(y impl, Object sharedElementTransition, Object exitTransition, a.e.a<String, View> aVar, boolean outIsPop, a.k.b.a outTransaction) {
        ArrayList<String> arrayList = outTransaction.m;
        if (arrayList != null && !arrayList.isEmpty()) {
            String sourceName = outIsPop ? outTransaction.n.get(0) : outTransaction.m.get(0);
            View outEpicenterView = aVar.get(sourceName);
            impl.v(sharedElementTransition, outEpicenterView);
            if (exitTransition != null) {
                impl.v(exitTransition, outEpicenterView);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static void y(a.e.a<String, String> aVar, a.e.a<String, View> aVar2) {
        for (int i = aVar.size() - 1; i >= 0; i--) {
            String targetName = aVar.m(i);
            if (!aVar2.containsKey(targetName)) {
                aVar.k(i);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public static void f(Fragment inFragment, Fragment outFragment, boolean isPop, a.e.a<String, View> aVar, boolean isStart) {
        if (isPop) {
            outFragment.t();
        } else {
            inFragment.t();
        }
        a.h.b.f sharedElementCallback = null;
        if (0 != 0) {
            ArrayList<View> views = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();
            int count = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < count; i++) {
                names.add(aVar.i(i));
                views.add(aVar.m(i));
            }
            if (isStart) {
                sharedElementCallback.c(names, views, null);
            } else {
                sharedElementCallback.b(names, views, null);
            }
        }
    }

    public static ArrayList<View> k(y impl, Object transition, Fragment fragment, ArrayList<View> sharedElements, View nonExistentView) {
        ArrayList<View> viewList = null;
        if (transition != null) {
            viewList = new ArrayList<>();
            View root = fragment.R();
            if (root != null) {
                impl.f(viewList, root);
            }
            if (sharedElements != null) {
                viewList.removeAll(sharedElements);
            }
            if (!viewList.isEmpty()) {
                viewList.add(nonExistentView);
                impl.b(transition, viewList);
            }
        }
        return viewList;
    }

    public static void B(ArrayList<View> views, int visibility) {
        if (views == null) {
            return;
        }
        for (int i = views.size() - 1; i >= 0; i--) {
            View view = views.get(i);
            view.setVisibility(visibility);
        }
    }

    public static Object v(y impl, Object enterTransition, Object exitTransition, Object sharedElementTransition, Fragment inFragment, boolean isPop) {
        boolean overlap = true;
        if (enterTransition != null && exitTransition != null && inFragment != null) {
            if (isPop) {
                inFragment.l();
            } else {
                inFragment.k();
            }
            overlap = true;
        }
        if (overlap) {
            Object transition = impl.n(exitTransition, enterTransition, sharedElementTransition);
            return transition;
        }
        Object transition2 = impl.m(exitTransition, enterTransition, sharedElementTransition);
        return transition2;
    }

    public static void c(a.k.b.a transaction, SparseArray<h> sparseArray, boolean isReordered) {
        int numOps = transaction.f587a.size();
        for (int opNum = 0; opNum < numOps; opNum++) {
            v.a op = transaction.f587a.get(opNum);
            b(transaction, op, sparseArray, false, isReordered);
        }
    }

    public static void e(a.k.b.a transaction, SparseArray<h> sparseArray, boolean isReordered) {
        if (!transaction.q.j0().i()) {
            return;
        }
        int numOps = transaction.f587a.size();
        for (int opNum = numOps - 1; opNum >= 0; opNum--) {
            v.a op = transaction.f587a.get(opNum);
            b(transaction, op, sparseArray, true, isReordered);
        }
    }

    public static void b(a.k.b.a transaction, v.a op, SparseArray<h> sparseArray, boolean isPop, boolean isReorderedTransaction) {
        int containerId;
        View view;
        Fragment fragment = op.f590b;
        if (fragment == null || (containerId = fragment.z) == 0) {
            return;
        }
        int command = isPop ? f591a[op.f589a] : op.f589a;
        boolean setLastIn = false;
        boolean wasRemoved = false;
        boolean setFirstOut = false;
        boolean wasAdded = false;
        switch (command) {
            case 1:
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                if (isReorderedTransaction) {
                    setLastIn = fragment.M;
                } else {
                    setLastIn = (fragment.n || fragment.B) ? false : true;
                }
                wasAdded = true;
                break;
            case 3:
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                if (isReorderedTransaction) {
                    setFirstOut = !fragment.n && (view = fragment.I) != null && view.getVisibility() == 0 && fragment.O >= 0.0f;
                } else {
                    setFirstOut = fragment.n && !fragment.B;
                }
                wasRemoved = true;
                break;
            case 4:
                if (isReorderedTransaction) {
                    setFirstOut = fragment.N && fragment.n && fragment.B;
                } else {
                    setFirstOut = fragment.n && !fragment.B;
                }
                wasRemoved = true;
                break;
            case 5:
                if (isReorderedTransaction) {
                    setLastIn = fragment.N && !fragment.B && fragment.n;
                } else {
                    setLastIn = fragment.B;
                }
                wasAdded = true;
                break;
        }
        h containerTransition = sparseArray.get(containerId);
        if (setLastIn) {
            containerTransition = p(containerTransition, sparseArray, containerId);
            containerTransition.f599a = fragment;
            containerTransition.f600b = isPop;
            containerTransition.c = transaction;
        }
        if (!isReorderedTransaction && wasAdded) {
            if (containerTransition != null && containerTransition.d == fragment) {
                containerTransition.d = null;
            }
            if (!transaction.o) {
                n manager = transaction.q;
                t fragmentStateManager = manager.r(fragment);
                manager.m0().p(fragmentStateManager);
                manager.H0(fragment);
            }
        }
        if (setFirstOut && (containerTransition == null || containerTransition.d == null)) {
            containerTransition = p(containerTransition, sparseArray, containerId);
            containerTransition.d = fragment;
            containerTransition.e = isPop;
            containerTransition.f = transaction;
        }
        if (!isReorderedTransaction && wasRemoved && containerTransition != null && containerTransition.f599a == fragment) {
            containerTransition.f599a = null;
        }
    }

    public static h p(h containerTransition, SparseArray<h> sparseArray, int containerId) {
        if (containerTransition == null) {
            h containerTransition2 = new h();
            sparseArray.put(containerId, containerTransition2);
            return containerTransition2;
        }
        return containerTransition;
    }
}
