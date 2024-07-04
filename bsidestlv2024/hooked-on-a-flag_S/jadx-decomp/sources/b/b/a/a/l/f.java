package b.b.a.a.l;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.a.a.l.a;
import java.util.Arrays;

/* loaded from: classes.dex */
public class f implements a.c {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final long f1022b;

    public /* synthetic */ f(long x0, a x1) {
        this(x0);
    }

    public f(long point) {
        this.f1022b = point;
    }

    public static f j(long point) {
        return new f(point);
    }

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<f> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel source) {
            return new f(source.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int size) {
            return new f[size];
        }
    }

    @Override // b.b.a.a.l.a.c
    public boolean i(long date) {
        return date >= this.f1022b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.f1022b);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof f)) {
            return false;
        }
        f that = (f) o;
        return this.f1022b == that.f1022b;
    }

    public int hashCode() {
        Object[] hashedFields = {Long.valueOf(this.f1022b)};
        return Arrays.hashCode(hashedFields);
    }
}
