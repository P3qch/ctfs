package b.b.a.a.r;

import a.b.g.x0;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1075a = {R.attr.colorPrimary};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1076b = {R.attr.colorPrimaryVariant};

    public static TypedArray h(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, int... textAppearanceResIndices) {
        b(context, set, defStyleAttr, defStyleRes);
        d(context, set, attrs, defStyleAttr, defStyleRes, textAppearanceResIndices);
        return context.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
    }

    public static x0 i(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, int... textAppearanceResIndices) {
        b(context, set, defStyleAttr, defStyleRes);
        d(context, set, attrs, defStyleAttr, defStyleRes, textAppearanceResIndices);
        return x0.v(context, set, attrs, defStyleAttr, defStyleRes);
    }

    public static void b(Context context, AttributeSet set, int defStyleAttr, int defStyleRes) {
        TypedArray a2 = context.obtainStyledAttributes(set, b.b.a.a.a.C, defStyleAttr, defStyleRes);
        int[] iArr = b.b.a.a.a.f942a;
        boolean enforceMaterialTheme = a2.getBoolean(1, false);
        a2.recycle();
        if (enforceMaterialTheme) {
            TypedValue isMaterialTheme = new TypedValue();
            boolean resolvedValue = context.getTheme().resolveAttribute(R.attr.isMaterialTheme, isMaterialTheme, true);
            if (!resolvedValue || (isMaterialTheme.type == 18 && isMaterialTheme.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void d(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, int... textAppearanceResIndices) {
        TypedArray themeEnforcementAttrs = context.obtainStyledAttributes(set, b.b.a.a.a.C, defStyleAttr, defStyleRes);
        int[] iArr = b.b.a.a.a.f942a;
        boolean validTextAppearance = false;
        boolean enforceTextAppearance = themeEnforcementAttrs.getBoolean(2, false);
        if (!enforceTextAppearance) {
            themeEnforcementAttrs.recycle();
            return;
        }
        if (textAppearanceResIndices == null || textAppearanceResIndices.length == 0) {
            if (themeEnforcementAttrs.getResourceId(0, -1) != -1) {
                validTextAppearance = true;
            }
        } else {
            validTextAppearance = f(context, set, attrs, defStyleAttr, defStyleRes, textAppearanceResIndices);
        }
        themeEnforcementAttrs.recycle();
        if (!validTextAppearance) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static boolean f(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, int... textAppearanceResIndices) {
        TypedArray componentAttrs = context.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
        for (int customTextAppearanceIndex : textAppearanceResIndices) {
            if (componentAttrs.getResourceId(customTextAppearanceIndex, -1) == -1) {
                componentAttrs.recycle();
                return false;
            }
        }
        componentAttrs.recycle();
        return true;
    }

    public static void a(Context context) {
        e(context, f1075a, "Theme.AppCompat");
    }

    public static void c(Context context) {
        e(context, f1076b, "Theme.MaterialComponents");
    }

    public static boolean g(Context context, int[] themeAttributes) {
        TypedArray a2 = context.obtainStyledAttributes(themeAttributes);
        for (int i = 0; i < themeAttributes.length; i++) {
            if (!a2.hasValue(i)) {
                a2.recycle();
                return false;
            }
        }
        a2.recycle();
        return true;
    }

    public static void e(Context context, int[] themeAttributes, String themeName) {
        if (!g(context, themeAttributes)) {
            throw new IllegalArgumentException("The style on this component requires your app theme to be " + themeName + " (or a descendant).");
        }
    }
}
