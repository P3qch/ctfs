package a.f.a.k;

import a.f.a.k.m.b;
import java.util.HashSet;

/* loaded from: classes.dex */
public class k extends i {
    public boolean w0 = false;

    public k() {
        new b.a();
    }

    public boolean m1() {
        return false;
    }

    @Override // a.f.a.k.i, a.f.a.k.h
    public void a(f container) {
        k1();
    }

    public void k1() {
        for (int i = 0; i < this.v0; i++) {
            e widget = this.u0[i];
            if (widget != null) {
                widget.J0(true);
            }
        }
    }

    public boolean l1(HashSet<e> hashSet) {
        for (int i = 0; i < this.v0; i++) {
            e widget = this.u0[i];
            if (hashSet.contains(widget)) {
                return true;
            }
        }
        return false;
    }
}
