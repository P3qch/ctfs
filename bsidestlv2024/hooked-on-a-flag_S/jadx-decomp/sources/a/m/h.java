package a.m;

import a.c.a.b.b;
import a.m.d;
import android.annotation.SuppressLint;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleRegistry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: a, reason: collision with root package name */
    public a.c.a.b.a<f, a> f621a;

    /* renamed from: b, reason: collision with root package name */
    public d.b f622b;
    public final WeakReference<g> c;
    public int d;
    public boolean e;
    public boolean f;
    public ArrayList<d.b> g;
    public final boolean h;

    public h(g provider) {
        this(provider, true);
    }

    public h(g provider, boolean enforceMainThread) {
        this.f621a = new a.c.a.b.a<>();
        this.d = 0;
        this.e = false;
        this.f = false;
        this.g = new ArrayList<>();
        this.c = new WeakReference<>(provider);
        this.f622b = d.b.INITIALIZED;
        this.h = enforceMainThread;
    }

    @Deprecated
    public void j(d.b state) {
        f("markState");
        o(state);
    }

    public void o(d.b state) {
        f("setCurrentState");
        l(state);
    }

    public void h(d.a event) {
        f("handleLifecycleEvent");
        l(event.b());
    }

    public final void l(d.b next) {
        if (this.f622b == next) {
            return;
        }
        this.f622b = next;
        if (this.e || this.d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        p();
        this.e = false;
    }

    public final boolean i() {
        if (this.f621a.size() == 0) {
            return true;
        }
        d.b eldestObserverState = ((a) ((b.c) this.f621a.b()).getValue()).f623a;
        d.b newestObserverState = ((a) ((b.c) this.f621a.e()).getValue()).f623a;
        return eldestObserverState == newestObserverState && this.f622b == newestObserverState;
    }

    public final d.b e(f observer) {
        Map.Entry<f, a> i = this.f621a.i(observer);
        d.b parentState = null;
        d.b siblingState = i != null ? ((a) ((b.c) i).getValue()).f623a : null;
        if (!this.g.isEmpty()) {
            parentState = this.g.get(r1.size() - 1);
        }
        return k(k(this.f622b, siblingState), parentState);
    }

    @Override // a.m.d
    public void a(f observer) {
        g lifecycleOwner;
        f("addObserver");
        d.b bVar = this.f622b;
        d.b bVar2 = d.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = d.b.INITIALIZED;
        }
        d.b initialState = bVar2;
        a statefulObserver = new a(observer, initialState);
        a previous = this.f621a.g(observer, statefulObserver);
        if (previous != null || (lifecycleOwner = this.c.get()) == null) {
            return;
        }
        boolean isReentrance = this.d != 0 || this.e;
        d.b targetState = e(observer);
        this.d++;
        while (statefulObserver.f623a.compareTo(targetState) < 0 && this.f621a.contains(observer)) {
            n(statefulObserver.f623a);
            d.a event = d.a.c(statefulObserver.f623a);
            if (event == null) {
                throw new IllegalStateException("no event up from " + statefulObserver.f623a);
            }
            statefulObserver.a(lifecycleOwner, event);
            m();
            targetState = e(observer);
        }
        if (!isReentrance) {
            p();
        }
        this.d--;
    }

    public final void m() {
        this.g.remove(r0.size() - 1);
    }

    public final void n(d.b state) {
        this.g.add(state);
    }

    @Override // a.m.d
    public void c(f observer) {
        f("removeObserver");
        this.f621a.h(observer);
    }

    @Override // a.m.d
    public d.b b() {
        return this.f622b;
    }

    public final void g(g lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, LifecycleRegistry.ObserverWithState>> ascendingIterator = this.f621a.d();
        while (ascendingIterator.hasNext() && !this.f) {
            Map.Entry<LifecycleObserver, LifecycleRegistry.ObserverWithState> entry = (Map.Entry) ascendingIterator.next();
            a observer = (a) entry.getValue();
            while (observer.f623a.compareTo(this.f622b) < 0 && !this.f && this.f621a.contains(entry.getKey())) {
                n(observer.f623a);
                d.a event = d.a.c(observer.f623a);
                if (event == null) {
                    throw new IllegalStateException("no event up from " + observer.f623a);
                }
                observer.a(lifecycleOwner, event);
                m();
            }
        }
    }

    public final void d(g lifecycleOwner) {
        Iterator<Map.Entry<f, a>> a2 = this.f621a.a();
        while (((b.e) a2).hasNext() && !this.f) {
            Map.Entry<LifecycleObserver, LifecycleRegistry.ObserverWithState> entry = (Map.Entry) ((b.e) a2).next();
            a observer = (a) entry.getValue();
            while (observer.f623a.compareTo(this.f622b) > 0 && !this.f && this.f621a.contains(entry.getKey())) {
                d.a event = d.a.a(observer.f623a);
                if (event == null) {
                    throw new IllegalStateException("no event down from " + observer.f623a);
                }
                n(event.b());
                observer.a(lifecycleOwner, event);
                m();
            }
        }
    }

    public final void p() {
        g lifecycleOwner = this.c.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f = false;
            if (this.f622b.compareTo(((a) ((b.c) this.f621a.b()).getValue()).f623a) < 0) {
                d(lifecycleOwner);
            }
            Map.Entry<f, a> e = this.f621a.e();
            if (!this.f && e != null && this.f622b.compareTo(((a) ((b.c) e).getValue()).f623a) > 0) {
                g(lifecycleOwner);
            }
        }
        this.f = false;
    }

    @SuppressLint({"RestrictedApi"})
    public final void f(String methodName) {
        if (this.h && !a.c.a.a.a.d().b()) {
            throw new IllegalStateException("Method " + methodName + " must be called on the main thread");
        }
    }

    public static d.b k(d.b state1, d.b state2) {
        return (state2 == null || state2.compareTo(state1) >= 0) ? state1 : state2;
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public d.b f623a;

        /* renamed from: b, reason: collision with root package name */
        public e f624b;

        public a(f observer, d.b initialState) {
            this.f624b = j.f(observer);
            this.f623a = initialState;
        }

        public void a(g owner, d.a event) {
            d.b newState = event.b();
            this.f623a = h.k(this.f623a, newState);
            this.f624b.g(owner, event);
            this.f623a = newState;
        }
    }
}
