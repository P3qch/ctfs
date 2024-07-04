package a.f.a.k;

import a.f.a.h;
import a.f.a.k.m.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public int f273b;
    public boolean c;
    public final e d;
    public final a e;
    public d f;
    public a.f.a.h i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet<d> f272a = null;
    public int g = 0;
    public int h = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public enum a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public void b(int orientation, ArrayList<o> arrayList, o group) {
        HashSet<d> hashSet = this.f272a;
        if (hashSet != null) {
            Iterator<d> it = hashSet.iterator();
            while (it.hasNext()) {
                d anchor = it.next();
                a.f.a.k.m.i.a(anchor.d, orientation, arrayList, group);
            }
        }
    }

    public HashSet<d> c() {
        return this.f272a;
    }

    public boolean l() {
        HashSet<d> hashSet = this.f272a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean k() {
        HashSet<d> hashSet = this.f272a;
        if (hashSet == null) {
            return false;
        }
        Iterator<d> it = hashSet.iterator();
        while (it.hasNext()) {
            d anchor = it.next();
            d opposite = anchor.f();
            if (opposite.n()) {
                return true;
            }
        }
        return false;
    }

    public void s(int finalValue) {
        this.f273b = finalValue;
        this.c = true;
    }

    public int d() {
        if (!this.c) {
            return 0;
        }
        return this.f273b;
    }

    public void q() {
        this.c = false;
        this.f273b = 0;
    }

    public boolean m() {
        return this.c;
    }

    public d(e owner, a type) {
        this.d = owner;
        this.e = type;
    }

    public a.f.a.h h() {
        return this.i;
    }

    public void r() {
        a.f.a.h hVar = this.i;
        if (hVar == null) {
            this.i = new a.f.a.h(h.a.UNRESTRICTED);
        } else {
            hVar.e();
        }
    }

    public e g() {
        return this.d;
    }

    public a j() {
        return this.e;
    }

    public int e() {
        d dVar;
        if (this.d.O() == 8) {
            return 0;
        }
        if (this.h != Integer.MIN_VALUE && (dVar = this.f) != null && dVar.d.O() == 8) {
            return this.h;
        }
        return this.g;
    }

    public d i() {
        return this.f;
    }

    public void p() {
        HashSet<d> hashSet;
        d dVar = this.f;
        if (dVar != null && (hashSet = dVar.f272a) != null) {
            hashSet.remove(this);
            if (this.f.f272a.size() == 0) {
                this.f.f272a = null;
            }
        }
        this.f272a = null;
        this.f = null;
        this.g = 0;
        this.h = Integer.MIN_VALUE;
        this.c = false;
        this.f273b = 0;
    }

    public boolean a(d toAnchor, int margin, int goneMargin, boolean forceConnection) {
        if (toAnchor == null) {
            p();
            return true;
        }
        if (!forceConnection && !o(toAnchor)) {
            return false;
        }
        this.f = toAnchor;
        if (toAnchor.f272a == null) {
            toAnchor.f272a = new HashSet<>();
        }
        HashSet<d> hashSet = this.f.f272a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = margin;
        this.h = goneMargin;
        return true;
    }

    public boolean n() {
        return this.f != null;
    }

    public boolean o(d anchor) {
        if (anchor == null) {
            return false;
        }
        a target = anchor.j();
        a aVar = this.e;
        if (target == aVar) {
            return aVar != a.BASELINE || (anchor.g().S() && g().S());
        }
        switch (aVar.ordinal()) {
            case 0:
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                return false;
            case 1:
            case 3:
                boolean isCompatible = target == a.LEFT || target == a.RIGHT;
                if (anchor.g() instanceof g) {
                    return isCompatible || target == a.CENTER_X;
                }
                return isCompatible;
            case 2:
            case 4:
                boolean isCompatible2 = target == a.TOP || target == a.BOTTOM;
                if (anchor.g() instanceof g) {
                    return isCompatible2 || target == a.CENTER_Y;
                }
                return isCompatible2;
            case 5:
                return (target == a.LEFT || target == a.RIGHT) ? false : true;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                return (target == a.BASELINE || target == a.CENTER_X || target == a.CENTER_Y) ? false : true;
            default:
                throw new AssertionError(this.e.name());
        }
    }

    public String toString() {
        return this.d.p() + ":" + this.e.toString();
    }

    public final d f() {
        switch (this.e.ordinal()) {
            case 0:
            case 5:
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                return null;
            case 1:
                return this.d.N;
            case 2:
                return this.d.O;
            case 3:
                return this.d.L;
            case 4:
                return this.d.M;
            default:
                throw new AssertionError(this.e.name());
        }
    }
}
