package a.u;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public class b extends a {
    public final SparseIntArray d;
    public final Parcel e;
    public final int f;
    public final int g;
    public final String h;
    public int i;
    public int j;
    public int k;

    public b(Parcel p) {
        this(p, p.dataPosition(), p.dataSize(), BuildConfig.FLAVOR, new a.e.a(), new a.e.a(), new a.e.a());
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.Class> */
    /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> */
    public b(Parcel p, int offset, int end, String prefix, a.e.a<String, Method> aVar, a.e.a<String, Method> aVar2, a.e.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.e = p;
        this.f = offset;
        this.g = end;
        this.j = offset;
        this.h = prefix;
    }

    @Override // a.u.a
    public boolean m(int fieldId) {
        while (this.j < this.g) {
            int i = this.k;
            if (i == fieldId) {
                return true;
            }
            if (String.valueOf(i).compareTo(String.valueOf(fieldId)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.j);
            int size = this.e.readInt();
            this.k = this.e.readInt();
            this.j += size;
        }
        return this.k == fieldId;
    }

    @Override // a.u.a
    public void w(int fieldId) {
        a();
        this.i = fieldId;
        this.d.put(fieldId, this.e.dataPosition());
        E(0);
        E(fieldId);
    }

    @Override // a.u.a
    public void a() {
        int i = this.i;
        if (i >= 0) {
            int currentFieldPosition = this.d.get(i);
            int position = this.e.dataPosition();
            int size = position - currentFieldPosition;
            this.e.setDataPosition(currentFieldPosition);
            this.e.writeInt(size);
            this.e.setDataPosition(position);
        }
    }

    @Override // a.u.a
    public a b() {
        Parcel parcel = this.e;
        int dataPosition = parcel.dataPosition();
        int i = this.j;
        if (i == this.f) {
            i = this.g;
        }
        return new b(parcel, dataPosition, i, this.h + "  ", this.f766a, this.f767b, this.c);
    }

    @Override // a.u.a
    public void A(byte[] b2) {
        if (b2 != null) {
            this.e.writeInt(b2.length);
            this.e.writeByteArray(b2);
        } else {
            this.e.writeInt(-1);
        }
    }

    @Override // a.u.a
    public void E(int val) {
        this.e.writeInt(val);
    }

    @Override // a.u.a
    public void I(String val) {
        this.e.writeString(val);
    }

    @Override // a.u.a
    public void G(Parcelable p) {
        this.e.writeParcelable(p, 0);
    }

    @Override // a.u.a
    public void y(boolean z) {
        this.e.writeInt(z ? 1 : 0);
    }

    @Override // a.u.a
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }

    @Override // a.u.a
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    @Override // a.u.a
    public int o() {
        return this.e.readInt();
    }

    @Override // a.u.a
    public String s() {
        return this.e.readString();
    }

    @Override // a.u.a
    public byte[] i() {
        int len = this.e.readInt();
        if (len < 0) {
            return null;
        }
        byte[] bytes = new byte[len];
        this.e.readByteArray(bytes);
        return bytes;
    }

    @Override // a.u.a
    public <T extends Parcelable> T q() {
        return (T) this.e.readParcelable(getClass().getClassLoader());
    }

    @Override // a.u.a
    public boolean g() {
        return this.e.readInt() != 0;
    }
}
