package androidx.recyclerview.widget;

import a.h.k.e0.c;
import a.o.b.e;
import a.o.b.g;
import a.o.b.i;
import a.o.b.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    public BitSet B;
    public boolean G;
    public boolean H;
    public e I;
    public int J;
    public int[] O;
    public f[] t;
    public i u;
    public i v;
    public int w;
    public int x;
    public final a.o.b.f y;
    public int s = -1;
    public boolean z = false;
    public boolean A = false;
    public int C = -1;
    public int D = Integer.MIN_VALUE;
    public d E = new d();
    public int F = 2;
    public final Rect K = new Rect();
    public final b L = new b();
    public boolean M = false;
    public boolean N = true;
    public final Runnable P = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.P1();
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        RecyclerView.o.d properties = RecyclerView.o.i0(context, attrs, defStyleAttr, defStyleRes);
        B2(properties.f904a);
        D2(properties.f905b);
        C2(properties.c);
        this.y = new a.o.b.f();
        V1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return this.F != 0;
    }

    public final void V1() {
        this.u = i.b(this, this.w);
        this.v = i.b(this, 1 - this.w);
    }

    public boolean P1() {
        int minPos;
        int maxPos;
        if (J() == 0 || this.F == 0 || !r0()) {
            return false;
        }
        if (this.A) {
            minPos = f2();
            maxPos = e2();
        } else {
            minPos = e2();
            maxPos = f2();
        }
        if (minPos == 0) {
            View gapView = m2();
            if (gapView != null) {
                this.E.a();
                u1();
                t1();
                return true;
            }
        }
        if (!this.M) {
            return false;
        }
        int invalidGapDir = this.A ? -1 : 1;
        d.a invalidFsi = this.E.d(minPos, maxPos + 1, invalidGapDir, true);
        if (invalidFsi == null) {
            this.M = false;
            this.E.c(maxPos + 1);
            return false;
        }
        d.a validFsi = this.E.d(minPos, invalidFsi.f926b, invalidGapDir * (-1), true);
        if (validFsi != null) {
            this.E.c(validFsi.f926b + 1);
        } else {
            this.E.c(invalidFsi.f926b);
        }
        u1();
        t1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(int state) {
        if (state == 0) {
            P1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView view, RecyclerView.u recycler) {
        super.I0(view, recycler);
        o1(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].e();
        }
        view.requestLayout();
    }

    public View m2() {
        int firstChildIndex;
        int childLimit;
        int endChildIndex = J() - 1;
        BitSet mSpansToCheck = new BitSet(this.s);
        mSpansToCheck.set(0, this.s, true);
        int preferredSpanDir = (this.w == 1 && o2()) ? 1 : -1;
        if (this.A) {
            firstChildIndex = endChildIndex;
            childLimit = 0 - 1;
        } else {
            firstChildIndex = 0;
            childLimit = endChildIndex + 1;
        }
        int nextChildDiff = firstChildIndex < childLimit ? 1 : -1;
        for (int i = firstChildIndex; i != childLimit; i += nextChildDiff) {
            View child = I(i);
            c lp = (c) child.getLayoutParams();
            if (mSpansToCheck.get(lp.e.e)) {
                if (Q1(lp.e)) {
                    return child;
                }
                mSpansToCheck.clear(lp.e.e);
            }
            lp.getClass();
            if (i + nextChildDiff != childLimit) {
                View nextChild = I(i + nextChildDiff);
                boolean compareSpans = false;
                if (this.A) {
                    int myEnd = this.u.d(child);
                    int nextEnd = this.u.d(nextChild);
                    if (myEnd < nextEnd) {
                        return child;
                    }
                    if (myEnd == nextEnd) {
                        compareSpans = true;
                    }
                } else {
                    int myStart = this.u.g(child);
                    int nextStart = this.u.g(nextChild);
                    if (myStart > nextStart) {
                        return child;
                    }
                    if (myStart == nextStart) {
                        compareSpans = true;
                    }
                }
                if (compareSpans) {
                    c nextLp = (c) nextChild.getLayoutParams();
                    if ((lp.e.e - nextLp.e.e < 0) != (preferredSpanDir < 0)) {
                        return child;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public final boolean Q1(f span) {
        if (this.A) {
            if (span.k() < this.u.i()) {
                ArrayList<View> arrayList = span.f928a;
                View endView = arrayList.get(arrayList.size() - 1);
                c lp = span.n(endView);
                lp.getClass();
                return true;
            }
        } else if (span.o() > this.u.m()) {
            View startView = span.f928a.get(0);
            c lp2 = span.n(startView);
            lp2.getClass();
            return true;
        }
        return false;
    }

    public void D2(int spanCount) {
        g(null);
        if (spanCount != this.s) {
            n2();
            this.s = spanCount;
            this.B = new BitSet(this.s);
            this.t = new f[this.s];
            for (int i = 0; i < this.s; i++) {
                this.t[i] = new f(i);
            }
            t1();
        }
    }

    public void B2(int orientation) {
        if (orientation != 0 && orientation != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (orientation == this.w) {
            return;
        }
        this.w = orientation;
        i tmp = this.u;
        this.u = this.v;
        this.v = tmp;
        t1();
    }

    public void C2(boolean reverseLayout) {
        g(null);
        e eVar = this.I;
        if (eVar != null && eVar.i != reverseLayout) {
            eVar.i = reverseLayout;
        }
        this.z = reverseLayout;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String message) {
        if (this.I == null) {
            super.g(message);
        }
    }

    public void n2() {
        this.E.a();
        t1();
    }

    public final void y2() {
        if (this.w == 1 || !o2()) {
            this.A = this.z;
        } else {
            this.A = !this.z;
        }
    }

    public boolean o2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect childrenBounds, int wSpec, int hSpec) {
        int usedHeight;
        int width;
        int horizontalPadding = e0() + f0();
        int verticalPadding = g0() + d0();
        if (this.w == 1) {
            int usedHeight2 = childrenBounds.height() + verticalPadding;
            width = RecyclerView.o.n(hSpec, usedHeight2, b0());
            usedHeight = RecyclerView.o.n(wSpec, (this.x * this.s) + horizontalPadding, c0());
        } else {
            int width2 = childrenBounds.width();
            int usedWidth = width2 + horizontalPadding;
            int width3 = RecyclerView.o.n(wSpec, usedWidth, c0());
            usedHeight = width3;
            width = RecyclerView.o.n(hSpec, (this.x * this.s) + verticalPadding, b0());
        }
        B1(usedHeight, width);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.u recycler, RecyclerView.z state) {
        r2(recycler, state, true);
    }

    public final void r2(RecyclerView.u recycler, RecyclerView.z state, boolean shouldCheckForGaps) {
        e eVar;
        b anchorInfo = this.L;
        if ((this.I != null || this.C != -1) && state.b() == 0) {
            k1(recycler);
            anchorInfo.c();
            return;
        }
        boolean needToCheckForGaps = true;
        boolean recalculateAnchor = (anchorInfo.e && this.C == -1 && this.I == null) ? false : true;
        if (recalculateAnchor) {
            anchorInfo.c();
            if (this.I != null) {
                M1(anchorInfo);
            } else {
                y2();
                anchorInfo.c = this.A;
            }
            H2(state, anchorInfo);
            anchorInfo.e = true;
        }
        if (this.I == null && this.C == -1 && (anchorInfo.c != this.G || o2() != this.H)) {
            this.E.a();
            anchorInfo.d = true;
        }
        if (J() > 0 && ((eVar = this.I) == null || eVar.d < 1)) {
            if (anchorInfo.d) {
                for (int i = 0; i < this.s; i++) {
                    this.t[i].e();
                    int i2 = anchorInfo.f923b;
                    if (i2 != Integer.MIN_VALUE) {
                        this.t[i].v(i2);
                    }
                }
            } else if (recalculateAnchor || this.L.f == null) {
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].b(this.A, anchorInfo.f923b);
                }
                this.L.d(this.t);
            } else {
                for (int i4 = 0; i4 < this.s; i4++) {
                    f span = this.t[i4];
                    span.e();
                    span.v(this.L.f[i4]);
                }
            }
        }
        w(recycler);
        this.y.f673a = false;
        this.M = false;
        J2(this.v.n());
        I2(anchorInfo.f922a, state);
        if (anchorInfo.c) {
            A2(-1);
            W1(recycler, this.y, state);
            A2(1);
            a.o.b.f fVar = this.y;
            fVar.c = anchorInfo.f922a + fVar.d;
            W1(recycler, fVar, state);
        } else {
            A2(1);
            W1(recycler, this.y, state);
            A2(-1);
            a.o.b.f fVar2 = this.y;
            fVar2.c = anchorInfo.f922a + fVar2.d;
            W1(recycler, fVar2, state);
        }
        x2();
        if (J() > 0) {
            if (this.A) {
                c2(recycler, state, true);
                d2(recycler, state, false);
            } else {
                d2(recycler, state, true);
                c2(recycler, state, false);
            }
        }
        boolean hasGaps = false;
        if (shouldCheckForGaps && !state.e()) {
            if (this.F == 0 || J() <= 0 || (!this.M && m2() == null)) {
                needToCheckForGaps = false;
            }
            if (needToCheckForGaps) {
                o1(this.P);
                if (P1()) {
                    hasGaps = true;
                }
            }
        }
        if (state.e()) {
            this.L.c();
        }
        this.G = anchorInfo.c;
        this.H = o2();
        if (hasGaps) {
            this.L.c();
            r2(recycler, state, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.z state) {
        super.Y0(state);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    public final void x2() {
        if (this.v.k() == 1073741824) {
            return;
        }
        float maxSize = 0.0f;
        int childCount = J();
        for (int i = 0; i < childCount; i++) {
            View child = I(i);
            float size = this.v.e(child);
            if (size >= maxSize) {
                c layoutParams = (c) child.getLayoutParams();
                layoutParams.f();
                maxSize = Math.max(maxSize, size);
            }
        }
        int i2 = this.x;
        int desired = Math.round(this.s * maxSize);
        if (this.v.k() == Integer.MIN_VALUE) {
            desired = Math.min(desired, this.v.n());
        }
        J2(desired);
        if (this.x == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View child2 = I(i3);
            c lp = (c) child2.getLayoutParams();
            lp.getClass();
            if (o2() && this.w == 1) {
                int i4 = this.s;
                int i5 = lp.e.e;
                child2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.x) - ((-((i4 - 1) - i5)) * i2));
            } else {
                int i6 = lp.e.e;
                int newOffset = this.x * i6;
                int prevOffset = i6 * i2;
                if (this.w == 1) {
                    child2.offsetLeftAndRight(newOffset - prevOffset);
                } else {
                    child2.offsetTopAndBottom(newOffset - prevOffset);
                }
            }
        }
    }

    public final void M1(b anchorInfo) {
        e eVar = this.I;
        int i = eVar.d;
        if (i > 0) {
            if (i == this.s) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    this.t[i2].e();
                    e eVar2 = this.I;
                    int line = eVar2.e[i2];
                    if (line != Integer.MIN_VALUE) {
                        if (eVar2.j) {
                            line += this.u.i();
                        } else {
                            line += this.u.m();
                        }
                    }
                    this.t[i2].v(line);
                }
            } else {
                eVar.k();
                e eVar3 = this.I;
                eVar3.f927b = eVar3.c;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.k;
        C2(eVar4.i);
        y2();
        e eVar5 = this.I;
        int i3 = eVar5.f927b;
        if (i3 != -1) {
            this.C = i3;
            anchorInfo.c = eVar5.j;
        } else {
            anchorInfo.c = this.A;
        }
        if (eVar5.f > 1) {
            d dVar = this.E;
            dVar.f924a = eVar5.g;
            dVar.f925b = eVar5.h;
        }
    }

    public void H2(RecyclerView.z state, b anchorInfo) {
        if (G2(state, anchorInfo)) {
            return;
        }
        F2(state, anchorInfo);
    }

    public final boolean F2(RecyclerView.z state, b anchorInfo) {
        int X1;
        if (this.G) {
            X1 = b2(state.b());
        } else {
            X1 = X1(state.b());
        }
        anchorInfo.f922a = X1;
        anchorInfo.f923b = Integer.MIN_VALUE;
        return true;
    }

    public boolean G2(RecyclerView.z state, b anchorInfo) {
        int i;
        int m;
        if (state.e() || (i = this.C) == -1) {
            return false;
        }
        if (i < 0 || i >= state.b()) {
            this.C = -1;
            this.D = Integer.MIN_VALUE;
            return false;
        }
        e eVar = this.I;
        if (eVar == null || eVar.f927b == -1 || eVar.d < 1) {
            View child = C(this.C);
            if (child != null) {
                anchorInfo.f922a = this.A ? f2() : e2();
                if (this.D != Integer.MIN_VALUE) {
                    if (anchorInfo.c) {
                        int target = this.u.i() - this.D;
                        anchorInfo.f923b = target - this.u.d(child);
                    } else {
                        int target2 = this.u.m() + this.D;
                        anchorInfo.f923b = target2 - this.u.g(child);
                    }
                    return true;
                }
                int childSize = this.u.e(child);
                if (childSize > this.u.n()) {
                    if (anchorInfo.c) {
                        m = this.u.i();
                    } else {
                        m = this.u.m();
                    }
                    anchorInfo.f923b = m;
                    return true;
                }
                int startGap = this.u.g(child) - this.u.m();
                if (startGap < 0) {
                    anchorInfo.f923b = -startGap;
                    return true;
                }
                int endGap = this.u.i() - this.u.d(child);
                if (endGap < 0) {
                    anchorInfo.f923b = endGap;
                    return true;
                }
                anchorInfo.f923b = Integer.MIN_VALUE;
            } else {
                int i2 = this.C;
                anchorInfo.f922a = i2;
                int i3 = this.D;
                if (i3 == Integer.MIN_VALUE) {
                    int position = O1(i2);
                    anchorInfo.c = position == 1;
                    anchorInfo.a();
                } else {
                    anchorInfo.b(i3);
                }
                anchorInfo.d = true;
            }
        } else {
            anchorInfo.f923b = Integer.MIN_VALUE;
            anchorInfo.f922a = this.C;
        }
        return true;
    }

    public void J2(int totalSpace) {
        this.x = totalSpace / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(totalSpace, this.v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.I == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z state) {
        return S1(state);
    }

    public final int S1(RecyclerView.z state) {
        if (J() == 0) {
            return 0;
        }
        return l.b(state, this.u, Z1(!this.N), Y1(!this.N), this, this.N, this.A);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z state) {
        return S1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.z state) {
        return R1(state);
    }

    public final int R1(RecyclerView.z state) {
        if (J() == 0) {
            return 0;
        }
        return l.a(state, this.u, Z1(!this.N), Y1(!this.N), this, this.N);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z state) {
        return R1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z state) {
        return T1(state);
    }

    public final int T1(RecyclerView.z state) {
        if (J() == 0) {
            return 0;
        }
        return l.c(state, this.u, Z1(!this.N), Y1(!this.N), this, this.N);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z state) {
        return T1(state);
    }

    public final void q2(View child, c lp, boolean alreadyMeasured) {
        lp.getClass();
        if (this.w == 1) {
            p2(child, RecyclerView.o.K(this.x, p0(), 0, ((ViewGroup.MarginLayoutParams) lp).width, false), RecyclerView.o.K(W(), X(), g0() + d0(), ((ViewGroup.MarginLayoutParams) lp).height, true), alreadyMeasured);
        } else {
            p2(child, RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) lp).width, true), RecyclerView.o.K(this.x, X(), 0, ((ViewGroup.MarginLayoutParams) lp).height, false), alreadyMeasured);
        }
    }

    public final void p2(View child, int widthSpec, int heightSpec, boolean alreadyMeasured) {
        boolean measure;
        j(child, this.K);
        c lp = (c) child.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) lp).leftMargin;
        Rect rect = this.K;
        int widthSpec2 = L2(widthSpec, i + rect.left, ((ViewGroup.MarginLayoutParams) lp).rightMargin + rect.right);
        int i2 = ((ViewGroup.MarginLayoutParams) lp).topMargin;
        Rect rect2 = this.K;
        int heightSpec2 = L2(heightSpec, i2 + rect2.top, ((ViewGroup.MarginLayoutParams) lp).bottomMargin + rect2.bottom);
        if (alreadyMeasured) {
            measure = H1(child, widthSpec2, heightSpec2, lp);
        } else {
            measure = F1(child, widthSpec2, heightSpec2, lp);
        }
        if (measure) {
            child.measure(widthSpec2, heightSpec2);
        }
    }

    public final int L2(int spec, int startInset, int endInset) {
        if (startInset == 0 && endInset == 0) {
            return spec;
        }
        int mode = View.MeasureSpec.getMode(spec);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(spec) - startInset) - endInset), mode);
        }
        return spec;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable state) {
        if (state instanceof e) {
            this.I = (e) state;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        int line;
        int[] iArr;
        if (this.I != null) {
            return new e(this.I);
        }
        e state = new e();
        state.i = this.z;
        state.j = this.G;
        state.k = this.H;
        d dVar = this.E;
        if (dVar != null && (iArr = dVar.f924a) != null) {
            state.g = iArr;
            state.f = iArr.length;
            state.h = dVar.f925b;
        } else {
            state.f = 0;
        }
        if (J() > 0) {
            state.f927b = this.G ? f2() : e2();
            state.c = a2();
            int i = this.s;
            state.d = i;
            state.e = new int[i];
            for (int i2 = 0; i2 < this.s; i2++) {
                if (this.G) {
                    line = this.t[i2].l(Integer.MIN_VALUE);
                    if (line != Integer.MIN_VALUE) {
                        line -= this.u.i();
                    }
                } else {
                    line = this.t[i2].p(Integer.MIN_VALUE);
                    if (line != Integer.MIN_VALUE) {
                        line -= this.u.m();
                    }
                }
                state.e[i2] = line;
            }
        } else {
            state.f927b = -1;
            state.c = -1;
            state.d = 0;
        }
        return state;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.u recycler, RecyclerView.z state, View host, a.h.k.e0.c info) {
        ViewGroup.LayoutParams lp = host.getLayoutParams();
        if (!(lp instanceof c)) {
            O0(host, info);
            return;
        }
        c sglp = (c) lp;
        if (this.w == 0) {
            int e2 = sglp.e();
            sglp.getClass();
            info.Z(c.C0030c.a(e2, 1, -1, -1, false, false));
        } else {
            int e3 = sglp.e();
            sglp.getClass();
            info.Z(c.C0030c.a(-1, -1, e3, 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent event) {
        super.K0(event);
        if (J() > 0) {
            View start = Z1(false);
            View end = Y1(false);
            if (start == null || end == null) {
                return;
            }
            int startPos = h0(start);
            int endPos = h0(end);
            if (startPos < endPos) {
                event.setFromIndex(startPos);
                event.setToIndex(endPos);
            } else {
                event.setFromIndex(endPos);
                event.setToIndex(startPos);
            }
        }
    }

    public int a2() {
        View first = this.A ? Y1(true) : Z1(true);
        if (first == null) {
            return -1;
        }
        return h0(first);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.u recycler, RecyclerView.z state) {
        if (this.w == 0) {
            return this.s;
        }
        return super.k0(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.u recycler, RecyclerView.z state) {
        if (this.w == 1) {
            return this.s;
        }
        return super.N(recycler, state);
    }

    public View Z1(boolean fullyVisible) {
        int boundsStart = this.u.m();
        int boundsEnd = this.u.i();
        int limit = J();
        View partiallyVisible = null;
        for (int i = 0; i < limit; i++) {
            View child = I(i);
            int childStart = this.u.g(child);
            int childEnd = this.u.d(child);
            if (childEnd > boundsStart && childStart < boundsEnd) {
                if (childStart >= boundsStart || !fullyVisible) {
                    return child;
                }
                if (partiallyVisible == null) {
                    partiallyVisible = child;
                }
            }
        }
        return partiallyVisible;
    }

    public View Y1(boolean fullyVisible) {
        int boundsStart = this.u.m();
        int boundsEnd = this.u.i();
        View partiallyVisible = null;
        for (int i = J() - 1; i >= 0; i--) {
            View child = I(i);
            int childStart = this.u.g(child);
            int childEnd = this.u.d(child);
            if (childEnd > boundsStart && childStart < boundsEnd) {
                if (childEnd <= boundsEnd || !fullyVisible) {
                    return child;
                }
                if (partiallyVisible == null) {
                    partiallyVisible = child;
                }
            }
        }
        return partiallyVisible;
    }

    public final void c2(RecyclerView.u recycler, RecyclerView.z state, boolean canOffsetChildren) {
        int gap;
        int maxEndLine = g2(Integer.MIN_VALUE);
        if (maxEndLine != Integer.MIN_VALUE && (gap = this.u.i() - maxEndLine) > 0) {
            int fixOffset = -z2(-gap, recycler, state);
            int gap2 = gap - fixOffset;
            if (canOffsetChildren && gap2 > 0) {
                this.u.r(gap2);
            }
        }
    }

    public final void d2(RecyclerView.u recycler, RecyclerView.z state, boolean canOffsetChildren) {
        int gap;
        int minStartLine = j2(Integer.MAX_VALUE);
        if (minStartLine != Integer.MAX_VALUE && (gap = minStartLine - this.u.m()) > 0) {
            int fixOffset = z2(gap, recycler, state);
            int gap2 = gap - fixOffset;
            if (canOffsetChildren && gap2 > 0) {
                this.u.r(-gap2);
            }
        }
    }

    public final void I2(int anchorPosition, RecyclerView.z state) {
        int targetPos;
        a.o.b.f fVar = this.y;
        boolean z = false;
        fVar.f674b = 0;
        fVar.c = anchorPosition;
        int startExtra = 0;
        int endExtra = 0;
        if (x0() && (targetPos = state.c()) != -1) {
            if (this.A == (targetPos < anchorPosition)) {
                endExtra = this.u.n();
            } else {
                startExtra = this.u.n();
            }
        }
        boolean clipToPadding = M();
        if (clipToPadding) {
            this.y.f = this.u.m() - startExtra;
            this.y.g = this.u.i() + endExtra;
        } else {
            this.y.g = this.u.h() + endExtra;
            this.y.f = -startExtra;
        }
        a.o.b.f fVar2 = this.y;
        fVar2.h = false;
        fVar2.f673a = true;
        if (this.u.k() == 0 && this.u.h() == 0) {
            z = true;
        }
        fVar2.i = z;
    }

    public final void A2(int direction) {
        a.o.b.f fVar = this.y;
        fVar.e = direction;
        fVar.d = this.A != (direction == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C0(int dx) {
        super.C0(dx);
        for (int i = 0; i < this.s; i++) {
            this.t[i].r(dx);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D0(int dy) {
        super.D0(dy);
        for (int i = 0; i < this.s; i++) {
            this.t[i].r(dy);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int positionStart, int itemCount) {
        l2(positionStart, itemCount, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int positionStart, int itemCount) {
        l2(positionStart, itemCount, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.E.a();
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int from, int to, int itemCount) {
        l2(from, to, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        l2(positionStart, itemCount, 4);
    }

    public final void l2(int positionStart, int itemCountOrToPosition, int cmd) {
        int affectedRangeStart;
        int affectedRangeEnd;
        int minPosition = this.A ? f2() : e2();
        if (cmd == 8) {
            if (positionStart < itemCountOrToPosition) {
                affectedRangeEnd = itemCountOrToPosition + 1;
                affectedRangeStart = positionStart;
            } else {
                affectedRangeEnd = positionStart + 1;
                affectedRangeStart = itemCountOrToPosition;
            }
        } else {
            affectedRangeStart = positionStart;
            affectedRangeEnd = positionStart + itemCountOrToPosition;
        }
        this.E.g(affectedRangeStart);
        switch (cmd) {
            case 1:
                this.E.i(positionStart, itemCountOrToPosition);
                break;
            case 2:
                this.E.j(positionStart, itemCountOrToPosition);
                break;
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                this.E.j(positionStart, 1);
                this.E.i(itemCountOrToPosition, 1);
                break;
        }
        if (affectedRangeEnd <= minPosition) {
            return;
        }
        int maxPosition = this.A ? e2() : f2();
        if (affectedRangeStart <= maxPosition) {
            t1();
        }
    }

    public final int W1(RecyclerView.u recycler, a.o.b.f layoutState, RecyclerView.z state) {
        int targetLine;
        int m;
        int diff;
        f currentSpan;
        int end;
        int start;
        int otherEnd;
        int otherStart;
        f currentSpan2;
        int i = 1;
        this.B.set(0, this.s, true);
        if (this.y.i) {
            if (layoutState.e == 1) {
                targetLine = Integer.MAX_VALUE;
            } else {
                targetLine = Integer.MIN_VALUE;
            }
        } else {
            int targetLine2 = layoutState.e;
            if (targetLine2 == 1) {
                targetLine = layoutState.g + layoutState.f674b;
            } else {
                int targetLine3 = layoutState.f;
                targetLine = targetLine3 - layoutState.f674b;
            }
        }
        E2(layoutState.e, targetLine);
        if (this.A) {
            m = this.u.i();
        } else {
            m = this.u.m();
        }
        int defaultNewViewLine = m;
        boolean added = false;
        while (layoutState.a(state) && (this.y.i || !this.B.isEmpty())) {
            View view = layoutState.b(recycler);
            c lp = (c) view.getLayoutParams();
            int position = lp.a();
            int spanIndex = this.E.f(position);
            boolean assignSpan = spanIndex == -1;
            if (assignSpan) {
                lp.getClass();
                f currentSpan3 = k2(layoutState);
                this.E.m(position, currentSpan3);
                currentSpan = currentSpan3;
            } else {
                currentSpan = this.t[spanIndex];
            }
            lp.e = currentSpan;
            if (layoutState.e == i) {
                d(view);
            } else {
                e(view, 0);
            }
            q2(view, lp, false);
            if (layoutState.e == i) {
                lp.getClass();
                start = currentSpan.l(defaultNewViewLine);
                end = this.u.e(view) + start;
                if (assignSpan) {
                    lp.getClass();
                }
            } else {
                lp.getClass();
                end = currentSpan.p(defaultNewViewLine);
                start = end - this.u.e(view);
                if (assignSpan) {
                    lp.getClass();
                }
            }
            int start2 = start;
            int end2 = end;
            lp.getClass();
            N1(view, lp, layoutState);
            if (o2() && this.w == i) {
                lp.getClass();
                int otherEnd2 = this.v.i() - (((this.s - i) - currentSpan.e) * this.x);
                otherEnd = otherEnd2;
                otherStart = otherEnd2 - this.v.e(view);
            } else {
                lp.getClass();
                int otherStart2 = (currentSpan.e * this.x) + this.v.m();
                otherEnd = this.v.e(view) + otherStart2;
                otherStart = otherStart2;
            }
            if (this.w == i) {
                currentSpan2 = currentSpan;
                z0(view, otherStart, start2, otherEnd, end2);
            } else {
                currentSpan2 = currentSpan;
                z0(view, start2, otherStart, end2, otherEnd);
            }
            lp.getClass();
            K2(currentSpan2, this.y.e, targetLine);
            u2(recycler, this.y);
            if (this.y.h && view.hasFocusable()) {
                lp.getClass();
                this.B.set(currentSpan2.e, false);
            }
            added = true;
            i = 1;
        }
        if (!added) {
            u2(recycler, this.y);
        }
        if (this.y.e == -1) {
            int minStart = j2(this.u.m());
            diff = this.u.m() - minStart;
        } else {
            int maxEnd = g2(this.u.i());
            diff = maxEnd - this.u.i();
        }
        if (diff > 0) {
            return Math.min(layoutState.f674b, diff);
        }
        return 0;
    }

    public final void N1(View view, c lp, a.o.b.f layoutState) {
        if (layoutState.e == 1) {
            lp.getClass();
            lp.e.a(view);
        } else {
            lp.getClass();
            lp.e.u(view);
        }
    }

    public final void u2(RecyclerView.u recycler, a.o.b.f layoutState) {
        int line;
        int line2;
        if (!layoutState.f673a || layoutState.i) {
            return;
        }
        if (layoutState.f674b == 0) {
            if (layoutState.e == -1) {
                v2(recycler, layoutState.g);
                return;
            } else {
                w2(recycler, layoutState.f);
                return;
            }
        }
        if (layoutState.e == -1) {
            int i = layoutState.f;
            int scrolled = i - h2(i);
            if (scrolled < 0) {
                line2 = layoutState.g;
            } else {
                int line3 = layoutState.g;
                line2 = line3 - Math.min(scrolled, layoutState.f674b);
            }
            v2(recycler, line2);
            return;
        }
        int scrolled2 = i2(layoutState.g) - layoutState.g;
        if (scrolled2 < 0) {
            line = layoutState.f;
        } else {
            int line4 = layoutState.f;
            line = line4 + Math.min(scrolled2, layoutState.f674b);
        }
        w2(recycler, line);
    }

    public final void E2(int layoutDir, int targetLine) {
        for (int i = 0; i < this.s; i++) {
            if (!this.t[i].f928a.isEmpty()) {
                K2(this.t[i], layoutDir, targetLine);
            }
        }
    }

    public final void K2(f span, int layoutDir, int targetLine) {
        int deletedSize = span.j();
        if (layoutDir == -1) {
            int line = span.o();
            if (line + deletedSize <= targetLine) {
                this.B.set(span.e, false);
                return;
            }
            return;
        }
        int line2 = span.k();
        if (line2 - deletedSize >= targetLine) {
            this.B.set(span.e, false);
        }
    }

    public final int h2(int def) {
        int maxStart = this.t[0].p(def);
        for (int i = 1; i < this.s; i++) {
            int spanStart = this.t[i].p(def);
            if (spanStart > maxStart) {
                maxStart = spanStart;
            }
        }
        return maxStart;
    }

    public final int j2(int def) {
        int minStart = this.t[0].p(def);
        for (int i = 1; i < this.s; i++) {
            int spanStart = this.t[i].p(def);
            if (spanStart < minStart) {
                minStart = spanStart;
            }
        }
        return minStart;
    }

    public final int g2(int def) {
        int maxEnd = this.t[0].l(def);
        for (int i = 1; i < this.s; i++) {
            int spanEnd = this.t[i].l(def);
            if (spanEnd > maxEnd) {
                maxEnd = spanEnd;
            }
        }
        return maxEnd;
    }

    public final int i2(int def) {
        int minEnd = this.t[0].l(def);
        for (int i = 1; i < this.s; i++) {
            int spanEnd = this.t[i].l(def);
            if (spanEnd < minEnd) {
                minEnd = spanEnd;
            }
        }
        return minEnd;
    }

    public final void w2(RecyclerView.u recycler, int line) {
        while (J() > 0) {
            View child = I(0);
            if (this.u.d(child) <= line && this.u.p(child) <= line) {
                c lp = (c) child.getLayoutParams();
                lp.getClass();
                if (lp.e.f928a.size() == 1) {
                    return;
                }
                lp.e.t();
                m1(child, recycler);
            } else {
                return;
            }
        }
    }

    public final void v2(RecyclerView.u recycler, int line) {
        int childCount = J();
        for (int i = childCount - 1; i >= 0; i--) {
            View child = I(i);
            if (this.u.g(child) >= line && this.u.q(child) >= line) {
                c lp = (c) child.getLayoutParams();
                lp.getClass();
                if (lp.e.f928a.size() == 1) {
                    return;
                }
                lp.e.s();
                m1(child, recycler);
            } else {
                return;
            }
        }
    }

    public final boolean s2(int layoutDir) {
        if (this.w == 0) {
            return (layoutDir == -1) != this.A;
        }
        return ((layoutDir == -1) == this.A) == o2();
    }

    public final f k2(a.o.b.f layoutState) {
        int startIndex;
        int endIndex;
        int diff;
        boolean preferLastSpan = s2(layoutState.e);
        if (preferLastSpan) {
            startIndex = this.s - 1;
            endIndex = -1;
            diff = -1;
        } else {
            startIndex = 0;
            endIndex = this.s;
            diff = 1;
        }
        if (layoutState.e == 1) {
            f min = null;
            int minLine = Integer.MAX_VALUE;
            int defaultLine = this.u.m();
            for (int i = startIndex; i != endIndex; i += diff) {
                f other = this.t[i];
                int otherLine = other.l(defaultLine);
                if (otherLine < minLine) {
                    min = other;
                    minLine = otherLine;
                }
            }
            return min;
        }
        f max = null;
        int maxLine = Integer.MIN_VALUE;
        int defaultLine2 = this.u.i();
        for (int i2 = startIndex; i2 != endIndex; i2 += diff) {
            f other2 = this.t[i2];
            int otherLine2 = other2.p(defaultLine2);
            if (otherLine2 > maxLine) {
                max = other2;
                maxLine = otherLine2;
            }
        }
        return max;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int dx, RecyclerView.u recycler, RecyclerView.z state) {
        return z2(dx, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int dy, RecyclerView.u recycler, RecyclerView.z state) {
        return z2(dy, recycler, state);
    }

    public final int O1(int position) {
        if (J() == 0) {
            return this.A ? 1 : -1;
        }
        int firstChildPos = e2();
        return (position < firstChildPos) != this.A ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int targetPosition) {
        int direction = O1(targetPosition);
        PointF outVector = new PointF();
        if (direction == 0) {
            return null;
        }
        if (this.w == 0) {
            outVector.x = direction;
            outVector.y = 0.0f;
        } else {
            outVector.x = 0.0f;
            outVector.y = direction;
        }
        return outVector;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.z state, int position) {
        g scroller = new g(recyclerView.getContext());
        scroller.p(position);
        J1(scroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int position) {
        e eVar = this.I;
        if (eVar != null && eVar.f927b != position) {
            eVar.j();
        }
        this.C = position;
        this.D = Integer.MIN_VALUE;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int dx, int dy, RecyclerView.z state, RecyclerView.o.c layoutPrefetchRegistry) {
        int distance;
        int delta = this.w == 0 ? dx : dy;
        if (J() == 0 || delta == 0) {
            return;
        }
        t2(delta, state);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.s) {
            this.O = new int[this.s];
        }
        int itemPrefetchCount = 0;
        for (int i = 0; i < this.s; i++) {
            a.o.b.f fVar = this.y;
            if (fVar.d == -1) {
                int i2 = fVar.f;
                distance = i2 - this.t[i].p(i2);
            } else {
                distance = this.t[i].l(fVar.g) - this.y.g;
            }
            if (distance >= 0) {
                this.O[itemPrefetchCount] = distance;
                itemPrefetchCount++;
            }
        }
        Arrays.sort(this.O, 0, itemPrefetchCount);
        for (int i3 = 0; i3 < itemPrefetchCount && this.y.a(state); i3++) {
            ((e.b) layoutPrefetchRegistry).a(this.y.c, this.O[i3]);
            a.o.b.f fVar2 = this.y;
            fVar2.c += fVar2.d;
        }
    }

    public void t2(int delta, RecyclerView.z state) {
        int layoutDir;
        int referenceChildPosition;
        if (delta > 0) {
            layoutDir = 1;
            referenceChildPosition = f2();
        } else {
            layoutDir = -1;
            referenceChildPosition = e2();
        }
        this.y.f673a = true;
        I2(referenceChildPosition, state);
        A2(layoutDir);
        a.o.b.f fVar = this.y;
        fVar.c = fVar.d + referenceChildPosition;
        fVar.f674b = Math.abs(delta);
    }

    public int z2(int dt, RecyclerView.u recycler, RecyclerView.z state) {
        int totalScroll;
        if (J() == 0 || dt == 0) {
            return 0;
        }
        t2(dt, state);
        int consumed = W1(recycler, this.y, state);
        int available = this.y.f674b;
        if (available < consumed) {
            totalScroll = dt;
        } else if (dt < 0) {
            totalScroll = -consumed;
        } else {
            totalScroll = consumed;
        }
        this.u.r(-totalScroll);
        this.G = this.A;
        a.o.b.f fVar = this.y;
        fVar.f674b = 0;
        u2(recycler, fVar);
        return totalScroll;
    }

    public int f2() {
        int childCount = J();
        if (childCount == 0) {
            return 0;
        }
        return h0(I(childCount - 1));
    }

    public int e2() {
        int childCount = J();
        if (childCount == 0) {
            return 0;
        }
        return h0(I(0));
    }

    public final int X1(int itemCount) {
        int limit = J();
        for (int i = 0; i < limit; i++) {
            View view = I(i);
            int position = h0(view);
            if (position >= 0 && position < itemCount) {
                return position;
            }
        }
        return 0;
    }

    public final int b2(int itemCount) {
        for (int i = J() - 1; i >= 0; i--) {
            View view = I(i);
            int position = h0(view);
            if (position >= 0 && position < itemCount) {
                return position;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        if (this.w == 0) {
            return new c(-2, -1);
        }
        return new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context c2, AttributeSet attrs) {
        return new c(c2, attrs);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams lp) {
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) lp);
        }
        return new c(lp);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p lp) {
        return lp instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View focused, int direction, RecyclerView.u recycler, RecyclerView.z state) {
        View directChild;
        int referenceChildPosition;
        int g;
        int g2;
        int g3;
        View view;
        if (J() == 0 || (directChild = B(focused)) == null) {
            return null;
        }
        y2();
        int layoutDir = U1(direction);
        if (layoutDir == Integer.MIN_VALUE) {
            return null;
        }
        c prevFocusLayoutParams = (c) directChild.getLayoutParams();
        prevFocusLayoutParams.getClass();
        f prevFocusSpan = prevFocusLayoutParams.e;
        if (layoutDir == 1) {
            referenceChildPosition = f2();
        } else {
            referenceChildPosition = e2();
        }
        I2(referenceChildPosition, state);
        A2(layoutDir);
        a.o.b.f fVar = this.y;
        fVar.c = fVar.d + referenceChildPosition;
        fVar.f674b = (int) (this.u.n() * 0.33333334f);
        a.o.b.f fVar2 = this.y;
        fVar2.h = true;
        fVar2.f673a = false;
        W1(recycler, fVar2, state);
        this.G = this.A;
        if (0 == 0 && (view = prevFocusSpan.m(referenceChildPosition, layoutDir)) != null && view != directChild) {
            return view;
        }
        if (s2(layoutDir)) {
            for (int i = this.s - 1; i >= 0; i--) {
                View view2 = this.t[i].m(referenceChildPosition, layoutDir);
                if (view2 != null && view2 != directChild) {
                    return view2;
                }
            }
        } else {
            for (int i2 = 0; i2 < this.s; i2++) {
                View view3 = this.t[i2].m(referenceChildPosition, layoutDir);
                if (view3 != null && view3 != directChild) {
                    return view3;
                }
            }
        }
        boolean shouldSearchFromStart = (this.z ^ true) == (layoutDir == -1);
        if (0 == 0) {
            if (shouldSearchFromStart) {
                g3 = prevFocusSpan.f();
            } else {
                g3 = prevFocusSpan.g();
            }
            View unfocusableCandidate = C(g3);
            if (unfocusableCandidate != null && unfocusableCandidate != directChild) {
                return unfocusableCandidate;
            }
        }
        if (s2(layoutDir)) {
            for (int i3 = this.s - 1; i3 >= 0; i3--) {
                if (i3 != prevFocusSpan.e) {
                    if (shouldSearchFromStart) {
                        g2 = this.t[i3].f();
                    } else {
                        g2 = this.t[i3].g();
                    }
                    View unfocusableCandidate2 = C(g2);
                    if (unfocusableCandidate2 != null && unfocusableCandidate2 != directChild) {
                        return unfocusableCandidate2;
                    }
                }
            }
        } else {
            for (int i4 = 0; i4 < this.s; i4++) {
                if (shouldSearchFromStart) {
                    g = this.t[i4].f();
                } else {
                    g = this.t[i4].g();
                }
                View unfocusableCandidate3 = C(g);
                if (unfocusableCandidate3 != null && unfocusableCandidate3 != directChild) {
                    return unfocusableCandidate3;
                }
            }
        }
        return null;
    }

    public final int U1(int focusDirection) {
        switch (focusDirection) {
            case 1:
                return (this.w != 1 && o2()) ? 1 : -1;
            case 2:
                return (this.w != 1 && o2()) ? -1 : 1;
            case 17:
                return this.w == 0 ? -1 : Integer.MIN_VALUE;
            case 33:
                return this.w == 1 ? -1 : Integer.MIN_VALUE;
            case 66:
                return this.w == 0 ? 1 : Integer.MIN_VALUE;
            case 130:
                return this.w == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RecyclerView.p {
        public f e;

        public c(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public c(int width, int height) {
            super(width, height);
        }

        public c(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

        public c(ViewGroup.LayoutParams source) {
            super(source);
        }

        public boolean f() {
            return false;
        }

        public final int e() {
            f fVar = this.e;
            if (fVar == null) {
                return -1;
            }
            return fVar.e;
        }
    }

    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<View> f928a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public int f929b = Integer.MIN_VALUE;
        public int c = Integer.MIN_VALUE;
        public int d = 0;
        public final int e;

        public f(int index) {
            this.e = index;
        }

        public int p(int def) {
            int i = this.f929b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            if (this.f928a.size() == 0) {
                return def;
            }
            d();
            return this.f929b;
        }

        public void d() {
            View startView = this.f928a.get(0);
            c lp = n(startView);
            this.f929b = StaggeredGridLayoutManager.this.u.g(startView);
            lp.getClass();
        }

        public int o() {
            int i = this.f929b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            d();
            return this.f929b;
        }

        public int l(int def) {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            int size = this.f928a.size();
            if (size == 0) {
                return def;
            }
            c();
            return this.c;
        }

        public void c() {
            View endView = this.f928a.get(r0.size() - 1);
            c lp = n(endView);
            this.c = StaggeredGridLayoutManager.this.u.d(endView);
            lp.getClass();
        }

        public int k() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.c;
        }

        public void u(View view) {
            c lp = n(view);
            lp.e = this;
            this.f928a.add(0, view);
            this.f929b = Integer.MIN_VALUE;
            if (this.f928a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (lp.c() || lp.b()) {
                this.d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        public void a(View view) {
            c lp = n(view);
            lp.e = this;
            this.f928a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.f928a.size() == 1) {
                this.f929b = Integer.MIN_VALUE;
            }
            if (lp.c() || lp.b()) {
                this.d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        public void b(boolean reverseLayout, int offset) {
            int reference;
            if (reverseLayout) {
                reference = l(Integer.MIN_VALUE);
            } else {
                reference = p(Integer.MIN_VALUE);
            }
            e();
            if (reference == Integer.MIN_VALUE) {
                return;
            }
            if (!reverseLayout || reference >= StaggeredGridLayoutManager.this.u.i()) {
                if (!reverseLayout && reference > StaggeredGridLayoutManager.this.u.m()) {
                    return;
                }
                if (offset != Integer.MIN_VALUE) {
                    reference += offset;
                }
                this.c = reference;
                this.f929b = reference;
            }
        }

        public void e() {
            this.f928a.clear();
            q();
            this.d = 0;
        }

        public void q() {
            this.f929b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        public void v(int line) {
            this.f929b = line;
            this.c = line;
        }

        public void s() {
            int size = this.f928a.size();
            View end = this.f928a.remove(size - 1);
            c lp = n(end);
            lp.e = null;
            if (lp.c() || lp.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.e(end);
            }
            if (size == 1) {
                this.f929b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        public void t() {
            View start = this.f928a.remove(0);
            c lp = n(start);
            lp.e = null;
            if (this.f928a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (lp.c() || lp.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.e(start);
            }
            this.f929b = Integer.MIN_VALUE;
        }

        public int j() {
            return this.d;
        }

        public c n(View view) {
            return (c) view.getLayoutParams();
        }

        public void r(int dt) {
            int i = this.f929b;
            if (i != Integer.MIN_VALUE) {
                this.f929b = i + dt;
            }
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                this.c = i2 + dt;
            }
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.z) {
                return i(this.f928a.size() - 1, -1, true);
            }
            return i(0, this.f928a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.z) {
                return i(0, this.f928a.size(), true);
            }
            return i(this.f928a.size() - 1, -1, true);
        }

        public int h(int fromIndex, int toIndex, boolean completelyVisible, boolean acceptCompletelyVisible, boolean acceptEndPointInclusion) {
            int start = StaggeredGridLayoutManager.this.u.m();
            int end = StaggeredGridLayoutManager.this.u.i();
            int next = toIndex > fromIndex ? 1 : -1;
            for (int i = fromIndex; i != toIndex; i += next) {
                View child = this.f928a.get(i);
                int childStart = StaggeredGridLayoutManager.this.u.g(child);
                int childEnd = StaggeredGridLayoutManager.this.u.d(child);
                boolean childEndInclusion = false;
                boolean childStartInclusion = !acceptEndPointInclusion ? childStart >= end : childStart > end;
                if (!acceptEndPointInclusion ? childEnd > start : childEnd >= start) {
                    childEndInclusion = true;
                }
                if (childStartInclusion && childEndInclusion) {
                    if (completelyVisible && acceptCompletelyVisible) {
                        if (childStart >= start && childEnd <= end) {
                            return StaggeredGridLayoutManager.this.h0(child);
                        }
                    } else {
                        if (acceptCompletelyVisible) {
                            return StaggeredGridLayoutManager.this.h0(child);
                        }
                        if (childStart < start || childEnd > end) {
                            return StaggeredGridLayoutManager.this.h0(child);
                        }
                    }
                }
            }
            return -1;
        }

        public int i(int fromIndex, int toIndex, boolean acceptEndPointInclusion) {
            return h(fromIndex, toIndex, false, false, acceptEndPointInclusion);
        }

        public View m(int referenceChildPosition, int layoutDir) {
            View candidate = null;
            if (layoutDir == -1) {
                int limit = this.f928a.size();
                for (int i = 0; i < limit; i++) {
                    View view = this.f928a.get(i);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.h0(view) <= referenceChildPosition) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.h0(view) >= referenceChildPosition) || !view.hasFocusable()) {
                        break;
                    }
                    candidate = view;
                }
            } else {
                for (int i2 = this.f928a.size() - 1; i2 >= 0; i2--) {
                    View view2 = this.f928a.get(i2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.h0(view2) >= referenceChildPosition) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.h0(view2) <= referenceChildPosition) || !view2.hasFocusable()) {
                        break;
                    }
                    candidate = view2;
                }
            }
            return candidate;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int[] f924a;

        /* renamed from: b, reason: collision with root package name */
        public List<a> f925b;

        public int c(int position) {
            List<a> list = this.f925b;
            if (list != null) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    a fsi = this.f925b.get(i);
                    if (fsi.f926b >= position) {
                        this.f925b.remove(i);
                    }
                }
            }
            int i2 = g(position);
            return i2;
        }

        public int g(int position) {
            int[] iArr = this.f924a;
            if (iArr == null || position >= iArr.length) {
                return -1;
            }
            int endPosition = h(position);
            if (endPosition == -1) {
                int[] iArr2 = this.f924a;
                Arrays.fill(iArr2, position, iArr2.length, -1);
                return this.f924a.length;
            }
            Arrays.fill(this.f924a, position, endPosition + 1, -1);
            return endPosition + 1;
        }

        public int f(int position) {
            int[] iArr = this.f924a;
            if (iArr == null || position >= iArr.length) {
                return -1;
            }
            return iArr[position];
        }

        public void m(int position, f span) {
            b(position);
            this.f924a[position] = span.e;
        }

        public int n(int position) {
            int len = this.f924a.length;
            while (len <= position) {
                len *= 2;
            }
            return len;
        }

        public void b(int position) {
            int[] iArr = this.f924a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(position, 10) + 1];
                this.f924a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (position >= iArr.length) {
                int[] old = this.f924a;
                int[] iArr3 = new int[n(position)];
                this.f924a = iArr3;
                System.arraycopy(old, 0, iArr3, 0, old.length);
                int[] iArr4 = this.f924a;
                Arrays.fill(iArr4, old.length, iArr4.length, -1);
            }
        }

        public void a() {
            int[] iArr = this.f924a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f925b = null;
        }

        public void j(int positionStart, int itemCount) {
            int[] iArr = this.f924a;
            if (iArr == null || positionStart >= iArr.length) {
                return;
            }
            b(positionStart + itemCount);
            int[] iArr2 = this.f924a;
            System.arraycopy(iArr2, positionStart + itemCount, iArr2, positionStart, (iArr2.length - positionStart) - itemCount);
            int[] iArr3 = this.f924a;
            Arrays.fill(iArr3, iArr3.length - itemCount, iArr3.length, -1);
            l(positionStart, itemCount);
        }

        public final void l(int positionStart, int itemCount) {
            List<a> list = this.f925b;
            if (list == null) {
                return;
            }
            int end = positionStart + itemCount;
            for (int i = list.size() - 1; i >= 0; i--) {
                a fsi = this.f925b.get(i);
                int i2 = fsi.f926b;
                if (i2 >= positionStart) {
                    if (i2 < end) {
                        this.f925b.remove(i);
                    } else {
                        fsi.f926b = i2 - itemCount;
                    }
                }
            }
        }

        public void i(int positionStart, int itemCount) {
            int[] iArr = this.f924a;
            if (iArr == null || positionStart >= iArr.length) {
                return;
            }
            b(positionStart + itemCount);
            int[] iArr2 = this.f924a;
            System.arraycopy(iArr2, positionStart, iArr2, positionStart + itemCount, (iArr2.length - positionStart) - itemCount);
            Arrays.fill(this.f924a, positionStart, positionStart + itemCount, -1);
            k(positionStart, itemCount);
        }

        public final void k(int positionStart, int itemCount) {
            List<a> list = this.f925b;
            if (list == null) {
                return;
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                a fsi = this.f925b.get(i);
                int i2 = fsi.f926b;
                if (i2 >= positionStart) {
                    fsi.f926b = i2 + itemCount;
                }
            }
        }

        public final int h(int position) {
            if (this.f925b == null) {
                return -1;
            }
            a item = e(position);
            if (item != null) {
                this.f925b.remove(item);
            }
            int nextFsiIndex = -1;
            int count = this.f925b.size();
            int i = 0;
            while (true) {
                if (i >= count) {
                    break;
                }
                a fsi = this.f925b.get(i);
                if (fsi.f926b < position) {
                    i++;
                } else {
                    nextFsiIndex = i;
                    break;
                }
            }
            if (nextFsiIndex == -1) {
                return -1;
            }
            a fsi2 = this.f925b.get(nextFsiIndex);
            this.f925b.remove(nextFsiIndex);
            return fsi2.f926b;
        }

        public a e(int position) {
            List<a> list = this.f925b;
            if (list == null) {
                return null;
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                a fsi = this.f925b.get(i);
                if (fsi.f926b == position) {
                    return fsi;
                }
            }
            return null;
        }

        public a d(int minPos, int maxPos, int gapDir, boolean hasUnwantedGapAfter) {
            List<a> list = this.f925b;
            if (list == null) {
                return null;
            }
            int limit = list.size();
            for (int i = 0; i < limit; i++) {
                a fsi = this.f925b.get(i);
                int i2 = fsi.f926b;
                if (i2 >= maxPos) {
                    return null;
                }
                if (i2 >= minPos && (gapDir == 0 || fsi.c == gapDir || (hasUnwantedGapAfter && fsi.e))) {
                    return fsi;
                }
            }
            return null;
        }

        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0057a();

            /* renamed from: b, reason: collision with root package name */
            public int f926b;
            public int c;
            public int[] d;
            public boolean e;

            public a(Parcel in) {
                this.f926b = in.readInt();
                this.c = in.readInt();
                this.e = in.readInt() == 1;
                int spanCount = in.readInt();
                if (spanCount > 0) {
                    int[] iArr = new int[spanCount];
                    this.d = iArr;
                    in.readIntArray(iArr);
                }
            }

            public a() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f926b);
                parcel.writeInt(this.c);
                parcel.writeInt(this.e ? 1 : 0);
                int[] iArr = this.d;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.d);
                } else {
                    parcel.writeInt(0);
                }
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f926b + ", mGapDir=" + this.c + ", mHasUnwantedGapAfter=" + this.e + ", mGapPerSpan=" + Arrays.toString(this.d) + '}';
            }

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static class C0057a implements Parcelable.Creator<a> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel in) {
                    return new a(in);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int size) {
                    return new a[size];
                }
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f927b;
        public int c;
        public int d;
        public int[] e;
        public int f;
        public int[] g;
        public List<d.a> h;
        public boolean i;
        public boolean j;
        public boolean k;

        public e() {
        }

        public e(Parcel in) {
            this.f927b = in.readInt();
            this.c = in.readInt();
            int readInt = in.readInt();
            this.d = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.e = iArr;
                in.readIntArray(iArr);
            }
            int readInt2 = in.readInt();
            this.f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.g = iArr2;
                in.readIntArray(iArr2);
            }
            this.i = in.readInt() == 1;
            this.j = in.readInt() == 1;
            this.k = in.readInt() == 1;
            List<LazySpanLookup.FullSpanItem> fullSpanItems = in.readArrayList(d.a.class.getClassLoader());
            this.h = fullSpanItems;
        }

        public e(e other) {
            this.d = other.d;
            this.f927b = other.f927b;
            this.c = other.c;
            this.e = other.e;
            this.f = other.f;
            this.g = other.g;
            this.i = other.i;
            this.j = other.j;
            this.k = other.k;
            this.h = other.h;
        }

        public void k() {
            this.e = null;
            this.d = 0;
            this.f = 0;
            this.g = null;
            this.h = null;
        }

        public void j() {
            this.e = null;
            this.d = 0;
            this.f927b = -1;
            this.c = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f927b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            if (this.d > 0) {
                parcel.writeIntArray(this.e);
            }
            parcel.writeInt(this.f);
            if (this.f > 0) {
                parcel.writeIntArray(this.g);
            }
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeList(this.h);
        }

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<e> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel in) {
                return new e(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int size) {
                return new e[size];
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f922a;

        /* renamed from: b, reason: collision with root package name */
        public int f923b;
        public boolean c;
        public boolean d;
        public boolean e;
        public int[] f;

        public b() {
            c();
        }

        public void c() {
            this.f922a = -1;
            this.f923b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(f[] spans) {
            int spanCount = spans.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < spanCount) {
                this.f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < spanCount; i++) {
                this.f[i] = spans[i].p(Integer.MIN_VALUE);
            }
        }

        public void a() {
            this.f923b = this.c ? StaggeredGridLayoutManager.this.u.i() : StaggeredGridLayoutManager.this.u.m();
        }

        public void b(int addedDistance) {
            if (this.c) {
                this.f923b = StaggeredGridLayoutManager.this.u.i() - addedDistance;
            } else {
                this.f923b = StaggeredGridLayoutManager.this.u.m() + addedDistance;
            }
        }
    }
}
