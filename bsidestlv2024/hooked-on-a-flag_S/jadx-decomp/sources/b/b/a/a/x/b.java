package b.b.a.a.x;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f1098a;

    /* renamed from: b, reason: collision with root package name */
    public final float f1099b;

    public b(float adjustment, c other) {
        while (other instanceof b) {
            other = ((b) other).f1098a;
            adjustment += ((b) other).f1099b;
        }
        this.f1098a = other;
        this.f1099b = adjustment;
    }

    @Override // b.b.a.a.x.c
    public float a(RectF bounds) {
        return Math.max(0.0f, this.f1098a.a(bounds) + this.f1099b);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof b)) {
            return false;
        }
        b that = (b) o;
        return this.f1098a.equals(that.f1098a) && this.f1099b == that.f1099b;
    }

    public int hashCode() {
        Object[] hashedFields = {this.f1098a, Float.valueOf(this.f1099b)};
        return Arrays.hashCode(hashedFields);
    }
}
