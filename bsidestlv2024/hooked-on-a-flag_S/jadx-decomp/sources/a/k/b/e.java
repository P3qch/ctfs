package a.k.b;

import a.m.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class e extends ComponentActivity {
    public boolean k;
    public boolean l;
    public final i i = i.b(new c());
    public final a.m.h j = new a.m.h(this);
    public boolean m = true;

    public e() {
        s();
    }

    /* loaded from: classes.dex */
    public class a implements SavedStateRegistry.b {
        public a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            Bundle outState = new Bundle();
            e.this.t();
            e.this.j.h(d.a.ON_STOP);
            Parcelable p = e.this.i.x();
            if (p != null) {
                outState.putParcelable("android:support:fragments", p);
            }
            return outState;
        }
    }

    public final void s() {
        d().d("android:support:fragments", new a());
        m(new b());
    }

    /* loaded from: classes.dex */
    public class b implements a.a.d.b {
        public b() {
        }

        @Override // a.a.d.b
        public void a(Context context) {
            e.this.i.a(null);
            Bundle savedInstanceState = e.this.d().a("android:support:fragments");
            if (savedInstanceState != null) {
                Parcelable p = savedInstanceState.getParcelable("android:support:fragments");
                e.this.i.w(p);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.i.u();
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        this.i.j(isInMultiWindowMode);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        this.i.n(isInPictureInPictureMode);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        this.i.u();
        super.onConfigurationChanged(newConfig);
        this.i.d(newConfig);
    }

    @Override // androidx.activity.ComponentActivity, a.h.b.d, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.j.h(d.a.ON_CREATE);
        this.i.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId == 0) {
            boolean show = super.onCreatePanelMenu(featureId, menu);
            return show | this.i.g(menu, getMenuInflater());
        }
        boolean show2 = super.onCreatePanelMenu(featureId, menu);
        return show2;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View v = q(parent, name, context, attrs);
        if (v == null) {
            return super.onCreateView(parent, name, context, attrs);
        }
        return v;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View v = q(null, name, context, attrs);
        if (v == null) {
            return super.onCreateView(name, context, attrs);
        }
        return v;
    }

    public final View q(View parent, String name, Context context, AttributeSet attrs) {
        return this.i.v(parent, name, context, attrs);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.i.h();
        this.j.h(d.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.i.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }
        switch (featureId) {
            case 0:
                return this.i.k(item);
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                return this.i.e(item);
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int featureId, Menu menu) {
        if (featureId == 0) {
            this.i.l(menu);
        }
        super.onPanelClosed(featureId, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.l = false;
        this.i.m();
        this.j.h(d.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.i.u();
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.i.u();
    }

    @Override // android.app.Activity
    public void onResume() {
        this.i.u();
        super.onResume();
        this.l = true;
        this.i.s();
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        x();
    }

    public void x() {
        this.j.h(d.a.ON_RESUME);
        this.i.p();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (featureId == 0) {
            boolean goforit = w(view, menu);
            return goforit | this.i.o(menu);
        }
        boolean goforit2 = super.onPreparePanel(featureId, view, menu);
        return goforit2;
    }

    @Deprecated
    public boolean w(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.i.u();
        super.onStart();
        this.m = false;
        if (!this.k) {
            this.k = true;
            this.i.c();
        }
        this.i.s();
        this.j.h(d.a.ON_START);
        this.i.q();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.m = true;
        t();
        this.i.r();
        this.j.h(d.a.ON_STOP);
    }

    @Deprecated
    public void y() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        writer.print(prefix);
        writer.print("Local FragmentActivity ");
        writer.print(Integer.toHexString(System.identityHashCode(this)));
        writer.println(" State:");
        String innerPrefix = prefix + "  ";
        writer.print(innerPrefix);
        writer.print("mCreated=");
        writer.print(this.k);
        writer.print(" mResumed=");
        writer.print(this.l);
        writer.print(" mStopped=");
        writer.print(this.m);
        if (getApplication() != null) {
            a.n.a.a.b(this).a(innerPrefix, fd, writer, args);
        }
        this.i.t().S(prefix, fd, writer, args);
    }

    @Deprecated
    public void v() {
    }

    public n r() {
        return this.i.t();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        this.i.u();
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* loaded from: classes.dex */
    public class c extends k<e> implements a.m.t, a.a.c, a.a.e.e, r {
        public c() {
            super(e.this);
        }

        @Override // a.m.g
        public a.m.d a() {
            return e.this.j;
        }

        @Override // a.m.t
        public a.m.s e() {
            return e.this.e();
        }

        @Override // a.a.c
        public OnBackPressedDispatcher c() {
            return e.this.c();
        }

        @Override // a.k.b.k
        public boolean o(Fragment fragment) {
            return !e.this.isFinishing();
        }

        @Override // a.k.b.k
        public LayoutInflater n() {
            return e.this.getLayoutInflater().cloneInContext(e.this);
        }

        @Override // a.k.b.k
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public e m() {
            return e.this;
        }

        @Override // a.k.b.k
        public void p() {
            e.this.y();
        }

        @Override // a.k.b.r
        public void b(n fragmentManager, Fragment fragment) {
            e.this.v();
        }

        @Override // a.k.b.k, a.k.b.g
        public View h(int id) {
            return e.this.findViewById(id);
        }

        @Override // a.k.b.k, a.k.b.g
        public boolean i() {
            Window w = e.this.getWindow();
            return (w == null || w.peekDecorView() == null) ? false : true;
        }

        @Override // a.a.e.e
        public a.a.e.d g() {
            return e.this.g();
        }
    }

    public void t() {
        boolean reiterate;
        do {
            reiterate = u(r(), d.b.CREATED);
        } while (reiterate);
    }

    public static boolean u(n manager, d.b state) {
        boolean hadNotMarked = false;
        Collection<Fragment> fragments = manager.n0();
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                if (fragment.y() != null) {
                    n childFragmentManager = fragment.p();
                    hadNotMarked |= u(childFragmentManager, state);
                }
                z zVar = fragment.T;
                if (zVar != null && zVar.a().b().a(d.b.STARTED)) {
                    fragment.T.j(state);
                    hadNotMarked = true;
                }
                if (fragment.S.b().a(d.b.STARTED)) {
                    fragment.S.o(state);
                    hadNotMarked = true;
                }
            }
        }
        return hadNotMarked;
    }
}
