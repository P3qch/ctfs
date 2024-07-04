package com.google.android.material.timepicker;

import a.h.k.e0.c;
import a.h.k.v;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import b.b.a.a.u.c;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class ClockFaceView extends b.b.a.a.c0.b implements ClockHandView.c {
    public final RectF A;
    public final SparseArray<TextView> B;
    public final a.h.k.a C;
    public final int[] D;
    public final float[] E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public String[] J;
    public float K;
    public final ColorStateList L;
    public final ClockHandView y;
    public final Rect z;

    public ClockFaceView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.z = new Rect();
        this.A = new RectF();
        this.B = new SparseArray<>();
        this.E = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray a2 = context.obtainStyledAttributes(attrs, b.b.a.a.a.e, defStyleAttr, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources res = getResources();
        int[] iArr = b.b.a.a.a.f942a;
        ColorStateList a3 = c.a(context, a2, 1);
        this.L = a3;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.y = clockHandView;
        this.F = res.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int clockHandTextColor = a3.getColorForState(new int[]{android.R.attr.state_selected}, a3.getDefaultColor());
        this.D = new int[]{clockHandTextColor, clockHandTextColor, a3.getDefaultColor()};
        clockHandView.b(this);
        int defaultBackgroundColor = a.b.c.a.a.c(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList backgroundColor = c.a(context, a2, 0);
        setBackgroundColor(backgroundColor == null ? defaultBackgroundColor : backgroundColor.getDefaultColor());
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        a2.recycle();
        this.C = new b();
        String[] initialValues = new String[12];
        Arrays.fill(initialValues, BuildConfig.FLAVOR);
        N(initialValues, 0);
        this.G = res.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.H = res.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.I = res.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            int circleRadius = ((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.y.g()) - ClockFaceView.this.F;
            ClockFaceView.this.D(circleRadius);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class b extends a.h.k.a {
        public b() {
        }

        @Override // a.h.k.a
        public void g(View host, a.h.k.e0.c info) {
            super.g(host, info);
            int index = ((Integer) host.getTag(R.id.material_value_index)).intValue();
            if (index > 0) {
                info.s0((View) ClockFaceView.this.B.get(index - 1));
            }
            info.Z(c.C0030c.a(0, 1, index, 1, false, host.isSelected()));
        }
    }

    public void N(String[] values, int contentDescription) {
        this.J = values;
        O(contentDescription);
    }

    public final void O(int contentDescription) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        int size = this.B.size();
        for (int i = 0; i < Math.max(this.J.length, size); i++) {
            TextView textView = this.B.get(i);
            if (i >= this.J.length) {
                removeView(textView);
                this.B.remove(i);
            } else {
                if (textView == null) {
                    textView = (TextView) inflater.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.B.put(i, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.J[i]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i));
                v.o0(textView, this.C);
                textView.setTextColor(this.L);
                if (contentDescription != 0) {
                    Resources res = getResources();
                    textView.setContentDescription(res.getString(contentDescription, this.J[i]));
                }
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        a.h.k.e0.c infoCompat = a.h.k.e0.c.v0(info);
        infoCompat.Y(c.b.a(1, this.J.length, false, 1));
    }

    @Override // b.b.a.a.c0.b
    public void D(int radius) {
        if (radius != C()) {
            super.D(radius);
            this.y.j(C());
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        K();
    }

    public final void K() {
        RectF selectorBox = this.y.d();
        for (int i = 0; i < this.B.size(); i++) {
            TextView tv = this.B.get(i);
            if (tv != null) {
                tv.getDrawingRect(this.z);
                this.z.offset(tv.getPaddingLeft(), tv.getPaddingTop());
                offsetDescendantRectToMyCoords(tv, this.z);
                this.A.set(this.z);
                RadialGradient radialGradient = L(selectorBox, this.A);
                tv.getPaint().setShader(radialGradient);
                tv.invalidate();
            }
        }
    }

    public final RadialGradient L(RectF selectorBox, RectF tvBox) {
        if (!RectF.intersects(selectorBox, tvBox)) {
            return null;
        }
        return new RadialGradient(selectorBox.centerX() - this.A.left, selectorBox.centerY() - this.A.top, 0.5f * selectorBox.width(), this.D, this.E, Shader.TileMode.CLAMP);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float rotation, boolean animating) {
        if (Math.abs(this.K - rotation) > 0.001f) {
            this.K = rotation;
            K();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Resources r = getResources();
        DisplayMetrics displayMetrics = r.getDisplayMetrics();
        float height = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;
        int size = (int) (this.I / M(this.G / height, this.H / width, 1.0f));
        int spec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        setMeasuredDimension(size, size);
        super.onMeasure(spec, spec);
    }

    public static float M(float a2, float b2, float c) {
        return Math.max(Math.max(a2, b2), c);
    }
}
