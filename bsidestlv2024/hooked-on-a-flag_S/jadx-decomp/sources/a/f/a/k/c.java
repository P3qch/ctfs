package a.f.a.k;

import a.f.a.k.e;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public e f270a;

    /* renamed from: b, reason: collision with root package name */
    public e f271b;
    public e c;
    public e d;
    public e e;
    public e f;
    public e g;
    public ArrayList<e> h;
    public int i;
    public int j;
    public float k = 0.0f;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;

    public c(e first, int orientation, boolean isRtl) {
        this.p = false;
        this.f270a = first;
        this.o = orientation;
        this.p = isRtl;
    }

    public static boolean c(e widget, int orientation) {
        if (widget.O() != 8 && widget.W[orientation] == e.a.MATCH_CONSTRAINT) {
            int[] iArr = widget.v;
            if (iArr[orientation] == 0 || iArr[orientation] == 3) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        e next;
        int offset = this.o * 2;
        e lastVisited = this.f270a;
        e widget = this.f270a;
        e eVar = this.f270a;
        boolean done = false;
        while (true) {
            if (done) {
                break;
            }
            this.i++;
            e[] eVarArr = widget.r0;
            int i = this.o;
            eVarArr[i] = null;
            widget.q0[i] = null;
            if (widget.O() != 8) {
                this.l++;
                e.a q = widget.q(this.o);
                e.a aVar = e.a.MATCH_CONSTRAINT;
                if (q != aVar) {
                    this.m += widget.A(this.o);
                }
                int e = this.m + widget.T[offset].e();
                this.m = e;
                this.m = e + widget.T[offset + 1].e();
                int e2 = this.n + widget.T[offset].e();
                this.n = e2;
                this.n = e2 + widget.T[offset + 1].e();
                if (this.f271b == null) {
                    this.f271b = widget;
                }
                this.d = widget;
                e.a[] aVarArr = widget.W;
                int i2 = this.o;
                if (aVarArr[i2] == aVar) {
                    int[] iArr = widget.v;
                    if (iArr[i2] == 0 || iArr[i2] == 3 || iArr[i2] == 2) {
                        this.j++;
                        float[] fArr = widget.p0;
                        float weight = fArr[i2];
                        if (weight > 0.0f) {
                            this.k += fArr[i2];
                        }
                        if (c(widget, i2)) {
                            if (weight < 0.0f) {
                                this.q = true;
                            } else {
                                this.r = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList<>();
                            }
                            this.h.add(widget);
                        }
                        if (this.f == null) {
                            this.f = widget;
                        }
                        e eVar2 = this.g;
                        if (eVar2 != null) {
                            eVar2.q0[this.o] = widget;
                        }
                        this.g = widget;
                    }
                    if (this.o != 0 ? widget.u == 0 && widget.z == 0 && widget.A != 0 : widget.t == 0 && widget.w == 0 && widget.x != 0) {
                    }
                    if (widget.a0 != 0.0f) {
                    }
                }
            }
            if (lastVisited != widget) {
                lastVisited.r0[this.o] = widget;
            }
            lastVisited = widget;
            d nextAnchor = widget.T[offset + 1].f;
            if (nextAnchor != null) {
                next = nextAnchor.d;
                d[] dVarArr = next.T;
                if (dVarArr[offset].f == null || dVarArr[offset].f.d != widget) {
                    next = null;
                }
            } else {
                next = null;
            }
            if (next != null) {
                widget = next;
            } else {
                done = true;
            }
        }
        e eVar3 = this.f271b;
        if (eVar3 != null) {
            this.m -= eVar3.T[offset].e();
        }
        e eVar4 = this.d;
        if (eVar4 != null) {
            this.m -= eVar4.T[offset + 1].e();
        }
        this.c = widget;
        if (this.o == 0 && this.p) {
            this.e = widget;
        } else {
            this.e = this.f270a;
        }
        this.s = this.r && this.q;
    }

    public void a() {
        if (!this.t) {
            b();
        }
        this.t = true;
    }
}
