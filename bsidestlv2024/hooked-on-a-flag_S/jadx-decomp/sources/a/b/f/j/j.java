package a.b.f.j;

import a.b.f.j.i;
import a.h.k.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class j extends a.b.f.j.c implements MenuItem {
    public final a.h.e.a.b d;
    public Method e;

    public j(Context context, a.h.e.a.b object) {
        super(context);
        if (object == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.d = object;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.d.getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.d.getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.d.getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence title) {
        this.d.setTitle(title);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int title) {
        this.d.setTitle(title);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.d.getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence title) {
        this.d.setTitleCondensed(title);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable icon) {
        this.d.setIcon(icon);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int iconRes) {
        this.d.setIcon(iconRes);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.d.getIcon();
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.d.getIntent();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.d.setShortcut(numericChar, alphaChar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        this.d.setShortcut(numericChar, alphaChar, numericModifiers, alphaModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar) {
        this.d.setNumericShortcut(numericChar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar, int numericModifiers) {
        this.d.setNumericShortcut(numericChar, numericModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        this.d.setAlphabeticShortcut(alphaChar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar, int alphaModifiers) {
        this.d.setAlphabeticShortcut(alphaChar, alphaModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean checkable) {
        this.d.setCheckable(checkable);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.d.isCheckable();
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean checked) {
        this.d.setChecked(checked);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.d.isChecked();
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean visible) {
        return this.d.setVisible(visible);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean enabled) {
        this.d.setEnabled(enabled);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener) {
        this.d.setOnMenuItemClickListener(menuItemClickListener != null ? new e(menuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int actionEnum) {
        this.d.setShowAsAction(actionEnum);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int actionEnum) {
        this.d.setShowAsActionFlags(actionEnum);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int resId) {
        this.d.setActionView(resId);
        View actionView = this.d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.d.setActionView(new c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.d.getActionView();
        if (actionView instanceof c) {
            return ((c) actionView).b();
        }
        return actionView;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider provider) {
        a actionProviderWrapper = new b(this, this.f96a, provider);
        this.d.b(provider != null ? actionProviderWrapper : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        a.h.k.b provider = this.d.a();
        if (provider instanceof a) {
            return ((a) provider).f113b;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.d.expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        this.d.setOnActionExpandListener(listener != null ? new d(listener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence contentDescription) {
        this.d.setContentDescription(contentDescription);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence tooltipText) {
        this.d.setTooltipText(tooltipText);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList tint) {
        this.d.setIconTintList(tint);
        return this;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode tintMode) {
        this.d.setIconTintMode(tintMode);
        return this;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.d.getIconTintMode();
    }

    public void h(boolean checkable) {
        try {
            if (this.e == null) {
                this.e = this.d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.e.invoke(this.d, Boolean.valueOf(checkable));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    /* loaded from: classes.dex */
    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f117a;

        public e(MenuItem.OnMenuItemClickListener object) {
            this.f117a = object;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem item) {
            return this.f117a.onMenuItemClick(j.this.c(item));
        }
    }

    /* loaded from: classes.dex */
    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f115a;

        public d(MenuItem.OnActionExpandListener object) {
            this.f115a = object;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem item) {
            return this.f115a.onMenuItemActionExpand(j.this.c(item));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem item) {
            return this.f115a.onMenuItemActionCollapse(j.this.c(item));
        }
    }

    /* loaded from: classes.dex */
    public class a extends a.h.k.b {

        /* renamed from: b, reason: collision with root package name */
        public final ActionProvider f113b;

        public a(Context context, ActionProvider inner) {
            super(context);
            this.f113b = inner;
        }

        @Override // a.h.k.b
        public View c() {
            return this.f113b.onCreateActionView();
        }

        @Override // a.h.k.b
        public boolean e() {
            return this.f113b.onPerformDefaultAction();
        }

        @Override // a.h.k.b
        public boolean a() {
            return this.f113b.hasSubMenu();
        }

        @Override // a.h.k.b
        public void f(SubMenu subMenu) {
            this.f113b.onPrepareSubMenu(j.this.d(subMenu));
        }
    }

    /* loaded from: classes.dex */
    public class b extends a implements ActionProvider.VisibilityListener {
        public b.InterfaceC0029b d;

        public b(j jVar, Context context, ActionProvider inner) {
            super(context, inner);
        }

        @Override // a.h.k.b
        public View d(MenuItem forItem) {
            return this.f113b.onCreateActionView(forItem);
        }

        @Override // a.h.k.b
        public boolean g() {
            return this.f113b.overridesItemVisibility();
        }

        @Override // a.h.k.b
        public boolean b() {
            return this.f113b.isVisible();
        }

        @Override // a.h.k.b
        public void j(b.InterfaceC0029b listener) {
            this.d = listener;
            this.f113b.setVisibilityListener(listener != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean isVisible) {
            b.InterfaceC0029b interfaceC0029b = this.d;
            if (interfaceC0029b != null) {
                ((i.a) interfaceC0029b).a(isVisible);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends FrameLayout implements a.b.f.c {

        /* renamed from: b, reason: collision with root package name */
        public final CollapsibleActionView f114b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(View view) {
            super(view.getContext());
            this.f114b = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // a.b.f.c
        public void a() {
            this.f114b.onActionViewExpanded();
        }

        @Override // a.b.f.c
        public void f() {
            this.f114b.onActionViewCollapsed();
        }

        public View b() {
            return (View) this.f114b;
        }
    }
}
