package a.b.d.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: b, reason: collision with root package name */
    public d f66b;
    public Rect c;
    public Drawable d;
    public Drawable e;
    public boolean g;
    public boolean i;
    public Runnable j;
    public long k;
    public long l;
    public c m;
    public int f = 255;
    public int h = -1;

    public d b() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f66b.getChangingConfigurations();
    }

    public final boolean e() {
        return isAutoMirrored() && a.h.d.l.a.f(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        boolean result;
        Rect r = this.f66b.l();
        if (r != null) {
            padding.set(r);
            result = (((r.left | r.top) | r.bottom) | r.right) != 0;
        } else {
            Drawable drawable = this.d;
            if (drawable != null) {
                result = drawable.getPadding(padding);
            } else {
                result = super.getPadding(padding);
            }
        }
        if (e()) {
            int left = padding.left;
            padding.left = padding.right;
            padding.right = left;
        }
        return result;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.d;
        if (drawable != null) {
            C0005b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (!this.g || this.f != alpha) {
            this.g = true;
            this.f = alpha;
            Drawable drawable = this.d;
            if (drawable != null) {
                if (this.k == 0) {
                    drawable.setAlpha(alpha);
                } else {
                    a(false);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean dither) {
        d dVar = this.f66b;
        if (dVar.x != dither) {
            dVar.x = dither;
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setDither(dither);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f66b;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
        d dVar = this.f66b;
        dVar.H = true;
        if (dVar.F != tint) {
            dVar.F = tint;
            a.h.d.l.a.o(this.d, tint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode tintMode) {
        d dVar = this.f66b;
        dVar.I = true;
        if (dVar.G != tintMode) {
            dVar.G = tintMode;
            a.h.d.l.a.p(this.d, tintMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        d dVar = this.f66b;
        if (dVar.C != mirrored) {
            dVar.C = mirrored;
            Drawable drawable = this.d;
            if (drawable != null) {
                a.h.d.l.a.j(drawable, mirrored);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f66b.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean changed = false;
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.e = null;
            changed = true;
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.g) {
                this.d.setAlpha(this.f);
            }
        }
        if (this.l != 0) {
            this.l = 0L;
            changed = true;
        }
        if (this.k != 0) {
            this.k = 0L;
            changed = true;
        }
        if (changed) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float x, float y) {
        Drawable drawable = this.d;
        if (drawable != null) {
            a.h.d.l.a.k(drawable, x, y);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        Rect rect = this.c;
        if (rect == null) {
            this.c = new Rect(left, top, right, bottom);
        } else {
            rect.set(left, top, right, bottom);
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            a.h.d.l.a.l(drawable, left, top, right, bottom);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect outRect) {
        Rect rect = this.c;
        if (rect != null) {
            outRect.set(rect);
        } else {
            super.getHotspotBounds(outRect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] state) {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.setState(state);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            return drawable2.setState(state);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.setLevel(level);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            return drawable2.setLevel(level);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int layoutDirection) {
        return this.f66b.w(layoutDirection, c());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f66b.q()) {
            return this.f66b.m();
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f66b.q()) {
            return this.f66b.i();
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f66b.q()) {
            return this.f66b.k();
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f66b.q()) {
            return this.f66b.j();
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        d dVar = this.f66b;
        if (dVar != null) {
            dVar.p();
        }
        if (who == this.d && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (who == this.d && getCallback() != null) {
            getCallback().scheduleDrawable(this, what, when);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (who == this.d && getCallback() != null) {
            getCallback().unscheduleDrawable(this, what);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setVisible(visible, restart);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setVisible(visible, restart);
        }
        return changed;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.d;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f66b.n();
    }

    public int c() {
        return this.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.h
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            a.b.d.a.b$d r0 = r9.f66b
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.e
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.d
            if (r0 == 0) goto L29
            r9.e = r0
            a.b.d.a.b$d r0 = r9.f66b
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.l = r0
            goto L35
        L29:
            r9.e = r4
            r9.l = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.d
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            a.b.d.a.b$d r0 = r9.f66b
            int r1 = r0.h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.d = r0
            r9.h = r10
            if (r0 == 0) goto L54
            a.b.d.a.b$d r1 = r9.f66b
            int r1 = r1.A
            if (r1 <= 0) goto L51
            long r7 = (long) r1
            long r7 = r7 + r2
            r9.k = r7
        L51:
            r9.d(r0)
        L54:
            goto L5a
        L55:
            r9.d = r4
            r0 = -1
            r9.h = r0
        L5a:
            long r0 = r9.k
            r4 = 1
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L67
            long r0 = r9.l
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.j
            if (r0 != 0) goto L73
            a.b.d.a.b$a r0 = new a.b.d.a.b$a
            r0.<init>()
            r9.j = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.a(r4)
        L79:
            r9.invalidateSelf()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.d.a.b.g(int):boolean");
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    public final void d(Drawable d2) {
        if (this.m == null) {
            this.m = new c();
        }
        c cVar = this.m;
        cVar.b(d2.getCallback());
        d2.setCallback(cVar);
        try {
            if (this.f66b.A <= 0 && this.g) {
                d2.setAlpha(this.f);
            }
            d dVar = this.f66b;
            if (dVar.E) {
                d2.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    a.h.d.l.a.o(d2, dVar.F);
                }
                d dVar2 = this.f66b;
                if (dVar2.I) {
                    a.h.d.l.a.p(d2, dVar2.G);
                }
            }
            d2.setVisible(isVisible(), true);
            d2.setDither(this.f66b.x);
            d2.setState(getState());
            d2.setLevel(getLevel());
            d2.setBounds(getBounds());
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                a.h.d.l.a.m(d2, a.h.d.l.a.f(this));
            }
            if (i >= 19) {
                a.h.d.l.a.j(d2, this.f66b.C);
            }
            Rect hotspotBounds = this.c;
            if (i >= 21 && hotspotBounds != null) {
                a.h.d.l.a.l(d2, hotspotBounds.left, hotspotBounds.top, hotspotBounds.right, hotspotBounds.bottom);
            }
        } finally {
            d2.setCallback(this.m.a());
        }
    }

    public void a(boolean schedule) {
        this.g = true;
        long now = SystemClock.uptimeMillis();
        boolean animating = false;
        Drawable drawable = this.d;
        if (drawable != null) {
            long j = this.k;
            if (j != 0) {
                if (j <= now) {
                    drawable.setAlpha(this.f);
                    this.k = 0L;
                } else {
                    int animAlpha = ((int) ((j - now) * 255)) / this.f66b.A;
                    drawable.setAlpha(((255 - animAlpha) * this.f) / 255);
                    animating = true;
                }
            }
        } else {
            this.k = 0L;
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            long j2 = this.l;
            if (j2 != 0) {
                if (j2 <= now) {
                    drawable2.setVisible(false, false);
                    this.e = null;
                    this.l = 0L;
                } else {
                    int animAlpha2 = ((int) ((j2 - now) * 255)) / this.f66b.B;
                    drawable2.setAlpha((this.f * animAlpha2) / 255);
                    animating = true;
                }
            }
        } else {
            this.l = 0L;
        }
        if (schedule && animating) {
            scheduleSelf(this.j, 16 + now);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.d;
    }

    public final void i(Resources res) {
        this.f66b.y(res);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f66b.b(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f66b.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f66b.c()) {
            this.f66b.d = getChangingConfigurations();
            return this.f66b;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.i && super.mutate() == this) {
            d clone = b();
            clone.r();
            h(clone);
            this.i = true;
        }
        return this;
    }

    /* loaded from: classes.dex */
    public static abstract class d extends Drawable.ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;

        /* renamed from: a, reason: collision with root package name */
        public final b f69a;

        /* renamed from: b, reason: collision with root package name */
        public Resources f70b;
        public int c;
        public int d;
        public int e;
        public SparseArray<Drawable.ConstantState> f;
        public Drawable[] g;
        public int h;
        public boolean i;
        public boolean j;
        public Rect k;
        public boolean l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public int z;

        public abstract void r();

        public d(d orig, b owner, Resources res) {
            Resources resources;
            this.i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.f69a = owner;
            if (res != null) {
                resources = res;
            } else {
                resources = orig != null ? orig.f70b : null;
            }
            this.f70b = resources;
            int f = b.f(res, orig != null ? orig.c : 0);
            this.c = f;
            if (orig != null) {
                this.d = orig.d;
                this.e = orig.e;
                this.v = true;
                this.w = true;
                this.i = orig.i;
                this.l = orig.l;
                this.x = orig.x;
                this.y = orig.y;
                this.z = orig.z;
                this.A = orig.A;
                this.B = orig.B;
                this.C = orig.C;
                this.D = orig.D;
                this.E = orig.E;
                this.F = orig.F;
                this.G = orig.G;
                this.H = orig.H;
                this.I = orig.I;
                if (orig.c == f) {
                    if (orig.j) {
                        this.k = orig.k != null ? new Rect(orig.k) : null;
                        this.j = true;
                    }
                    if (orig.m) {
                        this.n = orig.n;
                        this.o = orig.o;
                        this.p = orig.p;
                        this.q = orig.q;
                        this.m = true;
                    }
                }
                if (orig.r) {
                    this.s = orig.s;
                    this.r = true;
                }
                if (orig.t) {
                    this.u = orig.u;
                    this.t = true;
                }
                Drawable[] origDr = orig.g;
                this.g = new Drawable[origDr.length];
                this.h = orig.h;
                SparseArray<Drawable.ConstantState> origDf = orig.f;
                if (origDf != null) {
                    this.f = origDf.clone();
                } else {
                    this.f = new SparseArray<>(this.h);
                }
                int count = this.h;
                for (int i = 0; i < count; i++) {
                    if (origDr[i] != null) {
                        Drawable.ConstantState cs = origDr[i].getConstantState();
                        if (cs != null) {
                            this.f.put(i, cs);
                        } else {
                            this.g[i] = origDr[i];
                        }
                    }
                }
                return;
            }
            this.g = new Drawable[10];
            this.h = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.d | this.e;
        }

        public final int a(Drawable dr) {
            int pos = this.h;
            if (pos >= this.g.length) {
                o(pos, pos + 10);
            }
            dr.mutate();
            dr.setVisible(false, true);
            dr.setCallback(this.f69a);
            this.g[pos] = dr;
            this.h++;
            this.e |= dr.getChangingConfigurations();
            p();
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return pos;
        }

        public void p() {
            this.r = false;
            this.t = false;
        }

        public final int f() {
            return this.g.length;
        }

        public final void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray != null) {
                int futureCount = sparseArray.size();
                for (int keyIndex = 0; keyIndex < futureCount; keyIndex++) {
                    int index = this.f.keyAt(keyIndex);
                    Drawable.ConstantState cs = this.f.valueAt(keyIndex);
                    this.g[index] = s(cs.newDrawable(this.f70b));
                }
                this.f = null;
            }
        }

        public final Drawable s(Drawable child) {
            if (Build.VERSION.SDK_INT >= 23) {
                a.h.d.l.a.m(child, this.z);
            }
            Drawable child2 = child.mutate();
            child2.setCallback(this.f69a);
            return child2;
        }

        public final int h() {
            return this.h;
        }

        public final Drawable g(int index) {
            int keyIndex;
            Drawable result = this.g[index];
            if (result != null) {
                return result;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray == null || (keyIndex = sparseArray.indexOfKey(index)) < 0) {
                return null;
            }
            Drawable.ConstantState cs = this.f.valueAt(keyIndex);
            Drawable prepared = s(cs.newDrawable(this.f70b));
            this.g[index] = prepared;
            this.f.removeAt(keyIndex);
            if (this.f.size() == 0) {
                this.f = null;
            }
            return prepared;
        }

        public final boolean w(int layoutDirection, int currentIndex) {
            boolean changed = false;
            int count = this.h;
            Drawable[] drawables = this.g;
            for (int i = 0; i < count; i++) {
                if (drawables[i] != null) {
                    boolean childChanged = false;
                    if (Build.VERSION.SDK_INT >= 23) {
                        childChanged = a.h.d.l.a.m(drawables[i], layoutDirection);
                    }
                    if (i == currentIndex) {
                        changed = childChanged;
                    }
                }
            }
            this.z = layoutDirection;
            return changed;
        }

        public final void y(Resources res) {
            if (res != null) {
                this.f70b = res;
                int targetDensity = b.f(res, this.c);
                int sourceDensity = this.c;
                this.c = targetDensity;
                if (sourceDensity != targetDensity) {
                    this.m = false;
                    this.j = false;
                }
            }
        }

        public final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int count = this.h;
                Drawable[] drawables = this.g;
                for (int i = 0; i < count; i++) {
                    if (drawables[i] != null && a.h.d.l.a.b(drawables[i])) {
                        a.h.d.l.a.a(drawables[i], theme);
                        this.e |= drawables[i].getChangingConfigurations();
                    }
                }
                y(C0005b.c(theme));
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int count = this.h;
            Drawable[] drawables = this.g;
            for (int i = 0; i < count; i++) {
                Drawable d = drawables[i];
                if (d != null) {
                    if (a.h.d.l.a.b(d)) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState future = this.f.get(i);
                    if (future != null && C0005b.a(future)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final void x(boolean variable) {
            this.i = variable;
        }

        public final Rect l() {
            if (this.i) {
                return null;
            }
            Rect r = this.k;
            if (r != null || this.j) {
                return r;
            }
            e();
            Rect r2 = null;
            Rect t = new Rect();
            int count = this.h;
            Drawable[] drawables = this.g;
            for (int i = 0; i < count; i++) {
                if (drawables[i].getPadding(t)) {
                    if (r2 == null) {
                        r2 = new Rect(0, 0, 0, 0);
                    }
                    int i2 = t.left;
                    if (i2 > r2.left) {
                        r2.left = i2;
                    }
                    int i3 = t.top;
                    if (i3 > r2.top) {
                        r2.top = i3;
                    }
                    int i4 = t.right;
                    if (i4 > r2.right) {
                        r2.right = i4;
                    }
                    int i5 = t.bottom;
                    if (i5 > r2.bottom) {
                        r2.bottom = i5;
                    }
                }
            }
            this.j = true;
            this.k = r2;
            return r2;
        }

        public final void t(boolean constant) {
            this.l = constant;
        }

        public final boolean q() {
            return this.l;
        }

        public final int m() {
            if (!this.m) {
                d();
            }
            return this.n;
        }

        public final int i() {
            if (!this.m) {
                d();
            }
            return this.o;
        }

        public final int k() {
            if (!this.m) {
                d();
            }
            return this.p;
        }

        public final int j() {
            if (!this.m) {
                d();
            }
            return this.q;
        }

        public void d() {
            this.m = true;
            e();
            int count = this.h;
            Drawable[] drawables = this.g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i = 0; i < count; i++) {
                Drawable dr = drawables[i];
                int s = dr.getIntrinsicWidth();
                if (s > this.n) {
                    this.n = s;
                }
                int s2 = dr.getIntrinsicHeight();
                if (s2 > this.o) {
                    this.o = s2;
                }
                int s3 = dr.getMinimumWidth();
                if (s3 > this.p) {
                    this.p = s3;
                }
                int s4 = dr.getMinimumHeight();
                if (s4 > this.q) {
                    this.q = s4;
                }
            }
        }

        public final void u(int duration) {
            this.A = duration;
        }

        public final void v(int duration) {
            this.B = duration;
        }

        public final int n() {
            if (this.r) {
                return this.s;
            }
            e();
            int count = this.h;
            Drawable[] drawables = this.g;
            int op = count > 0 ? drawables[0].getOpacity() : -2;
            for (int i = 1; i < count; i++) {
                op = Drawable.resolveOpacity(op, drawables[i].getOpacity());
            }
            this.s = op;
            this.r = true;
            return op;
        }

        public void o(int oldSize, int newSize) {
            Drawable[] newDrawables = new Drawable[newSize];
            Drawable[] drawableArr = this.g;
            if (drawableArr != null) {
                System.arraycopy(drawableArr, 0, newDrawables, 0, oldSize);
            }
            this.g = newDrawables;
        }

        public boolean c() {
            if (this.v) {
                return this.w;
            }
            e();
            this.v = true;
            int count = this.h;
            Drawable[] drawables = this.g;
            for (int i = 0; i < count; i++) {
                if (drawables[i].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }
    }

    public void h(d state) {
        this.f66b = state;
        int i = this.h;
        if (i >= 0) {
            Drawable g = state.g(i);
            this.d = g;
            if (g != null) {
                d(g);
            }
        }
        this.e = null;
    }

    /* loaded from: classes.dex */
    public static class c implements Drawable.Callback {

        /* renamed from: b, reason: collision with root package name */
        public Drawable.Callback f68b;

        public c b(Drawable.Callback callback) {
            this.f68b = callback;
            return this;
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f68b;
            this.f68b = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable who) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
            Drawable.Callback callback = this.f68b;
            if (callback != null) {
                callback.scheduleDrawable(who, what, when);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable who, Runnable what) {
            Drawable.Callback callback = this.f68b;
            if (callback != null) {
                callback.unscheduleDrawable(who, what);
            }
        }
    }

    public static int f(Resources r, int parentDensity) {
        int densityDpi = r == null ? parentDensity : r.getDisplayMetrics().densityDpi;
        if (densityDpi == 0) {
            return 160;
        }
        return densityDpi;
    }

    /* renamed from: a.b.d.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0005b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }
}
