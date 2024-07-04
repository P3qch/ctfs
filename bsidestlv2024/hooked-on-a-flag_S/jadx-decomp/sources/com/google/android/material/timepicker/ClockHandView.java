package com.google.android.material.timepicker;

import a.h.k.v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class ClockHandView extends View {

    /* renamed from: b, reason: collision with root package name */
    public ValueAnimator f1201b;
    public float c;
    public float d;
    public boolean e;
    public int f;
    public final List<c> g;
    public final int h;
    public final float i;
    public final Paint j;
    public final RectF k;
    public final int l;
    public float m;
    public boolean n;
    public double o;
    public int p;

    /* loaded from: classes.dex */
    public interface c {
        void a(float f, boolean z);
    }

    public ClockHandView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.materialClockStyle);
    }

    public ClockHandView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.g = new ArrayList();
        Paint paint = new Paint();
        this.j = paint;
        this.k = new RectF();
        TypedArray a2 = context.obtainStyledAttributes(attrs, b.b.a.a.a.f, defStyleAttr, R.style.Widget_MaterialComponents_TimePicker_Clock);
        int[] iArr = b.b.a.a.a.f942a;
        this.p = a2.getDimensionPixelSize(1, 0);
        this.h = a2.getDimensionPixelSize(2, 0);
        Resources res = getResources();
        this.l = res.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.i = res.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int selectorColor = a2.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(selectorColor);
        k(0.0f);
        this.f = ViewConfiguration.get(context).getScaledTouchSlop();
        v.x0(this, 2);
        a2.recycle();
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        k(f());
    }

    public void k(float degrees) {
        l(degrees, false);
    }

    public void l(float degrees, boolean animate) {
        ValueAnimator valueAnimator = this.f1201b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!animate) {
            m(degrees, false);
            return;
        }
        Pair<Float, Float> animationValues = h(degrees);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) animationValues.first).floatValue(), ((Float) animationValues.second).floatValue());
        this.f1201b = ofFloat;
        ofFloat.setDuration(200L);
        this.f1201b.addUpdateListener(new a());
        this.f1201b.addListener(new b(this));
        this.f1201b.start();
    }

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            float animatedValue = ((Float) animation.getAnimatedValue()).floatValue();
            ClockHandView.this.m(animatedValue, true);
        }
    }

    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        public b(ClockHandView this$0) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            animation.end();
        }
    }

    public final Pair<Float, Float> h(float degrees) {
        float currentDegrees = f();
        if (Math.abs(currentDegrees - degrees) > 180.0f) {
            if (currentDegrees > 180.0f && degrees < 180.0f) {
                degrees += 360.0f;
            }
            if (currentDegrees < 180.0f && degrees > 180.0f) {
                currentDegrees += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(currentDegrees), Float.valueOf(degrees));
    }

    public final void m(float degrees, boolean animate) {
        float degrees2 = degrees % 360.0f;
        this.m = degrees2;
        float angDeg = degrees2 - 90.0f;
        this.o = Math.toRadians(angDeg);
        int yCenter = getHeight() / 2;
        int xCenter = getWidth() / 2;
        float selCenterX = xCenter + (this.p * ((float) Math.cos(this.o)));
        float selCenterY = yCenter + (this.p * ((float) Math.sin(this.o)));
        RectF rectF = this.k;
        int i = this.h;
        rectF.set(selCenterX - i, selCenterY - i, i + selCenterX, i + selCenterY);
        for (c listener : this.g) {
            listener.a(degrees2, animate);
        }
        invalidate();
    }

    public void b(c listener) {
        this.g.add(listener);
    }

    public float f() {
        return this.m;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    public final void c(Canvas canvas) {
        int yCenter = getHeight() / 2;
        int xCenter = getWidth() / 2;
        float selCenterX = xCenter + (this.p * ((float) Math.cos(this.o)));
        float selCenterY = yCenter + (this.p * ((float) Math.sin(this.o)));
        this.j.setStrokeWidth(0.0f);
        canvas.drawCircle(selCenterX, selCenterY, this.h, this.j);
        double sin = Math.sin(this.o);
        double cos = Math.cos(this.o);
        float lineLength = this.p - this.h;
        double d = lineLength;
        Double.isNaN(d);
        float linePointX = ((int) (d * cos)) + xCenter;
        double d2 = lineLength;
        Double.isNaN(d2);
        float linePointY = ((int) (d2 * sin)) + yCenter;
        this.j.setStrokeWidth(this.l);
        canvas.drawLine(xCenter, yCenter, linePointX, linePointY, this.j);
        canvas.drawCircle(xCenter, yCenter, this.i, this.j);
    }

    public RectF d() {
        return this.k;
    }

    public int g() {
        return this.h;
    }

    public void j(int circleRadius) {
        this.p = circleRadius;
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        boolean forceSelection = false;
        boolean actionDown = false;
        boolean actionUp = false;
        float x = event.getX();
        float y = event.getY();
        switch (action) {
            case 0:
                this.c = x;
                this.d = y;
                this.e = true;
                this.n = false;
                actionDown = true;
                break;
            case 1:
            case 2:
                int deltaX = (int) (x - this.c);
                int deltaY = (int) (y - this.d);
                int distance = (deltaX * deltaX) + (deltaY * deltaY);
                this.e = distance > this.f;
                if (this.n) {
                    forceSelection = true;
                }
                actionUp = action == 1;
                break;
        }
        boolean i = i(x, y, forceSelection, actionDown, actionUp) | this.n;
        this.n = i;
        if (!i || actionUp) {
        }
        return true;
    }

    public final boolean i(float x, float y, boolean forceSelection, boolean touchDown, boolean actionUp) {
        int degrees = e(x, y);
        boolean valueChanged = f() != ((float) degrees);
        if (touchDown && valueChanged) {
            return true;
        }
        if (!valueChanged && !forceSelection) {
            return false;
        }
        float f = degrees;
        if (actionUp) {
        }
        l(f, false);
        return true;
    }

    public final int e(float x, float y) {
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        double dX = x - xCenter;
        double dY = y - yCenter;
        int degrees = ((int) Math.toDegrees(Math.atan2(dY, dX))) + 90;
        if (degrees < 0) {
            return degrees + 360;
        }
        return degrees;
    }
}
