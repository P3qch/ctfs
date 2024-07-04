package com.google.android.material.textfield;

import a.b.g.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import b.b.a.a.b0.a.a;
import b.b.a.a.r.e;
import b.b.a.a.r.j;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class TextInputEditText extends k {
    public final Rect f;
    public boolean g;

    public TextInputEditText(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.editTextStyle);
    }

    public TextInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(a.c(context, attrs, defStyleAttr, 0), attrs, defStyleAttr);
        this.f = new Rect();
        TypedArray attributes = j.h(context, attrs, b.b.a.a.a.A, defStyleAttr, R.style.Widget_Design_TextInputEditText, new int[0]);
        int[] iArr = b.b.a.a.a.f942a;
        setTextInputLayoutFocusedRectEnabled(attributes.getBoolean(0, false));
        attributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout layout = getTextInputLayout();
        if (layout != null && layout.O() && super.getHint() == null && e.a()) {
            setHint(BuildConfig.FLAVOR);
        }
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout layout = getTextInputLayout();
        if (layout != null && layout.O()) {
            return layout.getHint();
        }
        return super.getHint();
    }

    @Override // a.b.g.k, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection ic = super.onCreateInputConnection(outAttrs);
        if (ic != null && outAttrs.hintText == null) {
            outAttrs.hintText = getHintFromLayout();
        }
        return ic;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout layout = getTextInputLayout();
        if (layout != null) {
            return layout.getHint();
        }
        return null;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean textInputLayoutFocusedRectEnabled) {
        this.g = textInputLayoutFocusedRectEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect r) {
        super.getFocusedRect(r);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.g && r != null) {
            textInputLayout.getFocusedRect(this.f);
            r.bottom = this.f.bottom;
        }
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(Rect r, Point globalOffset) {
        boolean result = super.getGlobalVisibleRect(r, globalOffset);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.g && r != null) {
            textInputLayout.getGlobalVisibleRect(this.f, globalOffset);
            r.bottom = this.f.bottom;
        }
        return result;
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect rectangle) {
        boolean result = super.requestRectangleOnScreen(rectangle);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.g) {
            this.f.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.f, true);
        }
        return result;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        TextInputLayout layout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && layout != null) {
            info.setText(b(layout));
        }
    }

    public final String b(TextInputLayout layout) {
        CharSequence inputText = getText();
        CharSequence hintText = layout.getHint();
        boolean showingText = !TextUtils.isEmpty(inputText);
        boolean hasHint = !TextUtils.isEmpty(hintText);
        if (Build.VERSION.SDK_INT >= 17) {
            setLabelFor(R.id.textinput_helper_text);
        }
        String str = BuildConfig.FLAVOR;
        String hint = hasHint ? hintText.toString() : BuildConfig.FLAVOR;
        if (showingText) {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) inputText);
            if (!TextUtils.isEmpty(hint)) {
                str = ", " + hint;
            }
            sb.append(str);
            return sb.toString();
        }
        if (TextUtils.isEmpty(hint)) {
            return BuildConfig.FLAVOR;
        }
        return hint;
    }
}
