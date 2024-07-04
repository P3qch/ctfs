package androidx.appcompat.widget;

import a.b.g.x0;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f808b = {R.attr.background};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        x0 a2 = x0.u(context, attrs, f808b);
        setBackgroundDrawable(a2.g(0));
        a2.w();
    }
}
