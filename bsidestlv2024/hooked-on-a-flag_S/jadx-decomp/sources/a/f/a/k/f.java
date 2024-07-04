package a.f.a.k;

import a.f.a.k.e;
import a.f.a.k.m.b;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class f extends l {
    public int B0;
    public int C0;
    public int x0;
    public a.f.a.k.m.b v0 = new a.f.a.k.m.b(this);
    public a.f.a.k.m.e w0 = new a.f.a.k.m.e(this);
    public b.InterfaceC0012b y0 = null;
    public boolean z0 = false;
    public a.f.a.d A0 = new a.f.a.d();
    public int D0 = 0;
    public int E0 = 0;
    public c[] F0 = new c[4];
    public c[] G0 = new c[4];
    public int H0 = 257;
    public boolean I0 = false;
    public boolean J0 = false;
    public WeakReference<d> K0 = null;
    public WeakReference<d> L0 = null;
    public WeakReference<d> M0 = null;
    public WeakReference<d> N0 = null;
    public HashSet<e> O0 = new HashSet<>();
    public b.a P0 = new b.a();

    public void B1() {
        this.w0.j();
    }

    public void C1() {
        this.w0.k();
    }

    public boolean v1(boolean optimizeWrap) {
        return this.w0.f(optimizeWrap);
    }

    public boolean w1(boolean optimizeWrap) {
        return this.w0.g();
    }

    public boolean x1(boolean optimizeWrap, int orientation) {
        return this.w0.h(optimizeWrap, orientation);
    }

    public long G1(int optimizationLevel, int widthMode, int widthSize, int heightMode, int heightSize, int lastMeasureWidth, int lastMeasureHeight, int paddingX, int paddingY) {
        this.B0 = paddingX;
        this.C0 = paddingY;
        this.v0.d(this, optimizationLevel, widthMode, widthSize, heightMode, heightSize);
        return 0L;
    }

    public void P1() {
        this.v0.e(this);
    }

    public void K1(b.InterfaceC0012b measurer) {
        this.y0 = measurer;
        this.w0.n(measurer);
    }

    public b.InterfaceC0012b y1() {
        return this.y0;
    }

    public void L1(int value) {
        this.H0 = value;
        a.f.a.d.f260a = I1(512);
    }

    public int z1() {
        return this.H0;
    }

    public boolean I1(int feature) {
        return (this.H0 & feature) == feature;
    }

    @Override // a.f.a.k.l, a.f.a.k.e
    public void m0() {
        this.A0.D();
        this.B0 = 0;
        this.C0 = 0;
        super.m0();
    }

    public boolean F1() {
        return this.I0;
    }

    public boolean D1() {
        return this.J0;
    }

    public void u1(d top) {
        WeakReference<d> weakReference = this.K0;
        if (weakReference == null || weakReference.get() == null || top.d() > this.K0.get().d()) {
            this.K0 = new WeakReference<>(top);
        }
    }

    public void p1(d left) {
        WeakReference<d> weakReference = this.L0;
        if (weakReference == null || weakReference.get() == null || left.d() > this.L0.get().d()) {
            this.L0 = new WeakReference<>(left);
        }
    }

    public void t1(d bottom) {
        WeakReference<d> weakReference = this.M0;
        if (weakReference == null || weakReference.get() == null || bottom.d() > this.M0.get().d()) {
            this.M0 = new WeakReference<>(bottom);
        }
    }

    public void o1(d right) {
        WeakReference<d> weakReference = this.N0;
        if (weakReference == null || weakReference.get() == null || right.d() > this.N0.get().d()) {
            this.N0 = new WeakReference<>(right);
        }
    }

    public final void r1(d constraintAnchor, a.f.a.h parentMin) {
        a.f.a.h variable = this.A0.q(constraintAnchor);
        this.A0.h(variable, parentMin, 0, 5);
    }

    public final void q1(d constraintAnchor, a.f.a.h parentMax) {
        a.f.a.h variable = this.A0.q(constraintAnchor);
        this.A0.h(parentMax, variable, 0, 5);
    }

    public boolean m1(a.f.a.d system) {
        int orientation;
        boolean optimize = I1(64);
        e(system, optimize);
        int count = this.u0.size();
        boolean hasBarriers = false;
        for (int i = 0; i < count; i++) {
            e widget = this.u0.get(i);
            widget.H0(0, false);
            widget.H0(1, false);
            if (widget instanceof a) {
                hasBarriers = true;
            }
        }
        if (hasBarriers) {
            for (int i2 = 0; i2 < count; i2++) {
                e widget2 = this.u0.get(i2);
                if (widget2 instanceof a) {
                    ((a) widget2).p1();
                }
            }
        }
        this.O0.clear();
        for (int i3 = 0; i3 < count; i3++) {
            e widget3 = this.u0.get(i3);
            if (widget3.d()) {
                if (widget3 instanceof k) {
                    this.O0.add(widget3);
                } else {
                    widget3.e(system, optimize);
                }
            }
        }
        while (this.O0.size() > 0) {
            int numLayouts = this.O0.size();
            Iterator<e> it = this.O0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k layout = (k) it.next();
                if (layout.l1(this.O0)) {
                    layout.e(system, optimize);
                    this.O0.remove(layout);
                    break;
                }
            }
            if (numLayouts == this.O0.size()) {
                Iterator<e> it2 = this.O0.iterator();
                while (it2.hasNext()) {
                    it2.next().e(system, optimize);
                }
                this.O0.clear();
            }
        }
        if (a.f.a.d.f260a) {
            HashSet<e> hashSet = new HashSet<>();
            for (int i4 = 0; i4 < count; i4++) {
                e widget4 = this.u0.get(i4);
                if (!widget4.d()) {
                    hashSet.add(widget4);
                }
            }
            if (w() != e.a.WRAP_CONTENT) {
                orientation = 1;
            } else {
                orientation = 0;
            }
            c(this, system, hashSet, orientation, false);
            Iterator<e> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                e widget5 = it3.next();
                j.a(this, system, widget5);
                widget5.e(system, optimize);
            }
        } else {
            for (int i5 = 0; i5 < count; i5++) {
                e widget6 = this.u0.get(i5);
                if (widget6 instanceof f) {
                    e.a[] aVarArr = widget6.W;
                    e.a horizontalBehaviour = aVarArr[0];
                    e.a verticalBehaviour = aVarArr[1];
                    e.a aVar = e.a.WRAP_CONTENT;
                    if (horizontalBehaviour == aVar) {
                        widget6.E0(e.a.FIXED);
                    }
                    if (verticalBehaviour == aVar) {
                        widget6.V0(e.a.FIXED);
                    }
                    widget6.e(system, optimize);
                    if (horizontalBehaviour == aVar) {
                        widget6.E0(horizontalBehaviour);
                    }
                    if (verticalBehaviour == aVar) {
                        widget6.V0(verticalBehaviour);
                    }
                } else {
                    j.a(this, system, widget6);
                    if (!widget6.d()) {
                        widget6.e(system, optimize);
                    }
                }
            }
        }
        int i6 = this.D0;
        if (i6 > 0) {
            b.b(this, system, null, 0);
        }
        if (this.E0 > 0) {
            b.b(this, system, null, 1);
        }
        return true;
    }

    public boolean O1(a.f.a.d system, boolean[] flags) {
        flags[2] = false;
        boolean optimize = I1(64);
        f1(system, optimize);
        int count = this.u0.size();
        boolean hasOverride = false;
        for (int i = 0; i < count; i++) {
            e widget = this.u0.get(i);
            widget.f1(system, optimize);
            if (widget.V()) {
                hasOverride = true;
            }
        }
        return hasOverride;
    }

    @Override // a.f.a.k.e
    public void e1(boolean updateHorizontal, boolean updateVertical) {
        super.e1(updateHorizontal, updateVertical);
        int count = this.u0.size();
        for (int i = 0; i < count; i++) {
            e widget = this.u0.get(i);
            widget.e1(updateHorizontal, updateVertical);
        }
    }

    public void N1(boolean isRtl) {
        this.z0 = isRtl;
    }

    public boolean E1() {
        return this.z0;
    }

    public static boolean H1(e widget, b.InterfaceC0012b measurer, b.a measure, int measureStrategy) {
        int measuredWidth;
        int measuredHeight;
        if (measurer == null) {
            return false;
        }
        if (widget.O() == 8 || (widget instanceof g) || (widget instanceof a)) {
            measure.h = 0;
            measure.i = 0;
            return false;
        }
        measure.d = widget.w();
        measure.e = widget.M();
        measure.f = widget.P();
        measure.g = widget.t();
        measure.l = false;
        measure.m = measureStrategy;
        e.a aVar = measure.d;
        e.a aVar2 = e.a.MATCH_CONSTRAINT;
        boolean horizontalMatchConstraints = aVar == aVar2;
        boolean verticalMatchConstraints = measure.e == aVar2;
        boolean horizontalUseRatio = horizontalMatchConstraints && widget.a0 > 0.0f;
        boolean verticalUseRatio = verticalMatchConstraints && widget.a0 > 0.0f;
        if (horizontalMatchConstraints && widget.T(0) && widget.t == 0 && !horizontalUseRatio) {
            horizontalMatchConstraints = false;
            measure.d = e.a.WRAP_CONTENT;
            if (verticalMatchConstraints && widget.u == 0) {
                measure.d = e.a.FIXED;
            }
        }
        if (verticalMatchConstraints && widget.T(1) && widget.u == 0 && !verticalUseRatio) {
            verticalMatchConstraints = false;
            measure.e = e.a.WRAP_CONTENT;
            if (horizontalMatchConstraints && widget.t == 0) {
                measure.e = e.a.FIXED;
            }
        }
        if (widget.g0()) {
            horizontalMatchConstraints = false;
            measure.d = e.a.FIXED;
        }
        if (widget.h0()) {
            verticalMatchConstraints = false;
            measure.e = e.a.FIXED;
        }
        if (horizontalUseRatio) {
            if (widget.v[0] == 4) {
                measure.d = e.a.FIXED;
            } else if (!verticalMatchConstraints) {
                e.a aVar3 = measure.e;
                e.a aVar4 = e.a.FIXED;
                if (aVar3 == aVar4) {
                    measuredHeight = measure.g;
                } else {
                    measure.d = e.a.WRAP_CONTENT;
                    ((ConstraintLayout.b) measurer).d(widget, measure);
                    measuredHeight = measure.i;
                }
                measure.d = aVar4;
                measure.f = (int) (widget.r() * measuredHeight);
            }
        }
        if (verticalUseRatio) {
            if (widget.v[1] == 4) {
                measure.e = e.a.FIXED;
            } else if (!horizontalMatchConstraints) {
                e.a aVar5 = measure.d;
                e.a aVar6 = e.a.FIXED;
                if (aVar5 == aVar6) {
                    measuredWidth = measure.f;
                } else {
                    measure.e = e.a.WRAP_CONTENT;
                    ((ConstraintLayout.b) measurer).d(widget, measure);
                    measuredWidth = measure.h;
                }
                measure.e = aVar6;
                if (widget.s() == -1) {
                    measure.g = (int) (measuredWidth / widget.r());
                } else {
                    measure.g = (int) (widget.r() * measuredWidth);
                }
            }
        }
        ((ConstraintLayout.b) measurer).d(widget, measure);
        widget.Z0(measure.h);
        widget.A0(measure.i);
        widget.z0(measure.k);
        widget.p0(measure.j);
        measure.m = 0;
        return measure.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0335 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x032b  */
    @Override // a.f.a.k.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i1() {
        /*
            Method dump skipped, instructions count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.k.f.i1():void");
    }

    public a.f.a.d A1() {
        return this.A0;
    }

    public final void J1() {
        this.D0 = 0;
        this.E0 = 0;
    }

    public void l1(e constraintWidget, int type) {
        if (type == 0) {
            n1(constraintWidget);
        } else if (type == 1) {
            s1(constraintWidget);
        }
    }

    public final void n1(e widget) {
        int i = this.D0 + 1;
        c[] cVarArr = this.G0;
        if (i >= cVarArr.length) {
            this.G0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.G0[this.D0] = new c(widget, 0, E1());
        this.D0++;
    }

    public final void s1(e widget) {
        int i = this.E0 + 1;
        c[] cVarArr = this.F0;
        if (i >= cVarArr.length) {
            this.F0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.F0[this.E0] = new c(widget, 1, E1());
        this.E0++;
    }

    public void M1(int pass) {
        this.x0 = pass;
    }
}
