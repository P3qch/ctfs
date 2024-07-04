package a.s;

import android.annotation.SuppressLint;
import android.view.View;

/* loaded from: classes.dex */
public class b0 extends a0 {
    public static boolean h = true;

    @Override // a.s.e0
    @SuppressLint({"NewApi"})
    public void e(View v, int left, int top, int right, int bottom) {
        if (h) {
            try {
                v.setLeftTopRightBottom(left, top, right, bottom);
            } catch (NoSuchMethodError e) {
                h = false;
            }
        }
    }
}
