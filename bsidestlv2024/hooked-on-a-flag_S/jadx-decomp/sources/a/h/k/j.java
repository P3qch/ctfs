package a.h.k;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class j {
    public static boolean a(MotionEvent event, int source) {
        return (event.getSource() & source) == source;
    }
}
