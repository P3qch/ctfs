package a.f.a.k.m;

import a.f.a.k.e;
import a.f.a.k.m.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static b.a f288a = new b.a();

    /* renamed from: b, reason: collision with root package name */
    public static int f289b = 0;
    public static int c = 0;

    public static void h(a.f.a.k.f layout, b.InterfaceC0012b measurer) {
        e.a horizontal = layout.w();
        e.a vertical = layout.M();
        f289b = 0;
        c = 0;
        layout.n0();
        ArrayList<a.f.a.k.e> h1 = layout.h1();
        int count = h1.size();
        for (int i = 0; i < count; i++) {
            h1.get(i).n0();
        }
        boolean isRtl = layout.E1();
        if (horizontal == e.a.FIXED) {
            layout.u0(0, layout.P());
        } else {
            layout.v0(0);
        }
        boolean hasGuideline = false;
        boolean hasBarrier = false;
        for (int i2 = 0; i2 < count; i2++) {
            a.f.a.k.e child = h1.get(i2);
            if (child instanceof a.f.a.k.g) {
                a.f.a.k.g guideline = (a.f.a.k.g) child;
                if (guideline.h1() == 1) {
                    if (guideline.i1() != -1) {
                        guideline.l1(guideline.i1());
                    } else if (guideline.j1() != -1 && layout.g0()) {
                        guideline.l1(layout.P() - guideline.j1());
                    } else if (layout.g0()) {
                        int position = (int) ((guideline.k1() * layout.P()) + 0.5f);
                        guideline.l1(position);
                    }
                    hasGuideline = true;
                }
            } else if ((child instanceof a.f.a.k.a) && ((a.f.a.k.a) child).o1() == 0) {
                hasBarrier = true;
            }
        }
        if (hasGuideline) {
            for (int i3 = 0; i3 < count; i3++) {
                a.f.a.k.e child2 = h1.get(i3);
                if (child2 instanceof a.f.a.k.g) {
                    a.f.a.k.g guideline2 = (a.f.a.k.g) child2;
                    if (guideline2.h1() == 1) {
                        b(0, guideline2, measurer, isRtl);
                    }
                }
            }
        }
        b(0, layout, measurer, isRtl);
        if (hasBarrier) {
            for (int i4 = 0; i4 < count; i4++) {
                a.f.a.k.e child3 = h1.get(i4);
                if (child3 instanceof a.f.a.k.a) {
                    a.f.a.k.a barrier = (a.f.a.k.a) child3;
                    if (barrier.o1() == 0) {
                        c(0, barrier, measurer, 0, isRtl);
                    }
                }
            }
        }
        if (vertical == e.a.FIXED) {
            layout.x0(0, layout.t());
        } else {
            layout.w0(0);
        }
        boolean hasGuideline2 = false;
        boolean hasBarrier2 = false;
        for (int i5 = 0; i5 < count; i5++) {
            a.f.a.k.e child4 = h1.get(i5);
            if (child4 instanceof a.f.a.k.g) {
                a.f.a.k.g guideline3 = (a.f.a.k.g) child4;
                if (guideline3.h1() == 0) {
                    if (guideline3.i1() != -1) {
                        guideline3.l1(guideline3.i1());
                    } else if (guideline3.j1() != -1 && layout.h0()) {
                        guideline3.l1(layout.t() - guideline3.j1());
                    } else if (layout.h0()) {
                        int position2 = (int) ((guideline3.k1() * layout.t()) + 0.5f);
                        guideline3.l1(position2);
                    }
                    hasGuideline2 = true;
                }
            } else if ((child4 instanceof a.f.a.k.a) && ((a.f.a.k.a) child4).o1() == 1) {
                hasBarrier2 = true;
            }
        }
        if (hasGuideline2) {
            for (int i6 = 0; i6 < count; i6++) {
                a.f.a.k.e child5 = h1.get(i6);
                if (child5 instanceof a.f.a.k.g) {
                    a.f.a.k.g guideline4 = (a.f.a.k.g) child5;
                    if (guideline4.h1() == 0) {
                        i(1, guideline4, measurer);
                    }
                }
            }
        }
        i(0, layout, measurer);
        if (hasBarrier2) {
            for (int i7 = 0; i7 < count; i7++) {
                a.f.a.k.e child6 = h1.get(i7);
                if (child6 instanceof a.f.a.k.a) {
                    a.f.a.k.a barrier2 = (a.f.a.k.a) child6;
                    if (barrier2.o1() == 1) {
                        c(0, barrier2, measurer, 1, isRtl);
                    }
                }
            }
        }
        for (int i8 = 0; i8 < count; i8++) {
            a.f.a.k.e child7 = h1.get(i8);
            if (child7.f0() && a(child7)) {
                a.f.a.k.f.H1(child7, measurer, f288a, 0);
                if (child7 instanceof a.f.a.k.g) {
                    if (((a.f.a.k.g) child7).h1() == 0) {
                        i(0, child7, measurer);
                    } else {
                        b(0, child7, measurer, isRtl);
                    }
                } else {
                    b(0, child7, measurer, isRtl);
                    i(0, child7, measurer);
                }
            }
        }
    }

    public static void c(int level, a.f.a.k.a barrier, b.InterfaceC0012b measurer, int orientation, boolean isRtl) {
        if (barrier.k1()) {
            if (orientation == 0) {
                b(level + 1, barrier, measurer, isRtl);
            } else {
                i(level + 1, barrier, measurer);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x01db, code lost:
    
        if (r9.r() != 0.0f) goto L158;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(int r19, a.f.a.k.e r20, a.f.a.k.m.b.InterfaceC0012b r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.k.m.h.b(int, a.f.a.k.e, a.f.a.k.m.b$b, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x01cb, code lost:
    
        if (r8.r() != 0.0f) goto L155;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(int r18, a.f.a.k.e r19, a.f.a.k.m.b.InterfaceC0012b r20) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.k.m.h.i(int, a.f.a.k.e, a.f.a.k.m.b$b):void");
    }

    public static void d(int level, b.InterfaceC0012b measurer, a.f.a.k.e widget, boolean isRtl) {
        int d1;
        float bias = widget.u();
        int start = widget.L.f.d();
        int end = widget.N.f.d();
        int s1 = widget.L.e() + start;
        int s2 = end - widget.N.e();
        if (start == end) {
            bias = 0.5f;
            s1 = start;
            s2 = end;
        }
        int width = widget.P();
        int distance = (s2 - s1) - width;
        if (s1 > s2) {
            distance = (s1 - s2) - width;
        }
        if (distance > 0) {
            d1 = (int) ((distance * bias) + 0.5f);
        } else {
            d1 = (int) (distance * bias);
        }
        int x1 = s1 + d1;
        int x2 = x1 + width;
        if (s1 > s2) {
            x1 = s1 + d1;
            x2 = x1 - width;
        }
        widget.u0(x1, x2);
        b(level + 1, widget, measurer, isRtl);
    }

    public static void f(int level, b.InterfaceC0012b measurer, a.f.a.k.e widget) {
        int d1;
        float bias = widget.K();
        int start = widget.M.f.d();
        int end = widget.O.f.d();
        int s1 = widget.M.e() + start;
        int s2 = end - widget.O.e();
        if (start == end) {
            bias = 0.5f;
            s1 = start;
            s2 = end;
        }
        int height = widget.t();
        int distance = (s2 - s1) - height;
        if (s1 > s2) {
            distance = (s1 - s2) - height;
        }
        if (distance > 0) {
            d1 = (int) ((distance * bias) + 0.5f);
        } else {
            d1 = (int) (distance * bias);
        }
        int y1 = s1 + d1;
        int y2 = y1 + height;
        if (s1 > s2) {
            y1 = s1 - d1;
            y2 = y1 - height;
        }
        widget.x0(y1, y2);
        i(level + 1, widget, measurer);
    }

    public static void e(int level, a.f.a.k.e layout, b.InterfaceC0012b measurer, a.f.a.k.e widget, boolean isRtl) {
        int parentWidth;
        float bias = widget.u();
        int s1 = widget.L.f.d() + widget.L.e();
        int s2 = widget.N.f.d() - widget.N.e();
        if (s2 >= s1) {
            int width = widget.P();
            if (widget.O() != 8) {
                int i = widget.t;
                if (i == 2) {
                    if (layout instanceof a.f.a.k.f) {
                        parentWidth = layout.P();
                    } else {
                        parentWidth = layout.G().P();
                    }
                    width = (int) (widget.u() * 0.5f * parentWidth);
                } else if (i == 0) {
                    width = s2 - s1;
                }
                width = Math.max(widget.w, width);
                int i2 = widget.x;
                if (i2 > 0) {
                    width = Math.min(i2, width);
                }
            }
            int distance = (s2 - s1) - width;
            int d1 = (int) ((distance * bias) + 0.5f);
            int x1 = s1 + d1;
            int x2 = x1 + width;
            widget.u0(x1, x2);
            b(level + 1, widget, measurer, isRtl);
        }
    }

    public static void g(int level, a.f.a.k.e layout, b.InterfaceC0012b measurer, a.f.a.k.e widget) {
        int parentHeight;
        float bias = widget.K();
        int s1 = widget.M.f.d() + widget.M.e();
        int s2 = widget.O.f.d() - widget.O.e();
        if (s2 >= s1) {
            int height = widget.t();
            if (widget.O() != 8) {
                int i = widget.u;
                if (i == 2) {
                    if (layout instanceof a.f.a.k.f) {
                        parentHeight = layout.t();
                    } else {
                        parentHeight = layout.G().t();
                    }
                    height = (int) (bias * 0.5f * parentHeight);
                } else if (i == 0) {
                    height = s2 - s1;
                }
                height = Math.max(widget.z, height);
                int i2 = widget.A;
                if (i2 > 0) {
                    height = Math.min(i2, height);
                }
            }
            int distance = (s2 - s1) - height;
            int d1 = (int) ((distance * bias) + 0.5f);
            int y1 = s1 + d1;
            int y2 = y1 + height;
            widget.x0(y1, y2);
            i(level + 1, widget, measurer);
        }
    }

    public static boolean a(a.f.a.k.e layout) {
        e.a aVar;
        e.a aVar2;
        e.a horizontalBehaviour = layout.w();
        e.a verticalBehaviour = layout.M();
        a.f.a.k.f parent = layout.G() != null ? (a.f.a.k.f) layout.G() : null;
        if (parent == null || parent.w() != e.a.FIXED) {
        }
        if (parent == null || parent.M() != e.a.FIXED) {
        }
        e.a aVar3 = e.a.FIXED;
        boolean isHorizontalFixed = horizontalBehaviour == aVar3 || layout.g0() || horizontalBehaviour == e.a.WRAP_CONTENT || (horizontalBehaviour == (aVar2 = e.a.MATCH_CONSTRAINT) && layout.t == 0 && layout.a0 == 0.0f && layout.T(0)) || (horizontalBehaviour == aVar2 && layout.t == 1 && layout.W(0, layout.P()));
        boolean isVerticalFixed = verticalBehaviour == aVar3 || layout.h0() || verticalBehaviour == e.a.WRAP_CONTENT || (verticalBehaviour == (aVar = e.a.MATCH_CONSTRAINT) && layout.u == 0 && layout.a0 == 0.0f && layout.T(1)) || (horizontalBehaviour == aVar && layout.u == 1 && layout.W(1, layout.t()));
        if (layout.a0 <= 0.0f || !(isHorizontalFixed || isVerticalFixed)) {
            return isHorizontalFixed && isVerticalFixed;
        }
        return true;
    }
}
