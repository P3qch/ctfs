package a.o.b;

import a.o.b.a;
import java.util.List;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final a f675a;

    /* loaded from: classes.dex */
    public interface a {
    }

    public h(a callback) {
        this.f675a = callback;
    }

    public void b(List<a.b> list) {
        while (true) {
            int badMove = a(list);
            if (badMove != -1) {
                d(list, badMove, badMove + 1);
            } else {
                return;
            }
        }
    }

    public final void d(List<a.b> list, int badMove, int next) {
        a.b moveOp = list.get(badMove);
        a.b nextOp = list.get(next);
        switch (nextOp.f638a) {
            case 1:
                c(list, badMove, moveOp, next, nextOp);
                return;
            case 2:
                e(list, badMove, moveOp, next, nextOp);
                return;
            case 3:
            default:
                return;
            case 4:
                f(list, badMove, moveOp, next, nextOp);
                return;
        }
    }

    public void e(List<a.b> list, int movePos, a.b moveOp, int removePos, a.b removeOp) {
        boolean moveIsBackwards;
        a.b extraRm = null;
        boolean revertedMove = false;
        int i = moveOp.f639b;
        int i2 = moveOp.d;
        if (i < i2) {
            moveIsBackwards = false;
            if (removeOp.f639b == i && removeOp.d == i2 - i) {
                revertedMove = true;
            }
        } else {
            moveIsBackwards = true;
            if (removeOp.f639b == i2 + 1 && removeOp.d == i - i2) {
                revertedMove = true;
            }
        }
        int i3 = removeOp.f639b;
        if (i2 < i3) {
            removeOp.f639b = i3 - 1;
        } else {
            int i4 = removeOp.d;
            if (i2 < i3 + i4) {
                removeOp.d = i4 - 1;
                moveOp.f638a = 2;
                moveOp.d = 1;
                if (removeOp.d == 0) {
                    list.remove(removePos);
                    ((a.o.b.a) this.f675a).s(removeOp);
                    return;
                }
                return;
            }
        }
        int i5 = moveOp.f639b;
        int i6 = removeOp.f639b;
        if (i5 <= i6) {
            removeOp.f639b = i6 + 1;
        } else {
            int i7 = removeOp.d;
            if (i5 < i6 + i7) {
                int remaining = (i6 + i7) - i5;
                extraRm = ((a.o.b.a) this.f675a).p(2, i5 + 1, remaining, null);
                removeOp.d = moveOp.f639b - removeOp.f639b;
            }
        }
        if (revertedMove) {
            list.set(movePos, removeOp);
            list.remove(removePos);
            ((a.o.b.a) this.f675a).s(moveOp);
            return;
        }
        if (moveIsBackwards) {
            if (extraRm != null) {
                int i8 = moveOp.f639b;
                if (i8 > extraRm.f639b) {
                    moveOp.f639b = i8 - extraRm.d;
                }
                int i9 = moveOp.d;
                if (i9 > extraRm.f639b) {
                    moveOp.d = i9 - extraRm.d;
                }
            }
            int i10 = moveOp.f639b;
            if (i10 > removeOp.f639b) {
                moveOp.f639b = i10 - removeOp.d;
            }
            int i11 = moveOp.d;
            if (i11 > removeOp.f639b) {
                moveOp.d = i11 - removeOp.d;
            }
        } else {
            if (extraRm != null) {
                int i12 = moveOp.f639b;
                if (i12 >= extraRm.f639b) {
                    moveOp.f639b = i12 - extraRm.d;
                }
                int i13 = moveOp.d;
                if (i13 >= extraRm.f639b) {
                    moveOp.d = i13 - extraRm.d;
                }
            }
            int i14 = moveOp.f639b;
            if (i14 >= removeOp.f639b) {
                moveOp.f639b = i14 - removeOp.d;
            }
            int i15 = moveOp.d;
            if (i15 >= removeOp.f639b) {
                moveOp.d = i15 - removeOp.d;
            }
        }
        list.set(movePos, removeOp);
        if (moveOp.f639b != moveOp.d) {
            list.set(removePos, moveOp);
        } else {
            list.remove(removePos);
        }
        if (extraRm != null) {
            list.add(movePos, extraRm);
        }
    }

    public final void c(List<a.b> list, int move, a.b moveOp, int add, a.b addOp) {
        int offset = 0;
        int i = moveOp.d;
        int i2 = addOp.f639b;
        if (i < i2) {
            offset = 0 - 1;
        }
        int i3 = moveOp.f639b;
        if (i3 < i2) {
            offset++;
        }
        if (i2 <= i3) {
            moveOp.f639b = i3 + addOp.d;
        }
        int i4 = addOp.f639b;
        if (i4 <= i) {
            moveOp.d = i + addOp.d;
        }
        addOp.f639b = i4 + offset;
        list.set(move, addOp);
        list.set(add, moveOp);
    }

    public void f(List<a.b> list, int move, a.b moveOp, int update, a.b updateOp) {
        a.b extraUp1 = null;
        a.b extraUp2 = null;
        int i = moveOp.d;
        int i2 = updateOp.f639b;
        if (i < i2) {
            updateOp.f639b = i2 - 1;
        } else {
            int i3 = updateOp.d;
            if (i < i2 + i3) {
                updateOp.d = i3 - 1;
                extraUp1 = ((a.o.b.a) this.f675a).p(4, moveOp.f639b, 1, updateOp.c);
            }
        }
        int i4 = moveOp.f639b;
        int i5 = updateOp.f639b;
        if (i4 <= i5) {
            updateOp.f639b = i5 + 1;
        } else {
            int i6 = updateOp.d;
            if (i4 < i5 + i6) {
                int remaining = (i5 + i6) - i4;
                extraUp2 = ((a.o.b.a) this.f675a).p(4, i4 + 1, remaining, updateOp.c);
                updateOp.d -= remaining;
            }
        }
        list.set(update, moveOp);
        if (updateOp.d > 0) {
            list.set(move, updateOp);
        } else {
            list.remove(move);
            ((a.o.b.a) this.f675a).s(updateOp);
        }
        if (extraUp1 != null) {
            list.add(move, extraUp1);
        }
        if (extraUp2 != null) {
            list.add(move, extraUp2);
        }
    }

    public final int a(List<a.b> list) {
        boolean foundNonMove = false;
        for (int i = list.size() - 1; i >= 0; i--) {
            a.b op1 = list.get(i);
            if (op1.f638a == 8) {
                if (foundNonMove) {
                    return i;
                }
            } else {
                foundNonMove = true;
            }
        }
        return -1;
    }
}
