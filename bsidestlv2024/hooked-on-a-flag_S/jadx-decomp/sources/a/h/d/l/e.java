package a.h.d.l;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class e extends d {
    public static Method i;

    public e(Drawable drawable) {
        super(drawable);
        g();
    }

    public e(f state, Resources resources) {
        super(state, resources);
        g();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float x, float y) {
        this.h.setHotspot(x, y);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        this.h.setHotspotBounds(left, top, right, bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.h.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.h.getDirtyBounds();
    }

    @Override // a.h.d.l.d, android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintList(ColorStateList tint) {
        if (c()) {
            super.setTintList(tint);
        } else {
            this.h.setTintList(tint);
        }
    }

    @Override // a.h.d.l.d, android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTint(int tintColor) {
        if (c()) {
            super.setTint(tintColor);
        } else {
            this.h.setTint(tintColor);
        }
    }

    @Override // a.h.d.l.d, android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintMode(PorterDuff.Mode tintMode) {
        if (c()) {
            super.setTintMode(tintMode);
        } else {
            this.h.setTintMode(tintMode);
        }
    }

    @Override // a.h.d.l.d, android.graphics.drawable.Drawable
    public boolean setState(int[] stateSet) {
        if (super.setState(stateSet)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // a.h.d.l.d
    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.h;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.h;
        if (drawable != null && (method = i) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception ex) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", ex);
            }
        }
        return false;
    }

    public final void g() {
        if (i == null) {
            try {
                i = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception ex) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", ex);
            }
        }
    }
}
