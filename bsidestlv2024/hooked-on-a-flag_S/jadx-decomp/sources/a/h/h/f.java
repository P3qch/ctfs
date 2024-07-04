package a.h.h;

import a.h.j.i;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;

/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public static class c {
        public void a(int i) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, d request, int style, boolean isBlockingFetch, int timeout, Handler handler, c callback) {
        a.h.h.a callbackWrapper = new a.h.h.a(callback, handler);
        if (isBlockingFetch) {
            return e.e(context, request, callbackWrapper, style, timeout);
        }
        return e.d(context, request, style, null, callbackWrapper);
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f401a;

        /* renamed from: b, reason: collision with root package name */
        public final int f402b;
        public final int c;
        public final boolean d;
        public final int e;

        @Deprecated
        public b(Uri uri, int ttcIndex, int weight, boolean italic, int resultCode) {
            i.e(uri);
            this.f401a = uri;
            this.f402b = ttcIndex;
            this.c = weight;
            this.d = italic;
            this.e = resultCode;
        }

        public static b a(Uri uri, int ttcIndex, int weight, boolean italic, int resultCode) {
            return new b(uri, ttcIndex, weight, italic, resultCode);
        }

        public Uri d() {
            return this.f401a;
        }

        public int c() {
            return this.f402b;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }

        public int b() {
            return this.e;
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f399a;

        /* renamed from: b, reason: collision with root package name */
        public final b[] f400b;

        @Deprecated
        public a(int statusCode, b[] fonts) {
            this.f399a = statusCode;
            this.f400b = fonts;
        }

        public int c() {
            return this.f399a;
        }

        public b[] b() {
            return this.f400b;
        }

        public static a a(int statusCode, b[] fonts) {
            return new a(statusCode, fonts);
        }
    }
}
