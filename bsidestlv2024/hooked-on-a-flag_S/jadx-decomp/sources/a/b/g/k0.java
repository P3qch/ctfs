package a.b.g;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import net.sqlcipher.R;
import net.sqlcipher.database.SQLiteCursor;

/* loaded from: classes.dex */
public class k0 implements a.b.f.j.p {

    /* renamed from: b, reason: collision with root package name */
    public static Method f164b;
    public static Method c;
    public static Method d;
    public final c A;
    public final Handler B;
    public final Rect C;
    public Rect D;
    public boolean E;
    public PopupWindow F;
    public Context e;
    public ListAdapter f;
    public g0 g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public DataSetObserver u;
    public View v;
    public AdapterView.OnItemClickListener w;
    public final g x;
    public final f y;
    public final e z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f164b = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e2) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                d = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException e3) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                c = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException e4) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public k0(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public k0(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public k0(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.h = -2;
        this.i = -2;
        this.l = 1002;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = Integer.MAX_VALUE;
        this.t = 0;
        this.x = new g();
        this.y = new f();
        this.z = new e();
        this.A = new c();
        this.C = new Rect();
        this.e = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray a2 = context.obtainStyledAttributes(attrs, a.b.a.n, defStyleAttr, defStyleRes);
        int[] iArr = a.b.a.f11a;
        this.j = a2.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = a2.getDimensionPixelOffset(1, 0);
        this.k = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.m = true;
        }
        a2.recycle();
        q qVar = new q(context, attrs, defStyleAttr, defStyleRes);
        this.F = qVar;
        qVar.setInputMethodMode(1);
    }

    public void o(ListAdapter adapter) {
        DataSetObserver dataSetObserver = this.u;
        if (dataSetObserver == null) {
            this.u = new d();
        } else {
            ListAdapter listAdapter = this.f;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f = adapter;
        if (adapter != null) {
            adapter.registerDataSetObserver(this.u);
        }
        g0 g0Var = this.g;
        if (g0Var != null) {
            g0Var.setAdapter(this.f);
        }
    }

    public void O(int position) {
        this.t = position;
    }

    public void J(boolean modal) {
        this.E = modal;
        this.F.setFocusable(modal);
    }

    public boolean B() {
        return this.E;
    }

    public Drawable n() {
        return this.F.getBackground();
    }

    public void l(Drawable d2) {
        this.F.setBackgroundDrawable(d2);
    }

    public void E(int animationStyle) {
        this.F.setAnimationStyle(animationStyle);
    }

    public View t() {
        return this.v;
    }

    public void D(View anchor) {
        this.v = anchor;
    }

    public int d() {
        return this.j;
    }

    public void c(int offset) {
        this.j = offset;
    }

    public int j() {
        if (!this.m) {
            return 0;
        }
        return this.k;
    }

    public void m(int offset) {
        this.k = offset;
        this.m = true;
    }

    public void H(Rect bounds) {
        this.D = bounds != null ? new Rect(bounds) : null;
    }

    public void G(int gravity) {
        this.p = gravity;
    }

    public int z() {
        return this.i;
    }

    public void Q(int width) {
        this.i = width;
    }

    public void F(int width) {
        Drawable popupBackground = this.F.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(this.C);
            Rect rect = this.C;
            this.i = rect.left + rect.right + width;
            return;
        }
        Q(width);
    }

    public void L(AdapterView.OnItemClickListener clickListener) {
        this.w = clickListener;
    }

    @Override // a.b.f.j.p
    public void i() {
        int widthSpec;
        int heightSpec;
        int widthSpec2;
        int heightSpec2;
        int height = q();
        boolean noInputMethod = A();
        a.h.l.h.b(this.F, this.l);
        if (this.F.isShowing()) {
            if (!a.h.k.v.S(t())) {
                return;
            }
            int widthSpec3 = this.i;
            if (widthSpec3 == -1) {
                widthSpec2 = -1;
            } else if (widthSpec3 == -2) {
                widthSpec2 = t().getWidth();
            } else {
                widthSpec2 = this.i;
            }
            int i = this.h;
            if (i == -1) {
                heightSpec2 = noInputMethod ? height : -1;
                if (noInputMethod) {
                    this.F.setWidth(this.i == -1 ? -1 : 0);
                    this.F.setHeight(0);
                } else {
                    this.F.setWidth(this.i == -1 ? -1 : 0);
                    this.F.setHeight(-1);
                }
            } else {
                heightSpec2 = i == -2 ? height : this.h;
            }
            this.F.setOutsideTouchable(true);
            this.F.update(t(), this.j, this.k, widthSpec2 < 0 ? -1 : widthSpec2, heightSpec2 < 0 ? -1 : heightSpec2);
            return;
        }
        int widthSpec4 = this.i;
        if (widthSpec4 == -1) {
            widthSpec = -1;
        } else if (widthSpec4 == -2) {
            widthSpec = t().getWidth();
        } else {
            widthSpec = this.i;
        }
        int i2 = this.h;
        if (i2 == -1) {
            heightSpec = -1;
        } else if (i2 == -2) {
            heightSpec = height;
        } else {
            heightSpec = this.h;
        }
        this.F.setWidth(widthSpec);
        this.F.setHeight(heightSpec);
        N(true);
        this.F.setOutsideTouchable(true);
        this.F.setTouchInterceptor(this.y);
        if (this.o) {
            a.h.l.h.a(this.F, this.n);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = d;
            if (method != null) {
                try {
                    method.invoke(this.F, this.D);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.F.setEpicenterBounds(this.D);
        }
        a.h.l.h.c(this.F, t(), this.j, this.k, this.p);
        this.g.setSelection(-1);
        if (!this.E || this.g.isInTouchMode()) {
            r();
        }
        if (!this.E) {
            this.B.post(this.A);
        }
    }

    @Override // a.b.f.j.p
    public void dismiss() {
        this.F.dismiss();
        C();
        this.F.setContentView(null);
        this.g = null;
        this.B.removeCallbacks(this.x);
    }

    public void K(PopupWindow.OnDismissListener listener) {
        this.F.setOnDismissListener(listener);
    }

    public final void C() {
    }

    public void I(int mode) {
        this.F.setInputMethodMode(mode);
    }

    public void P(int position) {
        g0 list = this.g;
        if (a() && list != null) {
            list.setListSelectionHidden(false);
            list.setSelection(position);
            if (list.getChoiceMode() != 0) {
                list.setItemChecked(position, true);
            }
        }
    }

    public void r() {
        g0 list = this.g;
        if (list != null) {
            list.setListSelectionHidden(true);
            list.requestLayout();
        }
    }

    @Override // a.b.f.j.p
    public boolean a() {
        return this.F.isShowing();
    }

    public boolean A() {
        return this.F.getInputMethodMode() == 2;
    }

    public Object v() {
        if (!a()) {
            return null;
        }
        return this.g.getSelectedItem();
    }

    public int x() {
        if (!a()) {
            return -1;
        }
        return this.g.getSelectedItemPosition();
    }

    public long w() {
        if (!a()) {
            return Long.MIN_VALUE;
        }
        return this.g.getSelectedItemId();
    }

    public View y() {
        if (!a()) {
            return null;
        }
        return this.g.getSelectedView();
    }

    @Override // a.b.f.j.p
    public ListView e() {
        return this.g;
    }

    public g0 s(Context context, boolean hijackFocus) {
        return new g0(context, hijackFocus);
    }

    public final int q() {
        int padding;
        int childWidthSpec;
        int widthMode;
        int widthSize;
        int otherHeights = 0;
        if (this.g == null) {
            Context context = this.e;
            new a();
            g0 s = s(context, !this.E);
            this.g = s;
            s.setAdapter(this.f);
            this.g.setOnItemClickListener(this.w);
            this.g.setFocusable(true);
            this.g.setFocusableInTouchMode(true);
            this.g.setOnItemSelectedListener(new b());
            this.g.setOnScrollListener(this.z);
            ViewGroup dropDownView = this.g;
            View hintView = null;
            if (0 != 0) {
                LinearLayout hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(1);
                LinearLayout.LayoutParams hintParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.t) {
                    case 0:
                        hintContainer.addView(null);
                        hintContainer.addView(dropDownView, hintParams);
                        break;
                    case 1:
                        hintContainer.addView(dropDownView, hintParams);
                        hintContainer.addView(null);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.t);
                        break;
                }
                if (this.i >= 0) {
                    widthMode = Integer.MIN_VALUE;
                    widthSize = this.i;
                } else {
                    widthMode = 0;
                    widthSize = 0;
                }
                int widthSpec = View.MeasureSpec.makeMeasureSpec(widthSize, widthMode);
                hintView.measure(widthSpec, 0);
                LinearLayout.LayoutParams hintParams2 = (LinearLayout.LayoutParams) hintView.getLayoutParams();
                dropDownView = hintContainer;
                otherHeights = hintView.getMeasuredHeight() + hintParams2.topMargin + hintParams2.bottomMargin;
            }
            this.F.setContentView(dropDownView);
        } else {
            View view = null;
            if (0 != 0) {
                LinearLayout.LayoutParams hintParams3 = (LinearLayout.LayoutParams) view.getLayoutParams();
                otherHeights = view.getMeasuredHeight() + hintParams3.topMargin + hintParams3.bottomMargin;
            }
        }
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i = rect.top;
            padding = rect.bottom + i;
            if (!this.m) {
                this.k = -i;
            }
        } else {
            this.C.setEmpty();
            padding = 0;
        }
        boolean ignoreBottomDecorations = this.F.getInputMethodMode() == 2;
        int maxHeight = u(t(), this.k, ignoreBottomDecorations);
        if (this.h == -1) {
            return maxHeight + padding;
        }
        int i2 = this.i;
        switch (i2) {
            case -2:
                int i3 = this.e.getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = this.C;
                childWidthSpec = View.MeasureSpec.makeMeasureSpec(i3 - (rect2.left + rect2.right), Integer.MIN_VALUE);
                break;
            case SQLiteCursor.NO_COUNT /* -1 */:
                int i4 = this.e.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.C;
                childWidthSpec = View.MeasureSpec.makeMeasureSpec(i4 - (rect3.left + rect3.right), 1073741824);
                break;
            default:
                childWidthSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                break;
        }
        int listContent = this.g.d(childWidthSpec, maxHeight - otherHeights, -1);
        if (listContent > 0) {
            int listPadding = this.g.getPaddingTop() + this.g.getPaddingBottom();
            otherHeights += padding + listPadding;
        }
        int listPadding2 = listContent + otherHeights;
        return listPadding2;
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = k0.this.t();
            if (view != null && view.getWindowToken() != null) {
                k0.this.i();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            g0 dropDownList;
            if (position != -1 && (dropDownList = k0.this.g) != null) {
                dropDownList.setListSelectionHidden(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    public void M(boolean overlapAnchor) {
        this.o = true;
        this.n = overlapAnchor;
    }

    /* loaded from: classes.dex */
    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (k0.this.a()) {
                k0.this.i();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            k0.this.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.this.r();
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g0 g0Var = k0.this.g;
            if (g0Var != null && a.h.k.v.S(g0Var) && k0.this.g.getCount() > k0.this.g.getChildCount()) {
                int childCount = k0.this.g.getChildCount();
                k0 k0Var = k0.this;
                if (childCount <= k0Var.s) {
                    k0Var.F.setInputMethodMode(2);
                    k0.this.i();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            PopupWindow popupWindow;
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (action == 0 && (popupWindow = k0.this.F) != null && popupWindow.isShowing() && x >= 0 && x < k0.this.F.getWidth() && y >= 0 && y < k0.this.F.getHeight()) {
                k0 k0Var = k0.this;
                k0Var.B.postDelayed(k0Var.x, 250L);
                return false;
            }
            if (action == 1) {
                k0 k0Var2 = k0.this;
                k0Var2.B.removeCallbacks(k0Var2.x);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == 1 && !k0.this.A() && k0.this.F.getContentView() != null) {
                k0 k0Var = k0.this;
                k0Var.B.removeCallbacks(k0Var.x);
                k0.this.x.run();
            }
        }
    }

    public final void N(boolean clip) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f164b;
            if (method != null) {
                try {
                    method.invoke(this.F, Boolean.valueOf(clip));
                    return;
                } catch (Exception e2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.F.setIsClippedToScreen(clip);
    }

    public final int u(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.F, anchor, Integer.valueOf(yOffset), Boolean.valueOf(ignoreBottomDecorations))).intValue();
                } catch (Exception e2) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.F.getMaxAvailableHeight(anchor, yOffset);
        }
        return this.F.getMaxAvailableHeight(anchor, yOffset, ignoreBottomDecorations);
    }
}
