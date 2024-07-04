package a.j.a;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class a implements Parcelable {
    public final Parcelable c;

    /* renamed from: b, reason: collision with root package name */
    public static final a f506b = new C0037a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* renamed from: a.j.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0037a extends a {
        public C0037a() {
            super((C0037a) null);
        }
    }

    public /* synthetic */ a(C0037a x0) {
        this();
    }

    public a() {
        this.c = null;
    }

    public a(Parcelable superState) {
        if (superState == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.c = superState != f506b ? superState : null;
    }

    public a(Parcel source, ClassLoader loader) {
        Parcelable superState = source.readParcelable(loader);
        this.c = superState != null ? superState : f506b;
    }

    public final Parcelable j() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.c, flags);
    }

    /* loaded from: classes.dex */
    public static class b implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel in, ClassLoader loader) {
            Parcelable superState = in.readParcelable(loader);
            if (superState != null) {
                throw new IllegalStateException("superState must be null");
            }
            return a.f506b;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel in) {
            return createFromParcel(in, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int size) {
            return new a[size];
        }
    }
}
