package a.f.a.k.m;

import a.f.a.k.e;
import a.f.a.k.m.b;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public a.f.a.k.f f283a;
    public a.f.a.k.f d;
    public b.InterfaceC0012b f;
    public b.a g;
    public ArrayList<m> h;

    /* renamed from: b, reason: collision with root package name */
    public boolean f284b = true;
    public boolean c = true;
    public ArrayList<p> e = new ArrayList<>();

    public e(a.f.a.k.f container) {
        new ArrayList();
        this.f = null;
        this.g = new b.a();
        this.h = new ArrayList<>();
        this.f283a = container;
        this.d = container;
    }

    public void n(b.InterfaceC0012b measurer) {
        this.f = measurer;
    }

    public final int e(a.f.a.k.f container, int orientation) {
        int count = this.h.size();
        long wrapSize = 0;
        for (int i = 0; i < count; i++) {
            m run = this.h.get(i);
            long size = run.b(container, orientation);
            wrapSize = Math.max(wrapSize, size);
        }
        int i2 = (int) wrapSize;
        return i2;
    }

    public boolean f(boolean optimizeWrap) {
        boolean optimizeWrap2 = optimizeWrap & true;
        if (this.f284b || this.c) {
            Iterator<a.f.a.k.e> it = this.f283a.u0.iterator();
            while (it.hasNext()) {
                a.f.a.k.e widget = it.next();
                widget.j();
                widget.f276b = false;
                widget.e.r();
                widget.f.q();
            }
            this.f283a.j();
            a.f.a.k.f fVar = this.f283a;
            fVar.f276b = false;
            fVar.e.r();
            this.f283a.f.q();
            this.c = false;
        }
        b(this.d);
        if (0 != 0) {
            return false;
        }
        this.f283a.b1(0);
        this.f283a.c1(0);
        e.a originalHorizontalDimension = this.f283a.q(0);
        e.a originalVerticalDimension = this.f283a.q(1);
        if (this.f284b) {
            c();
        }
        int x1 = this.f283a.Q();
        int y1 = this.f283a.R();
        this.f283a.e.h.d(x1);
        this.f283a.f.h.d(y1);
        m();
        e.a aVar = e.a.WRAP_CONTENT;
        if (originalHorizontalDimension == aVar || originalVerticalDimension == aVar) {
            if (optimizeWrap2) {
                Iterator<p> it2 = this.e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().m()) {
                        optimizeWrap2 = false;
                        break;
                    }
                }
            }
            if (optimizeWrap2 && originalHorizontalDimension == e.a.WRAP_CONTENT) {
                this.f283a.E0(e.a.FIXED);
                a.f.a.k.f fVar2 = this.f283a;
                fVar2.Z0(e(fVar2, 0));
                a.f.a.k.f fVar3 = this.f283a;
                fVar3.e.e.d(fVar3.P());
            }
            if (optimizeWrap2 && originalVerticalDimension == e.a.WRAP_CONTENT) {
                this.f283a.V0(e.a.FIXED);
                a.f.a.k.f fVar4 = this.f283a;
                fVar4.A0(e(fVar4, 1));
                a.f.a.k.f fVar5 = this.f283a;
                fVar5.f.e.d(fVar5.t());
            }
        }
        boolean checkRoot = false;
        a.f.a.k.f fVar6 = this.f283a;
        e.a[] aVarArr = fVar6.W;
        e.a aVar2 = aVarArr[0];
        e.a aVar3 = e.a.FIXED;
        if (aVar2 == aVar3 || aVarArr[0] == e.a.MATCH_PARENT) {
            int x2 = fVar6.P() + x1;
            this.f283a.e.i.d(x2);
            this.f283a.e.e.d(x2 - x1);
            m();
            a.f.a.k.f fVar7 = this.f283a;
            e.a[] aVarArr2 = fVar7.W;
            if (aVarArr2[1] == aVar3 || aVarArr2[1] == e.a.MATCH_PARENT) {
                int y2 = fVar7.t() + y1;
                this.f283a.f.i.d(y2);
                this.f283a.f.e.d(y2 - y1);
            }
            m();
            checkRoot = true;
        }
        Iterator<p> it3 = this.e.iterator();
        while (it3.hasNext()) {
            p run = it3.next();
            if (run.f295b != this.f283a || run.g) {
                run.e();
            }
        }
        boolean allResolved = true;
        Iterator<p> it4 = this.e.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            p run2 = it4.next();
            if (checkRoot || run2.f295b != this.f283a) {
                if (!run2.h.j) {
                    allResolved = false;
                    break;
                }
                if (!run2.i.j && !(run2 instanceof j)) {
                    allResolved = false;
                    break;
                }
                if (!run2.e.j && !(run2 instanceof c) && !(run2 instanceof j)) {
                    allResolved = false;
                    break;
                }
            }
        }
        this.f283a.E0(originalHorizontalDimension);
        this.f283a.V0(originalVerticalDimension);
        return allResolved;
    }

    public boolean g() {
        if (this.f284b) {
            Iterator<a.f.a.k.e> it = this.f283a.u0.iterator();
            while (it.hasNext()) {
                a.f.a.k.e widget = it.next();
                widget.j();
                widget.f276b = false;
                l lVar = widget.e;
                lVar.e.j = false;
                lVar.g = false;
                lVar.r();
                n nVar = widget.f;
                nVar.e.j = false;
                nVar.g = false;
                nVar.q();
            }
            this.f283a.j();
            a.f.a.k.f fVar = this.f283a;
            fVar.f276b = false;
            l lVar2 = fVar.e;
            lVar2.e.j = false;
            lVar2.g = false;
            lVar2.r();
            n nVar2 = this.f283a.f;
            nVar2.e.j = false;
            nVar2.g = false;
            nVar2.q();
            c();
        }
        b(this.d);
        if (0 != 0) {
            return false;
        }
        this.f283a.b1(0);
        this.f283a.c1(0);
        this.f283a.e.h.d(0);
        this.f283a.f.h.d(0);
        return true;
    }

    public boolean h(boolean optimizeWrap, int orientation) {
        e.a aVar;
        boolean optimizeWrap2 = optimizeWrap & true;
        e.a originalHorizontalDimension = this.f283a.q(0);
        e.a originalVerticalDimension = this.f283a.q(1);
        int x1 = this.f283a.Q();
        int y1 = this.f283a.R();
        if (optimizeWrap2 && (originalHorizontalDimension == (aVar = e.a.WRAP_CONTENT) || originalVerticalDimension == aVar)) {
            Iterator<p> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p run = it.next();
                if (run.f == orientation && !run.m()) {
                    optimizeWrap2 = false;
                    break;
                }
            }
            if (orientation == 0) {
                if (optimizeWrap2 && originalHorizontalDimension == e.a.WRAP_CONTENT) {
                    this.f283a.E0(e.a.FIXED);
                    a.f.a.k.f fVar = this.f283a;
                    fVar.Z0(e(fVar, 0));
                    a.f.a.k.f fVar2 = this.f283a;
                    fVar2.e.e.d(fVar2.P());
                }
            } else if (optimizeWrap2 && originalVerticalDimension == e.a.WRAP_CONTENT) {
                this.f283a.V0(e.a.FIXED);
                a.f.a.k.f fVar3 = this.f283a;
                fVar3.A0(e(fVar3, 1));
                a.f.a.k.f fVar4 = this.f283a;
                fVar4.f.e.d(fVar4.t());
            }
        }
        boolean checkRoot = false;
        if (orientation == 0) {
            a.f.a.k.f fVar5 = this.f283a;
            e.a[] aVarArr = fVar5.W;
            if (aVarArr[0] == e.a.FIXED || aVarArr[0] == e.a.MATCH_PARENT) {
                int x2 = fVar5.P() + x1;
                this.f283a.e.i.d(x2);
                this.f283a.e.e.d(x2 - x1);
                checkRoot = true;
            }
        } else {
            a.f.a.k.f fVar6 = this.f283a;
            e.a[] aVarArr2 = fVar6.W;
            if (aVarArr2[1] == e.a.FIXED || aVarArr2[1] == e.a.MATCH_PARENT) {
                int y2 = fVar6.t() + y1;
                this.f283a.f.i.d(y2);
                this.f283a.f.e.d(y2 - y1);
                checkRoot = true;
            }
        }
        m();
        Iterator<p> it2 = this.e.iterator();
        while (it2.hasNext()) {
            p run2 = it2.next();
            if (run2.f == orientation && (run2.f295b != this.f283a || run2.g)) {
                run2.e();
            }
        }
        boolean allResolved = true;
        Iterator<p> it3 = this.e.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            p run3 = it3.next();
            if (run3.f == orientation && (checkRoot || run3.f295b != this.f283a)) {
                if (!run3.h.j) {
                    allResolved = false;
                    break;
                }
                if (!run3.i.j) {
                    allResolved = false;
                    break;
                }
                if (!(run3 instanceof c) && !run3.e.j) {
                    allResolved = false;
                    break;
                }
            }
        }
        this.f283a.E0(originalHorizontalDimension);
        this.f283a.V0(originalVerticalDimension);
        return allResolved;
    }

    public final void l(a.f.a.k.e widget, e.a horizontalBehavior, int horizontalDimension, e.a verticalBehavior, int verticalDimension) {
        b.a aVar = this.g;
        aVar.d = horizontalBehavior;
        aVar.e = verticalBehavior;
        aVar.f = horizontalDimension;
        aVar.g = verticalDimension;
        ((ConstraintLayout.b) this.f).d(widget, aVar);
        widget.Z0(this.g.h);
        widget.A0(this.g.i);
        widget.z0(this.g.k);
        widget.p0(this.g.j);
    }

    public final boolean b(a.f.a.k.f constraintWidgetContainer) {
        e.a horizontal;
        e.a vertical;
        e.a aVar;
        e.a aVar2;
        Iterator<a.f.a.k.e> it = constraintWidgetContainer.u0.iterator();
        while (it.hasNext()) {
            a.f.a.k.e widget = it.next();
            e.a[] aVarArr = widget.W;
            e.a horizontal2 = aVarArr[0];
            e.a vertical2 = aVarArr[1];
            if (widget.O() == 8) {
                widget.f276b = true;
            } else {
                if (widget.y < 1.0f && horizontal2 == e.a.MATCH_CONSTRAINT) {
                    widget.t = 2;
                }
                if (widget.B < 1.0f && vertical2 == e.a.MATCH_CONSTRAINT) {
                    widget.u = 2;
                }
                if (widget.r() > 0.0f) {
                    e.a aVar3 = e.a.MATCH_CONSTRAINT;
                    if (horizontal2 == aVar3 && (vertical2 == e.a.WRAP_CONTENT || vertical2 == e.a.FIXED)) {
                        widget.t = 3;
                    } else if (vertical2 == aVar3 && (horizontal2 == e.a.WRAP_CONTENT || horizontal2 == e.a.FIXED)) {
                        widget.u = 3;
                    } else if (horizontal2 == aVar3 && vertical2 == aVar3) {
                        if (widget.t == 0) {
                            widget.t = 3;
                        }
                        if (widget.u == 0) {
                            widget.u = 3;
                        }
                    }
                }
                e.a aVar4 = e.a.MATCH_CONSTRAINT;
                if (horizontal2 == aVar4 && widget.t == 1 && (widget.L.f == null || widget.N.f == null)) {
                    horizontal = e.a.WRAP_CONTENT;
                } else {
                    horizontal = horizontal2;
                }
                if (vertical2 == aVar4 && widget.u == 1 && (widget.M.f == null || widget.O.f == null)) {
                    vertical = e.a.WRAP_CONTENT;
                } else {
                    vertical = vertical2;
                }
                l lVar = widget.e;
                lVar.d = horizontal;
                int i = widget.t;
                lVar.f294a = i;
                n nVar = widget.f;
                nVar.d = vertical;
                int i2 = widget.u;
                nVar.f294a = i2;
                e.a aVar5 = e.a.MATCH_PARENT;
                if ((horizontal == aVar5 || horizontal == e.a.FIXED || horizontal == e.a.WRAP_CONTENT) && (vertical == aVar5 || vertical == e.a.FIXED || vertical == e.a.WRAP_CONTENT)) {
                    int width = widget.P();
                    if (horizontal == aVar5) {
                        width = (constraintWidgetContainer.P() - widget.L.g) - widget.N.g;
                        horizontal = e.a.FIXED;
                    }
                    int height = widget.t();
                    if (vertical == aVar5) {
                        height = (constraintWidgetContainer.t() - widget.M.g) - widget.O.g;
                        vertical = e.a.FIXED;
                    }
                    l(widget, horizontal, width, vertical, height);
                    widget.e.e.d(widget.P());
                    widget.f.e.d(widget.t());
                    widget.f276b = true;
                } else {
                    if (horizontal == aVar4 && (vertical == (aVar2 = e.a.WRAP_CONTENT) || vertical == e.a.FIXED)) {
                        if (i == 3) {
                            if (vertical == aVar2) {
                                l(widget, aVar2, 0, aVar2, 0);
                            }
                            int height2 = widget.t();
                            int width2 = (int) ((height2 * widget.a0) + 0.5f);
                            e.a aVar6 = e.a.FIXED;
                            l(widget, aVar6, width2, aVar6, height2);
                            widget.e.e.d(widget.P());
                            widget.f.e.d(widget.t());
                            widget.f276b = true;
                        } else if (i == 1) {
                            l(widget, aVar2, 0, vertical, 0);
                            widget.e.e.m = widget.P();
                        } else if (i == 2) {
                            e.a[] aVarArr2 = constraintWidgetContainer.W;
                            e.a aVar7 = aVarArr2[0];
                            e.a aVar8 = e.a.FIXED;
                            if (aVar7 == aVar8 || aVarArr2[0] == aVar5) {
                                float percent = widget.y;
                                int width3 = (int) ((constraintWidgetContainer.P() * percent) + 0.5f);
                                int height3 = widget.t();
                                l(widget, aVar8, width3, vertical, height3);
                                widget.e.e.d(widget.P());
                                widget.f.e.d(widget.t());
                                widget.f276b = true;
                            }
                        } else {
                            a.f.a.k.d[] dVarArr = widget.T;
                            if (dVarArr[0].f == null || dVarArr[1].f == null) {
                                l(widget, aVar2, 0, vertical, 0);
                                widget.e.e.d(widget.P());
                                widget.f.e.d(widget.t());
                                widget.f276b = true;
                            }
                        }
                    }
                    if (vertical == aVar4 && (horizontal == (aVar = e.a.WRAP_CONTENT) || horizontal == e.a.FIXED)) {
                        if (i2 == 3) {
                            if (horizontal == aVar) {
                                l(widget, aVar, 0, aVar, 0);
                            }
                            int width4 = widget.P();
                            float ratio = widget.a0;
                            if (widget.s() == -1) {
                                ratio = 1.0f / ratio;
                            }
                            int height4 = (int) ((width4 * ratio) + 0.5f);
                            e.a aVar9 = e.a.FIXED;
                            l(widget, aVar9, width4, aVar9, height4);
                            widget.e.e.d(widget.P());
                            widget.f.e.d(widget.t());
                            widget.f276b = true;
                        } else if (i2 == 1) {
                            l(widget, horizontal, 0, aVar, 0);
                            widget.f.e.m = widget.t();
                        } else if (i2 == 2) {
                            e.a[] aVarArr3 = constraintWidgetContainer.W;
                            e.a aVar10 = aVarArr3[1];
                            e.a aVar11 = e.a.FIXED;
                            if (aVar10 == aVar11 || aVarArr3[1] == aVar5) {
                                float percent2 = widget.B;
                                int width5 = widget.P();
                                int height5 = (int) ((constraintWidgetContainer.t() * percent2) + 0.5f);
                                l(widget, horizontal, width5, aVar11, height5);
                                widget.e.e.d(widget.P());
                                widget.f.e.d(widget.t());
                                widget.f276b = true;
                            }
                        } else {
                            a.f.a.k.d[] dVarArr2 = widget.T;
                            if (dVarArr2[2].f == null || dVarArr2[3].f == null) {
                                l(widget, aVar, 0, vertical, 0);
                                widget.e.e.d(widget.P());
                                widget.f.e.d(widget.t());
                                widget.f276b = true;
                            }
                        }
                    }
                    if (horizontal == aVar4 && vertical == aVar4) {
                        if (i == 1 || i2 == 1) {
                            e.a aVar12 = e.a.WRAP_CONTENT;
                            l(widget, aVar12, 0, aVar12, 0);
                            widget.e.e.m = widget.P();
                            widget.f.e.m = widget.t();
                        } else if (i2 == 2 && i == 2) {
                            e.a[] aVarArr4 = constraintWidgetContainer.W;
                            e.a aVar13 = aVarArr4[0];
                            e.a aVar14 = e.a.FIXED;
                            if (aVar13 == aVar14 && aVarArr4[1] == aVar14) {
                                float horizPercent = widget.y;
                                float vertPercent = widget.B;
                                int width6 = (int) ((constraintWidgetContainer.P() * horizPercent) + 0.5f);
                                int height6 = (int) ((constraintWidgetContainer.t() * vertPercent) + 0.5f);
                                l(widget, aVar14, width6, aVar14, height6);
                                widget.e.e.d(widget.P());
                                widget.f.e.d(widget.t());
                                widget.f276b = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void m() {
        g gVar;
        Iterator<a.f.a.k.e> it = this.f283a.u0.iterator();
        while (it.hasNext()) {
            a.f.a.k.e widget = it.next();
            if (!widget.f276b) {
                e.a[] aVarArr = widget.W;
                boolean z = false;
                e.a horiz = aVarArr[0];
                e.a vert = aVarArr[1];
                int horizMatchConstraintsType = widget.t;
                int vertMatchConstraintsType = widget.u;
                e.a aVar = e.a.WRAP_CONTENT;
                boolean horizWrap = horiz == aVar || (horiz == e.a.MATCH_CONSTRAINT && horizMatchConstraintsType == 1);
                if (vert == aVar || (vert == e.a.MATCH_CONSTRAINT && vertMatchConstraintsType == 1)) {
                    z = true;
                }
                boolean vertWrap = z;
                g gVar2 = widget.e.e;
                boolean horizResolved = gVar2.j;
                g gVar3 = widget.f.e;
                boolean vertResolved = gVar3.j;
                if (horizResolved && vertResolved) {
                    e.a aVar2 = e.a.FIXED;
                    l(widget, aVar2, gVar2.g, aVar2, gVar3.g);
                    widget.f276b = true;
                } else if (horizResolved && vertWrap) {
                    l(widget, e.a.FIXED, gVar2.g, aVar, gVar3.g);
                    if (vert == e.a.MATCH_CONSTRAINT) {
                        widget.f.e.m = widget.t();
                    } else {
                        widget.f.e.d(widget.t());
                        widget.f276b = true;
                    }
                } else if (vertResolved && horizWrap) {
                    l(widget, aVar, gVar2.g, e.a.FIXED, gVar3.g);
                    if (horiz == e.a.MATCH_CONSTRAINT) {
                        widget.e.e.m = widget.P();
                    } else {
                        widget.e.e.d(widget.P());
                        widget.f276b = true;
                    }
                }
                if (widget.f276b && (gVar = widget.f.l) != null) {
                    gVar.d(widget.l());
                }
            }
        }
    }

    public void j() {
        this.f284b = true;
    }

    public void k() {
        this.c = true;
    }

    public void c() {
        d(this.e);
        this.h.clear();
        m.f290a = 0;
        i(this.f283a.e, 0, this.h);
        i(this.f283a.f, 1, this.h);
        this.f284b = false;
    }

    public void d(ArrayList<p> arrayList) {
        arrayList.clear();
        this.d.e.f();
        this.d.f.f();
        arrayList.add(this.d.e);
        arrayList.add(this.d.f);
        HashSet<ChainRun> chainRuns = null;
        Iterator<a.f.a.k.e> it = this.d.u0.iterator();
        while (it.hasNext()) {
            a.f.a.k.e widget = it.next();
            if (widget instanceof a.f.a.k.g) {
                arrayList.add(new j(widget));
            } else {
                if (widget.b0()) {
                    if (widget.c == null) {
                        widget.c = new c(widget, 0);
                    }
                    if (chainRuns == null) {
                        chainRuns = new HashSet<>();
                    }
                    chainRuns.add(widget.c);
                } else {
                    arrayList.add(widget.e);
                }
                if (widget.d0()) {
                    if (widget.d == null) {
                        widget.d = new c(widget, 1);
                    }
                    if (chainRuns == null) {
                        chainRuns = new HashSet<>();
                    }
                    chainRuns.add(widget.d);
                } else {
                    arrayList.add(widget.f);
                }
                if (widget instanceof a.f.a.k.i) {
                    arrayList.add(new k(widget));
                }
            }
        }
        if (chainRuns != null) {
            arrayList.addAll(chainRuns);
        }
        Iterator<p> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<p> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            p run = it3.next();
            if (run.f295b != this.d) {
                run.d();
            }
        }
    }

    public final void a(f node, int orientation, int direction, f end, ArrayList<m> arrayList, m group) {
        m group2;
        p run = node.d;
        if (run.c == null) {
            a.f.a.k.f fVar = this.f283a;
            if (run != fVar.e) {
                if (run == fVar.f) {
                    return;
                }
                if (group == null) {
                    m group3 = new m(run, direction);
                    arrayList.add(group3);
                    group2 = group3;
                } else {
                    group2 = group;
                }
                run.c = group2;
                group2.a(run);
                for (d dependent : run.h.k) {
                    if (dependent instanceof f) {
                        a((f) dependent, orientation, 0, end, arrayList, group2);
                    }
                }
                for (d dependent2 : run.i.k) {
                    if (dependent2 instanceof f) {
                        a((f) dependent2, orientation, 1, end, arrayList, group2);
                    }
                }
                if (orientation == 1 && (run instanceof n)) {
                    for (d dependent3 : ((n) run).k.k) {
                        if (dependent3 instanceof f) {
                            a((f) dependent3, orientation, 2, end, arrayList, group2);
                        }
                    }
                }
                for (f target : run.h.l) {
                    if (target == end) {
                        group2.getClass();
                    }
                    a(target, orientation, 0, end, arrayList, group2);
                }
                for (f target2 : run.i.l) {
                    if (target2 == end) {
                        group2.getClass();
                    }
                    a(target2, orientation, 1, end, arrayList, group2);
                }
                if (orientation == 1 && (run instanceof n)) {
                    Iterator<f> it = ((n) run).k.l.iterator();
                    while (it.hasNext()) {
                        a(it.next(), orientation, 2, end, arrayList, group2);
                    }
                }
            }
        }
    }

    public final void i(p run, int orientation, ArrayList<m> arrayList) {
        for (d dependent : run.h.k) {
            if (dependent instanceof f) {
                f node = (f) dependent;
                a(node, orientation, 0, run.i, arrayList, null);
            } else if (dependent instanceof p) {
                p dependentRun = (p) dependent;
                a(dependentRun.h, orientation, 0, run.i, arrayList, null);
            }
        }
        for (d dependent2 : run.i.k) {
            if (dependent2 instanceof f) {
                f node2 = (f) dependent2;
                a(node2, orientation, 1, run.h, arrayList, null);
            } else if (dependent2 instanceof p) {
                p dependentRun2 = (p) dependent2;
                a(dependentRun2.i, orientation, 1, run.h, arrayList, null);
            }
        }
        if (orientation == 1) {
            for (d dependent3 : ((n) run).k.k) {
                if (dependent3 instanceof f) {
                    f node3 = (f) dependent3;
                    a(node3, orientation, 2, null, arrayList, null);
                }
            }
        }
    }
}
