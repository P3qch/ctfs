package b.b.a.a.i;

import a.h.d.l.b;
import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import b.b.a.a.r.h;
import b.b.a.a.r.j;
import b.b.a.a.r.l;
import b.b.a.a.u.c;
import b.b.a.a.u.d;
import b.b.a.a.x.g;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public class a extends g implements b, Drawable.Callback, h.b {
    public PorterDuffColorFilter A0;
    public ColorStateList B;
    public ColorStateList B0;
    public ColorStateList C;
    public PorterDuff.Mode C0;
    public float D;
    public int[] D0;
    public float E;
    public boolean E0;
    public ColorStateList F;
    public ColorStateList F0;
    public float G;
    public WeakReference<InterfaceC0065a> G0;
    public ColorStateList H;
    public TextUtils.TruncateAt H0;
    public CharSequence I;
    public boolean I0;
    public boolean J;
    public int J0;
    public Drawable K;
    public boolean K0;
    public ColorStateList L;
    public float M;
    public boolean N;
    public boolean O;
    public Drawable P;
    public Drawable Q;
    public ColorStateList R;
    public float S;
    public CharSequence T;
    public boolean U;
    public boolean V;
    public Drawable W;
    public ColorStateList X;
    public b.b.a.a.b.h Y;
    public b.b.a.a.b.h Z;
    public float a0;
    public float b0;
    public float c0;
    public float d0;
    public float e0;
    public float f0;
    public float g0;
    public float h0;
    public final Context i0;
    public final Paint j0;
    public final Paint k0;
    public final Paint.FontMetrics l0;
    public final RectF m0;
    public final PointF n0;
    public final Path o0;
    public final h p0;
    public int q0;
    public int r0;
    public int s0;
    public int t0;
    public int u0;
    public int v0;
    public boolean w0;
    public int x0;
    public int y0;
    public ColorFilter z0;
    public static final int[] z = {R.attr.state_enabled};
    public static final ShapeDrawable A = new ShapeDrawable(new OvalShape());

    /* renamed from: b.b.a.a.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065a {
        void a();
    }

    public static a q0(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        a chip = new a(context, attrs, defStyleAttr, defStyleRes);
        chip.p1(attrs, defStyleAttr, defStyleRes);
        return chip;
    }

    public a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.E = -1.0f;
        this.j0 = new Paint(1);
        this.l0 = new Paint.FontMetrics();
        this.m0 = new RectF();
        this.n0 = new PointF();
        this.o0 = new Path();
        this.y0 = 255;
        this.C0 = PorterDuff.Mode.SRC_IN;
        this.G0 = new WeakReference<>(null);
        L(context);
        this.i0 = context;
        h hVar = new h(this);
        this.p0 = hVar;
        this.I = BuildConfig.FLAVOR;
        hVar.e().density = context.getResources().getDisplayMetrics().density;
        this.k0 = null;
        int[] iArr = z;
        setState(iArr);
        g2(iArr);
        this.I0 = true;
        if (b.b.a.a.v.b.f1093a) {
            A.setTint(-1);
        }
    }

    public final void p1(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a2 = j.h(this.i0, attrs, b.b.a.a.a.c, defStyleAttr, defStyleRes, new int[0]);
        int[] iArr = b.b.a.a.a.f942a;
        this.K0 = a2.hasValue(37);
        W1(c.a(this.i0, a2, 24));
        A1(c.a(this.i0, a2, 11));
        O1(a2.getDimension(19, 0.0f));
        if (a2.hasValue(12)) {
            C1(a2.getDimension(12, 0.0f));
        }
        S1(c.a(this.i0, a2, 22));
        U1(a2.getDimension(23, 0.0f));
        t2(c.a(this.i0, a2, 36));
        y2(a2.getText(5));
        d textAppearance = c.f(this.i0, a2, 0);
        float textSize = a2.getDimension(1, textAppearance.k);
        textAppearance.k = textSize;
        z2(textAppearance);
        int ellipsize = a2.getInt(3, 0);
        switch (ellipsize) {
            case 1:
                l2(TextUtils.TruncateAt.START);
                break;
            case 2:
                l2(TextUtils.TruncateAt.MIDDLE);
                break;
            case 3:
                l2(TextUtils.TruncateAt.END);
                break;
        }
        N1(a2.getBoolean(18, false));
        if (attrs != null && attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            N1(a2.getBoolean(15, false));
        }
        G1(c.d(this.i0, a2, 14));
        if (a2.hasValue(17)) {
            K1(c.a(this.i0, a2, 17));
        }
        I1(a2.getDimension(16, -1.0f));
        j2(a2.getBoolean(31, false));
        if (attrs != null && attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            j2(a2.getBoolean(26, false));
        }
        X1(c.d(this.i0, a2, 25));
        h2(c.a(this.i0, a2, 30));
        c2(a2.getDimension(28, 0.0f));
        s1(a2.getBoolean(6, false));
        z1(a2.getBoolean(10, false));
        if (attrs != null && attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            z1(a2.getBoolean(8, false));
        }
        u1(c.d(this.i0, a2, 7));
        if (a2.hasValue(9)) {
            w1(c.a(this.i0, a2, 9));
        }
        w2(b.b.a.a.b.h.b(this.i0, a2, 39));
        m2(b.b.a.a.b.h.b(this.i0, a2, 33));
        Q1(a2.getDimension(21, 0.0f));
        q2(a2.getDimension(35, 0.0f));
        o2(a2.getDimension(34, 0.0f));
        D2(a2.getDimension(41, 0.0f));
        B2(a2.getDimension(40, 0.0f));
        e2(a2.getDimension(29, 0.0f));
        Z1(a2.getDimension(27, 0.0f));
        E1(a2.getDimension(13, 0.0f));
        s2(a2.getDimensionPixelSize(4, Integer.MAX_VALUE));
        a2.recycle();
    }

    public void F2(boolean useCompatRipple) {
        if (this.E0 != useCompatRipple) {
            this.E0 = useCompatRipple;
            L2();
            onStateChange(getState());
        }
    }

    public boolean h1() {
        return this.E0;
    }

    public void k2(InterfaceC0065a delegate) {
        this.G0 = new WeakReference<>(delegate);
    }

    public void q1() {
        InterfaceC0065a delegate = this.G0.get();
        if (delegate != null) {
            delegate.a();
        }
    }

    public void T0(RectF bounds) {
        k0(getBounds(), bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int calculatedWidth = Math.round(this.a0 + i0() + this.d0 + this.p0.f(c1().toString()) + this.e0 + l0() + this.h0);
        return Math.min(calculatedWidth, this.J0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.D;
    }

    public final boolean I2() {
        return this.J && this.K != null;
    }

    public final boolean H2() {
        return this.V && this.W != null && this.w0;
    }

    public final boolean J2() {
        return this.O && this.P != null;
    }

    public final boolean p0() {
        return this.V && this.W != null && this.U;
    }

    public float i0() {
        if (I2() || H2()) {
            return this.b0 + V0() + this.c0;
        }
        return 0.0f;
    }

    public final float V0() {
        Drawable iconDrawable = this.w0 ? this.W : this.K;
        float f = this.M;
        if (f <= 0.0f && iconDrawable != null) {
            return iconDrawable.getIntrinsicWidth();
        }
        return f;
    }

    public final float U0() {
        Drawable icon = this.w0 ? this.W : this.K;
        float maxChipIconHeight = this.M;
        if (maxChipIconHeight <= 0.0f && icon != null) {
            float maxChipIconHeight2 = (float) Math.ceil(l.b(this.i0, 24));
            if (icon.getIntrinsicHeight() <= maxChipIconHeight2) {
                return icon.getIntrinsicHeight();
            }
            return maxChipIconHeight2;
        }
        return maxChipIconHeight;
    }

    public float l0() {
        if (J2()) {
            return this.f0 + this.S + this.g0;
        }
        return 0.0f;
    }

    @Override // b.b.a.a.x.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int saveCount = 0;
        int i = this.y0;
        if (i < 255) {
            saveCount = b.b.a.a.f.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        }
        v0(canvas, bounds);
        s0(canvas, bounds);
        if (this.K0) {
            super.draw(canvas);
        }
        u0(canvas, bounds);
        x0(canvas, bounds);
        t0(canvas, bounds);
        r0(canvas, bounds);
        if (this.I0) {
            z0(canvas, bounds);
        }
        w0(canvas, bounds);
        y0(canvas, bounds);
        if (this.y0 < 255) {
            canvas.restoreToCount(saveCount);
        }
    }

    public final void v0(Canvas canvas, Rect bounds) {
        if (!this.K0) {
            this.j0.setColor(this.q0);
            this.j0.setStyle(Paint.Style.FILL);
            this.m0.set(bounds);
            canvas.drawRoundRect(this.m0, D0(), D0(), this.j0);
        }
    }

    public final void s0(Canvas canvas, Rect bounds) {
        if (!this.K0) {
            this.j0.setColor(this.r0);
            this.j0.setStyle(Paint.Style.FILL);
            this.j0.setColorFilter(g1());
            this.m0.set(bounds);
            canvas.drawRoundRect(this.m0, D0(), D0(), this.j0);
        }
    }

    public final void u0(Canvas canvas, Rect bounds) {
        if (this.G > 0.0f && !this.K0) {
            this.j0.setColor(this.t0);
            this.j0.setStyle(Paint.Style.STROKE);
            if (!this.K0) {
                this.j0.setColorFilter(g1());
            }
            RectF rectF = this.m0;
            float f = bounds.left;
            float f2 = this.G;
            rectF.set(f + (f2 / 2.0f), bounds.top + (f2 / 2.0f), bounds.right - (f2 / 2.0f), bounds.bottom - (f2 / 2.0f));
            float strokeCornerRadius = this.E - (this.G / 2.0f);
            canvas.drawRoundRect(this.m0, strokeCornerRadius, strokeCornerRadius, this.j0);
        }
    }

    public final void x0(Canvas canvas, Rect bounds) {
        this.j0.setColor(this.u0);
        this.j0.setStyle(Paint.Style.FILL);
        this.m0.set(bounds);
        if (!this.K0) {
            canvas.drawRoundRect(this.m0, D0(), D0(), this.j0);
        } else {
            h(new RectF(bounds), this.o0);
            p(canvas, this.j0, this.o0, u());
        }
    }

    public final void t0(Canvas canvas, Rect bounds) {
        if (I2()) {
            h0(bounds, this.m0);
            RectF rectF = this.m0;
            float tx = rectF.left;
            float ty = rectF.top;
            canvas.translate(tx, ty);
            this.K.setBounds(0, 0, (int) this.m0.width(), (int) this.m0.height());
            this.K.draw(canvas);
            canvas.translate(-tx, -ty);
        }
    }

    public final void r0(Canvas canvas, Rect bounds) {
        if (H2()) {
            h0(bounds, this.m0);
            RectF rectF = this.m0;
            float tx = rectF.left;
            float ty = rectF.top;
            canvas.translate(tx, ty);
            this.W.setBounds(0, 0, (int) this.m0.width(), (int) this.m0.height());
            this.W.draw(canvas);
            canvas.translate(-tx, -ty);
        }
    }

    public final void z0(Canvas canvas, Rect bounds) {
        if (this.I != null) {
            Paint.Align align = o0(bounds, this.n0);
            m0(bounds, this.m0);
            if (this.p0.d() != null) {
                this.p0.e().drawableState = getState();
                this.p0.j(this.i0);
            }
            this.p0.e().setTextAlign(align);
            boolean clip = Math.round(this.p0.f(c1().toString())) > Math.round(this.m0.width());
            int saveCount = 0;
            if (clip) {
                saveCount = canvas.save();
                canvas.clipRect(this.m0);
            }
            CharSequence finalText = this.I;
            if (clip && this.H0 != null) {
                finalText = TextUtils.ellipsize(this.I, this.p0.e(), this.m0.width(), this.H0);
            }
            int length = finalText.length();
            PointF pointF = this.n0;
            canvas.drawText(finalText, 0, length, pointF.x, pointF.y, this.p0.e());
            if (clip) {
                canvas.restoreToCount(saveCount);
            }
        }
    }

    public final void w0(Canvas canvas, Rect bounds) {
        if (J2()) {
            j0(bounds, this.m0);
            RectF rectF = this.m0;
            float tx = rectF.left;
            float ty = rectF.top;
            canvas.translate(tx, ty);
            this.P.setBounds(0, 0, (int) this.m0.width(), (int) this.m0.height());
            if (b.b.a.a.v.b.f1093a) {
                this.Q.setBounds(this.P.getBounds());
                this.Q.jumpToCurrentState();
                this.Q.draw(canvas);
            } else {
                this.P.draw(canvas);
            }
            canvas.translate(-tx, -ty);
        }
    }

    public final void y0(Canvas canvas, Rect bounds) {
    }

    public final void h0(Rect bounds, RectF outBounds) {
        outBounds.setEmpty();
        if (I2() || H2()) {
            float offsetFromStart = this.a0 + this.b0;
            float chipWidth = V0();
            if (a.h.d.l.a.f(this) == 0) {
                float f = bounds.left + offsetFromStart;
                outBounds.left = f;
                outBounds.right = f + chipWidth;
            } else {
                float f2 = bounds.right - offsetFromStart;
                outBounds.right = f2;
                outBounds.left = f2 - chipWidth;
            }
            float chipHeight = U0();
            float exactCenterY = bounds.exactCenterY() - (chipHeight / 2.0f);
            outBounds.top = exactCenterY;
            outBounds.bottom = exactCenterY + chipHeight;
        }
    }

    public Paint.Align o0(Rect bounds, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.I != null) {
            float offsetFromStart = this.a0 + i0() + this.d0;
            if (a.h.d.l.a.f(this) == 0) {
                pointF.x = bounds.left + offsetFromStart;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = bounds.right - offsetFromStart;
                align = Paint.Align.RIGHT;
            }
            pointF.y = bounds.centerY() - n0();
        }
        return align;
    }

    public final float n0() {
        this.p0.e().getFontMetrics(this.l0);
        Paint.FontMetrics fontMetrics = this.l0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public final void m0(Rect bounds, RectF outBounds) {
        outBounds.setEmpty();
        if (this.I != null) {
            float offsetFromStart = this.a0 + i0() + this.d0;
            float offsetFromEnd = this.h0 + l0() + this.e0;
            if (a.h.d.l.a.f(this) == 0) {
                outBounds.left = bounds.left + offsetFromStart;
                outBounds.right = bounds.right - offsetFromEnd;
            } else {
                outBounds.left = bounds.left + offsetFromEnd;
                outBounds.right = bounds.right - offsetFromStart;
            }
            outBounds.top = bounds.top;
            outBounds.bottom = bounds.bottom;
        }
    }

    public final void j0(Rect bounds, RectF outBounds) {
        outBounds.setEmpty();
        if (J2()) {
            float offsetFromEnd = this.h0 + this.g0;
            if (a.h.d.l.a.f(this) == 0) {
                float f = bounds.right - offsetFromEnd;
                outBounds.right = f;
                outBounds.left = f - this.S;
            } else {
                float f2 = bounds.left + offsetFromEnd;
                outBounds.left = f2;
                outBounds.right = f2 + this.S;
            }
            float exactCenterY = bounds.exactCenterY();
            float f3 = this.S;
            float f4 = exactCenterY - (f3 / 2.0f);
            outBounds.top = f4;
            outBounds.bottom = f4 + f3;
        }
    }

    public final void k0(Rect bounds, RectF outBounds) {
        outBounds.setEmpty();
        if (J2()) {
            float offsetFromEnd = this.h0 + this.g0 + this.S + this.f0 + this.e0;
            if (a.h.d.l.a.f(this) == 0) {
                float f = bounds.right;
                outBounds.right = f;
                outBounds.left = f - offsetFromEnd;
            } else {
                int i = bounds.left;
                outBounds.left = i;
                outBounds.right = i + offsetFromEnd;
            }
            outBounds.top = bounds.top;
            outBounds.bottom = bounds.bottom;
        }
    }

    @Override // b.b.a.a.x.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return m1(this.B) || m1(this.C) || m1(this.F) || (this.E0 && m1(this.F0)) || o1(this.p0.d()) || p0() || n1(this.K) || n1(this.W) || m1(this.B0);
    }

    public boolean k1() {
        return n1(this.P);
    }

    public boolean g2(int[] stateSet) {
        if (!Arrays.equals(this.D0, stateSet)) {
            this.D0 = stateSet;
            if (J2()) {
                return r1(getState(), stateSet);
            }
            return false;
        }
        return false;
    }

    public int[] R0() {
        return this.D0;
    }

    @Override // b.b.a.a.r.h.b
    public void a() {
        q1();
        invalidateSelf();
    }

    @Override // b.b.a.a.x.g, android.graphics.drawable.Drawable, b.b.a.a.r.h.b
    public boolean onStateChange(int[] state) {
        if (this.K0) {
            super.onStateChange(state);
        }
        return r1(state, R0());
    }

    public final boolean r1(int[] chipState, int[] closeIconState) {
        boolean invalidate = super.onStateChange(chipState);
        boolean sizeChanged = false;
        ColorStateList colorStateList = this.B;
        int newChipSurfaceColor = l(colorStateList != null ? colorStateList.getColorForState(chipState, this.q0) : 0);
        if (this.q0 != newChipSurfaceColor) {
            this.q0 = newChipSurfaceColor;
            invalidate = true;
        }
        ColorStateList colorStateList2 = this.C;
        int newChipBackgroundColor = l(colorStateList2 != null ? colorStateList2.getColorForState(chipState, this.r0) : 0);
        if (this.r0 != newChipBackgroundColor) {
            this.r0 = newChipBackgroundColor;
            invalidate = true;
        }
        int newCompositeSurfaceBackgroundColor = b.b.a.a.k.a.e(newChipSurfaceColor, newChipBackgroundColor);
        boolean shouldUpdate = this.s0 != newCompositeSurfaceBackgroundColor;
        if (shouldUpdate | (x() == null)) {
            this.s0 = newCompositeSurfaceBackgroundColor;
            V(ColorStateList.valueOf(newCompositeSurfaceBackgroundColor));
            invalidate = true;
        }
        ColorStateList colorStateList3 = this.F;
        int newChipStrokeColor = colorStateList3 != null ? colorStateList3.getColorForState(chipState, this.t0) : 0;
        if (this.t0 != newChipStrokeColor) {
            this.t0 = newChipStrokeColor;
            invalidate = true;
        }
        int newCompatRippleColor = (this.F0 == null || !b.b.a.a.v.b.b(chipState)) ? 0 : this.F0.getColorForState(chipState, this.u0);
        if (this.u0 != newCompatRippleColor) {
            this.u0 = newCompatRippleColor;
            if (this.E0) {
                invalidate = true;
            }
        }
        int newTextColor = (this.p0.d() == null || this.p0.d().f1084a == null) ? 0 : this.p0.d().f1084a.getColorForState(chipState, this.v0);
        if (this.v0 != newTextColor) {
            this.v0 = newTextColor;
            invalidate = true;
        }
        boolean newChecked = i1(getState(), R.attr.state_checked) && this.U;
        if (this.w0 != newChecked && this.W != null) {
            float oldChipIconWidth = i0();
            this.w0 = newChecked;
            float newChipIconWidth = i0();
            invalidate = true;
            if (oldChipIconWidth != newChipIconWidth) {
                sizeChanged = true;
            }
        }
        ColorStateList colorStateList4 = this.B0;
        int newTint = colorStateList4 != null ? colorStateList4.getColorForState(chipState, this.x0) : 0;
        if (this.x0 != newTint) {
            this.x0 = newTint;
            this.A0 = b.b.a.a.n.a.a(this, this.B0, this.C0);
            invalidate = true;
        }
        if (n1(this.K)) {
            invalidate |= this.K.setState(chipState);
        }
        if (n1(this.W)) {
            invalidate |= this.W.setState(chipState);
        }
        if (n1(this.P)) {
            int[] closeIconMergedState = new int[chipState.length + closeIconState.length];
            System.arraycopy(chipState, 0, closeIconMergedState, 0, chipState.length);
            System.arraycopy(closeIconState, 0, closeIconMergedState, chipState.length, closeIconState.length);
            invalidate |= this.P.setState(closeIconMergedState);
        }
        if (b.b.a.a.v.b.f1093a && n1(this.Q)) {
            invalidate |= this.Q.setState(closeIconState);
        }
        if (invalidate) {
            invalidateSelf();
        }
        if (sizeChanged) {
            q1();
        }
        return invalidate;
    }

    public static boolean m1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean n1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static boolean o1(d textAppearance) {
        ColorStateList colorStateList;
        return (textAppearance == null || (colorStateList = textAppearance.f1084a) == null || !colorStateList.isStateful()) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int layoutDirection) {
        boolean invalidate = super.onLayoutDirectionChanged(layoutDirection);
        if (I2()) {
            invalidate |= a.h.d.l.a.m(this.K, layoutDirection);
        }
        if (H2()) {
            invalidate |= a.h.d.l.a.m(this.W, layoutDirection);
        }
        if (J2()) {
            invalidate |= a.h.d.l.a.m(this.P, layoutDirection);
        }
        if (invalidate) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        boolean invalidate = super.onLevelChange(level);
        if (I2()) {
            invalidate |= this.K.setLevel(level);
        }
        if (H2()) {
            invalidate |= this.W.setLevel(level);
        }
        if (J2()) {
            invalidate |= this.P.setLevel(level);
        }
        if (invalidate) {
            invalidateSelf();
        }
        return invalidate;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean invalidate = super.setVisible(visible, restart);
        if (I2()) {
            invalidate |= this.K.setVisible(visible, restart);
        }
        if (H2()) {
            invalidate |= this.W.setVisible(visible, restart);
        }
        if (J2()) {
            invalidate |= this.P.setVisible(visible, restart);
        }
        if (invalidate) {
            invalidateSelf();
        }
        return invalidate;
    }

    @Override // b.b.a.a.x.g, android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (this.y0 != alpha) {
            this.y0 = alpha;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.y0;
    }

    @Override // b.b.a.a.x.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.z0 != colorFilter) {
            this.z0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.z0;
    }

    @Override // b.b.a.a.x.g, android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintList(ColorStateList tint) {
        if (this.B0 != tint) {
            this.B0 = tint;
            onStateChange(getState());
        }
    }

    @Override // b.b.a.a.x.g, android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintMode(PorterDuff.Mode tintMode) {
        if (this.C0 != tintMode) {
            this.C0 = tintMode;
            this.A0 = b.b.a.a.n.a.a(this, this.B0, tintMode);
            invalidateSelf();
        }
    }

    @Override // b.b.a.a.x.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // b.b.a.a.x.g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.K0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.E);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.E);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    public final void K2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final void g0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        a.h.d.l.a.m(drawable, a.h.d.l.a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.P) {
            if (drawable.isStateful()) {
                drawable.setState(R0());
            }
            a.h.d.l.a.o(drawable, this.R);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.K;
        if (drawable == drawable2 && this.N) {
            a.h.d.l.a.o(drawable2, this.L);
        }
    }

    public final ColorFilter g1() {
        ColorFilter colorFilter = this.z0;
        return colorFilter != null ? colorFilter : this.A0;
    }

    public final void L2() {
        this.F0 = this.E0 ? b.b.a.a.v.b.a(this.H) : null;
    }

    public final void W1(ColorStateList chipSurfaceColor) {
        if (this.B != chipSurfaceColor) {
            this.B = chipSurfaceColor;
            onStateChange(getState());
        }
    }

    public static boolean i1(int[] stateSet, int state) {
        if (stateSet == null) {
            return false;
        }
        for (int s : stateSet) {
            if (s == state) {
                return true;
            }
        }
        return false;
    }

    public ColorStateList C0() {
        return this.C;
    }

    public void B1(int id) {
        A1(a.b.c.a.a.c(this.i0, id));
    }

    public void A1(ColorStateList chipBackgroundColor) {
        if (this.C != chipBackgroundColor) {
            this.C = chipBackgroundColor;
            onStateChange(getState());
        }
    }

    public float I0() {
        return this.D;
    }

    public void P1(int id) {
        O1(this.i0.getResources().getDimension(id));
    }

    public void O1(float chipMinHeight) {
        if (this.D != chipMinHeight) {
            this.D = chipMinHeight;
            invalidateSelf();
            q1();
        }
    }

    public float D0() {
        return this.K0 ? E() : this.E;
    }

    @Deprecated
    public void D1(int id) {
        C1(this.i0.getResources().getDimension(id));
    }

    @Deprecated
    public void C1(float chipCornerRadius) {
        if (this.E != chipCornerRadius) {
            this.E = chipCornerRadius;
            setShapeAppearanceModel(B().w(chipCornerRadius));
        }
    }

    public ColorStateList K0() {
        return this.F;
    }

    public void T1(int id) {
        S1(a.b.c.a.a.c(this.i0, id));
    }

    public void S1(ColorStateList chipStrokeColor) {
        if (this.F != chipStrokeColor) {
            this.F = chipStrokeColor;
            if (this.K0) {
                b0(chipStrokeColor);
            }
            onStateChange(getState());
        }
    }

    public float L0() {
        return this.G;
    }

    public void V1(int id) {
        U1(this.i0.getResources().getDimension(id));
    }

    public void U1(float chipStrokeWidth) {
        if (this.G != chipStrokeWidth) {
            this.G = chipStrokeWidth;
            this.j0.setStrokeWidth(chipStrokeWidth);
            if (this.K0) {
                c0(chipStrokeWidth);
            }
            invalidateSelf();
        }
    }

    public ColorStateList a1() {
        return this.H;
    }

    public void u2(int id) {
        t2(a.b.c.a.a.c(this.i0, id));
    }

    public void t2(ColorStateList rippleColor) {
        if (this.H != rippleColor) {
            this.H = rippleColor;
            L2();
            onStateChange(getState());
        }
    }

    public CharSequence c1() {
        return this.I;
    }

    public void y2(CharSequence text) {
        if (text == null) {
            text = BuildConfig.FLAVOR;
        }
        if (!TextUtils.equals(this.I, text)) {
            this.I = text;
            this.p0.i(true);
            invalidateSelf();
            q1();
        }
    }

    public d d1() {
        return this.p0.d();
    }

    public void A2(int id) {
        z2(new d(this.i0, id));
    }

    public void z2(d textAppearance) {
        this.p0.h(textAppearance, this.i0);
    }

    public TextUtils.TruncateAt W0() {
        return this.H0;
    }

    public void l2(TextUtils.TruncateAt truncateAt) {
        this.H0 = truncateAt;
    }

    public void M1(int id) {
        N1(this.i0.getResources().getBoolean(id));
    }

    public void N1(boolean chipIconVisible) {
        if (this.J != chipIconVisible) {
            boolean oldShowsChipIcon = I2();
            this.J = chipIconVisible;
            boolean newShowsChipIcon = I2();
            boolean changed = oldShowsChipIcon != newShowsChipIcon;
            if (changed) {
                if (newShowsChipIcon) {
                    g0(this.K);
                } else {
                    K2(this.K);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public Drawable F0() {
        Drawable drawable = this.K;
        if (drawable != null) {
            return a.h.d.l.a.q(drawable);
        }
        return null;
    }

    public void H1(int id) {
        G1(a.b.c.a.a.d(this.i0, id));
    }

    public void G1(Drawable chipIcon) {
        Drawable oldChipIcon = F0();
        if (oldChipIcon != chipIcon) {
            float oldChipIconWidth = i0();
            this.K = chipIcon != null ? a.h.d.l.a.r(chipIcon).mutate() : null;
            float newChipIconWidth = i0();
            K2(oldChipIcon);
            if (I2()) {
                g0(this.K);
            }
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                q1();
            }
        }
    }

    public ColorStateList H0() {
        return this.L;
    }

    public void L1(int id) {
        K1(a.b.c.a.a.c(this.i0, id));
    }

    public void K1(ColorStateList chipIconTint) {
        this.N = true;
        if (this.L != chipIconTint) {
            this.L = chipIconTint;
            if (I2()) {
                a.h.d.l.a.o(this.K, chipIconTint);
            }
            onStateChange(getState());
        }
    }

    public float G0() {
        return this.M;
    }

    public void J1(int id) {
        I1(this.i0.getResources().getDimension(id));
    }

    public void I1(float chipIconSize) {
        if (this.M != chipIconSize) {
            float oldChipIconWidth = i0();
            this.M = chipIconSize;
            float newChipIconWidth = i0();
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                q1();
            }
        }
    }

    public boolean l1() {
        return this.O;
    }

    public void j2(boolean closeIconVisible) {
        if (this.O != closeIconVisible) {
            boolean oldShowsCloseIcon = J2();
            this.O = closeIconVisible;
            boolean newShowsCloseIcon = J2();
            boolean changed = oldShowsCloseIcon != newShowsCloseIcon;
            if (changed) {
                if (newShowsCloseIcon) {
                    g0(this.P);
                } else {
                    K2(this.P);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public Drawable M0() {
        Drawable drawable = this.P;
        if (drawable != null) {
            return a.h.d.l.a.q(drawable);
        }
        return null;
    }

    public void b2(int id) {
        X1(a.b.c.a.a.d(this.i0, id));
    }

    public void X1(Drawable closeIcon) {
        Drawable oldCloseIcon = M0();
        if (oldCloseIcon != closeIcon) {
            float oldCloseIconWidth = l0();
            this.P = closeIcon != null ? a.h.d.l.a.r(closeIcon).mutate() : null;
            if (b.b.a.a.v.b.f1093a) {
                M2();
            }
            float newCloseIconWidth = l0();
            K2(oldCloseIcon);
            if (J2()) {
                g0(this.P);
            }
            invalidateSelf();
            if (oldCloseIconWidth != newCloseIconWidth) {
                q1();
            }
        }
    }

    @TargetApi(21)
    public final void M2() {
        this.Q = new RippleDrawable(b.b.a.a.v.b.a(a1()), this.P, A);
    }

    public ColorStateList S0() {
        return this.R;
    }

    public void i2(int id) {
        h2(a.b.c.a.a.c(this.i0, id));
    }

    public void h2(ColorStateList closeIconTint) {
        if (this.R != closeIconTint) {
            this.R = closeIconTint;
            if (J2()) {
                a.h.d.l.a.o(this.P, closeIconTint);
            }
            onStateChange(getState());
        }
    }

    public float P0() {
        return this.S;
    }

    public void d2(int id) {
        c2(this.i0.getResources().getDimension(id));
    }

    public void c2(float closeIconSize) {
        if (this.S != closeIconSize) {
            this.S = closeIconSize;
            invalidateSelf();
            if (J2()) {
                q1();
            }
        }
    }

    public void Y1(CharSequence closeIconContentDescription) {
        if (this.T != closeIconContentDescription) {
            this.T = a.h.i.a.c().h(closeIconContentDescription);
            invalidateSelf();
        }
    }

    public CharSequence N0() {
        return this.T;
    }

    public boolean j1() {
        return this.U;
    }

    public void t1(int id) {
        s1(this.i0.getResources().getBoolean(id));
    }

    public void s1(boolean checkable) {
        if (this.U != checkable) {
            this.U = checkable;
            float oldChipIconWidth = i0();
            if (!checkable && this.w0) {
                this.w0 = false;
            }
            float newChipIconWidth = i0();
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                q1();
            }
        }
    }

    public void y1(int id) {
        z1(this.i0.getResources().getBoolean(id));
    }

    public void z1(boolean checkedIconVisible) {
        if (this.V != checkedIconVisible) {
            boolean oldShowsCheckedIcon = H2();
            this.V = checkedIconVisible;
            boolean newShowsCheckedIcon = H2();
            boolean changed = oldShowsCheckedIcon != newShowsCheckedIcon;
            if (changed) {
                if (newShowsCheckedIcon) {
                    g0(this.W);
                } else {
                    K2(this.W);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public Drawable A0() {
        return this.W;
    }

    public void v1(int id) {
        u1(a.b.c.a.a.d(this.i0, id));
    }

    public void u1(Drawable checkedIcon) {
        Drawable oldCheckedIcon = this.W;
        if (oldCheckedIcon != checkedIcon) {
            float oldChipIconWidth = i0();
            this.W = checkedIcon;
            float newChipIconWidth = i0();
            K2(this.W);
            g0(this.W);
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                q1();
            }
        }
    }

    public ColorStateList B0() {
        return this.X;
    }

    public void x1(int id) {
        w1(a.b.c.a.a.c(this.i0, id));
    }

    public void w1(ColorStateList checkedIconTint) {
        if (this.X != checkedIconTint) {
            this.X = checkedIconTint;
            if (p0()) {
                a.h.d.l.a.o(this.W, checkedIconTint);
            }
            onStateChange(getState());
        }
    }

    public b.b.a.a.b.h b1() {
        return this.Y;
    }

    public void x2(int id) {
        w2(b.b.a.a.b.h.c(this.i0, id));
    }

    public void w2(b.b.a.a.b.h showMotionSpec) {
        this.Y = showMotionSpec;
    }

    public b.b.a.a.b.h X0() {
        return this.Z;
    }

    public void n2(int id) {
        m2(b.b.a.a.b.h.c(this.i0, id));
    }

    public void m2(b.b.a.a.b.h hideMotionSpec) {
        this.Z = hideMotionSpec;
    }

    public float J0() {
        return this.a0;
    }

    public void R1(int id) {
        Q1(this.i0.getResources().getDimension(id));
    }

    public void Q1(float chipStartPadding) {
        if (this.a0 != chipStartPadding) {
            this.a0 = chipStartPadding;
            invalidateSelf();
            q1();
        }
    }

    public float Z0() {
        return this.b0;
    }

    public void r2(int id) {
        q2(this.i0.getResources().getDimension(id));
    }

    public void q2(float iconStartPadding) {
        if (this.b0 != iconStartPadding) {
            float oldChipIconWidth = i0();
            this.b0 = iconStartPadding;
            float newChipIconWidth = i0();
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                q1();
            }
        }
    }

    public float Y0() {
        return this.c0;
    }

    public void p2(int id) {
        o2(this.i0.getResources().getDimension(id));
    }

    public void o2(float iconEndPadding) {
        if (this.c0 != iconEndPadding) {
            float oldChipIconWidth = i0();
            this.c0 = iconEndPadding;
            float newChipIconWidth = i0();
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                q1();
            }
        }
    }

    public float f1() {
        return this.d0;
    }

    public void E2(int id) {
        D2(this.i0.getResources().getDimension(id));
    }

    public void D2(float textStartPadding) {
        if (this.d0 != textStartPadding) {
            this.d0 = textStartPadding;
            invalidateSelf();
            q1();
        }
    }

    public float e1() {
        return this.e0;
    }

    public void C2(int id) {
        B2(this.i0.getResources().getDimension(id));
    }

    public void B2(float textEndPadding) {
        if (this.e0 != textEndPadding) {
            this.e0 = textEndPadding;
            invalidateSelf();
            q1();
        }
    }

    public float Q0() {
        return this.f0;
    }

    public void f2(int id) {
        e2(this.i0.getResources().getDimension(id));
    }

    public void e2(float closeIconStartPadding) {
        if (this.f0 != closeIconStartPadding) {
            this.f0 = closeIconStartPadding;
            invalidateSelf();
            if (J2()) {
                q1();
            }
        }
    }

    public float O0() {
        return this.g0;
    }

    public void a2(int id) {
        Z1(this.i0.getResources().getDimension(id));
    }

    public void Z1(float closeIconEndPadding) {
        if (this.g0 != closeIconEndPadding) {
            this.g0 = closeIconEndPadding;
            invalidateSelf();
            if (J2()) {
                q1();
            }
        }
    }

    public float E0() {
        return this.h0;
    }

    public void F1(int id) {
        E1(this.i0.getResources().getDimension(id));
    }

    public void E1(float chipEndPadding) {
        if (this.h0 != chipEndPadding) {
            this.h0 = chipEndPadding;
            invalidateSelf();
            q1();
        }
    }

    public void s2(int maxWidth) {
        this.J0 = maxWidth;
    }

    public boolean G2() {
        return this.I0;
    }

    public void v2(boolean shouldDrawText) {
        this.I0 = shouldDrawText;
    }
}
