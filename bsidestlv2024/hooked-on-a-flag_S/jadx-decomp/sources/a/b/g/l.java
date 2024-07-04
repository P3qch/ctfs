package a.b.g;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* loaded from: classes.dex */
public class l {
    public static InputConnection a(InputConnection ic, EditorInfo outAttrs, View view) {
        if (ic != null && outAttrs.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                }
                if (parent instanceof f1) {
                    outAttrs.hintText = ((f1) parent).a();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return ic;
    }
}
