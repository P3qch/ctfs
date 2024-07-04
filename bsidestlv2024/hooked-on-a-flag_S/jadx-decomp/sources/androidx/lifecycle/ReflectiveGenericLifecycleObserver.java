package androidx.lifecycle;

import a.m.a;
import a.m.d;
import a.m.e;
import a.m.g;

/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f869a;

    /* renamed from: b, reason: collision with root package name */
    public final a.C0044a f870b;

    public ReflectiveGenericLifecycleObserver(Object wrapped) {
        this.f869a = wrapped;
        this.f870b = a.f614a.c(wrapped.getClass());
    }

    @Override // a.m.e
    public void g(g source, d.a event) {
        this.f870b.a(source, event, this.f869a);
    }
}
