package a.b.g;

import a.h.i.c;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class a0 extends TextView implements a.h.k.u, a.h.l.l, a.h.l.b {

    /* renamed from: b, reason: collision with root package name */
    public final e f128b;
    public final z c;
    public final y d;
    public boolean e;
    public Future<a.h.i.c> f;

    public a0(Context context) {
        this(context, null);
    }

    public a0(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.textViewStyle);
    }

    public a0(Context context, AttributeSet attrs, int defStyleAttr) {
        super(u0.b(context), attrs, defStyleAttr);
        this.e = false;
        s0.a(this, getContext());
        e eVar = new e(this);
        this.f128b = eVar;
        eVar.e(attrs, defStyleAttr);
        z zVar = new z(this);
        this.c = zVar;
        zVar.m(attrs, defStyleAttr);
        zVar.b();
        this.d = new y(this);
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        e eVar = this.f128b;
        if (eVar != null) {
            eVar.g(resId);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        e eVar = this.f128b;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintList(ColorStateList tint) {
        e eVar = this.f128b;
        if (eVar != null) {
            eVar.i(tint);
        }
    }

    @Override // a.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f128b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode tintMode) {
        e eVar = this.f128b;
        if (eVar != null) {
            eVar.j(tintMode);
        }
    }

    @Override // a.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f128b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        z zVar = this.c;
        if (zVar != null) {
            zVar.q(context, resId);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f128b;
        if (eVar != null) {
            eVar.b();
        }
        z zVar = this.c;
        if (zVar != null) {
            zVar.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        z zVar = this.c;
        if (zVar != null) {
            zVar.o();
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int unit, float size) {
        if (a.h.l.b.f495a) {
            super.setTextSize(unit, size);
            return;
        }
        z zVar = this.c;
        if (zVar != null) {
            zVar.A(unit, size);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        z zVar = this.c;
        if (zVar != null && !a.h.l.b.f495a && zVar.l()) {
            this.c.c();
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int autoSizeTextType) {
        if (a.h.l.b.f495a) {
            super.setAutoSizeTextTypeWithDefaults(autoSizeTextType);
            return;
        }
        z zVar = this.c;
        if (zVar != null) {
            zVar.v(autoSizeTextType);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) {
        if (a.h.l.b.f495a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, unit);
            return;
        }
        z zVar = this.c;
        if (zVar != null) {
            zVar.t(autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, unit);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] presetSizes, int unit) {
        if (a.h.l.b.f495a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes, unit);
            return;
        }
        z zVar = this.c;
        if (zVar != null) {
            zVar.u(presetSizes, unit);
        }
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (a.h.l.b.f495a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        z zVar = this.c;
        if (zVar != null) {
            return zVar.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (a.h.l.b.f495a) {
            return super.getAutoSizeStepGranularity();
        }
        z zVar = this.c;
        if (zVar != null) {
            return zVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (a.h.l.b.f495a) {
            return super.getAutoSizeMinTextSize();
        }
        z zVar = this.c;
        if (zVar != null) {
            return zVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (a.h.l.b.f495a) {
            return super.getAutoSizeMaxTextSize();
        }
        z zVar = this.c;
        if (zVar != null) {
            return zVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (a.h.l.b.f495a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        z zVar = this.c;
        if (zVar != null) {
            return zVar.h();
        }
        return new int[0];
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection ic = super.onCreateInputConnection(outAttrs);
        this.c.r(this, ic, outAttrs);
        l.a(ic, outAttrs, this);
        return ic;
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int firstBaselineToTopHeight) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(firstBaselineToTopHeight);
        } else {
            a.h.l.i.j(this, firstBaselineToTopHeight);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int lastBaselineToBottomHeight) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(lastBaselineToBottomHeight);
        } else {
            a.h.l.i.k(this, lastBaselineToBottomHeight);
        }
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return a.h.l.i.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return a.h.l.i.c(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int lineHeight) {
        a.h.l.i.l(this, lineHeight);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        super.setCustomSelectionActionModeCallback(a.h.l.i.p(this, actionModeCallback));
    }

    public c.a getTextMetricsParamsCompat() {
        return a.h.l.i.f(this);
    }

    public void setTextMetricsParamsCompat(c.a params) {
        a.h.l.i.o(this, params);
    }

    public void setPrecomputedText(a.h.i.c precomputed) {
        a.h.l.i.m(this, precomputed);
    }

    public final void d() {
        Future<a.h.i.c> future = this.f;
        if (future != null) {
            try {
                this.f = null;
                a.h.l.i.m(this, future.get());
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        d();
        return super.getText();
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        y yVar;
        if (Build.VERSION.SDK_INT >= 28 || (yVar = this.d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            yVar.b(textClassifier);
        }
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        y yVar;
        if (Build.VERSION.SDK_INT >= 28 || (yVar = this.d) == null) {
            return super.getTextClassifier();
        }
        return yVar.a();
    }

    public void setTextFuture(Future<a.h.i.c> future) {
        this.f = future;
        if (future != null) {
            requestLayout();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        d();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        super.setCompoundDrawables(left, top, right, bottom);
        z zVar = this.c;
        if (zVar != null) {
            zVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable start, Drawable top, Drawable end, Drawable bottom) {
        super.setCompoundDrawablesRelative(start, top, end, bottom);
        z zVar = this.c;
        if (zVar != null) {
            zVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        z zVar = this.c;
        if (zVar != null) {
            zVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(left != 0 ? a.b.c.a.a.d(context, left) : null, top != 0 ? a.b.c.a.a.d(context, top) : null, right != 0 ? a.b.c.a.a.d(context, right) : null, bottom != 0 ? a.b.c.a.a.d(context, bottom) : null);
        z zVar = this.c;
        if (zVar != null) {
            zVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable start, Drawable top, Drawable end, Drawable bottom) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
        z zVar = this.c;
        if (zVar != null) {
            zVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end, int bottom) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(start != 0 ? a.b.c.a.a.d(context, start) : null, top != 0 ? a.b.c.a.a.d(context, top) : null, end != 0 ? a.b.c.a.a.d(context, end) : null, bottom != 0 ? a.b.c.a.a.d(context, bottom) : null);
        z zVar = this.c;
        if (zVar != null) {
            zVar.p();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.j();
    }

    @Override // a.h.l.l
    public void setSupportCompoundDrawablesTintList(ColorStateList tintList) {
        this.c.w(tintList);
        this.c.b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.k();
    }

    @Override // a.h.l.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode tintMode) {
        this.c.x(tintMode);
        this.c.b();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface tf, int style) {
        if (this.e) {
            return;
        }
        Typeface finalTypeface = null;
        if (tf != null && style > 0) {
            finalTypeface = a.h.d.d.a(getContext(), tf, style);
        }
        this.e = true;
        try {
            super.setTypeface(finalTypeface != null ? finalTypeface : tf, style);
        } finally {
            this.e = false;
        }
    }
}
