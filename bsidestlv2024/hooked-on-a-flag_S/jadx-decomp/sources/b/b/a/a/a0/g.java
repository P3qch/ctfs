package b.b.a.a.a0;

import a.b.g.k0;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import b.b.a.a.r.j;
import com.google.android.material.textfield.TextInputLayout;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class g extends a.b.g.d {
    public final k0 e;
    public final AccessibilityManager f;
    public final Rect g;

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public g(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(b.b.a.a.b0.a.a.c(context, attributeSet, defStyleAttr, 0), attributeSet, defStyleAttr);
        this.g = new Rect();
        Context context2 = getContext();
        TypedArray attributes = j.h(context2, attributeSet, b.b.a.a.a.k, defStyleAttr, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int[] iArr = b.b.a.a.a.f942a;
        if (attributes.hasValue(0)) {
            int inputType = attributes.getInt(0, 0);
            if (inputType == 0) {
                setKeyListener(null);
            }
        }
        this.f = (AccessibilityManager) context2.getSystemService("accessibility");
        k0 k0Var = new k0(context2);
        this.e = k0Var;
        k0Var.J(true);
        k0Var.D(this);
        k0Var.I(2);
        k0Var.o(getAdapter());
        k0Var.L(new a());
        attributes.recycle();
    }

    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View selectedView, int position, long id) {
            Object selectedItem = position < 0 ? g.this.e.v() : g.this.getAdapter().getItem(position);
            g.this.e(selectedItem);
            AdapterView.OnItemClickListener userOnitemClickListener = g.this.getOnItemClickListener();
            if (userOnitemClickListener != null) {
                if (selectedView == null || position < 0) {
                    selectedView = g.this.e.y();
                    position = g.this.e.x();
                    id = g.this.e.w();
                }
                userOnitemClickListener.onItemClick(g.this.e.e(), selectedView, position, id);
            }
            g.this.e.dismiss();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.e.i();
        } else {
            super.showDropDown();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T adapter) {
        super.setAdapter(adapter);
        this.e.o(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout layout = c();
        if (layout != null && layout.O() && super.getHint() == null && b.b.a.a.r.e.a()) {
            setHint(BuildConfig.FLAVOR);
        }
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = c();
        if (textInputLayout != null && textInputLayout.O()) {
            return textInputLayout.getHint();
        }
        return super.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (View.MeasureSpec.getMode(widthMeasureSpec) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            setMeasuredDimension(Math.min(Math.max(measuredWidth, d()), View.MeasureSpec.getSize(widthMeasureSpec)), getMeasuredHeight());
        }
    }

    public final int d() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayout = c();
        if (adapter == null || textInputLayout == null) {
            return 0;
        }
        int width = 0;
        View itemView = null;
        int itemType = 0;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int start = Math.max(0, this.e.x());
        int end = Math.min(adapter.getCount(), start + 15);
        int start2 = Math.max(0, end - 15);
        for (int i = start2; i < end; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            itemView = adapter.getView(i, itemView, textInputLayout);
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        Drawable background = this.e.n();
        if (background != null) {
            background.getPadding(this.g);
            Rect rect = this.g;
            width += rect.left + rect.right;
        }
        int iconWidth = textInputLayout.getEndIconView().getMeasuredWidth();
        return width + iconWidth;
    }

    public final TextInputLayout c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final <T extends ListAdapter & Filterable> void e(Object selectedItem) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(selectedItem), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(selectedItem));
        setAdapter(adapter);
    }
}
