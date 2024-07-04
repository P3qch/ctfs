package a.k.b;

import a.k.b.v;
import a.k.b.w;
import a.m.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f565a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f566b = true;
    public a.a.e.c<Intent> A;
    public a.a.e.c<?> B;
    public a.a.e.c<String[]> C;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public ArrayList<a.k.b.a> J;
    public ArrayList<Boolean> K;
    public ArrayList<Fragment> L;
    public ArrayList<o> M;
    public q N;
    public boolean d;
    public ArrayList<a.k.b.a> f;
    public ArrayList<Fragment> g;
    public OnBackPressedDispatcher i;
    public a.k.b.k<?> s;
    public a.k.b.g t;
    public Fragment u;
    public Fragment v;
    public final ArrayList<m> c = new ArrayList<>();
    public final u e = new u();
    public final a.k.b.l h = new a.k.b.l(this);
    public final a.a.b j = new c(false);
    public final AtomicInteger k = new AtomicInteger();
    public final Map<String, Bundle> l = Collections.synchronizedMap(new HashMap());
    public final Map<String, ?> m = Collections.synchronizedMap(new HashMap());
    public Map<Fragment, HashSet<a.h.g.b>> n = Collections.synchronizedMap(new HashMap());
    public final w.g o = new d();
    public final a.k.b.m p = new a.k.b.m(this);
    public final CopyOnWriteArrayList<r> q = new CopyOnWriteArrayList<>();
    public int r = -1;
    public a.k.b.j w = null;
    public a.k.b.j x = new e();
    public c0 y = null;
    public c0 z = new f(this);
    public ArrayDeque<l> D = new ArrayDeque<>();
    public Runnable O = new g();

    /* loaded from: classes.dex */
    public static abstract class k {
        @Deprecated
        public abstract void a(n nVar, Fragment fragment, Bundle bundle);

        public abstract void b(n nVar, Fragment fragment, Context context);

        public abstract void c(n nVar, Fragment fragment, Bundle bundle);

        public abstract void d(n nVar, Fragment fragment);

        public abstract void e(n nVar, Fragment fragment);

        public abstract void f(n nVar, Fragment fragment);

        public abstract void g(n nVar, Fragment fragment, Context context);

        public abstract void h(n nVar, Fragment fragment, Bundle bundle);

        public abstract void i(n nVar, Fragment fragment);

        public abstract void j(n nVar, Fragment fragment, Bundle bundle);

        public abstract void k(n nVar, Fragment fragment);

        public abstract void l(n nVar, Fragment fragment);

        public abstract void m(n nVar, Fragment fragment, View view, Bundle bundle);

        public abstract void n(n nVar, Fragment fragment);
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean a(ArrayList<a.k.b.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public static boolean A0(int level) {
        return Log.isLoggable("FragmentManager", level);
    }

    /* loaded from: classes.dex */
    public class c extends a.a.b {
        public c(boolean arg0) {
            super(arg0);
        }

        @Override // a.a.b
        public void b() {
            n.this.w0();
        }
    }

    /* loaded from: classes.dex */
    public class d implements w.g {
        public d() {
        }

        public void b(Fragment fragment, a.h.g.b signal) {
            n.this.d(fragment, signal);
        }

        public void a(Fragment f, a.h.g.b signal) {
            if (!signal.b()) {
                n.this.Q0(f, signal);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends a.k.b.j {
        public e() {
        }

        @Override // a.k.b.j
        public Fragment a(ClassLoader classLoader, String className) {
            return n.this.o0().f(n.this.o0().k(), className, null);
        }
    }

    /* loaded from: classes.dex */
    public class f implements c0 {
        public f(n this$0) {
        }

        public b0 a(ViewGroup container) {
            return new a.k.b.c(container);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.W(true);
        }
    }

    public v j() {
        return new a.k.b.a(this);
    }

    public final void e1() {
        synchronized (this.c) {
            if (!this.c.isEmpty()) {
                this.j.f(true);
            } else {
                this.j.f(h0() > 0 && D0(this.u));
            }
        }
    }

    public boolean D0(Fragment parent) {
        if (parent == null) {
            return true;
        }
        n parentFragmentManager = parent.u;
        Fragment primaryNavigationFragment = parentFragmentManager.s0();
        return parent.equals(primaryNavigationFragment) && D0(parentFragmentManager.u);
    }

    public boolean C0(Fragment parent) {
        if (parent == null) {
            return true;
        }
        return parent.X();
    }

    public void w0() {
        W(true);
        if (this.j.c()) {
            N0();
        } else {
            this.i.c();
        }
    }

    public boolean N0() {
        return O0(null, -1, 0);
    }

    public void M0(int id, int flags) {
        if (id < 0) {
            throw new IllegalArgumentException("Bad id: " + id);
        }
        U(new C0043n(null, id, flags), false);
    }

    public final boolean O0(String name, int id, int flags) {
        W(false);
        V(true);
        Fragment fragment = this.v;
        if (fragment != null && id < 0 && name == null) {
            n childManager = fragment.p();
            if (childManager.N0()) {
                return true;
            }
        }
        boolean executePop = P0(this.J, this.K, name, id, flags);
        if (executePop) {
            this.d = true;
            try {
                S0(this.J, this.K);
            } finally {
                n();
            }
        }
        e1();
        R();
        this.e.b();
        return executePop;
    }

    public int h0() {
        ArrayList<a.k.b.a> arrayList = this.f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void d(Fragment f2, a.h.g.b signal) {
        if (this.n.get(f2) == null) {
            this.n.put(f2, new HashSet<>());
        }
        this.n.get(f2).add(signal);
    }

    public void Q0(Fragment f2, a.h.g.b signal) {
        HashSet<a.h.g.b> hashSet = this.n.get(f2);
        if (hashSet != null && hashSet.remove(signal) && hashSet.isEmpty()) {
            this.n.remove(f2);
            if (f2.c < 5) {
                s(f2);
                H0(f2);
            }
        }
    }

    public static Fragment u0(View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public void K0(a.k.b.h container) {
        View view;
        for (t fragmentStateManager : this.e.k()) {
            Fragment fragment = fragmentStateManager.k();
            if (fragment.z == container.getId() && (view = fragment.I) != null && view.getParent() == null) {
                fragment.H = container;
                fragmentStateManager.b();
            }
        }
    }

    public List<Fragment> n0() {
        return this.e.n();
    }

    public a.m.s v0(Fragment f2) {
        return this.N.k(f2);
    }

    public final q i0(Fragment f2) {
        return this.N.h(f2);
    }

    public boolean z0() {
        return this.H;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.u;
        if (fragment != null) {
            Class<?> cls = fragment.getClass();
            sb.append(cls.getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.u)));
            sb.append("}");
        } else {
            a.k.b.k<?> kVar = this.s;
            if (kVar != null) {
                Class<?> cls2 = kVar.getClass();
                sb.append(cls2.getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.s)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public void S(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        int count;
        int count2;
        String innerPrefix = prefix + "    ";
        this.e.e(prefix, fd, writer, args);
        ArrayList<Fragment> arrayList = this.g;
        if (arrayList != null && (count2 = arrayList.size()) > 0) {
            writer.print(prefix);
            writer.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < count2; i2++) {
                Fragment f2 = this.g.get(i2);
                writer.print(prefix);
                writer.print("  #");
                writer.print(i2);
                writer.print(": ");
                writer.println(f2.toString());
            }
        }
        ArrayList<a.k.b.a> arrayList2 = this.f;
        if (arrayList2 != null && (count = arrayList2.size()) > 0) {
            writer.print(prefix);
            writer.println("Back Stack:");
            for (int i3 = 0; i3 < count; i3++) {
                a.k.b.a bs = this.f.get(i3);
                writer.print(prefix);
                writer.print("  #");
                writer.print(i3);
                writer.print(": ");
                writer.println(bs.toString());
                bs.q(innerPrefix, writer);
            }
        }
        writer.print(prefix);
        writer.println("Back Stack Index: " + this.k.get());
        synchronized (this.c) {
            int count3 = this.c.size();
            if (count3 > 0) {
                writer.print(prefix);
                writer.println("Pending Actions:");
                for (int i4 = 0; i4 < count3; i4++) {
                    m r = this.c.get(i4);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i4);
                    writer.print(": ");
                    writer.println(r);
                }
            }
        }
        writer.print(prefix);
        writer.println("FragmentManager misc state:");
        writer.print(prefix);
        writer.print("  mHost=");
        writer.println(this.s);
        writer.print(prefix);
        writer.print("  mContainer=");
        writer.println(this.t);
        if (this.u != null) {
            writer.print(prefix);
            writer.print("  mParent=");
            writer.println(this.u);
        }
        writer.print(prefix);
        writer.print("  mCurState=");
        writer.print(this.r);
        writer.print(" mStateSaved=");
        writer.print(this.F);
        writer.print(" mStopped=");
        writer.print(this.G);
        writer.print(" mDestroyed=");
        writer.println(this.H);
        if (this.E) {
            writer.print(prefix);
            writer.print("  mNeedMenuInvalidate=");
            writer.println(this.E);
        }
    }

    public void L0(t fragmentStateManager) {
        Fragment f2 = fragmentStateManager.k();
        if (f2.J) {
            if (this.d) {
                this.I = true;
            } else {
                f2.J = false;
                fragmentStateManager.m();
            }
        }
    }

    public boolean E0(int state) {
        return this.r >= state;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:43:0x0075. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void I0(androidx.fragment.app.Fragment r11, int r12) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.k.b.n.I0(androidx.fragment.app.Fragment, int):void");
    }

    public final void k(Fragment f2) {
        HashSet<a.h.g.b> hashSet = this.n.get(f2);
        if (hashSet != null) {
            Iterator<a.h.g.b> it = hashSet.iterator();
            while (it.hasNext()) {
                a.h.g.b signal = it.next();
                signal.a();
            }
            hashSet.clear();
            s(f2);
            this.n.remove(f2);
        }
    }

    public void Y0(Fragment f2, boolean isPop) {
        ViewGroup container = k0(f2);
        if (container != null && (container instanceof a.k.b.h)) {
            ((a.k.b.h) container).setDrawDisappearingViewsLast(!isPop);
        }
    }

    public final void s(Fragment fragment) {
        fragment.O0();
        this.p.n(fragment, false);
        fragment.H = null;
        fragment.I = null;
        fragment.T = null;
        fragment.U.j(null);
        fragment.q = false;
    }

    public void H0(Fragment f2) {
        I0(f2, this.r);
    }

    public void G0(int newState, boolean always) {
        a.k.b.k<?> kVar;
        if (this.s == null && newState != -1) {
            throw new IllegalStateException("No activity");
        }
        if (!always && newState == this.r) {
            return;
        }
        this.r = newState;
        this.e.r();
        d1();
        if (this.E && (kVar = this.s) != null && this.r == 7) {
            kVar.p();
            this.E = false;
        }
    }

    public final void d1() {
        for (t fragmentStateManager : this.e.k()) {
            L0(fragmentStateManager);
        }
    }

    public t r(Fragment f2) {
        t existing = this.e.m(f2.h);
        if (existing != null) {
            return existing;
        }
        t fragmentStateManager = new t(this.p, this.e, f2);
        fragmentStateManager.o(this.s.k().getClassLoader());
        fragmentStateManager.t(this.r);
        return fragmentStateManager;
    }

    public t e(Fragment fragment) {
        if (A0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        t fragmentStateManager = r(fragment);
        fragment.u = this;
        this.e.p(fragmentStateManager);
        if (!fragment.C) {
            this.e.a(fragment);
            fragment.o = false;
            if (fragment.I == null) {
                fragment.N = false;
            }
            if (B0(fragment)) {
                this.E = true;
            }
        }
        return fragmentStateManager;
    }

    public void R0(Fragment fragment) {
        if (A0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.t);
        }
        boolean inactive = !fragment.W();
        if (!fragment.C || inactive) {
            this.e.s(fragment);
            if (B0(fragment)) {
                this.E = true;
            }
            fragment.o = true;
            b1(fragment);
        }
    }

    public void x0(Fragment fragment) {
        if (A0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.B) {
            fragment.B = true;
            fragment.N = true ^ fragment.N;
            b1(fragment);
        }
    }

    public void c1(Fragment fragment) {
        if (A0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.B) {
            fragment.B = false;
            fragment.N = !fragment.N;
        }
    }

    public void t(Fragment fragment) {
        if (A0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.C) {
            fragment.C = true;
            if (fragment.n) {
                if (A0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.e.s(fragment);
                if (B0(fragment)) {
                    this.E = true;
                }
                b1(fragment);
            }
        }
    }

    public void i(Fragment fragment) {
        if (A0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.C) {
            fragment.C = false;
            if (!fragment.n) {
                this.e.a(fragment);
                if (A0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (B0(fragment)) {
                    this.E = true;
                }
            }
        }
    }

    public Fragment c0(int id) {
        return this.e.g(id);
    }

    public Fragment d0(String tag) {
        return this.e.h(tag);
    }

    public Fragment e0(String who) {
        return this.e.i(who);
    }

    public Fragment b0(String who) {
        return this.e.f(who);
    }

    public final void m() {
        if (F0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public boolean F0() {
        return this.F || this.G;
    }

    public void U(m action, boolean allowStateLoss) {
        if (!allowStateLoss) {
            if (this.s == null) {
                if (this.H) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            m();
        }
        synchronized (this.c) {
            if (this.s == null) {
                if (!allowStateLoss) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.c.add(action);
                X0();
            }
        }
    }

    public void X0() {
        synchronized (this.c) {
            ArrayList<o> arrayList = this.M;
            boolean postponeReady = (arrayList == null || arrayList.isEmpty()) ? false : true;
            boolean pendingReady = this.c.size() == 1;
            if (postponeReady || pendingReady) {
                this.s.l().removeCallbacks(this.O);
                this.s.l().post(this.O);
                e1();
            }
        }
    }

    public int g() {
        return this.k.getAndIncrement();
    }

    public final void V(boolean allowStateLoss) {
        if (this.d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.s == null) {
            if (this.H) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        }
        if (Looper.myLooper() != this.s.l().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!allowStateLoss) {
            m();
        }
        if (this.J == null) {
            this.J = new ArrayList<>();
            this.K = new ArrayList<>();
        }
        this.d = true;
        try {
            a0(null, null);
        } finally {
            this.d = false;
        }
    }

    public void X(m action, boolean allowStateLoss) {
        if (allowStateLoss && (this.s == null || this.H)) {
            return;
        }
        V(allowStateLoss);
        if (action.a(this.J, this.K)) {
            this.d = true;
            try {
                S0(this.J, this.K);
            } finally {
                n();
            }
        }
        e1();
        R();
        this.e.b();
    }

    public final void n() {
        this.d = false;
        this.K.clear();
        this.J.clear();
    }

    public boolean W(boolean allowStateLoss) {
        V(allowStateLoss);
        boolean didSomething = false;
        while (g0(this.J, this.K)) {
            this.d = true;
            try {
                S0(this.J, this.K);
                n();
                didSomething = true;
            } catch (Throwable th) {
                n();
                throw th;
            }
        }
        e1();
        R();
        this.e.b();
        return didSomething;
    }

    public final void a0(ArrayList<a.k.b.a> arrayList, ArrayList<Boolean> isRecordPop) {
        int index;
        int index2;
        ArrayList<o> arrayList2 = this.M;
        int numPostponed = arrayList2 == null ? 0 : arrayList2.size();
        int i2 = 0;
        while (i2 < numPostponed) {
            o listener = this.M.get(i2);
            if (arrayList != null && !listener.f577a && (index2 = arrayList.indexOf(listener.f578b)) != -1 && isRecordPop != null && isRecordPop.get(index2).booleanValue()) {
                this.M.remove(i2);
                i2--;
                numPostponed--;
                listener.a();
            } else if (listener.c() || (arrayList != null && listener.f578b.x(arrayList, 0, arrayList.size()))) {
                this.M.remove(i2);
                i2--;
                numPostponed--;
                if (arrayList != null && !listener.f577a && (index = arrayList.indexOf(listener.f578b)) != -1 && isRecordPop != null && isRecordPop.get(index).booleanValue()) {
                    listener.a();
                } else {
                    listener.b();
                }
            }
            i2++;
        }
    }

    public final void S0(ArrayList<a.k.b.a> arrayList, ArrayList<Boolean> isRecordPop) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != isRecordPop.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        a0(arrayList, isRecordPop);
        int numRecords = arrayList.size();
        int startIndex = 0;
        int recordNum = 0;
        while (recordNum < numRecords) {
            boolean canReorder = arrayList.get(recordNum).o;
            if (!canReorder) {
                if (startIndex != recordNum) {
                    Z(arrayList, isRecordPop, startIndex, recordNum);
                }
                int reorderingEnd = recordNum + 1;
                if (isRecordPop.get(recordNum).booleanValue()) {
                    while (reorderingEnd < numRecords && isRecordPop.get(reorderingEnd).booleanValue() && !arrayList.get(reorderingEnd).o) {
                        reorderingEnd++;
                    }
                }
                Z(arrayList, isRecordPop, recordNum, reorderingEnd);
                startIndex = reorderingEnd;
                recordNum = reorderingEnd - 1;
            }
            recordNum++;
        }
        if (startIndex != numRecords) {
            Z(arrayList, isRecordPop, startIndex, numRecords);
        }
    }

    public final void Z(ArrayList<a.k.b.a> arrayList, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex) {
        boolean allowReordering = arrayList.get(startIndex).o;
        boolean addToBackStack = false;
        ArrayList<Fragment> arrayList2 = this.L;
        if (arrayList2 == null) {
            this.L = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        this.L.addAll(this.e.n());
        Fragment oldPrimaryNav = s0();
        int recordNum = startIndex;
        while (true) {
            boolean z = true;
            if (recordNum >= endIndex) {
                break;
            }
            a.k.b.a record = arrayList.get(recordNum);
            if (!isRecordPop.get(recordNum).booleanValue()) {
                oldPrimaryNav = record.u(this.L, oldPrimaryNav);
            } else {
                oldPrimaryNav = record.z(this.L, oldPrimaryNav);
            }
            if (!addToBackStack && !record.g) {
                z = false;
            }
            addToBackStack = z;
            recordNum++;
        }
        this.L.clear();
        if (!allowReordering && this.r >= 1) {
            for (int index = startIndex; index < endIndex; index++) {
                Iterator<v.a> it = arrayList.get(index).f587a.iterator();
                while (it.hasNext()) {
                    v.a op = it.next();
                    Fragment fragment = op.f590b;
                    if (fragment != null && fragment.u != null) {
                        t fragmentStateManager = r(fragment);
                        this.e.p(fragmentStateManager);
                    }
                }
            }
        }
        Y(arrayList, isRecordPop, startIndex, endIndex);
        boolean isPop = isRecordPop.get(endIndex - 1).booleanValue();
        for (int index2 = startIndex; index2 < endIndex; index2++) {
            a.k.b.a record2 = arrayList.get(index2);
            if (isPop) {
                for (int opIndex = record2.f587a.size() - 1; opIndex >= 0; opIndex--) {
                    v.a op2 = record2.f587a.get(opIndex);
                    Fragment fragment2 = op2.f590b;
                    if (fragment2 != null) {
                        t fragmentStateManager2 = r(fragment2);
                        fragmentStateManager2.m();
                    }
                }
            } else {
                Iterator<v.a> it2 = record2.f587a.iterator();
                while (it2.hasNext()) {
                    v.a op3 = it2.next();
                    Fragment fragment3 = op3.f590b;
                    if (fragment3 != null) {
                        t fragmentStateManager3 = r(fragment3);
                        fragmentStateManager3.m();
                    }
                }
            }
        }
        int index3 = this.r;
        G0(index3, true);
        for (b0 controller : p(arrayList, startIndex, endIndex)) {
            controller.r(isPop);
            controller.p();
            controller.g();
        }
        for (int recordNum2 = startIndex; recordNum2 < endIndex; recordNum2++) {
            a.k.b.a record3 = arrayList.get(recordNum2);
            if (isRecordPop.get(recordNum2).booleanValue() && record3.s >= 0) {
                record3.s = -1;
            }
            record3.y();
        }
        if (addToBackStack) {
            T0();
        }
    }

    public final Set<b0> p(ArrayList<a.k.b.a> arrayList, int startIndex, int endIndex) {
        ViewGroup container;
        Set<SpecialEffectsController> controllers = new HashSet<>();
        for (int index = startIndex; index < endIndex; index++) {
            a.k.b.a record = arrayList.get(index);
            Iterator<v.a> it = record.f587a.iterator();
            while (it.hasNext()) {
                v.a op = it.next();
                Fragment fragment = op.f590b;
                if (fragment != null && (container = fragment.H) != null) {
                    controllers.add(b0.n(container, this));
                }
            }
        }
        return controllers;
    }

    public void q(a.k.b.a record, boolean isPop, boolean runTransitions, boolean moveToState) {
        if (isPop) {
            record.t(moveToState);
        } else {
            record.s();
        }
        ArrayList<BackStackRecord> records = new ArrayList<>(1);
        ArrayList<Boolean> isRecordPop = new ArrayList<>(1);
        records.add(record);
        isRecordPop.add(Boolean.valueOf(isPop));
        if (runTransitions && this.r >= 1) {
            w.C(this.s.k(), this.t, records, isRecordPop, 0, 1, true, this.o);
        }
        if (moveToState) {
            G0(this.r, true);
        }
        for (Fragment fragment : this.e.l()) {
            if (fragment != null && fragment.I != null && fragment.M && record.w(fragment.z)) {
                float f2 = fragment.O;
                if (f2 > 0.0f) {
                    fragment.I.setAlpha(f2);
                }
                if (moveToState) {
                    fragment.O = 0.0f;
                } else {
                    fragment.O = -1.0f;
                    fragment.M = false;
                }
            }
        }
    }

    public static void Y(ArrayList<a.k.b.a> arrayList, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex) {
        int i2 = startIndex;
        while (i2 < endIndex) {
            a.k.b.a record = arrayList.get(i2);
            boolean isPop = isRecordPop.get(i2).booleanValue();
            if (isPop) {
                record.o(-1);
                boolean moveToState = i2 == endIndex + (-1);
                record.t(moveToState);
            } else {
                record.o(1);
                record.s();
            }
            i2++;
        }
    }

    public final void b1(Fragment f2) {
        ViewGroup container = k0(f2);
        if (container != null && f2.r() + f2.u() + f2.F() + f2.G() > 0) {
            if (container.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                container.setTag(R.id.visible_removing_fragment_view_tag, f2);
            }
            ((Fragment) container.getTag(R.id.visible_removing_fragment_view_tag)).s1(f2.E());
        }
    }

    public final ViewGroup k0(Fragment f2) {
        ViewGroup viewGroup = f2.H;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (f2.z > 0 && this.t.i()) {
            View view = this.t.h(f2.z);
            if (view instanceof ViewGroup) {
                return (ViewGroup) view;
            }
        }
        return null;
    }

    public final void f0() {
        for (b0 controller : o()) {
            controller.k();
        }
    }

    public final void T() {
        for (b0 controller : o()) {
            controller.j();
        }
    }

    public final Set<b0> o() {
        Set<SpecialEffectsController> controllers = new HashSet<>();
        for (t fragmentStateManager : this.e.k()) {
            ViewGroup container = fragmentStateManager.k().H;
            if (container != null) {
                controllers.add(b0.o(container, t0()));
            }
        }
        return controllers;
    }

    public final boolean g0(ArrayList<a.k.b.a> arrayList, ArrayList<Boolean> isPop) {
        boolean didSomething = false;
        synchronized (this.c) {
            if (this.c.isEmpty()) {
                return false;
            }
            int numActions = this.c.size();
            for (int i2 = 0; i2 < numActions; i2++) {
                didSomething |= this.c.get(i2).a(arrayList, isPop);
            }
            this.c.clear();
            this.s.l().removeCallbacks(this.O);
            return didSomething;
        }
    }

    public final void R() {
        if (this.I) {
            this.I = false;
            d1();
        }
    }

    public final void T0() {
    }

    public void c(a.k.b.a state) {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.add(state);
    }

    public boolean P0(ArrayList<a.k.b.a> arrayList, ArrayList<Boolean> isRecordPop, String name, int id, int flags) {
        ArrayList<a.k.b.a> arrayList2 = this.f;
        if (arrayList2 == null) {
            return false;
        }
        if (name == null && id < 0 && (flags & 1) == 0) {
            int last = arrayList2.size() - 1;
            if (last < 0) {
                return false;
            }
            arrayList.add(this.f.remove(last));
            isRecordPop.add(true);
        } else {
            int index = -1;
            if (name != null || id >= 0) {
                index = arrayList2.size() - 1;
                while (index >= 0) {
                    a.k.b.a bss = this.f.get(index);
                    if ((name != null && name.equals(bss.v())) || (id >= 0 && id == bss.s)) {
                        break;
                    }
                    index--;
                }
                if (index < 0) {
                    return false;
                }
                if ((flags & 1) != 0) {
                    index--;
                    while (index >= 0) {
                        a.k.b.a bss2 = this.f.get(index);
                        if ((name == null || !name.equals(bss2.v())) && (id < 0 || id != bss2.s)) {
                            break;
                        }
                        index--;
                    }
                }
            }
            if (index == this.f.size() - 1) {
                return false;
            }
            for (int i2 = this.f.size() - 1; i2 > index; i2--) {
                arrayList.add(this.f.remove(i2));
                isRecordPop.add(true);
            }
        }
        return true;
    }

    public Parcelable W0() {
        int size;
        f0();
        T();
        W(true);
        this.F = true;
        this.N.n(true);
        ArrayList<s> v = this.e.v();
        if (v.isEmpty()) {
            if (A0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return null;
            }
            return null;
        }
        ArrayList<String> added = this.e.w();
        a.k.b.b[] backStack = null;
        ArrayList<a.k.b.a> arrayList = this.f;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStack = new a.k.b.b[size];
            for (int i2 = 0; i2 < size; i2++) {
                backStack[i2] = new a.k.b.b(this.f.get(i2));
                if (A0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f.get(i2));
                }
            }
        }
        p fms = new p();
        fms.f579b = v;
        fms.c = added;
        fms.d = backStack;
        fms.e = this.k.get();
        Fragment fragment = this.v;
        if (fragment != null) {
            fms.f = fragment.h;
        }
        fms.g.addAll(this.l.keySet());
        fms.h.addAll(this.l.values());
        fms.i = new ArrayList<>(this.D);
        return fms;
    }

    public void U0(Parcelable state) {
        t fragmentStateManager;
        if (state == null) {
            return;
        }
        p fms = (p) state;
        if (fms.f579b == null) {
            return;
        }
        this.e.t();
        Iterator<s> it = fms.f579b.iterator();
        while (it.hasNext()) {
            s fs = it.next();
            if (fs != null) {
                Fragment retainedFragment = this.N.g(fs.c);
                if (retainedFragment != null) {
                    if (A0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + retainedFragment);
                    }
                    fragmentStateManager = new t(this.p, this.e, retainedFragment, fs);
                } else {
                    fragmentStateManager = new t(this.p, this.e, this.s.k().getClassLoader(), l0(), fs);
                }
                Fragment f2 = fragmentStateManager.k();
                f2.u = this;
                if (A0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + f2.h + "): " + f2);
                }
                fragmentStateManager.o(this.s.k().getClassLoader());
                this.e.p(fragmentStateManager);
                fragmentStateManager.t(this.r);
            }
        }
        Iterator it2 = ((ArrayList) this.N.j()).iterator();
        while (it2.hasNext()) {
            Fragment f3 = (Fragment) it2.next();
            if (!this.e.c(f3.h)) {
                if (A0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + f3 + " that was not found in the set of active Fragments " + fms.f579b);
                }
                this.N.m(f3);
                f3.u = this;
                t fragmentStateManager2 = new t(this.p, this.e, f3);
                fragmentStateManager2.t(1);
                fragmentStateManager2.m();
                f3.o = true;
                fragmentStateManager2.m();
            }
        }
        this.e.u(fms.c);
        if (fms.d != null) {
            this.f = new ArrayList<>(fms.d.length);
            int i2 = 0;
            while (true) {
                a.k.b.b[] bVarArr = fms.d;
                if (i2 >= bVarArr.length) {
                    break;
                }
                a.k.b.a bse = bVarArr[i2].j(this);
                if (A0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + bse.s + "): " + bse);
                    a0 logw = new a0("FragmentManager");
                    PrintWriter pw = new PrintWriter(logw);
                    bse.r("  ", pw, false);
                    pw.close();
                }
                this.f.add(bse);
                i2++;
            }
        } else {
            this.f = null;
        }
        this.k.set(fms.e);
        String str = fms.f;
        if (str != null) {
            Fragment b0 = b0(str);
            this.v = b0;
            H(b0);
        }
        ArrayList<String> savedResultKeys = fms.g;
        if (savedResultKeys != null) {
            for (int i3 = 0; i3 < savedResultKeys.size(); i3++) {
                Bundle savedResult = fms.h.get(i3);
                savedResult.setClassLoader(this.s.k().getClassLoader());
                this.l.put(savedResultKeys.get(i3), savedResult);
            }
        }
        this.D = new ArrayDeque<>(fms.i);
    }

    public a.k.b.k<?> o0() {
        return this.s;
    }

    public Fragment r0() {
        return this.u;
    }

    public a.k.b.g j0() {
        return this.t;
    }

    public u m0() {
        return this.e;
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<?> */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public void h(a.k.b.k<?> kVar, a.k.b.g container, Fragment parent) {
        String parentId;
        if (this.s != null) {
            throw new IllegalStateException("Already attached");
        }
        this.s = kVar;
        this.t = container;
        this.u = parent;
        if (parent != null) {
            f(new h(this, parent));
        } else if (kVar instanceof r) {
            f((r) kVar);
        }
        if (this.u != null) {
            e1();
        }
        if (kVar instanceof a.a.c) {
            a.a.c cVar = (a.a.c) kVar;
            OnBackPressedDispatcher c2 = cVar.c();
            this.i = c2;
            a.m.g owner = parent != null ? parent : cVar;
            c2.a(owner, this.j);
        }
        if (parent != null) {
            this.N = parent.u.i0(parent);
        } else if (kVar instanceof a.m.t) {
            a.m.s viewModelStore = ((a.m.t) kVar).e();
            this.N = q.i(viewModelStore);
        } else {
            this.N = new q(false);
        }
        this.N.n(F0());
        this.e.x(this.N);
        Object obj = this.s;
        if (obj instanceof a.a.e.e) {
            a.a.e.d registry = ((a.a.e.e) obj).g();
            if (parent != null) {
                parentId = parent.h + ":";
            } else {
                parentId = BuildConfig.FLAVOR;
            }
            String keyPrefix = "FragmentManager:" + parentId;
            this.A = registry.g(keyPrefix + "StartActivityForResult", new a.a.e.f.c(), new i());
            this.B = registry.g(keyPrefix + "StartIntentSenderForResult", new j(), new a());
            this.C = registry.g(keyPrefix + "RequestPermissions", new a.a.e.f.b(), new b());
        }
    }

    /* loaded from: classes.dex */
    public class h implements r {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f572b;

        public h(n this$0, Fragment fragment) {
            this.f572b = fragment;
        }

        @Override // a.k.b.r
        public void b(n fragmentManager, Fragment fragment) {
            this.f572b.h0();
        }
    }

    /* loaded from: classes.dex */
    public class i implements a.a.e.b<a.a.e.a> {
        public i() {
        }

        @Override // a.a.e.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(a.a.e.a result) {
            l requestInfo = n.this.D.pollFirst();
            if (requestInfo == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String fragmentWho = requestInfo.f574b;
            int requestCode = requestInfo.c;
            Fragment fragment = n.this.e.i(fragmentWho);
            if (fragment == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + fragmentWho);
                return;
            }
            fragment.e0(requestCode, result.k(), result.j());
        }
    }

    /* loaded from: classes.dex */
    public class a implements a.a.e.b<a.a.e.a> {
        public a() {
        }

        @Override // a.a.e.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(a.a.e.a result) {
            l requestInfo = n.this.D.pollFirst();
            if (requestInfo == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String fragmentWho = requestInfo.f574b;
            int requestCode = requestInfo.c;
            Fragment fragment = n.this.e.i(fragmentWho);
            if (fragment == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + fragmentWho);
                return;
            }
            fragment.e0(requestCode, result.k(), result.j());
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.a.e.b<Map<String, Boolean>> {
        public b() {
        }

        @Override // a.a.e.b
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<String, Boolean> result) {
            int i;
            ArrayList<Boolean> resultValues = new ArrayList<>(result.values());
            int[] grantResults = new int[resultValues.size()];
            for (int i2 = 0; i2 < resultValues.size(); i2++) {
                if (resultValues.get(i2).booleanValue()) {
                    i = 0;
                } else {
                    i = -1;
                }
                grantResults[i2] = i;
            }
            l requestInfo = n.this.D.pollFirst();
            if (requestInfo == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String fragmentWho = requestInfo.f574b;
            int i3 = requestInfo.c;
            Fragment fragment = n.this.e.i(fragmentWho);
            if (fragment == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + fragmentWho);
                return;
            }
            fragment.z0();
        }
    }

    public void J0() {
        if (this.s == null) {
            return;
        }
        this.F = false;
        this.G = false;
        this.N.n(false);
        for (Fragment fragment : this.e.n()) {
            if (fragment != null) {
                fragment.c0();
            }
        }
    }

    public void v() {
        this.F = false;
        this.G = false;
        this.N.n(false);
        O(0);
    }

    public void y() {
        this.F = false;
        this.G = false;
        this.N.n(false);
        O(1);
    }

    public void Q() {
        O(2);
    }

    public void u() {
        this.F = false;
        this.G = false;
        this.N.n(false);
        O(4);
    }

    public void N() {
        this.F = false;
        this.G = false;
        this.N.n(false);
        O(5);
    }

    public void M() {
        this.F = false;
        this.G = false;
        this.N.n(false);
        O(7);
    }

    public void I() {
        O(5);
    }

    public void P() {
        this.G = true;
        this.N.n(true);
        O(4);
    }

    public void B() {
        O(1);
    }

    public void A() {
        this.H = true;
        W(true);
        T();
        O(-1);
        this.s = null;
        this.t = null;
        this.u = null;
        if (this.i != null) {
            this.j.d();
            this.i = null;
        }
        a.a.e.c<Intent> cVar = this.A;
        if (cVar != null) {
            cVar.a();
            this.B.a();
            this.C.a();
        }
    }

    public final void O(int nextState) {
        try {
            this.d = true;
            this.e.d(nextState);
            G0(nextState, false);
            for (b0 controller : o()) {
                controller.j();
            }
            this.d = false;
            W(true);
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    public void D(boolean isInMultiWindowMode) {
        for (Fragment f2 : this.e.n()) {
            if (f2 != null) {
                f2.S0(isInMultiWindowMode);
            }
        }
    }

    public void J(boolean isInPictureInPictureMode) {
        for (Fragment f2 : this.e.n()) {
            if (f2 != null) {
                f2.W0(isInPictureInPictureMode);
            }
        }
    }

    public void w(Configuration newConfig) {
        for (Fragment f2 : this.e.n()) {
            if (f2 != null) {
                f2.I0(newConfig);
            }
        }
    }

    public void C() {
        for (Fragment f2 : this.e.n()) {
            if (f2 != null) {
                f2.R0();
            }
        }
    }

    public boolean z(Menu menu, MenuInflater inflater) {
        if (this.r < 1) {
            return false;
        }
        boolean show = false;
        ArrayList<Fragment> newMenus = null;
        for (Fragment f2 : this.e.n()) {
            if (f2 != null && C0(f2) && f2.L0(menu, inflater)) {
                show = true;
                if (newMenus == null) {
                    newMenus = new ArrayList<>();
                }
                newMenus.add(f2);
            }
        }
        if (this.g != null) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                Fragment f3 = this.g.get(i2);
                if (newMenus == null || !newMenus.contains(f3)) {
                    f3.o0();
                }
            }
        }
        this.g = newMenus;
        return show;
    }

    public boolean K(Menu menu) {
        if (this.r < 1) {
            return false;
        }
        boolean show = false;
        for (Fragment f2 : this.e.n()) {
            if (f2 != null && C0(f2) && f2.X0(menu)) {
                show = true;
            }
        }
        return show;
    }

    public boolean F(MenuItem item) {
        if (this.r < 1) {
            return false;
        }
        for (Fragment f2 : this.e.n()) {
            if (f2 != null && f2.T0(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean x(MenuItem item) {
        if (this.r < 1) {
            return false;
        }
        for (Fragment f2 : this.e.n()) {
            if (f2 != null && f2.J0(item)) {
                return true;
            }
        }
        return false;
    }

    public void G(Menu menu) {
        if (this.r < 1) {
            return;
        }
        for (Fragment f2 : this.e.n()) {
            if (f2 != null) {
                f2.U0(menu);
            }
        }
    }

    public void a1(Fragment f2) {
        if (f2 != null && (!f2.equals(b0(f2.h)) || (f2.v != null && f2.u != this))) {
            throw new IllegalArgumentException("Fragment " + f2 + " is not an active fragment of FragmentManager " + this);
        }
        Fragment previousPrimaryNav = this.v;
        this.v = f2;
        H(previousPrimaryNav);
        H(this.v);
    }

    public final void H(Fragment f2) {
        if (f2 != null && f2.equals(b0(f2.h))) {
            f2.Y0();
        }
    }

    public void L() {
        e1();
        H(this.v);
    }

    public Fragment s0() {
        return this.v;
    }

    public void Z0(Fragment f2, d.b state) {
        if (!f2.equals(b0(f2.h)) || (f2.v != null && f2.u != this)) {
            throw new IllegalArgumentException("Fragment " + f2 + " is not an active fragment of FragmentManager " + this);
        }
        f2.R = state;
    }

    public a.k.b.j l0() {
        Fragment fragment = this.u;
        if (fragment != null) {
            return fragment.u.l0();
        }
        return this.x;
    }

    public c0 t0() {
        Fragment fragment = this.u;
        if (fragment != null) {
            return fragment.u.t0();
        }
        return this.z;
    }

    public a.k.b.m q0() {
        return this.p;
    }

    public void f(r listener) {
        this.q.add(listener);
    }

    public void E(Fragment fragment) {
        Iterator<r> it = this.q.iterator();
        while (it.hasNext()) {
            r listener = it.next();
            listener.b(this, fragment);
        }
    }

    public boolean l() {
        boolean hasMenu = false;
        for (Fragment fragment : this.e.l()) {
            if (fragment != null) {
                hasMenu = B0(fragment);
            }
            if (hasMenu) {
                return true;
            }
        }
        return false;
    }

    public final boolean B0(Fragment f2) {
        f2.getClass();
        return f2.w.l();
    }

    public void y0(Fragment f2) {
        if (f2.n && B0(f2)) {
            this.E = true;
        }
    }

    public static int V0(int transit) {
        switch (transit) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public LayoutInflater.Factory2 p0() {
        return this.h;
    }

    /* renamed from: a.k.b.n$n, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0043n implements m {

        /* renamed from: a, reason: collision with root package name */
        public final String f575a;

        /* renamed from: b, reason: collision with root package name */
        public final int f576b;
        public final int c;

        public C0043n(String name, int id, int flags) {
            this.f575a = name;
            this.f576b = id;
            this.c = flags;
        }

        @Override // a.k.b.n.m
        public boolean a(ArrayList<a.k.b.a> arrayList, ArrayList<Boolean> isRecordPop) {
            Fragment fragment = n.this.v;
            if (fragment != null && this.f576b < 0) {
                n childManager = fragment.p();
                if (childManager.N0()) {
                    return false;
                }
            }
            return n.this.P0(arrayList, isRecordPop, null, this.f576b, this.c);
        }
    }

    /* loaded from: classes.dex */
    public static class o implements Fragment.h {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f577a;

        /* renamed from: b, reason: collision with root package name */
        public final a.k.b.a f578b;
        public int c;

        public void d() {
            int i = this.c - 1;
            this.c = i;
            if (i != 0) {
                return;
            }
            this.f578b.q.X0();
        }

        public void e() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void b() {
            boolean canceled = this.c > 0;
            n manager = this.f578b.q;
            for (Fragment fragment : manager.n0()) {
                fragment.r1(null);
                if (canceled && fragment.Y()) {
                    fragment.v1();
                }
            }
            a.k.b.a aVar = this.f578b;
            aVar.q.q(aVar, this.f577a, canceled ? false : true, true);
        }

        public void a() {
            a.k.b.a aVar = this.f578b;
            aVar.q.q(aVar, this.f577a, false, false);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class l implements Parcelable {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public String f574b;
        public int c;

        public l(Parcel in) {
            this.f574b = in.readString();
            this.c = in.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.f574b);
            dest.writeInt(this.c);
        }

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<l> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel in) {
                return new l(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public l[] newArray(int size) {
                return new l[size];
            }
        }
    }

    /* loaded from: classes.dex */
    public static class j extends a.a.e.f.a<?, a.a.e.a> {
        @Override // a.a.e.f.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a.a.e.a a(int resultCode, Intent intent) {
            return new a.a.e.a(resultCode, intent);
        }
    }
}
