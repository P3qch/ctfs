package b.b.a.a.c0;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f1001b;
    public int c;
    public int d;
    public int e;

    public c() {
        this(0);
    }

    public c(int format) {
        this(0, 0, 10, format);
    }

    public c(int hour, int minute, int selection, int format) {
        this.c = hour;
        this.d = minute;
        this.e = selection;
        this.f1001b = format;
        l(hour);
        new b.b.a.a.c0.a(59);
        new b.b.a.a.c0.a(format == 1 ? 24 : 12);
    }

    public c(Parcel in) {
        this(in.readInt(), in.readInt(), in.readInt(), in.readInt());
    }

    public static int l(int hourOfDay) {
        return hourOfDay >= 12 ? 1 : 0;
    }

    public int hashCode() {
        Object[] hashedFields = {Integer.valueOf(this.f1001b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e)};
        return Arrays.hashCode(hashedFields);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof c)) {
            return false;
        }
        c that = (c) o;
        return this.c == that.c && this.d == that.d && this.f1001b == that.f1001b && this.e == that.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.c);
        dest.writeInt(this.d);
        dest.writeInt(this.e);
        dest.writeInt(this.f1001b);
    }

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<c> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel in) {
            return new c(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int size) {
            return new c[size];
        }
    }

    public static String j(Resources resources, CharSequence text) {
        return k(resources, text, "%02d");
    }

    public static String k(Resources resources, CharSequence text, String format) {
        return String.format(resources.getConfiguration().locale, format, Integer.valueOf(Integer.parseInt(String.valueOf(text))));
    }
}
