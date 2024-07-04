package b.b.a.a.r;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1070a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f1071b;
    public static Constructor<StaticLayout> c;
    public static Object d;
    public CharSequence e;
    public final TextPaint f;
    public final int g;
    public int i;
    public boolean p;
    public int h = 0;
    public Layout.Alignment j = Layout.Alignment.ALIGN_NORMAL;
    public int k = Integer.MAX_VALUE;
    public float l = 0.0f;
    public float m = 1.0f;
    public int n = f1070a;
    public boolean o = true;
    public TextUtils.TruncateAt q = null;

    static {
        f1070a = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    public g(CharSequence source, TextPaint paint, int width) {
        this.e = source;
        this.f = paint;
        this.g = width;
        this.i = source.length();
    }

    public static g c(CharSequence source, TextPaint paint, int width) {
        return new g(source, paint, width);
    }

    public g d(Layout.Alignment alignment) {
        this.j = alignment;
        return this;
    }

    public g g(boolean includePad) {
        this.o = includePad;
        return this;
    }

    public g j(int maxLines) {
        this.k = maxLines;
        return this;
    }

    public g i(float spacingAdd, float lineSpacingMultiplier) {
        this.l = spacingAdd;
        this.m = lineSpacingMultiplier;
        return this;
    }

    public g f(int hyphenationFrequency) {
        this.n = hyphenationFrequency;
        return this;
    }

    public g e(TextUtils.TruncateAt ellipsize) {
        this.q = ellipsize;
        return this;
    }

    public StaticLayout a() {
        if (this.e == null) {
            this.e = BuildConfig.FLAVOR;
        }
        int availableWidth = Math.max(0, this.g);
        CharSequence textToDraw = this.e;
        if (this.k == 1) {
            textToDraw = TextUtils.ellipsize(this.e, this.f, availableWidth, this.q);
        }
        int min = Math.min(textToDraw.length(), this.i);
        this.i = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.p && this.k == 1) {
                this.j = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder builder = StaticLayout.Builder.obtain(textToDraw, 0, min, this.f, availableWidth);
            builder.setAlignment(this.j);
            builder.setIncludePad(this.o);
            TextDirectionHeuristic textDirectionHeuristic = this.p ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            builder.setTextDirection(textDirectionHeuristic);
            TextUtils.TruncateAt truncateAt = this.q;
            if (truncateAt != null) {
                builder.setEllipsize(truncateAt);
            }
            builder.setMaxLines(this.k);
            float f = this.l;
            if (f != 0.0f || this.m != 1.0f) {
                builder.setLineSpacing(f, this.m);
            }
            if (this.k > 1) {
                builder.setHyphenationFrequency(this.n);
            }
            return builder.build();
        }
        b();
        try {
            Constructor<StaticLayout> constructor = c;
            a.h.j.i.e(constructor);
            Object obj = d;
            a.h.j.i.e(obj);
            return constructor.newInstance(textToDraw, 0, Integer.valueOf(this.i), this.f, Integer.valueOf(availableWidth), this.j, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.o), null, Integer.valueOf(availableWidth), Integer.valueOf(this.k));
        } catch (Exception cause) {
            throw new a(cause);
        }
    }

    public final void b() {
        Class<?> textDirClass;
        if (f1071b) {
            return;
        }
        try {
            boolean useRtl = this.p && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                textDirClass = TextDirectionHeuristic.class;
                d = useRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader loader = g.class.getClassLoader();
                String textDirClassName = this.p ? "RTL" : "LTR";
                Class<?> textDirClass2 = loader.loadClass("android.text.TextDirectionHeuristic");
                Class<?> textDirsClass = loader.loadClass("android.text.TextDirectionHeuristics");
                d = textDirsClass.getField(textDirClassName).get(textDirsClass);
                textDirClass = textDirClass2;
            }
            Class<?> cls = Integer.TYPE;
            Class<?> cls2 = Float.TYPE;
            Class<?>[] signature = {CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, textDirClass, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls};
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(signature);
            c = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f1071b = true;
        } catch (Exception cause) {
            throw new a(cause);
        }
    }

    public g h(boolean isRtl) {
        this.p = isRtl;
        return this;
    }

    /* loaded from: classes.dex */
    public static class a extends Exception {
        public a(Throwable cause) {
            super("Error thrown initializing StaticLayout " + cause.getMessage(), cause);
        }
    }
}
