package b.b.a.a.a0;

import a.h.k.v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import b.b.a.a.x.k;
import com.google.android.material.textfield.TextInputLayout;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class d extends b.b.a.a.a0.e {
    public static final boolean d;
    public final TextWatcher e;
    public final View.OnFocusChangeListener f;
    public final TextInputLayout.e g;
    public final TextInputLayout.f h;

    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.g i;
    public boolean j;
    public boolean k;
    public long l;
    public StateListDrawable m;
    public b.b.a.a.x.g n;
    public AccessibilityManager o;
    public ValueAnimator p;
    public ValueAnimator q;

    static {
        d = Build.VERSION.SDK_INT >= 21;
    }

    /* loaded from: classes.dex */
    public class a extends b.b.a.a.r.i {
        public a() {
        }

        @Override // b.b.a.a.r.i, android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            AutoCompleteTextView editText = d.y(d.this.f965a.getEditText());
            if (d.this.o.isTouchExplorationEnabled() && d.D(editText) && !d.this.c.hasFocus()) {
                editText.dismissDropDown();
            }
            editText.post(new RunnableC0060a(editText));
        }

        /* renamed from: b.b.a.a.a0.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0060a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AutoCompleteTextView f955b;

            public RunnableC0060a(AutoCompleteTextView autoCompleteTextView) {
                this.f955b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f955b.isPopupShowing();
                d.this.E(isPopupShowing);
                d.this.j = isPopupShowing;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View v, boolean hasFocus) {
            d.this.f965a.setEndIconActivated(hasFocus);
            if (!hasFocus) {
                d.this.E(false);
                d.this.j = false;
            }
        }
    }

    /* renamed from: b.b.a.a.a0.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0061d extends TextInputLayout.e {
        public C0061d(TextInputLayout layout) {
            super(layout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, a.h.k.a
        public void g(View host, a.h.k.e0.c info) {
            super.g(host, info);
            if (!d.D(d.this.f965a.getEditText())) {
                info.W(Spinner.class.getName());
            }
            if (info.J()) {
                info.g0(null);
            }
        }

        @Override // a.h.k.a
        public void h(View host, AccessibilityEvent event) {
            super.h(host, event);
            AutoCompleteTextView editText = d.y(d.this.f965a.getEditText());
            if (event.getEventType() == 1 && d.this.o.isTouchExplorationEnabled() && !d.D(d.this.f965a.getEditText())) {
                d.this.H(editText);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements TextInputLayout.f {
        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextView = d.y(textInputLayout.getEditText());
            d.this.F(autoCompleteTextView);
            d.this.v(autoCompleteTextView);
            d.this.G(autoCompleteTextView);
            autoCompleteTextView.setThreshold(0);
            autoCompleteTextView.removeTextChangedListener(d.this.e);
            autoCompleteTextView.addTextChangedListener(d.this.e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.D(autoCompleteTextView)) {
                v.x0(d.this.c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.g);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* loaded from: classes.dex */
    public class f implements TextInputLayout.g {
        public f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int previousIcon) {
            AutoCompleteTextView editText = (AutoCompleteTextView) textInputLayout.getEditText();
            if (editText != null && previousIcon == 3) {
                editText.post(new a(editText));
                if (editText.getOnFocusChangeListener() == d.this.f) {
                    editText.setOnFocusChangeListener(null);
                }
                editText.setOnTouchListener(null);
                if (d.d) {
                    editText.setOnDismissListener(null);
                }
            }
        }

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AutoCompleteTextView f960b;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.f960b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f960b.removeTextChangedListener(d.this.e);
            }
        }
    }

    public d(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.e = new a();
        this.f = new c();
        this.g = new C0061d(this.f965a);
        this.h = new e();
        this.i = new f();
        this.j = false;
        this.k = false;
        this.l = Long.MAX_VALUE;
    }

    @Override // b.b.a.a.a0.e
    public void a() {
        float popupCornerRadius = this.f966b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float exposedDropdownPopupElevation = this.f966b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int exposedDropdownPopupVerticalPadding = this.f966b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        b.b.a.a.x.g roundedCornersPopupBackground = A(popupCornerRadius, popupCornerRadius, exposedDropdownPopupElevation, exposedDropdownPopupVerticalPadding);
        b.b.a.a.x.g roundedBottomCornersPopupBackground = A(0.0f, popupCornerRadius, exposedDropdownPopupElevation, exposedDropdownPopupVerticalPadding);
        this.n = roundedCornersPopupBackground;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.m = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, roundedCornersPopupBackground);
        this.m.addState(new int[0], roundedBottomCornersPopupBackground);
        int drawableResId = d ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down;
        this.f965a.setEndIconDrawable(a.b.c.a.a.d(this.f966b, drawableResId));
        TextInputLayout textInputLayout = this.f965a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.f965a.setEndIconOnClickListener(new g());
        this.f965a.e(this.h);
        this.f965a.f(this.i);
        B();
        this.o = (AccessibilityManager) this.f966b.getSystemService("accessibility");
    }

    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            AutoCompleteTextView editText = (AutoCompleteTextView) d.this.f965a.getEditText();
            d.this.H(editText);
        }
    }

    @Override // b.b.a.a.a0.e
    public boolean d() {
        return true;
    }

    @Override // b.b.a.a.a0.e
    public boolean b(int boxBackgroundMode) {
        return boxBackgroundMode != 0;
    }

    public final void H(AutoCompleteTextView editText) {
        if (editText == null) {
            return;
        }
        if (C()) {
            this.j = false;
        }
        if (!this.j) {
            if (d) {
                E(!this.k);
            } else {
                this.k = !this.k;
                this.c.toggle();
            }
            if (this.k) {
                editText.requestFocus();
                editText.showDropDown();
                return;
            } else {
                editText.dismissDropDown();
                return;
            }
        }
        this.j = false;
    }

    public final void F(AutoCompleteTextView editText) {
        if (d) {
            int boxBackgroundMode = this.f965a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                editText.setDropDownBackgroundDrawable(this.n);
            } else if (boxBackgroundMode == 1) {
                editText.setDropDownBackgroundDrawable(this.m);
            }
        }
    }

    public final void v(AutoCompleteTextView editText) {
        if (D(editText)) {
            return;
        }
        int boxBackgroundMode = this.f965a.getBoxBackgroundMode();
        b.b.a.a.x.g boxBackground = this.f965a.getBoxBackground();
        int rippleColor = b.b.a.a.k.a.c(editText, R.attr.colorControlHighlight);
        int[][] states = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            x(editText, rippleColor, states, boxBackground);
        } else if (boxBackgroundMode == 1) {
            w(editText, rippleColor, states, boxBackground);
        }
    }

    public final void x(AutoCompleteTextView editText, int rippleColor, int[][] states, b.b.a.a.x.g boxBackground) {
        LayerDrawable editTextBackground;
        int surfaceColor = b.b.a.a.k.a.c(editText, R.attr.colorSurface);
        b.b.a.a.x.g rippleBackground = new b.b.a.a.x.g(boxBackground.B());
        int pressedBackgroundColor = b.b.a.a.k.a.f(rippleColor, surfaceColor, 0.1f);
        int[] rippleBackgroundColors = {pressedBackgroundColor, 0};
        rippleBackground.V(new ColorStateList(states, rippleBackgroundColors));
        if (d) {
            rippleBackground.setTint(surfaceColor);
            int[] colors = {pressedBackgroundColor, surfaceColor};
            ColorStateList rippleColorStateList = new ColorStateList(states, colors);
            b.b.a.a.x.g mask = new b.b.a.a.x.g(boxBackground.B());
            mask.setTint(-1);
            Drawable rippleDrawable = new RippleDrawable(rippleColorStateList, rippleBackground, mask);
            Drawable[] layers = {rippleDrawable, boxBackground};
            editTextBackground = new LayerDrawable(layers);
        } else {
            Drawable[] layers2 = {rippleBackground, boxBackground};
            editTextBackground = new LayerDrawable(layers2);
        }
        v.r0(editText, editTextBackground);
    }

    public final void w(AutoCompleteTextView editText, int rippleColor, int[][] states, b.b.a.a.x.g boxBackground) {
        int boxBackgroundColor = this.f965a.getBoxBackgroundColor();
        int pressedBackgroundColor = b.b.a.a.k.a.f(rippleColor, boxBackgroundColor, 0.1f);
        int[] colors = {pressedBackgroundColor, boxBackgroundColor};
        if (d) {
            ColorStateList rippleColorStateList = new ColorStateList(states, colors);
            Drawable editTextBackground = new RippleDrawable(rippleColorStateList, boxBackground, boxBackground);
            v.r0(editText, editTextBackground);
            return;
        }
        b.b.a.a.x.g rippleBackground = new b.b.a.a.x.g(boxBackground.B());
        rippleBackground.V(new ColorStateList(states, colors));
        Drawable[] layers = {boxBackground, rippleBackground};
        LayerDrawable editTextBackground2 = new LayerDrawable(layers);
        int start = v.I(editText);
        int top = editText.getPaddingTop();
        int end = v.H(editText);
        int bottom = editText.getPaddingBottom();
        v.r0(editText, editTextBackground2);
        v.A0(editText, start, top, end, bottom);
    }

    /* loaded from: classes.dex */
    public class h implements View.OnTouchListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AutoCompleteTextView f962b;

        public h(AutoCompleteTextView autoCompleteTextView) {
            this.f962b = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == 1) {
                if (d.this.C()) {
                    d.this.j = false;
                }
                d.this.H(this.f962b);
            }
            return false;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void G(AutoCompleteTextView editText) {
        editText.setOnTouchListener(new h(editText));
        editText.setOnFocusChangeListener(this.f);
        if (d) {
            editText.setOnDismissListener(new i());
        }
    }

    /* loaded from: classes.dex */
    public class i implements AutoCompleteTextView.OnDismissListener {
        public i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.j = true;
            d.this.l = System.currentTimeMillis();
            d.this.E(false);
        }
    }

    public final b.b.a.a.x.g A(float topCornerRadius, float bottomCornerRadius, float elevation, int verticalPadding) {
        k.b a2 = k.a();
        a2.A(topCornerRadius);
        a2.E(topCornerRadius);
        a2.s(bottomCornerRadius);
        a2.w(bottomCornerRadius);
        k shapeAppearanceModel = a2.m();
        b.b.a.a.x.g popupDrawable = b.b.a.a.x.g.m(this.f966b, elevation);
        popupDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        popupDrawable.X(0, verticalPadding, 0, verticalPadding);
        return popupDrawable;
    }

    public final boolean C() {
        long activeFor = System.currentTimeMillis() - this.l;
        return activeFor < 0 || activeFor > 300;
    }

    public static AutoCompleteTextView y(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        return (AutoCompleteTextView) editText;
    }

    public static boolean D(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public final void E(boolean checked) {
        if (this.k != checked) {
            this.k = checked;
            this.q.cancel();
            this.p.start();
        }
    }

    public final void B() {
        this.q = z(67, 0.0f, 1.0f);
        ValueAnimator z = z(50, 1.0f, 0.0f);
        this.p = z;
        z.addListener(new j());
    }

    /* loaded from: classes.dex */
    public class j extends AnimatorListenerAdapter {
        public j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            d dVar = d.this;
            dVar.c.setChecked(dVar.k);
            d.this.q.start();
        }
    }

    public final ValueAnimator z(int duration, float... values) {
        ValueAnimator animator = ValueAnimator.ofFloat(values);
        animator.setInterpolator(b.b.a.a.b.a.f977a);
        animator.setDuration(duration);
        animator.addUpdateListener(new b());
        return animator;
    }

    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            float alpha = ((Float) animation.getAnimatedValue()).floatValue();
            d.this.c.setAlpha(alpha);
        }
    }
}
