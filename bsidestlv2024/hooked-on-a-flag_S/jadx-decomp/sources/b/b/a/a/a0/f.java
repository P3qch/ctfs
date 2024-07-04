package b.b.a.a.a0;

import a.b.g.a0;
import a.h.k.v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f967a;

    /* renamed from: b, reason: collision with root package name */
    public final TextInputLayout f968b;
    public LinearLayout c;
    public int d;
    public FrameLayout e;
    public Animator f;
    public final float g;
    public int h;
    public int i;
    public CharSequence j;
    public boolean k;
    public TextView l;
    public CharSequence m;
    public int n;
    public ColorStateList o;
    public CharSequence p;
    public boolean q;
    public TextView r;
    public int s;
    public ColorStateList t;
    public Typeface u;

    public f(TextInputLayout textInputView) {
        this.f967a = textInputView.getContext();
        this.f968b = textInputView;
        this.g = r0.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    public void N(CharSequence helperText) {
        g();
        this.p = helperText;
        this.r.setText(helperText);
        int i = this.h;
        if (i != 2) {
            this.i = 2;
        }
        O(i, this.i, L(this.r, helperText));
    }

    public void u() {
        g();
        int i = this.h;
        if (i == 2) {
            this.i = 0;
        }
        O(i, this.i, L(this.r, null));
    }

    public void M(CharSequence errorText) {
        g();
        this.j = errorText;
        this.l.setText(errorText);
        int i = this.h;
        if (i != 1) {
            this.i = 1;
        }
        O(i, this.i, L(this.l, errorText));
    }

    public void t() {
        this.j = null;
        g();
        if (this.h == 1) {
            if (this.q && !TextUtils.isEmpty(this.p)) {
                this.i = 2;
            } else {
                this.i = 0;
            }
        }
        O(this.h, this.i, L(this.l, null));
    }

    public final boolean L(TextView captionView, CharSequence captionText) {
        return v.T(this.f968b) && this.f968b.isEnabled() && !(this.i == this.h && captionView != null && TextUtils.equals(captionView.getText(), captionText));
    }

    public final void O(int captionToHide, int captionToShow, boolean animate) {
        if (captionToHide == captionToShow) {
            return;
        }
        if (animate) {
            AnimatorSet captionAnimator = new AnimatorSet();
            this.f = captionAnimator;
            List<Animator> captionAnimatorList = new ArrayList<>();
            h(captionAnimatorList, this.q, this.r, 2, captionToHide, captionToShow);
            h(captionAnimatorList, this.k, this.l, 1, captionToHide, captionToShow);
            b.b.a.a.b.b.a(captionAnimator, captionAnimatorList);
            TextView captionViewToHide = l(captionToHide);
            TextView captionViewToShow = l(captionToShow);
            captionAnimator.addListener(new a(captionToShow, captionViewToHide, captionToHide, captionViewToShow));
            captionAnimator.start();
        } else {
            A(captionToHide, captionToShow);
        }
        this.f968b.s0();
        this.f968b.v0(animate);
        this.f968b.F0();
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f969a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f970b;
        public final /* synthetic */ int c;
        public final /* synthetic */ TextView d;

        public a(int i, TextView textView, int i2, TextView textView2) {
            this.f969a = i;
            this.f970b = textView;
            this.c = i2;
            this.d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.h = this.f969a;
            f.this.f = null;
            TextView textView = this.f970b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.c == 1 && f.this.l != null) {
                    f.this.l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public final void A(int captionToHide, int captionToShow) {
        TextView captionViewDisplayed;
        TextView captionViewToShow;
        if (captionToHide == captionToShow) {
            return;
        }
        if (captionToShow != 0 && (captionViewToShow = l(captionToShow)) != null) {
            captionViewToShow.setVisibility(0);
            captionViewToShow.setAlpha(1.0f);
        }
        if (captionToHide != 0 && (captionViewDisplayed = l(captionToHide)) != null) {
            captionViewDisplayed.setVisibility(4);
            if (captionToHide == 1) {
                captionViewDisplayed.setText((CharSequence) null);
            }
        }
        this.h = captionToShow;
    }

    public final void h(List<Animator> captionAnimatorList, boolean captionEnabled, TextView captionView, int captionState, int captionToHide, int captionToShow) {
        if (captionView == null || !captionEnabled) {
            return;
        }
        if (captionState == captionToShow || captionState == captionToHide) {
            captionAnimatorList.add(i(captionView, captionToShow == captionState));
            if (captionToShow == captionState) {
                captionAnimatorList.add(j(captionView));
            }
        }
    }

    public final ObjectAnimator i(TextView captionView, boolean display) {
        float endValue = display ? 1.0f : 0.0f;
        ObjectAnimator opacityAnimator = ObjectAnimator.ofFloat(captionView, (Property<TextView, Float>) View.ALPHA, endValue);
        opacityAnimator.setDuration(167L);
        opacityAnimator.setInterpolator(b.b.a.a.b.a.f977a);
        return opacityAnimator;
    }

    public final ObjectAnimator j(TextView captionView) {
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(captionView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.g, 0.0f);
        translationYAnimator.setDuration(217L);
        translationYAnimator.setInterpolator(b.b.a.a.b.a.d);
        return translationYAnimator;
    }

    public void g() {
        Animator animator = this.f;
        if (animator != null) {
            animator.cancel();
        }
    }

    public boolean w(int index) {
        return index == 0 || index == 1;
    }

    public final TextView l(int captionDisplayState) {
        switch (captionDisplayState) {
            case 1:
                return this.l;
            case 2:
                return this.r;
            default:
                return null;
        }
    }

    public void e() {
        if (f()) {
            EditText editText = this.f968b.getEditText();
            boolean isFontScaleLarge = b.b.a.a.u.c.g(this.f967a);
            v.A0(this.c, s(isFontScaleLarge, R.dimen.material_helper_text_font_1_3_padding_horizontal, v.I(editText)), s(isFontScaleLarge, R.dimen.material_helper_text_font_1_3_padding_top, this.f967a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), s(isFontScaleLarge, R.dimen.material_helper_text_font_1_3_padding_horizontal, v.H(editText)), 0);
        }
    }

    public final boolean f() {
        return (this.c == null || this.f968b.getEditText() == null) ? false : true;
    }

    public final int s(boolean isFontScaleLarge, int largeFontPaddingRes, int defaultPadding) {
        return isFontScaleLarge ? this.f967a.getResources().getDimensionPixelSize(largeFontPaddingRes) : defaultPadding;
    }

    public void d(TextView indicator, int index) {
        if (this.c == null && this.e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f967a);
            this.c = linearLayout;
            linearLayout.setOrientation(0);
            this.f968b.addView(this.c, -1, -2);
            this.e = new FrameLayout(this.f967a);
            LinearLayout.LayoutParams captionAreaLp = new LinearLayout.LayoutParams(0, -2, 1.0f);
            this.c.addView(this.e, captionAreaLp);
            if (this.f968b.getEditText() != null) {
                e();
            }
        }
        if (w(index)) {
            this.e.setVisibility(0);
            this.e.addView(indicator);
        } else {
            LinearLayout.LayoutParams indicatorAreaLp = new LinearLayout.LayoutParams(-2, -2);
            this.c.addView(indicator, indicatorAreaLp);
        }
        this.c.setVisibility(0);
        this.d++;
    }

    public void z(TextView indicator, int index) {
        FrameLayout frameLayout;
        if (this.c == null) {
            return;
        }
        if (w(index) && (frameLayout = this.e) != null) {
            frameLayout.removeView(indicator);
        } else {
            this.c.removeView(indicator);
        }
        int i = this.d - 1;
        this.d = i;
        K(this.c, i);
    }

    public final void K(ViewGroup viewGroup, int indicatorsAdded) {
        if (indicatorsAdded == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void C(boolean enabled) {
        if (this.k == enabled) {
            return;
        }
        g();
        if (enabled) {
            a0 a0Var = new a0(this.f967a);
            this.l = a0Var;
            a0Var.setId(R.id.textinput_error);
            if (Build.VERSION.SDK_INT >= 17) {
                this.l.setTextAlignment(5);
            }
            Typeface typeface = this.u;
            if (typeface != null) {
                this.l.setTypeface(typeface);
            }
            D(this.n);
            E(this.o);
            B(this.m);
            this.l.setVisibility(4);
            v.q0(this.l, 1);
            d(this.l, 0);
        } else {
            t();
            z(this.l, 0);
            this.l = null;
            this.f968b.s0();
            this.f968b.F0();
        }
        this.k = enabled;
    }

    public boolean x() {
        return this.k;
    }

    public boolean y() {
        return this.q;
    }

    public void G(boolean enabled) {
        if (this.q == enabled) {
            return;
        }
        g();
        if (enabled) {
            a0 a0Var = new a0(this.f967a);
            this.r = a0Var;
            a0Var.setId(R.id.textinput_helper_text);
            if (Build.VERSION.SDK_INT >= 17) {
                this.r.setTextAlignment(5);
            }
            Typeface typeface = this.u;
            if (typeface != null) {
                this.r.setTypeface(typeface);
            }
            this.r.setVisibility(4);
            v.q0(this.r, 1);
            F(this.s);
            H(this.t);
            d(this.r, 1);
        } else {
            u();
            z(this.r, 1);
            this.r = null;
            this.f968b.s0();
            this.f968b.F0();
        }
        this.q = enabled;
    }

    public boolean k() {
        return v(this.i);
    }

    public final boolean v(int captionState) {
        return (captionState != 1 || this.l == null || TextUtils.isEmpty(this.j)) ? false : true;
    }

    public CharSequence n() {
        return this.j;
    }

    public CharSequence q() {
        return this.p;
    }

    public void J(Typeface typeface) {
        if (typeface != this.u) {
            this.u = typeface;
            I(this.l, typeface);
            I(this.r, typeface);
        }
    }

    public final void I(TextView captionView, Typeface typeface) {
        if (captionView != null) {
            captionView.setTypeface(typeface);
        }
    }

    public int o() {
        TextView textView = this.l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public ColorStateList p() {
        TextView textView = this.l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public void E(ColorStateList errorViewTextColor) {
        this.o = errorViewTextColor;
        TextView textView = this.l;
        if (textView != null && errorViewTextColor != null) {
            textView.setTextColor(errorViewTextColor);
        }
    }

    public void D(int resId) {
        this.n = resId;
        TextView textView = this.l;
        if (textView != null) {
            this.f968b.e0(textView, resId);
        }
    }

    public void B(CharSequence errorContentDescription) {
        this.m = errorContentDescription;
        TextView textView = this.l;
        if (textView != null) {
            textView.setContentDescription(errorContentDescription);
        }
    }

    public CharSequence m() {
        return this.m;
    }

    public int r() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public void H(ColorStateList helperTextViewTextColor) {
        this.t = helperTextViewTextColor;
        TextView textView = this.r;
        if (textView != null && helperTextViewTextColor != null) {
            textView.setTextColor(helperTextViewTextColor);
        }
    }

    public void F(int resId) {
        this.s = resId;
        TextView textView = this.r;
        if (textView != null) {
            a.h.l.i.n(textView, resId);
        }
    }
}
