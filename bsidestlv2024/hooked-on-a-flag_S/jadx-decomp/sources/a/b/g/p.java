package a.b.g;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* loaded from: classes.dex */
public class p extends MultiAutoCompleteTextView implements a.h.k.u {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f179b = {R.attr.popupBackground};
    public final e c;
    public final z d;

    public p(Context context, AttributeSet attrs) {
        this(context, attrs, net.sqlcipher.R.attr.autoCompleteTextViewStyle);
    }

    public p(Context context, AttributeSet attrs, int defStyleAttr) {
        super(u0.b(context), attrs, defStyleAttr);
        s0.a(this, getContext());
        x0 a2 = x0.v(getContext(), attrs, f179b, defStyleAttr, 0);
        if (a2.s(0)) {
            setDropDownBackgroundDrawable(a2.g(0));
        }
        a2.w();
        e eVar = new e(this);
        this.c = eVar;
        eVar.e(attrs, defStyleAttr);
        z zVar = new z(this);
        this.d = zVar;
        zVar.m(attrs, defStyleAttr);
        zVar.b();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int resId) {
        setDropDownBackgroundDrawable(a.b.c.a.a.d(getContext(), resId));
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        e eVar = this.c;
        if (eVar != null) {
            eVar.g(resId);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        e eVar = this.c;
        if (eVar != null) {
            eVar.f();
        }
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

    @Override // android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        z zVar = this.d;
        if (zVar != null) {
            zVar.q(context, resId);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(outAttrs);
        l.a(onCreateInputConnection, outAttrs, this);
        return onCreateInputConnection;
    }
}
