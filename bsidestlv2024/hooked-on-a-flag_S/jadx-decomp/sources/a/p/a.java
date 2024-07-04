package a.p;

import a.m.d;
import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f690a;

    /* renamed from: b, reason: collision with root package name */
    public final SavedStateRegistry f691b = new SavedStateRegistry();

    public a(b owner) {
        this.f690a = owner;
    }

    public SavedStateRegistry b() {
        return this.f691b;
    }

    public void c(Bundle savedState) {
        d lifecycle = this.f690a.a();
        if (lifecycle.b() != d.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.f690a));
        this.f691b.b(lifecycle, savedState);
    }

    public void d(Bundle outBundle) {
        this.f691b.c(outBundle);
    }

    public static a a(b owner) {
        return new a(owner);
    }
}
