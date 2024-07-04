package androidx.appcompat.widget;

import a.b.a;
import a.b.g.a0;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class DialogTitle extends a0 {
    public DialogTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // a.b.g.a0, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int lineCount;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Layout layout = getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) > 0) {
            int ellipsisCount = layout.getEllipsisCount(lineCount - 1);
            if (ellipsisCount > 0) {
                setSingleLine(false);
                setMaxLines(2);
                TypedArray a2 = getContext().obtainStyledAttributes(null, a.v, R.attr.textAppearanceMedium, R.style.TextAppearance.Medium);
                int[] iArr = a.f11a;
                int textSize = a2.getDimensionPixelSize(0, 0);
                if (textSize != 0) {
                    setTextSize(0, textSize);
                }
                a2.recycle();
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
    }
}
