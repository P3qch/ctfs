package a.s;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static Method f707a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f708b;
    public static Field c;
    public static boolean d;

    public void f(View view, float alpha) {
        Float savedAlpha = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (savedAlpha != null) {
            view.setAlpha(savedAlpha.floatValue() * alpha);
        } else {
            view.setAlpha(alpha);
        }
    }

    public float c(View view) {
        Float savedAlpha = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (savedAlpha != null) {
            return view.getAlpha() / savedAlpha.floatValue();
        }
        return view.getAlpha();
    }

    public void d(View view) {
        if (view.getTag(R.id.save_non_transition_alpha) == null) {
            view.setTag(R.id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, null);
        }
    }

    public void h(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View vp = (View) parent;
            h(vp, matrix);
            matrix.preTranslate(-vp.getScrollX(), -vp.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix vm = view.getMatrix();
        if (!vm.isIdentity()) {
            matrix.preConcat(vm);
        }
    }

    public void i(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View vp = (View) parent;
            i(vp, matrix);
            matrix.postTranslate(vp.getScrollX(), vp.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix vm = view.getMatrix();
        if (!vm.isIdentity()) {
            Matrix inverted = new Matrix();
            if (vm.invert(inverted)) {
                matrix.postConcat(inverted);
            }
        }
    }

    public void e(View v, int left, int top, int right, int bottom) {
        b();
        Method method = f707a;
        if (method != null) {
            try {
                method.invoke(v, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void g(View view, int visibility) {
        if (!d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            d = true;
        }
        Field field = c;
        if (field != null) {
            try {
                int viewFlags = field.getInt(view);
                c.setInt(view, (viewFlags & (-13)) | visibility);
            } catch (IllegalAccessException e2) {
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    public final void b() {
        if (!f708b) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                f707a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e);
            }
            f708b = true;
        }
    }
}
