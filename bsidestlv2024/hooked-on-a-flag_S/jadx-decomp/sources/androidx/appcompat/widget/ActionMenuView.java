package androidx.appcompat.widget;

import a.b.f.j.g;
import a.b.f.j.i;
import a.b.f.j.m;
import a.b.f.j.n;
import a.b.g.e1;
import a.b.g.j0;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public class ActionMenuView extends j0 implements g.b, n {
    public int A;
    public e B;
    public g q;
    public Context r;
    public int s;
    public boolean t;
    public a.b.g.c u;
    public m.a v;
    public g.a w;
    public boolean x;
    public int y;
    public int z;

    /* loaded from: classes.dex */
    public interface a {
        boolean a();

        boolean b();
    }

    /* loaded from: classes.dex */
    public interface e {
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBaselineAligned(false);
        float density = context.getResources().getDisplayMetrics().density;
        this.z = (int) (56.0f * density);
        this.A = (int) (4.0f * density);
        this.r = context;
        this.s = 0;
    }

    public void setPopupTheme(int resId) {
        if (this.s != resId) {
            this.s = resId;
            if (resId == 0) {
                this.r = getContext();
            } else {
                this.r = new ContextThemeWrapper(getContext(), resId);
            }
        }
    }

    public int getPopupTheme() {
        return this.s;
    }

    public void setPresenter(a.b.g.c presenter) {
        this.u = presenter;
        presenter.H(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        a.b.g.c cVar = this.u;
        if (cVar != null) {
            cVar.h(false);
            if (this.u.E()) {
                this.u.B();
                this.u.K();
            }
        }
    }

    public void setOnMenuItemClickListener(e listener) {
        this.B = listener;
    }

    @Override // a.b.g.j0, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        g gVar;
        boolean wasFormatted = this.x;
        boolean z = View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824;
        this.x = z;
        if (wasFormatted != z) {
            this.y = 0;
        }
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        if (this.x && (gVar = this.q) != null && widthSize != this.y) {
            this.y = widthSize;
            gVar.K(true);
        }
        int childCount = getChildCount();
        if (this.x && childCount > 0) {
            M(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            c lp = (c) child.getLayoutParams();
            ((LinearLayout.LayoutParams) lp).rightMargin = 0;
            ((LinearLayout.LayoutParams) lp).leftMargin = 0;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02b3  */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M(int r41, int r42) {
        /*
            Method dump skipped, instructions count: 709
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.M(int, int):void");
    }

    public static int L(View child, int cellSize, int cellsRemaining, int parentHeightMeasureSpec, int parentHeightPadding) {
        c lp = (c) child.getLayoutParams();
        int childHeightSize = View.MeasureSpec.getSize(parentHeightMeasureSpec) - parentHeightPadding;
        int childHeightMode = View.MeasureSpec.getMode(parentHeightMeasureSpec);
        int childHeightSpec = View.MeasureSpec.makeMeasureSpec(childHeightSize, childHeightMode);
        ActionMenuItemView itemView = child instanceof ActionMenuItemView ? (ActionMenuItemView) child : null;
        boolean expandable = false;
        boolean hasText = itemView != null && itemView.f();
        int cellsUsed = 0;
        if (cellsRemaining > 0 && (!hasText || cellsRemaining >= 2)) {
            int childWidthSpec = View.MeasureSpec.makeMeasureSpec(cellSize * cellsRemaining, Integer.MIN_VALUE);
            child.measure(childWidthSpec, childHeightSpec);
            int measuredWidth = child.getMeasuredWidth();
            cellsUsed = measuredWidth / cellSize;
            if (measuredWidth % cellSize != 0) {
                cellsUsed++;
            }
            if (hasText && cellsUsed < 2) {
                cellsUsed = 2;
            }
        }
        if (!lp.f805a && hasText) {
            expandable = true;
        }
        lp.d = expandable;
        lp.f806b = cellsUsed;
        int targetWidth = cellsUsed * cellSize;
        child.measure(View.MeasureSpec.makeMeasureSpec(targetWidth, 1073741824), childHeightSpec);
        return cellsUsed;
    }

    @Override // a.b.g.j0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i;
        int overflowWidth;
        int nonOverflowCount;
        int dividerWidth;
        int r;
        int l;
        ActionMenuView actionMenuView = this;
        if (!actionMenuView.x) {
            super.onLayout(changed, left, top, right, bottom);
            return;
        }
        int childCount = getChildCount();
        int midVertical = (bottom - top) / 2;
        int dividerWidth2 = getDividerWidth();
        int overflowWidth2 = 0;
        int nonOverflowCount2 = 0;
        int widthRemaining = ((right - left) - getPaddingRight()) - getPaddingLeft();
        int i2 = 0;
        boolean isLayoutRtl = e1.b(this);
        int i3 = 0;
        while (true) {
            i = 8;
            if (i3 >= childCount) {
                break;
            }
            View v = actionMenuView.getChildAt(i3);
            if (v.getVisibility() == 8) {
                dividerWidth = dividerWidth2;
            } else {
                c p = (c) v.getLayoutParams();
                if (p.f805a) {
                    overflowWidth2 = v.getMeasuredWidth();
                    if (actionMenuView.G(i3)) {
                        overflowWidth2 += dividerWidth2;
                    }
                    int height = v.getMeasuredHeight();
                    if (isLayoutRtl) {
                        l = getPaddingLeft() + ((LinearLayout.LayoutParams) p).leftMargin;
                        r = l + overflowWidth2;
                    } else {
                        r = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) p).rightMargin;
                        l = r - overflowWidth2;
                    }
                    int t = midVertical - (height / 2);
                    dividerWidth = dividerWidth2;
                    int dividerWidth3 = t + height;
                    v.layout(l, t, r, dividerWidth3);
                    widthRemaining -= overflowWidth2;
                    i2 = 1;
                } else {
                    dividerWidth = dividerWidth2;
                    int dividerWidth4 = v.getMeasuredWidth();
                    int size = dividerWidth4 + ((LinearLayout.LayoutParams) p).leftMargin + ((LinearLayout.LayoutParams) p).rightMargin;
                    widthRemaining -= size;
                    actionMenuView.G(i3);
                    nonOverflowCount2++;
                }
            }
            i3++;
            dividerWidth2 = dividerWidth;
        }
        if (childCount == 1 && i2 == 0) {
            View v2 = actionMenuView.getChildAt(0);
            int width = v2.getMeasuredWidth();
            int height2 = v2.getMeasuredHeight();
            int midHorizontal = (right - left) / 2;
            int l2 = midHorizontal - (width / 2);
            int t2 = midVertical - (height2 / 2);
            v2.layout(l2, t2, l2 + width, t2 + height2);
            return;
        }
        int spacerCount = nonOverflowCount2 - (i2 ^ 1);
        int spacerSize = Math.max(0, spacerCount > 0 ? widthRemaining / spacerCount : 0);
        if (isLayoutRtl) {
            int startRight = getWidth() - getPaddingRight();
            int i4 = 0;
            while (i4 < childCount) {
                View v3 = actionMenuView.getChildAt(i4);
                c lp = (c) v3.getLayoutParams();
                if (v3.getVisibility() == i) {
                    overflowWidth = overflowWidth2;
                    nonOverflowCount = nonOverflowCount2;
                } else if (lp.f805a) {
                    overflowWidth = overflowWidth2;
                    nonOverflowCount = nonOverflowCount2;
                } else {
                    int startRight2 = startRight - ((LinearLayout.LayoutParams) lp).rightMargin;
                    int width2 = v3.getMeasuredWidth();
                    int height3 = v3.getMeasuredHeight();
                    int t3 = midVertical - (height3 / 2);
                    overflowWidth = overflowWidth2;
                    int overflowWidth3 = startRight2 - width2;
                    nonOverflowCount = nonOverflowCount2;
                    int nonOverflowCount3 = t3 + height3;
                    v3.layout(overflowWidth3, t3, startRight2, nonOverflowCount3);
                    startRight = startRight2 - ((((LinearLayout.LayoutParams) lp).leftMargin + width2) + spacerSize);
                }
                i4++;
                overflowWidth2 = overflowWidth;
                nonOverflowCount2 = nonOverflowCount;
                i = 8;
            }
            return;
        }
        int startLeft = getPaddingLeft();
        int i5 = 0;
        while (i5 < childCount) {
            View v4 = actionMenuView.getChildAt(i5);
            c lp2 = (c) v4.getLayoutParams();
            if (v4.getVisibility() != 8 && !lp2.f805a) {
                int startLeft2 = startLeft + ((LinearLayout.LayoutParams) lp2).leftMargin;
                int width3 = v4.getMeasuredWidth();
                int height4 = v4.getMeasuredHeight();
                int t4 = midVertical - (height4 / 2);
                v4.layout(startLeft2, t4, startLeft2 + width3, t4 + height4);
                startLeft = startLeft2 + ((LinearLayout.LayoutParams) lp2).rightMargin + width3 + spacerSize;
            }
            i5++;
            actionMenuView = this;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    public void setOverflowIcon(Drawable icon) {
        getMenu();
        this.u.I(icon);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.u.A();
    }

    public boolean K() {
        return this.t;
    }

    public void setOverflowReserved(boolean reserveOverflow) {
        this.t = reserveOverflow;
    }

    @Override // a.b.g.j0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c params = new c(-2, -2);
        ((LinearLayout.LayoutParams) params).gravity = 16;
        return params;
    }

    @Override // a.b.g.j0
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attrs) {
        return new c(getContext(), attrs);
    }

    @Override // a.b.g.j0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams p) {
        c result;
        if (p != null) {
            if (p instanceof c) {
                result = new c((c) p);
            } else {
                result = new c(p);
            }
            if (((LinearLayout.LayoutParams) result).gravity <= 0) {
                ((LinearLayout.LayoutParams) result).gravity = 16;
            }
            return result;
        }
        c result2 = generateDefaultLayoutParams();
        return result2;
    }

    @Override // a.b.g.j0, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof c;
    }

    public c F() {
        c result = generateDefaultLayoutParams();
        result.f805a = true;
        return result;
    }

    @Override // a.b.f.j.g.b
    public boolean b(i item) {
        return this.q.L(item, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // a.b.f.j.n
    public void d(g menu) {
        this.q = menu;
    }

    public Menu getMenu() {
        if (this.q == null) {
            Context context = getContext();
            g gVar = new g(context);
            this.q = gVar;
            gVar.R(new d());
            a.b.g.c cVar = new a.b.g.c(context);
            this.u = cVar;
            cVar.J(true);
            a.b.g.c cVar2 = this.u;
            m.a aVar = this.v;
            if (aVar == null) {
                aVar = new b();
            }
            cVar2.d(aVar);
            this.q.c(this.u, this.r);
            this.u.H(this);
        }
        return this.q;
    }

    public void O(m.a pcb, g.a mcb) {
        this.v = pcb;
        this.w = mcb;
    }

    public g N() {
        return this.q;
    }

    public boolean P() {
        a.b.g.c cVar = this.u;
        return cVar != null && cVar.K();
    }

    public boolean H() {
        a.b.g.c cVar = this.u;
        return cVar != null && cVar.B();
    }

    public boolean J() {
        a.b.g.c cVar = this.u;
        return cVar != null && cVar.E();
    }

    public boolean I() {
        a.b.g.c cVar = this.u;
        return cVar != null && cVar.D();
    }

    public void B() {
        a.b.g.c cVar = this.u;
        if (cVar != null) {
            cVar.y();
        }
    }

    public boolean G(int childIndex) {
        if (childIndex == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(childIndex - 1);
        KeyEvent.Callback childAt2 = getChildAt(childIndex);
        boolean result = false;
        if (childIndex < getChildCount() && (childAt instanceof a)) {
            result = false | ((a) childAt).b();
        }
        if (childIndex > 0 && (childAt2 instanceof a)) {
            return result | ((a) childAt2).a();
        }
        return result;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean exclusive) {
        this.u.G(exclusive);
    }

    /* loaded from: classes.dex */
    public class d implements g.a {
        public d() {
        }

        @Override // a.b.f.j.g.a
        public boolean b(g menu, MenuItem item) {
            e eVar = ActionMenuView.this.B;
            return eVar != null && ((Toolbar.a) eVar).a(item);
        }

        @Override // a.b.f.j.g.a
        public void a(g menu) {
            g.a aVar = ActionMenuView.this.w;
            if (aVar != null) {
                aVar.a(menu);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements m.a {
        @Override // a.b.f.j.m.a
        public void b(g menu, boolean allMenusAreClosing) {
        }

        @Override // a.b.f.j.m.a
        public boolean c(g subMenu) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends j0.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f805a;

        /* renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f806b;

        @ViewDebug.ExportedProperty
        public int c;

        @ViewDebug.ExportedProperty
        public boolean d;

        @ViewDebug.ExportedProperty
        public boolean e;
        public boolean f;

        public c(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public c(ViewGroup.LayoutParams other) {
            super(other);
        }

        public c(c other) {
            super(other);
            this.f805a = other.f805a;
        }

        public c(int width, int height) {
            super(width, height);
            this.f805a = false;
        }
    }
}
