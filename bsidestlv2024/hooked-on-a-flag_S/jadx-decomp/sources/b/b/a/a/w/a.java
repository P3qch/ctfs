package b.b.a.a.w;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1095a = new int[3];

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f1096b = {0.0f, 0.5f, 1.0f};
    public static final int[] c = new int[4];
    public static final float[] d = {0.0f, 0.0f, 0.5f, 1.0f};
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public int h;
    public int i;
    public int j;
    public final Path k;
    public Paint l;

    public a() {
        this(-16777216);
    }

    public a(int color) {
        this.k = new Path();
        this.l = new Paint();
        this.e = new Paint();
        d(color);
        this.l.setColor(0);
        Paint paint = new Paint(4);
        this.f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.g = new Paint(paint);
    }

    public void d(int color) {
        this.h = a.h.d.a.d(color, 68);
        this.i = a.h.d.a.d(color, 20);
        this.j = a.h.d.a.d(color, 0);
        this.e.setColor(this.h);
    }

    public void b(Canvas canvas, Matrix transform, RectF bounds, int elevation) {
        bounds.bottom += elevation;
        bounds.offset(0.0f, -elevation);
        int[] iArr = f1095a;
        iArr[0] = this.j;
        iArr[1] = this.i;
        iArr[2] = this.h;
        Paint paint = this.g;
        float f = bounds.left;
        paint.setShader(new LinearGradient(f, bounds.top, f, bounds.bottom, iArr, f1096b, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(transform);
        canvas.drawRect(bounds, this.g);
        canvas.restore();
    }

    public void a(Canvas canvas, Matrix matrix, RectF bounds, int elevation, float startAngle, float sweepAngle) {
        boolean drawShadowInsideBounds = sweepAngle < 0.0f;
        Path arcBounds = this.k;
        if (drawShadowInsideBounds) {
            int[] iArr = c;
            iArr[0] = 0;
            iArr[1] = this.j;
            iArr[2] = this.i;
            iArr[3] = this.h;
        } else {
            arcBounds.rewind();
            arcBounds.moveTo(bounds.centerX(), bounds.centerY());
            arcBounds.arcTo(bounds, startAngle, sweepAngle);
            arcBounds.close();
            bounds.inset(-elevation, -elevation);
            int[] iArr2 = c;
            iArr2[0] = 0;
            iArr2[1] = this.h;
            iArr2[2] = this.i;
            iArr2[3] = this.j;
        }
        float radius = bounds.width() / 2.0f;
        if (radius <= 0.0f) {
            return;
        }
        float startRatio = 1.0f - (elevation / radius);
        float midRatio = startRatio + ((1.0f - startRatio) / 2.0f);
        float[] fArr = d;
        fArr[1] = startRatio;
        fArr[2] = midRatio;
        RadialGradient shader = new RadialGradient(bounds.centerX(), bounds.centerY(), radius, c, fArr, Shader.TileMode.CLAMP);
        this.f.setShader(shader);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, bounds.height() / bounds.width());
        if (!drawShadowInsideBounds) {
            canvas.clipPath(arcBounds, Region.Op.DIFFERENCE);
            canvas.drawPath(arcBounds, this.l);
        }
        canvas.drawArc(bounds, startAngle, sweepAngle, true, this.f);
        canvas.restore();
    }

    public Paint c() {
        return this.e;
    }
}
