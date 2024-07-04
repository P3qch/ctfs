package a.k.b;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final k<?> f558a;

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<?> */
    public static i b(k<?> kVar) {
        a.h.j.i.f(kVar, "callbacks == null");
        return new i(kVar);
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<?> */
    public i(k<?> kVar) {
        this.f558a = kVar;
    }

    public n t() {
        return this.f558a.e;
    }

    public void a(Fragment parent) {
        k<?> kVar = this.f558a;
        kVar.e.h(kVar, kVar, parent);
    }

    public View v(View parent, String name, Context context, AttributeSet attrs) {
        return ((l) this.f558a.e.p0()).onCreateView(parent, name, context, attrs);
    }

    public void u() {
        this.f558a.e.J0();
    }

    public Parcelable x() {
        return this.f558a.e.W0();
    }

    public void w(Parcelable state) {
        k<?> kVar = this.f558a;
        if (!(kVar instanceof a.m.t)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        kVar.e.U0(state);
    }

    public void f() {
        this.f558a.e.y();
    }

    public void c() {
        this.f558a.e.u();
    }

    public void q() {
        this.f558a.e.N();
    }

    public void p() {
        this.f558a.e.M();
    }

    public void m() {
        this.f558a.e.I();
    }

    public void r() {
        this.f558a.e.P();
    }

    public void h() {
        this.f558a.e.A();
    }

    public void j(boolean isInMultiWindowMode) {
        this.f558a.e.D(isInMultiWindowMode);
    }

    public void n(boolean isInPictureInPictureMode) {
        this.f558a.e.J(isInPictureInPictureMode);
    }

    public void d(Configuration newConfig) {
        this.f558a.e.w(newConfig);
    }

    public void i() {
        this.f558a.e.C();
    }

    public boolean g(Menu menu, MenuInflater inflater) {
        return this.f558a.e.z(menu, inflater);
    }

    public boolean o(Menu menu) {
        return this.f558a.e.K(menu);
    }

    public boolean k(MenuItem item) {
        return this.f558a.e.F(item);
    }

    public boolean e(MenuItem item) {
        return this.f558a.e.x(item);
    }

    public void l(Menu menu) {
        this.f558a.e.G(menu);
    }

    public boolean s() {
        return this.f558a.e.W(true);
    }
}
