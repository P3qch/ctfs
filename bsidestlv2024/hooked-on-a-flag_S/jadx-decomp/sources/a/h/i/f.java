package a.h.i;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Locale f428a = new Locale(BuildConfig.FLAVOR, BuildConfig.FLAVOR);

    public static int b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale != null && !locale.equals(f428a)) {
            String scriptSubtag = b.c(locale);
            if (scriptSubtag == null) {
                return a(locale);
            }
            if (scriptSubtag.equalsIgnoreCase("Arab") || scriptSubtag.equalsIgnoreCase("Hebr")) {
                return 1;
            }
            return 0;
        }
        return 0;
    }

    public static int a(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
