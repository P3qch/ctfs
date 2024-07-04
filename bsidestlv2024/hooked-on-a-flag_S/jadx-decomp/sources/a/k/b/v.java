package a.k.b;

import a.m.d;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: b, reason: collision with root package name */
    public int f588b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public String h;
    public int i;
    public CharSequence j;
    public int k;
    public CharSequence l;
    public ArrayList<String> m;
    public ArrayList<String> n;
    public ArrayList<Runnable> p;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<a> f587a = new ArrayList<>();
    public boolean o = false;

    public abstract int e();

    public abstract int f();

    public abstract void g();

    public abstract void h();

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f589a;

        /* renamed from: b, reason: collision with root package name */
        public Fragment f590b;
        public int c;
        public int d;
        public int e;
        public int f;
        public d.b g;
        public d.b h;

        public a() {
        }

        public a(int cmd, Fragment fragment) {
            this.f589a = cmd;
            this.f590b = fragment;
            d.b bVar = d.b.RESUMED;
            this.g = bVar;
            this.h = bVar;
        }
    }

    public v(j fragmentFactory, ClassLoader classLoader) {
    }

    public void d(a op) {
        this.f587a.add(op);
        op.c = this.f588b;
        op.d = this.c;
        op.e = this.d;
        op.f = this.e;
    }

    public v b(int containerViewId, Fragment fragment, String tag) {
        j(containerViewId, fragment, tag, 1);
        return this;
    }

    public v c(ViewGroup container, Fragment fragment, String tag) {
        fragment.H = container;
        b(container.getId(), fragment, tag);
        return this;
    }

    public void j(int containerViewId, Fragment fragment, String tag, int opcmd) {
        Class<?> fragmentClass = fragment.getClass();
        int modifiers = fragmentClass.getModifiers();
        if (fragmentClass.isAnonymousClass() || !Modifier.isPublic(modifiers) || (fragmentClass.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + fragmentClass.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (tag != null) {
            String str = fragment.A;
            if (str != null && !tag.equals(str)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.A + " now " + tag);
            }
            fragment.A = tag;
        }
        if (containerViewId != 0) {
            if (containerViewId == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + tag + " to container view with no id");
            }
            int i = fragment.y;
            if (i != 0 && i != containerViewId) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.y + " now " + containerViewId);
            }
            fragment.y = containerViewId;
            fragment.z = containerViewId;
        }
        d(new a(opcmd, fragment));
    }

    public v l(int containerViewId, Fragment fragment) {
        m(containerViewId, fragment, null);
        return this;
    }

    public v m(int containerViewId, Fragment fragment, String tag) {
        if (containerViewId == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        j(containerViewId, fragment, tag, 2);
        return this;
    }

    public v k(Fragment fragment) {
        d(new a(3, fragment));
        return this;
    }

    public v i() {
        if (this.g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        return this;
    }

    public v n(boolean reorderingAllowed) {
        this.o = reorderingAllowed;
        return this;
    }
}
