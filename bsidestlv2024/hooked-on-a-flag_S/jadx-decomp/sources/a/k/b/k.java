package a.k.b;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public abstract class k<E> extends g {

    /* renamed from: b, reason: collision with root package name */
    public final Activity f560b;
    public final Context c;
    public final Handler d;
    public final n e;

    public abstract E m();

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<E> */
    public k(e activity) {
        this(activity, activity, new Handler(), 0);
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<E> */
    public k(Activity activity, Context context, Handler handler, int windowAnimations) {
        this.e = new o();
        this.f560b = activity;
        a.h.j.i.f(context, "context == null");
        this.c = context;
        a.h.j.i.f(handler, "handler == null");
        this.d = handler;
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<E> */
    public boolean o(Fragment fragment) {
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<E> */
    public LayoutInflater n() {
        return LayoutInflater.from(this.c);
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<E> */
    public void p() {
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<E> */
    @Override // a.k.b.g
    public View h(int id) {
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<E> */
    @Override // a.k.b.g
    public boolean i() {
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<E> */
    public Activity j() {
        return this.f560b;
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<E> */
    public Context k() {
        return this.c;
    }

    /* JADX WARN: Generic types in debug info not equals: a.k.b.k != androidx.fragment.app.FragmentHostCallback<E> */
    public Handler l() {
        return this.d;
    }
}
