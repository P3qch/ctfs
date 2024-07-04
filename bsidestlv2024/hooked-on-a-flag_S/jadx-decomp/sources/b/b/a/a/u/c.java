package b.b.a.a.u;

import a.b.g.x0;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class c {
    public static ColorStateList a(Context context, TypedArray attributes, int index) {
        int resourceId;
        ColorStateList value;
        if (attributes.hasValue(index) && (resourceId = attributes.getResourceId(index, 0)) != 0 && (value = a.b.c.a.a.c(context, resourceId)) != null) {
            return value;
        }
        return attributes.getColorStateList(index);
    }

    public static ColorStateList b(Context context, x0 attributes, int index) {
        int resourceId;
        ColorStateList value;
        if (attributes.s(index) && (resourceId = attributes.n(index, 0)) != 0 && (value = a.b.c.a.a.c(context, resourceId)) != null) {
            return value;
        }
        return attributes.c(index);
    }

    public static Drawable d(Context context, TypedArray attributes, int index) {
        int resourceId;
        Drawable value;
        if (attributes.hasValue(index) && (resourceId = attributes.getResourceId(index, 0)) != 0 && (value = a.b.c.a.a.d(context, resourceId)) != null) {
            return value;
        }
        return attributes.getDrawable(index);
    }

    public static d f(Context context, TypedArray attributes, int index) {
        int resourceId;
        if (attributes.hasValue(index) && (resourceId = attributes.getResourceId(index, 0)) != 0) {
            return new d(context, resourceId);
        }
        return null;
    }

    public static int c(Context context, TypedArray attributes, int index, int defaultValue) {
        TypedValue value = new TypedValue();
        if (!attributes.getValue(index, value) || value.type != 2) {
            return attributes.getDimensionPixelSize(index, defaultValue);
        }
        TypedArray styledAttrs = context.getTheme().obtainStyledAttributes(new int[]{value.data});
        int dimension = styledAttrs.getDimensionPixelSize(0, defaultValue);
        styledAttrs.recycle();
        return dimension;
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean h(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    public static int e(TypedArray attributes, int a2, int b2) {
        if (attributes.hasValue(a2)) {
            return a2;
        }
        return b2;
    }
}
