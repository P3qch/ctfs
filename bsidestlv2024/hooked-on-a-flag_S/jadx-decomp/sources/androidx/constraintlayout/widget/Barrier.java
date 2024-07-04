package androidx.constraintlayout.widget;

import a.f.a.k.a;
import a.f.a.k.e;
import a.f.c.b;
import a.f.c.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class Barrier extends b {
    public int k;
    public int l;
    public a m;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setVisibility(8);
    }

    public int getType() {
        return this.k;
    }

    public void setType(int type) {
        this.k = type;
    }

    public final void s(e widget, int type, boolean isRtl) {
        this.l = type;
        if (Build.VERSION.SDK_INT < 17) {
            int i = this.k;
            if (i == 5) {
                this.l = 0;
            } else if (i == 6) {
                this.l = 1;
            }
        } else if (isRtl) {
            int i2 = this.k;
            if (i2 == 5) {
                this.l = 1;
            } else if (i2 == 6) {
                this.l = 0;
            }
        } else {
            int i3 = this.k;
            if (i3 == 5) {
                this.l = 0;
            } else if (i3 == 6) {
                this.l = 1;
            }
        }
        if (widget instanceof a) {
            a barrier = (a) widget;
            barrier.r1(this.l);
        }
    }

    @Override // a.f.c.b
    public void m(e widget, boolean isRtl) {
        s(widget, this.k, isRtl);
    }

    @Override // a.f.c.b
    public void l(AttributeSet attrs) {
        super.l(attrs);
        this.m = new a();
        if (attrs != null) {
            TypedArray a2 = getContext().obtainStyledAttributes(attrs, i.f330b);
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                int[] iArr = i.f329a;
                if (attr == 26) {
                    setType(a2.getInt(attr, 0));
                } else if (attr == 25) {
                    this.m.q1(a2.getBoolean(attr, true));
                } else if (attr == 27) {
                    int margin = a2.getDimensionPixelSize(attr, 0);
                    this.m.s1(margin);
                }
            }
            a2.recycle();
        }
        this.e = this.m;
        r();
    }

    public void setAllowsGoneWidget(boolean supportGone) {
        this.m.q1(supportGone);
    }

    public boolean getAllowsGoneWidget() {
        return this.m.l1();
    }

    public void setDpMargin(int margin) {
        float density = getResources().getDisplayMetrics().density;
        int px = (int) ((margin * density) + 0.5f);
        this.m.s1(px);
    }

    public int getMargin() {
        return this.m.n1();
    }

    public void setMargin(int margin) {
        this.m.s1(margin);
    }
}
