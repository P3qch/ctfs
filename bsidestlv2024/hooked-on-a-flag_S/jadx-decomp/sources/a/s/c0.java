package a.s;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class c0 extends b0 {
    public static boolean i = true;

    @Override // a.s.e0
    @SuppressLint({"NewApi"})
    public void g(View view, int visibility) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, visibility);
        } else if (i) {
            try {
                view.setTransitionVisibility(visibility);
            } catch (NoSuchMethodError e) {
                i = false;
            }
        }
    }
}
