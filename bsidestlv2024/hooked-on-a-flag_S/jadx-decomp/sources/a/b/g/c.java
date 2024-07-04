package a.b.g;

import a.b.f.j.m;
import a.b.f.j.n;
import a.h.k.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class c extends a.b.f.j.b implements b.a {
    public d j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public final SparseBooleanArray t;
    public e u;
    public a v;
    public RunnableC0008c w;
    public b x;
    public final f y;

    public c(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.t = new SparseBooleanArray();
        this.y = new f();
    }

    @Override // a.b.f.j.b, a.b.f.j.m
    public void j(Context context, a.b.f.j.g menu) {
        super.j(context, menu);
        Resources res = context.getResources();
        a.b.f.a abp = a.b.f.a.b(context);
        if (!this.n) {
            this.m = abp.h();
        }
        this.o = abp.c();
        this.q = abp.d();
        int width = this.o;
        if (this.m) {
            if (this.j == null) {
                d dVar = new d(this.f95b);
                this.j = dVar;
                if (this.l) {
                    dVar.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                int spec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.j.measure(spec, spec);
            }
            width -= this.j.getMeasuredWidth();
        } else {
            this.j = null;
        }
        this.p = width;
        this.s = (int) (res.getDisplayMetrics().density * 56.0f);
    }

    public void F() {
        this.q = a.b.f.a.b(this.c).d();
        a.b.f.j.g gVar = this.d;
        if (gVar != null) {
            gVar.K(true);
        }
    }

    public void J(boolean reserveOverflow) {
        this.m = reserveOverflow;
        this.n = true;
    }

    public void G(boolean isExclusive) {
        this.r = isExclusive;
    }

    public void I(Drawable icon) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.setImageDrawable(icon);
        } else {
            this.l = true;
            this.k = icon;
        }
    }

    public Drawable A() {
        d dVar = this.j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.l) {
            return this.k;
        }
        return null;
    }

    @Override // a.b.f.j.b
    public a.b.f.j.n o(ViewGroup root) {
        a.b.f.j.n oldMenuView = this.i;
        a.b.f.j.n result = super.o(root);
        if (oldMenuView != result) {
            ((ActionMenuView) result).setPresenter(this);
        }
        return result;
    }

    @Override // a.b.f.j.b
    public View n(a.b.f.j.i item, View convertView, ViewGroup parent) {
        View actionView = item.getActionView();
        if (actionView == null || item.j()) {
            actionView = super.n(item, convertView, parent);
        }
        actionView.setVisibility(item.isActionViewExpanded() ? 8 : 0);
        ActionMenuView menuParent = (ActionMenuView) parent;
        ViewGroup.LayoutParams lp = actionView.getLayoutParams();
        if (!menuParent.checkLayoutParams(lp)) {
            actionView.setLayoutParams(menuParent.generateLayoutParams(lp));
        }
        return actionView;
    }

    @Override // a.b.f.j.b
    public void e(a.b.f.j.i item, n.a itemView) {
        itemView.e(item, 0);
        ActionMenuView menuView = (ActionMenuView) this.i;
        ActionMenuItemView actionItemView = (ActionMenuItemView) itemView;
        actionItemView.setItemInvoker(menuView);
        if (this.x == null) {
            this.x = new b();
        }
        actionItemView.setPopupCallback(this.x);
    }

    @Override // a.b.f.j.b
    public boolean q(int childIndex, a.b.f.j.i item) {
        return item.l();
    }

    @Override // a.b.f.j.b, a.b.f.j.m
    public void h(boolean cleared) {
        super.h(cleared);
        ((View) this.i).requestLayout();
        a.b.f.j.g gVar = this.d;
        if (gVar != null) {
            ArrayList<a.b.f.j.i> s = gVar.s();
            int count = s.size();
            for (int i = 0; i < count; i++) {
                a.h.k.b provider = s.get(i).a();
                if (provider != null) {
                    provider.i(this);
                }
            }
        }
        a.b.f.j.g gVar2 = this.d;
        ArrayList<a.b.f.j.i> z = gVar2 != null ? gVar2.z() : null;
        boolean hasOverflow = false;
        if (this.m && z != null) {
            int count2 = z.size();
            if (count2 == 1) {
                hasOverflow = !z.get(0).isActionViewExpanded();
            } else {
                hasOverflow = count2 > 0;
            }
        }
        if (hasOverflow) {
            if (this.j == null) {
                this.j = new d(this.f95b);
            }
            ViewGroup parent = (ViewGroup) this.j.getParent();
            if (parent != this.i) {
                if (parent != null) {
                    parent.removeView(this.j);
                }
                ActionMenuView menuView = (ActionMenuView) this.i;
                menuView.addView(this.j, menuView.F());
            }
        } else {
            d dVar = this.j;
            if (dVar != null) {
                Object parent2 = dVar.getParent();
                Object obj = this.i;
                if (parent2 == obj) {
                    ((ViewGroup) obj).removeView(this.j);
                }
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.m);
    }

    @Override // a.b.f.j.b
    public boolean l(ViewGroup parent, int childIndex) {
        if (parent.getChildAt(childIndex) == this.j) {
            return false;
        }
        super.l(parent, childIndex);
        return true;
    }

    @Override // a.b.f.j.b, a.b.f.j.m
    public boolean f(a.b.f.j.r subMenu) {
        if (!subMenu.hasVisibleItems()) {
            return false;
        }
        a.b.f.j.r topSubMenu = subMenu;
        while (topSubMenu.e0() != this.d) {
            topSubMenu = (a.b.f.j.r) topSubMenu.e0();
        }
        View anchor = z(topSubMenu.getItem());
        if (anchor == null) {
            return false;
        }
        ((a.b.f.j.i) subMenu.getItem()).getItemId();
        boolean preserveIconSpacing = false;
        int count = subMenu.size();
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            }
            MenuItem childItem = subMenu.getItem(i);
            if (!childItem.isVisible() || childItem.getIcon() == null) {
                i++;
            } else {
                preserveIconSpacing = true;
                break;
            }
        }
        a aVar = new a(this.c, subMenu, anchor);
        this.v = aVar;
        aVar.g(preserveIconSpacing);
        this.v.k();
        super.f(subMenu);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View z(MenuItem item) {
        ViewGroup parent = (ViewGroup) this.i;
        if (parent == null) {
            return null;
        }
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View childAt = parent.getChildAt(i);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == item) {
                return childAt;
            }
        }
        return null;
    }

    public boolean K() {
        a.b.f.j.g gVar;
        if (this.m && !E() && (gVar = this.d) != null && this.i != null && this.w == null && !gVar.z().isEmpty()) {
            e popup = new e(this.c, this.d, this.j, true);
            RunnableC0008c runnableC0008c = new RunnableC0008c(popup);
            this.w = runnableC0008c;
            ((View) this.i).post(runnableC0008c);
            return true;
        }
        return false;
    }

    public boolean B() {
        Object obj;
        RunnableC0008c runnableC0008c = this.w;
        if (runnableC0008c != null && (obj = this.i) != null) {
            ((View) obj).removeCallbacks(runnableC0008c);
            this.w = null;
            return true;
        }
        a.b.f.j.l popup = this.u;
        if (popup != null) {
            popup.b();
            return true;
        }
        return false;
    }

    public boolean y() {
        boolean result = B();
        return result | C();
    }

    public boolean C() {
        a aVar = this.v;
        if (aVar != null) {
            aVar.b();
            return true;
        }
        return false;
    }

    public boolean E() {
        e eVar = this.u;
        return eVar != null && eVar.d();
    }

    public boolean D() {
        return this.w != null || E();
    }

    @Override // a.b.f.j.m
    public boolean g() {
        ArrayList<a.b.f.j.i> arrayList;
        int itemsSize;
        ArrayList<a.b.f.j.i> arrayList2;
        int maxActions;
        boolean isAction;
        int widthLimit;
        int widthLimit2;
        boolean z;
        c cVar = this;
        a.b.f.j.g gVar = cVar.d;
        if (gVar != null) {
            arrayList = gVar.E();
            itemsSize = arrayList.size();
        } else {
            arrayList = null;
            itemsSize = 0;
        }
        int maxActions2 = cVar.q;
        int widthLimit3 = cVar.p;
        int querySpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup parent = (ViewGroup) cVar.i;
        int requiredItems = 0;
        int requestedItems = 0;
        int firstActionWidth = 0;
        boolean hasOverflow = false;
        for (int i = 0; i < itemsSize; i++) {
            a.b.f.j.i item = arrayList.get(i);
            if (item.o()) {
                requiredItems++;
            } else if (item.n()) {
                requestedItems++;
            } else {
                hasOverflow = true;
            }
            if (cVar.r && item.isActionViewExpanded()) {
                maxActions2 = 0;
            }
        }
        if (cVar.m && (hasOverflow || requiredItems + requestedItems > maxActions2)) {
            maxActions2--;
        }
        int maxActions3 = maxActions2 - requiredItems;
        SparseBooleanArray seenGroups = cVar.t;
        seenGroups.clear();
        int i2 = 0;
        while (i2 < itemsSize) {
            a.b.f.j.i item2 = arrayList.get(i2);
            int itemsSize2 = itemsSize;
            if (item2.o()) {
                View v = cVar.n(item2, null, parent);
                v.measure(querySpec, querySpec);
                int measuredWidth = v.getMeasuredWidth();
                int widthLimit4 = widthLimit3 - measuredWidth;
                if (firstActionWidth == 0) {
                    firstActionWidth = measuredWidth;
                }
                int groupId = item2.getGroupId();
                if (groupId == 0) {
                    widthLimit2 = widthLimit4;
                    z = true;
                } else {
                    widthLimit2 = widthLimit4;
                    z = true;
                    seenGroups.put(groupId, true);
                }
                item2.u(z);
                widthLimit3 = widthLimit2;
                arrayList2 = arrayList;
            } else if (item2.n()) {
                int groupId2 = item2.getGroupId();
                boolean inGroup = seenGroups.get(groupId2);
                boolean isAction2 = (maxActions3 > 0 || inGroup) && widthLimit3 > 0;
                if (!isAction2) {
                    maxActions = maxActions3;
                    isAction = isAction2;
                } else {
                    maxActions = maxActions3;
                    View v2 = cVar.n(item2, null, parent);
                    v2.measure(querySpec, querySpec);
                    int measuredWidth2 = v2.getMeasuredWidth();
                    widthLimit3 -= measuredWidth2;
                    if (firstActionWidth == 0) {
                        firstActionWidth = measuredWidth2;
                    }
                    isAction = isAction2 & (widthLimit3 + firstActionWidth > 0);
                }
                if (isAction && groupId2 != 0) {
                    seenGroups.put(groupId2, true);
                    arrayList2 = arrayList;
                    widthLimit = widthLimit3;
                } else if (!inGroup) {
                    arrayList2 = arrayList;
                    widthLimit = widthLimit3;
                } else {
                    seenGroups.put(groupId2, false);
                    int j = 0;
                    while (j < i2) {
                        ArrayList<a.b.f.j.i> arrayList3 = arrayList;
                        a.b.f.j.i areYouMyGroupie = arrayList.get(j);
                        int widthLimit5 = widthLimit3;
                        int widthLimit6 = areYouMyGroupie.getGroupId();
                        if (widthLimit6 == groupId2) {
                            if (areYouMyGroupie.l()) {
                                maxActions++;
                            }
                            areYouMyGroupie.u(false);
                        }
                        j++;
                        widthLimit3 = widthLimit5;
                        arrayList = arrayList3;
                    }
                    arrayList2 = arrayList;
                    widthLimit = widthLimit3;
                }
                if (isAction) {
                    maxActions--;
                }
                item2.u(isAction);
                widthLimit3 = widthLimit;
                maxActions3 = maxActions;
            } else {
                arrayList2 = arrayList;
                item2.u(false);
            }
            i2++;
            cVar = this;
            itemsSize = itemsSize2;
            arrayList = arrayList2;
        }
        return true;
    }

    @Override // a.b.f.j.b, a.b.f.j.m
    public void b(a.b.f.j.g menu, boolean allMenusAreClosing) {
        y();
        super.b(menu, allMenusAreClosing);
    }

    public void H(ActionMenuView menuView) {
        this.i = menuView;
        menuView.d(this.d);
    }

    /* loaded from: classes.dex */
    public class d extends o implements ActionMenuView.a {
        public d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            a1.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        /* loaded from: classes.dex */
        public class a extends i0 {
            public a(View src, c cVar) {
                super(src);
            }

            @Override // a.b.g.i0
            public a.b.f.j.p b() {
                e eVar = c.this.u;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // a.b.g.i0
            public boolean c() {
                c.this.K();
                return true;
            }

            @Override // a.b.g.i0
            public boolean d() {
                c cVar = c.this;
                if (cVar.w != null) {
                    return false;
                }
                cVar.B();
                return true;
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.K();
            return true;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int l, int t, int r, int b2) {
            boolean changed = super.setFrame(l, t, r, b2);
            Drawable d = getDrawable();
            Drawable bg = getBackground();
            if (d != null && bg != null) {
                int width = getWidth();
                int height = getHeight();
                int halfEdge = Math.max(width, height) / 2;
                int offsetX = getPaddingLeft() - getPaddingRight();
                int offsetY = getPaddingTop() - getPaddingBottom();
                int centerX = (width + offsetX) / 2;
                int centerY = (height + offsetY) / 2;
                a.h.d.l.a.l(bg, centerX - halfEdge, centerY - halfEdge, centerX + halfEdge, centerY + halfEdge);
            }
            return changed;
        }
    }

    /* loaded from: classes.dex */
    public class e extends a.b.f.j.l {
        public e(Context context, a.b.f.j.g menu, View anchorView, boolean overflowOnly) {
            super(context, menu, anchorView, overflowOnly, R.attr.actionOverflowMenuStyle);
            h(8388613);
            j(c.this.y);
        }

        @Override // a.b.f.j.l
        public void e() {
            if (c.this.d != null) {
                c.this.d.close();
            }
            c.this.u = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    public class a extends a.b.f.j.l {
        public a(Context context, a.b.f.j.r subMenu, View anchorView) {
            super(context, subMenu, anchorView, false, R.attr.actionOverflowMenuStyle);
            a.b.f.j.i item = (a.b.f.j.i) subMenu.getItem();
            if (!item.l()) {
                View view = c.this.j;
                f(view == null ? (View) c.this.i : view);
            }
            j(c.this.y);
        }

        @Override // a.b.f.j.l
        public void e() {
            c cVar = c.this;
            cVar.v = null;
            cVar.getClass();
            super.e();
        }
    }

    /* loaded from: classes.dex */
    public class f implements m.a {
        public f() {
        }

        @Override // a.b.f.j.m.a
        public boolean c(a.b.f.j.g subMenu) {
            if (subMenu == c.this.d) {
                return false;
            }
            c cVar = c.this;
            ((a.b.f.j.i) ((a.b.f.j.r) subMenu).getItem()).getItemId();
            cVar.getClass();
            m.a cb = c.this.m();
            if (cb != null) {
                return cb.c(subMenu);
            }
            return false;
        }

        @Override // a.b.f.j.m.a
        public void b(a.b.f.j.g menu, boolean allMenusAreClosing) {
            if (menu instanceof a.b.f.j.r) {
                menu.D().e(false);
            }
            m.a cb = c.this.m();
            if (cb != null) {
                cb.b(menu, allMenusAreClosing);
            }
        }
    }

    /* renamed from: a.b.g.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0008c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public e f136b;

        public RunnableC0008c(e popup) {
            this.f136b = popup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.d != null) {
                c.this.d.d();
            }
            View menuView = (View) c.this.i;
            if (menuView != null && menuView.getWindowToken() != null && this.f136b.m()) {
                c.this.u = this.f136b;
            }
            c.this.w = null;
        }
    }

    /* loaded from: classes.dex */
    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public a.b.f.j.p a() {
            a aVar = c.this.v;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }
}
