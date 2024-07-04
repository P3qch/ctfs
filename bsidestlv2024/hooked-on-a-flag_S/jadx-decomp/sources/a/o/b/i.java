package a.o.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.o f676a;

    /* renamed from: b, reason: collision with root package name */
    public int f677b;
    public final Rect c;

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i);

    public /* synthetic */ i(RecyclerView.o x0, a x1) {
        this(x0);
    }

    public i(RecyclerView.o layoutManager) {
        this.f677b = Integer.MIN_VALUE;
        this.c = new Rect();
        this.f676a = layoutManager;
    }

    public void s() {
        this.f677b = n();
    }

    public int o() {
        if (Integer.MIN_VALUE == this.f677b) {
            return 0;
        }
        return n() - this.f677b;
    }

    public static i b(RecyclerView.o layoutManager, int orientation) {
        switch (orientation) {
            case 0:
                return a(layoutManager);
            case 1:
                return c(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    /* loaded from: classes.dex */
    public static class a extends i {
        public a(RecyclerView.o layoutManager) {
            super(layoutManager, null);
        }

        @Override // a.o.b.i
        public int i() {
            return this.f676a.o0() - this.f676a.f0();
        }

        @Override // a.o.b.i
        public int h() {
            return this.f676a.o0();
        }

        @Override // a.o.b.i
        public void r(int amount) {
            this.f676a.C0(amount);
        }

        @Override // a.o.b.i
        public int m() {
            return this.f676a.e0();
        }

        @Override // a.o.b.i
        public int e(View view) {
            RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
            return this.f676a.S(view) + ((ViewGroup.MarginLayoutParams) params).leftMargin + ((ViewGroup.MarginLayoutParams) params).rightMargin;
        }

        @Override // a.o.b.i
        public int f(View view) {
            RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
            return this.f676a.R(view) + ((ViewGroup.MarginLayoutParams) params).topMargin + ((ViewGroup.MarginLayoutParams) params).bottomMargin;
        }

        @Override // a.o.b.i
        public int d(View view) {
            RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
            return this.f676a.T(view) + ((ViewGroup.MarginLayoutParams) params).rightMargin;
        }

        @Override // a.o.b.i
        public int g(View view) {
            RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
            return this.f676a.Q(view) - ((ViewGroup.MarginLayoutParams) params).leftMargin;
        }

        @Override // a.o.b.i
        public int p(View view) {
            this.f676a.n0(view, true, this.c);
            return this.c.right;
        }

        @Override // a.o.b.i
        public int q(View view) {
            this.f676a.n0(view, true, this.c);
            return this.c.left;
        }

        @Override // a.o.b.i
        public int n() {
            return (this.f676a.o0() - this.f676a.e0()) - this.f676a.f0();
        }

        @Override // a.o.b.i
        public int j() {
            return this.f676a.f0();
        }

        @Override // a.o.b.i
        public int k() {
            return this.f676a.p0();
        }

        @Override // a.o.b.i
        public int l() {
            return this.f676a.X();
        }
    }

    public static i a(RecyclerView.o layoutManager) {
        return new a(layoutManager);
    }

    /* loaded from: classes.dex */
    public static class b extends i {
        public b(RecyclerView.o layoutManager) {
            super(layoutManager, null);
        }

        @Override // a.o.b.i
        public int i() {
            return this.f676a.W() - this.f676a.d0();
        }

        @Override // a.o.b.i
        public int h() {
            return this.f676a.W();
        }

        @Override // a.o.b.i
        public void r(int amount) {
            this.f676a.D0(amount);
        }

        @Override // a.o.b.i
        public int m() {
            return this.f676a.g0();
        }

        @Override // a.o.b.i
        public int e(View view) {
            RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
            return this.f676a.R(view) + ((ViewGroup.MarginLayoutParams) params).topMargin + ((ViewGroup.MarginLayoutParams) params).bottomMargin;
        }

        @Override // a.o.b.i
        public int f(View view) {
            RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
            return this.f676a.S(view) + ((ViewGroup.MarginLayoutParams) params).leftMargin + ((ViewGroup.MarginLayoutParams) params).rightMargin;
        }

        @Override // a.o.b.i
        public int d(View view) {
            RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
            return this.f676a.O(view) + ((ViewGroup.MarginLayoutParams) params).bottomMargin;
        }

        @Override // a.o.b.i
        public int g(View view) {
            RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
            return this.f676a.U(view) - ((ViewGroup.MarginLayoutParams) params).topMargin;
        }

        @Override // a.o.b.i
        public int p(View view) {
            this.f676a.n0(view, true, this.c);
            return this.c.bottom;
        }

        @Override // a.o.b.i
        public int q(View view) {
            this.f676a.n0(view, true, this.c);
            return this.c.top;
        }

        @Override // a.o.b.i
        public int n() {
            return (this.f676a.W() - this.f676a.g0()) - this.f676a.d0();
        }

        @Override // a.o.b.i
        public int j() {
            return this.f676a.d0();
        }

        @Override // a.o.b.i
        public int k() {
            return this.f676a.X();
        }

        @Override // a.o.b.i
        public int l() {
            return this.f676a.p0();
        }
    }

    public static i c(RecyclerView.o layoutManager) {
        return new b(layoutManager);
    }
}
