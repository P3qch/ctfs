package b.b.a.a.l;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f1042a = new r(null, null);

    /* renamed from: b, reason: collision with root package name */
    public final Long f1043b;
    public final TimeZone c;

    public r(Long fixedTimeMs, TimeZone fixedTimeZone) {
        this.f1043b = fixedTimeMs;
        this.c = fixedTimeZone;
    }

    public static r c() {
        return f1042a;
    }

    public Calendar a() {
        return b(this.c);
    }

    public Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.f1043b;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
