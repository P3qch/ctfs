package a.h.b;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;

/* loaded from: classes.dex */
public class a extends a.h.c.a {
    public static void f(Activity activity) {
        activity.finishAffinity();
    }

    public static void g(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            activity.recreate();
            return;
        }
        if (i <= 23) {
            Handler handler = new Handler(activity.getMainLooper());
            handler.post(new RunnableC0017a(activity));
        } else if (!b.i(activity)) {
            activity.recreate();
        }
    }

    /* renamed from: a.h.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0017a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f339b;

        public RunnableC0017a(Activity activity) {
            this.f339b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f339b.isFinishing() && !b.i(this.f339b)) {
                this.f339b.recreate();
            }
        }
    }
}
