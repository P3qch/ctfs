package b.b.a.a.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0068a();

    /* renamed from: b, reason: collision with root package name */
    public final l f1015b;
    public final l c;
    public final c d;
    public l e;
    public final int f;
    public final int g;

    /* loaded from: classes.dex */
    public interface c extends Parcelable {
        boolean i(long j);
    }

    public /* synthetic */ a(l x0, l x1, c x2, l x3, C0068a x4) {
        this(x0, x1, x2, x3);
    }

    public a(l start, l end, c validator, l openAt) {
        this.f1015b = start;
        this.c = end;
        this.e = openAt;
        this.d = validator;
        if (openAt != null && start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (openAt != null && openAt.compareTo(end) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.g = start.t(end) + 1;
        this.f = (end.d - start.d) + 1;
    }

    public c o() {
        return this.d;
    }

    public l s() {
        return this.f1015b;
    }

    public l p() {
        return this.c;
    }

    public l r() {
        return this.e;
    }

    public int q() {
        return this.g;
    }

    public int t() {
        return this.f;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof a)) {
            return false;
        }
        a that = (a) o;
        return this.f1015b.equals(that.f1015b) && this.c.equals(that.c) && a.h.j.d.a(this.e, that.e) && this.d.equals(that.d);
    }

    public int hashCode() {
        Object[] hashedFields = {this.f1015b, this.c, this.e, this.d};
        return Arrays.hashCode(hashedFields);
    }

    /* renamed from: b.b.a.a.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0068a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel source) {
            l start = (l) source.readParcelable(l.class.getClassLoader());
            l end = (l) source.readParcelable(l.class.getClassLoader());
            l openAt = (l) source.readParcelable(l.class.getClassLoader());
            c validator = (c) source.readParcelable(c.class.getClassLoader());
            return new a(start, end, validator, openAt, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int size) {
            return new a[size];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.f1015b, 0);
        dest.writeParcelable(this.c, 0);
        dest.writeParcelable(this.e, 0);
        dest.writeParcelable(this.d, 0);
    }

    public l n(l month) {
        if (month.compareTo(this.f1015b) < 0) {
            return this.f1015b;
        }
        if (month.compareTo(this.c) > 0) {
            return this.c;
        }
        return month;
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final long f1016a = s.a(l.k(1900, 0).g);

        /* renamed from: b, reason: collision with root package name */
        public static final long f1017b = s.a(l.k(2100, 11).g);
        public long c;
        public long d;
        public Long e;
        public c f;

        public b(a clone) {
            this.c = f1016a;
            this.d = f1017b;
            this.f = f.j(Long.MIN_VALUE);
            this.c = clone.f1015b.g;
            this.d = clone.c.g;
            this.e = Long.valueOf(clone.e.g);
            this.f = clone.d;
        }

        public b b(long month) {
            this.e = Long.valueOf(month);
            return this;
        }

        public a a() {
            Bundle deepCopyBundle = new Bundle();
            deepCopyBundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f);
            l l = l.l(this.c);
            l l2 = l.l(this.d);
            c cVar = (c) deepCopyBundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l3 = this.e;
            return new a(l, l2, cVar, l3 == null ? null : l.l(l3.longValue()), null);
        }
    }
}
