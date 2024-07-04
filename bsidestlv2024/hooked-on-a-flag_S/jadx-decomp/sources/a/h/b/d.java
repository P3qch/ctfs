package a.h.b;

import a.h.k.f;
import a.m.d;
import a.m.h;
import a.m.o;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

/* loaded from: classes.dex */
public class d extends Activity implements a.m.g, f.a {

    /* renamed from: b, reason: collision with root package name */
    public h f347b;

    public d() {
        new a.e.g();
        this.f347b = new h(this);
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        o.f(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        this.f347b.j(d.b.CREATED);
        super.onSaveInstanceState(outState);
    }

    @Override // a.h.k.f.a
    public boolean i(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        View decor = getWindow().getDecorView();
        if (decor != null && a.h.k.f.d(decor, event)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        View decor = getWindow().getDecorView();
        if (decor != null && a.h.k.f.d(decor, event)) {
            return true;
        }
        return a.h.k.f.e(this, decor, this, event);
    }
}
