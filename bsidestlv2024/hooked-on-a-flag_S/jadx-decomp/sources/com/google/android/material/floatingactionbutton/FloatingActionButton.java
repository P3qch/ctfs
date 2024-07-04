package com.google.android.material.floatingactionbutton;

import a.b.g.j;
import a.h.j.i;
import a.h.k.u;
import a.h.k.v;
import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.a.a.b.h;
import b.b.a.a.q.a;
import b.b.a.a.r.m;
import b.b.a.a.x.k;
import b.b.a.a.x.n;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.List;
import net.sqlcipher.R;
import net.sqlcipher.database.SQLiteCursor;

/* loaded from: classes.dex */
public class FloatingActionButton extends m implements u, a.h.l.m, b.b.a.a.p.a, n, CoordinatorLayout.b {
    public ColorStateList c;
    public PorterDuff.Mode d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public ColorStateList g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public b.b.a.a.q.a l;

    /* loaded from: classes.dex */
    public static abstract class b {
        public void b(FloatingActionButton fab) {
        }

        public void a(FloatingActionButton fab) {
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMeasureSpec2 = getSizeDimension();
        int preferredSize = widthMeasureSpec2 + 0;
        this.j = preferredSize / 2;
        getImpl().b0();
        throw null;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.g;
    }

    public void setRippleColor(int color) {
        setRippleColor(ColorStateList.valueOf(color));
    }

    public void setRippleColor(ColorStateList color) {
        if (this.g != color) {
            this.g = color;
            getImpl().R(this.g);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.c;
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList tint) {
        if (this.c != tint) {
            this.c = tint;
            getImpl().J(tint);
        }
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.d;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode tintMode) {
        if (this.d != tintMode) {
            this.d = tintMode;
            getImpl().K(tintMode);
        }
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintList(ColorStateList tint) {
        setBackgroundTintList(tint);
    }

    @Override // a.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode tintMode) {
        setBackgroundTintMode(tintMode);
    }

    @Override // a.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // a.h.l.m
    public void setSupportImageTintList(ColorStateList tint) {
        if (this.e != tint) {
            this.e = tint;
            p();
        }
    }

    @Override // a.h.l.m
    public ColorStateList getSupportImageTintList() {
        return this.e;
    }

    @Override // a.h.l.m
    public void setSupportImageTintMode(PorterDuff.Mode tintMode) {
        if (this.f != tintMode) {
            this.f = tintMode;
            p();
        }
    }

    @Override // a.h.l.m
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f;
    }

