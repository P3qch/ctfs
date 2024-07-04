package b.b.a.a.y;

import a.h.k.v;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import b.b.a.a.r.l;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class d extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public static final View.OnTouchListener f1126b = new a();
    public c c;
    public b d;
    public int e;
    public final float f;
    public final float g;
    public ColorStateList h;
    public PorterDuff.Mode i;

    /* loaded from: classes.dex */
    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    public d(Context context, AttributeSet attrs) {
        super(b.b.a.a.b0.a.a.c(context, attrs, 0, 0), attrs);
        Context context2 = getContext();
        TypedArray a2 = context2.obtainStyledAttributes(attrs, b.b.a.a.a.y);
        int[] iArr = b.b.a.a.a.f942a;
        if (a2.hasValue(6)) {
            v.v0(this, a2.getDimensionPixelSize(6, 0));
        }
        this.e = a2.getInt(2, 0);
        this.f = a2.getFloat(3, 1.0f);
        setBackgroundTintList(b.b.a.a.u.c.a(context2, a2, 4));
        setBackgroundTintMode(l.e(a2.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.g = a2.getFloat(1, 1.0f);
        a2.recycle();
        setOnTouchListener(f1126b);
        setFocusable(true);
        if (getBackground() == null) {
            v.r0(this, a());
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.h != null) {
            drawable = a.h.d.l.a.r(drawable.mutate());
            a.h.d.l.a.o(drawable, this.h);
            a.h.d.l.a.p(drawable, this.i);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList backgroundTint) {
        this.h = backgroundTint;
        if (getBackground() != null) {
            Drawable wrappedBackground = a.h.d.l.a.r(getBackground().mutate());
            a.h.d.l.a.o(wrappedBackground, backgroundTint);
            a.h.d.l.a.p(wrappedBackground, this.i);
            if (wrappedBackground != getBackground()) {
                super.setBackgroundDrawable(wrappedBackground);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode backgroundTintMode) {
        this.i = backgroundTintMode;
        if (getBackground() != null) {
            Drawable wrappedBackground = a.h.d.l.a.r(getBackground().mutate());
            a.h.d.l.a.p(wrappedBackground, backgroundTintMode);
            if (wrappedBackground != getBackground()) {
                super.setBackgroundDrawable(wrappedBackground);
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f1126b);
        super.setOnClickListener(onClickListener);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(this, l, t, r, b2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        v.l0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
    }

    public void setOnLayoutChangeListener(c onLayoutChangeListener) {
        this.c = onLayoutChangeListener;
    }

    public void setOnAttachStateChangeListener(b listener) {
        this.d = listener;
    }

    public int getAnimationMode() {
        return this.e;
    }

    public void setAnimationMode(int animationMode) {
        this.e = animationMode;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f;
    }

    public float getActionTextColorAlpha() {
        return this.g;
    }

    public final Drawable a() {
        float cornerRadius = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable background = new GradientDrawable();
        background.setShape(0);
        background.setCornerRadius(cornerRadius);
        int backgroundColor = b.b.a.a.k.a.g(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha());
        background.setColor(backgroundColor);
        if (this.h != null) {
            Drawable wrappedDrawable = a.h.d.l.a.r(background);
            a.h.d.l.a.o(wrappedDrawable, this.h);
            return wrappedDrawable;
        }
        return a.h.d.l.a.r(background);
    }
}
