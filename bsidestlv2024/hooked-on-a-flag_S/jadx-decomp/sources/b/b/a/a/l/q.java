package b.b.a.a.l;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class q extends LinearLayoutManager {
    public q(Context context, int orientation, boolean reverseLayout) {
        super(orientation, reverseLayout);
    }

    /* loaded from: classes.dex */
    public class a extends a.o.b.g {
        public a(q this$0, Context x0) {
            super(x0);
        }

        @Override // a.o.b.g
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.z state, int position) {
        a.o.b.g linearSmoothScroller = new a(this, recyclerView.getContext());
        linearSmoothScroller.p(position);
        J1(linearSmoothScroller);
    }
}
