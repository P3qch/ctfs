package androidx.recyclerview.widget;

import a.h.k.e0.c;
import a.o.b.e;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean H;
    public int I;
    public int[] J;
    public View[] K;
    public final SparseIntArray L;
    public final SparseIntArray M;
    public c N;
    public final Rect O;

    public GridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.H = false;
        this.I = -1;
        this.L = new SparseIntArray();
        this.M = new SparseIntArray();
        this.N = new a();
        this.O = new Rect();
        RecyclerView.o.d properties = RecyclerView.o.i0(context, attrs, defStyleAttr, defStyleRes);
        a3(properties.f905b);
    }

    public GridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(orientation, reverseLayout);
        this.H = false;
        this.I = -1;
        this.L = new SparseIntArray();
        this.M = new SparseIntArray();
        this.N = new a();
        this.O = new Rect();
        a3(spanCount);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void D2(boolean stackFromEnd) {
        if (stackFromEnd) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.D2(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.u recycler, RecyclerView.z state) {
        if (this.s == 0) {
            return this.I;
        }
        if (state.b() < 1) {
            return 0;
        }
        return U2(recycler, state, state.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.u recycler, RecyclerView.z state) {
        if (this.s == 1) {
            return this.I;
        }
        if (state.b() < 1) {
            return 0;
        }
        return U2(recycler, state, state.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.u recycler, RecyclerView.z state, View host, a.h.k.e0.c info) {
        ViewGroup.LayoutParams lp = host.getLayoutParams();
        if (!(lp instanceof b)) {
            O0(host, info);
            return;
        }
        b glp = (b) lp;
        int spanGroupIndex = U2(recycler, state, glp.a());
        if (this.s == 0) {
            info.Z(c.C0030c.a(glp.e(), glp.f(), spanGroupIndex, 1, false, false));
        } else {
            info.Z(c.C0030c.a(spanGroupIndex, 1, glp.e(), glp.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.u recycler, RecyclerView.z state) {
        if (state.e()) {
            N2();
        }
        super.X0(recycler, state);
        Q2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.z state) {
        super.Y0(state);
        this.H = false;
    }

    public final void Q2() {
        this.L.clear();
        this.M.clear();
    }

    public final void N2() {
        int childCount = J();
        for (int i = 0; i < childCount; i++) {
            b lp = (b) I(i).getLayoutParams();
            int viewPosition = lp.a();
            this.L.put(viewPosition, lp.f());
            this.M.put(viewPosition, lp.e());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int positionStart, int itemCount) {
        this.N.g();
        this.N.f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.N.g();
        this.N.f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int positionStart, int itemCount) {
        this.N.g();
        this.N.f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        this.N.g();
        this.N.f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int from, int to, int itemCount) {
        this.N.g();
        this.N.f();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        if (this.s == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context c2, AttributeSet attrs) {
        return new b(c2, attrs);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams lp) {
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) lp);
        }
        return new b(lp);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p lp) {
        return lp instanceof b;
    }

    public final void b3() {
        int totalSpace;
        if (p2() == 1) {
            totalSpace = (o0() - f0()) - e0();
        } else {
            int totalSpace2 = W();
            totalSpace = (totalSpace2 - d0()) - g0();
        }
        O2(totalSpace);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect childrenBounds, int wSpec, int hSpec) {
        int usedHeight;
        int width;
        if (this.J == null) {
            super.C1(childrenBounds, wSpec, hSpec);
        }
        int horizontalPadding = e0() + f0();
        int verticalPadding = g0() + d0();
        if (this.s == 1) {
            int usedHeight2 = childrenBounds.height() + verticalPadding;
            width = RecyclerView.o.n(hSpec, usedHeight2, b0());
            int[] iArr = this.J;
            usedHeight = RecyclerView.o.n(wSpec, iArr[iArr.length - 1] + horizontalPadding, c0());
        } else {
            int width2 = childrenBounds.width();
            int usedWidth = width2 + horizontalPadding;
            int width3 = RecyclerView.o.n(wSpec, usedWidth, c0());
            int[] iArr2 = this.J;
            usedHeight = width3;
            width = RecyclerView.o.n(hSpec, iArr2[iArr2.length - 1] + verticalPadding, b0());
        }
        B1(usedHeight, width);
    }

    public final void O2(int totalSpace) {
        this.J = P2(this.J, this.I, totalSpace);
    }

    public static int[] P2(int[] cachedBorders, int spanCount, int totalSpace) {
        if (cachedBorders == null || cachedBorders.length != spanCount + 1 || cachedBorders[cachedBorders.length - 1] != totalSpace) {
            cachedBorders = new int[spanCount + 1];
        }
        cachedBorders[0] = 0;
        int sizePerSpan = totalSpace / spanCount;
        int sizePerSpanRemainder = totalSpace % spanCount;
        int consumedPixels = 0;
        int additionalSize = 0;
        for (int i = 1; i <= spanCount; i++) {
            int itemSize = sizePerSpan;
            additionalSize += sizePerSpanRemainder;
            if (additionalSize > 0 && spanCount - additionalSize < sizePerSpanRemainder) {
                itemSize++;
                additionalSize -= spanCount;
            }
            consumedPixels += itemSize;
            cachedBorders[i] = consumedPixels;
        }
        return cachedBorders;
    }

    public int T2(int startSpan, int spanSize) {
        if (this.s == 1 && q2()) {
            int[] iArr = this.J;
            int i = this.I;
            return iArr[i - startSpan] - iArr[(i - startSpan) - spanSize];
        }
        int[] iArr2 = this.J;
        return iArr2[startSpan + spanSize] - iArr2[startSpan];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void t2(RecyclerView.u recycler, RecyclerView.z state, LinearLayoutManager.a anchorInfo, int itemDirection) {
        super.t2(recycler, state, anchorInfo, itemDirection);
        b3();
        if (state.b() > 0 && !state.e()) {
            R2(recycler, state, anchorInfo, itemDirection);
        }
        S2();
    }

    public final void S2() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int w1(int dx, RecyclerView.u recycler, RecyclerView.z state) {
        b3();
        S2();
        return super.w1(dx, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int y1(int dy, RecyclerView.u recycler, RecyclerView.z state) {
        b3();
        S2();
        return super.y1(dy, recycler, state);
    }

    public final void R2(RecyclerView.u recycler, RecyclerView.z state, LinearLayoutManager.a anchorInfo, int itemDirection) {
        boolean layingOutInPrimaryDirection = itemDirection == 1;
        int span = V2(recycler, state, anchorInfo.f878b);
        if (!layingOutInPrimaryDirection) {
            int indexLimit = state.b() - 1;
            int pos = anchorInfo.f878b;
            int bestSpan = span;
            while (pos < indexLimit) {
                int next = V2(recycler, state, pos + 1);
                if (next <= bestSpan) {
                    break;
                }
                pos++;
                bestSpan = next;
            }
            anchorInfo.f878b = pos;
            return;
        }
        while (span > 0) {
            int i = anchorInfo.f878b;
            if (i > 0) {
                int i2 = i - 1;
                anchorInfo.f878b = i2;
                span = V2(recycler, state, i2);
            } else {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
                int span = V2(recycler, state, position);
                if (span != 0) {
                    continue;
                } else if (((RecyclerView.p) view.getLayoutParams()).c()) {
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

    public final int U2(RecyclerView.u recycler, RecyclerView.z state, int viewPosition) {
        if (!state.e()) {
            return this.N.a(viewPosition, this.I);
        }
        int adapterPosition = recycler.f(viewPosition);
        if (adapterPosition == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + viewPosition);
            return 0;
        }
        return this.N.a(adapterPosition, this.I);
    }

    public final int V2(RecyclerView.u recycler, RecyclerView.z state, int pos) {
        if (!state.e()) {
            return this.N.b(pos, this.I);
        }
        int cached = this.M.get(pos, -1);
        if (cached != -1) {
            return cached;
        }
        int adapterPosition = recycler.f(pos);
        if (adapterPosition == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + pos);
            return 0;
        }
        return this.N.b(adapterPosition, this.I);
    }

    public final int W2(RecyclerView.u recycler, RecyclerView.z state, int pos) {
        if (!state.e()) {
            this.N.e(pos);
            return 1;
        }
        int cached = this.L.get(pos, -1);
        if (cached != -1) {
            return cached;
        }
        int adapterPosition = recycler.f(pos);
        if (adapterPosition == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + pos);
            return 1;
        }
        this.N.e(adapterPosition);
        return 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void N1(RecyclerView.z state, LinearLayoutManager.c layoutState, RecyclerView.o.c layoutPrefetchRegistry) {
        int remainingSpan = this.I;
        for (int count = 0; count < this.I && layoutState.c(state) && remainingSpan > 0; count++) {
            int pos = layoutState.d;
            ((e.b) layoutPrefetchRegistry).a(pos, Math.max(0, layoutState.g));
            this.N.e(pos);
            remainingSpan--;
            layoutState.d += layoutState.e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void r2(RecyclerView.u recycler, RecyclerView.z state, LinearLayoutManager.c layoutState, LinearLayoutManager.b result) {
        int itemSpanIndex;
        int consumedSpanCount;
        int maxSize;
        int left;
        int right;
        int top;
        int bottom;
        float maxSizeInOther;
        int otherDirSpecMode;
        boolean flexibleInOtherDir;
        int wSpec;
        int hSpec;
        boolean z;
        View view;
        int otherDirSpecMode2 = this.u.l();
        boolean flexibleInOtherDir2 = otherDirSpecMode2 != 1073741824;
        int currentOtherDirSize = J() > 0 ? this.J[this.I] : 0;
        if (flexibleInOtherDir2) {
            b3();
        }
        boolean layingOutInPrimaryDirection = layoutState.e == 1;
        int remainingSpan = this.I;
        if (!layingOutInPrimaryDirection) {
            int itemSpanIndex2 = V2(recycler, state, layoutState.d);
            int itemSpanSize = W2(recycler, state, layoutState.d);
            remainingSpan = itemSpanIndex2 + itemSpanSize;
            itemSpanIndex = 0;
            consumedSpanCount = 0;
        } else {
            itemSpanIndex = 0;
            consumedSpanCount = 0;
        }
        while (itemSpanIndex < this.I && layoutState.c(state) && remainingSpan > 0) {
            int pos = layoutState.d;
            int spanSize = W2(recycler, state, pos);
            if (spanSize > this.I) {
                throw new IllegalArgumentException("Item at position " + pos + " requires " + spanSize + " spans but GridLayoutManager has only " + this.I + " spans.");
            }
            remainingSpan -= spanSize;
            if (remainingSpan < 0 || (view = layoutState.d(recycler)) == null) {
                break;
            }
            consumedSpanCount += spanSize;
            this.K[itemSpanIndex] = view;
            itemSpanIndex++;
        }
        if (itemSpanIndex == 0) {
            result.f880b = true;
            return;
        }
        int maxSize2 = 0;
        M2(recycler, state, itemSpanIndex, layingOutInPrimaryDirection);
        int i = 0;
        float maxSizeInOther2 = 0.0f;
        while (i < itemSpanIndex) {
            View view2 = this.K[i];
            if (layoutState.k == null) {
                if (layingOutInPrimaryDirection) {
                    d(view2);
                    z = false;
                } else {
                    z = false;
                    e(view2, 0);
                }
            } else {
                z = false;
                if (layingOutInPrimaryDirection) {
                    b(view2);
                } else {
                    c(view2, 0);
                }
            }
            j(view2, this.O);
            Y2(view2, otherDirSpecMode2, z);
            int size = this.u.e(view2);
            if (size > maxSize2) {
                maxSize2 = size;
            }
            int maxSize3 = maxSize2;
            float otherSize = (this.u.f(view2) * 1.0f) / ((b) view2.getLayoutParams()).f;
            if (otherSize > maxSizeInOther2) {
                maxSizeInOther2 = otherSize;
            }
            i++;
            maxSize2 = maxSize3;
        }
        if (!flexibleInOtherDir2) {
            maxSize = maxSize2;
        } else {
            X2(maxSizeInOther2, currentOtherDirSize);
            int maxSize4 = 0;
            for (int i2 = 0; i2 < itemSpanIndex; i2++) {
                View view3 = this.K[i2];
                Y2(view3, 1073741824, true);
                int size2 = this.u.e(view3);
                if (size2 > maxSize4) {
                    maxSize4 = size2;
                }
            }
            maxSize = maxSize4;
        }
        int i3 = 0;
        while (i3 < itemSpanIndex) {
            View view4 = this.K[i3];
            if (this.u.e(view4) == maxSize) {
                maxSizeInOther = maxSizeInOther2;
                otherDirSpecMode = otherDirSpecMode2;
                flexibleInOtherDir = flexibleInOtherDir2;
            } else {
                b lp = (b) view4.getLayoutParams();
                Rect decorInsets = lp.f907b;
                maxSizeInOther = maxSizeInOther2;
                int verticalInsets = decorInsets.top + decorInsets.bottom + ((ViewGroup.MarginLayoutParams) lp).topMargin + ((ViewGroup.MarginLayoutParams) lp).bottomMargin;
                int horizontalInsets = decorInsets.left + decorInsets.right + ((ViewGroup.MarginLayoutParams) lp).leftMargin + ((ViewGroup.MarginLayoutParams) lp).rightMargin;
                int totalSpaceInOther = T2(lp.e, lp.f);
                otherDirSpecMode = otherDirSpecMode2;
                if (this.s == 1) {
                    flexibleInOtherDir = flexibleInOtherDir2;
                    wSpec = RecyclerView.o.K(totalSpaceInOther, 1073741824, horizontalInsets, ((ViewGroup.MarginLayoutParams) lp).width, false);
                    hSpec = View.MeasureSpec.makeMeasureSpec(maxSize - verticalInsets, 1073741824);
                } else {
                    flexibleInOtherDir = flexibleInOtherDir2;
                    wSpec = View.MeasureSpec.makeMeasureSpec(maxSize - horizontalInsets, 1073741824);
                    hSpec = RecyclerView.o.K(totalSpaceInOther, 1073741824, verticalInsets, ((ViewGroup.MarginLayoutParams) lp).height, false);
                }
                Z2(view4, wSpec, hSpec, true);
            }
            i3++;
            flexibleInOtherDir2 = flexibleInOtherDir;
            maxSizeInOther2 = maxSizeInOther;
            otherDirSpecMode2 = otherDirSpecMode;
        }
        result.f879a = maxSize;
        int left2 = 0;
        int right2 = 0;
        int top2 = 0;
        int bottom2 = 0;
        if (this.s == 1) {
            if (layoutState.f == -1) {
                bottom2 = layoutState.f882b;
                top2 = bottom2 - maxSize;
            } else {
                top2 = layoutState.f882b;
                bottom2 = top2 + maxSize;
            }
        } else if (layoutState.f == -1) {
            right2 = layoutState.f882b;
            left2 = right2 - maxSize;
        } else {
            left2 = layoutState.f882b;
            right2 = left2 + maxSize;
        }
        int i4 = 0;
        while (i4 < itemSpanIndex) {
            View view5 = this.K[i4];
            b params = (b) view5.getLayoutParams();
            if (this.s == 1) {
                if (q2()) {
                    int right3 = e0() + this.J[this.I - params.e];
                    left = right3 - this.u.f(view5);
                    top = top2;
                    bottom = bottom2;
                    right = right3;
                } else {
                    int left3 = e0() + this.J[params.e];
                    left = left3;
                    right = this.u.f(view5) + left3;
                    top = top2;
                    bottom = bottom2;
                }
            } else {
                left = left2;
                right = right2;
                int top3 = g0() + this.J[params.e];
                top = top3;
                bottom = this.u.f(view5) + top3;
            }
            int count = itemSpanIndex;
            int count2 = bottom;
            z0(view5, left, top, right, count2);
            if (params.c() || params.b()) {
                result.c = true;
            }
            result.d |= view5.hasFocusable();
            i4++;
            top2 = top;
            left2 = left;
            right2 = right;
            bottom2 = bottom;
            itemSpanIndex = count;
        }
        Arrays.fill(this.K, (Object) null);
    }

    public final void Y2(View view, int otherDirParentSpecMode, boolean alreadyMeasured) {
        int hSpec;
        int wSpec;
        b lp = (b) view.getLayoutParams();
        Rect decorInsets = lp.f907b;
        int verticalInsets = decorInsets.top + decorInsets.bottom + ((ViewGroup.MarginLayoutParams) lp).topMargin + ((ViewGroup.MarginLayoutParams) lp).bottomMargin;
        int horizontalInsets = decorInsets.left + decorInsets.right + ((ViewGroup.MarginLayoutParams) lp).leftMargin + ((ViewGroup.MarginLayoutParams) lp).rightMargin;
        int availableSpaceInOther = T2(lp.e, lp.f);
        if (this.s == 1) {
            wSpec = RecyclerView.o.K(availableSpaceInOther, otherDirParentSpecMode, horizontalInsets, ((ViewGroup.MarginLayoutParams) lp).width, false);
            hSpec = RecyclerView.o.K(this.u.n(), X(), verticalInsets, ((ViewGroup.MarginLayoutParams) lp).height, true);
        } else {
            int wSpec2 = ((ViewGroup.MarginLayoutParams) lp).height;
            hSpec = RecyclerView.o.K(availableSpaceInOther, otherDirParentSpecMode, verticalInsets, wSpec2, false);
            wSpec = RecyclerView.o.K(this.u.n(), p0(), horizontalInsets, ((ViewGroup.MarginLayoutParams) lp).width, true);
        }
        Z2(view, wSpec, hSpec, alreadyMeasured);
    }

    public final void X2(float maxSizeInOther, int currentOtherDirSize) {
        int contentSize = Math.round(this.I * maxSizeInOther);
        O2(Math.max(contentSize, currentOtherDirSize));
    }

    public final void Z2(View child, int widthSpec, int heightSpec, boolean alreadyMeasured) {
        boolean measure;
        RecyclerView.p lp = (RecyclerView.p) child.getLayoutParams();
        if (alreadyMeasured) {
            measure = H1(child, widthSpec, heightSpec, lp);
        } else {
            measure = F1(child, widthSpec, heightSpec, lp);
        }
        if (measure) {
            child.measure(widthSpec, heightSpec);
        }
    }

    public final void M2(RecyclerView.u recycler, RecyclerView.z state, int count, boolean layingOutInPrimaryDirection) {
        int start;
        int end;
        int diff;
        if (layingOutInPrimaryDirection) {
            start = 0;
            end = count;
            diff = 1;
        } else {
            start = count - 1;
            end = -1;
            diff = -1;
        }
        int span = 0;
        for (int i = start; i != end; i += diff) {
            View view = this.K[i];
            b params = (b) view.getLayoutParams();
            int W2 = W2(recycler, state, h0(view));
            params.f = W2;
            params.e = span;
            span += W2;
        }
    }

    public void a3(int spanCount) {
        if (spanCount == this.I) {
            return;
        }
        this.H = true;
        if (spanCount < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + spanCount);
        }
        this.I = spanCount;
        this.N.g();
        t1();
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final SparseIntArray f875a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        public final SparseIntArray f876b = new SparseIntArray();
        public boolean c = false;
        public boolean d = false;

        public abstract int d(int i, int i2);

        public abstract int e(int i);

        public void g() {
            this.f875a.clear();
        }

        public void f() {
            this.f876b.clear();
        }

        public int b(int position, int spanCount) {
            return d(position, spanCount);
        }

        public int a(int position, int spanCount) {
            return c(position, spanCount);
        }

        public int c(int adapterPosition, int spanCount) {
            int span = 0;
            int group = 0;
            e(adapterPosition);
            for (int i = 0; i < adapterPosition; i++) {
                e(i);
                span++;
                if (span == spanCount) {
                    span = 0;
                    group++;
                } else if (span > spanCount) {
                    span = 1;
                    group++;
                }
            }
            int i2 = span + 1;
            if (i2 > spanCount) {
                return group + 1;
            }
            return group;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public View J0(View focused, int focusDirection, RecyclerView.u recycler, RecyclerView.z state) {
        int start;
        int inc;
        int limit;
        View prevFocusedChild;
        int focusableSpanGroupIndex;
        int focusableWeakCandidateSpanIndex;
        int overlap;
        GridLayoutManager gridLayoutManager = this;
        RecyclerView.u uVar = recycler;
        RecyclerView.z zVar = state;
        View prevFocusedChild2 = B(focused);
        if (prevFocusedChild2 == null) {
            return null;
        }
        b lp = (b) prevFocusedChild2.getLayoutParams();
        int prevSpanStart = lp.e;
        int prevSpanEnd = lp.e + lp.f;
        View view = super.J0(focused, focusDirection, recycler, state);
        if (view == null) {
            return null;
        }
        int layoutDir = gridLayoutManager.R1(focusDirection);
        boolean ascend = (layoutDir == 1) != gridLayoutManager.x;
        if (ascend) {
            start = J() - 1;
            inc = -1;
            limit = -1;
        } else {
            start = 0;
            inc = 1;
            limit = J();
        }
        boolean preferLastSpan = gridLayoutManager.s == 1 && q2();
        View focusableWeakCandidate = null;
        View unfocusableWeakCandidate = null;
        int focusableSpanGroupIndex2 = gridLayoutManager.U2(uVar, zVar, start);
        int focusableWeakCandidateSpanIndex2 = -1;
        int focusableWeakCandidateOverlap = 0;
        int unfocusableWeakCandidateSpanIndex = -1;
        int layoutDir2 = 0;
        int i = start;
        while (i != limit) {
            int start2 = start;
            int spanGroupIndex = gridLayoutManager.U2(uVar, zVar, i);
            View candidate = gridLayoutManager.I(i);
            if (candidate == prevFocusedChild2) {
                break;
            }
            if (candidate.hasFocusable() && spanGroupIndex != focusableSpanGroupIndex2) {
                if (focusableWeakCandidate != null) {
                    break;
                }
                prevFocusedChild = prevFocusedChild2;
                focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex2;
                focusableSpanGroupIndex = focusableSpanGroupIndex2;
            } else {
                b candidateLp = (b) candidate.getLayoutParams();
                prevFocusedChild = prevFocusedChild2;
                int candidateStart = candidateLp.e;
                focusableSpanGroupIndex = focusableSpanGroupIndex2;
                int focusableSpanGroupIndex3 = candidateLp.e;
                int spanGroupIndex2 = candidateLp.f;
                int candidateEnd = focusableSpanGroupIndex3 + spanGroupIndex2;
                if (candidate.hasFocusable() && candidateStart == prevSpanStart && candidateEnd == prevSpanEnd) {
                    return candidate;
                }
                if ((candidate.hasFocusable() && focusableWeakCandidate == null) || (!candidate.hasFocusable() && unfocusableWeakCandidate == null)) {
                    overlap = 1;
                    focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex2;
                } else {
                    int maxStart = Math.max(candidateStart, prevSpanStart);
                    int minEnd = Math.min(candidateEnd, prevSpanEnd);
                    int overlap2 = minEnd - maxStart;
                    if (candidate.hasFocusable()) {
                        if (overlap2 > focusableWeakCandidateOverlap) {
                            focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex2;
                            overlap = 1;
                        } else {
                            if (overlap2 == focusableWeakCandidateOverlap) {
                                focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex2;
                                if (preferLastSpan == (candidateStart > focusableWeakCandidateSpanIndex2)) {
                                    overlap = 1;
                                }
                            } else {
                                focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex2;
                            }
                            overlap = 0;
                        }
                    } else {
                        focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex2;
                        if (focusableWeakCandidate == null) {
                            if (gridLayoutManager.y0(candidate, false)) {
                                if (overlap2 > layoutDir2) {
                                    overlap = 1;
                                } else if (overlap2 == layoutDir2) {
                                    if (preferLastSpan == (candidateStart > unfocusableWeakCandidateSpanIndex)) {
                                        overlap = 1;
                                    }
                                }
                            }
                        }
                        overlap = 0;
                    }
                }
                if (overlap != 0) {
                    if (candidate.hasFocusable()) {
                        int focusableWeakCandidateSpanIndex3 = candidateLp.e;
                        focusableWeakCandidateOverlap = Math.min(candidateEnd, prevSpanEnd) - Math.max(candidateStart, prevSpanStart);
                        focusableWeakCandidate = candidate;
                        focusableWeakCandidateSpanIndex2 = focusableWeakCandidateSpanIndex3;
                    } else {
                        int unfocusableWeakCandidateSpanIndex2 = candidateLp.e;
                        int unfocusableWeakCandidateSpanIndex3 = Math.min(candidateEnd, prevSpanEnd);
                        unfocusableWeakCandidate = candidate;
                        layoutDir2 = unfocusableWeakCandidateSpanIndex3 - Math.max(candidateStart, prevSpanStart);
                        unfocusableWeakCandidateSpanIndex = unfocusableWeakCandidateSpanIndex2;
                        focusableWeakCandidateSpanIndex2 = focusableWeakCandidateSpanIndex;
                    }
                    i += inc;
                    gridLayoutManager = this;
                    uVar = recycler;
                    zVar = state;
                    start = start2;
                    prevFocusedChild2 = prevFocusedChild;
                    focusableSpanGroupIndex2 = focusableSpanGroupIndex;
                }
            }
            focusableWeakCandidateSpanIndex2 = focusableWeakCandidateSpanIndex;
            i += inc;
            gridLayoutManager = this;
            uVar = recycler;
            zVar = state;
            start = start2;
            prevFocusedChild2 = prevFocusedChild;
            focusableSpanGroupIndex2 = focusableSpanGroupIndex;
        }
        return focusableWeakCandidate != null ? focusableWeakCandidate : unfocusableWeakCandidate;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.C == null && !this.H;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z state) {
        return super.s(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z state) {
        return super.v(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z state) {
        return super.r(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z state) {
        return super.u(state);
    }

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int position) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int d(int position, int spanCount) {
            return position % spanCount;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.p {
        public int e;
        public int f;

        public b(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.e = -1;
            this.f = 0;
        }

        public b(int width, int height) {
            super(width, height);
            this.e = -1;
            this.f = 0;
        }

        public b(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.e = -1;
            this.f = 0;
        }

        public b(ViewGroup.LayoutParams source) {
            super(source);
            this.e = -1;
            this.f = 0;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }
    }
}
