package androidx.appcompat.view.menu;

import a.b.a;
import a.b.f.j.i;
import a.b.f.j.n;
import a.b.g.x0;
import a.h.k.v;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: b, reason: collision with root package name */
    public i f798b;
    public ImageView c;
    public RadioButton d;
    public TextView e;
    public CheckBox f;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public LinearLayout j;
    public Drawable k;
    public int l;
    public Context m;
    public boolean n;
    public Drawable o;
    public boolean p;
    public LayoutInflater q;
    public boolean r;

    public ListMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        x0 a2 = x0.v(getContext(), attrs, a.q, defStyleAttr, 0);
        int[] iArr = a.f11a;
        this.k = a2.g(5);
        this.l = a2.n(1, -1);
        this.n = a2.a(7, false);
        this.m = context;
        this.o = a2.g(8);
        TypedArray b2 = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.p = b2.hasValue(0);
        a2.w();
        b2.recycle();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        v.r0(this, this.k);
        TextView textView = (TextView) findViewById(R.id.title);
        this.e = textView;
        int i = this.l;
        if (i != -1) {
            textView.setTextAppearance(this.m, i);
        }
        this.g = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.o);
        }
        this.i = (ImageView) findViewById(R.id.group_divider);
        this.j = (LinearLayout) findViewById(R.id.content);
    }

    @Override // a.b.f.j.n.a
    public void e(i itemData, int menuType) {
        this.f798b = itemData;
        setVisibility(itemData.isVisible() ? 0 : 8);
        setTitle(itemData.i(this));
        setCheckable(itemData.isCheckable());
        boolean z = itemData.z();
        itemData.g();
        h(z);
        setIcon(itemData.getIcon());
        setEnabled(itemData.isEnabled());
        setSubMenuArrowVisible(itemData.hasSubMenu());
        setContentDescription(itemData.getContentDescription());
    }

    public final void a(View v) {
        b(v, -1);
    }

    public final void b(View v, int index) {
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.addView(v, index);
        } else {
            addView(v, index);
        }
    }

    public void setForceShowIcon(boolean forceShow) {
        this.r = forceShow;
        this.n = forceShow;
    }

    public void setTitle(CharSequence title) {
        if (title != null) {
            this.e.setText(title);
            if (this.e.getVisibility() != 0) {
                this.e.setVisibility(0);
                return;
            }
            return;
        }
        if (this.e.getVisibility() != 8) {
            this.e.setVisibility(8);
        }
    }

    @Override // a.b.f.j.n.a
    public i getItemData() {
        return this.f798b;
    }

    public void setCheckable(boolean checkable) {
        CompoundButton compoundButton;
        CompoundButton otherCompoundButton;
        if (!checkable && this.d == null && this.f == null) {
            return;
        }
        if (this.f798b.m()) {
            if (this.d == null) {
                g();
            }
            compoundButton = this.d;
            otherCompoundButton = this.f;
        } else {
            CompoundButton compoundButton2 = this.f;
            if (compoundButton2 == null) {
                d();
            }
            compoundButton = this.f;
            otherCompoundButton = this.d;
        }
        if (checkable) {
            compoundButton.setChecked(this.f798b.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (otherCompoundButton != null && otherCompoundButton.getVisibility() != 8) {
                otherCompoundButton.setVisibility(8);
                return;
            }
            return;
        }
        CheckBox checkBox = this.f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.d;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean checked) {
        CompoundButton compoundButton;
        if (this.f798b.m()) {
            if (this.d == null) {
                g();
            }
            compoundButton = this.d;
        } else {
            CompoundButton compoundButton2 = this.f;
            if (compoundButton2 == null) {
                d();
            }
            compoundButton = this.f;
        }
        compoundButton.setChecked(checked);
    }

    private void setSubMenuArrowVisible(boolean hasSubmenu) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility(hasSubmenu ? 0 : 8);
        }
    }

    public void h(boolean showShortcut) {
        int newVisibility = (showShortcut && this.f798b.z()) ? 0 : 8;
        if (newVisibility == 0) {
            this.g.setText(this.f798b.h());
        }
        if (this.g.getVisibility() != newVisibility) {
            this.g.setVisibility(newVisibility);
        }
    }

    public void setIcon(Drawable icon) {
        this.f798b.y();
        boolean showIcon = this.r;
        if (!showIcon && !this.n) {
            return;
        }
        ImageView imageView = this.c;
        if (imageView == null && icon == null && !this.n) {
            return;
        }
        if (imageView == null) {
            f();
        }
        if (icon != null || this.n) {
            this.c.setImageDrawable(showIcon ? icon : null);
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
                return;
            }
            return;
        }
        this.c.setVisibility(8);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.c != null && this.n) {
            ViewGroup.LayoutParams lp = getLayoutParams();
            LinearLayout.LayoutParams iconLp = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int i = lp.height;
            if (i > 0 && iconLp.width <= 0) {
                iconLp.width = i;
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void f() {
        LayoutInflater inflater = getInflater();
        ImageView imageView = (ImageView) inflater.inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.c = imageView;
        b(imageView, 0);
    }

    public final void g() {
        LayoutInflater inflater = getInflater();
        RadioButton radioButton = (RadioButton) inflater.inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.d = radioButton;
        a(radioButton);
    }

    public final void d() {
        LayoutInflater inflater = getInflater();
        CheckBox checkBox = (CheckBox) inflater.inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f = checkBox;
        a(checkBox);
    }

    @Override // a.b.f.j.n.a
    public boolean c() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    public void setGroupDividerEnabled(boolean groupDividerEnabled) {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility((this.p || !groupDividerEnabled) ? 8 : 0);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.i;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            rect.top += this.i.getHeight() + lp.topMargin + lp.bottomMargin;
        }
    }
}
