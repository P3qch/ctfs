package a.k.b;

import a.k.b.n;
import a.k.b.v;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.io.PrintWriter;
import java.util.ArrayList;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public final class a extends v implements n.m {
    public final n q;
    public boolean r;
    public int s;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.s >= 0) {
            sb.append(" #");
            sb.append(this.s);
        }
        if (this.h != null) {
            sb.append(" ");
            sb.append(this.h);
        }
        sb.append("}");
        return sb.toString();
    }

    public void q(String prefix, PrintWriter writer) {
        r(prefix, writer, true);
    }

    public void r(String prefix, PrintWriter writer, boolean full) {
        String cmdStr;
        if (full) {
            writer.print(prefix);
            writer.print("mName=");
            writer.print(this.h);
            writer.print(" mIndex=");
            writer.print(this.s);
            writer.print(" mCommitted=");
            writer.println(this.r);
            if (this.f != 0) {
                writer.print(prefix);
                writer.print("mTransition=#");
                writer.print(Integer.toHexString(this.f));
            }
            if (this.f588b != 0 || this.c != 0) {
                writer.print(prefix);
                writer.print("mEnterAnim=#");
                writer.print(Integer.toHexString(this.f588b));
                writer.print(" mExitAnim=#");
                writer.println(Integer.toHexString(this.c));
            }
            if (this.d != 0 || this.e != 0) {
                writer.print(prefix);
                writer.print("mPopEnterAnim=#");
                writer.print(Integer.toHexString(this.d));
                writer.print(" mPopExitAnim=#");
                writer.println(Integer.toHexString(this.e));
            }
            if (this.i != 0 || this.j != null) {
                writer.print(prefix);
                writer.print("mBreadCrumbTitleRes=#");
                writer.print(Integer.toHexString(this.i));
                writer.print(" mBreadCrumbTitleText=");
                writer.println(this.j);
            }
            if (this.k != 0 || this.l != null) {
                writer.print(prefix);
                writer.print("mBreadCrumbShortTitleRes=#");
                writer.print(Integer.toHexString(this.k));
                writer.print(" mBreadCrumbShortTitleText=");
                writer.println(this.l);
            }
        }
        if (!this.f587a.isEmpty()) {
            writer.print(prefix);
            writer.println("Operations:");
            int numOps = this.f587a.size();
            for (int opNum = 0; opNum < numOps; opNum++) {
                v.a op = this.f587a.get(opNum);
                switch (op.f589a) {
                    case 0:
                        cmdStr = "NULL";
                        break;
                    case 1:
                        cmdStr = "ADD";
                        break;
                    case 2:
                        cmdStr = "REPLACE";
                        break;
                    case 3:
                        cmdStr = "REMOVE";
                        break;
                    case 4:
                        cmdStr = "HIDE";
                        break;
                    case 5:
                        cmdStr = "SHOW";
                        break;
                    case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                        cmdStr = "DETACH";
                        break;
                    case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                        cmdStr = "ATTACH";
                        break;
                    case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                        cmdStr = "SET_PRIMARY_NAV";
                        break;
                    case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                        cmdStr = "UNSET_PRIMARY_NAV";
                        break;
                    case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                        cmdStr = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        cmdStr = "cmd=" + op.f589a;
                        break;
                }
                writer.print(prefix);
                writer.print("  Op #");
                writer.print(opNum);
                writer.print(": ");
                writer.print(cmdStr);
                writer.print(" ");
                writer.println(op.f590b);
                if (full) {
                    if (op.c != 0 || op.d != 0) {
                        writer.print(prefix);
                        writer.print("enterAnim=#");
                        writer.print(Integer.toHexString(op.c));
                        writer.print(" exitAnim=#");
                        writer.println(Integer.toHexString(op.d));
                    }
                    if (op.e != 0 || op.f != 0) {
                        writer.print(prefix);
                        writer.print("popEnterAnim=#");
                        writer.print(Integer.toHexString(op.e));
                        writer.print(" popExitAnim=#");
                        writer.println(Integer.toHexString(op.f));
                    }
                }
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(a.k.b.n r3) {
        /*
            r2 = this;
            a.k.b.j r0 = r3.l0()
            a.k.b.k r1 = r3.o0()
            if (r1 == 0) goto L17
            a.k.b.k r1 = r3.o0()
            android.content.Context r1 = r1.k()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L18
        L17:
            r1 = 0
        L18:
            r2.<init>(r0, r1)
            r0 = -1
            r2.s = r0
            r2.q = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.k.b.a.<init>(a.k.b.n):void");
    }

    @Override // a.k.b.v
    public void j(int containerViewId, Fragment fragment, String tag, int opcmd) {
        super.j(containerViewId, fragment, tag, opcmd);
        fragment.u = this.q;
    }

    @Override // a.k.b.v
    public v k(Fragment fragment) {
        n nVar = fragment.u;
        if (nVar != null && nVar != this.q) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        super.k(fragment);
        return this;
    }

    public void o(int amt) {
        if (!this.g) {
            return;
        }
        if (n.A0(2)) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + amt);
        }
        int numOps = this.f587a.size();
        for (int opNum = 0; opNum < numOps; opNum++) {
            v.a op = this.f587a.get(opNum);
            Fragment fragment = op.f590b;
            if (fragment != null) {
                fragment.t += amt;
                if (n.A0(2)) {
                    Log.v("FragmentManager", "Bump nesting of " + op.f590b + " to " + op.f590b.t);
                }
            }
        }
    }

    public void y() {
        if (this.p != null) {
            for (int i = 0; i < this.p.size(); i++) {
                this.p.get(i).run();
            }
            this.p = null;
        }
    }

    @Override // a.k.b.v
    public int e() {
        return p(false);
    }

    @Override // a.k.b.v
    public int f() {
        return p(true);
    }

    @Override // a.k.b.v
    public void g() {
        i();
        this.q.X(this, false);
    }

    @Override // a.k.b.v
    public void h() {
        i();
        this.q.X(this, true);
    }

    public int p(boolean allowStateLoss) {
        if (this.r) {
            throw new IllegalStateException("commit already called");
        }
        if (n.A0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            a0 logw = new a0("FragmentManager");
            PrintWriter pw = new PrintWriter(logw);
            q("  ", pw);
            pw.close();
        }
        this.r = true;
        if (this.g) {
            this.s = this.q.g();
        } else {
            this.s = -1;
        }
        this.q.U(this, allowStateLoss);
        return this.s;
    }

    @Override // a.k.b.n.m
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> isRecordPop) {
        if (n.A0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        isRecordPop.add(false);
        if (this.g) {
            this.q.c(this);
            return true;
        }
        return true;
    }

    public boolean w(int containerId) {
        int numOps = this.f587a.size();
        int opNum = 0;
        while (true) {
            if (opNum >= numOps) {
                return false;
            }
            v.a op = this.f587a.get(opNum);
            Fragment fragment = op.f590b;
            int fragContainer = fragment != null ? fragment.z : 0;
            if (fragContainer == 0 || fragContainer != containerId) {
                opNum++;
            } else {
                return true;
            }
        }
    }

    public boolean x(ArrayList<a> arrayList, int startIndex, int endIndex) {
        if (endIndex == startIndex) {
            return false;
        }
        int numOps = this.f587a.size();
        int lastContainer = -1;
        for (int opNum = 0; opNum < numOps; opNum++) {
            v.a op = this.f587a.get(opNum);
            Fragment fragment = op.f590b;
            int container = fragment != null ? fragment.z : 0;
            if (container != 0 && container != lastContainer) {
                lastContainer = container;
                for (int i = startIndex; i < endIndex; i++) {
                    a record = arrayList.get(i);
                    int numThoseOps = record.f587a.size();
                    for (int thoseOpIndex = 0; thoseOpIndex < numThoseOps; thoseOpIndex++) {
                        v.a thatOp = record.f587a.get(thoseOpIndex);
                        Fragment fragment2 = thatOp.f590b;
                        int thatContainer = fragment2 != null ? fragment2.z : 0;
                        if (thatContainer == container) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void s() {
        int numOps = this.f587a.size();
        int opNum = 0;
        while (opNum < numOps) {
            v.a op = this.f587a.get(opNum);
            Fragment f = op.f590b;
            if (f != null) {
                f.s1(false);
                f.q1(this.f);
                f.u1(this.m, this.n);
            }
            switch (op.f589a) {
                case 1:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.Y0(f, false);
                    this.q.e(f);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f589a);
                case 3:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.R0(f);
                    break;
                case 4:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.x0(f);
                    break;
                case 5:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.Y0(f, false);
                    this.q.c1(f);
                    break;
                case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.t(f);
                    break;
                case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.Y0(f, false);
                    this.q.i(f);
                    break;
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    this.q.a1(f);
                    break;
                case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                    this.q.a1(null);
                    break;
                case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                    this.q.Z0(f, op.h);
                    break;
            }
            opNum = (this.o || op.f589a == 1 || f != null) ? opNum + 1 : opNum + 1;
        }
        if (!this.o) {
        }
    }

    public void t(boolean moveToState) {
        int opNum = this.f587a.size() - 1;
        while (opNum >= 0) {
            v.a op = this.f587a.get(opNum);
            Fragment f = op.f590b;
            if (f != null) {
                f.s1(true);
                f.q1(n.V0(this.f));
                f.u1(this.n, this.m);
            }
            switch (op.f589a) {
                case 1:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.Y0(f, true);
                    this.q.R0(f);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f589a);
                case 3:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.e(f);
                    break;
                case 4:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.c1(f);
                    break;
                case 5:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.Y0(f, true);
                    this.q.x0(f);
                    break;
                case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.i(f);
                    break;
                case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                    f.l1(op.c, op.d, op.e, op.f);
                    this.q.Y0(f, true);
                    this.q.t(f);
                    break;
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    this.q.a1(null);
                    break;
                case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                    this.q.a1(f);
                    break;
                case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                    this.q.Z0(f, op.g);
                    break;
            }
            opNum = (this.o || op.f589a == 3 || f != null) ? opNum - 1 : opNum + (-1);
        }
        if (this.o || moveToState) {
        }
    }

    public Fragment u(ArrayList<Fragment> added, Fragment oldPrimaryNav) {
        int opNum = 0;
        while (opNum < this.f587a.size()) {
            v.a op = this.f587a.get(opNum);
            switch (op.f589a) {
                case 1:
                case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                    added.add(op.f590b);
                    break;
                case 2:
                    Fragment f = op.f590b;
                    int containerId = f.z;
                    boolean alreadyAdded = false;
                    for (int i = added.size() - 1; i >= 0; i--) {
                        Fragment old = added.get(i);
                        if (old.z == containerId) {
                            if (old == f) {
                                alreadyAdded = true;
                            } else {
                                if (old == oldPrimaryNav) {
                                    this.f587a.add(opNum, new v.a(9, old));
                                    opNum++;
                                    oldPrimaryNav = null;
                                }
                                v.a removeOp = new v.a(3, old);
                                removeOp.c = op.c;
                                removeOp.e = op.e;
                                removeOp.d = op.d;
                                removeOp.f = op.f;
                                this.f587a.add(opNum, removeOp);
                                added.remove(old);
                                opNum++;
                            }
                        }
                    }
                    if (alreadyAdded) {
                        this.f587a.remove(opNum);
                        opNum--;
                        break;
                    } else {
                        op.f589a = 1;
                        added.add(f);
                        break;
                    }
                case 3:
                case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                    added.remove(op.f590b);
                    Fragment fragment = op.f590b;
                    if (fragment == oldPrimaryNav) {
                        this.f587a.add(opNum, new v.a(9, fragment));
                        opNum++;
                        oldPrimaryNav = null;
                        break;
                    } else {
                        break;
                    }
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    this.f587a.add(opNum, new v.a(9, oldPrimaryNav));
                    opNum++;
                    oldPrimaryNav = op.f590b;
                    break;
            }
            opNum++;
        }
        return oldPrimaryNav;
    }

    public Fragment z(ArrayList<Fragment> added, Fragment oldPrimaryNav) {
        for (int opNum = this.f587a.size() - 1; opNum >= 0; opNum--) {
            v.a op = this.f587a.get(opNum);
            switch (op.f589a) {
                case 1:
                case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                    added.remove(op.f590b);
                    break;
                case 3:
                case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                    added.add(op.f590b);
                    break;
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    oldPrimaryNav = null;
                    break;
                case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                    oldPrimaryNav = op.f590b;
                    break;
                case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                    op.h = op.g;
                    break;
            }
        }
        return oldPrimaryNav;
    }

    public String v() {
        return this.h;
    }
}
