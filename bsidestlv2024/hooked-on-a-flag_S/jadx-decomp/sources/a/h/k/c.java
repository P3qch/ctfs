package a.h.k;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ClipData f435a;

    /* renamed from: b, reason: collision with root package name */
    public final int f436b;
    public final int c;
    public final Uri d;
    public final Bundle e;

    public static String e(int source) {
        switch (source) {
            case 0:
                return "SOURCE_APP";
            case 1:
                return "SOURCE_CLIPBOARD";
            case 2:
                return "SOURCE_INPUT_METHOD";
            case 3:
                return "SOURCE_DRAG_AND_DROP";
            default:
                return String.valueOf(source);
        }
    }

    public static String a(int flags) {
        if ((flags & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(flags);
    }

    public c(a b2) {
        ClipData clipData = b2.f437a;
        a.h.j.i.e(clipData);
        this.f435a = clipData;
        int i = b2.f438b;
        a.h.j.i.b(i, 0, 3, "source");
        this.f436b = i;
        int i2 = b2.c;
        a.h.j.i.d(i2, 1);
        this.c = i2;
        this.d = b2.d;
        this.e = b2.e;
    }

    public String toString() {
        return "ContentInfoCompat{clip=" + this.f435a + ", source=" + e(this.f436b) + ", flags=" + a(this.c) + ", linkUri=" + this.d + ", extras=" + this.e + "}";
    }

    public ClipData b() {
        return this.f435a;
    }

    public int d() {
        return this.f436b;
    }

    public int c() {
        return this.c;
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ClipData f437a;

        /* renamed from: b, reason: collision with root package name */
        public int f438b;
        public int c;
        public Uri d;
        public Bundle e;

        public a(ClipData clip, int source) {
            this.f437a = clip;
            this.f438b = source;
        }

        public a c(int flags) {
            this.c = flags;
            return this;
        }

        public a d(Uri linkUri) {
            this.d = linkUri;
            return this;
        }

        public a b(Bundle extras) {
            this.e = extras;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}
