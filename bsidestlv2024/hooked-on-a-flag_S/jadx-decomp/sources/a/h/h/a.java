package a.h.h;

import a.h.h.e;
import a.h.h.f;
import android.graphics.Typeface;
import android.os.Handler;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final f.c f382a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f383b;

    public a(f.c callback, Handler callbackHandler) {
        this.f382a = callback;
        this.f383b = callbackHandler;
    }

    /* renamed from: a.h.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0022a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f.c f384b;
        public final /* synthetic */ Typeface c;

        public RunnableC0022a(a this$0, f.c cVar, Typeface typeface) {
            this.f384b = cVar;
            this.c = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f384b.b(this.c);
        }
    }

    public final void c(Typeface typeface) {
        f.c callback = this.f382a;
        this.f383b.post(new RunnableC0022a(this, callback, typeface));
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f.c f385b;
        public final /* synthetic */ int c;

        public b(a this$0, f.c cVar, int i) {
            this.f385b = cVar;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f385b.a(this.c);
        }
    }

    public final void a(int reason) {
        f.c callback = this.f382a;
        this.f383b.post(new b(this, callback, reason));
    }

    public void b(e.C0023e typefaceResult) {
        if (typefaceResult.a()) {
            c(typefaceResult.f397a);
        } else {
            a(typefaceResult.f398b);
        }
    }
}
