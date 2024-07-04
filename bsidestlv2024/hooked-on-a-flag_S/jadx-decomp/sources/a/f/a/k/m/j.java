package a.f.a.k.m;

/* loaded from: classes.dex */
public class j extends p {
    public j(a.f.a.k.e widget) {
        super(widget);
        widget.e.f();
        widget.f.f();
        this.f = ((a.f.a.k.g) widget).h1();
    }

    @Override // a.f.a.k.m.p
    public void f() {
        this.h.c();
    }

    @Override // a.f.a.k.m.p
    public boolean m() {
        return false;
    }

    public final void q(f node) {
        this.h.k.add(node);
        node.l.add(this.h);
    }

    @Override // a.f.a.k.m.p, a.f.a.k.m.d
    public void a(d dependency) {
        f fVar = this.h;
        if (!fVar.c || fVar.j) {
            return;
        }
        f startTarget = fVar.l.get(0);
        a.f.a.k.g guideline = (a.f.a.k.g) this.f295b;
        int startPos = (int) ((startTarget.g * guideline.k1()) + 0.5f);
        this.h.d(startPos);
    }

    @Override // a.f.a.k.m.p
    public void d() {
        a.f.a.k.g guideline = (a.f.a.k.g) this.f295b;
        int relativeBegin = guideline.i1();
        int relativeEnd = guideline.j1();
        guideline.k1();
        if (guideline.h1() == 1) {
            if (relativeBegin != -1) {
                this.h.l.add(this.f295b.X.e.h);
                this.f295b.X.e.h.k.add(this.h);
                this.h.f = relativeBegin;
            } else if (relativeEnd != -1) {
                this.h.l.add(this.f295b.X.e.i);
                this.f295b.X.e.i.k.add(this.h);
                this.h.f = -relativeEnd;
            } else {
                f fVar = this.h;
                fVar.f286b = true;
                fVar.l.add(this.f295b.X.e.i);
                this.f295b.X.e.i.k.add(this.h);
            }
            q(this.f295b.e.h);
            q(this.f295b.e.i);
            return;
        }
        if (relativeBegin != -1) {
            this.h.l.add(this.f295b.X.f.h);
            this.f295b.X.f.h.k.add(this.h);
            this.h.f = relativeBegin;
        } else if (relativeEnd != -1) {
            this.h.l.add(this.f295b.X.f.i);
            this.f295b.X.f.i.k.add(this.h);
            this.h.f = -relativeEnd;
        } else {
            f fVar2 = this.h;
            fVar2.f286b = true;
            fVar2.l.add(this.f295b.X.f.i);
            this.f295b.X.f.i.k.add(this.h);
        }
        q(this.f295b.f.h);
        q(this.f295b.f.i);
    }

    @Override // a.f.a.k.m.p
    public void e() {
        a.f.a.k.g guideline = (a.f.a.k.g) this.f295b;
        if (guideline.h1() == 1) {
            this.f295b.b1(this.h.g);
        } else {
            this.f295b.c1(this.h.g);
        }
    }
}
