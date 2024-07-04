package a.o.b;

import a.h.k.v;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class k extends a.h.k.a {
    public final RecyclerView d;
    public final a e;

    public k(RecyclerView recyclerView) {
        this.d = recyclerView;
        a.h.k.a itemDelegate = n();
        if (itemDelegate != null && (itemDelegate instanceof a)) {
            this.e = (a) itemDelegate;
        } else {
            this.e = new a(this);
        }
    }

    public boolean o() {
        return this.d.l0();
    }

    @Override // a.h.k.a
    public boolean j(View host, int action, Bundle args) {
        if (super.j(host, action, args)) {
            return true;
        }
        if (!o() && this.d.getLayoutManager() != null) {
            return this.d.getLayoutManager().h1(action, args);
        }
        return false;
    }

    @Override // a.h.k.a
    public void g(View host, a.h.k.e0.c info) {
        super.g(host, info);
        if (!o() && this.d.getLayoutManager() != null) {
            this.d.getLayoutManager().M0(info);
        }
    }

    @Override // a.h.k.a
    public void f(View host, AccessibilityEvent event) {
        super.f(host, event);
        if ((host instanceof RecyclerView) && !o()) {
            RecyclerView rv = (RecyclerView) host;
            if (rv.getLayoutManager() != null) {
                rv.getLayoutManager().K0(event);
            }
        }
    }

    public a.h.k.a n() {
        return this.e;
    }

    /* loaded from: classes.dex */
    public static class a extends a.h.k.a {
        public final k d;
        public Map<View, a.h.k.a> e = new WeakHashMap();

        public a(k recyclerViewDelegate) {
            this.d = recyclerViewDelegate;
        }

        public void o(View itemView) {
            a.h.k.a delegate = v.l(itemView);
            if (delegate != null && delegate != this) {
                this.e.put(itemView, delegate);
            }
        }

        public a.h.k.a n(View itemView) {
            return this.e.remove(itemView);
        }

        @Override // a.h.k.a
        public void g(View host, a.h.k.e0.c info) {
            if (!this.d.o() && this.d.d.getLayoutManager() != null) {
                this.d.d.getLayoutManager().O0(host, info);
                a.h.k.a originalDelegate = this.e.get(host);
                if (originalDelegate != null) {
                    originalDelegate.g(host, info);
                    return;
                } else {
                    super.g(host, info);
                    return;
                }
            }
            super.g(host, info);
        }

        @Override // a.h.k.a
        public boolean j(View host, int action, Bundle args) {
            if (!this.d.o() && this.d.d.getLayoutManager() != null) {
                a.h.k.a originalDelegate = this.e.get(host);
                if (originalDelegate != null) {
                    if (originalDelegate.j(host, action, args)) {
                        return true;
                    }
                } else if (super.j(host, action, args)) {
                    return true;
                }
                return this.d.d.getLayoutManager().j1(host, action, args);
            }
            return super.j(host, action, args);
        }

        @Override // a.h.k.a
        public void l(View host, int eventType) {
            a.h.k.a originalDelegate = this.e.get(host);
            if (originalDelegate != null) {
                originalDelegate.l(host, eventType);
            } else {
                super.l(host, eventType);
            }
        }

        @Override // a.h.k.a
        public void m(View host, AccessibilityEvent event) {
            a.h.k.a originalDelegate = this.e.get(host);
            if (originalDelegate != null) {
                originalDelegate.m(host, event);
            } else {
                super.m(host, event);
            }
        }

        @Override // a.h.k.a
        public boolean a(View host, AccessibilityEvent event) {
            a.h.k.a originalDelegate = this.e.get(host);
            if (originalDelegate != null) {
                return originalDelegate.a(host, event);
            }
            return super.a(host, event);
        }

        @Override // a.h.k.a
        public void h(View host, AccessibilityEvent event) {
            a.h.k.a originalDelegate = this.e.get(host);
            if (originalDelegate != null) {
                originalDelegate.h(host, event);
            } else {
                super.h(host, event);
            }
        }

        @Override // a.h.k.a
        public void f(View host, AccessibilityEvent event) {
            a.h.k.a originalDelegate = this.e.get(host);
            if (originalDelegate != null) {
                originalDelegate.f(host, event);
            } else {
                super.f(host, event);
            }
        }

        @Override // a.h.k.a
        public boolean i(ViewGroup host, View child, AccessibilityEvent event) {
            a.h.k.a originalDelegate = this.e.get(host);
            if (originalDelegate != null) {
                return originalDelegate.i(host, child, event);
            }
            return super.i(host, child, event);
        }

        @Override // a.h.k.a
        public a.h.k.e0.d b(View host) {
            a.h.k.a originalDelegate = this.e.get(host);
            if (originalDelegate != null) {
                return originalDelegate.b(host);
            }
            return super.b(host);
        }
    }
}
