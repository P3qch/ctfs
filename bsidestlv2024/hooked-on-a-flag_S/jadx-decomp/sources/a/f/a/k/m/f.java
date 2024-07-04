package a.f.a.k.m;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f implements d {
    public p d;
    public int f;
    public int g;

    /* renamed from: a, reason: collision with root package name */
    public d f285a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f286b = false;
    public boolean c = false;
    public a e = a.UNKNOWN;
    public int h = 1;
    public g i = null;
    public boolean j = false;
    public List<d> k = new ArrayList();
    public List<f> l = new ArrayList();

    /* loaded from: classes.dex */
    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p run) {
        this.d = run;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.f295b.p());
        sb.append(":");
        sb.append(this.e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }

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

    @Override // a.f.a.k.m.d
    public void a(d node) {
        for (f target : this.l) {
            if (!target.j) {
                return;
            }
        }
        this.c = true;
        d dVar = this.f285a;
        if (dVar != null) {
            dVar.a(this);
        }
        if (this.f286b) {
            this.d.a(this);
            return;
        }
        f target2 = null;
        int numTargets = 0;
        for (f t : this.l) {
            if (!(t instanceof g)) {
                target2 = t;
                numTargets++;
            }
        }
        if (target2 != null && numTargets == 1 && target2.j) {
            g gVar = this.i;
            if (gVar != null) {
                if (gVar.j) {
                    this.f = this.h * gVar.g;
                } else {
                    return;
                }
            }
            d(target2.g + this.f);
        }
        d dVar2 = this.f285a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
    }

    public void b(d dependency) {
        this.k.add(dependency);
        if (this.j) {
            dependency.a(dependency);
        }
    }

    public void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.f286b = false;
    }
}
