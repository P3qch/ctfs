package b.b.a.a.x;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import b.b.a.a.x.k;
import b.b.a.a.x.l;
import b.b.a.a.x.m;
import java.util.BitSet;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class g extends Drawable implements a.h.d.l.b, n {

    /* renamed from: b, reason: collision with root package name */
    public static final String f1101b = g.class.getSimpleName();
    public static final Paint c = new Paint(1);
    public c d;
    public final m.g[] e;
    public final m.g[] f;
    public final BitSet g;
    public boolean h;
    public final Matrix i;
    public final Path j;
    public final Path k;
    public final RectF l;
    public final RectF m;
    public final Region n;
    public final Region o;
    public k p;
    public final Paint q;
    public final Paint r;
    public final b.b.a.a.w.a s;
    public final l.b t;
    public final l u;
    public PorterDuffColorFilter v;
    public PorterDuffColorFilter w;
    public final RectF x;
    public boolean y;

    public /* synthetic */ g(c x0, a x1) {
        this(x0);
    }

    public static g m(Context context, float elevation) {
        int colorSurface = b.b.a.a.k.a.b(context, R.attr.colorSurface, g.class.getSimpleName());
        g materialShapeDrawable = new g();
        materialShapeDrawable.L(context);
        materialShapeDrawable.V(ColorStateList.valueOf(colorSurface));
        materialShapeDrawable.U(elevation);
        return materialShapeDrawable;
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(k.e(context, attrs, defStyleAttr, defStyleRes).m());
    }

    public g(k shapeAppearanceModel) {
        this(new c(shapeAppearanceModel, null));
    }

    public g(c drawableState) {
        this.e = new m.g[4];
        this.f = new m.g[4];
        this.g = new BitSet(8);
        this.i = new Matrix();
        this.j = new Path();
        this.k = new Path();
        this.l = new RectF();
        this.m = new RectF();
        this.n = new Region();
        this.o = new Region();
        Paint paint = new Paint(1);
        this.q = paint;
        Paint paint2 = new Paint(1);
        this.r = paint2;
        this.s = new b.b.a.a.w.a();
        this.u = Looper.getMainLooper().getThread() == Thread.currentThread() ? l.k() : new l();
        this.x = new RectF();
        this.y = true;
        this.d = drawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = c;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        e0();
        d0(getState());
        this.t = new a();
    }

    /* loaded from: classes.dex */
    public class a implements l.b {
        public a() {
        }

        public void a(m cornerPath, Matrix transform, int count) {
            BitSet bitSet = g.this.g;
            cornerPath.e();
            bitSet.set(count, false);
            g.this.e[count] = cornerPath.f(transform);
        }

        public void b(m edgePath, Matrix transform, int count) {
            edgePath.e();
            g.this.g.set(count + 4, false);
            g.this.f[count] = edgePath.f(transform);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        c newDrawableState = new c(this.d);
        this.d = newDrawableState;
        return this;
    }

    public static int Q(int paintAlpha, int alpha) {
        int scale = (alpha >>> 7) + alpha;
        return (paintAlpha * scale) >>> 8;
    }

    @Override // b.b.a.a.x.n
    public void setShapeAppearanceModel(k shapeAppearanceModel) {
        this.d.f1104a = shapeAppearanceModel;
        invalidateSelf();
    }

    public k B() {
        return this.d.f1104a;
    }

    public void V(ColorStateList fillColor) {
        c cVar = this.d;
        if (cVar.d != fillColor) {
            cVar.d = fillColor;
            onStateChange(getState());
        }
    }

    public ColorStateList x() {
        return this.d.d;
    }

    public void b0(ColorStateList strokeColor) {
        c cVar = this.d;
        if (cVar.e != strokeColor) {
            cVar.e = strokeColor;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintMode(PorterDuff.Mode tintMode) {
        c cVar = this.d;
        if (cVar.h != tintMode) {
            cVar.h = tintMode;
            e0();
            M();
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintList(ColorStateList tintList) {
        this.d.g = tintList;
        e0();
        M();
    }

    public ColorStateList D() {
        return this.d.g;
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTint(int tintColor) {
        setTintList(ColorStateList.valueOf(tintColor));
    }

    public void Z(float strokeWidth, int strokeColor) {
        c0(strokeWidth);
        b0(ColorStateList.valueOf(strokeColor));
    }

    public void a0(float strokeWidth, ColorStateList strokeColor) {
        c0(strokeWidth);
        b0(strokeColor);
    }

    public void c0(float strokeWidth) {
        this.d.l = strokeWidth;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        c cVar = this.d;
        if (cVar.m != alpha) {
            cVar.m = alpha;
            M();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.c = colorFilter;
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect bounds = getBounds();
        this.n.set(bounds);
        g(u(), this.j);
        this.o.setPath(this.j, this.n);
        this.n.op(this.o, Region.Op.DIFFERENCE);
        return this.n;
    }

    public RectF u() {
        this.l.set(getBounds());
        return this.l;
    }

    public void T(b.b.a.a.x.c cornerSize) {
        setShapeAppearanceModel(this.d.f1104a.x(cornerSize));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        Rect rect = this.d.i;
        if (rect != null) {
            padding.set(rect);
            return true;
        }
        return super.getPadding(padding);
    }

    public void X(int left, int top, int right, int bottom) {
        c cVar = this.d;
        if (cVar.i == null) {
            cVar.i = new Rect();
        }
        this.d.i.set(left, top, right, bottom);
        invalidateSelf();
    }

    public boolean N() {
        b.b.a.a.o.a aVar = this.d.f1105b;
        return aVar != null && aVar.d();
    }

    public void L(Context context) {
        this.d.f1105b = new b.b.a.a.o.a(context);
        f0();
    }

    public int l(int backgroundColor) {
        float elevation = H() + y();
        b.b.a.a.o.a aVar = this.d.f1105b;
        return aVar != null ? aVar.c(backgroundColor, elevation) : backgroundColor;
    }

    public void W(float interpolation) {
        c cVar = this.d;
        if (cVar.k != interpolation) {
            cVar.k = interpolation;
            this.h = true;
            invalidateSelf();
        }
    }

    public float y() {
        return this.d.n;
    }

    public void Y(float parentAbsoluteElevation) {
        c cVar = this.d;
        if (cVar.n != parentAbsoluteElevation) {
            cVar.n = parentAbsoluteElevation;
            f0();
        }
    }

    public float w() {
        return this.d.o;
    }

    public void U(float elevation) {
        c cVar = this.d;
        if (cVar.o != elevation) {
            cVar.o = elevation;
            f0();
        }
    }

    public float G() {
        return this.d.p;
    }

    public float H() {
        return w() + G();
    }

    public final void f0() {
        float z = H();
        this.d.r = (int) Math.ceil(0.75f * z);
        this.d.s = (int) Math.ceil(0.25f * z);
        e0();
        M();
    }

    public boolean S() {
        int i = Build.VERSION.SDK_INT;
        return i < 21 || !(O() || this.j.isConvex() || i >= 29);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.h = true;
        super.invalidateSelf();
    }

    public final void M() {
        super.invalidateSelf();
    }

    public final boolean I() {
        c cVar = this.d;
        int i = cVar.q;
        return i != 1 && cVar.r > 0 && (i == 2 || S());
    }

    public final boolean J() {
        Paint.Style style = this.d.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    public final boolean K() {
        Paint.Style style = this.d.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.r.getStrokeWidth() > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        this.h = true;
        super.onBoundsChange(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.q.setColorFilter(this.v);
        int prevAlpha = this.q.getAlpha();
        this.q.setAlpha(Q(prevAlpha, this.d.m));
        this.r.setColorFilter(this.w);
        this.r.setStrokeWidth(this.d.l);
        int prevStrokeAlpha = this.r.getAlpha();
        this.r.setAlpha(Q(prevStrokeAlpha, this.d.m));
        if (this.h) {
            i();
            g(u(), this.j);
            this.h = false;
        }
        P(canvas);
        if (J()) {
            o(canvas);
        }
        if (K()) {
            r(canvas);
        }
        this.q.setAlpha(prevAlpha);
        this.r.setAlpha(prevStrokeAlpha);
    }

    public final void P(Canvas canvas) {
        if (!I()) {
            return;
        }
        canvas.save();
        R(canvas);
        if (!this.y) {
            n(canvas);
            canvas.restore();
            return;
        }
        int pathExtraWidth = (int) (this.x.width() - getBounds().width());
        int pathExtraHeight = (int) (this.x.height() - getBounds().height());
        if (pathExtraWidth < 0 || pathExtraHeight < 0) {
            throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
        }
        Bitmap shadowLayer = Bitmap.createBitmap(((int) this.x.width()) + (this.d.r * 2) + pathExtraWidth, ((int) this.x.height()) + (this.d.r * 2) + pathExtraHeight, Bitmap.Config.ARGB_8888);
        Canvas shadowCanvas = new Canvas(shadowLayer);
        float shadowLeft = (getBounds().left - this.d.r) - pathExtraWidth;
        float shadowTop = (getBounds().top - this.d.r) - pathExtraHeight;
        shadowCanvas.translate(-shadowLeft, -shadowTop);
        n(shadowCanvas);
        canvas.drawBitmap(shadowLayer, shadowLeft, shadowTop, (Paint) null);
        shadowLayer.recycle();
        canvas.restore();
    }

    public void p(Canvas canvas, Paint paint, Path path, RectF bounds) {
        q(canvas, paint, path, this.d.f1104a, bounds);
    }

    public final void q(Canvas canvas, Paint paint, Path path, k shapeAppearanceModel, RectF bounds) {
        if (shapeAppearanceModel.u(bounds)) {
            float cornerSize = shapeAppearanceModel.t().a(bounds) * this.d.k;
            canvas.drawRoundRect(bounds, cornerSize, cornerSize, paint);
        } else {
            canvas.drawPath(path, paint);
        }
    }

    public final void o(Canvas canvas) {
        q(canvas, this.q, this.j, this.d.f1104a, u());
    }

    public final void r(Canvas canvas) {
        q(canvas, this.r, this.k, this.p, v());
    }

    public final void R(Canvas canvas) {
        int shadowOffsetX = z();
        int shadowOffsetY = A();
        if (Build.VERSION.SDK_INT < 21 && this.y) {
            Rect canvasClipBounds = canvas.getClipBounds();
            int i = this.d.r;
            canvasClipBounds.inset(-i, -i);
            canvasClipBounds.offset(shadowOffsetX, shadowOffsetY);
            canvas.clipRect(canvasClipBounds, Region.Op.REPLACE);
        }
        canvas.translate(shadowOffsetX, shadowOffsetY);
    }

    public final void n(Canvas canvas) {
        if (this.g.cardinality() > 0) {
            Log.w(f1101b, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.d.s != 0) {
            canvas.drawPath(this.j, this.s.c());
        }
        for (int index = 0; index < 4; index++) {
            this.e[index].b(this.s, this.d.r, canvas);
            this.f[index].b(this.s, this.d.r, canvas);
        }
        if (this.y) {
            int shadowOffsetX = z();
            int shadowOffsetY = A();
            canvas.translate(-shadowOffsetX, -shadowOffsetY);
            canvas.drawPath(this.j, c);
            canvas.translate(shadowOffsetX, shadowOffsetY);
        }
    }

    public int z() {
        double d = this.d.s;
        double sin = Math.sin(Math.toRadians(r0.t));
        Double.isNaN(d);
        return (int) (d * sin);
    }

    public int A() {
        double d = this.d.s;
        double cos = Math.cos(Math.toRadians(r0.t));
        Double.isNaN(d);
        return (int) (d * cos);
    }

    public final void h(RectF bounds, Path path) {
        l lVar = this.u;
        c cVar = this.d;
        lVar.e(cVar.f1104a, cVar.k, bounds, this.t, path);
    }

    public final void i() {
        float strokeInsetLength = -C();
        k y = B().y(new b(this, strokeInsetLength));
        this.p = y;
        this.u.d(y, this.d.k, v(), this.k);
    }

    /* loaded from: classes.dex */
    public class b implements k.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f1103a;

        public b(g this$0, float f) {
            this.f1103a = f;
        }

        public b.b.a.a.x.c a(b.b.a.a.x.c cornerSize) {
            return cornerSize instanceof i ? cornerSize : new b.b.a.a.x.b(this.f1103a, cornerSize);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.d.q == 2) {
            return;
        }
        if (O()) {
            float radius = E() * this.d.k;
            outline.setRoundRect(getBounds(), radius);
            return;
        }
        g(u(), this.j);
        if (this.j.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.j);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public final void g(RectF bounds, Path path) {
        h(bounds, path);
        if (this.d.j != 1.0f) {
            this.i.reset();
            Matrix matrix = this.i;
            float f = this.d.j;
            matrix.setScale(f, f, bounds.width() / 2.0f, bounds.height() / 2.0f);
            path.transform(this.i);
        }
        path.computeBounds(this.x, true);
    }

    public final boolean e0() {
        PorterDuffColorFilter originalTintFilter = this.v;
        PorterDuffColorFilter originalStrokeTintFilter = this.w;
        c cVar = this.d;
        this.v = k(cVar.g, cVar.h, this.q, true);
        c cVar2 = this.d;
        this.w = k(cVar2.f, cVar2.h, this.r, false);
        c cVar3 = this.d;
        if (cVar3.u) {
            this.s.d(cVar3.g.getColorForState(getState(), 0));
        }
        return (a.h.j.d.a(originalTintFilter, this.v) && a.h.j.d.a(originalStrokeTintFilter, this.w)) ? false : true;
    }

    public final PorterDuffColorFilter k(ColorStateList tintList, PorterDuff.Mode tintMode, Paint paint, boolean requiresElevationOverlay) {
        if (tintList == null || tintMode == null) {
            return f(paint, requiresElevationOverlay);
        }
        return j(tintList, tintMode, requiresElevationOverlay);
    }

    public final PorterDuffColorFilter f(Paint paint, boolean requiresElevationOverlay) {
        int paintColor;
        int tintColor;
        if (requiresElevationOverlay && (tintColor = l((paintColor = paint.getColor()))) != paintColor) {
            return new PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    public final PorterDuffColorFilter j(ColorStateList tintList, PorterDuff.Mode tintMode, boolean requiresElevationOverlay) {
        int tintColor = tintList.getColorForState(getState(), 0);
        if (requiresElevationOverlay) {
            tintColor = l(tintColor);
        }
        return new PorterDuffColorFilter(tintColor, tintMode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.d.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.d.f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.d.e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.d.d) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable, b.b.a.a.r.h.b
    public boolean onStateChange(int[] state) {
        boolean paintColorChanged = d0(state);
        boolean tintFilterChanged = e0();
        boolean invalidateSelf = paintColorChanged || tintFilterChanged;
        if (invalidateSelf) {
            invalidateSelf();
        }
        return invalidateSelf;
    }

    public final boolean d0(int[] state) {
        int previousStrokeColor;
        int newStrokeColor;
        int previousFillColor;
        int newFillColor;
        boolean invalidateSelf = false;
        if (this.d.d != null && previousFillColor != (newFillColor = this.d.d.getColorForState(state, (previousFillColor = this.q.getColor())))) {
            this.q.setColor(newFillColor);
            invalidateSelf = true;
        }
        if (this.d.e != null && previousStrokeColor != (newStrokeColor = this.d.e.getColorForState(state, (previousStrokeColor = this.r.getColor())))) {
            this.r.setColor(newStrokeColor);
            return true;
        }
        return invalidateSelf;
    }

    public final float C() {
        if (K()) {
            return this.r.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final RectF v() {
        this.m.set(u());
        float inset = C();
        this.m.inset(inset, inset);
        return this.m;
    }

    public float E() {
        return this.d.f1104a.r().a(u());
    }

    public float F() {
        return this.d.f1104a.t().a(u());
    }

    public float s() {
        return this.d.f1104a.j().a(u());
    }

    public float t() {
        return this.d.f1104a.l().a(u());
    }

    public boolean O() {
        return this.d.f1104a.u(u());
    }

    /* loaded from: classes.dex */
    public static final class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public k f1104a;

        /* renamed from: b, reason: collision with root package name */
        public b.b.a.a.o.a f1105b;
        public ColorFilter c;
        public ColorStateList d;
        public ColorStateList e;
        public ColorStateList f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public c(k shapeAppearanceModel, b.b.a.a.o.a elevationOverlayProvider) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f1104a = shapeAppearanceModel;
            this.f1105b = elevationOverlayProvider;
        }

        public c(c orig) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f1104a = orig.f1104a;
            this.f1105b = orig.f1105b;
            this.l = orig.l;
            this.c = orig.c;
            this.d = orig.d;
            this.e = orig.e;
            this.h = orig.h;
            this.g = orig.g;
            this.m = orig.m;
            this.j = orig.j;
            this.s = orig.s;
            this.q = orig.q;
            this.u = orig.u;
            this.k = orig.k;
            this.n = orig.n;
            this.o = orig.o;
            this.p = orig.p;
            this.r = orig.r;
            this.t = orig.t;
            this.f = orig.f;
            this.v = orig.v;
            if (orig.i != null) {
                this.i = new Rect(orig.i);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g msd = new g(this, null);
            msd.h = true;
            return msd;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }
}
