package com.google.android.material.snackbar;

import a.h.k.v;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.a.a.a;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public TextView f1192b;
    public Button c;
    public int d;
    public int e;

    public SnackbarContentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a2 = context.obtainStyledAttributes(attrs, a.y);
        int[] iArr = a.f942a;
        this.d = a2.getDimensionPixelSize(0, -1);
        this.e = a2.getDimensionPixelSize(7, -1);
        a2.recycle();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1192b = (TextView) findViewById(R.id.snackbar_text);
        this.c = (Button) findViewById(R.id.snackbar_action);
    }

    public TextView getMessageView() {
        return this.f1192b;
    }

    public Button getActionView() {
        return this.c;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.d > 0) {
            int measuredWidth = getMeasuredWidth();
            int i = this.d;
            if (measuredWidth > i) {
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
        int multiLineVPadding = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int singleLineVPadding = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        boolean isMultiLine = this.f1192b.getLayout().getLineCount() > 1;
        boolean remeasure = false;
        if (isMultiLine && this.e > 0 && this.c.getMeasuredWidth() > this.e) {
            if (b(1, multiLineVPadding, multiLineVPadding - singleLineVPadding)) {
                remeasure = true;
            }
        } else {
            int messagePadding = isMultiLine ? multiLineVPadding : singleLineVPadding;
            if (b(0, messagePadding, messagePadding)) {
                remeasure = true;
            }
        }
        if (remeasure) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final boolean b(int orientation, int messagePadTop, int messagePadBottom) {
        boolean changed = false;
        if (orientation != getOrientation()) {
            setOrientation(orientation);
            changed = true;
        }
        if (this.f1192b.getPaddingTop() != messagePadTop || this.f1192b.getPaddingBottom() != messagePadBottom) {
            a(this.f1192b, messagePadTop, messagePadBottom);
            return true;
        }
        return changed;
    }

    public static void a(View view, int topPadding, int bottomPadding) {
        if (v.V(view)) {
            v.A0(view, v.I(view), topPadding, v.H(view), bottomPadding);
        } else {
            view.setPadding(view.getPaddingLeft(), topPadding, view.getPaddingRight(), bottomPadding);
        }
    }

    public void setMaxInlineActionWidth(int width) {
        this.e = width;
    }
}
