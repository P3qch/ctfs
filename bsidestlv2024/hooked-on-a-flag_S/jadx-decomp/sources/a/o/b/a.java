package a.o.b;

import a.o.b.h;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class a implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public a.h.j.f<b> f636a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f637b;
    public final ArrayList<b> c;
    public final InterfaceC0046a d;
    public final boolean e;
    public final h f;
    public int g;

    /* renamed from: a.o.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0046a {
    }

    public a(InterfaceC0046a callback) {
        this(callback, false);
    }

    public a(InterfaceC0046a callback, boolean disableRecycler) {
        this.f636a = new a.h.j.g(30);
        this.f637b = new ArrayList<>();
        this.c = new ArrayList<>();
        this.g = 0;
        this.d = callback;
        this.e = disableRecycler;
        this.f = new h(this);
    }

    public void u() {
        t(this.f637b);
        t(this.c);
        this.g = 0;
    }

    public void r() {
        this.f.b(this.f637b);
        int count = this.f637b.size();
        for (int i = 0; i < count; i++) {
            b op = this.f637b.get(i);
            switch (op.f638a) {
                case 1:
                    a(op);
                    break;
                case 2:
                    d(op);
                    break;
                case 4:
                    e(op);
                    break;
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    b(op);
                    break;
            }
        }
        this.f637b.clear();
    }

    public void g() {
        int count = this.c.size();
        for (int i = 0; i < count; i++) {
            ((RecyclerView.f) this.d).i(this.c.get(i));
        }
        t(this.c);
        this.g = 0;
    }

    public final void b(b op) {
        q(op);
    }

    public final void d(b op) {
        int tmpStart = op.f639b;
        int tmpCount = 0;
        int tmpEnd = op.f639b + op.d;
        int type = -1;
        int position = op.f639b;
        while (position < tmpEnd) {
            boolean typeChanged = false;
            RecyclerView.c0 vh = ((RecyclerView.f) this.d).b(position);
            if (vh != null || f(position)) {
                if (type == 0) {
                    b newOp = p(2, tmpStart, tmpCount, null);
                    i(newOp);
                    typeChanged = true;
                }
                type = 1;
            } else {
                if (type == 1) {
                    b newOp2 = p(2, tmpStart, tmpCount, null);
                    q(newOp2);
                    typeChanged = true;
                }
                type = 0;
            }
            if (typeChanged) {
                position -= tmpCount;
                tmpEnd -= tmpCount;
                tmpCount = 1;
            } else {
                tmpCount++;
            }
            position++;
        }
        int position2 = op.d;
        if (tmpCount != position2) {
            s(op);
            op = p(2, tmpStart, tmpCount, null);
        }
        if (type == 0) {
            i(op);
        } else {
            q(op);
        }
    }

    public final void e(b op) {
        int tmpStart = op.f639b;
        int tmpCount = 0;
        int tmpEnd = op.f639b + op.d;
        int type = -1;
        for (int position = op.f639b; position < tmpEnd; position++) {
            RecyclerView.c0 vh = ((RecyclerView.f) this.d).b(position);
            if (vh != null || f(position)) {
                if (type == 0) {
                    b newOp = p(4, tmpStart, tmpCount, op.c);
                    i(newOp);
                    tmpCount = 0;
                    tmpStart = position;
                }
                type = 1;
            } else {
                if (type == 1) {
                    b newOp2 = p(4, tmpStart, tmpCount, op.c);
                    q(newOp2);
                    tmpCount = 0;
                    tmpStart = position;
                }
                type = 0;
            }
            tmpCount++;
        }
        int position2 = op.d;
        if (tmpCount != position2) {
            Object payload = op.c;
            s(op);
            op = p(4, tmpStart, tmpCount, payload);
        }
        if (type == 0) {
            i(op);
        } else {
            q(op);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(a.o.b.a.b r13) {
        /*
            r12 = this;
            int r0 = r13.f638a
            r1 = 1
            if (r0 == r1) goto L85
            r2 = 8
            if (r0 == r2) goto L85
            int r2 = r13.f639b
            int r0 = r12.v(r2, r0)
            r2 = 1
            int r3 = r13.f639b
            int r4 = r13.f638a
            switch(r4) {
                case 2: goto L30;
                case 3: goto L17;
                case 4: goto L2e;
                default: goto L17;
            }
        L17:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "op should be remove or update."
            r4.append(r5)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r1.<init>(r4)
            throw r1
        L2e:
            r4 = 1
            goto L32
        L30:
            r4 = 0
        L32:
            r5 = 1
        L33:
            int r6 = r13.d
            if (r5 >= r6) goto L71
            int r6 = r13.f639b
            int r7 = r4 * r5
            int r6 = r6 + r7
            int r7 = r13.f638a
            int r7 = r12.v(r6, r7)
            r8 = 0
            int r9 = r13.f638a
            r10 = 0
            switch(r9) {
                case 2: goto L51;
                case 3: goto L49;
                case 4: goto L4a;
                default: goto L49;
            }
        L49:
            goto L55
        L4a:
            int r11 = r0 + 1
            if (r7 != r11) goto L4f
            r10 = 1
        L4f:
            r8 = r10
            goto L55
        L51:
            if (r7 != r0) goto L54
            r10 = 1
        L54:
            r8 = r10
        L55:
            if (r8 == 0) goto L5a
            int r2 = r2 + 1
            goto L6e
        L5a:
            java.lang.Object r10 = r13.c
            a.o.b.a$b r9 = r12.p(r9, r0, r2, r10)
            r12.j(r9, r3)
            r12.s(r9)
            int r10 = r13.f638a
            r11 = 4
            if (r10 != r11) goto L6c
            int r3 = r3 + r2
        L6c:
            r0 = r7
            r2 = 1
        L6e:
            int r5 = r5 + 1
            goto L33
        L71:
            java.lang.Object r1 = r13.c
            r12.s(r13)
            if (r2 <= 0) goto L84
            int r5 = r13.f638a
            a.o.b.a$b r5 = r12.p(r5, r0, r2, r1)
            r12.j(r5, r3)
            r12.s(r5)
        L84:
            return
        L85:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "should not dispatch add or move for pre layout"
            r0.<init>(r1)
            goto L8e
        L8d:
            throw r0
        L8e:
            goto L8d
        */
        throw new UnsupportedOperationException("Method not decompiled: a.o.b.a.i(a.o.b.a$b):void");
    }

    public void j(b op, int offsetStart) {
        ((RecyclerView.f) this.d).h(op);
        switch (op.f638a) {
            case 2:
                ((RecyclerView.f) this.d).f(offsetStart, op.d);
                return;
            case 3:
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            case 4:
                ((RecyclerView.f) this.d).c(offsetStart, op.d, op.c);
                return;
        }
    }

    public final int v(int pos, int cmd) {
        int start;
        int end;
        int count = this.c.size();
        for (int i = count - 1; i >= 0; i--) {
            b postponed = this.c.get(i);
            int i2 = postponed.f638a;
            if (i2 == 8) {
                int i3 = postponed.f639b;
                int i4 = postponed.d;
                if (i3 < i4) {
                    start = postponed.f639b;
                    end = postponed.d;
                } else {
                    start = postponed.d;
                    end = postponed.f639b;
                }
                if (pos >= start && pos <= end) {
                    if (start == i3) {
                        if (cmd == 1) {
                            postponed.d = i4 + 1;
                        } else if (cmd == 2) {
                            postponed.d = i4 - 1;
                        }
                        pos++;
                    } else {
                        if (cmd == 1) {
                            postponed.f639b = i3 + 1;
                        } else if (cmd == 2) {
                            postponed.f639b = i3 - 1;
                        }
                        pos--;
                    }
                } else if (pos < i3) {
                    if (cmd == 1) {
                        postponed.f639b = i3 + 1;
                        postponed.d = i4 + 1;
                    } else if (cmd == 2) {
                        postponed.f639b = i3 - 1;
                        postponed.d = i4 - 1;
                    }
                }
            } else {
                int i5 = postponed.f639b;
                if (i5 <= pos) {
                    if (i2 == 1) {
                        pos -= postponed.d;
                    } else if (i2 == 2) {
                        pos += postponed.d;
                    }
                } else if (cmd == 1) {
                    postponed.f639b = i5 + 1;
                } else if (cmd == 2) {
                    postponed.f639b = i5 - 1;
                }
            }
        }
        for (int i6 = this.c.size() - 1; i6 >= 0; i6--) {
            b op = this.c.get(i6);
            if (op.f638a == 8) {
                int i7 = op.d;
                if (i7 == op.f639b || i7 < 0) {
                    this.c.remove(i6);
                    s(op);
                }
            } else if (op.d <= 0) {
                this.c.remove(i6);
                s(op);
            }
        }
        return pos;
    }

    public final boolean f(int position) {
        int count = this.c.size();
        for (int i = 0; i < count; i++) {
            b op = this.c.get(i);
            int i2 = op.f638a;
            if (i2 == 8) {
                if (l(op.d, i + 1) == position) {
                    return true;
                }
            } else if (i2 == 1) {
                int end = op.f639b + op.d;
                for (int pos = op.f639b; pos < end; pos++) {
                    if (l(pos, i + 1) == position) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public final void a(b op) {
        q(op);
    }

    public final void q(b op) {
        this.c.add(op);
        switch (op.f638a) {
            case 1:
                ((RecyclerView.f) this.d).d(op.f639b, op.d);
                return;
            case 2:
                ((RecyclerView.f) this.d).g(op.f639b, op.d);
                return;
            case 4:
                ((RecyclerView.f) this.d).c(op.f639b, op.d, op.c);
                return;
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                ((RecyclerView.f) this.d).e(op.f639b, op.d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + op);
        }
    }

    public boolean n() {
        return this.f637b.size() > 0;
    }

    public boolean m(int updateTypes) {
        return (this.g & updateTypes) != 0;
    }

    public int k(int position) {
        return l(position, 0);
    }

    public int l(int position, int firstPostponedItem) {
        int count = this.c.size();
        for (int i = firstPostponedItem; i < count; i++) {
            b op = this.c.get(i);
            int i2 = op.f638a;
            if (i2 == 8) {
                int i3 = op.f639b;
                if (i3 == position) {
                    position = op.d;
                } else {
                    if (i3 < position) {
                        position--;
                    }
                    if (op.d <= position) {
                        position++;
                    }
                }
            } else {
                int i4 = op.f639b;
                if (i4 > position) {
                    continue;
                } else if (i2 == 2) {
                    int i5 = op.d;
                    if (position < i4 + i5) {
                        return -1;
                    }
                    position -= i5;
                } else if (i2 == 1) {
                    position += op.d;
                }
            }
        }
        return position;
    }

    public void h() {
        g();
        int count = this.f637b.size();
        for (int i = 0; i < count; i++) {
            b op = this.f637b.get(i);
            switch (op.f638a) {
                case 1:
                    ((RecyclerView.f) this.d).i(op);
                    ((RecyclerView.f) this.d).d(op.f639b, op.d);
                    break;
                case 2:
                    ((RecyclerView.f) this.d).i(op);
                    ((RecyclerView.f) this.d).f(op.f639b, op.d);
                    break;
                case 4:
                    ((RecyclerView.f) this.d).i(op);
                    ((RecyclerView.f) this.d).c(op.f639b, op.d, op.c);
                    break;
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    ((RecyclerView.f) this.d).i(op);
                    ((RecyclerView.f) this.d).e(op.f639b, op.d);
                    break;
            }
        }
        t(this.f637b);
        this.g = 0;
    }

    public int c(int position) {
        int size = this.f637b.size();
        for (int i = 0; i < size; i++) {
            b op = this.f637b.get(i);
            switch (op.f638a) {
                case 1:
                    if (op.f639b <= position) {
                        position += op.d;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    int i2 = op.f639b;
                    if (i2 <= position) {
                        int i3 = op.d;
                        int end = i2 + i3;
                        if (end > position) {
                            return -1;
                        }
                        position -= i3;
                        break;
                    } else {
                        continue;
                    }
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    int i4 = op.f639b;
                    if (i4 == position) {
                        position = op.d;
                        break;
                    } else {
                        if (i4 < position) {
                            position--;
                        }
                        if (op.d <= position) {
                            position++;
                            break;
                        } else {
                            break;
                        }
                    }
            }
        }
        return position;
    }

    public boolean o() {
        return (this.c.isEmpty() || this.f637b.isEmpty()) ? false : true;
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f638a;

        /* renamed from: b, reason: collision with root package name */
        public int f639b;
        public Object c;
        public int d;

        public b(int cmd, int positionStart, int itemCount, Object payload) {
            this.f638a = cmd;
            this.f639b = positionStart;
            this.d = itemCount;
            this.c = payload;
        }

        public String a() {
            switch (this.f638a) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 4:
                    return "up";
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    return "mv";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f639b + "c:" + this.d + ",p:" + this.c + "]";
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            b op = (b) o;
            int i = this.f638a;
            if (i != op.f638a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.f639b) == 1 && this.d == op.f639b && this.f639b == op.d) {
                return true;
            }
            if (this.d != op.d || this.f639b != op.f639b) {
                return false;
            }
            Object obj = this.c;
            if (obj != null) {
                if (!obj.equals(op.c)) {
                    return false;
                }
            } else if (op.c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int result = this.f638a;
            return (((result * 31) + this.f639b) * 31) + this.d;
        }
    }

    public b p(int cmd, int positionStart, int itemCount, Object payload) {
        b op = this.f636a.b();
        if (op == null) {
            return new b(cmd, positionStart, itemCount, payload);
        }
        op.f638a = cmd;
        op.f639b = positionStart;
        op.d = itemCount;
        op.c = payload;
        return op;
    }

    public void s(b op) {
        if (!this.e) {
            op.c = null;
            this.f636a.a(op);
        }
    }

    public void t(List<b> list) {
        int count = list.size();
        for (int i = 0; i < count; i++) {
            s(list.get(i));
        }
        list.clear();
    }
}
