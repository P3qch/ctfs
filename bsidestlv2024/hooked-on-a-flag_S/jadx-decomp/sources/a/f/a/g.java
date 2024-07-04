package a.f.a;

import a.f.a.b;
import java.util.Arrays;
import java.util.Comparator;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public class g extends a.f.a.b {
    public int f;
    public h[] g;
    public h[] h;
    public int i;
    public b j;

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public h f264a;

        public b(g row) {
        }

        public void b(h variable) {
            this.f264a = variable;
        }

        public boolean a(h other, float value) {
            if (this.f264a.c) {
                boolean empty = true;
                for (int i = 0; i < 9; i++) {
                    float[] fArr = this.f264a.k;
                    fArr[i] = fArr[i] + (other.k[i] * value);
                    if (Math.abs(fArr[i]) < 1.0E-4f) {
                        this.f264a.k[i] = 0.0f;
                    } else {
                        empty = false;
                    }
                }
                if (empty) {
                    g.this.G(this.f264a);
                    return false;
                }
                return false;
            }
            for (int i2 = 0; i2 < 9; i2++) {
                float strength = other.k[i2];
                if (strength != 0.0f) {
                    float v = value * strength;
                    if (Math.abs(v) < 1.0E-4f) {
                        v = 0.0f;
                    }
                    this.f264a.k[i2] = v;
                } else {
                    this.f264a.k[i2] = 0.0f;
                }
            }
            return true;
        }

        public final boolean c() {
            for (int i = 8; i >= 0; i--) {
                float value = this.f264a.k[i];
                if (value > 0.0f) {
                    return false;
                }
                if (value < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(h other) {
            for (int i = 8; i >= 0; i--) {
                float comparedValue = other.k[i];
                float value = this.f264a.k[i];
                if (value != comparedValue) {
                    return value < comparedValue;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f264a.k, 0.0f);
        }

        public String toString() {
            String result = "[ ";
            if (this.f264a != null) {
                for (int i = 0; i < 9; i++) {
                    result = result + this.f264a.k[i] + " ";
                }
            }
            return result + "] " + this.f264a;
        }
    }

    @Override // a.f.a.b, a.f.a.d.a
    public void clear() {
        this.i = 0;
        this.f257b = 0.0f;
    }

    public g(c cache) {
        super(cache);
        this.f = 128;
        this.g = new h[128];
        this.h = new h[128];
        this.i = 0;
        this.j = new b(this);
    }

    @Override // a.f.a.b, a.f.a.d.a
    public boolean isEmpty() {
        return this.i == 0;
    }

    @Override // a.f.a.b, a.f.a.d.a
    public h a(d system, boolean[] avoid) {
        int pivot = -1;
        for (int i = 0; i < this.i; i++) {
            h variable = this.g[i];
            if (!avoid[variable.e]) {
                this.j.b(variable);
                if (pivot == -1) {
                    if (this.j.c()) {
                        pivot = i;
                    }
                } else if (this.j.d(this.g[pivot])) {
                    pivot = i;
                }
            }
        }
        if (pivot == -1) {
            return null;
        }
        return this.g[pivot];
    }

    @Override // a.f.a.b, a.f.a.d.a
    public void b(h error) {
        this.j.b(error);
        this.j.e();
        error.k[error.g] = 1.0f;
        F(error);
    }

    public final void F(h variable) {
        int i;
        int i2 = this.i + 1;
        h[] hVarArr = this.g;
        if (i2 > hVarArr.length) {
            h[] hVarArr2 = (h[]) Arrays.copyOf(hVarArr, hVarArr.length * 2);
            this.g = hVarArr2;
            this.h = (h[]) Arrays.copyOf(hVarArr2, hVarArr2.length * 2);
        }
        h[] hVarArr3 = this.g;
        int i3 = this.i;
        hVarArr3[i3] = variable;
        int i4 = i3 + 1;
        this.i = i4;
        if (i4 > 1 && hVarArr3[i4 - 1].e > variable.e) {
            int i5 = 0;
            while (true) {
                i = this.i;
                if (i5 >= i) {
                    break;
                }
                this.h[i5] = this.g[i5];
                i5++;
            }
            Arrays.sort(this.h, 0, i, new a(this));
            for (int i6 = 0; i6 < this.i; i6++) {
                this.g[i6] = this.h[i6];
            }
        }
        variable.c = true;
        variable.a(this);
    }

    /* loaded from: classes.dex */
    public class a implements Comparator<h> {
        public a(g this$0) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h variable1, h variable2) {
            return variable1.e - variable2.e;
        }
    }

    public final void G(h variable) {
        for (int i = 0; i < this.i; i++) {
            if (this.g[i] == variable) {
                int j = i;
                while (true) {
                    int i2 = this.i;
                    if (j < i2 - 1) {
                        h[] hVarArr = this.g;
                        hVarArr[j] = hVarArr[j + 1];
                        j++;
                    } else {
                        this.i = i2 - 1;
                        variable.c = false;
                        return;
                    }
                }
            }
        }
    }

    @Override // a.f.a.b
    public void C(d system, a.f.a.b definition, boolean removeFromDefinition) {
        h goalVariable = definition.f256a;
        if (goalVariable == null) {
            return;
        }
        b.a rowVariables = definition.d;
        int currentSize = rowVariables.k();
        for (int i = 0; i < currentSize; i++) {
            h solverVariable = rowVariables.d(i);
            float value = rowVariables.a(i);
            this.j.b(solverVariable);
            if (this.j.a(goalVariable, value)) {
                F(solverVariable);
            }
            this.f257b += definition.f257b * value;
        }
        G(goalVariable);
    }

    @Override // a.f.a.b
    public String toString() {
        String result = BuildConfig.FLAVOR + " goal -> (" + this.f257b + ") : ";
        for (int i = 0; i < this.i; i++) {
            h v = this.g[i];
            this.j.b(v);
            result = result + this.j + " ";
        }
        return result;
    }
}
