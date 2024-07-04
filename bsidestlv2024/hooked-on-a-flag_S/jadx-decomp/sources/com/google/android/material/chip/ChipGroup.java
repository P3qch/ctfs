package com.google.android.material.chip;

import a.h.k.e0.c;
import a.h.k.v;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import b.b.a.a.r.j;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class ChipGroup extends b.b.a.a.r.c {
    public static final int f = R.style.Widget_MaterialComponents_ChipGroup;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public d k;
    public final b l;
    public e m;
    public int n;
    public boolean o;

    /* loaded from: classes.dex */
    public interface d {
        void a(ChipGroup chipGroup, int i);
    }

    /* loaded from: classes.dex */
    public static class c extends ViewGroup.MarginLayoutParams {
        public c(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public c(ViewGroup.LayoutParams source) {
            super(source);
        }

        public c(int width, int height) {
            super(width, height);
        }
    }

    public ChipGroup(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.chipGroupStyle);
    }

    public ChipGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(b.b.a.a.b0.a.a.c(context, attrs, defStyleAttr, R.style.Widget_MaterialComponents_ChipGroup), attrs, defStyleAttr);
        this.l = new b();
        this.m = new e();
        this.n = -1;
        this.o = false;
        Context context2 = getContext();
        TypedArray a2 = j.h(context2, attrs, b.b.a.a.a.d, defStyleAttr, R.style.Widget_MaterialComponents_ChipGroup, new int[0]);
        int[] iArr = b.b.a.a.a.f942a;
        int chipSpacing = a2.getDimensionPixelOffset(1, 0);
        setChipSpacingHorizontal(a2.getDimensionPixelOffset(2, chipSpacing));
        setChipSpacingVertical(a2.getDimensionPixelOffset(3, chipSpacing));
        setSingleLine(a2.getBoolean(5, false));
        setSingleSelection(a2.getBoolean(6, false));
        setSelectionRequired(a2.getBoolean(4, false));
        int checkedChip = a2.getResourceId(0, -1);
        if (checkedChip != -1) {
            this.n = checkedChip;
        }
        a2.recycle();
        super.setOnHierarchyChangeListener(this.m);
        v.x0(this, 1);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        a.h.k.e0.c infoCompat = a.h.k.e0.c.v0(info);
        int columnCount = c() ? getChipCount() : -1;
        infoCompat.Y(c.b.a(getRowCount(), columnCount, false, p() ? 1 : 2));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new c(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return new c(lp);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return super.checkLayoutParams(p) && (p instanceof c);
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener listener) {
        this.m.f1177a = listener;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.n;
        if (i != -1) {
            r(i, true);
            setCheckedId(this.n);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (child instanceof Chip) {
            Chip chip = (Chip) child;
            if (chip.isChecked()) {
                int i = this.n;
                if (i != -1 && this.i) {
                    r(i, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(child, index, params);
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable divider) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable divider) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerHorizontal(int dividerMode) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int dividerMode) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int flexWrap) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void m(int id) {
        int i = this.n;
        if (id == i) {
            return;
        }
        if (i != -1 && this.i) {
            r(i, false);
        }
        if (id != -1) {
            r(id, true);
        }
        setCheckedId(id);
    }

    public int getCheckedChipId() {
        if (this.i) {
            return this.n;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList<Integer> checkedIds = new ArrayList<>();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if ((child instanceof Chip) && ((Chip) child).isChecked()) {
                checkedIds.add(Integer.valueOf(child.getId()));
                if (this.i) {
                    return checkedIds;
                }
            }
        }
        return checkedIds;
    }

    public void n() {
        this.o = true;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child instanceof Chip) {
                ((Chip) child).setChecked(false);
            }
        }
        this.o = false;
        setCheckedId(-1);
    }

    public void setOnCheckedChangeListener(d listener) {
        this.k = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int checkedId) {
        q(checkedId, true);
    }

    public final void q(int checkedId, boolean fromUser) {
        this.n = checkedId;
        d dVar = this.k;
        if (dVar != null && this.i && fromUser) {
            dVar.a(this, checkedId);
        }
    }

    public final void r(int viewId, boolean checked) {
        View checkedView = findViewById(viewId);
        if (checkedView instanceof Chip) {
            this.o = true;
            ((Chip) checkedView).setChecked(checked);
            this.o = false;
        }
    }

    private int getChipCount() {
        int count = 0;
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof Chip) {
                count++;
            }
        }
        return count;
    }

    public int o(View child) {
        if (!(child instanceof Chip)) {
            return -1;
        }
        int index = 0;
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof Chip) {
                Chip chip = (Chip) getChildAt(i);
                if (chip == child) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public void setChipSpacing(int chipSpacing) {
        setChipSpacingHorizontal(chipSpacing);
        setChipSpacingVertical(chipSpacing);
    }

    public void setChipSpacingResource(int id) {
        setChipSpacing(getResources().getDimensionPixelOffset(id));
    }

    public int getChipSpacingHorizontal() {
        return this.g;
    }

    public void setChipSpacingHorizontal(int chipSpacingHorizontal) {
        if (this.g != chipSpacingHorizontal) {
            this.g = chipSpacingHorizontal;
            setItemSpacing(chipSpacingHorizontal);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int id) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(id));
    }

    public int getChipSpacingVertical() {
        return this.h;
    }

    public void setChipSpacingVertical(int chipSpacingVertical) {
        if (this.h != chipSpacingVertical) {
            this.h = chipSpacingVertical;
            setLineSpacing(chipSpacingVertical);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int id) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(id));
    }

    @Override // b.b.a.a.r.c
    public boolean c() {
        return super.c();
    }

    @Override // b.b.a.a.r.c
    public void setSingleLine(boolean singleLine) {
        super.setSingleLine(singleLine);
    }

    public void setSingleLine(int id) {
        setSingleLine(getResources().getBoolean(id));
    }

    public boolean p() {
        return this.i;
    }

    public void setSingleSelection(boolean singleSelection) {
        if (this.i != singleSelection) {
            this.i = singleSelection;
            n();
        }
    }

    public void setSingleSelection(int id) {
        setSingleSelection(getResources().getBoolean(id));
    }

    public void setSelectionRequired(boolean selectionRequired) {
        this.j = selectionRequired;
    }

    /* loaded from: classes.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (ChipGroup.this.o) {
                return;
            }
            List<Integer> checkedChipIds = ChipGroup.this.getCheckedChipIds();
            if (checkedChipIds.isEmpty() && ChipGroup.this.j) {
                ChipGroup.this.r(buttonView.getId(), true);
                ChipGroup.this.q(buttonView.getId(), false);
                return;
            }
            int id = buttonView.getId();
            if (!isChecked) {
                if (ChipGroup.this.n == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            } else {
                if (ChipGroup.this.n != -1 && ChipGroup.this.n != id && ChipGroup.this.i) {
                    ChipGroup chipGroup = ChipGroup.this;
                    chipGroup.r(chipGroup.n, false);
                }
                ChipGroup.this.setCheckedId(id);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public ViewGroup.OnHierarchyChangeListener f1177a;

        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View parent, View child) {
            if (parent == ChipGroup.this && (child instanceof Chip)) {
                int id = child.getId();
                if (id == -1) {
                    int id2 = v.k();
                    child.setId(id2);
                }
                Chip chip = (Chip) child;
                if (chip.isChecked()) {
                    ((ChipGroup) parent).m(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.l);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f1177a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(parent, child);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View parent, View child) {
            if (parent == ChipGroup.this && (child instanceof Chip)) {
                ((Chip) child).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f1177a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(parent, child);
            }
        }
    }
}
