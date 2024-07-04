package a.f.a.k;

import a.f.a.k.d;
import a.f.a.k.e;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class g extends e {
    public float u0 = -1.0f;
    public int v0 = -1;
    public int w0 = -1;
    public d x0 = this.M;
    public int y0 = 0;
    public boolean z0;

    public g() {
        this.U.clear();
        this.U.add(this.x0);
        int count = this.T.length;
        for (int i = 0; i < count; i++) {
            this.T[i] = this.x0;
        }
    }

    @Override // a.f.a.k.e
    public boolean f() {
        return true;
    }

    public void p1(int orientation) {
        if (this.y0 == orientation) {
            return;
        }
        this.y0 = orientation;
        this.U.clear();
        if (this.y0 == 1) {
            this.x0 = this.L;
        } else {
            this.x0 = this.M;
        }
        this.U.add(this.x0);
        int count = this.T.length;
        for (int i = 0; i < count; i++) {
            this.T[i] = this.x0;
        }
    }

    public d g1() {
        return this.x0;
    }

    public int h1() {
        return this.y0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // a.f.a.k.e
    public d k(d.a anchorType) {
        switch (anchorType.ordinal()) {
            case 0:
            case 5:
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                return null;
            case 1:
            case 3:
                if (this.y0 == 1) {
                    return this.x0;
                }
                return null;
            case 2:
            case 4:
                if (this.y0 == 0) {
                    return this.x0;
                }
                return null;
            default:
                return null;
        }
    }

    public void o1(float value) {
        if (value > -1.0f) {
            this.u0 = value;
            this.v0 = -1;
            this.w0 = -1;
        }
    }

    public void m1(int value) {
        if (value > -1) {
            this.u0 = -1.0f;
            this.v0 = value;
            this.w0 = -1;
        }
    }

    public void n1(int value) {
        if (value > -1) {
            this.u0 = -1.0f;
            this.v0 = -1;
            this.w0 = value;
        }
    }

    public float k1() {
        return this.u0;
    }

    public int i1() {
        return this.v0;
    }

    public int j1() {
        return this.w0;
    }

    public void l1(int position) {
        this.x0.s(position);
        this.z0 = true;
    }

    @Override // a.f.a.k.e
    public boolean g0() {
        return this.z0;
    }

    @Override // a.f.a.k.e
    public boolean h0() {
        return this.z0;
    }

    @Override // a.f.a.k.e
    public void e(a.f.a.d system, boolean optimize) {
        f parent = (f) G();
        if (parent == null) {
            return;
        }
        d begin = parent.k(d.a.LEFT);
        d end = parent.k(d.a.RIGHT);
        e eVar = this.X;
        boolean parentWrapContent = eVar != null && eVar.W[0] == e.a.WRAP_CONTENT;
        if (this.y0 == 0) {
            begin = parent.k(d.a.TOP);
            end = parent.k(d.a.BOTTOM);
            e eVar2 = this.X;
            parentWrapContent = eVar2 != null && eVar2.W[1] == e.a.WRAP_CONTENT;
        }
        if (this.z0 && this.x0.m()) {
            a.f.a.h guide = system.q(this.x0);
            system.f(guide, this.x0.d());
            if (this.v0 != -1) {
                if (parentWrapContent) {
                    system.h(system.q(end), guide, 0, 5);
                }
            } else if (this.w0 != -1 && parentWrapContent) {
                a.f.a.h parentRight = system.q(end);
                system.h(guide, system.q(begin), 0, 5);
                system.h(parentRight, guide, 0, 5);
            }
            this.z0 = false;
            return;
        }
        if (this.v0 != -1) {
            a.f.a.h guide2 = system.q(this.x0);
            a.f.a.h parentLeft = system.q(begin);
            system.e(guide2, parentLeft, this.v0, 8);
            if (parentWrapContent) {
                system.h(system.q(end), guide2, 0, 5);
                return;
            }
            return;
        }
        if (this.w0 == -1) {
            if (this.u0 != -1.0f) {
                system.d(a.f.a.d.s(system, system.q(this.x0), system.q(end), this.u0));
                return;
            }
            return;
        }
        a.f.a.h guide3 = system.q(this.x0);
        a.f.a.h parentRight2 = system.q(end);
        system.e(guide3, parentRight2, -this.w0, 8);
        if (parentWrapContent) {
            system.h(guide3, system.q(begin), 0, 5);
            system.h(parentRight2, guide3, 0, 5);
        }
    }

    @Override // a.f.a.k.e
    public void f1(a.f.a.d system, boolean optimize) {
        if (G() == null) {
            return;
        }
        int value = system.x(this.x0);
        if (this.y0 == 1) {
            b1(value);
            c1(0);
            A0(G().t());
            Z0(0);
            return;
        }
        b1(0);
        c1(value);
        Z0(G().P());
        A0(0);
    }
}
