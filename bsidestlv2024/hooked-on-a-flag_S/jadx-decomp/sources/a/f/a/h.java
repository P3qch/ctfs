package a.f.a;

import java.util.Arrays;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public class h implements Comparable<h> {

    /* renamed from: b, reason: collision with root package name */
    public static int f266b = 1;
    public boolean c;
    public String d;
    public float h;
    public a l;
    public int e = -1;
    public int f = -1;
    public int g = 0;
    public boolean i = false;
    public float[] j = new float[9];
    public float[] k = new float[9];
    public b[] m = new b[16];
    public int n = 0;
    public int o = 0;
    public boolean p = false;
    public int q = -1;
    public float r = 0.0f;

    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public static void c() {
        f266b++;
    }

    public h(a type) {
        this.l = type;
    }

    public final void a(b row) {
        int i = 0;
        while (true) {
            int i2 = this.n;
            if (i < i2) {
                if (this.m[i] != row) {
                    i++;
                } else {
                    return;
                }
            } else {
                b[] bVarArr = this.m;
                if (i2 >= bVarArr.length) {
                    this.m = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.m;
                int i3 = this.n;
                bVarArr2[i3] = row;
                this.n = i3 + 1;
                return;
            }
        }
    }

    public final void d(b row) {
        int count = this.n;
        for (int i = 0; i < count; i++) {
            if (this.m[i] == row) {
                for (int j = i; j < count - 1; j++) {
                    b[] bVarArr = this.m;
                    bVarArr[j] = bVarArr[j + 1];
                }
                int j2 = this.n;
                this.n = j2 - 1;
                return;
            }
        }
    }

    public final void h(d system, b definition) {
        int count = this.n;
        for (int i = 0; i < count; i++) {
            this.m[i].C(system, definition, false);
        }
        this.n = 0;
    }

    public void f(d system, float value) {
        this.h = value;
        this.i = true;
        this.p = false;
        this.q = -1;
        this.r = 0.0f;
        int count = this.n;
        this.f = -1;
        for (int i = 0; i < count; i++) {
            this.m[i].B(system, this, false);
        }
        this.n = 0;
    }

    public void e() {
        this.d = null;
        this.l = a.UNKNOWN;
        this.g = 0;
        this.e = -1;
        this.f = -1;
        this.h = 0.0f;
        this.i = false;
        this.p = false;
        this.q = -1;
        this.r = 0.0f;
        int count = this.n;
        for (int i = 0; i < count; i++) {
            this.m[i] = null;
        }
        this.n = 0;
        this.o = 0;
        this.c = false;
        Arrays.fill(this.k, 0.0f);
    }

    public void g(a type) {
        this.l = type;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(h v) {
        return this.e - v.e;
    }

    public String toString() {
        String result = BuildConfig.FLAVOR + this.e;
        return result;
    }
}
