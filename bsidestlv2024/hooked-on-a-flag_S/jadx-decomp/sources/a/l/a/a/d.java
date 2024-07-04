package a.l.a.a;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f612a;

    /* renamed from: b, reason: collision with root package name */
    public final float f613b;

    public d(float[] values) {
        this.f612a = values;
        this.f613b = 1.0f / (values.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        if (input >= 1.0f) {
            return 1.0f;
        }
        if (input <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f612a;
        int position = Math.min((int) ((fArr.length - 1) * input), fArr.length - 2);
        float f = this.f613b;
        float quantized = position * f;
        float diff = input - quantized;
        float weight = diff / f;
        float[] fArr2 = this.f612a;
        return fArr2[position] + ((fArr2[position + 1] - fArr2[position]) * weight);
    }
}
