package com.google.android.material.internal;

import a.b.f.j.i;
import a.b.f.j.n;
import a.b.g.a1;
import a.b.g.j0;
import a.h.c.c.f;
import a.h.k.e0.c;
import a.h.k.v;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import b.b.a.a.r.d;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements n.a {
    public static final int[] w = {R.attr.state_checked};
    public final CheckedTextView A;
    public FrameLayout B;
    public i C;
    public ColorStateList D;
    public boolean E;
    public Drawable F;
    public final a.h.k.a G;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes.dex */
    public class a extends a.h.k.a {
        public a() {
        }

        @Override // a.h.k.a
        public void g(View host, c info) {
            super.g(host, info);
            info.U(NavigationMenuItemView.this.z);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a aVar = new a();
        this.G = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(net.sqlcipher.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(net.sqlcipher.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(net.sqlcipher.R.id.design_menu_item_text);
        this.A = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        v.o0(checkedTextView, aVar);
    }

    @Override // a.b.f.j.n.a
    public void e(i itemData, int menuType) {
        this.C = itemData;
        if (itemData.getItemId() > 0) {
            setId(itemData.getItemId());
        }
        setVisibility(itemData.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            v.r0(this, C());
        }
        setCheckable(itemData.isCheckable());
        setChecked(itemData.isChecked());
        setEnabled(itemData.isEnabled());
        setTitle(itemData.getTitle());
        setIcon(itemData.getIcon());
        setActionView(itemData.getActionView());
        setContentDescription(itemData.getContentDescription());
        a1.a(this, itemData.getTooltipText());
        B();
    }

    public final boolean D() {
        return this.C.getTitle() == null && this.C.getIcon() == null && this.C.getActionView() != null;
    }

    public final void B() {
        if (D()) {
            this.A.setVisibility(8);
            FrameLayout frameLayout = this.B;
            if (frameLayout != null) {
                j0.a params = (j0.a) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) params).width = -1;
                this.B.setLayoutParams(params);
                return;
            }
            return;
        }
        this.A.setVisibility(0);
        FrameLayout frameLayout2 = this.B;
        if (frameLayout2 != null) {
            j0.a params2 = (j0.a) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) params2).width = -2;
            this.B.setLayoutParams(params2);
        }
    }

    private void setActionView(View actionView) {
        if (actionView != null) {
            if (this.B == null) {
                this.B = (FrameLayout) ((ViewStub) findViewById(net.sqlcipher.R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.B.removeAllViews();
            this.B.addView(actionView);
        }
    }

    public final StateListDrawable C() {
        TypedValue value = new TypedValue();
        if (getContext().getTheme().resolveAttribute(net.sqlcipher.R.attr.colorControlHighlight, value, true)) {
            StateListDrawable drawable = new StateListDrawable();
            drawable.addState(w, new ColorDrawable(value.data));
            drawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return drawable;
        }
        return null;
    }

    @Override // a.b.f.j.n.a
    public i getItemData() {
        return this.C;
    }

    public void setTitle(CharSequence title) {
        this.A.setText(title);
    }

    public void setCheckable(boolean checkable) {
        refreshDrawableState();
        if (this.z != checkable) {
            this.z = checkable;
            this.G.l(this.A, 2048);
        }
    }

    public void setChecked(boolean checked) {
        refreshDrawableState();
        this.A.setChecked(checked);
    }

    public void setIcon(Drawable icon) {
        if (icon != null) {
            if (this.E) {
                Drawable.ConstantState state = icon.getConstantState();
                icon = a.h.d.l.a.r(state == null ? icon : state.newDrawable()).mutate();
                a.h.d.l.a.o(icon, this.D);
            }
            int i = this.x;
            icon.setBounds(0, 0, i, i);
        } else if (this.y) {
            if (this.F == null) {
                Drawable b2 = f.b(getResources(), net.sqlcipher.R.drawable.navigation_empty_icon, getContext().getTheme());
                this.F = b2;
                if (b2 != null) {
                    int i2 = this.x;
                    b2.setBounds(0, 0, i2, i2);
                }
            }
            icon = this.F;
        }
        a.h.l.i.i(this.A, icon, null, null, null);
    }

    public void setIconSize(int iconSize) {
        this.x = iconSize;
    }

    @Override // a.b.f.j.n.a
    public boolean c() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        i iVar = this.C;
        if (iVar != null && iVar.isCheckable() && this.C.isChecked()) {
            ViewGroup.mergeDrawableStates(drawableState, w);
        }
        return drawableState;
    }

    public void setIconTintList(ColorStateList tintList) {
        this.D = tintList;
        this.E = tintList != null;
        i iVar = this.C;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setTextAppearance(int textAppearance) {
        a.h.l.i.n(this.A, textAppearance);
    }

    public void setTextColor(ColorStateList colors) {
        this.A.setTextColor(colors);
    }

    public void setNeedsEmptyIcon(boolean needsEmptyIcon) {
        this.y = needsEmptyIcon;
    }

    public void setHorizontalPadding(int padding) {
        setPadding(padding, 0, padding, 0);
    }

    public void setIconPadding(int padding) {
        this.A.setCompoundDrawablePadding(padding);
    }

    public void setMaxLines(int maxLines) {
        this.A.setMaxLines(maxLines);
    }
}
