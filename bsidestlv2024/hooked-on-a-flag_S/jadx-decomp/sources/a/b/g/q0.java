package a.b.g;

import a.b.b.a;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class q0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: b, reason: collision with root package name */
    public Runnable f184b;
    public boolean c;
    public int d;
    public int e;
    public int f;

    static {
        new DecelerateInterpolator();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean lockedExpanded = View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824;
        setFillViewport(lockedExpanded);
        ViewGroup viewGroup = null;
        viewGroup.getChildCount();
        throw null;
    }

    public void setAllowCollapse(boolean allowCollapse) {
        this.c = allowCollapse;
    }

    public void setTabSelected(int position) {
        this.f = position;
        ViewGroup viewGroup = null;
        viewGroup.getChildCount();
        throw null;
    }

    public void setContentHeight(int contentHeight) {
        this.e = contentHeight;
        requestLayout();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        a.b.f.a abp = a.b.f.a.b(getContext());
        setContentHeight(abp.f());
        this.d = abp.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f184b;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f184b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        a tabView = (a) view;
        tabView.a().a();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* loaded from: classes.dex */
    public class a extends LinearLayout {

        /* renamed from: b, reason: collision with root package name */
        public a.c f185b;
        public final /* synthetic */ q0 c;

        @Override // android.view.View
        public void setSelected(boolean selected) {
            boolean changed = isSelected() != selected;
            super.setSelected(selected);
            if (changed && selected) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
            super.onInitializeAccessibilityEvent(event);
            event.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            this.c.getClass();
        }

        public a.c a() {
            return this.f185b;
        }
    }
}
