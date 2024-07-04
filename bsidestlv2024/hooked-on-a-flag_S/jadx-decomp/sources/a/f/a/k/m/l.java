package a.f.a.k.m;

import a.f.a.k.d;
import a.f.a.k.e;
import a.f.a.k.m.f;
import a.f.a.k.m.p;
import net.sqlcipher.database.SQLiteCursor;

/* loaded from: classes.dex */
public class l extends p {
    public static int[] k = new int[2];

    public l(a.f.a.k.e widget) {
        super(widget);
        this.h.e = f.a.LEFT;
        this.i.e = f.a.RIGHT;
        this.f = 0;
    }

    public String toString() {
        return "HorizontalRun " + this.f295b.p();
    }

    @Override // a.f.a.k.m.p
    public void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    public void r() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.e.j = false;
    }

    @Override // a.f.a.k.m.p
    public boolean m() {
        return this.d != e.a.MATCH_CONSTRAINT || this.f295b.t == 0;
    }

    @Override // a.f.a.k.m.p
    public void d() {
        a.f.a.k.e parent;
        a.f.a.k.e parent2;
        a.f.a.k.e eVar = this.f295b;
        if (eVar.f276b) {
            this.e.d(eVar.P());
        }
        if (!this.e.j) {
            e.a w = this.f295b.w();
            this.d = w;
            if (w != e.a.MATCH_CONSTRAINT) {
                e.a aVar = e.a.MATCH_PARENT;
                if (w == aVar && (parent2 = this.f295b.G()) != null && (parent2.w() == e.a.FIXED || parent2.w() == aVar)) {
                    int resolvedDimension = (parent2.P() - this.f295b.L.e()) - this.f295b.N.e();
                    b(this.h, parent2.e.h, this.f295b.L.e());
                    b(this.i, parent2.e.i, -this.f295b.N.e());
                    this.e.d(resolvedDimension);
                    return;
                }
                if (this.d == e.a.FIXED) {
                    this.e.d(this.f295b.P());
                }
            }
        } else {
            e.a aVar2 = this.d;
            e.a aVar3 = e.a.MATCH_PARENT;
            if (aVar2 == aVar3 && (parent = this.f295b.G()) != null && (parent.w() == e.a.FIXED || parent.w() == aVar3)) {
                b(this.h, parent.e.h, this.f295b.L.e());
                b(this.i, parent.e.i, -this.f295b.N.e());
                return;
            }
        }
        g gVar = this.e;
        if (gVar.j) {
            a.f.a.k.e eVar2 = this.f295b;
            if (eVar2.f276b) {
                a.f.a.k.d[] dVarArr = eVar2.T;
                if (dVarArr[0].f != null && dVarArr[1].f != null) {
                    if (eVar2.b0()) {
                        this.h.f = this.f295b.T[0].e();
                        this.i.f = -this.f295b.T[1].e();
                        return;
                    }
                    f startTarget = h(this.f295b.T[0]);
                    if (startTarget != null) {
                        b(this.h, startTarget, this.f295b.T[0].e());
                    }
                    f endTarget = h(this.f295b.T[1]);
                    if (endTarget != null) {
                        b(this.i, endTarget, -this.f295b.T[1].e());
                    }
                    this.h.f286b = true;
                    this.i.f286b = true;
                    return;
                }
                if (dVarArr[0].f != null) {
                    f target = h(dVarArr[0]);
                    if (target != null) {
                        b(this.h, target, this.f295b.T[0].e());
                        b(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                }
                if (dVarArr[1].f != null) {
                    f target2 = h(dVarArr[1]);
                    if (target2 != null) {
                        b(this.i, target2, -this.f295b.T[1].e());
                        b(this.h, this.i, -this.e.g);
                        return;
                    }
                    return;
                }
                if (!(eVar2 instanceof a.f.a.k.h) && eVar2.G() != null && this.f295b.k(d.a.CENTER).f == null) {
                    f left = this.f295b.G().e.h;
                    b(this.h, left, this.f295b.Q());
                    b(this.i, this.h, this.e.g);
                    return;
                }
                return;
            }
        }
        if (this.d == e.a.MATCH_CONSTRAINT) {
            a.f.a.k.e eVar3 = this.f295b;
            switch (eVar3.t) {
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
                    if (eVar3.u == 3) {
                        this.h.f285a = this;
                        this.i.f285a = this;
                        n nVar = eVar3.f;
                        nVar.h.f285a = this;
                        nVar.i.f285a = this;
                        gVar.f285a = this;
                        if (eVar3.d0()) {
                            this.e.l.add(this.f295b.f.e);
                            this.f295b.f.e.k.add(this.e);
                            n nVar2 = this.f295b.f;
                            nVar2.e.f285a = this;
                            this.e.l.add(nVar2.h);
                            this.e.l.add(this.f295b.f.i);
                            this.f295b.f.h.k.add(this.e);
                            this.f295b.f.i.k.add(this.e);
                            break;
                        } else if (this.f295b.b0()) {
                            this.f295b.f.e.l.add(this.e);
                            this.e.k.add(this.f295b.f.e);
                            break;
                        } else {
                            this.f295b.f.e.l.add(this.e);
                            break;
                        }
                    } else {
                        f targetDimension2 = eVar3.f.e;
                        gVar.l.add(targetDimension2);
                        targetDimension2.k.add(this.e);
                        this.f295b.f.h.k.add(this.e);
                        this.f295b.f.i.k.add(this.e);
                        g gVar3 = this.e;
                        gVar3.f286b = true;
                        gVar3.k.add(this.h);
                        this.e.k.add(this.i);
                        this.h.l.add(this.e);
                        this.i.l.add(this.e);
                        break;
                    }
            }
        }
        a.f.a.k.e eVar4 = this.f295b;
        a.f.a.k.d[] dVarArr2 = eVar4.T;
        if (dVarArr2[0].f != null && dVarArr2[1].f != null) {
            if (eVar4.b0()) {
                this.h.f = this.f295b.T[0].e();
                this.i.f = -this.f295b.T[1].e();
                return;
            }
            f startTarget2 = h(this.f295b.T[0]);
            f endTarget2 = h(this.f295b.T[1]);
            if (startTarget2 != null) {
                startTarget2.b(this);
            }
            if (endTarget2 != null) {
                endTarget2.b(this);
            }
            this.j = p.a.CENTER;
            return;
        }
        if (dVarArr2[0].f != null) {
            f target3 = h(dVarArr2[0]);
            if (target3 != null) {
                b(this.h, target3, this.f295b.T[0].e());
                c(this.i, this.h, 1, this.e);
                return;
            }
            return;
        }
        if (dVarArr2[1].f != null) {
            f target4 = h(dVarArr2[1]);
            if (target4 != null) {
                b(this.i, target4, -this.f295b.T[1].e());
                c(this.h, this.i, -1, this.e);
                return;
            }
            return;
        }
        if (!(eVar4 instanceof a.f.a.k.h) && eVar4.G() != null) {
            f left2 = this.f295b.G().e.h;
            b(this.h, left2, this.f295b.Q());
            c(this.i, this.h, 1, this.e);
        }
    }

    public final void q(int[] dimensions, int x1, int x2, int y1, int y2, float ratio, int side) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        switch (side) {
            case SQLiteCursor.NO_COUNT /* -1 */:
                int candidateX1 = (int) ((dy * ratio) + 0.5f);
                int candidateY2 = (int) ((dx / ratio) + 0.5f);
                if (candidateX1 <= dx && dy <= dy) {
                    dimensions[0] = candidateX1;
                    dimensions[1] = dy;
                    return;
                } else {
                    if (dx <= dx && candidateY2 <= dy) {
                        dimensions[0] = dx;
                        dimensions[1] = candidateY2;
                        return;
                    }
                    return;
                }
            case 0:
                int horizontalSide = (int) ((dy * ratio) + 0.5f);
                dimensions[0] = horizontalSide;
                dimensions[1] = dy;
                return;
            case 1:
                int verticalSide = (int) ((dx * ratio) + 0.5f);
                dimensions[0] = dx;
                dimensions[1] = verticalSide;
                return;
            default:
                return;
        }
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
                n(eVar.L, eVar.N, 0);
                return;
        }
        if (!this.e.j && this.d == e.a.MATCH_CONSTRAINT) {
            a.f.a.k.e eVar2 = this.f295b;
            switch (eVar2.t) {
                case 2:
                    a.f.a.k.e parent = eVar2.G();
                    if (parent != null) {
                        g gVar = parent.e.e;
                        if (gVar.j) {
                            float percent = this.f295b.y;
                            int targetDimensionValue = gVar.g;
                            int size = (int) ((targetDimensionValue * percent) + 0.5f);
                            this.e.d(size);
                            break;
                        }
                    }
                    break;
                case 3:
                    int i = eVar2.u;
                    if (i == 0 || i == 3) {
                        n nVar = eVar2.f;
                        f secondStart = nVar.h;
                        f secondEnd = nVar.i;
                        boolean s1 = eVar2.L.f != null;
                        boolean s2 = eVar2.M.f != null;
                        boolean e1 = eVar2.N.f != null;
                        boolean e2 = eVar2.O.f != null;
                        int definedSide = eVar2.s();
                        if (s1 && s2 && e1 && e2) {
                            float ratio = this.f295b.r();
                            if (secondStart.j && secondEnd.j) {
                                f fVar = this.h;
                                if (!fVar.c || !this.i.c) {
                                    return;
                                }
                                q(k, fVar.l.get(0).g + this.h.f, this.i.l.get(0).g - this.i.f, secondStart.g + secondStart.f, secondEnd.g - secondEnd.f, ratio, definedSide);
                                this.e.d(k[0]);
                                this.f295b.f.e.d(k[1]);
                                return;
                            }
                            f fVar2 = this.h;
                            if (fVar2.j) {
                                f fVar3 = this.i;
                                if (fVar3.j) {
                                    if (!secondStart.c || !secondEnd.c) {
                                        return;
                                    }
                                    q(k, fVar2.g + fVar2.f, fVar3.g - fVar3.f, secondStart.l.get(0).g + secondStart.f, secondEnd.l.get(0).g - secondEnd.f, ratio, definedSide);
                                    this.e.d(k[0]);
                                    this.f295b.f.e.d(k[1]);
                                }
                            }
                            f fVar4 = this.h;
                            if (!fVar4.c || !this.i.c || !secondStart.c || !secondEnd.c) {
                                return;
                            }
                            q(k, fVar4.l.get(0).g + this.h.f, this.i.l.get(0).g - this.i.f, secondStart.l.get(0).g + secondStart.f, secondEnd.l.get(0).g - secondEnd.f, ratio, definedSide);
                            this.e.d(k[0]);
                            this.f295b.f.e.d(k[1]);
                            break;
                        } else if (s1 && e1) {
                            if (!this.h.c || !this.i.c) {
                                return;
                            }
                            float ratio2 = this.f295b.r();
                            int x1 = this.h.l.get(0).g + this.h.f;
                            int x2 = this.i.l.get(0).g - this.i.f;
                            switch (definedSide) {
                                case SQLiteCursor.NO_COUNT /* -1 */:
                                case 0:
                                    int ldx = g(x2 - x1, 0);
                                    int dy = (int) ((ldx * ratio2) + 0.5f);
                                    int ldy = g(dy, 1);
                                    if (dy != ldy) {
                                        ldx = (int) ((ldy / ratio2) + 0.5f);
                                    }
                                    this.e.d(ldx);
                                    this.f295b.f.e.d(ldy);
                                    break;
                                case 1:
                                    int ldx2 = g(x2 - x1, 0);
                                    int dy2 = (int) ((ldx2 / ratio2) + 0.5f);
                                    int ldy2 = g(dy2, 1);
                                    if (dy2 != ldy2) {
                                        ldx2 = (int) ((ldy2 * ratio2) + 0.5f);
                                    }
                                    this.e.d(ldx2);
                                    this.f295b.f.e.d(ldy2);
                                    break;
                            }
                        } else if (s2 && e2) {
                            if (!secondStart.c || !secondEnd.c) {
                                return;
                            }
                            float ratio3 = this.f295b.r();
                            int y1 = secondStart.l.get(0).g + secondStart.f;
                            int y2 = secondEnd.l.get(0).g - secondEnd.f;
                            switch (definedSide) {
                                case SQLiteCursor.NO_COUNT /* -1 */:
                                case 1:
                                    int dy3 = y2 - y1;
                                    int ldy3 = g(dy3, 1);
                                    int dx = (int) ((ldy3 / ratio3) + 0.5f);
                                    int ldx3 = g(dx, 0);
                                    if (dx != ldx3) {
                                        ldy3 = (int) ((ldx3 * ratio3) + 0.5f);
                                    }
                                    this.e.d(ldx3);
                                    this.f295b.f.e.d(ldy3);
                                    break;
                                case 0:
                                    int dy4 = y2 - y1;
                                    int ldy4 = g(dy4, 1);
                                    int dx2 = (int) ((ldy4 * ratio3) + 0.5f);
                                    int ldx4 = g(dx2, 0);
                                    if (dx2 != ldx4) {
                                        ldy4 = (int) ((ldx4 / ratio3) + 0.5f);
                                    }
                                    this.e.d(ldx4);
                                    this.f295b.f.e.d(ldy4);
                                    break;
                            }
                        }
                    } else {
                        int size2 = 0;
                        int ratioSide = eVar2.s();
                        switch (ratioSide) {
                            case SQLiteCursor.NO_COUNT /* -1 */:
                                size2 = (int) ((r2.f.e.g * this.f295b.r()) + 0.5f);
                                break;
                            case 0:
                                size2 = (int) ((r2.f.e.g / this.f295b.r()) + 0.5f);
                                break;
                            case 1:
                                size2 = (int) ((r2.f.e.g * this.f295b.r()) + 0.5f);
                                break;
                        }
                        this.e.d(size2);
                        break;
                    }
                    break;
            }
        }
        f fVar5 = this.h;
        if (fVar5.c) {
            f fVar6 = this.i;
            if (!fVar6.c) {
                return;
            }
            if (fVar5.j && fVar6.j && this.e.j) {
                return;
            }
            if (!this.e.j && this.d == e.a.MATCH_CONSTRAINT) {
                a.f.a.k.e eVar3 = this.f295b;
                if (eVar3.t == 0 && !eVar3.b0()) {
                    f startTarget = this.h.l.get(0);
                    f endTarget = this.i.l.get(0);
                    int i2 = startTarget.g;
                    f fVar7 = this.h;
                    int startPos = i2 + fVar7.f;
                    int endPos = endTarget.g + this.i.f;
                    int distance = endPos - startPos;
                    fVar7.d(startPos);
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
                int value = Math.min(availableSpace, this.e.m);
                a.f.a.k.e eVar4 = this.f295b;
                int max = eVar4.x;
                int min = eVar4.w;
                int value2 = Math.max(min, value);
                if (max > 0) {
                    value2 = Math.min(max, value2);
                }
                this.e.d(value2);
            }
            f startTarget4 = this.e;
            if (!startTarget4.j) {
                return;
            }
            f startTarget5 = this.h.l.get(0);
            f endTarget3 = this.i.l.get(0);
            int startPos3 = startTarget5.g + this.h.f;
            int endPos3 = endTarget3.g + this.i.f;
            float bias = this.f295b.u();
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

    @Override // a.f.a.k.m.p
    public void e() {
        f fVar = this.h;
        if (fVar.j) {
            this.f295b.b1(fVar.g);
        }
    }
}
