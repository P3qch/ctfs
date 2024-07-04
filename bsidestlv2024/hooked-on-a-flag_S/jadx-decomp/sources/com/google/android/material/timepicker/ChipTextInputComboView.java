package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import b.b.a.a.c0.c;
import b.b.a.a.r.i;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: b, reason: collision with root package name */
    public final Chip f1198b;
    public final TextInputLayout c;
    public final EditText d;
    public TextWatcher e;

    public ChipTextInputComboView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChipTextInputComboView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        Chip chip = (Chip) inflater.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f1198b = chip;
        TextInputLayout textInputLayout = (TextInputLayout) inflater.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.c = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.d = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.e = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        editText.setSaveEnabled(false);
    }

    public final void d() {
        if (Build.VERSION.SDK_INT >= 24) {
            Configuration configuration = getContext().getResources().getConfiguration();
            LocaleList locales = configuration.getLocales();
            this.d.setImeHintLocales(locales);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f1198b.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        this.f1198b.setChecked(checked);
        this.d.setVisibility(checked ? 0 : 4);
        this.f1198b.setVisibility(checked ? 8 : 0);
        if (isChecked()) {
            this.d.requestFocus();
            if (!TextUtils.isEmpty(this.d.getText())) {
                EditText editText = this.d;
                editText.setSelection(editText.getText().length());
            }
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f1198b.toggle();
    }

    public final String c(CharSequence text) {
        return c.j(getResources(), text);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.f1198b.setOnClickListener(l);
    }

    @Override // android.view.View
    public void setTag(int key, Object tag) {
        this.f1198b.setTag(key, tag);
    }

    /* loaded from: classes.dex */
    public class b extends i {
        public b() {
        }

        @Override // b.b.a.a.r.i, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f1198b.setText(ChipTextInputComboView.this.c("00"));
            } else {
                ChipTextInputComboView.this.f1198b.setText(ChipTextInputComboView.this.c(editable));
            }
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        d();
    }
}
