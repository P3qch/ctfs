package a.b.f.j;

import a.b.f.j.m;
import a.b.f.j.n;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements m {

    /* renamed from: b, reason: collision with root package name */
    public Context f95b;
    public Context c;
    public g d;
    public LayoutInflater e;
    public m.a f;
    public int g;
    public int h;
    public n i;

    public abstract void e(i iVar, n.a aVar);

    public abstract boolean q(int i, i iVar);

    public b(Context context, int menuLayoutRes, int itemLayoutRes) {
        this.f95b = context;
        this.e = LayoutInflater.from(context);
        this.g = menuLayoutRes;
        this.h = itemLayoutRes;
    }

    @Override // a.b.f.j.m
    public void j(Context context, g menu) {
        this.c = context;
        LayoutInflater.from(context);
        this.d = menu;
    }

    public n o(ViewGroup root) {
        if (this.i == null) {
            n nVar = (n) this.e.inflate(this.g, root, false);
            this.i = nVar;
            nVar.d(this.d);
            h(true);
        }
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.b.f.j.m
    public void h(boolean cleared) {
        ViewGroup parent = (ViewGroup) this.i;
        if (parent == null) {
            return;
        }
        int childIndex = 0;
        g gVar = this.d;
        if (gVar != null) {
            gVar.r();
            ArrayList<i> E = this.d.E();
            int itemCount = E.size();
            for (int i = 0; i < itemCount; i++) {
                i item = E.get(i);
                if (q(childIndex, item)) {
                    View childAt = parent.getChildAt(childIndex);
                    i oldItem = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View itemView = n(item, childAt, parent);
                    if (item != oldItem) {
                        itemView.setPressed(false);
                        itemView.jumpDrawablesToCurrentState();
                    }
                    if (itemView != childAt) {
                        a(itemView, childIndex);
                    }
                    childIndex++;
                }
            }
        }
        while (childIndex < parent.getChildCount()) {
            if (!l(parent, childIndex)) {
                childIndex++;
            }
        }
    }

    public void a(View itemView, int childIndex) {
        ViewGroup currentParent = (ViewGroup) itemView.getParent();
        if (currentParent != null) {
            currentParent.removeView(itemView);
        }
        ((ViewGroup) this.i).addView(itemView, childIndex);
    }

    public boolean l(ViewGroup parent, int childIndex) {
        parent.removeViewAt(childIndex);
        return true;
    }

    @Override // a.b.f.j.m
    public void d(m.a cb) {
        this.f = cb;
    }

    public m.a m() {
        return this.f;
    }

    public n.a i(ViewGroup parent) {
        return (n.a) this.e.inflate(this.h, parent, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(i item, View view, ViewGroup parent) {
        n.a itemView;
        if (view instanceof n.a) {
            itemView = (n.a) view;
        } else {
            itemView = i(parent);
        }
        e(item, itemView);
        return (View) itemView;
    }

    @Override // a.b.f.j.m
    public void b(g menu, boolean allMenusAreClosing) {
        m.a aVar = this.f;
        if (aVar != null) {
            aVar.b(menu, allMenusAreClosing);
        }
    }

    @Override // a.b.f.j.m
    public boolean f(r menu) {
        m.a aVar = this.f;
        if (aVar != null) {
            return aVar.c(menu != null ? menu : this.d);
        }
        return false;
    }

    @Override // a.b.f.j.m
    public boolean c(g menu, i item) {
        return false;
    }

    @Override // a.b.f.j.m
    public boolean k(g menu, i item) {
        return false;
    }

    public void p(int id) {
    }
}
