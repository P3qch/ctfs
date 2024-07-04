package androidx.appcompat.view.menu;

import a.b.f.j.g;
import a.b.f.j.i;
import a.b.f.j.n;
import a.b.g.x0;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements g.b, n, AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f797b = {R.attr.background, R.attr.divider};
    public g c;

    public ExpandedMenuView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        setOnItemClickListener(this);
        x0 a2 = x0.v(context, attrs, f797b, defStyleAttr, 0);
        if (a2.s(0)) {
            setBackgroundDrawable(a2.g(0));
        }
        if (a2.s(1)) {
            setDivider(a2.g(1));
        }
        a2.w();
    }

    @Override // a.b.f.j.n
    public void d(g menu) {
        this.c = menu;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // a.b.f.j.g.b
    public boolean b(i item) {
        return this.c.L(item, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView parent, View v, int position, long id) {
        b((i) getAdapter().getItem(position));
    }

    public int getWindowAnimations() {
        return 0;
    }
}
