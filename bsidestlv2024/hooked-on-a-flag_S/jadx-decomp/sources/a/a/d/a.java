package a.a.d;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Set<b> f2a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public volatile Context f3b;

    public void a(b listener) {
        if (this.f3b != null) {
            listener.a(this.f3b);
        }
        this.f2a.add(listener);
    }

    public void c(Context context) {
        this.f3b = context;
        for (b listener : this.f2a) {
            listener.a(context);
        }
    }

    public void b() {
        this.f3b = null;
    }
}
