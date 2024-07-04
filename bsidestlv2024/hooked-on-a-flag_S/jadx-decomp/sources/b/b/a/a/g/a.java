package b.b.a.a.g;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import b.b.a.a.x.k;
import b.b.a.a.x.n;

/* loaded from: classes.dex */
public class a extends a.d.a.a implements Checkable, n {
    public static final int[] e = {R.attr.state_checkable};
    public static final int[] f = {R.attr.state_checked};
    public static final int[] g = {net.sqlcipher.R.attr.state_dragged};
    public boolean h;
    public InterfaceC0064a i;

    /* renamed from: b.b.a.a.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0064a {
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("androidx.cardview.widget.CardView");
        e();
        info.setCheckable(false);
        info.setClickable(isClickable());
        isChecked();
        info.setChecked(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        isChecked();
        accessibilityEvent.setChecked(false);
    }

    @Override // a.d.a.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureSpec2 = getMeasuredWidth();
        b bVar = null;
        bVar.q(widthMeasureSpec2, getMeasuredHeight());
        throw null;
    }

    public void setStrokeColor(int strokeColor) {
        b bVar = null;
        bVar.C(ColorStateList.valueOf(strokeColor));
        throw null;
    }

    public void setStrokeColor(ColorStateList strokeColor) {
        b bVar = null;
        bVar.C(strokeColor);
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        b bVar = null;
        bVar.m();
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        b bVar = null;
        bVar.n();
        throw null;
    }

    public void setStrokeWidth(int strokeWidth) {
        b bVar = null;
        bVar.D(strokeWidth);
        throw null;
    }

    public int getStrokeWidth() {
        b bVar = null;
        bVar.o();
        throw null;
    }

    @Override // a.d.a.a
    public void setRadius(float radius) {
        super.setRadius(radius);
        b bVar = null;
        bVar.y(radius);
        throw null;
    }

    @Override // a.d.a.a
    public float getRadius() {
        b bVar = null;
        bVar.i();
        throw null;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public void setProgress(float progress) {
        b bVar = null;
        bVar.z(progress);
        throw null;
    }

    public float getProgress() {
        b bVar = null;
        bVar.j();
        throw null;
    }

    @Override // a.d.a.a
    public int getContentPaddingLeft() {
        b bVar = null;
        bVar.p();
        throw null;
    }

    @Override // a.d.a.a
    public int getContentPaddingTop() {
        b bVar = null;
        bVar.p();
        throw null;
    }

    @Override // a.d.a.a
    public int getContentPaddingRight() {
        b bVar = null;
        bVar.p();
        throw null;
    }

    @Override // a.d.a.a
    public int getContentPaddingBottom() {
        b bVar = null;
        bVar.p();
        throw null;
    }

    @Override // a.d.a.a
    public void setCardBackgroundColor(int color) {
        b bVar = null;
        bVar.r(ColorStateList.valueOf(color));
        throw null;
    }

    @Override // a.d.a.a
    public void setCardBackgroundColor(ColorStateList color) {
        b bVar = null;
        bVar.r(color);
        throw null;
    }

    @Override // a.d.a.a
    public ColorStateList getCardBackgroundColor() {
        b bVar = null;
        bVar.c();
        throw null;
    }

    public void setCardForegroundColor(ColorStateList foregroundColor) {
        b bVar = null;
        bVar.s(foregroundColor);
        throw null;
    }

    public ColorStateList getCardForegroundColor() {
        b bVar = null;
        bVar.d();
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean clickable) {
        super.setClickable(clickable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = null;
        bVar.b();
        throw null;
    }

    @Override // a.d.a.a
    public void setCardElevation(float elevation) {
        super.setCardElevation(elevation);
        b bVar = null;
        bVar.E();
        throw null;
    }

    @Override // a.d.a.a
    public void setMaxCardElevation(float maxCardElevation) {
        super.setMaxCardElevation(maxCardElevation);
        b bVar = null;
        bVar.F();
        throw null;
    }

    @Override // a.d.a.a
    public void setUseCompatPadding(boolean useCompatPadding) {
        super.setUseCompatPadding(useCompatPadding);
        b bVar = null;
        bVar.F();
        throw null;
    }

    @Override // a.d.a.a
    public void setPreventCornerOverlap(boolean preventCornerOverlap) {
        super.setPreventCornerOverlap(preventCornerOverlap);
        b bVar = null;
        bVar.F();
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return false;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (checked) {
            toggle();
        }
    }

    public void setDragged(boolean dragged) {
        if (this.h != dragged) {
            this.h = dragged;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    public boolean f() {
        return this.h;
    }

    public boolean e() {
        return false;
    }

    public void setCheckable(boolean checkable) {
        b bVar = null;
        bVar.t(checkable);
        throw null;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 3);
        e();
        isChecked();
        if (f()) {
            FrameLayout.mergeDrawableStates(drawableState, g);
        }
        return drawableState;
    }

    public void setOnCheckedChangeListener(InterfaceC0064a listener) {
        this.i = listener;
    }

    public void setRippleColor(ColorStateList rippleColor) {
        b bVar = null;
        bVar.A(rippleColor);
        throw null;
    }

    public void setRippleColorResource(int rippleColorResourceId) {
        b bVar = null;
        bVar.A(a.b.c.a.a.c(getContext(), rippleColorResourceId));
        throw null;
    }

    public ColorStateList getRippleColor() {
        b bVar = null;
        bVar.k();
        throw null;
    }

    public Drawable getCheckedIcon() {
        b bVar = null;
        bVar.e();
        throw null;
    }

    public void setCheckedIconResource(int id) {
        b bVar = null;
        bVar.u(a.b.c.a.a.d(getContext(), id));
        throw null;
    }

    public void setCheckedIcon(Drawable checkedIcon) {
        b bVar = null;
        bVar.u(checkedIcon);
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
        b bVar = null;
        bVar.h();
        throw null;
    }

    public void setCheckedIconTint(ColorStateList checkedIconTint) {
        b bVar = null;
        bVar.x(checkedIconTint);
        throw null;
    }

    public int getCheckedIconSize() {
        b bVar = null;
        bVar.g();
        throw null;
    }

    public void setCheckedIconSize(int checkedIconSize) {
        b bVar = null;
        bVar.w(checkedIconSize);
        throw null;
    }

    public void setCheckedIconSizeResource(int checkedIconSizeResId) {
        if (checkedIconSizeResId != 0) {
            b bVar = null;
            bVar.w(getResources().getDimensionPixelSize(checkedIconSizeResId));
            throw null;
        }
    }

    public int getCheckedIconMargin() {
        b bVar = null;
        bVar.f();
        throw null;
    }

    public void setCheckedIconMargin(int checkedIconMargin) {
        b bVar = null;
        bVar.v(checkedIconMargin);
        throw null;
    }

    public void setCheckedIconMarginResource(int checkedIconMarginResId) {
        if (checkedIconMarginResId != -1) {
            b bVar = null;
            bVar.v(getResources().getDimensionPixelSize(checkedIconMarginResId));
            throw null;
        }
    }

    private RectF getBoundsAsRectF() {
        new RectF();
        b bVar = null;
        bVar.b();
        throw null;
    }

    @Override // b.b.a.a.x.n
    public void setShapeAppearanceModel(k shapeAppearanceModel) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(shapeAppearanceModel.u(getBoundsAsRectF()));
        }
        b bVar = null;
        bVar.B(shapeAppearanceModel);
        throw null;
    }

    public k getShapeAppearanceModel() {
        b bVar = null;
        bVar.l();
        throw null;
    }

    public final void d() {
        if (Build.VERSION.SDK_INT > 26) {
            b bVar = null;
            bVar.a();
            throw null;
        }
    }
}
