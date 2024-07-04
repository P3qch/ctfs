package a.b.f.j;

import a.h.k.w;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class g implements a.h.e.a.a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f107a = {1, 4, 5, 3, 2, 0};

    /* renamed from: b, reason: collision with root package name */
    public final Context f108b;
    public final Resources c;
    public boolean d;
    public boolean e;
    public a f;
    public CharSequence n;
    public Drawable o;
    public View p;
    public i x;
    public boolean z;
    public int m = 0;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public ArrayList<i> v = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<m>> w = new CopyOnWriteArrayList<>();
    public boolean y = false;
    public ArrayList<i> g = new ArrayList<>();
    public ArrayList<i> h = new ArrayList<>();
    public boolean i = true;
    public ArrayList<i> j = new ArrayList<>();
    public ArrayList<i> k = new ArrayList<>();
    public boolean l = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(g gVar);

        boolean b(g gVar, MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean b(i iVar);
    }

    public g(Context context) {
        this.f108b = context;
        this.c = context.getResources();
        b0(true);
    }

    public g S(int defaultShowAsAction) {
        this.m = defaultShowAsAction;
        return this;
    }

    public void b(m presenter) {
        c(presenter, this.f108b);
    }

    public void c(m presenter, Context menuContext) {
        this.w.add(new WeakReference<>(presenter));
        presenter.j(menuContext, this);
        this.l = true;
    }

    public void O(m presenter) {
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m item = next.get();
            if (item == null || item == presenter) {
                this.w.remove(next);
            }
        }
    }

    public final void i(boolean cleared) {
        if (this.w.isEmpty()) {
            return;
        }
        d0();
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m presenter = next.get();
            if (presenter == null) {
                this.w.remove(next);
            } else {
                presenter.h(cleared);
            }
        }
        c0();
    }

    public final boolean j(r subMenu, m preferredPresenter) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean result = false;
        if (preferredPresenter != null) {
            result = preferredPresenter.f(subMenu);
        }
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m presenter = next.get();
            if (presenter == null) {
                this.w.remove(next);
            } else if (!result) {
                result = presenter.f(subMenu);
            }
        }
        return result;
    }

    public void Q(Bundle outStates) {
        SparseArray<Parcelable> viewStates = null;
        int itemCount = size();
        for (int i = 0; i < itemCount; i++) {
            MenuItem item = getItem(i);
            View v = item.getActionView();
            if (v != null && v.getId() != -1) {
                if (viewStates == null) {
                    viewStates = new SparseArray<>();
                }
                v.saveHierarchyState(viewStates);
                if (item.isActionViewExpanded()) {
                    outStates.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                r subMenu = (r) item.getSubMenu();
                subMenu.Q(outStates);
            }
        }
        if (viewStates != null) {
            outStates.putSparseParcelableArray(t(), viewStates);
        }
    }

    public void P(Bundle states) {
        MenuItem itemToExpand;
        if (states == null) {
            return;
        }
        SparseArray<Parcelable> viewStates = states.getSparseParcelableArray(t());
        int itemCount = size();
        for (int i = 0; i < itemCount; i++) {
            MenuItem item = getItem(i);
            View v = item.getActionView();
            if (v != null && v.getId() != -1) {
                v.restoreHierarchyState(viewStates);
            }
            if (item.hasSubMenu()) {
                r subMenu = (r) item.getSubMenu();
                subMenu.P(states);
            }
        }
        int expandedId = states.getInt("android:menu:expandedactionview");
        if (expandedId > 0 && (itemToExpand = findItem(expandedId)) != null) {
            itemToExpand.expandActionView();
        }
    }

    public String t() {
        return "android:menu:actionviewstates";
    }

    public void R(a cb) {
        this.f = cb;
    }

    public MenuItem a(int group, int id, int categoryOrder, CharSequence title) {
        int ordering = B(categoryOrder);
        i item = g(group, id, categoryOrder, ordering, title, this.m);
        ArrayList<i> arrayList = this.g;
        arrayList.add(n(arrayList, ordering), item);
        K(true);
        return item;
    }

    public final i g(int group, int id, int categoryOrder, int ordering, CharSequence title, int defaultShowAsAction) {
        return new i(this, group, id, categoryOrder, ordering, title, defaultShowAsAction);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence title) {
        return a(0, 0, 0, title);
    }

    @Override // android.view.Menu
    public MenuItem add(int titleRes) {
        return a(0, 0, 0, this.c.getString(titleRes));
    }

    @Override // android.view.Menu
    public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        return a(group, id, categoryOrder, title);
    }

    @Override // android.view.Menu
    public MenuItem add(int group, int id, int categoryOrder, int title) {
        return a(group, id, categoryOrder, this.c.getString(title));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence title) {
        return addSubMenu(0, 0, 0, title);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int titleRes) {
        return addSubMenu(0, 0, 0, this.c.getString(titleRes));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        i item = (i) a(group, id, categoryOrder, title);
        r subMenu = new r(this.f108b, this, item);
        item.w(subMenu);
        return subMenu;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        return addSubMenu(group, id, categoryOrder, this.c.getString(title));
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean enabled) {
        this.y = enabled;
    }

    public boolean F() {
        return this.y;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int group, int id, int categoryOrder, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        int i;
        PackageManager pm = this.f108b.getPackageManager();
        List<ResolveInfo> lri = pm.queryIntentActivityOptions(caller, specifics, intent, 0);
        int N = lri != null ? lri.size() : 0;
        if ((flags & 1) == 0) {
            removeGroup(group);
        }
        for (int i2 = 0; i2 < N; i2++) {
            ResolveInfo ri = lri.get(i2);
            int i3 = ri.specificIndex;
            Intent rintent = new Intent(i3 < 0 ? intent : specifics[i3]);
            ActivityInfo activityInfo = ri.activityInfo;
            rintent.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            i iVar = (i) add(group, id, categoryOrder, ri.loadLabel(pm));
            iVar.setIcon(ri.loadIcon(pm));
            MenuItem item = iVar.setIntent(rintent);
            if (outSpecificItems != null && (i = ri.specificIndex) >= 0) {
                outSpecificItems[i] = item;
            }
        }
        return N;
    }

    @Override // android.view.Menu
    public void removeItem(int id) {
        N(o(id), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int group) {
        int i = l(group);
        if (i >= 0) {
            int maxRemovable = this.g.size() - i;
            int numRemoved = 0;
            while (true) {
                int numRemoved2 = numRemoved + 1;
                if (numRemoved >= maxRemovable || this.g.get(i).getGroupId() != group) {
                    break;
                }
                N(i, false);
                numRemoved = numRemoved2;
            }
            K(true);
        }
    }

    public final void N(int index, boolean updateChildrenOnMenuViews) {
        if (index < 0 || index >= this.g.size()) {
            return;
        }
        this.g.remove(index);
        if (updateChildrenOnMenuViews) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        i iVar = this.x;
        if (iVar != null) {
            f(iVar);
        }
        this.g.clear();
        K(true);
    }

    public void T(MenuItem item) {
        int group = item.getGroupId();
        int N = this.g.size();
        d0();
        for (int i = 0; i < N; i++) {
            i curItem = this.g.get(i);
            if (curItem.getGroupId() == group && curItem.m() && curItem.isCheckable()) {
                curItem.s(curItem == item);
            }
        }
        c0();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        int N = this.g.size();
        for (int i = 0; i < N; i++) {
            i item = this.g.get(i);
            if (item.getGroupId() == group) {
                item.t(exclusive);
                item.setCheckable(checkable);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int group, boolean visible) {
        int N = this.g.size();
        boolean changedAtLeastOneItem = false;
        for (int i = 0; i < N; i++) {
            i item = this.g.get(i);
            if (item.getGroupId() == group && item.x(visible)) {
                changedAtLeastOneItem = true;
            }
        }
        if (changedAtLeastOneItem) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int group, boolean enabled) {
        int N = this.g.size();
        for (int i = 0; i < N; i++) {
            i item = this.g.get(i);
            if (item.getGroupId() == group) {
                item.setEnabled(enabled);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            i item = this.g.get(i);
            if (item.isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int id) {
        MenuItem possibleItem;
        int size = size();
        for (int i = 0; i < size; i++) {
            i item = this.g.get(i);
            if (item.getItemId() == id) {
                return item;
            }
            if (item.hasSubMenu() && (possibleItem = ((g) item.getSubMenu()).findItem(id)) != null) {
                return possibleItem;
            }
        }
        return null;
    }

    public int o(int id) {
        int size = size();
        for (int i = 0; i < size; i++) {
            i item = this.g.get(i);
            if (item.getItemId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int l(int group) {
        return m(group, 0);
    }

    public int m(int group, int start) {
        int size = size();
        if (start < 0) {
            start = 0;
        }
        for (int i = start; i < size; i++) {
            i item = this.g.get(i);
            if (item.getGroupId() == group) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public int size() {
        return this.g.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int index) {
        return this.g.get(index);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return p(keyCode, event) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean isQwerty) {
        this.d = isQwerty;
        K(false);
    }

    public static int B(int categoryOrder) {
        int index = ((-65536) & categoryOrder) >> 16;
        if (index >= 0) {
            int[] iArr = f107a;
            if (index < iArr.length) {
                return (iArr[index] << 16) | (65535 & categoryOrder);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public boolean G() {
        return this.d;
    }

    public final void b0(boolean shortcutsVisible) {
        this.e = shortcutsVisible && this.c.getConfiguration().keyboard != 1 && w.e(ViewConfiguration.get(this.f108b), this.f108b);
    }

    public boolean H() {
        return this.e;
    }

    public Resources C() {
        return this.c;
    }

    public Context u() {
        return this.f108b;
    }

    public boolean h(g menu, MenuItem item) {
        a aVar = this.f;
        return aVar != null && aVar.b(menu, item);
    }

    public void d() {
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public static int n(ArrayList<i> arrayList, int ordering) {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            i item = arrayList.get(i);
            if (item.f() <= ordering) {
                return i + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        i item = p(keyCode, event);
        boolean handled = false;
        if (item != null) {
            handled = L(item, flags);
        }
        if ((flags & 2) != 0) {
            e(true);
        }
        return handled;
    }

    public void q(List<i> list, int keyCode, KeyEvent event) {
        boolean qwerty = G();
        int modifierState = event.getModifiers();
        KeyCharacterMap.KeyData possibleChars = new KeyCharacterMap.KeyData();
        boolean isKeyCodeMapped = event.getKeyData(possibleChars);
        if (!isKeyCodeMapped && keyCode != 67) {
            return;
        }
        int N = this.g.size();
        for (int i = 0; i < N; i++) {
            i item = this.g.get(i);
            if (item.hasSubMenu()) {
                ((g) item.getSubMenu()).q(list, keyCode, event);
            }
            char shortcutChar = qwerty ? item.getAlphabeticShortcut() : item.getNumericShortcut();
            int shortcutModifiers = qwerty ? item.getAlphabeticModifiers() : item.getNumericModifiers();
            boolean isModifiersExactMatch = (modifierState & 69647) == (69647 & shortcutModifiers);
            if (isModifiersExactMatch && shortcutChar != 0) {
                char[] cArr = possibleChars.meta;
                if (shortcutChar != cArr[0] && shortcutChar != cArr[2]) {
                    if (qwerty && shortcutChar == '\b') {
                        if (keyCode != 67) {
                        }
                    }
                }
                if (item.isEnabled()) {
                    list.add(item);
                }
            }
        }
    }

    public i p(int keyCode, KeyEvent event) {
        ArrayList<i> arrayList = this.v;
        arrayList.clear();
        q(arrayList, keyCode, event);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = event.getMetaState();
        KeyCharacterMap.KeyData possibleChars = new KeyCharacterMap.KeyData();
        event.getKeyData(possibleChars);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean qwerty = G();
        for (int i = 0; i < size; i++) {
            i item = arrayList.get(i);
            char shortcutChar = qwerty ? item.getAlphabeticShortcut() : item.getNumericShortcut();
            char[] cArr = possibleChars.meta;
            if ((shortcutChar == cArr[0] && (metaState & 2) == 0) || ((shortcutChar == cArr[2] && (metaState & 2) != 0) || (qwerty && shortcutChar == '\b' && keyCode == 67))) {
                return item;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int id, int flags) {
        return L(findItem(id), flags);
    }

    public boolean L(MenuItem item, int flags) {
        return M(item, null, flags);
    }

    public boolean M(MenuItem item, m preferredPresenter, int flags) {
        i itemImpl = (i) item;
        if (itemImpl == null || !itemImpl.isEnabled()) {
            return false;
        }
        boolean invoked = itemImpl.k();
        a.h.k.b provider = itemImpl.a();
        boolean providerHasSubMenu = provider != null && provider.a();
        if (itemImpl.j()) {
            invoked |= itemImpl.expandActionView();
            if (invoked) {
                e(true);
            }
        } else if (itemImpl.hasSubMenu() || providerHasSubMenu) {
            if ((flags & 4) == 0) {
                e(false);
            }
            if (!itemImpl.hasSubMenu()) {
                itemImpl.w(new r(u(), this, itemImpl));
            }
            r subMenu = (r) itemImpl.getSubMenu();
            if (providerHasSubMenu) {
                provider.f(subMenu);
            }
            invoked |= j(subMenu, preferredPresenter);
            if (!invoked) {
                e(true);
            }
        } else if ((flags & 1) == 0) {
            e(true);
        }
        return invoked;
    }

    public final void e(boolean closeAllMenus) {
        if (this.u) {
            return;
        }
        this.u = true;
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m presenter = next.get();
            if (presenter == null) {
                this.w.remove(next);
            } else {
                presenter.b(this, closeAllMenus);
            }
        }
        this.u = false;
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void K(boolean structureChanged) {
        if (!this.q) {
            if (structureChanged) {
                this.i = true;
                this.l = true;
            }
            i(structureChanged);
            return;
        }
        this.r = true;
        if (structureChanged) {
            this.s = true;
        }
    }

    public void d0() {
        if (!this.q) {
            this.q = true;
            this.r = false;
            this.s = false;
        }
    }

    public void c0() {
        this.q = false;
        if (this.r) {
            this.r = false;
            K(this.s);
        }
    }

    public void J() {
        this.i = true;
        K(true);
    }

    public void I() {
        this.l = true;
        K(true);
    }

    public ArrayList<i> E() {
        if (!this.i) {
            return this.h;
        }
        this.h.clear();
        int itemsSize = this.g.size();
        for (int i = 0; i < itemsSize; i++) {
            i item = this.g.get(i);
            if (item.isVisible()) {
                this.h.add(item);
            }
        }
        this.i = false;
        this.l = true;
        return this.h;
    }

    public void r() {
        ArrayList<i> E = E();
        if (!this.l) {
            return;
        }
        boolean flagged = false;
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m presenter = next.get();
            if (presenter == null) {
                this.w.remove(next);
            } else {
                flagged |= presenter.g();
            }
        }
        if (flagged) {
            this.j.clear();
            this.k.clear();
            int itemsSize = E.size();
            for (int i = 0; i < itemsSize; i++) {
                i item = E.get(i);
                if (item.l()) {
                    this.j.add(item);
                } else {
                    this.k.add(item);
                }
            }
        } else {
            this.j.clear();
            this.k.clear();
            this.k.addAll(E());
        }
        this.l = false;
    }

    public ArrayList<i> s() {
        r();
        return this.j;
    }

    public ArrayList<i> z() {
        r();
        return this.k;
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        K(false);
    }

    public final void W(int titleRes, CharSequence title, int iconRes, Drawable icon, View view) {
        Resources r = C();
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (titleRes > 0) {
                this.n = r.getText(titleRes);
            } else if (title != null) {
                this.n = title;
            }
            if (iconRes > 0) {
                this.o = a.h.c.a.d(u(), iconRes);
            } else if (icon != null) {
                this.o = icon;
            }
            this.p = null;
        }
        K(false);
    }

    public g Y(CharSequence title) {
        W(0, title, 0, null, null);
        return this;
    }

    public g X(int titleRes) {
        W(titleRes, null, 0, null, null);
        return this;
    }

    public g V(Drawable icon) {
        W(0, null, 0, icon, null);
        return this;
    }

    public g U(int iconRes) {
        W(0, null, iconRes, null, null);
        return this;
    }

    public g Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    public CharSequence x() {
        return this.n;
    }

    public Drawable w() {
        return this.o;
    }

    public View y() {
        return this.p;
    }

    public g D() {
        return this;
    }

    public boolean A() {
        return false;
    }

    public boolean k(i item) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean expanded = false;
        d0();
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m presenter = next.get();
            if (presenter == null) {
                this.w.remove(next);
            } else {
                boolean c = presenter.c(this, item);
                expanded = c;
                if (c) {
                    break;
                }
            }
        }
        c0();
        if (expanded) {
            this.x = item;
        }
        return expanded;
    }

    public boolean f(i item) {
        if (this.w.isEmpty() || this.x != item) {
            return false;
        }
        boolean collapsed = false;
        d0();
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m presenter = next.get();
            if (presenter == null) {
                this.w.remove(next);
            } else {
                boolean k = presenter.k(this, item);
                collapsed = k;
                if (k) {
                    break;
                }
            }
        }
        c0();
        if (collapsed) {
            this.x = null;
        }
        return collapsed;
    }

    public i v() {
        return this.x;
    }

    public void a0(boolean override) {
        this.z = override;
    }
}
