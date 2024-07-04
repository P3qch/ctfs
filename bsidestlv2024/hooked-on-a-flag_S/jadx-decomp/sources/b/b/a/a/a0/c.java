package b.b.a.a.a0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import b.b.a.a.x.k;

/* loaded from: classes.dex */
public class c extends b.b.a.a.x.g {
    public final RectF A;
    public int B;
    public final Paint z;

    public c() {
        this(null);
    }

    public c(k shapeAppearanceModel) {
        super(shapeAppearanceModel != null ? shapeAppearanceModel : new k());
        this.z = new Paint(1);
        n0();
        this.A = new RectF();
    }

    public final void n0() {
        this.z.setStyle(Paint.Style.FILL_AND_STROKE);
        this.z.setColor(-1);
        this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public boolean g0() {
        return !this.A.isEmpty();
    }

    public void l0(float left, float top, float right, float bottom) {
        RectF rectF = this.A;
        if (left != rectF.left || top != rectF.top || right != rectF.right || bottom != rectF.bottom) {
            rectF.set(left, top, right, bottom);
            invalidateSelf();
        }
    }

    public void m0(RectF bounds) {
        l0(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    public void j0() {
        l0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // b.b.a.a.x.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        i0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.A, this.z);
        h0(canvas);
    }

    public final void i0(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (o0(callback)) {
            View viewCallback = (View) callback;
            if (viewCallback.getLayerType() != 2) {
                viewCallback.setLayerType(2, null);
                return;
            }
            return;
        }
        k0(canvas);
    }

    public final void k0(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.B = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.B = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    public final void h0(Canvas canvas) {
        if (!o0(getCallback())) {
            canvas.restoreToCount(this.B);
        }
    }

    public final boolean o0(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
