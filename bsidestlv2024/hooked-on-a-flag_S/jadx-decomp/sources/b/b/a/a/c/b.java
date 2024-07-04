package b.b.a.a.c;

import a.h.k.d0;
import a.h.k.v;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b extends c<View> {
    public final Rect d;
    public final Rect e;
    public int f;
    public int g;

    public abstract View H(List<View> list);

    public abstract float J(View view);

    public b() {
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }

    public b(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout parent, View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        d0 parentInsets;
        int childLpHeight = child.getLayoutParams().height;
        if (childLpHeight == -1 || childLpHeight == -2) {
            List<View> dependencies = parent.r(child);
            View header = H(dependencies);
            if (header != null) {
                int availableHeight = View.MeasureSpec.getSize(parentHeightMeasureSpec);
                if (availableHeight > 0) {
                    if (v.z(header) && (parentInsets = parent.getLastWindowInsets()) != null) {
                        availableHeight += parentInsets.i() + parentInsets.f();
                    }
                } else {
                    availableHeight = parent.getHeight();
                }
                int height = L(header) + availableHeight;
                int headerHeight = header.getMeasuredHeight();
                P();
                int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height - headerHeight, childLpHeight == -1 ? 1073741824 : Integer.MIN_VALUE);
                parent.J(child, parentWidthMeasureSpec, widthUsed, heightMeasureSpec, heightUsed);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // b.b.a.a.c.c
    public void F(CoordinatorLayout parent, View child, int layoutDirection) {
        List<View> dependencies = parent.r(child);
        View header = H(dependencies);
        if (header != null) {
            CoordinatorLayout.f lp = (CoordinatorLayout.f) child.getLayoutParams();
            Rect available = this.d;
            available.set(parent.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) lp).leftMargin, header.getBottom() + ((ViewGroup.MarginLayoutParams) lp).topMargin, (parent.getWidth() - parent.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) lp).rightMargin, ((parent.getHeight() + header.getBottom()) - parent.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) lp).bottomMargin);
            d0 parentInsets = parent.getLastWindowInsets();
            if (parentInsets != null && v.z(parent) && !v.z(child)) {
                available.left += parentInsets.g();
                available.right -= parentInsets.h();
            }
            Rect out = this.e;
            a.h.k.e.a(N(lp.c), child.getMeasuredWidth(), child.getMeasuredHeight(), available, out, layoutDirection);
            int overlap = I(header);
            child.layout(out.left, out.top - overlap, out.right, out.bottom - overlap);
            this.f = out.top - header.getBottom();
            return;
        }
        super.F(parent, child, layoutDirection);
        this.f = 0;
    }

    public boolean P() {
        return false;
    }

    public final int I(View header) {
        if (this.g == 0) {
            return 0;
        }
        float J = J(header);
        int i = this.g;
        return a.h.f.a.b((int) (J * i), 0, i);
    }

    public static int N(int gravity) {
        if (gravity == 0) {
            return 8388659;
        }
        return gravity;
    }

    public int L(View v) {
        return v.getMeasuredHeight();
    }

    public final int M() {
        return this.f;
    }

    public final void O(int overlayTop) {
        this.g = overlayTop;
    }

    public final int K() {
        return this.g;
    }
}
