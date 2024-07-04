package a.f.a.k.m;

import a.f.a.k.d;
import a.f.a.k.e;
import a.f.a.k.m.f;
import a.f.a.k.m.p;
import net.sqlcipher.database.SQLiteCursor;

/* loaded from: classes.dex */
public class n extends p {
    public f k;
    public g l;

    public n(a.f.a.k.e widget) {
        super(widget);
        f fVar = new f(this);
        this.k = fVar;
        this.l = null;
        this.h.e = f.a.TOP;
        this.i.e = f.a.BOTTOM;
        fVar.e = f.a.BASELINE;
        this.f = 1;
    }

    public String toString() {
        return "VerticalRun " + this.f295b.p();
    }

    @Override // a.f.a.k.m.p
    public void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    public void q() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.k.c();
        this.k.j = false;
        this.e.j = false;
    }

    @Override // a.f.a.k.m.p
    public boolean m() {
        return this.d != e.a.MATCH_CONSTRAINT || this.f295b.u == 0;
    }

    @Override // a.f.a.k.m.p, a.f.a.k.m.d
    public void a(d dependency) {
        switch (this.j.ordinal()) {
            case 1:
                p();
                break;
            case 2:
                o();
                break;
            case 3:
                a.f.a.k.e eVar = this.f295b;
                n(eVar.M, eVar.O, 1);
                return;
        }
        g gVar = this.e;
        if (gVar.c && !gVar.j && this.d == e.a.MATCH_CONSTRAINT) {
            a.f.a.k.e eVar2 = this.f295b;
            switch (eVar2.u) {
                case 2:
                    a.f.a.k.e parent = eVar2.G();
                    if (parent != null) {
                        g gVar2 = parent.f.e;
                        if (gVar2.j) {
                            float percent = this.f295b.B;
                            int targetDimensionValue = gVar2.g;
                            int size = (int) ((targetDimensionValue * percent) + 0.5f);
                            this.e.d(size);
                            break;
                        }
                    }
                    break;
                case 3:
                    if (eVar2.e.e.j) {
                        int size2 = 0;
                        int ratioSide = eVar2.s();
                        switch (ratioSide) {
                            case SQLiteCursor.NO_COUNT /* -1 */:
                                size2 = (int) ((r4.e.e.g / this.f295b.r()) + 0.5f);
                                break;
                            case 0:
                                size2 = (int) ((r4.e.e.g * this.f295b.r()) + 0.5f);
                                break;
                            case 1:
                                size2 = (int) ((r4.e.e.g / this.f295b.r()) + 0.5f);
                                break;
                        }
                        this.e.d(size2);
                        break;
                    }
                    break;
            }
        }
        f fVar = this.h;
        if (fVar.c) {
            f fVar2 = this.i;
            if (!fVar2.c) {
                return;
            }
            if (fVar.j && fVar2.j && this.e.j) {
                return;
            }
            if (!this.e.j && this.d == e.a.MATCH_CONSTRAINT) {
                a.f.a.k.e eVar3 = this.f295b;
                if (eVar3.t == 0 && !eVar3.d0()) {
                    f startTarget = this.h.l.get(0);
                    f endTarget = this.i.l.get(0);
                    int i = startTarget.g;
                    f fVar3 = this.h;
                    int startPos = i + fVar3.f;
                    int endPos = endTarget.g + this.i.f;
                    int distance = endPos - startPos;
                    fVar3.d(startPos);
                    this.i.d(endPos);
                    this.e.d(distance);
                    return;
                }
            }
            f startTarget2 = this.e;
            if (!startTarget2.j && this.d == e.a.MATCH_CONSTRAINT && this.f294a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                f startTarget3 = this.h.l.get(0);
                f endTarget2 = this.i.l.get(0);
                int startPos2 = startTarget3.g + this.h.f;
                int endPos2 = endTarget2.g + this.i.f;
                int availableSpace = endPos2 - startPos2;
                g gVar3 = this.e;
                int i2 = gVar3.m;
                if (availableSpace < i2) {
                    gVar3.d(availableSpace);
                } else {
                    gVar3.d(i2);
                }
            }
            f startTarget4 = this.e;
            if (startTarget4.j && this.h.l.size() > 0 && this.i.l.size() > 0) {
                f startTarget5 = this.h.l.get(0);
                f endTarget3 = this.i.l.get(0);
                int startPos3 = startTarget5.g + this.h.f;
                int endPos3 = endTarget3.g + this.i.f;
                float bias = this.f295b.K();
                if (startTarget5 == endTarget3) {
                    startPos3 = startTarget5.g;
                    endPos3 = endTarget3.g;
                    bias = 0.5f;
                }
                int distance2 = (endPos3 - startPos3) - this.e.g;
                this.h.d((int) (startPos3 + 0.5f + (distance2 * bias)));
                this.i.d(this.h.g + this.e.g);
            }
        }
    }

    @Override // a.f.a.k.m.p
    public void d() {
        a.f.a.k.e parent;
        a.f.a.k.e parent2;
        a.f.a.k.e eVar = this.f295b;
        if (eVar.f276b) {
            this.e.d(eVar.t());
        }
        if (!this.e.j) {
            this.d = this.f295b.M();
            if (this.f295b.S()) {
                this.l = new a(this);
            }
            e.a aVar = this.d;
            if (aVar != e.a.MATCH_CONSTRAINT) {
                if (aVar == e.a.MATCH_PARENT && (parent2 = this.f295b.G()) != null && parent2.M() == e.a.FIXED) {
                    int resolvedDimension = (parent2.t() - this.f295b.M.e()) - this.f295b.O.e();
                    b(this.h, parent2.f.h, this.f295b.M.e());
                    b(this.i, parent2.f.i, -this.f295b.O.e());
                    this.e.d(resolvedDimension);
                    return;
                }
                if (this.d == e.a.FIXED) {
                    this.e.d(this.f295b.t());
                }
            }
        } else if (this.d == e.a.MATCH_PARENT && (parent = this.f295b.G()) != null && parent.M() == e.a.FIXED) {
            b(this.h, parent.f.h, this.f295b.M.e());
            b(this.i, parent.f.i, -this.f295b.O.e());
            return;
        }
        g gVar = this.e;
        boolean z = gVar.j;
        if (z) {
            a.f.a.k.e eVar2 = this.f295b;
            if (eVar2.f276b) {
                a.f.a.k.d[] dVarArr = eVar2.T;
                if (dVarArr[2].f != null && dVarArr[3].f != null) {
                    if (eVar2.d0()) {
                        this.h.f = this.f295b.T[2].e();
                        this.i.f = -this.f295b.T[3].e();
                    } else {
                        f startTarget = h(this.f295b.T[2]);
                        if (startTarget != null) {
                            b(this.h, startTarget, this.f295b.T[2].e());
                        }
                        f endTarget = h(this.f295b.T[3]);
                        if (endTarget != null) {
                            b(this.i, endTarget, -this.f295b.T[3].e());
                        }
                        this.h.f286b = true;
                        this.i.f286b = true;
                    }
                    if (this.f295b.S()) {
                        b(this.k, this.h, this.f295b.l());
                        return;
                    }
                    return;
                }
                if (dVarArr[2].f != null) {
                    f target = h(dVarArr[2]);
                    if (target != null) {
                        b(this.h, target, this.f295b.T[2].e());
                        b(this.i, this.h, this.e.g);
                        if (this.f295b.S()) {
                            b(this.k, this.h, this.f295b.l());
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (dVarArr[3].f != null) {
                    f target2 = h(dVarArr[3]);
                    if (target2 != null) {
                        b(this.i, target2, -this.f295b.T[3].e());
                        b(this.h, this.i, -this.e.g);
                    }
                    if (this.f295b.S()) {
                        b(this.k, this.h, this.f295b.l());
                        return;
                    }
                    return;
                }
                if (dVarArr[4].f != null) {
                    f target3 = h(dVarArr[4]);
                    if (target3 != null) {
                        b(this.k, target3, 0);
                        b(this.h, this.k, -this.f295b.l());
                        b(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                }
                if (!(eVar2 instanceof a.f.a.k.h) && eVar2.G() != null && this.f295b.k(d.a.CENTER).f == null) {
                    f top = this.f295b.G().f.h;
                    b(this.h, top, this.f295b.R());
                    b(this.i, this.h, this.e.g);
                    if (this.f295b.S()) {
                        b(this.k, this.h, this.f295b.l());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (!z && this.d == e.a.MATCH_CONSTRAINT) {
            a.f.a.k.e eVar3 = this.f295b;
            switch (eVar3.u) {
                case 2:
                    a.f.a.k.e parent3 = eVar3.G();
                    if (parent3 != null) {
                        f targetDimension = parent3.f.e;
                        this.e.l.add(targetDimension);
                        targetDimension.k.add(this.e);
                        g gVar2 = this.e;
                        gVar2.f286b = true;
                        gVar2.k.add(this.h);
                        this.e.k.add(this.i);
                        break;
                    }
                    break;
                case 3:
                    if (!eVar3.d0()) {
                        a.f.a.k.e eVar4 = this.f295b;
                        if (eVar4.t != 3) {
                            f targetDimension2 = eVar4.e.e;
                            this.e.l.add(targetDimension2);
                            targetDimension2.k.add(this.e);
                            g gVar3 = this.e;
                            gVar3.f286b = true;
                            gVar3.k.add(this.h);
                            this.e.k.add(this.i);
                            break;
                        }
                    }
                    break;
            }
        } else {
            gVar.b(this);
        }
        a.f.a.k.e eVar5 = this.f295b;
        a.f.a.k.d[] dVarArr2 = eVar5.T;
        if (dVarArr2[2].f != null && dVarArr2[3].f != null) {
            if (eVar5.d0()) {
                this.h.f = this.f295b.T[2].e();
                this.i.f = -this.f295b.T[3].e();
            } else {
                f startTarget2 = h(this.f295b.T[2]);
                f endTarget2 = h(this.f295b.T[3]);
                if (startTarget2 != null) {
                    startTarget2.b(this);
                }
                if (endTarget2 != null) {
                    endTarget2.b(this);
                }
                this.j = p.a.CENTER;
            }
            if (this.f295b.S()) {
                c(this.k, this.h, 1, this.l);
            }
        } else if (dVarArr2[2].f != null) {
            f target4 = h(dVarArr2[2]);
            if (target4 != null) {
                b(this.h, target4, this.f295b.T[2].e());
                c(this.i, this.h, 1, this.e);
                if (this.f295b.S()) {
                    c(this.k, this.h, 1, this.l);
                }
                e.a aVar2 = this.d;
                e.a aVar3 = e.a.MATCH_CONSTRAINT;
                if (aVar2 == aVar3 && this.f295b.r() > 0.0f) {
                    l lVar = this.f295b.e;
                    if (lVar.d == aVar3) {
                        lVar.e.k.add(this.e);
                        this.e.l.add(this.f295b.e.e);
                        this.e.f285a = this;
                    }
                }
            }
        } else if (dVarArr2[3].f != null) {
            f target5 = h(dVarArr2[3]);
            if (target5 != null) {
                b(this.i, target5, -this.f295b.T[3].e());
                c(this.h, this.i, -1, this.e);
                if (this.f295b.S()) {
                    c(this.k, this.h, 1, this.l);
                }
            }
        } else if (dVarArr2[4].f != null) {
            f target6 = h(dVarArr2[4]);
            if (target6 != null) {
                b(this.k, target6, 0);
                c(this.h, this.k, -1, this.l);
                c(this.i, this.h, 1, this.e);
            }
        } else if (!(eVar5 instanceof a.f.a.k.h) && eVar5.G() != null) {
            f top2 = this.f295b.G().f.h;
            b(this.h, top2, this.f295b.R());
            c(this.i, this.h, 1, this.e);
            if (this.f295b.S()) {
                c(this.k, this.h, 1, this.l);
            }
            e.a aVar4 = this.d;
            e.a aVar5 = e.a.MATCH_CONSTRAINT;
            if (aVar4 == aVar5 && this.f295b.r() > 0.0f) {
                l lVar2 = this.f295b.e;
                if (lVar2.d == aVar5) {
                    lVar2.e.k.add(this.e);
                    this.e.l.add(this.f295b.e.e);
                    this.e.f285a = this;
                }
            }
        }
        f top3 = this.e;
        if (top3.l.size() == 0) {
            this.e.c = true;
        }
    }

    @Override // a.f.a.k.m.p
    public void e() {
        f fVar = this.h;
        if (fVar.j) {
            this.f295b.c1(fVar.g);
        }
    }
}
