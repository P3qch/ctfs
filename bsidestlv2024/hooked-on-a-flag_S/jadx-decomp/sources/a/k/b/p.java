package a.k.b;

import a.k.b.n;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class p implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<s> f579b;
    public ArrayList<String> c;
    public b[] d;
    public int e;
    public String f;
    public ArrayList<String> g;
    public ArrayList<Bundle> h;
    public ArrayList<n.l> i;

    public p() {
        this.f = null;
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
    }

    public p(Parcel in) {
        this.f = null;
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.f579b = in.createTypedArrayList(s.CREATOR);
        this.c = in.createStringArrayList();
        this.d = (b[]) in.createTypedArray(b.CREATOR);
        this.e = in.readInt();
        this.f = in.readString();
        this.g = in.createStringArrayList();
        this.h = in.createTypedArrayList(Bundle.CREATOR);
        this.i = in.createTypedArrayList(n.l.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.f579b);
        dest.writeStringList(this.c);
        dest.writeTypedArray(this.d, flags);
        dest.writeInt(this.e);
        dest.writeString(this.f);
        dest.writeStringList(this.g);
        dest.writeTypedList(this.h);
        dest.writeTypedList(this.i);
    }

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<p> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p createFromParcel(Parcel in) {
            return new p(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public p[] newArray(int size) {
            return new p[size];
        }
    }
}
