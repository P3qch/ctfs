package a.b.g;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class a1 {
    public static void a(View view, CharSequence tooltipText) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(tooltipText);
        } else {
            b1.f(view, tooltipText);
        }
    }
}
