package a.b.g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final View f143a;
    public v0 d;
    public v0 e;
    public v0 f;
    public int c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final j f144b = j.b();

    public e(View view) {
        this.f143a = view;
    }

    public void e(AttributeSet attrs, int defStyleAttr) {
        Context context = this.f143a.getContext();
        int[] iArr = a.b.a.y;
        x0 a2 = x0.v(context, attrs, iArr, defStyleAttr, 0);
        View view = this.f143a;
        a.h.k.v.m0(view, view.getContext(), iArr, attrs, a2.r(), defStyleAttr, 0);
        try {
            int[] iArr2 = a.b.a.f11a;
            if (a2.s(0)) {
                this.c = a2.n(0, -1);
                ColorStateList tint = this.f144b.f(this.f143a.getContext(), this.c);
                if (tint != null) {
                    h(tint);
                }
            }
            if (a2.s(1)) {
                a.h.k.v.s0(this.f143a, a2.c(1));
            }
            if (a2.s(2)) {
                a.h.k.v.t0(this.f143a, f0.d(a2.k(2, -1), null));
            }
        } finally {
            a2.w();
        }
    }

    public void g(int resId) {
        ColorStateList colorStateList;
        this.c = resId;
        j jVar = this.f144b;
        if (jVar != null) {
            colorStateList = jVar.f(this.f143a.getContext(), resId);
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        b();
    }

    public void f() {
        this.c = -1;
        h(null);
        b();
    }

    public void i(ColorStateList tint) {
        if (this.e == null) {
            this.e = new v0();
        }
        v0 v0Var = this.e;
        v0Var.f198a = tint;
        v0Var.d = true;
        b();
    }

    public ColorStateList c() {
        v0 v0Var = this.e;
        if (v0Var != null) {
            return v0Var.f198a;
        }
        return null;
    }

    public void j(PorterDuff.Mode tintMode) {
        if (this.e == null) {
            this.e = new v0();
        }
        v0 v0Var = this.e;
        v0Var.f199b = tintMode;
        v0Var.c = true;
        b();
    }

    public PorterDuff.Mode d() {
        v0 v0Var = this.e;
        if (v0Var != null) {
            return v0Var.f199b;
        }
        return null;
    }

    public void b() {
        Drawable background = this.f143a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            v0 v0Var = this.e;
            if (v0Var != null) {
                j.i(background, v0Var, this.f143a.getDrawableState());
                return;
            }
            v0 v0Var2 = this.d;
            if (v0Var2 != null) {
                j.i(background, v0Var2, this.f143a.getDrawableState());
            }
        }
    }

    public void h(ColorStateList tint) {
        if (tint != null) {
            if (this.d == null) {
                this.d = new v0();
            }
            v0 v0Var = this.d;
            v0Var.f198a = tint;
            v0Var.d = true;
        } else {
            this.d = null;
        }
        b();
    }

    public final boolean k() {
        int sdk = Build.VERSION.SDK_INT;
        return sdk > 21 ? this.d != null : sdk == 21;
    }

    public final boolean a(Drawable background) {
        if (this.f == null) {
            this.f = new v0();
        }
        v0 info = this.f;
        info.a();
        ColorStateList tintList = a.h.k.v.s(this.f143a);
        if (tintList != null) {
            info.d = true;
            info.f198a = tintList;
        }
        PorterDuff.Mode mode = a.h.k.v.t(this.f143a);
        if (mode != null) {
            info.c = true;
            info.f199b = mode;
        }
        if (info.d || info.c) {
            j.i(background, info, this.f143a.getDrawableState());
            return true;
        }
        return false;
    }
}
