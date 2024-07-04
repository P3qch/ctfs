package a.f.a.k;

import a.f.a.k.d;
import a.f.a.k.e;

/* loaded from: classes.dex */
public class a extends i {
    public int w0 = 0;
    public boolean x0 = true;
    public int y0 = 0;
    public boolean z0 = false;

    @Override // a.f.a.k.e
    public boolean f() {
        return true;
    }

    public int m1() {
        return this.w0;
    }

    public void r1(int barrierType) {
        this.w0 = barrierType;
    }

    public void q1(boolean allowsGoneWidget) {
        this.x0 = allowsGoneWidget;
    }

    public boolean l1() {
        return this.x0;
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
    public String toString() {
        String debug = "[Barrier] " + p() + " {";
        for (int i = 0; i < this.v0; i++) {
            e widget = this.u0[i];
            if (i > 0) {
                debug = debug + ", ";
            }
            debug = debug + widget.p();
        }
        return debug + "}";
    }

    public void p1() {
        for (int i = 0; i < this.v0; i++) {
            e widget = this.u0[i];
            if (this.x0 || widget.f()) {
                int i2 = this.w0;
                if (i2 == 0 || i2 == 1) {
                    widget.H0(0, true);
                } else if (i2 == 2 || i2 == 3) {
                    widget.H0(1, true);
                }
            }
        }
    }

    @Override // a.f.a.k.e
    public void e(a.f.a.d system, boolean optimize) {
        d[] dVarArr;
        int i;
        d[] dVarArr2 = this.T;
        dVarArr2[0] = this.L;
        dVarArr2[2] = this.M;
        dVarArr2[1] = this.N;
        dVarArr2[3] = this.O;
        int i2 = 0;
        while (true) {
            dVarArr = this.T;
            if (i2 >= dVarArr.length) {
                break;
            }
            dVarArr[i2].i = system.q(dVarArr[i2]);
            i2++;
        }
        int i3 = this.w0;
        if (i3 >= 0 && i3 < 4) {
            d position = dVarArr[i3];
            if (!this.z0) {
                k1();
            }
            if (this.z0) {
                this.z0 = false;
                int i4 = this.w0;
                if (i4 == 0 || i4 == 1) {
                    system.f(this.L.i, this.c0);
                    system.f(this.N.i, this.c0);
                    return;
                } else {
                    if (i4 == 2 || i4 == 3) {
                        system.f(this.M.i, this.d0);
                        system.f(this.O.i, this.d0);
                        return;
                    }
                    return;
                }
            }
            boolean hasMatchConstraintWidgets = false;
            int i5 = 0;
            while (true) {
                if (i5 >= this.v0) {
                    break;
                }
                e widget = this.u0[i5];
                if (this.x0 || widget.f()) {
                    int i6 = this.w0;
                    if ((i6 == 0 || i6 == 1) && widget.w() == e.a.MATCH_CONSTRAINT && widget.L.f != null && widget.N.f != null) {
                        hasMatchConstraintWidgets = true;
                        break;
                    }
                    int i7 = this.w0;
                    if ((i7 == 2 || i7 == 3) && widget.M() == e.a.MATCH_CONSTRAINT && widget.M.f != null && widget.O.f != null) {
                        hasMatchConstraintWidgets = true;
                        break;
                    }
                }
                i5++;
            }
            boolean mHasHorizontalCenteredDependents = this.L.k() || this.N.k();
            boolean mHasVerticalCenteredDependents = this.M.k() || this.O.k();
            boolean applyEqualityOnReferences = !hasMatchConstraintWidgets && (((i = this.w0) == 0 && mHasHorizontalCenteredDependents) || ((i == 2 && mHasVerticalCenteredDependents) || ((i == 1 && mHasHorizontalCenteredDependents) || (i == 3 && mHasVerticalCenteredDependents))));
            int equalityOnReferencesStrength = 5;
            if (!applyEqualityOnReferences) {
                equalityOnReferencesStrength = 4;
            }
            for (int i8 = 0; i8 < this.v0; i8++) {
                e widget2 = this.u0[i8];
                if (this.x0 || widget2.f()) {
                    a.f.a.h target = system.q(widget2.T[this.w0]);
                    d[] dVarArr3 = widget2.T;
                    int i9 = this.w0;
                    dVarArr3[i9].i = target;
                    int margin = 0;
                    if (dVarArr3[i9].f != null && dVarArr3[i9].f.d == this) {
                        margin = 0 + dVarArr3[i9].g;
                    }
                    if (i9 == 0 || i9 == 2) {
                        system.i(position.i, target, this.y0 - margin);
                    } else {
                        system.g(position.i, target, this.y0 + margin);
                    }
                    system.e(position.i, target, this.y0 + margin, equalityOnReferencesStrength);
                }
            }
            int i10 = this.w0;
            if (i10 == 0) {
                system.e(this.N.i, this.L.i, 0, 8);
                system.e(this.L.i, this.X.N.i, 0, 4);
                system.e(this.L.i, this.X.L.i, 0, 0);
                return;
            }
            if (i10 == 1) {
                system.e(this.L.i, this.N.i, 0, 8);
                system.e(this.L.i, this.X.L.i, 0, 4);
                system.e(this.L.i, this.X.N.i, 0, 0);
            } else if (i10 == 2) {
                system.e(this.O.i, this.M.i, 0, 8);
                system.e(this.M.i, this.X.O.i, 0, 4);
                system.e(this.M.i, this.X.M.i, 0, 0);
            } else if (i10 == 3) {
                system.e(this.M.i, this.O.i, 0, 8);
                system.e(this.M.i, this.X.M.i, 0, 4);
                system.e(this.M.i, this.X.O.i, 0, 0);
            }
        }
    }

    public void s1(int margin) {
        this.y0 = margin;
    }

    public int n1() {
        return this.y0;
    }

    public int o1() {
        switch (this.w0) {
            case 0:
            case 1:
                return 0;
            case 2:
            case 3:
                return 1;
            default:
                return -1;
        }
    }

    public boolean k1() {
        int i;
        boolean hasAllWidgetsResolved = true;
        int i2 = 0;
        while (true) {
            i = this.v0;
            if (i2 >= i) {
                break;
            }
            e widget = this.u0[i2];
            if (this.x0 || widget.f()) {
                int i3 = this.w0;
                if ((i3 == 0 || i3 == 1) && !widget.g0()) {
                    hasAllWidgetsResolved = false;
                } else {
                    int i4 = this.w0;
                    if ((i4 == 2 || i4 == 3) && !widget.h0()) {
                        hasAllWidgetsResolved = false;
                    }
                }
            }
            i2++;
        }
        if (hasAllWidgetsResolved && i > 0) {
            int barrierPosition = 0;
            boolean initialized = false;
            for (int i5 = 0; i5 < this.v0; i5++) {
                e widget2 = this.u0[i5];
                if (this.x0 || widget2.f()) {
                    if (!initialized) {
                        int i6 = this.w0;
                        if (i6 == 0) {
                            barrierPosition = widget2.k(d.a.LEFT).d();
                        } else if (i6 == 1) {
                            barrierPosition = widget2.k(d.a.RIGHT).d();
                        } else if (i6 == 2) {
                            barrierPosition = widget2.k(d.a.TOP).d();
                        } else if (i6 == 3) {
                            barrierPosition = widget2.k(d.a.BOTTOM).d();
                        }
                        initialized = true;
                    }
                    int i7 = this.w0;
                    if (i7 == 0) {
                        barrierPosition = Math.min(barrierPosition, widget2.k(d.a.LEFT).d());
                    } else if (i7 == 1) {
                        barrierPosition = Math.max(barrierPosition, widget2.k(d.a.RIGHT).d());
                    } else if (i7 == 2) {
                        barrierPosition = Math.min(barrierPosition, widget2.k(d.a.TOP).d());
                    } else if (i7 == 3) {
                        barrierPosition = Math.max(barrierPosition, widget2.k(d.a.BOTTOM).d());
                    }
                }
            }
            int barrierPosition2 = barrierPosition + this.y0;
            int i8 = this.w0;
            if (i8 == 0 || i8 == 1) {
                u0(barrierPosition2, barrierPosition2);
            } else {
                x0(barrierPosition2, barrierPosition2);
            }
            this.z0 = true;
            return true;
        }
        return false;
    }
}
