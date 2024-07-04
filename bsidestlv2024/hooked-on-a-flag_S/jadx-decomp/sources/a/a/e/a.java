package a.a.e;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import net.sqlcipher.database.SQLiteCursor;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0000a();

    /* renamed from: b, reason: collision with root package name */
    public final int f4b;
    public final Intent c;

    public a(int resultCode, Intent data) {
        this.f4b = resultCode;
        this.c = data;
    }

    public a(Parcel in) {
        this.f4b = in.readInt();
        this.c = in.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(in);
    }

    public int k() {
        return this.f4b;
    }

    public Intent j() {
        return this.c;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + l(this.f4b) + ", data=" + this.c + '}';
    }

    public static String l(int resultCode) {
        switch (resultCode) {
            case SQLiteCursor.NO_COUNT /* -1 */:
                return "RESULT_OK";
            case 0:
                return "RESULT_CANCELED";
            default:
                return String.valueOf(resultCode);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f4b);
        dest.writeInt(this.c == null ? 0 : 1);
        Intent intent = this.c;
        if (intent != null) {
            intent.writeToParcel(dest, flags);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: a.a.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel in) {
            return new a(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int size) {
            return new a[size];
        }
    }
}
