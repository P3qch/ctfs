package a.k.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public class d extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler X;
    public boolean g0;
    public Dialog i0;
    public boolean j0;
    public boolean k0;
    public boolean l0;
    public Runnable Y = new a();
    public DialogInterface.OnCancelListener Z = new b();
    public DialogInterface.OnDismissListener a0 = new c();
    public int b0 = 0;
    public int c0 = 0;
    public boolean d0 = true;
    public boolean e0 = true;
    public int f0 = -1;
    public a.m.m<a.m.g> h0 = new C0042d();
    public boolean m0 = false;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            d.this.a0.onDismiss(d.this.i0);
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialog) {
            if (d.this.i0 != null) {
                d dVar = d.this;
                dVar.onCancel(dVar.i0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialog) {
            if (d.this.i0 != null) {
                d dVar = d.this;
                dVar.onDismiss(dVar.i0);
            }
        }
    }

    /* renamed from: a.k.b.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0042d implements a.m.m<a.m.g> {
        public C0042d() {
        }

        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(a.m.g lifecycleOwner) {
            if (lifecycleOwner != null && d.this.e0) {
                View view = d.this.g1();
                if (view.getParent() == null) {
                    if (d.this.i0 != null) {
                        if (n.A0(3)) {
                            Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + d.this.i0);
                        }
                        d.this.i0.setContentView(view);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
        }
    }

    public void z1() {
        A1(false, false);
    }

    public final void A1(boolean allowStateLoss, boolean fromOnDismiss) {
        if (this.k0) {
            return;
        }
        this.k0 = true;
        this.l0 = false;
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.i0.dismiss();
            if (!fromOnDismiss) {
                if (Looper.myLooper() == this.X.getLooper()) {
                    onDismiss(this.i0);
                } else {
                    this.X.post(this.Y);
                }
            }
        }
        this.j0 = true;
        if (this.f0 >= 0) {
            D().M0(this.f0, 1);
            this.f0 = -1;
            return;
        }
        v ft = D().j();
        ft.k(this);
        if (allowStateLoss) {
            ft.f();
        } else {
            ft.e();
        }
    }

    public Dialog B1() {
        return this.i0;
    }

    public final Dialog H1() {
        Dialog dialog = B1();
        if (dialog == null) {
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        return dialog;
    }

    public int C1() {
        return this.c0;
    }

    @Override // androidx.fragment.app.Fragment
    public void g0(Context context) {
        super.g0(context);
        S().f(this.h0);
        this.k0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void q0() {
        super.q0();
        if (!this.k0) {
            this.k0 = true;
        }
        S().i(this.h0);
    }

    @Override // androidx.fragment.app.Fragment
    public void j0(Bundle savedInstanceState) {
        super.j0(savedInstanceState);
        this.X = new Handler();
        this.e0 = this.z == 0;
        if (savedInstanceState != null) {
            this.b0 = savedInstanceState.getInt("android:style", 0);
            this.c0 = savedInstanceState.getInt("android:theme", 0);
            this.d0 = savedInstanceState.getBoolean("android:cancelable", true);
            this.e0 = savedInstanceState.getBoolean("android:showsDialog", this.e0);
            this.f0 = savedInstanceState.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M0(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle dialogState;
        super.M0(inflater, container, savedInstanceState);
        if (this.I == null && this.i0 != null && savedInstanceState != null && (dialogState = savedInstanceState.getBundle("android:savedDialogState")) != null) {
            this.i0.onRestoreInstanceState(dialogState);
        }
    }

    /* loaded from: classes.dex */
    public class e extends g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f544a;

        public e(g gVar) {
            this.f544a = gVar;
        }

        @Override // a.k.b.g
        public View h(int id) {
            if (this.f544a.i()) {
                return this.f544a.h(id);
            }
            return d.this.E1(id);
        }

        @Override // a.k.b.g
        public boolean i() {
            return this.f544a.i() || d.this.F1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public g f() {
        g fragmentContainer = super.f();
        return new e(fragmentContainer);
    }

    public View E1(int id) {
        Dialog dialog = this.i0;
        if (dialog != null) {
            return dialog.findViewById(id);
        }
        return null;
    }

    public boolean F1() {
        return this.m0;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater r0(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = super.r0(savedInstanceState);
        if (!this.e0 || this.g0) {
            if (n.A0(2)) {
                String message = "getting layout inflater for DialogFragment " + this;
                if (!this.e0) {
                    Log.d("FragmentManager", "mShowsDialog = false: " + message);
                } else {
                    Log.d("FragmentManager", "mCreatingDialog = true: " + message);
                }
            }
            return layoutInflater;
        }
        G1(savedInstanceState);
        if (n.A0(2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.i0;
        if (dialog != null) {
            return layoutInflater.cloneInContext(dialog.getContext());
        }
        return layoutInflater;
    }

    public void I1(Dialog dialog, int style) {
        switch (style) {
            case 1:
            case 2:
                break;
            case 3:
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                    break;
                }
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog D1(Bundle savedInstanceState) {
        if (n.A0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(f1(), C1());
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        if (!this.j0) {
            if (n.A0(3)) {
                Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }
            A1(true, true);
        }
    }

    public final void G1(Bundle savedInstanceState) {
        if (this.e0 && !this.m0) {
            try {
                this.g0 = true;
                Dialog D1 = D1(savedInstanceState);
                this.i0 = D1;
                if (this.e0) {
                    I1(D1, this.b0);
                    Context context = q();
                    if (context instanceof Activity) {
                        this.i0.setOwnerActivity((Activity) context);
                    }
                    this.i0.setCancelable(this.d0);
                    this.i0.setOnCancelListener(this.Z);
                    this.i0.setOnDismissListener(this.a0);
                    this.m0 = true;
                } else {
                    this.i0 = null;
                }
            } finally {
                this.g0 = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F0(Bundle savedInstanceState) {
        Bundle dialogState;
        super.F0(savedInstanceState);
        if (this.i0 != null && savedInstanceState != null && (dialogState = savedInstanceState.getBundle("android:savedDialogState")) != null) {
            this.i0.onRestoreInstanceState(dialogState);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void C0() {
        super.C0();
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.j0 = false;
            dialog.show();
            View decorView = this.i0.getWindow().getDecorView();
            a.m.u.a(decorView, this);
            a.m.v.a(decorView, this);
            a.p.c.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle outState) {
        super.B0(outState);
        Dialog dialog = this.i0;
        if (dialog != null) {
            Bundle dialogState = dialog.onSaveInstanceState();
            dialogState.putBoolean("android:dialogShowing", false);
            outState.putBundle("android:savedDialogState", dialogState);
        }
        int i = this.b0;
        if (i != 0) {
            outState.putInt("android:style", i);
        }
        int i2 = this.c0;
        if (i2 != 0) {
            outState.putInt("android:theme", i2);
        }
        boolean z = this.d0;
        if (!z) {
            outState.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.e0;
        if (!z2) {
            outState.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.f0;
        if (i3 != -1) {
            outState.putInt("android:backStackId", i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void D0() {
        super.D0();
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void p0() {
        super.p0();
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.j0 = true;
            dialog.setOnDismissListener(null);
            this.i0.dismiss();
            if (!this.k0) {
                onDismiss(this.i0);
            }
            this.i0 = null;
            this.m0 = false;
        }
    }
}
