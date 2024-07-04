package a.f.a;

import a.f.a.d;
import a.f.a.h;
import java.util.ArrayList;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public class b implements d.a {
    public a d;

    /* renamed from: a, reason: collision with root package name */
    public h f256a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f257b = 0.0f;
    public ArrayList<h> c = new ArrayList<>();
    public boolean e = false;

    /* loaded from: classes.dex */
    public interface a {
        float a(int i);

        float b(h hVar);

        float c(h hVar, boolean z);

        void clear();

        h d(int i);

        void e(h hVar, float f, boolean z);

        boolean f(h hVar);

        void g(float f);

        float h(b bVar, boolean z);

        void i();

        void j(h hVar, float f);

        int k();
    }

    public b() {
    }

    public b(c cache) {
        this.d = new a.f.a.a(this, cache);
    }

    public boolean s() {
        h hVar = this.f256a;
        return hVar != null && (hVar.l == h.a.UNRESTRICTED || this.f257b >= 0.0f);
    }

    public String toString() {
        return A();
    }

    public String A() {
        String s = (this.f256a == null ? BuildConfig.FLAVOR + "0" : BuildConfig.FLAVOR + this.f256a) + " = ";
        boolean addedVariable = false;
        if (this.f257b != 0.0f) {
            s = s + this.f257b;
            addedVariable = true;
        }
        int count = this.d.k();
        for (int i = 0; i < count; i++) {
            h v = this.d.d(i);
            if (v != null) {
                float amount = this.d.a(i);
                if (amount != 0.0f) {
                    String name = v.toString();
                    if (addedVariable) {
                        if (amount > 0.0f) {
                            s = s + " + ";
                        } else {
                            s = s + " - ";
                            amount *= -1.0f;
                        }
                    } else if (amount < 0.0f) {
                        s = s + "- ";
                        amount *= -1.0f;
                    }
                    s = amount == 1.0f ? s + name : s + amount + " " + name;
                    addedVariable = true;
                }
            }
        }
        if (!addedVariable) {
            return s + "0.0";
        }
        return s;
    }

    public void z() {
        this.f256a = null;
        this.d.clear();
        this.f257b = 0.0f;
        this.e = false;
    }

    public boolean t(h v) {
        return this.d.f(v);
    }

    public b h(h variable, int value) {
        this.f256a = variable;
        variable.h = value;
        this.f257b = value;
        this.e = true;
        return this;
    }

    public b l(h variable, int value) {
        if (value < 0) {
            this.f257b = value * (-1);
            this.d.j(variable, 1.0f);
        } else {
            this.f257b = value;
            this.d.j(variable, -1.0f);
        }
        return this;
    }

    public b m(h variableA, h variableB, int margin) {
        boolean inverse = false;
        if (margin != 0) {
            int m = margin;
            if (m < 0) {
                m *= -1;
                inverse = true;
            }
            this.f257b = m;
        }
        if (!inverse) {
            this.d.j(variableA, -1.0f);
            this.d.j(variableB, 1.0f);
        } else {
            this.d.j(variableA, 1.0f);
            this.d.j(variableB, -1.0f);
        }
        return this;
    }

    public b d(h error, int sign) {
        this.d.j(error, sign);
        return this;
    }

    public b n(h variableA, h variableB, h slack, int margin) {
        boolean inverse = false;
        if (margin != 0) {
            int m = margin;
            if (m < 0) {
                m *= -1;
                inverse = true;
            }
            this.f257b = m;
        }
        if (!inverse) {
            this.d.j(variableA, -1.0f);
            this.d.j(variableB, 1.0f);
            this.d.j(slack, 1.0f);
        } else {
            this.d.j(variableA, 1.0f);
            this.d.j(variableB, -1.0f);
            this.d.j(slack, -1.0f);
        }
        return this;
    }

    public b o(h variableA, h variableB, h slack, int margin) {
        boolean inverse = false;
        if (margin != 0) {
            int m = margin;
            if (m < 0) {
                m *= -1;
                inverse = true;
            }
            this.f257b = m;
        }
        if (!inverse) {
            this.d.j(variableA, -1.0f);
            this.d.j(variableB, 1.0f);
            this.d.j(slack, -1.0f);
        } else {
            this.d.j(variableA, 1.0f);
            this.d.j(variableB, -1.0f);
            this.d.j(slack, 1.0f);
        }
        return this;
    }

    public b k(float currentWeight, float totalWeights, float nextWeight, h variableStartA, h variableEndA, h variableStartB, h variableEndB) {
        this.f257b = 0.0f;
        if (totalWeights == 0.0f || currentWeight == nextWeight) {
            this.d.j(variableStartA, 1.0f);
            this.d.j(variableEndA, -1.0f);
            this.d.j(variableEndB, 1.0f);
            this.d.j(variableStartB, -1.0f);
        } else if (currentWeight == 0.0f) {
            this.d.j(variableStartA, 1.0f);
            this.d.j(variableEndA, -1.0f);
        } else if (nextWeight == 0.0f) {
            this.d.j(variableStartB, 1.0f);
            this.d.j(variableEndB, -1.0f);
        } else {
            float cw = currentWeight / totalWeights;
            float nw = nextWeight / totalWeights;
            float w = cw / nw;
            this.d.j(variableStartA, 1.0f);
            this.d.j(variableEndA, -1.0f);
            this.d.j(variableEndB, w);
            this.d.j(variableStartB, -w);
        }
        return this;
    }

    public b g(h variableA, h variableB, int marginA, float bias, h variableC, h variableD, int marginB) {
        if (variableB == variableC) {
            this.d.j(variableA, 1.0f);
            this.d.j(variableD, 1.0f);
            this.d.j(variableB, -2.0f);
            return this;
        }
        if (bias == 0.5f) {
            this.d.j(variableA, 1.0f);
            this.d.j(variableB, -1.0f);
            this.d.j(variableC, -1.0f);
            this.d.j(variableD, 1.0f);
            if (marginA > 0 || marginB > 0) {
                this.f257b = (-marginA) + marginB;
            }
        } else if (bias <= 0.0f) {
            this.d.j(variableA, -1.0f);
            this.d.j(variableB, 1.0f);
            this.f257b = marginA;
        } else if (bias < 1.0f) {
            this.d.j(variableA, (1.0f - bias) * 1.0f);
            this.d.j(variableB, (1.0f - bias) * (-1.0f));
            this.d.j(variableC, (-1.0f) * bias);
            this.d.j(variableD, bias * 1.0f);
            if (marginA > 0 || marginB > 0) {
                this.f257b = ((-marginA) * (1.0f - bias)) + (marginB * bias);
            }
        } else {
            this.d.j(variableD, -1.0f);
            this.d.j(variableC, 1.0f);
            this.f257b = -marginB;
        }
        return this;
    }

    public b c(d system, int strength) {
        this.d.j(system.o(strength, "ep"), 1.0f);
        this.d.j(system.o(strength, "em"), -1.0f);
        return this;
    }

    public b i(h variableA, h variableC, float percent) {
        this.d.j(variableA, -1.0f);
        this.d.j(variableC, percent);
        return this;
    }

    public b j(h variableA, h variableB, h variableC, h variableD, float ratio) {
        this.d.j(variableA, -1.0f);
        this.d.j(variableB, 1.0f);
        this.d.j(variableC, ratio);
        this.d.j(variableD, -ratio);
        return this;
    }

    public b p(h at, h ab, h bt, h bb, float angleComponent) {
        this.d.j(bt, 0.5f);
        this.d.j(bb, 0.5f);
        this.d.j(at, -0.5f);
        this.d.j(ab, -0.5f);
        this.f257b = -angleComponent;
        return this;
    }

    public void q() {
        float f = this.f257b;
        if (f < 0.0f) {
            this.f257b = f * (-1.0f);
            this.d.i();
        }
    }

    public boolean e(d system) {
        boolean addedExtra = false;
        h pivotCandidate = f(system);
        if (pivotCandidate == null) {
            addedExtra = true;
        } else {
            y(pivotCandidate);
        }
        if (this.d.k() == 0) {
            this.e = true;
        }
        return addedExtra;
    }

    public h f(d system) {
        h restrictedCandidate = null;
        h unrestrictedCandidate = null;
        float unrestrictedCandidateAmount = 0.0f;
        float restrictedCandidateAmount = 0.0f;
        boolean unrestrictedCandidateIsNew = false;
        boolean restrictedCandidateIsNew = false;
        int currentSize = this.d.k();
        for (int i = 0; i < currentSize; i++) {
            float amount = this.d.a(i);
            h variable = this.d.d(i);
            if (variable.l == h.a.UNRESTRICTED) {
                if (unrestrictedCandidate == null) {
                    unrestrictedCandidate = variable;
                    unrestrictedCandidateAmount = amount;
                    unrestrictedCandidateIsNew = v(variable);
                } else if (unrestrictedCandidateAmount > amount) {
                    unrestrictedCandidate = variable;
                    unrestrictedCandidateAmount = amount;
                    unrestrictedCandidateIsNew = v(variable);
                } else if (!unrestrictedCandidateIsNew && v(variable)) {
                    unrestrictedCandidate = variable;
                    unrestrictedCandidateAmount = amount;
                    unrestrictedCandidateIsNew = true;
                }
            } else if (unrestrictedCandidate == null && amount < 0.0f) {
                if (restrictedCandidate == null) {
                    restrictedCandidate = variable;
                    restrictedCandidateAmount = amount;
                    restrictedCandidateIsNew = v(variable);
                } else if (restrictedCandidateAmount > amount) {
                    restrictedCandidate = variable;
                    restrictedCandidateAmount = amount;
                    restrictedCandidateIsNew = v(variable);
                } else if (!restrictedCandidateIsNew && v(variable)) {
                    restrictedCandidate = variable;
                    restrictedCandidateAmount = amount;
                    restrictedCandidateIsNew = true;
                }
            }
        }
        if (unrestrictedCandidate != null) {
            return unrestrictedCandidate;
        }
        return restrictedCandidate;
    }

    public final boolean v(h variable) {
        return variable.o <= 1;
    }

    public void y(h v) {
        h hVar = this.f256a;
        if (hVar != null) {
            this.d.j(hVar, -1.0f);
            this.f256a.f = -1;
            this.f256a = null;
        }
        float amount = this.d.c(v, true) * (-1.0f);
        this.f256a = v;
        if (amount == 1.0f) {
            return;
        }
        this.f257b /= amount;
        this.d.g(amount);
    }

    @Override // a.f.a.d.a
    public boolean isEmpty() {
        return this.f256a == null && this.f257b == 0.0f && this.d.k() == 0;
    }

    public void C(d system, b definition, boolean removeFromDefinition) {
        float value = this.d.h(definition, removeFromDefinition);
        this.f257b += definition.f257b * value;
        if (removeFromDefinition) {
            definition.f256a.d(this);
        }
        if (this.f256a != null && this.d.k() == 0) {
            this.e = true;
            system.i = true;
        }
    }

    public void B(d system, h variable, boolean removeFromDefinition) {
        if (variable == null || !variable.i) {
            return;
        }
        float value = this.d.b(variable);
        this.f257b += variable.h * value;
        this.d.c(variable, removeFromDefinition);
        if (removeFromDefinition) {
            variable.d(this);
        }
        if (this.d.k() == 0) {
            this.e = true;
            system.i = true;
        }
    }

    public final h x(boolean[] avoid, h exclude) {
        float value = 0.0f;
        h pivot = null;
        h pivotSlack = null;
        float valueSlack = 0.0f;
        int currentSize = this.d.k();
        for (int i = 0; i < currentSize; i++) {
            float currentValue = this.d.a(i);
            if (currentValue < 0.0f) {
                h v = this.d.d(i);
                if ((avoid == null || !avoid[v.e]) && v != exclude) {
                    if (1 != 0) {
                        h.a aVar = v.l;
                        if ((aVar == h.a.SLACK || aVar == h.a.ERROR) && currentValue < value) {
                            value = currentValue;
                            pivot = v;
                        }
                    } else {
                        h.a aVar2 = v.l;
                        if (aVar2 == h.a.SLACK) {
                            if (currentValue < valueSlack) {
                                valueSlack = currentValue;
                                pivotSlack = v;
                            }
                        } else if (aVar2 == h.a.ERROR && currentValue < value) {
                            value = currentValue;
                            pivot = v;
                        }
                    }
                }
            }
        }
        if (1 != 0) {
            return pivot;
        }
        return pivot != null ? pivot : pivotSlack;
    }

    public h w(h exclude) {
        return x(null, exclude);
    }

    @Override // a.f.a.d.a
    public h a(d system, boolean[] avoid) {
        return x(avoid, null);
    }

    @Override // a.f.a.d.a
    public void clear() {
        this.d.clear();
        this.f256a = null;
        this.f257b = 0.0f;
    }

    public void u(d.a row) {
        if (row instanceof b) {
            b copiedRow = (b) row;
            this.f256a = null;
            this.d.clear();
            for (int i = 0; i < copiedRow.d.k(); i++) {
                h var = copiedRow.d.d(i);
                float val = copiedRow.d.a(i);
                this.d.e(var, val, true);
            }
        }
    }

    @Override // a.f.a.d.a
    public void b(h error) {
        float weight = 1.0f;
        int i = error.g;
        if (i == 1) {
            weight = 1.0f;
        } else if (i == 2) {
            weight = 1000.0f;
        } else if (i == 3) {
            weight = 1000000.0f;
        } else if (i == 4) {
            weight = 1.0E9f;
        } else if (i == 5) {
            weight = 1.0E12f;
        }
        this.d.j(error, weight);
    }

    public h r() {
        return this.f256a;
    }

    public void D(d system) {
        if (system.o.length == 0) {
            return;
        }
        boolean done = false;
        while (!done) {
            int currentSize = this.d.k();
            for (int i = 0; i < currentSize; i++) {
                h variable = this.d.d(i);
                if (variable.f != -1 || variable.i) {
                    this.c.add(variable);
                } else {
                    variable.getClass();
                }
            }
            int size = this.c.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    h variable2 = this.c.get(i2);
                    if (variable2.i) {
                        B(system, variable2, true);
                    } else {
                        variable2.getClass();
                        C(system, system.o[variable2.f], true);
                    }
                }
                this.c.clear();
            } else {
                done = true;
            }
        }
        if (this.f256a != null && this.d.k() == 0) {
            this.e = true;
            system.i = true;
        }
    }
}
