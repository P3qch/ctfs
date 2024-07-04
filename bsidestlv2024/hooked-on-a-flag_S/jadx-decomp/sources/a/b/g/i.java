package a.b.g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final CompoundButton f153a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f154b = null;
    public PorterDuff.Mode c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f;

    public i(CompoundButton view) {
        this.f153a = view;
    }

    public void e(AttributeSet attrs, int defStyleAttr) {
        int resourceId;
        int resourceId2;
        Context context = this.f153a.getContext();
        int[] iArr = a.b.a.l;
        x0 a2 = x0.v(context, attrs, iArr, defStyleAttr, 0);
        CompoundButton compoundButton = this.f153a;
        a.h.k.v.m0(compoundButton, compoundButton.getContext(), iArr, attrs, a2.r(), defStyleAttr, 0);
        boolean buttonDrawableLoaded = false;
        try {
            int[] iArr2 = a.b.a.f11a;
            if (a2.s(1) && (resourceId2 = a2.n(1, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.f153a;
                    compoundButton2.setButtonDrawable(a.b.c.a.a.d(compoundButton2.getContext(), resourceId2));
                    buttonDrawableLoaded = true;
                } catch (Resources.NotFoundException e) {
                }
            }
            if (!buttonDrawableLoaded) {
                int[] iArr3 = a.b.a.f11a;
                if (a2.s(0) && (resourceId = a2.n(0, 0)) != 0) {
                    CompoundButton compoundButton3 = this.f153a;
                    compoundButton3.setButtonDrawable(a.b.c.a.a.d(compoundButton3.getContext(), resourceId));
                }
            }
            int[] iArr4 = a.b.a.f11a;
            if (a2.s(2)) {
                a.h.l.c.c(this.f153a, a2.c(2));
            }
            if (a2.s(3)) {
                a.h.l.c.d(this.f153a, f0.d(a2.k(3, -1), null));
            }
        } finally {
            a2.w();
        }
    }

    public void g(ColorStateList tint) {
        this.f154b = tint;
        this.d = true;
        a();
    }

    public ColorStateList c() {
        return this.f154b;
    }

    public void h(PorterDuff.Mode tintMode) {
        this.c = tintMode;
        this.e = true;
        a();
    }

    public PorterDuff.Mode d() {
        return this.c;
    }

    public void f() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            a();
        }
    }

    public void a() {
        Drawable buttonDrawable = a.h.l.c.a(this.f153a);
        if (buttonDrawable != null) {
            if (this.d || this.e) {
                Drawable buttonDrawable2 = a.h.d.l.a.r(buttonDrawable).mutate();
                if (this.d) {
                    a.h.d.l.a.o(buttonDrawable2, this.f154b);
                }
                if (this.e) {
                    a.h.d.l.a.p(buttonDrawable2, this.c);
                }
                if (buttonDrawable2.isStateful()) {
                    buttonDrawable2.setState(this.f153a.getDrawableState());
                }
                this.f153a.setButtonDrawable(buttonDrawable2);
            }
        }
    }

    public int b(int superValue) {
        Drawable buttonDrawable;
        if (Build.VERSION.SDK_INT < 17 && (buttonDrawable = a.h.l.c.a(this.f153a)) != null) {
            return superValue + buttonDrawable.getIntrinsicWidth();
        }
        return superValue;
    }
}
