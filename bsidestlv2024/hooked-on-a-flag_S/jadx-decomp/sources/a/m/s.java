package a.m;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, q> f631a = new HashMap<>();

    public final void d(String key, q viewModel) {
        q oldViewModel = this.f631a.put(key, viewModel);
        if (oldViewModel != null) {
            oldViewModel.d();
        }
    }

    public final q b(String key) {
        return this.f631a.get(key);
    }

    public Set<String> c() {
        return new HashSet(this.f631a.keySet());
    }

    public final void a() {
        for (q vm : this.f631a.values()) {
            vm.a();
        }
        this.f631a.clear();
    }
}
