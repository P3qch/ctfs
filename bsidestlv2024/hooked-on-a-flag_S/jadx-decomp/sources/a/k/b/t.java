package a.k.b;

import a.k.b.b0;
import a.m.d;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.R;
import net.sqlcipher.database.SQLiteCursor;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public final m f582a;

    /* renamed from: b, reason: collision with root package name */
    public final u f583b;
    public final Fragment c;
    public boolean d = false;
    public int e = -1;

    public t(m dispatcher, u fragmentStore, Fragment fragment) {
        this.f582a = dispatcher;
        this.f583b = fragmentStore;
        this.c = fragment;
    }

    public t(m dispatcher, u fragmentStore, ClassLoader classLoader, j fragmentFactory, s fs) {
        this.f582a = dispatcher;
        this.f583b = fragmentStore;
        Fragment a2 = fragmentFactory.a(classLoader, fs.f581b);
        this.c = a2;
        Bundle bundle = fs.k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.n1(fs.k);
        a2.h = fs.c;
        a2.p = fs.d;
        a2.r = true;
        a2.y = fs.e;
        a2.z = fs.f;
        a2.A = fs.g;
        a2.D = fs.h;
        a2.o = fs.i;
        a2.C = fs.j;
        a2.B = fs.l;
        a2.R = d.b.values()[fs.m];
        Bundle bundle2 = fs.n;
        if (bundle2 != null) {
            a2.d = bundle2;
        } else {
            a2.d = new Bundle();
        }
        if (n.A0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a2);
        }
    }

    public t(m dispatcher, u fragmentStore, Fragment retainedFragment, s fs) {
        this.f582a = dispatcher;
        this.f583b = fragmentStore;
        this.c = retainedFragment;
        retainedFragment.e = null;
        retainedFragment.f = null;
        retainedFragment.t = 0;
        retainedFragment.q = false;
        retainedFragment.n = false;
        Fragment fragment = retainedFragment.j;
        retainedFragment.k = fragment != null ? fragment.h : null;
        retainedFragment.j = null;
        Bundle bundle = fs.n;
        if (bundle != null) {
            retainedFragment.d = bundle;
        } else {
            retainedFragment.d = new Bundle();
        }
    }

    public Fragment k() {
        return this.c;
    }

    public void t(int state) {
        this.e = state;
    }

    public int d() {
        Fragment fragment = this.c;
        if (fragment.u == null) {
            return fragment.c;
        }
        int maxState = this.e;
        switch (fragment.R.ordinal()) {
            case 1:
                maxState = Math.min(maxState, 0);
                break;
            case 2:
                maxState = Math.min(maxState, 1);
                break;
            case 3:
                maxState = Math.min(maxState, 5);
                break;
            case 4:
                break;
            default:
                maxState = Math.min(maxState, -1);
                break;
        }
        Fragment fragment2 = this.c;
        if (fragment2.p) {
            if (fragment2.q) {
                maxState = Math.max(this.e, 2);
                View view = this.c.I;
                if (view != null && view.getParent() == null) {
                    maxState = Math.min(maxState, 2);
                }
            } else {
                maxState = this.e < 4 ? Math.min(maxState, fragment2.c) : Math.min(maxState, 1);
            }
        }
        if (!this.c.n) {
            maxState = Math.min(maxState, 1);
        }
        b0.d.b awaitingEffect = null;
        Fragment fragment3 = this.c;
        ViewGroup viewGroup = fragment3.H;
        if (viewGroup != null) {
            b0 controller = b0.n(viewGroup, fragment3.D());
            awaitingEffect = controller.l(this);
        }
        if (awaitingEffect == b0.d.b.ADDING) {
            maxState = Math.min(maxState, 6);
        } else if (awaitingEffect == b0.d.b.REMOVING) {
            maxState = Math.max(maxState, 3);
        } else {
            Fragment fragment4 = this.c;
            if (fragment4.o) {
                if (fragment4.W()) {
                    maxState = Math.min(maxState, 1);
                } else {
                    maxState = Math.min(maxState, -1);
                }
            }
        }
        Fragment fragment5 = this.c;
        if (fragment5.J && fragment5.c < 5) {
            maxState = Math.min(maxState, 4);
        }
        if (n.A0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + maxState + " for " + this.c);
        }
        return maxState;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.d) {
            if (n.A0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.d = true;
            while (true) {
                int newState = d();
                Fragment fragment = this.c;
                int i = fragment.c;
                if (newState != i) {
                    if (newState > i) {
                        int nextStep = i + 1;
                        switch (nextStep) {
                            case 0:
                                c();
                                break;
                            case 1:
                                e();
                                break;
                            case 2:
                                j();
                                f();
                                break;
                            case 3:
                                a();
                                break;
                            case 4:
                                if (fragment.I != null && (viewGroup2 = fragment.H) != null) {
                                    b0 controller = b0.n(viewGroup2, fragment.D());
                                    int visibility = this.c.I.getVisibility();
                                    b0.d.c finalState = b0.d.c.b(visibility);
                                    controller.b(finalState, this);
                                }
                                this.c.c = 4;
                                break;
                            case 5:
                                u();
                                break;
                            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                                fragment.c = 6;
                                break;
                            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                                p();
                                break;
                        }
                    } else {
                        int nextStep2 = i - 1;
                        switch (nextStep2) {
                            case SQLiteCursor.NO_COUNT /* -1 */:
                                i();
                                break;
                            case 0:
                                g();
                                break;
                            case 1:
                                h();
                                this.c.c = 1;
                                break;
                            case 2:
                                fragment.q = false;
                                fragment.c = 2;
                                break;
                            case 3:
                                if (n.A0(3)) {
                                    Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.c);
                                }
                                Fragment fragment2 = this.c;
                                if (fragment2.I != null && fragment2.e == null) {
                                    s();
                                }
                                Fragment fragment3 = this.c;
                                if (fragment3.I != null && (viewGroup3 = fragment3.H) != null) {
                                    b0.n(viewGroup3, fragment3.D()).d(this);
                                }
                                this.c.c = 3;
                                break;
                            case 4:
                                v();
                                break;
                            case 5:
                                fragment.c = 5;
                                break;
                            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                                n();
                                break;
                        }
                    }
                } else {
                    if (fragment.N) {
                        if (fragment.I != null && (viewGroup = fragment.H) != null) {
                            b0 controller2 = b0.n(viewGroup, fragment.D());
                            if (this.c.B) {
                                controller2.c(this);
                            } else {
                                controller2.e(this);
                            }
                        }
                        Fragment fragment4 = this.c;
                        n nVar = fragment4.u;
                        if (nVar != null) {
                            nVar.y0(fragment4);
                        }
                        Fragment fragment5 = this.c;
                        fragment5.N = false;
                        boolean z = fragment5.B;
                        fragment5.s0();
                    }
                    return;
                }
            }
        } finally {
            this.d = false;
        }
    }

    public void j() {
        Fragment fragment = this.c;
        if (fragment.p && fragment.q && !fragment.s) {
            if (n.A0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
            }
            Fragment fragment2 = this.c;
            fragment2.M0(fragment2.Q0(fragment2.d), null, this.c.d);
            View view = this.c.I;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.c;
                fragment3.I.setTag(R.id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.c;
                if (fragment4.B) {
                    fragment4.I.setVisibility(8);
                }
                this.c.d1();
                m mVar = this.f582a;
                Fragment fragment5 = this.c;
                mVar.m(fragment5, fragment5.I, fragment5.d, false);
                this.c.c = 2;
            }
        }
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.c.d;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.c;
        fragment.e = fragment.d.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.c;
        fragment2.f = fragment2.d.getBundle("android:view_registry_state");
        Fragment fragment3 = this.c;
        fragment3.k = fragment3.d.getString("android:target_state");
        Fragment fragment4 = this.c;
        if (fragment4.k != null) {
            fragment4.l = fragment4.d.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.c;
        Boolean bool = fragment5.g;
        if (bool != null) {
            fragment5.K = bool.booleanValue();
            this.c.g = null;
        } else {
            fragment5.K = fragment5.d.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.c;
        if (!fragment6.K) {
            fragment6.J = true;
        }
    }

    public void c() {
        t targetFragmentStateManager;
        if (n.A0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.c);
        }
        Fragment fragment = this.c;
        Fragment fragment2 = fragment.j;
        if (fragment2 != null) {
            targetFragmentStateManager = this.f583b.m(fragment2.h);
            if (targetFragmentStateManager == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.j + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.c;
            fragment3.k = fragment3.j.h;
            fragment3.j = null;
        } else {
            String str = fragment.k;
            if (str != null) {
                targetFragmentStateManager = this.f583b.m(str);
                if (targetFragmentStateManager == null) {
                    throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.k + " that does not belong to this FragmentManager!");
                }
            } else {
                targetFragmentStateManager = null;
            }
        }
        if (targetFragmentStateManager != null) {
            targetFragmentStateManager.m();
        }
        Fragment fragment4 = this.c;
        fragment4.v = fragment4.u.o0();
        Fragment fragment5 = this.c;
        fragment5.x = fragment5.u.r0();
        this.f582a.g(this.c, false);
        this.c.H0();
        this.f582a.b(this.c, false);
    }

    public void e() {
        if (n.A0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        if (!fragment.Q) {
            this.f582a.h(fragment, fragment.d, false);
            Fragment fragment2 = this.c;
            fragment2.K0(fragment2.d);
            m mVar = this.f582a;
            Fragment fragment3 = this.c;
            mVar.c(fragment3, fragment3.d, false);
            return;
        }
        fragment.h1(fragment.d);
        this.c.c = 1;
    }

    public void f() {
        String resName;
        if (this.c.p) {
            return;
        }
        if (n.A0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        LayoutInflater layoutInflater = fragment.Q0(fragment.d);
        ViewGroup container = null;
        Fragment fragment2 = this.c;
        if (fragment2.H != null) {
            container = fragment2.H;
        } else {
            int i = fragment2.z;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.c + " for a container view with no id");
                }
                g fragmentContainer = fragment2.u.j0();
                container = (ViewGroup) fragmentContainer.h(this.c.z);
                if (container == null) {
                    Fragment fragment3 = this.c;
                    if (!fragment3.r) {
                        try {
                            resName = fragment3.J().getResourceName(this.c.z);
                        } catch (Resources.NotFoundException e) {
                            resName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.c.z) + " (" + resName + ") for fragment " + this.c);
                    }
                }
            }
        }
        Fragment fragment4 = this.c;
        fragment4.H = container;
        fragment4.M0(layoutInflater, container, fragment4.d);
        View view = this.c.I;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.c;
            fragment5.I.setTag(R.id.fragment_container_view_tag, fragment5);
            if (container != null) {
                b();
            }
            Fragment fragment6 = this.c;
            if (fragment6.B) {
                fragment6.I.setVisibility(8);
            }
            if (a.h.k.v.S(this.c.I)) {
                a.h.k.v.l0(this.c.I);
            } else {
                View fragmentView = this.c.I;
                fragmentView.addOnAttachStateChangeListener(new a(this, fragmentView));
            }
            this.c.d1();
            m mVar = this.f582a;
            Fragment fragment7 = this.c;
            mVar.m(fragment7, fragment7.I, fragment7.d, false);
            int postOnViewCreatedVisibility = this.c.I.getVisibility();
            float postOnViewCreatedAlpha = this.c.I.getAlpha();
            this.c.t1(postOnViewCreatedAlpha);
            Fragment fragment8 = this.c;
            if (fragment8.H != null && postOnViewCreatedVisibility == 0) {
                View focusedView = fragment8.I.findFocus();
                if (focusedView != null) {
                    this.c.o1(focusedView);
                    if (n.A0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + focusedView + " for Fragment " + this.c);
                    }
                }
                this.c.I.setAlpha(0.0f);
            }
        }
        this.c.c = 2;
    }

    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f584b;

        public a(t this$0, View view) {
            this.f584b = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            this.f584b.removeOnAttachStateChangeListener(this);
            a.h.k.v.l0(this.f584b);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
        }
    }

    public void a() {
        if (n.A0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        fragment.G0(fragment.d);
        m mVar = this.f582a;
        Fragment fragment2 = this.c;
        mVar.a(fragment2, fragment2.d, false);
    }

    public void u() {
        if (n.A0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.c);
        }
        this.c.b1();
        this.f582a.k(this.c, false);
    }

    public void p() {
        if (n.A0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.c);
        }
        View focusedView = this.c.x();
        if (focusedView != null && l(focusedView)) {
            boolean success = focusedView.requestFocus();
            if (n.A0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(success ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.c);
                sb.append(" resulting in focused view ");
                sb.append(this.c.I.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.c.o1(null);
        this.c.Z0();
        this.f582a.i(this.c, false);
        Fragment fragment = this.c;
        fragment.d = null;
        fragment.e = null;
        fragment.f = null;
    }

    public final boolean l(View view) {
        if (view == this.c.I) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.c.I) {
                return true;
            }
        }
        return false;
    }

    public void n() {
        if (n.A0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.c);
        }
        this.c.V0();
        this.f582a.f(this.c, false);
    }

    public void v() {
        if (n.A0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.c);
        }
        this.c.c1();
        this.f582a.l(this.c, false);
    }

    public s r() {
        s fs = new s(this.c);
        Fragment fragment = this.c;
        if (fragment.c > -1 && fs.n == null) {
            Bundle q = q();
            fs.n = q;
            if (this.c.k != null) {
                if (q == null) {
                    fs.n = new Bundle();
                }
                fs.n.putString("android:target_state", this.c.k);
                int i = this.c.l;
                if (i != 0) {
                    fs.n.putInt("android:target_req_state", i);
                }
            }
        } else {
            fs.n = fragment.d;
        }
        return fs;
    }

    public final Bundle q() {
        Bundle result = new Bundle();
        this.c.a1(result);
        this.f582a.j(this.c, result, false);
        if (result.isEmpty()) {
            result = null;
        }
        if (this.c.I != null) {
            s();
        }
        if (this.c.e != null) {
            if (result == null) {
                result = new Bundle();
            }
            result.putSparseParcelableArray("android:view_state", this.c.e);
        }
        if (this.c.f != null) {
            if (result == null) {
                result = new Bundle();
            }
            result.putBundle("android:view_registry_state", this.c.f);
        }
        if (!this.c.K) {
            if (result == null) {
                result = new Bundle();
            }
            result.putBoolean("android:user_visible_hint", this.c.K);
        }
        return result;
    }

    public void s() {
        if (this.c.I == null) {
            return;
        }
        SparseArray<Parcelable> mStateArray = new SparseArray<>();
        this.c.I.saveHierarchyState(mStateArray);
        if (mStateArray.size() > 0) {
            this.c.e = mStateArray;
        }
        Bundle outBundle = new Bundle();
        this.c.T.i(outBundle);
        if (!outBundle.isEmpty()) {
            this.c.f = outBundle;
        }
    }

    public void h() {
        View view;
        if (n.A0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        ViewGroup viewGroup = fragment.H;
        if (viewGroup != null && (view = fragment.I) != null) {
            viewGroup.removeView(view);
        }
        this.c.O0();
        this.f582a.n(this.c, false);
        Fragment fragment2 = this.c;
        fragment2.H = null;
        fragment2.I = null;
        fragment2.T = null;
        fragment2.U.j(null);
        this.c.q = false;
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<?> */
    public void g() {
        Fragment target;
        boolean shouldClear;
        if (n.A0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        boolean beingRemoved = fragment.o && !fragment.W();
        boolean shouldDestroy = beingRemoved || this.f583b.o().o(this.c);
        if (shouldDestroy) {
            k<?> kVar = this.c.v;
            if (kVar instanceof a.m.t) {
                shouldClear = this.f583b.o().l();
            } else if (kVar.k() instanceof Activity) {
                Activity activity = (Activity) kVar.k();
                shouldClear = true ^ activity.isChangingConfigurations();
            } else {
                shouldClear = true;
            }
            if (beingRemoved || shouldClear) {
                this.f583b.o().f(this.c);
            }
            this.c.N0();
            this.f582a.d(this.c, false);
            for (t fragmentStateManager : this.f583b.k()) {
                if (fragmentStateManager != null) {
                    Fragment fragment2 = fragmentStateManager.k();
                    if (this.c.h.equals(fragment2.k)) {
                        fragment2.j = this.c;
                        fragment2.k = null;
                    }
                }
            }
            Fragment fragment3 = this.c;
            String str = fragment3.k;
            if (str != null) {
                fragment3.j = this.f583b.f(str);
            }
            this.f583b.q(this);
            return;
        }
        String str2 = this.c.k;
        if (str2 != null && (target = this.f583b.f(str2)) != null && target.D) {
            this.c.j = target;
        }
        this.c.c = 0;
    }

    public void i() {
        if (n.A0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.c);
        }
        this.c.P0();
        boolean z = false;
        this.f582a.e(this.c, false);
        Fragment fragment = this.c;
        fragment.c = -1;
        fragment.v = null;
        fragment.x = null;
        fragment.u = null;
        if (fragment.o && !fragment.W()) {
            z = true;
        }
        boolean beingRemoved = z;
        if (beingRemoved || this.f583b.o().o(this.c)) {
            if (n.A0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.c);
            }
            this.c.U();
        }
    }

    public void b() {
        int index = this.f583b.j(this.c);
        Fragment fragment = this.c;
        fragment.H.addView(fragment.I, index);
    }
}
