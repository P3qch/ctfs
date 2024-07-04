package a.k.b;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public final class h extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<View> f557b;
    public ArrayList<View> c;
    public View.OnApplyWindowInsetsListener d;
    public boolean e;

    public h(Context context, AttributeSet attrs, n fm) {
        super(context, attrs);
        String tagMessage;
        this.e = true;
        String name = attrs.getClassAttribute();
        TypedArray a2 = context.obtainStyledAttributes(attrs, a.k.a.f513b);
        if (name == null) {
            int[] iArr = a.k.a.f512a;
            name = a2.getString(0);
        }
        int[] iArr2 = a.k.a.f512a;
        String tag = a2.getString(1);
        a2.recycle();
        int id = getId();
        Fragment existingFragment = fm.c0(id);
        if (name != null && existingFragment == null) {
            if (id <= 0) {
                if (tag != null) {
                    tagMessage = " with tag " + tag;
                } else {
                    tagMessage = BuildConfig.FLAVOR;
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + name + tagMessage);
            }
            Fragment containerFragment = fm.l0().a(context.getClassLoader(), name);
            containerFragment.u0(attrs, null);
            v j = fm.j();
            j.n(true);
            j.c(this, containerFragment, tag);
            j.h();
        }
        fm.K0(this);
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition transition) {
        if (Build.VERSION.SDK_INT < 18) {
            super.setLayoutTransition(transition);
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        this.d = listener;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        a.h.k.d0 dispatchInsets;
        a.h.k.d0 insetsCompat = a.h.k.d0.s(insets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.d;
        if (onApplyWindowInsetsListener != null) {
            dispatchInsets = a.h.k.d0.s(onApplyWindowInsetsListener.onApplyWindowInsets(this, insets));
        } else {
            dispatchInsets = a.h.k.v.a0(this, insetsCompat);
        }
        if (!dispatchInsets.l()) {
            int count = getChildCount();
            for (int i = 0; i < count; i++) {
                a.h.k.v.h(getChildAt(i), dispatchInsets);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.e && this.f557b != null) {
            for (int i = 0; i < this.f557b.size(); i++) {
                super.drawChild(canvas, this.f557b.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        ArrayList<View> arrayList;
        if (this.e && (arrayList = this.f557b) != null && arrayList.size() > 0 && this.f557b.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, drawingTime);
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
            this.c.add(view);
        }
        super.startViewTransition(view);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.c;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f557b;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.e = true;
            }
        }
        super.endViewTransition(view);
    }

    public void setDrawDisappearingViewsLast(boolean drawDisappearingViewsFirst) {
        this.e = drawDisappearingViewsFirst;
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (n.u0(child) == null) {
            throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.");
        }
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        if (n.u0(child) == null) {
            throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.");
        }
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int index) {
        View view = getChildAt(index);
        a(view);
        super.removeViewAt(index);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int start, int count) {
        for (int i = start; i < start + count; i++) {
            View view = getChildAt(i);
            a(view);
        }
        super.removeViews(start, count);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int start, int count) {
        for (int i = start; i < start + count; i++) {
            View view = getChildAt(i);
            a(view);
        }
        super.removeViewsInLayout(start, count);
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int i = getChildCount() - 1; i >= 0; i--) {
            View view = getChildAt(i);
            a(view);
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View child, boolean animate) {
        if (animate) {
            a(child);
        }
        super.removeDetachedView(child, animate);
    }

    public final void a(View v) {
        ArrayList<View> arrayList = this.c;
        if (arrayList != null && arrayList.contains(v)) {
            if (this.f557b == null) {
                this.f557b = new ArrayList<>();
            }
            this.f557b.add(v);
        }
    }
}
