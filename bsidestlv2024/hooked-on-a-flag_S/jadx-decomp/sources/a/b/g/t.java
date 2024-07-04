package a.b.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class t extends RatingBar {

    /* renamed from: b, reason: collision with root package name */
    public final r f193b;

    public t(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.ratingBarStyle);
    }

    public t(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        s0.a(this, getContext());
        r rVar = new r(this);
        this.f193b = rVar;
        rVar.c(attrs, defStyleAttr);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Bitmap sampleTile = this.f193b.b();
        if (sampleTile != null) {
            int width = sampleTile.getWidth() * getNumStars();
            setMeasuredDimension(View.resolveSizeAndState(width, widthMeasureSpec, 0), getMeasuredHeight());
        }
    }
}
