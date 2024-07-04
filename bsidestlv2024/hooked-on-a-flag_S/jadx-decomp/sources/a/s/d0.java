package a.s;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public class d0 extends c0 {
    @Override // a.s.z, a.s.e0
    public void f(View view, float alpha) {
        view.setTransitionAlpha(alpha);
    }

    @Override // a.s.z, a.s.e0
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // a.s.c0, a.s.e0
    public void g(View view, int visibility) {
        view.setTransitionVisibility(visibility);
    }

    @Override // a.s.b0, a.s.e0
    public void e(View v, int left, int top, int right, int bottom) {
        v.setLeftTopRightBottom(left, top, right, bottom);
    }

    @Override // a.s.a0, a.s.e0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // a.s.a0, a.s.e0
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
