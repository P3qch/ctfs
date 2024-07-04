package a.b.g;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class g0 extends ListView {

    /* renamed from: b, reason: collision with root package name */
    public final Rect f150b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public Field h;
    public a i;
    public boolean j;
    public boolean k;
    public boolean l;
    public a.h.k.z m;
    public a.h.l.f n;
    public b o;

    public g0(Context context, boolean hijackFocus) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f150b = new Rect();
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.k = hijackFocus;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.h = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.k && this.j) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.k || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.k || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable sel) {
        a aVar = sel != null ? new a(sel) : null;
        this.i = aVar;
        super.setSelector(aVar);
        Rect padding = new Rect();
        if (sel != null) {
            sel.getPadding(padding);
        }
        this.c = padding.left;
        this.d = padding.top;
        this.e = padding.right;
        this.f = padding.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.o != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        k();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                this.g = pointToPosition((int) ev.getX(), (int) ev.getY());
                break;
        }
        b bVar = this.o;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(ev);
    }

    public int d(int widthMeasureSpec, int maxHeight, int disallowPartialChildPosition) {
        ViewGroup.LayoutParams childLp;
        int startPosition = 0;
        int endPosition = 0;
        int paddingTop = getListPaddingTop();
        int paddingBottom = getListPaddingBottom();
        int reportedDividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            int startPosition2 = paddingTop + paddingBottom;
            return startPosition2;
        }
        int returnedHeight = paddingTop + paddingBottom;
        int dividerHeight = (reportedDividerHeight <= 0 || divider == null) ? 0 : reportedDividerHeight;
        int prevHeightWithoutPartialChild = 0;
        View child = null;
        int viewType = 0;
        int count = adapter.getCount();
        int i = 0;
        while (i < count) {
            int startPosition3 = startPosition;
            int newType = adapter.getItemViewType(i);
            if (newType != viewType) {
                child = null;
                viewType = newType;
            }
            child = adapter.getView(i, child, this);
            ViewGroup.LayoutParams childLp2 = child.getLayoutParams();
            if (childLp2 != null) {
                childLp = childLp2;
            } else {
                childLp = generateDefaultLayoutParams();
                child.setLayoutParams(childLp);
            }
            int endPosition2 = endPosition;
            int endPosition3 = childLp.height;
            int heightMeasureSpec = endPosition3 > 0 ? View.MeasureSpec.makeMeasureSpec(endPosition3, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0);
            child.measure(widthMeasureSpec, heightMeasureSpec);
            child.forceLayout();
            if (i > 0) {
                returnedHeight += dividerHeight;
            }
            returnedHeight += child.getMeasuredHeight();
            if (returnedHeight >= maxHeight) {
                if (disallowPartialChildPosition >= 0 && i > disallowPartialChildPosition && prevHeightWithoutPartialChild > 0 && returnedHeight != maxHeight) {
                    return prevHeightWithoutPartialChild;
                }
                return maxHeight;
            }
            if (disallowPartialChildPosition >= 0 && i >= disallowPartialChildPosition) {
                prevHeightWithoutPartialChild = returnedHeight;
            }
            i++;
            startPosition = startPosition3;
            endPosition = endPosition2;
        }
        return returnedHeight;
    }

    private void setSelectorEnabled(boolean enabled) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.c(enabled);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends a.b.d.a.c {
        public boolean c;

        public a(Drawable drawable) {
            super(drawable);
            this.c = true;
        }

        public void c(boolean enabled) {
            this.c = enabled;
        }

        @Override // a.b.d.a.c, android.graphics.drawable.Drawable
        public boolean setState(int[] stateSet) {
            if (this.c) {
                return super.setState(stateSet);
            }
            return false;
        }

        @Override // a.b.d.a.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.c) {
                super.draw(canvas);
            }
        }

        @Override // a.b.d.a.c, android.graphics.drawable.Drawable
        public void setHotspot(float x, float y) {
            if (this.c) {
                super.setHotspot(x, y);
            }
        }

        @Override // a.b.d.a.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int left, int top, int right, int bottom) {
            if (this.c) {
                super.setHotspotBounds(left, top, right, bottom);
            }
        }

        @Override // a.b.d.a.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean visible, boolean restart) {
            if (this.c) {
                return super.setVisible(visible, restart);
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent ev) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(ev);
        }
        int action = ev.getActionMasked();
        if (action == 10 && this.o == null) {
            b bVar = new b();
            this.o = bVar;
            bVar.b();
        }
        boolean handled = super.onHoverEvent(ev);
        if (action == 9 || action == 7) {
            int position = pointToPosition((int) ev.getX(), (int) ev.getY());
            if (position != -1 && position != getSelectedItemPosition()) {
                View hoveredItem = getChildAt(position - getFirstVisiblePosition());
                if (hoveredItem.isEnabled()) {
                    setSelectionFromTop(position, hoveredItem.getTop() - getTop());
                }
                k();
            }
        } else {
            setSelection(-1);
        }
        return handled;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.o = null;
        super.onDetachedFromWindow();
    }

    public boolean e(MotionEvent event, int activePointerId) {
        boolean handledEvent = true;
        boolean clearPressedItem = false;
        int actionMasked = event.getActionMasked();
        switch (actionMasked) {
            case 1:
                handledEvent = false;
            case 2:
                int activeIndex = event.findPointerIndex(activePointerId);
                if (activeIndex < 0) {
                    handledEvent = false;
                    break;
                } else {
                    int x = (int) event.getX(activeIndex);
                    int y = (int) event.getY(activeIndex);
                    int position = pointToPosition(x, y);
                    if (position == -1) {
                        clearPressedItem = true;
                        break;
                    } else {
                        View child = getChildAt(position - getFirstVisiblePosition());
                        i(child, position, x, y);
                        handledEvent = true;
                        if (actionMasked == 1) {
                            b(child, position);
                            break;
                        }
                    }
                }
                break;
            case 3:
                handledEvent = false;
                break;
        }
        if (!handledEvent || clearPressedItem) {
            a();
        }
        if (handledEvent) {
            if (this.n == null) {
                this.n = new a.h.l.f(this);
            }
            this.n.m(true);
            this.n.onTouch(this, event);
        } else {
            a.h.l.f fVar = this.n;
            if (fVar != null) {
                fVar.m(false);
            }
        }
        return handledEvent;
    }

    public final void b(View child, int position) {
        long id = getItemIdAtPosition(position);
        performItemClick(child, position, id);
    }

    public void setListSelectionHidden(boolean hideListSelection) {
        this.j = hideListSelection;
    }

    public final void k() {
        Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (!this.f150b.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f150b);
            selector.draw(canvas);
        }
    }

    public final void h(int position, View sel, float x, float y) {
        g(position, sel);
        Drawable selector = getSelector();
        if (selector != null && position != -1) {
            a.h.d.l.a.k(selector, x, y);
        }
    }

    public final void g(int position, View sel) {
        Drawable selector = getSelector();
        boolean manageState = (selector == null || position == -1) ? false : true;
        if (manageState) {
            selector.setVisible(false, false);
        }
        f(position, sel);
        if (manageState) {
            Rect bounds = this.f150b;
            float x = bounds.exactCenterX();
            float y = bounds.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            a.h.d.l.a.k(selector, x, y);
        }
    }

    public final void f(int position, View sel) {
        Rect selectorRect = this.f150b;
        selectorRect.set(sel.getLeft(), sel.getTop(), sel.getRight(), sel.getBottom());
        selectorRect.left -= this.c;
        selectorRect.top -= this.d;
        selectorRect.right += this.e;
        selectorRect.bottom += this.f;
        try {
            boolean isChildViewEnabled = this.h.getBoolean(this);
            if (sel.isEnabled() != isChildViewEnabled) {
                this.h.set(this, Boolean.valueOf(!isChildViewEnabled));
                if (position != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public final void a() {
        this.l = false;
        setPressed(false);
        drawableStateChanged();
        View motionView = getChildAt(this.g - getFirstVisiblePosition());
        if (motionView != null) {
            motionView.setPressed(false);
        }
        a.h.k.z zVar = this.m;
        if (zVar != null) {
            zVar.b();
            this.m = null;
        }
    }

    public final void i(View child, int position, float x, float y) {
        View motionView;
        this.l = true;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            drawableHotspotChanged(x, y);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.g;
        if (i2 != -1 && (motionView = getChildAt(i2 - getFirstVisiblePosition())) != null && motionView != child && motionView.isPressed()) {
            motionView.setPressed(false);
        }
        this.g = position;
        float childX = x - child.getLeft();
        float childY = y - child.getTop();
        if (i >= 21) {
            child.drawableHotspotChanged(childX, childY);
        }
        if (!child.isPressed()) {
            child.setPressed(true);
        }
        h(position, child, x, y);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    public final boolean j() {
        return this.l;
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g0 g0Var = g0.this;
            g0Var.o = null;
            g0Var.drawableStateChanged();
        }

        public void a() {
            g0 g0Var = g0.this;
            g0Var.o = null;
            g0Var.removeCallbacks(this);
        }

        public void b() {
            g0.this.post(this);
        }
    }
}
