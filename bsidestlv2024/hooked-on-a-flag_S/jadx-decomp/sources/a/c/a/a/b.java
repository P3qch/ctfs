package a.c.a.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f225a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f226b = Executors.newFixedThreadPool(4, new a(this));
    public volatile Handler c;

    /* loaded from: classes.dex */
    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f227a = new AtomicInteger(0);

        public a(b this$0) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f227a.getAndIncrement())));
            return t;
        }
    }

    @Override // a.c.a.a.c
    public void a(Runnable runnable) {
        this.f226b.execute(runnable);
    }

    @Override // a.c.a.a.c
    public void c(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.f225a) {
                if (this.c == null) {
                    this.c = d(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }

    @Override // a.c.a.a.c
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
        } catch (IllegalAccessException e) {
            return new Handler(looper);
        } catch (InstantiationException e2) {
            return new Handler(looper);
        } catch (NoSuchMethodException e3) {
            return new Handler(looper);
        } catch (InvocationTargetException e4) {
            return new Handler(looper);
        }
    }
}
