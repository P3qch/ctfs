package a.b.f.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
public class o extends c implements Menu {
    public final a.h.e.a.a d;

    public o(Context context, a.h.e.a.a object) {
        super(context);
        if (object == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.d = object;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence title) {
        return c(this.d.add(title));
    }

    @Override // android.view.Menu
    public MenuItem add(int titleRes) {
        return c(this.d.add(titleRes));
    }

    @Override // android.view.Menu
    public MenuItem add(int groupId, int itemId, int order, CharSequence title) {
        return c(this.d.add(groupId, itemId, order, title));
    }

    @Override // android.view.Menu
    public MenuItem add(int groupId, int itemId, int order, int titleRes) {
        return c(this.d.add(groupId, itemId, order, titleRes));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence title) {
        return d(this.d.addSubMenu(title));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int titleRes) {
        return d(this.d.addSubMenu(titleRes));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int groupId, int itemId, int order, CharSequence title) {
        return d(this.d.addSubMenu(groupId, itemId, order, title));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
        return d(this.d.addSubMenu(groupId, itemId, order, titleRes));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        MenuItem[] items = outSpecificItems != null ? new MenuItem[outSpecificItems.length] : null;
        int result = this.d.addIntentOptions(groupId, itemId, order, caller, specifics, intent, flags, items);
        if (items != null) {
            int z = items.length;
            for (int i = 0; i < z; i++) {
                outSpecificItems[i] = c(items[i]);
            }
        }
        return result;
    }

    @Override // android.view.Menu
    public void removeItem(int id) {
        g(id);
        this.d.removeItem(id);
    }

    @Override // android.view.Menu
    public void removeGroup(int groupId) {
        f(groupId);
        this.d.removeGroup(groupId);
    }

    @Override // android.view.Menu
    public void clear() {
        e();
        this.d.clear();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        this.d.setGroupCheckable(group, checkable, exclusive);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int group, boolean visible) {
        this.d.setGroupVisible(group, visible);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int group, boolean enabled) {
        this.d.setGroupEnabled(group, enabled);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int id) {
        return c(this.d.findItem(id));
    }

    @Override // android.view.Menu
    public int size() {
        return this.d.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int index) {
        return c(this.d.getItem(index));
    }

    @Override // android.view.Menu
    public void close() {
        this.d.close();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        return this.d.performShortcut(keyCode, event, flags);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return this.d.isShortcutKey(keyCode, event);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int id, int flags) {
        return this.d.performIdentifierAction(id, flags);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean isQwerty) {
        this.d.setQwertyMode(isQwerty);
    }
}
