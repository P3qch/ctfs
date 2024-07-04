package a.f.a.k;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class l extends e {
    public ArrayList<e> u0 = new ArrayList<>();

    @Override // a.f.a.k.e
    public void m0() {
        this.u0.clear();
        super.m0();
    }

    public void g1(e widget) {
        this.u0.add(widget);
        if (widget.G() != null) {
            l container = (l) widget.G();
            container.j1(widget);
        }
        widget.R0(this);
    }

    public void j1(e widget) {
        this.u0.remove(widget);
        widget.m0();
    }

    public ArrayList<e> h1() {
        return this.u0;
    }

    public void i1() {
        ArrayList<e> arrayList = this.u0;
        if (arrayList == null) {
            return;
        }
        int count = arrayList.size();
        for (int i = 0; i < count; i++) {
            e widget = this.u0.get(i);
            if (widget instanceof l) {
                ((l) widget).i1();
            }
        }
    }

    @Override // a.f.a.k.e
    public void o0(a.f.a.c cache) {
        super.o0(cache);
        int count = this.u0.size();
        for (int i = 0; i < count; i++) {
            e widget = this.u0.get(i);
            widget.o0(cache);
        }
    }

    public void k1() {
        this.u0.clear();
    }
}
