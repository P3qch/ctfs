package a.h.g;

import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f380a;

    /* renamed from: b, reason: collision with root package name */
    public a f381b;
    public boolean c;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.f380a;
        }
        return z;
    }

    public void a() {
        synchronized (this) {
            if (this.f380a) {
                return;
            }
            this.f380a = true;
            this.c = true;
            a listener = this.f381b;
            CancellationSignal cancellationSignal = null;
            if (listener != null) {
                try {
                    listener.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.c = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (0 != 0) {
                cancellationSignal.cancel();
            }
            synchronized (this) {
                this.c = false;
                notifyAll();
            }
        }
    }

    public void c(a listener) {
        synchronized (this) {
            d();
            if (this.f381b == listener) {
                return;
            }
            this.f381b = listener;
            if (this.f380a && listener != null) {
                listener.a();
            }
        }
    }

    public final void d() {
        while (this.c) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
