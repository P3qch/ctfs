package a.o.b;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class j extends n {
    public i c;
    public i d;

    @Override // a.o.b.n
    public int[] c(RecyclerView.o layoutManager, View targetView) {
        int[] out = new int[2];
        if (layoutManager.k()) {
            out[0] = l(targetView, n(layoutManager));
        } else {
            out[0] = 0;
        }
        if (layoutManager.l()) {
            out[1] = l(targetView, p(layoutManager));
        } else {
            out[1] = 0;
        }
        return out;
    }

    @Override // a.o.b.n
    public View g(RecyclerView.o layoutManager) {
        if (layoutManager.l()) {
            return m(layoutManager, p(layoutManager));
        }
        if (layoutManager.k()) {
            return m(layoutManager, n(layoutManager));
        }
        return null;
    }

    @Override // a.o.b.n
    public int h(RecyclerView.o layoutManager, int velocityX, int velocityY) {
        i orientationHelper;
        int itemCount = layoutManager.Y();
        if (itemCount == 0 || (orientationHelper = o(layoutManager)) == null) {
            return -1;
        }
        View closestChildBeforeCenter = null;
        int distanceBefore = Integer.MIN_VALUE;
        View closestChildAfterCenter = null;
        int distanceAfter = Integer.MAX_VALUE;
        int childCount = layoutManager.J();
        for (int i = 0; i < childCount; i++) {
            View child = layoutManager.I(i);
            if (child != null) {
                int distance = l(child, orientationHelper);
                if (distance <= 0 && distance > distanceBefore) {
                    distanceBefore = distance;
                    closestChildBeforeCenter = child;
                }
                if (distance >= 0 && distance < distanceAfter) {
                    distanceAfter = distance;
                    closestChildAfterCenter = child;
                }
            }
        }
        boolean forwardDirection = q(layoutManager, velocityX, velocityY);
        if (forwardDirection && closestChildAfterCenter != null) {
            return layoutManager.h0(closestChildAfterCenter);
        }
        if (!forwardDirection && closestChildBeforeCenter != null) {
            return layoutManager.h0(closestChildBeforeCenter);
        }
        View visibleView = forwardDirection ? closestChildBeforeCenter : closestChildAfterCenter;
        if (visibleView == null) {
            return -1;
        }
        int visiblePosition = layoutManager.h0(visibleView);
        int snapToPosition = (r(layoutManager) == forwardDirection ? -1 : 1) + visiblePosition;
        if (snapToPosition < 0 || snapToPosition >= itemCount) {
            return -1;
        }
        return snapToPosition;
    }

    public final boolean q(RecyclerView.o layoutManager, int velocityX, int velocityY) {
        return layoutManager.k() ? velocityX > 0 : velocityY > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean r(RecyclerView.o oVar) {
        int itemCount = oVar.Y();
        if (oVar instanceof RecyclerView.y.b) {
            RecyclerView.y.b vectorProvider = (RecyclerView.y.b) oVar;
            PointF vectorForEnd = vectorProvider.a(itemCount - 1);
            if (vectorForEnd != null) {
                return vectorForEnd.x < 0.0f || vectorForEnd.y < 0.0f;
            }
        }
        return false;
    }

    @Override // a.o.b.n
    public g e(RecyclerView.o layoutManager) {
        if (!(layoutManager instanceof RecyclerView.y.b)) {
            return null;
        }
        return new a(this.f678a.getContext());
    }

    /* loaded from: classes.dex */
    public class a extends g {
        public a(Context context) {
            super(context);
        }

        @Override // a.o.b.g, androidx.recyclerview.widget.RecyclerView.y
        public void o(View targetView, RecyclerView.z state, RecyclerView.y.a action) {
            j jVar = j.this;
            int[] snapDistances = jVar.c(jVar.f678a.getLayoutManager(), targetView);
            int dx = snapDistances[0];
            int dy = snapDistances[1];
            int time = w(Math.max(Math.abs(dx), Math.abs(dy)));
            if (time > 0) {
                action.d(dx, dy, time, this.j);
            }
        }

        @Override // a.o.b.g
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // a.o.b.g
        public int x(int dx) {
            return Math.min(100, super.x(dx));
        }
    }

    public final int l(View targetView, i helper) {
        int childCenter = helper.g(targetView) + (helper.e(targetView) / 2);
        int containerCenter = helper.m() + (helper.n() / 2);
        return childCenter - containerCenter;
    }

    public final View m(RecyclerView.o layoutManager, i helper) {
        int childCount = layoutManager.J();
        if (childCount == 0) {
            return null;
        }
        View closestChild = null;
        int center = helper.m() + (helper.n() / 2);
        int absClosest = Integer.MAX_VALUE;
        for (int i = 0; i < childCount; i++) {
            View child = layoutManager.I(i);
            int childCenter = helper.g(child) + (helper.e(child) / 2);
            int absDistance = Math.abs(childCenter - center);
            if (absDistance < absClosest) {
                absClosest = absDistance;
                closestChild = child;
            }
        }
        return closestChild;
    }

    public final i o(RecyclerView.o layoutManager) {
        if (layoutManager.l()) {
            return p(layoutManager);
        }
        if (layoutManager.k()) {
            return n(layoutManager);
        }
        return null;
    }

    public final i p(RecyclerView.o layoutManager) {
        i iVar = this.c;
        if (iVar == null || iVar.f676a != layoutManager) {
            this.c = i.c(layoutManager);
        }
        return this.c;
    }

    public final i n(RecyclerView.o layoutManager) {
        i iVar = this.d;
        if (iVar == null || iVar.f676a != layoutManager) {
            this.d = i.a(layoutManager);
        }
        return this.d;
    }
}
