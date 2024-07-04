package a.f.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class e extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public d f327b;

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attrs) {
        return new a(getContext(), attrs);
    }

    /* loaded from: classes.dex */
    public static class a extends ConstraintLayout.a {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float r0;
        public boolean s0;
        public float t0;
        public float u0;
        public float v0;
        public float w0;
        public float x0;
        public float y0;
        public float z0;

        public a(int width, int height) {
            super(width, height);
            this.r0 = 1.0f;
            this.s0 = false;
            this.t0 = 0.0f;
            this.u0 = 0.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 1.0f;
            this.y0 = 1.0f;
            this.z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
        }

        public a(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.r0 = 1.0f;
            this.s0 = false;
            this.t0 = 0.0f;
            this.u0 = 0.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 1.0f;
            this.y0 = 1.0f;
            this.z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            TypedArray a2 = c.obtainStyledAttributes(attrs, i.d);
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                int[] iArr = i.f329a;
                if (attr == 15) {
                    this.r0 = a2.getFloat(attr, this.r0);
                } else if (attr == 28) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.t0 = a2.getFloat(attr, this.t0);
                        this.s0 = true;
                    }
                } else if (attr == 23) {
                    this.v0 = a2.getFloat(attr, this.v0);
                } else if (attr == 24) {
                    this.w0 = a2.getFloat(attr, this.w0);
                } else if (attr == 22) {
                    this.u0 = a2.getFloat(attr, this.u0);
                } else if (attr == 20) {
                    this.x0 = a2.getFloat(attr, this.x0);
                } else if (attr == 21) {
                    this.y0 = a2.getFloat(attr, this.y0);
                } else if (attr == 16) {
                    this.z0 = a2.getFloat(attr, this.z0);
                } else if (attr == 17) {
                    this.A0 = a2.getFloat(attr, this.A0);
                } else if (attr == 18) {
                    this.B0 = a2.getFloat(attr, this.B0);
                } else if (attr == 19) {
                    this.C0 = a2.getFloat(attr, this.C0);
                } else if (attr == 27 && Build.VERSION.SDK_INT >= 21) {
                    this.D0 = a2.getFloat(attr, this.D0);
                }
            }
            a2.recycle();
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new ConstraintLayout.a(p);
    }

    public d getConstraintSet() {
        if (this.f327b == null) {
            this.f327b = new d();
        }
        this.f327b.h(this);
        return this.f327b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
    }
}
