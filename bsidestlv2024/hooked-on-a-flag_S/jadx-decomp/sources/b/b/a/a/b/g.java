package b.b.a.a.b;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f984a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f985b = new float[9];
    public final Matrix c = new Matrix();

    public Matrix a(float fraction, Matrix startValue, Matrix endValue) {
        startValue.getValues(this.f984a);
        endValue.getValues(this.f985b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f985b;
            float f = fArr[i];
            float[] fArr2 = this.f984a;
            float diff = f - fArr2[i];
            fArr[i] = fArr2[i] + (fraction * diff);
        }
        this.c.setValues(this.f985b);
        return this.c;
    }
}
