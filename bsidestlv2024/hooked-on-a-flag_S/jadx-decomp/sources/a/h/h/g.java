package a.h.h;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class g {
    /* JADX WARN: Generic types in debug info not equals: a.h.j.a != androidx.core.util.Consumer<T> */
    public static <T> void b(Executor executor, Callable<T> callable, a.h.j.a<T> aVar) {
        Handler calleeHandler = a.h.h.b.a();
        executor.execute(new b(calleeHandler, callable, aVar));
    }

    public static <T> T c(ExecutorService executor, Callable<T> callable, int timeoutMillis) {
        Future<T> future = executor.submit(callable);
        try {
            return future.get(timeoutMillis, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException e3) {
            throw new InterruptedException("timeout");
        }
    }

    public static ThreadPoolExecutor a(String threadName, int threadPriority, int keepAliveTimeInMillis) {
        ThreadFactory threadFactory = new a(threadName, threadPriority);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 1, keepAliveTimeInMillis, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), threadFactory);
        executor.allowCoreThreadTimeOut(true);
        return executor;
    }

    /* loaded from: classes.dex */
    public static class b<T> implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public Callable<T> f406b;
        public a.h.j.a<T> c;
        public Handler d;

        /* JADX WARN: Generic types in debug info not equals: a.h.h.g$b != androidx.core.provider.RequestExecutor$ReplyRunnable<T> */
        /* JADX WARN: Generic types in debug info not equals: a.h.j.a != androidx.core.util.Consumer<T> */
        public b(Handler handler, Callable<T> callable, a.h.j.a<T> aVar) {
            this.f406b = callable;
            this.c = aVar;
            this.d = handler;
        }

        /* JADX WARN: Generic types in debug info not equals: a.h.h.g$b != androidx.core.provider.RequestExecutor$ReplyRunnable<T> */
        /* JADX WARN: Generic types in debug info not equals: a.h.j.a != androidx.core.util.Consumer<T> */
        @Override // java.lang.Runnable
        public void run() {
            T t;
            try {
                t = this.f406b.call();
            } catch (Exception e) {
                t = null;
            }
            T result = t;
            this.d.post(new a(this, this.c, result));
        }

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.h.j.a f407b;
            public final /* synthetic */ Object c;

            public a(b this$0, a.h.j.a aVar, Object obj) {
                this.f407b = aVar;
                this.c = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f407b.a(this.c);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public String f403a;

        /* renamed from: b, reason: collision with root package name */
        public int f404b;

        public a(String threadName, int priority) {
            this.f403a = threadName;
            this.f404b = priority;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0024a(runnable, this.f403a, this.f404b);
        }

        /* renamed from: a.h.h.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0024a extends Thread {

            /* renamed from: b, reason: collision with root package name */
            public final int f405b;

            public C0024a(Runnable target, String name, int priority) {
                super(target, name);
                this.f405b = priority;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f405b);
                super.run();
            }
        }
    }
}
