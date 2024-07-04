package a.s;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public class a0 extends z {
    public static boolean f = true;
    public static boolean g = true;

    @Override // a.s.e0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError e) {
                f = false;
            }
        }
    }

    @Override // a.s.e0
    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError e) {
                g = false;
            }
        }
    }
}
