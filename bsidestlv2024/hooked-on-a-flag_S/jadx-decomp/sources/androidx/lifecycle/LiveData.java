package androidx.lifecycle;

import a.k.b.d;
import a.m.d;
import a.m.e;
import a.m.g;
import a.m.m;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f864a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Object f865b = new Object();
    public a.c.a.b.b<m<? super T>, LiveData<T>.c> c = new a.c.a.b.b<>();
    public int d = 0;
    public boolean e;
    public volatile Object f;
    public volatile Object g;
    public int h;
    public boolean i;
    public boolean j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object newValue;
            synchronized (LiveData.this.f865b) {
                newValue = LiveData.this.g;
                LiveData.this.g = LiveData.f864a;
            }
            LiveData.this.j(newValue);
        }
    }

    public LiveData() {
        Object obj = f864a;
        this.g = obj;
        new a();
        this.f = obj;
        this.h = -1;
    }

    /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$c != androidx.lifecycle.LiveData<T>$ObserverWrapper */
    public final void c(LiveData<T>.c cVar) {
        if (!cVar.f868b) {
            return;
        }
        if (!cVar.k()) {
            cVar.h(false);
            return;
        }
        int i = cVar.c;
        int i2 = this.h;
        if (i >= i2) {
            return;
        }
        cVar.c = i2;
        ((d.C0042d) cVar.f867a).b(this.f);
    }

    /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$c != androidx.lifecycle.LiveData<T>$ObserverWrapper */
    public void d(LiveData<T>.c cVar) {
        if (this.i) {
            this.j = true;
            return;
        }
        this.i = true;
        do {
            this.j = false;
            if (cVar != null) {
                c(cVar);
                cVar = null;
            } else {
                Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> iterator = this.c.d();
                while (iterator.hasNext()) {
                    c((c) ((Map.Entry) iterator.next()).getValue());
                    if (this.j) {
                        break;
                    }
                }
            }
        } while (this.j);
        this.i = false;
    }

    /* JADX WARN: Generic types in debug info not equals: a.m.m != androidx.lifecycle.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$c != androidx.lifecycle.LiveData<T>$ObserverWrapper */
    public void e(g owner, m<? super T> mVar) {
        a("observe");
        if (owner.a().b() == d.b.DESTROYED) {
            return;
        }
        LiveData<T>.LifecycleBoundObserver wrapper = new LifecycleBoundObserver(owner, mVar);
        LiveData<T>.c g = this.c.g(mVar, wrapper);
        if (g != null && !g.j(owner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (g != null) {
            return;
        }
        owner.a().a(wrapper);
    }

    /* JADX WARN: Generic types in debug info not equals: a.m.m != androidx.lifecycle.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$b != androidx.lifecycle.LiveData<T>$AlwaysActiveObserver */
    /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$c != androidx.lifecycle.LiveData<T>$ObserverWrapper */
    public void f(m<? super T> mVar) {
        a("observeForever");
        b bVar = new b(this, mVar);
        LiveData<T>.c g = this.c.g(mVar, bVar);
        if (g instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (g != null) {
            return;
        }
        bVar.h(true);
    }

    /* JADX WARN: Generic types in debug info not equals: a.m.m != androidx.lifecycle.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$c != androidx.lifecycle.LiveData<T>$ObserverWrapper */
    public void i(m<? super T> mVar) {
        a("removeObserver");
        LiveData<T>.c h = this.c.h(mVar);
        if (h == null) {
            return;
        }
        h.i();
        h.h(false);
    }

    public void j(T value) {
        a("setValue");
        this.h++;
        this.f = value;
        d(null);
    }

    public void g() {
    }

    public void h() {
    }

    public void b(int change) {
        int previousActiveCount = this.d;
        this.d += change;
        if (this.e) {
            return;
        }
        this.e = true;
        while (true) {
            try {
                int i = this.d;
                if (previousActiveCount != i) {
                    boolean needToCallActive = previousActiveCount == 0 && i > 0;
                    boolean needToCallInactive = previousActiveCount > 0 && i == 0;
                    previousActiveCount = i;
                    if (needToCallActive) {
                        g();
                    } else if (needToCallInactive) {
                        h();
                    }
                } else {
                    return;
                }
            } finally {
                this.e = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.c implements e {
        public final g e;

        /* JADX WARN: Generic types in debug info not equals: a.m.m != androidx.lifecycle.Observer<? super T> */
        public LifecycleBoundObserver(g owner, m<? super T> mVar) {
            super(mVar);
            this.e = owner;
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return this.e.a().b().a(d.b.STARTED);
        }

        @Override // a.m.e
        public void g(g source, d.a event) {
            d.b currentState = this.e.a().b();
            if (currentState == d.b.DESTROYED) {
                LiveData.this.i(this.f867a);
                return;
            }
            d.b prevState = null;
            while (prevState != currentState) {
                prevState = currentState;
                h(k());
                currentState = this.e.a().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean j(g owner) {
            return this.e == owner;
        }

        @Override // androidx.lifecycle.LiveData.c
        public void i() {
            this.e.a().c(this);
        }
    }

    /* loaded from: classes.dex */
    public abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final m<? super T> f867a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f868b;
        public int c = -1;

        public abstract boolean k();

        /* JADX WARN: Generic types in debug info not equals: a.m.m != androidx.lifecycle.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$c != androidx.lifecycle.LiveData<T>$ObserverWrapper */
        public c(m<? super T> mVar) {
            this.f867a = mVar;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$c != androidx.lifecycle.LiveData<T>$ObserverWrapper */
        public boolean j(g owner) {
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$c != androidx.lifecycle.LiveData<T>$ObserverWrapper */
        public void i() {
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$c != androidx.lifecycle.LiveData<T>$ObserverWrapper */
        public void h(boolean newActive) {
            if (newActive == this.f868b) {
                return;
            }
            this.f868b = newActive;
            LiveData.this.b(newActive ? 1 : -1);
            if (this.f868b) {
                LiveData.this.d(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends LiveData<T>.c {
        /* JADX WARN: Generic types in debug info not equals: a.m.m != androidx.lifecycle.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$b != androidx.lifecycle.LiveData<T>$AlwaysActiveObserver */
        public b(LiveData liveData, m<? super T> mVar) {
            super(mVar);
        }

        /* JADX WARN: Generic types in debug info not equals: androidx.lifecycle.LiveData$b != androidx.lifecycle.LiveData<T>$AlwaysActiveObserver */
        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return true;
        }
    }

    public static void a(String methodName) {
        if (!a.c.a.a.a.d().b()) {
            throw new IllegalStateException("Cannot invoke " + methodName + " on a background thread");
        }
    }
}
