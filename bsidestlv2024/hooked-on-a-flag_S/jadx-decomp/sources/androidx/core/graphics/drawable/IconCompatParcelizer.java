package androidx.core.graphics.drawable;

import a.u.a;
import android.content.res.ColorStateList;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a parcel) {
        IconCompat obj = new IconCompat();
        obj.f850b = parcel.p(obj.f850b, 1);
        obj.d = parcel.j(obj.d, 2);
        obj.e = parcel.r(obj.e, 3);
        obj.f = parcel.p(obj.f, 4);
        obj.g = parcel.p(obj.g, 5);
        obj.h = (ColorStateList) parcel.r(obj.h, 6);
        obj.j = parcel.t(obj.j, 7);
        obj.k = parcel.t(obj.k, 8);
        obj.c();
        return obj;
    }

    public static void write(IconCompat obj, a parcel) {
        parcel.x();
        parcel.f();
        obj.d(false);
        int i = obj.f850b;
        if (-1 != i) {
            parcel.F(i, 1);
        }
        byte[] bArr = obj.d;
        if (bArr != null) {
            parcel.B(bArr, 2);
        }
        Parcelable parcelable = obj.e;
        if (parcelable != null) {
            parcel.H(parcelable, 3);
        }
        int i2 = obj.f;
        if (i2 != 0) {
            parcel.F(i2, 4);
        }
        int i3 = obj.g;
        if (i3 != 0) {
            parcel.F(i3, 5);
        }
        ColorStateList colorStateList = obj.h;
        if (colorStateList != null) {
            parcel.H(colorStateList, 6);
        }
        String str = obj.j;
        if (str != null) {
            parcel.J(str, 7);
        }
        String str2 = obj.k;
        if (str2 != null) {
            parcel.J(str2, 8);
        }
    }
}
