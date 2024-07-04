package a.s;

import a.s.k;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class o extends k {
    public int K;
    public ArrayList<k> I = new ArrayList<>();
    public boolean J = true;
    public boolean L = false;
    public int M = 0;

    @Override // a.s.k
    public /* bridge */ /* synthetic */ k U(long j) {
        k0(j);
        return this;
    }

    public o m0(int ordering) {
        switch (ordering) {
            case 0:
                this.J = true;
                return this;
            case 1:
                this.J = false;
                return this;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + ordering);
        }
    }

    public o e0(k transition) {
        f0(transition);
        long j = this.g;
        if (j >= 0) {
            transition.U(j);
        }
        if ((this.M & 1) != 0) {
            transition.W(s());
        }
        if ((this.M & 2) != 0) {
            w();
            transition.Y(null);
        }
        if ((this.M & 4) != 0) {
            transition.X(v());
        }
        if ((this.M & 8) != 0) {
            transition.V(r());
        }
        return this;
    }

    public final void f0(k transition) {
        this.I.add(transition);
        transition.v = this;
    }

    public int h0() {
        return this.I.size();
    }

    public k g0(int index) {
        if (index < 0 || index >= this.I.size()) {
            return null;
        }
        return this.I.get(index);
    }

    public o k0(long duration) {
        ArrayList<k> arrayList;
        super.U(duration);
        if (this.g >= 0 && (arrayList = this.I) != null) {
            int numTransitions = arrayList.size();
            for (int i = 0; i < numTransitions; i++) {
                this.I.get(i).U(duration);
            }
        }
        return this;
    }

    @Override // a.s.k
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public o Z(long startDelay) {
        super.Z(startDelay);
        return this;
    }

    @Override // a.s.k
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public o W(TimeInterpolator interpolator) {
        this.M |= 1;
        ArrayList<k> arrayList = this.I;
        if (arrayList != null) {
            int numTransitions = arrayList.size();
            for (int i = 0; i < numTransitions; i++) {
                this.I.get(i).W(interpolator);
            }
        }
        super.W(interpolator);
        return this;
    }

    @Override // a.s.k
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public o b(View target) {
        for (int i = 0; i < this.I.size(); i++) {
            this.I.get(i).b(target);
        }
        super.b(target);
        return this;
    }

    @Override // a.s.k
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public o a(k.f listener) {
        super.a(listener);
        return this;
    }

    @Override // a.s.k
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public o Q(View target) {
        for (int i = 0; i < this.I.size(); i++) {
            this.I.get(i).Q(target);
        }
        super.Q(target);
        return this;
    }

    @Override // a.s.k
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public o P(k.f listener) {
        super.P(listener);
        return this;
    }

    @Override // a.s.k
    public void X(g pathMotion) {
        super.X(pathMotion);
        this.M |= 4;
        if (this.I != null) {
            for (int i = 0; i < this.I.size(); i++) {
                this.I.get(i).X(pathMotion);
            }
        }
    }

    public final void o0() {
        b listener = new b(this);
        Iterator<k> it = this.I.iterator();
        while (it.hasNext()) {
            k childTransition = it.next();
            childTransition.a(listener);
        }
        this.K = this.I.size();
    }

    /* loaded from: classes.dex */
    public static class b extends l {

        /* renamed from: a, reason: collision with root package name */
        public o f731a;

        public b(o transitionSet) {
            this.f731a = transitionSet;
        }

        @Override // a.s.l, a.s.k.f
        public void a(k transition) {
            o oVar = this.f731a;
            if (!oVar.L) {
                oVar.a0();
                this.f731a.L = true;
            }
        }

        @Override // a.s.k.f
        public void c(k transition) {
            o oVar = this.f731a;
            int i = oVar.K - 1;
            oVar.K = i;
            if (i == 0) {
                oVar.L = false;
                oVar.p();
            }
            transition.P(this);
        }
    }

    @Override // a.s.k
    public void o(ViewGroup sceneRoot, r startValues, r endValues, ArrayList<q> arrayList, ArrayList<q> arrayList2) {
        long startDelay = y();
        int numTransitions = this.I.size();
        for (int i = 0; i < numTransitions; i++) {
            k childTransition = this.I.get(i);
            if (startDelay > 0 && (this.J || i == 0)) {
                long childStartDelay = childTransition.y();
                if (childStartDelay > 0) {
                    childTransition.Z(startDelay + childStartDelay);
                } else {
                    childTransition.Z(startDelay);
                }
            }
            childTransition.o(sceneRoot, startValues, endValues, arrayList, arrayList2);
        }
    }

    @Override // a.s.k
    public void T() {
        if (this.I.isEmpty()) {
            a0();
            p();
            return;
        }
        o0();
        if (!this.J) {
            for (int i = 1; i < this.I.size(); i++) {
                k previousTransition = this.I.get(i - 1);
                k nextTransition = this.I.get(i);
                previousTransition.a(new a(this, nextTransition));
            }
            k firstTransition = this.I.get(0);
            if (firstTransition != null) {
                firstTransition.T();
                return;
            }
            return;
        }
        Iterator<k> it = this.I.iterator();
        while (it.hasNext()) {
            k childTransition = it.next();
            childTransition.T();
        }
    }

    /* loaded from: classes.dex */
    public class a extends l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f730a;

        public a(o this$0, k kVar) {
            this.f730a = kVar;
        }

        @Override // a.s.k.f
        public void c(k transition) {
            this.f730a.T();
            transition.P(this);
        }
    }

    @Override // a.s.k
    public void j(q transitionValues) {
        if (G(transitionValues.f735b)) {
            Iterator<k> it = this.I.iterator();
            while (it.hasNext()) {
                k childTransition = it.next();
                if (childTransition.G(transitionValues.f735b)) {
                    childTransition.j(transitionValues);
                    transitionValues.c.add(childTransition);
                }
            }
        }
    }

    @Override // a.s.k
    public void g(q transitionValues) {
        if (G(transitionValues.f735b)) {
            Iterator<k> it = this.I.iterator();
            while (it.hasNext()) {
                k childTransition = it.next();
                if (childTransition.G(transitionValues.f735b)) {
                    childTransition.g(transitionValues);
                    transitionValues.c.add(childTransition);
                }
            }
        }
    }

    @Override // a.s.k
    public void i(q transitionValues) {
        super.i(transitionValues);
        int numTransitions = this.I.size();
        for (int i = 0; i < numTransitions; i++) {
            this.I.get(i).i(transitionValues);
        }
    }

    @Override // a.s.k
    public void N(View sceneRoot) {
        super.N(sceneRoot);
        int numTransitions = this.I.size();
        for (int i = 0; i < numTransitions; i++) {
            this.I.get(i).N(sceneRoot);
        }
    }

    @Override // a.s.k
    public void R(View sceneRoot) {
        super.R(sceneRoot);
        int numTransitions = this.I.size();
        for (int i = 0; i < numTransitions; i++) {
            this.I.get(i).R(sceneRoot);
        }
    }

    @Override // a.s.k
    public void Y(n propagation) {
        super.Y(propagation);
        this.M |= 2;
        int numTransitions = this.I.size();
        for (int i = 0; i < numTransitions; i++) {
            this.I.get(i).Y(propagation);
        }
    }

    @Override // a.s.k
    public void V(k.e epicenterCallback) {
        super.V(epicenterCallback);
        this.M |= 8;
        int numTransitions = this.I.size();
        for (int i = 0; i < numTransitions; i++) {
            this.I.get(i).V(epicenterCallback);
        }
    }

    @Override // a.s.k
    public String b0(String indent) {
        String result = super.b0(indent);
        for (int i = 0; i < this.I.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(result);
            sb.append("\n");
            sb.append(this.I.get(i).b0(indent + "  "));
            result = sb.toString();
        }
        return result;
    }

    @Override // a.s.k
    /* renamed from: m */
    public k clone() {
        o clone = (o) super.clone();
        clone.I = new ArrayList<>();
        int numTransitions = this.I.size();
        for (int i = 0; i < numTransitions; i++) {
            clone.f0(this.I.get(i).clone());
        }
        return clone;
    }
}
