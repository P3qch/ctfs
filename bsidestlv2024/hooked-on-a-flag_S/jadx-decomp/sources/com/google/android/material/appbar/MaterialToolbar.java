package com.google.android.material.appbar;

import a.h.k.v;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import b.b.a.a.b0.a.a;
import b.b.a.a.r.j;
import b.b.a.a.r.k;
import b.b.a.a.x.g;
import b.b.a.a.x.h;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final int O = R.style.Widget_MaterialComponents_Toolbar;
    public Integer P;
    public boolean Q;
    public boolean R;

    public MaterialToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.toolbarStyle);
    }

    public MaterialToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(a.c(context, attrs, defStyleAttr, R.style.Widget_MaterialComponents_Toolbar), attrs, defStyleAttr);
        Context context2 = getContext();
        TypedArray a2 = j.h(context2, attrs, b.b.a.a.a.u, defStyleAttr, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        int[] iArr = b.b.a.a.a.f942a;
        if (a2.hasValue(0)) {
            setNavigationIconTint(a2.getColor(0, -1));
        }
        this.Q = a2.getBoolean(2, false);
        this.R = a2.getBoolean(1, false);
        a2.recycle();
        P(context2);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        R();
    }

    public final void R() {
        if (!this.Q && !this.R) {
            return;
        }
        TextView titleTextView = k.c(this);
        TextView subtitleTextView = k.a(this);
        if (titleTextView == null && subtitleTextView == null) {
            return;
        }
        Pair<Integer, Integer> titleBoundLimits = O(titleTextView, subtitleTextView);
        if (this.Q && titleTextView != null) {
            Q(titleTextView, titleBoundLimits);
        }
        if (this.R && subtitleTextView != null) {
            Q(subtitleTextView, titleBoundLimits);
        }
    }

    public final Pair<Integer, Integer> O(TextView titleTextView, TextView subtitleTextView) {
        int width = getMeasuredWidth();
        int midpoint = width / 2;
        int leftLimit = getPaddingLeft();
        int rightLimit = width - getPaddingRight();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8 && child != titleTextView && child != subtitleTextView) {
                if (child.getRight() < midpoint && child.getRight() > leftLimit) {
                    leftLimit = child.getRight();
                }
                if (child.getLeft() > midpoint && child.getLeft() < rightLimit) {
                    rightLimit = child.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(leftLimit), Integer.valueOf(rightLimit));
    }

    public final void Q(View titleView, Pair<Integer, Integer> titleBoundLimits) {
        int width = getMeasuredWidth();
        int titleWidth = titleView.getMeasuredWidth();
        int titleLeft = (width / 2) - (titleWidth / 2);
        int titleRight = titleLeft + titleWidth;
        int leftOverlap = Math.max(((Integer) titleBoundLimits.first).intValue() - titleLeft, 0);
        int rightOverlap = Math.max(titleRight - ((Integer) titleBoundLimits.second).intValue(), 0);
        int overlap = Math.max(leftOverlap, rightOverlap);
        if (overlap > 0) {
            titleLeft += overlap;
            titleRight -= overlap;
            titleView.measure(View.MeasureSpec.makeMeasureSpec(titleRight - titleLeft, 1073741824), titleView.getMeasuredHeightAndState());
        }
        titleView.layout(titleLeft, titleView.getTop(), titleRight, titleView.getBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        h.d(this, elevation);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(S(drawable));
    }

    public void setNavigationIconTint(int navigationIconTint) {
        this.P = Integer.valueOf(navigationIconTint);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setTitleCentered(boolean titleCentered) {
        if (this.Q != titleCentered) {
            this.Q = titleCentered;
            requestLayout();
        }
    }

    public void setSubtitleCentered(boolean subtitleCentered) {
        if (this.R != subtitleCentered) {
            this.R = subtitleCentered;
            requestLayout();
        }
    }

    public final void P(Context context) {
        Drawable background = getBackground();
        if (background != null && !(background instanceof ColorDrawable)) {
            return;
        }
        g materialShapeDrawable = new g();
        int backgroundColor = background != null ? ((ColorDrawable) background).getColor() : 0;
        materialShapeDrawable.V(ColorStateList.valueOf(backgroundColor));
        materialShapeDrawable.L(context);
        materialShapeDrawable.U(v.w(this));
        v.r0(this, materialShapeDrawable);
    }

    public final Drawable S(Drawable navigationIcon) {
        if (navigationIcon != null && this.P != null) {
            Drawable wrappedNavigationIcon = a.h.d.l.a.r(navigationIcon);
            a.h.d.l.a.n(wrappedNavigationIcon, this.P.intValue());
            return wrappedNavigationIcon;
        }
        return navigationIcon;
    }
}
