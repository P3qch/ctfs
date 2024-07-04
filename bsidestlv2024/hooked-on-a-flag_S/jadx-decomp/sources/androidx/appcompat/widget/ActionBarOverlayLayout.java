package androidx.appcompat.widget;

import a.b.f.j.m;
import a.b.g.d0;
import a.b.g.e0;
import a.b.g.e1;
import a.h.k.d0;
import a.h.k.m;
import a.h.k.n;
import a.h.k.o;
import a.h.k.p;
import a.h.k.v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import net.sqlcipher.R;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements d0, o, m, n {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f801b = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public d A;
    public OverScroller B;
    public ViewPropertyAnimator C;
    public final AnimatorListenerAdapter D;
    public final Runnable E;
    public final Runnable F;
    public final p G;
    public int c;
    public int d;
    public ContentFrameLayout e;
    public ActionBarContainer f;
    public e0 g;
    public Drawable h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public final Rect p;
    public final Rect q;
    public final Rect r;
    public final Rect s;
    public final Rect t;
    public final Rect u;
    public final Rect v;
    public a.h.k.d0 w;
    public a.h.k.d0 x;
    public a.h.k.d0 y;
    public a.h.k.d0 z;

    /* loaded from: classes.dex */
    public interface d {
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.C = null;
            actionBarOverlayLayout.m = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.C = null;
            actionBarOverlayLayout.m = false;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.C = actionBarOverlayLayout.f.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.D);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.C = actionBarOverlayLayout.f.animate().translationY(-ActionBarOverlayLayout.this.f.getHeight()).setListener(ActionBarOverlayLayout.this.D);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.d = 0;
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        a.h.k.d0 d0Var = a.h.k.d0.f440a;
        this.w = d0Var;
        this.x = d0Var;
        this.y = d0Var;
        this.z = d0Var;
        this.D = new a();
        this.E = new b();
        this.F = new c();
        v(context);
        this.G = new p();
    }

    public final void v(Context context) {
        TypedArray ta = getContext().getTheme().obtainStyledAttributes(f801b);
        this.c = ta.getDimensionPixelSize(0, 0);
        Drawable drawable = ta.getDrawable(1);
        this.h = drawable;
        setWillNotDraw(drawable == null);
        ta.recycle();
        this.i = context.getApplicationInfo().targetSdkVersion < 19;
        this.B = new OverScroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    public void setActionBarVisibilityCallback(d cb) {
        this.A = cb;
        if (getWindowToken() != null) {
            ((a.b.b.m) this.A).C(this.d);
            if (this.o != 0) {
                int newVis = this.o;
                onWindowSystemUiVisibilityChanged(newVis);
                v.l0(this);
            }
        }
    }

    public void setOverlayMode(boolean overlayMode) {
        this.j = overlayMode;
        this.i = overlayMode && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public boolean w() {
        return this.j;
    }

    public void setHasNonEmbeddedTabs(boolean hasNonEmbeddedTabs) {
        this.k = hasNonEmbeddedTabs;
    }

    public void setShowingForActionMode(boolean showing) {
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        v(getContext());
        v.l0(this);
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int visible) {
        super.onWindowSystemUiVisibilityChanged(visible);
        z();
        int diff = this.o ^ visible;
        this.o = visible;
        boolean barVisible = (visible & 4) == 0;
        boolean stable = (visible & 256) != 0;
        d dVar = this.A;
        if (dVar != null) {
            ((a.b.b.m) dVar).u(stable ? false : true);
            if (barVisible || !stable) {
                ((a.b.b.m) this.A).L();
            } else {
                ((a.b.b.m) this.A).y();
            }
        }
        if ((diff & 256) != 0 && this.A != null) {
            v.l0(this);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        this.d = visibility;
        d dVar = this.A;
        if (dVar != null) {
            ((a.b.b.m) dVar).C(visibility);
        }
    }

    public final boolean q(View view, Rect insets, boolean left, boolean top, boolean bottom, boolean right) {
        boolean changed = false;
        e lp = (e) view.getLayoutParams();
        if (left) {
            int i = ((ViewGroup.MarginLayoutParams) lp).leftMargin;
            int i2 = insets.left;
            if (i != i2) {
                changed = true;
                ((ViewGroup.MarginLayoutParams) lp).leftMargin = i2;
            }
        }
        if (top) {
            int i3 = ((ViewGroup.MarginLayoutParams) lp).topMargin;
            int i4 = insets.top;
            if (i3 != i4) {
                changed = true;
                ((ViewGroup.MarginLayoutParams) lp).topMargin = i4;
            }
        }
        if (right) {
            int i5 = ((ViewGroup.MarginLayoutParams) lp).rightMargin;
            int i6 = insets.right;
            if (i5 != i6) {
                changed = true;
                ((ViewGroup.MarginLayoutParams) lp).rightMargin = i6;
            }
        }
        if (!bottom) {
            return changed;
        }
        int i7 = ((ViewGroup.MarginLayoutParams) lp).bottomMargin;
        int i8 = insets.bottom;
        if (i7 != i8) {
            ((ViewGroup.MarginLayoutParams) lp).bottomMargin = i8;
            return true;
        }
        return changed;
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect insets) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(insets);
        }
        z();
        boolean changed = q(this.f, insets, true, true, false, true);
        this.s.set(insets);
        e1.a(this, this.s, this.p);
        if (!this.t.equals(this.s)) {
            changed = true;
            this.t.set(this.s);
        }
        if (!this.q.equals(this.p)) {
            changed = true;
            this.q.set(this.p);
        }
        if (changed) {
            requestLayout();
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets in) {
        z();
        a.h.k.d0 insets = a.h.k.d0.t(in, this);
        Rect systemInsets = new Rect(insets.g(), insets.i(), insets.h(), insets.f());
        boolean changed = q(this.f, systemInsets, true, true, false, true);
        v.g(this, insets, this.p);
        Rect rect = this.p;
        a.h.k.d0 j = insets.j(rect.left, rect.top, rect.right, rect.bottom);
        this.w = j;
        if (!this.x.equals(j)) {
            changed = true;
            this.x = this.w;
        }
        if (!this.q.equals(this.p)) {
            changed = true;
            this.q.set(this.p);
        }
        if (changed) {
            requestLayout();
        }
        return insets.a().c().b().r();
    }

    @Override // android.view.ViewGroup
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attrs) {
        return new e(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new e(p);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof e;
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        z();
        int topInset = 0;
        measureChildWithMargins(this.f, widthMeasureSpec, 0, heightMeasureSpec, 0);
        e lp = (e) this.f.getLayoutParams();
        int maxWidth = Math.max(0, this.f.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) lp).leftMargin + ((ViewGroup.MarginLayoutParams) lp).rightMargin);
        int maxHeight = Math.max(0, this.f.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) lp).topMargin + ((ViewGroup.MarginLayoutParams) lp).bottomMargin);
        int childState = View.combineMeasuredStates(0, this.f.getMeasuredState());
        int vis = v.M(this);
        boolean stable = (vis & 256) != 0;
        if (stable) {
            topInset = this.c;
            if (this.k) {
                View tabs = this.f.getTabContainer();
                if (tabs != null) {
                    topInset += this.c;
                }
            }
        } else if (this.f.getVisibility() != 8) {
            topInset = this.f.getMeasuredHeight();
        }
        this.r.set(this.p);
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            this.y = this.w;
        } else {
            this.u.set(this.s);
        }
        if (!this.j && !stable) {
            Rect rect = this.r;
            rect.top += topInset;
            rect.bottom += 0;
            if (i >= 21) {
                this.y = this.y.j(0, topInset, 0, 0);
            }
        } else if (i >= 21) {
            a.h.d.b sysWindow = a.h.d.b.a(this.y.g(), this.y.i() + topInset, this.y.h(), this.y.f() + 0);
            d0.b bVar = new d0.b(this.y);
            bVar.c(sysWindow);
            this.y = bVar.a();
        } else {
            Rect rect2 = this.u;
            rect2.top += topInset;
            rect2.bottom += 0;
        }
        q(this.e, this.r, true, true, true, true);
        if (i >= 21 && !this.z.equals(this.y)) {
            a.h.k.d0 d0Var = this.y;
            this.z = d0Var;
            v.h(this.e, d0Var);
        } else if (i < 21 && !this.v.equals(this.u)) {
            this.v.set(this.u);
            this.e.a(this.u);
        }
        measureChildWithMargins(this.e, widthMeasureSpec, 0, heightMeasureSpec, 0);
        e lp2 = (e) this.e.getLayoutParams();
        int maxWidth2 = Math.max(maxWidth, this.e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) lp2).leftMargin + ((ViewGroup.MarginLayoutParams) lp2).rightMargin);
        int maxHeight2 = Math.max(maxHeight, this.e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) lp2).topMargin + ((ViewGroup.MarginLayoutParams) lp2).bottomMargin);
        int childState2 = View.combineMeasuredStates(childState, this.e.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(maxWidth2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), widthMeasureSpec, childState2), View.resolveSizeAndState(Math.max(maxHeight2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), heightMeasureSpec, childState2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount();
        int parentLeft = getPaddingLeft();
        int parentTop = getPaddingTop();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                e lp = (e) child.getLayoutParams();
                int width = child.getMeasuredWidth();
                int height = child.getMeasuredHeight();
                int childLeft = ((ViewGroup.MarginLayoutParams) lp).leftMargin + parentLeft;
                int childTop = ((ViewGroup.MarginLayoutParams) lp).topMargin + parentTop;
                child.layout(childLeft, childTop, childLeft + width, childTop + height);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas c2) {
        int top;
        super.draw(c2);
        if (this.h != null && !this.i) {
            if (this.f.getVisibility() == 0) {
                top = (int) (this.f.getBottom() + this.f.getTranslationY() + 0.5f);
            } else {
                top = 0;
            }
            this.h.setBounds(0, top, getWidth(), this.h.getIntrinsicHeight() + top);
            this.h.draw(c2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // a.h.k.n
    public void k(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        l(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
    }

    @Override // a.h.k.m
    public boolean o(View child, View target, int axes, int type) {
        return type == 0 && onStartNestedScroll(child, target, axes);
    }

    @Override // a.h.k.m
    public void i(View child, View target, int axes, int type) {
        if (type == 0) {
            onNestedScrollAccepted(child, target, axes);
        }
    }

    @Override // a.h.k.m
    public void m(View target, int type) {
        if (type == 0) {
            onStopNestedScroll(target);
        }
    }

    @Override // a.h.k.m
    public void l(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if (type == 0) {
            onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        }
    }

    @Override // a.h.k.m
    public void n(View target, int dx, int dy, int[] consumed, int type) {
        if (type == 0) {
            onNestedPreScroll(target, dx, dy, consumed);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onStartNestedScroll(View child, View target, int axes) {
        if ((axes & 2) == 0 || this.f.getVisibility() != 0) {
            return false;
        }
        return this.l;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onNestedScrollAccepted(View child, View target, int axes) {
        this.G.c(child, target, axes);
        this.n = getActionBarHideOffset();
        u();
        d dVar = this.A;
        if (dVar != null) {
            ((a.b.b.m) dVar).A();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        int i = this.n + dyConsumed;
        this.n = i;
        setActionBarHideOffset(i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onStopNestedScroll(View target) {
        if (this.l && !this.m) {
            if (this.n <= this.f.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.A;
        if (dVar != null) {
            ((a.b.b.m) dVar).B();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        if (!this.l || !consumed) {
            return false;
        }
        if (B(velocityY)) {
            p();
        } else {
            A();
        }
        this.m = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.G.a();
    }

    public void z() {
        if (this.e == null) {
            this.e = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.g = t(findViewById(R.id.action_bar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e0 t(View view) {
        if (view instanceof e0) {
            return (e0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean hideOnContentScroll) {
        if (hideOnContentScroll != this.l) {
            this.l = hideOnContentScroll;
            if (!hideOnContentScroll) {
                u();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int offset) {
        u();
        int topHeight = this.f.getHeight();
        this.f.setTranslationY(-Math.max(0, Math.min(offset, topHeight)));
    }

    public void u() {
        removeCallbacks(this.E);
        removeCallbacks(this.F);
        ViewPropertyAnimator viewPropertyAnimator = this.C;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void y() {
        u();
        postDelayed(this.E, 600L);
    }

    public final void x() {
        u();
        postDelayed(this.F, 600L);
    }

    public final void A() {
        u();
        this.E.run();
    }

    public final void p() {
        u();
        this.F.run();
    }

    public final boolean B(float velocityY) {
        this.B.fling(0, 0, 0, (int) velocityY, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int finalY = this.B.getFinalY();
        return finalY > this.f.getHeight();
    }

    @Override // a.b.g.d0
    public void setWindowCallback(Window.Callback cb) {
        z();
        this.g.setWindowCallback(cb);
    }

    @Override // a.b.g.d0
    public void setWindowTitle(CharSequence title) {
        z();
        this.g.setWindowTitle(title);
    }

    public CharSequence getTitle() {
        z();
        return this.g.getTitle();
    }

    @Override // a.b.g.d0
    public void h(int windowFeature) {
        z();
        switch (windowFeature) {
            case 2:
                this.g.l();
                return;
            case 5:
                this.g.r();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void setUiOptions(int uiOptions) {
    }

    public void setIcon(int resId) {
        z();
        this.g.setIcon(resId);
    }

    public void setIcon(Drawable d2) {
        z();
        this.g.setIcon(d2);
    }

    public void setLogo(int resId) {
        z();
        this.g.n(resId);
    }

    @Override // a.b.g.d0
    public boolean f() {
        z();
        return this.g.f();
    }

    @Override // a.b.g.d0
    public boolean e() {
        z();
        return this.g.e();
    }

    @Override // a.b.g.d0
    public boolean c() {
        z();
        return this.g.c();
    }

    @Override // a.b.g.d0
    public boolean a() {
        z();
        return this.g.a();
    }

    @Override // a.b.g.d0
    public boolean g() {
        z();
        return this.g.g();
    }

    @Override // a.b.g.d0
    public void d() {
        z();
        this.g.d();
    }

    @Override // a.b.g.d0
    public void b(Menu menu, m.a cb) {
        z();
        this.g.b(menu, cb);
    }

    @Override // a.b.g.d0
    public void j() {
        z();
        this.g.h();
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public e(int width, int height) {
            super(width, height);
        }

        public e(ViewGroup.LayoutParams source) {
            super(source);
        }
    }
}
