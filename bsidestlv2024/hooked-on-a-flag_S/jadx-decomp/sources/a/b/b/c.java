package a.b.b;

import a.b.f.b;
import a.b.g.d1;
import a.h.b.g;
import a.m.u;
import a.m.v;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
public class c extends a.k.b.e implements d, g.a {
    public e n;
    public Resources o;

    public c() {
        B();
    }

    /* loaded from: classes.dex */
    public class a implements SavedStateRegistry.b {
        public a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            Bundle outState = new Bundle();
            c.this.z().u(outState);
            return outState;
        }
    }

    public final void B() {
        d().d("androidx:appcompat", new a());
        m(new b());
    }

    /* loaded from: classes.dex */
    public class b implements a.a.d.b {
        public b() {
        }

        @Override // a.a.d.b
        public void a(Context context) {
            e delegate = c.this.z();
            delegate.n();
            delegate.q(c.this.d().a("androidx:appcompat"));
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(z().f(newBase));
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int resId) {
        super.setTheme(resId);
        z().D(resId);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        z().s(savedInstanceState);
    }

    public a.b.b.a A() {
        return z().m();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return z().l();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int layoutResID) {
        o();
        z().A(layoutResID);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        o();
        z().B(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        o();
        z().C(view, params);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        o();
        z().d(view, params);
    }

    private void o() {
        u.a(getWindow().getDecorView(), this);
        v.a(getWindow().getDecorView(), this);
        a.p.c.a(getWindow().getDecorView(), this);
    }

    @Override // a.k.b.e, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        z().p(newConfig);
    }

    @Override // a.k.b.e, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        z().t();
    }

    @Override // a.k.b.e, android.app.Activity
    public void onStart() {
        super.onStart();
        z().v();
    }

    @Override // a.k.b.e, android.app.Activity
    public void onStop() {
        super.onStop();
        z().w();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) z().i(i);
    }

    @Override // a.k.b.e, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }
        a.b.b.a ab = A();
        if (item.getItemId() == 16908332 && ab != null && (ab.d() & 4) != 0) {
            return G();
        }
        return false;
    }

    @Override // a.k.b.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        z().r();
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        z().E(title);
    }

    @Override // a.k.b.e
    public void y() {
        z().o();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        z().o();
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

    public void C(a.h.b.g builder) {
        builder.b(this);
    }

    public void E() {
    }

    public boolean G() {
        Intent upIntent = j();
        if (upIntent != null) {
            if (J(upIntent)) {
                a.h.b.g b2 = a.h.b.g.d(this);
                C(b2);
                E();
                b2.e();
                try {
                    a.h.b.a.f(this);
                    return true;
                } catch (IllegalStateException e) {
                    finish();
                    return true;
                }
            }
            I(upIntent);
            return true;
        }
        return false;
    }

    @Override // a.h.b.g.a
    public Intent j() {
        return a.h.b.e.a(this);
    }

    public boolean J(Intent targetIntent) {
        return a.h.b.e.f(this, targetIntent);
    }

    public void I(Intent upIntent) {
        a.h.b.e.e(this, upIntent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        F();
    }

    @Deprecated
    public void F() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override // a.k.b.e, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
    }

    public e z() {
        if (this.n == null) {
            this.n = e.g(this, this);
        }
        return this.n;
    }

    @Override // a.h.b.d, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        a.b.b.a actionBar = A();
        if (keyCode == 82 && actionBar != null) {
            actionBar.j();
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.o == null) {
            d1.b();
        }
        Resources resources = this.o;
        return resources == null ? super.getResources() : resources;
    }

    public final boolean H(KeyEvent event) {
        Window currentWindow;
        if (Build.VERSION.SDK_INT < 26 && !event.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(event.getMetaState()) && event.getRepeatCount() == 0 && !KeyEvent.isModifierKey(event.getKeyCode()) && (currentWindow = getWindow()) != null && currentWindow.getDecorView() != null) {
            View decorView = currentWindow.getDecorView();
            if (decorView.dispatchKeyShortcutEvent(event)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (H(event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a.b.b.a actionBar = A();
        if (getWindow().hasFeature(0)) {
            if (actionBar != null) {
                actionBar.k();
            }
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a.b.b.a actionBar = A();
        if (getWindow().hasFeature(0)) {
            if (actionBar != null) {
                actionBar.a();
            }
            super.closeOptionsMenu();
        }
    }

    public void D() {
    }
}
