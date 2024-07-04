package a.o.b;

import a.h.k.v;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class d extends RecyclerView.n implements RecyclerView.r {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f661a = {R.attr.state_pressed};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f662b = new int[0];
    public final ValueAnimator B;
    public int C;
    public final Runnable D;
    public final RecyclerView.s E;
    public final int c;
    public final int d;
    public final StateListDrawable e;
    public final Drawable f;
    public final int g;
    public final int h;
    public final StateListDrawable i;
    public final Drawable j;
    public final int k;
    public final int l;
    public int m;
    public int n;
    public float o;
    public int p;
    public int q;
    public float r;
    public RecyclerView u;
    public int s = 0;
    public int t = 0;
    public boolean v = false;
    public boolean w = false;
    public int x = 0;
    public int y = 0;
    public final int[] z = new int[2];
    public final int[] A = new int[2];

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(500);
        }
    }

    /* loaded from: classes.dex */
    public class b extends RecyclerView.s {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int dx, int dy) {
            d.this.B(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    public d(RecyclerView recyclerView, StateListDrawable verticalThumbDrawable, Drawable verticalTrackDrawable, StateListDrawable horizontalThumbDrawable, Drawable horizontalTrackDrawable, int defaultWidth, int scrollbarMinimumRange, int margin) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.B = ofFloat;
        this.C = 0;
        this.D = new a();
        this.E = new b();
        this.e = verticalThumbDrawable;
        this.f = verticalTrackDrawable;
        this.i = horizontalThumbDrawable;
        this.j = horizontalTrackDrawable;
        this.g = Math.max(defaultWidth, verticalThumbDrawable.getIntrinsicWidth());
        this.h = Math.max(defaultWidth, verticalTrackDrawable.getIntrinsicWidth());
        this.k = Math.max(defaultWidth, horizontalThumbDrawable.getIntrinsicWidth());
        this.l = Math.max(defaultWidth, horizontalTrackDrawable.getIntrinsicWidth());
        this.c = scrollbarMinimumRange;
        this.d = margin;
        verticalThumbDrawable.setAlpha(255);
        verticalTrackDrawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new C0049d());
        j(recyclerView);
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.u;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            l();
        }
        this.u = recyclerView;
        if (recyclerView != null) {
            z();
        }
    }

    public final void z() {
        this.u.h(this);
        this.u.j(this);
        this.u.k(this.E);
    }

    public final void l() {
        this.u.V0(this);
        this.u.W0(this);
        this.u.X0(this.E);
        k();
    }

    public void v() {
        this.u.invalidate();
    }

    public void y(int state) {
        if (state == 2 && this.x != 2) {
            this.e.setState(f661a);
            k();
        }
        if (state == 0) {
            v();
        } else {
            A();
        }
        if (this.x == 2 && state != 2) {
            this.e.setState(f662b);
            w(1200);
        } else if (state == 1) {
            w(1500);
        }
        this.x = state;
    }

    public final boolean s() {
        return v.C(this.u) == 1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    public void A() {
        switch (this.C) {
            case 3:
                this.B.cancel();
            case 0:
                this.C = 1;
                ValueAnimator valueAnimator = this.B;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
                this.B.setDuration(500L);
                this.B.setStartDelay(0L);
                this.B.start();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    public void q(int duration) {
        switch (this.C) {
            case 1:
                this.B.cancel();
            case 2:
                this.C = 3;
                ValueAnimator valueAnimator = this.B;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                this.B.setDuration(duration);
                this.B.start();
                return;
            default:
                return;
        }
    }

    public final void k() {
        this.u.removeCallbacks(this.D);
    }

    public final void w(int delay) {
        k();
        this.u.postDelayed(this.D, delay);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView parent, RecyclerView.z state) {
        if (this.s != this.u.getWidth() || this.t != this.u.getHeight()) {
            this.s = this.u.getWidth();
            this.t = this.u.getHeight();
            y(0);
        } else if (this.C != 0) {
            if (this.v) {
                n(canvas);
            }
            if (this.w) {
                m(canvas);
            }
        }
    }

    public final void n(Canvas canvas) {
        int viewWidth = this.s;
        int i = this.g;
        int left = viewWidth - i;
        int i2 = this.n;
        int i3 = this.m;
        int top = i2 - (i3 / 2);
        this.e.setBounds(0, 0, i, i3);
        this.f.setBounds(0, 0, this.h, this.t);
        if (s()) {
            this.f.draw(canvas);
            canvas.translate(this.g, top);
            canvas.scale(-1.0f, 1.0f);
            this.e.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.g, -top);
            return;
        }
        canvas.translate(left, 0.0f);
        this.f.draw(canvas);
        canvas.translate(0.0f, top);
        this.e.draw(canvas);
        canvas.translate(-left, -top);
    }

    public final void m(Canvas canvas) {
        int viewHeight = this.t;
        int i = this.k;
        int top = viewHeight - i;
        int i2 = this.q;
        int i3 = this.p;
        int left = i2 - (i3 / 2);
        this.i.setBounds(0, 0, i3, i);
        this.j.setBounds(0, 0, this.s, this.l);
        canvas.translate(0.0f, top);
        this.j.draw(canvas);
        canvas.translate(left, 0.0f);
        this.i.draw(canvas);
        canvas.translate(-left, -top);
    }

    public void B(int offsetX, int offsetY) {
        int verticalContentLength = this.u.computeVerticalScrollRange();
        int verticalVisibleLength = this.t;
        this.v = verticalContentLength - verticalVisibleLength > 0 && this.t >= this.c;
        int horizontalContentLength = this.u.computeHorizontalScrollRange();
        int horizontalVisibleLength = this.s;
        boolean z = horizontalContentLength - horizontalVisibleLength > 0 && this.s >= this.c;
        this.w = z;
        boolean z2 = this.v;
        if (!z2 && !z) {
            if (this.x != 0) {
                y(0);
                return;
            }
            return;
        }
        if (z2) {
            float middleScreenPos = offsetY + (verticalVisibleLength / 2.0f);
            this.n = (int) ((verticalVisibleLength * middleScreenPos) / verticalContentLength);
            this.m = Math.min(verticalVisibleLength, (verticalVisibleLength * verticalVisibleLength) / verticalContentLength);
        }
        if (this.w) {
            float middleScreenPos2 = offsetX + (horizontalVisibleLength / 2.0f);
            this.q = (int) ((horizontalVisibleLength * middleScreenPos2) / horizontalContentLength);
            this.p = Math.min(horizontalVisibleLength, (horizontalVisibleLength * horizontalVisibleLength) / horizontalContentLength);
        }
        int i = this.x;
        if (i == 0 || i == 1) {
            y(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean b(RecyclerView recyclerView, MotionEvent ev) {
        int i = this.x;
        if (i != 1) {
            if (i == 2) {
                return true;
            }
            return false;
        }
        boolean insideVerticalThumb = u(ev.getX(), ev.getY());
        boolean insideHorizontalThumb = t(ev.getX(), ev.getY());
        if (ev.getAction() == 0 && (insideVerticalThumb || insideHorizontalThumb)) {
            if (insideHorizontalThumb) {
                this.y = 1;
                this.r = (int) ev.getX();
            } else if (insideVerticalThumb) {
                this.y = 2;
                this.o = (int) ev.getY();
            }
            y(2);
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void c(RecyclerView recyclerView, MotionEvent me) {
        if (this.x == 0) {
            return;
        }
        if (me.getAction() == 0) {
            boolean insideVerticalThumb = u(me.getX(), me.getY());
            boolean insideHorizontalThumb = t(me.getX(), me.getY());
            if (insideVerticalThumb || insideHorizontalThumb) {
                if (insideHorizontalThumb) {
                    this.y = 1;
                    this.r = (int) me.getX();
                } else if (insideVerticalThumb) {
                    this.y = 2;
                    this.o = (int) me.getY();
                }
                y(2);
                return;
            }
            return;
        }
        if (me.getAction() == 1 && this.x == 2) {
            this.o = 0.0f;
            this.r = 0.0f;
            y(1);
            this.y = 0;
            return;
        }
        if (me.getAction() == 2 && this.x == 2) {
            A();
            if (this.y == 1) {
                r(me.getX());
            }
            if (this.y == 2) {
                C(me.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void a(boolean disallowIntercept) {
    }

    public final void C(float y) {
        int[] scrollbarRange = p();
        float y2 = Math.max(scrollbarRange[0], Math.min(scrollbarRange[1], y));
        if (Math.abs(this.n - y2) < 2.0f) {
            return;
        }
        int scrollingBy = x(this.o, y2, scrollbarRange, this.u.computeVerticalScrollRange(), this.u.computeVerticalScrollOffset(), this.t);
        if (scrollingBy != 0) {
            this.u.scrollBy(0, scrollingBy);
        }
        this.o = y2;
    }

    public final void r(float x) {
        int[] scrollbarRange = o();
        float x2 = Math.max(scrollbarRange[0], Math.min(scrollbarRange[1], x));
        if (Math.abs(this.q - x2) < 2.0f) {
            return;
        }
        int scrollingBy = x(this.r, x2, scrollbarRange, this.u.computeHorizontalScrollRange(), this.u.computeHorizontalScrollOffset(), this.s);
        if (scrollingBy != 0) {
            this.u.scrollBy(scrollingBy, 0);
        }
        this.r = x2;
    }

    public final int x(float oldDragPos, float newDragPos, int[] scrollbarRange, int scrollRange, int scrollOffset, int viewLength) {
        int scrollbarLength = scrollbarRange[1] - scrollbarRange[0];
        if (scrollbarLength == 0) {
            return 0;
        }
        float percentage = (newDragPos - oldDragPos) / scrollbarLength;
        int totalPossibleOffset = scrollRange - viewLength;
        int scrollingBy = (int) (totalPossibleOffset * percentage);
        int absoluteOffset = scrollOffset + scrollingBy;
        if (absoluteOffset >= totalPossibleOffset || absoluteOffset < 0) {
            return 0;
        }
        return scrollingBy;
    }

    public boolean u(float x, float y) {
        if (!s() ? x >= this.s - this.g : x <= this.g / 2) {
            int i = this.n;
            int i2 = this.m;
            if (y >= i - (i2 / 2) && y <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean t(float x, float y) {
        if (y >= this.t - this.k) {
            int i = this.q;
            int i2 = this.p;
            if (x >= i - (i2 / 2) && x <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    public final int[] p() {
        int[] iArr = this.z;
        int i = this.d;
        iArr[0] = i;
        iArr[1] = this.t - i;
        return iArr;
    }

    public final int[] o() {
        int[] iArr = this.A;
        int i = this.d;
        iArr[0] = i;
        iArr[1] = this.s - i;
        return iArr;
    }

    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f665a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (this.f665a) {
                this.f665a = false;
                return;
            }
            if (((Float) d.this.B.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.C = 0;
                dVar.y(0);
            } else {
                d dVar2 = d.this;
                dVar2.C = 2;
                dVar2.v();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.f665a = true;
        }
    }

    /* renamed from: a.o.b.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0049d implements ValueAnimator.AnimatorUpdateListener {
        public C0049d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int alpha = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.e.setAlpha(alpha);
            d.this.f.setAlpha(alpha);
            d.this.v();
        }
    }
}
