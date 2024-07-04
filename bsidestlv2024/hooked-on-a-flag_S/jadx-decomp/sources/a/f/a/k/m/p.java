package a.f.a.k.m;

import a.f.a.k.d;
import a.f.a.k.e;

/* loaded from: classes.dex */
public abstract class p implements d {

    /* renamed from: a, reason: collision with root package name */
    public int f294a;

    /* renamed from: b, reason: collision with root package name */
    public a.f.a.k.e f295b;
    public m c;
    public e.a d;
    public g e = new g(this);
    public int f = 0;
    public boolean g = false;
    public f h = new f(this);
    public f i = new f(this);
    public a j = a.NONE;

    /* loaded from: classes.dex */
    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract boolean m();

    public p(a.f.a.k.e widget) {
        this.f295b = widget;
    }

    public final f h(a.f.a.k.d anchor) {
        a.f.a.k.d dVar = anchor.f;
        if (dVar == null) {
            return null;
        }
        a.f.a.k.e targetWidget = dVar.d;
        d.a targetType = dVar.e;
        switch (targetType.ordinal()) {
            case 1:
                l run = targetWidget.e;
                f target = run.h;
                return target;
            case 2:
                n run2 = targetWidget.f;
                f target2 = run2.h;
                return target2;
            case 3:
                l run3 = targetWidget.e;
                f target3 = run3.i;
                return target3;
            case 4:
                n run4 = targetWidget.f;
                f target4 = run4.i;
                return target4;
            case 5:
                n run5 = targetWidget.f;
                f target5 = run5.k;
                return target5;
            default:
                return null;
        }
    }

    public void n(a.f.a.k.d startAnchor, a.f.a.k.d endAnchor, int orientation) {
        f startTarget = h(startAnchor);
        f endTarget = h(endAnchor);
        if (!startTarget.j || !endTarget.j) {
            return;
        }
        int startPos = startTarget.g + startAnchor.e();
        int endPos = endTarget.g - endAnchor.e();
        int distance = endPos - startPos;
        if (!this.e.j && this.d == e.a.MATCH_CONSTRAINT) {
            l(orientation, distance);
        }
        g gVar = this.e;
        if (!gVar.j) {
            return;
        }
        if (gVar.g == distance) {
            this.h.d(startPos);
            this.i.d(endPos);
            return;
        }
        a.f.a.k.e eVar = this.f295b;
        float bias = orientation == 0 ? eVar.u() : eVar.K();
        if (startTarget == endTarget) {
            startPos = startTarget.g;
            endPos = endTarget.g;
            bias = 0.5f;
        }
        int availableDistance = (endPos - startPos) - this.e.g;
        this.h.d((int) (startPos + 0.5f + (availableDistance * bias)));
        this.i.d(this.h.g + this.e.g);
    }

    public final void l(int orientation, int distance) {
        int value;
        switch (this.f294a) {
            case 0:
                this.e.d(g(distance, orientation));
                return;
            case 1:
                int wrapValue = g(this.e.m, orientation);
                this.e.d(Math.min(wrapValue, distance));
                return;
            case 2:
                a.f.a.k.e parent = this.f295b.G();
                if (parent != null) {
                    g gVar = (orientation == 0 ? parent.e : parent.f).e;
                    if (gVar.j) {
                        a.f.a.k.e eVar = this.f295b;
                        float percent = orientation == 0 ? eVar.y : eVar.B;
                        int targetDimensionValue = gVar.g;
                        int size = (int) ((targetDimensionValue * percent) + 0.5f);
                        this.e.d(g(size, orientation));
                        return;
                    }
                    return;
                }
                return;
            case 3:
                a.f.a.k.e eVar2 = this.f295b;
                p run = eVar2.e;
                e.a aVar = run.d;
                e.a aVar2 = e.a.MATCH_CONSTRAINT;
                if (aVar == aVar2 && run.f294a == 3) {
                    n nVar = eVar2.f;
                    if (nVar.d == aVar2 && nVar.f294a == 3) {
                        return;
                    }
                }
                if (orientation == 0) {
                    run = eVar2.f;
                }
                if (run.e.j) {
                    float ratio = eVar2.r();
                    if (orientation == 1) {
                        value = (int) ((run.e.g / ratio) + 0.5f);
                    } else {
                        value = (int) ((run.e.g * ratio) + 0.5f);
                    }
                    this.e.d(value);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void p() {
    }

    public void o() {
    }

    @Override // a.f.a.k.m.d
    public void a(d dependency) {
    }

    public final int g(int dimension, int orientation) {
        if (orientation == 0) {
            a.f.a.k.e eVar = this.f295b;
            int max = eVar.x;
            int min = eVar.w;
            int value = Math.max(min, dimension);
            if (max > 0) {
                value = Math.min(max, dimension);
            }
            if (value != dimension) {
                return value;
            }
            return dimension;
        }
        a.f.a.k.e eVar2 = this.f295b;
        int max2 = eVar2.A;
        int min2 = eVar2.z;
        int value2 = Math.max(min2, dimension);
        if (max2 > 0) {
            value2 = Math.min(max2, dimension);
        }
        if (value2 != dimension) {
            return value2;
        }
        return dimension;
    }

    public final f i(a.f.a.k.d anchor, int orientation) {
        a.f.a.k.d dVar = anchor.f;
        if (dVar == null) {
            return null;
        }
        a.f.a.k.e targetWidget = dVar.d;
        p run = orientation == 0 ? targetWidget.e : targetWidget.f;
        d.a targetType = dVar.e;
        switch (targetType.ordinal()) {
            case 1:
            case 2:
                f target = run.h;
                return target;
            case 3:
            case 4:
                f target2 = run.i;
                return target2;
            default:
                return null;
        }
    }

    public final void b(f node, f target, int margin) {
        node.l.add(target);
        node.f = margin;
        target.k.add(node);
    }

    public final void c(f node, f target, int marginFactor, g dimensionDependency) {
        node.l.add(target);
        node.l.add(this.e);
        node.h = marginFactor;
        node.i = dimensionDependency;
        target.k.add(node);
        dimensionDependency.k.add(node);
    }

    public long j() {
        if (this.e.j) {
            return r0.g;
        }
        return 0L;
    }

    public boolean k() {
        return this.g;
    }
}
