package a.b.f.j;

import a.b.f.j.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class r extends g implements SubMenu {
    public g A;
    public i B;

    public r(Context context, g parentMenu, i item) {
        super(context);
        this.A = parentMenu;
        this.B = item;
    }

    @Override // a.b.f.j.g, android.view.Menu
    public void setQwertyMode(boolean isQwerty) {
        this.A.setQwertyMode(isQwerty);
    }

    @Override // a.b.f.j.g
    public boolean G() {
        return this.A.G();
    }

    @Override // a.b.f.j.g
    public boolean H() {
        return this.A.H();
    }

    public Menu e0() {
        return this.A;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.B;
    }

    @Override // a.b.f.j.g
    public void R(g.a callback) {
        this.A.R(callback);
    }

    @Override // a.b.f.j.g
    public g D() {
        return this.A.D();
    }

    @Override // a.b.f.j.g
    public boolean h(g menu, MenuItem item) {
        return super.h(menu, item) || this.A.h(menu, item);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable icon) {
        this.B.setIcon(icon);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int iconRes) {
        this.B.setIcon(iconRes);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable icon) {
        V(icon);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int iconRes) {
        U(iconRes);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence title) {
        Y(title);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int titleRes) {
        X(titleRes);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        Z(view);
        return this;
    }

    @Override // a.b.f.j.g
    public boolean k(i item) {
        return this.A.k(item);
    }

    @Override // a.b.f.j.g
    public boolean f(i item) {
        return this.A.f(item);
    }

    @Override // a.b.f.j.g
    public String t() {
        i iVar = this.B;
        int itemId = iVar != null ? iVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        super.t();
        sb.append("android:menu:actionviewstates");
        sb.append(":");
        sb.append(itemId);
        return sb.toString();
    }

    @Override // a.b.f.j.g, android.view.Menu
    public void setGroupDividerEnabled(boolean groupDividerEnabled) {
        this.A.setGroupDividerEnabled(groupDividerEnabled);
    }

    @Override // a.b.f.j.g
    public boolean F() {
        return this.A.F();
    }
}
