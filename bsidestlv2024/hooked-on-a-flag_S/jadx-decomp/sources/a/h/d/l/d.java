package a.h.d.l;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class d extends Drawable implements Drawable.Callback, c, b {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f377b = PorterDuff.Mode.SRC_IN;
    public int c;
    public PorterDuff.Mode d;
    public boolean e;
    public f f;
    public boolean g;
    public Drawable h;

    public d(f state, Resources res) {
        this.f = state;
        e(res);
    }

    public d(Drawable dr) {
        this.f = d();
        b(dr);
    }

    public final void e(Resources res) {
        Drawable.ConstantState constantState;
        f fVar = this.f;
        if (fVar != null && (constantState = fVar.f379b) != null) {
            b(constantState.newDrawable(res));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.h.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.h.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int configs) {
        this.h.setChangingConfigurations(configs);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.h.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean dither) {
        this.h.setDither(dither);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filter) {
        this.h.setFilterBitmap(filter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.h.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.h.setColorFilter(cf);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList tintList;
        f fVar;
        if (c() && (fVar = this.f) != null) {
            tintList = fVar.c;
        } else {
            tintList = null;
        }
        return (tintList != null && tintList.isStateful()) || this.h.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] stateSet) {
        boolean handled = this.h.setState(stateSet);
        boolean handled2 = f(stateSet) || handled;
        return handled2;
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.h.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.h.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        return super.setVisible(visible, restart) || this.h.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.h.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.h.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.h.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.h.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.h.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.h.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        return this.h.getPadding(padding);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        a.j(this.h, mirrored);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.h(this.h);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int layoutDirection) {
        return a.m(this.h, layoutDirection);
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.f(this.h);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        f fVar = this.f;
        if (fVar != null && fVar.a()) {
            this.f.f378a = getChangingConfigurations();
            return this.f;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.g && super.mutate() == this) {
            this.f = d();
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f;
            if (fVar != null) {
                Drawable drawable2 = this.h;
                fVar.f379b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.g = true;
        }
        return this;
    }

    public final f d() {
        return new f(this.f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        scheduleSelf(what, when);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        unscheduleSelf(what);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        return this.h.setLevel(level);
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTint(int tint) {
        setTintList(ColorStateList.valueOf(tint));
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintList(ColorStateList tint) {
        this.f.c = tint;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintMode(PorterDuff.Mode tintMode) {
        this.f.d = tintMode;
        f(getState());
    }

    public final boolean f(int[] state) {
        if (!c()) {
            return false;
        }
        f fVar = this.f;
        ColorStateList tintList = fVar.c;
        PorterDuff.Mode tintMode = fVar.d;
        if (tintList != null && tintMode != null) {
            int color = tintList.getColorForState(state, tintList.getDefaultColor());
            if (!this.e || color != this.c || tintMode != this.d) {
                setColorFilter(color, tintMode);
                this.c = color;
                this.d = tintMode;
                this.e = true;
                return true;
            }
        } else {
            this.e = false;
            clearColorFilter();
        }
        return false;
    }

    @Override // a.h.d.l.c
    public final Drawable a() {
        return this.h;
    }

    @Override // a.h.d.l.c
    public final void b(Drawable dr) {
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.h = dr;
        if (dr != null) {
            dr.setCallback(this);
            setVisible(dr.isVisible(), true);
            setState(dr.getState());
            setLevel(dr.getLevel());
            setBounds(dr.getBounds());
            f fVar = this.f;
            if (fVar != null) {
                fVar.f379b = dr.getConstantState();
            }
        }
        invalidateSelf();
    }

    public boolean c() {
        return true;
    }
}
