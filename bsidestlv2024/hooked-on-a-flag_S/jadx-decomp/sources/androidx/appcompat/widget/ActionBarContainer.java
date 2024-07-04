package androidx.appcompat.widget;

import a.b.a;
import a.b.g.b;
import a.b.g.q0;
import a.h.k.v;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f799b;
    public View c;
    public View d;
    public View e;
    public Drawable f;
    public Drawable g;
    public Drawable h;
    public boolean i;
    public boolean j;
    public int k;

    public ActionBarContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        Drawable bg = new b(this);
        v.r0(this, bg);
        TypedArray a2 = context.obtainStyledAttributes(attrs, a.f11a);
        int[] iArr = a.f11a;
        boolean z = false;
        this.f = a2.getDrawable(0);
        this.g = a2.getDrawable(2);
        this.k = a2.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.i = true;
            this.h = a2.getDrawable(1);
        }
        a2.recycle();
        if (this.i) {
            if (this.h == null) {
                z = true;
            }
        } else if (this.f == null && this.g == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.d = findViewById(R.id.action_bar);
        this.e = findViewById(R.id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable bg) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setCallback(null);
            unscheduleDrawable(this.f);
        }
        this.f = bg;
        if (bg != null) {
            bg.setCallback(this);
            View view = this.d;
            if (view != null) {
                this.f.setBounds(view.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
            }
        }
        boolean z = true;
        if (this.i) {
            if (this.h != null) {
                z = false;
            }
        } else if (this.f != null || this.g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable bg) {
        Drawable drawable;
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.g);
        }
        this.g = bg;
        if (bg != null) {
            bg.setCallback(this);
            if (this.j && (drawable = this.g) != null) {
                drawable.setBounds(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            }
        }
        boolean z = true;
        if (this.i) {
            if (this.h != null) {
                z = false;
            }
        } else if (this.f != null || this.g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable bg) {
        Drawable drawable;
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.h);
        }
        this.h = bg;
        boolean z = false;
        if (bg != null) {
            bg.setCallback(this);
            if (this.i && (drawable = this.h) != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.i) {
            if (this.h == null) {
                z = true;
            }
        } else if (this.f == null && this.g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        boolean isVisible = visibility == 0;
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setVisible(isVisible, false);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setVisible(isVisible, false);
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.setVisible(isVisible, false);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        return (who == this.f && !this.i) || (who == this.g && this.j) || ((who == this.h && this.i) || super.verifyDrawable(who));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f;
        if (drawable != null && drawable.isStateful()) {
            this.f.setState(getDrawableState());
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.g.setState(getDrawableState());
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null && drawable3.isStateful()) {
            this.h.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean isTransitioning) {
        this.f799b = isTransitioning;
        setDescendantFocusability(isTransitioning ? 393216 : 262144);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.f799b || super.onInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent ev) {
        super.onHoverEvent(ev);
        return true;
    }

    public void setTabContainer(q0 tabView) {
        View view = this.c;
        if (view != null) {
            removeView(view);
        }
        this.c = tabView;
        if (tabView != null) {
            addView(tabView);
            ViewGroup.LayoutParams lp = tabView.getLayoutParams();
            lp.width = -1;
            lp.height = -2;
            tabView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View child, ActionMode.Callback callback, int type) {
        if (type != 0) {
            return super.startActionModeForChild(child, callback, type);
        }
        return null;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    public final int a(View view) {
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int topMarginForTabs;
        int i;
        if (this.d == null && View.MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE && (i = this.k) >= 0) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(heightMeasureSpec)), Integer.MIN_VALUE);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.d == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        View view = this.c;
        if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
            if (!b(this.d)) {
                topMarginForTabs = a(this.d);
            } else if (!b(this.e)) {
                topMarginForTabs = a(this.e);
            } else {
                topMarginForTabs = 0;
            }
            int maxHeight = mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(heightMeasureSpec) : Integer.MAX_VALUE;
            setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.c) + topMarginForTabs, maxHeight));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        Drawable drawable;
        super.onLayout(changed, l, t, r, b2);
        View tabContainer = this.c;
        boolean hasTabs = (tabContainer == null || tabContainer.getVisibility() == 8) ? false : true;
        if (tabContainer != null && tabContainer.getVisibility() != 8) {
            int containerHeight = getMeasuredHeight();
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) tabContainer.getLayoutParams();
            int tabHeight = tabContainer.getMeasuredHeight();
            int i = lp.bottomMargin;
            tabContainer.layout(l, (containerHeight - tabHeight) - i, r, containerHeight - i);
        }
        int containerHeight2 = 0;
        if (this.i) {
            Drawable drawable2 = this.h;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                containerHeight2 = 1;
            }
        } else {
            if (this.f != null) {
                if (this.d.getVisibility() == 0) {
                    this.f.setBounds(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
                } else {
                    View view = this.e;
                    if (view != null && view.getVisibility() == 0) {
                        this.f.setBounds(this.e.getLeft(), this.e.getTop(), this.e.getRight(), this.e.getBottom());
                    } else {
                        this.f.setBounds(0, 0, 0, 0);
                    }
                }
                containerHeight2 = 1;
            }
            this.j = hasTabs;
            if (hasTabs && (drawable = this.g) != null) {
                drawable.setBounds(tabContainer.getLeft(), tabContainer.getTop(), tabContainer.getRight(), tabContainer.getBottom());
                containerHeight2 = 1;
            }
        }
        if (containerHeight2 != 0) {
            invalidate();
        }
    }
}
