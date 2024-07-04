package a.f.b.a;

import a.f.b.a.d;
import a.f.c.i;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class c extends a.f.c.b implements d.c {
    public boolean k;
    public boolean l;
    public float m;
    public View[] n;

    @Override // a.f.c.b
    public void l(AttributeSet attrs) {
        super.l(attrs);
        if (attrs != null) {
            TypedArray a2 = getContext().obtainStyledAttributes(attrs, i.h);
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                int[] iArr = i.f329a;
                if (attr == 1) {
                    this.k = a2.getBoolean(attr, this.k);
                } else if (attr == 0) {
                    this.l = a2.getBoolean(attr, this.l);
                }
            }
            a2.recycle();
        }
    }

    public boolean u() {
        return this.k;
    }

    public boolean t() {
        return this.l;
    }

    public float getProgress() {
        return this.m;
    }

    public void setProgress(float progress) {
        this.m = progress;
        if (this.c > 0) {
            this.n = k((ConstraintLayout) getParent());
            for (int i = 0; i < this.c; i++) {
                View view = this.n[i];
                v();
            }
            return;
        }
        ViewGroup group = (ViewGroup) getParent();
        int count = group.getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View view2 = group.getChildAt(i2);
            if (!(view2 instanceof c)) {
                v();
            }
        }
    }

    public void v() {
    }

    @Override // a.f.b.a.d.c
    public void a(d motionLayout, int startId, int endId) {
    }

    @Override // a.f.b.a.d.c
    public void b(d motionLayout, int startId, int endId, float progress) {
    }

    public boolean s() {
        return false;
    }
}
