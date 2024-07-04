package a.h.d.l;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static Method f375a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f376b;
    public static Method c;
    public static boolean d;

    @Deprecated
    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean mirrored) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(mirrored);
        }
    }

    public static boolean h(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    public static void k(Drawable drawable, float x, float y) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(x, y);
        }
    }

    public static void l(Drawable drawable, int left, int top, int right, int bottom) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(left, top, right, bottom);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void n(Drawable drawable, int tint) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(tint);
        } else if (drawable instanceof b) {
            ((b) drawable).setTint(tint);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void o(Drawable drawable, ColorStateList tint) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(tint);
        } else if (drawable instanceof b) {
            ((b) drawable).setTintList(tint);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void p(Drawable drawable, PorterDuff.Mode tintMode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(tintMode);
        } else if (drawable instanceof b) {
            ((b) drawable).setTintMode(tintMode);
        }
    }

    public static int d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public static ColorFilter e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            drawable.clearColorFilter();
            return;
        }
        if (i >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                c(((InsetDrawable) drawable).getDrawable());
                return;
            }
            if (drawable instanceof c) {
                c(((c) drawable).a());
                return;
            }
            if (drawable instanceof DrawableContainer) {
                DrawableContainer container = (DrawableContainer) drawable;
                DrawableContainer.DrawableContainerState state = (DrawableContainer.DrawableContainerState) container.getConstantState();
                if (state != null) {
                    int count = state.getChildCount();
                    for (int i2 = 0; i2 < count; i2++) {
                        Drawable child = state.getChild(i2);
                        if (child != null) {
                            c(child);
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        drawable.clearColorFilter();
    }

    public static void g(Drawable drawable, Resources res, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(res, parser, attrs, theme);
        } else {
            drawable.inflate(res, parser, attrs);
        }
    }

    public static Drawable r(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return drawable;
        }
        if (i >= 21) {
            if (!(drawable instanceof b)) {
                return new e(drawable);
            }
            return drawable;
        }
        if (!(drawable instanceof b)) {
            return new d(drawable);
        }
        return drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T q(Drawable drawable) {
        if (drawable instanceof c) {
            return (T) ((c) drawable).a();
        }
        return drawable;
    }

    public static boolean m(Drawable drawable, int layoutDirection) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return drawable.setLayoutDirection(layoutDirection);
        }
        if (i < 17) {
            return false;
        }
        if (!f376b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f375a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f376b = true;
        }
        Method method = f375a;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(layoutDirection));
                return true;
            } catch (Exception e2) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f375a = null;
            }
        }
        return false;
    }

    public static int f(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i < 17) {
            return 0;
        }
        if (!d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
            }
            d = true;
        }
        Method method = c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                c = null;
            }
        }
        return 0;
    }
}
