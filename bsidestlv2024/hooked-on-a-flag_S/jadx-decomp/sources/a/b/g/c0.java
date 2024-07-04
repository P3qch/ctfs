package a.b.g;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class c0 extends ToggleButton implements a.h.k.u {

    /* renamed from: b, reason: collision with root package name */
    public final e f138b;
    public final z c;

    public c0(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.buttonStyleToggle);
    }

    public c0(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        s0.a(this, getContext());
        e eVar = new e(this);
        this.f138b = eVar;
        eVar.e(attrs, defStyleAttr);
        z zVar = new z(this);
        this.c = zVar;
        zVar.m(attrs, defStyleAttr);
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        e eVar = this.f138b;
        if (eVar != null) {
            eVar.g(resId);
        }
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        e eVar = this.f138b;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintList(ColorStateList tint) {
        e eVar = this.f138b;
        if (eVar != null) {
            eVar.i(tint);
        }
    }

    @Override // a.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f138b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode tintMode) {
        e eVar = this.f138b;
        if (eVar != null) {
            eVar.j(tintMode);
        }
    }

    @Override // a.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f138b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f138b;
        if (eVar != null) {
            eVar.b();
        }
        z zVar = this.c;
        if (zVar != null) {
            zVar.b();
        }
    }
}
