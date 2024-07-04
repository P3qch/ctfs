package b.b.a.a.c0;

import a.f.c.d;
import a.h.k.v;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.b.a.a.x.g;
import b.b.a.a.x.i;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class b extends ConstraintLayout {
    public final Runnable v;
    public int w;
    public g x;

    public b(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public b(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        v.r0(this, B());
        TypedArray a2 = context.obtainStyledAttributes(attrs, b.b.a.a.a.v, defStyleAttr, 0);
        int[] iArr = b.b.a.a.a.f942a;
        this.w = a2.getDimensionPixelSize(0, 0);
        this.v = new a();
        a2.recycle();
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.F();
        }
    }

    public final Drawable B() {
        g gVar = new g();
        this.x = gVar;
        gVar.T(new i(0.5f));
        this.x.V(ColorStateList.valueOf(-1));
        return this.x;
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        this.x.V(ColorStateList.valueOf(color));
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if (child.getId() == -1) {
            child.setId(v.k());
        }
        G();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        G();
    }

    public final void G() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.v);
            handler.post(this.v);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        F();
    }

    public void F() {
        int skippedChildren = 1;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (E(getChildAt(i))) {
                skippedChildren++;
            }
        }
        d constraintSet = new d();
        constraintSet.g(this);
        float currentAngle = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getId() != R.id.circle_center && !E(childAt)) {
                constraintSet.i(childAt.getId(), R.id.circle_center, this.w, currentAngle);
                currentAngle += 360.0f / (childCount - skippedChildren);
            }
        }
        constraintSet.c(this);
    }

    public void D(int radius) {
        this.w = radius;
        F();
    }

    public int C() {
        return this.w;
    }

    public static boolean E(View child) {
        return "skip".equals(child.getTag());
    }
}
