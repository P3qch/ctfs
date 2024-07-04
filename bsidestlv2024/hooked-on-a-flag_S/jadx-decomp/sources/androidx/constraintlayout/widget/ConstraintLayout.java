package androidx.constraintlayout.widget;

import a.f.a.k.d;
import a.f.a.k.e;
import a.f.a.k.f;
import a.f.a.k.m.b;
import a.f.c.c;
import a.f.c.d;
import a.f.c.g;
import a.f.c.i;
import a.f.c.j;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public static j f835b = null;
    public SparseArray<View> c;
    public ArrayList<a.f.c.b> d;
    public f e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public int k;
    public d l;
    public c m;
    public int n;
    public HashMap<String, Integer> o;
    public int p;
    public int q;
    public SparseArray<e> r;
    public b s;
    public int t;
    public int u;

    public static j getSharedValues() {
        if (f835b == null) {
            f835b = new j();
        }
        return f835b;
    }

    public void x(int type, Object value1, Object value2) {
        if (type == 0 && (value1 instanceof String) && (value2 instanceof Integer)) {
            if (this.o == null) {
                this.o = new HashMap<>();
            }
            String name = (String) value1;
            int index = name.indexOf("/");
            if (index != -1) {
                name = name.substring(index + 1);
            }
            int id = ((Integer) value2).intValue();
            this.o.put(name, Integer.valueOf(id));
        }
    }

    public Object g(int type, Object value) {
        if (type == 0 && (value instanceof String)) {
            String name = (String) value;
            HashMap<String, Integer> hashMap = this.o;
            if (hashMap != null && hashMap.containsKey(name)) {
                return this.o.get(name);
            }
            return null;
        }
        return null;
    }

    public ConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.c = new SparseArray<>();
        this.d = new ArrayList<>(4);
        this.e = new f();
        this.f = 0;
        this.g = 0;
        this.h = Integer.MAX_VALUE;
        this.i = Integer.MAX_VALUE;
        this.j = true;
        this.k = 257;
        this.l = null;
        this.m = null;
        this.n = -1;
        this.o = new HashMap<>();
        this.p = -1;
        this.q = -1;
        this.r = new SparseArray<>();
        this.s = new b(this);
        this.t = 0;
        this.u = 0;
        q(attrs, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.c = new SparseArray<>();
        this.d = new ArrayList<>(4);
        this.e = new f();
        this.f = 0;
        this.g = 0;
        this.h = Integer.MAX_VALUE;
        this.i = Integer.MAX_VALUE;
        this.j = true;
        this.k = 257;
        this.l = null;
        this.m = null;
        this.n = -1;
        this.o = new HashMap<>();
        this.p = -1;
        this.q = -1;
        this.r = new SparseArray<>();
        this.s = new b(this);
        this.t = 0;
        this.u = 0;
        q(attrs, defStyleAttr, 0);
    }

    @Override // android.view.View
    public void setId(int id) {
        this.c.remove(getId());
        super.setId(id);
        this.c.put(getId(), this);
    }

    /* loaded from: classes.dex */
    public class b implements b.InterfaceC0012b {

        /* renamed from: a, reason: collision with root package name */
        public ConstraintLayout f839a;

        /* renamed from: b, reason: collision with root package name */
        public int f840b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public void a(int widthSpec, int heightSpec, int top, int bottom, int width, int height) {
            this.f840b = top;
            this.c = bottom;
            this.d = width;
            this.e = height;
            this.f = widthSpec;
            this.g = heightSpec;
        }

        public b(ConstraintLayout l) {
            this.f839a = l;
        }

        /* JADX WARN: Removed duplicated region for block: B:122:0x01e8  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x01f7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:127:0x01f8  */
        /* JADX WARN: Removed duplicated region for block: B:200:0x01f2 A[ADDED_TO_REGION] */
        @android.annotation.SuppressLint({"WrongCall"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d(a.f.a.k.e r30, a.f.a.k.m.b.a r31) {
            /*
                Method dump skipped, instructions count: 836
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.d(a.f.a.k.e, a.f.a.k.m.b$a):void");
        }

        public final boolean c(int lastMeasureSpec, int spec, int widgetSize) {
            if (lastMeasureSpec == spec) {
                return true;
            }
            int lastMode = View.MeasureSpec.getMode(lastMeasureSpec);
            View.MeasureSpec.getSize(lastMeasureSpec);
            int mode = View.MeasureSpec.getMode(spec);
            int size = View.MeasureSpec.getSize(spec);
            if (mode != 1073741824) {
                return false;
            }
            if ((lastMode == Integer.MIN_VALUE || lastMode == 0) && widgetSize == size) {
                return true;
            }
            return false;
        }

        public final void b() {
            int widgetsCount = this.f839a.getChildCount();
            for (int i = 0; i < widgetsCount; i++) {
                View child = this.f839a.getChildAt(i);
                if (child instanceof g) {
                    ((g) child).a();
                }
            }
            int helperCount = this.f839a.d.size();
            if (helperCount > 0) {
                for (int i2 = 0; i2 < helperCount; i2++) {
                    a.f.c.b helper = (a.f.c.b) this.f839a.d.get(i2);
                    helper.o();
                }
            }
        }
    }

    public final void q(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.e.q0(this);
        this.e.K1(this.s);
        this.c.put(getId(), this);
        this.l = null;
        if (attrs != null) {
            TypedArray a2 = getContext().obtainStyledAttributes(attrs, i.f330b, defStyleAttr, defStyleRes);
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                int[] iArr = i.f329a;
                if (attr == 16) {
                    this.f = a2.getDimensionPixelOffset(attr, this.f);
                } else if (attr == 17) {
                    this.g = a2.getDimensionPixelOffset(attr, this.g);
                } else if (attr == 14) {
                    this.h = a2.getDimensionPixelOffset(attr, this.h);
                } else if (attr == 15) {
                    this.i = a2.getDimensionPixelOffset(attr, this.i);
                } else if (attr == 112) {
                    this.k = a2.getInt(attr, this.k);
                } else if (attr == 55) {
                    int id = a2.getResourceId(attr, 0);
                    if (id != 0) {
                        try {
                            t(id);
                        } catch (Resources.NotFoundException e) {
                            this.m = null;
                        }
                    }
                } else if (attr == 34) {
                    int id2 = a2.getResourceId(attr, 0);
                    try {
                        d dVar = new d();
                        this.l = dVar;
                        dVar.m(getContext(), id2);
                    } catch (Resources.NotFoundException e2) {
                        this.l = null;
                    }
                    this.n = id2;
                }
            }
            a2.recycle();
        }
        this.e.L1(this.k);
    }

    public void t(int id) {
        this.m = new c(getContext(), this, id);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        e widget = p(view);
        if ((view instanceof Guideline) && !(widget instanceof a.f.a.k.g)) {
            a layoutParams = (a) view.getLayoutParams();
            a.f.a.k.g gVar = new a.f.a.k.g();
            layoutParams.q0 = gVar;
            layoutParams.c0 = true;
            gVar.p1(layoutParams.U);
        }
        if (view instanceof a.f.c.b) {
            a.f.c.b helper = (a.f.c.b) view;
            helper.r();
            ((a) view.getLayoutParams()).d0 = true;
            if (!this.d.contains(helper)) {
                this.d.add(helper);
            }
        }
        this.c.put(view.getId(), view);
        this.j = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.c.remove(view.getId());
        e widget = p(view);
        this.e.j1(widget);
        this.d.remove(view);
        this.j = true;
    }

    public void setMinWidth(int value) {
        if (value == this.f) {
            return;
        }
        this.f = value;
        requestLayout();
    }

    public void setMinHeight(int value) {
        if (value == this.g) {
            return;
        }
        this.g = value;
        requestLayout();
    }

    public int getMinWidth() {
        return this.f;
    }

    public int getMinHeight() {
        return this.g;
    }

    public void setMaxWidth(int value) {
        if (value == this.h) {
            return;
        }
        this.h = value;
        requestLayout();
    }

    public void setMaxHeight(int value) {
        if (value == this.i) {
            return;
        }
        this.i = value;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.h;
    }

    public int getMaxHeight() {
        return this.i;
    }

    public final boolean A() {
        int count = getChildCount();
        boolean recompute = false;
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            }
            View child = getChildAt(i);
            if (!child.isLayoutRequested()) {
                i++;
            } else {
                recompute = true;
                break;
            }
        }
        if (recompute) {
            w();
        }
        return recompute;
    }

    public final void w() {
        boolean isInEditMode = isInEditMode();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            e widget = p(getChildAt(i));
            if (widget != null) {
                widget.m0();
            }
        }
        if (isInEditMode) {
            for (int i2 = 0; i2 < count; i2++) {
                View view = getChildAt(i2);
                try {
                    String IdAsString = getResources().getResourceName(view.getId());
                    x(0, IdAsString, Integer.valueOf(view.getId()));
                    int slashIndex = IdAsString.indexOf(47);
                    if (slashIndex != -1) {
                        IdAsString = IdAsString.substring(slashIndex + 1);
                    }
                    h(view.getId()).r0(IdAsString);
                } catch (Resources.NotFoundException e) {
                }
            }
        }
        int i3 = this.n;
        if (i3 != -1) {
            for (int i4 = 0; i4 < count; i4++) {
                View child = getChildAt(i4);
                if (child.getId() == this.n && (child instanceof a.f.c.e)) {
                    this.l = ((a.f.c.e) child).getConstraintSet();
                }
            }
        }
        d dVar = this.l;
        if (dVar != null) {
            dVar.d(this, true);
        }
        this.e.k1();
        int helperCount = this.d.size();
        if (helperCount > 0) {
            for (int i5 = 0; i5 < helperCount; i5++) {
                a.f.c.b helper = this.d.get(i5);
                helper.q(this);
            }
        }
        for (int i6 = 0; i6 < count; i6++) {
            View child2 = getChildAt(i6);
            if (child2 instanceof g) {
                ((g) child2).b(this);
            }
        }
        this.r.clear();
        this.r.put(0, this.e);
        this.r.put(getId(), this.e);
        for (int i7 = 0; i7 < count; i7++) {
            View child3 = getChildAt(i7);
            this.r.put(child3.getId(), p(child3));
        }
        for (int i8 = 0; i8 < count; i8++) {
            View child4 = getChildAt(i8);
            e widget2 = p(child4);
            if (widget2 != null) {
                a layoutParams = (a) child4.getLayoutParams();
                this.e.g1(widget2);
                d(isInEditMode, child4, widget2, layoutParams, this.r);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(boolean r21, android.view.View r22, a.f.a.k.e r23, androidx.constraintlayout.widget.ConstraintLayout.a r24, android.util.SparseArray<a.f.a.k.e> r25) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.d(boolean, android.view.View, a.f.a.k.e, androidx.constraintlayout.widget.ConstraintLayout$a, android.util.SparseArray):void");
    }

    public final void z(e widget, a layoutParams, SparseArray<e> sparseArray, int baselineTarget, d.a type) {
        View view = this.c.get(baselineTarget);
        e target = sparseArray.get(baselineTarget);
        if (target != null && view != null && (view.getLayoutParams() instanceof a)) {
            layoutParams.b0 = true;
            d.a aVar = d.a.BASELINE;
            if (type == aVar) {
                a targetParams = (a) view.getLayoutParams();
                targetParams.b0 = true;
                targetParams.q0.z0(true);
            }
            a.f.a.k.d baseline = widget.k(aVar);
            a.f.a.k.d targetAnchor = target.k(type);
            baseline.a(targetAnchor, layoutParams.C, layoutParams.B, true);
            widget.z0(true);
            widget.k(d.a.TOP).p();
            widget.k(d.a.BOTTOM).p();
        }
    }

    public final e h(int id) {
        if (id == 0) {
            return this.e;
        }
        View view = this.c.get(id);
        if (view == null && (view = findViewById(id)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.e;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).q0;
    }

    public final e p(View view) {
        if (view == this) {
            return this.e;
        }
        if (view != null) {
            if (view.getLayoutParams() instanceof a) {
                return ((a) view.getLayoutParams()).q0;
            }
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (view.getLayoutParams() instanceof a) {
                return ((a) view.getLayoutParams()).q0;
            }
            return null;
        }
        return null;
    }

    public void v(f layout, int optimizationLevel, int widthMeasureSpec, int heightMeasureSpec) {
        int paddingX;
        int paddingX2;
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int paddingY = Math.max(0, getPaddingTop());
        int paddingBottom = Math.max(0, getPaddingBottom());
        int paddingHeight = paddingY + paddingBottom;
        int paddingWidth = getPaddingWidth();
        this.s.a(widthMeasureSpec, heightMeasureSpec, paddingY, paddingBottom, paddingWidth, paddingHeight);
        if (Build.VERSION.SDK_INT >= 17) {
            int paddingStart = Math.max(0, getPaddingStart());
            int paddingEnd = Math.max(0, getPaddingEnd());
            if (paddingStart > 0 || paddingEnd > 0) {
                if (r()) {
                    paddingX2 = paddingEnd;
                } else {
                    paddingX2 = paddingStart;
                }
            } else {
                paddingX2 = Math.max(0, getPaddingLeft());
            }
            paddingX = paddingX2;
        } else {
            paddingX = Math.max(0, getPaddingLeft());
        }
        int widthSize2 = widthSize - paddingWidth;
        int heightSize2 = heightSize - paddingHeight;
        y(layout, widthMode, widthSize2, heightMode, heightSize2);
        layout.G1(optimizationLevel, widthMode, widthSize2, heightMode, heightSize2, this.p, this.q, paddingX, paddingY);
    }

    public void u(int widthMeasureSpec, int heightMeasureSpec, int measuredWidth, int measuredHeight, boolean isWidthMeasuredTooSmall, boolean isHeightMeasuredTooSmall) {
        b bVar = this.s;
        int heightPadding = bVar.e;
        int widthPadding = bVar.d;
        int androidLayoutWidth = measuredWidth + widthPadding;
        int androidLayoutHeight = measuredHeight + heightPadding;
        int resolvedWidthSize = ViewGroup.resolveSizeAndState(androidLayoutWidth, widthMeasureSpec, 0);
        int resolvedHeightSize = ViewGroup.resolveSizeAndState(androidLayoutHeight, heightMeasureSpec, 0 << 16);
        int resolvedWidthSize2 = Math.min(this.h, resolvedWidthSize & 16777215);
        int resolvedHeightSize2 = Math.min(this.i, resolvedHeightSize & 16777215);
        if (isWidthMeasuredTooSmall) {
            resolvedWidthSize2 |= 16777216;
        }
        if (isHeightMeasuredTooSmall) {
            resolvedHeightSize2 |= 16777216;
        }
        setMeasuredDimension(resolvedWidthSize2, resolvedHeightSize2);
        this.p = resolvedWidthSize2;
        this.q = resolvedHeightSize2;
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.t != widthMeasureSpec || this.u != heightMeasureSpec) {
        }
        if (!this.j && 0 == 0) {
            int count = getChildCount();
            int i = 0;
            while (true) {
                if (i >= count) {
                    break;
                }
                View child = getChildAt(i);
                if (!child.isLayoutRequested()) {
                    i++;
                } else {
                    this.j = true;
                    break;
                }
            }
        }
        if (!this.j && 0 != 0) {
            u(widthMeasureSpec, heightMeasureSpec, this.e.P(), this.e.t(), this.e.F1(), this.e.D1());
            return;
        }
        this.t = widthMeasureSpec;
        this.u = heightMeasureSpec;
        this.e.N1(r());
        if (this.j) {
            this.j = false;
            if (A()) {
                this.e.P1();
            }
        }
        v(this.e, this.k, widthMeasureSpec, heightMeasureSpec);
        u(widthMeasureSpec, heightMeasureSpec, this.e.P(), this.e.t(), this.e.F1(), this.e.D1());
    }

    public boolean r() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        boolean isRtlSupported = (getContext().getApplicationInfo().flags & 4194304) != 0;
        return isRtlSupported && 1 == getLayoutDirection();
    }

    private int getPaddingWidth() {
        int widthPadding = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int rtlPadding = 0;
        if (Build.VERSION.SDK_INT >= 17) {
            rtlPadding = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        }
        if (rtlPadding > 0) {
            int widthPadding2 = rtlPadding;
            return widthPadding2;
        }
        return widthPadding;
    }

    public void y(f layout, int widthMode, int widthSize, int heightMode, int heightSize) {
        b bVar = this.s;
        int heightPadding = bVar.e;
        int widthPadding = bVar.d;
        e.a widthBehaviour = e.a.FIXED;
        e.a heightBehaviour = e.a.FIXED;
        int desiredWidth = 0;
        int desiredHeight = 0;
        int childCount = getChildCount();
        switch (widthMode) {
            case Integer.MIN_VALUE:
                widthBehaviour = e.a.WRAP_CONTENT;
                desiredWidth = widthSize;
                if (childCount == 0) {
                    desiredWidth = Math.max(0, this.f);
                    break;
                }
                break;
            case 0:
                widthBehaviour = e.a.WRAP_CONTENT;
                if (childCount == 0) {
                    desiredWidth = Math.max(0, this.f);
                    break;
                }
                break;
            case 1073741824:
                desiredWidth = Math.min(this.h - widthPadding, widthSize);
                break;
        }
        switch (heightMode) {
            case Integer.MIN_VALUE:
                heightBehaviour = e.a.WRAP_CONTENT;
                desiredHeight = heightSize;
                if (childCount == 0) {
                    desiredHeight = Math.max(0, this.g);
                    break;
                }
                break;
            case 0:
                heightBehaviour = e.a.WRAP_CONTENT;
                if (childCount == 0) {
                    desiredHeight = Math.max(0, this.g);
                    break;
                }
                break;
            case 1073741824:
                desiredHeight = Math.min(this.i - heightPadding, heightSize);
                break;
        }
        if (desiredWidth != layout.P() || desiredHeight != layout.t()) {
            layout.C1();
        }
        layout.b1(0);
        layout.c1(0);
        layout.M0(this.h - widthPadding);
        layout.L0(this.i - heightPadding);
        layout.P0(0);
        layout.O0(0);
        layout.E0(widthBehaviour);
        layout.Z0(desiredWidth);
        layout.V0(heightBehaviour);
        layout.A0(desiredHeight);
        layout.P0(this.f - widthPadding);
        layout.O0(this.g - heightPadding);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int widgetsCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i = 0; i < widgetsCount; i++) {
            View child = getChildAt(i);
            a params = (a) child.getLayoutParams();
            e widget = params.q0;
            if ((child.getVisibility() != 8 || params.c0 || params.d0 || params.f0 || isInEditMode) && !params.e0) {
                int l = widget.Q();
                int t = widget.R();
                int r = widget.P() + l;
                int b2 = widget.t() + t;
                child.layout(l, t, r, b2);
                if (child instanceof g) {
                    g holder = (g) child;
                    View content = holder.getContent();
                    if (content != null) {
                        content.setVisibility(0);
                        content.layout(l, t, r, b2);
                    }
                }
            }
        }
        int helperCount = this.d.size();
        if (helperCount > 0) {
            for (int i2 = 0; i2 < helperCount; i2++) {
                a.f.c.b helper = this.d.get(i2);
                helper.n();
            }
        }
    }

    public void setOptimizationLevel(int level) {
        this.k = level;
        this.e.L1(level);
    }

    public int getOptimizationLevel() {
        return this.e.z1();
    }

    @Override // android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attrs) {
        return new a(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new a(p);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof a;
    }

    public void setConstraintSet(a.f.c.d set) {
        this.l = set;
    }

    public View j(int id) {
        return this.c.get(id);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float cw;
        float ch;
        float ow;
        int helperCount;
        ConstraintLayout constraintLayout = this;
        ArrayList<a.f.c.b> arrayList = constraintLayout.d;
        if (arrayList != null && (helperCount = arrayList.size()) > 0) {
            for (int i = 0; i < helperCount; i++) {
                a.f.c.b helper = constraintLayout.d.get(i);
                helper.p();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float cw2 = getWidth();
            float ch2 = getHeight();
            float ow2 = 1080.0f;
            int count = getChildCount();
            int i2 = 0;
            while (i2 < count) {
                View child = constraintLayout.getChildAt(i2);
                if (child.getVisibility() == 8) {
                    cw = cw2;
                    ch = ch2;
                    ow = ow2;
                } else {
                    Object tag = child.getTag();
                    if (tag == null || !(tag instanceof String)) {
                        cw = cw2;
                        ch = ch2;
                        ow = ow2;
                    } else {
                        String coordinates = (String) tag;
                        String[] split = coordinates.split(",");
                        if (split.length != 4) {
                            cw = cw2;
                            ch = ch2;
                            ow = ow2;
                        } else {
                            int x = (int) ((Integer.parseInt(split[0]) / ow2) * cw2);
                            int y = (int) ((Integer.parseInt(split[1]) / 1920.0f) * ch2);
                            int w = (int) ((Integer.parseInt(split[2]) / ow2) * cw2);
                            int h = (int) ((Integer.parseInt(split[3]) / 1920.0f) * ch2);
                            Paint paint = new Paint();
                            paint.setColor(-65536);
                            cw = cw2;
                            float cw3 = y;
                            ch = ch2;
                            ow = ow2;
                            float ow3 = y;
                            canvas.drawLine(x, cw3, x + w, ow3, paint);
                            canvas.drawLine(x + w, y, x + w, y + h, paint);
                            canvas.drawLine(x + w, y + h, x, y + h, paint);
                            canvas.drawLine(x, y + h, x, y, paint);
                            paint.setColor(-16711936);
                            canvas.drawLine(x, y, x + w, y + h, paint);
                            canvas.drawLine(x, y + h, x + w, y, paint);
                        }
                    }
                }
                i2++;
                constraintLayout = this;
                cw2 = cw;
                ch2 = ch;
                ow2 = ow;
            }
        }
    }

    public void setOnConstraintsChanged(a.f.c.f constraintsChangedListener) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.c(constraintsChangedListener);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public float D;
        public float E;
        public String F;
        public float G;
        public float H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public int U;
        public boolean V;
        public boolean W;
        public String X;
        public int Y;
        public boolean Z;

        /* renamed from: a, reason: collision with root package name */
        public int f836a;
        public boolean a0;

        /* renamed from: b, reason: collision with root package name */
        public int f837b;
        public boolean b0;
        public float c;
        public boolean c0;
        public int d;
        public boolean d0;
        public int e;
        public boolean e0;
        public int f;
        public boolean f0;
        public int g;
        public int g0;
        public int h;
        public int h0;
        public int i;
        public int i0;
        public int j;
        public int j0;
        public int k;
        public int k0;
        public int l;
        public int l0;
        public int m;
        public float m0;
        public int n;
        public int n0;
        public int o;
        public int o0;
        public int p;
        public float p0;
        public float q;
        public e q0;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public int z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0056a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f838a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f838a = sparseIntArray;
                int[] iArr = i.f329a;
                sparseIntArray.append(97, 64);
                sparseIntArray.append(74, 65);
                sparseIntArray.append(83, 8);
                sparseIntArray.append(84, 9);
                sparseIntArray.append(86, 10);
                sparseIntArray.append(87, 11);
                sparseIntArray.append(93, 12);
                sparseIntArray.append(92, 13);
                sparseIntArray.append(64, 14);
                sparseIntArray.append(63, 15);
                sparseIntArray.append(59, 16);
                sparseIntArray.append(61, 52);
                sparseIntArray.append(60, 53);
                sparseIntArray.append(65, 2);
                sparseIntArray.append(67, 3);
                sparseIntArray.append(66, 4);
                sparseIntArray.append(102, 49);
                sparseIntArray.append(103, 50);
                sparseIntArray.append(71, 5);
                sparseIntArray.append(72, 6);
                sparseIntArray.append(73, 7);
                sparseIntArray.append(0, 1);
                sparseIntArray.append(88, 17);
                sparseIntArray.append(89, 18);
                sparseIntArray.append(70, 19);
                sparseIntArray.append(69, 20);
                sparseIntArray.append(107, 21);
                sparseIntArray.append(110, 22);
                sparseIntArray.append(108, 23);
                sparseIntArray.append(105, 24);
                sparseIntArray.append(109, 25);
                sparseIntArray.append(106, 26);
                sparseIntArray.append(104, 55);
                sparseIntArray.append(111, 54);
                sparseIntArray.append(79, 29);
                sparseIntArray.append(94, 30);
                sparseIntArray.append(68, 44);
                sparseIntArray.append(81, 45);
                sparseIntArray.append(96, 46);
                sparseIntArray.append(80, 47);
                sparseIntArray.append(95, 48);
                sparseIntArray.append(57, 27);
                sparseIntArray.append(56, 28);
                sparseIntArray.append(98, 31);
                sparseIntArray.append(75, 32);
                sparseIntArray.append(100, 33);
                sparseIntArray.append(99, 34);
                sparseIntArray.append(101, 35);
                sparseIntArray.append(77, 36);
                sparseIntArray.append(76, 37);
                sparseIntArray.append(78, 38);
                sparseIntArray.append(82, 39);
                sparseIntArray.append(91, 40);
                sparseIntArray.append(85, 41);
                sparseIntArray.append(62, 42);
                sparseIntArray.append(58, 43);
                sparseIntArray.append(90, 51);
                sparseIntArray.append(113, 66);
            }
        }

        public a(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.f836a = -1;
            this.f837b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = 0;
            this.q = 0.0f;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = Integer.MIN_VALUE;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = 0;
            this.D = 0.5f;
            this.E = 0.5f;
            this.F = null;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 1.0f;
            this.R = 1.0f;
            this.S = -1;
            this.T = -1;
            this.U = -1;
            this.V = false;
            this.W = false;
            this.X = null;
            this.Y = 0;
            this.Z = true;
            this.a0 = true;
            this.b0 = false;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = Integer.MIN_VALUE;
            this.l0 = Integer.MIN_VALUE;
            this.m0 = 0.5f;
            this.q0 = new e();
            TypedArray a2 = c.obtainStyledAttributes(attrs, i.f330b);
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                int look = C0056a.f838a.get(attr);
                switch (look) {
                    case 1:
                        this.U = a2.getInt(attr, this.U);
                        break;
                    case 2:
                        int resourceId = a2.getResourceId(attr, this.o);
                        this.o = resourceId;
                        if (resourceId == -1) {
                            this.o = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.p = a2.getDimensionPixelSize(attr, this.p);
                        break;
                    case 4:
                        float f = a2.getFloat(attr, this.q) % 360.0f;
                        this.q = f;
                        if (f < 0.0f) {
                            this.q = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f836a = a2.getDimensionPixelOffset(attr, this.f836a);
                        break;
                    case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                        this.f837b = a2.getDimensionPixelOffset(attr, this.f837b);
                        break;
                    case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                        this.c = a2.getFloat(attr, this.c);
                        break;
                    case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                        int resourceId2 = a2.getResourceId(attr, this.d);
                        this.d = resourceId2;
                        if (resourceId2 == -1) {
                            this.d = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                        int resourceId3 = a2.getResourceId(attr, this.e);
                        this.e = resourceId3;
                        if (resourceId3 == -1) {
                            this.e = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                        int resourceId4 = a2.getResourceId(attr, this.f);
                        this.f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case IBulkCursor.RESPOND_TRANSACTION /* 11 */:
                        int resourceId5 = a2.getResourceId(attr, this.g);
                        this.g = resourceId5;
                        if (resourceId5 == -1) {
                            this.g = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case IBulkCursor.CLOSE_TRANSACTION /* 12 */:
                        int resourceId6 = a2.getResourceId(attr, this.h);
                        this.h = resourceId6;
                        if (resourceId6 == -1) {
                            this.h = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = a2.getResourceId(attr, this.i);
                        this.i = resourceId7;
                        if (resourceId7 == -1) {
                            this.i = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = a2.getResourceId(attr, this.j);
                        this.j = resourceId8;
                        if (resourceId8 == -1) {
                            this.j = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = a2.getResourceId(attr, this.k);
                        this.k = resourceId9;
                        if (resourceId9 == -1) {
                            this.k = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                        int resourceId10 = a2.getResourceId(attr, this.l);
                        this.l = resourceId10;
                        if (resourceId10 == -1) {
                            this.l = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = a2.getResourceId(attr, this.r);
                        this.r = resourceId11;
                        if (resourceId11 == -1) {
                            this.r = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = a2.getResourceId(attr, this.s);
                        this.s = resourceId12;
                        if (resourceId12 == -1) {
                            this.s = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = a2.getResourceId(attr, this.t);
                        this.t = resourceId13;
                        if (resourceId13 == -1) {
                            this.t = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = a2.getResourceId(attr, this.u);
                        this.u = resourceId14;
                        if (resourceId14 == -1) {
                            this.u = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.v = a2.getDimensionPixelSize(attr, this.v);
                        break;
                    case 22:
                        this.w = a2.getDimensionPixelSize(attr, this.w);
                        break;
                    case 23:
                        this.x = a2.getDimensionPixelSize(attr, this.x);
                        break;
                    case 24:
                        this.y = a2.getDimensionPixelSize(attr, this.y);
                        break;
                    case 25:
                        this.z = a2.getDimensionPixelSize(attr, this.z);
                        break;
                    case 26:
                        this.A = a2.getDimensionPixelSize(attr, this.A);
                        break;
                    case 27:
                        this.V = a2.getBoolean(attr, this.V);
                        break;
                    case 28:
                        this.W = a2.getBoolean(attr, this.W);
                        break;
                    case 29:
                        this.D = a2.getFloat(attr, this.D);
                        break;
                    case 30:
                        this.E = a2.getFloat(attr, this.E);
                        break;
                    case 31:
                        int i2 = a2.getInt(attr, 0);
                        this.K = i2;
                        if (i2 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i3 = a2.getInt(attr, 0);
                        this.L = i3;
                        if (i3 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.M = a2.getDimensionPixelSize(attr, this.M);
                            break;
                        } catch (Exception e) {
                            int value = a2.getInt(attr, this.M);
                            if (value == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.O = a2.getDimensionPixelSize(attr, this.O);
                            break;
                        } catch (Exception e2) {
                            int value2 = a2.getInt(attr, this.O);
                            if (value2 == -2) {
                                this.O = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.Q = Math.max(0.0f, a2.getFloat(attr, this.Q));
                        this.K = 2;
                        break;
                    case 36:
                        try {
                            this.N = a2.getDimensionPixelSize(attr, this.N);
                            break;
                        } catch (Exception e3) {
                            int value3 = a2.getInt(attr, this.N);
                            if (value3 == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.P = a2.getDimensionPixelSize(attr, this.P);
                            break;
                        } catch (Exception e4) {
                            int value4 = a2.getInt(attr, this.P);
                            if (value4 == -2) {
                                this.P = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.R = Math.max(0.0f, a2.getFloat(attr, this.R));
                        this.L = 2;
                        break;
                    case 44:
                        a.f.c.d.r(this, a2.getString(attr));
                        break;
                    case 45:
                        this.G = a2.getFloat(attr, this.G);
                        break;
                    case 46:
                        this.H = a2.getFloat(attr, this.H);
                        break;
                    case 47:
                        this.I = a2.getInt(attr, 0);
                        break;
                    case 48:
                        this.J = a2.getInt(attr, 0);
                        break;
                    case 49:
                        this.S = a2.getDimensionPixelOffset(attr, this.S);
                        break;
                    case 50:
                        this.T = a2.getDimensionPixelOffset(attr, this.T);
                        break;
                    case 51:
                        this.X = a2.getString(attr);
                        break;
                    case 52:
                        int resourceId15 = a2.getResourceId(attr, this.m);
                        this.m = resourceId15;
                        if (resourceId15 == -1) {
                            this.m = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        int resourceId16 = a2.getResourceId(attr, this.n);
                        this.n = resourceId16;
                        if (resourceId16 == -1) {
                            this.n = a2.getInt(attr, -1);
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        this.C = a2.getDimensionPixelSize(attr, this.C);
                        break;
                    case 55:
                        this.B = a2.getDimensionPixelSize(attr, this.B);
                        break;
                    case 64:
                        a.f.c.d.p(this, a2, attr, 0);
                        break;
                    case 65:
                        a.f.c.d.p(this, a2, attr, 1);
                        break;
                    case 66:
                        this.Y = a2.getInt(attr, this.Y);
                        break;
                }
            }
            a2.recycle();
            a();
        }

        public void a() {
            this.c0 = false;
            this.Z = true;
            this.a0 = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.V) {
                this.Z = false;
                if (this.K == 0) {
                    this.K = 1;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == -2 && this.W) {
                this.a0 = false;
                if (this.L == 0) {
                    this.L = 1;
                }
            }
            if (i == 0 || i == -1) {
                this.Z = false;
                if (i == 0 && this.K == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.V = true;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.a0 = false;
                if (i2 == 0 && this.L == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.W = true;
                }
            }
            if (this.c != -1.0f || this.f836a != -1 || this.f837b != -1) {
                this.c0 = true;
                this.Z = true;
                this.a0 = true;
                if (!(this.q0 instanceof a.f.a.k.g)) {
                    this.q0 = new a.f.a.k.g();
                }
                ((a.f.a.k.g) this.q0).p1(this.U);
            }
        }

        public a(int width, int height) {
            super(width, height);
            this.f836a = -1;
            this.f837b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = 0;
            this.q = 0.0f;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = Integer.MIN_VALUE;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = 0;
            this.D = 0.5f;
            this.E = 0.5f;
            this.F = null;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 1.0f;
            this.R = 1.0f;
            this.S = -1;
            this.T = -1;
            this.U = -1;
            this.V = false;
            this.W = false;
            this.X = null;
            this.Y = 0;
            this.Z = true;
            this.a0 = true;
            this.b0 = false;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = Integer.MIN_VALUE;
            this.l0 = Integer.MIN_VALUE;
            this.m0 = 0.5f;
            this.q0 = new e();
        }

        public a(ViewGroup.LayoutParams source) {
            super(source);
            this.f836a = -1;
            this.f837b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = 0;
            this.q = 0.0f;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = Integer.MIN_VALUE;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = 0;
            this.D = 0.5f;
            this.E = 0.5f;
            this.F = null;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 1.0f;
            this.R = 1.0f;
            this.S = -1;
            this.T = -1;
            this.U = -1;
            this.V = false;
            this.W = false;
            this.X = null;
            this.Y = 0;
            this.Z = true;
            this.a0 = true;
            this.b0 = false;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = Integer.MIN_VALUE;
            this.l0 = Integer.MIN_VALUE;
            this.m0 = 0.5f;
            this.q0 = new e();
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int layoutDirection) {
            int originalLeftMargin = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int originalRightMargin = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            boolean isRtl = false;
            if (Build.VERSION.SDK_INT >= 17) {
                super.resolveLayoutDirection(layoutDirection);
                isRtl = 1 == getLayoutDirection();
            }
            this.i0 = -1;
            this.j0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.k0 = -1;
            this.l0 = -1;
            this.k0 = this.v;
            this.l0 = this.x;
            float f = this.D;
            this.m0 = f;
            int i = this.f836a;
            this.n0 = i;
            int i2 = this.f837b;
            this.o0 = i2;
            float f2 = this.c;
            this.p0 = f2;
            if (isRtl) {
                boolean startEndDefined = false;
                int i3 = this.r;
                if (i3 != -1) {
                    this.i0 = i3;
                    startEndDefined = true;
                } else {
                    int i4 = this.s;
                    if (i4 != -1) {
                        this.j0 = i4;
                        startEndDefined = true;
                    }
                }
                int i5 = this.t;
                if (i5 != -1) {
                    this.h0 = i5;
                    startEndDefined = true;
                }
                int i6 = this.u;
                if (i6 != -1) {
                    this.g0 = i6;
                    startEndDefined = true;
                }
                int i7 = this.z;
                if (i7 != Integer.MIN_VALUE) {
                    this.l0 = i7;
                }
                int i8 = this.A;
                if (i8 != Integer.MIN_VALUE) {
                    this.k0 = i8;
                }
                if (startEndDefined) {
                    this.m0 = 1.0f - f;
                }
                if (this.c0 && this.U == 1) {
                    if (f2 != -1.0f) {
                        this.p0 = 1.0f - f2;
                        this.n0 = -1;
                        this.o0 = -1;
                    } else if (i != -1) {
                        this.o0 = i;
                        this.n0 = -1;
                        this.p0 = -1.0f;
                    } else if (i2 != -1) {
                        this.n0 = i2;
                        this.o0 = -1;
                        this.p0 = -1.0f;
                    }
                }
            } else {
                int i9 = this.r;
                if (i9 != -1) {
                    this.h0 = i9;
                }
                int i10 = this.s;
                if (i10 != -1) {
                    this.g0 = i10;
                }
                int i11 = this.t;
                if (i11 != -1) {
                    this.i0 = i11;
                }
                int i12 = this.u;
                if (i12 != -1) {
                    this.j0 = i12;
                }
                int i13 = this.z;
                if (i13 != Integer.MIN_VALUE) {
                    this.k0 = i13;
                }
                int i14 = this.A;
                if (i14 != Integer.MIN_VALUE) {
                    this.l0 = i14;
                }
            }
            if (this.t == -1 && this.u == -1 && this.s == -1 && this.r == -1) {
                int i15 = this.f;
                if (i15 != -1) {
                    this.i0 = i15;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && originalRightMargin > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = originalRightMargin;
                    }
                } else {
                    int i16 = this.g;
                    if (i16 != -1) {
                        this.j0 = i16;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && originalRightMargin > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = originalRightMargin;
                        }
                    }
                }
                int i17 = this.d;
                if (i17 != -1) {
                    this.g0 = i17;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && originalLeftMargin > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = originalLeftMargin;
                        return;
                    }
                    return;
                }
                int i18 = this.e;
                if (i18 != -1) {
                    this.h0 = i18;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && originalLeftMargin > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = originalLeftMargin;
                    }
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        s();
        super.requestLayout();
    }

    @Override // android.view.View
    public void forceLayout() {
        s();
        super.forceLayout();
    }

    public final void s() {
        this.j = true;
        this.p = -1;
        this.q = -1;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
