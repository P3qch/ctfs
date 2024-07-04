package a.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: b, reason: collision with root package name */
    public int[] f306b;
    public int c;
    public Context d;
    public a.f.a.k.h e;
    public boolean f;
    public String g;
    public String h;
    public View[] i;
    public HashMap<Integer, String> j;

    public b(Context context) {
        super(context);
        this.f306b = new int[32];
        this.f = false;
        this.i = null;
        this.j = new HashMap<>();
        this.d = context;
        l(null);
    }

    public b(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f306b = new int[32];
        this.f = false;
        this.i = null;
        this.j = new HashMap<>();
        this.d = context;
        l(attrs);
    }

    public void l(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a2 = getContext().obtainStyledAttributes(attrs, i.f330b);
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                int[] iArr = i.f329a;
                if (attr == 35) {
                    String string = a2.getString(attr);
                    this.g = string;
                    setIds(string);
                } else if (attr == 36) {
                    String string2 = a2.getString(attr);
                    this.h = string2;
                    setReferenceTags(string2);
                }
            }
            a2.recycle();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.g;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.h;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f306b, this.c);
    }

    public void setReferencedIds(int[] ids) {
        this.g = null;
        this.c = 0;
        for (int i : ids) {
            d(i);
        }
    }

    public final void d(int id) {
        if (id == getId()) {
            return;
        }
        int i = this.c + 1;
        int[] iArr = this.f306b;
        if (i > iArr.length) {
            this.f306b = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f306b;
        int i2 = this.c;
        iArr2[i2] = id;
        this.c = i2 + 1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void r() {
        if (this.e == null) {
            return;
        }
        ViewGroup.LayoutParams params = getLayoutParams();
        if (params instanceof ConstraintLayout.a) {
            ConstraintLayout.a layoutParams = (ConstraintLayout.a) params;
            layoutParams.q0 = (a.f.a.k.e) this.e;
        }
    }

    public final void c(String idString) {
        if (idString == null || idString.length() == 0 || this.d == null) {
            return;
        }
        String idString2 = idString.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int rscId = j(idString2);
        if (rscId != 0) {
            this.j.put(Integer.valueOf(rscId), idString2);
            d(rscId);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + idString2 + "\"");
    }

    public final void e(String tagString) {
        if (tagString == null || tagString.length() == 0 || this.d == null) {
            return;
        }
        String tagString2 = tagString.trim();
        ConstraintLayout parent = null;
        if (getParent() instanceof ConstraintLayout) {
            parent = (ConstraintLayout) getParent();
        }
        if (parent == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View v = parent.getChildAt(i);
            ViewGroup.LayoutParams params = v.getLayoutParams();
            if (params instanceof ConstraintLayout.a) {
                ConstraintLayout.a lp = (ConstraintLayout.a) params;
                if (tagString2.equals(lp.X)) {
                    if (v.getId() == -1) {
                        Log.w("ConstraintHelper", "to use ConstraintTag view " + v.getClass().getSimpleName() + " must have an ID");
                    } else {
                        d(v.getId());
                    }
                }
            }
        }
    }

    public final int j(String referenceId) {
        ConstraintLayout parent = null;
        if (getParent() instanceof ConstraintLayout) {
            parent = (ConstraintLayout) getParent();
        }
        int rscId = 0;
        if (isInEditMode() && parent != null) {
            Object value = parent.g(0, referenceId);
            if (value instanceof Integer) {
                rscId = ((Integer) value).intValue();
            }
        }
        if (rscId == 0 && parent != null) {
            rscId = i(parent, referenceId);
        }
        if (rscId == 0) {
            try {
                Field field = h.class.getField(referenceId);
                rscId = field.getInt(null);
            } catch (Exception e) {
            }
        }
        if (rscId == 0) {
            return this.d.getResources().getIdentifier(referenceId, "id", this.d.getPackageName());
        }
        return rscId;
    }

    public final int i(ConstraintLayout container, String idString) {
        Resources resources;
        if (idString == null || container == null || (resources = this.d.getResources()) == null) {
            return 0;
        }
        int count = container.getChildCount();
        for (int j = 0; j < count; j++) {
            View child = container.getChildAt(j);
            if (child.getId() != -1) {
                String res = null;
                try {
                    res = resources.getResourceEntryName(child.getId());
                } catch (Resources.NotFoundException e) {
                }
                if (idString.equals(res)) {
                    return child.getId();
                }
            }
        }
        return 0;
    }

    public void setIds(String idList) {
        this.g = idList;
        if (idList == null) {
            return;
        }
        int begin = 0;
        this.c = 0;
        while (true) {
            int end = idList.indexOf(44, begin);
            if (end == -1) {
                c(idList.substring(begin));
                return;
            } else {
                c(idList.substring(begin, end));
                begin = end + 1;
            }
        }
    }

    public void setReferenceTags(String tagList) {
        this.h = tagList;
        if (tagList == null) {
            return;
        }
        int begin = 0;
        this.c = 0;
        while (true) {
            int end = tagList.indexOf(44, begin);
            if (end == -1) {
                e(tagList.substring(begin));
                return;
            } else {
                e(tagList.substring(begin, end));
                begin = end + 1;
            }
        }
    }

    public void g(ConstraintLayout container) {
        int visibility = getVisibility();
        float elevation = 0.0f;
        if (Build.VERSION.SDK_INT >= 21) {
            elevation = getElevation();
        }
        for (int i = 0; i < this.c; i++) {
            int id = this.f306b[i];
            View view = container.j(id);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    view.setTranslationZ(view.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void f() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            g((ConstraintLayout) parent);
        }
    }

    public void h(ConstraintLayout container) {
    }

    public void q(ConstraintLayout container) {
        String candidate;
        int foundId;
        if (isInEditMode()) {
            setIds(this.g);
        }
        a.f.a.k.h hVar = this.e;
        if (hVar == null) {
            return;
        }
        ((a.f.a.k.i) hVar).j1();
        for (int i = 0; i < this.c; i++) {
            int id = this.f306b[i];
            View view = container.j(id);
            if (view == null && (foundId = i(container, (candidate = this.j.get(Integer.valueOf(id))))) != 0) {
                this.f306b[i] = foundId;
                this.j.put(Integer.valueOf(foundId), candidate);
                view = container.j(foundId);
            }
            if (view != null) {
                ((a.f.a.k.i) this.e).g1(container.p(view));
            }
        }
        this.e.a(container.e);
    }

    public View[] k(ConstraintLayout layout) {
        View[] viewArr = this.i;
        if (viewArr == null || viewArr.length != this.c) {
            this.i = new View[this.c];
        }
        for (int i = 0; i < this.c; i++) {
            int id = this.f306b[i];
            this.i[i] = layout.j(id);
        }
        return this.i;
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
    }

    public void m(a.f.a.k.e widget, boolean isRtl) {
    }

    @Override // android.view.View
    public void setTag(int key, Object tag) {
        super.setTag(key, tag);
        if (tag == null && this.g == null) {
            d(key);
        }
    }
}
