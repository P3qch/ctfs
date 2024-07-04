package b.b.a.a.a0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class a extends b.b.a.a.a0.e {
    public final TextWatcher d;
    public final View.OnFocusChangeListener e;
    public final TextInputLayout.f f;
    public final TextInputLayout.g g;
    public AnimatorSet h;
    public ValueAnimator i;

    /* renamed from: b.b.a.a.a0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0058a implements TextWatcher {
        public C0058a() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            if (a.this.f965a.getSuffixText() != null) {
                return;
            }
            a aVar = a.this;
            aVar.i(aVar.f965a.hasFocus() && a.l(s));
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View v, boolean hasFocus) {
            boolean hasText = !TextUtils.isEmpty(((EditText) v).getText());
            a.this.i(hasText && hasFocus);
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextInputLayout.f {
        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && a.l(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.e);
            editText.removeTextChangedListener(a.this.d);
            editText.addTextChangedListener(a.this.d);
        }
    }

    /* loaded from: classes.dex */
    public class d implements TextInputLayout.g {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int previousIcon) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && previousIcon == 2) {
                editText.post(new RunnableC0059a(editText));
                if (editText.getOnFocusChangeListener() == a.this.e) {
                    editText.setOnFocusChangeListener(null);
                }
            }
        }

        /* renamed from: b.b.a.a.a0.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0059a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ EditText f948b;

            public RunnableC0059a(EditText editText) {
                this.f948b = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f948b.removeTextChangedListener(a.this.d);
            }
        }
    }

    public a(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new C0058a();
        this.e = new b();
        this.f = new c();
        this.g = new d();
    }

    @Override // b.b.a.a.a0.e
    public void a() {
        this.f965a.setEndIconDrawable(a.b.c.a.a.d(this.f966b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f965a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.f965a.setEndIconOnClickListener(new e());
        this.f965a.e(this.f);
        this.f965a.f(this.g);
        m();
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Editable text = a.this.f965a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.f965a.V();
        }
    }

    @Override // b.b.a.a.a0.e
    public void c(boolean visible) {
        if (this.f965a.getSuffixText() == null) {
            return;
        }
        i(visible);
    }

    public final void i(boolean show) {
        boolean shouldSkipAnimation = this.f965a.K() == show;
        if (show && !this.h.isRunning()) {
            this.i.cancel();
            this.h.start();
            if (shouldSkipAnimation) {
                this.h.end();
                return;
            }
            return;
        }
        if (!show) {
            this.h.cancel();
            this.i.start();
            if (shouldSkipAnimation) {
                this.i.end();
            }
        }
    }

    public final void m() {
        ValueAnimator scaleAnimator = k();
        ValueAnimator fadeAnimator = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.h = animatorSet;
        animatorSet.playTogether(scaleAnimator, fadeAnimator);
        this.h.addListener(new f());
        ValueAnimator j = j(1.0f, 0.0f);
        this.i = j;
        j.addListener(new g());
    }

    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            a.this.f965a.setEndIconVisible(true);
        }
    }

    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            a.this.f965a.setEndIconVisible(false);
        }
    }

    public final ValueAnimator j(float... values) {
        ValueAnimator animator = ValueAnimator.ofFloat(values);
        animator.setInterpolator(b.b.a.a.b.a.f977a);
        animator.setDuration(100L);
        animator.addUpdateListener(new h());
        return animator;
    }

    /* loaded from: classes.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            float alpha = ((Float) animation.getAnimatedValue()).floatValue();
            a.this.c.setAlpha(alpha);
        }
    }

    public final ValueAnimator k() {
        ValueAnimator animator = ValueAnimator.ofFloat(0.8f, 1.0f);
        animator.setInterpolator(b.b.a.a.b.a.d);
        animator.setDuration(150L);
        animator.addUpdateListener(new i());
        return animator;
    }

    /* loaded from: classes.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            float scale = ((Float) animation.getAnimatedValue()).floatValue();
            a.this.c.setScaleX(scale);
            a.this.c.setScaleY(scale);
        }
    }

    public static boolean l(Editable editable) {
        return editable.length() > 0;
    }
}
