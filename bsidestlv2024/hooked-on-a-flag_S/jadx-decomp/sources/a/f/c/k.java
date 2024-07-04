package a.f.c;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public abstract class k extends b {
    public boolean k;
    public boolean l;

    @Override // a.f.c.b
    public void l(AttributeSet attrs) {
        super.l(attrs);
        if (attrs != null) {
            TypedArray a2 = getContext().obtainStyledAttributes(attrs, i.f330b);
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                int[] iArr = i.f329a;
                if (attr == 6) {
                    this.k = true;
                } else if (attr == 22) {
                    this.l = true;
                }
            }
            a2.recycle();
        }
    }

    public void s() {
    }

    @Override // a.f.c.b, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.k || this.l) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout container = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = 0.0f;
                if (Build.VERSION.SDK_INT >= 21) {
                    elevation = getElevation();
                }
                for (int i = 0; i < this.c; i++) {
                    int id = this.f306b[i];
                    View view = container.j(id);
                    if (view != null) {
                        if (this.k) {
                            view.setVisibility(visibility);
                        }
                        if (this.l && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                            view.setTranslationZ(view.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        f();
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        f();
    }

    @Override // a.f.c.b
    public void h(ConstraintLayout container) {
        g(container);
    }
}
