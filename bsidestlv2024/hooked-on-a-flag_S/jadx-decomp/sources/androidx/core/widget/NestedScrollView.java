package androidx.core.widget;

import a.h.k.e0.c;
import a.h.k.e0.e;
import a.h.k.k;
import a.h.k.l;
import a.h.k.n;
import a.h.k.p;
import a.h.k.v;
import a.h.l.d;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.appcompat.app.AlertController;
import java.util.List;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements n, k {

    /* renamed from: b, reason: collision with root package name */
    public static final a f851b = new a();
    public static final int[] c = {R.attr.fillViewport};
    public final l A;
    public float B;
    public b C;
    public long d;
    public final Rect e;
    public OverScroller f;
    public EdgeEffect g;
    public EdgeEffect h;
    public int i;
    public boolean j;
    public boolean k;
    public View l;
    public boolean m;
    public VelocityTracker n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public int t;
    public final int[] u;
    public final int[] v;
    public int w;
    public int x;
    public c y;
    public final p z;

    /* loaded from: classes.dex */
    public interface b {
    }

    public NestedScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.e = new Rect();
        this.j = true;
        this.k = false;
        this.l = null;
        this.m = false;
        this.p = true;
        this.t = -1;
        this.u = new int[2];
        this.v = new int[2];
        x();
        TypedArray a2 = context.obtainStyledAttributes(attrs, c, defStyleAttr, 0);
        setFillViewport(a2.getBoolean(0, false));
        a2.recycle();
        this.z = new p();
        this.A = new l(this);
        setNestedScrollingEnabled(true);
        v.o0(this, f851b);
    }

    public void g(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        this.A.e(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed);
    }

    public boolean P(int axes, int type) {
        return this.A.p(axes, type);
    }

    public void Q(int type) {
        this.A.r(type);
    }

    public boolean u(int type) {
        return this.A.k(type);
    }

    public boolean f(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        return this.A.d(dx, dy, consumed, offsetInWindow, type);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean enabled) {
        this.A.m(enabled);
    }

    @Override // android.view.View, a.h.k.k
    public boolean isNestedScrollingEnabled() {
        return this.A.l();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int axes) {
        return P(axes, 0);
    }

    @Override // android.view.View, a.h.k.k
    public void stopNestedScroll() {
        Q(0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return u(0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return this.A.f(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return f(dx, dy, consumed, offsetInWindow, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return this.A.a(velocityX, velocityY, consumed);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.A.b(velocityX, velocityY);
    }

    @Override // a.h.k.n
    public void k(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        C(dyUnconsumed, type, consumed);
    }

    public final void C(int dyUnconsumed, int type, int[] consumed) {
        int oldScrollY = getScrollY();
        scrollBy(0, dyUnconsumed);
        int myConsumed = getScrollY() - oldScrollY;
        if (consumed != null) {
            consumed[1] = consumed[1] + myConsumed;
        }
        int myUnconsumed = dyUnconsumed - myConsumed;
        this.A.e(0, myConsumed, 0, myUnconsumed, null, type, consumed);
    }

    @Override // a.h.k.m
    public boolean o(View child, View target, int axes, int type) {
        return (axes & 2) != 0;
    }

    @Override // a.h.k.m
    public void i(View child, View target, int axes, int type) {
        this.z.b(axes, type);
        P(2, type);
    }

    @Override // a.h.k.m
    public void m(View target, int type) {
        this.z.d(type);
        Q(type);
    }

    @Override // a.h.k.m
    public void l(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        C(dyUnconsumed, type, null);
    }

    @Override // a.h.k.m
    public void n(View target, int dx, int dy, int[] consumed, int type) {
        f(dx, dy, consumed, null, type);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return o(child, target, nestedScrollAxes, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        i(child, target, nestedScrollAxes, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onStopNestedScroll(View target) {
        m(target, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        C(dyUnconsumed, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        n(target, dx, dy, consumed, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        if (!consumed) {
            dispatchNestedFling(0.0f, velocityY, true);
            s((int) velocityY);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.z.a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int length = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < length) {
            return scrollY / length;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View child = getChildAt(0);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
        int length = getVerticalFadingEdgeLength();
        int bottomEdge = getHeight() - getPaddingBottom();
        int span = ((child.getBottom() + lp.bottomMargin) - getScrollY()) - bottomEdge;
        if (span < length) {
            return span / length;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    public final void x() {
        this.f = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        this.q = configuration.getScaledTouchSlop();
        this.r = configuration.getScaledMinimumFlingVelocity();
        this.s = configuration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(child);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(child, index);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(child, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(child, index, params);
    }

    public void setOnScrollChangeListener(b l) {
        this.C = l;
    }

    public final boolean c() {
        if (getChildCount() <= 0) {
            return false;
        }
        View child = getChildAt(0);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
        int childSize = child.getHeight() + lp.topMargin + lp.bottomMargin;
        int parentSpace = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return childSize > parentSpace;
    }

    public void setFillViewport(boolean fillViewport) {
        if (fillViewport != this.o) {
            this.o = fillViewport;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        this.p = smoothScrollingEnabled;
    }

    @Override // android.view.View
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        b bVar = this.C;
        if (bVar != null) {
            ((AlertController.b) bVar).a(this, l, t, oldl, oldt);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!this.o) {
            return;
        }
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode != 0 && getChildCount() > 0) {
            View child = getChildAt(0);
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
            int childSize = child.getMeasuredHeight();
            int parentSpace = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - lp.topMargin) - lp.bottomMargin;
            if (childSize < parentSpace) {
                int childWidthMeasureSpec = FrameLayout.getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin, lp.width);
                int childHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(parentSpace, 1073741824);
                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event) || q(event);
    }

    public boolean q(KeyEvent event) {
        this.e.setEmpty();
        if (!c()) {
            if (!isFocused() || event.getKeyCode() == 4) {
                return false;
            }
            View currentFocused = findFocus();
            if (currentFocused == this) {
                currentFocused = null;
            }
            View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, 130);
            return (nextFocused == null || nextFocused == this || !nextFocused.requestFocus(130)) ? false : true;
        }
        if (event.getAction() != 0) {
            return false;
        }
        switch (event.getKeyCode()) {
            case 19:
                if (!event.isAltPressed()) {
                    boolean handled = b(33);
                    return handled;
                }
                boolean handled2 = t(33);
                return handled2;
            case 20:
                if (!event.isAltPressed()) {
                    boolean handled3 = b(130);
                    return handled3;
                }
                boolean handled4 = t(130);
                return handled4;
            case 62:
                F(event.isShiftPressed() ? 33 : 130);
                return false;
            default:
                return false;
        }
    }

    public final boolean v(int x, int y) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View child = getChildAt(0);
        return y >= child.getTop() - scrollY && y < child.getBottom() - scrollY && x >= child.getLeft() && x < child.getRight();
    }

    public final void w() {
        VelocityTracker velocityTracker = this.n;
        if (velocityTracker == null) {
            this.n = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public final void y() {
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
    }

    public final void G() {
        VelocityTracker velocityTracker = this.n;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.n = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept) {
            G();
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == 2 && this.m) {
            return true;
        }
        switch (action & 255) {
            case 0:
                int y = (int) ev.getY();
                if (!v((int) ev.getX(), y)) {
                    this.m = false;
                    G();
                    break;
                } else {
                    this.i = y;
                    this.t = ev.getPointerId(0);
                    w();
                    this.n.addMovement(ev);
                    this.f.computeScrollOffset();
                    this.m = true ^ this.f.isFinished();
                    P(2, 0);
                    break;
                }
            case 1:
            case 3:
                this.m = false;
                this.t = -1;
                G();
                if (this.f.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    v.f0(this);
                }
                Q(0);
                break;
            case 2:
                int activePointerId = this.t;
                if (activePointerId != -1) {
                    int pointerIndex = ev.findPointerIndex(activePointerId);
                    if (pointerIndex == -1) {
                        Log.e("NestedScrollView", "Invalid pointerId=" + activePointerId + " in onInterceptTouchEvent");
                        break;
                    } else {
                        int y2 = (int) ev.getY(pointerIndex);
                        int yDiff = Math.abs(y2 - this.i);
                        if (yDiff > this.q && (2 & getNestedScrollAxes()) == 0) {
                            this.m = true;
                            this.i = y2;
                            y();
                            this.n.addMovement(ev);
                            this.w = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                }
                break;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                D(ev);
                break;
        }
        return this.m;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        ViewParent parent;
        int deltaY;
        int deltaY2;
        y();
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            this.w = 0;
        }
        MotionEvent vtev = MotionEvent.obtain(ev);
        vtev.offsetLocation(0.0f, this.w);
        switch (actionMasked) {
            case 0:
                if (getChildCount() == 0) {
                    return false;
                }
                boolean z = !this.f.isFinished();
                this.m = z;
                if (z && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (!this.f.isFinished()) {
                    a();
                }
                this.i = (int) ev.getY();
                this.t = ev.getPointerId(0);
                P(2, 0);
                break;
            case 1:
                VelocityTracker velocityTracker = this.n;
                velocityTracker.computeCurrentVelocity(1000, this.s);
                int initialVelocity = (int) velocityTracker.getYVelocity(this.t);
                if (Math.abs(initialVelocity) >= this.r) {
                    if (!dispatchNestedPreFling(0.0f, -initialVelocity)) {
                        dispatchNestedFling(0.0f, -initialVelocity, true);
                        s(-initialVelocity);
                    }
                } else if (this.f.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    v.f0(this);
                }
                this.t = -1;
                j();
                break;
            case 2:
                int activePointerIndex = ev.findPointerIndex(this.t);
                if (activePointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.t + " in onTouchEvent");
                    break;
                } else {
                    int y = (int) ev.getY(activePointerIndex);
                    int deltaY3 = this.i - y;
                    if (!this.m && Math.abs(deltaY3) > this.q) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.m = true;
                        if (deltaY3 > 0) {
                            deltaY = deltaY3 - this.q;
                        } else {
                            deltaY = deltaY3 + this.q;
                        }
                    } else {
                        deltaY = deltaY3;
                    }
                    if (!this.m) {
                        break;
                    } else {
                        if (!f(0, deltaY, this.v, this.u, 0)) {
                            deltaY2 = deltaY;
                        } else {
                            int deltaY4 = deltaY - this.v[1];
                            this.w += this.u[1];
                            deltaY2 = deltaY4;
                        }
                        this.i = y - this.u[1];
                        int oldY = getScrollY();
                        int range = getScrollRange();
                        int overscrollMode = getOverScrollMode();
                        boolean canOverscroll = overscrollMode == 0 || (overscrollMode == 1 && range > 0);
                        if (E(0, deltaY2, 0, getScrollY(), 0, range, 0, 0) && !u(0)) {
                            this.n.clear();
                        }
                        int scrolledDeltaY = getScrollY() - oldY;
                        int unconsumedY = deltaY2 - scrolledDeltaY;
                        int[] iArr = this.v;
                        iArr[1] = 0;
                        g(0, scrolledDeltaY, 0, unconsumedY, this.u, 0, iArr);
                        int i = this.i;
                        int[] iArr2 = this.u;
                        this.i = i - iArr2[1];
                        this.w += iArr2[1];
                        if (!canOverscroll) {
                            break;
                        } else {
                            int deltaY5 = deltaY2 - this.v[1];
                            p();
                            int pulledToY = oldY + deltaY5;
                            if (pulledToY < 0) {
                                d.a(this.g, deltaY5 / getHeight(), ev.getX(activePointerIndex) / getWidth());
                                if (!this.h.isFinished()) {
                                    this.h.onRelease();
                                }
                            } else if (pulledToY > range) {
                                d.a(this.h, deltaY5 / getHeight(), 1.0f - (ev.getX(activePointerIndex) / getWidth()));
                                if (!this.g.isFinished()) {
                                    this.g.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.g;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.h.isFinished())) {
                                v.f0(this);
                            }
                            break;
                        }
                    }
                }
                break;
            case 3:
                if (this.m && getChildCount() > 0 && this.f.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    v.f0(this);
                }
                this.t = -1;
                j();
                break;
            case 5:
                int index = ev.getActionIndex();
                this.i = (int) ev.getY(index);
                this.t = ev.getPointerId(index);
                break;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                D(ev);
                this.i = (int) ev.getY(ev.findPointerIndex(this.t));
                break;
        }
        VelocityTracker velocityTracker2 = this.n;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(vtev);
        }
        vtev.recycle();
        return true;
    }

    public final void D(MotionEvent ev) {
        int pointerIndex = ev.getActionIndex();
        int pointerId = ev.getPointerId(pointerIndex);
        if (pointerId == this.t) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.i = (int) ev.getY(newPointerIndex);
            this.t = ev.getPointerId(newPointerIndex);
            VelocityTracker velocityTracker = this.n;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent event) {
        if ((event.getSource() & 2) != 0) {
            switch (event.getAction()) {
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    if (!this.m) {
                        float vscroll = event.getAxisValue(9);
                        if (vscroll != 0.0f) {
                            int delta = (int) (getVerticalScrollFactorCompat() * vscroll);
                            int range = getScrollRange();
                            int oldScrollY = getScrollY();
                            int newScrollY = oldScrollY - delta;
                            if (newScrollY < 0) {
                                newScrollY = 0;
                            } else if (newScrollY > range) {
                                newScrollY = range;
                            }
                            if (newScrollY != oldScrollY) {
                                super.scrollTo(getScrollX(), newScrollY);
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.B == 0.0f) {
            TypedValue outValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, outValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.B = outValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.B;
    }

    @Override // android.view.View
    public void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.scrollTo(scrollX, scrollY);
    }

    public boolean E(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY) {
        int maxOverScrollX2;
        int maxOverScrollY2;
        boolean clampedX;
        boolean clampedY;
        int overScrollMode = getOverScrollMode();
        boolean canScrollHorizontal = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean canScrollVertical = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean overScrollHorizontal = overScrollMode == 0 || (overScrollMode == 1 && canScrollHorizontal);
        boolean overScrollVertical = overScrollMode == 0 || (overScrollMode == 1 && canScrollVertical);
        int newScrollX = scrollX + deltaX;
        if (overScrollHorizontal) {
            maxOverScrollX2 = maxOverScrollX;
        } else {
            maxOverScrollX2 = 0;
        }
        int newScrollY = scrollY + deltaY;
        if (overScrollVertical) {
            maxOverScrollY2 = maxOverScrollY;
        } else {
            maxOverScrollY2 = 0;
        }
        int left = -maxOverScrollX2;
        int right = maxOverScrollX2 + scrollRangeX;
        int top = -maxOverScrollY2;
        int bottom = maxOverScrollY2 + scrollRangeY;
        if (newScrollX > right) {
            newScrollX = right;
            clampedX = true;
        } else if (newScrollX >= left) {
            clampedX = false;
        } else {
            newScrollX = left;
            clampedX = true;
        }
        if (newScrollY > bottom) {
            newScrollY = bottom;
            clampedY = true;
        } else if (newScrollY >= top) {
            clampedY = false;
        } else {
            newScrollY = top;
            clampedY = true;
        }
        if (clampedY && !u(1)) {
            this.f.springBack(newScrollX, newScrollY, 0, 0, 0, getScrollRange());
        }
        boolean isTouchEvent = clampedX;
        onOverScrolled(newScrollX, newScrollY, isTouchEvent, clampedY);
        return isTouchEvent || clampedY;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View child = getChildAt(0);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
        int childSize = child.getHeight() + lp.topMargin + lp.bottomMargin;
        int parentSpace = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int scrollRange = Math.max(0, childSize - parentSpace);
        return scrollRange;
    }

    public final View r(boolean topFocus, int top, int bottom) {
        List<View> focusables = getFocusables(2);
        View focusCandidate = null;
        boolean foundFullyContainedFocusable = false;
        int count = focusables.size();
        for (int i = 0; i < count; i++) {
            View view = focusables.get(i);
            int viewTop = view.getTop();
            int viewBottom = view.getBottom();
            if (top < viewBottom && viewTop < bottom) {
                boolean viewIsCloserToBoundary = false;
                boolean viewIsFullyContained = top < viewTop && viewBottom < bottom;
                if (focusCandidate == null) {
                    focusCandidate = view;
                    foundFullyContainedFocusable = viewIsFullyContained;
                } else {
                    if ((topFocus && viewTop < focusCandidate.getTop()) || (!topFocus && viewBottom > focusCandidate.getBottom())) {
                        viewIsCloserToBoundary = true;
                    }
                    if (foundFullyContainedFocusable) {
                        if (viewIsFullyContained && viewIsCloserToBoundary) {
                            focusCandidate = view;
                        }
                    } else if (viewIsFullyContained) {
                        focusCandidate = view;
                        foundFullyContainedFocusable = true;
                    } else if (viewIsCloserToBoundary) {
                        focusCandidate = view;
                    }
                }
            }
        }
        return focusCandidate;
    }

    public boolean F(int direction) {
        boolean down = direction == 130;
        int height = getHeight();
        if (down) {
            this.e.top = getScrollY() + height;
            int count = getChildCount();
            if (count > 0) {
                View view = getChildAt(count - 1);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
                int bottom = view.getBottom() + lp.bottomMargin + getPaddingBottom();
                Rect rect = this.e;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.e.top = getScrollY() - height;
            Rect rect2 = this.e;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.e;
        int i = rect3.top;
        int i2 = i + height;
        rect3.bottom = i2;
        return I(direction, i, i2);
    }

    public boolean t(int direction) {
        int count;
        boolean down = direction == 130;
        int height = getHeight();
        Rect rect = this.e;
        rect.top = 0;
        rect.bottom = height;
        if (down && (count = getChildCount()) > 0) {
            View view = getChildAt(count - 1);
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.e.bottom = view.getBottom() + lp.bottomMargin + getPaddingBottom();
            Rect rect2 = this.e;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.e;
        return I(direction, rect3.top, rect3.bottom);
    }

    public final boolean I(int direction, int top, int bottom) {
        boolean handled = true;
        int height = getHeight();
        int containerTop = getScrollY();
        int containerBottom = containerTop + height;
        boolean up = direction == 33;
        View newFocused = r(up, top, bottom);
        if (newFocused == null) {
            newFocused = this;
        }
        if (top >= containerTop && bottom <= containerBottom) {
            handled = false;
        } else {
            int delta = up ? top - containerTop : bottom - containerBottom;
            h(delta);
        }
        if (newFocused != findFocus()) {
            newFocused.requestFocus(direction);
        }
        return handled;
    }

    public boolean b(int direction) {
        View currentFocused = findFocus();
        if (currentFocused == this) {
            currentFocused = null;
        }
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        int maxJump = getMaxScrollAmount();
        if (nextFocused != null && B(nextFocused, maxJump, getHeight())) {
            nextFocused.getDrawingRect(this.e);
            offsetDescendantRectToMyCoords(nextFocused, this.e);
            h(e(this.e));
            nextFocused.requestFocus(direction);
        } else {
            int scrollDelta = maxJump;
            if (direction == 33 && getScrollY() < scrollDelta) {
                scrollDelta = getScrollY();
            } else if (direction == 130 && getChildCount() > 0) {
                View child = getChildAt(0);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
                int daBottom = child.getBottom() + lp.bottomMargin;
                int screenBottom = (getScrollY() + getHeight()) - getPaddingBottom();
                scrollDelta = Math.min(daBottom - screenBottom, maxJump);
            }
            if (scrollDelta == 0) {
                return false;
            }
            h(direction == 130 ? scrollDelta : -scrollDelta);
        }
        if (currentFocused != null && currentFocused.isFocused() && z(currentFocused)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
            return true;
        }
        return true;
    }

    public final boolean z(View descendant) {
        return !B(descendant, 0, getHeight());
    }

    public final boolean B(View descendant, int delta, int height) {
        descendant.getDrawingRect(this.e);
        offsetDescendantRectToMyCoords(descendant, this.e);
        return this.e.bottom + delta >= getScrollY() && this.e.top - delta <= getScrollY() + height;
    }

    public final void h(int delta) {
        if (delta != 0) {
            if (this.p) {
                L(0, delta);
            } else {
                scrollBy(0, delta);
            }
        }
    }

    public final void L(int dx, int dy) {
        M(dx, dy, SQLiteDatabase.MAX_SQL_CACHE_SIZE, false);
    }

    public final void M(int dx, int dy, int scrollDurationMs, boolean withNestedScrolling) {
        if (getChildCount() != 0) {
            long duration = AnimationUtils.currentAnimationTimeMillis() - this.d;
            if (duration > 250) {
                View child = getChildAt(0);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
                int childSize = child.getHeight() + lp.topMargin + lp.bottomMargin;
                int parentSpace = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                int maxY = Math.max(0, childSize - parentSpace);
                this.f.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + dy, maxY)) - scrollY, scrollDurationMs);
                H(withNestedScrolling);
            } else {
                if (!this.f.isFinished()) {
                    a();
                }
                scrollBy(dx, dy);
            }
            this.d = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public void O(int x, int y, boolean withNestedScrolling) {
        N(x, y, SQLiteDatabase.MAX_SQL_CACHE_SIZE, withNestedScrolling);
    }

    public void N(int x, int y, int scrollDurationMs, boolean withNestedScrolling) {
        M(x - getScrollX(), y - getScrollY(), scrollDurationMs, withNestedScrolling);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int count = getChildCount();
        int parentSpace = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (count == 0) {
            return parentSpace;
        }
        View child = getChildAt(0);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
        int scrollRange = child.getBottom() + lp.bottomMargin;
        int scrollY = getScrollY();
        int overscrollBottom = Math.max(0, scrollRange - parentSpace);
        if (scrollY < 0) {
            return scrollRange - scrollY;
        }
        if (scrollY > overscrollBottom) {
            return scrollRange + (scrollY - overscrollBottom);
        }
        return scrollRange;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.ViewGroup
    public void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        int childWidthMeasureSpec = FrameLayout.getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight(), lp.width);
        int childHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        int childWidthMeasureSpec = FrameLayout.getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin + widthUsed, lp.width);
        int childHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(lp.topMargin + lp.bottomMargin, 0);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f.isFinished()) {
            return;
        }
        this.f.computeScrollOffset();
        int y = this.f.getCurrY();
        int unconsumed = y - this.x;
        this.x = y;
        int[] iArr = this.v;
        boolean z = false;
        iArr[1] = 0;
        f(0, unconsumed, iArr, null, 1);
        int unconsumed2 = unconsumed - this.v[1];
        int range = getScrollRange();
        if (unconsumed2 != 0) {
            int oldScrollY = getScrollY();
            E(0, unconsumed2, getScrollX(), oldScrollY, 0, range, 0, 0);
            int scrolledByMe = getScrollY() - oldScrollY;
            int unconsumed3 = unconsumed2 - scrolledByMe;
            int[] iArr2 = this.v;
            iArr2[1] = 0;
            g(0, scrolledByMe, 0, unconsumed3, this.u, 1, iArr2);
            unconsumed2 = unconsumed3 - this.v[1];
        }
        if (unconsumed2 != 0) {
            int mode = getOverScrollMode();
            if (mode == 0 || (mode == 1 && range > 0)) {
                z = true;
            }
            boolean canOverscroll = z;
            if (canOverscroll) {
                p();
                if (unconsumed2 < 0) {
                    if (this.g.isFinished()) {
                        this.g.onAbsorb((int) this.f.getCurrVelocity());
                    }
                } else if (this.h.isFinished()) {
                    this.h.onAbsorb((int) this.f.getCurrVelocity());
                }
            }
            a();
        }
        if (!this.f.isFinished()) {
            v.f0(this);
        } else {
            Q(1);
        }
    }

    public final void H(boolean participateInNestedScrolling) {
        if (participateInNestedScrolling) {
            P(2, 1);
        } else {
            Q(1);
        }
        this.x = getScrollY();
        v.f0(this);
    }

    public final void a() {
        this.f.abortAnimation();
        Q(1);
    }

    public final void J(View child) {
        child.getDrawingRect(this.e);
        offsetDescendantRectToMyCoords(child, this.e);
        int scrollDelta = e(this.e);
        if (scrollDelta != 0) {
            scrollBy(0, scrollDelta);
        }
    }

    public final boolean K(Rect rect, boolean immediate) {
        int delta = e(rect);
        boolean scroll = delta != 0;
        if (scroll) {
            if (immediate) {
                scrollBy(0, delta);
            } else {
                L(0, delta);
            }
        }
        return scroll;
    }

    public int e(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int screenTop = getScrollY();
        int screenBottom = screenTop + height;
        int fadingEdge = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            screenTop += fadingEdge;
        }
        View child = getChildAt(0);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
        if (rect.bottom < child.getHeight() + lp.topMargin + lp.bottomMargin) {
            screenBottom -= fadingEdge;
        }
        int i = rect.bottom;
        if (i > screenBottom && rect.top > screenTop) {
            int scrollYDelta = rect.height() > height ? 0 + (rect.top - screenTop) : 0 + (rect.bottom - screenBottom);
            int bottom = child.getBottom() + lp.bottomMargin;
            int distanceToBottom = bottom - screenBottom;
            return Math.min(scrollYDelta, distanceToBottom);
        }
        if (rect.top >= screenTop || i >= screenBottom) {
            return 0;
        }
        int scrollYDelta2 = rect.height() > height ? 0 - (screenBottom - rect.bottom) : 0 - (screenTop - rect.top);
        return Math.max(scrollYDelta2, -getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        if (!this.j) {
            J(focused);
        } else {
            this.l = focused;
        }
        super.requestChildFocus(child, focused);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        View nextFocus;
        if (direction == 2) {
            direction = 130;
        } else if (direction == 1) {
            direction = 33;
        }
        if (previouslyFocusedRect == null) {
            nextFocus = FocusFinder.getInstance().findNextFocus(this, null, direction);
        } else {
            nextFocus = FocusFinder.getInstance().findNextFocusFromRect(this, previouslyFocusedRect, direction);
        }
        if (nextFocus == null || z(nextFocus)) {
            return false;
        }
        return nextFocus.requestFocus(direction, previouslyFocusedRect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        rectangle.offset(child.getLeft() - child.getScrollX(), child.getTop() - child.getScrollY());
        return K(rectangle, immediate);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.j = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        this.j = false;
        View view = this.l;
        if (view != null && A(view, this)) {
            J(this.l);
        }
        this.l = null;
        if (!this.k) {
            if (this.y != null) {
                scrollTo(getScrollX(), this.y.f852b);
                this.y = null;
            }
            int childSize = 0;
            if (getChildCount() > 0) {
                View child = getChildAt(0);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
                childSize = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            }
            int parentSpace = ((b2 - t) - getPaddingTop()) - getPaddingBottom();
            int currentScrollY = getScrollY();
            int newScrollY = d(currentScrollY, parentSpace, childSize);
            if (newScrollY != currentScrollY) {
                scrollTo(getScrollX(), newScrollY);
            }
        }
        int parentSpace2 = getScrollX();
        scrollTo(parentSpace2, getScrollY());
        this.k = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        View currentFocused = findFocus();
        if (currentFocused != null && this != currentFocused && B(currentFocused, 0, oldh)) {
            currentFocused.getDrawingRect(this.e);
            offsetDescendantRectToMyCoords(currentFocused, this.e);
            int scrollDelta = e(this.e);
            h(scrollDelta);
        }
    }

    public static boolean A(View child, View parent) {
        if (child == parent) {
            return true;
        }
        Object parent2 = child.getParent();
        return (parent2 instanceof ViewGroup) && A((View) parent2, parent);
    }

    public void s(int velocityY) {
        if (getChildCount() > 0) {
            this.f.fling(getScrollX(), getScrollY(), 0, velocityY, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            H(true);
        }
    }

    public final void j() {
        this.m = false;
        G();
        Q(0);
        EdgeEffect edgeEffect = this.g;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.h.onRelease();
        }
    }

    @Override // android.view.View
    public void scrollTo(int x, int y) {
        if (getChildCount() > 0) {
            View child = getChildAt(0);
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
            int parentSpaceHorizontal = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int childSizeHorizontal = child.getWidth() + lp.leftMargin + lp.rightMargin;
            int parentSpaceVertical = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int childSizeVertical = child.getHeight() + lp.topMargin + lp.bottomMargin;
            int x2 = d(x, parentSpaceHorizontal, childSizeHorizontal);
            int y2 = d(y, parentSpaceVertical, childSizeVertical);
            if (x2 != getScrollX() || y2 != getScrollY()) {
                super.scrollTo(x2, y2);
            }
        }
    }

    public final void p() {
        if (getOverScrollMode() != 2) {
            if (this.g == null) {
                Context context = getContext();
                this.g = new EdgeEffect(context);
                this.h = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.g = null;
        this.h = null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g != null) {
            int scrollY = getScrollY();
            if (!this.g.isFinished()) {
                int restoreCount = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int xTranslation = 0;
                int yTranslation = Math.min(0, scrollY);
                int i = Build.VERSION.SDK_INT;
                if (i < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    xTranslation = 0 + getPaddingLeft();
                }
                if (i >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    yTranslation += getPaddingTop();
                }
                canvas.translate(xTranslation, yTranslation);
                this.g.setSize(width, height);
                if (this.g.draw(canvas)) {
                    v.f0(this);
                }
                canvas.restoreToCount(restoreCount);
            }
            if (!this.h.isFinished()) {
                int restoreCount2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int xTranslation2 = 0;
                int yTranslation2 = Math.max(getScrollRange(), scrollY) + height2;
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    xTranslation2 = 0 + getPaddingLeft();
                }
                if (i2 >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    yTranslation2 -= getPaddingBottom();
                }
                canvas.translate(xTranslation2 - width2, yTranslation2);
                canvas.rotate(180.0f, width2, 0.0f);
                this.h.setSize(width2, height2);
                if (this.h.draw(canvas)) {
                    v.f0(this);
                }
                canvas.restoreToCount(restoreCount2);
            }
        }
    }

    public static int d(int n, int my, int child) {
        if (my >= child || n < 0) {
            return 0;
        }
        if (my + n > child) {
            return child - my;
        }
        return n;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof c)) {
            super.onRestoreInstanceState(state);
            return;
        }
        c ss = (c) state;
        super.onRestoreInstanceState(ss.getSuperState());
        this.y = ss;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        c ss = new c(superState);
        ss.f852b = getScrollY();
        return ss;
    }

    /* loaded from: classes.dex */
    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f852b;

        public c(Parcelable superState) {
            super(superState);
        }

        public c(Parcel source) {
            super(source);
            this.f852b = source.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f852b);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f852b + "}";
        }

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<c> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel in) {
                return new c(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int size) {
                return new c[size];
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends a.h.k.a {
        @Override // a.h.k.a
        public boolean j(View host, int action, Bundle arguments) {
            if (super.j(host, action, arguments)) {
                return true;
            }
            NestedScrollView nsvHost = (NestedScrollView) host;
            if (!nsvHost.isEnabled()) {
                return false;
            }
            switch (action) {
                case 4096:
                case R.id.accessibilityActionScrollDown:
                    int viewportHeight = (nsvHost.getHeight() - nsvHost.getPaddingBottom()) - nsvHost.getPaddingTop();
                    int targetScrollY = Math.min(nsvHost.getScrollY() + viewportHeight, nsvHost.getScrollRange());
                    if (targetScrollY == nsvHost.getScrollY()) {
                        return false;
                    }
                    nsvHost.O(0, targetScrollY, true);
                    return true;
                case 8192:
                case R.id.accessibilityActionScrollUp:
                    int viewportHeight2 = (nsvHost.getHeight() - nsvHost.getPaddingBottom()) - nsvHost.getPaddingTop();
                    int targetScrollY2 = Math.max(nsvHost.getScrollY() - viewportHeight2, 0);
                    if (targetScrollY2 == nsvHost.getScrollY()) {
                        return false;
                    }
                    nsvHost.O(0, targetScrollY2, true);
                    return true;
                default:
                    return false;
            }
        }

        @Override // a.h.k.a
        public void g(View host, a.h.k.e0.c info) {
            int scrollRange;
            super.g(host, info);
            NestedScrollView nsvHost = (NestedScrollView) host;
            info.W(ScrollView.class.getName());
            if (nsvHost.isEnabled() && (scrollRange = nsvHost.getScrollRange()) > 0) {
                info.n0(true);
                if (nsvHost.getScrollY() > 0) {
                    info.b(c.a.c);
                    info.b(c.a.g);
                }
                if (nsvHost.getScrollY() < scrollRange) {
                    info.b(c.a.f454b);
                    info.b(c.a.h);
                }
            }
        }

        @Override // a.h.k.a
        public void f(View host, AccessibilityEvent event) {
            super.f(host, event);
            NestedScrollView nsvHost = (NestedScrollView) host;
            event.setClassName(ScrollView.class.getName());
            boolean scrollable = nsvHost.getScrollRange() > 0;
            event.setScrollable(scrollable);
            event.setScrollX(nsvHost.getScrollX());
            event.setScrollY(nsvHost.getScrollY());
            e.a(event, nsvHost.getScrollX());
            e.b(event, nsvHost.getScrollRange());
        }
    }
}
