package a.b.g;

/* loaded from: classes.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    public int f180a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f181b = 0;
    public int c = Integer.MIN_VALUE;
    public int d = Integer.MIN_VALUE;
    public int e = 0;
    public int f = 0;
    public boolean g = false;
    public boolean h = false;

    public int b() {
        return this.f180a;
    }

    public int c() {
        return this.f181b;
    }

    public int d() {
        return this.g ? this.f181b : this.f180a;
    }

    public int a() {
        return this.g ? this.f180a : this.f181b;
    }

    public void g(int start, int end) {
        this.c = start;
        this.d = end;
        this.h = true;
        if (this.g) {
            if (end != Integer.MIN_VALUE) {
                this.f180a = end;
            }
            if (start != Integer.MIN_VALUE) {
                this.f181b = start;
                return;
            }
            return;
        }
        if (start != Integer.MIN_VALUE) {
            this.f180a = start;
        }
        if (end != Integer.MIN_VALUE) {
            this.f181b = end;
        }
    }

    public void e(int left, int right) {
        this.h = false;
        if (left != Integer.MIN_VALUE) {
            this.e = left;
            this.f180a = left;
        }
        if (right != Integer.MIN_VALUE) {
            this.f = right;
            this.f181b = right;
        }
    }

    public void f(boolean isRtl) {
        if (isRtl == this.g) {
            return;
        }
        this.g = isRtl;
        if (!this.h) {
            this.f180a = this.e;
            this.f181b = this.f;
            return;
        }
        if (isRtl) {
            int i = this.d;
            if (i == Integer.MIN_VALUE) {
                i = this.e;
            }
            this.f180a = i;
            int i2 = this.c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f;
            }
            this.f181b = i2;
            return;
        }
        int i3 = this.c;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.e;
        }
        this.f180a = i3;
        int i4 = this.d;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f;
        }
        this.f181b = i4;
    }
}
