package a.b.f;

import a.h.k.a0;
import a.h.k.b0;
import a.h.k.z;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {
    public Interpolator c;
    public a0 d;
    public boolean e;

    /* renamed from: b, reason: collision with root package name */
    public long f89b = -1;
    public final b0 f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<z> f88a = new ArrayList<>();

    public h c(z animator) {
        if (!this.e) {
            this.f88a.add(animator);
        }
        return this;
    }

    public h d(z anim1, z anim2) {
        this.f88a.add(anim1);
        anim2.h(anim1.c());
        this.f88a.add(anim2);
        return this;
    }

    public void h() {
        if (this.e) {
            return;
        }
        Iterator<z> it = this.f88a.iterator();
        while (it.hasNext()) {
            z animator = it.next();
            long j = this.f89b;
            if (j >= 0) {
                animator.d(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                animator.e(interpolator);
            }
            if (this.d != null) {
                animator.f(this.f);
            }
            animator.j();
        }
        this.e = true;
    }

    public void b() {
        this.e = false;
    }

    public void a() {
        if (!this.e) {
            return;
        }
        Iterator<z> it = this.f88a.iterator();
        while (it.hasNext()) {
            z animator = it.next();
            animator.b();
        }
        this.e = false;
    }

    public h e(long duration) {
        if (!this.e) {
            this.f89b = duration;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public h g(a0 listener) {
        if (!this.e) {
            this.d = listener;
        }
        return this;
    }

    /* loaded from: classes.dex */
    public class a extends b0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f90a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f91b = 0;

        public a() {
        }

        @Override // a.h.k.b0, a.h.k.a0
        public void b(View view) {
            if (this.f90a) {
                return;
            }
            this.f90a = true;
            a0 a0Var = h.this.d;
            if (a0Var != null) {
                a0Var.b(null);
            }
        }

        public void d() {
            this.f91b = 0;
            this.f90a = false;
            h.this.b();
        }

        @Override // a.h.k.a0
        public void a(View view) {
            int i = this.f91b + 1;
            this.f91b = i;
            if (i == h.this.f88a.size()) {
                a0 a0Var = h.this.d;
                if (a0Var != null) {
                    a0Var.a(null);
                }
                d();
            }
        }
    }
}
