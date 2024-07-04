package a.h.k;

import android.view.View;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public int f472a;

    /* renamed from: b, reason: collision with root package name */
    public int f473b;

    public void c(View child, View target, int axes) {
        b(axes, 0);
    }

    public void b(int axes, int type) {
        if (type == 1) {
            this.f473b = axes;
        } else {
            this.f472a = axes;
        }
    }

    public int a() {
        return this.f472a | this.f473b;
    }

    public void d(int type) {
        if (type == 1) {
            this.f473b = 0;
        } else {
            this.f472a = 0;
        }
    }
}
