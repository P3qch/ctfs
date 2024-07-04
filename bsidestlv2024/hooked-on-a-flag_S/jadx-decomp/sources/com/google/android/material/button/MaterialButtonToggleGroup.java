package com.google.android.material.button;

import a.h.k.e0.c;
import a.h.k.h;
import a.h.k.v;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import b.b.a.a.r.j;
import b.b.a.a.r.l;
import b.b.a.a.x.k;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public static final String f1168b = MaterialButtonToggleGroup.class.getSimpleName();
    public static final int c = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    public final List<d> d;
    public final c e;
    public final f f;
    public final LinkedHashSet<e> g;
    public final Comparator<MaterialButton> h;
    public Integer[] i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes.dex */
    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    /* loaded from: classes.dex */
    public class a implements Comparator<MaterialButton> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton v1, MaterialButton v2) {
            int checked = Boolean.valueOf(v1.isChecked()).compareTo(Boolean.valueOf(v2.isChecked()));
            if (checked != 0) {
                return checked;
            }
            int stateful = Boolean.valueOf(v1.isPressed()).compareTo(Boolean.valueOf(v2.isPressed()));
            if (stateful != 0) {
                return stateful;
            }
            return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(v1)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(v2)));
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(b.b.a.a.b0.a.a.c(context, attrs, defStyleAttr, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), attrs, defStyleAttr);
        this.d = new ArrayList();
        a aVar = null;
        this.e = new c(this, aVar);
        this.f = new f(this, aVar);
        this.g = new LinkedHashSet<>();
        this.h = new a();
        this.j = false;
        Context context2 = getContext();
        TypedArray attributes = j.h(context2, attrs, b.b.a.a.a.m, defStyleAttr, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        int[] iArr = b.b.a.a.a.f942a;
        setSingleSelection(attributes.getBoolean(2, false));
        this.m = attributes.getResourceId(0, -1);
        this.l = attributes.getBoolean(1, false);
        setChildrenDrawingOrderEnabled(true);
        attributes.recycle();
        v.x0(this, 1);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.m;
        if (i != -1) {
            j(i, true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        v();
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (!(child instanceof MaterialButton)) {
            Log.e(f1168b, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(child, index, params);
        MaterialButton buttonChild = (MaterialButton) child;
        setGeneratedIdIfNeeded(buttonChild);
        setupButtonChild(buttonChild);
        if (buttonChild.isChecked()) {
            u(buttonChild.getId(), true);
            setCheckedId(buttonChild.getId());
        }
        k shapeAppearanceModel = buttonChild.getShapeAppearanceModel();
        this.d.add(new d(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        v.o0(buttonChild, new b());
    }

    /* loaded from: classes.dex */
    public class b extends a.h.k.a {
        public b() {
        }

        @Override // a.h.k.a
        public void g(View host, a.h.k.e0.c info) {
            super.g(host, info);
            info.Z(c.C0030c.a(0, 1, MaterialButtonToggleGroup.this.n(host), 1, false, ((MaterialButton) host).isChecked()));
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        if (child instanceof MaterialButton) {
            ((MaterialButton) child).h(this.e);
            ((MaterialButton) child).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(child);
        if (indexOfChild >= 0) {
            this.d.remove(indexOfChild);
        }
        w();
        h();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        w();
        h();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        a.h.k.e0.c infoCompat = a.h.k.e0.c.v0(info);
        infoCompat.Y(c.b.a(1, getVisibleButtonCount(), false, q() ? 1 : 2));
    }

    public void k() {
        this.j = true;
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton child = m(i);
            child.setChecked(false);
            l(child.getId(), false);
        }
        this.j = false;
        setCheckedId(-1);
    }

    public int getCheckedButtonId() {
        if (this.k) {
            return this.m;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        List<Integer> checkedIds = new ArrayList<>();
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton child = m(i);
            if (child.isChecked()) {
                checkedIds.add(Integer.valueOf(child.getId()));
            }
        }
        return checkedIds;
    }

    public void g(e listener) {
        this.g.add(listener);
    }

    public boolean q() {
        return this.k;
    }

    public void setSingleSelection(boolean singleSelection) {
        if (this.k != singleSelection) {
            this.k = singleSelection;
            k();
        }
    }

    public void setSelectionRequired(boolean selectionRequired) {
        this.l = selectionRequired;
    }

    public void setSingleSelection(int id) {
        setSingleSelection(getResources().getBoolean(id));
    }

    public final void s(int viewId, boolean checked) {
        View checkedView = findViewById(viewId);
        if (checkedView instanceof MaterialButton) {
            this.j = true;
            ((MaterialButton) checkedView).setChecked(checked);
            this.j = false;
        }
    }

    private void setCheckedId(int checkedId) {
        this.m = checkedId;
        l(checkedId, true);
    }

    public final void h() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton currentButton = m(i);
            MaterialButton previousButton = m(i - 1);
            int smallestStrokeWidth = Math.min(currentButton.getStrokeWidth(), previousButton.getStrokeWidth());
            LinearLayout.LayoutParams params = i(currentButton);
            if (getOrientation() == 0) {
                h.c(params, 0);
                h.d(params, -smallestStrokeWidth);
                params.topMargin = 0;
            } else {
                params.bottomMargin = 0;
                params.topMargin = -smallestStrokeWidth;
                h.d(params, 0);
            }
            currentButton.setLayoutParams(params);
        }
        r(firstVisibleChildIndex);
    }

    public final MaterialButton m(int index) {
        return (MaterialButton) getChildAt(index);
    }

    public final void r(int childIndex) {
        if (getChildCount() == 0 || childIndex == -1) {
            return;
        }
        MaterialButton currentButton = m(childIndex);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) currentButton.getLayoutParams();
        if (getOrientation() == 1) {
            params.topMargin = 0;
            params.bottomMargin = 0;
        } else {
            h.c(params, 0);
            h.d(params, 0);
            params.leftMargin = 0;
            params.rightMargin = 0;
        }
    }

    public void w() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton button = m(i);
            if (button.getVisibility() != 8) {
                k.b builder = button.getShapeAppearanceModel().v();
                d newCornerData = o(i, firstVisibleChildIndex, lastVisibleChildIndex);
                t(builder, newCornerData);
                button.setShapeAppearanceModel(builder.m());
            }
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (p(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            if (p(i)) {
                return i;
            }
        }
        return -1;
    }

    public final boolean p(int i) {
        View child = getChildAt(i);
        return child.getVisibility() != 8;
    }

    private int getVisibleButtonCount() {
        int count = 0;
        for (int i = 0; i < getChildCount(); i++) {
            if ((getChildAt(i) instanceof MaterialButton) && p(i)) {
                count++;
            }
        }
        return count;
    }

    public final int n(View child) {
        if (!(child instanceof MaterialButton)) {
            return -1;
        }
        int index = 0;
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) == child) {
                return index;
            }
            if ((getChildAt(i) instanceof MaterialButton) && p(i)) {
                index++;
            }
        }
        return -1;
    }

    public final d o(int index, int firstVisibleChildIndex, int lastVisibleChildIndex) {
        d cornerData = this.d.get(index);
        if (firstVisibleChildIndex == lastVisibleChildIndex) {
            return cornerData;
        }
        boolean isHorizontal = getOrientation() == 0;
        if (index == firstVisibleChildIndex) {
            return isHorizontal ? d.e(cornerData, this) : d.f(cornerData);
        }
        if (index == lastVisibleChildIndex) {
            return isHorizontal ? d.b(cornerData, this) : d.a(cornerData);
        }
        return null;
    }

    public static void t(k.b shapeAppearanceModelBuilder, d cornerData) {
        if (cornerData == null) {
            shapeAppearanceModelBuilder.o(0.0f);
            return;
        }
        shapeAppearanceModelBuilder.B(cornerData.f1172b);
        shapeAppearanceModelBuilder.t(cornerData.e);
        shapeAppearanceModelBuilder.F(cornerData.c);
        shapeAppearanceModelBuilder.x(cornerData.d);
    }

    public final boolean u(int childId, boolean childIsChecked) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.l && checkedButtonIds.isEmpty()) {
            s(childId, true);
            this.m = childId;
            return false;
        }
        if (childIsChecked && this.k) {
            checkedButtonIds.remove(Integer.valueOf(childId));
            Iterator<Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int buttonId = it.next().intValue();
                s(buttonId, false);
                l(buttonId, false);
            }
        }
        return true;
    }

    public final void l(int buttonId, boolean checked) {
        Iterator<e> it = this.g.iterator();
        while (it.hasNext()) {
            e listener = it.next();
            listener.a(this, buttonId, checked);
        }
    }

    public final void j(int checkedId, boolean checked) {
        MaterialButton button = (MaterialButton) findViewById(checkedId);
        if (button != null) {
            button.setChecked(checked);
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(v.k());
        }
    }

    private void setupButtonChild(MaterialButton buttonChild) {
        buttonChild.setMaxLines(1);
        buttonChild.setEllipsize(TextUtils.TruncateAt.END);
        buttonChild.setCheckable(true);
        buttonChild.a(this.e);
        buttonChild.setOnPressedChangeListenerInternal(this.f);
        buttonChild.setShouldDrawSurfaceColorStroke(true);
    }

    public final LinearLayout.LayoutParams i(View child) {
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int childCount, int i) {
        Integer[] numArr = this.i;
        if (numArr == null || i >= numArr.length) {
            Log.w(f1168b, "Child order wasn't updated");
            return i;
        }
        return numArr[i].intValue();
    }

    public final void v() {
        SortedMap<MaterialButton, Integer> viewToIndexMap = new TreeMap<>(this.h);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewToIndexMap.put(m(i), Integer.valueOf(i));
        }
        this.i = (Integer[]) viewToIndexMap.values().toArray(new Integer[0]);
    }

    /* loaded from: classes.dex */
    public class c implements MaterialButton.a {
        public c() {
        }

        public /* synthetic */ c(MaterialButtonToggleGroup x0, a x1) {
            this();
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton button, boolean isChecked) {
            if (!MaterialButtonToggleGroup.this.j) {
                if (MaterialButtonToggleGroup.this.k) {
                    MaterialButtonToggleGroup.this.m = isChecked ? button.getId() : -1;
                }
                boolean buttonCheckedStateChanged = MaterialButtonToggleGroup.this.u(button.getId(), isChecked);
                if (buttonCheckedStateChanged) {
                    MaterialButtonToggleGroup.this.l(button.getId(), button.isChecked());
                }
                MaterialButtonToggleGroup.this.invalidate();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements MaterialButton.b {
        public f() {
        }

        public /* synthetic */ f(MaterialButtonToggleGroup x0, a x1) {
            this();
        }

        public void a(MaterialButton button, boolean isPressed) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static final b.b.a.a.x.c f1171a = new b.b.a.a.x.a(0.0f);

        /* renamed from: b, reason: collision with root package name */
        public b.b.a.a.x.c f1172b;
        public b.b.a.a.x.c c;
        public b.b.a.a.x.c d;
        public b.b.a.a.x.c e;

        public d(b.b.a.a.x.c topLeft, b.b.a.a.x.c bottomLeft, b.b.a.a.x.c topRight, b.b.a.a.x.c bottomRight) {
            this.f1172b = topLeft;
            this.c = topRight;
            this.d = bottomRight;
            this.e = bottomLeft;
        }

        public static d e(d orig, View view) {
            return l.d(view) ? d(orig) : c(orig);
        }

        public static d b(d orig, View view) {
            return l.d(view) ? c(orig) : d(orig);
        }

        public static d c(d orig) {
            b.b.a.a.x.c cVar = orig.f1172b;
            b.b.a.a.x.c cVar2 = orig.e;
            b.b.a.a.x.c cVar3 = f1171a;
            return new d(cVar, cVar2, cVar3, cVar3);
        }

        public static d d(d orig) {
            b.b.a.a.x.c cVar = f1171a;
            return new d(cVar, cVar, orig.c, orig.d);
        }

        public static d f(d orig) {
            b.b.a.a.x.c cVar = orig.f1172b;
            b.b.a.a.x.c cVar2 = f1171a;
            return new d(cVar, cVar2, orig.c, cVar2);
        }

        public static d a(d orig) {
            b.b.a.a.x.c cVar = f1171a;
            return new d(cVar, orig.e, cVar, orig.d);
        }
    }
}
