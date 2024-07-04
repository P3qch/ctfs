package androidx.appcompat.widget;

import a.b.b.a;
import a.b.f.j.i;
import a.b.f.j.r;
import a.b.g.a0;
import a.b.g.e0;
import a.b.g.e1;
import a.b.g.m;
import a.b.g.o;
import a.b.g.p0;
import a.b.g.x0;
import a.b.g.z0;
import a.h.k.h;
import a.h.k.v;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.R;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public ColorStateList A;
    public ColorStateList B;
    public boolean C;
    public boolean D;
    public final ArrayList<View> E;
    public final ArrayList<View> F;
    public final int[] G;
    public f H;
    public final ActionMenuView.e I;
    public z0 J;
    public a.b.g.c K;
    public d L;
    public boolean M;
    public final Runnable N;

    /* renamed from: b, reason: collision with root package name */
    public ActionMenuView f828b;
    public TextView c;
    public TextView d;
    public ImageButton e;
    public ImageView f;
    public Drawable g;
    public CharSequence h;
    public ImageButton i;
    public View j;
    public Context k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public p0 u;
    public int v;
    public int w;
    public int x;
    public CharSequence y;
    public CharSequence z;

    /* loaded from: classes.dex */
    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public class a implements ActionMenuView.e {
        public a() {
        }

        public boolean a(MenuItem item) {
            f fVar = Toolbar.this.H;
            if (fVar != null) {
                return fVar.onMenuItemClick(item);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.N();
        }
    }

    public Toolbar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.I = new a();
        this.N = new b();
        Context context2 = getContext();
        int[] iArr = a.b.a.w;
        x0 a2 = x0.v(context2, attrs, iArr, defStyleAttr, 0);
        v.m0(this, context, iArr, attrs, a2.r(), defStyleAttr, 0);
        int[] iArr2 = a.b.a.f11a;
        this.m = a2.n(28, 0);
        this.n = a2.n(19, 0);
        this.x = a2.l(0, this.x);
        this.o = a2.l(2, 48);
        int titleMargin = a2.e(22, 0);
        titleMargin = a2.s(27) ? a2.e(27, titleMargin) : titleMargin;
        this.t = titleMargin;
        this.s = titleMargin;
        this.r = titleMargin;
        this.q = titleMargin;
        int marginStart = a2.e(25, -1);
        if (marginStart >= 0) {
            this.q = marginStart;
        }
        int marginEnd = a2.e(24, -1);
        if (marginEnd >= 0) {
            this.r = marginEnd;
        }
        int marginTop = a2.e(26, -1);
        if (marginTop >= 0) {
            this.s = marginTop;
        }
        int marginBottom = a2.e(23, -1);
        if (marginBottom >= 0) {
            this.t = marginBottom;
        }
        this.p = a2.f(13, -1);
        int contentInsetStart = a2.e(9, Integer.MIN_VALUE);
        int contentInsetEnd = a2.e(5, Integer.MIN_VALUE);
        int contentInsetLeft = a2.f(7, 0);
        int contentInsetRight = a2.f(8, 0);
        h();
        this.u.e(contentInsetLeft, contentInsetRight);
        if (contentInsetStart != Integer.MIN_VALUE || contentInsetEnd != Integer.MIN_VALUE) {
            this.u.g(contentInsetStart, contentInsetEnd);
        }
        this.v = a2.e(10, Integer.MIN_VALUE);
        this.w = a2.e(6, Integer.MIN_VALUE);
        this.g = a2.g(4);
        this.h = a2.p(3);
        CharSequence title = a2.p(21);
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
        CharSequence subtitle = a2.p(18);
        if (!TextUtils.isEmpty(subtitle)) {
            setSubtitle(subtitle);
        }
        this.k = getContext();
        setPopupTheme(a2.n(17, 0));
        Drawable navIcon = a2.g(16);
        if (navIcon != null) {
            setNavigationIcon(navIcon);
        }
        CharSequence navDesc = a2.p(15);
        if (!TextUtils.isEmpty(navDesc)) {
            setNavigationContentDescription(navDesc);
        }
        Drawable logo = a2.g(11);
        if (logo != null) {
            setLogo(logo);
        }
        CharSequence logoDesc = a2.p(12);
        if (!TextUtils.isEmpty(logoDesc)) {
            setLogoDescription(logoDesc);
        }
        if (a2.s(29)) {
            setTitleTextColor(a2.c(29));
        }
        if (a2.s(20)) {
            setSubtitleTextColor(a2.c(20));
        }
        if (a2.s(14)) {
            x(a2.n(14, 0));
        }
        a2.w();
    }

    public void setPopupTheme(int resId) {
        if (this.l != resId) {
            this.l = resId;
            if (resId == 0) {
                this.k = getContext();
            } else {
                this.k = new ContextThemeWrapper(getContext(), resId);
            }
        }
    }

    public int getPopupTheme() {
        return this.l;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public void setTitleMarginStart(int margin) {
        this.q = margin;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public void setTitleMarginTop(int margin) {
        this.s = margin;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public void setTitleMarginEnd(int margin) {
        this.r = margin;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public void setTitleMarginBottom(int margin) {
        this.t = margin;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(layoutDirection);
        }
        h();
        this.u.f(layoutDirection == 1);
    }

    public void setLogo(int resId) {
        setLogo(a.b.c.a.a.d(getContext(), resId));
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f828b) != null && actionMenuView.K();
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f828b;
        return actionMenuView != null && actionMenuView.J();
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.f828b;
        return actionMenuView != null && actionMenuView.I();
    }

    public boolean N() {
        ActionMenuView actionMenuView = this.f828b;
        return actionMenuView != null && actionMenuView.P();
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f828b;
        return actionMenuView != null && actionMenuView.H();
    }

    public void I(a.b.f.j.g menu, a.b.g.c outerPresenter) {
        if (menu == null && this.f828b == null) {
            return;
        }
        k();
        a.b.f.j.g oldMenu = this.f828b.N();
        if (oldMenu == menu) {
            return;
        }
        if (oldMenu != null) {
            oldMenu.O(this.K);
            oldMenu.O(this.L);
        }
        if (this.L == null) {
            this.L = new d();
        }
        outerPresenter.G(true);
        if (menu != null) {
            menu.c(outerPresenter, this.k);
            menu.c(this.L, this.k);
        } else {
            outerPresenter.j(this.k, null);
            this.L.j(this.k, null);
            outerPresenter.h(true);
            this.L.h(true);
        }
        this.f828b.setPopupTheme(this.l);
        this.f828b.setPresenter(outerPresenter);
        this.K = outerPresenter;
    }

    public void f() {
        ActionMenuView actionMenuView = this.f828b;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f)) {
                c(this.f, true);
            }
        } else {
            ImageView imageView = this.f;
            if (imageView != null && y(imageView)) {
                removeView(this.f);
                this.F.remove(this.f);
            }
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        ImageView imageView = this.f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int resId) {
        setLogoDescription(getContext().getText(resId));
    }

    public void setLogoDescription(CharSequence description) {
        if (!TextUtils.isEmpty(description)) {
            i();
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setContentDescription(description);
        }
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public final void i() {
        if (this.f == null) {
            this.f = new o(getContext());
        }
    }

    public boolean v() {
        d dVar = this.L;
        return (dVar == null || dVar.c == null) ? false : true;
    }

    public void e() {
        d dVar = this.L;
        i item = dVar == null ? null : dVar.c;
        if (item != null) {
            item.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    public void setTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            if (this.c == null) {
                Context context = getContext();
                a0 a0Var = new a0(context);
                this.c = a0Var;
                a0Var.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.m;
                if (i != 0) {
                    this.c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
            }
            if (!y(this.c)) {
                c(this.c, true);
            }
        } else {
            TextView textView = this.c;
            if (textView != null && y(textView)) {
                removeView(this.c);
                this.F.remove(this.c);
            }
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(title);
        }
        this.y = title;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public void setSubtitle(int resId) {
        setSubtitle(getContext().getText(resId));
    }

    public void setSubtitle(CharSequence subtitle) {
        if (!TextUtils.isEmpty(subtitle)) {
            if (this.d == null) {
                Context context = getContext();
                a0 a0Var = new a0(context);
                this.d = a0Var;
                a0Var.setSingleLine();
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.n;
                if (i != 0) {
                    this.d.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.d.setTextColor(colorStateList);
                }
            }
            if (!y(this.d)) {
                c(this.d, true);
            }
        } else {
            TextView textView = this.d;
            if (textView != null && y(textView)) {
                removeView(this.d);
                this.F.remove(this.d);
            }
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setText(subtitle);
        }
        this.z = subtitle;
    }

    public void K(Context context, int resId) {
        this.m = resId;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextAppearance(context, resId);
        }
    }

    public void J(Context context, int resId) {
        this.n = resId;
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextAppearance(context, resId);
        }
    }

    public void setTitleTextColor(int color) {
        setTitleTextColor(ColorStateList.valueOf(color));
    }

    public void setTitleTextColor(ColorStateList color) {
        this.A = color;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public void setSubtitleTextColor(int color) {
        setSubtitleTextColor(ColorStateList.valueOf(color));
    }

    public void setSubtitleTextColor(ColorStateList color) {
        this.B = color;
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int resId) {
        setNavigationContentDescription(resId != 0 ? getContext().getText(resId) : null);
    }

    public void setNavigationContentDescription(CharSequence description) {
        if (!TextUtils.isEmpty(description)) {
            l();
        }
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            imageButton.setContentDescription(description);
        }
    }

    public void setNavigationIcon(int resId) {
        setNavigationIcon(a.b.c.a.a.d(getContext(), resId));
    }

    public void setNavigationIcon(Drawable icon) {
        if (icon != null) {
            l();
            if (!y(this.e)) {
                c(this.e, true);
            }
        } else {
            ImageButton imageButton = this.e;
            if (imageButton != null && y(imageButton)) {
                removeView(this.e);
                this.F.remove(this.e);
            }
        }
        ImageButton imageButton2 = this.e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(icon);
        }
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener listener) {
        l();
        this.e.setOnClickListener(listener);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setCollapseContentDescription(int resId) {
        setCollapseContentDescription(resId != 0 ? getContext().getText(resId) : null);
    }

    public void setCollapseContentDescription(CharSequence description) {
        if (!TextUtils.isEmpty(description)) {
            g();
        }
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            imageButton.setContentDescription(description);
        }
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setCollapseIcon(int resId) {
        setCollapseIcon(a.b.c.a.a.d(getContext(), resId));
    }

    public void setCollapseIcon(Drawable icon) {
        if (icon != null) {
            g();
            this.i.setImageDrawable(icon);
        } else {
            ImageButton imageButton = this.i;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.g);
            }
        }
    }

    public Menu getMenu() {
        j();
        return this.f828b.getMenu();
    }

    public void setOverflowIcon(Drawable icon) {
        j();
        this.f828b.setOverflowIcon(icon);
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f828b.getOverflowIcon();
    }

    public final void j() {
        k();
        if (this.f828b.N() == null) {
            a.b.f.j.g menu = (a.b.f.j.g) this.f828b.getMenu();
            if (this.L == null) {
                this.L = new d();
            }
            this.f828b.setExpandedActionViewsExclusive(true);
            menu.c(this.L, this.k);
        }
    }

    public final void k() {
        if (this.f828b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f828b = actionMenuView;
            actionMenuView.setPopupTheme(this.l);
            this.f828b.setOnMenuItemClickListener(this.I);
            this.f828b.O(null, null);
            e lp = generateDefaultLayoutParams();
            lp.f13a = 8388613 | (this.o & 112);
            this.f828b.setLayoutParams(lp);
            c(this.f828b, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new a.b.f.g(getContext());
    }

    public void x(int resId) {
        getMenuInflater().inflate(resId, getMenu());
    }

    public void setOnMenuItemClickListener(f listener) {
        this.H = listener;
    }

    public void H(int contentInsetStart, int contentInsetEnd) {
        h();
        this.u.g(contentInsetStart, contentInsetEnd);
    }

    public int getContentInsetStart() {
        p0 p0Var = this.u;
        if (p0Var != null) {
            return p0Var.d();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        p0 p0Var = this.u;
        if (p0Var != null) {
            return p0Var.a();
        }
        return 0;
    }

    public int getContentInsetLeft() {
        p0 p0Var = this.u;
        if (p0Var != null) {
            return p0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        p0 p0Var = this.u;
        if (p0Var != null) {
            return p0Var.c();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.v;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int insetStartWithNavigation) {
        if (insetStartWithNavigation < 0) {
            insetStartWithNavigation = Integer.MIN_VALUE;
        }
        if (insetStartWithNavigation != this.v) {
            this.v = insetStartWithNavigation;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        int i = this.w;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int insetEndWithActions) {
        if (insetEndWithActions < 0) {
            insetEndWithActions = Integer.MIN_VALUE;
        }
        if (insetEndWithActions != this.w) {
            this.w = insetEndWithActions;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.v, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean hasActions = false;
        ActionMenuView actionMenuView = this.f828b;
        if (actionMenuView != null) {
            a.b.f.j.g mb = actionMenuView.N();
            hasActions = mb != null && mb.hasVisibleItems();
        }
        if (hasActions) {
            return Math.max(getContentInsetEnd(), Math.max(this.w, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (v.C(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (v.C(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public final void l() {
        if (this.e == null) {
            this.e = new m(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            e lp = generateDefaultLayoutParams();
            lp.f13a = 8388611 | (this.o & 112);
            this.e.setLayoutParams(lp);
        }
    }

    public void g() {
        if (this.i == null) {
            m mVar = new m(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.i = mVar;
            mVar.setImageDrawable(this.g);
            this.i.setContentDescription(this.h);
            e lp = generateDefaultLayoutParams();
            lp.f13a = 8388611 | (this.o & 112);
            lp.f833b = 2;
            this.i.setLayoutParams(lp);
            this.i.setOnClickListener(new c());
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Toolbar.this.e();
        }
    }

    public final void c(View v, boolean allowHide) {
        e lp;
        ViewGroup.LayoutParams vlp = v.getLayoutParams();
        if (vlp == null) {
            lp = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(vlp)) {
            lp = generateLayoutParams(vlp);
        } else {
            lp = (e) vlp;
        }
        lp.f833b = 1;
        if (allowHide && this.j != null) {
            v.setLayoutParams(lp);
            this.F.add(v);
        } else {
            addView(v, lp);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar;
        g state = new g(super.onSaveInstanceState());
        d dVar = this.L;
        if (dVar != null && (iVar = dVar.c) != null) {
            state.d = iVar.getItemId();
        }
        state.e = A();
        return state;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        MenuItem item;
        if (!(state instanceof g)) {
            super.onRestoreInstanceState(state);
            return;
        }
        g ss = (g) state;
        super.onRestoreInstanceState(ss.j());
        ActionMenuView actionMenuView = this.f828b;
        Menu menu = actionMenuView != null ? actionMenuView.N() : null;
        int i = ss.d;
        if (i != 0 && this.L != null && menu != null && (item = menu.findItem(i)) != null) {
            item.expandActionView();
        }
        if (ss.e) {
            F();
        }
    }

    public final void F() {
        removeCallbacks(this.N);
        post(this.N);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.N);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean handled = super.onTouchEvent(ev);
            if (action == 0 && !handled) {
                this.C = true;
            }
        }
        if (action == 1 || action == 3) {
            this.C = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean handled = super.onHoverEvent(ev);
            if (action == 9 && !handled) {
                this.D = true;
            }
        }
        if (action == 10 || action == 3) {
            this.D = false;
        }
        return true;
    }

    public final void E(View child, int parentWidthSpec, int widthUsed, int parentHeightSpec, int heightUsed, int heightConstraint) {
        int size;
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        int childWidthSpec = ViewGroup.getChildMeasureSpec(parentWidthSpec, getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin + widthUsed, lp.width);
        int childHeightSpec = ViewGroup.getChildMeasureSpec(parentHeightSpec, getPaddingTop() + getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed, lp.height);
        int childHeightMode = View.MeasureSpec.getMode(childHeightSpec);
        if (childHeightMode != 1073741824 && heightConstraint >= 0) {
            if (childHeightMode != 0) {
                size = Math.min(View.MeasureSpec.getSize(childHeightSpec), heightConstraint);
            } else {
                size = heightConstraint;
            }
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    public final int D(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed, int[] collapsingMargins) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        int leftDiff = lp.leftMargin - collapsingMargins[0];
        int rightDiff = lp.rightMargin - collapsingMargins[1];
        int leftMargin = Math.max(0, leftDiff);
        int rightMargin = Math.max(0, rightDiff);
        int hMargins = leftMargin + rightMargin;
        collapsingMargins[0] = Math.max(0, -leftDiff);
        collapsingMargins[1] = Math.max(0, -rightDiff);
        int childWidthMeasureSpec = ViewGroup.getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight() + hMargins + widthUsed, lp.width);
        int childHeightMeasureSpec = ViewGroup.getChildMeasureSpec(parentHeightMeasureSpec, getPaddingTop() + getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        return child.getMeasuredWidth() + hMargins;
    }

    public final boolean L() {
        if (!this.M) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (M(child) && child.getMeasuredWidth() > 0 && child.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int marginStartIndex;
        int marginEndIndex;
        int marginStartIndex2;
        int menuWidth;
        int titleHeight;
        int childState;
        int childCount;
        int height = 0;
        int childState2 = 0;
        int[] collapsingMargins = this.G;
        if (e1.b(this)) {
            marginStartIndex = 1;
            marginEndIndex = 0;
        } else {
            marginStartIndex = 0;
            marginEndIndex = 1;
        }
        int navWidth = 0;
        if (M(this.e)) {
            E(this.e, widthMeasureSpec, 0, heightMeasureSpec, 0, this.p);
            navWidth = this.e.getMeasuredWidth() + s(this.e);
            height = Math.max(0, this.e.getMeasuredHeight() + t(this.e));
            childState2 = View.combineMeasuredStates(0, this.e.getMeasuredState());
        }
        if (M(this.i)) {
            E(this.i, widthMeasureSpec, 0, heightMeasureSpec, 0, this.p);
            navWidth = this.i.getMeasuredWidth() + s(this.i);
            height = Math.max(height, this.i.getMeasuredHeight() + t(this.i));
            childState2 = View.combineMeasuredStates(childState2, this.i.getMeasuredState());
        }
        int contentInsetStart = getCurrentContentInsetStart();
        int width = 0 + Math.max(contentInsetStart, navWidth);
        collapsingMargins[marginStartIndex] = Math.max(0, contentInsetStart - navWidth);
        if (M(this.f828b)) {
            marginStartIndex2 = 0;
            E(this.f828b, widthMeasureSpec, width, heightMeasureSpec, 0, this.p);
            int menuWidth2 = this.f828b.getMeasuredWidth() + s(this.f828b);
            height = Math.max(height, this.f828b.getMeasuredHeight() + t(this.f828b));
            childState2 = View.combineMeasuredStates(childState2, this.f828b.getMeasuredState());
            menuWidth = menuWidth2;
        } else {
            marginStartIndex2 = 0;
            menuWidth = 0;
        }
        int contentInsetEnd = getCurrentContentInsetEnd();
        int width2 = width + Math.max(contentInsetEnd, menuWidth);
        collapsingMargins[marginEndIndex] = Math.max(marginStartIndex2, contentInsetEnd - menuWidth);
        if (M(this.j)) {
            width2 += D(this.j, widthMeasureSpec, width2, heightMeasureSpec, 0, collapsingMargins);
            height = Math.max(height, this.j.getMeasuredHeight() + t(this.j));
            childState2 = View.combineMeasuredStates(childState2, this.j.getMeasuredState());
        }
        if (M(this.f)) {
            width2 += D(this.f, widthMeasureSpec, width2, heightMeasureSpec, 0, collapsingMargins);
            height = Math.max(height, this.f.getMeasuredHeight() + t(this.f));
            childState2 = View.combineMeasuredStates(childState2, this.f.getMeasuredState());
        }
        int childCount2 = getChildCount();
        int childState3 = childState2;
        int height2 = height;
        int width3 = width2;
        int width4 = 0;
        while (width4 < childCount2) {
            View child = getChildAt(width4);
            e lp = (e) child.getLayoutParams();
            if (lp.f833b != 0) {
                childState = childState3;
                childCount = childCount2;
            } else if (!M(child)) {
                childState = childState3;
                childCount = childCount2;
            } else {
                childCount = childCount2;
                width3 += D(child, widthMeasureSpec, width3, heightMeasureSpec, 0, collapsingMargins);
                height2 = Math.max(height2, child.getMeasuredHeight() + t(child));
                childState3 = View.combineMeasuredStates(childState3, child.getMeasuredState());
                width4++;
                childCount2 = childCount;
            }
            childState3 = childState;
            width4++;
            childCount2 = childCount;
        }
        int childState4 = childState3;
        int titleWidth = 0;
        int titleHeight2 = 0;
        int titleVertMargins = this.s + this.t;
        int titleHorizMargins = this.q + this.r;
        if (M(this.c)) {
            D(this.c, widthMeasureSpec, width3 + titleHorizMargins, heightMeasureSpec, titleVertMargins, collapsingMargins);
            titleWidth = this.c.getMeasuredWidth() + s(this.c);
            titleHeight2 = this.c.getMeasuredHeight() + t(this.c);
            childState4 = View.combineMeasuredStates(childState4, this.c.getMeasuredState());
        }
        if (!M(this.d)) {
            titleHeight = titleHeight2;
        } else {
            titleWidth = Math.max(titleWidth, D(this.d, widthMeasureSpec, width3 + titleHorizMargins, heightMeasureSpec, titleHeight2 + titleVertMargins, collapsingMargins));
            int titleHeight3 = titleHeight2 + this.d.getMeasuredHeight() + t(this.d);
            childState4 = View.combineMeasuredStates(childState4, this.d.getMeasuredState());
            titleHeight = titleHeight3;
        }
        int height3 = Math.max(height2, titleHeight);
        int width5 = width3 + titleWidth + getPaddingLeft() + getPaddingRight();
        int height4 = height3 + getPaddingTop() + getPaddingBottom();
        int measuredWidth = View.resolveSizeAndState(Math.max(width5, getSuggestedMinimumWidth()), widthMeasureSpec, (-16777216) & childState4);
        int measuredHeight = View.resolveSizeAndState(Math.max(height4, getSuggestedMinimumHeight()), heightMeasureSpec, childState4 << 16);
        setMeasuredDimension(measuredWidth, L() ? 0 : measuredHeight);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x015e, code lost:
    
        if (r33.c.getMeasuredWidth() > 0) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0256  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r34, int r35, int r36, int r37, int r38) {
        /*
            Method dump skipped, instructions count: 874
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    public final int u(List<View> views, int[] collapsingMargins) {
        int collapseLeft = collapsingMargins[0];
        int collapseRight = collapsingMargins[1];
        int width = 0;
        int count = views.size();
        for (int i = 0; i < count; i++) {
            View v = views.get(i);
            e lp = (e) v.getLayoutParams();
            int l = ((ViewGroup.MarginLayoutParams) lp).leftMargin - collapseLeft;
            int r = ((ViewGroup.MarginLayoutParams) lp).rightMargin - collapseRight;
            int leftMargin = Math.max(0, l);
            int rightMargin = Math.max(0, r);
            collapseLeft = Math.max(0, -l);
            collapseRight = Math.max(0, -r);
            width += v.getMeasuredWidth() + leftMargin + rightMargin;
        }
        return width;
    }

    public final int B(View child, int left, int[] collapsingMargins, int alignmentHeight) {
        e lp = (e) child.getLayoutParams();
        int l = ((ViewGroup.MarginLayoutParams) lp).leftMargin - collapsingMargins[0];
        int left2 = left + Math.max(0, l);
        collapsingMargins[0] = Math.max(0, -l);
        int top = q(child, alignmentHeight);
        int childWidth = child.getMeasuredWidth();
        child.layout(left2, top, left2 + childWidth, child.getMeasuredHeight() + top);
        return left2 + ((ViewGroup.MarginLayoutParams) lp).rightMargin + childWidth;
    }

    public final int C(View child, int right, int[] collapsingMargins, int alignmentHeight) {
        e lp = (e) child.getLayoutParams();
        int r = ((ViewGroup.MarginLayoutParams) lp).rightMargin - collapsingMargins[1];
        int right2 = right - Math.max(0, r);
        collapsingMargins[1] = Math.max(0, -r);
        int top = q(child, alignmentHeight);
        int childWidth = child.getMeasuredWidth();
        child.layout(right2 - childWidth, top, right2, child.getMeasuredHeight() + top);
        return right2 - (((ViewGroup.MarginLayoutParams) lp).leftMargin + childWidth);
    }

    public final int q(View child, int alignmentHeight) {
        e lp = (e) child.getLayoutParams();
        int childHeight = child.getMeasuredHeight();
        int alignmentOffset = alignmentHeight > 0 ? (childHeight - alignmentHeight) / 2 : 0;
        switch (r(lp.f13a)) {
            case 48:
                return getPaddingTop() - alignmentOffset;
            case 80:
                return (((getHeight() - getPaddingBottom()) - childHeight) - ((ViewGroup.MarginLayoutParams) lp).bottomMargin) - alignmentOffset;
            default:
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int space = (height - paddingTop) - paddingBottom;
                int spaceAbove = (space - childHeight) / 2;
                if (spaceAbove < ((ViewGroup.MarginLayoutParams) lp).topMargin) {
                    spaceAbove = ((ViewGroup.MarginLayoutParams) lp).topMargin;
                } else {
                    int spaceBelow = (((height - paddingBottom) - childHeight) - spaceAbove) - paddingTop;
                    int i = ((ViewGroup.MarginLayoutParams) lp).bottomMargin;
                    if (spaceBelow < i) {
                        spaceAbove = Math.max(0, spaceAbove - (i - spaceBelow));
                    }
                }
                return paddingTop + spaceAbove;
        }
    }

    public final int r(int gravity) {
        int vgrav = gravity & 112;
        switch (vgrav) {
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
            case 48:
            case 80:
                return vgrav;
            default:
                return this.x & 112;
        }
    }

    public final void b(List<View> views, int gravity) {
        boolean isRtl = v.C(this) == 1;
        int childCount = getChildCount();
        int absGrav = a.h.k.e.b(gravity, v.C(this));
        views.clear();
        if (isRtl) {
            for (int i = childCount - 1; i >= 0; i--) {
                View child = getChildAt(i);
                e lp = (e) child.getLayoutParams();
                if (lp.f833b == 0 && M(child) && p(lp.f13a) == absGrav) {
                    views.add(child);
                }
            }
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View child2 = getChildAt(i2);
            e lp2 = (e) child2.getLayoutParams();
            if (lp2.f833b == 0 && M(child2) && p(lp2.f13a) == absGrav) {
                views.add(child2);
            }
        }
    }

    public final int p(int gravity) {
        int ld = v.C(this);
        int absGrav = a.h.k.e.b(gravity, ld);
        int hGrav = absGrav & 7;
        switch (hGrav) {
            case 1:
            case 3:
            case 5:
                return hGrav;
            case 2:
            case 4:
            default:
                return ld == 1 ? 5 : 3;
        }
    }

    public final boolean M(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final int s(View v) {
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        return h.b(mlp) + h.a(mlp);
    }

    public final int t(View v) {
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        return mlp.topMargin + mlp.bottomMargin;
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attrs) {
        return new e(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams p) {
        if (p instanceof e) {
            return new e((e) p);
        }
        if (p instanceof a.C0001a) {
            return new e((a.C0001a) p);
        }
        if (p instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) p);
        }
        return new e(p);
    }

    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return super.checkLayoutParams(p) && (p instanceof e);
    }

    public e0 getWrapper() {
        if (this.J == null) {
            this.J = new z0(this, true);
        }
        return this.J;
    }

    public void G() {
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            View child = getChildAt(i);
            e lp = (e) child.getLayoutParams();
            if (lp.f833b != 2 && child != this.f828b) {
                removeViewAt(i);
                this.F.add(child);
            }
        }
    }

    public void a() {
        int count = this.F.size();
        for (int i = count - 1; i >= 0; i--) {
            addView(this.F.get(i));
        }
        this.F.clear();
    }

    public final boolean y(View child) {
        return child.getParent() == this || this.F.contains(child);
    }

    public void setCollapsible(boolean collapsible) {
        this.M = collapsible;
        requestLayout();
    }

    public final void h() {
        if (this.u == null) {
            this.u = new p0();
        }
    }

    public final TextView getTitleTextView() {
        return this.c;
    }

    public final TextView getSubtitleTextView() {
        return this.d;
    }

    public a.b.g.c getOuterActionMenuPresenter() {
        return this.K;
    }

    public Context getPopupContext() {
        return this.k;
    }

    /* loaded from: classes.dex */
    public static class e extends a.C0001a {

        /* renamed from: b, reason: collision with root package name */
        public int f833b;

        public e(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.f833b = 0;
        }

        public e(int width, int height) {
            super(width, height);
            this.f833b = 0;
            this.f13a = 8388627;
        }

        public e(e source) {
            super((a.C0001a) source);
            this.f833b = 0;
            this.f833b = source.f833b;
        }

        public e(a.C0001a source) {
            super(source);
            this.f833b = 0;
        }

        public e(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.f833b = 0;
            a(source);
        }

        public e(ViewGroup.LayoutParams source) {
            super(source);
            this.f833b = 0;
        }

        public void a(ViewGroup.MarginLayoutParams source) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = source.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = source.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = source.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = source.bottomMargin;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends a.j.a.a {
        public static final Parcelable.Creator<g> CREATOR = new a();
        public int d;
        public boolean e;

        public g(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.d = source.readInt();
            this.e = source.readInt() != 0;
        }

        public g(Parcelable superState) {
            super(superState);
        }

        @Override // a.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e ? 1 : 0);
        }

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<g> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel in, ClassLoader loader) {
                return new g(in, loader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel in) {
                return new g(in, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int size) {
                return new g[size];
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.b.f.j.m {

        /* renamed from: b, reason: collision with root package name */
        public a.b.f.j.g f832b;
        public i c;

        public d() {
        }

        @Override // a.b.f.j.m
        public void j(Context context, a.b.f.j.g menu) {
            i iVar;
            a.b.f.j.g gVar = this.f832b;
            if (gVar != null && (iVar = this.c) != null) {
                gVar.f(iVar);
            }
            this.f832b = menu;
        }

        @Override // a.b.f.j.m
        public void h(boolean cleared) {
            if (this.c != null) {
                boolean found = false;
                a.b.f.j.g gVar = this.f832b;
                if (gVar != null) {
                    int count = gVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= count) {
                            break;
                        }
                        MenuItem item = this.f832b.getItem(i);
                        if (item != this.c) {
                            i++;
                        } else {
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    k(this.f832b, this.c);
                }
            }
        }

        @Override // a.b.f.j.m
        public boolean f(r subMenu) {
            return false;
        }

        @Override // a.b.f.j.m
        public void b(a.b.f.j.g menu, boolean allMenusAreClosing) {
        }

        @Override // a.b.f.j.m
        public boolean g() {
            return false;
        }

        @Override // a.b.f.j.m
        public boolean c(a.b.f.j.g menu, i item) {
            Toolbar.this.g();
            ViewParent collapseButtonParent = Toolbar.this.i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (collapseButtonParent != toolbar) {
                if (collapseButtonParent instanceof ViewGroup) {
                    ((ViewGroup) collapseButtonParent).removeView(toolbar.i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.i);
            }
            Toolbar.this.j = item.getActionView();
            this.c = item;
            ViewParent expandedActionParent = Toolbar.this.j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (expandedActionParent != toolbar3) {
                if (expandedActionParent instanceof ViewGroup) {
                    ((ViewGroup) expandedActionParent).removeView(toolbar3.j);
                }
                e lp = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                lp.f13a = 8388611 | (toolbar4.o & 112);
                lp.f833b = 2;
                toolbar4.j.setLayoutParams(lp);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.j);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            item.r(true);
            KeyEvent.Callback callback = Toolbar.this.j;
            if (callback instanceof a.b.f.c) {
                ((a.b.f.c) callback).a();
            }
            return true;
        }

        @Override // a.b.f.j.m
        public boolean k(a.b.f.j.g menu, i item) {
            KeyEvent.Callback callback = Toolbar.this.j;
            if (callback instanceof a.b.f.c) {
                ((a.b.f.c) callback).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.j = null;
            toolbar3.a();
            this.c = null;
            Toolbar.this.requestLayout();
            item.r(false);
            return true;
        }
    }
}
