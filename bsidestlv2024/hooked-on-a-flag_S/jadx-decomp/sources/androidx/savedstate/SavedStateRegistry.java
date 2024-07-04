package androidx.savedstate;

import a.m.d;
import a.m.e;
import a.m.g;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b, reason: collision with root package name */
    public Bundle f933b;
    public boolean c;
    public Recreator.a d;

    /* renamed from: a, reason: collision with root package name */
    public a.c.a.b.b<String, b> f932a = new a.c.a.b.b<>();
    public boolean e = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(a.p.b bVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        Bundle a();
    }

    public Bundle a(String key) {
        if (!this.c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f933b;
        if (bundle == null) {
            return null;
        }
        Bundle result = bundle.getBundle(key);
        this.f933b.remove(key);
        if (this.f933b.isEmpty()) {
            this.f933b = null;
        }
        return result;
    }

    public void d(String key, b provider) {
        b previous = this.f932a.g(key, provider);
        if (previous != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class<? extends a> cls) {
        if (!this.e) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.d == null) {
            this.d = new Recreator.a(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.d.b(cls.getName());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    public void b(d lifecycle, Bundle savedState) {
        if (this.c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (savedState != null) {
            this.f933b = savedState.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        lifecycle.a(new e() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // a.m.e
            public void g(g source, d.a event) {
                if (event == d.a.ON_START) {
                    SavedStateRegistry.this.e = true;
                } else if (event == d.a.ON_STOP) {
                    SavedStateRegistry.this.e = false;
                }
            }
        });
        this.c = true;
    }

    public void c(Bundle outBundle) {
        Bundle components = new Bundle();
        Bundle bundle = this.f933b;
        if (bundle != null) {
            components.putAll(bundle);
        }
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.f932a.d();
        while (it.hasNext()) {
            Map.Entry<String, SavedStateProvider> entry1 = (Map.Entry) it.next();
            components.putBundle(entry1.getKey(), ((b) entry1.getValue()).a());
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", components);
    }
}
