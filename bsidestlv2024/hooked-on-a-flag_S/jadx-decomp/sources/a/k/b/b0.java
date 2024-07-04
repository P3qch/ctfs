package a.k.b;

import a.h.g.b;
import a.k.b.n;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f516a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<d> f517b = new ArrayList<>();
    public final ArrayList<d> c = new ArrayList<>();
    public boolean d = false;
    public boolean e = false;

    public abstract void f(List<d> list, boolean z);

    public static b0 n(ViewGroup container, n fragmentManager) {
        c0 factory = fragmentManager.t0();
        return o(container, factory);
    }

    public static b0 o(ViewGroup container, c0 factory) {
        Object controller = container.getTag(R.id.special_effects_controller_view_tag);
        if (controller instanceof b0) {
            return (b0) controller;
        }
        b0 newController = ((n.f) factory).a(container);
        container.setTag(R.id.special_effects_controller_view_tag, newController);
        return newController;
    }

    public b0(ViewGroup container) {
        this.f516a = container;
    }

    public ViewGroup m() {
        return this.f516a;
    }

    public d.b l(t fragmentStateManager) {
        d.b lifecycleImpact = null;
        d pendingOperation = h(fragmentStateManager.k());
        if (pendingOperation != null) {
            lifecycleImpact = pendingOperation.g();
        }
        d runningOperation = i(fragmentStateManager.k());
        if (runningOperation != null && (lifecycleImpact == null || lifecycleImpact == d.b.NONE)) {
            return runningOperation.g();
        }
        return lifecycleImpact;
    }

    public final d h(Fragment fragment) {
        Iterator<d> it = this.f517b.iterator();
        while (it.hasNext()) {
            d operation = it.next();
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    public final d i(Fragment fragment) {
        Iterator<d> it = this.c.iterator();
        while (it.hasNext()) {
            d operation = it.next();
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    public void b(d.c finalState, t fragmentStateManager) {
        if (n.A0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        a(finalState, d.b.ADDING, fragmentStateManager);
    }

    public void e(t fragmentStateManager) {
        if (n.A0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        a(d.c.VISIBLE, d.b.NONE, fragmentStateManager);
    }

    public void c(t fragmentStateManager) {
        if (n.A0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        a(d.c.GONE, d.b.NONE, fragmentStateManager);
    }

    public void d(t fragmentStateManager) {
        if (n.A0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        a(d.c.REMOVED, d.b.REMOVING, fragmentStateManager);
    }

    public final void a(d.c finalState, d.b lifecycleImpact, t fragmentStateManager) {
        synchronized (this.f517b) {
            a.h.g.b signal = new a.h.g.b();
            d existingOperation = h(fragmentStateManager.k());
            if (existingOperation != null) {
                existingOperation.k(finalState, lifecycleImpact);
                return;
            }
            c operation = new c(finalState, lifecycleImpact, fragmentStateManager, signal);
            this.f517b.add(operation);
            operation.a(new a(operation));
            operation.a(new b(operation));
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f518b;

        public a(c cVar) {
            this.f518b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b0.this.f517b.contains(this.f518b)) {
                this.f518b.e().a(this.f518b.f().I);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f519b;

        public b(c cVar) {
            this.f519b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f517b.remove(this.f519b);
            b0.this.c.remove(this.f519b);
        }
    }

    public void r(boolean isPop) {
        this.d = isPop;
    }

    public void p() {
        synchronized (this.f517b) {
            q();
            this.e = false;
            int index = this.f517b.size() - 1;
            while (true) {
                if (index < 0) {
                    break;
                }
                d operation = this.f517b.get(index);
                d.c currentState = d.c.c(operation.f().I);
                d.c e = operation.e();
                d.c cVar = d.c.VISIBLE;
                if (e != cVar || currentState == cVar) {
                    index--;
                } else {
                    Fragment fragment = operation.f();
                    this.e = fragment.Y();
                    break;
                }
            }
        }
    }

    public void k() {
        if (this.e) {
            this.e = false;
            g();
        }
    }

    public void g() {
        if (this.e) {
            return;
        }
        if (!a.h.k.v.S(this.f516a)) {
            j();
            this.d = false;
            return;
        }
        synchronized (this.f517b) {
            if (!this.f517b.isEmpty()) {
                ArrayList<SpecialEffectsController.Operation> currentlyRunningOperations = new ArrayList<>(this.c);
                this.c.clear();
                Iterator<SpecialEffectsController.Operation> it = currentlyRunningOperations.iterator();
                while (it.hasNext()) {
                    d operation = (d) it.next();
                    if (n.A0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                    }
                    operation.b();
                    if (!operation.i()) {
                        this.c.add(operation);
                    }
                }
                q();
                ArrayList<SpecialEffectsController.Operation> newPendingOperations = new ArrayList<>(this.f517b);
                this.f517b.clear();
                this.c.addAll(newPendingOperations);
                Iterator<SpecialEffectsController.Operation> it2 = newPendingOperations.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).l();
                }
                f(newPendingOperations, this.d);
                this.d = false;
            }
        }
    }

    public void j() {
        String str;
        String str2;
        boolean attachedToWindow = a.h.k.v.S(this.f516a);
        synchronized (this.f517b) {
            q();
            Iterator<d> it = this.f517b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            ArrayList<SpecialEffectsController.Operation> runningOperations = new ArrayList<>(this.c);
            Iterator<SpecialEffectsController.Operation> it2 = runningOperations.iterator();
            while (it2.hasNext()) {
                d operation = (d) it2.next();
                if (n.A0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (attachedToWindow) {
                        str2 = BuildConfig.FLAVOR;
                    } else {
                        str2 = "Container " + this.f516a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                    Log.v("FragmentManager", sb.toString());
                }
                operation.b();
            }
            ArrayList<SpecialEffectsController.Operation> pendingOperations = new ArrayList<>(this.f517b);
            Iterator<SpecialEffectsController.Operation> it3 = pendingOperations.iterator();
            while (it3.hasNext()) {
                d operation2 = (d) it3.next();
                if (n.A0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (attachedToWindow) {
                        str = BuildConfig.FLAVOR;
                    } else {
                        str = "Container " + this.f516a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(operation2);
                    Log.v("FragmentManager", sb2.toString());
                }
                operation2.b();
            }
        }
    }

    public final void q() {
        Iterator<d> it = this.f517b.iterator();
        while (it.hasNext()) {
            d operation = it.next();
            if (operation.g() == d.b.ADDING) {
                Fragment fragment = operation.f();
                View view = fragment.g1();
                d.c finalState = d.c.b(view.getVisibility());
                operation.k(finalState, d.b.NONE);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public c f520a;

        /* renamed from: b, reason: collision with root package name */
        public b f521b;
        public final Fragment c;
        public final List<Runnable> d = new ArrayList();
        public final HashSet<a.h.g.b> e = new HashSet<>();
        public boolean f = false;
        public boolean g = false;

        /* loaded from: classes.dex */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* loaded from: classes.dex */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c c(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return b(view.getVisibility());
            }

            public static c b(int visibility) {
                switch (visibility) {
                    case 0:
                        return VISIBLE;
                    case 4:
                        return INVISIBLE;
                    case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                        return GONE;
                    default:
                        throw new IllegalArgumentException("Unknown visibility " + visibility);
                }
            }

            public void a(View view) {
                switch (this) {
                    case REMOVED:
                        ViewGroup parent = (ViewGroup) view.getParent();
                        if (parent != null) {
                            if (n.A0(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + parent);
                            }
                            parent.removeView(view);
                            return;
                        }
                        return;
                    case VISIBLE:
                        if (n.A0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                        }
                        view.setVisibility(0);
                        return;
                    case GONE:
                        if (n.A0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                        }
                        view.setVisibility(8);
                        return;
                    case INVISIBLE:
                        if (n.A0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    default:
                        return;
                }
            }
        }

        public d(c finalState, b lifecycleImpact, Fragment fragment, a.h.g.b cancellationSignal) {
            this.f520a = finalState;
            this.f521b = lifecycleImpact;
            this.c = fragment;
            cancellationSignal.c(new a());
        }

        /* loaded from: classes.dex */
        public class a implements b.a {
            public a() {
            }

            @Override // a.h.g.b.a
            public void a() {
                d.this.b();
            }
        }

        public c e() {
            return this.f520a;
        }

        public b g() {
            return this.f521b;
        }

        public final Fragment f() {
            return this.c;
        }

        public final boolean h() {
            return this.f;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f520a + "} {mLifecycleImpact = " + this.f521b + "} {mFragment = " + this.c + "}";
        }

        public final void b() {
            if (h()) {
                return;
            }
            this.f = true;
            if (this.e.isEmpty()) {
                c();
                return;
            }
            ArrayList<CancellationSignal> signals = new ArrayList<>(this.e);
            Iterator<CancellationSignal> it = signals.iterator();
            while (it.hasNext()) {
                a.h.g.b signal = (a.h.g.b) it.next();
                signal.a();
            }
        }

        public final void k(c finalState, b lifecycleImpact) {
            switch (lifecycleImpact) {
                case NONE:
                    if (this.f520a != c.REMOVED) {
                        if (n.A0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.f520a + " -> " + finalState + ". ");
                        }
                        this.f520a = finalState;
                        return;
                    }
                    return;
                case ADDING:
                    if (this.f520a == c.REMOVED) {
                        if (n.A0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f521b + " to ADDING.");
                        }
                        this.f520a = c.VISIBLE;
                        this.f521b = b.ADDING;
                        return;
                    }
                    return;
                case REMOVING:
                    if (n.A0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.f520a + " -> REMOVED. mLifecycleImpact  = " + this.f521b + " to REMOVING.");
                    }
                    this.f520a = c.REMOVED;
                    this.f521b = b.REMOVING;
                    return;
                default:
                    return;
            }
        }

        public final void a(Runnable listener) {
            this.d.add(listener);
        }

        public void l() {
        }

        public final void j(a.h.g.b signal) {
            l();
            this.e.add(signal);
        }

        public final void d(a.h.g.b signal) {
            if (this.e.remove(signal) && this.e.isEmpty()) {
                c();
            }
        }

        public final boolean i() {
            return this.g;
        }

        public void c() {
            if (this.g) {
                return;
            }
            if (n.A0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            for (Runnable listener : this.d) {
                listener.run();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {
        public final t h;

        public c(d.c finalState, d.b lifecycleImpact, t fragmentStateManager, a.h.g.b cancellationSignal) {
            super(finalState, lifecycleImpact, fragmentStateManager.k(), cancellationSignal);
            this.h = fragmentStateManager;
        }

        @Override // a.k.b.b0.d
        public void l() {
            if (g() == d.b.ADDING) {
                Fragment fragment = this.h.k();
                View focusedView = fragment.I.findFocus();
                if (focusedView != null) {
                    fragment.o1(focusedView);
                    if (n.A0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + focusedView + " for Fragment " + fragment);
                    }
                }
                View view = f().g1();
                if (view.getParent() == null) {
                    this.h.b();
                    view.setAlpha(0.0f);
                }
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    view.setVisibility(4);
                }
                view.setAlpha(fragment.H());
            }
        }

        @Override // a.k.b.b0.d
        public void c() {
            super.c();
            this.h.m();
        }
    }
}
