package androidx.appcompat.widget;

import a.b.g.j0;
import a.h.k.e;
import a.h.k.v;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import net.sqlcipher.R;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class AlertDialogLayout extends j0 {
    public AlertDialogLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // a.b.g.j0, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!C(widthMeasureSpec, heightMeasureSpec)) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final boolean C(int widthMeasureSpec, int heightMeasureSpec) {
        int childHeightSpec;
        View topPanel = null;
        View buttonPanel = null;
        View middlePanel = null;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                int id = child.getId();
                if (id == R.id.topPanel) {
                    topPanel = child;
                } else if (id == R.id.buttonPanel) {
                    buttonPanel = child;
                } else {
                    if ((id != R.id.contentPanel && id != R.id.customPanel) || middlePanel != null) {
                        return false;
                    }
                    middlePanel = child;
                }
            }
        }
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int childState = 0;
        int usedHeight = getPaddingTop() + getPaddingBottom();
        if (topPanel != null) {
            topPanel.measure(widthMeasureSpec, 0);
            usedHeight += topPanel.getMeasuredHeight();
            childState = View.combineMeasuredStates(0, topPanel.getMeasuredState());
        }
        int buttonHeight = 0;
        int buttonWantsHeight = 0;
        if (buttonPanel != null) {
            buttonPanel.measure(widthMeasureSpec, 0);
            buttonHeight = B(buttonPanel);
            buttonWantsHeight = buttonPanel.getMeasuredHeight() - buttonHeight;
            usedHeight += buttonHeight;
            childState = View.combineMeasuredStates(childState, buttonPanel.getMeasuredState());
        }
        int middleHeight = 0;
        if (middlePanel != null) {
            if (heightMode == 0) {
                childHeightSpec = 0;
            } else {
                childHeightSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, heightSize - usedHeight), heightMode);
            }
            middlePanel.measure(widthMeasureSpec, childHeightSpec);
            middleHeight = middlePanel.getMeasuredHeight();
            usedHeight += middleHeight;
            childState = View.combineMeasuredStates(childState, middlePanel.getMeasuredState());
        }
        int remainingHeight = heightSize - usedHeight;
        if (buttonPanel != null) {
            int usedHeight2 = usedHeight - buttonHeight;
            int heightToGive = Math.min(remainingHeight, buttonWantsHeight);
            if (heightToGive > 0) {
                remainingHeight -= heightToGive;
                buttonHeight += heightToGive;
            }
            int remainingHeight2 = remainingHeight;
            int childHeightSpec2 = View.MeasureSpec.makeMeasureSpec(buttonHeight, 1073741824);
            buttonPanel.measure(widthMeasureSpec, childHeightSpec2);
            usedHeight = usedHeight2 + buttonPanel.getMeasuredHeight();
            childState = View.combineMeasuredStates(childState, buttonPanel.getMeasuredState());
            remainingHeight = remainingHeight2;
        }
        if (middlePanel != null && remainingHeight > 0) {
            int heightToGive2 = remainingHeight;
            int remainingHeight3 = remainingHeight - heightToGive2;
            int childHeightSpec3 = View.MeasureSpec.makeMeasureSpec(middleHeight + heightToGive2, heightMode);
            middlePanel.measure(widthMeasureSpec, childHeightSpec3);
            usedHeight = (usedHeight - middleHeight) + middlePanel.getMeasuredHeight();
            int childHeightSpec4 = middlePanel.getMeasuredState();
            childState = View.combineMeasuredStates(childState, childHeightSpec4);
            remainingHeight = remainingHeight3;
        }
        int maxWidth = 0;
        int remainingHeight4 = 0;
        while (remainingHeight4 < count) {
            View child2 = getChildAt(remainingHeight4);
            View buttonPanel2 = buttonPanel;
            View middlePanel2 = middlePanel;
            if (child2.getVisibility() != 8) {
                maxWidth = Math.max(maxWidth, child2.getMeasuredWidth());
            }
            remainingHeight4++;
            buttonPanel = buttonPanel2;
            middlePanel = middlePanel2;
        }
        int i2 = getPaddingLeft();
        int widthSizeAndState = View.resolveSizeAndState(maxWidth + i2 + getPaddingRight(), widthMeasureSpec, childState);
        int heightSizeAndState = View.resolveSizeAndState(usedHeight, heightMeasureSpec, 0);
        setMeasuredDimension(widthSizeAndState, heightSizeAndState);
        if (widthMode != 1073741824) {
            l(count, heightMeasureSpec);
            return true;
        }
        return true;
    }

    private void l(int count, int heightMeasureSpec) {
        int uniformMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                j0.a lp = (j0.a) child.getLayoutParams();
                if (((LinearLayout.LayoutParams) lp).width == -1) {
                    int oldHeight = ((LinearLayout.LayoutParams) lp).height;
                    ((LinearLayout.LayoutParams) lp).height = child.getMeasuredHeight();
                    measureChildWithMargins(child, uniformMeasureSpec, 0, heightMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) lp).height = oldHeight;
                }
            }
        }
    }

    public static int B(View v) {
        int minHeight = v.D(v);
        if (minHeight > 0) {
            return minHeight;
        }
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            if (vg.getChildCount() == 1) {
                return B(vg.getChildAt(0));
            }
        }
        return 0;
    }

    @Override // a.b.g.j0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int childTop;
        int i;
        int layoutGravity;
        int childLeft;
        AlertDialogLayout alertDialogLayout = this;
        int paddingLeft = getPaddingLeft();
        int width = right - left;
        int childRight = width - getPaddingRight();
        int childSpace = (width - paddingLeft) - getPaddingRight();
        int totalLength = getMeasuredHeight();
        int count = getChildCount();
        int gravity = getGravity();
        int majorGravity = gravity & 112;
        int minorGravity = gravity & 8388615;
        switch (majorGravity) {
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                int childTop2 = getPaddingTop();
                childTop = childTop2 + (((bottom - top) - totalLength) / 2);
                break;
            case 80:
                int childTop3 = getPaddingTop();
                childTop = ((childTop3 + bottom) - top) - totalLength;
                break;
            default:
                childTop = getPaddingTop();
                break;
        }
        Drawable dividerDrawable = getDividerDrawable();
        int dividerHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        int i2 = 0;
        while (i2 < count) {
            View child = alertDialogLayout.getChildAt(i2);
            if (child == null || child.getVisibility() == 8) {
                i = i2;
            } else {
                int childWidth = child.getMeasuredWidth();
                int childHeight = child.getMeasuredHeight();
                j0.a lp = (j0.a) child.getLayoutParams();
                int layoutGravity2 = ((LinearLayout.LayoutParams) lp).gravity;
                if (layoutGravity2 >= 0) {
                    layoutGravity = layoutGravity2;
                } else {
                    layoutGravity = minorGravity;
                }
                int layoutDirection = v.C(this);
                int absoluteGravity = e.b(layoutGravity, layoutDirection);
                switch (absoluteGravity & 7) {
                    case 1:
                        int childLeft2 = ((((childSpace - childWidth) / 2) + paddingLeft) + ((LinearLayout.LayoutParams) lp).leftMargin) - ((LinearLayout.LayoutParams) lp).rightMargin;
                        childLeft = childLeft2;
                        break;
                    case 5:
                        int childLeft3 = childRight - childWidth;
                        int layoutDirection2 = ((LinearLayout.LayoutParams) lp).rightMargin;
                        childLeft = childLeft3 - layoutDirection2;
                        break;
                    default:
                        childLeft = ((LinearLayout.LayoutParams) lp).leftMargin + paddingLeft;
                        break;
                }
                if (alertDialogLayout.t(i2)) {
                    childTop += dividerHeight;
                }
                int childTop4 = childTop + ((LinearLayout.LayoutParams) lp).topMargin;
                i = i2;
                A(child, childLeft, childTop4, childWidth, childHeight);
                childTop = childTop4 + childHeight + ((LinearLayout.LayoutParams) lp).bottomMargin;
            }
            i2 = i + 1;
            alertDialogLayout = this;
        }
    }

    private void A(View child, int left, int top, int width, int height) {
        child.layout(left, top, left + width, top + height);
    }
}
