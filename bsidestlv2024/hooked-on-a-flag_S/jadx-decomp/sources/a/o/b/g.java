package a.o.b;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import net.sqlcipher.database.SQLiteCursor;

/* loaded from: classes.dex */
public class g extends RecyclerView.y {
    public PointF k;
    public final DisplayMetrics l;
    public float n;
    public final LinearInterpolator i = new LinearInterpolator();
    public final DecelerateInterpolator j = new DecelerateInterpolator();
    public boolean m = false;
    public int o = 0;
    public int p = 0;

    public g(Context context) {
        this.l = context.getResources().getDisplayMetrics();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void o(View targetView, RecyclerView.z state, RecyclerView.y.a action) {
        int dx = t(targetView, z());
        int dy = u(targetView, B());
        int distance = (int) Math.sqrt((dx * dx) + (dy * dy));
        int time = w(distance);
        if (time > 0) {
            action.d(-dx, -dy, time, this.j);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void l(int dx, int dy, RecyclerView.z state, RecyclerView.y.a action) {
        if (c() == 0) {
            r();
            return;
        }
        this.o = y(this.o, dx);
        int y = y(this.p, dy);
        this.p = y;
        if (this.o == 0 && y == 0) {
            C(action);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void n() {
        this.p = 0;
        this.o = 0;
        this.k = null;
    }

    public float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public final float A() {
        if (!this.m) {
            this.n = v(this.l);
            this.m = true;
        }
        return this.n;
    }

    public int w(int dx) {
        double x = x(dx);
        Double.isNaN(x);
        return (int) Math.ceil(x / 0.3356d);
    }

    public int x(int dx) {
        return (int) Math.ceil(Math.abs(dx) * A());
    }

    public int z() {
        PointF pointF = this.k;
        if (pointF != null) {
            float f = pointF.x;
            if (f != 0.0f) {
                return f > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public int B() {
        PointF pointF = this.k;
        if (pointF != null) {
            float f = pointF.y;
            if (f != 0.0f) {
                return f > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public void C(RecyclerView.y.a action) {
        PointF scrollVector = a(f());
        if (scrollVector == null || (scrollVector.x == 0.0f && scrollVector.y == 0.0f)) {
            int target = f();
            action.b(target);
            r();
        } else {
            i(scrollVector);
            this.k = scrollVector;
            this.o = (int) (scrollVector.x * 10000.0f);
            this.p = (int) (scrollVector.y * 10000.0f);
            int time = x(10000);
            action.d((int) (this.o * 1.2f), (int) (this.p * 1.2f), (int) (time * 1.2f), this.i);
        }
    }

    public final int y(int tmpDt, int dt) {
        int tmpDt2 = tmpDt - dt;
        if (tmpDt * tmpDt2 <= 0) {
            return 0;
        }
        return tmpDt2;
    }

    public int s(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
        switch (snapPreference) {
            case SQLiteCursor.NO_COUNT /* -1 */:
                return boxStart - viewStart;
            case 0:
                int dtStart = boxStart - viewStart;
                if (dtStart > 0) {
                    return dtStart;
                }
                int dtEnd = boxEnd - viewEnd;
                if (dtEnd < 0) {
                    return dtEnd;
                }
                return 0;
            case 1:
                return boxEnd - viewEnd;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int u(View view, int snapPreference) {
        RecyclerView.o layoutManager = e();
        if (layoutManager == null || !layoutManager.l()) {
            return 0;
        }
        RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
        int top = layoutManager.U(view) - ((ViewGroup.MarginLayoutParams) params).topMargin;
        int bottom = layoutManager.O(view) + ((ViewGroup.MarginLayoutParams) params).bottomMargin;
        int start = layoutManager.g0();
        int end = layoutManager.W() - layoutManager.d0();
        return s(top, bottom, start, end, snapPreference);
    }

    public int t(View view, int snapPreference) {
        RecyclerView.o layoutManager = e();
        if (layoutManager == null || !layoutManager.k()) {
            return 0;
        }
        RecyclerView.p params = (RecyclerView.p) view.getLayoutParams();
        int left = layoutManager.Q(view) - ((ViewGroup.MarginLayoutParams) params).leftMargin;
        int right = layoutManager.T(view) + ((ViewGroup.MarginLayoutParams) params).rightMargin;
        int start = layoutManager.e0();
        int end = layoutManager.o0() - layoutManager.f0();
        return s(left, right, start, end, snapPreference);
    }
}
