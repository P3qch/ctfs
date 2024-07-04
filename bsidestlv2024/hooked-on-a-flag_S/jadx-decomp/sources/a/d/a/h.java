package a.d.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class h extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public static final double f237a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b, reason: collision with root package name */
    public static a f238b;
    public float c;
    public float d;
    public float e;
    public float f;
    public ColorStateList g;
    public boolean h;
    public boolean i;
    public boolean j;

    /* loaded from: classes.dex */
    public interface a {
    }

    public final void m(ColorStateList color) {
        if (color == null) {
            color = ColorStateList.valueOf(0);
        }
        this.g = color;
        Paint paint = null;
        paint.setColor(color.getColorForState(getState(), this.g.getDefaultColor()));
        throw null;
    }

    public final int s(float value) {
        int i = (int) (0.5f + value);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    public void l(boolean addPaddingForCorners) {
        this.i = addPaddingForCorners;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Paint paint = null;
        paint.setAlpha(alpha);
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.h = true;
    }

    public final void r(float shadowSize, float maxShadowSize) {
        if (shadowSize < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + shadowSize + ". Must be >= 0");
        }
        if (maxShadowSize < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + maxShadowSize + ". Must be >= 0");
        }
        float shadowSize2 = s(shadowSize);
        float maxShadowSize2 = s(maxShadowSize);
        if (shadowSize2 > maxShadowSize2) {
            shadowSize2 = maxShadowSize2;
            if (!this.j) {
                this.j = true;
            }
        }
        if (this.f == shadowSize2 && this.d == maxShadowSize2) {
            return;
        }
        this.f = shadowSize2;
        this.d = maxShadowSize2;
        this.e = (int) ((1.5f * shadowSize2) + 0 + 0.5f);
        this.h = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        int vOffset = (int) Math.ceil(c(this.d, this.c, this.i));
        int hOffset = (int) Math.ceil(b(this.d, this.c, this.i));
        padding.set(hOffset, vOffset, hOffset, vOffset);
        return true;
    }

    public static float c(float maxShadowSize, float cornerRadius, boolean addPaddingForCorners) {
        if (addPaddingForCorners) {
            double d = 1.5f * maxShadowSize;
            double d2 = 1.0d - f237a;
            double d3 = cornerRadius;
            Double.isNaN(d3);
            Double.isNaN(d);
            return (float) (d + (d2 * d3));
        }
        return 1.5f * maxShadowSize;
    }

    public static float b(float maxShadowSize, float cornerRadius, boolean addPaddingForCorners) {
        if (addPaddingForCorners) {
            double d = maxShadowSize;
            double d2 = 1.0d - f237a;
            double d3 = cornerRadius;
            Double.isNaN(d3);
            Double.isNaN(d);
            return (float) (d + (d2 * d3));
        }
        return maxShadowSize;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        ColorStateList colorStateList = this.g;
        colorStateList.getColorForState(stateSet, colorStateList.getDefaultColor());
        Paint paint = null;
        paint.getColor();
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.g;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        Paint paint = null;
        paint.setColorFilter(cf);
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void o(float radius) {
        if (radius < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + radius + ". Must be >= 0");
        }
        float radius2 = (int) (0.5f + radius);
        if (this.c == radius2) {
            return;
        }
        this.c = radius2;
        this.h = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.h) {
            a(getBounds());
            throw null;
        }
        canvas.translate(0.0f, this.f / 2.0f);
        d(canvas);
        throw null;
    }

    public final void d(Canvas canvas) {
        RectF rectF = null;
        rectF.width();
        throw null;
    }

    public final void a(Rect bounds) {
        float f = this.d;
        float verticalOffset = 1.5f * f;
        RectF rectF = null;
        rectF.set(bounds.left + f, bounds.top + verticalOffset, bounds.right - f, bounds.bottom - verticalOffset);
        throw null;
    }

    public float f() {
        return this.c;
    }

    public void g(Rect into) {
        getPadding(into);
    }

    public void q(float size) {
        r(size, this.d);
    }

    public void p(float size) {
        r(this.f, size);
    }

    public float k() {
        return this.f;
    }

    public float h() {
        return this.d;
    }

    public float j() {
        float f = this.d;
        float f2 = 0;
        float content = Math.max(f, this.c + f2 + (f / 2.0f)) * 2.0f;
        return ((this.d + f2) * 2.0f) + content;
    }

    public float i() {
        float f = this.d;
        float f2 = 0;
        float content = Math.max(f, this.c + f2 + ((f * 1.5f) / 2.0f)) * 2.0f;
        return (((this.d * 1.5f) + f2) * 2.0f) + content;
    }

    public void n(ColorStateList color) {
        m(color);
        throw null;
    }

    public ColorStateList e() {
        return this.g;
    }
}
