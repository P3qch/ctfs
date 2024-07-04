package a.f.a.k.m;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static int f290a;

    /* renamed from: b, reason: collision with root package name */
    public p f291b;
    public ArrayList<p> c = new ArrayList<>();

    public m(p run, int dir) {
        this.f291b = null;
        f290a++;
        this.f291b = run;
    }

    public void a(p run) {
        this.c.add(run);
    }

    public final long d(f node, long startPosition) {
        p run = node.d;
        if (run instanceof k) {
            return startPosition;
        }
        long position = startPosition;
        int count = node.k.size();
        for (int i = 0; i < count; i++) {
            d dependency = node.k.get(i);
            if (dependency instanceof f) {
                f nextNode = (f) dependency;
                if (nextNode.d != run) {
                    position = Math.max(position, d(nextNode, nextNode.f + startPosition));
                }
            }
        }
        if (node == run.h) {
            long dimension = run.j();
            return Math.max(Math.max(position, d(run.i, startPosition + dimension)), (startPosition + dimension) - run.i.f);
        }
        return position;
    }

    public final long c(f node, long startPosition) {
        p run = node.d;
        if (run instanceof k) {
            return startPosition;
        }
        long position = startPosition;
        int count = node.k.size();
        for (int i = 0; i < count; i++) {
            d dependency = node.k.get(i);
            if (dependency instanceof f) {
                f nextNode = (f) dependency;
                if (nextNode.d != run) {
                    position = Math.min(position, c(nextNode, nextNode.f + startPosition));
                }
            }
        }
        if (node == run.i) {
            long dimension = run.j();
            return Math.min(Math.min(position, c(run.h, startPosition - dimension)), (startPosition - dimension) - run.h.f);
        }
        return position;
    }

    public long b(a.f.a.k.f container, int orientation) {
        p pVar = this.f291b;
        if (pVar instanceof c) {
            c chainRun = (c) pVar;
            if (chainRun.f != orientation) {
                return 0L;
            }
        } else if (orientation == 0) {
            if (!(pVar instanceof l)) {
                return 0L;
            }
        } else if (!(pVar instanceof n)) {
            return 0L;
        }
        f containerStart = (orientation == 0 ? container.e : container.f).h;
        f containerEnd = (orientation == 0 ? container.e : container.f).i;
        boolean runWithStartTarget = pVar.h.l.contains(containerStart);
        boolean runWithEndTarget = this.f291b.i.l.contains(containerEnd);
        long dimension = this.f291b.j();
        if (runWithStartTarget && runWithEndTarget) {
            long maxPosition = d(this.f291b.h, 0L);
            long minPosition = c(this.f291b.i, 0L);
            long endGap = maxPosition - dimension;
            p pVar2 = this.f291b;
            int i = pVar2.i.f;
            long maxPosition2 = -i;
            if (endGap >= maxPosition2) {
                endGap += i;
            }
            int i2 = pVar2.h.f;
            long startGap = ((-minPosition) - dimension) - i2;
            if (startGap >= i2) {
                startGap -= i2;
            }
            float bias = pVar2.f295b.m(orientation);
            long gap = 0;
            if (bias > 0.0f) {
                gap = (((float) startGap) / bias) + (((float) endGap) / (1.0f - bias));
            }
            long runDimension = (((float) gap) * bias) + 0.5f + dimension + (((float) gap) * (1.0f - bias)) + 0.5f;
            long gap2 = this.f291b.h.f;
            return (gap2 + runDimension) - r2.i.f;
        }
        if (runWithStartTarget) {
            long maxPosition3 = d(this.f291b.h, r1.f);
            long runDimension2 = this.f291b.h.f + dimension;
            return Math.max(maxPosition3, runDimension2);
        }
        if (runWithEndTarget) {
            long minPosition2 = c(this.f291b.i, r1.f);
            long runDimension3 = (-this.f291b.i.f) + dimension;
            return Math.max(-minPosition2, runDimension3);
        }
        return (r1.h.f + this.f291b.j()) - this.f291b.i.f;
    }
}
