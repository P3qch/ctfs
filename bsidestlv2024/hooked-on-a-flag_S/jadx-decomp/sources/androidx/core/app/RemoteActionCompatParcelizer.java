package androidx.core.app;

import a.u.a;
import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a parcel) {
        RemoteActionCompat obj = new RemoteActionCompat();
        obj.f847a = (IconCompat) parcel.v(obj.f847a, 1);
        obj.f848b = parcel.l(obj.f848b, 2);
        obj.c = parcel.l(obj.c, 3);
        obj.d = (PendingIntent) parcel.r(obj.d, 4);
        obj.e = parcel.h(obj.e, 5);
        obj.f = parcel.h(obj.f, 6);
        return obj;
    }

    public static void write(RemoteActionCompat obj, a parcel) {
        parcel.x();
        parcel.M(obj.f847a, 1);
        parcel.D(obj.f848b, 2);
        parcel.D(obj.c, 3);
        parcel.H(obj.d, 4);
        parcel.z(obj.e, 5);
        parcel.z(obj.f, 6);
    }
}
