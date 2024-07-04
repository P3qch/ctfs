package a.b.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class w0 extends o0 {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f200b;

    public w0(Context context, Resources res) {
        super(res);
        this.f200b = new WeakReference<>(context);
    }

    @Override // a.b.g.o0, android.content.res.Resources
    public Drawable getDrawable(int id) {
        Drawable d = super.getDrawable(id);
        Context context = this.f200b.get();
        if (d != null && context != null) {
            n0.h().w(context, id, d);
        }
        return d;
    }
}
