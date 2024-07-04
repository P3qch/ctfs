package b.b.a.a.r;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public class k {
    public static TextView c(Toolbar toolbar) {
        return b(toolbar, toolbar.getTitle());
    }

    public static TextView a(Toolbar toolbar) {
        return b(toolbar, toolbar.getSubtitle());
    }

    public static TextView b(Toolbar toolbar, CharSequence text) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View child = toolbar.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                if (TextUtils.equals(textView.getText(), text)) {
                    return textView;
                }
            }
        }
        return null;
    }
}
