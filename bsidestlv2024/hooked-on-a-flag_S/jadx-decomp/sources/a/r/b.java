package a.r;

import android.os.Trace;

/* loaded from: classes.dex */
public final class b {
    public static void a(String label) {
        Trace.beginSection(label);
    }

    public static void b() {
        Trace.endSection();
    }
}
