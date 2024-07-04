package b.b.a.a.a0;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class i extends e {
    public final TextWatcher d;
    public final TextInputLayout.f e;
    public final TextInputLayout.g f;

    /* loaded from: classes.dex */
    public class a extends b.b.a.a.r.i {
        public a() {
        }

        @Override // b.b.a.a.r.i, android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            i.this.c.setChecked(!r0.g());
        }
    }

    /* loaded from: classes.dex */
    public class b implements TextInputLayout.f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            i iVar = i.this;
            iVar.c.setChecked(true ^ iVar.g());
            editText.removeTextChangedListener(i.this.d);
            editText.addTextChangedListener(i.this.d);
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextInputLayout.g {
        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int previousIcon) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && previousIcon == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.post(new a(editText));
            }
        }

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ EditText f975b;

            public a(EditText editText) {
                this.f975b = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f975b.removeTextChangedListener(i.this.d);
            }
        }
    }

    public i(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new a();
        this.e = new b();
        this.f = new c();
    }

    @Override // b.b.a.a.a0.e
    public void a() {
        this.f965a.setEndIconDrawable(a.b.c.a.a.d(this.f966b, R.drawable.design_password_eye));
        TextInputLayout textInputLayout = this.f965a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        this.f965a.setEndIconOnClickListener(new d());
        this.f965a.e(this.e);
        this.f965a.f(this.f);
        EditText editText = this.f965a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            EditText editText = i.this.f965a.getEditText();
            if (editText == null) {
                return;
            }
            int selection = editText.getSelectionEnd();
            if (i.this.g()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selection >= 0) {
                editText.setSelection(selection);
            }
            i.this.f965a.V();
        }
    }

    public final boolean g() {
        EditText editText = this.f965a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    public static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }
}
