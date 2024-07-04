package a.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public abstract class k implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f719b = {2, 1, 3, 4};
    public static final g c = new a();
    public static ThreadLocal<a.e.a<Animator, d>> d = new ThreadLocal<>();
    public e G;
    public ArrayList<q> x;
    public ArrayList<q> y;
    public String e = getClass().getName();
    public long f = -1;
    public long g = -1;
    public TimeInterpolator h = null;
    public ArrayList<Integer> i = new ArrayList<>();
    public ArrayList<View> j = new ArrayList<>();
    public ArrayList<String> k = null;
    public ArrayList<Class<?>> l = null;
    public ArrayList<Integer> m = null;
    public ArrayList<View> n = null;
    public ArrayList<Class<?>> o = null;
    public ArrayList<String> p = null;
    public ArrayList<Integer> q = null;
    public ArrayList<View> r = null;
    public ArrayList<Class<?>> s = null;
    public r t = new r();
    public r u = new r();
    public o v = null;
    public int[] w = f719b;
    public boolean z = false;
    public ArrayList<Animator> A = new ArrayList<>();
    public int B = 0;
    public boolean C = false;
    public boolean D = false;
    public ArrayList<f> E = null;
    public ArrayList<Animator> F = new ArrayList<>();
    public g H = c;

    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(k kVar);

        void b(k kVar);

        void c(k kVar);

        void d(k kVar);

        void e(k kVar);
    }

    public abstract void g(q qVar);

    public abstract void j(q qVar);

    /* loaded from: classes.dex */
    public static class a extends g {
        @Override // a.s.g
        public Path a(float startX, float startY, float endX, float endY) {
            Path path = new Path();
            path.moveTo(startX, startY);
            path.lineTo(endX, endY);
            return path;
        }
    }

    public k U(long duration) {
        this.g = duration;
        return this;
    }

    public long q() {
        return this.g;
    }

    public k Z(long startDelay) {
        this.f = startDelay;
        return this;
    }

    public long y() {
        return this.f;
    }

    public k W(TimeInterpolator interpolator) {
        this.h = interpolator;
        return this;
    }

    public TimeInterpolator s() {
        return this.h;
    }

    public String[] D() {
        return null;
    }

    public Animator n(ViewGroup sceneRoot, q startValues, q endValues) {
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.view.View, androidx.transition.TransitionValues> */
    public final void J(a.e.a<View, q> aVar, a.e.a<View, q> aVar2) {
        q end;
        for (int i = aVar.size() - 1; i >= 0; i--) {
            View view = aVar.i(i);
            if (view != null && G(view) && (end = aVar2.remove(view)) != null && G(end.f735b)) {
                q start = aVar.k(i);
                this.x.add(start);
                this.y.add(end);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.view.View, androidx.transition.TransitionValues> */
    /* JADX WARN: Generic types in debug info not equals: a.e.d != androidx.collection.LongSparseArray<android.view.View> */
    public final void K(a.e.a<View, q> aVar, a.e.a<View, q> aVar2, a.e.d<View> dVar, a.e.d<View> dVar2) {
        View endView;
        int numStartIds = dVar.l();
        for (int i = 0; i < numStartIds; i++) {
            View startView = dVar.m(i);
            if (startView != null && G(startView) && (endView = dVar2.e(dVar.h(i))) != null && G(endView)) {
                q startValues = aVar.get(startView);
                q endValues = aVar2.get(endView);
                if (startValues != null && endValues != null) {
                    this.x.add(startValues);
                    this.y.add(endValues);
                    aVar.remove(startView);
                    aVar2.remove(endView);
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.view.View, androidx.transition.TransitionValues> */
    public final void I(a.e.a<View, q> aVar, a.e.a<View, q> aVar2, SparseArray<View> startIds, SparseArray<View> endIds) {
        View endView;
        int numStartIds = startIds.size();
        for (int i = 0; i < numStartIds; i++) {
            View startView = startIds.valueAt(i);
            if (startView != null && G(startView) && (endView = endIds.get(startIds.keyAt(i))) != null && G(endView)) {
                q startValues = aVar.get(startView);
                q endValues = aVar2.get(endView);
                if (startValues != null && endValues != null) {
                    this.x.add(startValues);
                    this.y.add(endValues);
                    aVar.remove(startView);
                    aVar2.remove(endView);
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.view.View, androidx.transition.TransitionValues> */
    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public final void L(a.e.a<View, q> aVar, a.e.a<View, q> aVar2, a.e.a<String, View> aVar3, a.e.a<String, View> aVar4) {
        View endView;
        int numStartNames = aVar3.size();
        for (int i = 0; i < numStartNames; i++) {
            View startView = aVar3.m(i);
            if (startView != null && G(startView) && (endView = aVar4.get(aVar3.i(i))) != null && G(endView)) {
                q startValues = aVar.get(startView);
                q endValues = aVar2.get(endView);
                if (startValues != null && endValues != null) {
                    this.x.add(startValues);
                    this.y.add(endValues);
                    aVar.remove(startView);
                    aVar2.remove(endView);
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.view.View, androidx.transition.TransitionValues> */
    public final void c(a.e.a<View, q> aVar, a.e.a<View, q> aVar2) {
        for (int i = 0; i < aVar.size(); i++) {
            q start = aVar.m(i);
            if (G(start.f735b)) {
                this.x.add(start);
                this.y.add(null);
            }
        }
        for (int i2 = 0; i2 < aVar2.size(); i2++) {
            q end = aVar2.m(i2);
            if (G(end.f735b)) {
                this.y.add(end);
                this.x.add(null);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.view.View, androidx.transition.TransitionValues> */
    public final void M(r startValues, r endValues) {
        a.e.a<View, q> aVar = new a.e.a<>(startValues.f736a);
        a.e.a<View, q> aVar2 = new a.e.a<>(endValues.f736a);
        int i = 0;
        while (true) {
            int[] iArr = this.w;
            if (i < iArr.length) {
                switch (iArr[i]) {
                    case 1:
                        J(aVar, aVar2);
                        break;
                    case 2:
                        L(aVar, aVar2, startValues.d, endValues.d);
                        break;
                    case 3:
                        I(aVar, aVar2, startValues.f737b, endValues.f737b);
                        break;
                    case 4:
                        K(aVar, aVar2, startValues.c, endValues.c);
                        break;
                }
                i++;
            } else {
                c(aVar, aVar2);
                return;
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.Transition$AnimationInfo> */
    public void o(ViewGroup sceneRoot, r startValues, r endValues, ArrayList<q> arrayList, ArrayList<q> arrayList2) {
        q start;
        q end;
        int startValuesListCount;
        q infoValues;
        Animator animator;
        View view;
        Animator animator2;
        Animator animator3;
        int numExistingAnims;
        a.e.a<Animator, d> x = x();
        SparseIntArray startDelays = new SparseIntArray();
        int startValuesListCount2 = arrayList.size();
        int i = 0;
        while (i < startValuesListCount2) {
            q start2 = arrayList.get(i);
            q end2 = arrayList2.get(i);
            if (start2 != null && !start2.c.contains(this)) {
                start = null;
            } else {
                start = start2;
            }
            if (end2 != null && !end2.c.contains(this)) {
                end = null;
            } else {
                end = end2;
            }
            if (start == null && end == null) {
                startValuesListCount = startValuesListCount2;
            } else {
                boolean isChanged = start == null || end == null || F(start, end);
                if (isChanged) {
                    Animator animator4 = n(sceneRoot, start, end);
                    if (animator4 != null) {
                        q infoValues2 = null;
                        if (end == null) {
                            startValuesListCount = startValuesListCount2;
                            infoValues = null;
                            animator = animator4;
                            view = start.f735b;
                        } else {
                            View view2 = end.f735b;
                            String[] properties = D();
                            if (properties != null) {
                                animator2 = animator4;
                                if (properties.length > 0) {
                                    q infoValues3 = new q(view2);
                                    q newValues = endValues.f736a.get(view2);
                                    if (newValues != null) {
                                        int j = 0;
                                        while (true) {
                                            q end3 = end;
                                            if (j >= properties.length) {
                                                break;
                                            }
                                            infoValues3.f734a.put(properties[j], newValues.f734a.get(properties[j]));
                                            j++;
                                            end = end3;
                                            startValuesListCount2 = startValuesListCount2;
                                            newValues = newValues;
                                        }
                                        startValuesListCount = startValuesListCount2;
                                    } else {
                                        startValuesListCount = startValuesListCount2;
                                    }
                                    int numExistingAnims2 = x.size();
                                    int j2 = 0;
                                    while (true) {
                                        if (j2 >= numExistingAnims2) {
                                            infoValues2 = infoValues3;
                                            animator3 = animator2;
                                            break;
                                        }
                                        Animator anim = x.i(j2);
                                        d info = x.get(anim);
                                        if (info.c == null || info.f723a != view2) {
                                            numExistingAnims = numExistingAnims2;
                                        } else {
                                            numExistingAnims = numExistingAnims2;
                                            if (info.f724b.equals(u()) && info.c.equals(infoValues3)) {
                                                infoValues2 = infoValues3;
                                                animator3 = null;
                                                break;
                                            }
                                        }
                                        j2++;
                                        numExistingAnims2 = numExistingAnims;
                                    }
                                    animator = animator3;
                                    infoValues = infoValues2;
                                    view = view2;
                                } else {
                                    startValuesListCount = startValuesListCount2;
                                }
                            } else {
                                animator2 = animator4;
                                startValuesListCount = startValuesListCount2;
                            }
                            animator3 = animator2;
                            animator = animator3;
                            infoValues = infoValues2;
                            view = view2;
                        }
                        if (animator != null) {
                            x.put(animator, new d(view, u(), this, y.c(sceneRoot), infoValues));
                            this.F.add(animator);
                        }
                    } else {
                        startValuesListCount = startValuesListCount2;
                    }
                } else {
                    startValuesListCount = startValuesListCount2;
                }
            }
            i++;
            startValuesListCount2 = startValuesListCount;
        }
        if (startDelays.size() != 0) {
            for (int i2 = 0; i2 < startDelays.size(); i2++) {
                int index = startDelays.keyAt(i2);
                Animator animator5 = this.F.get(index);
                long delay = (startDelays.valueAt(i2) - Long.MAX_VALUE) + animator5.getStartDelay();
                animator5.setStartDelay(delay);
            }
        }
    }

    public boolean G(View target) {
        int targetId = target.getId();
        return (this.i.size() == 0 && this.j.size() == 0) || this.i.contains(Integer.valueOf(targetId)) || this.j.contains(target);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.Transition$AnimationInfo> */
    public static a.e.a<Animator, d> x() {
        a.e.a<Animator, d> aVar = d.get();
        if (aVar == null) {
            a.e.a<Animator, d> aVar2 = new a.e.a<>();
            d.set(aVar2);
            return aVar2;
        }
        return aVar;
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.Transition$AnimationInfo> */
    public void T() {
        a0();
        a.e.a<Animator, d> x = x();
        Iterator<Animator> it = this.F.iterator();
        while (it.hasNext()) {
            Animator anim = it.next();
            if (x.containsKey(anim)) {
                a0();
                S(anim, x);
            }
        }
        this.F.clear();
        p();
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.Transition$AnimationInfo> */
    public final void S(Animator animator, a.e.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.e.a f720a;

        public b(a.e.a aVar) {
            this.f720a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            k.this.A.add(animation);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f720a.remove(animation);
            k.this.A.remove(animation);
        }
    }

    public k b(View target) {
        this.j.add(target);
        return this;
    }

    public k Q(View target) {
        this.j.remove(target);
        return this;
    }

    public List<Integer> z() {
        return this.i;
    }

    public List<View> C() {
        return this.j;
    }

    public List<String> A() {
        return null;
    }

    public List<Class<?>> B() {
        return null;
    }

    public void k(ViewGroup sceneRoot, boolean start) {
        l(start);
        if (this.i.size() > 0 || this.j.size() > 0) {
            for (int i = 0; i < this.i.size(); i++) {
                int id = this.i.get(i).intValue();
                View view = sceneRoot.findViewById(id);
                if (view != null) {
                    q values = new q(view);
                    if (start) {
                        j(values);
                    } else {
                        g(values);
                    }
                    values.c.add(this);
                    i(values);
                    if (start) {
                        d(this.t, view, values);
                    } else {
                        d(this.u, view, values);
                    }
                }
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                View view2 = this.j.get(i2);
                q values2 = new q(view2);
                if (start) {
                    j(values2);
                } else {
                    g(values2);
                }
                values2.c.add(this);
                i(values2);
                if (start) {
                    d(this.t, view2, values2);
                } else {
                    d(this.u, view2, values2);
                }
            }
        } else {
            h(sceneRoot, start);
        }
        if (!start) {
        }
    }

    public static void d(r transitionValuesMaps, View view, q transitionValues) {
        transitionValuesMaps.f736a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.f737b.indexOfKey(id) >= 0) {
                transitionValuesMaps.f737b.put(id, null);
            } else {
                transitionValuesMaps.f737b.put(id, view);
            }
        }
        String name = a.h.k.v.L(view);
        if (name != null) {
            if (transitionValuesMaps.d.containsKey(name)) {
                transitionValuesMaps.d.put(name, null);
            } else {
                transitionValuesMaps.d.put(name, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listview = (ListView) view.getParent();
            if (listview.getAdapter().hasStableIds()) {
                int position = listview.getPositionForView(view);
                long itemId = listview.getItemIdAtPosition(position);
                if (transitionValuesMaps.c.g(itemId) >= 0) {
                    View alreadyMatched = transitionValuesMaps.c.e(itemId);
                    if (alreadyMatched != null) {
                        a.h.k.v.w0(alreadyMatched, false);
                        transitionValuesMaps.c.i(itemId, null);
                        return;
                    }
                    return;
                }
                a.h.k.v.w0(view, true);
                transitionValuesMaps.c.i(itemId, view);
            }
        }
    }

    public void l(boolean start) {
        if (start) {
            this.t.f736a.clear();
            this.t.f737b.clear();
            this.t.c.b();
        } else {
            this.u.f736a.clear();
            this.u.f737b.clear();
            this.u.c.b();
        }
    }

    public final void h(View view, boolean start) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            q values = new q(view);
            if (start) {
                j(values);
            } else {
                g(values);
            }
            values.c.add(this);
            i(values);
            if (start) {
                d(this.t, view, values);
            } else {
                d(this.u, view, values);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) view;
            for (int i = 0; i < parent.getChildCount(); i++) {
                h(parent.getChildAt(i), start);
            }
        }
    }

    public q E(View view, boolean start) {
        o oVar = this.v;
        if (oVar != null) {
            return oVar.E(view, start);
        }
        r valuesMaps = start ? this.t : this.u;
        return valuesMaps.f736a.get(view);
    }

    public q t(View view, boolean viewInStart) {
        o oVar = this.v;
        if (oVar != null) {
            return oVar.t(view, viewInStart);
        }
        ArrayList<q> arrayList = viewInStart ? this.x : this.y;
        if (arrayList == null) {
            return null;
        }
        int count = arrayList.size();
        int index = -1;
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            }
            q values = arrayList.get(i);
            if (values == null) {
                return null;
            }
            if (values.f735b != view) {
                i++;
            } else {
                index = i;
                break;
            }
        }
        if (index < 0) {
            return null;
        }
        return (viewInStart ? this.y : this.x).get(index);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.Transition$AnimationInfo> */
    public void N(View sceneRoot) {
        if (!this.D) {
            a.e.a<Animator, d> x = x();
            int numOldAnims = x.size();
            j0 windowId = y.c(sceneRoot);
            for (int i = numOldAnims - 1; i >= 0; i--) {
                d info = x.m(i);
                if (info.f723a != null && windowId.equals(info.d)) {
                    Animator anim = x.i(i);
                    a.s.a.b(anim);
                }
            }
            ArrayList<f> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<Transition.TransitionListener> tmpListeners = (ArrayList) this.E.clone();
                int numListeners = tmpListeners.size();
                for (int i2 = 0; i2 < numListeners; i2++) {
                    ((f) tmpListeners.get(i2)).d(this);
                }
            }
            this.C = true;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.Transition$AnimationInfo> */
    public void R(View sceneRoot) {
        if (this.C) {
            if (!this.D) {
                a.e.a<Animator, d> x = x();
                int numOldAnims = x.size();
                j0 windowId = y.c(sceneRoot);
                for (int i = numOldAnims - 1; i >= 0; i--) {
                    d info = x.m(i);
                    if (info.f723a != null && windowId.equals(info.d)) {
                        Animator anim = x.i(i);
                        a.s.a.c(anim);
                    }
                }
                ArrayList<f> arrayList = this.E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList<Transition.TransitionListener> tmpListeners = (ArrayList) this.E.clone();
                    int numListeners = tmpListeners.size();
                    for (int i2 = 0; i2 < numListeners; i2++) {
                        ((f) tmpListeners.get(i2)).e(this);
                    }
                }
            }
            this.C = false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.Transition$AnimationInfo> */
    public void O(ViewGroup sceneRoot) {
        d oldInfo;
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        M(this.t, this.u);
        a.e.a<Animator, d> x = x();
        int numOldAnims = x.size();
        j0 windowId = y.c(sceneRoot);
        for (int i = numOldAnims - 1; i >= 0; i--) {
            Animator anim = x.i(i);
            if (anim != null && (oldInfo = x.get(anim)) != null && oldInfo.f723a != null && windowId.equals(oldInfo.d)) {
                q oldValues = oldInfo.c;
                View oldView = oldInfo.f723a;
                q startValues = E(oldView, true);
                q endValues = t(oldView, true);
                if (startValues == null && endValues == null) {
                    endValues = this.u.f736a.get(oldView);
                }
                boolean cancel = !(startValues == null && endValues == null) && oldInfo.e.F(oldValues, endValues);
                if (cancel) {
                    if (anim.isRunning() || anim.isStarted()) {
                        anim.cancel();
                    } else {
                        x.remove(anim);
                    }
                }
            }
        }
        o(sceneRoot, this.t, this.u, this.x, this.y);
        T();
    }

    public boolean F(q startValues, q endValues) {
        if (startValues == null || endValues == null) {
            return false;
        }
        String[] properties = D();
        if (properties != null) {
            for (String property : properties) {
                if (H(startValues, endValues, property)) {
                    return true;
                }
            }
            return false;
        }
        for (String key : startValues.f734a.keySet()) {
            if (H(startValues, endValues, key)) {
                return true;
            }
        }
        return false;
    }

    public static boolean H(q oldValues, q newValues, String key) {
        Object oldValue = oldValues.f734a.get(key);
        Object newValue = newValues.f734a.get(key);
        if (oldValue == null && newValue == null) {
            return false;
        }
        if (oldValue == null || newValue == null) {
            return true;
        }
        boolean changed = !oldValue.equals(newValue);
        return changed;
    }

    public void e(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (q() >= 0) {
            animator.setDuration(q());
        }
        if (y() >= 0) {
            animator.setStartDelay(y() + animator.getStartDelay());
        }
        if (s() != null) {
            animator.setInterpolator(s());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            k.this.p();
            animation.removeListener(this);
        }
    }

    public void a0() {
        if (this.B == 0) {
            ArrayList<f> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<Transition.TransitionListener> tmpListeners = (ArrayList) this.E.clone();
                int numListeners = tmpListeners.size();
                for (int i = 0; i < numListeners; i++) {
                    ((f) tmpListeners.get(i)).a(this);
                }
            }
            this.D = false;
        }
        this.B++;
    }

    public void p() {
        int i = this.B - 1;
        this.B = i;
        if (i == 0) {
            ArrayList<f> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<Transition.TransitionListener> tmpListeners = (ArrayList) this.E.clone();
                int numListeners = tmpListeners.size();
                for (int i2 = 0; i2 < numListeners; i2++) {
                    ((f) tmpListeners.get(i2)).c(this);
                }
            }
            for (int i3 = 0; i3 < this.t.c.l(); i3++) {
                View view = this.t.c.m(i3);
                if (view != null) {
                    a.h.k.v.w0(view, false);
                }
            }
            for (int i4 = 0; i4 < this.u.c.l(); i4++) {
                View view2 = this.u.c.m(i4);
                if (view2 != null) {
                    a.h.k.v.w0(view2, false);
                }
            }
            this.D = true;
        }
    }

    public void f() {
        int numAnimators = this.A.size();
        for (int i = numAnimators - 1; i >= 0; i--) {
            Animator animator = this.A.get(i);
            animator.cancel();
        }
        ArrayList<f> arrayList = this.E;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<Transition.TransitionListener> tmpListeners = (ArrayList) this.E.clone();
            int numListeners = tmpListeners.size();
            for (int i2 = 0; i2 < numListeners; i2++) {
                ((f) tmpListeners.get(i2)).b(this);
            }
        }
    }

    public k a(f listener) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(listener);
        return this;
    }

    public k P(f listener) {
        ArrayList<f> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(listener);
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    public void X(g pathMotion) {
        if (pathMotion == null) {
            this.H = c;
        } else {
            this.H = pathMotion;
        }
    }

    public g v() {
        return this.H;
    }

    public void V(e epicenterCallback) {
        this.G = epicenterCallback;
    }

    public e r() {
        return this.G;
    }

    public void Y(n transitionPropagation) {
    }

    public void w() {
    }

    public void i(q transitionValues) {
    }

    public String toString() {
        return b0(BuildConfig.FLAVOR);
    }

    @Override // 
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public k clone() {
        try {
            k clone = (k) super.clone();
            clone.F = new ArrayList<>();
            clone.t = new r();
            clone.u = new r();
            clone.x = null;
            clone.y = null;
            return clone;
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public String u() {
        return this.e;
    }

    public String b0(String indent) {
        String result = indent + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.g != -1) {
            result = result + "dur(" + this.g + ") ";
        }
        if (this.f != -1) {
            result = result + "dly(" + this.f + ") ";
        }
        if (this.h != null) {
            result = result + "interp(" + this.h + ") ";
        }
        if (this.i.size() > 0 || this.j.size() > 0) {
            String result2 = result + "tgts(";
            if (this.i.size() > 0) {
                for (int i = 0; i < this.i.size(); i++) {
                    if (i > 0) {
                        result2 = result2 + ", ";
                    }
                    result2 = result2 + this.i.get(i);
                }
            }
            if (this.j.size() > 0) {
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    if (i2 > 0) {
                        result2 = result2 + ", ";
                    }
                    result2 = result2 + this.j.get(i2);
                }
            }
            return result2 + ")";
        }
        return result;
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public View f723a;

        /* renamed from: b, reason: collision with root package name */
        public String f724b;
        public q c;
        public j0 d;
        public k e;

        public d(View view, String name, k transition, j0 windowId, q values) {
            this.f723a = view;
            this.f724b = name;
            this.c = values;
            this.d = windowId;
            this.e = transition;
        }
    }
}
