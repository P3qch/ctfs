package androidx.appcompat.widget;

import a.b.f.b;
import a.b.f.j.g;
import a.b.g.c;
import a.b.g.e1;
import a.b.g.x0;
import a.h.k.v;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class ActionBarContextView extends a.b.g.a {
    public CharSequence j;
    public CharSequence k;
    public View l;
    public View m;
    public View n;
    public LinearLayout o;
    public TextView p;
    public TextView q;
    public int r;
    public int s;
    public boolean t;
    public int u;

    @Override // a.b.g.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // a.b.g.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // a.b.g.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        x0 a2 = x0.v(context, attrs, a.b.a.d, defStyle, 0);
        int[] iArr = a.b.a.f11a;
        v.r0(this, a2.g(0));
        this.r = a2.n(5, 0);
        this.s = a2.n(4, 0);
        this.f = a2.m(3, 0);
        this.u = a2.n(2, R.layout.abc_action_mode_close_item_material);
        a2.w();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.e;
        if (cVar != null) {
            cVar.B();
            this.e.C();
        }
    }

    @Override // a.b.g.a
    public void setContentHeight(int height) {
        this.f = height;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.n;
        if (view2 != null) {
            removeView(view2);
        }
        this.n = view;
        if (view != null && (linearLayout = this.o) != null) {
            removeView(linearLayout);
            this.o = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence title) {
        this.j = title;
        i();
    }

    public void setSubtitle(CharSequence subtitle) {
        this.k = subtitle;
        i();
    }

    public CharSequence getTitle() {
        return this.j;
    }

    public CharSequence getSubtitle() {
        return this.k;
    }

    public final void i() {
        if (this.o == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.o = linearLayout;
            this.p = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.q = (TextView) this.o.findViewById(R.id.action_bar_subtitle);
            if (this.r != 0) {
                this.p.setTextAppearance(getContext(), this.r);
            }
            if (this.s != 0) {
                this.q.setTextAppearance(getContext(), this.s);
            }
        }
        this.p.setText(this.j);
        this.q.setText(this.k);
        boolean hasTitle = !TextUtils.isEmpty(this.j);
        boolean hasSubtitle = !TextUtils.isEmpty(this.k);
        int i = 0;
        this.q.setVisibility(hasSubtitle ? 0 : 8);
        LinearLayout linearLayout2 = this.o;
        if (!hasTitle && !hasSubtitle) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        if (this.o.getParent() == null) {
            addView(this.o);
        }
    }

    public void h(b mode) {
        View view = this.l;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View inflate = inflater.inflate(this.u, (ViewGroup) this, false);
            this.l = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.l);
        }
        View findViewById = this.l.findViewById(R.id.action_mode_close_button);
        this.m = findViewById;
        findViewById.setOnClickListener(new a(this, mode));
        g menu = (g) mode.e();
        c cVar = this.e;
        if (cVar != null) {
            cVar.y();
        }
        c cVar2 = new c(getContext());
        this.e = cVar2;
        cVar2.J(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menu.c(this.e, this.c);
        ActionMenuView actionMenuView = (ActionMenuView) this.e.o(this);
        this.d = actionMenuView;
        v.r0(actionMenuView, null);
        addView(this.d, layoutParams);
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f800b;

        public a(ActionBarContextView this$0, b bVar) {
            this.f800b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            this.f800b.c();
        }
    }

    public void g() {
        if (this.l == null) {
            k();
        }
    }

    public void k() {
        removeAllViews();
        this.n = null;
        this.d = null;
        this.e = null;
        View view = this.m;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int contentWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight = this.f;
        if (maxHeight <= 0) {
            maxHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        }
        int verticalPadding = getPaddingTop() + getPaddingBottom();
        int availableWidth = (contentWidth - getPaddingLeft()) - getPaddingRight();
        int height = maxHeight - verticalPadding;
        int childSpecHeight = View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE);
        View view = this.l;
        if (view != null) {
            int availableWidth2 = c(view, availableWidth, childSpecHeight, 0);
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            availableWidth = availableWidth2 - (lp.leftMargin + lp.rightMargin);
        }
        ActionMenuView actionMenuView = this.d;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            availableWidth = c(this.d, availableWidth, childSpecHeight, 0);
        }
        LinearLayout linearLayout = this.o;
        if (linearLayout != null && this.n == null) {
            if (this.t) {
                int titleWidthSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.o.measure(titleWidthSpec, childSpecHeight);
                int titleWidth = this.o.getMeasuredWidth();
                boolean titleFits = titleWidth <= availableWidth;
                if (titleFits) {
                    availableWidth -= titleWidth;
                }
                this.o.setVisibility(titleFits ? 0 : 8);
            } else {
                availableWidth = c(linearLayout, availableWidth, childSpecHeight, 0);
            }
        }
        View view2 = this.n;
        if (view2 != null) {
            ViewGroup.LayoutParams lp2 = view2.getLayoutParams();
            int i = lp2.width;
            int customWidthMode = i != -2 ? 1073741824 : Integer.MIN_VALUE;
            int customWidth = i >= 0 ? Math.min(i, availableWidth) : availableWidth;
            int i2 = lp2.height;
            int customHeightMode = i2 == -2 ? Integer.MIN_VALUE : 1073741824;
            int customHeight = i2 >= 0 ? Math.min(i2, height) : height;
            View view3 = this.n;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(customWidth, customWidthMode);
            int widthMode2 = View.MeasureSpec.makeMeasureSpec(customHeight, customHeightMode);
            view3.measure(makeMeasureSpec, widthMode2);
        }
        int widthMode3 = this.f;
        if (widthMode3 <= 0) {
            int measuredHeight = 0;
            int count = getChildCount();
            for (int i3 = 0; i3 < count; i3++) {
                View v = getChildAt(i3);
                int paddedViewHeight = v.getMeasuredHeight() + verticalPadding;
                if (paddedViewHeight > measuredHeight) {
                    measuredHeight = paddedViewHeight;
                }
            }
            setMeasuredDimension(contentWidth, measuredHeight);
            return;
        }
        setMeasuredDimension(contentWidth, maxHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        int x;
        boolean isLayoutRtl = e1.b(this);
        int x2 = isLayoutRtl ? (r - l) - getPaddingRight() : getPaddingLeft();
        int y = getPaddingTop();
        int contentHeight = ((b2 - t) - getPaddingTop()) - getPaddingBottom();
        View view = this.l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            int startMargin = isLayoutRtl ? lp.rightMargin : lp.leftMargin;
            int endMargin = isLayoutRtl ? lp.leftMargin : lp.rightMargin;
            int x3 = a.b.g.a.d(x2, startMargin, isLayoutRtl);
            x = a.b.g.a.d(x3 + e(this.l, x3, y, contentHeight, isLayoutRtl), endMargin, isLayoutRtl);
        } else {
            x = x2;
        }
        LinearLayout linearLayout = this.o;
        if (linearLayout != null && this.n == null && linearLayout.getVisibility() != 8) {
            x += e(this.o, x, y, contentHeight, isLayoutRtl);
        }
        View view2 = this.n;
        if (view2 != null) {
            int e = x + e(view2, x, y, contentHeight, isLayoutRtl);
        }
        int x4 = isLayoutRtl ? getPaddingLeft() : (r - l) - getPaddingRight();
        ActionMenuView actionMenuView = this.d;
        if (actionMenuView != null) {
            int e2 = x4 + e(actionMenuView, x4, y, contentHeight, !isLayoutRtl);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == 32) {
            event.setSource(this);
            event.setClassName(getClass().getName());
            event.setPackageName(getContext().getPackageName());
            event.setContentDescription(this.j);
            return;
        }
        super.onInitializeAccessibilityEvent(event);
    }

    public void setTitleOptional(boolean titleOptional) {
        if (titleOptional != this.t) {
            requestLayout();
        }
        this.t = titleOptional;
    }

    public boolean j() {
        return this.t;
    }
}
