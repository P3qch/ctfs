package a.b.g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: classes.dex */
public class w extends r {
    public final SeekBar d;
    public Drawable e;
    public ColorStateList f;
    public PorterDuff.Mode g;
    public boolean h;
    public boolean i;

    public w(SeekBar view) {
        super(view);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.d = view;
    }

    @Override // a.b.g.r
    public void c(AttributeSet attrs, int defStyleAttr) {
        super.c(attrs, defStyleAttr);
        Context context = this.d.getContext();
        int[] iArr = a.b.a.g;
        x0 a2 = x0.v(context, attrs, iArr, defStyleAttr, 0);
        SeekBar seekBar = this.d;
        a.h.k.v.m0(seekBar, seekBar.getContext(), iArr, attrs, a2.r(), defStyleAttr, 0);
        int[] iArr2 = a.b.a.f11a;
        Drawable drawable = a2.h(0);
        if (drawable != null) {
            this.d.setThumb(drawable);
        }
        Drawable tickMark = a2.g(1);
        j(tickMark);
        if (a2.s(3)) {
            this.g = f0.d(a2.k(3, -1), this.g);
            this.i = true;
        }
        if (a2.s(2)) {
            this.f = a2.c(2);
            this.h = true;
        }
        a2.w();
        f();
    }

    public void j(Drawable tickMark) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.e = tickMark;
        if (tickMark != null) {
            tickMark.setCallback(this.d);
            a.h.d.l.a.m(tickMark, a.h.k.v.C(this.d));
            if (tickMark.isStateful()) {
                tickMark.setState(this.d.getDrawableState());
            }
            f();
        }
        this.d.invalidate();
    }

    public final void f() {
        Drawable drawable = this.e;
        if (drawable != null) {
            if (this.h || this.i) {
                Drawable r = a.h.d.l.a.r(drawable.mutate());
                this.e = r;
                if (this.h) {
                    a.h.d.l.a.o(r, this.f);
                }
                if (this.i) {
                    a.h.d.l.a.p(this.e, this.g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.d.getDrawableState());
                }
            }
        }
    }

    public void i() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void h() {
        Drawable tickMark = this.e;
        if (tickMark != null && tickMark.isStateful() && tickMark.setState(this.d.getDrawableState())) {
            this.d.invalidateDrawable(tickMark);
        }
    }

    public void g(Canvas canvas) {
        if (this.e != null) {
            int count = this.d.getMax();
            if (count > 1) {
                int w = this.e.getIntrinsicWidth();
                int h = this.e.getIntrinsicHeight();
                int halfW = w >= 0 ? w / 2 : 1;
                int halfH = h >= 0 ? h / 2 : 1;
                this.e.setBounds(-halfW, -halfH, halfW, halfH);
                float spacing = ((this.d.getWidth() - this.d.getPaddingLeft()) - this.d.getPaddingRight()) / count;
                int saveCount = canvas.save();
                canvas.translate(this.d.getPaddingLeft(), this.d.getHeight() / 2);
                for (int i = 0; i <= count; i++) {
                    this.e.draw(canvas);
                    canvas.translate(spacing, 0.0f);
                }
                canvas.restoreToCount(saveCount);
            }
        }
    }
}
