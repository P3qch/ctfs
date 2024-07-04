package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteCursor;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: a, reason: collision with root package name */
    public static final PorterDuff.Mode f849a = PorterDuff.Mode.SRC_IN;
    public Object c;
    public String k;

    /* renamed from: b, reason: collision with root package name */
    public int f850b = -1;
    public byte[] d = null;
    public Parcelable e = null;
    public int f = 0;
    public int g = 0;
    public ColorStateList h = null;
    public PorterDuff.Mode i = f849a;
    public String j = null;

    public int a() {
        int i = this.f850b;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.c);
        }
        if (i != 2) {
            throw new IllegalStateException("called getResId() on " + this);
        }
        return this.f;
    }

    public String toString() {
        if (this.f850b == -1) {
            return String.valueOf(this.c);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=").append(e(this.f850b));
        switch (this.f850b) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.c).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.c).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.k);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(a())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f);
                if (this.g != 0) {
                    sb.append(" off=");
                    sb.append(this.g);
                    break;
                }
                break;
            case 4:
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                sb.append(" uri=");
                sb.append(this.c);
                break;
        }
        if (this.h != null) {
            sb.append(" tint=");
            sb.append(this.h);
        }
        if (this.i != f849a) {
            sb.append(" mode=");
            sb.append(this.i);
        }
        sb.append(")");
        return sb.toString();
    }

    public void d(boolean isStream) {
        this.j = this.i.name();
        switch (this.f850b) {
            case SQLiteCursor.NO_COUNT /* -1 */:
                if (isStream) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.e = (Parcelable) this.c;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (isStream) {
                    Bitmap bitmap = (Bitmap) this.c;
                    ByteArrayOutputStream data = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, data);
                    this.d = data.toByteArray();
                    return;
                }
                this.e = (Parcelable) this.c;
                return;
            case 2:
                this.d = ((String) this.c).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.d = (byte[]) this.c;
                return;
            case 4:
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                this.d = this.c.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public void c() {
        this.i = PorterDuff.Mode.valueOf(this.j);
        switch (this.f850b) {
            case SQLiteCursor.NO_COUNT /* -1 */:
                Parcelable parcelable = this.e;
                if (parcelable != null) {
                    this.c = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.e;
                if (parcelable2 != null) {
                    this.c = parcelable2;
                    return;
                }
                byte[] bArr = this.d;
                this.c = bArr;
                this.f850b = 3;
                this.f = 0;
                this.g = bArr.length;
                return;
            case 2:
            case 4:
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                String str = new String(this.d, Charset.forName("UTF-16"));
                this.c = str;
                if (this.f850b == 2 && this.k == null) {
                    this.k = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.c = this.d;
                return;
        }
    }

    public static String e(int x) {
        switch (x) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }
}
