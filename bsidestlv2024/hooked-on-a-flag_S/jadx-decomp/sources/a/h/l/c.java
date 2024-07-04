package a.h.l;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static Field f496a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f497b;

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(CompoundButton compoundButton, ColorStateList tint) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(tint);
        } else if (compoundButton instanceof k) {
            ((k) compoundButton).setSupportButtonTintList(tint);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList b(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return compoundButton.getButtonTintList();
        }
        if (compoundButton instanceof k) {
            return ((k) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(CompoundButton compoundButton, PorterDuff.Mode tintMode) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(tintMode);
        } else if (compoundButton instanceof k) {
            ((k) compoundButton).setSupportButtonTintMode(tintMode);
        }
    }

    public static Drawable a(CompoundButton button) {
        if (Build.VERSION.SDK_INT >= 23) {
            return button.getButtonDrawable();
        }
        if (!f497b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f496a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            f497b = true;
        }
        Field field = f496a;
        if (field != null) {
            try {
                return (Drawable) field.get(button);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                f496a = null;
            }
        }
        return null;
    }
}
