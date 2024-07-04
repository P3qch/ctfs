package b.b.a.a.u;

import a.h.c.c.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f1084a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f1085b;
    public final String c;
    public final int d;
    public final int e;
    public final float f;
    public final float g;
    public final float h;
    public final boolean i;
    public final float j;
    public float k;
    public final int l;
    public boolean m = false;
    public Typeface n;

    public d(Context context, int id) {
        TypedArray a2 = context.obtainStyledAttributes(id, b.b.a.a.a.z);
        int[] iArr = b.b.a.a.a.f942a;
        this.k = a2.getDimension(0, 0.0f);
        this.f1084a = c.a(context, a2, 3);
        c.a(context, a2, 4);
        c.a(context, a2, 5);
        this.d = a2.getInt(2, 0);
        this.e = a2.getInt(1, 1);
        int fontFamilyIndex = c.e(a2, 12, 10);
        this.l = a2.getResourceId(fontFamilyIndex, 0);
        this.c = a2.getString(fontFamilyIndex);
        a2.getBoolean(14, false);
        this.f1085b = c.a(context, a2, 6);
        this.f = a2.getFloat(7, 0.0f);
        this.g = a2.getFloat(8, 0.0f);
        this.h = a2.getFloat(9, 0.0f);
        a2.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray a3 = context.obtainStyledAttributes(id, b.b.a.a.a.s);
            this.i = a3.hasValue(0);
            this.j = a3.getFloat(0, 0.0f);
            a3.recycle();
            return;
        }
        this.i = false;
        this.j = 0.0f;
    }

    public Typeface f(Context context) {
        if (this.m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface c = a.h.c.c.f.c(context, this.l);
                this.n = c;
                if (c != null) {
                    this.n = Typeface.create(c, this.d);
                }
            } catch (Resources.NotFoundException e) {
            } catch (UnsupportedOperationException e2) {
            } catch (Exception e3) {
                Log.d("TextAppearance", "Error loading font " + this.c, e3);
            }
        }
        d();
        this.m = true;
        return this.n;
    }

    public void h(Context context, f callback) {
        if (i(context)) {
            f(context);
        } else {
            d();
        }
        int i = this.l;
        if (i == 0) {
            this.m = true;
        }
        if (this.m) {
            callback.b(this.n, true);
            return;
        }
        try {
            a.h.c.c.f.e(context, i, new a(callback), null);
        } catch (Resources.NotFoundException e) {
            this.m = true;
            callback.a(1);
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.c, e2);
            this.m = true;
            callback.a(-3);
        }
    }

    /* loaded from: classes.dex */
    public class a extends f.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f1086a;

        public a(f fVar) {
            this.f1086a = fVar;
        }

        @Override // a.h.c.c.f.a
        public void e(Typeface typeface) {
            d dVar = d.this;
            dVar.n = Typeface.create(typeface, dVar.d);
            d.this.m = true;
            this.f1086a.b(d.this.n, false);
        }

        @Override // a.h.c.c.f.a
        public void d(int reason) {
            d.this.m = true;
            this.f1086a.a(reason);
        }
    }

    public void g(Context context, TextPaint textPaint, f callback) {
        l(textPaint, e());
        h(context, new b(textPaint, callback));
    }

    /* loaded from: classes.dex */
    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextPaint f1088a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f1089b;

        public b(TextPaint textPaint, f fVar) {
            this.f1088a = textPaint;
            this.f1089b = fVar;
        }

        @Override // b.b.a.a.u.f
        public void b(Typeface typeface, boolean fontResolvedSynchronously) {
            d.this.l(this.f1088a, typeface);
            this.f1089b.b(typeface, fontResolvedSynchronously);
        }

        @Override // b.b.a.a.u.f
        public void a(int i) {
            this.f1089b.a(i);
        }
    }

    public Typeface e() {
        d();
        return this.n;
    }

    public final void d() {
        String str;
        if (this.n == null && (str = this.c) != null) {
            this.n = Typeface.create(str, this.d);
        }
        if (this.n == null) {
            switch (this.e) {
                case 1:
                    this.n = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.n = Typeface.SERIF;
                    break;
                case 3:
                    this.n = Typeface.MONOSPACE;
                    break;
                default:
                    this.n = Typeface.DEFAULT;
                    break;
            }
            this.n = Typeface.create(this.n, this.d);
        }
    }

    public void j(Context context, TextPaint textPaint, f callback) {
        k(context, textPaint, callback);
        ColorStateList colorStateList = this.f1084a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.h;
        float f2 = this.f;
        float f3 = this.g;
        ColorStateList colorStateList2 = this.f1085b;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void k(Context context, TextPaint textPaint, f callback) {
        if (i(context)) {
            l(textPaint, f(context));
        } else {
            g(context, textPaint, callback);
        }
    }

    public void l(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int fake = this.d & (typeface.getStyle() ^ (-1));
        textPaint.setFakeBoldText((fake & 1) != 0);
        textPaint.setTextSkewX((fake & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.k);
        if (Build.VERSION.SDK_INT >= 21 && this.i) {
            textPaint.setLetterSpacing(this.j);
        }
    }

    public final boolean i(Context context) {
        e.a();
        int i = this.l;
        Typeface typeface = i != 0 ? a.h.c.c.f.a(context, i) : null;
        return typeface != null;
    }
}
