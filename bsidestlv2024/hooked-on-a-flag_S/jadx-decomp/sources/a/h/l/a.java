package a.h.l;

import a.h.k.v;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: b, reason: collision with root package name */
    public static final int f491b = ViewConfiguration.getTapTimeout();
    public final View e;
    public Runnable f;
    public int i;
    public int j;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public final C0035a c = new C0035a();
    public final Interpolator d = new AccelerateInterpolator();
    public float[] g = {0.0f, 0.0f};
    public float[] h = {Float.MAX_VALUE, Float.MAX_VALUE};
    public float[] k = {0.0f, 0.0f};
    public float[] l = {0.0f, 0.0f};
    public float[] m = {Float.MAX_VALUE, Float.MAX_VALUE};

    public abstract boolean a(int i);

    public abstract boolean b(int i);

    public abstract void j(int i, int i2);

    public a(View target) {
        this.e = target;
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float f = metrics.density;
        int maxVelocity = (int) ((1575.0f * f) + 0.5f);
        int minVelocity = (int) ((f * 315.0f) + 0.5f);
        o(maxVelocity, maxVelocity);
        p(minVelocity, minVelocity);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f491b);
        r(500);
        q(500);
    }

    public a m(boolean enabled) {
        if (this.r && !enabled) {
            i();
        }
        this.r = enabled;
        return this;
    }

    public a o(float horizontalMax, float verticalMax) {
        float[] fArr = this.m;
        fArr[0] = horizontalMax / 1000.0f;
        fArr[1] = verticalMax / 1000.0f;
        return this;
    }

    public a p(float horizontalMin, float verticalMin) {
        float[] fArr = this.l;
        fArr[0] = horizontalMin / 1000.0f;
        fArr[1] = verticalMin / 1000.0f;
        return this;
    }

    public a t(float horizontal, float vertical) {
        float[] fArr = this.k;
        fArr[0] = horizontal / 1000.0f;
        fArr[1] = vertical / 1000.0f;
        return this;
    }

    public a l(int type) {
        this.i = type;
        return this;
    }

    public a s(float horizontal, float vertical) {
        float[] fArr = this.g;
        fArr[0] = horizontal;
        fArr[1] = vertical;
        return this;
    }

    public a n(float horizontalMax, float verticalMax) {
        float[] fArr = this.h;
        fArr[0] = horizontalMax;
        fArr[1] = verticalMax;
        return this;
    }

    public a k(int delayMillis) {
        this.j = delayMillis;
        return this;
    }

    public a r(int durationMillis) {
        this.c.k(durationMillis);
        return this;
    }

    public a q(int durationMillis) {
        this.c.j(durationMillis);
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (!this.r) {
            return false;
        }
        int action = event.getActionMasked();
        switch (action) {
            case 0:
                this.p = true;
                this.n = false;
                float xTargetVelocity = d(0, event.getX(), v.getWidth(), this.e.getWidth());
                float yTargetVelocity = d(1, event.getY(), v.getHeight(), this.e.getHeight());
                this.c.l(xTargetVelocity, yTargetVelocity);
                if (!this.q && u()) {
                    v();
                    break;
                }
                break;
            case 1:
            case 3:
                i();
                break;
            case 2:
                float xTargetVelocity2 = d(0, event.getX(), v.getWidth(), this.e.getWidth());
                float yTargetVelocity2 = d(1, event.getY(), v.getHeight(), this.e.getHeight());
                this.c.l(xTargetVelocity2, yTargetVelocity2);
                if (!this.q) {
                    v();
                    break;
                }
                break;
        }
        return false;
    }

    public boolean u() {
        C0035a scroller = this.c;
        int verticalDirection = scroller.f();
        int horizontalDirection = scroller.d();
        if (verticalDirection == 0 || !b(verticalDirection)) {
            if (horizontalDirection != 0) {
                a(horizontalDirection);
            }
            return false;
        }
        return true;
    }

    public final void v() {
        int i;
        if (this.f == null) {
            this.f = new b();
        }
        this.q = true;
        this.o = true;
        if (!this.n && (i = this.j) > 0) {
            v.h0(this.e, this.f, i);
        } else {
            this.f.run();
        }
        this.n = true;
    }

    public final void i() {
        if (this.o) {
            this.q = false;
        } else {
            this.c.i();
        }
    }

    public final float d(int direction, float coordinate, float srcSize, float dstSize) {
        float relativeEdge = this.g[direction];
        float maximumEdge = this.h[direction];
        float value = h(relativeEdge, srcSize, maximumEdge, coordinate);
        if (value == 0.0f) {
            return 0.0f;
        }
        float relativeVelocity = this.k[direction];
        float minimumVelocity = this.l[direction];
        float maximumVelocity = this.m[direction];
        float targetVelocity = relativeVelocity * dstSize;
        if (value > 0.0f) {
            return e(value * targetVelocity, minimumVelocity, maximumVelocity);
        }
        return -e((-value) * targetVelocity, minimumVelocity, maximumVelocity);
    }

    public final float h(float relativeValue, float size, float maxValue, float current) {
        float interpolated;
        float edgeSize = e(relativeValue * size, 0.0f, maxValue);
        float valueLeading = g(current, edgeSize);
        float valueTrailing = g(size - current, edgeSize);
        float value = valueTrailing - valueLeading;
        if (value < 0.0f) {
            interpolated = -this.d.getInterpolation(-value);
        } else {
            if (value <= 0.0f) {
                return 0.0f;
            }
            interpolated = this.d.getInterpolation(value);
        }
        return e(interpolated, -1.0f, 1.0f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final float g(float current, float leading) {
        if (leading == 0.0f) {
            return 0.0f;
        }
        int i = this.i;
        switch (i) {
            case 0:
            case 1:
                if (current < leading) {
                    if (current >= 0.0f) {
                        return 1.0f - (current / leading);
                    }
                    if (this.q && i == 1) {
                        return 1.0f;
                    }
                }
                return 0.0f;
            case 2:
                if (current < 0.0f) {
                    return current / (-leading);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    public static int f(int value, int min, int max) {
        if (value > max) {
            return max;
        }
        if (value < min) {
            return min;
        }
        return value;
    }

    public static float e(float value, float min, float max) {
        if (value > max) {
            return max;
        }
        if (value < min) {
            return min;
        }
        return value;
    }

    public void c() {
        long eventTime = SystemClock.uptimeMillis();
        MotionEvent cancel = MotionEvent.obtain(eventTime, eventTime, 3, 0.0f, 0.0f, 0);
        this.e.onTouchEvent(cancel);
        cancel.recycle();
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (!aVar.q) {
                return;
            }
            if (aVar.o) {
                aVar.o = false;
                aVar.c.m();
            }
            C0035a scroller = a.this.c;
            if (scroller.h() || !a.this.u()) {
                a.this.q = false;
                return;
            }
            a aVar2 = a.this;
            if (aVar2.p) {
                aVar2.p = false;
                aVar2.c();
            }
            scroller.a();
            int deltaX = scroller.b();
            int deltaY = scroller.c();
            a.this.j(deltaX, deltaY);
            v.g0(a.this.e, this);
        }
    }

    /* renamed from: a.h.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0035a {

        /* renamed from: a, reason: collision with root package name */
        public int f492a;

        /* renamed from: b, reason: collision with root package name */
        public int f493b;
        public float c;
        public float d;
        public float j;
        public int k;
        public long e = Long.MIN_VALUE;
        public long i = -1;
        public long f = 0;
        public int g = 0;
        public int h = 0;

        public void k(int durationMillis) {
            this.f492a = durationMillis;
        }

        public void j(int durationMillis) {
            this.f493b = durationMillis;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.e = currentAnimationTimeMillis;
            this.i = -1L;
            this.f = currentAnimationTimeMillis;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void i() {
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.f((int) (currentTime - this.e), 0, this.f493b);
            this.j = e(currentTime);
            this.i = currentTime;
        }

        public boolean h() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public final float e(long currentTime) {
            long elapsedSinceEnd = this.e;
            if (currentTime < elapsedSinceEnd) {
                return 0.0f;
            }
            long j = this.i;
            if (j < 0 || currentTime < j) {
                long elapsedSinceStart = currentTime - elapsedSinceEnd;
                return a.e(((float) elapsedSinceStart) / this.f492a, 0.0f, 1.0f) * 0.5f;
            }
            long elapsedSinceEnd2 = currentTime - j;
            float f = this.j;
            return (1.0f - f) + (f * a.e(((float) elapsedSinceEnd2) / this.k, 0.0f, 1.0f));
        }

        public final float g(float value) {
            return ((-4.0f) * value * value) + (4.0f * value);
        }

        public void a() {
            if (this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            float value = e(currentTime);
            float scale = g(value);
            long elapsedSinceDelta = currentTime - this.f;
            this.f = currentTime;
            this.g = (int) (((float) elapsedSinceDelta) * scale * this.c);
            this.h = (int) (((float) elapsedSinceDelta) * scale * this.d);
        }

        public void l(float x, float y) {
            this.c = x;
            this.d = y;
        }

        public int d() {
            float f = this.c;
            return (int) (f / Math.abs(f));
        }

        public int f() {
            float f = this.d;
            return (int) (f / Math.abs(f));
        }

        public int b() {
            return this.g;
        }

        public int c() {
            return this.h;
        }
    }
}
