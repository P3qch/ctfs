package a.k.b;

import a.m.r;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class q extends a.m.q {

    /* renamed from: b, reason: collision with root package name */
    public static final r.a f580b = new a();
    public final boolean f;
    public final HashMap<String, Fragment> c = new HashMap<>();
    public final HashMap<String, q> d = new HashMap<>();
    public final HashMap<String, a.m.s> e = new HashMap<>();
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;

    /* loaded from: classes.dex */
    public class a implements r.a {
        @Override // a.m.r.a
        public <T extends a.m.q> T a(Class<T> modelClass) {
            q viewModel = new q(true);
            return viewModel;
        }
    }

    public static q i(a.m.s viewModelStore) {
        a.m.r viewModelProvider = new a.m.r(viewModelStore, f580b);
        return (q) viewModelProvider.a(q.class);
    }

    public q(boolean stateAutomaticallySaved) {
        this.f = stateAutomaticallySaved;
    }

    public void n(boolean isStateSaved) {
        this.i = isStateSaved;
    }

    @Override // a.m.q
    public void d() {
        if (n.A0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.g = true;
    }

    public boolean l() {
        return this.g;
    }

    public void e(Fragment fragment) {
        if (this.i) {
            if (n.A0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.c.containsKey(fragment.h)) {
                return;
            }
            this.c.put(fragment.h, fragment);
            if (n.A0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public Fragment g(String who) {
        return this.c.get(who);
    }

    public Collection<Fragment> j() {
        return new ArrayList(this.c.values());
    }

    public boolean o(Fragment fragment) {
        if (this.c.containsKey(fragment.h) && this.f) {
            return this.g;
        }
        return true;
    }

    public void m(Fragment fragment) {
        if (this.i) {
            if (n.A0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        boolean removed = this.c.remove(fragment.h) != null;
        if (removed && n.A0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public q h(Fragment f) {
        q childNonConfig = this.d.get(f.h);
        if (childNonConfig == null) {
            q childNonConfig2 = new q(this.f);
            this.d.put(f.h, childNonConfig2);
            return childNonConfig2;
        }
        return childNonConfig;
    }

    public a.m.s k(Fragment f) {
        a.m.s viewModelStore = this.e.get(f.h);
        if (viewModelStore == null) {
            a.m.s viewModelStore2 = new a.m.s();
            this.e.put(f.h, viewModelStore2);
            return viewModelStore2;
        }
        return viewModelStore;
    }

    public void f(Fragment f) {
        if (n.A0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + f);
        }
        q childNonConfig = this.d.get(f.h);
        if (childNonConfig != null) {
            childNonConfig.d();
            this.d.remove(f.h);
        }
        a.m.s viewModelStore = this.e.get(f.h);
        if (viewModelStore != null) {
            viewModelStore.a();
            this.e.remove(f.h);
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        q that = (q) o;
        return this.c.equals(that.c) && this.d.equals(that.d) && this.e.equals(that.e);
    }

    public int hashCode() {
        int result = this.c.hashCode();
        return (((result * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> fragmentIterator = this.c.values().iterator();
        while (fragmentIterator.hasNext()) {
            sb.append(fragmentIterator.next());
            if (fragmentIterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> childNonConfigIterator = this.d.keySet().iterator();
        while (childNonConfigIterator.hasNext()) {
            sb.append(childNonConfigIterator.next());
            if (childNonConfigIterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> viewModelStoreIterator = this.e.keySet().iterator();
        while (viewModelStoreIterator.hasNext()) {
            sb.append(viewModelStoreIterator.next());
            if (viewModelStoreIterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
