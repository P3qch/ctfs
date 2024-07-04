package b.b.a.a.r;

import a.h.i.e;
import a.h.k.v;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import b.b.a.a.r.g;
import b.b.a.a.u.a;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f1059a;

    /* renamed from: b, reason: collision with root package name */
    public static final Paint f1060b;
    public CharSequence A;
    public boolean B;
    public boolean D;
    public Bitmap E;
    public Paint F;
    public float G;
    public float H;
    public int[] I;
    public boolean J;
    public final TextPaint K;
    public final TextPaint L;
    public TimeInterpolator M;
    public TimeInterpolator N;
    public float O;
    public float P;
    public float Q;
    public ColorStateList R;
    public float S;
    public StaticLayout T;
    public float U;
    public float V;
    public float W;
    public CharSequence X;
    public final View c;
    public boolean d;
    public float e;
    public float f;
    public final Rect g;
    public final Rect h;
    public final RectF i;
    public ColorStateList n;
    public ColorStateList o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public Typeface v;
    public Typeface w;
    public Typeface x;
    public b.b.a.a.u.a y;
    public CharSequence z;
    public int j = 16;
    public int k = 16;
    public float l = 15.0f;
    public float m = 15.0f;
    public boolean C = true;
    public int Y = 1;
    public float Z = 0.0f;
    public float a0 = 1.0f;
    public int b0 = g.f1070a;

    static {
        f1059a = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        f1060b = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            paint.setColor(-65281);
        }
    }

    public a(View view) {
        this.c = view;
        TextPaint textPaint = new TextPaint(129);
        this.K = textPaint;
        this.L = new TextPaint(textPaint);
        this.h = new Rect();
        this.g = new Rect();
        this.i = new RectF();
        e();
        this.f = 0.5f;
    }

    public void d0(TimeInterpolator interpolator) {
        this.N = interpolator;
        G();
    }

    public void a0(TimeInterpolator interpolator) {
        this.M = interpolator;
        G();
    }

    public void W(float textSize) {
        if (this.l != textSize) {
            this.l = textSize;
            G();
        }
    }

    public void N(ColorStateList textColor) {
        if (this.o != textColor) {
            this.o = textColor;
            G();
        }
    }

    public void U(ColorStateList textColor) {
        if (this.n != textColor) {
            this.n = textColor;
            G();
        }
    }

    public void R(int left, int top, int right, int bottom) {
        if (!I(this.g, left, top, right, bottom)) {
            this.g.set(left, top, right, bottom);
            this.J = true;
            F();
        }
    }

    public void S(Rect bounds) {
        R(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    public void J(int left, int top, int right, int bottom) {
        if (!I(this.h, left, top, right, bottom)) {
            this.h.set(left, top, right, bottom);
            this.J = true;
            F();
        }
    }

    public void K(Rect bounds) {
        J(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    public void n(RectF bounds, int labelWidth, int textGravity) {
        this.B = f(this.z);
        bounds.left = q(labelWidth, textGravity);
        bounds.top = this.h.top;
        bounds.right = r(bounds, labelWidth, textGravity);
        bounds.bottom = this.h.top + p();
    }

    public final float q(int width, int gravity) {
        if (gravity == 17 || (gravity & 7) == 1) {
            return (width / 2.0f) - (c() / 2.0f);
        }
        return ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) ? this.B ? this.h.left : this.h.right - c() : this.B ? this.h.right - c() : this.h.left;
    }

    public final float r(RectF bounds, int width, int gravity) {
        if (gravity == 17 || (gravity & 7) == 1) {
            return (width / 2.0f) + (c() / 2.0f);
        }
        return ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) ? this.B ? bounds.left + c() : this.h.right : this.B ? this.h.right : bounds.left + c();
    }

    public float c() {
        if (this.z == null) {
            return 0.0f;
        }
        x(this.L);
        TextPaint textPaint = this.L;
        CharSequence charSequence = this.z;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public float v() {
        y(this.L);
        return -this.L.ascent();
    }

    public float p() {
        x(this.L);
        return -this.L.ascent();
    }

    public final float e() {
        return 0.5f;
    }

    public final void y(TextPaint textPaint) {
        textPaint.setTextSize(this.l);
        textPaint.setTypeface(this.w);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(0.0f);
        }
    }

    public final void x(TextPaint textPaint) {
        textPaint.setTextSize(this.m);
        textPaint.setTypeface(this.v);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.S);
        }
    }

    public void F() {
        this.d = this.h.width() > 0 && this.h.height() > 0 && this.g.width() > 0 && this.g.height() > 0;
    }

    public void V(int gravity) {
        if (this.j != gravity) {
            this.j = gravity;
            G();
        }
    }

    public void O(int gravity) {
        if (this.k != gravity) {
            this.k = gravity;
            G();
        }
    }

    public void L(int resId) {
        b.b.a.a.u.d textAppearance = new b.b.a.a.u.d(this.c.getContext(), resId);
        ColorStateList colorStateList = textAppearance.f1084a;
        if (colorStateList != null) {
            this.o = colorStateList;
        }
        float f = textAppearance.k;
        if (f != 0.0f) {
            this.m = f;
        }
        ColorStateList colorStateList2 = textAppearance.f1085b;
        if (colorStateList2 != null) {
            this.R = colorStateList2;
        }
        this.P = textAppearance.f;
        this.Q = textAppearance.g;
        this.O = textAppearance.h;
        this.S = textAppearance.j;
        b.b.a.a.u.a aVar = this.y;
        if (aVar != null) {
            aVar.c();
        }
        this.y = new b.b.a.a.u.a(new C0071a(), textAppearance.e());
        textAppearance.h(this.c.getContext(), this.y);
        G();
    }

    /* renamed from: b.b.a.a.r.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0071a implements a.InterfaceC0072a {
        public C0071a() {
        }

        public void a(Typeface font) {
            a.this.P(font);
        }
    }

    public void P(Typeface typeface) {
        if (Q(typeface)) {
            G();
        }
    }

    public void e0(Typeface typeface) {
        boolean collapsedFontChanged = Q(typeface);
        boolean expandedFontChanged = X(typeface);
        if (collapsedFontChanged || expandedFontChanged) {
            G();
        }
    }

    public final boolean Q(Typeface typeface) {
        b.b.a.a.u.a aVar = this.y;
        if (aVar != null) {
            aVar.c();
        }
        if (this.v != typeface) {
            this.v = typeface;
            return true;
        }
        return false;
    }

    public final boolean X(Typeface typeface) {
        if (this.w != typeface) {
            this.w = typeface;
            return true;
        }
        return false;
    }

    public void Y(float fraction) {
        float fraction2 = a.h.f.a.a(fraction, 0.0f, 1.0f);
        if (fraction2 != this.e) {
            this.e = fraction2;
            d();
        }
    }

    public final boolean b0(int[] state) {
        this.I = state;
        if (C()) {
            G();
            return true;
        }
        return false;
    }

    public final boolean C() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.o;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.n) != null && colorStateList.isStateful());
    }

    public float w() {
        return this.e;
    }

    public final void d() {
        g(this.e);
    }

    public final void g(float fraction) {
        z(fraction);
        this.t = E(this.r, this.s, fraction, this.M);
        this.u = E(this.p, this.q, fraction, this.M);
        Z(E(this.l, this.m, fraction, this.N));
        TimeInterpolator timeInterpolator = b.b.a.a.b.a.f978b;
        M(1.0f - E(0.0f, 1.0f, 1.0f - fraction, timeInterpolator));
        T(E(1.0f, 0.0f, fraction, timeInterpolator));
        if (this.o != this.n) {
            this.K.setColor(a(u(), s(), fraction));
        } else {
            this.K.setColor(s());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f = this.S;
            if (f != 0.0f) {
                this.K.setLetterSpacing(E(0.0f, f, fraction, timeInterpolator));
            } else {
                this.K.setLetterSpacing(f);
            }
        }
        this.K.setShadowLayer(E(0.0f, this.O, fraction, null), E(0.0f, this.P, fraction, null), E(0.0f, this.Q, fraction, null), a(t(null), t(this.R), fraction));
        v.f0(this.c);
    }

    public final int u() {
        return t(this.n);
    }

    public int s() {
        return t(this.o);
    }

    public final int t(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.I;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public final void b(boolean z) {
        StaticLayout staticLayout;
        float f = this.H;
        i(this.m, z);
        CharSequence charSequence = this.A;
        if (charSequence != null && (staticLayout = this.T) != null) {
            this.X = TextUtils.ellipsize(charSequence, this.K, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.X;
        float measureText = charSequence2 != null ? this.K.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int b2 = a.h.k.e.b(this.k, this.B ? 1 : 0);
        switch (b2 & 112) {
            case 48:
                this.q = this.h.top;
                break;
            case 80:
                this.q = this.h.bottom + this.K.ascent();
                break;
            default:
                this.q = this.h.centerY() - ((this.K.descent() - this.K.ascent()) / 2.0f);
                break;
        }
        switch (b2 & 8388615) {
            case 1:
                this.s = this.h.centerX() - (measureText / 2.0f);
                break;
            case 5:
                this.s = this.h.right - measureText;
                break;
            default:
                this.s = this.h.left;
                break;
        }
        i(this.l, z);
        float height = this.T != null ? r7.getHeight() : 0.0f;
        CharSequence charSequence3 = this.A;
        float measureText2 = charSequence3 != null ? this.K.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout2 = this.T;
        if (staticLayout2 != null) {
        }
        float f2 = measureText2;
        this.W = staticLayout2 != null ? staticLayout2.getLineLeft(0) : 0.0f;
        int b3 = a.h.k.e.b(this.j, this.B ? 1 : 0);
        switch (b3 & 112) {
            case 48:
                this.p = this.g.top;
                break;
            case 80:
                this.p = (this.g.bottom - height) + this.K.descent();
                break;
            default:
                this.p = this.g.centerY() - (height / 2.0f);
                break;
        }
        switch (b3 & 8388615) {
            case 1:
                this.r = this.g.centerX() - (f2 / 2.0f);
                break;
            case 5:
                this.r = this.g.right - f2;
                break;
            default:
                this.r = this.g.left;
                break;
        }
        j();
        Z(f);
    }

    public final void z(float fraction) {
        this.i.left = E(this.g.left, this.h.left, fraction, this.M);
        this.i.top = E(this.p, this.q, fraction, this.M);
        this.i.right = E(this.g.right, this.h.right, fraction, this.M);
        this.i.bottom = E(this.g.bottom, this.h.bottom, fraction, this.M);
    }

    public final void M(float blend) {
        this.U = blend;
        v.f0(this.c);
    }

    public final void T(float blend) {
        this.V = blend;
        v.f0(this.c);
    }

    public void l(Canvas canvas) {
        int saveCount = canvas.save();
        if (this.A != null && this.d) {
            boolean drawTexture = false;
            float firstLineX = this.T.getLineLeft(0);
            float f = (this.t + firstLineX) - (this.W * 2.0f);
            this.K.setTextSize(this.H);
            float x = this.t;
            float y = this.u;
            if (this.D && this.E != null) {
                drawTexture = true;
            }
            float f2 = this.G;
            if (f2 != 1.0f) {
                canvas.scale(f2, f2, x, y);
            }
            if (drawTexture) {
                canvas.drawBitmap(this.E, x, y, this.F);
                canvas.restoreToCount(saveCount);
            } else {
                f0();
                canvas.translate(x, y);
                this.T.draw(canvas);
                canvas.restoreToCount(saveCount);
            }
        }
    }

    public final boolean f0() {
        return false;
    }

    public final boolean f(CharSequence text) {
        boolean defaultIsRtl = B();
        return D(text, defaultIsRtl);
    }

    public final boolean B() {
        return v.C(this.c) == 1;
    }

    public final boolean D(CharSequence text, boolean defaultIsRtl) {
        return ((e.d) (defaultIsRtl ? a.h.i.e.d : a.h.i.e.c)).c(text, 0, text.length());
    }

    public final void Z(float textSize) {
        h(textSize);
        boolean z = f1059a && this.G != 1.0f;
        this.D = z;
        if (z) {
            m();
        }
        v.f0(this.c);
    }

    public final void h(float textSize) {
        i(textSize, false);
    }

    public final void i(float textSize, boolean forceRecalculate) {
        float newTextSize;
        float textSizeRatio;
        if (this.z == null) {
            return;
        }
        float collapsedWidth = this.h.width();
        float expandedWidth = this.g.width();
        boolean updateDrawText = false;
        if (A(textSize, this.m)) {
            newTextSize = this.m;
            this.G = 1.0f;
            Typeface typeface = this.x;
            Typeface typeface2 = this.v;
            if (typeface != typeface2) {
                this.x = typeface2;
                updateDrawText = true;
            }
            textSizeRatio = collapsedWidth;
        } else {
            newTextSize = this.l;
            Typeface typeface3 = this.x;
            Typeface typeface4 = this.w;
            if (typeface3 != typeface4) {
                this.x = typeface4;
                updateDrawText = true;
            }
            if (A(textSize, this.l)) {
                this.G = 1.0f;
            } else {
                this.G = textSize / this.l;
            }
            float textSizeRatio2 = this.m / this.l;
            float scaledDownWidth = expandedWidth * textSizeRatio2;
            if (forceRecalculate) {
                textSizeRatio = expandedWidth;
            } else {
                textSizeRatio = scaledDownWidth > collapsedWidth ? Math.min(collapsedWidth / textSizeRatio2, expandedWidth) : expandedWidth;
            }
        }
        if (textSizeRatio > 0.0f) {
            updateDrawText = this.H != newTextSize || this.J || updateDrawText;
            this.H = newTextSize;
            this.J = false;
        }
        if (this.A == null || updateDrawText) {
            this.K.setTextSize(this.H);
            this.K.setTypeface(this.x);
            this.K.setLinearText(this.G != 1.0f);
            this.B = f(this.z);
            f0();
            StaticLayout k = k(1, textSizeRatio, this.B);
            this.T = k;
            this.A = k.getText();
        }
    }

    public final StaticLayout k(int maxLines, float availableWidth, boolean isRtl) {
        StaticLayout textLayout = null;
        try {
            g c = g.c(this.z, this.K, (int) availableWidth);
            c.e(TextUtils.TruncateAt.END);
            c.h(isRtl);
            c.d(Layout.Alignment.ALIGN_NORMAL);
            c.g(false);
            c.j(maxLines);
            c.i(0.0f, 1.0f);
            c.f(this.b0);
            textLayout = c.a();
        } catch (g.a e) {
            Log.e("CollapsingTextHelper", e.getCause().getMessage(), e);
        }
        a.h.j.i.e(textLayout);
        return textLayout;
    }

    public final void m() {
        if (this.E != null || this.g.isEmpty() || TextUtils.isEmpty(this.A)) {
            return;
        }
        g(0.0f);
        int width = this.T.getWidth();
        int height = this.T.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.E = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(this.E);
        this.T.draw(c);
        if (this.F == null) {
            this.F = new Paint(3);
        }
    }

    public void G() {
        H(false);
    }

    public void H(boolean forceRecalculate) {
        if ((this.c.getHeight() > 0 && this.c.getWidth() > 0) || forceRecalculate) {
            b(forceRecalculate);
            d();
        }
    }

    public void c0(CharSequence text) {
        if (text == null || !TextUtils.equals(this.z, text)) {
            this.z = text;
            this.A = null;
            j();
            G();
        }
    }

    public final void j() {
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            bitmap.recycle();
            this.E = null;
        }
    }

    public static boolean A(float value, float targetValue) {
        return Math.abs(value - targetValue) < 0.001f;
    }

    public ColorStateList o() {
        return this.o;
    }

    public static int a(int color1, int color2, float ratio) {
        float inverseRatio = 1.0f - ratio;
        float a2 = (Color.alpha(color1) * inverseRatio) + (Color.alpha(color2) * ratio);
        float r = (Color.red(color1) * inverseRatio) + (Color.red(color2) * ratio);
        float g = (Color.green(color1) * inverseRatio) + (Color.green(color2) * ratio);
        float b2 = (Color.blue(color1) * inverseRatio) + (Color.blue(color2) * ratio);
        return Color.argb((int) a2, (int) r, (int) g, (int) b2);
    }

    public static float E(float startValue, float endValue, float fraction, TimeInterpolator interpolator) {
        if (interpolator != null) {
            fraction = interpolator.getInterpolation(fraction);
        }
        return b.b.a.a.b.a.a(startValue, endValue, fraction);
    }

    public static boolean I(Rect r, int left, int top, int right, int bottom) {
        return r.left == left && r.top == top && r.right == right && r.bottom == bottom;
    }
}
