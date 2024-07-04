package androidx.appcompat.widget;

import a.b.b.f;
import a.h.k.v;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public TypedValue f810b;
    public TypedValue c;
    public TypedValue d;
    public TypedValue e;
    public TypedValue f;
    public TypedValue g;
    public final Rect h;
    public a i;

    /* loaded from: classes.dex */
    public interface a {
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.h = new Rect();
    }

    public void a(Rect insets) {
        fitSystemWindows(insets);
    }

    public void setAttachListener(a attachListener) {
        this.i = attachListener;
    }

    public void b(int left, int top, int right, int bottom) {
        this.h.set(left, top, right, bottom);
        if (v.T(this)) {
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2;
        int i3;
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        boolean isPortrait = metrics.widthPixels < metrics.heightPixels;
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        boolean fixedWidth = false;
        if (widthMode == Integer.MIN_VALUE) {
            TypedValue tvw = isPortrait ? this.e : this.d;
            if (tvw != null && (i3 = tvw.type) != 0) {
                int w = 0;
                if (i3 == 5) {
                    w = (int) tvw.getDimension(metrics);
                } else if (i3 == 6) {
                    int i4 = metrics.widthPixels;
                    w = (int) tvw.getFraction(i4, i4);
                }
                if (w > 0) {
                    Rect rect = this.h;
                    int w2 = w - (rect.left + rect.right);
                    int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
                    widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(w2, widthSize), 1073741824);
                    fixedWidth = true;
                }
            }
        }
        if (heightMode == Integer.MIN_VALUE) {
            TypedValue tvh = isPortrait ? this.f : this.g;
            if (tvh != null && (i2 = tvh.type) != 0) {
                int h = 0;
                if (i2 == 5) {
                    h = (int) tvh.getDimension(metrics);
                } else if (i2 == 6) {
                    int i5 = metrics.heightPixels;
                    h = (int) tvh.getFraction(i5, i5);
                }
                if (h > 0) {
                    Rect rect2 = this.h;
                    int h2 = h - (rect2.top + rect2.bottom);
                    int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
                    heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(h2, heightSize), 1073741824);
                }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        boolean measure = false;
        int widthMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
        if (!fixedWidth && widthMode == Integer.MIN_VALUE) {
            TypedValue tv = isPortrait ? this.c : this.f810b;
            if (tv != null && (i = tv.type) != 0) {
                int min = 0;
                if (i == 5) {
                    min = (int) tv.getDimension(metrics);
                } else if (i == 6) {
                    int i6 = metrics.widthPixels;
                    min = (int) tv.getFraction(i6, i6);
                }
                if (min > 0) {
                    Rect rect3 = this.h;
                    min -= rect3.left + rect3.right;
                }
                if (width < min) {
                    widthMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
                    measure = true;
                }
            }
        }
        if (measure) {
            super.onMeasure(widthMeasureSpec2, heightMeasureSpec);
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.f810b == null) {
            this.f810b = new TypedValue();
        }
        return this.f810b;
    }

    public TypedValue getMinWidthMinor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.g == null) {
            this.g = new TypedValue();
        }
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.i;
        if (aVar != null) {
            ((f.e) aVar).a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.i;
        if (aVar != null) {
            ((f.e) aVar).b();
        }
    }
}
