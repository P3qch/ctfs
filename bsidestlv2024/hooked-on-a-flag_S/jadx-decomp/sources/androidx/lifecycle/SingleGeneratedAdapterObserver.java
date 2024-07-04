package androidx.lifecycle;

import a.m.c;
import a.m.d;
import a.m.e;
import a.m.g;

/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements e {

    /* renamed from: a, reason: collision with root package name */
    public final c f874a;

    public SingleGeneratedAdapterObserver(c generatedAdapter) {
        this.f874a = generatedAdapter;
    }

    @Override // a.m.e
    public void g(g source, d.a event) {
        this.f874a.a(source, event, false, null);
        this.f874a.a(source, event, true, null);
    }
}
