package androidx.appcompat.widget;

import a.b.a;
import a.h.k.v;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f809b;
    public int c;
    public int d;

    public ButtonBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.c = -1;
        this.d = 0;
        int[] iArr = a.k;
        TypedArray ta = context.obtainStyledAttributes(attrs, iArr);
        v.m0(this, context, iArr, attrs, ta, 0, 0);
        int[] iArr2 = a.f11a;
        this.f809b = ta.getBoolean(0, true);
        ta.recycle();
    }

    public void setAllowStacking(boolean allowStacking) {
        if (this.f809b != allowStacking) {
            this.f809b = allowStacking;
            if (!allowStacking && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int initialWidthMeasureSpec;
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        if (this.f809b) {
            if (widthSize > this.c && b()) {
                setStacked(false);
            }
            this.c = widthSize;
        }
        boolean needsRemeasure = false;
        if (!b() && View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824) {
            initialWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(widthSize, Integer.MIN_VALUE);
            needsRemeasure = true;
        } else {
            initialWidthMeasureSpec = widthMeasureSpec;
        }
        super.onMeasure(initialWidthMeasureSpec, heightMeasureSpec);
        if (this.f809b && !b()) {
            int measuredWidth = getMeasuredWidthAndState();
            int measuredWidthState = (-16777216) & measuredWidth;
            boolean stack = measuredWidthState == 16777216;
            if (stack) {
                setStacked(true);
                needsRemeasure = true;
            }
        }
        if (needsRemeasure) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
        int minHeight = 0;
        int firstVisible = a(0);
        if (firstVisible >= 0) {
            View firstButton = getChildAt(firstVisible);
            LinearLayout.LayoutParams firstParams = (LinearLayout.LayoutParams) firstButton.getLayoutParams();
            minHeight = 0 + getPaddingTop() + firstButton.getMeasuredHeight() + firstParams.topMargin + firstParams.bottomMargin;
            if (b()) {
                int secondVisible = a(firstVisible + 1);
                if (secondVisible >= 0) {
                    minHeight += getChildAt(secondVisible).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
            } else {
                minHeight += getPaddingBottom();
            }
        }
        if (v.D(this) != minHeight) {
            setMinimumHeight(minHeight);
        }
    }

    public final int a(int index) {
        int count = getChildCount();
        for (int i = index; i < count; i++) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(0, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 8388613 : 80);
        View findViewById = findViewById(R.id.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    public final boolean b() {
        return getOrientation() == 1;
    }
}
