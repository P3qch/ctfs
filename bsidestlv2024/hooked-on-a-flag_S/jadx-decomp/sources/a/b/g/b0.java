package a.b.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final RectF f130a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Method> f131b = new ConcurrentHashMap<>();

    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Field> c = new ConcurrentHashMap<>();
    public int d = 0;
    public boolean e = false;
    public float f = -1.0f;
    public float g = -1.0f;
    public float h = -1.0f;
    public int[] i = new int[0];
    public boolean j = false;
    public TextPaint k;
    public final TextView l;
    public final Context m;
    public final c n;

    /* loaded from: classes.dex */
    public static class c {
        public boolean b(TextView textView) {
            return ((Boolean) b0.o(textView, "getHorizontallyScrolling", false)).booleanValue();
        }

        public void a(StaticLayout.Builder layoutBuilder, TextView textView) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends c {
        @Override // a.b.g.b0.c
        public void a(StaticLayout.Builder layoutBuilder, TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) b0.o(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
            layoutBuilder.setTextDirection(textDirectionHeuristic);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        @Override // a.b.g.b0.c
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        @Override // a.b.g.b0.a, a.b.g.b0.c
        public void a(StaticLayout.Builder layoutBuilder, TextView textView) {
            layoutBuilder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    public b0(TextView textView) {
        this.l = textView;
        this.m = textView.getContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            this.n = new b();
        } else if (i >= 23) {
            this.n = new a();
        } else {
            this.n = new c();
        }
    }

    public void q(AttributeSet attrs, int defStyleAttr) {
        int autoSizeStepSizeArrayResId;
        float autoSizeMinTextSizeInPx = -1.0f;
        float autoSizeMaxTextSizeInPx = -1.0f;
        float autoSizeStepGranularityInPx = -1.0f;
        Context context = this.m;
        int[] iArr = a.b.a.i;
        TypedArray a2 = context.obtainStyledAttributes(attrs, iArr, defStyleAttr, 0);
        TextView textView = this.l;
        a.h.k.v.m0(textView, textView.getContext(), iArr, attrs, a2, defStyleAttr, 0);
        int[] iArr2 = a.b.a.f11a;
        if (a2.hasValue(5)) {
            this.d = a2.getInt(5, 0);
        }
        if (a2.hasValue(4)) {
            autoSizeStepGranularityInPx = a2.getDimension(4, -1.0f);
        }
        if (a2.hasValue(2)) {
            autoSizeMinTextSizeInPx = a2.getDimension(2, -1.0f);
        }
        if (a2.hasValue(1)) {
            autoSizeMaxTextSizeInPx = a2.getDimension(1, -1.0f);
        }
        if (a2.hasValue(3) && (autoSizeStepSizeArrayResId = a2.getResourceId(3, 0)) > 0) {
            TypedArray autoSizePreDefTextSizes = a2.getResources().obtainTypedArray(autoSizeStepSizeArrayResId);
            x(autoSizePreDefTextSizes);
            autoSizePreDefTextSizes.recycle();
        }
        a2.recycle();
        if (A()) {
            if (this.d == 1) {
                if (!this.j) {
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    if (autoSizeMinTextSizeInPx == -1.0f) {
                        autoSizeMinTextSizeInPx = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (autoSizeMaxTextSizeInPx == -1.0f) {
                        autoSizeMaxTextSizeInPx = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (autoSizeStepGranularityInPx == -1.0f) {
                        autoSizeStepGranularityInPx = 1.0f;
                    }
                    B(autoSizeMinTextSizeInPx, autoSizeMaxTextSizeInPx, autoSizeStepGranularityInPx);
                }
                w();
                return;
            }
            return;
        }
        this.d = 0;
    }

    public void t(int autoSizeTextType) {
        if (A()) {
            switch (autoSizeTextType) {
                case 0:
                    c();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    float autoSizeMinTextSizeInPx = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    float autoSizeMaxTextSizeInPx = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    B(autoSizeMinTextSizeInPx, autoSizeMaxTextSizeInPx, 1.0f);
                    if (w()) {
                        a();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: " + autoSizeTextType);
            }
        }
    }

    public void r(int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) {
        if (A()) {
            DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
            float autoSizeMinTextSizeInPx = TypedValue.applyDimension(unit, autoSizeMinTextSize, displayMetrics);
            float autoSizeMaxTextSizeInPx = TypedValue.applyDimension(unit, autoSizeMaxTextSize, displayMetrics);
            float autoSizeStepGranularityInPx = TypedValue.applyDimension(unit, autoSizeStepGranularity, displayMetrics);
            B(autoSizeMinTextSizeInPx, autoSizeMaxTextSizeInPx, autoSizeStepGranularityInPx);
            if (w()) {
                a();
            }
        }
    }

    public void s(int[] presetSizes, int unit) {
        if (A()) {
            int presetSizesLength = presetSizes.length;
            if (presetSizesLength > 0) {
                int[] presetSizesInPx = new int[presetSizesLength];
                if (unit == 0) {
                    presetSizesInPx = Arrays.copyOf(presetSizes, presetSizesLength);
                } else {
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    for (int i = 0; i < presetSizesLength; i++) {
                        presetSizesInPx[i] = Math.round(TypedValue.applyDimension(unit, presetSizes[i], displayMetrics));
                    }
                }
                this.i = b(presetSizesInPx);
                if (!y()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(presetSizes));
                }
            } else {
                this.j = false;
            }
            if (w()) {
                a();
            }
        }
    }

    public int l() {
        return this.d;
    }

    public int j() {
        return Math.round(this.f);
    }

    public int i() {
        return Math.round(this.g);
    }

    public int h() {
        return Math.round(this.h);
    }

    public int[] k() {
        return this.i;
    }

    public final void x(TypedArray textSizes) {
        int textSizesLength = textSizes.length();
        int[] parsedSizes = new int[textSizesLength];
        if (textSizesLength > 0) {
            for (int i = 0; i < textSizesLength; i++) {
                parsedSizes[i] = textSizes.getDimensionPixelSize(i, -1);
            }
            this.i = b(parsedSizes);
            y();
        }
    }

    public final boolean y() {
        int sizesLength = this.i.length;
        boolean z = sizesLength > 0;
        this.j = z;
        if (z) {
            this.d = 1;
            this.g = r0[0];
            this.h = r0[sizesLength - 1];
            this.f = -1.0f;
        }
        return z;
    }

    public final int[] b(int[] presetValues) {
        int presetValuesLength = presetValues.length;
        if (presetValuesLength == 0) {
            return presetValues;
        }
        Arrays.sort(presetValues);
        List<Integer> uniqueValidSizes = new ArrayList<>();
        for (int currentPresetValue : presetValues) {
            if (currentPresetValue > 0 && Collections.binarySearch(uniqueValidSizes, Integer.valueOf(currentPresetValue)) < 0) {
                uniqueValidSizes.add(Integer.valueOf(currentPresetValue));
            }
        }
        int i = uniqueValidSizes.size();
        if (presetValuesLength == i) {
            return presetValues;
        }
        int uniqueValidSizesLength = uniqueValidSizes.size();
        int[] cleanedUpSizes = new int[uniqueValidSizesLength];
        for (int i2 = 0; i2 < uniqueValidSizesLength; i2++) {
            cleanedUpSizes[i2] = uniqueValidSizes.get(i2).intValue();
        }
        return cleanedUpSizes;
    }

    public final void B(float autoSizeMinTextSizeInPx, float autoSizeMaxTextSizeInPx, float autoSizeStepGranularityInPx) {
        if (autoSizeMinTextSizeInPx <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + autoSizeMinTextSizeInPx + "px) is less or equal to (0px)");
        }
        if (autoSizeMaxTextSizeInPx <= autoSizeMinTextSizeInPx) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + autoSizeMaxTextSizeInPx + "px) is less or equal to minimum auto-size text size (" + autoSizeMinTextSizeInPx + "px)");
        }
        if (autoSizeStepGranularityInPx <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + autoSizeStepGranularityInPx + "px) is less or equal to (0px)");
        }
        this.d = 1;
        this.g = autoSizeMinTextSizeInPx;
        this.h = autoSizeMaxTextSizeInPx;
        this.f = autoSizeStepGranularityInPx;
        this.j = false;
    }

    public final boolean w() {
        if (A() && this.d == 1) {
            if (!this.j || this.i.length == 0) {
                int autoSizeValuesLength = ((int) Math.floor((this.h - this.g) / this.f)) + 1;
                int[] autoSizeTextSizesInPx = new int[autoSizeValuesLength];
                for (int i = 0; i < autoSizeValuesLength; i++) {
                    autoSizeTextSizesInPx[i] = Math.round(this.g + (i * this.f));
                }
                this.i = b(autoSizeTextSizesInPx);
            }
            this.e = true;
        } else {
            this.e = false;
        }
        return this.e;
    }

    public void a() {
        int availableWidth;
        if (!p()) {
            return;
        }
        if (this.e) {
            if (this.l.getMeasuredHeight() <= 0 || this.l.getMeasuredWidth() <= 0) {
                return;
            }
            boolean horizontallyScrolling = this.n.b(this.l);
            if (horizontallyScrolling) {
                availableWidth = 1048576;
            } else {
                availableWidth = (this.l.getMeasuredWidth() - this.l.getTotalPaddingLeft()) - this.l.getTotalPaddingRight();
            }
            int availableHeight = (this.l.getHeight() - this.l.getCompoundPaddingBottom()) - this.l.getCompoundPaddingTop();
            if (availableWidth <= 0 || availableHeight <= 0) {
                return;
            }
            RectF rectF = f130a;
            synchronized (rectF) {
                rectF.setEmpty();
                rectF.right = availableWidth;
                rectF.bottom = availableHeight;
                float optimalTextSize = g(rectF);
                if (optimalTextSize != this.l.getTextSize()) {
                    v(0, optimalTextSize);
                }
            }
        }
        this.e = true;
    }

    public final void c() {
        this.d = 0;
        this.g = -1.0f;
        this.h = -1.0f;
        this.f = -1.0f;
        this.i = new int[0];
        this.e = false;
    }

    public void v(int unit, float size) {
        Resources res;
        Context context = this.m;
        if (context == null) {
            res = Resources.getSystem();
        } else {
            res = context.getResources();
        }
        u(TypedValue.applyDimension(unit, size, res.getDisplayMetrics()));
    }

    public final void u(float size) {
        if (size != this.l.getPaint().getTextSize()) {
            this.l.getPaint().setTextSize(size);
            boolean isInLayout = false;
            if (Build.VERSION.SDK_INT >= 18) {
                isInLayout = this.l.isInLayout();
            }
            if (this.l.getLayout() != null) {
                this.e = false;
                try {
                    Method method = m("nullLayouts");
                    if (method != null) {
                        method.invoke(this.l, new Object[0]);
                    }
                } catch (Exception ex) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", ex);
                }
                if (!isInLayout) {
                    this.l.requestLayout();
                } else {
                    this.l.forceLayout();
                }
                this.l.invalidate();
            }
        }
    }

    public final int g(RectF availableSpace) {
        int sizesCount = this.i.length;
        if (sizesCount == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int bestSizeIndex = 0;
        int lowIndex = 0 + 1;
        int highIndex = sizesCount - 1;
        while (lowIndex <= highIndex) {
            int sizeToTryIndex = (lowIndex + highIndex) / 2;
            if (z(this.i[sizeToTryIndex], availableSpace)) {
                bestSizeIndex = lowIndex;
                lowIndex = sizeToTryIndex + 1;
            } else {
                highIndex = sizeToTryIndex - 1;
                bestSizeIndex = highIndex;
            }
        }
        return this.i[bestSizeIndex];
    }

    public void n(int suggestedSizeInPx) {
        TextPaint textPaint = this.k;
        if (textPaint == null) {
            this.k = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.k.set(this.l.getPaint());
        this.k.setTextSize(suggestedSizeInPx);
    }

    public StaticLayout d(CharSequence text, Layout.Alignment alignment, int availableWidth, int maxLines) {
        if (Build.VERSION.SDK_INT >= 23) {
            return e(text, alignment, availableWidth, maxLines);
        }
        return f(text, alignment, availableWidth);
    }

    public final boolean z(int suggestedSizeInPx, RectF availableSpace) {
        CharSequence transformedText;
        CharSequence text = this.l.getText();
        TransformationMethod transformationMethod = this.l.getTransformationMethod();
        if (transformationMethod != null && (transformedText = transformationMethod.getTransformation(text, this.l)) != null) {
            text = transformedText;
        }
        int maxLines = this.l.getMaxLines();
        n(suggestedSizeInPx);
        Layout.Alignment alignment = (Layout.Alignment) o(this.l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
        StaticLayout layout = d(text, alignment, Math.round(availableSpace.right), maxLines);
        return (maxLines == -1 || (layout.getLineCount() <= maxLines && layout.getLineEnd(layout.getLineCount() - 1) == text.length())) && ((float) layout.getHeight()) <= availableSpace.bottom;
    }

    public final StaticLayout e(CharSequence text, Layout.Alignment alignment, int availableWidth, int maxLines) {
        StaticLayout.Builder layoutBuilder = StaticLayout.Builder.obtain(text, 0, text.length(), this.k, availableWidth);
        layoutBuilder.setAlignment(alignment).setLineSpacing(this.l.getLineSpacingExtra(), this.l.getLineSpacingMultiplier()).setIncludePad(this.l.getIncludeFontPadding()).setBreakStrategy(this.l.getBreakStrategy()).setHyphenationFrequency(this.l.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? Integer.MAX_VALUE : maxLines);
        try {
            this.n.a(layoutBuilder, this.l);
        } catch (ClassCastException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return layoutBuilder.build();
    }

    public final StaticLayout f(CharSequence text, Layout.Alignment alignment, int availableWidth) {
        float lineSpacingMultiplier = this.l.getLineSpacingMultiplier();
        float lineSpacingAdd = this.l.getLineSpacingExtra();
        boolean includePad = this.l.getIncludeFontPadding();
        return new StaticLayout(text, this.k, availableWidth, alignment, lineSpacingMultiplier, lineSpacingAdd, includePad);
    }

    public static <T> T o(Object obj, String str, T t) {
        try {
            try {
                T t2 = (T) m(str).invoke(obj, new Object[0]);
                if (t2 != null || 0 == 0) {
                    return t2;
                }
            } catch (Exception e) {
                Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
                if (0 != 0 || 1 == 0) {
                    return null;
                }
            }
            return t;
        } catch (Throwable th) {
            if (0 != 0 || 0 != 0) {
            }
            throw th;
        }
    }

    public static Method m(String methodName) {
        try {
            Method method = f131b.get(methodName);
            if (method == null && (method = TextView.class.getDeclaredMethod(methodName, new Class[0])) != null) {
                method.setAccessible(true);
                f131b.put(methodName, method);
            }
            return method;
        } catch (Exception ex) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + methodName + "() method", ex);
            return null;
        }
    }

    public boolean p() {
        return A() && this.d != 0;
    }

    public final boolean A() {
        return !(this.l instanceof k);
    }
}
