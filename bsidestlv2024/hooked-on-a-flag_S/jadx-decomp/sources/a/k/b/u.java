package a.k.b;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStateManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Fragment> f585a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, t> f586b = new HashMap<>();
    public q c;

    public void x(q nonConfig) {
        this.c = nonConfig;
    }

    public q o() {
        return this.c;
    }

    public void t() {
        this.f586b.clear();
    }

    public void u(List<String> added) {
        this.f585a.clear();
        if (added != null) {
            for (String who : added) {
                Fragment f = f(who);
                if (f == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + who + ")");
                }
                if (n.A0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + who + "): " + f);
                }
                a(f);
            }
        }
    }

    public void p(t newlyActive) {
        Fragment f = newlyActive.k();
        if (c(f.h)) {
            return;
        }
        this.f586b.put(f.h, newlyActive);
        if (f.E) {
            if (f.D) {
                this.c.e(f);
            } else {
                this.c.m(f);
            }
            f.E = false;
        }
        if (n.A0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + f);
        }
    }

    public void a(Fragment fragment) {
        if (this.f585a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f585a) {
            this.f585a.add(fragment);
        }
        fragment.n = true;
    }

    public void d(int state) {
        for (t fragmentStateManager : this.f586b.values()) {
            if (fragmentStateManager != null) {
                fragmentStateManager.t(state);
            }
        }
    }

    public void r() {
        Iterator<Fragment> it = this.f585a.iterator();
        while (it.hasNext()) {
            t fragmentStateManager = this.f586b.get(it.next().h);
            if (fragmentStateManager != null) {
                fragmentStateManager.m();
            }
        }
        for (t fragmentStateManager2 : this.f586b.values()) {
            if (fragmentStateManager2 != null) {
                fragmentStateManager2.m();
                Fragment f = fragmentStateManager2.k();
                boolean beingRemoved = f.o && !f.W();
                if (beingRemoved) {
                    q(fragmentStateManager2);
                }
            }
        }
    }

    public void s(Fragment fragment) {
        synchronized (this.f585a) {
            this.f585a.remove(fragment);
        }
        fragment.n = false;
    }

    public void q(t newlyInactive) {
        Fragment f = newlyInactive.k();
        if (f.D) {
            this.c.m(f);
        }
        t removedStateManager = this.f586b.put(f.h, null);
        if (removedStateManager != null && n.A0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + f);
        }
    }

    public void b() {
        this.f586b.values().removeAll(Collections.singleton(null));
    }

    public ArrayList<s> v() {
        ArrayList<s> arrayList = new ArrayList<>(this.f586b.size());
        for (t fragmentStateManager : this.f586b.values()) {
            if (fragmentStateManager != null) {
                Fragment f = fragmentStateManager.k();
                s fs = fragmentStateManager.r();
                arrayList.add(fs);
                if (n.A0(2)) {
                    Log.v("FragmentManager", "Saved state of " + f + ": " + fs.n);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> w() {
        synchronized (this.f585a) {
            if (this.f585a.isEmpty()) {
                return null;
            }
            ArrayList<String> added = new ArrayList<>(this.f585a.size());
            Iterator<Fragment> it = this.f585a.iterator();
            while (it.hasNext()) {
                Fragment f = it.next();
                added.add(f.h);
                if (n.A0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + f.h + "): " + f);
                }
            }
            return added;
        }
    }

    public List<t> k() {
        ArrayList<FragmentStateManager> activeFragmentStateManagers = new ArrayList<>();
        for (t fragmentStateManager : this.f586b.values()) {
            if (fragmentStateManager != null) {
                activeFragmentStateManagers.add(fragmentStateManager);
            }
        }
        return activeFragmentStateManagers;
    }

    public List<Fragment> n() {
        ArrayList arrayList;
        if (this.f585a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f585a) {
            arrayList = new ArrayList(this.f585a);
        }
        return arrayList;
    }

    public List<Fragment> l() {
        ArrayList<Fragment> activeFragments = new ArrayList<>();
        for (t fragmentStateManager : this.f586b.values()) {
            if (fragmentStateManager != null) {
                activeFragments.add(fragmentStateManager.k());
            } else {
                activeFragments.add(null);
            }
        }
        return activeFragments;
    }

    public Fragment g(int id) {
        for (int i = this.f585a.size() - 1; i >= 0; i--) {
            Fragment f = this.f585a.get(i);
            if (f != null && f.y == id) {
                return f;
            }
        }
        for (t fragmentStateManager : this.f586b.values()) {
            if (fragmentStateManager != null) {
                Fragment f2 = fragmentStateManager.k();
                if (f2.y == id) {
                    return f2;
                }
            }
        }
        return null;
    }

    public Fragment h(String tag) {
        if (tag != null) {
            for (int i = this.f585a.size() - 1; i >= 0; i--) {
                Fragment f = this.f585a.get(i);
                if (f != null && tag.equals(f.A)) {
                    return f;
                }
            }
        }
        if (tag != null) {
            for (t fragmentStateManager : this.f586b.values()) {
                if (fragmentStateManager != null) {
                    Fragment f2 = fragmentStateManager.k();
                    if (tag.equals(f2.A)) {
                        return f2;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public boolean c(String who) {
        return this.f586b.get(who) != null;
    }

    public t m(String who) {
        return this.f586b.get(who);
    }

    public Fragment i(String who) {
        Fragment f;
        for (t fragmentStateManager : this.f586b.values()) {
            if (fragmentStateManager != null && (f = fragmentStateManager.k().i(who)) != null) {
                return f;
            }
        }
        return null;
    }

    public Fragment f(String who) {
        t fragmentStateManager = this.f586b.get(who);
        if (fragmentStateManager != null) {
            return fragmentStateManager.k();
        }
        return null;
    }

    public int j(Fragment f) {
        View view;
        View view2;
        ViewGroup container = f.H;
        if (container == null) {
            return -1;
        }
        int fragmentIndex = this.f585a.indexOf(f);
        for (int i = fragmentIndex - 1; i >= 0; i--) {
            Fragment underFragment = this.f585a.get(i);
            if (underFragment.H == container && (view2 = underFragment.I) != null) {
                int underIndex = container.indexOfChild(view2);
                return underIndex + 1;
            }
        }
        for (int i2 = fragmentIndex + 1; i2 < this.f585a.size(); i2++) {
            Fragment overFragment = this.f585a.get(i2);
            if (overFragment.H == container && (view = overFragment.I) != null) {
                return container.indexOfChild(view);
            }
        }
        return -1;
    }

    public void e(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        String innerPrefix = prefix + "    ";
        if (!this.f586b.isEmpty()) {
            writer.print(prefix);
            writer.println("Active Fragments:");
            for (t fragmentStateManager : this.f586b.values()) {
                writer.print(prefix);
                if (fragmentStateManager != null) {
                    Fragment f = fragmentStateManager.k();
                    writer.println(f);
                    f.g(innerPrefix, fd, writer, args);
                } else {
                    writer.println("null");
                }
            }
        }
        int count = this.f585a.size();
        if (count > 0) {
            writer.print(prefix);
            writer.println("Added Fragments:");
            for (int i = 0; i < count; i++) {
                Fragment f2 = this.f585a.get(i);
                writer.print(prefix);
                writer.print("  #");
                writer.print(i);
                writer.print(": ");
                writer.println(f2.toString());
            }
        }
    }
}