    public final void p() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.e;
        if (colorStateList == null) {
            a.h.d.l.a.c(drawable);
            return;
        }
        int color = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(j.e(color, mode));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int resid) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.widget.ImageView
    public void setImageResource(int resId) {
        a.b.g.n nVar = null;
        nVar.g(resId);
        throw null;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().a0();
            if (this.e != null) {
                p();
            }
        }
    }

    @Override // b.b.a.a.x.n
    public void setShapeAppearanceModel(k shapeAppearance) {
        getImpl().T(shapeAppearance);
    }

    public k getShapeAppearanceModel() {
        k t = getImpl().t();
        i.e(t);
        return t;
    }

    public void setEnsureMinTouchTargetSize(boolean flag) {
        if (flag != getImpl().n()) {
            getImpl().M(flag);
            requestLayout();
        }
    }

    @Override // b.b.a.a.r.m, android.widget.ImageView, android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
    }

    public void q(b listener) {
        r(listener, true);
    }

    public void r(b listener, boolean fromUser) {
        getImpl().Y(s(listener), fromUser);
    }

    public void e(Animator.AnimatorListener listener) {
        getImpl().e(listener);
    }

    public void k(b listener) {
        l(listener, true);
    }

    public void l(b listener, boolean fromUser) {
        getImpl().v(s(listener), fromUser);
    }

    public void d(Animator.AnimatorListener listener) {
        getImpl().d(listener);
    }

    @Override // b.b.a.a.p.a
    public boolean a() {
        b.b.a.a.p.b bVar = null;
        bVar.b();
        throw null;
    }

    public void setExpandedComponentIdHint(int expandedComponentIdHint) {
        b.b.a.a.p.b bVar = null;
        bVar.e(expandedComponentIdHint);
        throw null;
    }

    public int getExpandedComponentIdHint() {
        b.b.a.a.p.b bVar = null;
        bVar.a();
        throw null;
    }

    public void setUseCompatPadding(boolean useCompatPadding) {
        if (this.k != useCompatPadding) {
            this.k = useCompatPadding;
            getImpl().A();
        }
    }

    public boolean getUseCompatPadding() {
        return this.k;
    }

    public void setSize(int size) {
        this.i = 0;
        if (size != this.h) {
            this.h = size;
            requestLayout();
        }
    }

    public int getSize() {
        return this.h;
    }

    public final a.j s(b listener) {
        if (listener == null) {
            return null;
        }
        return new a(listener);
    }

    /* loaded from: classes.dex */
    public class a implements a.j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f1186a;

        public a(b bVar) {
            this.f1186a = bVar;
        }

        public void b() {
            this.f1186a.b(FloatingActionButton.this);
        }

        public void a() {
            this.f1186a.a(FloatingActionButton.this);
        }
    }

    public boolean m() {
        return getImpl().w();
    }

    public boolean n() {
        return getImpl().x();
    }

    public void setCustomSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (size != this.i) {
            this.i = size;
            requestLayout();
        }
    }

    public int getCustomSize() {
        return this.i;
    }

    public int getSizeDimension() {
        return j(this.h);
    }

    public final int j(int size) {
        int i = this.i;
        if (i != 0) {
            return i;
        }
        Resources res = getResources();
        switch (size) {
            case SQLiteCursor.NO_COUNT /* -1 */:
                int width = res.getConfiguration().screenWidthDp;
                int height = res.getConfiguration().screenHeightDp;
                if (Math.max(width, height) < 470) {
                    return j(1);
                }
                return j(0);
            case 0:
            default:
                return res.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            case 1:
                return res.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().z();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().C(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().y();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        if (superState == null) {
            superState = new Bundle();
        }
        new b.b.a.a.z.a(superState);
        b.b.a.a.p.b bVar = null;
        bVar.d();
        throw null;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof b.b.a.a.z.a)) {
            super.onRestoreInstanceState(state);
            return;
        }
        b.b.a.a.z.a ess = (b.b.a.a.z.a) state;
        super.onRestoreInstanceState(ess.j());
        Bundle bundle = ess.d.get("expandableWidgetHelper");
        i.e(bundle);
        b.b.a.a.p.b bVar = null;
        bVar.c(bundle);
        throw null;
    }

    @Deprecated
    public boolean h(Rect rect) {
        if (!v.T(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        o(rect);
        throw null;
    }

    public void i(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        o(rect);
        throw null;
    }

    public final void o(Rect rect) {
        int i = rect.left;
        throw null;
    }

    public Drawable getContentBackground() {
        getImpl().j();
        return null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            h(null);
        }
        return super.onTouchEvent(ev);
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
    }

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f1184a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1185b;

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return E((FloatingActionButton) view, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            H(coordinatorLayout, (FloatingActionButton) view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            I(coordinatorLayout, (FloatingActionButton) view, i);
            return true;
        }

        public BaseBehavior() {
            this.f1185b = true;
        }

        public BaseBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a2 = context.obtainStyledAttributes(attrs, b.b.a.a.a.h);
            int[] iArr = b.b.a.a.a.f942a;
            this.f1185b = a2.getBoolean(0, true);
            a2.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f lp) {
            if (lp.h == 0) {
                lp.h = 80;
            }
        }

        public boolean H(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                K(parent, (AppBarLayout) dependency, child);
                return false;
            }
            if (F(dependency)) {
                L(dependency, child);
                return false;
            }
            return false;
        }

        public static boolean F(View view) {
            ViewGroup.LayoutParams lp = view.getLayoutParams();
            if (lp instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) lp).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean J(View dependency, FloatingActionButton child) {
            CoordinatorLayout.f lp = (CoordinatorLayout.f) child.getLayoutParams();
            return this.f1185b && lp.e() == dependency.getId() && child.getUserSetVisibility() == 0;
        }

        public final boolean K(CoordinatorLayout parent, AppBarLayout appBarLayout, FloatingActionButton child) {
            if (!J(appBarLayout, child)) {
                return false;
            }
            if (this.f1184a == null) {
                this.f1184a = new Rect();
            }
            Rect rect = this.f1184a;
            b.b.a.a.r.b.a(parent, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                child.l(null, false);
                return true;
            }
            child.r(null, false);
            return true;
        }

        public final boolean L(View bottomSheet, FloatingActionButton child) {
            if (!J(bottomSheet, child)) {
                return false;
            }
            CoordinatorLayout.f lp = (CoordinatorLayout.f) child.getLayoutParams();
            if (bottomSheet.getTop() < (child.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) lp).topMargin) {
                child.l(null, false);
                return true;
            }
            child.r(null, false);
            return true;
        }

        public boolean I(CoordinatorLayout parent, FloatingActionButton child, int layoutDirection) {
            List<View> dependencies = parent.r(child);
            int count = dependencies.size();
            for (int i = 0; i < count; i++) {
                View dependency = dependencies.get(i);
                if (dependency instanceof AppBarLayout) {
                    if (K(parent, (AppBarLayout) dependency, child)) {
                        break;
                    }
                } else {
                    if (F(dependency) && L(dependency, child)) {
                        break;
                    }
                }
            }
            parent.I(child, layoutDirection);
            G(parent, child);
            return true;
        }

        public boolean E(FloatingActionButton child, Rect rect) {
            child.getClass();
            Rect shadowPadding = null;
            rect.set(child.getLeft() + shadowPadding.left, child.getTop() + shadowPadding.top, child.getRight() - shadowPadding.right, child.getBottom() - shadowPadding.bottom);
            return true;
        }

        public final void G(CoordinatorLayout parent, FloatingActionButton fab) {
            fab.getClass();
            Rect padding = null;
            if (0 != 0 && padding.centerX() > 0 && padding.centerY() > 0) {
                CoordinatorLayout.f lp = (CoordinatorLayout.f) fab.getLayoutParams();
                int offsetTB = 0;
                int offsetLR = 0;
                if (fab.getRight() >= parent.getWidth() - ((ViewGroup.MarginLayoutParams) lp).rightMargin) {
                    offsetLR = padding.right;
                } else if (fab.getLeft() <= ((ViewGroup.MarginLayoutParams) lp).leftMargin) {
                    offsetLR = -padding.left;
                }
                if (fab.getBottom() >= parent.getHeight() - ((ViewGroup.MarginLayoutParams) lp).bottomMargin) {
                    offsetTB = padding.bottom;
                } else if (fab.getTop() <= ((ViewGroup.MarginLayoutParams) lp).topMargin) {
                    offsetTB = -padding.top;
                }
                if (offsetTB != 0) {
                    v.Z(fab, offsetTB);
                }
                if (offsetLR != 0) {
                    v.Y(fab, offsetLR);
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        getImpl().c0(elevation);
    }

    public float getCompatElevation() {
        return getImpl().m();
    }

    public void setCompatElevation(float elevation) {
        getImpl().L(elevation);
    }

    public void setCompatElevationResource(int id) {
        setCompatElevation(getResources().getDimension(id));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p();
    }

    public void setCompatHoveredFocusedTranslationZ(float translationZ) {
        getImpl().O(translationZ);
    }

    public void setCompatHoveredFocusedTranslationZResource(int id) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(id));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().s();
    }

    public void setCompatPressedTranslationZ(float translationZ) {
        getImpl().Q(translationZ);
    }

    public void setCompatPressedTranslationZResource(int id) {
        setCompatPressedTranslationZ(getResources().getDimension(id));
    }

    public h getShowMotionSpec() {
        return getImpl().u();
    }

    public void setShowMotionSpec(h spec) {
        getImpl().U(spec);
    }

    public void setShowMotionSpecResource(int id) {
        setShowMotionSpec(h.c(getContext(), id));
    }

    public h getHideMotionSpec() {
        return getImpl().o();
    }

    public void setHideMotionSpec(h spec) {
        getImpl().N(spec);
    }

    public void setHideMotionSpecResource(int id) {
        setHideMotionSpec(h.c(getContext(), id));
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.b.k != com.google.android.material.animation.TransformationCallback<? extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
    public void f(b.b.a.a.b.k<? extends FloatingActionButton> kVar) {
        getImpl().f(new d(kVar));
    }

    /* loaded from: classes.dex */
    public class d<T extends FloatingActionButton> implements a.i {

        /* renamed from: a, reason: collision with root package name */
        public final b.b.a.a.b.k<T> f1189a;

        /* JADX WARN: Generic types in debug info not equals: b.b.a.a.b.k != com.google.android.material.animation.TransformationCallback<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Generic types in debug info not equals: com.google.android.material.floatingactionbutton.FloatingActionButton$d != com.google.android.material.floatingactionbutton.FloatingActionButton$TransformationCallbackWrapper<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        public d(b.b.a.a.b.k<T> kVar) {
            this.f1189a = kVar;
        }

        /* JADX WARN: Generic types in debug info not equals: com.google.android.material.floatingactionbutton.FloatingActionButton$d != com.google.android.material.floatingactionbutton.FloatingActionButton$TransformationCallbackWrapper<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        @Override // b.b.a.a.q.a.i
        public void b() {
            this.f1189a.b(FloatingActionButton.this);
        }

        /* JADX WARN: Generic types in debug info not equals: com.google.android.material.floatingactionbutton.FloatingActionButton$d != com.google.android.material.floatingactionbutton.FloatingActionButton$TransformationCallbackWrapper<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        @Override // b.b.a.a.q.a.i
        public void a() {
            this.f1189a.a(FloatingActionButton.this);
        }

        /* JADX WARN: Generic types in debug info not equals: com.google.android.material.floatingactionbutton.FloatingActionButton$d != com.google.android.material.floatingactionbutton.FloatingActionButton$TransformationCallbackWrapper<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        public boolean equals(Object obj) {
            return (obj instanceof d) && ((d) obj).f1189a.equals(this.f1189a);
        }

        /* JADX WARN: Generic types in debug info not equals: com.google.android.material.floatingactionbutton.FloatingActionButton$d != com.google.android.material.floatingactionbutton.FloatingActionButton$TransformationCallbackWrapper<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        public int hashCode() {
            return this.f1189a.hashCode();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float translationX) {
        super.setTranslationX(translationX);
        getImpl().H();
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
        getImpl().H();
    }

    @Override // android.view.View
    public void setTranslationZ(float translationZ) {
        super.setTranslationZ(translationZ);
        getImpl().H();
    }

    @Override // android.view.View
    public void setScaleX(float scaleX) {
        super.setScaleX(scaleX);
        getImpl().G();
    }

    @Override // android.view.View
    public void setScaleY(float scaleY) {
        super.setScaleY(scaleY);
        getImpl().G();
    }

    public void setShadowPaddingEnabled(boolean shadowPaddingEnabled) {
        getImpl().S(shadowPaddingEnabled);
        throw null;
    }

    private b.b.a.a.q.a getImpl() {
        if (this.l == null) {
            this.l = g();
        }
        return this.l;
    }

    public final b.b.a.a.q.a g() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new b.b.a.a.q.b(this, new c());
        }
        return new b.b.a.a.q.a(this, new c());
    }

    /* loaded from: classes.dex */
    public class c implements b.b.a.a.w.b {
        public c() {
        }

        public void c(int left, int top, int right, int bottom) {
            FloatingActionButton.this.getClass();
            Rect rect = null;
            rect.set(left, top, right, bottom);
            throw null;
        }

        public void b(Drawable background) {
            if (background != null) {
                FloatingActionButton.super.setBackgroundDrawable(background);
            }
        }

        public boolean a() {
            return FloatingActionButton.this.k;
        }
    }
}
