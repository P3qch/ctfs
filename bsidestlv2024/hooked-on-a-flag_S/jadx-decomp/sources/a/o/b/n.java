package a.o.b;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class n extends RecyclerView.q {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f678a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView.s f679b = new a();

    public abstract int[] c(RecyclerView.o oVar, View view);

    @Deprecated
    public abstract g e(RecyclerView.o oVar);

    public abstract View g(RecyclerView.o oVar);

    public abstract int h(RecyclerView.o oVar, int i, int i2);

    /* loaded from: classes.dex */
    public class a extends RecyclerView.s {

        /* renamed from: a, reason: collision with root package name */
        public boolean f680a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int newState) {
            super.a(recyclerView, newState);
            if (newState == 0 && this.f680a) {
                this.f680a = false;
                n.this.k();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int dx, int dy) {
            if (dx != 0 || dy != 0) {
                this.f680a = true;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean a(int velocityX, int velocityY) {
        RecyclerView.o layoutManager = this.f678a.getLayoutManager();
        if (layoutManager == null) {
            return false;
        }
        RecyclerView.g adapter = this.f678a.getAdapter();
        if (adapter == null) {
            return false;
        }
        int minFlingVelocity = this.f678a.getMinFlingVelocity();
        return (Math.abs(velocityY) > minFlingVelocity || Math.abs(velocityX) > minFlingVelocity) && j(layoutManager, velocityX, velocityY);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f678a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            f();
        }
        this.f678a = recyclerView;
        if (recyclerView != null) {
            i();
            new Scroller(this.f678a.getContext(), new DecelerateInterpolator());
            k();
        }
    }

    public final void i() {
        if (this.f678a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f678a.k(this.f679b);
        this.f678a.setOnFlingListener(this);
    }

    public final void f() {
        this.f678a.X0(this.f679b);
        this.f678a.setOnFlingListener(null);
    }

    public final boolean j(RecyclerView.o layoutManager, int velocityX, int velocityY) {
        RecyclerView.y smoothScroller;
        int targetPosition;
        if (!(layoutManager instanceof RecyclerView.y.b) || (smoothScroller = d(layoutManager)) == null || (targetPosition = h(layoutManager, velocityX, velocityY)) == -1) {
            return false;
        }
        smoothScroller.p(targetPosition);
        layoutManager.J1(smoothScroller);
        return true;
    }

    public void k() {
        RecyclerView.o layoutManager;
        View snapView;
        RecyclerView recyclerView = this.f678a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (snapView = g(layoutManager)) == null) {
            return;
        }
        int[] snapDistance = c(layoutManager, snapView);
        if (snapDistance[0] != 0 || snapDistance[1] != 0) {
            this.f678a.k1(snapDistance[0], snapDistance[1]);
        }
    }

    public RecyclerView.y d(RecyclerView.o layoutManager) {
        return e(layoutManager);
    }
}
