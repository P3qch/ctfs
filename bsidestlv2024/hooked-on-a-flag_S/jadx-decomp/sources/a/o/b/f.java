package a.o.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    public int f674b;
    public int c;
    public int d;
    public int e;
    public boolean h;
    public boolean i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f673a = true;
    public int f = 0;
    public int g = 0;

    public boolean a(RecyclerView.z state) {
        int i = this.c;
        return i >= 0 && i < state.b();
    }

    public View b(RecyclerView.u recycler) {
        View view = recycler.o(this.c);
        this.c += this.d;
        return view;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f674b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
