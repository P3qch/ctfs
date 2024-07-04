package a.b.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class f extends Button implements a.h.k.u, a.h.l.b, a.h.l.l {

    /* renamed from: b, reason: collision with root package name */
    public final e f146b;
    public final z c;

    public f(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.buttonStyle);
    }

    public f(Context context, AttributeSet attrs, int defStyleAttr) {
        super(u0.b(context), attrs, defStyleAttr);
        s0.a(this, getContext());
        e eVar = new e(this);
        this.f146b = eVar;
        eVar.e(attrs, defStyleAttr);
        z zVar = new z(this);
        this.c = zVar;
        zVar.m(attrs, defStyleAttr);
        zVar.b();
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        e eVar = this.f146b;
        if (eVar != null) {
            eVar.g(resId);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        e eVar = this.f146b;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintList(ColorStateList tint) {
        e eVar = this.f146b;
        if (eVar != null) {
            eVar.i(tint);
        }
    }

    @Override // a.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f146b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode tintMode) {
        e eVar = this.f146b;
        if (eVar != null) {
            eVar.j(tintMode);
        }
    }

    @Override // a.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f146b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f146b;
        if (eVar != null) {
            eVar.b();
        }
        z zVar = this.c;
        if (zVar != null) {
            zVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        z zVar = this.c;
        if (zVar != null) {
            zVar.q(context, resId);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(Button.class.getName());
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

    public void setSupportAllCaps(boolean allCaps) {
        z zVar = this.c;
        if (zVar != null) {
            zVar.s(allCaps);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        super.setCustomSelectionActionModeCallback(a.h.l.i.p(this, actionModeCallback));
    }

    @Override // a.h.l.l
    public void setSupportCompoundDrawablesTintList(ColorStateList tint) {
        this.c.w(tint);
        this.c.b();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.j();
    }

    @Override // a.h.l.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode tintMode) {
        this.c.x(tintMode);
        this.c.b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.k();
    }
}
