package a.h.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f439a;

    public d(Object displayCutout) {
        this.f439a = displayCutout;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        d other = (d) o;
        return a.h.j.d.a(this.f439a, other.f439a);
    }

    public int hashCode() {
        Object obj = this.f439a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f439a + "}";
    }

    public static d a(Object displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new d(displayCutout);
    }
}
