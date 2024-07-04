package b.b.a.a.a0;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public TextInputLayout f965a;

    /* renamed from: b, reason: collision with root package name */
    public Context f966b;
    public CheckableImageButton c;

    public abstract void a();

    public e(TextInputLayout textInputLayout) {
        this.f965a = textInputLayout;
        this.f966b = textInputLayout.getContext();
        this.c = textInputLayout.getEndIconView();
    }

    public boolean d() {
        return false;
    }

    public boolean b(int boxBackgroundMode) {
        return true;
    }

    public void c(boolean visible) {
    }
}
