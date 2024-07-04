package b.b.a.a.l;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicReference<r> f1044a = new AtomicReference<>();

    public static r g() {
        r timeSource = f1044a.get();
        return timeSource == null ? r.c() : timeSource;
    }

    public static TimeZone h() {
        return TimeZone.getTimeZone("UTC");
    }

    @TargetApi(24)
    public static android.icu.util.TimeZone j() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    public static Calendar i() {
        Calendar today = g().a();
        today.set(11, 0);
        today.set(12, 0);
        today.set(13, 0);
        today.set(14, 0);
        today.setTimeZone(h());
        return today;
    }

    public static Calendar k() {
        return l(null);
    }

    public static Calendar l(Calendar rawCalendar) {
        Calendar utc = Calendar.getInstance(h());
        if (rawCalendar == null) {
            utc.clear();
        } else {
            utc.setTimeInMillis(rawCalendar.getTimeInMillis());
        }
        return utc;
    }

    public static Calendar d(Calendar rawCalendar) {
        Calendar rawCalendarInUtc = l(rawCalendar);
        Calendar utcCalendar = k();
        utcCalendar.set(rawCalendarInUtc.get(1), rawCalendarInUtc.get(2), rawCalendarInUtc.get(5));
        return utcCalendar;
    }

    public static long a(long rawDate) {
        Calendar rawCalendar = k();
        rawCalendar.setTimeInMillis(rawDate);
        Calendar sanitizedStartItem = d(rawCalendar);
        return sanitizedStartItem.getTimeInMillis();
    }

    @TargetApi(24)
    public static DateFormat c(String pattern, Locale locale) {
        DateFormat format = DateFormat.getInstanceForSkeleton(pattern, locale);
        format.setTimeZone(j());
        return format;
    }

    public static java.text.DateFormat e(int style, Locale locale) {
        java.text.DateFormat format = java.text.DateFormat.getDateInstance(style, locale);
        format.setTimeZone(h());
        return format;
    }

    @TargetApi(24)
    public static DateFormat b(Locale locale) {
        return c("MMMEd", locale);
    }

    @TargetApi(24)
    public static DateFormat m(Locale locale) {
        return c("yMMMEd", locale);
    }

    public static java.text.DateFormat f(Locale locale) {
        return e(0, locale);
    }
}
