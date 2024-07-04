package a.k.b;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class s implements Parcelable {
    public static final Parcelable.Creator<s> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f581b;
    public final String c;
    public final boolean d;
    public final int e;
    public final int f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final Bundle k;
    public final boolean l;
    public final int m;
    public Bundle n;

    public s(Fragment frag) {
        this.f581b = frag.getClass().getName();
        this.c = frag.h;
        this.d = frag.p;
        this.e = frag.y;
        this.f = frag.z;
        this.g = frag.A;
        this.h = frag.D;
        this.i = frag.o;
        this.j = frag.C;
        this.k = frag.i;
        this.l = frag.B;
        this.m = frag.R.ordinal();
    }

    public s(Parcel in) {
        this.f581b = in.readString();
        this.c = in.readString();
        this.d = in.readInt() != 0;
        this.e = in.readInt();
        this.f = in.readInt();
        this.g = in.readString();
        this.h = in.readInt() != 0;
        this.i = in.readInt() != 0;
        this.j = in.readInt() != 0;
        this.k = in.readBundle();
        this.l = in.readInt() != 0;
        this.n = in.readBundle();
        this.m = in.readInt();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f581b);
        sb.append(" (");
        sb.append(this.c);
        sb.append(")}:");
        if (this.d) {
            sb.append(" fromLayout");
        }
        if (this.f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f));
        }
        String str = this.g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.g);
        }
        if (this.h) {
            sb.append(" retainInstance");
        }
        if (this.i) {
            sb.append(" removing");
        }
        if (this.j) {
            sb.append(" detached");
        }
        if (this.l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f581b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<s> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s createFromParcel(Parcel in) {
            return new s(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public s[] newArray(int size) {
            return new s[size];
        }
    }
}
