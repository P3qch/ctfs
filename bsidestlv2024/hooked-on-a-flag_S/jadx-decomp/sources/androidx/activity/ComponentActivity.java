package androidx.activity;

import a.m.d;
import a.m.g;
import a.m.h;
import a.m.o;
import a.m.s;
import a.m.t;
import a.m.u;
import a.m.v;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.savedstate.SavedStateRegistry;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ComponentActivity extends a.h.b.d implements g, t, a.p.b, a.a.c, a.a.e.e {
    public s f;
    public final a.a.e.d h;
    public final a.a.d.a c = new a.a.d.a();
    public final h d = new h(this);
    public final a.p.a e = a.p.a.a(this);
    public final OnBackPressedDispatcher g = new OnBackPressedDispatcher(new a());

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public s f774a;
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends a.a.e.d {
        public b(ComponentActivity this$0) {
        }
    }

    public ComponentActivity() {
        new AtomicInteger();
        this.h = new b(this);
        a.m.d lifecycle = a();
        if (lifecycle == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            a().a(new a.m.e() { // from class: androidx.activity.ComponentActivity.3
                @Override // a.m.e
                public void g(g source, d.a event) {
                    if (event == d.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View decor = window != null ? window.peekDecorView() : null;
                        if (decor != null) {
                            decor.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        a().a(new a.m.e() { // from class: androidx.activity.ComponentActivity.4
            @Override // a.m.e
            public void g(g source, d.a event) {
                if (event == d.a.ON_DESTROY) {
                    ComponentActivity.this.c.b();
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.e().a();
                    }
                }
            }
        });
        a().a(new a.m.e() { // from class: androidx.activity.ComponentActivity.5
            @Override // a.m.e
            public void g(g source, d.a event) {
                ComponentActivity.this.n();
                ComponentActivity.this.a().c(this);
            }
        });
        if (19 <= i && i <= 23) {
            a().a(new ImmLeaksCleaner(this));
        }
        d().d("android:support:activity-result", new c());
        m(new d());
    }

    /* loaded from: classes.dex */
    public class c implements SavedStateRegistry.b {
        public c() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        @SuppressLint({"SyntheticAccessor"})
        public Bundle a() {
            Bundle outState = new Bundle();
            ComponentActivity.this.h.f(outState);
            return outState;
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.a.d.b {
        public d() {
        }

        @Override // a.a.d.b
        @SuppressLint({"SyntheticAccessor"})
        public void a(Context context) {
            Bundle savedInstanceState = ComponentActivity.this.d().a("android:support:activity-result");
            if (savedInstanceState != null) {
                ComponentActivity.this.h.e(savedInstanceState);
            }
        }
    }

    @Override // a.h.b.d, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        this.e.c(savedInstanceState);
        this.c.c(this);
        super.onCreate(savedInstanceState);
        o.f(this);
    }

    @Override // a.h.b.d, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        a.m.d lifecycle = a();
        if (lifecycle instanceof h) {
            ((h) lifecycle).o(d.b.CREATED);
        }
        super.onSaveInstanceState(outState);
        this.e.d(outState);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e nc;
        p();
        s viewModelStore = this.f;
        if (viewModelStore == null && (nc = (e) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nc.f774a;
        }
        if (viewModelStore == null && 0 == 0) {
            return null;
        }
        e nci = new e();
        nci.f774a = viewModelStore;
        return nci;
    }

    @Deprecated
    public Object p() {
        return null;
    }

    @Override // android.app.Activity
    public void setContentView(int layoutResID) {
        o();
        super.setContentView(layoutResID);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        o();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams params) {
        o();
        super.setContentView(view, params);
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams params) {
        o();
        super.addContentView(view, params);
    }

    public final void o() {
        u.a(getWindow().getDecorView(), this);
        v.a(getWindow().getDecorView(), this);
        a.p.c.a(getWindow().getDecorView(), this);
    }

    public final void m(a.a.d.b listener) {
        this.c.a(listener);
    }

    @Override // a.m.g
    public a.m.d a() {
        return this.d;
    }

    @Override // a.m.t
    public s e() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        n();
        return this.f;
    }

    public void n() {
        if (this.f == null) {
            e nc = (e) getLastNonConfigurationInstance();
            if (nc != null) {
                this.f = nc.f774a;
            }
            if (this.f == null) {
                this.f = new s();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.g.c();
    }

    @Override // a.a.c
    public final OnBackPressedDispatcher c() {
        return this.g;
    }

    @Override // a.p.b
    public final SavedStateRegistry d() {
        return this.e.b();
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int requestCode, Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) {
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) {
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!this.h.b(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (!this.h.b(requestCode, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", permissions).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", grantResults)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override // a.a.e.e
    public final a.a.e.d g() {
        return this.h;
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (a.r.a.d()) {
                a.r.a.a("reportFullyDrawn() for " + getComponentName());
            }
            int i = Build.VERSION.SDK_INT;
            if (i > 19) {
                super.reportFullyDrawn();
            } else if (i == 19 && a.h.c.a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
        } finally {
            a.r.a.b();
        }
    }
}
