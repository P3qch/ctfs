package com.google.android.material.textview;

import a.b.g.a0;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.b.a.a.b0.a.a;
import b.b.a.a.u.b;
import b.b.a.a.u.c;

/* loaded from: classes.dex */
public class MaterialTextView extends a0 {
    public MaterialTextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MaterialTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(a.c(context, attrs, defStyleAttr, defStyleRes), attrs, defStyleAttr);
        int resId;
        Context context2 = getContext();
        if (g(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (!j(context2, theme, attrs, defStyleAttr, defStyleRes) && (resId = h(theme, attrs, defStyleAttr, defStyleRes)) != -1) {
                f(theme, resId);
            }
        }
    }

    @Override // a.b.g.a0, android.widget.TextView
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        if (g(context)) {
            f(context.getTheme(), resId);
        }
    }

    public final void f(Resources.Theme theme, int resId) {
        TypedArray attributes = theme.obtainStyledAttributes(resId, b.b.a.a.a.s);
        int[] iArr = b.b.a.a.a.f942a;
        int lineHeight = i(getContext(), attributes, 1, 2);
        attributes.recycle();
        if (lineHeight >= 0) {
            setLineHeight(lineHeight);
        }
    }

    public static boolean g(Context context) {
        return b.b(context, net.sqlcipher.R.attr.textAppearanceLineHeightEnabled, true);
    }

    public static int i(Context context, TypedArray attributes, int... indices) {
        int lineHeight = -1;
        for (int index = 0; index < indices.length && lineHeight < 0; index++) {
            lineHeight = c.c(context, attributes, indices[index], -1);
        }
        return lineHeight;
    }

    public static boolean j(Context context, Resources.Theme theme, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray attributes = theme.obtainStyledAttributes(attrs, b.b.a.a.a.t, defStyleAttr, defStyleRes);
        int[] iArr = b.b.a.a.a.f942a;
        int lineHeight = i(context, attributes, 1, 2);
        attributes.recycle();
        return lineHeight != -1;
    }

    public static int h(Resources.Theme theme, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray attributes = theme.obtainStyledAttributes(attrs, b.b.a.a.a.t, defStyleAttr, defStyleRes);
        int[] iArr = b.b.a.a.a.f942a;
        int appearanceAttrId = attributes.getResourceId(0, -1);
        attributes.recycle();
        return appearanceAttrId;
    }
}
