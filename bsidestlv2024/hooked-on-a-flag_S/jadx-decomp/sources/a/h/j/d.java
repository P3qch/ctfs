package a.h.j;

import android.os.Build;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d {
    public static boolean a(Object a2, Object b2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return c.a(a2, b2);
        }
        return a2 == b2 || (a2 != null && a2.equals(b2));
    }

    public static int b(Object... values) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Arrays.hashCode(values);
        }
        return Arrays.hashCode(values);
    }
}
