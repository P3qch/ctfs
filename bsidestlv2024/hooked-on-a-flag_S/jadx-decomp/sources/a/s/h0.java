package a.s;

import android.os.IBinder;

/* loaded from: classes.dex */
public class h0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f717a;

    public h0(IBinder token) {
        this.f717a = token;
    }

    public boolean equals(Object o) {
        return (o instanceof h0) && ((h0) o).f717a.equals(this.f717a);
    }

    public int hashCode() {
        return this.f717a.hashCode();
    }
}
