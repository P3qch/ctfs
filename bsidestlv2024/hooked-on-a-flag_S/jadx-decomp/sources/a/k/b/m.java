package a.k.b;

import a.k.b.n;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f563a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final n f564b;

    /* loaded from: classes.dex */
    public static final class a {
    }

    public m(n fragmentManager) {
        this.f564b = fragmentManager;
    }

    public void g(Fragment f, boolean onlyRecursive) {
        Context k = this.f564b.o0().k();
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().g(f, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.g(this.f564b, f, k);
                throw null;
            }
            holder.getClass();
        }
    }

    public void b(Fragment f, boolean onlyRecursive) {
        Context k = this.f564b.o0().k();
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().b(f, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.b(this.f564b, f, k);
                throw null;
            }
            holder.getClass();
        }
    }

    public void h(Fragment f, Bundle savedInstanceState, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().h(f, savedInstanceState, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.h(this.f564b, f, savedInstanceState);
                throw null;
            }
            holder.getClass();
        }
    }

    public void c(Fragment f, Bundle savedInstanceState, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().c(f, savedInstanceState, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.c(this.f564b, f, savedInstanceState);
                throw null;
            }
            holder.getClass();
        }
    }

    public void a(Fragment f, Bundle savedInstanceState, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().a(f, savedInstanceState, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.a(this.f564b, f, savedInstanceState);
                throw null;
            }
            holder.getClass();
        }
    }

    public void m(Fragment f, View v, Bundle savedInstanceState, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().m(f, v, savedInstanceState, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.m(this.f564b, f, v, savedInstanceState);
                throw null;
            }
            holder.getClass();
        }
    }

    public void k(Fragment f, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().k(f, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.k(this.f564b, f);
                throw null;
            }
            holder.getClass();
        }
    }

    public void i(Fragment f, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().i(f, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.i(this.f564b, f);
                throw null;
            }
            holder.getClass();
        }
    }

    public void f(Fragment f, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().f(f, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.f(this.f564b, f);
                throw null;
            }
            holder.getClass();
        }
    }

    public void l(Fragment f, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().l(f, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.l(this.f564b, f);
                throw null;
            }
            holder.getClass();
        }
    }

    public void j(Fragment f, Bundle outState, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().j(f, outState, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.j(this.f564b, f, outState);
                throw null;
            }
            holder.getClass();
        }
    }

    public void n(Fragment f, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().n(f, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.n(this.f564b, f);
                throw null;
            }
            holder.getClass();
        }
    }

    public void d(Fragment f, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().d(f, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.d(this.f564b, f);
                throw null;
            }
            holder.getClass();
        }
    }

    public void e(Fragment f, boolean onlyRecursive) {
        Fragment parent = this.f564b.r0();
        if (parent != null) {
            n parentManager = parent.D();
            parentManager.q0().e(f, true);
        }
        Iterator<a> it = this.f563a.iterator();
        while (it.hasNext()) {
            a holder = it.next();
            if (!onlyRecursive) {
                holder.getClass();
                n.k kVar = null;
                kVar.e(this.f564b, f);
                throw null;
            }
            holder.getClass();
        }
    }
}
