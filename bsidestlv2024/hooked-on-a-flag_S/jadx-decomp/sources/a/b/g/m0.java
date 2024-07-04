package a.b.g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class m0 extends k0 implements l0 {
    public static Method G;
    public l0 H;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                G = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public m0(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override // a.b.g.k0
    public g0 s(Context context, boolean hijackFocus) {
        a view = new a(context, hijackFocus);
        view.setHoverListener(this);
        return view;
    }

    public void R(Object enterTransition) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.F.setEnterTransition((Transition) enterTransition);
        }
    }

    public void S(Object exitTransition) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.F.setExitTransition((Transition) exitTransition);
        }
    }

    public void T(l0 hoverListener) {
        this.H = hoverListener;
    }

    public void U(boolean touchModal) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = G;
            if (method != null) {
                try {
                    method.invoke(this.F, Boolean.valueOf(touchModal));
                    return;
                } catch (Exception e) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.F.setTouchModal(touchModal);
    }

    @Override // a.b.g.l0
    public void g(a.b.f.j.g menu, MenuItem item) {
        l0 l0Var = this.H;
        if (l0Var != null) {
            l0Var.g(menu, item);
        }
    }

    @Override // a.b.g.l0
    public void k(a.b.f.j.g menu, MenuItem item) {
        l0 l0Var = this.H;
        if (l0Var != null) {
            l0Var.k(menu, item);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends g0 {
        public final int p;
        public final int q;
        public l0 r;
        public MenuItem s;

        @Override // a.b.g.g0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public a(Context context, boolean hijackFocus) {
            super(context, hijackFocus);
            Resources res = context.getResources();
            Configuration config = res.getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == config.getLayoutDirection()) {
                this.p = 21;
                this.q = 22;
            } else {
                this.p = 22;
                this.q = 21;
            }
        }

        public void setHoverListener(l0 hoverListener) {
            this.r = hoverListener;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            a.b.f.j.f menuAdapter;
            ListMenuItemView selectedItem = (ListMenuItemView) getSelectedView();
            if (selectedItem != null && keyCode == this.p) {
                if (selectedItem.isEnabled() && selectedItem.getItemData().hasSubMenu()) {
                    performItemClick(selectedItem, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (selectedItem != null && keyCode == this.q) {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    menuAdapter = (a.b.f.j.f) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    menuAdapter = (a.b.f.j.f) adapter;
                }
                menuAdapter.b().e(false);
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }

        @Override // a.b.g.g0, android.view.View
        public boolean onHoverEvent(MotionEvent ev) {
            int headersCount;
            a.b.f.j.f menuAdapter;
            int position;
            int itemPosition;
            if (this.r != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerAdapter.getHeadersCount();
                    menuAdapter = (a.b.f.j.f) headerAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    menuAdapter = (a.b.f.j.f) adapter;
                }
                MenuItem menuItem = null;
                if (ev.getAction() != 10 && (position = pointToPosition((int) ev.getX(), (int) ev.getY())) != -1 && (itemPosition = position - headersCount) >= 0 && itemPosition < menuAdapter.getCount()) {
                    menuItem = menuAdapter.getItem(itemPosition);
                }
                MenuItem oldMenuItem = this.s;
                if (oldMenuItem != menuItem) {
                    a.b.f.j.g menu = menuAdapter.b();
                    if (oldMenuItem != null) {
                        this.r.k(menu, oldMenuItem);
                    }
                    this.s = menuItem;
                    if (menuItem != null) {
                        this.r.g(menu, menuItem);
                    }
                }
            }
            return super.onHoverEvent(ev);
        }
    }
}
