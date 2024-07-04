package androidx.appcompat.view.menu;

import a.b.f.j.g;
import a.b.f.j.i;
import a.b.f.j.n;
import a.b.f.j.p;
import a.b.g.a0;
import a.b.g.a1;
import a.b.g.i0;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;

/* loaded from: classes.dex */
public class ActionMenuItemView extends a0 implements n.a, View.OnClickListener, ActionMenuView.a {
    public i g;
    public CharSequence h;
    public Drawable i;
    public g.b j;
    public i0 k;
    public b l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract p a();
    }

    public ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Resources res = context.getResources();
        this.m = g();
        TypedArray a2 = context.obtainStyledAttributes(attrs, a.b.a.c, defStyle, 0);
        int[] iArr = a.b.a.f11a;
        this.o = a2.getDimensionPixelSize(0, 0);
        a2.recycle();
        float density = res.getDisplayMetrics().density;
        this.q = (int) ((32.0f * density) + 0.5f);
        setOnClickListener(this);
        this.p = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.m = g();
        h();
    }

    public final boolean g() {
        Configuration config = getContext().getResources().getConfiguration();
        int widthDp = config.screenWidthDp;
        int heightDp = config.screenHeightDp;
        return widthDp >= 480 || (widthDp >= 640 && heightDp >= 480) || config.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int l, int t, int r, int b2) {
        this.p = l;
        super.setPadding(l, t, r, b2);
    }

    @Override // a.b.f.j.n.a
    public i getItemData() {
        return this.g;
    }

    @Override // a.b.f.j.n.a
    public void e(i itemData, int menuType) {
        this.g = itemData;
        setIcon(itemData.getIcon());
        setTitle(itemData.i(this));
        setId(itemData.getItemId());
        setVisibility(itemData.isVisible() ? 0 : 8);
        setEnabled(itemData.isEnabled());
        if (itemData.hasSubMenu() && this.k == null) {
            this.k = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent e) {
        i0 i0Var;
        if (this.g.hasSubMenu() && (i0Var = this.k) != null && i0Var.onTouch(this, e)) {
            return true;
        }
        return super.onTouchEvent(e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        g.b bVar = this.j;
        if (bVar != null) {
            bVar.b(this.g);
        }
    }

    public void setItemInvoker(g.b invoker) {
        this.j = invoker;
    }

    public void setPopupCallback(b popupCallback) {
        this.l = popupCallback;
    }

    @Override // a.b.f.j.n.a
    public boolean c() {
        return true;
    }

    public void setCheckable(boolean checkable) {
    }

    public void setChecked(boolean checked) {
    }

    public void setExpandedFormat(boolean expandedFormat) {
        if (this.n != expandedFormat) {
            this.n = expandedFormat;
            i iVar = this.g;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    public final void h() {
        boolean z = true;
        boolean visible = !TextUtils.isEmpty(this.h);
        if (this.i != null && (!this.g.A() || (!this.m && !this.n))) {
            z = false;
        }
        boolean visible2 = visible & z;
        setText(visible2 ? this.h : null);
        CharSequence contentDescription = this.g.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(visible2 ? null : this.g.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.g.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            a1.a(this, visible2 ? null : this.g.getTitle());
        } else {
            a1.a(this, tooltipText);
        }
    }

    public void setIcon(Drawable icon) {
        this.i = icon;
        if (icon != null) {
            int width = icon.getIntrinsicWidth();
            int height = icon.getIntrinsicHeight();
            int i = this.q;
            if (width > i) {
                float scale = i / width;
                width = this.q;
                height = (int) (height * scale);
            }
            if (height > i) {
                float scale2 = i / height;
                height = this.q;
                width = (int) (width * scale2);
            }
            icon.setBounds(0, 0, width, height);
        }
        setCompoundDrawables(icon, null, null, null);
        h();
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence title) {
        this.h = title;
        h();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return f() && this.g.getIcon() == null;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f();
    }

    @Override // a.b.g.a0, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        boolean textVisible = f();
        if (textVisible && (i = this.p) >= 0) {
            super.setPadding(i, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int oldMeasuredWidth = getMeasuredWidth();
        int targetWidth = widthMode == Integer.MIN_VALUE ? Math.min(widthSize, this.o) : this.o;
        if (widthMode != 1073741824 && this.o > 0 && oldMeasuredWidth < targetWidth) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(targetWidth, 1073741824), heightMeasureSpec);
        }
        if (!textVisible && this.i != null) {
            int w = getMeasuredWidth();
            int dw = this.i.getBounds().width();
            super.setPadding((w - dw) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    /* loaded from: classes.dex */
    public class a extends i0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // a.b.g.i0
        public p b() {
            b bVar = ActionMenuItemView.this.l;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // a.b.g.i0
        public boolean c() {
            p popup;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.j;
            return bVar != null && bVar.b(actionMenuItemView.g) && (popup = b()) != null && popup.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(null);
    }
}
