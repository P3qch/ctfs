package a.f.a.k.m;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c extends p {
    public ArrayList<p> k;
    public int l;

    public c(a.f.a.k.e widget, int orientation) {
        super(widget);
        this.k = new ArrayList<>();
        this.f = orientation;
        q();
    }

    public String toString() {
        StringBuilder log = new StringBuilder("ChainRun ");
        log.append(this.f == 0 ? "horizontal : " : "vertical : ");
        Iterator<p> it = this.k.iterator();
        while (it.hasNext()) {
            p run = it.next();
            log.append("<");
            log.append(run);
            log.append("> ");
        }
        return log.toString();
    }

    @Override // a.f.a.k.m.p
    public boolean m() {
        int count = this.k.size();
        for (int i = 0; i < count; i++) {
            p run = this.k.get(i);
            if (!run.m()) {
                return false;
            }
        }
        return true;
    }

    @Override // a.f.a.k.m.p
    public long j() {
        int count = this.k.size();
        long wrapDimension = 0;
        for (int i = 0; i < count; i++) {
            p run = this.k.get(i);
            wrapDimension = wrapDimension + run.h.f + run.j() + run.i.f;
        }
        return wrapDimension;
    }

    public final void q() {
        a.f.a.k.e current = this.f295b;
        a.f.a.k.e previous = current.H(this.f);
        while (previous != null) {
            current = previous;
            previous = current.H(this.f);
        }
        this.f295b = current;
        this.k.add(current.J(this.f));
        a.f.a.k.e next = current.F(this.f);
        while (next != null) {
            a.f.a.k.e current2 = next;
            this.k.add(current2.J(this.f));
            next = current2.F(this.f);
        }
        Iterator<p> it = this.k.iterator();
        while (it.hasNext()) {
            p run = it.next();
            int i = this.f;
            if (i == 0) {
                run.f295b.c = this;
            } else if (i == 1) {
                run.f295b.d = this;
            }
        }
        boolean isInRtl = this.f == 0 && ((a.f.a.k.f) this.f295b.G()).E1();
        if (isInRtl && this.k.size() > 1) {
            ArrayList<p> arrayList = this.k;
            this.f295b = arrayList.get(arrayList.size() - 1).f295b;
        }
        this.l = this.f == 0 ? this.f295b.v() : this.f295b.L();
    }

    @Override // a.f.a.k.m.p
    public void f() {
        this.c = null;
        Iterator<p> it = this.k.iterator();
        while (it.hasNext()) {
            p run = it.next();
            run.f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:296:0x045e, code lost:
    
        r6 = r6 - r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0  */
    @Override // a.f.a.k.m.p, a.f.a.k.m.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(a.f.a.k.m.d r28) {
        /*
            Method dump skipped, instructions count: 1171
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.k.m.c.a(a.f.a.k.m.d):void");
    }

    @Override // a.f.a.k.m.p
    public void e() {
        for (int i = 0; i < this.k.size(); i++) {
            p run = this.k.get(i);
            run.e();
        }
    }

    public final a.f.a.k.e r() {
        for (int i = 0; i < this.k.size(); i++) {
            p run = this.k.get(i);
            if (run.f295b.O() != 8) {
                return run.f295b;
            }
        }
        return null;
    }

    public final a.f.a.k.e s() {
        for (int i = this.k.size() - 1; i >= 0; i--) {
            p run = this.k.get(i);
            if (run.f295b.O() != 8) {
                return run.f295b;
            }
        }
        return null;
    }

    @Override // a.f.a.k.m.p
    public void d() {
        Iterator<p> it = this.k.iterator();
        while (it.hasNext()) {
            p run = it.next();
            run.d();
        }
        int count = this.k.size();
        if (count < 1) {
            return;
        }
        a.f.a.k.e firstWidget = this.k.get(0).f295b;
        a.f.a.k.e lastWidget = this.k.get(count - 1).f295b;
        if (this.f == 0) {
            a.f.a.k.d startAnchor = firstWidget.L;
            a.f.a.k.d endAnchor = lastWidget.N;
            f startTarget = i(startAnchor, 0);
            int startMargin = startAnchor.e();
            a.f.a.k.e firstVisibleWidget = r();
            if (firstVisibleWidget != null) {
                startMargin = firstVisibleWidget.L.e();
            }
            if (startTarget != null) {
                b(this.h, startTarget, startMargin);
            }
            f endTarget = i(endAnchor, 0);
            int endMargin = endAnchor.e();
            a.f.a.k.e lastVisibleWidget = s();
            if (lastVisibleWidget != null) {
                endMargin = lastVisibleWidget.N.e();
            }
            if (endTarget != null) {
                b(this.i, endTarget, -endMargin);
            }
        } else {
            a.f.a.k.d startAnchor2 = firstWidget.M;
            a.f.a.k.d endAnchor2 = lastWidget.O;
            f startTarget2 = i(startAnchor2, 1);
            int startMargin2 = startAnchor2.e();
            a.f.a.k.e firstVisibleWidget2 = r();
            if (firstVisibleWidget2 != null) {
                startMargin2 = firstVisibleWidget2.M.e();
            }
            if (startTarget2 != null) {
                b(this.h, startTarget2, startMargin2);
            }
            f endTarget2 = i(endAnchor2, 1);
            int endMargin2 = endAnchor2.e();
            a.f.a.k.e lastVisibleWidget2 = s();
            if (lastVisibleWidget2 != null) {
                endMargin2 = lastVisibleWidget2.O.e();
            }
            if (endTarget2 != null) {
                b(this.i, endTarget2, -endMargin2);
            }
        }
        this.h.f285a = this;
        this.i.f285a = this;
    }
}
