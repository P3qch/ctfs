package a.b.g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class s extends RadioButton implements a.h.l.k, a.h.k.u {

    /* renamed from: b, reason: collision with root package name */
    public final i f190b;
    public final e c;
    public final z d;

    public s(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.radioButtonStyle);
    }

    public s(Context context, AttributeSet attrs, int defStyleAttr) {
        super(u0.b(context), attrs, defStyleAttr);
        s0.a(this, getContext());
        i iVar = new i(this);
        this.f190b = iVar;
        iVar.e(attrs, defStyleAttr);
        e eVar = new e(this);
        this.c = eVar;
        eVar.e(attrs, defStyleAttr);
        z zVar = new z(this);
        this.d = zVar;
        zVar.m(attrs, defStyleAttr);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable buttonDrawable) {
        super.setButtonDrawable(buttonDrawable);
        i iVar = this.f190b;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int resId) {
        setButtonDrawable(a.b.c.a.a.d(getContext(), resId));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int value = super.getCompoundPaddingLeft();
        i iVar = this.f190b;
        if (iVar != null) {
            return iVar.b(value);
        }
        return value;
    }

    @Override // a.h.l.k
    public void setSupportButtonTintList(ColorStateList tint) {
        i iVar = this.f190b;
        if (iVar != null) {
            iVar.g(tint);
        }
    }

    @Override // a.h.l.k
    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f190b;
        if (iVar != null) {
            return iVar.c();
        }
        return null;
    }

    @Override // a.h.l.k
    public void setSupportButtonTintMode(PorterDuff.Mode tintMode) {
        i iVar = this.f190b;
        if (iVar != null) {
            iVar.h(tintMode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.f190b;
        if (iVar != null) {
            return iVar.d();
        }
        return null;
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintList(ColorStateList tint) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.i(tint);
        }
    }

    @Override // a.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode tintMode) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.j(tintMode);
        }
    }

    @Override // a.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        e eVar = this.c;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        e eVar = this.c;
        if (eVar != null) {
            eVar.g(resId);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.c;
        if (eVar != null) {
            eVar.b();
        }
        z zVar = this.d;
        if (zVar != null) {
            zVar.b();
        }
    }
}
