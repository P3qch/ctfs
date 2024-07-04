package a.b.g;

import android.R;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public class y0 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final a.b.f.j.a f213b;
    public final /* synthetic */ z0 c;

    public y0(z0 this$0) {
        this.c = this$0;
        this.f213b = new a.b.f.j.a(this$0.f219a.getContext(), 0, R.id.home, 0, this$0.i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        z0 z0Var = this.c;
        Window.Callback callback = z0Var.l;
        if (callback != null && z0Var.m) {
            callback.onMenuItemSelected(0, this.f213b);
        }
    }
}
