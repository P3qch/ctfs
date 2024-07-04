package androidx.fragment.app;

import a.k.b.b0;
import a.k.b.d0;
import a.k.b.j;
import a.k.b.k;
import a.k.b.n;
import a.k.b.o;
import a.k.b.z;
import a.m.d;
import a.m.l;
import a.m.s;
import a.m.t;
import a.m.u;
import a.m.v;
import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.LiveData;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, a.m.g, t, a.p.b {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f853b = new Object();
    public String A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean G;
    public ViewGroup H;
    public View I;
    public boolean J;
    public e L;
    public boolean M;
    public boolean N;
    public float O;
    public LayoutInflater P;
    public boolean Q;
    public d.b R;
    public a.m.h S;
    public z T;
    public l<a.m.g> U;
    public a.p.a V;
    public final ArrayList<g> W;
    public Bundle d;
    public SparseArray<Parcelable> e;
    public Bundle f;
    public Boolean g;
    public Bundle i;
    public Fragment j;
    public int l;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public n u;
    public k<?> v;
    public Fragment x;
    public int y;
    public int z;
    public int c = -1;
    public String h = UUID.randomUUID().toString();
    public String k = null;
    public Boolean m = null;
    public n w = new o();
    public boolean F = true;
    public boolean K = true;

    /* loaded from: classes.dex */
    public static abstract class g {
        public abstract void a();
    }

    /* loaded from: classes.dex */
    public interface h {
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.v1();
        }
    }

    @Override // a.m.g
    public a.m.d a() {
        return this.S;
    }

    public LiveData<a.m.g> S() {
        return this.U;
    }

    @Override // a.m.t
    public s e() {
        if (this.u == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (A() == d.b.INITIALIZED.ordinal()) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        return this.u.v0(this);
    }

    public final int A() {
        d.b bVar = this.R;
        if (bVar == d.b.INITIALIZED || this.x == null) {
            return bVar.ordinal();
        }
        return Math.min(bVar.ordinal(), this.x.A());
    }

    @Override // a.p.b
    public final SavedStateRegistry d() {
        return this.V.b();
    }

    /* loaded from: classes.dex */
    public static class f extends RuntimeException {
        public f(String msg, Exception cause) {
            super(msg, cause);
        }
    }

    public Fragment() {
        new a();
        this.R = d.b.RESUMED;
        this.U = new l<>();
        new AtomicInteger();
        this.W = new ArrayList<>();
        T();
    }

    public final void T() {
        this.S = new a.m.h(this);
        this.V = a.p.a.a(this);
    }

    @Deprecated
    public static Fragment V(Context context, String fname, Bundle args) {
        try {
            Class<? extends Fragment> clazz = j.d(context.getClassLoader(), fname);
            Fragment f2 = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (args != null) {
                args.setClassLoader(f2.getClass().getClassLoader());
                f2.n1(args);
            }
            return f2;
        } catch (IllegalAccessException e2) {
            throw new f("Unable to instantiate fragment " + fname + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new f("Unable to instantiate fragment " + fname + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new f("Unable to instantiate fragment " + fname + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new f("Unable to instantiate fragment " + fname + ": calling Fragment constructor caused an exception", e5);
        }
    }

    public final void j1(Bundle savedInstanceState) {
        SparseArray<Parcelable> sparseArray = this.e;
        if (sparseArray != null) {
            this.I.restoreHierarchyState(sparseArray);
            this.e = null;
        }
        if (this.I != null) {
            this.T.h(this.f);
            this.f = null;
        }
        this.G = false;
        F0(savedInstanceState);
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
        if (this.I != null) {
            this.T.b(d.a.ON_CREATE);
        }
    }

    public final boolean W() {
        return this.t > 0;
    }

    public final boolean equals(Object o) {
        return super.equals(o);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        Class<?> cls = getClass();
        sb.append(cls.getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.h);
        if (this.y != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.y));
        }
        if (this.A != null) {
            sb.append(" tag=");
            sb.append(this.A);
        }
        sb.append(")");
        return sb.toString();
    }

    public void n1(Bundle args) {
        if (this.u != null && b0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.i = args;
    }

    public final Bundle o() {
        return this.i;
    }

    public final boolean b0() {
        n nVar = this.u;
        if (nVar == null) {
            return false;
        }
        return nVar.F0();
    }

    @Deprecated
    public final Fragment Q() {
        String str;
        Fragment fragment = this.j;
        if (fragment != null) {
            return fragment;
        }
        n nVar = this.u;
        if (nVar != null && (str = this.k) != null) {
            return nVar.b0(str);
        }
        return null;
    }

    public Context q() {
        k<?> kVar = this.v;
        if (kVar == null) {
            return null;
        }
        return kVar.k();
    }

    public final Context f1() {
        Context context = q();
        if (context == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to a context.");
        }
        return context;
    }

    public final a.k.b.e j() {
        k<?> kVar = this.v;
        if (kVar == null) {
            return null;
        }
        return (a.k.b.e) kVar.j();
    }

    public final a.k.b.e e1() {
        a.k.b.e activity = j();
        if (activity == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
        }
        return activity;
    }

    public final Object y() {
        k<?> kVar = this.v;
        if (kVar == null) {
            return null;
        }
        return kVar.m();
    }

    public final Resources J() {
        return f1().getResources();
    }

    public final String P(int resId) {
        return J().getString(resId);
    }

    public final n D() {
        n fragmentManager = this.u;
        if (fragmentManager == null) {
            throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
        }
        return fragmentManager;
    }

    public final n p() {
        if (this.v == null) {
            throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
        }
        return this.w;
    }

    public final Fragment C() {
        return this.x;
    }

    public final boolean Z() {
        return this.o;
    }

    public final boolean a0() {
        Fragment parent = C();
        return parent != null && (parent.Z() || parent.a0());
    }

    public final boolean X() {
        n nVar;
        return this.F && ((nVar = this.u) == null || nVar.C0(this.x));
    }

    public void s0() {
    }

    @Deprecated
    public void e0(int requestCode, int resultCode, Intent data) {
        if (n.A0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + requestCode + " resultCode: " + resultCode + " data: " + data);
        }
    }

    @Deprecated
    public void z0() {
    }

    public LayoutInflater r0(Bundle savedInstanceState) {
        return z();
    }

    public LayoutInflater Q0(Bundle savedInstanceState) {
        LayoutInflater r0 = r0(savedInstanceState);
        this.P = r0;
        return r0;
    }

    @Deprecated
    public LayoutInflater z() {
        k<?> kVar = this.v;
        if (kVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater result = kVar.n();
        a.h.k.g.b(result, this.w.p0());
        return result;
    }

    public void u0(AttributeSet attrs, Bundle savedInstanceState) {
        this.G = true;
        k<?> kVar = this.v;
        Activity hostActivity = kVar == null ? null : kVar.j();
        if (hostActivity != null) {
            this.G = false;
            t0();
        }
    }

    @Deprecated
    public void t0() {
        this.G = true;
    }

    @Deprecated
    public void h0() {
    }

    public void g0(Context context) {
        this.G = true;
        k<?> kVar = this.v;
        Activity hostActivity = kVar == null ? null : kVar.j();
        if (hostActivity != null) {
            this.G = false;
            f0();
        }
    }

    @Deprecated
    public void f0() {
        this.G = true;
    }

    public Animation k0() {
        return null;
    }

    public Animator l0() {
        return null;
    }

    public void j0(Bundle savedInstanceState) {
        this.G = true;
        h1(savedInstanceState);
        if (!this.w.E0(1)) {
            this.w.y();
        }
    }

    public void h1(Bundle savedInstanceState) {
        Parcelable p;
        if (savedInstanceState != null && (p = savedInstanceState.getParcelable("android:support:fragments")) != null) {
            this.w.U0(p);
            this.w.y();
        }
    }

    public View m0(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    public void E0() {
    }

    public View R() {
        return this.I;
    }

    public final View g1() {
        View view = R();
        if (view == null) {
            throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
        }
        return view;
    }

    @Deprecated
    public void d0() {
        this.G = true;
    }

    public void F0(Bundle savedInstanceState) {
        this.G = true;
    }

    public void C0() {
        this.G = true;
    }

    public void A0() {
        this.G = true;
    }

    public void B0(Bundle outState) {
    }

    public void v0() {
    }

    public void x0() {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        this.G = true;
    }

    public void y0() {
    }

    public void w0() {
        this.G = true;
    }

    public void D0() {
        this.G = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.G = true;
    }

    public void p0() {
        this.G = true;
    }

    public void n0() {
        this.G = true;
    }

    public void U() {
        T();
        this.h = UUID.randomUUID().toString();
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.t = 0;
        this.u = null;
        this.w = new o();
        this.v = null;
        this.y = 0;
        this.z = 0;
        this.A = null;
        this.B = false;
        this.C = false;
    }

    public void q0() {
        this.G = true;
    }

    public void o0() {
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        e1().onCreateContextMenu(menu, v, menuInfo);
    }

    public boolean i0() {
        return false;
    }

    public Object s() {
        e eVar = this.L;
        if (eVar == null) {
            return null;
        }
        eVar.getClass();
        return null;
    }

    public Object K() {
        e eVar = this.L;
        if (eVar == null) {
            return null;
        }
        Object obj = eVar.l;
        if (obj != f853b) {
            return obj;
        }
        s();
        return null;
    }

    public Object v() {
        e eVar = this.L;
        if (eVar == null) {
            return null;
        }
        eVar.getClass();
        return null;
    }

    public Object I() {
        e eVar = this.L;
        if (eVar == null) {
            return null;
        }
        Object obj = eVar.n;
        if (obj != f853b) {
            return obj;
        }
        v();
        return null;
    }

    public Object L() {
        e eVar = this.L;
        if (eVar == null) {
            return null;
        }
        eVar.getClass();
        return null;
    }

    public Object M() {
        e eVar = this.L;
        if (eVar == null) {
            return null;
        }
        Object obj = eVar.p;
        if (obj == f853b) {
            L();
            return null;
        }
        return obj;
    }

    public boolean k() {
        e eVar = this.L;
        if (eVar != null) {
            eVar.getClass();
            return true;
        }
        return true;
    }

    public boolean l() {
        e eVar = this.L;
        if (eVar != null) {
            eVar.getClass();
            return true;
        }
        return true;
    }

    public void v1() {
        if (this.L == null || !h().s) {
            return;
        }
        if (this.v == null) {
            h().s = false;
        } else if (Looper.myLooper() != this.v.l().getLooper()) {
            this.v.l().postAtFrontOfQueue(new b());
        } else {
            b(true);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.b(false);
        }
    }

    public void b(boolean calledDirectly) {
        h listener;
        ViewGroup viewGroup;
        n nVar;
        e eVar = this.L;
        if (eVar == null) {
            listener = null;
        } else {
            eVar.s = false;
            h listener2 = eVar.t;
            eVar.t = null;
            listener = listener2;
        }
        if (listener != null) {
            ((n.o) listener).d();
            return;
        }
        if (this.I != null && (viewGroup = this.H) != null && (nVar = this.u) != null) {
            b0 controller = b0.n(viewGroup, nVar);
            controller.p();
            if (calledDirectly) {
                this.v.l().post(new c(this, controller));
            } else {
                controller.g();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b0 f857b;

        public c(Fragment this$0, b0 b0Var) {
            this.f857b = b0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f857b.g();
        }
    }

    public void g(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix);
        writer.print("mFragmentId=#");
        writer.print(Integer.toHexString(this.y));
        writer.print(" mContainerId=#");
        writer.print(Integer.toHexString(this.z));
        writer.print(" mTag=");
        writer.println(this.A);
        writer.print(prefix);
        writer.print("mState=");
        writer.print(this.c);
        writer.print(" mWho=");
        writer.print(this.h);
        writer.print(" mBackStackNesting=");
        writer.println(this.t);
        writer.print(prefix);
        writer.print("mAdded=");
        writer.print(this.n);
        writer.print(" mRemoving=");
        writer.print(this.o);
        writer.print(" mFromLayout=");
        writer.print(this.p);
        writer.print(" mInLayout=");
        writer.println(this.q);
        writer.print(prefix);
        writer.print("mHidden=");
        writer.print(this.B);
        writer.print(" mDetached=");
        writer.print(this.C);
        writer.print(" mMenuVisible=");
        writer.print(this.F);
        writer.print(" mHasMenu=");
        writer.println(false);
        writer.print(prefix);
        writer.print("mRetainInstance=");
        writer.print(this.D);
        writer.print(" mUserVisibleHint=");
        writer.println(this.K);
        if (this.u != null) {
            writer.print(prefix);
            writer.print("mFragmentManager=");
            writer.println(this.u);
        }
        if (this.v != null) {
            writer.print(prefix);
            writer.print("mHost=");
            writer.println(this.v);
        }
        if (this.x != null) {
            writer.print(prefix);
            writer.print("mParentFragment=");
            writer.println(this.x);
        }
        if (this.i != null) {
            writer.print(prefix);
            writer.print("mArguments=");
            writer.println(this.i);
        }
        if (this.d != null) {
            writer.print(prefix);
            writer.print("mSavedFragmentState=");
            writer.println(this.d);
        }
        if (this.e != null) {
            writer.print(prefix);
            writer.print("mSavedViewState=");
            writer.println(this.e);
        }
        if (this.f != null) {
            writer.print(prefix);
            writer.print("mSavedViewRegistryState=");
            writer.println(this.f);
        }
        Fragment target = Q();
        if (target != null) {
            writer.print(prefix);
            writer.print("mTarget=");
            writer.print(target);
            writer.print(" mTargetRequestCode=");
            writer.println(this.l);
        }
        writer.print(prefix);
        writer.print("mPopDirection=");
        writer.println(E());
        if (r() != 0) {
            writer.print(prefix);
            writer.print("getEnterAnim=");
            writer.println(r());
        }
        if (u() != 0) {
            writer.print(prefix);
            writer.print("getExitAnim=");
            writer.println(u());
        }
        if (F() != 0) {
            writer.print(prefix);
            writer.print("getPopEnterAnim=");
            writer.println(F());
        }
        if (G() != 0) {
            writer.print(prefix);
            writer.print("getPopExitAnim=");
            writer.println(G());
        }
        if (this.H != null) {
            writer.print(prefix);
            writer.print("mContainer=");
            writer.println(this.H);
        }
        if (this.I != null) {
            writer.print(prefix);
            writer.print("mView=");
            writer.println(this.I);
        }
        if (m() != null) {
            writer.print(prefix);
            writer.print("mAnimatingAway=");
            writer.println(m());
        }
        if (q() != null) {
            a.n.a.a.b(this).a(prefix, fd, writer, args);
        }
        writer.print(prefix);
        writer.println("Child " + this.w + ":");
        this.w.S(prefix + "  ", fd, writer, args);
    }

    public Fragment i(String who) {
        if (who.equals(this.h)) {
            return this;
        }
        return this.w.e0(who);
    }

    /* loaded from: classes.dex */
    public class d extends a.k.b.g {
        public d() {
        }

        @Override // a.k.b.g
        public View h(int id) {
            View view = Fragment.this.I;
            if (view == null) {
                throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
            }
            return view.findViewById(id);
        }

        @Override // a.k.b.g
        public boolean i() {
            return Fragment.this.I != null;
        }
    }

    public a.k.b.g f() {
        return new d();
    }

    public void H0() {
        Iterator<g> it = this.W.iterator();
        while (it.hasNext()) {
            g listener = it.next();
            listener.a();
        }
        this.W.clear();
        this.w.h(this.v, f(), this);
        this.c = 0;
        this.G = false;
        g0(this.v.k());
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onAttach()");
        }
        this.u.E(this);
        this.w.v();
    }

    public void K0(Bundle savedInstanceState) {
        this.w.J0();
        this.c = 1;
        this.G = false;
        if (Build.VERSION.SDK_INT >= 19) {
            this.S.a(new a.m.e() { // from class: androidx.fragment.app.Fragment.5
                @Override // a.m.e
                public void g(a.m.g source, d.a event) {
                    View view;
                    if (event == d.a.ON_STOP && (view = Fragment.this.I) != null) {
                        view.cancelPendingInputEvents();
                    }
                }
            });
        }
        this.V.c(savedInstanceState);
        j0(savedInstanceState);
        this.Q = true;
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onCreate()");
        }
        this.S.h(d.a.ON_CREATE);
    }

    public void M0(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.w.J0();
        this.s = true;
        this.T = new z(this, e());
        View m0 = m0(inflater, container, savedInstanceState);
        this.I = m0;
        if (m0 != null) {
            this.T.f();
            u.a(this.I, this.T);
            v.a(this.I, this.T);
            a.p.c.a(this.I, this.T);
            this.U.j(this.T);
            return;
        }
        if (this.T.g()) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
        this.T = null;
    }

    public void d1() {
        E0();
        this.w.Q();
    }

    public void G0(Bundle savedInstanceState) {
        this.w.J0();
        this.c = 3;
        this.G = false;
        d0();
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        i1();
        this.w.u();
    }

    public final void i1() {
        if (n.A0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.I != null) {
            j1(this.d);
        }
        this.d = null;
    }

    public void b1() {
        this.w.J0();
        this.w.W(true);
        this.c = 5;
        this.G = false;
        C0();
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onStart()");
        }
        a.m.h hVar = this.S;
        d.a aVar = d.a.ON_START;
        hVar.h(aVar);
        if (this.I != null) {
            this.T.b(aVar);
        }
        this.w.N();
    }

    public void Z0() {
        this.w.J0();
        this.w.W(true);
        this.c = 7;
        this.G = false;
        A0();
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onResume()");
        }
        a.m.h hVar = this.S;
        d.a aVar = d.a.ON_RESUME;
        hVar.h(aVar);
        if (this.I != null) {
            this.T.b(aVar);
        }
        this.w.M();
    }

    public void c0() {
        this.w.J0();
    }

    public void Y0() {
        boolean isPrimaryNavigationFragment = this.u.D0(this);
        Boolean bool = this.m;
        if (bool == null || bool.booleanValue() != isPrimaryNavigationFragment) {
            this.m = Boolean.valueOf(isPrimaryNavigationFragment);
            y0();
            this.w.L();
        }
    }

    public void S0(boolean isInMultiWindowMode) {
        v0();
        this.w.D(isInMultiWindowMode);
    }

    public void W0(boolean isInPictureInPictureMode) {
        x0();
        this.w.J(isInPictureInPictureMode);
    }

    public void I0(Configuration newConfig) {
        onConfigurationChanged(newConfig);
        this.w.w(newConfig);
    }

    public void R0() {
        onLowMemory();
        this.w.C();
    }

    public boolean L0(Menu menu, MenuInflater inflater) {
        if (!this.B) {
            boolean show = false | this.w.z(menu, inflater);
            return show;
        }
        return false;
    }

    public boolean X0(Menu menu) {
        if (!this.B) {
            boolean show = false | this.w.K(menu);
            return show;
        }
        return false;
    }

    public boolean T0(MenuItem item) {
        if (!this.B) {
            return this.w.F(item);
        }
        return false;
    }

    public boolean J0(MenuItem item) {
        if (!this.B) {
            if (i0()) {
                return true;
            }
            return this.w.x(item);
        }
        return false;
    }

    public void U0(Menu menu) {
        if (!this.B) {
            this.w.G(menu);
        }
    }

    public void a1(Bundle outState) {
        B0(outState);
        this.V.d(outState);
        Parcelable p = this.w.W0();
        if (p != null) {
            outState.putParcelable("android:support:fragments", p);
        }
    }

    public void V0() {
        this.w.I();
        if (this.I != null) {
            this.T.b(d.a.ON_PAUSE);
        }
        this.S.h(d.a.ON_PAUSE);
        this.c = 6;
        this.G = false;
        w0();
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public void c1() {
        this.w.P();
        if (this.I != null) {
            this.T.b(d.a.ON_STOP);
        }
        this.S.h(d.a.ON_STOP);
        this.c = 4;
        this.G = false;
        D0();
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void O0() {
        this.w.B();
        if (this.I != null && this.T.a().b().a(d.b.CREATED)) {
            this.T.b(d.a.ON_DESTROY);
        }
        this.c = 1;
        this.G = false;
        p0();
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        a.n.a.a.b(this).c();
        this.s = false;
    }

    public void N0() {
        this.w.A();
        this.S.h(d.a.ON_DESTROY);
        this.c = 0;
        this.G = false;
        this.Q = false;
        n0();
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public void P0() {
        this.c = -1;
        this.G = false;
        q0();
        this.P = null;
        if (!this.G) {
            throw new d0("Fragment " + this + " did not call through to super.onDetach()");
        }
        if (!this.w.z0()) {
            this.w.A();
            this.w = new o();
        }
    }

    public void r1(h listener) {
        h();
        e eVar = this.L;
        h hVar = eVar.t;
        if (listener == hVar) {
            return;
        }
        if (listener != null && hVar != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (eVar.s) {
            eVar.t = listener;
        }
        if (listener != null) {
            ((n.o) listener).e();
        }
    }

    public final e h() {
        if (this.L == null) {
            this.L = new e();
        }
        return this.L;
    }

    public void l1(int enter, int exit, int popEnter, int popExit) {
        if (this.L == null && enter == 0 && exit == 0 && popEnter == 0 && popExit == 0) {
            return;
        }
        h().d = enter;
        h().e = exit;
        h().f = popEnter;
        h().g = popExit;
    }

    public int r() {
        e eVar = this.L;
        if (eVar == null) {
            return 0;
        }
        return eVar.d;
    }

    public int u() {
        e eVar = this.L;
        if (eVar == null) {
            return 0;
        }
        return eVar.e;
    }

    public int F() {
        e eVar = this.L;
        if (eVar == null) {
            return 0;
        }
        return eVar.f;
    }

    public int G() {
        e eVar = this.L;
        if (eVar == null) {
            return 0;
        }
        return eVar.g;
    }

    public boolean E() {
        e eVar = this.L;
        if (eVar == null) {
            return false;
        }
        return eVar.c;
    }

    public void s1(boolean isPop) {
        if (this.L == null) {
            return;
        }
        h().c = isPop;
    }

    public int B() {
        e eVar = this.L;
        if (eVar == null) {
            return 0;
        }
        return eVar.h;
    }

    public void q1(int nextTransition) {
        if (this.L == null && nextTransition == 0) {
            return;
        }
        h();
        this.L.h = nextTransition;
    }

    public ArrayList<String> N() {
        ArrayList<String> arrayList;
        e eVar = this.L;
        if (eVar == null || (arrayList = eVar.i) == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    public ArrayList<String> O() {
        ArrayList<String> arrayList;
        e eVar = this.L;
        if (eVar == null || (arrayList = eVar.j) == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    public void u1(ArrayList<String> sharedElementSourceNames, ArrayList<String> sharedElementTargetNames) {
        h();
        e eVar = this.L;
        eVar.i = sharedElementSourceNames;
        eVar.j = sharedElementTargetNames;
    }

    public void t() {
        e eVar = this.L;
        if (eVar == null) {
            return;
        }
        eVar.getClass();
    }

    public void w() {
        e eVar = this.L;
        if (eVar == null) {
            return;
        }
        eVar.getClass();
    }

    public View m() {
        e eVar = this.L;
        if (eVar == null) {
            return null;
        }
        return eVar.f859a;
    }

    public void k1(View view) {
        h().f859a = view;
    }

    public void m1(Animator animator) {
        h().f860b = animator;
    }

    public Animator n() {
        e eVar = this.L;
        if (eVar == null) {
            return null;
        }
        return eVar.f860b;
    }

    public void t1(float alpha) {
        h().q = alpha;
    }

    public float H() {
        e eVar = this.L;
        if (eVar == null) {
            return 1.0f;
        }
        return eVar.q;
    }

    public void o1(View view) {
        h().r = view;
    }

    public View x() {
        e eVar = this.L;
        if (eVar == null) {
            return null;
        }
        return eVar.r;
    }

    public boolean Y() {
        e eVar = this.L;
        if (eVar == null) {
            return false;
        }
        return eVar.s;
    }

    public void p1(boolean replaced) {
        h().u = replaced;
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public View f859a;

        /* renamed from: b, reason: collision with root package name */
        public Animator f860b;
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public ArrayList<String> i;
        public ArrayList<String> j;
        public Object k = null;
        public Object l;
        public Object m;
        public Object n;
        public Object o;
        public Object p;
        public float q;
        public View r;
        public boolean s;
        public h t;
        public boolean u;

        public e() {
            Object obj = Fragment.f853b;
            this.l = obj;
            this.m = null;
            this.n = obj;
            this.o = null;
            this.p = obj;
            this.q = 1.0f;
            this.r = null;
        }
    }
}
