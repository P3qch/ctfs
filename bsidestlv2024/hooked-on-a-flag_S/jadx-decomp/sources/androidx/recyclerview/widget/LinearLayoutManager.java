package androidx.recyclerview.widget;

import a.o.b.e;
import a.o.b.g;
import a.o.b.i;
import a.o.b.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    public int A;
    public int B;
    public d C;
    public final a D;
    public final b E;
    public int F;
    public int[] G;
    public int s;
    public c t;
    public i u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public LinearLayoutManager(int orientation, boolean reverseLayout) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.C = null;
        this.D = new a();
        this.E = new b();
        this.F = 2;
        this.G = new int[2];
        B2(orientation);
        C2(reverseLayout);
    }

    public LinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.C = null;
        this.D = new a();
        this.E = new b();
        this.F = 2;
        this.G = new int[2];
        RecyclerView.o.d properties = RecyclerView.o.i0(context, attrs, defStyleAttr, defStyleRes);
        B2(properties.f904a);
        C2(properties.c);
        D2(properties.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView view, RecyclerView.u recycler) {
        super.I0(view, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent event) {
        super.K0(event);
        if (J() > 0) {
            event.setFromIndex(Z1());
            event.setToIndex(c2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        if (this.C != null) {
            return new d(this.C);
        }
        d state = new d();
        if (J() > 0) {
            T1();
            boolean didLayoutFromEnd = this.v ^ this.x;
            state.d = didLayoutFromEnd;
            if (didLayoutFromEnd) {
                View refChild = m2();
                state.c = this.u.i() - this.u.d(refChild);
                state.f883b = h0(refChild);
            } else {
                View refChild2 = n2();
                state.f883b = h0(refChild2);
                state.c = this.u.g(refChild2) - this.u.m();
            }
        } else {
            state.k();
        }
        return state;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable state) {
        if (state instanceof d) {
            this.C = (d) state;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.s == 1;
    }

    public void D2(boolean stackFromEnd) {
        g(null);
        if (this.y == stackFromEnd) {
            return;
        }
        this.y = stackFromEnd;
        t1();
    }

    public int p2() {
        return this.s;
    }

    public void B2(int orientation) {
        if (orientation != 0 && orientation != 1) {
            throw new IllegalArgumentException("invalid orientation:" + orientation);
        }
        g(null);
        if (orientation != this.s || this.u == null) {
            i b2 = i.b(this, orientation);
            this.u = b2;
            this.D.f877a = b2;
            this.s = orientation;
            t1();
        }
    }

    public final void z2() {
        if (this.s == 1 || !q2()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    public void C2(boolean reverseLayout) {
        g(null);
        if (reverseLayout == this.w) {
            return;
        }
        this.w = reverseLayout;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int position) {
        int childCount = J();
        if (childCount == 0) {
            return null;
        }
        int firstChild = h0(I(0));
        int viewPosition = position - firstChild;
        if (viewPosition >= 0 && viewPosition < childCount) {
            View child = I(viewPosition);
            if (h0(child) == position) {
                return child;
            }
        }
        return super.C(position);
    }

    @Deprecated
    public int o2(RecyclerView.z state) {
        if (state.d()) {
            return this.u.n();
        }
        return 0;
    }

    public void M1(RecyclerView.z state, int[] extraLayoutSpace) {
        int extraLayoutSpaceStart = 0;
        int extraLayoutSpaceEnd = 0;
        int extraScrollSpace = o2(state);
        if (this.t.f == -1) {
            extraLayoutSpaceStart = extraScrollSpace;
        } else {
            extraLayoutSpaceEnd = extraScrollSpace;
        }
        extraLayoutSpace[0] = extraLayoutSpaceStart;
        extraLayoutSpace[1] = extraLayoutSpaceEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.z state, int position) {
        g linearSmoothScroller = new g(recyclerView.getContext());
        linearSmoothScroller.p(position);
        J1(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int targetPosition) {
        if (J() == 0) {
            return null;
        }
        int firstChildPos = h0(I(0));
        int direction = (targetPosition < firstChildPos) != this.x ? -1 : 1;
        if (this.s == 0) {
            return new PointF(direction, 0.0f);
        }
        return new PointF(0.0f, direction);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.u recycler, RecyclerView.z state) {
        int endOffset;
        int startOffset;
        int i;
        View existing;
        int upcomingOffset;
        int firstLayoutDirection = -1;
        if ((this.C != null || this.A != -1) && state.b() == 0) {
            k1(recycler);
            return;
        }
        d dVar = this.C;
        if (dVar != null && dVar.j()) {
            this.A = this.C.f883b;
        }
        T1();
        this.t.f881a = false;
        z2();
        View focused = V();
        a aVar = this.D;
        if (!aVar.e || this.A != -1 || this.C != null) {
            aVar.e();
            a aVar2 = this.D;
            aVar2.d = this.x ^ this.y;
            G2(recycler, state, aVar2);
            this.D.e = true;
        } else if (focused != null && (this.u.g(focused) >= this.u.i() || this.u.d(focused) <= this.u.m())) {
            this.D.c(focused, h0(focused));
        }
        c cVar = this.t;
        cVar.f = cVar.j >= 0 ? 1 : -1;
        int[] iArr = this.G;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(state, iArr);
        int extraForStart = Math.max(0, this.G[0]) + this.u.m();
        int extraForEnd = Math.max(0, this.G[1]) + this.u.j();
        if (state.e() && (i = this.A) != -1 && this.B != Integer.MIN_VALUE && (existing = C(i)) != null) {
            if (this.x) {
                int current = this.u.i() - this.u.d(existing);
                upcomingOffset = current - this.B;
            } else {
                int current2 = this.u.g(existing) - this.u.m();
                upcomingOffset = this.B - current2;
            }
            if (upcomingOffset > 0) {
                extraForStart += upcomingOffset;
            } else {
                extraForEnd -= upcomingOffset;
            }
        }
        a aVar3 = this.D;
        if (aVar3.d) {
            if (this.x) {
                firstLayoutDirection = 1;
            }
        } else if (!this.x) {
            firstLayoutDirection = 1;
        }
        t2(recycler, state, aVar3, firstLayoutDirection);
        w(recycler);
        this.t.l = y2();
        c cVar2 = this.t;
        state.e();
        cVar2.getClass();
        this.t.i = 0;
        a aVar4 = this.D;
        if (aVar4.d) {
            L2(aVar4);
            c cVar3 = this.t;
            cVar3.h = extraForStart;
            U1(recycler, cVar3, state, false);
            c cVar4 = this.t;
            startOffset = cVar4.f882b;
            int firstElement = cVar4.d;
            int i2 = cVar4.c;
            if (i2 > 0) {
                extraForEnd += i2;
            }
            J2(this.D);
            c cVar5 = this.t;
            cVar5.h = extraForEnd;
            cVar5.d += cVar5.e;
            U1(recycler, cVar5, state, false);
            c cVar6 = this.t;
            endOffset = cVar6.f882b;
            if (cVar6.c > 0) {
                int extraForStart2 = cVar6.c;
                K2(firstElement, startOffset);
                c cVar7 = this.t;
                cVar7.h = extraForStart2;
                U1(recycler, cVar7, state, false);
                startOffset = this.t.f882b;
            }
        } else {
            J2(aVar4);
            c cVar8 = this.t;
            cVar8.h = extraForEnd;
            U1(recycler, cVar8, state, false);
            c cVar9 = this.t;
            endOffset = cVar9.f882b;
            int lastElement = cVar9.d;
            int i3 = cVar9.c;
            if (i3 > 0) {
                extraForStart += i3;
            }
            L2(this.D);
            c cVar10 = this.t;
            cVar10.h = extraForStart;
            cVar10.d += cVar10.e;
            U1(recycler, cVar10, state, false);
            c cVar11 = this.t;
            int startOffset2 = cVar11.f882b;
            if (cVar11.c <= 0) {
                startOffset = startOffset2;
            } else {
                int extraForEnd2 = cVar11.c;
                I2(lastElement, endOffset);
                c cVar12 = this.t;
                cVar12.h = extraForEnd2;
                U1(recycler, cVar12, state, false);
                endOffset = this.t.f882b;
                startOffset = startOffset2;
            }
        }
        if (J() > 0) {
            if (this.x ^ this.y) {
                int fixOffset = k2(endOffset, recycler, state, true);
                int startOffset3 = startOffset + fixOffset;
                int fixOffset2 = l2(startOffset3, recycler, state, false);
                startOffset = startOffset3 + fixOffset2;
                endOffset = endOffset + fixOffset + fixOffset2;
            } else {
                int fixOffset3 = l2(startOffset, recycler, state, true);
                int endOffset2 = endOffset + fixOffset3;
                int fixOffset4 = k2(endOffset2, recycler, state, false);
                startOffset = startOffset + fixOffset3 + fixOffset4;
                endOffset = endOffset2 + fixOffset4;
            }
        }
        s2(recycler, state, startOffset, endOffset);
        if (!state.e()) {
            this.u.s();
        } else {
            this.D.e();
        }
        this.v = this.y;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.z state) {
        super.Y0(state);
        this.C = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D.e();
    }

    public void t2(RecyclerView.u recycler, RecyclerView.z state, a anchorInfo, int firstLayoutItemDirection) {
    }

    public final void s2(RecyclerView.u recycler, RecyclerView.z state, int startOffset, int endOffset) {
        if (state.g() && J() != 0 && !state.e()) {
            if (!L1()) {
                return;
            }
            int scrapExtraStart = 0;
            int scrapExtraEnd = 0;
            List<RecyclerView.c0> k = recycler.k();
            int scrapSize = k.size();
            int firstChildPos = h0(I(0));
            for (int i = 0; i < scrapSize; i++) {
                RecyclerView.c0 scrap = k.get(i);
                if (!scrap.v()) {
                    int position = scrap.m();
                    int direction = (position < firstChildPos) != this.x ? -1 : 1;
                    if (direction == -1) {
                        scrapExtraStart += this.u.e(scrap.f889b);
                    } else {
                        scrapExtraEnd += this.u.e(scrap.f889b);
                    }
                }
            }
            this.t.k = k;
            if (scrapExtraStart > 0) {
                View anchor = n2();
                K2(h0(anchor), startOffset);
                c cVar = this.t;
                cVar.h = scrapExtraStart;
                cVar.c = 0;
                cVar.a();
                U1(recycler, this.t, state, false);
            }
            if (scrapExtraEnd > 0) {
                View anchor2 = m2();
                I2(h0(anchor2), endOffset);
                c cVar2 = this.t;
                cVar2.h = scrapExtraEnd;
                cVar2.c = 0;
                cVar2.a();
                U1(recycler, this.t, state, false);
            }
            this.t.k = null;
        }
    }

    public final void G2(RecyclerView.u recycler, RecyclerView.z state, a anchorInfo) {
        if (F2(state, anchorInfo) || E2(recycler, state, anchorInfo)) {
            return;
        }
        anchorInfo.a();
        anchorInfo.f878b = this.y ? state.b() - 1 : 0;
    }

    public final boolean E2(RecyclerView.u recycler, RecyclerView.z state, a anchorInfo) {
        View referenceChild;
        int m;
        if (J() == 0) {
            return false;
        }
        View focused = V();
        if (focused != null && anchorInfo.d(focused, state)) {
            anchorInfo.c(focused, h0(focused));
            return true;
        }
        if (this.v != this.y) {
            return false;
        }
        if (anchorInfo.d) {
            referenceChild = i2(recycler, state);
        } else {
            referenceChild = j2(recycler, state);
        }
        if (referenceChild == null) {
            return false;
        }
        anchorInfo.b(referenceChild, h0(referenceChild));
        if (!state.e() && L1()) {
            boolean notVisible = this.u.g(referenceChild) >= this.u.i() || this.u.d(referenceChild) < this.u.m();
            if (notVisible) {
                if (anchorInfo.d) {
                    m = this.u.i();
                } else {
                    m = this.u.m();
                }
                anchorInfo.c = m;
            }
        }
        return true;
    }

    public final boolean F2(RecyclerView.z state, a anchorInfo) {
        int i;
        int g;
        if (state.e() || (i = this.A) == -1) {
            return false;
        }
        if (i < 0 || i >= state.b()) {
            this.A = -1;
            this.B = Integer.MIN_VALUE;
            return false;
        }
        anchorInfo.f878b = this.A;
        d dVar = this.C;
        if (dVar == null || !dVar.j()) {
            if (this.B == Integer.MIN_VALUE) {
                View child = C(this.A);
                if (child != null) {
                    int childSize = this.u.e(child);
                    if (childSize > this.u.n()) {
                        anchorInfo.a();
                        return true;
                    }
                    int startGap = this.u.g(child) - this.u.m();
                    if (startGap < 0) {
                        anchorInfo.c = this.u.m();
                        anchorInfo.d = false;
                        return true;
                    }
                    int endGap = this.u.i() - this.u.d(child);
                    if (endGap < 0) {
                        anchorInfo.c = this.u.i();
                        anchorInfo.d = true;
                        return true;
                    }
                    if (anchorInfo.d) {
                        g = this.u.d(child) + this.u.o();
                    } else {
                        g = this.u.g(child);
                    }
                    anchorInfo.c = g;
                } else {
                    if (J() > 0) {
                        int pos = h0(I(0));
                        anchorInfo.d = (this.A < pos) == this.x;
                    }
                    anchorInfo.a();
                }
                return true;
            }
            boolean z = this.x;
            anchorInfo.d = z;
            if (z) {
                anchorInfo.c = this.u.i() - this.B;
            } else {
                anchorInfo.c = this.u.m() + this.B;
            }
            return true;
        }
        boolean z2 = this.C.d;
        anchorInfo.d = z2;
        if (z2) {
            anchorInfo.c = this.u.i() - this.C.c;
        } else {
            anchorInfo.c = this.u.m() + this.C.c;
        }
        return true;
    }

    public final int k2(int endOffset, RecyclerView.u recycler, RecyclerView.z state, boolean canOffsetChildren) {
        int gap;
        int gap2 = this.u.i() - endOffset;
        if (gap2 > 0) {
            int fixOffset = -A2(-gap2, recycler, state);
            int endOffset2 = endOffset + fixOffset;
            if (canOffsetChildren && (gap = this.u.i() - endOffset2) > 0) {
                this.u.r(gap);
                return gap + fixOffset;
            }
            return fixOffset;
        }
        return 0;
    }

    public final int l2(int startOffset, RecyclerView.u recycler, RecyclerView.z state, boolean canOffsetChildren) {
        int gap;
        int gap2 = startOffset - this.u.m();
        if (gap2 > 0) {
            int fixOffset = -A2(gap2, recycler, state);
            int startOffset2 = startOffset + fixOffset;
            if (canOffsetChildren && (gap = startOffset2 - this.u.m()) > 0) {
                this.u.r(-gap);
                return fixOffset - gap;
            }
            return fixOffset;
        }
        return 0;
    }

    public final void J2(a anchorInfo) {
        I2(anchorInfo.f878b, anchorInfo.c);
    }

    public final void I2(int itemPosition, int offset) {
        this.t.c = this.u.i() - offset;
        c cVar = this.t;
        cVar.e = this.x ? -1 : 1;
        cVar.d = itemPosition;
        cVar.f = 1;
        cVar.f882b = offset;
        cVar.g = Integer.MIN_VALUE;
    }

    public final void L2(a anchorInfo) {
        K2(anchorInfo.f878b, anchorInfo.c);
    }

    public final void K2(int itemPosition, int offset) {
        this.t.c = offset - this.u.m();
        c cVar = this.t;
        cVar.d = itemPosition;
        cVar.e = this.x ? 1 : -1;
        cVar.f = -1;
        cVar.f882b = offset;
        cVar.g = Integer.MIN_VALUE;
    }

    public boolean q2() {
        return Z() == 1;
    }

    public void T1() {
        if (this.t == null) {
            this.t = S1();
        }
    }

    public c S1() {
        return new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int position) {
        this.A = position;
        this.B = Integer.MIN_VALUE;
        d dVar = this.C;
        if (dVar != null) {
            dVar.k();
        }
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int dx, RecyclerView.u recycler, RecyclerView.z state) {
        if (this.s == 1) {
            return 0;
        }
        return A2(dx, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int dy, RecyclerView.u recycler, RecyclerView.z state) {
        if (this.s == 0) {
            return 0;
        }
        return A2(dy, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z state) {
        return P1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z state) {
        return P1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.z state) {
        return O1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z state) {
        return O1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z state) {
        return Q1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z state) {
        return Q1(state);
    }

    public final int P1(RecyclerView.z state) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.b(state, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z, this.x);
    }

    public final int O1(RecyclerView.z state) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.a(state, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z);
    }

    public final int Q1(RecyclerView.z state) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.c(state, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z);
    }

    public final void H2(int layoutDirection, int requiredSpace, boolean canUseExistingSpace, RecyclerView.z state) {
        int scrollingOffset;
        this.t.l = y2();
        this.t.f = layoutDirection;
        int[] iArr = this.G;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(state, iArr);
        int extraForStart = Math.max(0, this.G[0]);
        int extraForEnd = Math.max(0, this.G[1]);
        boolean layoutToEnd = layoutDirection == 1;
        c cVar = this.t;
        int i = layoutToEnd ? extraForEnd : extraForStart;
        cVar.h = i;
        cVar.i = layoutToEnd ? extraForStart : extraForEnd;
        if (layoutToEnd) {
            cVar.h = i + this.u.j();
            View child = m2();
            c cVar2 = this.t;
            cVar2.e = this.x ? -1 : 1;
            int h0 = h0(child);
            c cVar3 = this.t;
            cVar2.d = h0 + cVar3.e;
            cVar3.f882b = this.u.d(child);
            scrollingOffset = this.u.d(child) - this.u.i();
        } else {
            View child2 = n2();
            this.t.h += this.u.m();
            c cVar4 = this.t;
            cVar4.e = this.x ? 1 : -1;
            int h02 = h0(child2);
            c cVar5 = this.t;
            cVar4.d = h02 + cVar5.e;
            cVar5.f882b = this.u.g(child2);
            scrollingOffset = (-this.u.g(child2)) + this.u.m();
        }
        c cVar6 = this.t;
        cVar6.c = requiredSpace;
        if (canUseExistingSpace) {
            cVar6.c = requiredSpace - scrollingOffset;
        }
        cVar6.g = scrollingOffset;
    }

    public boolean y2() {
        return this.u.k() == 0 && this.u.h() == 0;
    }

    public void N1(RecyclerView.z state, c layoutState, RecyclerView.o.c layoutPrefetchRegistry) {
        int pos = layoutState.d;
        if (pos >= 0 && pos < state.b()) {
            ((e.b) layoutPrefetchRegistry).a(pos, Math.max(0, layoutState.g));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int adapterItemCount, RecyclerView.o.c layoutPrefetchRegistry) {
        boolean fromEnd;
        int anchorPos;
        d dVar = this.C;
        if (dVar != null && dVar.j()) {
            d dVar2 = this.C;
            fromEnd = dVar2.d;
            anchorPos = dVar2.f883b;
        } else {
            z2();
            fromEnd = this.x;
            if (this.A == -1) {
                anchorPos = fromEnd ? adapterItemCount - 1 : 0;
            } else {
                anchorPos = this.A;
            }
        }
        int direction = fromEnd ? -1 : 1;
        int targetPos = anchorPos;
        for (int i = 0; i < this.F && targetPos >= 0 && targetPos < adapterItemCount; i++) {
            ((e.b) layoutPrefetchRegistry).a(targetPos, 0);
            targetPos += direction;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int dx, int dy, RecyclerView.z state, RecyclerView.o.c layoutPrefetchRegistry) {
        int delta = this.s == 0 ? dx : dy;
        if (J() == 0 || delta == 0) {
            return;
        }
        T1();
        int layoutDirection = delta > 0 ? 1 : -1;
        int absDelta = Math.abs(delta);
        H2(layoutDirection, absDelta, true, state);
        N1(state, this.t, layoutPrefetchRegistry);
    }

    public int A2(int delta, RecyclerView.u recycler, RecyclerView.z state) {
        if (J() == 0 || delta == 0) {
            return 0;
        }
        T1();
        this.t.f881a = true;
        int layoutDirection = delta > 0 ? 1 : -1;
        int absDelta = Math.abs(delta);
        H2(layoutDirection, absDelta, true, state);
        c cVar = this.t;
        int consumed = cVar.g + U1(recycler, cVar, state, false);
        if (consumed < 0) {
            return 0;
        }
        int scrolled = absDelta > consumed ? layoutDirection * consumed : delta;
        this.u.r(-scrolled);
        this.t.j = scrolled;
        return scrolled;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String message) {
        if (this.C == null) {
            super.g(message);
        }
    }

    public final void v2(RecyclerView.u recycler, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return;
        }
        if (endIndex > startIndex) {
            for (int i = endIndex - 1; i >= startIndex; i--) {
                n1(i, recycler);
            }
            return;
        }
        for (int i2 = startIndex; i2 > endIndex; i2--) {
            n1(i2, recycler);
        }
    }

    public final void x2(RecyclerView.u recycler, int scrollingOffset, int noRecycleSpace) {
        if (scrollingOffset < 0) {
            return;
        }
        int limit = scrollingOffset - noRecycleSpace;
        int childCount = J();
        if (this.x) {
            for (int i = childCount - 1; i >= 0; i--) {
                View child = I(i);
                if (this.u.d(child) > limit || this.u.p(child) > limit) {
                    v2(recycler, childCount - 1, i);
                    return;
                }
            }
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View child2 = I(i2);
            if (this.u.d(child2) > limit || this.u.p(child2) > limit) {
                v2(recycler, 0, i2);
                return;
            }
        }
    }

    public final void w2(RecyclerView.u recycler, int scrollingOffset, int noRecycleSpace) {
        int childCount = J();
        if (scrollingOffset < 0) {
            return;
        }
        int limit = (this.u.h() - scrollingOffset) + noRecycleSpace;
        if (this.x) {
            for (int i = 0; i < childCount; i++) {
                View child = I(i);
                if (this.u.g(child) < limit || this.u.q(child) < limit) {
                    v2(recycler, 0, i);
                    return;
                }
            }
            return;
        }
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View child2 = I(i2);
            if (this.u.g(child2) < limit || this.u.q(child2) < limit) {
                v2(recycler, childCount - 1, i2);
                return;
            }
        }
    }

    public final void u2(RecyclerView.u recycler, c layoutState) {
        if (!layoutState.f881a || layoutState.l) {
            return;
        }
        int scrollingOffset = layoutState.g;
        int noRecycleSpace = layoutState.i;
        if (layoutState.f == -1) {
            w2(recycler, scrollingOffset, noRecycleSpace);
        } else {
            x2(recycler, scrollingOffset, noRecycleSpace);
        }
    }

    public int U1(RecyclerView.u recycler, c layoutState, RecyclerView.z state, boolean stopOnFocusable) {
        int start = layoutState.c;
        int i = layoutState.g;
        if (i != Integer.MIN_VALUE) {
            int i2 = layoutState.c;
            if (i2 < 0) {
                layoutState.g = i + i2;
            }
            u2(recycler, layoutState);
        }
        int remainingSpace = layoutState.c + layoutState.h;
        b layoutChunkResult = this.E;
        while (true) {
            if ((!layoutState.l && remainingSpace <= 0) || !layoutState.c(state)) {
                break;
            }
            layoutChunkResult.a();
            r2(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f880b) {
                layoutState.f882b += layoutChunkResult.f879a * layoutState.f;
                if (!layoutChunkResult.c || layoutState.k != null || !state.e()) {
                    int i3 = layoutState.c;
                    int i4 = layoutChunkResult.f879a;
                    layoutState.c = i3 - i4;
                    remainingSpace -= i4;
                }
                int i5 = layoutState.g;
                if (i5 != Integer.MIN_VALUE) {
                    int i6 = i5 + layoutChunkResult.f879a;
                    layoutState.g = i6;
                    int i7 = layoutState.c;
                    if (i7 < 0) {
                        layoutState.g = i6 + i7;
                    }
                    u2(recycler, layoutState);
                }
                if (stopOnFocusable && layoutChunkResult.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return start - layoutState.c;
    }

    public void r2(RecyclerView.u recycler, RecyclerView.z state, c layoutState, b result) {
        int bottom;
        int right;
        int left;
        int top;
        int left2;
        int right2;
        View view = layoutState.d(recycler);
        if (view == null) {
            result.f880b = true;
            return;
        }
        RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
        if (layoutState.k == null) {
            if (this.x == (layoutState.f == -1)) {
                d(view);
            } else {
                e(view, 0);
            }
        } else {
            if (this.x == (layoutState.f == -1)) {
                b(view);
            } else {
                c(view, 0);
            }
        }
        A0(view, 0, 0);
        result.f879a = this.u.e(view);
        if (this.s == 1) {
            if (q2()) {
                right2 = o0() - f0();
                left2 = right2 - this.u.f(view);
            } else {
                left2 = e0();
                right2 = this.u.f(view) + left2;
            }
            if (layoutState.f == -1) {
                right = right2;
                bottom = layoutState.f882b;
                left = left2;
                top = layoutState.f882b - result.f879a;
            } else {
                int top2 = layoutState.f882b;
                right = right2;
                bottom = layoutState.f882b + result.f879a;
                left = left2;
                top = top2;
            }
        } else {
            int top3 = g0();
            int bottom2 = this.u.f(view) + top3;
            if (layoutState.f == -1) {
                int right3 = layoutState.f882b;
                bottom = bottom2;
                right = right3;
                left = layoutState.f882b - result.f879a;
                top = top3;
            } else {
                int left3 = layoutState.f882b;
                bottom = bottom2;
                right = layoutState.f882b + result.f879a;
                left = left3;
                top = top3;
            }
        }
        z0(view, left, top, right, bottom);
        if (params.c() || params.b()) {
            result.c = true;
        }
        result.d = view.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean G1() {
        return (X() == 1073741824 || p0() == 1073741824 || !q0()) ? false : true;
    }

    public int R1(int focusDirection) {
        switch (focusDirection) {
            case 1:
                return (this.s != 1 && q2()) ? 1 : -1;
            case 2:
                return (this.s != 1 && q2()) ? -1 : 1;
            case 17:
                return this.s == 0 ? -1 : Integer.MIN_VALUE;
            case 33:
                return this.s == 1 ? -1 : Integer.MIN_VALUE;
            case 66:
                return this.s == 0 ? 1 : Integer.MIN_VALUE;
            case 130:
                return this.s == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public final View n2() {
        return I(this.x ? J() - 1 : 0);
    }

    public final View m2() {
        return I(this.x ? 0 : J() - 1);
    }

    public View Y1(boolean completelyVisible, boolean acceptPartiallyVisible) {
        if (this.x) {
            return e2(J() - 1, -1, completelyVisible, acceptPartiallyVisible);
        }
        return e2(0, J(), completelyVisible, acceptPartiallyVisible);
    }

    public View X1(boolean completelyVisible, boolean acceptPartiallyVisible) {
        if (this.x) {
            return e2(0, J(), completelyVisible, acceptPartiallyVisible);
        }
        return e2(J() - 1, -1, completelyVisible, acceptPartiallyVisible);
    }

    public final View i2(RecyclerView.u recycler, RecyclerView.z state) {
        return this.x ? W1(recycler, state) : b2(recycler, state);
    }

    public final View j2(RecyclerView.u recycler, RecyclerView.z state) {
        return this.x ? b2(recycler, state) : W1(recycler, state);
    }

    public final View W1(RecyclerView.u recycler, RecyclerView.z state) {
        return h2(recycler, state, 0, J(), state.b());
    }

    public final View b2(RecyclerView.u recycler, RecyclerView.z state) {
        return h2(recycler, state, J() - 1, -1, state.b());
    }

    public View h2(RecyclerView.u recycler, RecyclerView.z state, int start, int end, int itemCount) {
        T1();
        View invalidMatch = null;
        View outOfBoundsMatch = null;
        int boundsStart = this.u.m();
        int boundsEnd = this.u.i();
        int diff = end > start ? 1 : -1;
        for (int i = start; i != end; i += diff) {
            View view = I(i);
            int position = h0(view);
            if (position >= 0 && position < itemCount) {
                if (((RecyclerView.p) view.getLayoutParams()).c()) {
                    if (invalidMatch == null) {
                        invalidMatch = view;
                    }
                } else if (this.u.g(view) >= boundsEnd || this.u.d(view) < boundsStart) {
                    if (outOfBoundsMatch == null) {
                        outOfBoundsMatch = view;
                    }
                } else {
                    return view;
                }
            }
        }
        return outOfBoundsMatch != null ? outOfBoundsMatch : invalidMatch;
    }

    public final View f2() {
        return this.x ? V1() : a2();
    }

    public final View g2() {
        return this.x ? a2() : V1();
    }

    public final View V1() {
        return d2(0, J());
    }

    public final View a2() {
        return d2(J() - 1, -1);
    }

    public int Z1() {
        View child = e2(0, J(), false, true);
        if (child == null) {
            return -1;
        }
        return h0(child);
    }

    public int c2() {
        View child = e2(J() - 1, -1, false, true);
        if (child == null) {
            return -1;
        }
        return h0(child);
    }

    public View e2(int fromIndex, int toIndex, boolean completelyVisible, boolean acceptPartiallyVisible) {
        int preferredBoundsFlag;
        T1();
        int acceptableBoundsFlag = 0;
        if (completelyVisible) {
            preferredBoundsFlag = 24579;
        } else {
            preferredBoundsFlag = 320;
        }
        if (acceptPartiallyVisible) {
            acceptableBoundsFlag = 320;
        }
        if (this.s == 0) {
            return this.e.a(fromIndex, toIndex, preferredBoundsFlag, acceptableBoundsFlag);
        }
        return this.f.a(fromIndex, toIndex, preferredBoundsFlag, acceptableBoundsFlag);
    }

    public View d2(int fromIndex, int toIndex) {
        int preferredBoundsFlag;
        int acceptableBoundsFlag;
        T1();
        int next = toIndex > fromIndex ? 1 : toIndex < fromIndex ? -1 : 0;
        if (next == 0) {
            return I(fromIndex);
        }
        if (this.u.g(I(fromIndex)) < this.u.m()) {
            preferredBoundsFlag = 16644;
            acceptableBoundsFlag = 16388;
        } else {
            preferredBoundsFlag = 4161;
            acceptableBoundsFlag = 4097;
        }
        if (this.s == 0) {
            return this.e.a(fromIndex, toIndex, preferredBoundsFlag, acceptableBoundsFlag);
        }
        return this.f.a(fromIndex, toIndex, preferredBoundsFlag, acceptableBoundsFlag);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View focused, int focusDirection, RecyclerView.u recycler, RecyclerView.z state) {
        int layoutDir;
        View nextCandidate;
        View nextFocus;
        z2();
        if (J() == 0 || (layoutDir = R1(focusDirection)) == Integer.MIN_VALUE) {
            return null;
        }
        T1();
        int maxScroll = (int) (this.u.n() * 0.33333334f);
        H2(layoutDir, maxScroll, false, state);
        c cVar = this.t;
        cVar.g = Integer.MIN_VALUE;
        cVar.f881a = false;
        U1(recycler, cVar, state, true);
        if (layoutDir == -1) {
            nextCandidate = g2();
        } else {
            nextCandidate = f2();
        }
        if (layoutDir == -1) {
            nextFocus = n2();
        } else {
            nextFocus = m2();
        }
        if (nextFocus.hasFocusable()) {
            if (nextCandidate == null) {
                return null;
            }
            return nextFocus;
        }
        return nextCandidate;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.C == null && this.v == this.y;
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        public int f882b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int j;
        public boolean l;

        /* renamed from: a, reason: collision with root package name */
        public boolean f881a = true;
        public int h = 0;
        public int i = 0;
        public List<RecyclerView.c0> k = null;

        public boolean c(RecyclerView.z state) {
            int i = this.d;
            return i >= 0 && i < state.b();
        }

        public View d(RecyclerView.u recycler) {
            if (this.k != null) {
                return e();
            }
            View view = recycler.o(this.d);
            this.d += this.e;
            return view;
        }

        public final View e() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = this.k.get(i).f889b;
                RecyclerView.p lp = (RecyclerView.p) view.getLayoutParams();
                if (!lp.c() && this.d == lp.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View ignore) {
            View closest = f(ignore);
            if (closest == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.p) closest.getLayoutParams()).a();
            }
        }

        public View f(View ignore) {
            int distance;
            int size = this.k.size();
            View closest = null;
            int closestDistance = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                View view = this.k.get(i).f889b;
                RecyclerView.p lp = (RecyclerView.p) view.getLayoutParams();
                if (view != ignore && !lp.c() && (distance = (lp.a() - this.d) * this.e) >= 0 && distance < closestDistance) {
                    closest = view;
                    closestDistance = distance;
                    if (distance == 0) {
                        break;
                    }
                }
            }
            return closest;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f883b;
        public int c;
        public boolean d;

        public d() {
        }

        public d(Parcel in) {
            this.f883b = in.readInt();
            this.c = in.readInt();
            this.d = in.readInt() == 1;
        }

        public d(d other) {
            this.f883b = other.f883b;
            this.c = other.c;
            this.d = other.d;
        }

        public boolean j() {
            return this.f883b >= 0;
        }

        public void k() {
            this.f883b = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f883b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d ? 1 : 0);
        }

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<d> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel in) {
                return new d(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int size) {
                return new d[size];
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public i f877a;

        /* renamed from: b, reason: collision with root package name */
        public int f878b;
        public int c;
        public boolean d;
        public boolean e;

        public a() {
            e();
        }

        public void e() {
            this.f878b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public void a() {
            int m;
            if (this.d) {
                m = this.f877a.i();
            } else {
                m = this.f877a.m();
            }
            this.c = m;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f878b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }

        public boolean d(View child, RecyclerView.z state) {
            RecyclerView.p lp = (RecyclerView.p) child.getLayoutParams();
            return !lp.c() && lp.a() >= 0 && lp.a() < state.b();
        }

        public void c(View child, int position) {
            int spaceChange = this.f877a.o();
            if (spaceChange >= 0) {
                b(child, position);
                return;
            }
            this.f878b = position;
            if (this.d) {
                int prevLayoutEnd = this.f877a.i() - spaceChange;
                int childEnd = this.f877a.d(child);
                int previousEndMargin = prevLayoutEnd - childEnd;
                this.c = this.f877a.i() - previousEndMargin;
                if (previousEndMargin > 0) {
                    int childSize = this.f877a.e(child);
                    int estimatedChildStart = this.c - childSize;
                    int layoutStart = this.f877a.m();
                    int previousStartMargin = this.f877a.g(child) - layoutStart;
                    int startReference = Math.min(previousStartMargin, 0) + layoutStart;
                    int startMargin = estimatedChildStart - startReference;
                    if (startMargin < 0) {
                        this.c += Math.min(previousEndMargin, -startMargin);
                        return;
                    }
                    return;
                }
                return;
            }
            int childStart = this.f877a.g(child);
            int startMargin2 = childStart - this.f877a.m();
            this.c = childStart;
            if (startMargin2 > 0) {
                int estimatedEnd = this.f877a.e(child) + childStart;
                int previousLayoutEnd = this.f877a.i() - spaceChange;
                int endReference = this.f877a.i() - Math.min(0, previousLayoutEnd - this.f877a.d(child));
                int endMargin = endReference - estimatedEnd;
                if (endMargin < 0) {
                    this.c -= Math.min(startMargin2, -endMargin);
                }
            }
        }

        public void b(View child, int position) {
            if (this.d) {
                this.c = this.f877a.d(child) + this.f877a.o();
            } else {
                this.c = this.f877a.g(child);
            }
            this.f878b = position;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f879a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f880b;
        public boolean c;
        public boolean d;

        public void a() {
            this.f879a = 0;
            this.f880b = false;
            this.c = false;
            this.d = false;
        }
    }
}
