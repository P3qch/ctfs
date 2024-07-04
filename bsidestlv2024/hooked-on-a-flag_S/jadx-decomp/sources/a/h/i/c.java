package a.h.i;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes.dex */
public class c implements Spannable {
    static {
        new Object();
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextPaint f416a;

        /* renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f417b;
        public final int c;
        public final int d;

        /* renamed from: a.h.i.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0026a {

            /* renamed from: a, reason: collision with root package name */
            public final TextPaint f418a;

            /* renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f419b;
            public int c;
            public int d;

            public C0026a(TextPaint paint) {
                this.f418a = paint;
                int i = Build.VERSION.SDK_INT;
                if (i >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                if (i >= 18) {
                    this.f419b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f419b = null;
                }
            }

            public C0026a b(int strategy) {
                this.c = strategy;
                return this;
            }

            public C0026a c(int frequency) {
                this.d = frequency;
                return this;
            }

            public C0026a d(TextDirectionHeuristic textDir) {
                this.f419b = textDir;
                return this;
            }

            public a a() {
                return new a(this.f418a, this.f419b, this.c, this.d);
            }
        }

        @SuppressLint({"NewApi"})
        public a(TextPaint paint, TextDirectionHeuristic textDir, int strategy, int frequency) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(paint).setBreakStrategy(strategy).setHyphenationFrequency(frequency).setTextDirection(textDir).build();
            }
            this.f416a = paint;
            this.f417b = textDir;
            this.c = strategy;
            this.d = frequency;
        }

        public a(PrecomputedText.Params wrapped) {
            this.f416a = wrapped.getTextPaint();
            this.f417b = wrapped.getTextDirection();
            this.c = wrapped.getBreakStrategy();
            this.d = wrapped.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }

        public TextPaint e() {
            return this.f416a;
        }

        public TextDirectionHeuristic d() {
            return this.f417b;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public boolean a(a other) {
            int i = Build.VERSION.SDK_INT;
            if ((i >= 23 && (this.c != other.b() || this.d != other.c())) || this.f416a.getTextSize() != other.e().getTextSize() || this.f416a.getTextScaleX() != other.e().getTextScaleX() || this.f416a.getTextSkewX() != other.e().getTextSkewX()) {
                return false;
            }
            if ((i >= 21 && (this.f416a.getLetterSpacing() != other.e().getLetterSpacing() || !TextUtils.equals(this.f416a.getFontFeatureSettings(), other.e().getFontFeatureSettings()))) || this.f416a.getFlags() != other.e().getFlags()) {
                return false;
            }
            if (i >= 24) {
                if (!this.f416a.getTextLocales().equals(other.e().getTextLocales())) {
                    return false;
                }
            } else if (i >= 17 && !this.f416a.getTextLocale().equals(other.e().getTextLocale())) {
                return false;
            }
            return this.f416a.getTypeface() == null ? other.e().getTypeface() == null : this.f416a.getTypeface().equals(other.e().getTypeface());
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            a other = (a) o;
            if (a(other)) {
                return Build.VERSION.SDK_INT < 18 || this.f417b == other.d();
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return a.h.j.d.b(Float.valueOf(this.f416a.getTextSize()), Float.valueOf(this.f416a.getTextScaleX()), Float.valueOf(this.f416a.getTextSkewX()), Float.valueOf(this.f416a.getLetterSpacing()), Integer.valueOf(this.f416a.getFlags()), this.f416a.getTextLocales(), this.f416a.getTypeface(), Boolean.valueOf(this.f416a.isElegantTextHeight()), this.f417b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 21) {
                return a.h.j.d.b(Float.valueOf(this.f416a.getTextSize()), Float.valueOf(this.f416a.getTextScaleX()), Float.valueOf(this.f416a.getTextSkewX()), Float.valueOf(this.f416a.getLetterSpacing()), Integer.valueOf(this.f416a.getFlags()), this.f416a.getTextLocale(), this.f416a.getTypeface(), Boolean.valueOf(this.f416a.isElegantTextHeight()), this.f417b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 18) {
                return a.h.j.d.b(Float.valueOf(this.f416a.getTextSize()), Float.valueOf(this.f416a.getTextScaleX()), Float.valueOf(this.f416a.getTextSkewX()), Integer.valueOf(this.f416a.getFlags()), this.f416a.getTextLocale(), this.f416a.getTypeface(), this.f417b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 17) {
                return a.h.j.d.b(Float.valueOf(this.f416a.getTextSize()), Float.valueOf(this.f416a.getTextScaleX()), Float.valueOf(this.f416a.getTextSkewX()), Integer.valueOf(this.f416a.getFlags()), this.f416a.getTextLocale(), this.f416a.getTypeface(), this.f417b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            return a.h.j.d.b(Float.valueOf(this.f416a.getTextSize()), Float.valueOf(this.f416a.getTextScaleX()), Float.valueOf(this.f416a.getTextSkewX()), Integer.valueOf(this.f416a.getFlags()), this.f416a.getTypeface(), this.f417b, Integer.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f416a.getTextSize());
            sb.append(", textScaleX=" + this.f416a.getTextScaleX());
            sb.append(", textSkewX=" + this.f416a.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                sb.append(", letterSpacing=" + this.f416a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f416a.isElegantTextHeight());
            }
            if (i >= 24) {
                sb.append(", textLocale=" + this.f416a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.f416a.getTextLocale());
            }
            sb.append(", typeface=" + this.f416a.getTypeface());
            if (i >= 26) {
                sb.append(", variationSettings=" + this.f416a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f417b);
            sb.append(", breakStrategy=" + this.c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }
    }

    public PrecomputedText b() {
        return null;
    }

    public a a() {
        return null;
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object what, int start, int end, int flags) {
        if (what instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        PrecomputedText precomputedText = null;
        if (Build.VERSION.SDK_INT >= 29) {
            precomputedText.setSpan(what, start, end, flags);
            throw null;
        }
        precomputedText.setSpan(what, start, end, flags);
        throw null;
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object what) {
        if (what instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        PrecomputedText precomputedText = null;
        if (Build.VERSION.SDK_INT >= 29) {
            precomputedText.removeSpan(what);
            throw null;
        }
        precomputedText.removeSpan(what);
        throw null;
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int start, int end, Class<T> type) {
        PrecomputedText precomputedText = null;
        if (Build.VERSION.SDK_INT >= 29) {
            precomputedText.getSpans(start, end, type);
            throw null;
        }
        precomputedText.getSpans(start, end, type);
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object tag) {
        Spannable spannable = null;
        spannable.getSpanStart(tag);
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object tag) {
        Spannable spannable = null;
        spannable.getSpanEnd(tag);
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object tag) {
        Spannable spannable = null;
        spannable.getSpanFlags(tag);
        throw null;
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int start, int limit, Class type) {
        Spannable spannable = null;
        spannable.nextSpanTransition(start, limit, type);
        throw null;
    }

    @Override // java.lang.CharSequence
    public int length() {
        Spannable spannable = null;
        spannable.length();
        throw null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int index) {
        Spannable spannable = null;
        spannable.charAt(index);
        throw null;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int start, int end) {
        Spannable spannable = null;
        spannable.subSequence(start, end);
        throw null;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        Object obj = null;
        obj.toString();
        throw null;
    }
}
