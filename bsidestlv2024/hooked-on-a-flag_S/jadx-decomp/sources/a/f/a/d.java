package a.f.a;

import a.f.a.h;
import a.f.a.k.d;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f260a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f261b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = false;
    public static int f = 1000;
    public static long g = 0;
    public static long h = 0;
    public a l;
    public b[] o;
    public final c v;
    public a y;
    public boolean i = false;
    public int j = 0;
    public HashMap<String, h> k = null;
    public int m = 32;
    public int n = 32;
    public boolean p = false;
    public boolean q = false;
    public boolean[] r = new boolean[32];
    public int s = 1;
    public int t = 0;
    public int u = 32;
    public h[] w = new h[f];
    public int x = 0;

    /* loaded from: classes.dex */
    public interface a {
        h a(d dVar, boolean[] zArr);

        void b(h hVar);

        void clear();

        boolean isEmpty();
    }

    public d() {
        this.o = null;
        this.o = new b[32];
        C();
        c cVar = new c();
        this.v = cVar;
        this.l = new g(cVar);
        this.y = new b(cVar);
    }

    public static void w() {
    }

    public final void y() {
        int i = this.m * 2;
        this.m = i;
        this.o = (b[]) Arrays.copyOf(this.o, i);
        c cVar = this.v;
        cVar.d = (h[]) Arrays.copyOf(cVar.d, this.m);
        int i2 = this.m;
        this.r = new boolean[i2];
        this.n = i2;
        this.u = i2;
    }

    public final void C() {
        for (int i = 0; i < this.t; i++) {
            b row = this.o[i];
            if (row != null) {
                ((f) this.v.f259b).b(row);
            }
            this.o[i] = null;
        }
    }

    public void D() {
        c cVar;
        int i = 0;
        while (true) {
            cVar = this.v;
            h[] hVarArr = cVar.d;
            if (i >= hVarArr.length) {
                break;
            }
            h variable = hVarArr[i];
            if (variable != null) {
                variable.e();
            }
            i++;
        }
        ((f) cVar.c).c(this.w, this.x);
        this.x = 0;
        Arrays.fill(this.v.d, (Object) null);
        this.j = 0;
        this.l.clear();
        this.s = 1;
        for (int i2 = 0; i2 < this.t; i2++) {
            b[] bVarArr = this.o;
            if (bVarArr[i2] != null) {
                bVarArr[i2].getClass();
            }
        }
        C();
        this.t = 0;
        this.y = new b(this.v);
    }

    public h q(Object anchor) {
        if (anchor == null) {
            return null;
        }
        if (this.s + 1 >= this.n) {
            y();
        }
        h variable = null;
        if (anchor instanceof a.f.a.k.d) {
            variable = ((a.f.a.k.d) anchor).h();
            if (variable == null) {
                ((a.f.a.k.d) anchor).r();
                variable = ((a.f.a.k.d) anchor).h();
            }
            int i = variable.e;
            if (i == -1 || i > this.j || this.v.d[i] == null) {
                if (i != -1) {
                    variable.e();
                }
                int i2 = this.j + 1;
                this.j = i2;
                this.s++;
                variable.e = i2;
                variable.l = h.a.UNRESTRICTED;
                this.v.d[i2] = variable;
            }
        }
        return variable;
    }

    public b r() {
        b row = (b) ((f) this.v.f259b).a();
        if (row == null) {
            row = new b(this.v);
            g++;
        } else {
            row.z();
        }
        h.c();
        return row;
    }

    public h t() {
        if (this.s + 1 >= this.n) {
            y();
        }
        h variable = a(h.a.SLACK, null);
        int i = this.j + 1;
        this.j = i;
        this.s++;
        variable.e = i;
        this.v.d[i] = variable;
        return variable;
    }

    public h p() {
        if (this.s + 1 >= this.n) {
            y();
        }
        h variable = a(h.a.SLACK, null);
        int i = this.j + 1;
        this.j = i;
        this.s++;
        variable.e = i;
        this.v.d[i] = variable;
        return variable;
    }

    public void m(b row, int sign, int strength) {
        h error = o(strength, null);
        row.d(error, sign);
    }

    public h o(int strength, String prefix) {
        if (this.s + 1 >= this.n) {
            y();
        }
        h variable = a(h.a.ERROR, prefix);
        int i = this.j + 1;
        this.j = i;
        this.s++;
        variable.e = i;
        variable.g = strength;
        this.v.d[i] = variable;
        this.l.b(variable);
        return variable;
    }

    public final h a(h.a type, String prefix) {
        h variable = (h) ((f) this.v.c).a();
        if (variable == null) {
            variable = new h(type);
            variable.g(type);
        } else {
            variable.e();
            variable.g(type);
        }
        int i = this.x;
        int i2 = f;
        if (i >= i2) {
            int i3 = i2 * 2;
            f = i3;
            this.w = (h[]) Arrays.copyOf(this.w, i3);
        }
        h[] hVarArr = this.w;
        int i4 = this.x;
        this.x = i4 + 1;
        hVarArr[i4] = variable;
        return variable;
    }

    public int x(Object object) {
        a.f.a.k.d anchor = (a.f.a.k.d) object;
        h variable = anchor.h();
        if (variable != null) {
            return (int) (variable.h + 0.5f);
        }
        return 0;
    }

    public void z() {
        if (this.l.isEmpty()) {
            n();
            return;
        }
        if (this.p || this.q) {
            boolean fullySolved = true;
            int i = 0;
            while (true) {
                if (i >= this.t) {
                    break;
                }
                b r = this.o[i];
                if (r.e) {
                    i++;
                } else {
                    fullySolved = false;
                    break;
                }
            }
            if (!fullySolved) {
                A(this.l);
                return;
            } else {
                n();
                return;
            }
        }
        A(this.l);
    }

    public void A(a goal) {
        u();
        B(goal);
        n();
    }

    public void d(b row) {
        h pivotCandidate;
        if (row == null) {
            return;
        }
        if (this.t + 1 >= this.u || this.s + 1 >= this.n) {
            y();
        }
        boolean added = false;
        if (!row.e) {
            row.D(this);
            if (row.isEmpty()) {
                return;
            }
            row.q();
            if (row.e(this)) {
                h extra = p();
                row.f256a = extra;
                int numRows = this.t;
                l(row);
                if (this.t == numRows + 1) {
                    added = true;
                    ((b) this.y).u(row);
                    B(this.y);
                    if (extra.f == -1) {
                        if (row.f256a == extra && (pivotCandidate = row.w(extra)) != null) {
                            row.y(pivotCandidate);
                        }
                        if (!row.e) {
                            row.f256a.h(this, row);
                        }
                        ((f) this.v.f259b).b(row);
                        this.t--;
                    }
                }
            }
            if (!row.s()) {
                return;
            }
        }
        if (!added) {
            l(row);
        }
    }

    public final void l(b row) {
        int i;
        if (row.e) {
            row.f256a.f(this, row.f257b);
        } else {
            b[] bVarArr = this.o;
            int i2 = this.t;
            bVarArr[i2] = row;
            h hVar = row.f256a;
            hVar.f = i2;
            this.t = i2 + 1;
            hVar.h(this, row);
        }
        if (this.i) {
            int i3 = 0;
            while (i3 < this.t) {
                if (this.o[i3] == null) {
                    System.out.println("WTF");
                }
                b[] bVarArr2 = this.o;
                if (bVarArr2[i3] != null && bVarArr2[i3].e) {
                    b removedRow = bVarArr2[i3];
                    removedRow.f256a.f(this, removedRow.f257b);
                    ((f) this.v.f259b).b(removedRow);
                    this.o[i3] = null;
                    int lastRow = i3 + 1;
                    int j = i3 + 1;
                    while (true) {
                        i = this.t;
                        if (j >= i) {
                            break;
                        }
                        b[] bVarArr3 = this.o;
                        bVarArr3[j - 1] = bVarArr3[j];
                        if (bVarArr3[j - 1].f256a.f == j) {
                            bVarArr3[j - 1].f256a.f = j - 1;
                        }
                        lastRow = j;
                        j++;
                    }
                    if (lastRow < i) {
                        this.o[lastRow] = null;
                    }
                    this.t = i - 1;
                    i3--;
                }
                i3++;
            }
            this.i = false;
        }
    }

    public final int B(a goal) {
        boolean done = false;
        int tries = 0;
        for (int i = 0; i < this.s; i++) {
            this.r[i] = false;
        }
        while (!done) {
            tries++;
            if (tries >= this.s * 2) {
                return tries;
            }
            if (((b) goal).r() != null) {
                this.r[((b) goal).r().e] = true;
            }
            h pivotCandidate = goal.a(this, this.r);
            if (pivotCandidate != null) {
                boolean[] zArr = this.r;
                int i2 = pivotCandidate.e;
                if (zArr[i2]) {
                    return tries;
                }
                zArr[i2] = true;
            }
            if (pivotCandidate != null) {
                float min = Float.MAX_VALUE;
                int pivotRowIndex = -1;
                for (int i3 = 0; i3 < this.t; i3++) {
                    b current = this.o[i3];
                    h variable = current.f256a;
                    if (variable.l != h.a.UNRESTRICTED && !current.e && current.t(pivotCandidate)) {
                        float a_j = current.d.b(pivotCandidate);
                        if (a_j < 0.0f) {
                            float value = (-current.f257b) / a_j;
                            if (value < min) {
                                min = value;
                                pivotRowIndex = i3;
                            }
                        }
                    }
                }
                if (pivotRowIndex > -1) {
                    b pivotEquation = this.o[pivotRowIndex];
                    pivotEquation.f256a.f = -1;
                    pivotEquation.y(pivotCandidate);
                    h hVar = pivotEquation.f256a;
                    hVar.f = pivotRowIndex;
                    hVar.h(this, pivotEquation);
                }
            } else {
                done = true;
            }
        }
        return tries;
    }

    public final int u() {
        float f2;
        a goal;
        boolean infeasibleSystem;
        a goal2 = null;
        int tries = 0;
        boolean infeasibleSystem2 = false;
        int i = 0;
        while (true) {
            f2 = 0.0f;
            if (i >= this.t) {
                break;
            }
            b[] bVarArr = this.o;
            h variable = bVarArr[i].f256a;
            if (variable.l == h.a.UNRESTRICTED || bVarArr[i].f257b >= 0.0f) {
                i++;
            } else {
                infeasibleSystem2 = true;
                break;
            }
        }
        if (infeasibleSystem2) {
            boolean done = false;
            tries = 0;
            while (!done) {
                tries++;
                float min = Float.MAX_VALUE;
                int strength = 0;
                int pivotRowIndex = -1;
                int pivotColumnIndex = -1;
                int i2 = 0;
                while (i2 < this.t) {
                    b current = this.o[i2];
                    h variable2 = current.f256a;
                    if (variable2.l != h.a.UNRESTRICTED && !current.e && current.f257b < f2) {
                        int size = current.d.k();
                        int j = 0;
                        while (j < size) {
                            h candidate = current.d.d(j);
                            float a_j = current.d.b(candidate);
                            if (a_j <= 0.0f) {
                                goal = goal2;
                                infeasibleSystem = infeasibleSystem2;
                            } else {
                                goal = goal2;
                                int k = 0;
                                while (true) {
                                    infeasibleSystem = infeasibleSystem2;
                                    if (k < 9) {
                                        float value = candidate.j[k] / a_j;
                                        if ((value < min && k == strength) || k > strength) {
                                            min = value;
                                            pivotRowIndex = i2;
                                            pivotColumnIndex = candidate.e;
                                            strength = k;
                                        }
                                        k++;
                                        infeasibleSystem2 = infeasibleSystem;
                                    }
                                }
                            }
                            j++;
                            goal2 = goal;
                            infeasibleSystem2 = infeasibleSystem;
                        }
                    }
                    i2++;
                    goal2 = goal2;
                    infeasibleSystem2 = infeasibleSystem2;
                    f2 = 0.0f;
                }
                a goal3 = goal2;
                boolean infeasibleSystem3 = infeasibleSystem2;
                if (pivotRowIndex != -1) {
                    b pivotEquation = this.o[pivotRowIndex];
                    pivotEquation.f256a.f = -1;
                    pivotEquation.y(this.v.d[pivotColumnIndex]);
                    h hVar = pivotEquation.f256a;
                    hVar.f = pivotRowIndex;
                    hVar.h(this, pivotEquation);
                } else {
                    done = true;
                }
                if (tries > this.s / 2) {
                    done = true;
                }
                goal2 = goal3;
                infeasibleSystem2 = infeasibleSystem3;
                f2 = 0.0f;
            }
        }
        return tries;
    }

    public final void n() {
        for (int i = 0; i < this.t; i++) {
            b row = this.o[i];
            row.f256a.h = row.f257b;
        }
    }

    public c v() {
        return this.v;
    }

    public void h(h a2, h b2, int margin, int strength) {
        b row = r();
        h slack = t();
        slack.g = 0;
        row.n(a2, b2, slack, margin);
        if (strength != 8) {
            float slackValue = row.d.b(slack);
            m(row, (int) ((-1.0f) * slackValue), strength);
        }
        d(row);
    }

    public void g(h a2, h b2, int margin) {
        b row = r();
        h slack = t();
        slack.g = 0;
        row.n(a2, b2, slack, margin);
        d(row);
    }

    public void j(h a2, h b2, int margin, int strength) {
        b row = r();
        h slack = t();
        slack.g = 0;
        row.o(a2, b2, slack, margin);
        if (strength != 8) {
            float slackValue = row.d.b(slack);
            m(row, (int) ((-1.0f) * slackValue), strength);
        }
        d(row);
    }

    public void i(h a2, h b2, int margin) {
        b row = r();
        h slack = t();
        slack.g = 0;
        row.o(a2, b2, slack, margin);
        d(row);
    }

    public void c(h a2, h b2, int m1, float bias, h c2, h d2, int m2, int strength) {
        b row = r();
        row.g(a2, b2, m1, bias, c2, d2, m2);
        if (strength != 8) {
            row.c(this, strength);
        }
        d(row);
    }

    public void k(h a2, h b2, h c2, h d2, float ratio, int strength) {
        b row = r();
        row.j(a2, b2, c2, d2, ratio);
        if (strength != 8) {
            row.c(this, strength);
        }
        d(row);
    }

    public b e(h a2, h b2, int margin, int strength) {
        if (strength == 8 && b2.i && a2.f == -1) {
            a2.f(this, b2.h + margin);
            return null;
        }
        b row = r();
        row.m(a2, b2, margin);
        if (strength != 8) {
            row.c(this, strength);
        }
        d(row);
        return row;
    }

    public void f(h a2, int value) {
        int i = a2.f;
        if (i == -1) {
            a2.f(this, value);
            for (int i2 = 0; i2 < this.j + 1; i2++) {
                h variable = this.v.d[i2];
                if (variable != null) {
                    variable.getClass();
                }
            }
            return;
        }
        int idx = a2.f;
        if (i != -1) {
            b row = this.o[idx];
            if (row.e) {
                row.f257b = value;
                return;
            }
            if (row.d.k() == 0) {
                row.e = true;
                row.f257b = value;
                return;
            } else {
                b newRow = r();
                newRow.l(a2, value);
                d(newRow);
                return;
            }
        }
        b row2 = r();
        row2.h(a2, value);
        d(row2);
    }

    public static b s(d linearSystem, h variableA, h variableC, float percent) {
        b row = linearSystem.r();
        row.i(variableA, variableC, percent);
        return row;
    }

    public void b(a.f.a.k.e widget, a.f.a.k.e target, float angle, int radius) {
        d.a aVar = d.a.LEFT;
        h Al = q(widget.k(aVar));
        d.a aVar2 = d.a.TOP;
        h At = q(widget.k(aVar2));
        d.a aVar3 = d.a.RIGHT;
        h Ar = q(widget.k(aVar3));
        d.a aVar4 = d.a.BOTTOM;
        h Ab = q(widget.k(aVar4));
        h Bl = q(target.k(aVar));
        h Bt = q(target.k(aVar2));
        h Br = q(target.k(aVar3));
        h Bb = q(target.k(aVar4));
        b row = r();
        double sin = Math.sin(angle);
        double d2 = radius;
        Double.isNaN(d2);
        float angleComponent = (float) (sin * d2);
        row.p(At, Ab, Bt, Bb, angleComponent);
        d(row);
        b row2 = r();
        double cos = Math.cos(angle);
        double d3 = radius;
        Double.isNaN(d3);
        float angleComponent2 = (float) (cos * d3);
        row2.p(Al, Ar, Bl, Br, angleComponent2);
        d(row2);
    }
}
