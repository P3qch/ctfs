package a.h.l;

import android.os.Build;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class d {
    public static void a(EdgeEffect edgeEffect, float deltaDistance, float displacement) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(deltaDistance, displacement);
        } else {
            edgeEffect.onPull(deltaDistance);
        }
    }
}
