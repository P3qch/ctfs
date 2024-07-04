package a.f.a.k;

import a.f.a.k.e;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static boolean[] f278a = new boolean[3];

    public static void a(f container, a.f.a.d system, e widget) {
        widget.q = -1;
        widget.r = -1;
        e.a aVar = container.W[0];
        e.a aVar2 = e.a.WRAP_CONTENT;
        if (aVar != aVar2 && widget.W[0] == e.a.MATCH_PARENT) {
            int left = widget.L.g;
            int right = container.P() - widget.N.g;
            d dVar = widget.L;
            dVar.i = system.q(dVar);
            d dVar2 = widget.N;
            dVar2.i = system.q(dVar2);
            system.f(widget.L.i, left);
            system.f(widget.N.i, right);
            widget.q = 2;
            widget.D0(left, right);
        }
        if (container.W[1] != aVar2 && widget.W[1] == e.a.MATCH_PARENT) {
            int top = widget.M.g;
            int bottom = container.t() - widget.O.g;
            d dVar3 = widget.M;
            dVar3.i = system.q(dVar3);
            d dVar4 = widget.O;
            dVar4.i = system.q(dVar4);
            system.f(widget.M.i, top);
            system.f(widget.O.i, bottom);
            if (widget.e0 > 0 || widget.O() == 8) {
                d dVar5 = widget.P;
                dVar5.i = system.q(dVar5);
                system.f(widget.P.i, widget.e0 + top);
            }
            widget.r = 2;
            widget.U0(top, bottom);
        }
    }

    public static final boolean b(int optimizationLevel, int optimization) {
        return (optimizationLevel & optimization) == optimization;
    }
}
