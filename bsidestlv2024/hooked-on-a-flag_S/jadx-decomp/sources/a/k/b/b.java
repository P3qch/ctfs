package a.k.b;

import a.k.b.v;
import a.m.d;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int[] f515b;
    public final ArrayList<String> c;
    public final int[] d;
    public final int[] e;
    public final int f;
    public final String g;
    public final int h;
    public final int i;
    public final CharSequence j;
    public final int k;
    public final CharSequence l;
    public final ArrayList<String> m;
    public final ArrayList<String> n;
    public final boolean o;

    public b(a.k.b.a bse) {
        int numOps = bse.f587a.size();
        this.f515b = new int[numOps * 5];
        if (!bse.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.c = new ArrayList<>(numOps);
        this.d = new int[numOps];
        this.e = new int[numOps];
        int pos = 0;
        int opNum = 0;
        while (opNum < numOps) {
            v.a op = bse.f587a.get(opNum);
            int pos2 = pos + 1;
            this.f515b[pos] = op.f589a;
            ArrayList<String> arrayList = this.c;
            Fragment fragment = op.f590b;
            arrayList.add(fragment != null ? fragment.h : null);
            int[] iArr = this.f515b;
            int pos3 = pos2 + 1;
            iArr[pos2] = op.c;
            int pos4 = pos3 + 1;
            iArr[pos3] = op.d;
            int pos5 = pos4 + 1;
            iArr[pos4] = op.e;
            iArr[pos5] = op.f;
            this.d[opNum] = op.g.ordinal();
            this.e[opNum] = op.h.ordinal();
            opNum++;
            pos = pos5 + 1;
        }
        int opNum2 = bse.f;
        this.f = opNum2;
        this.g = bse.h;
        this.h = bse.s;
        this.i = bse.i;
        this.j = bse.j;
        this.k = bse.k;
        this.l = bse.l;
        this.m = bse.m;
        this.n = bse.n;
        this.o = bse.o;
    }

    public b(Parcel in) {
        this.f515b = in.createIntArray();
        this.c = in.createStringArrayList();
        this.d = in.createIntArray();
        this.e = in.createIntArray();
        this.f = in.readInt();
        this.g = in.readString();
        this.h = in.readInt();
        this.i = in.readInt();
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.k = in.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.m = in.createStringArrayList();
        this.n = in.createStringArrayList();
        this.o = in.readInt() != 0;
    }

    public a.k.b.a j(n fm) {
        a.k.b.a bse = new a.k.b.a(fm);
        int pos = 0;
        int num = 0;
        while (pos < this.f515b.length) {
            v.a op = new v.a();
            int pos2 = pos + 1;
            op.f589a = this.f515b[pos];
            if (n.A0(2)) {
                Log.v("FragmentManager", "Instantiate " + bse + " op #" + num + " base fragment #" + this.f515b[pos2]);
            }
            String fWho = this.c.get(num);
            if (fWho != null) {
                Fragment f = fm.b0(fWho);
                op.f590b = f;
            } else {
                op.f590b = null;
            }
            op.g = d.b.values()[this.d[num]];
            op.h = d.b.values()[this.e[num]];
            int[] iArr = this.f515b;
            int pos3 = pos2 + 1;
            int pos4 = iArr[pos2];
            op.c = pos4;
            int pos5 = pos3 + 1;
            int pos6 = iArr[pos3];
            op.d = pos6;
            int pos7 = pos5 + 1;
            int pos8 = iArr[pos5];
            op.e = pos8;
            int i = iArr[pos7];
            op.f = i;
            bse.f588b = pos4;
            bse.c = pos6;
            bse.d = pos8;
            bse.e = i;
            bse.d(op);
            num++;
            pos = pos7 + 1;
        }
        bse.f = this.f;
        bse.h = this.g;
        bse.s = this.h;
        bse.g = true;
        bse.i = this.i;
        bse.j = this.j;
        bse.k = this.k;
        bse.l = this.l;
        bse.m = this.m;
        bse.n = this.n;
        bse.o = this.o;
        bse.o(1);
        return bse;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f515b);
        parcel.writeStringList(this.c);
        parcel.writeIntArray(this.d);
        parcel.writeIntArray(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel in) {
            return new b(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int size) {
            return new b[size];
        }
    }
}
