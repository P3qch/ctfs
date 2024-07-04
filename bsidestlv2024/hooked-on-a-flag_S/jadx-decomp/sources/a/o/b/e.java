package a.o.b;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<e> f668b = new ThreadLocal<>();
    public static Comparator<c> c = new a();
    public long e;
    public long f;
    public ArrayList<RecyclerView> d = new ArrayList<>();
    public ArrayList<c> g = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f671a;

        /* renamed from: b, reason: collision with root package name */
        public int f672b;
        public int c;
        public RecyclerView d;
        public int e;

        public void a() {
            this.f671a = false;
            this.f672b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.o.c {

        /* renamed from: a, reason: collision with root package name */
        public int f669a;

        /* renamed from: b, reason: collision with root package name */
        public int f670b;
        public int[] c;
        public int d;

        public void e(int dx, int dy) {
            this.f669a = dx;
            this.f670b = dy;
        }

        public void c(RecyclerView view, boolean nested) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o layout = view.u;
            if (view.t != null && layout != null && layout.u0()) {
                if (nested) {
                    if (!view.m.n()) {
                        layout.p(view.t.c(), this);
                    }
                } else if (!view.l0()) {
                    layout.o(this.f669a, this.f670b, view.o0, this);
                }
                int i = this.d;
                if (i > layout.m) {
                    layout.m = i;
                    layout.n = nested;
                    view.k.K();
                }
            }
        }

        public void a(int layoutPosition, int pixelDistance) {
            if (layoutPosition < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (pixelDistance < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int storagePosition = this.d * 2;
            int[] iArr = this.c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (storagePosition >= iArr.length) {
                int[] oldArray = this.c;
                int[] iArr3 = new int[storagePosition * 2];
                this.c = iArr3;
                System.arraycopy(oldArray, 0, iArr3, 0, oldArray.length);
            }
            int[] oldArray2 = this.c;
            oldArray2[storagePosition] = layoutPosition;
            oldArray2[storagePosition + 1] = pixelDistance;
            this.d++;
        }

        public boolean d(int position) {
            if (this.c != null) {
                int count = this.d * 2;
                for (int i = 0; i < count; i += 2) {
                    if (this.c[i] == position) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        public void b() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.d.add(recyclerView);
    }

    public void j(RecyclerView recyclerView) {
        this.d.remove(recyclerView);
    }

    public void f(RecyclerView recyclerView, int prefetchDx, int prefetchDy) {
        if (recyclerView.isAttachedToWindow() && this.e == 0) {
            this.e = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.n0.e(prefetchDx, prefetchDy);
    }

    /* loaded from: classes.dex */
    public static class a implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c lhs, c rhs) {
            RecyclerView recyclerView = lhs.d;
            if ((recyclerView == null) != (rhs.d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = lhs.f671a;
            if (z != rhs.f671a) {
                return z ? -1 : 1;
            }
            int deltaViewVelocity = rhs.f672b - lhs.f672b;
            if (deltaViewVelocity != 0) {
                return deltaViewVelocity;
            }
            int deltaDistanceToItem = lhs.c - rhs.c;
            if (deltaDistanceToItem != 0) {
                return deltaDistanceToItem;
            }
            return 0;
        }
    }

    public final void b() {
        c task;
        int viewCount = this.d.size();
        int totalTaskCount = 0;
        for (int i = 0; i < viewCount; i++) {
            RecyclerView view = this.d.get(i);
            if (view.getWindowVisibility() == 0) {
                view.n0.c(view, false);
                totalTaskCount += view.n0.d;
            }
        }
        this.g.ensureCapacity(totalTaskCount);
        int totalTaskIndex = 0;
        for (int i2 = 0; i2 < viewCount; i2++) {
            RecyclerView view2 = this.d.get(i2);
            if (view2.getWindowVisibility() == 0) {
                b prefetchRegistry = view2.n0;
                int viewVelocity = Math.abs(prefetchRegistry.f669a) + Math.abs(prefetchRegistry.f670b);
                for (int j = 0; j < prefetchRegistry.d * 2; j += 2) {
                    if (totalTaskIndex >= this.g.size()) {
                        task = new c();
                        this.g.add(task);
                    } else {
                        task = this.g.get(totalTaskIndex);
                    }
                    int[] iArr = prefetchRegistry.c;
                    int distanceToItem = iArr[j + 1];
                    task.f671a = distanceToItem <= viewVelocity;
                    task.f672b = viewVelocity;
                    task.c = distanceToItem;
                    task.d = view2;
                    task.e = iArr[j];
                    totalTaskIndex++;
                }
            }
        }
        Collections.sort(this.g, c);
    }

    public static boolean e(RecyclerView view, int position) {
        int childCount = view.n.j();
        for (int i = 0; i < childCount; i++) {
            View attachedView = view.n.i(i);
            RecyclerView.c0 holder = RecyclerView.f0(attachedView);
            if (holder.d == position && !holder.t()) {
                return true;
            }
        }
        return false;
    }

    public final RecyclerView.c0 i(RecyclerView view, int position, long deadlineNs) {
        if (e(view, position)) {
            return null;
        }
        RecyclerView.u recycler = view.k;
        try {
            view.F0();
            RecyclerView.c0 holder = recycler.I(position, false, deadlineNs);
            if (holder != null) {
                if (holder.s() && !holder.t()) {
                    recycler.B(holder.f889b);
                } else {
                    recycler.a(holder, false);
                }
            }
            return holder;
        } finally {
            view.H0(false);
        }
    }

    public final void h(RecyclerView innerView, long deadlineNs) {
        if (innerView == null) {
            return;
        }
        if (innerView.K && innerView.n.j() != 0) {
            innerView.T0();
        }
        b innerPrefetchRegistry = innerView.n0;
        innerPrefetchRegistry.c(innerView, true);
        if (innerPrefetchRegistry.d != 0) {
            try {
                a.h.g.c.a("RV Nested Prefetch");
                innerView.o0.f(innerView.t);
                for (int i = 0; i < innerPrefetchRegistry.d * 2; i += 2) {
                    int innerPosition = innerPrefetchRegistry.c[i];
                    i(innerView, innerPosition, deadlineNs);
                }
            } finally {
                a.h.g.c.b();
            }
        }
    }

    public final void c(c task, long deadlineNs) {
        long taskDeadlineNs = task.f671a ? Long.MAX_VALUE : deadlineNs;
        RecyclerView.c0 holder = i(task.d, task.e, taskDeadlineNs);
        if (holder != null && holder.c != null && holder.s() && !holder.t()) {
            h(holder.c.get(), deadlineNs);
        }
    }

    public final void d(long deadlineNs) {
        for (int i = 0; i < this.g.size(); i++) {
            c task = this.g.get(i);
            if (task.d != null) {
                c(task, deadlineNs);
                task.a();
            } else {
                return;
            }
        }
    }

    public void g(long deadlineNs) {
        b();
        d(deadlineNs);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a.h.g.c.a("RV Prefetch");
            if (this.d.isEmpty()) {
                return;
            }
            int size = this.d.size();
            long latestFrameVsyncMs = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView view = this.d.get(i);
                if (view.getWindowVisibility() == 0) {
                    latestFrameVsyncMs = Math.max(view.getDrawingTime(), latestFrameVsyncMs);
                }
            }
            if (latestFrameVsyncMs == 0) {
                return;
            }
            long nextFrameNs = TimeUnit.MILLISECONDS.toNanos(latestFrameVsyncMs) + this.f;
            g(nextFrameNs);
        } finally {
            this.e = 0L;
            a.h.g.c.b();
        }
    }
}
