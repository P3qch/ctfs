package b.b.a.a.r;

import a.b.g.j0;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;

/* loaded from: classes.dex */
public class d extends j0 {
    public Drawable q;
    public final Rect r;
    public final Rect s;
    public int t;
    public boolean u;
    public boolean v;

    public d(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public d(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.r = new Rect();
        this.s = new Rect();
        this.t = 119;
        this.u = true;
        this.v = false;
        TypedArray a2 = j.h(context, attrs, b.b.a.a.a.j, defStyle, 0, new int[0]);
        int[] iArr = b.b.a.a.a.f942a;
        this.t = a2.getInt(1, this.t);
        Drawable d = a2.getDrawable(0);
        if (d != null) {
            setForeground(d);
        }
        this.u = a2.getBoolean(2, true);
        a2.recycle();
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.t;
    }

    @Override // android.view.View
    public void setForegroundGravity(int foregroundGravity) {
        if (this.t != foregroundGravity) {
            if ((8388615 & foregroundGravity) == 0) {
                foregroundGravity |= 8388611;
            }
            if ((foregroundGravity & 112) == 0) {
                foregroundGravity |= 48;
            }
            this.t = foregroundGravity;
            if (foregroundGravity == 119 && this.q != null) {
                Rect padding = new Rect();
                this.q.getPadding(padding);
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful()) {
            this.q.setState(getDrawableState());
        }
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.q);
            }
            this.q = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.t == 119) {
                    Rect padding = new Rect();
                    drawable.getPadding(padding);
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.q;
    }

    @Override // a.b.g.j0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.v |= changed;
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.v = true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.q != null) {
            Drawable foreground = this.q;
            if (this.v) {
                this.v = false;
                Rect selfBounds = this.r;
                Rect overlayBounds = this.s;
                int w = getRight() - getLeft();
                int h = getBottom() - getTop();
                if (this.u) {
                    selfBounds.set(0, 0, w, h);
                } else {
                    selfBounds.set(getPaddingLeft(), getPaddingTop(), w - getPaddingRight(), h - getPaddingBottom());
                }
                Gravity.apply(this.t, foreground.getIntrinsicWidth(), foreground.getIntrinsicHeight(), selfBounds, overlayBounds);
                foreground.setBounds(overlayBounds);
            }
            foreground.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setHotspot(x, y);
        }
    }
}
