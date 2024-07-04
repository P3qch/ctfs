package a.d.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class g extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f235a;

    /* renamed from: b, reason: collision with root package name */
    public float f236b;
    public boolean c;
    public boolean d;
    public ColorStateList e;
    public PorterDuffColorFilter f;
    public ColorStateList g;
    public PorterDuff.Mode h;

    public final void e(ColorStateList color) {
        if (color == null) {
            color = ColorStateList.valueOf(0);
        }
        this.e = color;
        Paint paint = null;
        paint.setColor(color.getColorForState(getState(), this.e.getDefaultColor()));
        throw null;
    }

    public void g(float padding, boolean insetForPadding, boolean insetForRadius) {
        if (padding == this.f236b && this.c == insetForPadding && this.d == insetForRadius) {
            return;
        }
        this.f236b = padding;
        this.c = insetForPadding;
        this.d = insetForRadius;
        i(null);
        throw null;
    }

    public float c() {
        return this.f236b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean clearColorFilter;
        Paint paint = null;
        if (this.f != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.f);
            clearColorFilter = true;
        } else {
            clearColorFilter = false;
        }
        float f = this.f235a;
        canvas.drawRoundRect(null, f, f, null);
        if (clearColorFilter) {
            paint.setColorFilter(null);
        }
    }

    public final void i(Rect bounds) {
        if (bounds == null) {
            bounds = getBounds();
        }
        RectF rectF = null;
        rectF.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        i(bounds);
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(null, this.f235a);
    }

    public void h(float radius) {
        if (radius == this.f235a) {
            return;
        }
        this.f235a = radius;
        i(null);
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Paint paint = null;
        paint.setAlpha(alpha);
        throw null;
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

    public float d() {
        return this.f235a;
    }

    public void f(ColorStateList color) {
        e(color);
        throw null;
    }

    public ColorStateList b() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
        this.g = tint;
        this.f = a(tint, this.h);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode tintMode) {
        this.h = tintMode;
        this.f = a(this.g, tintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        ColorStateList colorStateList = this.e;
        colorStateList.getColorForState(stateSet, colorStateList.getDefaultColor());
        Paint paint = null;
        paint.getColor();
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.g;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.e) != null && colorStateList.isStateful()) || super.isStateful();
    }

    public final PorterDuffColorFilter a(ColorStateList tint, PorterDuff.Mode tintMode) {
        if (tint == null || tintMode == null) {
            return null;
        }
        int color = tint.getColorForState(getState(), 0);
        return new PorterDuffColorFilter(color, tintMode);
    }
}
