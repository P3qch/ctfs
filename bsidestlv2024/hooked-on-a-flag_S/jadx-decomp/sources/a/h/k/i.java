package a.h.k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;

/* loaded from: classes.dex */
public final class i {
    public static MenuItem a(MenuItem item, b provider) {
        if (item instanceof a.h.e.a.b) {
            return ((a.h.e.a.b) item).b(provider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return item;
    }

    public static void c(MenuItem item, CharSequence contentDescription) {
        if (item instanceof a.h.e.a.b) {
            ((a.h.e.a.b) item).setContentDescription(contentDescription);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setContentDescription(contentDescription);
        }
    }

    public static void g(MenuItem item, CharSequence tooltipText) {
        if (item instanceof a.h.e.a.b) {
            ((a.h.e.a.b) item).setTooltipText(tooltipText);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setTooltipText(tooltipText);
        }
    }

    public static void f(MenuItem item, char numericChar, int numericModifiers) {
        if (item instanceof a.h.e.a.b) {
            ((a.h.e.a.b) item).setNumericShortcut(numericChar, numericModifiers);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setNumericShortcut(numericChar, numericModifiers);
        }
    }

    public static void b(MenuItem item, char alphaChar, int alphaModifiers) {
        if (item instanceof a.h.e.a.b) {
            ((a.h.e.a.b) item).setAlphabeticShortcut(alphaChar, alphaModifiers);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setAlphabeticShortcut(alphaChar, alphaModifiers);
        }
    }

    public static void d(MenuItem item, ColorStateList tint) {
        if (item instanceof a.h.e.a.b) {
            ((a.h.e.a.b) item).setIconTintList(tint);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setIconTintList(tint);
        }
    }

    public static void e(MenuItem item, PorterDuff.Mode tintMode) {
        if (item instanceof a.h.e.a.b) {
            ((a.h.e.a.b) item).setIconTintMode(tintMode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setIconTintMode(tintMode);
        }
    }
}
