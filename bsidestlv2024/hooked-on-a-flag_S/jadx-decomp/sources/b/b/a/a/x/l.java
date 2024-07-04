package b.b.a.a.x;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import b.b.a.a.x.g;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final m[] f1112a = new m[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f1113b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final m g = new m();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public final Path j = new Path();
    public final Path k = new Path();
    public boolean l = true;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final l f1114a = new l();
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public l() {
        for (int i = 0; i < 4; i++) {
            this.f1112a[i] = new m();
            this.f1113b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    public static l k() {
        return a.f1114a;
    }

    public void d(k shapeAppearanceModel, float interpolation, RectF bounds, Path path) {
        e(shapeAppearanceModel, interpolation, bounds, null, path);
    }

    public void e(k shapeAppearanceModel, float interpolation, RectF bounds, b pathListener, Path path) {
        path.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(bounds, Path.Direction.CW);
        c spec = new c(shapeAppearanceModel, interpolation, bounds, pathListener, path);
        for (int index = 0; index < 4; index++) {
            m(spec, index);
            n(index);
        }
        for (int index2 = 0; index2 < 4; index2++) {
            b(spec, index2);
            c(spec, index2);
        }
        path.close();
        this.e.close();
        if (Build.VERSION.SDK_INT >= 19 && !this.e.isEmpty()) {
            path.op(this.e, Path.Op.UNION);
        }
    }

    public final void m(c spec, int index) {
        b.b.a.a.x.c size = g(index, spec.f1115a);
        h(index, spec.f1115a).b(this.f1112a[index], 90.0f, spec.e, spec.c, size);
        float edgeAngle = a(index);
        this.f1113b[index].reset();
        f(index, spec.c, this.d);
        Matrix matrix = this.f1113b[index];
        PointF pointF = this.d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f1113b[index].preRotate(edgeAngle);
    }

    public final void n(int index) {
        this.h[0] = this.f1112a[index].i();
        this.h[1] = this.f1112a[index].j();
        this.f1113b[index].mapPoints(this.h);
        float edgeAngle = a(index);
        this.c[index].reset();
        Matrix matrix = this.c[index];
        float[] fArr = this.h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.c[index].preRotate(edgeAngle);
    }

    public final void b(c spec, int index) {
        this.h[0] = this.f1112a[index].k();
        this.h[1] = this.f1112a[index].l();
        this.f1113b[index].mapPoints(this.h);
        if (index == 0) {
            Path path = spec.f1116b;
            float[] fArr = this.h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = spec.f1116b;
            float[] fArr2 = this.h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f1112a[index].d(this.f1113b[index], spec.f1116b);
        b bVar = spec.d;
        if (bVar != null) {
            ((g.a) bVar).a(this.f1112a[index], this.f1113b[index], index);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(b.b.a.a.x.l.c r10, int r11) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.a.x.l.c(b.b.a.a.x.l$c, int):void");
    }

    public final boolean l(Path edgePath, int index) {
        this.k.reset();
        this.f1112a[index].d(this.f1113b[index], this.k);
        RectF bounds = new RectF();
        edgePath.computeBounds(bounds, true);
        this.k.computeBounds(bounds, true);
        edgePath.op(this.k, Path.Op.INTERSECT);
        edgePath.computeBounds(bounds, true);
        if (bounds.isEmpty()) {
            return bounds.width() > 1.0f && bounds.height() > 1.0f;
        }
        return true;
    }

    public final float i(RectF bounds, int index) {
        float[] fArr = this.h;
        m[] mVarArr = this.f1112a;
        fArr[0] = mVarArr[index].c;
        fArr[1] = mVarArr[index].d;
        this.f1113b[index].mapPoints(fArr);
        switch (index) {
            case 1:
            case 3:
                return Math.abs(bounds.centerX() - this.h[0]);
            case 2:
            default:
                return Math.abs(bounds.centerY() - this.h[1]);
        }
    }

    public final d h(int index, k shapeAppearanceModel) {
        switch (index) {
            case 1:
                return shapeAppearanceModel.k();
            case 2:
                return shapeAppearanceModel.i();
            case 3:
                return shapeAppearanceModel.q();
            default:
                return shapeAppearanceModel.s();
        }
    }

    public final b.b.a.a.x.c g(int index, k shapeAppearanceModel) {
        switch (index) {
            case 1:
                return shapeAppearanceModel.l();
            case 2:
                return shapeAppearanceModel.j();
            case 3:
                return shapeAppearanceModel.r();
            default:
                return shapeAppearanceModel.t();
        }
    }

    public final f j(int index, k shapeAppearanceModel) {
        switch (index) {
            case 1:
                return shapeAppearanceModel.h();
            case 2:
                return shapeAppearanceModel.n();
            case 3:
                return shapeAppearanceModel.p();
            default:
                return shapeAppearanceModel.o();
        }
    }

    public final void f(int index, RectF bounds, PointF pointF) {
        switch (index) {
            case 1:
                pointF.set(bounds.right, bounds.bottom);
                return;
            case 2:
                pointF.set(bounds.left, bounds.bottom);
                return;
            case 3:
                pointF.set(bounds.left, bounds.top);
                return;
            default:
                pointF.set(bounds.right, bounds.top);
                return;
        }
    }

    public final float a(int index) {
        return (index + 1) * 90;
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final k f1115a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f1116b;
        public final RectF c;
        public final b d;
        public final float e;

        public c(k shapeAppearanceModel, float interpolation, RectF bounds, b pathListener, Path path) {
            this.d = pathListener;
            this.f1115a = shapeAppearanceModel;
            this.e = interpolation;
            this.c = bounds;
            this.f1116b = path;
        }
    }
}
