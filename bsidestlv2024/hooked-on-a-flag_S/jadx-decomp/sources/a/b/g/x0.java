package a.b.g;

import a.h.c.c.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f209a;

    /* renamed from: b, reason: collision with root package name */
    public final TypedArray f210b;
    public TypedValue c;

    public static x0 u(Context context, AttributeSet set, int[] attrs) {
        return new x0(context, context.obtainStyledAttributes(set, attrs));
    }

    public static x0 v(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {
        return new x0(context, context.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes));
    }

    public static x0 t(Context context, int resid, int[] attrs) {
        return new x0(context, context.obtainStyledAttributes(resid, attrs));
    }

    public x0(Context context, TypedArray array) {
        this.f209a = context;
        this.f210b = array;
    }

    public TypedArray r() {
        return this.f210b;
    }

    public Drawable g(int index) {
        int resourceId;
        if (this.f210b.hasValue(index) && (resourceId = this.f210b.getResourceId(index, 0)) != 0) {
            return a.b.c.a.a.d(this.f209a, resourceId);
        }
        return this.f210b.getDrawable(index);
    }

    public Drawable h(int index) {
        int resourceId;
        if (this.f210b.hasValue(index) && (resourceId = this.f210b.getResourceId(index, 0)) != 0) {
            return j.b().d(this.f209a, resourceId, true);
        }
        return null;
    }

    public Typeface j(int index, int style, f.a fontCallback) {
        int resourceId = this.f210b.getResourceId(index, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return a.h.c.c.f.d(this.f209a, resourceId, this.c, style, fontCallback);
    }

    public CharSequence p(int index) {
        return this.f210b.getText(index);
    }

    public String o(int index) {
        return this.f210b.getString(index);
    }

    public boolean a(int index, boolean defValue) {
        return this.f210b.getBoolean(index, defValue);
    }

    public int k(int index, int defValue) {
        return this.f210b.getInt(index, defValue);
    }

    public float i(int index, float defValue) {
        return this.f210b.getFloat(index, defValue);
    }

    public int b(int index, int defValue) {
        return this.f210b.getColor(index, defValue);
    }

    public ColorStateList c(int index) {
        int resourceId;
        ColorStateList value;
        if (this.f210b.hasValue(index) && (resourceId = this.f210b.getResourceId(index, 0)) != 0 && (value = a.b.c.a.a.c(this.f209a, resourceId)) != null) {
            return value;
        }
        return this.f210b.getColorStateList(index);
    }

    public int l(int index, int defValue) {
        return this.f210b.getInteger(index, defValue);
    }

    public float d(int index, float defValue) {
        return this.f210b.getDimension(index, defValue);
    }

    public int e(int index, int defValue) {
        return this.f210b.getDimensionPixelOffset(index, defValue);
    }

    public int f(int index, int defValue) {
        return this.f210b.getDimensionPixelSize(index, defValue);
    }

    public int m(int index, int defValue) {
        return this.f210b.getLayoutDimension(index, defValue);
    }

    public int n(int index, int defValue) {
        return this.f210b.getResourceId(index, defValue);
    }

    public CharSequence[] q(int index) {
        return this.f210b.getTextArray(index);
    }

    public boolean s(int index) {
        return this.f210b.hasValue(index);
    }

    public void w() {
        this.f210b.recycle();
    }
}
