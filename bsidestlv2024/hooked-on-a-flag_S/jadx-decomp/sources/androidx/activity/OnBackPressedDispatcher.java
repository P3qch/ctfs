package androidx.activity;

import a.a.b;
import a.m.d;
import a.m.e;
import a.m.g;
import android.annotation.SuppressLint;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f777a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<b> f778b = new ArrayDeque<>();

    public OnBackPressedDispatcher(Runnable fallbackOnBackPressed) {
        this.f777a = fallbackOnBackPressed;
    }

    public a.a.a b(b onBackPressedCallback) {
        this.f778b.add(onBackPressedCallback);
        a cancellable = new a(onBackPressedCallback);
        onBackPressedCallback.a(cancellable);
        return cancellable;
    }

    @SuppressLint({"LambdaLast"})
    public void a(g owner, b onBackPressedCallback) {
        d lifecycle = owner.a();
        if (lifecycle.b() == d.b.DESTROYED) {
            return;
        }
        onBackPressedCallback.a(new LifecycleOnBackPressedCancellable(lifecycle, onBackPressedCallback));
    }

    public void c() {
        Iterator<b> descendingIterator = this.f778b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b callback = descendingIterator.next();
            if (callback.c()) {
                callback.b();
                return;
            }
        }
        Runnable runnable = this.f777a;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* loaded from: classes.dex */
    public class a implements a.a.a {

        /* renamed from: a, reason: collision with root package name */
        public final b f781a;

        public a(b onBackPressedCallback) {
            this.f781a = onBackPressedCallback;
        }

        @Override // a.a.a
        public void cancel() {
            OnBackPressedDispatcher.this.f778b.remove(this.f781a);
            this.f781a.e(this);
        }
    }

    /* loaded from: classes.dex */
    public class LifecycleOnBackPressedCancellable implements e, a.a.a {

        /* renamed from: a, reason: collision with root package name */
        public final d f779a;

        /* renamed from: b, reason: collision with root package name */
        public final b f780b;
        public a.a.a c;

        public LifecycleOnBackPressedCancellable(d lifecycle, b onBackPressedCallback) {
            this.f779a = lifecycle;
            this.f780b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // a.m.e
        public void g(g source, d.a event) {
            if (event == d.a.ON_START) {
                this.c = OnBackPressedDispatcher.this.b(this.f780b);
                return;
            }
            if (event == d.a.ON_STOP) {
                a.a.a aVar = this.c;
                if (aVar != null) {
                    aVar.cancel();
                    return;
                }
                return;
            }
            if (event == d.a.ON_DESTROY) {
                cancel();
            }
        }

        @Override // a.a.a
        public void cancel() {
            this.f779a.c(this);
            this.f780b.e(this);
            a.a.a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
                this.c = null;
            }
        }
    }
}
