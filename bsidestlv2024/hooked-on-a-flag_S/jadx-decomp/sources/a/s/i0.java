package a.s;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
public class i0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    public final WindowId f718a;

    public i0(View view) {
        this.f718a = view.getWindowId();
    }

    public boolean equals(Object o) {
        return (o instanceof i0) && ((i0) o).f718a.equals(this.f718a);
    }

    public int hashCode() {
        return this.f718a.hashCode();
    }
}
