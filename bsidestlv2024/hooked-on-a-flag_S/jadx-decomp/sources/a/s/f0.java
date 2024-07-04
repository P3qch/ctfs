package a.s;

import android.view.View;
import android.view.ViewGroup;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class f0 extends l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f709a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f710b;
    public final /* synthetic */ View c;
    public final /* synthetic */ g0 d;

    public f0(g0 this$0, ViewGroup viewGroup, View view, View view2) {
        this.d = this$0;
        this.f709a = viewGroup;
        this.f710b = view;
        this.c = view2;
    }

    @Override // a.s.l, a.s.k.f
    public void d(k transition) {
        v.a(this.f709a).a(this.f710b);
    }

    @Override // a.s.l, a.s.k.f
    public void e(k transition) {
        if (this.f710b.getParent() == null) {
            v.a(this.f709a).b(this.f710b);
        } else {
            this.d.f();
        }
    }

    @Override // a.s.k.f
    public void c(k transition) {
        this.c.setTag(R.id.save_overlay_view, null);
        v.a(this.f709a).a(this.f710b);
        transition.P(this);
    }
}
