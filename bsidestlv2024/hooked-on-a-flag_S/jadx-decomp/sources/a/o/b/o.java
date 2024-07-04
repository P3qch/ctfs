package a.o.b;

import android.view.View;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final b f682a;

    /* renamed from: b, reason: collision with root package name */
    public a f683b = new a();

    /* loaded from: classes.dex */
    public interface b {
        int a();

        int b();

        int c(View view);

        int d(View view);

        View e(int i);
    }

    public o(b callback) {
        this.f682a = callback;
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f684a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f685b;
        public int c;
        public int d;
        public int e;

        public void e(int rvStart, int rvEnd, int childStart, int childEnd) {
            this.f685b = rvStart;
            this.c = rvEnd;
            this.d = childStart;
            this.e = childEnd;
        }

        public void a(int flags) {
            this.f684a |= flags;
        }

        public void d() {
            this.f684a = 0;
        }

        public int c(int x, int y) {
            if (x > y) {
                return 1;
            }
            if (x == y) {
                return 2;
            }
            return 4;
        }

        public boolean b() {
            int i = this.f684a;
            if ((i & 7) != 0 && (i & (c(this.d, this.f685b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f684a;
            if ((i2 & 112) != 0 && (i2 & (c(this.d, this.c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f684a;
            if ((i3 & 1792) != 0 && (i3 & (c(this.e, this.f685b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f684a;
            return (i4 & 28672) == 0 || (i4 & (c(this.e, this.c) << 12)) != 0;
        }
    }

    public View a(int fromIndex, int toIndex, int preferredBoundFlags, int acceptableBoundFlags) {
        int start = this.f682a.b();
        int end = this.f682a.a();
        int next = toIndex > fromIndex ? 1 : -1;
        View acceptableMatch = null;
        for (int i = fromIndex; i != toIndex; i += next) {
            View child = this.f682a.e(i);
            int childStart = this.f682a.d(child);
            int childEnd = this.f682a.c(child);
            this.f683b.e(start, end, childStart, childEnd);
            if (preferredBoundFlags != 0) {
                this.f683b.d();
                this.f683b.a(preferredBoundFlags);
                if (this.f683b.b()) {
                    return child;
                }
            }
            if (acceptableBoundFlags != 0) {
                this.f683b.d();
                this.f683b.a(acceptableBoundFlags);
                if (this.f683b.b()) {
                    acceptableMatch = child;
                }
            }
        }
        return acceptableMatch;
    }

    public boolean b(View child, int boundsFlags) {
        this.f683b.e(this.f682a.b(), this.f682a.a(), this.f682a.d(child), this.f682a.c(child));
        if (boundsFlags != 0) {
            this.f683b.d();
            this.f683b.a(boundsFlags);
            return this.f683b.b();
        }
        return false;
    }
}
