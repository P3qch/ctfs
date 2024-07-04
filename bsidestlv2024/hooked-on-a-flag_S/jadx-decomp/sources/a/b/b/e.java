package a.b.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: b, reason: collision with root package name */
    public static int f18b = -100;
    public static final a.e.b<WeakReference<e>> c = new a.e.b<>();
    public static final Object d = new Object();

    public abstract void A(int i);

    public abstract void B(View view);

    public abstract void C(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void E(CharSequence charSequence);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    public abstract <T extends View> T i(int i);

    public abstract MenuInflater l();

    public abstract a m();

    public abstract void n();

    public abstract void o();

    public abstract void p(Configuration configuration);

    public abstract void q(Bundle bundle);

    public abstract void r();

    public abstract void s(Bundle bundle);

    public abstract void t();

    public abstract void u(Bundle bundle);

    public abstract void v();

    public abstract void w();

    public abstract boolean z(int i);

    public static e g(Activity activity, d callback) {
        return new f(activity, callback);
    }

    public static e h(Dialog dialog, d callback) {
        return new f(dialog, callback);
    }

    public void D(int themeResId) {
    }

    @Deprecated
    public void e() {
    }

    public Context f(Context context) {
        e();
        return context;
    }

    public int k() {
        return -100;
    }

    public static int j() {
        return -100;
    }

    public static void c(e delegate) {
        synchronized (d) {
            y(delegate);
            c.add(new WeakReference<>(delegate));
        }
    }

    public static void x(e delegate) {
        synchronized (d) {
            y(delegate);
        }
    }

    public static void y(e toRemove) {
        synchronized (d) {
            Iterator<WeakReference<e>> it = c.iterator();
            while (it.hasNext()) {
                e delegate = it.next().get();
                if (delegate == toRemove || delegate == null) {
                    it.remove();
                }
            }
        }
    }
}
