package a.s;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f739a = true;

    public static u a(ViewGroup group) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new t(group);
        }
        return s.e(group);
    }

    public static void c(ViewGroup group, boolean suppress) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            group.suppressLayout(suppress);
        } else if (i >= 18) {
            b(group, suppress);
        } else {
            w.b(group, suppress);
        }
    }

    @SuppressLint({"NewApi"})
    public static void b(ViewGroup group, boolean suppress) {
        if (f739a) {
            try {
                group.suppressLayout(suppress);
            } catch (NoSuchMethodError e) {
                f739a = false;
            }
        }
    }
}
