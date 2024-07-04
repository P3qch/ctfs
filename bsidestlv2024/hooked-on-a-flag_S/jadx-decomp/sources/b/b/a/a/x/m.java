package b.b.a.a.x;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapePath;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f1117a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f1118b;

    @Deprecated
    public float c;

    @Deprecated
    public float d;

    @Deprecated
    public float e;

    @Deprecated
    public float f;
    public final List<f> g = new ArrayList();
    public final List<g> h = new ArrayList();
    public boolean i;

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f1124a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public m() {
        n(0.0f, 0.0f);
    }

    public void n(float startX, float startY) {
        o(startX, startY, 270.0f, 0.0f);
    }

    public void o(float startX, float startY, float shadowStartAngle, float shadowSweepAngle) {
        t(startX);
        u(startY);
        r(startX);
        s(startY);
        p(shadowStartAngle);
        q((shadowStartAngle + shadowSweepAngle) % 360.0f);
        this.g.clear();
        this.h.clear();
        this.i = false;
    }

    public void m(float x, float y) {
        e operation = new e();
        operation.f1123b = x;
        operation.c = y;
        this.g.add(operation);
        c shadowOperation = new c(operation, i(), j());
        c(shadowOperation, shadowOperation.c() + 270.0f, shadowOperation.c() + 270.0f);
        r(x);
        s(y);
    }

    public void a(float left, float top, float right, float bottom, float startAngle, float sweepAngle) {
        d operation = new d(left, top, right, bottom);
        operation.s(startAngle);
        operation.t(sweepAngle);
        this.g.add(operation);
        b arcShadowOperation = new b(operation);
        float endAngle = startAngle + sweepAngle;
        boolean drawShadowInsideBounds = sweepAngle < 0.0f;
        c(arcShadowOperation, drawShadowInsideBounds ? (startAngle + 180.0f) % 360.0f : startAngle, drawShadowInsideBounds ? (180.0f + endAngle) % 360.0f : endAngle);
        r(((left + right) * 0.5f) + (((right - left) / 2.0f) * ((float) Math.cos(Math.toRadians(startAngle + sweepAngle)))));
        s(((top + bottom) * 0.5f) + (((bottom - top) / 2.0f) * ((float) Math.sin(Math.toRadians(startAngle + sweepAngle)))));
    }

    public void d(Matrix transform, Path path) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            f operation = this.g.get(i);
            operation.a(transform, path);
        }
    }

    public g f(Matrix transform) {
        b(h());
        Matrix transformCopy = new Matrix(transform);
        List<ShapePath.ShadowCompatOperation> operations = new ArrayList<>(this.h);
        return new a(this, operations, transformCopy);
    }

    /* loaded from: classes.dex */
    public class a extends g {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f1119b;
        public final /* synthetic */ Matrix c;

        public a(m this$0, List list, Matrix matrix) {
            this.f1119b = list;
            this.c = matrix;
        }

        @Override // b.b.a.a.x.m.g
        public void a(Matrix matrix, b.b.a.a.w.a shadowRenderer, int shadowElevation, Canvas canvas) {
            for (g op : this.f1119b) {
                op.a(this.c, shadowRenderer, shadowElevation, canvas);
            }
        }
    }

    public final void c(g shadowOperation, float startShadowAngle, float endShadowAngle) {
        b(startShadowAngle);
        this.h.add(shadowOperation);
        p(endShadowAngle);
    }

    public boolean e() {
        return false;
    }

    public final void b(float nextShadowAngle) {
        if (g() == nextShadowAngle) {
            return;
        }
        float shadowSweep = ((nextShadowAngle - g()) + 360.0f) % 360.0f;
        if (shadowSweep > 180.0f) {
            return;
        }
        d pathArcOperation = new d(i(), j(), i(), j());
        pathArcOperation.s(g());
        pathArcOperation.t(shadowSweep);
        this.h.add(new b(pathArcOperation));
        p(nextShadowAngle);
    }

    public float k() {
        return this.f1117a;
    }

    public float l() {
        return this.f1118b;
    }

    public float i() {
        return this.c;
    }

    public float j() {
        return this.d;
    }

    public final float g() {
        return this.e;
    }

    public final float h() {
        return this.f;
    }

    public final void t(float startX) {
        this.f1117a = startX;
    }

    public final void u(float startY) {
        this.f1118b = startY;
    }

    public final void r(float endX) {
        this.c = endX;
    }

    public final void s(float endY) {
        this.d = endY;
    }

    public final void p(float currentShadowAngle) {
        this.e = currentShadowAngle;
    }

    public final void q(float endShadowAngle) {
        this.f = endShadowAngle;
    }

    /* loaded from: classes.dex */
    public static abstract class g {

        /* renamed from: a, reason: collision with root package name */
        public static final Matrix f1125a = new Matrix();

        public abstract void a(Matrix matrix, b.b.a.a.w.a aVar, int i, Canvas canvas);

        public final void b(b.b.a.a.w.a shadowRenderer, int shadowElevation, Canvas canvas) {
            a(f1125a, shadowRenderer, shadowElevation, canvas);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends g {

        /* renamed from: b, reason: collision with root package name */
        public final e f1121b;
        public final float c;
        public final float d;

        public c(e operation, float startX, float startY) {
            this.f1121b = operation;
            this.c = startX;
            this.d = startY;
        }

        @Override // b.b.a.a.x.m.g
        public void a(Matrix transform, b.b.a.a.w.a shadowRenderer, int shadowElevation, Canvas canvas) {
            float height = this.f1121b.c - this.d;
            float width = this.f1121b.f1123b - this.c;
            RectF rect = new RectF(0.0f, 0.0f, (float) Math.hypot(height, width), 0.0f);
            Matrix edgeTransform = new Matrix(transform);
            edgeTransform.preTranslate(this.c, this.d);
            edgeTransform.preRotate(c());
            shadowRenderer.b(canvas, edgeTransform, rect, shadowElevation);
        }

        public float c() {
            return (float) Math.toDegrees(Math.atan((this.f1121b.c - this.d) / (this.f1121b.f1123b - this.c)));
        }
    }

    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: b, reason: collision with root package name */
        public final d f1120b;

        public b(d operation) {
            this.f1120b = operation;
        }

        @Override // b.b.a.a.x.m.g
        public void a(Matrix transform, b.b.a.a.w.a shadowRenderer, int shadowElevation, Canvas canvas) {
            float startAngle = this.f1120b.m();
            float sweepAngle = this.f1120b.n();
            RectF rect = new RectF(this.f1120b.k(), this.f1120b.o(), this.f1120b.l(), this.f1120b.j());
            shadowRenderer.a(canvas, transform, rect, shadowElevation, startAngle, sweepAngle);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        public float f1123b;
        public float c;

        @Override // b.b.a.a.x.m.f
        public void a(Matrix transform, Path path) {
            Matrix inverse = this.f1124a;
            transform.invert(inverse);
            path.transform(inverse);
            path.lineTo(this.f1123b, this.c);
            path.transform(transform);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends f {

        /* renamed from: b, reason: collision with root package name */
        public static final RectF f1122b = new RectF();

        @Deprecated
        public float c;

        @Deprecated
        public float d;

        @Deprecated
        public float e;

        @Deprecated
        public float f;

        @Deprecated
        public float g;

        @Deprecated
        public float h;

        public d(float left, float top, float right, float bottom) {
            q(left);
            u(top);
            r(right);
            p(bottom);
        }

        @Override // b.b.a.a.x.m.f
        public void a(Matrix transform, Path path) {
            Matrix inverse = this.f1124a;
            transform.invert(inverse);
            path.transform(inverse);
            RectF rectF = f1122b;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(transform);
        }

        public final float k() {
            return this.c;
        }

        public final float o() {
            return this.d;
        }

        public final float l() {
            return this.e;
        }

        public final float j() {
            return this.f;
        }

        public final void q(float left) {
            this.c = left;
        }

        public final void u(float top) {
            this.d = top;
        }

        public final void r(float right) {
            this.e = right;
        }

        public final void p(float bottom) {
            this.f = bottom;
        }

        public final float m() {
            return this.g;
        }

        public final float n() {
            return this.h;
        }

        public final void s(float startAngle) {
            this.g = startAngle;
        }

        public final void t(float sweepAngle) {
            this.h = sweepAngle;
        }
    }
}
