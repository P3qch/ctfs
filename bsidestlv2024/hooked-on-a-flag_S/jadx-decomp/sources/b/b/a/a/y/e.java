package b.b.a.a.y;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static e f1127a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1128b = new Object();
    public final Handler c = new Handler(Looper.getMainLooper(), new a());

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public static class c {
    }

    public static e b() {
        if (f1127a == null) {
            f1127a = new e();
        }
        return f1127a;
    }

    /* loaded from: classes.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    e.this.c((c) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    }

    public void e(b callback) {
        synchronized (this.f1128b) {
            d(callback);
        }
    }

    public void f(b callback) {
        synchronized (this.f1128b) {
            d(callback);
        }
    }

    public final boolean a(c record, int event) {
        record.getClass();
        WeakReference weakReference = null;
        weakReference.get();
        throw null;
    }

    public final boolean d(b callback) {
        return false;
    }

    public void c(c record) {
        synchronized (this.f1128b) {
            if (record == null || record == null) {
                a(record, 2);
                throw null;
            }
        }
    }
}
