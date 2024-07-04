package a.h.d;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f363a = new b(0, 0, 0, 0);

    /* renamed from: b, reason: collision with root package name */
    public final int f364b;
    public final int c;
    public final int d;
    public final int e;

    public b(int left, int top, int right, int bottom) {
        this.f364b = left;
        this.c = top;
        this.d = right;
        this.e = bottom;
    }

    public static b a(int left, int top, int right, int bottom) {
        if (left == 0 && top == 0 && right == 0 && bottom == 0) {
            return f363a;
        }
        return new b(left, top, right, bottom);
    }

    public static b b(Rect r) {
        return a(r.left, r.top, r.right, r.bottom);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        b insets = (b) o;
        if (this.e == insets.e && this.f364b == insets.f364b && this.d == insets.d && this.c == insets.c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = this.f364b;
        return (((((result * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return "Insets{left=" + this.f364b + ", top=" + this.c + ", right=" + this.d + ", bottom=" + this.e + '}';
    }

    public static b c(Insets insets) {
        return a(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets d() {
        return Insets.of(this.f364b, this.c, this.d, this.e);
    }
}
