package a.f.a.k.m;

import a.f.a.k.m.f;

/* loaded from: classes.dex */
public class k extends p {
    public k(a.f.a.k.e widget) {
        super(widget);
    }

    @Override // a.f.a.k.m.p
    public void f() {
        this.c = null;
        this.h.c();
    }

    @Override // a.f.a.k.m.p
    public boolean m() {
        return false;
    }

    public final void q(f node) {
        this.h.k.add(node);
        node.l.add(this.h);
    }

    @Override // a.f.a.k.m.p
    public void d() {
        a.f.a.k.e eVar = this.f295b;
        if (eVar instanceof a.f.a.k.a) {
            this.h.f286b = true;
            a.f.a.k.a barrier = (a.f.a.k.a) eVar;
            int type = barrier.m1();
            boolean allowsGoneWidget = barrier.l1();
            switch (type) {
                case 0:
                    this.h.e = f.a.LEFT;
                    for (int i = 0; i < barrier.v0; i++) {
                        a.f.a.k.e refWidget = barrier.u0[i];
                        if (allowsGoneWidget || refWidget.O() != 8) {
                            f target = refWidget.e.h;
                            target.k.add(this.h);
                            this.h.l.add(target);
                        }
                    }
                    q(this.f295b.e.h);
                    q(this.f295b.e.i);
                    return;
                case 1:
                    this.h.e = f.a.RIGHT;
                    for (int i2 = 0; i2 < barrier.v0; i2++) {
                        a.f.a.k.e refWidget2 = barrier.u0[i2];
                        if (allowsGoneWidget || refWidget2.O() != 8) {
                            f target2 = refWidget2.e.i;
                            target2.k.add(this.h);
                            this.h.l.add(target2);
                        }
                    }
                    q(this.f295b.e.h);
                    q(this.f295b.e.i);
                    return;
                case 2:
                    this.h.e = f.a.TOP;
                    for (int i3 = 0; i3 < barrier.v0; i3++) {
                        a.f.a.k.e refwidget = barrier.u0[i3];
                        if (allowsGoneWidget || refwidget.O() != 8) {
                            f target3 = refwidget.f.h;
                            target3.k.add(this.h);
                            this.h.l.add(target3);
                        }
                    }
                    q(this.f295b.f.h);
                    q(this.f295b.f.i);
                    return;
                case 3:
                    this.h.e = f.a.BOTTOM;
                    for (int i4 = 0; i4 < barrier.v0; i4++) {
                        a.f.a.k.e refwidget2 = barrier.u0[i4];
                        if (allowsGoneWidget || refwidget2.O() != 8) {
                            f target4 = refwidget2.f.i;
                            target4.k.add(this.h);
                            this.h.l.add(target4);
                        }
                    }
                    q(this.f295b.f.h);
                    q(this.f295b.f.i);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // a.f.a.k.m.p, a.f.a.k.m.d
    public void a(d dependency) {
        a.f.a.k.a barrier = (a.f.a.k.a) this.f295b;
        int type = barrier.m1();
        int min = -1;
        int max = 0;
        for (f node : this.h.l) {
            int value = node.g;
            if (min == -1 || value < min) {
                min = value;
            }
            if (max < value) {
                max = value;
            }
        }
        if (type == 0 || type == 2) {
            this.h.d(barrier.n1() + min);
        } else {
            this.h.d(barrier.n1() + max);
        }
    }

    @Override // a.f.a.k.m.p
    public void e() {
        a.f.a.k.e eVar = this.f295b;
        if (eVar instanceof a.f.a.k.a) {
            a.f.a.k.a barrier = (a.f.a.k.a) eVar;
            int type = barrier.m1();
            if (type == 0 || type == 1) {
                this.f295b.b1(this.h.g);
            } else {
                this.f295b.c1(this.h.g);
            }
        }
    }
}
