package a.k.b;

import a.m.d;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
public class z implements a.p.b, a.m.t {

    /* renamed from: b, reason: collision with root package name */
    public final a.m.s f611b;
    public a.m.h c = null;
    public a.p.a d = null;

    public z(Fragment fragment, a.m.s viewModelStore) {
        this.f611b = viewModelStore;
    }

    @Override // a.m.t
    public a.m.s e() {
        f();
        return this.f611b;
    }

    public void f() {
        if (this.c == null) {
            this.c = new a.m.h(this);
            this.d = a.p.a.a(this);
        }
    }

    public boolean g() {
        return this.c != null;
    }

    @Override // a.m.g
    public a.m.d a() {
        f();
        return this.c;
    }

    public void j(d.b state) {
        this.c.o(state);
    }

    public void b(d.a event) {
        this.c.h(event);
    }

    @Override // a.p.b
    public SavedStateRegistry d() {
        f();
        return this.d.b();
    }

    public void h(Bundle savedState) {
        this.d.c(savedState);
    }

    public void i(Bundle outBundle) {
        this.d.d(outBundle);
    }
}
