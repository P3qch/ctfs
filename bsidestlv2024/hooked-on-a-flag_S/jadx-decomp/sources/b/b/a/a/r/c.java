package b.b.a.a.r;

import a.h.k.v;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class c extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public int f1064b;
    public int c;
    public boolean d;
    public int e;

    public c(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public c(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.d = false;
        d(context, attrs);
    }

    public final void d(Context context, AttributeSet attrs) {
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, b.b.a.a.a.i, 0, 0);
        int[] iArr = b.b.a.a.a.f942a;
        this.f1064b = array.getDimensionPixelSize(1, 0);
        this.c = array.getDimensionPixelSize(0, 0);
        array.recycle();
    }

    public int getLineSpacing() {
        return this.f1064b;
    }

    public void setLineSpacing(int lineSpacing) {
        this.f1064b = lineSpacing;
    }

    public int getItemSpacing() {
        return this.c;
    }

    public void setItemSpacing(int itemSpacing) {
        this.c = itemSpacing;
    }

    public boolean c() {
        return this.d;
    }

    public void setSingleLine(boolean singleLine) {
        this.d = singleLine;
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int maxWidth;
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int maxWidth2 = (widthMode == Integer.MIN_VALUE || widthMode == 1073741824) ? width : Integer.MAX_VALUE;
        int childLeft = getPaddingLeft();
        int childTop = getPaddingTop();
        int childBottom = childTop;
        int maxChildRight = 0;
        int maxRight = maxWidth2 - getPaddingRight();
        int i = 0;
        while (i < getChildCount()) {
            View child = getChildAt(i);
            if (child.getVisibility() == 8) {
                maxWidth = maxWidth2;
            } else {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
                maxWidth = maxWidth2;
                ViewGroup.LayoutParams lp = child.getLayoutParams();
                int leftMargin = 0;
                int rightMargin = 0;
                int childTop2 = childTop;
                if (lp instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLp = (ViewGroup.MarginLayoutParams) lp;
                    leftMargin = 0 + marginLp.leftMargin;
                    rightMargin = 0 + marginLp.rightMargin;
                }
                if (childLeft + leftMargin + child.getMeasuredWidth() > maxRight && !c()) {
                    childLeft = getPaddingLeft();
                    childTop = this.f1064b + childBottom;
                } else {
                    childTop = childTop2;
                }
                int childRight = childLeft + leftMargin + child.getMeasuredWidth();
                int childBottom2 = child.getMeasuredHeight() + childTop;
                if (childRight > maxChildRight) {
                    maxChildRight = childRight;
                }
                int measuredWidth = leftMargin + rightMargin + child.getMeasuredWidth();
                int childBottom3 = this.c;
                childLeft += measuredWidth + childBottom3;
                if (i != getChildCount() - 1) {
                    childBottom = childBottom2;
                } else {
                    maxChildRight += rightMargin;
                    childBottom = childBottom2;
                }
            }
            i++;
            maxWidth2 = maxWidth;
        }
        int maxChildRight2 = maxChildRight + getPaddingRight();
        int childBottom4 = childBottom + getPaddingBottom();
        int finalWidth = a(width, widthMode, maxChildRight2);
        int finalHeight = a(height, heightMode, childBottom4);
        setMeasuredDimension(finalWidth, finalHeight);
    }

    public static int a(int size, int mode, int childrenEdge) {
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(childrenEdge, size);
            case 1073741824:
                return size;
            default:
                return childrenEdge;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean sizeChanged, int left, int top, int right, int bottom) {
        if (getChildCount() == 0) {
            this.e = 0;
            return;
        }
        int i = 1;
        this.e = 1;
        boolean isRtl = v.C(this) == 1;
        int paddingStart = isRtl ? getPaddingRight() : getPaddingLeft();
        int paddingEnd = isRtl ? getPaddingLeft() : getPaddingRight();
        int childStart = paddingStart;
        int childTop = getPaddingTop();
        int childBottom = childTop;
        int maxChildEnd = (right - left) - paddingEnd;
        int i2 = 0;
        while (i2 < getChildCount()) {
            View child = getChildAt(i2);
            if (child.getVisibility() == 8) {
                child.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams lp = child.getLayoutParams();
                int startMargin = 0;
                int endMargin = 0;
                if (lp instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLp = (ViewGroup.MarginLayoutParams) lp;
                    startMargin = a.h.k.h.b(marginLp);
                    endMargin = a.h.k.h.a(marginLp);
                }
                int childEnd = childStart + startMargin + child.getMeasuredWidth();
                if (!this.d && childEnd > maxChildEnd) {
                    childStart = paddingStart;
                    childTop = childBottom + this.f1064b;
                    this.e += i;
                }
                child.setTag(R.id.row_index_key, Integer.valueOf(this.e - i));
                int childEnd2 = childStart + startMargin + child.getMeasuredWidth();
                int childBottom2 = child.getMeasuredHeight() + childTop;
                if (isRtl) {
                    child.layout(maxChildEnd - childEnd2, childTop, (maxChildEnd - childStart) - startMargin, childBottom2);
                } else {
                    child.layout(childStart + startMargin, childTop, childEnd2, childBottom2);
                }
                childStart += startMargin + endMargin + child.getMeasuredWidth() + this.c;
                childBottom = childBottom2;
            }
            i2++;
            i = 1;
        }
    }

    public int getRowCount() {
        return this.e;
    }

    public int b(View child) {
        Object index = child.getTag(R.id.row_index_key);
        if (!(index instanceof Integer)) {
            return -1;
        }
        return ((Integer) index).intValue();
    }
}
