package a.d.a;

import android.content.res.ColorStateList;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class a extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public static final f f232b;
    public boolean c;
    public boolean d;

    static {
        new int[1][0] = 16842801;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f232b = new c();
        } else if (i >= 17) {
            f232b = new b();
        } else {
            f232b = new d();
        }
        f232b.l();
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int start, int top, int end, int bottom) {
    }

    public boolean getUseCompatPadding() {
        return this.c;
    }

    public void setUseCompatPadding(boolean useCompatPadding) {
        if (this.c != useCompatPadding) {
            this.c = useCompatPadding;
            f232b.h(null);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!(f232b instanceof c)) {
            int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
            switch (widthMode) {
                case Integer.MIN_VALUE:
                case 1073741824:
                    int minWidth = (int) Math.ceil(r0.g(null));
                    widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(minWidth, View.MeasureSpec.getSize(widthMeasureSpec)), widthMode);
                    break;
            }
            int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
            switch (heightMode) {
                case Integer.MIN_VALUE:
                case 1073741824:
                    int minHeight = (int) Math.ceil(r0.e(null));
                    heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(minHeight, View.MeasureSpec.getSize(heightMeasureSpec)), heightMode);
                    break;
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    public void setMinimumWidth(int minWidth) {
        super.setMinimumWidth(minWidth);
    }

    @Override // android.view.View
    public void setMinimumHeight(int minHeight) {
        super.setMinimumHeight(minHeight);
    }

    public void setCardBackgroundColor(int color) {
        f232b.d(null, ColorStateList.valueOf(color));
    }

    public void setCardBackgroundColor(ColorStateList color) {
        f232b.d(null, color);
    }

    public ColorStateList getCardBackgroundColor() {
        return f232b.i(null);
    }

    public int getContentPaddingLeft() {
        throw null;
    }

    public int getContentPaddingRight() {
        throw null;
    }

    public int getContentPaddingTop() {
        throw null;
    }

    public int getContentPaddingBottom() {
        throw null;
    }

    public void setRadius(float radius) {
        f232b.m(null, radius);
    }

    public float getRadius() {
        return f232b.b(null);
    }

    public void setCardElevation(float elevation) {
        f232b.j(null, elevation);
    }

    public float getCardElevation() {
        return f232b.f(null);
    }

    public void setMaxCardElevation(float maxElevation) {
        f232b.k(null, maxElevation);
    }

    public float getMaxCardElevation() {
        return f232b.a(null);
    }

    public boolean getPreventCornerOverlap() {
        return this.d;
    }

    public void setPreventCornerOverlap(boolean preventCornerOverlap) {
        if (preventCornerOverlap != this.d) {
            this.d = preventCornerOverlap;
            f232b.c(null);
        }
    }
}
