package a.o.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class m extends RecyclerView.l {
    public boolean g = true;

    public abstract boolean w(RecyclerView.c0 c0Var);

    public abstract boolean x(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i, int i2, int i3, int i4);

    public abstract boolean y(RecyclerView.c0 c0Var, int i, int i2, int i3, int i4);

    public abstract boolean z(RecyclerView.c0 c0Var);

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.c0 viewHolder) {
        return !this.g || viewHolder.t();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.c0 viewHolder, RecyclerView.l.c preLayoutInfo, RecyclerView.l.c postLayoutInfo) {
        int oldLeft = preLayoutInfo.f897a;
        int oldTop = preLayoutInfo.f898b;
        View disappearingItemView = viewHolder.f889b;
        int newLeft = postLayoutInfo == null ? disappearingItemView.getLeft() : postLayoutInfo.f897a;
        int newTop = postLayoutInfo == null ? disappearingItemView.getTop() : postLayoutInfo.f898b;
        if (!viewHolder.v() && (oldLeft != newLeft || oldTop != newTop)) {
            disappearingItemView.layout(newLeft, newTop, disappearingItemView.getWidth() + newLeft, disappearingItemView.getHeight() + newTop);
            return y(viewHolder, oldLeft, oldTop, newLeft, newTop);
        }
        z(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.c0 viewHolder, RecyclerView.l.c preLayoutInfo, RecyclerView.l.c postLayoutInfo) {
        int i;
        int i2;
        if (preLayoutInfo != null && ((i = preLayoutInfo.f897a) != (i2 = postLayoutInfo.f897a) || preLayoutInfo.f898b != postLayoutInfo.f898b)) {
            return y(viewHolder, i, preLayoutInfo.f898b, i2, postLayoutInfo.f898b);
        }
        w(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.c0 viewHolder, RecyclerView.l.c preInfo, RecyclerView.l.c postInfo) {
        int i = preInfo.f897a;
        int i2 = postInfo.f897a;
        if (i != i2 || preInfo.f898b != postInfo.f898b) {
            return y(viewHolder, i, preInfo.f898b, i2, postInfo.f898b);
        }
        E(viewHolder);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.c0 oldHolder, RecyclerView.c0 newHolder, RecyclerView.l.c preInfo, RecyclerView.l.c postInfo) {
        int toLeft;
        int toTop;
        int fromLeft = preInfo.f897a;
        int fromTop = preInfo.f898b;
        if (newHolder.J()) {
            int toLeft2 = preInfo.f897a;
            toLeft = toLeft2;
            toTop = preInfo.f898b;
        } else {
            int toLeft3 = postInfo.f897a;
            toLeft = toLeft3;
            toTop = postInfo.f898b;
        }
        return x(oldHolder, newHolder, fromLeft, fromTop, toLeft, toTop);
    }

    public final void G(RecyclerView.c0 item) {
        O();
        h(item);
    }

    public final void E(RecyclerView.c0 item) {
        M();
        h(item);
    }

    public final void A(RecyclerView.c0 item) {
        I();
        h(item);
    }

    public final void C(RecyclerView.c0 item, boolean oldItem) {
        K();
        h(item);
    }

    public final void H(RecyclerView.c0 item) {
        P();
    }

    public final void F(RecyclerView.c0 item) {
        N();
    }

    public final void B(RecyclerView.c0 item) {
        J();
    }

    public final void D(RecyclerView.c0 item, boolean oldItem) {
        L();
    }

    public void P() {
    }

    public void O() {
    }

    public void J() {
    }

    public void I() {
    }

    public void N() {
    }

    public void M() {
    }

    public void L() {
    }

    public void K() {
    }
}
