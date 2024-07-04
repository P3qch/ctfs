package a.b.f.j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class a implements a.h.e.a.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f93a;

    /* renamed from: b, reason: collision with root package name */
    public final int f94b;
    public final int c;
    public CharSequence d;
    public CharSequence e;
    public Intent f;
    public char g;
    public char i;
    public Drawable k;
    public Context l;
    public CharSequence m;
    public CharSequence n;
    public int h = 4096;
    public int j = 4096;
    public ColorStateList o = null;
    public PorterDuff.Mode p = null;
    public boolean q = false;
    public boolean r = false;
    public int s = 16;

    @Override // a.h.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i) {
        e();
        throw null;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        d();
        throw null;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        f(i);
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    public a(Context context, int group, int id, int ordering, CharSequence title) {
        this.l = context;
        this.f93a = id;
        this.f94b = group;
        this.c = ordering;
        this.d = title;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.i;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f94b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f93a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.g;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.e;
        return charSequence != null ? charSequence : this.d;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.s & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.s & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.s & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.s & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        this.i = Character.toLowerCase(alphaChar);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar, int alphaModifiers) {
        this.i = Character.toLowerCase(alphaChar);
        this.j = KeyEvent.normalizeMetaState(alphaModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.s = (this.s & (-2)) | (z ? 1 : 0);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean checked) {
        this.s = (this.s & (-3)) | (checked ? 2 : 0);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean enabled) {
        this.s = (this.s & (-17)) | (enabled ? 16 : 0);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable icon) {
        this.k = icon;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int iconRes) {
        this.k = a.h.c.a.d(this.l, iconRes);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar) {
        this.g = numericChar;
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar, int numericModifiers) {
        this.g = numericChar;
        this.h = KeyEvent.normalizeMetaState(numericModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.g = numericChar;
        this.i = Character.toLowerCase(alphaChar);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        this.g = numericChar;
        this.h = KeyEvent.normalizeMetaState(numericModifiers);
        this.i = Character.toLowerCase(alphaChar);
        this.j = KeyEvent.normalizeMetaState(alphaModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence title) {
        this.d = title;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int title) {
        this.d = this.l.getResources().getString(title);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence title) {
        this.e = title;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean visible) {
        this.s = (this.s & 8) | (visible ? 0 : 8);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public void setShowAsAction(int show) {
    }

    public a.h.e.a.b d() {
        throw new UnsupportedOperationException();
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public a.h.e.a.b e() {
        throw new UnsupportedOperationException();
    }

    @Override // a.h.e.a.b
    public a.h.k.b a() {
        return null;
    }

    @Override // a.h.e.a.b
    public a.h.e.a.b b(a.h.k.b actionProvider) {
        throw new UnsupportedOperationException();
    }

    public a.h.e.a.b f(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public a.h.e.a.b setContentDescription(CharSequence contentDescription) {
        this.m = contentDescription;
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.m;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public a.h.e.a.b setTooltipText(CharSequence tooltipText) {
        this.n = tooltipText;
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.n;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList iconTintList) {
        this.o = iconTintList;
        this.q = true;
        c();
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.o;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode iconTintMode) {
        this.p = iconTintMode;
        this.r = true;
        c();
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.p;
    }

    public final void c() {
        Drawable drawable = this.k;
        if (drawable != null) {
            if (this.q || this.r) {
                Drawable r = a.h.d.l.a.r(drawable);
                this.k = r;
                Drawable mutate = r.mutate();
                this.k = mutate;
                if (this.q) {
                    a.h.d.l.a.o(mutate, this.o);
                }
                if (this.r) {
                    a.h.d.l.a.p(this.k, this.p);
                }
            }
        }
    }
}
