package b.b.a.a.r;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Matrix> f1062a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<RectF> f1063b = new ThreadLocal<>();

    public static void c(ViewGroup parent, View descendant, Rect rect) {
        ThreadLocal<Matrix> threadLocal = f1062a;
        Matrix m = threadLocal.get();
        if (m == null) {
            m = new Matrix();
            threadLocal.set(m);
        } else {
            m.reset();
        }
        b(parent, descendant, m);
        ThreadLocal<RectF> threadLocal2 = f1063b;
        RectF rectF = threadLocal2.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal2.set(rectF);
        }
        rectF.set(rect);
        m.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public static void a(ViewGroup parent, View descendant, Rect out) {
        out.set(0, 0, descendant.getWidth(), descendant.getHeight());
        c(parent, descendant, out);
    }

    public static void b(ViewParent target, View view, Matrix m) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != target) {
            View vp = (View) parent;
            b(target, vp, m);
            m.preTranslate(-vp.getScrollX(), -vp.getScrollY());
        }
        m.preTranslate(view.getLeft(), view.getTop());
        if (!view.getMatrix().isIdentity()) {
            m.preConcat(view.getMatrix());
        }
    }
}
