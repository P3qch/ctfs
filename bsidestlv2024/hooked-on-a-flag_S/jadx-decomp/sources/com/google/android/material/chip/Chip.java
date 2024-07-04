package com.google.android.material.chip;

import a.b.g.g;
import a.h.k.e0.c;
import a.h.k.v;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import b.b.a.a.i.a;
import b.b.a.a.r.j;
import b.b.a.a.r.l;
import b.b.a.a.u.d;
import b.b.a.a.u.f;
import b.b.a.a.x.h;
import b.b.a.a.x.k;
import b.b.a.a.x.n;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class Chip extends g implements a.InterfaceC0065a, n {
    public static final int e = R.style.Widget_MaterialComponents_Chip_Action;
    public static final Rect f = new Rect();
    public static final int[] g = {android.R.attr.state_selected};
    public static final int[] h = {android.R.attr.state_checkable};
    public b.b.a.a.i.a i;
    public InsetDrawable j;
    public RippleDrawable k;
    public View.OnClickListener l;
    public CompoundButton.OnCheckedChangeListener m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public final c u;
    public final Rect v;
    public final RectF w;
    public final f x;

    /* loaded from: classes.dex */
    public class a extends f {
        public a() {
        }

        @Override // b.b.a.a.u.f
        public void b(Typeface typeface, boolean fontResolvedSynchronously) {
            Chip chip = Chip.this;
            chip.setText(chip.i.G2() ? Chip.this.i.c1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }

        @Override // b.b.a.a.u.f
        public void a(int reason) {
        }
    }

    public Chip(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.chipStyle);
    }

    public Chip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(b.b.a.a.b0.a.a.c(context, attrs, defStyleAttr, R.style.Widget_MaterialComponents_Chip_Action), attrs, defStyleAttr);
        this.v = new Rect();
        this.w = new RectF();
        this.x = new a();
        Context context2 = getContext();
        C(attrs);
        b.b.a.a.i.a drawable = b.b.a.a.i.a.q0(context2, attrs, defStyleAttr, R.style.Widget_MaterialComponents_Chip_Action);
        o(context2, attrs, defStyleAttr);
        setChipDrawable(drawable);
        drawable.U(v.w(this));
        TypedArray a2 = j.h(context2, attrs, b.b.a.a.a.c, defStyleAttr, R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            int[] iArr = b.b.a.a.a.f942a;
            setTextColor(b.b.a.a.u.c.a(context2, a2, 2));
        }
        int[] iArr2 = b.b.a.a.a.f942a;
        boolean hasShapeAppearanceAttribute = a2.hasValue(37);
        a2.recycle();
        this.u = new c(this);
        x();
        if (!hasShapeAppearanceAttribute) {
            p();
        }
        setChecked(this.n);
        setText(drawable.c1());
        setEllipsize(drawable.W0());
        B();
        if (!this.i.G2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        A();
        if (v()) {
            setMinHeight(this.t);
        }
        this.s = v.C(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.i);
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.U(elevation);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (r() || isClickable()) {
            info.setClassName(r() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            info.setClassName("android.view.View");
        }
        info.setCheckable(r());
        info.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            a.h.k.e0.c infoCompat = a.h.k.e0.c.v0(info);
            int columnIndex = chipGroup.c() ? chipGroup.o(this) : -1;
            infoCompat.Z(c.C0030c.a(chipGroup.b(this), 1, columnIndex, 1, false, isChecked()));
        }
    }

    public final void x() {
        if (n() && s() && this.l != null) {
            v.o0(this, this.u);
        } else {
            v.o0(this, null);
        }
    }

    public final void o(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a2 = j.h(context, attrs, b.b.a.a.a.c, defStyleAttr, R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        int[] iArr = b.b.a.a.a.f942a;
        this.r = a2.getBoolean(32, false);
        float defaultMinTouchTargetSize = (float) Math.ceil(l.b(getContext(), 48));
        this.t = (int) Math.ceil(a2.getDimension(20, defaultMinTouchTargetSize));
        a2.recycle();
    }

    public final void A() {
        b.b.a.a.i.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.i) == null) {
            return;
        }
        int paddingEnd = (int) (aVar.E0() + this.i.e1() + this.i.l0());
        int paddingStart = (int) (this.i.J0() + this.i.f1() + this.i.i0());
        if (this.j != null) {
            Rect padding = new Rect();
            this.j.getPadding(padding);
            paddingStart += padding.left;
            paddingEnd += padding.right;
        }
        v.A0(this, paddingStart, getPaddingTop(), paddingEnd, getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        if (this.s != layoutDirection) {
            this.s = layoutDirection;
            A();
        }
    }

    public final void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                                Log.w("Chip", "Chip text must be vertically center and start aligned");
                                return;
                            }
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    public final void p() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            if (Chip.this.i != null) {
                Chip.this.i.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    public Drawable getChipDrawable() {
        return this.i;
    }

    public void setChipDrawable(b.b.a.a.i.a drawable) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != drawable) {
            w(aVar);
            this.i = drawable;
            drawable.v2(false);
            i(this.i);
            k(this.t);
        }
    }

    public final void y() {
        if (b.b.a.a.v.b.f1093a) {
            z();
            return;
        }
        this.i.F2(true);
        v.r0(this, getBackgroundDrawable());
        A();
        l();
    }

    public final void l() {
        if (getBackgroundDrawable() == this.j && this.i.getCallback() == null) {
            this.i.setCallback(this.j);
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.j;
        if (insetDrawable == null) {
            return this.i;
        }
        return insetDrawable;
    }

    public final void z() {
        this.k = new RippleDrawable(b.b.a.a.v.b.a(this.i.a1()), getBackgroundDrawable(), null);
        this.i.F2(false);
        v.r0(this, this.k);
        A();
    }

    public final void w(b.b.a.a.i.a chipDrawable) {
        if (chipDrawable != null) {
            chipDrawable.k2(null);
        }
    }

    public final void i(b.b.a.a.i.a chipDrawable) {
        chipDrawable.k2(this);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        int[] state = super.onCreateDrawableState(extraSpace + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(state, g);
        }
        if (r()) {
            CheckBox.mergeDrawableStates(state, h);
        }
        return state;
    }

    @Override // android.widget.TextView
    public void setGravity(int gravity) {
        if (gravity != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(gravity);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList tint) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode tintMode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // a.b.g.g, android.view.View
    public void setBackgroundResource(int resid) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        if (background != getBackgroundDrawable() && background != this.k) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        } else {
            super.setBackground(background);
        }
    }

    @Override // a.b.g.g, android.view.View
    public void setBackgroundDrawable(Drawable background) {
        if (background != getBackgroundDrawable() && background != this.k) {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        } else {
            super.setBackgroundDrawable(background);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        if (left != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (right != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(left, top, right, bottom);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        if (left != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (right != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        if (left != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (right != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable start, Drawable top, Drawable end, Drawable bottom) {
        if (start != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (end != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(start, top, end, bottom);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end, int bottom) {
        if (start != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (end != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable start, Drawable top, Drawable end, Drawable bottom) {
        if (start != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (end != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.W0();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt where) {
        if (this.i == null) {
            return;
        }
        if (where == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(where);
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.l2(where);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean singleLine) {
        if (!singleLine) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(singleLine);
    }

    @Override // android.widget.TextView
    public void setLines(int lines) {
        if (lines > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(lines);
    }

    @Override // android.widget.TextView
    public void setMinLines(int minLines) {
        if (minLines > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(minLines);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int maxLines) {
        if (maxLines > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(maxLines);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int maxWidth) {
        super.setMaxWidth(maxWidth);
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.s2(maxWidth);
        }
    }

    @Override // b.b.a.a.i.a.InterfaceC0065a
    public void a() {
        k(this.t);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        b.b.a.a.i.a aVar = this.i;
        if (aVar == null) {
            this.n = checked;
            return;
        }
        if (aVar.j1()) {
            boolean wasChecked = isChecked();
            super.setChecked(checked);
            if (wasChecked != checked && (onCheckedChangeListener = this.m) != null) {
                onCheckedChangeListener.onCheckedChanged(this, checked);
            }
        }
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener listener) {
        this.m = listener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener listener) {
        this.l = listener;
        x();
    }

    public boolean t() {
        boolean result;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.l;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            result = true;
        } else {
            result = false;
        }
        this.u.U(1, 1);
        return result;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        boolean handled = false;
        int action = event.getActionMasked();
        boolean eventInCloseIcon = getCloseIconTouchBounds().contains(event.getX(), event.getY());
        switch (action) {
            case 0:
                if (eventInCloseIcon) {
                    setCloseIconPressed(true);
                    handled = true;
                    break;
                }
                break;
            case 1:
                if (this.o) {
                    t();
                    handled = true;
                }
                setCloseIconPressed(false);
                break;
            case 2:
                if (this.o) {
                    if (!eventInCloseIcon) {
                        setCloseIconPressed(false);
                    }
                    handled = true;
                    break;
                }
                break;
            case 3:
                setCloseIconPressed(false);
                break;
        }
        return handled || super.onTouchEvent(event);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action) {
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                setCloseIconHovered(getCloseIconTouchBounds().contains(event.getX(), event.getY()));
                break;
            case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                setCloseIconHovered(false);
                break;
        }
        return super.onHoverEvent(event);
    }

    @SuppressLint({"PrivateApi"})
    public final boolean m(MotionEvent event) {
        if (event.getAction() == 10) {
            try {
                Field f2 = a.j.b.a.class.getDeclaredField("p");
                f2.setAccessible(true);
                int mHoveredVirtualViewId = ((Integer) f2.get(this.u)).intValue();
                if (mHoveredVirtualViewId != Integer.MIN_VALUE) {
                    Method m = a.j.b.a.class.getDeclaredMethod("V", Integer.TYPE);
                    m.setAccessible(true);
                    m.invoke(this.u, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchFieldException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (NoSuchMethodException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            } catch (InvocationTargetException e5) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        return m(event) || this.u.v(event) || super.dispatchHoverEvent(event);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        boolean handled = this.u.w(event);
        if (handled && this.u.A() != Integer.MIN_VALUE) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        this.u.I(focused, direction, previouslyFocusedRect);
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect r) {
        if (this.u.A() == 1 || this.u.x() == 1) {
            r.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(r);
        }
    }

    private void setCloseIconPressed(boolean pressed) {
        if (this.o != pressed) {
            this.o = pressed;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean hovered) {
        if (this.p != hovered) {
            this.p = hovered;
            refreshDrawableState();
        }
    }

    @Override // a.b.g.g, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        boolean changed = false;
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null && aVar.k1()) {
            changed = this.i.g2(j());
        }
        if (changed) {
            invalidate();
        }
    }

    public final int[] j() {
        int count = 0;
        if (isEnabled()) {
            count = 0 + 1;
        }
        if (this.q) {
            count++;
        }
        if (this.p) {
            count++;
        }
        if (this.o) {
            count++;
        }
        if (isChecked()) {
            count++;
        }
        int[] stateSet = new int[count];
        int i = 0;
        if (isEnabled()) {
            stateSet[0] = 16842910;
            i = 0 + 1;
        }
        if (this.q) {
            stateSet[i] = 16842908;
            i++;
        }
        if (this.p) {
            stateSet[i] = 16843623;
            i++;
        }
        if (this.o) {
            stateSet[i] = 16842919;
            i++;
        }
        if (isChecked()) {
            stateSet[i] = 16842913;
            int i2 = i + 1;
        }
        return stateSet;
    }

    public final boolean n() {
        b.b.a.a.i.a aVar = this.i;
        return (aVar == null || aVar.M0() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.w.setEmpty();
        if (n() && this.l != null) {
            this.i.T0(this.w);
        }
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF bounds = getCloseIconTouchBounds();
        this.v.set((int) bounds.left, (int) bounds.top, (int) bounds.right, (int) bounds.bottom);
        return this.v;
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        if (getCloseIconTouchBounds().contains(event.getX(), event.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class c extends a.j.b.a {
        public c(Chip view) {
            super(view);
        }

        @Override // a.j.b.a
        public int B(float x, float y) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(x, y)) ? 1 : 0;
        }

        @Override // a.j.b.a
        public void C(List<Integer> virtualViewIds) {
            virtualViewIds.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.l != null) {
                virtualViewIds.add(1);
            }
        }

        @Override // a.j.b.a
        public void O(int virtualViewId, boolean hasFocus) {
            if (virtualViewId == 1) {
                Chip.this.q = hasFocus;
                Chip.this.refreshDrawableState();
            }
        }

        @Override // a.j.b.a
        public void N(int virtualViewId, a.h.k.e0.c node) {
            CharSequence charSequence = BuildConfig.FLAVOR;
            if (virtualViewId == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    node.a0(closeIconContentDescription);
                } else {
                    CharSequence chipText = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(chipText)) {
                        charSequence = chipText;
                    }
                    objArr[0] = charSequence;
                    node.a0(context.getString(R.string.mtrl_chip_close_icon_content_description, objArr).trim());
                }
                node.S(Chip.this.getCloseIconTouchBoundsInt());
                node.b(c.a.f453a);
                node.b0(Chip.this.isEnabled());
                return;
            }
            node.a0(BuildConfig.FLAVOR);
            node.S(Chip.f);
        }

        @Override // a.j.b.a
        public void M(a.h.k.e0.c node) {
            node.U(Chip.this.r());
            node.X(Chip.this.isClickable());
            if (Chip.this.r() || Chip.this.isClickable()) {
                node.W(Chip.this.r() ? "android.widget.CompoundButton" : "android.widget.Button");
            } else {
                node.W("android.view.View");
            }
            CharSequence chipText = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                node.r0(chipText);
            } else {
                node.a0(chipText);
            }
        }

        @Override // a.j.b.a
        public boolean J(int virtualViewId, int action, Bundle arguments) {
            if (action == 16) {
                if (virtualViewId == 0) {
                    return Chip.this.performClick();
                }
                if (virtualViewId == 1) {
                    return Chip.this.t();
                }
                return false;
            }
            return false;
        }
    }

    public ColorStateList getChipBackgroundColor() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.C0();
        }
        return null;
    }

    public void setChipBackgroundColorResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.B1(id);
        }
    }

    public void setChipBackgroundColor(ColorStateList chipBackgroundColor) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.A1(chipBackgroundColor);
        }
    }

    public float getChipMinHeight() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.I0();
        }
        return 0.0f;
    }

    public void setChipMinHeightResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.P1(id);
        }
    }

    public void setChipMinHeight(float minHeight) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.O1(minHeight);
        }
    }

    public float getChipCornerRadius() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return Math.max(0.0f, aVar.D0());
        }
        return 0.0f;
    }

    @Deprecated
    public void setChipCornerRadiusResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.D1(id);
        }
    }

    @Override // b.b.a.a.x.n
    public void setShapeAppearanceModel(k shapeAppearanceModel) {
        this.i.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public k getShapeAppearanceModel() {
        return this.i.B();
    }

    @Deprecated
    public void setChipCornerRadius(float chipCornerRadius) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.C1(chipCornerRadius);
        }
    }

    public ColorStateList getChipStrokeColor() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.K0();
        }
        return null;
    }

    public void setChipStrokeColorResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.T1(id);
        }
    }

    public void setChipStrokeColor(ColorStateList chipStrokeColor) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.S1(chipStrokeColor);
        }
    }

    public float getChipStrokeWidth() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.L0();
        }
        return 0.0f;
    }

    public void setChipStrokeWidthResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.V1(id);
        }
    }

    public void setChipStrokeWidth(float chipStrokeWidth) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.U1(chipStrokeWidth);
        }
    }

    public ColorStateList getRippleColor() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.a1();
        }
        return null;
    }

    public void setRippleColorResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.u2(id);
            if (!this.i.h1()) {
                z();
            }
        }
    }

    public void setRippleColor(ColorStateList rippleColor) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.t2(rippleColor);
        }
        if (!this.i.h1()) {
            z();
        }
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Override // android.view.View
    public void setLayoutDirection(int layoutDirection) {
        if (this.i != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(layoutDirection);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        if (text == null) {
            text = BuildConfig.FLAVOR;
        }
        super.setText(aVar.G2() ? null : text, type);
        b.b.a.a.i.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.y2(text);
        }
    }

    @Deprecated
    public void setChipTextResource(int id) {
        setText(getResources().getString(id));
    }

    @Deprecated
    public void setChipText(CharSequence chipText) {
        setText(chipText);
    }

    public void setTextAppearanceResource(int id) {
        setTextAppearance(getContext(), id);
    }

    public void setTextAppearance(d textAppearance) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.z2(textAppearance);
        }
        B();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.A2(resId);
        }
        B();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int resId) {
        super.setTextAppearance(resId);
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.A2(resId);
        }
        B();
    }

    public final void B() {
        TextPaint textPaint = getPaint();
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            textPaint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.j(getContext(), textPaint, this.x);
        }
    }

    private d getTextAppearance() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.d1();
        }
        return null;
    }

    public void setChipIconVisible(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.M1(id);
        }
    }

    public void setChipIconVisible(boolean chipIconVisible) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.N1(chipIconVisible);
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(int id) {
        setChipIconVisible(id);
    }

    @Deprecated
    public void setChipIconEnabled(boolean chipIconEnabled) {
        setChipIconVisible(chipIconEnabled);
    }

    public Drawable getChipIcon() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.F0();
        }
        return null;
    }

    public void setChipIconResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.H1(id);
        }
    }

    public void setChipIcon(Drawable chipIcon) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.G1(chipIcon);
        }
    }

    public ColorStateList getChipIconTint() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.H0();
        }
        return null;
    }

    public void setChipIconTintResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.L1(id);
        }
    }

    public void setChipIconTint(ColorStateList chipIconTint) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.K1(chipIconTint);
        }
    }

    public float getChipIconSize() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.G0();
        }
        return 0.0f;
    }

    public void setChipIconSizeResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.J1(id);
        }
    }

    public void setChipIconSize(float chipIconSize) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.I1(chipIconSize);
        }
    }

    public boolean s() {
        b.b.a.a.i.a aVar = this.i;
        return aVar != null && aVar.l1();
    }

    public void setCloseIconVisible(int id) {
        setCloseIconVisible(getResources().getBoolean(id));
    }

    public void setCloseIconVisible(boolean closeIconVisible) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.j2(closeIconVisible);
        }
        x();
    }

    @Deprecated
    public void setCloseIconEnabledResource(int id) {
        setCloseIconVisible(id);
    }

    @Deprecated
    public void setCloseIconEnabled(boolean closeIconEnabled) {
        setCloseIconVisible(closeIconEnabled);
    }

    public Drawable getCloseIcon() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.M0();
        }
        return null;
    }

    public void setCloseIconResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.b2(id);
        }
        x();
    }

    public void setCloseIcon(Drawable closeIcon) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.X1(closeIcon);
        }
        x();
    }

    public ColorStateList getCloseIconTint() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.S0();
        }
        return null;
    }

    public void setCloseIconTintResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.i2(id);
        }
    }

    public void setCloseIconTint(ColorStateList closeIconTint) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.h2(closeIconTint);
        }
    }

    public float getCloseIconSize() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.P0();
        }
        return 0.0f;
    }

    public void setCloseIconSizeResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.d2(id);
        }
    }

    public void setCloseIconSize(float closeIconSize) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.c2(closeIconSize);
        }
    }

    public void setCloseIconContentDescription(CharSequence closeIconContentDescription) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.Y1(closeIconContentDescription);
        }
    }

    public CharSequence getCloseIconContentDescription() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.N0();
        }
        return null;
    }

    public boolean r() {
        b.b.a.a.i.a aVar = this.i;
        return aVar != null && aVar.j1();
    }

    public void setCheckableResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.t1(id);
        }
    }

    public void setCheckable(boolean checkable) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.s1(checkable);
        }
    }

    public void setCheckedIconVisible(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.y1(id);
        }
    }

    public void setCheckedIconVisible(boolean checkedIconVisible) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.z1(checkedIconVisible);
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int id) {
        setCheckedIconVisible(id);
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean checkedIconEnabled) {
        setCheckedIconVisible(checkedIconEnabled);
    }

    public Drawable getCheckedIcon() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.A0();
        }
        return null;
    }

    public void setCheckedIconResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.v1(id);
        }
    }

    public void setCheckedIcon(Drawable checkedIcon) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.u1(checkedIcon);
        }
    }

    public ColorStateList getCheckedIconTint() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.B0();
        }
        return null;
    }

    public void setCheckedIconTintResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.x1(id);
        }
    }

    public void setCheckedIconTint(ColorStateList checkedIconTint) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.w1(checkedIconTint);
        }
    }

    public b.b.a.a.b.h getShowMotionSpec() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public void setShowMotionSpecResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.x2(id);
        }
    }

    public void setShowMotionSpec(b.b.a.a.b.h showMotionSpec) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.w2(showMotionSpec);
        }
    }

    public b.b.a.a.b.h getHideMotionSpec() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.X0();
        }
        return null;
    }

    public void setHideMotionSpecResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.n2(id);
        }
    }

    public void setHideMotionSpec(b.b.a.a.b.h hideMotionSpec) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.m2(hideMotionSpec);
        }
    }

    public float getChipStartPadding() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.J0();
        }
        return 0.0f;
    }

    public void setChipStartPaddingResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.R1(id);
        }
    }

    public void setChipStartPadding(float chipStartPadding) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.Q1(chipStartPadding);
        }
    }

    public float getIconStartPadding() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.Z0();
        }
        return 0.0f;
    }

    public void setIconStartPaddingResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.r2(id);
        }
    }

    public void setIconStartPadding(float iconStartPadding) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.q2(iconStartPadding);
        }
    }

    public float getIconEndPadding() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.Y0();
        }
        return 0.0f;
    }

    public void setIconEndPaddingResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.p2(id);
        }
    }

    public void setIconEndPadding(float iconEndPadding) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.o2(iconEndPadding);
        }
    }

    public float getTextStartPadding() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.f1();
        }
        return 0.0f;
    }

    public void setTextStartPaddingResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.E2(id);
        }
    }

    public void setTextStartPadding(float textStartPadding) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.D2(textStartPadding);
        }
    }

    public float getTextEndPadding() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.e1();
        }
        return 0.0f;
    }

    public void setTextEndPaddingResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.C2(id);
        }
    }

    public void setTextEndPadding(float textEndPadding) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.B2(textEndPadding);
        }
    }

    public float getCloseIconStartPadding() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.Q0();
        }
        return 0.0f;
    }

    public void setCloseIconStartPaddingResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.f2(id);
        }
    }

    public void setCloseIconStartPadding(float closeIconStartPadding) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.e2(closeIconStartPadding);
        }
    }

    public float getCloseIconEndPadding() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.O0();
        }
        return 0.0f;
    }

    public void setCloseIconEndPaddingResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.a2(id);
        }
    }

    public void setCloseIconEndPadding(float closeIconEndPadding) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.Z1(closeIconEndPadding);
        }
    }

    public float getChipEndPadding() {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            return aVar.E0();
        }
        return 0.0f;
    }

    public void setChipEndPaddingResource(int id) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.F1(id);
        }
    }

    public void setChipEndPadding(float chipEndPadding) {
        b.b.a.a.i.a aVar = this.i;
        if (aVar != null) {
            aVar.E1(chipEndPadding);
        }
    }

    public boolean v() {
        return this.r;
    }

    public void setEnsureMinTouchTargetSize(boolean flag) {
        this.r = flag;
        k(this.t);
    }

    public boolean k(int minTargetPx) {
        this.t = minTargetPx;
        if (!v()) {
            if (this.j != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int deltaHeight = Math.max(0, minTargetPx - this.i.getIntrinsicHeight());
        int deltaWidth = Math.max(0, minTargetPx - this.i.getIntrinsicWidth());
        if (deltaWidth <= 0 && deltaHeight <= 0) {
            if (this.j != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int deltaX = deltaWidth > 0 ? deltaWidth / 2 : 0;
        int deltaY = deltaHeight > 0 ? deltaHeight / 2 : 0;
        if (this.j != null) {
            Rect padding = new Rect();
            this.j.getPadding(padding);
            if (padding.top == deltaY && padding.bottom == deltaY && padding.left == deltaX && padding.right == deltaX) {
                y();
                return true;
            }
        }
        if (getMinHeight() != minTargetPx) {
            setMinHeight(minTargetPx);
        }
        if (getMinWidth() != minTargetPx) {
            setMinWidth(minTargetPx);
        }
        q(deltaX, deltaY, deltaX, deltaY);
        y();
        return true;
    }

    public final void u() {
        if (this.j != null) {
            this.j = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            y();
        }
    }

    public final void q(int insetLeft, int insetTop, int insetRight, int insetBottom) {
        this.j = new InsetDrawable((Drawable) this.i, insetLeft, insetTop, insetRight, insetBottom);
    }
}
