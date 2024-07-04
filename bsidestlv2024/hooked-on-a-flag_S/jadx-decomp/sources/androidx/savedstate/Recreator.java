package androidx.savedstate;

import a.m.d;
import a.m.e;
import a.m.g;
import a.p.b;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class Recreator implements e {

    /* renamed from: a, reason: collision with root package name */
    public final b f930a;

    public Recreator(b owner) {
        this.f930a = owner;
    }

    @Override // a.m.e
    public void g(g source, d.a event) {
        if (event != d.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.a().c(this);
        Bundle bundle = this.f930a.d().a("androidx.savedstate.Restarter");
        if (bundle == null) {
            return;
        }
        ArrayList<String> classes = bundle.getStringArrayList("classes_to_restore");
        if (classes == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = classes.iterator();
        while (it.hasNext()) {
            String className = it.next();
            h(className);
        }
    }

    public final void h(String className) {
        try {
            Class<? extends U> asSubclass = Class.forName(className, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.a.class);
            try {
                Constructor<? extends SavedStateRegistry.AutoRecreated> constructor = asSubclass.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
                try {
                    SavedStateRegistry.a newInstance = (SavedStateRegistry.a) constructor.newInstance(new Object[0]);
                    newInstance.a(this.f930a);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + className, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + className + " wasn't found", e3);
        }
    }

    /* loaded from: classes.dex */
    public static final class a implements SavedStateRegistry.b {

        /* renamed from: a, reason: collision with root package name */
        public final Set<String> f931a = new HashSet();

        public a(SavedStateRegistry registry) {
            registry.d("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f931a));
            return bundle;
        }

        public void b(String className) {
            this.f931a.add(className);
        }
    }
}
