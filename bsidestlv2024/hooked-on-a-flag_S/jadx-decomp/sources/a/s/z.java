package a.s;

import android.annotation.SuppressLint;
import android.view.View;

/* loaded from: classes.dex */
public class z extends e0 {
    public static boolean e = true;

    @Override // a.s.e0
    @SuppressLint({"NewApi"})
    public void f(View view, float alpha) {
        if (e) {
            try {
                view.setTransitionAlpha(alpha);
                return;
            } catch (NoSuchMethodError e2) {
                e = false;
            }
        }
        view.setAlpha(alpha);
    }

    @Override // a.s.e0
    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError e2) {
                e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // a.s.e0
    public void d(View view) {
    }

    @Override // a.s.e0
    public void a(View view) {
    }
}
