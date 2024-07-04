package a.f.a.k.m;

import a.f.a.k.d;
import a.f.a.k.e;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<a.f.a.k.e> f279a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public a f280b = new a();
    public a.f.a.k.f c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static int f281a = 0;

        /* renamed from: b, reason: collision with root package name */
        public static int f282b = 1;
        public static int c = 2;
        public e.a d;
        public e.a e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public boolean l;
        public int m;
    }

    /* renamed from: a.f.a.k.m.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0012b {
    }

    public void e(a.f.a.k.f layout) {
        this.f279a.clear();
        int childCount = layout.u0.size();
        for (int i = 0; i < childCount; i++) {
            a.f.a.k.e widget = layout.u0.get(i);
            e.a w = widget.w();
            e.a aVar = e.a.MATCH_CONSTRAINT;
            if (w == aVar || widget.M() == aVar) {
                this.f279a.add(widget);
            }
        }
        layout.B1();
    }

    public b(a.f.a.k.f constraintWidgetContainer) {
        this.c = constraintWidgetContainer;
    }

    public final void b(a.f.a.k.f layout) {
        l lVar;
        n nVar;
        int childCount = layout.u0.size();
        boolean optimize = layout.I1(64);
        InterfaceC0012b measurer = layout.y1();
        for (int i = 0; i < childCount; i++) {
            a.f.a.k.e child = layout.u0.get(i);
            if (!(child instanceof a.f.a.k.g) && !(child instanceof a.f.a.k.a) && !child.e0() && (!optimize || (lVar = child.e) == null || (nVar = child.f) == null || !lVar.e.j || !nVar.e.j)) {
                e.a widthBehavior = child.q(0);
                e.a heightBehavior = child.q(1);
                e.a aVar = e.a.MATCH_CONSTRAINT;
                boolean skip = widthBehavior == aVar && child.t != 1 && heightBehavior == aVar && child.u != 1;
                if (!skip && layout.I1(1) && !(child instanceof a.f.a.k.k)) {
                    if (widthBehavior == aVar && child.t == 0 && heightBehavior != aVar && !child.b0()) {
                        skip = true;
                    }
                    if (heightBehavior == aVar && child.u == 0 && widthBehavior != aVar && !child.b0()) {
                        skip = true;
                    }
                    if ((widthBehavior == aVar || heightBehavior == aVar) && child.a0 > 0.0f) {
                        skip = true;
                    }
                }
                if (!skip) {
                    a(measurer, child, 0);
                    layout.getClass();
                }
            }
        }
        ((ConstraintLayout.b) measurer).b();
    }

    public final void c(a.f.a.k.f layout, int pass, int w, int h) {
        int minWidth = layout.E();
        int minHeight = layout.D();
        layout.P0(0);
        layout.O0(0);
        layout.Z0(w);
        layout.A0(h);
        layout.P0(minWidth);
        layout.O0(minHeight);
        this.c.M1(pass);
        this.c.i1();
    }

    public long d(a.f.a.k.f layout, int optimizationLevel, int widthMode, int widthSize, int heightMode, int heightSize) {
        boolean optimize;
        boolean optimize2;
        int widthSize2;
        boolean allSolved;
        int heightSize2;
        int optimizations;
        long layoutTime;
        a.f.a.k.f fVar;
        int sizeDependentWidgetsCount;
        boolean optimize3;
        int startingWidth;
        int maxIterations;
        int optimizations2;
        int heightSize3;
        boolean allSolved2;
        boolean allSolved3;
        int lastMeasureWidth = 0;
        int lastMeasureHeight = 0;
        int paddingX = 0;
        InterfaceC0012b measurer = layout.y1();
        long layoutTime2 = 0;
        int childCount = layout.u0.size();
        int startingWidth2 = layout.P();
        int startingHeight = layout.t();
        boolean optimizeWrap = a.f.a.k.j.b(optimizationLevel, 128);
        boolean optimize4 = optimizeWrap || a.f.a.k.j.b(optimizationLevel, 64);
        if (!optimize4) {
            optimize = optimize4;
        } else {
            int i = 0;
            while (i < childCount) {
                boolean optimize5 = optimize4;
                a.f.a.k.e child = layout.u0.get(i);
                int lastMeasureWidth2 = lastMeasureWidth;
                e.a w = child.w();
                int lastMeasureHeight2 = lastMeasureHeight;
                e.a aVar = e.a.MATCH_CONSTRAINT;
                boolean matchWidth = w == aVar;
                int paddingX2 = paddingX;
                boolean matchHeight = child.M() == aVar;
                boolean ratio = matchWidth && matchHeight && child.r() > 0.0f;
                if (child.b0() && ratio) {
                    optimize2 = false;
                    break;
                }
                if (child.d0() && ratio) {
                    optimize2 = false;
                    break;
                }
                boolean matchWidth2 = child instanceof a.f.a.k.k;
                if (matchWidth2) {
                    optimize2 = false;
                    break;
                }
                if (!child.b0() && !child.d0()) {
                    i++;
                    optimize4 = optimize5;
                    lastMeasureWidth = lastMeasureWidth2;
                    lastMeasureHeight = lastMeasureHeight2;
                    paddingX = paddingX2;
                } else {
                    optimize2 = false;
                    break;
                }
            }
            optimize = optimize4;
        }
        optimize2 = optimize;
        if (optimize2) {
        }
        boolean optimize6 = optimize2 & ((widthMode == 1073741824 && heightMode == 1073741824) || optimizeWrap);
        int computations = 0;
        if (!optimize6) {
            widthSize2 = widthSize;
            allSolved = false;
            heightSize2 = heightSize;
        } else {
            widthSize2 = Math.min(layout.C(), widthSize);
            int heightSize4 = Math.min(layout.B(), heightSize);
            if (widthMode == 1073741824 && layout.P() != widthSize2) {
                layout.Z0(widthSize2);
                layout.B1();
            }
            if (heightMode == 1073741824 && layout.t() != heightSize4) {
                layout.A0(heightSize4);
                layout.B1();
            }
            if (widthMode == 1073741824 && heightMode == 1073741824) {
                boolean allSolved4 = layout.v1(optimizeWrap);
                computations = 2;
                heightSize3 = heightSize4;
                allSolved2 = allSolved4;
            } else {
                boolean allSolved5 = layout.w1(optimizeWrap);
                heightSize3 = heightSize4;
                if (widthMode == 1073741824) {
                    allSolved5 &= layout.x1(optimizeWrap, 0);
                    computations = 0 + 1;
                }
                if (heightMode != 1073741824) {
                    allSolved2 = allSolved5;
                } else {
                    allSolved2 = allSolved5 & layout.x1(optimizeWrap, 1);
                    computations++;
                }
            }
            if (!allSolved2) {
                allSolved3 = allSolved2;
            } else {
                allSolved3 = allSolved2;
                boolean allSolved6 = widthMode == 1073741824;
                layout.e1(allSolved6, heightMode == 1073741824);
            }
            heightSize2 = heightSize3;
            allSolved = allSolved3;
        }
        if (allSolved && computations == 2) {
            return 0L;
        }
        int optimizations3 = layout.z1();
        if (childCount > 0) {
            b(layout);
        }
        e(layout);
        int sizeDependentWidgetsCount2 = this.f279a.size();
        if (childCount > 0) {
            c(layout, 0, startingWidth2, startingHeight);
        }
        if (sizeDependentWidgetsCount2 <= 0) {
            optimizations = optimizations3;
            layoutTime = 0;
            fVar = layout;
        } else {
            e.a w2 = layout.w();
            e.a aVar2 = e.a.WRAP_CONTENT;
            boolean containerWrapWidth = w2 == aVar2;
            boolean containerWrapHeight = layout.M() == aVar2;
            int minWidth = Math.max(layout.P(), this.c.E());
            int minHeight = Math.max(layout.t(), this.c.D());
            int i2 = 0;
            int minWidth2 = minWidth;
            int childCount2 = minHeight;
            boolean needSolverPass = false;
            while (i2 < sizeDependentWidgetsCount2) {
                long layoutTime3 = layoutTime2;
                a.f.a.k.e widget = this.f279a.get(i2);
                if (!(widget instanceof a.f.a.k.k)) {
                    optimizations2 = optimizations3;
                } else {
                    int preWidth = widget.P();
                    optimizations2 = optimizations3;
                    int preHeight = widget.t();
                    boolean needSolverPass2 = needSolverPass | a(measurer, widget, 1);
                    layout.getClass();
                    int measuredWidth = widget.P();
                    boolean needSolverPass3 = needSolverPass2;
                    int measuredHeight = widget.t();
                    if (measuredWidth != preWidth) {
                        widget.Z0(measuredWidth);
                        if (containerWrapWidth && widget.I() > minWidth2) {
                            int w3 = widget.I() + widget.k(d.a.RIGHT).e();
                            minWidth2 = Math.max(minWidth2, w3);
                        }
                        needSolverPass3 = true;
                    }
                    if (measuredHeight != preHeight) {
                        widget.A0(measuredHeight);
                        if (containerWrapHeight && widget.n() > childCount2) {
                            int h = widget.n() + widget.k(d.a.BOTTOM).e();
                            childCount2 = Math.max(childCount2, h);
                        }
                        needSolverPass3 = true;
                    }
                    a.f.a.k.k virtualLayout = (a.f.a.k.k) widget;
                    virtualLayout.m1();
                    needSolverPass = needSolverPass3 | false;
                }
                i2++;
                optimizations3 = optimizations2;
                layoutTime2 = layoutTime3;
            }
            optimizations = optimizations3;
            layoutTime = layoutTime2;
            int maxIterations2 = 2;
            int j = 0;
            while (true) {
                if (j >= maxIterations2) {
                    fVar = layout;
                    break;
                }
                int i3 = 0;
                while (i3 < sizeDependentWidgetsCount2) {
                    a.f.a.k.e widget2 = this.f279a.get(i3);
                    if ((widget2 instanceof a.f.a.k.h) && !(widget2 instanceof a.f.a.k.k)) {
                        sizeDependentWidgetsCount = sizeDependentWidgetsCount2;
                    } else if (widget2 instanceof a.f.a.k.g) {
                        sizeDependentWidgetsCount = sizeDependentWidgetsCount2;
                    } else {
                        sizeDependentWidgetsCount = sizeDependentWidgetsCount2;
                        if (widget2.O() != 8 && ((!optimize6 || !widget2.e.e.j || !widget2.f.e.j) && !(widget2 instanceof a.f.a.k.k))) {
                            int preWidth2 = widget2.P();
                            int preHeight2 = widget2.t();
                            optimize3 = optimize6;
                            int preBaselineDistance = widget2.l();
                            startingWidth = startingWidth2;
                            int measureStrategy = j == maxIterations2 + (-1) ? 2 : 1;
                            boolean hasMeasure = a(measurer, widget2, measureStrategy);
                            layout.getClass();
                            maxIterations = maxIterations2;
                            int measuredWidth2 = widget2.P();
                            boolean needSolverPass4 = needSolverPass | hasMeasure;
                            int measuredHeight2 = widget2.t();
                            if (measuredWidth2 != preWidth2) {
                                widget2.Z0(measuredWidth2);
                                if (containerWrapWidth && widget2.I() > minWidth2) {
                                    int w4 = widget2.I() + widget2.k(d.a.RIGHT).e();
                                    minWidth2 = Math.max(minWidth2, w4);
                                }
                                needSolverPass4 = true;
                            }
                            if (measuredHeight2 != preHeight2) {
                                widget2.A0(measuredHeight2);
                                if (containerWrapHeight && widget2.n() > childCount2) {
                                    int h2 = widget2.n() + widget2.k(d.a.BOTTOM).e();
                                    childCount2 = Math.max(childCount2, h2);
                                }
                                needSolverPass4 = true;
                            }
                            if (!widget2.S() || preBaselineDistance == widget2.l()) {
                                needSolverPass = needSolverPass4;
                            } else {
                                needSolverPass = true;
                            }
                            i3++;
                            sizeDependentWidgetsCount2 = sizeDependentWidgetsCount;
                            optimize6 = optimize3;
                            startingWidth2 = startingWidth;
                            maxIterations2 = maxIterations;
                        }
                    }
                    maxIterations = maxIterations2;
                    optimize3 = optimize6;
                    startingWidth = startingWidth2;
                    i3++;
                    sizeDependentWidgetsCount2 = sizeDependentWidgetsCount;
                    optimize6 = optimize3;
                    startingWidth2 = startingWidth;
                    maxIterations2 = maxIterations;
                }
                int maxIterations3 = maxIterations2;
                int sizeDependentWidgetsCount3 = sizeDependentWidgetsCount2;
                boolean optimize7 = optimize6;
                int startingWidth3 = startingWidth2;
                if (!needSolverPass) {
                    fVar = layout;
                    break;
                }
                c(layout, j + 1, startingWidth3, startingHeight);
                needSolverPass = false;
                j++;
                sizeDependentWidgetsCount2 = sizeDependentWidgetsCount3;
                startingWidth2 = startingWidth3;
                optimize6 = optimize7;
                maxIterations2 = maxIterations3;
            }
        }
        fVar.L1(optimizations);
        return layoutTime;
    }

    public final boolean a(InterfaceC0012b measurer, a.f.a.k.e widget, int measureStrategy) {
        this.f280b.d = widget.w();
        this.f280b.e = widget.M();
        this.f280b.f = widget.P();
        this.f280b.g = widget.t();
        a aVar = this.f280b;
        aVar.l = false;
        aVar.m = measureStrategy;
        e.a aVar2 = aVar.d;
        e.a aVar3 = e.a.MATCH_CONSTRAINT;
        boolean horizontalMatchConstraints = aVar2 == aVar3;
        boolean verticalMatchConstraints = aVar.e == aVar3;
        boolean horizontalUseRatio = horizontalMatchConstraints && widget.a0 > 0.0f;
        boolean verticalUseRatio = verticalMatchConstraints && widget.a0 > 0.0f;
        if (horizontalUseRatio && widget.v[0] == 4) {
            aVar.d = e.a.FIXED;
        }
        if (verticalUseRatio && widget.v[1] == 4) {
            aVar.e = e.a.FIXED;
        }
        ((ConstraintLayout.b) measurer).d(widget, aVar);
        widget.Z0(this.f280b.h);
        widget.A0(this.f280b.i);
        widget.z0(this.f280b.k);
        widget.p0(this.f280b.j);
        a aVar4 = this.f280b;
        aVar4.m = 0;
        return aVar4.l;
    }
}
