package b.b.a.a.x;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class i implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f1106a;

    public i(float percent) {
        this.f1106a = percent;
    }

    @Override // b.b.a.a.x.c
    public float a(RectF bounds) {
        return this.f1106a * bounds.height();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof i)) {
            return false;
        }
        i that = (i) o;
        return this.f1106a == that.f1106a;
    }

    public int hashCode() {
        Object[] hashedFields = {Float.valueOf(this.f1106a)};
        return Arrays.hashCode(hashedFields);
    }
}
