package a.b.f.j;

import a.b.f.j.n;
import a.h.k.b;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class i implements a.h.e.a.b {
    public a.h.k.b A;
    public MenuItem.OnActionExpandListener B;
    public ContextMenu.ContextMenuInfo D;

    /* renamed from: a, reason: collision with root package name */
    public final int f110a;

    /* renamed from: b, reason: collision with root package name */
    public final int f111b;
    public final int c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public Intent g;
    public char h;
    public char j;
    public Drawable l;
    public g n;
    public r o;
    public MenuItem.OnMenuItemClickListener p;
    public CharSequence q;
    public CharSequence r;
    public int y;
    public View z;
    public int i = 4096;
    public int k = 4096;
    public int m = 0;
    public ColorStateList s = null;
    public PorterDuff.Mode t = null;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public int x = 16;
    public boolean C = false;

    @Override // a.h.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i) {
        p(i);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        q(view);
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        v(i);
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    public i(g menu, int group, int id, int categoryOrder, int ordering, CharSequence title, int showAsAction) {
        this.y = 0;
        this.n = menu;
        this.f110a = id;
        this.f111b = group;
        this.c = categoryOrder;
        this.d = ordering;
        this.e = title;
        this.y = showAsAction;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.p;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.n;
        if (gVar.h(gVar, this)) {
            return true;
        }
        if (this.g != null) {
            try {
                this.n.u().startActivity(this.g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        a.h.k.b bVar = this.A;
        return bVar != null && bVar.e();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean enabled) {
        if (enabled) {
            this.x |= 16;
        } else {
            this.x &= -17;
        }
        this.n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f111b;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f110a;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    public int f() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        if (this.j == alphaChar) {
            return this;
        }
        this.j = Character.toLowerCase(alphaChar);
        this.n.K(false);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar, int alphaModifiers) {
        if (this.j == alphaChar && this.k == alphaModifiers) {
            return this;
        }
        this.j = Character.toLowerCase(alphaChar);
        this.k = KeyEvent.normalizeMetaState(alphaModifiers);
        this.n.K(false);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.h;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar) {
        if (this.h == numericChar) {
            return this;
        }
        this.h = numericChar;
        this.n.K(false);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar, int numericModifiers) {
        if (this.h == numericChar && this.i == numericModifiers) {
            return this;
        }
        this.h = numericChar;
        this.i = KeyEvent.normalizeMetaState(numericModifiers);
        this.n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.h = numericChar;
        this.j = Character.toLowerCase(alphaChar);
        this.n.K(false);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        this.h = numericChar;
        this.i = KeyEvent.normalizeMetaState(numericModifiers);
        this.j = Character.toLowerCase(alphaChar);
        this.k = KeyEvent.normalizeMetaState(alphaModifiers);
        this.n.K(false);
        return this;
    }

    public char g() {
        return this.n.G() ? this.j : this.h;
    }

    public String h() {
        char shortcut = g();
        if (shortcut == 0) {
            return BuildConfig.FLAVOR;
        }
        Resources res = this.n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.u()).hasPermanentMenuKey()) {
            sb.append(res.getString(R.string.abc_prepend_shortcut_label));
        }
        int modifiers = this.n.G() ? this.k : this.i;
        d(sb, modifiers, 65536, res.getString(R.string.abc_menu_meta_shortcut_label));
        d(sb, modifiers, 4096, res.getString(R.string.abc_menu_ctrl_shortcut_label));
        d(sb, modifiers, 2, res.getString(R.string.abc_menu_alt_shortcut_label));
        d(sb, modifiers, 1, res.getString(R.string.abc_menu_shift_shortcut_label));
        d(sb, modifiers, 4, res.getString(R.string.abc_menu_sym_shortcut_label));
        d(sb, modifiers, 8, res.getString(R.string.abc_menu_function_shortcut_label));
        switch (shortcut) {
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                sb.append(res.getString(R.string.abc_menu_delete_shortcut_label));
                break;
            case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                sb.append(res.getString(R.string.abc_menu_enter_shortcut_label));
                break;
            case ' ':
                sb.append(res.getString(R.string.abc_menu_space_shortcut_label));
                break;
            default:
                sb.append(shortcut);
                break;
        }
        return sb.toString();
    }

    public static void d(StringBuilder sb, int modifiers, int flag, String label) {
        if ((modifiers & flag) == flag) {
            sb.append(label);
        }
    }

    public boolean z() {
        return this.n.H() && g() != 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    public void w(r subMenu) {
        this.o = subMenu;
        subMenu.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence i(n.a itemView) {
        if (itemView != null && itemView.c()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence title) {
        this.e = title;
        this.n.K(false);
        r rVar = this.o;
        if (rVar != null) {
            rVar.setHeaderTitle(title);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int title) {
        setTitle(this.n.u().getString(title));
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence ctitle = this.f;
        if (ctitle == null) {
            ctitle = this.e;
        }
        if (Build.VERSION.SDK_INT < 18 && ctitle != null && !(ctitle instanceof String)) {
            return ctitle.toString();
        }
        return ctitle;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence title) {
        this.f = title;
        if (title == null) {
            CharSequence title2 = this.e;
        }
        this.n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.m != 0) {
            Drawable icon = a.b.c.a.a.d(this.n.u(), this.m);
            this.m = 0;
            this.l = icon;
            return e(icon);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable icon) {
        this.m = 0;
        this.l = icon;
        this.w = true;
        this.n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int iconResId) {
        this.l = null;
        this.m = iconResId;
        this.w = true;
        this.n.K(false);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList iconTintList) {
        this.s = iconTintList;
        this.u = true;
        this.w = true;
        this.n.K(false);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.s;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode iconTintMode) {
        this.t = iconTintMode;
        this.v = true;
        this.w = true;
        this.n.K(false);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.t;
    }

    public final Drawable e(Drawable icon) {
        if (icon != null && this.w && (this.u || this.v)) {
            icon = a.h.d.l.a.r(icon).mutate();
            if (this.u) {
                a.h.d.l.a.o(icon, this.s);
            }
            if (this.v) {
                a.h.d.l.a.p(icon, this.t);
            }
            this.w = false;
        }
        return icon;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.x;
        int i2 = (this.x & (-2)) | (z ? 1 : 0);
        this.x = i2;
        if (i != i2) {
            this.n.K(false);
        }
        return this;
    }

    public void t(boolean exclusive) {
        this.x = (this.x & (-5)) | (exclusive ? 4 : 0);
    }

    public boolean m() {
        return (this.x & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean checked) {
        if ((this.x & 4) != 0) {
            this.n.T(this);
        } else {
            s(checked);
        }
        return this;
    }

    public void s(boolean checked) {
        int oldFlags = this.x;
        int i = (this.x & (-3)) | (checked ? 2 : 0);
        this.x = i;
        if (oldFlags != i) {
            this.n.K(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        a.h.k.b bVar = this.A;
        return (bVar == null || !bVar.g()) ? (this.x & 8) == 0 : (this.x & 8) == 0 && this.A.b();
    }

    public boolean x(boolean shown) {
        int oldFlags = this.x;
        int i = (this.x & (-9)) | (shown ? 0 : 8);
        this.x = i;
        return oldFlags != i;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean shown) {
        if (x(shown)) {
            this.n.J();
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        this.p = clickListener;
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.D;
    }

    public void c() {
        this.n.I();
    }

    public boolean y() {
        this.n.A();
        return false;
    }

    public boolean l() {
        return (this.x & 32) == 32;
    }

    public boolean n() {
        return (this.y & 1) == 1;
    }

    public boolean o() {
        return (this.y & 2) == 2;
    }

    public void u(boolean isActionButton) {
        if (isActionButton) {
            this.x |= 32;
        } else {
            this.x &= -33;
        }
    }

    public boolean A() {
        return (this.y & 4) == 4;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public void setShowAsAction(int actionEnum) {
        switch (actionEnum & 3) {
            case 0:
            case 1:
            case 2:
                this.y = actionEnum;
                this.n.I();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public a.h.e.a.b q(View view) {
        int i;
        this.z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i = this.f110a) > 0) {
            view.setId(i);
        }
        this.n.I();
        return this;
    }

    public a.h.e.a.b p(int resId) {
        Context context = this.n.u();
        LayoutInflater inflater = LayoutInflater.from(context);
        q(inflater.inflate(resId, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public View getActionView() {
        View view = this.z;
        if (view != null) {
            return view;
        }
        a.h.k.b bVar = this.A;
        if (bVar != null) {
            View d = bVar.d(this);
            this.z = d;
            return d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // a.h.e.a.b
    public a.h.k.b a() {
        return this.A;
    }

    @Override // a.h.e.a.b
    public a.h.e.a.b b(a.h.k.b actionProvider) {
        a.h.k.b bVar = this.A;
        if (bVar != null) {
            bVar.h();
        }
        this.z = null;
        this.A = actionProvider;
        this.n.K(true);
        a.h.k.b bVar2 = this.A;
        if (bVar2 != null) {
            bVar2.j(new a());
        }
        return this;
    }

    /* loaded from: classes.dex */
    public class a implements b.InterfaceC0029b {
        public a() {
        }

        public void a(boolean isVisible) {
            i.this.n.J();
        }
    }

    public a.h.e.a.b v(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.k(this);
        }
        return false;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.f(this);
        }
        return false;
    }

    public boolean j() {
        a.h.k.b bVar;
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null && (bVar = this.A) != null) {
            this.z = bVar.d(this);
        }
        return this.z != null;
    }

    public void r(boolean isExpanded) {
        this.C = isExpanded;
        this.n.K(false);
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        this.B = listener;
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public a.h.e.a.b setContentDescription(CharSequence contentDescription) {
        this.q = contentDescription;
        this.n.K(false);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.q;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public a.h.e.a.b setTooltipText(CharSequence tooltipText) {
        this.r = tooltipText;
        this.n.K(false);
        return this;
    }

    @Override // a.h.e.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.r;
    }
}
