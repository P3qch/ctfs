package a.b.g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f173a;

    /* renamed from: b, reason: collision with root package name */
    public v0 f174b;
    public v0 c;

    public n(ImageView view) {
        this.f173a = view;
    }

    public void f(AttributeSet attrs, int defStyleAttr) {
        Context context = this.f173a.getContext();
        int[] iArr = a.b.a.f;
        x0 a2 = x0.v(context, attrs, iArr, defStyleAttr, 0);
        ImageView imageView = this.f173a;
        a.h.k.v.m0(imageView, imageView.getContext(), iArr, attrs, a2.r(), defStyleAttr, 0);
        try {
            Drawable drawable = this.f173a.getDrawable();
            if (drawable == null) {
                int[] iArr2 = a.b.a.f11a;
                int id = a2.n(1, -1);
                if (id != -1 && (drawable = a.b.c.a.a.d(this.f173a.getContext(), id)) != null) {
                    this.f173a.setImageDrawable(drawable);
                }
            }
            if (drawable != null) {
                f0.b(drawable);
            }
            int[] iArr3 = a.b.a.f11a;
            if (a2.s(2)) {
                a.h.l.e.c(this.f173a, a2.c(2));
            }
            if (a2.s(3)) {
                a.h.l.e.d(this.f173a, f0.d(a2.k(3, -1), null));
            }
        } finally {
            a2.w();
        }
    }

    public void g(int resId) {
        if (resId != 0) {
            Drawable d = a.b.c.a.a.d(this.f173a.getContext(), resId);
            if (d != null) {
                f0.b(d);
            }
            this.f173a.setImageDrawable(d);
        } else {
            this.f173a.setImageDrawable(null);
        }
        b();
    }

    public boolean e() {
        Drawable background = this.f173a.getBackground();
        if (Build.VERSION.SDK_INT >= 21 && (background instanceof RippleDrawable)) {
            return false;
        }
        return true;
    }

    public void h(ColorStateList tint) {
        if (this.f174b == null) {
            this.f174b = new v0();
        }
        v0 v0Var = this.f174b;
        v0Var.f198a = tint;
        v0Var.d = true;
        b();
    }

    public ColorStateList c() {
        v0 v0Var = this.f174b;
        if (v0Var != null) {
            return v0Var.f198a;
        }
        return null;
    }

    public void i(PorterDuff.Mode tintMode) {
        if (this.f174b == null) {
            this.f174b = new v0();
        }
        v0 v0Var = this.f174b;
        v0Var.f199b = tintMode;
        v0Var.c = true;
        b();
    }

    public PorterDuff.Mode d() {
        v0 v0Var = this.f174b;
        if (v0Var != null) {
            return v0Var.f199b;
        }
        return null;
    }

    public void b() {
        v0 v0Var;
        Drawable imageViewDrawable = this.f173a.getDrawable();
        if (imageViewDrawable != null) {
            f0.b(imageViewDrawable);
        }
        if (imageViewDrawable != null) {
            if ((!j() || !a(imageViewDrawable)) && (v0Var = this.f174b) != null) {
                j.i(imageViewDrawable, v0Var, this.f173a.getDrawableState());
            }
        }
    }

    public final boolean j() {
        int sdk = Build.VERSION.SDK_INT;
        if (sdk > 21 || sdk != 21) {
            return false;
        }
        return true;
    }

    public final boolean a(Drawable imageSource) {
        if (this.c == null) {
            this.c = new v0();
        }
        v0 info = this.c;
        info.a();
        ColorStateList tintList = a.h.l.e.a(this.f173a);
        if (tintList != null) {
            info.d = true;
            info.f198a = tintList;
        }
        PorterDuff.Mode mode = a.h.l.e.b(this.f173a);
        if (mode != null) {
            info.c = true;
            info.f199b = mode;
        }
        if (info.d || info.c) {
            j.i(imageSource, info, this.f173a.getDrawableState());
            return true;
        }
        return false;
    }
}
