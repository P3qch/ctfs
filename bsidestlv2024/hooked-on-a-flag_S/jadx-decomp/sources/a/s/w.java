package a.s;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public static LayoutTransition f740a;

    /* renamed from: b, reason: collision with root package name */
    public static Field f741b;
    public static boolean c;
    public static Method d;
    public static boolean e;

    public static void b(ViewGroup group, boolean suppress) {
        if (f740a == null) {
            a aVar = new a();
            f740a = aVar;
            aVar.setAnimator(2, null);
            f740a.setAnimator(0, null);
            f740a.setAnimator(1, null);
            f740a.setAnimator(3, null);
            f740a.setAnimator(4, null);
        }
        if (suppress) {
            LayoutTransition layoutTransition = group.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != f740a) {
                    group.setTag(R.id.transition_layout_save, layoutTransition);
                }
            }
            group.setLayoutTransition(f740a);
            return;
        }
        group.setLayoutTransition(null);
        if (!c) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f741b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }
            c = true;
        }
        boolean layoutSuppressed = false;
        Field field = f741b;
        if (field != null) {
            try {
                layoutSuppressed = field.getBoolean(group);
                if (layoutSuppressed) {
                    f741b.setBoolean(group, false);
                }
            } catch (IllegalAccessException e3) {
                Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
            }
        }
        if (layoutSuppressed) {
            group.requestLayout();
        }
        LayoutTransition layoutTransition2 = (LayoutTransition) group.getTag(R.id.transition_layout_save);
        if (layoutTransition2 != null) {
            group.setTag(R.id.transition_layout_save, null);
            group.setLayoutTransition(layoutTransition2);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends LayoutTransition {
        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    public static void a(LayoutTransition t) {
        if (!e) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            e = true;
        }
        Method method = d;
        if (method != null) {
            try {
                method.invoke(t, new Object[0]);
            } catch (IllegalAccessException e3) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException e4) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
