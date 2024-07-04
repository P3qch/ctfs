package com.google.android.material.timepicker;

import a.h.k.v;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class TimePickerView extends ConstraintLayout {
    public final Chip v;
    public final Chip w;
    public final MaterialButtonToggleGroup x;
    public final View.OnClickListener y;

    /* loaded from: classes.dex */
    public interface e {
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    /* loaded from: classes.dex */
    public interface g {
    }

    public static /* synthetic */ g B(TimePickerView x0) {
        x0.getClass();
        return null;
    }

    public static /* synthetic */ f C(TimePickerView x0) {
        x0.getClass();
        return null;
    }

    public static /* synthetic */ e D(TimePickerView x0) {
        x0.getClass();
        return null;
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            TimePickerView.B(TimePickerView.this);
        }
    }

    public TimePickerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimePickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.y = new a();
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.x = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new b());
        this.v = (Chip) findViewById(R.id.material_minute_tv);
        this.w = (Chip) findViewById(R.id.material_hour_tv);
        F();
        E();
    }

    /* loaded from: classes.dex */
    public class b implements MaterialButtonToggleGroup.e {
        public b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
            if (checkedId == R.id.material_clock_period_pm_button) {
            }
            TimePickerView.C(TimePickerView.this);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void F() {
        GestureDetector gestureDetector = new GestureDetector(getContext(), new c());
        View.OnTouchListener onTouchListener = new d(this, gestureDetector);
        this.v.setOnTouchListener(onTouchListener);
        this.w.setOnTouchListener(onTouchListener);
    }

    /* loaded from: classes.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e) {
            boolean ret = super.onDoubleTap(e);
            TimePickerView.D(TimePickerView.this);
            return ret;
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GestureDetector f1206b;

        public d(TimePickerView this$0, GestureDetector gestureDetector) {
            this.f1206b = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent event) {
            if (((Checkable) view).isChecked()) {
                return this.f1206b.onTouchEvent(event);
            }
            return false;
        }
    }

    public final void E() {
        this.v.setTag(R.id.selection_type, 12);
        this.w.setTag(R.id.selection_type, 10);
        this.v.setOnClickListener(this.y);
        this.w.setOnClickListener(this.y);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (changedView == this && visibility == 0) {
            G();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        G();
    }

    public final void G() {
        if (this.x.getVisibility() == 0) {
            a.f.c.d constraintSet = new a.f.c.d();
            constraintSet.g(this);
            boolean isLtr = v.C(this) == 0;
            int sideToClear = isLtr ? 2 : 1;
            constraintSet.e(R.id.material_clock_display, sideToClear);
            constraintSet.c(this);
        }
    }
}
