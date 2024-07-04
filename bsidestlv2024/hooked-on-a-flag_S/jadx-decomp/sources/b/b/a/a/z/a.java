package b.b.a.a.z;

import a.e.g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class a extends a.j.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0074a();
    public final g<String, Bundle> d;

    public /* synthetic */ a(Parcel x0, ClassLoader x1, C0074a x2) {
        this(x0, x1);
    }

    public a(Parcelable superState) {
        super(superState);
        this.d = new g<>();
    }

    public a(Parcel in, ClassLoader loader) {
        super(in, loader);
        int size = in.readInt();
        String[] keys = new String[size];
        in.readStringArray(keys);
        Bundle[] states = new Bundle[size];
        in.readTypedArray(states, Bundle.CREATOR);
        this.d = new g<>(size);
        for (int i = 0; i < size; i++) {
            this.d.put(keys[i], states[i]);
        }
    }

    @Override // a.j.a.a, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        int size = this.d.size();
        out.writeInt(size);
        String[] keys = new String[size];
        Bundle[] states = new Bundle[size];
        for (int i = 0; i < size; i++) {
            keys[i] = this.d.i(i);
            states[i] = this.d.m(i);
        }
        out.writeStringArray(keys);
        out.writeTypedArray(states, 0);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.d + "}";
    }

    /* renamed from: b.b.a.a.z.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0074a implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel in, ClassLoader loader) {
            return new a(in, loader, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int size) {
            return new a[size];
        }
    }
}
