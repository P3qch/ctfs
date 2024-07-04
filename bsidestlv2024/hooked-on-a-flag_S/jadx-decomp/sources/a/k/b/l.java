package a.k.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public class l implements LayoutInflater.Factory2 {

    /* renamed from: b, reason: collision with root package name */
    public final n f561b;

    public l(n fragmentManager) {
        this.f561b = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return onCreateView(null, name, context, attrs);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        t fragmentStateManager;
        if (h.class.getName().equals(name)) {
            return new h(context, attrs, this.f561b);
        }
        if (!"fragment".equals(name)) {
            return null;
        }
        String fname = attrs.getAttributeValue(null, "class");
        TypedArray a2 = context.obtainStyledAttributes(attrs, a.k.a.f512a);
        if (fname == null) {
            int[] iArr = a.k.a.f512a;
            fname = a2.getString(0);
        }
        int[] iArr2 = a.k.a.f512a;
        int id = a2.getResourceId(1, -1);
        String tag = a2.getString(2);
        a2.recycle();
        if (fname == null || !j.b(context.getClassLoader(), fname)) {
            return null;
        }
        int containerId = parent != null ? parent.getId() : 0;
        if (containerId != -1 || id != -1 || tag != null) {
            Fragment fragment = id != -1 ? this.f561b.c0(id) : null;
            if (fragment == null && tag != null) {
                fragment = this.f561b.d0(tag);
            }
            if (fragment == null && containerId != -1) {
                fragment = this.f561b.c0(containerId);
            }
            if (fragment == null) {
                fragment = this.f561b.l0().a(context.getClassLoader(), fname);
                fragment.p = true;
                fragment.y = id != 0 ? id : containerId;
                fragment.z = containerId;
                fragment.A = tag;
                fragment.q = true;
                n nVar = this.f561b;
                fragment.u = nVar;
                fragment.v = nVar.o0();
                this.f561b.o0().k();
                fragment.u0(attrs, fragment.d);
                fragmentStateManager = this.f561b.e(fragment);
                if (n.A0(2)) {
                    Log.v("FragmentManager", "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(id));
                }
            } else {
                if (fragment.q) {
                    throw new IllegalArgumentException(attrs.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(id) + ", tag " + tag + ", or parent id 0x" + Integer.toHexString(containerId) + " with another fragment for " + fname);
                }
                fragment.q = true;
                n nVar2 = this.f561b;
                fragment.u = nVar2;
                fragment.v = nVar2.o0();
                this.f561b.o0().k();
                fragment.u0(attrs, fragment.d);
                fragmentStateManager = this.f561b.r(fragment);
                if (n.A0(2)) {
                    Log.v("FragmentManager", "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(id));
                }
            }
            fragment.H = (ViewGroup) parent;
            fragmentStateManager.m();
            fragmentStateManager.j();
            View view = fragment.I;
            if (view == null) {
                throw new IllegalStateException("Fragment " + fname + " did not create a view.");
            }
            if (id != 0) {
                view.setId(id);
            }
            if (fragment.I.getTag() == null) {
                fragment.I.setTag(tag);
            }
            fragment.I.addOnAttachStateChangeListener(new a(fragmentStateManager));
            return fragment.I;
        }
        throw new IllegalArgumentException(attrs.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + fname);
    }

    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f562b;

        public a(t tVar) {
            this.f562b = tVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Fragment fragment = this.f562b.k();
            this.f562b.m();
            b0 controller = b0.n((ViewGroup) fragment.I.getParent(), l.this.f561b);
            controller.j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
        }
    }
}
