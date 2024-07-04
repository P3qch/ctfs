package a.h.h;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class b {
    public static Handler a() {
        if (Looper.myLooper() == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            return handler;
        }
        Handler handler2 = new Handler();
        return handler2;
    }
}
