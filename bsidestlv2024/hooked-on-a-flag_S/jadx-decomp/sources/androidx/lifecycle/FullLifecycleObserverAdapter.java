package androidx.lifecycle;

import a.m.b;
import a.m.d;
import a.m.e;
import a.m.g;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements e {

    /* renamed from: a, reason: collision with root package name */
    public final b f862a;

    /* renamed from: b, reason: collision with root package name */
    public final e f863b;

    public FullLifecycleObserverAdapter(b fullLifecycleObserver, e lifecycleEventObserver) {
        this.f862a = fullLifecycleObserver;
        this.f863b = lifecycleEventObserver;
    }

    @Override // a.m.e
    public void g(g source, d.a event) {
        switch (event.ordinal()) {
            case 0:
                this.f862a.e(source);
                break;
            case 1:
                this.f862a.f(source);
                break;
            case 2:
                this.f862a.a(source);
                break;
            case 3:
                this.f862a.b(source);
                break;
            case 4:
                this.f862a.d(source);
                break;
            case 5:
                this.f862a.c(source);
                break;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        e eVar = this.f863b;
        if (eVar != null) {
            eVar.g(source, event);
        }
    }
}
