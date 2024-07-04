package a.f.a.k;

import a.f.a.k.d;
import a.f.a.k.m.n;
import a.f.a.k.m.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static float f275a = 0.5f;
    public int A;
    public float B;
    public int C;
    public float D;
    public int[] E;
    public float F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public int K;
    public d L;
    public d M;
    public d N;
    public d O;
    public d P;
    public d Q;
    public d R;
    public d S;
    public d[] T;
    public ArrayList<d> U;
    public boolean[] V;
    public a[] W;
    public e X;
    public int Y;
    public int Z;
    public float a0;
    public int b0;
    public a.f.a.k.m.c c;
    public int c0;
    public a.f.a.k.m.c d;
    public int d0;
    public int e0;
    public int f0;
    public int g0;
    public float h0;
    public float i0;
    public Object j0;
    public int k0;
    public String l0;
    public boolean m;
    public String m0;
    public boolean n;
    public int n0;
    public boolean o;
    public int o0;
    public boolean p;
    public float[] p0;
    public int q;
    public e[] q0;
    public int r;
    public e[] r0;
    public int s;
    public int s0;
    public int t;
    public int t0;
    public int u;
    public int[] v;
    public int w;
    public int x;
    public float y;
    public int z;

    /* renamed from: b, reason: collision with root package name */
    public boolean f276b = false;
    public a.f.a.k.m.l e = null;
    public n f = null;
    public boolean[] g = {true, true};
    public boolean h = true;
    public boolean i = false;
    public boolean j = true;
    public int k = -1;
    public int l = -1;

    /* loaded from: classes.dex */
    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public p J(int orientation) {
        if (orientation == 0) {
            return this.e;
        }
        if (orientation == 1) {
            return this.f;
        }
        return null;
    }

    public void v0(int x1) {
        this.L.s(x1);
        this.c0 = x1;
    }

    public void w0(int y1) {
        this.M.s(y1);
        this.d0 = y1;
    }

    public boolean Z() {
        return this.o;
    }

    public boolean i0() {
        return this.p;
    }

    public void j0() {
        this.o = true;
    }

    public void k0() {
        this.p = true;
    }

    public void u0(int x1, int x2) {
        if (this.m) {
            return;
        }
        this.L.s(x1);
        this.N.s(x2);
        this.c0 = x1;
        this.Y = x2 - x1;
        this.m = true;
    }

    public void x0(int y1, int y2) {
        if (this.n) {
            return;
        }
        this.M.s(y1);
        this.O.s(y2);
        this.d0 = y1;
        this.Z = y2 - y1;
        if (this.G) {
            this.P.s(this.e0 + y1);
        }
        this.n = true;
    }

    public void t0(int baselineValue) {
        if (!this.G) {
            return;
        }
        int y1 = baselineValue - this.e0;
        int y2 = this.Z + y1;
        this.d0 = y1;
        this.M.s(y1);
        this.O.s(y2);
        this.P.s(baselineValue);
        this.n = true;
    }

    public boolean g0() {
        return this.m || (this.L.m() && this.N.m());
    }

    public boolean h0() {
        return this.n || (this.M.m() && this.O.m());
    }

    public void n0() {
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        int mAnchorsSize = this.U.size();
        for (int i = 0; i < mAnchorsSize; i++) {
            d anchor = this.U.get(i);
            anchor.q();
        }
    }

    public boolean U() {
        int mAnchorsSize = this.U.size();
        for (int i = 0; i < mAnchorsSize; i++) {
            d anchor = this.U.get(i);
            if (anchor.l()) {
                return true;
            }
        }
        return false;
    }

    public boolean T(int orientation) {
        if (orientation == 0) {
            int horizontalTargets = (this.L.f != null ? 1 : 0) + (this.N.f != null ? 1 : 0);
            return horizontalTargets < 2;
        }
        int verticalTargets = (this.M.f != null ? 1 : 0) + (this.O.f != null ? 1 : 0) + (this.P.f != null ? 1 : 0);
        return verticalTargets < 2;
    }

    public boolean W(int orientation, int size) {
        d dVar;
        d dVar2;
        if (orientation == 0) {
            d dVar3 = this.L.f;
            return dVar3 != null && dVar3.m() && (dVar2 = this.N.f) != null && dVar2.m() && (this.N.f.d() - this.N.e()) - (this.L.f.d() + this.L.e()) >= size;
        }
        d dVar4 = this.M.f;
        return dVar4 != null && dVar4.m() && (dVar = this.O.f) != null && dVar.m() && (this.O.f.d() - this.O.e()) - (this.M.f.d() + this.M.e()) >= size;
        return false;
    }

    public boolean e0() {
        return this.I;
    }

    public void J0(boolean inVirtualLayout) {
        this.I = inVirtualLayout;
    }

    public int B() {
        return this.E[1];
    }

    public int C() {
        return this.E[0];
    }

    public void M0(int maxWidth) {
        this.E[0] = maxWidth;
    }

    public void L0(int maxHeight) {
        this.E[1] = maxHeight;
    }

    public void z0(boolean hasBaseline) {
        this.G = hasBaseline;
    }

    public boolean c0() {
        return this.H;
    }

    public void I0(boolean inPlaceholder) {
        this.H = inPlaceholder;
    }

    public void H0(int orientation, boolean value) {
        this.V[orientation] = value;
    }

    public boolean a0(int orientation) {
        return this.V[orientation];
    }

    public void N0(boolean measureRequested) {
        this.h = measureRequested;
    }

    public boolean f0() {
        return this.h && this.k0 != 8;
    }

    public void a1(int behavior) {
        if (behavior >= 0 && behavior <= 3) {
            this.s = behavior;
        }
    }

    public int y() {
        return this.J;
    }

    public int z() {
        return this.K;
    }

    public void K0(int horizontal, int vertical) {
        this.J = horizontal;
        this.K = vertical;
        N0(false);
    }

    public void m0() {
        this.L.p();
        this.M.p();
        this.N.p();
        this.O.p();
        this.P.p();
        this.Q.p();
        this.R.p();
        this.S.p();
        this.X = null;
        this.F = 0.0f;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0.0f;
        this.b0 = -1;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0.5f;
        this.i0 = 0.5f;
        a[] aVarArr = this.W;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.j0 = null;
        this.k0 = 0;
        this.m0 = null;
        this.n0 = 0;
        this.o0 = 0;
        float[] fArr = this.p0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.q = -1;
        this.r = -1;
        int[] iArr = this.E;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.t = 0;
        this.u = 0;
        this.y = 1.0f;
        this.B = 1.0f;
        this.x = Integer.MAX_VALUE;
        this.A = Integer.MAX_VALUE;
        this.w = 0;
        this.z = 0;
        this.C = -1;
        this.D = 1.0f;
        boolean[] zArr = this.g;
        zArr[0] = true;
        zArr[1] = true;
        this.I = false;
        boolean[] zArr2 = this.V;
        zArr2[0] = false;
        zArr2[1] = false;
        this.h = true;
        int[] iArr2 = this.v;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.k = -1;
        this.l = -1;
    }

    public boolean l0() {
        a[] aVarArr = this.W;
        a aVar = aVarArr[0];
        a aVar2 = a.MATCH_CONSTRAINT;
        return aVar == aVar2 && aVarArr[1] == aVar2;
    }

    public boolean V() {
        return (this.k == -1 && this.l == -1) ? false : true;
    }

    public e() {
        new a.f.a.j.a(this);
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = -1;
        this.r = -1;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = new int[2];
        this.w = 0;
        this.x = 0;
        this.y = 1.0f;
        this.z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = -1;
        this.D = 1.0f;
        this.E = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.F = 0.0f;
        this.G = false;
        this.I = false;
        this.J = 0;
        this.K = 0;
        this.L = new d(this, d.a.LEFT);
        this.M = new d(this, d.a.TOP);
        this.N = new d(this, d.a.RIGHT);
        this.O = new d(this, d.a.BOTTOM);
        this.P = new d(this, d.a.BASELINE);
        this.Q = new d(this, d.a.CENTER_X);
        this.R = new d(this, d.a.CENTER_Y);
        d dVar = new d(this, d.a.CENTER);
        this.S = dVar;
        this.T = new d[]{this.L, this.N, this.M, this.O, this.P, dVar};
        this.U = new ArrayList<>();
        this.V = new boolean[2];
        a aVar = a.FIXED;
        this.W = new a[]{aVar, aVar};
        this.X = null;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0.0f;
        this.b0 = -1;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.h0 = 0.5f;
        this.i0 = 0.5f;
        this.k0 = 0;
        this.l0 = null;
        this.m0 = null;
        this.n0 = 0;
        this.o0 = 0;
        this.p0 = new float[]{-1.0f, -1.0f};
        this.q0 = new e[]{null, null};
        this.r0 = new e[]{null, null};
        this.s0 = -1;
        this.t0 = -1;
        b();
    }

    public void j() {
        if (this.e == null) {
            this.e = new a.f.a.k.m.l(this);
        }
        if (this.f == null) {
            this.f = new n(this);
        }
    }

    public void o0(a.f.a.c cache) {
        this.L.r();
        this.M.r();
        this.N.r();
        this.O.r();
        this.P.r();
        this.S.r();
        this.Q.r();
        this.R.r();
    }

    public final void b() {
        this.U.add(this.L);
        this.U.add(this.M);
        this.U.add(this.N);
        this.U.add(this.O);
        this.U.add(this.Q);
        this.U.add(this.R);
        this.U.add(this.S);
        this.U.add(this.P);
    }

    public e G() {
        return this.X;
    }

    public void R0(e widget) {
        this.X = widget;
    }

    public void h(e target, float angle, int radius) {
        d.a aVar = d.a.CENTER;
        X(aVar, target, aVar, radius, 0);
        this.F = angle;
    }

    public void Y0(int visibility) {
        this.k0 = visibility;
    }

    public int O() {
        return this.k0;
    }

    public String p() {
        return this.l0;
    }

    public void r0(String name) {
        this.l0 = name;
    }

    public void i(a.f.a.d system) {
        system.q(this.L);
        system.q(this.M);
        system.q(this.N);
        system.q(this.O);
        if (this.e0 > 0) {
            system.q(this.P);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = this.m0;
        String str3 = BuildConfig.FLAVOR;
        if (str2 != null) {
            str = "type: " + this.m0 + " ";
        } else {
            str = BuildConfig.FLAVOR;
        }
        sb.append(str);
        if (this.l0 != null) {
            str3 = "id: " + this.l0 + " ";
        }
        sb.append(str3);
        sb.append("(");
        sb.append(this.c0);
        sb.append(", ");
        sb.append(this.d0);
        sb.append(") - (");
        sb.append(this.Y);
        sb.append(" x ");
        sb.append(this.Z);
        sb.append(")");
        return sb.toString();
    }

    public int Q() {
        e eVar = this.X;
        if (eVar != null && (eVar instanceof f)) {
            return ((f) eVar).B0 + this.c0;
        }
        return this.c0;
    }

    public int R() {
        e eVar = this.X;
        if (eVar != null && (eVar instanceof f)) {
            return ((f) eVar).C0 + this.d0;
        }
        return this.d0;
    }

    public int P() {
        if (this.k0 == 8) {
            return 0;
        }
        return this.Y;
    }

    public int t() {
        if (this.k0 == 8) {
            return 0;
        }
        return this.Z;
    }

    public int A(int orientation) {
        if (orientation == 0) {
            return P();
        }
        if (orientation == 1) {
            return t();
        }
        return 0;
    }

    public int E() {
        return this.f0;
    }

    public int D() {
        return this.g0;
    }

    public int I() {
        return Q() + this.Y;
    }

    public int n() {
        return R() + this.Z;
    }

    public int x() {
        d dVar = this.L;
        int margin = dVar != null ? 0 + dVar.g : 0;
        d dVar2 = this.N;
        if (dVar2 != null) {
            return margin + dVar2.g;
        }
        return margin;
    }

    public int N() {
        int margin = this.L != null ? 0 + this.M.g : 0;
        if (this.N != null) {
            return margin + this.O.g;
        }
        return margin;
    }

    public float u() {
        return this.h0;
    }

    public float K() {
        return this.i0;
    }

    public float m(int orientation) {
        if (orientation == 0) {
            return this.h0;
        }
        if (orientation == 1) {
            return this.i0;
        }
        return -1.0f;
    }

    public boolean S() {
        return this.G;
    }

    public int l() {
        return this.e0;
    }

    public Object o() {
        return this.j0;
    }

    public void b1(int x) {
        this.c0 = x;
    }

    public void c1(int y) {
        this.d0 = y;
    }

    public void Q0(int x, int y) {
        this.c0 = x;
        this.d0 = y;
    }

    public void Z0(int w) {
        this.Y = w;
        int i = this.f0;
        if (w < i) {
            this.Y = i;
        }
    }

    public void A0(int h) {
        this.Z = h;
        int i = this.g0;
        if (h < i) {
            this.Z = i;
        }
    }

    public void F0(int horizontalMatchStyle, int min, int max, float percent) {
        this.t = horizontalMatchStyle;
        this.w = min;
        this.x = max == Integer.MAX_VALUE ? 0 : max;
        this.y = percent;
        if (percent > 0.0f && percent < 1.0f && horizontalMatchStyle == 0) {
            this.t = 2;
        }
    }

    public void W0(int verticalMatchStyle, int min, int max, float percent) {
        this.u = verticalMatchStyle;
        this.z = min;
        this.A = max == Integer.MAX_VALUE ? 0 : max;
        this.B = percent;
        if (percent > 0.0f && percent < 1.0f && verticalMatchStyle == 0) {
            this.u = 2;
        }
    }

    public void s0(String ratio) {
        int commaIndex;
        if (ratio == null || ratio.length() == 0) {
            this.a0 = 0.0f;
            return;
        }
        int dimensionRatioSide = -1;
        float dimensionRatio = 0.0f;
        int len = ratio.length();
        int commaIndex2 = ratio.indexOf(44);
        if (commaIndex2 > 0 && commaIndex2 < len - 1) {
            String dimension = ratio.substring(0, commaIndex2);
            if (dimension.equalsIgnoreCase("W")) {
                dimensionRatioSide = 0;
            } else if (dimension.equalsIgnoreCase("H")) {
                dimensionRatioSide = 1;
            }
            commaIndex = commaIndex2 + 1;
        } else {
            commaIndex = 0;
        }
        int colonIndex = ratio.indexOf(58);
        if (colonIndex >= 0 && colonIndex < len - 1) {
            String nominator = ratio.substring(commaIndex, colonIndex);
            String denominator = ratio.substring(colonIndex + 1);
            if (nominator.length() > 0 && denominator.length() > 0) {
                try {
                    float nominatorValue = Float.parseFloat(nominator);
                    float denominatorValue = Float.parseFloat(denominator);
                    if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                        dimensionRatio = dimensionRatioSide == 1 ? Math.abs(denominatorValue / nominatorValue) : Math.abs(nominatorValue / denominatorValue);
                    }
                } catch (NumberFormatException e) {
                }
            }
        } else {
            String r = ratio.substring(commaIndex);
            if (r.length() > 0) {
                try {
                    dimensionRatio = Float.parseFloat(r);
                } catch (NumberFormatException e2) {
                }
            }
        }
        if (dimensionRatio > 0.0f) {
            this.a0 = dimensionRatio;
            this.b0 = dimensionRatioSide;
        }
    }

    public float r() {
        return this.a0;
    }

    public int s() {
        return this.b0;
    }

    public void B0(float horizontalBiasPercent) {
        this.h0 = horizontalBiasPercent;
    }

    public void S0(float verticalBiasPercent) {
        this.i0 = verticalBiasPercent;
    }

    public void P0(int w) {
        if (w < 0) {
            this.f0 = 0;
        } else {
            this.f0 = w;
        }
    }

    public void O0(int h) {
        if (h < 0) {
            this.g0 = 0;
        } else {
            this.g0 = h;
        }
    }

    public void y0(int left, int top, int right, int bottom) {
        int w = right - left;
        int h = bottom - top;
        this.c0 = left;
        this.d0 = top;
        if (this.k0 == 8) {
            this.Y = 0;
            this.Z = 0;
            return;
        }
        a[] aVarArr = this.W;
        a aVar = aVarArr[0];
        a aVar2 = a.FIXED;
        if (aVar == aVar2 && w < this.Y) {
            w = this.Y;
        }
        if (aVarArr[1] == aVar2 && h < this.Z) {
            h = this.Z;
        }
        this.Y = w;
        this.Z = h;
        int i = this.g0;
        if (h < i) {
            this.Z = i;
        }
        int i2 = this.f0;
        if (w < i2) {
            this.Y = i2;
        }
        int i3 = this.x;
        if (i3 > 0 && aVarArr[0] == a.MATCH_CONSTRAINT) {
            this.Y = Math.min(this.Y, i3);
        }
        int i4 = this.A;
        if (i4 > 0 && this.W[1] == a.MATCH_CONSTRAINT) {
            this.Z = Math.min(this.Z, i4);
        }
        int i5 = this.Y;
        if (w != i5) {
            this.k = i5;
        }
        int i6 = this.Z;
        if (h != i6) {
            this.l = i6;
        }
    }

    public void D0(int left, int right) {
        this.c0 = left;
        int i = right - left;
        this.Y = i;
        int i2 = this.f0;
        if (i < i2) {
            this.Y = i2;
        }
    }

    public void U0(int top, int bottom) {
        this.d0 = top;
        int i = bottom - top;
        this.Z = i;
        int i2 = this.g0;
        if (i < i2) {
            this.Z = i2;
        }
    }

    public void p0(int baseline) {
        this.e0 = baseline;
        this.G = baseline > 0;
    }

    public void q0(Object companion) {
        this.j0 = companion;
    }

    public void G0(float horizontalWeight) {
        this.p0[0] = horizontalWeight;
    }

    public void X0(float verticalWeight) {
        this.p0[1] = verticalWeight;
    }

    public void C0(int horizontalChainStyle) {
        this.n0 = horizontalChainStyle;
    }

    public int v() {
        return this.n0;
    }

    public void T0(int verticalChainStyle) {
        this.o0 = verticalChainStyle;
    }

    public int L() {
        return this.o0;
    }

    public boolean f() {
        return this.k0 != 8;
    }

    public void X(d.a startType, e target, d.a endType, int margin, int goneMargin) {
        d startAnchor = k(startType);
        d endAnchor = target.k(endType);
        startAnchor.a(endAnchor, margin, goneMargin, true);
    }

    public d k(d.a anchorType) {
        switch (anchorType.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.L;
            case 2:
                return this.M;
            case 3:
                return this.N;
            case 4:
                return this.O;
            case 5:
                return this.P;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                return this.S;
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                return this.Q;
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                return this.R;
            default:
                throw new AssertionError(anchorType.name());
        }
    }

    public a w() {
        return this.W[0];
    }

    public a M() {
        return this.W[1];
    }

    public a q(int orientation) {
        if (orientation == 0) {
            return w();
        }
        if (orientation == 1) {
            return M();
        }
        return null;
    }

    public void E0(a behaviour) {
        this.W[0] = behaviour;
    }

    public void V0(a behaviour) {
        this.W[1] = behaviour;
    }

    public boolean b0() {
        d dVar = this.L;
        d dVar2 = dVar.f;
        if (dVar2 != null && dVar2.f == dVar) {
            return true;
        }
        d dVar3 = this.N;
        d dVar4 = dVar3.f;
        if (dVar4 != null && dVar4.f == dVar3) {
            return true;
        }
        return false;
    }

    public e H(int orientation) {
        d dVar;
        d dVar2;
        if (orientation == 0) {
            d dVar3 = this.L;
            d dVar4 = dVar3.f;
            if (dVar4 != null && dVar4.f == dVar3) {
                return dVar4.d;
            }
            return null;
        }
        if (orientation == 1 && (dVar2 = (dVar = this.M).f) != null && dVar2.f == dVar) {
            return dVar2.d;
        }
        return null;
    }

    public e F(int orientation) {
        d dVar;
        d dVar2;
        if (orientation == 0) {
            d dVar3 = this.N;
            d dVar4 = dVar3.f;
            if (dVar4 != null && dVar4.f == dVar3) {
                return dVar4.d;
            }
            return null;
        }
        if (orientation == 1 && (dVar2 = (dVar = this.O).f) != null && dVar2.f == dVar) {
            return dVar2.d;
        }
        return null;
    }

    public boolean d0() {
        d dVar = this.M;
        d dVar2 = dVar.f;
        if (dVar2 != null && dVar2.f == dVar) {
            return true;
        }
        d dVar3 = this.O;
        d dVar4 = dVar3.f;
        if (dVar4 != null && dVar4.f == dVar3) {
            return true;
        }
        return false;
    }

    public final boolean Y(int orientation) {
        int offset = orientation * 2;
        d[] dVarArr = this.T;
        return (dVarArr[offset].f == null || dVarArr[offset].f.f == dVarArr[offset] || dVarArr[offset + 1].f == null || dVarArr[offset + 1].f.f != dVarArr[offset + 1]) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x02ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(a.f.a.d r76, boolean r77) {
        /*
            Method dump skipped, instructions count: 1576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.k.e.e(a.f.a.d, boolean):void");
    }

    public boolean d() {
        return (this instanceof k) || (this instanceof g);
    }

    public void d1(boolean horizontalDimensionFixed, boolean verticalDimensionFixed) {
        if (this.C == -1) {
            if (horizontalDimensionFixed && !verticalDimensionFixed) {
                this.C = 0;
            } else if (!horizontalDimensionFixed && verticalDimensionFixed) {
                this.C = 1;
                if (this.b0 == -1) {
                    this.D = 1.0f / this.D;
                }
            }
        }
        if (this.C == 0 && (!this.M.n() || !this.O.n())) {
            this.C = 1;
        } else if (this.C == 1 && (!this.L.n() || !this.N.n())) {
            this.C = 0;
        }
        if (this.C == -1 && (!this.M.n() || !this.O.n() || !this.L.n() || !this.N.n())) {
            if (this.M.n() && this.O.n()) {
                this.C = 0;
            } else if (this.L.n() && this.N.n()) {
                this.D = 1.0f / this.D;
                this.C = 1;
            }
        }
        if (this.C == -1) {
            int i = this.w;
            if (i > 0 && this.z == 0) {
                this.C = 0;
            } else if (i == 0 && this.z > 0) {
                this.D = 1.0f / this.D;
                this.C = 1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x0594, code lost:
    
        if ((r3 instanceof a.f.a.k.a) != false) goto L266;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0205  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(a.f.a.d r40, boolean r41, boolean r42, boolean r43, boolean r44, a.f.a.h r45, a.f.a.h r46, a.f.a.k.e.a r47, boolean r48, a.f.a.k.d r49, a.f.a.k.d r50, int r51, int r52, int r53, int r54, float r55, boolean r56, boolean r57, boolean r58, boolean r59, boolean r60, int r61, int r62, int r63, int r64, float r65, boolean r66) {
        /*
            Method dump skipped, instructions count: 1750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.k.e.g(a.f.a.d, boolean, boolean, boolean, boolean, a.f.a.h, a.f.a.h, a.f.a.k.e$a, boolean, a.f.a.k.d, a.f.a.k.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public void f1(a.f.a.d system, boolean optimize) {
        n nVar;
        a.f.a.k.m.l lVar;
        int left = system.x(this.L);
        int top = system.x(this.M);
        int right = system.x(this.N);
        int bottom = system.x(this.O);
        if (optimize && (lVar = this.e) != null) {
            a.f.a.k.m.f fVar = lVar.h;
            if (fVar.j) {
                a.f.a.k.m.f fVar2 = lVar.i;
                if (fVar2.j) {
                    left = fVar.g;
                    right = fVar2.g;
                }
            }
        }
        if (optimize && (nVar = this.f) != null) {
            a.f.a.k.m.f fVar3 = nVar.h;
            if (fVar3.j) {
                a.f.a.k.m.f fVar4 = nVar.i;
                if (fVar4.j) {
                    top = fVar3.g;
                    bottom = fVar4.g;
                }
            }
        }
        int w = right - left;
        int h = bottom - top;
        if (w < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        y0(left, top, right, bottom);
    }

    public void e1(boolean updateHorizontal, boolean updateVertical) {
        boolean updateHorizontal2 = updateHorizontal & this.e.k();
        boolean updateVertical2 = updateVertical & this.f.k();
        a.f.a.k.m.l lVar = this.e;
        int left = lVar.h.g;
        n nVar = this.f;
        int top = nVar.h.g;
        int right = lVar.i.g;
        int bottom = nVar.i.g;
        int h = bottom - top;
        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        int w = right - left;
        int h2 = bottom - top;
        if (updateHorizontal2) {
            this.c0 = left;
        }
        if (updateVertical2) {
            this.d0 = top;
        }
        if (this.k0 == 8) {
            this.Y = 0;
            this.Z = 0;
            return;
        }
        if (updateHorizontal2) {
            if (this.W[0] == a.FIXED && w < this.Y) {
                w = this.Y;
            }
            this.Y = w;
            int i = this.f0;
            if (w < i) {
                this.Y = i;
            }
        }
        if (updateVertical2) {
            if (this.W[1] == a.FIXED && h2 < this.Z) {
                h2 = this.Z;
            }
            this.Z = h2;
            int i2 = this.g0;
            if (h2 < i2) {
                this.Z = i2;
            }
        }
    }

    public void c(f container, a.f.a.d system, HashSet<e> hashSet, int orientation, boolean addSelf) {
        if (addSelf) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.a(container, system, this);
            hashSet.remove(this);
            e(system, container.I1(64));
        }
        if (orientation == 0) {
            HashSet<d> c = this.L.c();
            if (c != null) {
                Iterator<d> it = c.iterator();
                while (it.hasNext()) {
                    d anchor = it.next();
                    anchor.d.c(container, system, hashSet, orientation, true);
                }
            }
            HashSet<d> c2 = this.N.c();
            if (c2 != null) {
                Iterator<d> it2 = c2.iterator();
                while (it2.hasNext()) {
                    d anchor2 = it2.next();
                    anchor2.d.c(container, system, hashSet, orientation, true);
                }
                return;
            }
            return;
        }
        HashSet<d> c3 = this.M.c();
        if (c3 != null) {
            Iterator<d> it3 = c3.iterator();
            while (it3.hasNext()) {
                d anchor3 = it3.next();
                anchor3.d.c(container, system, hashSet, orientation, true);
            }
        }
        HashSet<d> c4 = this.O.c();
        if (c4 != null) {
            Iterator<d> it4 = c4.iterator();
            while (it4.hasNext()) {
                d anchor4 = it4.next();
                anchor4.d.c(container, system, hashSet, orientation, true);
            }
        }
        HashSet<d> c5 = this.P.c();
        if (c5 != null) {
            Iterator<d> it5 = c5.iterator();
            while (it5.hasNext()) {
                d anchor5 = it5.next();
                anchor5.d.c(container, system, hashSet, orientation, true);
            }
        }
    }
}
