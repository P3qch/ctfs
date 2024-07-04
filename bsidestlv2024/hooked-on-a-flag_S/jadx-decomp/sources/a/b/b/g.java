package a.b.b;

import a.b.f.b;
import a.h.k.f;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class g extends Dialog implements d {

    /* renamed from: b, reason: collision with root package name */
    public e f37b;
    public final f.a c;

    /* loaded from: classes.dex */
    public class a implements f.a {
        public a() {
        }

        @Override // a.h.k.f.a
        public boolean i(KeyEvent event) {
            return g.this.d(event);
        }
    }

    public g(Context context, int theme) {
        super(context, c(context, theme));
        this.c = new a();
        e delegate = a();
        delegate.D(c(context, theme));
        delegate.q(null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        a().n();
        super.onCreate(savedInstanceState);
        a().q(savedInstanceState);
    }

    @Override // android.app.Dialog
    public void setContentView(int layoutResID) {
        a().A(layoutResID);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().B(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        a().C(view, params);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) a().i(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        a().E(title);
    }

    @Override // android.app.Dialog
    public void setTitle(int titleId) {
        super.setTitle(titleId);
        a().E(getContext().getString(titleId));
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        a().d(view, params);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        a().w();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a().r();
    }

    public boolean e(int featureId) {
        return a().z(featureId);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().o();
    }

    public e a() {
        if (this.f37b == null) {
            this.f37b = e.h(this, this);
        }
        return this.f37b;
    }

    public static int c(Context context, int themeId) {
        if (themeId == 0) {
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, outValue, true);
            return outValue.resourceId;
        }
        return themeId;
    }

    @Override // a.b.b.d
    public void b(a.b.f.b mode) {
    }

    @Override // a.b.b.d
    public void f(a.b.f.b mode) {
    }

    @Override // a.b.b.d
    public a.b.f.b h(b.a callback) {
        return null;
    }

    public boolean d(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        View decor = getWindow().getDecorView();
        return a.h.k.f.e(this.c, decor, this, event);
    }
}
