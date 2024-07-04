package a.s;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
public class t implements u {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f738a;

    public t(ViewGroup group) {
        this.f738a = group.getOverlay();
    }

    @Override // a.s.u
    public void b(View view) {
        this.f738a.add(view);
    }

    @Override // a.s.u
    public void a(View view) {
        this.f738a.remove(view);
    }
}
