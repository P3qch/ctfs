package a.b.g;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteDatabase;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f147a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f148b = new int[0];

    static {
        new Rect();
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    public static void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            c(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (!(drawable instanceof DrawableContainer)) {
            if (drawable instanceof a.h.d.l.c) {
                return a(((a.h.d.l.c) drawable).a());
            }
            if (drawable instanceof a.b.d.a.c) {
                return a(((a.b.d.a.c) drawable).a());
            }
            if (drawable instanceof ScaleDrawable) {
                return a(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
        Drawable.ConstantState state = drawable.getConstantState();
        if (state instanceof DrawableContainer.DrawableContainerState) {
            DrawableContainer.DrawableContainerState containerState = (DrawableContainer.DrawableContainerState) state;
            for (Drawable child : containerState.getChildren()) {
                if (!a(child)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static void c(Drawable drawable) {
        int[] originalState = drawable.getState();
        if (originalState == null || originalState.length == 0) {
            drawable.setState(f147a);
        } else {
            drawable.setState(f148b);
        }
        drawable.setState(originalState);
    }

    public static PorterDuff.Mode d(int value, PorterDuff.Mode defaultMode) {
        switch (value) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                return PorterDuff.Mode.ADD;
            default:
                return defaultMode;
        }
    }
}
