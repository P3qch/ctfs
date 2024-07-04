package b.b.a.a.x;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f1097a;

    public a(float size) {
        this.f1097a = size;
    }

    @Override // b.b.a.a.x.c
    public float a(RectF bounds) {
        return this.f1097a;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof a)) {
            return false;
        }
        a that = (a) o;
        return this.f1097a == that.f1097a;
    }

    public int hashCode() {
        Object[] hashedFields = {Float.valueOf(this.f1097a)};
        return Arrays.hashCode(hashedFields);
    }
}
