package a.h.d;

import a.h.c.c.c;
import a.h.c.c.f;
import a.h.h.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final j f369a;

    /* renamed from: b, reason: collision with root package name */
    public static final a.e.e<String, Typeface> f370b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f369a = new i();
        } else if (i >= 28) {
            f369a = new h();
        } else if (i >= 26) {
            f369a = new g();
        } else if (i >= 24 && f.m()) {
            f369a = new f();
        } else if (i >= 21) {
            f369a = new e();
        } else {
            f369a = new j();
        }
        f370b = new a.e.e<>(16);
    }

    public static Typeface f(Resources resources, int id, int style) {
        return f370b.c(e(resources, id, style));
    }

    public static String e(Resources resources, int id, int style) {
        return resources.getResourcePackageName(id) + "-" + id + "-" + style;
    }

    public static Typeface h(String familyName) {
        if (familyName == null || familyName.isEmpty()) {
            return null;
        }
        Typeface typeface = Typeface.create(familyName, 0);
        Typeface defaultTypeface = Typeface.create(Typeface.DEFAULT, 0);
        if (typeface == null || typeface.equals(defaultTypeface)) {
            return null;
        }
        return typeface;
    }

    public static Typeface c(Context context, c.a entry, Resources resources, int id, int style, f.a fontCallback, Handler handler, boolean isRequestFromLayoutInflator) {
        Typeface typeface;
        boolean isBlocking;
        if (!(entry instanceof c.d)) {
            typeface = f369a.b(context, (c.b) entry, resources, style);
            if (fontCallback != null) {
                if (typeface != null) {
                    fontCallback.b(typeface, handler);
                } else {
                    fontCallback.a(-3, handler);
                }
            }
        } else {
            c.d providerEntry = (c.d) entry;
            Typeface fontFamilyTypeface = h(providerEntry.c());
            if (fontFamilyTypeface != null) {
                if (fontCallback != null) {
                    fontCallback.b(fontFamilyTypeface, handler);
                }
                return fontFamilyTypeface;
            }
            if (isRequestFromLayoutInflator) {
                isBlocking = providerEntry.a() == 0;
            } else {
                isBlocking = fontCallback == null;
            }
            int timeout = isRequestFromLayoutInflator ? providerEntry.d() : -1;
            Handler newHandler = f.a.c(handler);
            a newCallback = new a(fontCallback);
            typeface = a.h.h.f.a(context, providerEntry.b(), style, isBlocking, timeout, newHandler, newCallback);
        }
        if (typeface != null) {
            f370b.d(e(resources, id, style), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int id, String path, int style) {
        Typeface typeface = f369a.e(context, resources, id, path, style);
        if (typeface != null) {
            String resourceUid = e(resources, id, style);
            f370b.d(resourceUid, typeface);
        }
        return typeface;
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] fonts, int style) {
        return f369a.c(context, cancellationSignal, fonts, style);
    }

    public static Typeface g(Context context, Typeface typeface, int style) {
        j jVar = f369a;
        c.b families = jVar.i(typeface);
        if (families == null) {
            return null;
        }
        return jVar.b(context, families, context.getResources(), style);
    }

    public static Typeface a(Context context, Typeface family, int style) {
        Typeface typefaceFromFamily;
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        if (Build.VERSION.SDK_INT < 21 && (typefaceFromFamily = g(context, family, style)) != null) {
            return typefaceFromFamily;
        }
        return Typeface.create(family, style);
    }

    /* loaded from: classes.dex */
    public static class a extends f.c {

        /* renamed from: a, reason: collision with root package name */
        public f.a f371a;

        public a(f.a fontCallback) {
            this.f371a = fontCallback;
        }

        @Override // a.h.h.f.c
        public void b(Typeface typeface) {
            f.a aVar = this.f371a;
            if (aVar != null) {
                aVar.e(typeface);
            }
        }

        @Override // a.h.h.f.c
        public void a(int reason) {
            f.a aVar = this.f371a;
            if (aVar != null) {
                aVar.d(reason);
            }
        }
    }
}
