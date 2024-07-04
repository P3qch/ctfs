package a.b.g;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class j0 extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public boolean f162b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;
    public boolean i;
    public int[] j;
    public int[] k;
    public Drawable l;
    public int m;
    public int n;
    public int o;
    public int p;

    public j0(Context context) {
        this(context, null);
    }

    public j0(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public j0(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f162b = true;
        this.c = -1;
        this.d = 0;
        this.f = 8388659;
        int[] iArr = a.b.a.m;
        x0 a2 = x0.v(context, attrs, iArr, defStyleAttr, 0);
        a.h.k.v.m0(this, context, iArr, attrs, a2.r(), defStyleAttr, 0);
        int[] iArr2 = a.b.a.f11a;
        int index = a2.k(1, -1);
        if (index >= 0) {
            setOrientation(index);
        }
        int index2 = a2.k(0, -1);
        if (index2 >= 0) {
            setGravity(index2);
        }
        boolean baselineAligned = a2.a(2, true);
        if (!baselineAligned) {
            setBaselineAligned(baselineAligned);
        }
        this.h = a2.i(4, -1.0f);
        this.c = a2.k(3, -1);
        this.i = a2.a(7, false);
        setDividerDrawable(a2.g(5));
        this.o = a2.k(8, 0);
        this.p = a2.f(6, 0);
        a2.w();
    }

    public void setShowDividers(int showDividers) {
        if (showDividers != this.o) {
            requestLayout();
        }
        this.o = showDividers;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.o;
    }

    public Drawable getDividerDrawable() {
        return this.l;
    }

    public void setDividerDrawable(Drawable divider) {
        if (divider == this.l) {
            return;
        }
        this.l = divider;
        if (divider != null) {
            this.m = divider.getIntrinsicWidth();
            this.n = divider.getIntrinsicHeight();
        } else {
            this.m = 0;
            this.n = 0;
        }
        setWillNotDraw(divider == null);
        requestLayout();
    }

    public void setDividerPadding(int padding) {
        this.p = padding;
    }

    public int getDividerPadding() {
        return this.p;
    }

    public int getDividerWidth() {
        return this.m;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.l == null) {
            return;
        }
        if (this.e == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    public void h(Canvas canvas) {
        int bottom;
        int count = getVirtualChildCount();
        for (int i = 0; i < count; i++) {
            View child = s(i);
            if (child != null && child.getVisibility() != 8 && t(i)) {
                a lp = (a) child.getLayoutParams();
                int top = (child.getTop() - ((LinearLayout.LayoutParams) lp).topMargin) - this.n;
                i(canvas, top);
            }
        }
        if (t(count)) {
            View child2 = s(count - 1);
            if (child2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.n;
            } else {
                a lp2 = (a) child2.getLayoutParams();
                int bottom2 = child2.getBottom() + ((LinearLayout.LayoutParams) lp2).bottomMargin;
                bottom = bottom2;
            }
            i(canvas, bottom);
        }
    }

    public void g(Canvas canvas) {
        int position;
        int position2;
        int count = getVirtualChildCount();
        boolean isLayoutRtl = e1.b(this);
        for (int i = 0; i < count; i++) {
            View child = s(i);
            if (child != null && child.getVisibility() != 8 && t(i)) {
                a lp = (a) child.getLayoutParams();
                if (isLayoutRtl) {
                    position2 = child.getRight() + ((LinearLayout.LayoutParams) lp).rightMargin;
                } else {
                    int position3 = child.getLeft();
                    position2 = (position3 - ((LinearLayout.LayoutParams) lp).leftMargin) - this.m;
                }
                j(canvas, position2);
            }
        }
        if (t(count)) {
            View child2 = s(count - 1);
            if (child2 == null) {
                if (isLayoutRtl) {
                    position = getPaddingLeft();
                } else {
                    int position4 = getWidth();
                    position = (position4 - getPaddingRight()) - this.m;
                }
            } else {
                a lp2 = (a) child2.getLayoutParams();
                if (isLayoutRtl) {
                    position = (child2.getLeft() - ((LinearLayout.LayoutParams) lp2).leftMargin) - this.m;
                } else {
                    int position5 = child2.getRight();
                    position = position5 + ((LinearLayout.LayoutParams) lp2).rightMargin;
                }
            }
            j(canvas, position);
        }
    }

    public void i(Canvas canvas, int top) {
        this.l.setBounds(getPaddingLeft() + this.p, top, (getWidth() - getPaddingRight()) - this.p, this.n + top);
        this.l.draw(canvas);
    }

    public void j(Canvas canvas, int left) {
        this.l.setBounds(left, getPaddingTop() + this.p, this.m + left, (getHeight() - getPaddingBottom()) - this.p);
        this.l.draw(canvas);
    }

    public void setBaselineAligned(boolean baselineAligned) {
        this.f162b = baselineAligned;
    }

    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        this.i = enabled;
    }

    @Override // android.view.View
    public int getBaseline() {
        int majorGravity;
        if (this.c < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i = this.c;
        if (childCount <= i) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View child = getChildAt(i);
        int childBaseline = child.getBaseline();
        if (childBaseline == -1) {
            if (this.c == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int childTop = this.d;
        if (this.e == 1 && (majorGravity = this.f & 112) != 48) {
            switch (majorGravity) {
                case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                    childTop += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.g) / 2;
                    break;
                case 80:
                    childTop = ((getBottom() - getTop()) - getPaddingBottom()) - this.g;
                    break;
            }
        }
        a lp = (a) child.getLayoutParams();
        return ((LinearLayout.LayoutParams) lp).topMargin + childTop + childBaseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.c;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.c = i;
    }

    public View s(int index) {
        return getChildAt(index);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.h;
    }

    public void setWeightSum(float weightSum) {
        this.h = Math.max(0.0f, weightSum);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.e == 1) {
            z(widthMeasureSpec, heightMeasureSpec);
        } else {
            x(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public boolean t(int childIndex) {
        if (childIndex == 0) {
            return (this.o & 1) != 0;
        }
        if (childIndex == getChildCount()) {
            return (this.o & 4) != 0;
        }
        if ((this.o & 2) == 0) {
            return false;
        }
        for (int i = childIndex - 1; i >= 0; i--) {
            if (getChildAt(i).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z(int r40, int r41) {
        /*
            Method dump skipped, instructions count: 1103
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.j0.z(int, int):void");
    }

    public final void l(int count, int heightMeasureSpec) {
        int uniformMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i = 0; i < count; i++) {
            View child = s(i);
            if (child.getVisibility() != 8) {
                a lp = (a) child.getLayoutParams();
                if (((LinearLayout.LayoutParams) lp).width == -1) {
                    int oldHeight = ((LinearLayout.LayoutParams) lp).height;
                    ((LinearLayout.LayoutParams) lp).height = child.getMeasuredHeight();
                    measureChildWithMargins(child, uniformMeasureSpec, 0, heightMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) lp).height = oldHeight;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x(int r48, int r49) {
        /*
            Method dump skipped, instructions count: 1549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.j0.x(int, int):void");
    }

    public final void k(int count, int widthMeasureSpec) {
        int uniformMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i = 0; i < count; i++) {
            View child = s(i);
            if (child.getVisibility() != 8) {
                a lp = (a) child.getLayoutParams();
                if (((LinearLayout.LayoutParams) lp).height == -1) {
                    int oldWidth = ((LinearLayout.LayoutParams) lp).width;
                    ((LinearLayout.LayoutParams) lp).width = child.getMeasuredWidth();
                    measureChildWithMargins(child, widthMeasureSpec, 0, uniformMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) lp).width = oldWidth;
                }
            }
        }
    }

    public int p() {
        return 0;
    }

    public int y() {
        return 0;
    }

    public void w(View child, int widthMeasureSpec, int totalWidth, int heightMeasureSpec, int totalHeight) {
        measureChildWithMargins(child, widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
    }

    public int q() {
        return 0;
    }

    public int r() {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        if (this.e == 1) {
            v(l, t, r, b2);
        } else {
            u(l, t, r, b2);
        }
    }

    public void v(int left, int top, int right, int bottom) {
        int childTop;
        int gravity;
        int childLeft;
        j0 j0Var = this;
        int paddingLeft = getPaddingLeft();
        int width = right - left;
        int childRight = width - getPaddingRight();
        int childSpace = (width - paddingLeft) - getPaddingRight();
        int count = getVirtualChildCount();
        int i = j0Var.f;
        int majorGravity = i & 112;
        int minorGravity = i & 8388615;
        switch (majorGravity) {
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                int childTop2 = getPaddingTop();
                childTop = childTop2 + (((bottom - top) - j0Var.g) / 2);
                break;
            case 80:
                int childTop3 = getPaddingTop();
                childTop = ((childTop3 + bottom) - top) - j0Var.g;
                break;
            default:
                childTop = getPaddingTop();
                break;
        }
        int i2 = 0;
        while (i2 < count) {
            View child = j0Var.s(i2);
            if (child == null) {
                childTop += y();
            } else if (child.getVisibility() != 8) {
                int childWidth = child.getMeasuredWidth();
                int childHeight = child.getMeasuredHeight();
                a lp = (a) child.getLayoutParams();
                int gravity2 = ((LinearLayout.LayoutParams) lp).gravity;
                if (gravity2 >= 0) {
                    gravity = gravity2;
                } else {
                    gravity = minorGravity;
                }
                int layoutDirection = a.h.k.v.C(this);
                int absoluteGravity = a.h.k.e.b(gravity, layoutDirection);
                switch (absoluteGravity & 7) {
                    case 1:
                        int childLeft2 = childSpace - childWidth;
                        childLeft = (((childLeft2 / 2) + paddingLeft) + ((LinearLayout.LayoutParams) lp).leftMargin) - ((LinearLayout.LayoutParams) lp).rightMargin;
                        break;
                    case 5:
                        int childLeft3 = childRight - childWidth;
                        childLeft = childLeft3 - ((LinearLayout.LayoutParams) lp).rightMargin;
                        break;
                    default:
                        childLeft = ((LinearLayout.LayoutParams) lp).leftMargin + paddingLeft;
                        break;
                }
                if (j0Var.t(i2)) {
                    childTop += j0Var.n;
                }
                int childTop4 = childTop + ((LinearLayout.LayoutParams) lp).topMargin;
                int childTop5 = q();
                A(child, childLeft, childTop4 + childTop5, childWidth, childHeight);
                int childTop6 = childTop4 + childHeight + ((LinearLayout.LayoutParams) lp).bottomMargin + r();
                i2 += p();
                childTop = childTop6;
            }
            i2++;
            j0Var = this;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(int r33, int r34, int r35, int r36) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.j0.u(int, int, int, int):void");
    }

    public final void A(View child, int left, int top, int width, int height) {
        child.layout(left, top, left + width, top + height);
    }

    public void setOrientation(int orientation) {
        if (this.e != orientation) {
            this.e = orientation;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.e;
    }

    public void setGravity(int gravity) {
        if (this.f != gravity) {
            if ((8388615 & gravity) == 0) {
                gravity |= 8388611;
            }
            if ((gravity & 112) == 0) {
                gravity |= 48;
            }
            this.f = gravity;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.f;
    }

    public void setHorizontalGravity(int horizontalGravity) {
        int gravity = horizontalGravity & 8388615;
        int i = this.f;
        if ((8388615 & i) != gravity) {
            this.f = ((-8388616) & i) | gravity;
            requestLayout();
        }
    }

    public void setVerticalGravity(int verticalGravity) {
        int gravity = verticalGravity & 112;
        int i = this.f;
        if ((i & 112) != gravity) {
            this.f = (i & (-113)) | gravity;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attrs) {
        return new a(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i = this.e;
        if (i == 0) {
            return new a(-2, -2);
        }
        if (i == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams p) {
        return new a(p);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof a;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        public a(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public a(int width, int height) {
            super(width, height);
        }

        public a(ViewGroup.LayoutParams p) {
            super(p);
        }
    }
}
