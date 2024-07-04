package a.b.f.j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f96a;

    /* renamed from: b, reason: collision with root package name */
    public a.e.g<a.h.e.a.b, MenuItem> f97b;
    public a.e.g<a.h.e.a.c, SubMenu> c;

    public c(Context context) {
        this.f96a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof a.h.e.a.b) {
            a.h.e.a.b supportMenuItem = (a.h.e.a.b) menuItem;
            if (this.f97b == null) {
                this.f97b = new a.e.g<>();
            }
            MenuItem wrappedItem = this.f97b.get(menuItem);
            if (wrappedItem == null) {
                MenuItem wrappedItem2 = new j(this.f96a, supportMenuItem);
                this.f97b.put(supportMenuItem, wrappedItem2);
                return wrappedItem2;
            }
            return wrappedItem;
        }
        return menuItem;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (subMenu instanceof a.h.e.a.c) {
            a.h.e.a.c supportSubMenu = (a.h.e.a.c) subMenu;
            if (this.c == null) {
                this.c = new a.e.g<>();
            }
            SubMenu wrappedMenu = this.c.get(supportSubMenu);
            if (wrappedMenu == null) {
                SubMenu wrappedMenu2 = new s(this.f96a, supportSubMenu);
                this.c.put(supportSubMenu, wrappedMenu2);
                return wrappedMenu2;
            }
            return wrappedMenu;
        }
        return subMenu;
    }

    public final void e() {
        a.e.g<a.h.e.a.b, MenuItem> gVar = this.f97b;
        if (gVar != null) {
            gVar.clear();
        }
        a.e.g<a.h.e.a.c, SubMenu> gVar2 = this.c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    public final void f(int groupId) {
        if (this.f97b == null) {
            return;
        }
        int i = 0;
        while (i < this.f97b.size()) {
            if (this.f97b.i(i).getGroupId() == groupId) {
                this.f97b.k(i);
                i--;
            }
            i++;
        }
    }

    public final void g(int id) {
        if (this.f97b == null) {
            return;
        }
        for (int i = 0; i < this.f97b.size(); i++) {
            if (this.f97b.i(i).getItemId() == id) {
                this.f97b.k(i);
                return;
            }
        }
    }
}
