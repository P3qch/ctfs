package b.b.a.a.c;

import a.h.k.v;
import android.view.View;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final View f997a;

    /* renamed from: b, reason: collision with root package name */
    public int f998b;
    public int c;
    public int d;
    public int e;
    public boolean f = true;
    public boolean g = true;

    public d(View view) {
        this.f997a = view;
    }

    public void c() {
        this.f998b = this.f997a.getTop();
        this.c = this.f997a.getLeft();
    }

    public void a() {
        View view = this.f997a;
        v.Z(view, this.d - (view.getTop() - this.f998b));
        View view2 = this.f997a;
        v.Y(view2, this.e - (view2.getLeft() - this.c));
    }

    public boolean e(int offset) {
        if (this.d != offset) {
            this.d = offset;
            a();
            return true;
        }
        return false;
    }

    public boolean d(int offset) {
        if (this.e != offset) {
            this.e = offset;
            a();
            return true;
        }
        return false;
    }

    public int b() {
        return this.d;
    }
}
