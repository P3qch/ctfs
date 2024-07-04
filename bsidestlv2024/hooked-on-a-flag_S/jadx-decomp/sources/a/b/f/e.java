package a.b.f;

import a.b.f.b;
import a.b.f.j.g;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements g.a {
    public Context d;
    public ActionBarContextView e;
    public b.a f;
    public WeakReference<View> g;
    public boolean h;
    public a.b.f.j.g i;

    public e(Context context, ActionBarContextView view, b.a callback, boolean isFocusable) {
        this.d = context;
        this.e = view;
        this.f = callback;
        a.b.f.j.g gVar = new a.b.f.j.g(view.getContext());
        gVar.S(1);
        this.i = gVar;
        gVar.R(this);
    }

    @Override // a.b.f.b
    public void r(CharSequence title) {
        this.e.setTitle(title);
    }

    @Override // a.b.f.b
    public void o(CharSequence subtitle) {
        this.e.setSubtitle(subtitle);
    }

    @Override // a.b.f.b
    public void q(int resId) {
        r(this.d.getString(resId));
    }

    @Override // a.b.f.b
    public void n(int resId) {
        o(this.d.getString(resId));
    }

    @Override // a.b.f.b
    public void s(boolean titleOptional) {
        super.s(titleOptional);
        this.e.setTitleOptional(titleOptional);
    }

    @Override // a.b.f.b
    public boolean l() {
        return this.e.j();
    }

    @Override // a.b.f.b
    public void m(View view) {
        this.e.setCustomView(view);
        this.g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // a.b.f.b
    public void k() {
        this.f.a(this, this.i);
    }

    @Override // a.b.f.b
    public void c() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.e.sendAccessibilityEvent(32);
        this.f.b(this);
    }

    @Override // a.b.f.b
    public Menu e() {
        return this.i;
    }

    @Override // a.b.f.b
    public CharSequence i() {
        return this.e.getTitle();
    }

    @Override // a.b.f.b
    public CharSequence g() {
        return this.e.getSubtitle();
    }

    @Override // a.b.f.b
    public View d() {
        WeakReference<View> weakReference = this.g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // a.b.f.b
    public MenuInflater f() {
        return new g(this.e.getContext());
    }

    @Override // a.b.f.j.g.a
    public boolean b(a.b.f.j.g menu, MenuItem item) {
        return this.f.c(this, item);
    }

    @Override // a.b.f.j.g.a
    public void a(a.b.f.j.g menu) {
        k();
        this.e.l();
    }
}
