package a.f.a.k.m;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static int f292a = 0;
    public int c;
    public int d;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<a.f.a.k.e> f293b = new ArrayList<>();
    public ArrayList<a> e = null;
    public int f = -1;

    public o(int orientation) {
        this.c = -1;
        this.d = 0;
        int i = f292a;
        f292a = i + 1;
        this.c = i;
        this.d = orientation;
    }

    public int d() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public boolean a(a.f.a.k.e widget) {
        if (this.f293b.contains(widget)) {
            return false;
        }
        this.f293b.add(widget);
        return true;
    }

    public void h(boolean isAuthoritative) {
    }

    public final String e() {
        int i = this.d;
        if (i == 0) {
            return "Horizontal";
        }
        if (i == 1) {
            return "Vertical";
        }
        if (i == 2) {
            return "Both";
        }
        return "Unknown";
    }

    public String toString() {
        String ret = e() + " [" + this.c + "] <";
        Iterator<a.f.a.k.e> it = this.f293b.iterator();
        while (it.hasNext()) {
            a.f.a.k.e widget = it.next();
            ret = ret + " " + widget.p();
        }
        return ret + " >";
    }

    public void g(int orientation, o widgetGroup) {
        Iterator<a.f.a.k.e> it = this.f293b.iterator();
        while (it.hasNext()) {
            a.f.a.k.e widget = it.next();
            widgetGroup.a(widget);
            if (orientation == 0) {
                widget.s0 = widgetGroup.c();
            } else {
                widget.t0 = widgetGroup.c();
            }
        }
        this.f = widgetGroup.c;
    }

    public int f(a.f.a.d system, int orientation) {
        int count = this.f293b.size();
        if (count == 0) {
            return 0;
        }
        return j(system, this.f293b, orientation);
    }

    public final int j(a.f.a.d system, ArrayList<a.f.a.k.e> arrayList, int orientation) {
        a.f.a.k.f container = (a.f.a.k.f) arrayList.get(0).G();
        system.D();
        container.e(system, false);
        for (int i = 0; i < arrayList.size(); i++) {
            a.f.a.k.e widget = arrayList.get(i);
            widget.e(system, false);
        }
        if (orientation == 0 && container.D0 > 0) {
            a.f.a.k.b.b(container, system, arrayList, 0);
        }
        if (orientation == 1 && container.E0 > 0) {
            a.f.a.k.b.b(container, system, arrayList, 1);
        }
        try {
            system.z();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.e = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a.f.a.k.e widget2 = arrayList.get(i2);
            a result = new a(this, widget2, system, orientation);
            this.e.add(result);
        }
        if (orientation == 0) {
            int left = system.x(container.L);
            int right = system.x(container.N);
            system.D();
            return right - left;
        }
        int top = system.x(container.M);
        int bottom = system.x(container.O);
        system.D();
        return bottom - top;
    }

    public void i(int orientation) {
        this.d = orientation;
    }

    public void b(ArrayList<o> arrayList) {
        int count = this.f293b.size();
        if (this.f != -1 && count > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                o group = arrayList.get(i);
                if (this.f == group.c) {
                    g(this.d, group);
                }
            }
        }
        if (count == 0) {
            arrayList.remove(this);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public a(o this$0, a.f.a.k.e widget, a.f.a.d system, int orientation) {
            new WeakReference(widget);
            system.x(widget.L);
            system.x(widget.M);
            system.x(widget.N);
            system.x(widget.O);
            system.x(widget.P);
        }
    }
}
