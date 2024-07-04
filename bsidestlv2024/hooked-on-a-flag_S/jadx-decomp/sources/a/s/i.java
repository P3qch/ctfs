package a.s;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes.dex */
public class i implements TypeEvaluator<Rect> {
    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float fraction, Rect startValue, Rect endValue) {
        int left = startValue.left + ((int) ((endValue.left - r0) * fraction));
        int top = startValue.top + ((int) ((endValue.top - r1) * fraction));
        int right = startValue.right + ((int) ((endValue.right - r2) * fraction));
        int bottom = startValue.bottom + ((int) ((endValue.bottom - r3) * fraction));
        return new Rect(left, top, right, bottom);
    }
}
