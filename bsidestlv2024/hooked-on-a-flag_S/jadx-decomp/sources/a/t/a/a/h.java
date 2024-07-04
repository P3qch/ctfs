package a.t.a.a;

import a.h.d.c;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteDatabase;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class h extends a.t.a.a.g {
    public static final PorterDuff.Mode c = PorterDuff.Mode.SRC_IN;
    public C0054h d;
    public PorterDuffColorFilter e;
    public ColorFilter f;
    public boolean g;
    public boolean h;
    public final float[] i;
    public final Matrix j;
    public final Rect k;

    public h() {
        this.h = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.d = new C0054h();
    }

    public h(C0054h state) {
        this.h = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.d = state;
        this.e = j(state.c, state.d);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.g && super.mutate() == this) {
            this.d = new C0054h(this.d);
            this.g = true;
        }
        return this;
    }

    public Object d(String name) {
        return this.d.f764b.q.get(name);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f756b != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f756b.getConstantState());
        }
        this.d.f763a = getChangingConfigurations();
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() <= 0 || this.k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f;
        if (colorFilter == null) {
            colorFilter = this.e;
        }
        canvas.getMatrix(this.j);
        this.j.getValues(this.i);
        float canvasScaleX = Math.abs(this.i[0]);
        float canvasScaleY = Math.abs(this.i[4]);
        float canvasSkewX = Math.abs(this.i[1]);
        float canvasSkewY = Math.abs(this.i[3]);
        if (canvasSkewX != 0.0f || canvasSkewY != 0.0f) {
            canvasScaleX = 1.0f;
            canvasScaleY = 1.0f;
        }
        int scaledWidth = Math.min(2048, (int) (this.k.width() * canvasScaleX));
        int scaledHeight = Math.min(2048, (int) (this.k.height() * canvasScaleY));
        if (scaledWidth <= 0 || scaledHeight <= 0) {
            return;
        }
        int saveCount = canvas.save();
        Rect rect = this.k;
        canvas.translate(rect.left, rect.top);
        boolean needMirroring = f();
        if (needMirroring) {
            canvas.translate(this.k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k.offsetTo(0, 0);
        this.d.c(scaledWidth, scaledHeight);
        if (!this.h) {
            this.d.j(scaledWidth, scaledHeight);
        } else if (!this.d.b()) {
            this.d.j(scaledWidth, scaledHeight);
            this.d.i();
        }
        this.d.d(canvas, colorFilter, this.k);
        canvas.restoreToCount(saveCount);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return a.h.d.l.a.d(drawable);
        }
        return this.d.f764b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.setAlpha(alpha);
        } else if (this.d.f764b.getRootAlpha() != alpha) {
            this.d.f764b.setRootAlpha(alpha);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return a.h.d.l.a.e(drawable);
        }
        return this.f;
    }

    public PorterDuffColorFilter j(ColorStateList tint, PorterDuff.Mode tintMode) {
        if (tint == null || tintMode == null) {
            return null;
        }
        int color = tint.getColorForState(getState(), 0);
        return new PorterDuffColorFilter(color, tintMode);
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTint(int tint) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.n(drawable, tint);
        } else {
            setTintList(ColorStateList.valueOf(tint));
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintList(ColorStateList tint) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.o(drawable, tint);
            return;
        }
        C0054h state = this.d;
        if (state.c != tint) {
            state.c = tint;
            this.e = j(tint, state.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintMode(PorterDuff.Mode tintMode) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.p(drawable, tintMode);
            return;
        }
        C0054h state = this.d;
        if (state.d != tintMode) {
            state.d = tintMode;
            this.e = j(state.c, tintMode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0054h c0054h;
        ColorStateList colorStateList;
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((c0054h = this.d) != null && (c0054h.g() || ((colorStateList = this.d.c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.setState(stateSet);
        }
        boolean changed = false;
        C0054h state = this.d;
        ColorStateList colorStateList = state.c;
        if (colorStateList != null && (mode = state.d) != null) {
            this.e = j(colorStateList, mode);
            invalidateSelf();
            changed = true;
        }
        if (state.g() && state.h(stateSet)) {
            invalidateSelf();
            return true;
        }
        return changed;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.d.f764b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.d.f764b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.b(drawable);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return a.h.d.l.a.h(drawable);
        }
        return this.d.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.j(drawable, mirrored);
        } else {
            this.d.e = mirrored;
        }
    }

    public static h b(Resources res, int resId, Resources.Theme theme) {
        int type;
        if (Build.VERSION.SDK_INT >= 24) {
            h drawable = new h();
            drawable.f756b = a.h.c.c.f.b(res, resId, theme);
            new i(drawable.f756b.getConstantState());
            return drawable;
        }
        try {
            XmlPullParser parser = res.getXml(resId);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            do {
                type = parser.next();
                if (type == 2) {
                    break;
                }
            } while (type != 1);
            if (type != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            return c(res, parser, attrs, theme);
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static h c(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        h drawable = new h();
        drawable.inflate(r, parser, attrs, theme);
        return drawable;
    }

    public static int a(int color, float alpha) {
        int alphaBytes = Color.alpha(color);
        return (color & 16777215) | (((int) (alphaBytes * alpha)) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.inflate(res, parser, attrs);
        } else {
            inflate(res, parser, attrs, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.g(drawable, res, parser, attrs, theme);
            return;
        }
        C0054h state = this.d;
        g pathRenderer = new g();
        state.f764b = pathRenderer;
        TypedArray a2 = a.h.c.c.g.k(res, theme, attrs, a.t.a.a.a.f746a);
        i(a2, parser, theme);
        a2.recycle();
        state.f763a = getChangingConfigurations();
        state.k = true;
        e(res, parser, attrs, theme);
        this.e = j(state.c, state.d);
    }

    public static PorterDuff.Mode g(int value, PorterDuff.Mode defaultMode) {
        switch (value) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                return PorterDuff.Mode.ADD;
            default:
                return defaultMode;
        }
    }

    public final void i(TypedArray a2, XmlPullParser parser, Resources.Theme theme) {
        C0054h state = this.d;
        g pathRenderer = state.f764b;
        int mode = a.h.c.c.g.g(a2, parser, "tintMode", 6, -1);
        state.d = g(mode, PorterDuff.Mode.SRC_IN);
        ColorStateList tint = a.h.c.c.g.c(a2, parser, theme, "tint", 1);
        if (tint != null) {
            state.c = tint;
        }
        state.e = a.h.c.c.g.a(a2, parser, "autoMirrored", 5, state.e);
        pathRenderer.l = a.h.c.c.g.f(a2, parser, "viewportWidth", 7, pathRenderer.l);
        float f2 = a.h.c.c.g.f(a2, parser, "viewportHeight", 8, pathRenderer.m);
        pathRenderer.m = f2;
        if (pathRenderer.l <= 0.0f) {
            throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 <= 0.0f) {
            throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        pathRenderer.j = a2.getDimension(3, pathRenderer.j);
        float dimension = a2.getDimension(2, pathRenderer.k);
        pathRenderer.k = dimension;
        if (pathRenderer.j <= 0.0f) {
            throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires height > 0");
        }
        float alphaInFloat = a.h.c.c.g.f(a2, parser, "alpha", 4, pathRenderer.getAlpha());
        pathRenderer.setAlpha(alphaInFloat);
        String name = a2.getString(0);
        if (name != null) {
            pathRenderer.o = name;
            pathRenderer.q.put(name, pathRenderer);
        }
    }

    public final void e(Resources res, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        C0054h state = this.d;
        g pathRenderer = state.f764b;
        boolean noPathTag = true;
        ArrayDeque<VectorDrawableCompat.VGroup> groupStack = new ArrayDeque<>();
        groupStack.push(pathRenderer.i);
        int eventType = parser.getEventType();
        int innerDepth = parser.getDepth() + 1;
        for (int i2 = 1; eventType != i2 && (parser.getDepth() >= innerDepth || eventType != 3); i2 = 1) {
            if (eventType == 2) {
                String tagName = parser.getName();
                d currentGroup = (d) groupStack.peek();
                if ("path".equals(tagName)) {
                    c path = new c();
                    path.g(res, attrs, theme, parser);
                    currentGroup.f758b.add(path);
                    if (path.getPathName() != null) {
                        pathRenderer.q.put(path.getPathName(), path);
                    }
                    noPathTag = false;
                    state.f763a |= path.d;
                } else if ("clip-path".equals(tagName)) {
                    b path2 = new b();
                    path2.e(res, attrs, theme, parser);
                    currentGroup.f758b.add(path2);
                    if (path2.getPathName() != null) {
                        pathRenderer.q.put(path2.getPathName(), path2);
                    }
                    state.f763a |= path2.d;
                } else if ("group".equals(tagName)) {
                    d newChildGroup = new d();
                    newChildGroup.c(res, attrs, theme, parser);
                    currentGroup.f758b.add(newChildGroup);
                    groupStack.push(newChildGroup);
                    if (newChildGroup.getGroupName() != null) {
                        pathRenderer.q.put(newChildGroup.getGroupName(), newChildGroup);
                    }
                    state.f763a |= newChildGroup.k;
                }
            } else if (eventType == 3 && "group".equals(parser.getName())) {
                groupStack.pop();
            }
            eventType = parser.next();
        }
        if (noPathTag) {
            throw new XmlPullParserException("no path defined");
        }
    }

    public void h(boolean allowCaching) {
        this.h = allowCaching;
    }

    public final boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && a.h.d.l.a.f(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable what, long when) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.scheduleSelf(what, when);
        } else {
            super.scheduleSelf(what, when);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.setVisible(visible, restart);
        }
        return super.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable what) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.unscheduleSelf(what);
        } else {
            super.unscheduleSelf(what);
        }
    }

    /* loaded from: classes.dex */
    public static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f765a;

        public i(Drawable.ConstantState state) {
            this.f765a = state;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h drawableCompat = new h();
            drawableCompat.f756b = (VectorDrawable) this.f765a.newDrawable();
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            h drawableCompat = new h();
            drawableCompat.f756b = (VectorDrawable) this.f765a.newDrawable(res);
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res, Resources.Theme theme) {
            h drawableCompat = new h();
            drawableCompat.f756b = (VectorDrawable) this.f765a.newDrawable(res, theme);
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f765a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f765a.getChangingConfigurations();
        }
    }

    /* renamed from: a.t.a.a.h$h, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0054h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f763a;

        /* renamed from: b, reason: collision with root package name */
        public g f764b;
        public ColorStateList c;
        public PorterDuff.Mode d;
        public boolean e;
        public Bitmap f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public int i;
        public boolean j;
        public boolean k;
        public Paint l;

        public C0054h(C0054h copy) {
            this.c = null;
            this.d = h.c;
            if (copy != null) {
                this.f763a = copy.f763a;
                g gVar = new g(copy.f764b);
                this.f764b = gVar;
                if (copy.f764b.f != null) {
                    gVar.f = new Paint(copy.f764b.f);
                }
                if (copy.f764b.e != null) {
                    this.f764b.e = new Paint(copy.f764b.e);
                }
                this.c = copy.c;
                this.d = copy.d;
                this.e = copy.e;
            }
        }

        public void d(Canvas canvas, ColorFilter filter, Rect originalBounds) {
            Paint p = e(filter);
            canvas.drawBitmap(this.f, (Rect) null, originalBounds, p);
        }

        public boolean f() {
            return this.f764b.getRootAlpha() < 255;
        }

        public Paint e(ColorFilter filter) {
            if (!f() && filter == null) {
                return null;
            }
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                paint.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f764b.getRootAlpha());
            this.l.setColorFilter(filter);
            return this.l;
        }

        public void j(int width, int height) {
            this.f.eraseColor(0);
            Canvas tmpCanvas = new Canvas(this.f);
            this.f764b.b(tmpCanvas, width, height, null);
        }

        public void c(int width, int height) {
            if (this.f == null || !a(width, height)) {
                this.f = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean a(int width, int height) {
            if (width == this.f.getWidth() && height == this.f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (!this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.f764b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void i() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.f764b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public C0054h() {
            this.c = null;
            this.d = h.c;
            this.f764b = new g();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new h(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            return new h(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f763a;
        }

        public boolean g() {
            return this.f764b.f();
        }

        public boolean h(int[] stateSet) {
            boolean changed = this.f764b.g(stateSet);
            this.k |= changed;
            return changed;
        }
    }

    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public static final Matrix f761a = new Matrix();

        /* renamed from: b, reason: collision with root package name */
        public final Path f762b;
        public final Path c;
        public final Matrix d;
        public Paint e;
        public Paint f;
        public PathMeasure g;
        public int h;
        public final d i;
        public float j;
        public float k;
        public float l;
        public float m;
        public int n;
        public String o;
        public Boolean p;
        public final a.e.a<String, Object> q;

        public g() {
            this.d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new a.e.a<>();
            this.i = new d();
            this.f762b = new Path();
            this.c = new Path();
        }

        public void setRootAlpha(int alpha) {
            this.n = alpha;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float alpha) {
            setRootAlpha((int) (255.0f * alpha));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public g(g copy) {
            this.d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            a.e.a<String, Object> aVar = new a.e.a<>();
            this.q = aVar;
            this.i = new d(copy.i, aVar);
            this.f762b = new Path(copy.f762b);
            this.c = new Path(copy.c);
            this.j = copy.j;
            this.k = copy.k;
            this.l = copy.l;
            this.m = copy.m;
            this.h = copy.h;
            this.n = copy.n;
            this.o = copy.o;
            String str = copy.o;
            if (str != null) {
                aVar.put(str, this);
            }
            this.p = copy.p;
        }

        public final void c(d currentGroup, Matrix currentMatrix, Canvas canvas, int w, int h, ColorFilter filter) {
            currentGroup.f757a.set(currentMatrix);
            currentGroup.f757a.preConcat(currentGroup.j);
            canvas.save();
            for (int i = 0; i < currentGroup.f758b.size(); i++) {
                e child = currentGroup.f758b.get(i);
                if (child instanceof d) {
                    d childGroup = (d) child;
                    c(childGroup, currentGroup.f757a, canvas, w, h, filter);
                } else if (child instanceof f) {
                    f childPath = (f) child;
                    d(currentGroup, childPath, canvas, w, h, filter);
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int w, int h, ColorFilter filter) {
            c(this.i, f761a, canvas, w, h, filter);
        }

        public final void d(d vGroup, f vPath, Canvas canvas, int w, int h, ColorFilter filter) {
            float len;
            float scaleX = w / this.l;
            float scaleY = h / this.m;
            float minScale = Math.min(scaleX, scaleY);
            Matrix groupStackedMatrix = vGroup.f757a;
            this.d.set(groupStackedMatrix);
            this.d.postScale(scaleX, scaleY);
            float matrixScale = e(groupStackedMatrix);
            if (matrixScale == 0.0f) {
                return;
            }
            vPath.d(this.f762b);
            Path path = this.f762b;
            this.c.reset();
            if (vPath.c()) {
                this.c.setFillType(vPath.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.c.addPath(path, this.d);
                canvas.clipPath(this.c);
                return;
            }
            c fullPath = (c) vPath;
            float f = fullPath.k;
            if (f != 0.0f || fullPath.l != 1.0f) {
                float f2 = fullPath.m;
                float start = (f + f2) % 1.0f;
                float end = (fullPath.l + f2) % 1.0f;
                if (this.g == null) {
                    this.g = new PathMeasure();
                }
                this.g.setPath(this.f762b, false);
                float len2 = this.g.getLength();
                float start2 = start * len2;
                float end2 = end * len2;
                path.reset();
                if (start2 <= end2) {
                    len = 0.0f;
                    this.g.getSegment(start2, end2, path, true);
                } else {
                    this.g.getSegment(start2, len2, path, true);
                    len = 0.0f;
                    this.g.getSegment(0.0f, end2, path, true);
                }
                path.rLineTo(len, len);
            }
            this.c.addPath(path, this.d);
            if (fullPath.h.l()) {
                a.h.c.c.b fill = fullPath.h;
                if (this.f == null) {
                    Paint paint = new Paint(1);
                    this.f = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint fillPaint = this.f;
                if (fill.h()) {
                    Shader shader = fill.f();
                    shader.setLocalMatrix(this.d);
                    fillPaint.setShader(shader);
                    fillPaint.setAlpha(Math.round(fullPath.j * 255.0f));
                } else {
                    fillPaint.setShader(null);
                    fillPaint.setAlpha(255);
                    fillPaint.setColor(h.a(fill.e(), fullPath.j));
                }
                fillPaint.setColorFilter(filter);
                this.c.setFillType(fullPath.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.c, fillPaint);
            }
            if (fullPath.f.l()) {
                a.h.c.c.b strokeColor = fullPath.f;
                if (this.e == null) {
                    Paint paint2 = new Paint(1);
                    this.e = paint2;
                    paint2.setStyle(Paint.Style.STROKE);
                }
                Paint strokePaint = this.e;
                Paint.Join join = fullPath.o;
                if (join != null) {
                    strokePaint.setStrokeJoin(join);
                }
                Paint.Cap cap = fullPath.n;
                if (cap != null) {
                    strokePaint.setStrokeCap(cap);
                }
                strokePaint.setStrokeMiter(fullPath.p);
                if (strokeColor.h()) {
                    Shader shader2 = strokeColor.f();
                    shader2.setLocalMatrix(this.d);
                    strokePaint.setShader(shader2);
                    strokePaint.setAlpha(Math.round(fullPath.i * 255.0f));
                } else {
                    strokePaint.setShader(null);
                    strokePaint.setAlpha(255);
                    strokePaint.setColor(h.a(strokeColor.e(), fullPath.i));
                }
                strokePaint.setColorFilter(filter);
                float finalStrokeScale = minScale * matrixScale;
                strokePaint.setStrokeWidth(fullPath.g * finalStrokeScale);
                canvas.drawPath(this.c, strokePaint);
            }
        }

        public static float a(float v1x, float v1y, float v2x, float v2y) {
            return (v1x * v2y) - (v1y * v2x);
        }

        public final float e(Matrix groupStackedMatrix) {
            float[] unitVectors = {0.0f, 1.0f, 1.0f, 0.0f};
            groupStackedMatrix.mapVectors(unitVectors);
            float scaleX = (float) Math.hypot(unitVectors[0], unitVectors[1]);
            float scaleY = (float) Math.hypot(unitVectors[2], unitVectors[3]);
            float crossProduct = a(unitVectors[0], unitVectors[1], unitVectors[2], unitVectors[3]);
            float maxScale = Math.max(scaleX, scaleY);
            if (maxScale <= 0.0f) {
                return 0.0f;
            }
            float matrixScale = Math.abs(crossProduct) / maxScale;
            return matrixScale;
        }

        public boolean f() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.i.a());
            }
            return this.p.booleanValue();
        }

        public boolean g(int[] stateSet) {
            return this.i.b(stateSet);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] stateSet) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f757a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<e> f758b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public final Matrix j;
        public int k;
        public int[] l;
        public String m;

        /* JADX WARN: Generic types in debug info not equals: a.e.a != androidx.collection.ArrayMap<java.lang.String, java.lang.Object> */
        public d(d copy, a.e.a<String, Object> aVar) {
            super();
            f newPath;
            this.f757a = new Matrix();
            this.f758b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.m = null;
            this.c = copy.c;
            this.d = copy.d;
            this.e = copy.e;
            this.f = copy.f;
            this.g = copy.g;
            this.h = copy.h;
            this.i = copy.i;
            this.l = copy.l;
            String str = copy.m;
            this.m = str;
            this.k = copy.k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(copy.j);
            ArrayList<e> arrayList = copy.f758b;
            for (int i = 0; i < arrayList.size(); i++) {
                Object copyChild = arrayList.get(i);
                if (copyChild instanceof d) {
                    d copyGroup = (d) copyChild;
                    this.f758b.add(new d(copyGroup, aVar));
                } else {
                    if (copyChild instanceof c) {
                        newPath = new c((c) copyChild);
                    } else if (copyChild instanceof b) {
                        newPath = new b((b) copyChild);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f758b.add(newPath);
                    String str2 = newPath.f760b;
                    if (str2 != null) {
                        aVar.put(str2, newPath);
                    }
                }
            }
        }

        public d() {
            super();
            this.f757a = new Matrix();
            this.f758b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public void c(Resources res, AttributeSet attrs, Resources.Theme theme, XmlPullParser parser) {
            TypedArray a2 = a.h.c.c.g.k(res, theme, attrs, a.t.a.a.a.f747b);
            e(a2, parser);
            a2.recycle();
        }

        public final void e(TypedArray a2, XmlPullParser parser) {
            this.l = null;
            this.c = a.h.c.c.g.f(a2, parser, "rotation", 5, this.c);
            this.d = a2.getFloat(1, this.d);
            this.e = a2.getFloat(2, this.e);
            this.f = a.h.c.c.g.f(a2, parser, "scaleX", 3, this.f);
            this.g = a.h.c.c.g.f(a2, parser, "scaleY", 4, this.g);
            this.h = a.h.c.c.g.f(a2, parser, "translateX", 6, this.h);
            this.i = a.h.c.c.g.f(a2, parser, "translateY", 7, this.i);
            String groupName = a2.getString(0);
            if (groupName != null) {
                this.m = groupName;
            }
            d();
        }

        public final void d() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public float getRotation() {
            return this.c;
        }

        public void setRotation(float rotation) {
            if (rotation != this.c) {
                this.c = rotation;
                d();
            }
        }

        public float getPivotX() {
            return this.d;
        }

        public void setPivotX(float pivotX) {
            if (pivotX != this.d) {
                this.d = pivotX;
                d();
            }
        }

        public float getPivotY() {
            return this.e;
        }

        public void setPivotY(float pivotY) {
            if (pivotY != this.e) {
                this.e = pivotY;
                d();
            }
        }

        public float getScaleX() {
            return this.f;
        }

        public void setScaleX(float scaleX) {
            if (scaleX != this.f) {
                this.f = scaleX;
                d();
            }
        }

        public float getScaleY() {
            return this.g;
        }

        public void setScaleY(float scaleY) {
            if (scaleY != this.g) {
                this.g = scaleY;
                d();
            }
        }

        public float getTranslateX() {
            return this.h;
        }

        public void setTranslateX(float translateX) {
            if (translateX != this.h) {
                this.h = translateX;
                d();
            }
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setTranslateY(float translateY) {
            if (translateY != this.i) {
                this.i = translateY;
                d();
            }
        }

        @Override // a.t.a.a.h.e
        public boolean a() {
            for (int i = 0; i < this.f758b.size(); i++) {
                if (this.f758b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // a.t.a.a.h.e
        public boolean b(int[] stateSet) {
            boolean changed = false;
            for (int i = 0; i < this.f758b.size(); i++) {
                changed |= this.f758b.get(i).b(stateSet);
            }
            return changed;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f extends e {

        /* renamed from: a, reason: collision with root package name */
        public c.b[] f759a;

        /* renamed from: b, reason: collision with root package name */
        public String f760b;
        public int c;
        public int d;

        public f() {
            super();
            this.f759a = null;
            this.c = 0;
        }

        public f(f copy) {
            super();
            this.f759a = null;
            this.c = 0;
            this.f760b = copy.f760b;
            this.d = copy.d;
            this.f759a = a.h.d.c.f(copy.f759a);
        }

        public void d(Path path) {
            path.reset();
            c.b[] bVarArr = this.f759a;
            if (bVarArr != null) {
                c.b.e(bVarArr, path);
            }
        }

        public String getPathName() {
            return this.f760b;
        }

        public boolean c() {
            return false;
        }

        public c.b[] getPathData() {
            return this.f759a;
        }

        public void setPathData(c.b[] nodes) {
            if (!a.h.d.c.b(this.f759a, nodes)) {
                this.f759a = a.h.d.c.f(nodes);
            } else {
                a.h.d.c.j(this.f759a, nodes);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends f {
        public b() {
        }

        public b(b copy) {
            super(copy);
        }

        public void e(Resources r, AttributeSet attrs, Resources.Theme theme, XmlPullParser parser) {
            boolean hasPathData = a.h.c.c.g.j(parser, "pathData");
            if (!hasPathData) {
                return;
            }
            TypedArray a2 = a.h.c.c.g.k(r, theme, attrs, a.t.a.a.a.d);
            f(a2, parser);
            a2.recycle();
        }

        public final void f(TypedArray a2, XmlPullParser parser) {
            String pathName = a2.getString(0);
            if (pathName != null) {
                this.f760b = pathName;
            }
            String pathData = a2.getString(1);
            if (pathData != null) {
                this.f759a = a.h.d.c.d(pathData);
            }
            this.c = a.h.c.c.g.g(a2, parser, "fillType", 2, 0);
        }

        @Override // a.t.a.a.h.f
        public boolean c() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends f {
        public int[] e;
        public a.h.c.c.b f;
        public float g;
        public a.h.c.c.b h;
        public float i;
        public float j;
        public float k;
        public float l;
        public float m;
        public Paint.Cap n;
        public Paint.Join o;
        public float p;

        public c() {
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        public c(c copy) {
            super(copy);
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.e = copy.e;
            this.f = copy.f;
            this.g = copy.g;
            this.i = copy.i;
            this.h = copy.h;
            this.c = copy.c;
            this.j = copy.j;
            this.k = copy.k;
            this.l = copy.l;
            this.m = copy.m;
            this.n = copy.n;
            this.o = copy.o;
            this.p = copy.p;
        }

        public final Paint.Cap e(int id, Paint.Cap defValue) {
            switch (id) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return defValue;
            }
        }

        public final Paint.Join f(int id, Paint.Join defValue) {
            switch (id) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return defValue;
            }
        }

        public void g(Resources r, AttributeSet attrs, Resources.Theme theme, XmlPullParser parser) {
            TypedArray a2 = a.h.c.c.g.k(r, theme, attrs, a.t.a.a.a.c);
            h(a2, parser, theme);
            a2.recycle();
        }

        public final void h(TypedArray a2, XmlPullParser parser, Resources.Theme theme) {
            this.e = null;
            boolean hasPathData = a.h.c.c.g.j(parser, "pathData");
            if (!hasPathData) {
                return;
            }
            String pathName = a2.getString(0);
            if (pathName != null) {
                this.f760b = pathName;
            }
            String pathData = a2.getString(2);
            if (pathData != null) {
                this.f759a = a.h.d.c.d(pathData);
            }
            this.h = a.h.c.c.g.e(a2, parser, theme, "fillColor", 1, 0);
            this.j = a.h.c.c.g.f(a2, parser, "fillAlpha", 12, this.j);
            int lineCap = a.h.c.c.g.g(a2, parser, "strokeLineCap", 8, -1);
            this.n = e(lineCap, this.n);
            int lineJoin = a.h.c.c.g.g(a2, parser, "strokeLineJoin", 9, -1);
            this.o = f(lineJoin, this.o);
            this.p = a.h.c.c.g.f(a2, parser, "strokeMiterLimit", 10, this.p);
            this.f = a.h.c.c.g.e(a2, parser, theme, "strokeColor", 3, 0);
            this.i = a.h.c.c.g.f(a2, parser, "strokeAlpha", 11, this.i);
            this.g = a.h.c.c.g.f(a2, parser, "strokeWidth", 4, this.g);
            this.l = a.h.c.c.g.f(a2, parser, "trimPathEnd", 6, this.l);
            this.m = a.h.c.c.g.f(a2, parser, "trimPathOffset", 7, this.m);
            this.k = a.h.c.c.g.f(a2, parser, "trimPathStart", 5, this.k);
            this.c = a.h.c.c.g.g(a2, parser, "fillType", 13, this.c);
        }

        @Override // a.t.a.a.h.e
        public boolean a() {
            return this.h.i() || this.f.i();
        }

        @Override // a.t.a.a.h.e
        public boolean b(int[] stateSet) {
            boolean changed = this.h.j(stateSet);
            return changed | this.f.j(stateSet);
        }

        public int getStrokeColor() {
            return this.f.e();
        }

        public void setStrokeColor(int strokeColor) {
            this.f.k(strokeColor);
        }

        public float getStrokeWidth() {
            return this.g;
        }

        public void setStrokeWidth(float strokeWidth) {
            this.g = strokeWidth;
        }

        public float getStrokeAlpha() {
            return this.i;
        }

        public void setStrokeAlpha(float strokeAlpha) {
            this.i = strokeAlpha;
        }

        public int getFillColor() {
            return this.h.e();
        }

        public void setFillColor(int fillColor) {
            this.h.k(fillColor);
        }

        public float getFillAlpha() {
            return this.j;
        }

        public void setFillAlpha(float fillAlpha) {
            this.j = fillAlpha;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public void setTrimPathStart(float trimPathStart) {
            this.k = trimPathStart;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public void setTrimPathEnd(float trimPathEnd) {
            this.l = trimPathEnd;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public void setTrimPathOffset(float trimPathOffset) {
            this.m = trimPathOffset;
        }
    }
}
