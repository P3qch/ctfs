package a.f.a.k;

import a.f.a.k.m.o;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class i extends e implements h {
    public e[] u0 = new e[4];
    public int v0 = 0;

    @Override // a.f.a.k.h
    public void a(f container) {
    }

    public void g1(e widget) {
        if (widget == this || widget == null) {
            return;
        }
        int i = this.v0 + 1;
        e[] eVarArr = this.u0;
        if (i > eVarArr.length) {
            this.u0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.u0;
        int i2 = this.v0;
        eVarArr2[i2] = widget;
        this.v0 = i2 + 1;
    }

    public void j1() {
        this.v0 = 0;
        Arrays.fill(this.u0, (Object) null);
    }

    public void h1(ArrayList<o> arrayList, int orientation, o group) {
        for (int i = 0; i < this.v0; i++) {
            e widget = this.u0[i];
            group.a(widget);
        }
        for (int i2 = 0; i2 < this.v0; i2++) {
            e widget2 = this.u0[i2];
            a.f.a.k.m.i.a(widget2, orientation, arrayList, group);
        }
    }

    public int i1(int orientation) {
        int i;
        int i2;
        for (int i3 = 0; i3 < this.v0; i3++) {
            e widget = this.u0[i3];
            if (orientation == 0 && (i2 = widget.s0) != -1) {
                return i2;
            }
            if (orientation == 1 && (i = widget.t0) != -1) {
                return i;
            }
        }
        return -1;
    }
}
