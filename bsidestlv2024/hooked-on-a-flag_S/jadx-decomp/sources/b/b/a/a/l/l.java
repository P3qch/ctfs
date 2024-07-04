package b.b.a.a.l;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
public final class l implements Comparable<l>, Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final Calendar f1039b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final long g;
    public String h;

    public l(Calendar rawCalendar) {
        rawCalendar.set(5, 1);
        Calendar d = s.d(rawCalendar);
        this.f1039b = d;
        this.c = d.get(2);
        this.d = d.get(1);
        this.e = d.getMaximum(7);
        this.f = d.getActualMaximum(5);
        this.g = d.getTimeInMillis();
    }

    public static l l(long timeInMillis) {
        Calendar calendar = s.k();
        calendar.setTimeInMillis(timeInMillis);
        return new l(calendar);
    }

    public static l k(int year, int month) {
        Calendar calendar = s.k();
        calendar.set(1, year);
        calendar.set(2, month);
        return new l(calendar);
    }

    public static l m() {
        return new l(s.i());
    }

    public int n() {
        int difference = this.f1039b.get(7) - this.f1039b.getFirstDayOfWeek();
        if (difference < 0) {
            return difference + this.e;
        }
        return difference;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof l)) {
            return false;
        }
        l that = (l) o;
        return this.c == that.c && this.d == that.d;
    }

    public int hashCode() {
        Object[] hashedFields = {Integer.valueOf(this.c), Integer.valueOf(this.d)};
        return Arrays.hashCode(hashedFields);
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(l other) {
        return this.f1039b.compareTo(other.f1039b);
    }

    public int t(l other) {
        if (this.f1039b instanceof GregorianCalendar) {
            return ((other.d - this.d) * 12) + (other.c - this.c);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public long r() {
        return this.f1039b.getTimeInMillis();
    }

    public long o(int day) {
        Calendar dayCalendar = s.d(this.f1039b);
        dayCalendar.set(5, day);
        return dayCalendar.getTimeInMillis();
    }

    public int p(long date) {
        Calendar dayCalendar = s.d(this.f1039b);
        dayCalendar.setTimeInMillis(date);
        return dayCalendar.get(5);
    }

    public l s(int months) {
        Calendar laterMonth = s.d(this.f1039b);
        laterMonth.add(2, months);
        return new l(laterMonth);
    }

    public String q(Context context) {
        if (this.h == null) {
            this.h = e.c(context, this.f1039b.getTimeInMillis());
        }
        return this.h;
    }

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<l> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel source) {
            int year = source.readInt();
            int month = source.readInt();
            return l.k(year, month);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int size) {
            return new l[size];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.d);
        dest.writeInt(this.c);
    }
}
