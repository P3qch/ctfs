package com.google.android.material.textfield;

import a.b.g.a0;
import a.b.g.f0;
import a.b.g.x0;
import a.h.k.v;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.a.a.a0.i;
import b.b.a.a.r.j;
import b.b.a.a.r.l;
import b.b.a.a.x.k;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public static final int f1193b = R.style.Widget_Design_TextInputLayout;
    public CharSequence A;
    public int A0;
    public final TextView B;
    public ColorStateList B0;
    public boolean C;
    public int C0;
    public CharSequence D;
    public int D0;
    public boolean E;
    public int E0;
    public b.b.a.a.x.g F;
    public int F0;
    public b.b.a.a.x.g G;
    public int G0;
    public k H;
    public boolean H0;
    public final int I;
    public final b.b.a.a.r.a I0;
    public int J;
    public boolean J0;
    public int K;
    public boolean K0;
    public int L;
    public ValueAnimator L0;
    public int M;
    public boolean M0;
    public int N;
    public boolean N0;
    public int O;
    public int P;
    public int Q;
    public final Rect R;
    public final Rect S;
    public final RectF T;
    public Typeface U;
    public final CheckableImageButton V;
    public ColorStateList W;
    public boolean a0;
    public PorterDuff.Mode b0;
    public final FrameLayout c;
    public boolean c0;
    public final LinearLayout d;
    public Drawable d0;
    public final LinearLayout e;
    public int e0;
    public final FrameLayout f;
    public View.OnLongClickListener f0;
    public EditText g;
    public final LinkedHashSet<f> g0;
    public CharSequence h;
    public int h0;
    public int i;
    public final SparseArray<b.b.a.a.a0.e> i0;
    public int j;
    public final CheckableImageButton j0;
    public final b.b.a.a.a0.f k;
    public final LinkedHashSet<g> k0;
    public boolean l;
    public ColorStateList l0;
    public int m;
    public boolean m0;
    public boolean n;
    public PorterDuff.Mode n0;
    public TextView o;
    public boolean o0;
    public int p;
    public Drawable p0;
    public int q;
    public int q0;
    public CharSequence r;
    public Drawable r0;
    public boolean s;
    public View.OnLongClickListener s0;
    public TextView t;
    public View.OnLongClickListener t0;
    public ColorStateList u;
    public final CheckableImageButton u0;
    public int v;
    public ColorStateList v0;
    public ColorStateList w;
    public ColorStateList w0;
    public ColorStateList x;
    public ColorStateList x0;
    public CharSequence y;
    public int y0;
    public final TextView z;
    public int z0;

    /* loaded from: classes.dex */
    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    public TextInputLayout(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.textInputStyle);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(b.b.a.a.b0.a.a.c(context, attributeSet, i, R.style.Widget_Design_TextInputLayout), attributeSet, i);
        int i2;
        int i3;
        this.i = -1;
        this.j = -1;
        this.k = new b.b.a.a.a0.f(this);
        this.R = new Rect();
        this.S = new Rect();
        this.T = new RectF();
        this.g0 = new LinkedHashSet<>();
        this.h0 = 0;
        SparseArray<b.b.a.a.a0.e> sparseArray = new SparseArray<>();
        this.i0 = sparseArray;
        this.k0 = new LinkedHashSet<>();
        b.b.a.a.r.a aVar = new b.b.a.a.r.a(this);
        this.I0 = aVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.c = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.d = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.e = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = b.b.a.a.b.a.f977a;
        aVar.d0(timeInterpolator);
        aVar.a0(timeInterpolator);
        aVar.O(8388659);
        int[] iArr = b.b.a.a.a.f942a;
        x0 i4 = j.i(context2, attributeSet, b.b.a.a.a.B, i, R.style.Widget_Design_TextInputLayout, 20, 18, 33, 38, 42);
        this.C = i4.a(41, true);
        setHint(i4.p(4));
        this.K0 = i4.a(40, true);
        this.J0 = i4.a(35, true);
        if (i4.s(3)) {
            setMinWidth(i4.f(3, -1));
        }
        if (i4.s(2)) {
            setMaxWidth(i4.f(2, -1));
        }
        this.H = k.e(context2, attributeSet, i, R.style.Widget_Design_TextInputLayout).m();
        this.I = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.L = i4.e(7, 0);
        this.N = i4.f(14, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.O = i4.f(15, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.M = this.N;
        float d2 = i4.d(11, -1.0f);
        float d3 = i4.d(10, -1.0f);
        float d4 = i4.d(8, -1.0f);
        float d5 = i4.d(9, -1.0f);
        k.b v = this.H.v();
        if (d2 >= 0.0f) {
            v.A(d2);
        }
        if (d3 >= 0.0f) {
            v.E(d3);
        }
        if (d4 >= 0.0f) {
            v.w(d4);
        }
        if (d5 >= 0.0f) {
            v.s(d5);
        }
        this.H = v.m();
        ColorStateList b2 = b.b.a.a.u.c.b(context2, i4, 5);
        if (b2 == null) {
            this.Q = 0;
            this.C0 = 0;
            this.D0 = 0;
            this.E0 = 0;
            this.F0 = 0;
        } else {
            int defaultColor = b2.getDefaultColor();
            this.C0 = defaultColor;
            this.Q = defaultColor;
            if (b2.isStateful()) {
                this.D0 = b2.getColorForState(new int[]{-16842910}, -1);
                this.E0 = b2.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.F0 = b2.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.E0 = this.C0;
                ColorStateList c2 = a.b.c.a.a.c(context2, R.color.mtrl_filled_background_color);
                this.D0 = c2.getColorForState(new int[]{-16842910}, -1);
                this.F0 = c2.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        }
        if (i4.s(1)) {
            ColorStateList c3 = i4.c(1);
            this.x0 = c3;
            this.w0 = c3;
        }
        ColorStateList b3 = b.b.a.a.u.c.b(context2, i4, 12);
        this.A0 = i4.b(12, 0);
        this.y0 = a.h.c.a.b(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.G0 = a.h.c.a.b(context2, R.color.mtrl_textinput_disabled_color);
        this.z0 = a.h.c.a.b(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (b3 != null) {
            setBoxStrokeColorStateList(b3);
        }
        if (i4.s(13)) {
            setBoxStrokeErrorColor(b.b.a.a.u.c.b(context2, i4, 13));
        }
        if (i4.n(42, -1) == -1) {
            i2 = 0;
        } else {
            i2 = 0;
            setHintTextAppearance(i4.n(42, 0));
        }
        int n = i4.n(33, i2);
        CharSequence p = i4.p(28);
        boolean a2 = i4.a(29, false);
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_end_icon, (ViewGroup) linearLayout2, false);
        this.u0 = checkableImageButton;
        checkableImageButton.setId(R.id.text_input_error_icon);
        checkableImageButton.setVisibility(8);
        if (b.b.a.a.u.c.g(context2)) {
            a.h.k.h.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        if (i4.s(30)) {
            setErrorIconDrawable(i4.g(30));
        }
        if (i4.s(31)) {
            setErrorIconTintList(b.b.a.a.u.c.b(context2, i4, 31));
        }
        if (i4.s(32)) {
            setErrorIconTintMode(l.e(i4.k(32, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        v.x0(checkableImageButton, 2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int n2 = i4.n(38, 0);
        boolean a3 = i4.a(37, false);
        CharSequence p2 = i4.p(36);
        int n3 = i4.n(50, 0);
        CharSequence p3 = i4.p(49);
        int n4 = i4.n(53, 0);
        CharSequence p4 = i4.p(52);
        int n5 = i4.n(63, 0);
        CharSequence p5 = i4.p(62);
        boolean a4 = i4.a(16, false);
        setCounterMaxLength(i4.k(17, -1));
        this.q = i4.n(20, 0);
        this.p = i4.n(18, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) linearLayout, false);
        this.V = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (b.b.a.a.u.c.g(context2)) {
            a.h.k.h.c((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (i4.s(59)) {
            setStartIconDrawable(i4.g(59));
            if (i4.s(58)) {
                setStartIconContentDescription(i4.p(58));
            }
            setStartIconCheckable(i4.a(57, true));
        }
        if (i4.s(60)) {
            setStartIconTintList(b.b.a.a.u.c.b(context2, i4, 60));
        }
        if (i4.s(61)) {
            setStartIconTintMode(l.e(i4.k(61, -1), null));
        }
        setBoxBackgroundMode(i4.k(6, 0));
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_end_icon, (ViewGroup) frameLayout2, false);
        this.j0 = checkableImageButton3;
        frameLayout2.addView(checkableImageButton3);
        checkableImageButton3.setVisibility(8);
        if (!b.b.a.a.u.c.g(context2)) {
            i3 = 0;
        } else {
            i3 = 0;
            a.h.k.h.d((ViewGroup.MarginLayoutParams) checkableImageButton3.getLayoutParams(), 0);
        }
        sparseArray.append(-1, new b.b.a.a.a0.b(this));
        sparseArray.append(i3, new b.b.a.a.a0.h(this));
        sparseArray.append(1, new i(this));
        sparseArray.append(2, new b.b.a.a.a0.a(this));
        sparseArray.append(3, new b.b.a.a.a0.d(this));
        if (i4.s(25)) {
            setEndIconMode(i4.k(25, 0));
            if (i4.s(24)) {
                setEndIconDrawable(i4.g(24));
            }
            if (i4.s(23)) {
                setEndIconContentDescription(i4.p(23));
            }
            setEndIconCheckable(i4.a(22, true));
        } else if (i4.s(46)) {
            setEndIconMode(i4.a(46, false) ? 1 : 0);
            setEndIconDrawable(i4.g(45));
            setEndIconContentDescription(i4.p(44));
            if (i4.s(47)) {
                setEndIconTintList(b.b.a.a.u.c.b(context2, i4, 47));
            }
            if (i4.s(48)) {
                setEndIconTintMode(l.e(i4.k(48, -1), null));
            }
        }
        if (!i4.s(46)) {
            if (i4.s(26)) {
                setEndIconTintList(b.b.a.a.u.c.b(context2, i4, 26));
            }
            if (i4.s(27)) {
                setEndIconTintMode(l.e(i4.k(27, -1), null));
            }
        }
        a0 a0Var = new a0(context2);
        this.z = a0Var;
        a0Var.setId(R.id.textinput_prefix_text);
        a0Var.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        v.q0(a0Var, 1);
        linearLayout.addView(checkableImageButton2);
        linearLayout.addView(a0Var);
        a0 a0Var2 = new a0(context2);
        this.B = a0Var2;
        a0Var2.setId(R.id.textinput_suffix_text);
        a0Var2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        v.q0(a0Var2, 1);
        linearLayout2.addView(a0Var2);
        linearLayout2.addView(checkableImageButton);
        linearLayout2.addView(frameLayout2);
        setHelperTextEnabled(a3);
        setHelperText(p2);
        setHelperTextTextAppearance(n2);
        setErrorEnabled(a2);
        setErrorTextAppearance(n);
        setErrorContentDescription(p);
        setCounterTextAppearance(this.q);
        setCounterOverflowTextAppearance(this.p);
        setPlaceholderText(p3);
        setPlaceholderTextAppearance(n3);
        setPrefixText(p4);
        setPrefixTextAppearance(n4);
        setSuffixText(p5);
        setSuffixTextAppearance(n5);
        if (i4.s(34)) {
            setErrorTextColor(i4.c(34));
        }
        if (i4.s(39)) {
            setHelperTextColor(i4.c(39));
        }
        if (i4.s(43)) {
            setHintTextColor(i4.c(43));
        }
        if (i4.s(21)) {
            setCounterTextColor(i4.c(21));
        }
        if (i4.s(19)) {
            setCounterOverflowTextColor(i4.c(19));
        }
        if (i4.s(51)) {
            setPlaceholderTextColor(i4.c(51));
        }
        if (i4.s(54)) {
            setPrefixTextColor(i4.c(54));
        }
        if (i4.s(64)) {
            setSuffixTextColor(i4.c(64));
        }
        setCounterEnabled(a4);
        setEnabled(i4.a(0, true));
        i4.w();
        v.x0(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            v.y0(this, 1);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (child instanceof EditText) {
            FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(params);
            flp.gravity = (flp.gravity & (-113)) | 16;
            this.c.addView(child, flp);
            this.c.setLayoutParams(params);
            u0();
            setEditText((EditText) child);
            return;
        }
        super.addView(child, index, params);
    }

    public b.b.a.a.x.g getBoxBackground() {
        int i = this.K;
        if (i == 1 || i == 2) {
            return this.F;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int boxBackgroundMode) {
        if (boxBackgroundMode == this.K) {
            return;
        }
        this.K = boxBackgroundMode;
        if (this.g != null) {
            S();
        }
    }

    public int getBoxBackgroundMode() {
        return this.K;
    }

    public final void S() {
        p();
        a0();
        F0();
        k0();
        h();
        if (this.K != 0) {
            u0();
        }
    }

    public final void p() {
        switch (this.K) {
            case 0:
                this.F = null;
                this.G = null;
                return;
            case 1:
                this.F = new b.b.a.a.x.g(this.H);
                this.G = new b.b.a.a.x.g();
                return;
            case 2:
                if (this.C && !(this.F instanceof b.b.a.a.a0.c)) {
                    this.F = new b.b.a.a.a0.c(this.H);
                } else {
                    this.F = new b.b.a.a.x.g(this.H);
                }
                this.G = null;
                return;
            default:
                throw new IllegalArgumentException(this.K + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    public final void a0() {
        if (h0()) {
            v.r0(this.g, this.F);
        }
    }

    public final boolean h0() {
        EditText editText = this.g;
        return (editText == null || this.F == null || editText.getBackground() != null || this.K == 0) ? false : true;
    }

    public final void k0() {
        if (this.K == 1) {
            if (b.b.a.a.u.c.h(getContext())) {
                this.L = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (b.b.a.a.u.c.g(getContext())) {
                this.L = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    public final void h() {
        if (this.g == null || this.K != 1) {
            return;
        }
        if (b.b.a.a.u.c.h(getContext())) {
            EditText editText = this.g;
            v.A0(editText, v.I(editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), v.H(this.g), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (b.b.a.a.u.c.g(getContext())) {
            EditText editText2 = this.g;
            v.A0(editText2, v.I(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), v.H(this.g), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    public void setBoxStrokeWidthResource(int boxStrokeWidthResId) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(boxStrokeWidthResId));
    }

    public void setBoxStrokeWidth(int boxStrokeWidth) {
        this.N = boxStrokeWidth;
        F0();
    }

    public int getBoxStrokeWidth() {
        return this.N;
    }

    public void setBoxStrokeWidthFocusedResource(int boxStrokeWidthFocusedResId) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(boxStrokeWidthFocusedResId));
    }

    public void setBoxStrokeWidthFocused(int boxStrokeWidthFocused) {
        this.O = boxStrokeWidthFocused;
        F0();
    }

    public int getBoxStrokeWidthFocused() {
        return this.O;
    }

    public void setBoxStrokeColor(int boxStrokeColor) {
        if (this.A0 != boxStrokeColor) {
            this.A0 = boxStrokeColor;
            F0();
        }
    }

    public int getBoxStrokeColor() {
        return this.A0;
    }

    public void setBoxStrokeColorStateList(ColorStateList boxStrokeColorStateList) {
        if (boxStrokeColorStateList.isStateful()) {
            this.y0 = boxStrokeColorStateList.getDefaultColor();
            this.G0 = boxStrokeColorStateList.getColorForState(new int[]{-16842910}, -1);
            this.z0 = boxStrokeColorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.A0 = boxStrokeColorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.A0 != boxStrokeColorStateList.getDefaultColor()) {
            this.A0 = boxStrokeColorStateList.getDefaultColor();
        }
        F0();
    }

    public void setBoxStrokeErrorColor(ColorStateList strokeErrorColor) {
        if (this.B0 != strokeErrorColor) {
            this.B0 = strokeErrorColor;
            F0();
        }
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.B0;
    }

    public void setBoxBackgroundColorResource(int boxBackgroundColorId) {
        setBoxBackgroundColor(a.h.c.a.b(getContext(), boxBackgroundColorId));
    }

    public void setBoxBackgroundColor(int boxBackgroundColor) {
        if (this.Q != boxBackgroundColor) {
            this.Q = boxBackgroundColor;
            this.C0 = boxBackgroundColor;
            this.E0 = boxBackgroundColor;
            this.F0 = boxBackgroundColor;
            j();
        }
    }

    public void setBoxBackgroundColorStateList(ColorStateList boxBackgroundColorStateList) {
        int defaultColor = boxBackgroundColorStateList.getDefaultColor();
        this.C0 = defaultColor;
        this.Q = defaultColor;
        this.D0 = boxBackgroundColorStateList.getColorForState(new int[]{-16842910}, -1);
        this.E0 = boxBackgroundColorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.F0 = boxBackgroundColorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        j();
    }

    public int getBoxBackgroundColor() {
        return this.Q;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.F.E();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.F.F();
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.F.s();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.F.t();
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.U) {
            this.U = typeface;
            this.I0.e0(typeface);
            this.k.J(typeface);
            TextView textView = this.o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.U;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure structure, int flags) {
        EditText editText = this.g;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(structure, flags);
            return;
        }
        if (this.h != null) {
            boolean wasProvidingHint = this.E;
            this.E = false;
            CharSequence hint = editText.getHint();
            this.g.setHint(this.h);
            try {
                super.dispatchProvideAutofillStructure(structure, flags);
                return;
            } finally {
                this.g.setHint(hint);
                this.E = wasProvidingHint;
            }
        }
        structure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(structure, flags);
        onProvideAutofillVirtualStructure(structure, flags);
        structure.setChildCount(this.c.getChildCount());
        for (int i = 0; i < this.c.getChildCount(); i++) {
            View child = this.c.getChildAt(i);
            ViewStructure childStructure = structure.newChild(i);
            child.dispatchProvideAutofillStructure(childStructure, flags);
            if (child == this.g) {
                childStructure.setHint(getHint());
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.g != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.h0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.g = editText;
        setMinWidth(this.i);
        setMaxWidth(this.j);
        S();
        setTextInputAccessibilityDelegate(new e(this));
        this.I0.e0(this.g.getTypeface());
        this.I0.W(this.g.getTextSize());
        int editTextGravity = this.g.getGravity();
        this.I0.O((editTextGravity & (-113)) | 48);
        this.I0.V(editTextGravity);
        this.g.addTextChangedListener(new a());
        if (this.w0 == null) {
            this.w0 = this.g.getHintTextColors();
        }
        if (this.C) {
            if (TextUtils.isEmpty(this.D)) {
                CharSequence hint = this.g.getHint();
                this.h = hint;
                setHint(hint);
                this.g.setHint((CharSequence) null);
            }
            this.E = true;
        }
        if (this.o != null) {
            n0(this.g.getText().length());
        }
        s0();
        this.k.e();
        this.d.bringToFront();
        this.e.bringToFront();
        this.f.bringToFront();
        this.u0.bringToFront();
        B();
        A0();
        D0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w0(false, true);
    }

    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            TextInputLayout.this.v0(!r0.N0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.l) {
                textInputLayout.n0(s.length());
            }
            if (TextInputLayout.this.s) {
                TextInputLayout.this.z0(s.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    public final void u0() {
        if (this.K != 1) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int newTopMargin = v();
            if (newTopMargin != lp.topMargin) {
                lp.topMargin = newTopMargin;
                this.c.requestLayout();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.g;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + v();
        }
        return super.getBaseline();
    }

    public void v0(boolean animate) {
        w0(animate, false);
    }

    public final void w0(boolean animate, boolean force) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.g;
        boolean hasText = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.g;
        boolean hasFocus = editText2 != null && editText2.hasFocus();
        boolean errorShouldBeShown = this.k.k();
        ColorStateList colorStateList2 = this.w0;
        if (colorStateList2 != null) {
            this.I0.N(colorStateList2);
            this.I0.U(this.w0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.w0;
            int disabledHintColor = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.G0) : this.G0;
            this.I0.N(ColorStateList.valueOf(disabledHintColor));
            this.I0.U(ColorStateList.valueOf(disabledHintColor));
        } else if (errorShouldBeShown) {
            this.I0.N(this.k.p());
        } else if (this.n && (textView = this.o) != null) {
            this.I0.N(textView.getTextColors());
        } else if (hasFocus && (colorStateList = this.x0) != null) {
            this.I0.N(colorStateList);
        }
        if (hasText || !this.J0 || (isEnabled() && hasFocus)) {
            if (force || this.H0) {
                z(animate);
                return;
            }
            return;
        }
        if (force || !this.H0) {
            F(animate);
        }
    }

    public EditText getEditText() {
        return this.g;
    }

    public void setMinWidth(int minWidth) {
        this.i = minWidth;
        EditText editText = this.g;
        if (editText != null && minWidth != -1) {
            editText.setMinWidth(minWidth);
        }
    }

    public void setMinWidthResource(int minWidthId) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(minWidthId));
    }

    public int getMinWidth() {
        return this.i;
    }

    public void setMaxWidth(int maxWidth) {
        this.j = maxWidth;
        EditText editText = this.g;
        if (editText != null && maxWidth != -1) {
            editText.setMaxWidth(maxWidth);
        }
    }

    public void setMaxWidthResource(int maxWidthId) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(maxWidthId));
    }

    public int getMaxWidth() {
        return this.j;
    }

    public void setHint(CharSequence hint) {
        if (this.C) {
            setHintInternal(hint);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHint(int textHintId) {
        setHint(textHintId != 0 ? getResources().getText(textHintId) : null);
    }

    private void setHintInternal(CharSequence hint) {
        if (!TextUtils.equals(hint, this.D)) {
            this.D = hint;
            this.I0.c0(hint);
            if (!this.H0) {
                T();
            }
        }
    }

    public CharSequence getHint() {
        if (this.C) {
            return this.D;
        }
        return null;
    }

    public void setHintEnabled(boolean enabled) {
        if (enabled != this.C) {
            this.C = enabled;
            if (!enabled) {
                this.E = false;
                if (!TextUtils.isEmpty(this.D) && TextUtils.isEmpty(this.g.getHint())) {
                    this.g.setHint(this.D);
                }
                setHintInternal(null);
            } else {
                CharSequence editTextHint = this.g.getHint();
                if (!TextUtils.isEmpty(editTextHint)) {
                    if (TextUtils.isEmpty(this.D)) {
                        setHint(editTextHint);
                    }
                    this.g.setHint((CharSequence) null);
                }
                this.E = true;
            }
            if (this.g != null) {
                u0();
            }
        }
    }

    public boolean O() {
        return this.E;
    }

    public void setHintTextAppearance(int resId) {
        this.I0.L(resId);
        this.x0 = this.I0.o();
        if (this.g != null) {
            v0(false);
            u0();
        }
    }

    public void setHintTextColor(ColorStateList hintTextColor) {
        if (this.x0 != hintTextColor) {
            if (this.w0 == null) {
                this.I0.N(hintTextColor);
            }
            this.x0 = hintTextColor;
            if (this.g != null) {
                v0(false);
            }
        }
    }

    public ColorStateList getHintTextColor() {
        return this.x0;
    }

    public void setDefaultHintTextColor(ColorStateList textColor) {
        this.w0 = textColor;
        this.x0 = textColor;
        if (this.g != null) {
            v0(false);
        }
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.w0;
    }

    public void setErrorEnabled(boolean enabled) {
        this.k.C(enabled);
    }

    public void setErrorTextAppearance(int errorTextAppearance) {
        this.k.D(errorTextAppearance);
    }

    public void setErrorTextColor(ColorStateList errorTextColor) {
        this.k.E(errorTextColor);
    }

    public int getErrorCurrentTextColors() {
        return this.k.o();
    }

    public void setHelperTextTextAppearance(int helperTextTextAppearance) {
        this.k.F(helperTextTextAppearance);
    }

    public void setHelperTextColor(ColorStateList helperTextColor) {
        this.k.H(helperTextColor);
    }

    public void setHelperTextEnabled(boolean enabled) {
        this.k.G(enabled);
    }

    public void setHelperText(CharSequence helperText) {
        if (TextUtils.isEmpty(helperText)) {
            if (M()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!M()) {
                setHelperTextEnabled(true);
            }
            this.k.N(helperText);
        }
    }

    public boolean M() {
        return this.k.y();
    }

    public int getHelperTextCurrentTextColor() {
        return this.k.r();
    }

    public void setErrorContentDescription(CharSequence errorContentDecription) {
        this.k.B(errorContentDecription);
    }

    public CharSequence getErrorContentDescription() {
        return this.k.m();
    }

    public void setError(CharSequence errorText) {
        if (!this.k.x()) {
            if (TextUtils.isEmpty(errorText)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (!TextUtils.isEmpty(errorText)) {
            this.k.M(errorText);
        } else {
            this.k.t();
        }
    }

    public void setErrorIconDrawable(int resId) {
        setErrorIconDrawable(resId != 0 ? a.b.c.a.a.d(getContext(), resId) : null);
        W();
    }

    public void setErrorIconDrawable(Drawable errorIconDrawable) {
        this.u0.setImageDrawable(errorIconDrawable);
        setErrorIconVisible(errorIconDrawable != null && this.k.x());
    }

    public Drawable getErrorIconDrawable() {
        return this.u0.getDrawable();
    }

    public void setErrorIconTintList(ColorStateList errorIconTintList) {
        this.v0 = errorIconTintList;
        Drawable icon = this.u0.getDrawable();
        if (icon != null) {
            icon = a.h.d.l.a.r(icon).mutate();
            a.h.d.l.a.o(icon, errorIconTintList);
        }
        if (this.u0.getDrawable() != icon) {
            this.u0.setImageDrawable(icon);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode errorIconTintMode) {
        Drawable icon = this.u0.getDrawable();
        if (icon != null) {
            icon = a.h.d.l.a.r(icon).mutate();
            a.h.d.l.a.p(icon, errorIconTintMode);
        }
        if (this.u0.getDrawable() != icon) {
            this.u0.setImageDrawable(icon);
        }
    }

    public void setCounterEnabled(boolean enabled) {
        if (this.l != enabled) {
            if (!enabled) {
                this.k.z(this.o, 2);
                this.o = null;
            } else {
                a0 a0Var = new a0(getContext());
                this.o = a0Var;
                a0Var.setId(R.id.textinput_counter);
                Typeface typeface = this.U;
                if (typeface != null) {
                    this.o.setTypeface(typeface);
                }
                this.o.setMaxLines(1);
                this.k.d(this.o, 2);
                a.h.k.h.d((ViewGroup.MarginLayoutParams) this.o.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                p0();
                m0();
            }
            this.l = enabled;
        }
    }

    public void setCounterTextAppearance(int counterTextAppearance) {
        if (this.q != counterTextAppearance) {
            this.q = counterTextAppearance;
            p0();
        }
    }

    public void setCounterTextColor(ColorStateList counterTextColor) {
        if (this.w != counterTextColor) {
            this.w = counterTextColor;
            p0();
        }
    }

    public ColorStateList getCounterTextColor() {
        return this.w;
    }

    public void setCounterOverflowTextAppearance(int counterOverflowTextAppearance) {
        if (this.p != counterOverflowTextAppearance) {
            this.p = counterOverflowTextAppearance;
            p0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList counterOverflowTextColor) {
        if (this.x != counterOverflowTextColor) {
            this.x = counterOverflowTextColor;
            p0();
        }
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.w;
    }

    public void setCounterMaxLength(int maxLength) {
        if (this.m != maxLength) {
            if (maxLength > 0) {
                this.m = maxLength;
            } else {
                this.m = -1;
            }
            if (this.l) {
                m0();
            }
        }
    }

    public final void m0() {
        if (this.o != null) {
            EditText editText = this.g;
            n0(editText == null ? 0 : editText.getText().length());
        }
    }

    public void n0(int length) {
        boolean wasCounterOverflowed = this.n;
        int i = this.m;
        if (i == -1) {
            this.o.setText(String.valueOf(length));
            this.o.setContentDescription(null);
            this.n = false;
        } else {
            this.n = length > i;
            o0(getContext(), this.o, length, this.m, this.n);
            if (wasCounterOverflowed != this.n) {
                p0();
            }
            a.h.i.a bidiFormatter = a.h.i.a.c();
            this.o.setText(bidiFormatter.j(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.m))));
        }
        if (this.g != null && wasCounterOverflowed != this.n) {
            v0(false);
            F0();
            s0();
        }
    }

    public static void o0(Context context, TextView counterView, int length, int counterMaxLength, boolean counterOverflowed) {
        counterView.setContentDescription(context.getString(counterOverflowed ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(counterMaxLength)));
    }

    public void setPlaceholderText(CharSequence placeholderText) {
        if (this.s && TextUtils.isEmpty(placeholderText)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.s) {
                setPlaceholderTextEnabled(true);
            }
            this.r = placeholderText;
        }
        y0();
    }

    public CharSequence getPlaceholderText() {
        if (this.s) {
            return this.r;
        }
        return null;
    }

    private void setPlaceholderTextEnabled(boolean placeholderEnabled) {
        if (this.s == placeholderEnabled) {
            return;
        }
        if (placeholderEnabled) {
            a0 a0Var = new a0(getContext());
            this.t = a0Var;
            a0Var.setId(R.id.textinput_placeholder);
            v.q0(this.t, 1);
            setPlaceholderTextAppearance(this.v);
            setPlaceholderTextColor(this.u);
            g();
        } else {
            Z();
            this.t = null;
        }
        this.s = placeholderEnabled;
    }

    public final void y0() {
        EditText editText = this.g;
        z0(editText == null ? 0 : editText.getText().length());
    }

    public final void z0(int inputTextLength) {
        if (inputTextLength == 0 && !this.H0) {
            i0();
        } else {
            J();
        }
    }

    public final void i0() {
        TextView textView = this.t;
        if (textView != null && this.s) {
            textView.setText(this.r);
            this.t.setVisibility(0);
            this.t.bringToFront();
        }
    }

    public final void J() {
        TextView textView = this.t;
        if (textView != null && this.s) {
            textView.setText((CharSequence) null);
            this.t.setVisibility(4);
        }
    }

    public final void g() {
        TextView textView = this.t;
        if (textView != null) {
            this.c.addView(textView);
            this.t.setVisibility(0);
        }
    }

    public final void Z() {
        TextView textView = this.t;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void setPlaceholderTextColor(ColorStateList placeholderTextColor) {
        if (this.u != placeholderTextColor) {
            this.u = placeholderTextColor;
            TextView textView = this.t;
            if (textView != null && placeholderTextColor != null) {
                textView.setTextColor(placeholderTextColor);
            }
        }
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.u;
    }

    public void setPlaceholderTextAppearance(int placeholderTextAppearance) {
        this.v = placeholderTextAppearance;
        TextView textView = this.t;
        if (textView != null) {
            a.h.l.i.n(textView, placeholderTextAppearance);
        }
    }

    public int getPlaceholderTextAppearance() {
        return this.v;
    }

    public void setPrefixText(CharSequence prefixText) {
        this.y = TextUtils.isEmpty(prefixText) ? null : prefixText;
        this.z.setText(prefixText);
        B0();
    }

    public CharSequence getPrefixText() {
        return this.y;
    }

    public TextView getPrefixTextView() {
        return this.z;
    }

    public final void B0() {
        this.z.setVisibility((this.y == null || N()) ? 8 : 0);
        r0();
    }

    public void setPrefixTextColor(ColorStateList prefixTextColor) {
        this.z.setTextColor(prefixTextColor);
    }

    public ColorStateList getPrefixTextColor() {
        return this.z.getTextColors();
    }

    public void setPrefixTextAppearance(int prefixTextAppearance) {
        a.h.l.i.n(this.z, prefixTextAppearance);
    }

    public final void A0() {
        if (this.g == null) {
            return;
        }
        int startPadding = Q() ? 0 : v.I(this.g);
        v.A0(this.z, startPadding, this.g.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.g.getCompoundPaddingBottom());
    }

    public void setSuffixText(CharSequence suffixText) {
        this.A = TextUtils.isEmpty(suffixText) ? null : suffixText;
        this.B.setText(suffixText);
        E0();
    }

    public CharSequence getSuffixText() {
        return this.A;
    }

    public TextView getSuffixTextView() {
        return this.B;
    }

    public final void E0() {
        int oldSuffixVisibility = this.B.getVisibility();
        boolean visible = (this.A == null || N()) ? false : true;
        this.B.setVisibility(visible ? 0 : 8);
        if (oldSuffixVisibility != this.B.getVisibility()) {
            getEndIconDelegate().c(visible);
        }
        r0();
    }

    public void setSuffixTextColor(ColorStateList suffixTextColor) {
        this.B.setTextColor(suffixTextColor);
    }

    public ColorStateList getSuffixTextColor() {
        return this.B.getTextColors();
    }

    public void setSuffixTextAppearance(int suffixTextAppearance) {
        a.h.l.i.n(this.B, suffixTextAppearance);
    }

    public final void D0() {
        if (this.g == null) {
            return;
        }
        int endPadding = (K() || L()) ? 0 : v.H(this.g);
        v.A0(this.B, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.g.getPaddingTop(), endPadding, this.g.getPaddingBottom());
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        U(this, enabled);
        super.setEnabled(enabled);
    }

    public static void U(ViewGroup vg, boolean enabled) {
        int count = vg.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = vg.getChildAt(i);
            child.setEnabled(enabled);
            if (child instanceof ViewGroup) {
                U((ViewGroup) child, enabled);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.m;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.l && this.n && (textView = this.o) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public final void p0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.o;
        if (textView != null) {
            e0(textView, this.n ? this.p : this.q);
            if (!this.n && (colorStateList2 = this.w) != null) {
                this.o.setTextColor(colorStateList2);
            }
            if (this.n && (colorStateList = this.x) != null) {
                this.o.setTextColor(colorStateList);
            }
        }
    }

    public void e0(TextView textView, int textAppearance) {
        boolean useDefaultColor = false;
        try {
            a.h.l.i.n(textView, textAppearance);
            if (Build.VERSION.SDK_INT >= 23) {
                if (textView.getTextColors().getDefaultColor() == -65281) {
                    useDefaultColor = true;
                }
            }
        } catch (Exception e2) {
            useDefaultColor = true;
        }
        if (useDefaultColor) {
            a.h.l.i.n(textView, R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(a.h.c.a.b(getContext(), R.color.design_error));
        }
    }

    public final int v() {
        if (!this.C) {
            return 0;
        }
        switch (this.K) {
            case 0:
            case 1:
                return (int) this.I0.p();
            case 2:
                return (int) (this.I0.p() / 2.0f);
            default:
                return 0;
        }
    }

    public final Rect r(Rect rect) {
        if (this.g == null) {
            throw new IllegalStateException();
        }
        Rect bounds = this.S;
        boolean isRtl = v.C(this) == 1;
        bounds.bottom = rect.bottom;
        switch (this.K) {
            case 1:
                bounds.left = G(rect.left, isRtl);
                bounds.top = rect.top + this.L;
                bounds.right = H(rect.right, isRtl);
                return bounds;
            case 2:
                bounds.left = rect.left + this.g.getPaddingLeft();
                bounds.top = rect.top - v();
                bounds.right = rect.right - this.g.getPaddingRight();
                return bounds;
            default:
                bounds.left = G(rect.left, isRtl);
                bounds.top = getPaddingTop();
                bounds.right = H(rect.right, isRtl);
                return bounds;
        }
    }

    public final int G(int rectLeft, boolean isRtl) {
        int left = this.g.getCompoundPaddingLeft() + rectLeft;
        if (this.y != null && !isRtl) {
            return (left - this.z.getMeasuredWidth()) + this.z.getPaddingLeft();
        }
        return left;
    }

    public final int H(int rectRight, boolean isRtl) {
        int right = rectRight - this.g.getCompoundPaddingRight();
        if (this.y != null && isRtl) {
            return right + (this.z.getMeasuredWidth() - this.z.getPaddingRight());
        }
        return right;
    }

    public final Rect u(Rect rect) {
        if (this.g == null) {
            throw new IllegalStateException();
        }
        Rect bounds = this.S;
        float labelHeight = this.I0.v();
        bounds.left = rect.left + this.g.getCompoundPaddingLeft();
        bounds.top = t(rect, labelHeight);
        bounds.right = rect.right - this.g.getCompoundPaddingRight();
        bounds.bottom = s(rect, bounds, labelHeight);
        return bounds;
    }

    public final int t(Rect rect, float labelHeight) {
        if (P()) {
            return (int) (rect.centerY() - (labelHeight / 2.0f));
        }
        return rect.top + this.g.getCompoundPaddingTop();
    }

    public final int s(Rect rect, Rect bounds, float labelHeight) {
        if (P()) {
            return (int) (bounds.top + labelHeight);
        }
        return rect.bottom - this.g.getCompoundPaddingBottom();
    }

    public final boolean P() {
        return this.K == 1 && this.g.getMinLines() <= 1;
    }

    public final int q() {
        int backgroundColor = this.Q;
        if (this.K == 1) {
            int surfaceLayerColor = b.b.a.a.k.a.d(this, R.attr.colorSurface, 0);
            int backgroundColor2 = b.b.a.a.k.a.e(surfaceLayerColor, this.Q);
            return backgroundColor2;
        }
        return backgroundColor;
    }

    public final void j() {
        b.b.a.a.x.g gVar = this.F;
        if (gVar == null) {
            return;
        }
        gVar.setShapeAppearanceModel(this.H);
        if (w()) {
            this.F.Z(this.M, this.P);
        }
        int q = q();
        this.Q = q;
        this.F.V(ColorStateList.valueOf(q));
        if (this.h0 == 3) {
            this.g.getBackground().invalidateSelf();
        }
        k();
        invalidate();
    }

    public final void k() {
        if (this.G == null) {
            return;
        }
        if (x()) {
            this.G.V(ColorStateList.valueOf(this.P));
        }
        invalidate();
    }

    public final boolean w() {
        return this.K == 2 && x();
    }

    public final boolean x() {
        return this.M > -1 && this.P != 0;
    }

    public void s0() {
        Drawable editTextBackground;
        TextView textView;
        EditText editText = this.g;
        if (editText == null || this.K != 0 || (editTextBackground = editText.getBackground()) == null) {
            return;
        }
        if (f0.a(editTextBackground)) {
            editTextBackground = editTextBackground.mutate();
        }
        if (this.k.k()) {
            editTextBackground.setColorFilter(a.b.g.j.e(this.k.o(), PorterDuff.Mode.SRC_IN));
        } else if (this.n && (textView = this.o) != null) {
            editTextBackground.setColorFilter(a.b.g.j.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            a.h.d.l.a.c(editTextBackground);
            this.g.refreshDrawableState();
        }
    }

    /* loaded from: classes.dex */
    public static class h extends a.j.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public CharSequence d;
        public boolean e;
        public CharSequence f;
        public CharSequence g;
        public CharSequence h;

        public h(Parcelable superState) {
            super(superState);
        }

        public h(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            this.e = source.readInt() == 1;
            this.f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            this.h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        }

        @Override // a.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.d, parcel, i);
            parcel.writeInt(this.e ? 1 : 0);
            TextUtils.writeToParcel(this.f, parcel, i);
            TextUtils.writeToParcel(this.g, parcel, i);
            TextUtils.writeToParcel(this.h, parcel, i);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.d) + " hint=" + ((Object) this.f) + " helperText=" + ((Object) this.g) + " placeholderText=" + ((Object) this.h) + "}";
        }

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel in, ClassLoader loader) {
                return new h(in, loader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel in) {
                return new h(in, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int size) {
                return new h[size];
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        h ss = new h(superState);
        if (this.k.k()) {
            ss.d = getError();
        }
        ss.e = I() && this.j0.isChecked();
        ss.f = getHint();
        ss.g = getHelperText();
        ss.h = getPlaceholderText();
        return ss;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof h)) {
            super.onRestoreInstanceState(state);
            return;
        }
        h ss = (h) state;
        super.onRestoreInstanceState(ss.j());
        setError(ss.d);
        if (ss.e) {
            this.j0.post(new b());
        }
        setHint(ss.f);
        setHelperText(ss.g);
        setPlaceholderText(ss.h);
        requestLayout();
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.j0.performClick();
            TextInputLayout.this.j0.jumpDrawablesToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        this.N0 = true;
        super.dispatchRestoreInstanceState(container);
        this.N0 = false;
    }

    public CharSequence getError() {
        if (this.k.x()) {
            return this.k.n();
        }
        return null;
    }

    public CharSequence getHelperText() {
        if (this.k.y()) {
            return this.k.q();
        }
        return null;
    }

    public void setHintAnimationEnabled(boolean enabled) {
        this.K0 = enabled;
    }

    public void setExpandedHintEnabled(boolean enabled) {
        if (this.J0 != enabled) {
            this.J0 = enabled;
            v0(false);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        boolean updatedHeight = t0();
        boolean updatedIcon = r0();
        if (updatedHeight || updatedIcon) {
            this.g.post(new c());
        }
        x0();
        A0();
        D0();
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.g.requestLayout();
        }
    }

    public final boolean t0() {
        int maxIconHeight;
        if (this.g == null || this.g.getMeasuredHeight() >= (maxIconHeight = Math.max(this.e.getMeasuredHeight(), this.d.getMeasuredHeight()))) {
            return false;
        }
        this.g.setMinimumHeight(maxIconHeight);
        return true;
    }

    public final void x0() {
        EditText editText;
        if (this.t != null && (editText = this.g) != null) {
            int editTextGravity = editText.getGravity();
            this.t.setGravity(editTextGravity);
            this.t.setPadding(this.g.getCompoundPaddingLeft(), this.g.getCompoundPaddingTop(), this.g.getCompoundPaddingRight(), this.g.getCompoundPaddingBottom());
        }
    }

    public void setStartIconDrawable(int resId) {
        setStartIconDrawable(resId != 0 ? a.b.c.a.a.d(getContext(), resId) : null);
    }

    public void setStartIconDrawable(Drawable startIconDrawable) {
        this.V.setImageDrawable(startIconDrawable);
        if (startIconDrawable != null) {
            setStartIconVisible(true);
            Y();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    public Drawable getStartIconDrawable() {
        return this.V.getDrawable();
    }

    public void setStartIconOnClickListener(View.OnClickListener startIconOnClickListener) {
        c0(this.V, startIconOnClickListener, this.f0);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener startIconOnLongClickListener) {
        this.f0 = startIconOnLongClickListener;
        d0(this.V, startIconOnLongClickListener);
    }

    public void setStartIconVisible(boolean visible) {
        if (Q() != visible) {
            this.V.setVisibility(visible ? 0 : 8);
            A0();
            r0();
        }
    }

    public boolean Q() {
        return this.V.getVisibility() == 0;
    }

    public void Y() {
        X(this.V, this.W);
    }

    public void setStartIconCheckable(boolean startIconCheckable) {
        this.V.setCheckable(startIconCheckable);
    }

    public void setStartIconContentDescription(int resId) {
        setStartIconContentDescription(resId != 0 ? getResources().getText(resId) : null);
    }

    public void setStartIconContentDescription(CharSequence startIconContentDescription) {
        if (getStartIconContentDescription() != startIconContentDescription) {
            this.V.setContentDescription(startIconContentDescription);
        }
    }

    public CharSequence getStartIconContentDescription() {
        return this.V.getContentDescription();
    }

    public void setStartIconTintList(ColorStateList startIconTintList) {
        if (this.W != startIconTintList) {
            this.W = startIconTintList;
            this.a0 = true;
            o();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode startIconTintMode) {
        if (this.b0 != startIconTintMode) {
            this.b0 = startIconTintMode;
            this.c0 = true;
            o();
        }
    }

    public void setEndIconMode(int endIconMode) {
        int previousEndIconMode = this.h0;
        this.h0 = endIconMode;
        C(previousEndIconMode);
        setEndIconVisible(endIconMode != 0);
        if (getEndIconDelegate().b(this.K)) {
            getEndIconDelegate().a();
            m();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.K + " is not supported by the end icon mode " + endIconMode);
    }

    public int getEndIconMode() {
        return this.h0;
    }

    public void setEndIconOnClickListener(View.OnClickListener endIconOnClickListener) {
        c0(this.j0, endIconOnClickListener, this.s0);
    }

    public void setErrorIconOnClickListener(View.OnClickListener errorIconOnClickListener) {
        c0(this.u0, errorIconOnClickListener, this.t0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener endIconOnLongClickListener) {
        this.s0 = endIconOnLongClickListener;
        d0(this.j0, endIconOnLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener errorIconOnLongClickListener) {
        this.t0 = errorIconOnLongClickListener;
        d0(this.u0, errorIconOnLongClickListener);
    }

    public void W() {
        X(this.u0, this.v0);
    }

    public void setEndIconVisible(boolean visible) {
        if (K() != visible) {
            this.j0.setVisibility(visible ? 0 : 8);
            D0();
            r0();
        }
    }

    public boolean K() {
        return this.f.getVisibility() == 0 && this.j0.getVisibility() == 0;
    }

    public void setEndIconActivated(boolean endIconActivated) {
        this.j0.setActivated(endIconActivated);
    }

    public void V() {
        X(this.j0, this.l0);
    }

    public void setEndIconCheckable(boolean endIconCheckable) {
        this.j0.setCheckable(endIconCheckable);
    }

    public void setEndIconDrawable(int resId) {
        setEndIconDrawable(resId != 0 ? a.b.c.a.a.d(getContext(), resId) : null);
    }

    public void setEndIconDrawable(Drawable endIconDrawable) {
        this.j0.setImageDrawable(endIconDrawable);
        V();
    }

    public Drawable getEndIconDrawable() {
        return this.j0.getDrawable();
    }

    public void setEndIconContentDescription(int resId) {
        setEndIconContentDescription(resId != 0 ? getResources().getText(resId) : null);
    }

    public void setEndIconContentDescription(CharSequence endIconContentDescription) {
        if (getEndIconContentDescription() != endIconContentDescription) {
            this.j0.setContentDescription(endIconContentDescription);
        }
    }

    public CharSequence getEndIconContentDescription() {
        return this.j0.getContentDescription();
    }

    public void setEndIconTintList(ColorStateList endIconTintList) {
        if (this.l0 != endIconTintList) {
            this.l0 = endIconTintList;
            this.m0 = true;
            m();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode endIconTintMode) {
        if (this.n0 != endIconTintMode) {
            this.n0 = endIconTintMode;
            this.o0 = true;
            m();
        }
    }

    public void f(g listener) {
        this.k0.add(listener);
    }

    public void e(f listener) {
        this.g0.add(listener);
        if (this.g != null) {
            listener.a(this);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int resId) {
        setPasswordVisibilityToggleDrawable(resId != 0 ? a.b.c.a.a.d(getContext(), resId) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable icon) {
        this.j0.setImageDrawable(icon);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int resId) {
        setPasswordVisibilityToggleContentDescription(resId != 0 ? getResources().getText(resId) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence description) {
        this.j0.setContentDescription(description);
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.j0.getDrawable();
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.j0.getContentDescription();
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean enabled) {
        if (enabled && this.h0 != 1) {
            setEndIconMode(1);
        } else if (!enabled) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList tintList) {
        this.l0 = tintList;
        this.m0 = true;
        m();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.n0 = mode;
        this.o0 = true;
        m();
    }

    public void setTextInputAccessibilityDelegate(e delegate) {
        EditText editText = this.g;
        if (editText != null) {
            v.o0(editText, delegate);
        }
    }

    public CheckableImageButton getEndIconView() {
        return this.j0;
    }

    private b.b.a.a.a0.e getEndIconDelegate() {
        b.b.a.a.a0.e endIconDelegate = this.i0.get(this.h0);
        return endIconDelegate != null ? endIconDelegate : this.i0.get(0);
    }

    public final void B() {
        Iterator<f> it = this.g0.iterator();
        while (it.hasNext()) {
            f listener = it.next();
            listener.a(this);
        }
    }

    public final void o() {
        n(this.V, this.a0, this.W, this.c0, this.b0);
    }

    public final boolean I() {
        return this.h0 != 0;
    }

    public final void C(int previousIcon) {
        Iterator<g> it = this.k0.iterator();
        while (it.hasNext()) {
            g listener = it.next();
            listener.a(this, previousIcon);
        }
    }

    public final void j0(boolean tintEndIconOnError) {
        if (tintEndIconOnError && getEndIconDrawable() != null) {
            Drawable endIconDrawable = a.h.d.l.a.r(getEndIconDrawable()).mutate();
            a.h.d.l.a.n(endIconDrawable, this.k.o());
            this.j0.setImageDrawable(endIconDrawable);
            return;
        }
        m();
    }

    public final void m() {
        n(this.j0, this.m0, this.l0, this.o0, this.n0);
    }

    public final boolean r0() {
        if (this.g == null) {
            return false;
        }
        boolean updatedIcon = false;
        if (g0()) {
            int right = this.d.getMeasuredWidth() - this.g.getPaddingLeft();
            if (this.d0 == null || this.e0 != right) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.d0 = colorDrawable;
                this.e0 = right;
                colorDrawable.setBounds(0, 0, right, 1);
            }
            Drawable[] compounds = a.h.l.i.a(this.g);
            Drawable drawable = compounds[0];
            Drawable drawable2 = this.d0;
            if (drawable != drawable2) {
                a.h.l.i.i(this.g, drawable2, compounds[1], compounds[2], compounds[3]);
                updatedIcon = true;
            }
        } else if (this.d0 != null) {
            Drawable[] compounds2 = a.h.l.i.a(this.g);
            a.h.l.i.i(this.g, null, compounds2[1], compounds2[2], compounds2[3]);
            this.d0 = null;
            updatedIcon = true;
        }
        if (f0()) {
            int right2 = this.B.getMeasuredWidth() - this.g.getPaddingRight();
            View iconView = getEndIconToUpdateDummyDrawable();
            if (iconView != null) {
                right2 = iconView.getMeasuredWidth() + right2 + a.h.k.h.b((ViewGroup.MarginLayoutParams) iconView.getLayoutParams());
            }
            Drawable[] compounds3 = a.h.l.i.a(this.g);
            Drawable drawable3 = this.p0;
            if (drawable3 != null && this.q0 != right2) {
                this.q0 = right2;
                drawable3.setBounds(0, 0, right2, 1);
                a.h.l.i.i(this.g, compounds3[0], compounds3[1], this.p0, compounds3[3]);
                return true;
            }
            if (drawable3 == null) {
                ColorDrawable colorDrawable2 = new ColorDrawable();
                this.p0 = colorDrawable2;
                this.q0 = right2;
                colorDrawable2.setBounds(0, 0, right2, 1);
            }
            Drawable drawable4 = compounds3[2];
            Drawable drawable5 = this.p0;
            if (drawable4 != drawable5) {
                this.r0 = compounds3[2];
                a.h.l.i.i(this.g, compounds3[0], compounds3[1], drawable5, compounds3[3]);
                return true;
            }
            return updatedIcon;
        }
        if (this.p0 != null) {
            Drawable[] compounds4 = a.h.l.i.a(this.g);
            if (compounds4[2] == this.p0) {
                a.h.l.i.i(this.g, compounds4[0], compounds4[1], this.r0, compounds4[3]);
                updatedIcon = true;
            }
            this.p0 = null;
            return updatedIcon;
        }
        return updatedIcon;
    }

    public final boolean g0() {
        return !(getStartIconDrawable() == null && this.y == null) && this.d.getMeasuredWidth() > 0;
    }

    public final boolean f0() {
        return (this.u0.getVisibility() == 0 || ((I() && K()) || this.A != null)) && this.e.getMeasuredWidth() > 0;
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.u0.getVisibility() == 0) {
            return this.u0;
        }
        if (I() && K()) {
            return this.j0;
        }
        return null;
    }

    public final void n(CheckableImageButton iconView, boolean hasIconTintList, ColorStateList iconTintList, boolean hasIconTintMode, PorterDuff.Mode iconTintMode) {
        Drawable icon = iconView.getDrawable();
        if (icon != null && (hasIconTintList || hasIconTintMode)) {
            icon = a.h.d.l.a.r(icon).mutate();
            if (hasIconTintList) {
                a.h.d.l.a.o(icon, iconTintList);
            }
            if (hasIconTintMode) {
                a.h.d.l.a.p(icon, iconTintMode);
            }
        }
        if (iconView.getDrawable() != icon) {
            iconView.setImageDrawable(icon);
        }
    }

    public static void c0(CheckableImageButton iconView, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        iconView.setOnClickListener(onClickListener);
        b0(iconView, onLongClickListener);
    }

    public static void d0(CheckableImageButton iconView, View.OnLongClickListener onLongClickListener) {
        iconView.setOnLongClickListener(onLongClickListener);
        b0(iconView, onLongClickListener);
    }

    public static void b0(CheckableImageButton iconView, View.OnLongClickListener onLongClickListener) {
        boolean iconClickable = v.O(iconView);
        boolean iconLongClickable = onLongClickListener != null;
        boolean iconFocusable = iconClickable || iconLongClickable;
        iconView.setFocusable(iconFocusable);
        iconView.setClickable(iconClickable);
        iconView.setPressable(iconClickable);
        iconView.setLongClickable(iconLongClickable);
        v.x0(iconView, iconFocusable ? 1 : 2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        EditText editText = this.g;
        if (editText != null) {
            Rect rect = this.R;
            b.b.a.a.r.b.a(this, editText, rect);
            l0(rect);
            if (this.C) {
                this.I0.W(this.g.getTextSize());
                int editTextGravity = this.g.getGravity();
                this.I0.O((editTextGravity & (-113)) | 48);
                this.I0.V(editTextGravity);
                this.I0.K(r(rect));
                this.I0.S(u(rect));
                this.I0.G();
                if (A() && !this.H0) {
                    T();
                }
            }
        }
    }

    public final void l0(Rect bounds) {
        b.b.a.a.x.g gVar = this.G;
        if (gVar != null) {
            int i = bounds.bottom;
            int top = i - this.O;
            gVar.setBounds(bounds.left, top, bounds.right, i);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    public final void E(Canvas canvas) {
        if (this.C) {
            this.I0.l(canvas);
        }
    }

    public final void D(Canvas canvas) {
        b.b.a.a.x.g gVar = this.G;
        if (gVar != null) {
            Rect underlineBounds = gVar.getBounds();
            underlineBounds.top = underlineBounds.bottom - this.M;
            this.G.draw(canvas);
        }
    }

    public final void z(boolean animate) {
        ValueAnimator valueAnimator = this.L0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.L0.cancel();
        }
        if (!animate || !this.K0) {
            this.I0.Y(1.0f);
        } else {
            i(1.0f);
        }
        this.H0 = false;
        if (A()) {
            T();
        }
        y0();
        B0();
        E0();
    }

    public final boolean A() {
        return this.C && !TextUtils.isEmpty(this.D) && (this.F instanceof b.b.a.a.a0.c);
    }

    public final void T() {
        if (!A()) {
            return;
        }
        RectF cutoutBounds = this.T;
        this.I0.n(cutoutBounds, this.g.getWidth(), this.g.getGravity());
        l(cutoutBounds);
        int i = this.M;
        this.J = i;
        cutoutBounds.top = 0.0f;
        cutoutBounds.bottom = i;
        cutoutBounds.offset(-getPaddingLeft(), 0.0f);
        ((b.b.a.a.a0.c) this.F).m0(cutoutBounds);
    }

    public final void q0() {
        if (A() && !this.H0 && this.J != this.M) {
            y();
            T();
        }
    }

    public final void y() {
        if (A()) {
            ((b.b.a.a.a0.c) this.F).j0();
        }
    }

    public final void l(RectF cutoutBounds) {
        float f2 = cutoutBounds.left;
        int i = this.I;
        cutoutBounds.left = f2 - i;
        cutoutBounds.right += i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.M0) {
            return;
        }
        this.M0 = true;
        super.drawableStateChanged();
        int[] state = getDrawableState();
        b.b.a.a.r.a aVar = this.I0;
        boolean changed = aVar != null ? false | aVar.b0(state) : false;
        if (this.g != null) {
            v0(v.T(this) && isEnabled());
        }
        s0();
        F0();
        if (changed) {
            invalidate();
        }
        this.M0 = false;
    }

    public void F0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.F == null || this.K == 0) {
            return;
        }
        boolean z = false;
        boolean hasFocus = isFocused() || ((editText2 = this.g) != null && editText2.hasFocus());
        boolean isHovered = isHovered() || ((editText = this.g) != null && editText.isHovered());
        if (!isEnabled()) {
            this.P = this.G0;
        } else if (this.k.k()) {
            if (this.B0 != null) {
                C0(hasFocus, isHovered);
            } else {
                this.P = this.k.o();
            }
        } else if (this.n && (textView = this.o) != null) {
            if (this.B0 != null) {
                C0(hasFocus, isHovered);
            } else {
                this.P = textView.getCurrentTextColor();
            }
        } else if (hasFocus) {
            this.P = this.A0;
        } else if (isHovered) {
            this.P = this.z0;
        } else {
            this.P = this.y0;
        }
        if (getErrorIconDrawable() != null && this.k.x() && this.k.k()) {
            z = true;
        }
        setErrorIconVisible(z);
        W();
        Y();
        V();
        if (getEndIconDelegate().d()) {
            j0(this.k.k());
        }
        if (hasFocus && isEnabled()) {
            this.M = this.O;
        } else {
            this.M = this.N;
        }
        if (this.K == 2) {
            q0();
        }
        if (this.K == 1) {
            if (!isEnabled()) {
                this.Q = this.D0;
            } else if (isHovered && !hasFocus) {
                this.Q = this.F0;
            } else if (hasFocus) {
                this.Q = this.E0;
            } else {
                this.Q = this.C0;
            }
        }
        j();
    }

    public final void C0(boolean hasFocus, boolean isHovered) {
        int defaultStrokeErrorColor = this.B0.getDefaultColor();
        int hoveredStrokeErrorColor = this.B0.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultStrokeErrorColor);
        int focusedStrokeErrorColor = this.B0.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultStrokeErrorColor);
        if (hasFocus) {
            this.P = focusedStrokeErrorColor;
        } else if (isHovered) {
            this.P = hoveredStrokeErrorColor;
        } else {
            this.P = defaultStrokeErrorColor;
        }
    }

    private void setErrorIconVisible(boolean errorIconVisible) {
        this.u0.setVisibility(errorIconVisible ? 0 : 8);
        this.f.setVisibility(errorIconVisible ? 8 : 0);
        D0();
        if (!I()) {
            r0();
        }
    }

    public final boolean L() {
        return this.u0.getVisibility() == 0;
    }

    public final void X(CheckableImageButton iconView, ColorStateList colorStateList) {
        Drawable icon = iconView.getDrawable();
        if (iconView.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int color = colorStateList.getColorForState(R(iconView), colorStateList.getDefaultColor());
        Drawable icon2 = a.h.d.l.a.r(icon).mutate();
        a.h.d.l.a.o(icon2, ColorStateList.valueOf(color));
        iconView.setImageDrawable(icon2);
    }

    public final int[] R(CheckableImageButton iconView) {
        int[] textInputStates = getDrawableState();
        int[] iconStates = iconView.getDrawableState();
        int index = textInputStates.length;
        int[] states = Arrays.copyOf(textInputStates, textInputStates.length + iconStates.length);
        System.arraycopy(iconStates, 0, states, index, iconStates.length);
        return states;
    }

    public final void F(boolean animate) {
        ValueAnimator valueAnimator = this.L0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.L0.cancel();
        }
        if (!animate || !this.K0) {
            this.I0.Y(0.0f);
        } else {
            i(0.0f);
        }
        if (A() && ((b.b.a.a.a0.c) this.F).g0()) {
            y();
        }
        this.H0 = true;
        J();
        B0();
        E0();
    }

    public void i(float target) {
        if (this.I0.w() == target) {
            return;
        }
        if (this.L0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.L0 = valueAnimator;
            valueAnimator.setInterpolator(b.b.a.a.b.a.f978b);
            this.L0.setDuration(167L);
            this.L0.addUpdateListener(new d());
        }
        this.L0.setFloatValues(this.I0.w(), target);
        this.L0.start();
    }

    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animator) {
            TextInputLayout.this.I0.Y(((Float) animator.getAnimatedValue()).floatValue());
        }
    }

    public final boolean N() {
        return this.H0;
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.I0.s();
    }

    public final float getHintCollapsedTextHeight() {
        return this.I0.p();
    }

    public final int getErrorTextCurrentColor() {
        return this.k.o();
    }

    /* loaded from: classes.dex */
    public static class e extends a.h.k.a {
        public final TextInputLayout d;

        public e(TextInputLayout layout) {
            this.d = layout;
        }

        @Override // a.h.k.a
        public void g(View host, a.h.k.e0.c info) {
            String hint;
            String text;
            super.g(host, info);
            EditText editText = this.d.getEditText();
            CharSequence inputText = editText != null ? editText.getText() : null;
            CharSequence hintText = this.d.getHint();
            CharSequence errorText = this.d.getError();
            CharSequence placeholderText = this.d.getPlaceholderText();
            int maxCharLimit = this.d.getCounterMaxLength();
            CharSequence counterOverflowDesc = this.d.getCounterOverflowDescription();
            boolean showingText = !TextUtils.isEmpty(inputText);
            boolean hasHint = !TextUtils.isEmpty(hintText);
            boolean isHintCollapsed = !this.d.N();
            boolean showingError = !TextUtils.isEmpty(errorText);
            boolean contentInvalid = showingError || !TextUtils.isEmpty(counterOverflowDesc);
            String hint2 = hasHint ? hintText.toString() : BuildConfig.FLAVOR;
            if (showingText) {
                info.r0(inputText);
                hint = hint2;
            } else if (!TextUtils.isEmpty(hint2)) {
                hint = hint2;
                info.r0(hint);
                if (isHintCollapsed && placeholderText != null) {
                    info.r0(hint + ", " + ((Object) placeholderText));
                }
            } else {
                hint = hint2;
                if (placeholderText != null) {
                    info.r0(placeholderText);
                }
            }
            if (!TextUtils.isEmpty(hint)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    info.g0(hint);
                } else {
                    if (showingText) {
                        text = ((Object) inputText) + ", " + hint;
                    } else {
                        text = hint;
                    }
                    info.r0(text);
                }
                info.o0(!showingText);
            }
            info.h0((inputText == null || inputText.length() != maxCharLimit) ? -1 : maxCharLimit);
            if (contentInvalid) {
                info.c0(showingError ? errorText : counterOverflowDesc);
            }
            if (Build.VERSION.SDK_INT >= 17 && editText != null) {
                editText.setLabelFor(R.id.textinput_helper_text);
            }
        }
    }
}
