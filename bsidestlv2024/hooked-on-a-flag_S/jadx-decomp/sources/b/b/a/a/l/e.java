package b.b.a.a.l;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class e {
    public static String c(Context context, long timeInMillis) {
        long offsetMillis = TimeZone.getDefault().getOffset(timeInMillis);
        return DateUtils.formatDateTime(context, timeInMillis - offsetMillis, 36);
    }

    public static String a(long timeInMillis) {
        return b(timeInMillis, Locale.getDefault());
    }

    public static String b(long timeInMillis, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return s.b(locale).format(new Date(timeInMillis));
        }
        return s.f(locale).format(new Date(timeInMillis));
    }

    public static String d(long timeInMillis) {
        return e(timeInMillis, Locale.getDefault());
    }

    public static String e(long timeInMillis, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return s.m(locale).format(new Date(timeInMillis));
        }
        return s.f(locale).format(new Date(timeInMillis));
    }
}
