package androidx.lifecycle;

import a.m.d;
import a.m.e;
import a.m.g;
import a.m.p;
import a.m.q;
import a.m.s;
import a.m.t;
import a.p.b;
import androidx.savedstate.SavedStateRegistry;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class SavedStateHandleController implements e {

    /* renamed from: a, reason: collision with root package name */
    public boolean f871a;

    public boolean j() {
        return this.f871a;
    }

    public void i(SavedStateRegistry registry, d lifecycle) {
        if (this.f871a) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f871a = true;
        lifecycle.a(this);
        p pVar = null;
        pVar.a();
        throw null;
    }

    @Override // a.m.e
    public void g(g source, d.a event) {
        if (event == d.a.ON_DESTROY) {
            this.f871a = false;
            source.a().c(this);
        }
    }

    /* loaded from: classes.dex */
    public static final class a implements SavedStateRegistry.a {
        @Override // androidx.savedstate.SavedStateRegistry.a
        public void a(b owner) {
            if (!(owner instanceof t)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
            s viewModelStore = ((t) owner).e();
            SavedStateRegistry savedStateRegistry = owner.d();
            Iterator it = ((HashSet) viewModelStore.c()).iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                q viewModel = viewModelStore.b(key);
                SavedStateHandleController.h(viewModel, savedStateRegistry, owner.a());
            }
            if (!((HashSet) viewModelStore.c()).isEmpty()) {
                savedStateRegistry.e(a.class);
            }
        }
    }

    public static void h(q viewModel, SavedStateRegistry registry, d lifecycle) {
        SavedStateHandleController controller = (SavedStateHandleController) viewModel.c("androidx.lifecycle.savedstate.vm.tag");
        if (controller != null && !controller.j()) {
            controller.i(registry, lifecycle);
            throw null;
        }
    }

    /* renamed from: androidx.lifecycle.SavedStateHandleController$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f872a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SavedStateRegistry f873b;

        @Override // a.m.e
        public void g(g source, d.a event) {
            if (event == d.a.ON_START) {
                this.f872a.c(this);
                this.f873b.e(a.class);
            }
        }
    }
}
