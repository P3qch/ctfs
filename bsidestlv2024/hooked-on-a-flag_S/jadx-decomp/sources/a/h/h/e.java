package a.h.h;

import a.h.h.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.core.provider.FontRequestWorker;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a.e.e<String, Typeface> f389a = new a.e.e<>(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f390b = g.a("fonts-androidx", 10, 10000);
    public static final Object c = new Object();
    public static final a.e.g<String, ArrayList<a.h.j.a<C0023e>>> d = new a.e.g<>();

    public static Typeface e(Context context, a.h.h.d request, a.h.h.a callback, int style, int timeoutInMillis) {
        String id = a(request, style);
        Typeface cached = f389a.c(id);
        if (cached != null) {
            callback.b(new C0023e(cached));
            return cached;
        }
        if (timeoutInMillis == -1) {
            C0023e typefaceResult = c(id, context, request, style);
            callback.b(typefaceResult);
            return typefaceResult.f397a;
        }
        Callable<FontRequestWorker.TypefaceResult> fetcher = new a(id, context, request, style);
        try {
            C0023e typefaceResult2 = (C0023e) g.c(f390b, fetcher, timeoutInMillis);
            callback.b(typefaceResult2);
            return typefaceResult2.f397a;
        } catch (InterruptedException e) {
            callback.b(new C0023e(-3));
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Callable<C0023e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f391a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f392b;
        public final /* synthetic */ a.h.h.d c;
        public final /* synthetic */ int d;

        public a(String str, Context context, a.h.h.d dVar, int i) {
            this.f391a = str;
            this.f392b = context;
            this.c = dVar;
            this.d = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0023e call() {
            return e.c(this.f391a, this.f392b, this.c, this.d);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.h.j.a != androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker$TypefaceResult> */
    public static Typeface d(Context context, a.h.h.d request, int style, Executor executor, a.h.h.a callback) {
        String id = a(request, style);
        Typeface cached = f389a.c(id);
        if (cached != null) {
            callback.b(new C0023e(cached));
            return cached;
        }
        b bVar = new b(callback);
        synchronized (c) {
            a.e.g<String, ArrayList<a.h.j.a<C0023e>>> gVar = d;
            ArrayList<a.h.j.a<C0023e>> arrayList = gVar.get(id);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<a.h.j.a<C0023e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            gVar.put(id, arrayList2);
            Callable<FontRequestWorker.TypefaceResult> fetcher = new c(id, context, request, style);
            Executor finalExecutor = executor == null ? f390b : executor;
            g.b(finalExecutor, fetcher, new d(id));
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.h.j.a<C0023e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.h.h.a f393a;

        public b(a.h.h.a aVar) {
            this.f393a = aVar;
        }

        @Override // a.h.j.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C0023e typefaceResult) {
            this.f393a.b(typefaceResult);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Callable<C0023e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f394a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f395b;
        public final /* synthetic */ a.h.h.d c;
        public final /* synthetic */ int d;

        public c(String str, Context context, a.h.h.d dVar, int i) {
            this.f394a = str;
            this.f395b = context;
            this.c = dVar;
            this.d = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0023e call() {
            C0023e typeface = e.c(this.f394a, this.f395b, this.c, this.d);
            return typeface;
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.h.j.a<C0023e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f396a;

        public d(String str) {
            this.f396a = str;
        }

        @Override // a.h.j.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C0023e typefaceResult) {
            synchronized (e.c) {
                a.e.g<String, ArrayList<a.h.j.a<C0023e>>> gVar = e.d;
                ArrayList<a.h.j.a<C0023e>> arrayList = gVar.get(this.f396a);
                if (arrayList == null) {
                    return;
                }
                gVar.remove(this.f396a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).a(typefaceResult);
                }
            }
        }
    }

    public static String a(a.h.h.d request, int style) {
        return request.d() + "-" + style;
    }

    public static C0023e c(String cacheId, Context context, a.h.h.d request, int style) {
        a.e.e<String, Typeface> eVar = f389a;
        Typeface cached = eVar.c(cacheId);
        if (cached != null) {
            return new C0023e(cached);
        }
        try {
            f.a result = a.h.h.c.d(context, request, null);
            int fontFamilyResultStatus = b(result);
            if (fontFamilyResultStatus != 0) {
                return new C0023e(fontFamilyResultStatus);
            }
            Typeface typeface = a.h.d.d.b(context, null, result.b(), style);
            if (typeface != null) {
                eVar.d(cacheId, typeface);
                return new C0023e(typeface);
            }
            return new C0023e(-3);
        } catch (PackageManager.NameNotFoundException e) {
            return new C0023e(-1);
        }
    }

    @SuppressLint({"WrongConstant"})
    public static int b(f.a fontFamilyResult) {
        if (fontFamilyResult.c() != 0) {
            switch (fontFamilyResult.c()) {
                case 1:
                    return -2;
                default:
                    return -3;
            }
        }
        f.b[] fonts = fontFamilyResult.b();
        if (fonts == null || fonts.length == 0) {
            return 1;
        }
        for (f.b font : fonts) {
            int resultCode = font.b();
            if (resultCode != 0) {
                if (resultCode < 0) {
                    return -3;
                }
                return resultCode;
            }
        }
        return 0;
    }

    /* renamed from: a.h.h.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0023e {

        /* renamed from: a, reason: collision with root package name */
        public final Typeface f397a;

        /* renamed from: b, reason: collision with root package name */
        public final int f398b;

        public C0023e(int result) {
            this.f397a = null;
            this.f398b = result;
        }

        @SuppressLint({"WrongConstant"})
        public C0023e(Typeface typeface) {
            this.f397a = typeface;
            this.f398b = 0;
        }

        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f398b == 0;
        }
    }
}
