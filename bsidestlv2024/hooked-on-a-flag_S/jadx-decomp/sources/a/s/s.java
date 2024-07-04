package a.s;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class s extends x implements u {
    public s(Context context, ViewGroup hostView, View requestingView) {
        super(context, hostView, requestingView);
    }

    public static s e(ViewGroup viewGroup) {
        return (s) x.c(viewGroup);
    }

    @Override // a.s.u
    public void b(View view) {
        this.f742a.a(view);
    }

    @Override // a.s.u
    public void a(View view) {
        this.f742a.e(view);
    }
}
