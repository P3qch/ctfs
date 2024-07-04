package b.b.a.a.e;

import a.h.k.v;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import b.b.a.a.r.l;
import b.b.a.a.u.c;
import b.b.a.a.v.b;
import b.b.a.a.x.g;
import b.b.a.a.x.k;
import b.b.a.a.x.n;
import com.google.android.material.button.MaterialButton;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f1005a;

    /* renamed from: b, reason: collision with root package name */
    public final MaterialButton f1006b;
    public k c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public PorterDuff.Mode j;
    public ColorStateList k;
    public ColorStateList l;
    public ColorStateList m;
    public Drawable n;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public boolean r;
    public LayerDrawable s;
    public int t;

    static {
        f1005a = Build.VERSION.SDK_INT >= 21;
    }

    public a(MaterialButton button, k shapeAppearanceModel) {
        this.f1006b = button;
        this.c = shapeAppearanceModel;
    }

    public void q(TypedArray attributes) {
        int[] iArr = b.b.a.a.a.f942a;
        this.d = attributes.getDimensionPixelOffset(1, 0);
        this.e = attributes.getDimensionPixelOffset(2, 0);
        this.f = attributes.getDimensionPixelOffset(3, 0);
        this.g = attributes.getDimensionPixelOffset(4, 0);
        if (attributes.hasValue(8)) {
            int dimensionPixelSize = attributes.getDimensionPixelSize(8, -1);
            this.h = dimensionPixelSize;
            y(this.c.w(dimensionPixelSize));
            this.q = true;
        }
        this.i = attributes.getDimensionPixelSize(20, 0);
        this.j = l.e(attributes.getInt(7, -1), PorterDuff.Mode.SRC_IN);
        this.k = c.a(this.f1006b.getContext(), attributes, 6);
        this.l = c.a(this.f1006b.getContext(), attributes, 19);
        this.m = c.a(this.f1006b.getContext(), attributes, 16);
        this.r = attributes.getBoolean(5, false);
        this.t = attributes.getDimensionPixelSize(9, 0);
        int paddingStart = v.I(this.f1006b);
        int paddingTop = this.f1006b.getPaddingTop();
        int paddingEnd = v.H(this.f1006b);
        int paddingBottom = this.f1006b.getPaddingBottom();
        if (attributes.hasValue(0)) {
            s();
        } else {
            F();
        }
        v.A0(this.f1006b, this.d + paddingStart, this.f + paddingTop, this.e + paddingEnd, this.g + paddingBottom);
    }

    public final void F() {
        this.f1006b.setInternalBackground(a());
        g materialShapeDrawable = f();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.U(this.t);
        }
    }

    public void s() {
        this.p = true;
        this.f1006b.setSupportBackgroundTintList(this.k);
        this.f1006b.setSupportBackgroundTintMode(this.j);
    }

    public boolean o() {
        return this.p;
    }

    public final InsetDrawable J(Drawable drawable) {
        return new InsetDrawable(drawable, this.d, this.f, this.e, this.g);
    }

    public void C(ColorStateList tintList) {
        if (this.k != tintList) {
            this.k = tintList;
            if (f() != null) {
                a.h.d.l.a.o(f(), this.k);
            }
        }
    }

    public ColorStateList l() {
        return this.k;
    }

    public void D(PorterDuff.Mode mode) {
        if (this.j != mode) {
            this.j = mode;
            if (f() != null && this.j != null) {
                a.h.d.l.a.p(f(), this.j);
            }
        }
    }

    public PorterDuff.Mode m() {
        return this.j;
    }

    public void z(boolean shouldDrawSurfaceColorStroke) {
        this.o = shouldDrawSurfaceColorStroke;
        I();
    }

    public final Drawable a() {
        g backgroundDrawable = new g(this.c);
        Context context = this.f1006b.getContext();
        backgroundDrawable.L(context);
        a.h.d.l.a.o(backgroundDrawable, this.k);
        PorterDuff.Mode mode = this.j;
        if (mode != null) {
            a.h.d.l.a.p(backgroundDrawable, mode);
        }
        backgroundDrawable.a0(this.i, this.l);
        g surfaceColorStrokeDrawable = new g(this.c);
        surfaceColorStrokeDrawable.setTint(0);
        surfaceColorStrokeDrawable.Z(this.i, this.o ? b.b.a.a.k.a.c(this.f1006b, R.attr.colorSurface) : 0);
        if (f1005a) {
            g gVar = new g(this.c);
            this.n = gVar;
            a.h.d.l.a.n(gVar, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.a(this.m), J(new LayerDrawable(new Drawable[]{surfaceColorStrokeDrawable, backgroundDrawable})), this.n);
            this.s = rippleDrawable;
            return rippleDrawable;
        }
        b.b.a.a.v.a aVar = new b.b.a.a.v.a(this.c);
        this.n = aVar;
        a.h.d.l.a.o(aVar, b.a(this.m));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{surfaceColorStrokeDrawable, backgroundDrawable, this.n});
        this.s = layerDrawable;
        return J(layerDrawable);
    }

    public void H(int height, int width) {
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setBounds(this.d, this.f, width - this.e, height - this.g);
        }
    }

    public void r(int color) {
        if (f() != null) {
            f().setTint(color);
        }
    }

    public void x(ColorStateList rippleColor) {
        if (this.m != rippleColor) {
            this.m = rippleColor;
            boolean z = f1005a;
            if (z && (this.f1006b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f1006b.getBackground()).setColor(b.a(rippleColor));
            } else if (!z && (this.f1006b.getBackground() instanceof b.b.a.a.v.a)) {
                ((b.b.a.a.v.a) this.f1006b.getBackground()).setTintList(b.a(rippleColor));
            }
        }
    }

    public ColorStateList h() {
        return this.m;
    }

    public void A(ColorStateList strokeColor) {
        if (this.l != strokeColor) {
            this.l = strokeColor;
            I();
        }
    }

    public ColorStateList j() {
        return this.l;
    }

    public void B(int strokeWidth) {
        if (this.i != strokeWidth) {
            this.i = strokeWidth;
            I();
        }
    }

    public int k() {
        return this.i;
    }

    public final void I() {
        g materialShapeDrawable = f();
        g surfaceColorStrokeDrawable = n();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.a0(this.i, this.l);
            if (surfaceColorStrokeDrawable != null) {
                surfaceColorStrokeDrawable.Z(this.i, this.o ? b.b.a.a.k.a.c(this.f1006b, R.attr.colorSurface) : 0);
            }
        }
    }

    public void u(int cornerRadius) {
        if (!this.q || this.h != cornerRadius) {
            this.h = cornerRadius;
            this.q = true;
            y(this.c.w(cornerRadius));
        }
    }

    public int b() {
        return this.h;
    }

    public final g g(boolean z) {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 0) {
            if (f1005a) {
                return (g) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
            }
            return (g) this.s.getDrawable(!z ? 1 : 0);
        }
        return null;
    }

    public g f() {
        return g(false);
    }

    public void t(boolean checkable) {
        this.r = checkable;
    }

    public boolean p() {
        return this.r;
    }

    public final g n() {
        return g(true);
    }

    public final void G(k shapeAppearanceModel) {
        if (f() != null) {
            f().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public n e() {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 1) {
            if (this.s.getNumberOfLayers() > 2) {
                return (n) this.s.getDrawable(2);
            }
            return (n) this.s.getDrawable(1);
        }
        return null;
    }

    public void y(k shapeAppearanceModel) {
        this.c = shapeAppearanceModel;
        G(shapeAppearanceModel);
    }

    public k i() {
        return this.c;
    }

    public void v(int newInsetBottom) {
        E(this.f, newInsetBottom);
    }

    public int c() {
        return this.g;
    }

    public void w(int newInsetTop) {
        E(newInsetTop, this.g);
    }

    public final void E(int newInsetTop, int newInsetBottom) {
        int paddingStart = v.I(this.f1006b);
        int paddingTop = this.f1006b.getPaddingTop();
        int paddingEnd = v.H(this.f1006b);
        int paddingBottom = this.f1006b.getPaddingBottom();
        int oldInsetTop = this.f;
        int oldInsetBottom = this.g;
        this.g = newInsetBottom;
        this.f = newInsetTop;
        if (!this.p) {
            F();
        }
        v.A0(this.f1006b, paddingStart, (paddingTop + newInsetTop) - oldInsetTop, paddingEnd, (paddingBottom + newInsetBottom) - oldInsetBottom);
    }

    public int d() {
        return this.f;
    }
}
