package com.google.android.material.button;

import a.b.g.f;
import a.h.k.v;
import a.h.l.i;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import b.b.a.a.r.j;
import b.b.a.a.r.l;
import b.b.a.a.x.h;
import b.b.a.a.x.k;
import b.b.a.a.x.n;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class MaterialButton extends f implements Checkable, n {
    public static final int[] d = {R.attr.state_checkable};
    public static final int[] e = {R.attr.state_checked};
    public static final int f = net.sqlcipher.R.style.Widget_MaterialComponents_Button;
    public final b.b.a.a.e.a g;
    public final LinkedHashSet<a> h;
    public b i;
    public PorterDuff.Mode j;
    public ColorStateList k;
    public Drawable l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;

    /* loaded from: classes.dex */
    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public MaterialButton(Context context, AttributeSet attrs) {
        this(context, attrs, net.sqlcipher.R.attr.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(b.b.a.a.b0.a.a.c(context, attrs, defStyleAttr, net.sqlcipher.R.style.Widget_MaterialComponents_Button), attrs, defStyleAttr);
        this.h = new LinkedHashSet<>();
        this.q = false;
        this.r = false;
        Context context2 = getContext();
        TypedArray attributes = j.h(context2, attrs, b.b.a.a.a.l, defStyleAttr, net.sqlcipher.R.style.Widget_MaterialComponents_Button, new int[0]);
        int[] iArr = b.b.a.a.a.f942a;
        this.p = attributes.getDimensionPixelSize(12, 0);
        this.j = l.e(attributes.getInt(15, -1), PorterDuff.Mode.SRC_IN);
        this.k = b.b.a.a.u.c.a(getContext(), attributes, 14);
        this.l = b.b.a.a.u.c.d(getContext(), attributes, 10);
        this.s = attributes.getInteger(11, 1);
        this.m = attributes.getDimensionPixelSize(13, 0);
        k shapeAppearanceModel = k.e(context2, attrs, defStyleAttr, net.sqlcipher.R.style.Widget_MaterialComponents_Button).m();
        b.b.a.a.e.a aVar = new b.b.a.a.e.a(this, shapeAppearanceModel);
        this.g = aVar;
        aVar.q(attributes);
        attributes.recycle();
        setCompoundDrawablePadding(this.p);
        j(this.l != null);
    }

    private String getA11yClassName() {
        return (b() ? CompoundButton.class : Button.class).getName();
    }

    @Override // a.b.g.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(getA11yClassName());
        info.setCheckable(b());
        info.setChecked(isChecked());
        info.setClickable(isClickable());
    }

    @Override // a.b.g.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        c savedState = new c(superState);
        savedState.d = this.q;
        return savedState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof c)) {
            super.onRestoreInstanceState(state);
            return;
        }
        c savedState = (c) state;
        super.onRestoreInstanceState(savedState.j());
        setChecked(savedState.d);
    }

    @Override // a.b.g.f, a.h.k.u
    public void setSupportBackgroundTintList(ColorStateList tint) {
        if (g()) {
            this.g.C(tint);
        } else {
            super.setSupportBackgroundTintList(tint);
        }
    }

    @Override // a.b.g.f, a.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        if (g()) {
            return this.g.l();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // a.b.g.f, a.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode tintMode) {
        if (g()) {
            this.g.D(tintMode);
        } else {
            super.setSupportBackgroundTintMode(tintMode);
        }
    }

    @Override // a.b.g.f, a.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (g()) {
            return this.g.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList tintList) {
        setSupportBackgroundTintList(tintList);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode tintMode) {
        setSupportBackgroundTintMode(tintMode);
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        if (g()) {
            this.g.r(color);
        } else {
            super.setBackgroundColor(color);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        setBackgroundDrawable(background);
    }

    @Override // a.b.g.f, android.view.View
    public void setBackgroundResource(int backgroundResourceId) {
        Drawable background = null;
        if (backgroundResourceId != 0) {
            background = a.b.c.a.a.d(getContext(), backgroundResourceId);
        }
        setBackgroundDrawable(background);
    }

    @Override // a.b.g.f, android.view.View
    public void setBackgroundDrawable(Drawable background) {
        if (g()) {
            if (background != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.g.s();
                super.setBackgroundDrawable(background);
                return;
            }
            getBackground().setState(background.getState());
            return;
        }
        super.setBackgroundDrawable(background);
    }

    @Override // a.b.g.f, android.widget.TextView, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        b.b.a.a.e.a aVar;
        super.onLayout(changed, left, top, right, bottom);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.g) != null) {
            aVar.H(bottom - top, right - left);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        k(w, h);
    }

    @Override // a.b.g.f, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        super.onTextChanged(charSequence, i, i1, i2);
        k(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (g()) {
            h.f(this, this.g.f());
        }
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        if (g()) {
            this.g.f().U(elevation);
        }
    }

    public final void k(int buttonWidth, int buttonHeight) {
        if (this.l == null || getLayout() == null) {
            return;
        }
        if (d() || c()) {
            this.o = 0;
            int i = this.s;
            if (i == 1 || i == 3) {
                this.n = 0;
                j(false);
                return;
            }
            int localIconSize = this.m;
            if (localIconSize == 0) {
                localIconSize = this.l.getIntrinsicWidth();
            }
            int newIconLeft = (((((buttonWidth - getTextWidth()) - v.H(this)) - localIconSize) - this.p) - v.I(this)) / 2;
            if (f() != (this.s == 4)) {
                newIconLeft = -newIconLeft;
            }
            if (this.n != newIconLeft) {
                this.n = newIconLeft;
                j(false);
                return;
            }
            return;
        }
        if (e()) {
            this.n = 0;
            if (this.s == 16) {
                this.o = 0;
                j(false);
                return;
            }
            int localIconSize2 = this.m;
            if (localIconSize2 == 0) {
                localIconSize2 = this.l.getIntrinsicHeight();
            }
            int newIconTop = (((((buttonHeight - getTextHeight()) - getPaddingTop()) - localIconSize2) - this.p) - getPaddingBottom()) / 2;
            if (this.o != newIconTop) {
                this.o = newIconTop;
                j(false);
            }
        }
    }

    private int getTextWidth() {
        Paint textPaint = getPaint();
        String buttonText = getText().toString();
        if (getTransformationMethod() != null) {
            buttonText = getTransformationMethod().getTransformation(buttonText, this).toString();
        }
        return Math.min((int) textPaint.measureText(buttonText), getLayout().getEllipsizedWidth());
    }

    private int getTextHeight() {
        Paint textPaint = getPaint();
        String buttonText = getText().toString();
        if (getTransformationMethod() != null) {
            buttonText = getTransformationMethod().getTransformation(buttonText, this).toString();
        }
        Rect bounds = new Rect();
        textPaint.getTextBounds(buttonText, 0, buttonText.length(), bounds);
        return Math.min(bounds.height(), getLayout().getHeight());
    }

    public final boolean f() {
        return v.C(this) == 1;
    }

    public void setInternalBackground(Drawable background) {
        super.setBackgroundDrawable(background);
    }

    public void setIconPadding(int iconPadding) {
        if (this.p != iconPadding) {
            this.p = iconPadding;
            setCompoundDrawablePadding(iconPadding);
        }
    }

    public int getIconPadding() {
        return this.p;
    }

    public void setIconSize(int iconSize) {
        if (iconSize < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.m != iconSize) {
            this.m = iconSize;
            j(true);
        }
    }

    public int getIconSize() {
        return this.m;
    }

    public void setIcon(Drawable icon) {
        if (this.l != icon) {
            this.l = icon;
            j(true);
            k(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconResource(int iconResourceId) {
        Drawable icon = null;
        if (iconResourceId != 0) {
            icon = a.b.c.a.a.d(getContext(), iconResourceId);
        }
        setIcon(icon);
    }

    public Drawable getIcon() {
        return this.l;
    }

    public void setIconTint(ColorStateList iconTint) {
        if (this.k != iconTint) {
            this.k = iconTint;
            j(false);
        }
    }

    public void setIconTintResource(int iconTintResourceId) {
        setIconTint(a.b.c.a.a.c(getContext(), iconTintResourceId));
    }

    public ColorStateList getIconTint() {
        return this.k;
    }

    public void setIconTintMode(PorterDuff.Mode iconTintMode) {
        if (this.j != iconTintMode) {
            this.j = iconTintMode;
            j(false);
        }
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.j;
    }

    public final void j(boolean needsIconReset) {
        Drawable drawable = this.l;
        if (drawable != null) {
            Drawable mutate = a.h.d.l.a.r(drawable).mutate();
            this.l = mutate;
            a.h.d.l.a.o(mutate, this.k);
            PorterDuff.Mode mode = this.j;
            if (mode != null) {
                a.h.d.l.a.p(this.l, mode);
            }
            int width = this.m;
            if (width == 0) {
                width = this.l.getIntrinsicWidth();
            }
            int height = this.m;
            if (height == 0) {
                height = this.l.getIntrinsicHeight();
            }
            Drawable drawable2 = this.l;
            int i = this.n;
            int i2 = this.o;
            drawable2.setBounds(i, i2, i + width, i2 + height);
        }
        if (needsIconReset) {
            i();
            return;
        }
        Drawable[] existingDrawables = i.a(this);
        boolean hasIconChanged = false;
        Drawable drawableStart = existingDrawables[0];
        Drawable drawableTop = existingDrawables[1];
        Drawable drawableEnd = existingDrawables[2];
        if ((d() && drawableStart != this.l) || ((c() && drawableEnd != this.l) || (e() && drawableTop != this.l))) {
            hasIconChanged = true;
        }
        if (hasIconChanged) {
            i();
        }
    }

    public final void i() {
        if (d()) {
            i.i(this, this.l, null, null, null);
        } else if (c()) {
            i.i(this, null, null, this.l, null);
        } else if (e()) {
            i.i(this, null, this.l, null, null);
        }
    }

    public final boolean d() {
        int i = this.s;
        return i == 1 || i == 2;
    }

    public final boolean c() {
        int i = this.s;
        return i == 3 || i == 4;
    }

    public final boolean e() {
        int i = this.s;
        return i == 16 || i == 32;
    }

    public void setRippleColor(ColorStateList rippleColor) {
        if (g()) {
            this.g.x(rippleColor);
        }
    }

    public void setRippleColorResource(int rippleColorResourceId) {
        if (g()) {
            setRippleColor(a.b.c.a.a.c(getContext(), rippleColorResourceId));
        }
    }

    public ColorStateList getRippleColor() {
        if (g()) {
            return this.g.h();
        }
        return null;
    }

    public void setStrokeColor(ColorStateList strokeColor) {
        if (g()) {
            this.g.A(strokeColor);
        }
    }

    public void setStrokeColorResource(int strokeColorResourceId) {
        if (g()) {
            setStrokeColor(a.b.c.a.a.c(getContext(), strokeColorResourceId));
        }
    }

    public ColorStateList getStrokeColor() {
        if (g()) {
            return this.g.j();
        }
        return null;
    }

    public void setStrokeWidth(int strokeWidth) {
        if (g()) {
            this.g.B(strokeWidth);
        }
    }

    public void setStrokeWidthResource(int strokeWidthResourceId) {
        if (g()) {
            setStrokeWidth(getResources().getDimensionPixelSize(strokeWidthResourceId));
        }
    }

    public int getStrokeWidth() {
        if (g()) {
            return this.g.k();
        }
        return 0;
    }

    public void setCornerRadius(int cornerRadius) {
        if (g()) {
            this.g.u(cornerRadius);
        }
    }

    public void setCornerRadiusResource(int cornerRadiusResourceId) {
        if (g()) {
            setCornerRadius(getResources().getDimensionPixelSize(cornerRadiusResourceId));
        }
    }

    public int getCornerRadius() {
        if (g()) {
            return this.g.b();
        }
        return 0;
    }

    public int getIconGravity() {
        return this.s;
    }

    public void setIconGravity(int iconGravity) {
        if (this.s != iconGravity) {
            this.s = iconGravity;
            k(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setInsetBottom(int insetBottom) {
        this.g.v(insetBottom);
    }

    public int getInsetBottom() {
        return this.g.c();
    }

    public void setInsetTop(int insetTop) {
        this.g.w(insetTop);
    }

    public int getInsetTop() {
        return this.g.d();
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 2);
        if (b()) {
            Button.mergeDrawableStates(drawableState, d);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(drawableState, e);
        }
        return drawableState;
    }

    public void a(a listener) {
        this.h.add(listener);
    }

    public void h(a listener) {
        this.h.remove(listener);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (b() && isEnabled() && this.q != checked) {
            this.q = checked;
            refreshDrawableState();
            if (this.r) {
                return;
            }
            this.r = true;
            Iterator<a> it = this.h.iterator();
            while (it.hasNext()) {
                a listener = it.next();
                listener.a(this, this.q);
            }
            this.r = false;
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.q;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.q);
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public boolean b() {
        b.b.a.a.e.a aVar = this.g;
        return aVar != null && aVar.p();
    }

    public void setCheckable(boolean checkable) {
        if (g()) {
            this.g.t(checkable);
        }
    }

    @Override // b.b.a.a.x.n
    public void setShapeAppearanceModel(k shapeAppearanceModel) {
        if (g()) {
            this.g.y(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public k getShapeAppearanceModel() {
        if (g()) {
            return this.g.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public void setOnPressedChangeListenerInternal(b listener) {
        this.i = listener;
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        b bVar = this.i;
        if (bVar != null) {
            ((MaterialButtonToggleGroup.f) bVar).a(this, pressed);
        }
        super.setPressed(pressed);
    }

    public final boolean g() {
        b.b.a.a.e.a aVar = this.g;
        return (aVar == null || aVar.o()) ? false : true;
    }

    public void setShouldDrawSurfaceColorStroke(boolean shouldDrawSurfaceColorStroke) {
        if (g()) {
            this.g.z(shouldDrawSurfaceColorStroke);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a.j.a.a {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public boolean d;

        public c(Parcelable superState) {
            super(superState);
        }

        public c(Parcel source, ClassLoader loader) {
            super(source, loader);
            if (loader == null) {
                getClass().getClassLoader();
            }
            k(source);
        }

        @Override // a.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.d ? 1 : 0);
        }

        public final void k(Parcel in) {
            this.d = in.readInt() == 1;
        }

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel in, ClassLoader loader) {
                return new c(in, loader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel in) {
                return new c(in, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int size) {
                return new c[size];
            }
        }
    }
}
