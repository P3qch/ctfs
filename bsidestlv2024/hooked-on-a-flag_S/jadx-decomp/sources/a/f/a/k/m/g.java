package a.f.a.k.m;

import a.f.a.k.m.f;

/* loaded from: classes.dex */
public class g extends f {
    public int m;

    public g(p run) {
        super(run);
        if (run instanceof l) {
            this.e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // a.f.a.k.m.f
    public void d(int value) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = value;
        for (d node : this.k) {
            node.a(node);
        }
    }
}
