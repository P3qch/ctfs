package a.b.g;

import a.h.c.c.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f214a;

    /* renamed from: b, reason: collision with root package name */
    public v0 f215b;
    public v0 c;
    public v0 d;
    public v0 e;
    public v0 f;
    public v0 g;
    public v0 h;
    public final b0 i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public z(TextView view) {
        this.f214a = view;
        this.i = new b0(view);
    }

    @SuppressLint({"NewApi"})
    public void m(AttributeSet attrs, int defStyleAttr) {
        boolean allCaps;
        ColorStateList textColor;
        ColorStateList textColorHint;
        ColorStateList textColorLink;
        String localeListString;
        String fontVariation;
        j drawableManager;
        String localeListString2;
        ColorStateList textColorLink2;
        j drawableManager2;
        int i;
        Context context = this.f214a.getContext();
        j drawableManager3 = j.b();
        int[] iArr = a.b.a.h;
        x0 a2 = x0.v(context, attrs, iArr, defStyleAttr, 0);
        TextView textView = this.f214a;
        a.h.k.v.m0(textView, textView.getContext(), iArr, attrs, a2.r(), defStyleAttr, 0);
        int[] iArr2 = a.b.a.f11a;
        int ap = a2.n(0, -1);
        if (a2.s(3)) {
            this.f215b = d(context, drawableManager3, a2.n(3, 0));
        }
        if (a2.s(1)) {
            this.c = d(context, drawableManager3, a2.n(1, 0));
        }
        if (a2.s(4)) {
            this.d = d(context, drawableManager3, a2.n(4, 0));
        }
        if (a2.s(2)) {
            this.e = d(context, drawableManager3, a2.n(2, 0));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            if (a2.s(5)) {
                this.f = d(context, drawableManager3, a2.n(5, 0));
            }
            if (a2.s(6)) {
                this.g = d(context, drawableManager3, a2.n(6, 0));
            }
        }
        a2.w();
        boolean hasPwdTm = this.f214a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean allCaps2 = false;
        boolean allCapsSet = false;
        ColorStateList textColor2 = null;
        ColorStateList textColorHint2 = null;
        ColorStateList textColorLink3 = null;
        String fontVariation2 = null;
        String localeListString3 = null;
        if (ap != -1) {
            x0 a3 = x0.t(context, ap, a.b.a.v);
            if (!hasPwdTm && a3.s(14)) {
                allCaps2 = a3.a(14, false);
                allCapsSet = true;
            }
            C(context, a3);
            if (i2 < 23) {
                if (a3.s(3)) {
                    textColor2 = a3.c(3);
                }
                if (a3.s(4)) {
                    textColorHint2 = a3.c(4);
                }
                if (a3.s(5)) {
                    textColorLink3 = a3.c(5);
                }
            }
            if (a3.s(15)) {
                localeListString3 = a3.o(15);
            }
            if (i2 >= 26 && a3.s(13)) {
                fontVariation2 = a3.o(13);
            }
            a3.w();
        }
        x0 a4 = x0.v(context, attrs, a.b.a.v, defStyleAttr, 0);
        if (!hasPwdTm && a4.s(14)) {
            allCapsSet = true;
            allCaps = a4.a(14, false);
        } else {
            allCaps = allCaps2;
        }
        if (i2 >= 23) {
            textColor = textColor2;
            textColorHint = textColorHint2;
            textColorLink = textColorLink3;
        } else {
            if (a4.s(3)) {
                textColor2 = a4.c(3);
            }
            if (a4.s(4)) {
                textColorHint2 = a4.c(4);
            }
            if (!a4.s(5)) {
                textColor = textColor2;
                textColorHint = textColorHint2;
                textColorLink = textColorLink3;
            } else {
                textColor = textColor2;
                textColorHint = textColorHint2;
                textColorLink = a4.c(5);
            }
        }
        if (!a4.s(15)) {
            localeListString = localeListString3;
        } else {
            localeListString = a4.o(15);
        }
        if (i2 >= 26 && a4.s(13)) {
            fontVariation = a4.o(13);
        } else {
            fontVariation = fontVariation2;
        }
        if (i2 < 28) {
            drawableManager = drawableManager3;
        } else if (a4.s(0)) {
            if (a4.f(0, -1) == 0) {
                drawableManager = drawableManager3;
                this.f214a.setTextSize(0, 0.0f);
            } else {
                drawableManager = drawableManager3;
            }
        } else {
            drawableManager = drawableManager3;
        }
        C(context, a4);
        a4.w();
        if (textColor != null) {
            this.f214a.setTextColor(textColor);
        }
        if (textColorHint != null) {
            this.f214a.setHintTextColor(textColorHint);
        }
        if (textColorLink != null) {
            this.f214a.setLinkTextColor(textColorLink);
        }
        if (!hasPwdTm && allCapsSet) {
            s(allCaps);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.f214a.setTypeface(typeface, this.j);
            } else {
                this.f214a.setTypeface(typeface);
            }
        }
        if (fontVariation != null) {
            this.f214a.setFontVariationSettings(fontVariation);
        }
        if (localeListString != null) {
            if (i2 >= 24) {
                this.f214a.setTextLocales(LocaleList.forLanguageTags(localeListString));
            } else if (i2 >= 21) {
                String firstLanTag = localeListString.substring(0, localeListString.indexOf(44));
                this.f214a.setTextLocale(Locale.forLanguageTag(firstLanTag));
            }
        }
        this.i.q(attrs, defStyleAttr);
        if (!a.h.l.b.f495a) {
            localeListString2 = localeListString;
            textColorLink2 = textColorLink;
        } else if (this.i.l() == 0) {
            localeListString2 = localeListString;
            textColorLink2 = textColorLink;
        } else {
            int[] autoSizeTextSizesInPx = this.i.k();
            if (autoSizeTextSizesInPx.length <= 0) {
                localeListString2 = localeListString;
                textColorLink2 = textColorLink;
            } else if (this.f214a.getAutoSizeStepGranularity() != -1.0f) {
                localeListString2 = localeListString;
                textColorLink2 = textColorLink;
                this.f214a.setAutoSizeTextTypeUniformWithConfiguration(this.i.i(), this.i.h(), this.i.j(), 0);
            } else {
                localeListString2 = localeListString;
                textColorLink2 = textColorLink;
                this.f214a.setAutoSizeTextTypeUniformWithPresetSizes(autoSizeTextSizesInPx, 0);
            }
        }
        x0 a5 = x0.u(context, attrs, a.b.a.i);
        Drawable drawableBottom = null;
        Drawable drawableLeft = null;
        Drawable drawableTop = null;
        int drawableLeftId = a5.n(8, -1);
        if (drawableLeftId == -1) {
            drawableManager2 = drawableManager;
        } else {
            drawableManager2 = drawableManager;
            drawableLeft = drawableManager2.c(context, drawableLeftId);
        }
        Drawable drawableRight = null;
        int drawableTopId = a5.n(13, -1);
        if (drawableTopId != -1) {
            drawableTop = drawableManager2.c(context, drawableTopId);
        }
        int drawableRightId = a5.n(9, -1);
        if (drawableRightId != -1) {
            drawableRight = drawableManager2.c(context, drawableRightId);
        }
        int drawableBottomId = a5.n(6, -1);
        if (drawableBottomId != -1) {
            drawableBottom = drawableManager2.c(context, drawableBottomId);
        }
        int drawableStartId = a5.n(10, -1);
        Drawable drawableStart = drawableStartId != -1 ? drawableManager2.c(context, drawableStartId) : null;
        int drawableEndId = a5.n(7, -1);
        Drawable drawableEnd = drawableEndId != -1 ? drawableManager2.c(context, drawableEndId) : null;
        y(drawableLeft, drawableTop, drawableRight, drawableBottom, drawableStart, drawableEnd);
        if (a5.s(11)) {
            ColorStateList tintList = a5.c(11);
            a.h.l.i.g(this.f214a, tintList);
        }
        if (!a5.s(12)) {
            i = -1;
        } else {
            i = -1;
            PorterDuff.Mode tintMode = f0.d(a5.k(12, -1), null);
            a.h.l.i.h(this.f214a, tintMode);
        }
        int firstBaselineToTopHeight = a5.f(14, i);
        int lastBaselineToBottomHeight = a5.f(17, i);
        int lineHeight = a5.f(18, i);
        a5.w();
        if (firstBaselineToTopHeight != i) {
            a.h.l.i.j(this.f214a, firstBaselineToTopHeight);
        }
        if (lastBaselineToBottomHeight != i) {
            a.h.l.i.k(this.f214a, lastBaselineToBottomHeight);
        }
        if (lineHeight != i) {
            a.h.l.i.l(this.f214a, lineHeight);
        }
    }

    public final void C(Context context, x0 a2) {
        String fontFamilyName;
        int[] iArr = a.b.a.f11a;
        this.j = a2.k(2, this.j);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int k = a2.k(11, -1);
            this.k = k;
            if (k != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        int fontFamilyId = 10;
        if (a2.s(10) || a2.s(12)) {
            this.l = null;
            if (a2.s(12)) {
                fontFamilyId = 12;
            }
            int fontWeight = this.k;
            int style = this.j;
            if (!context.isRestricted()) {
                WeakReference<TextView> textViewWeak = new WeakReference<>(this.f214a);
                f.a replyCallback = new a(fontWeight, style, textViewWeak);
                try {
                    Typeface typeface = a2.j(fontFamilyId, this.j, replyCallback);
                    if (typeface != null) {
                        if (i >= 28 && this.k != -1) {
                            this.l = Typeface.create(Typeface.create(typeface, 0), this.k, (this.j & 2) != 0);
                        } else {
                            this.l = typeface;
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
            if (this.l == null && (fontFamilyName = a2.o(fontFamilyId)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
                    this.l = Typeface.create(fontFamilyName, this.j);
                    return;
                } else {
                    this.l = Typeface.create(Typeface.create(fontFamilyName, 0), this.k, (2 & this.j) != 0);
                    return;
                }
            }
            return;
        }
        if (a2.s(1)) {
            this.m = false;
            int typefaceIndex = a2.k(1, 1);
            switch (typefaceIndex) {
                case 1:
                    this.l = Typeface.SANS_SERIF;
                    return;
                case 2:
                    this.l = Typeface.SERIF;
                    return;
                case 3:
                    this.l = Typeface.MONOSPACE;
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends f.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f216a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f217b;
        public final /* synthetic */ WeakReference c;

        public a(int i, int i2, WeakReference weakReference) {
            this.f216a = i;
            this.f217b = i2;
            this.c = weakReference;
        }

        @Override // a.h.c.c.f.a
        public void e(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.f216a) != -1) {
                typeface = Typeface.create(typeface, i, (this.f217b & 2) != 0);
            }
            z.this.n(this.c, typeface);
        }

        @Override // a.h.c.c.f.a
        public void d(int reason) {
        }
    }

    public void n(WeakReference<TextView> textViewWeak, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = textViewWeak.get();
            if (textView != null) {
                if (a.h.k.v.S(textView)) {
                    int style = this.j;
                    textView.post(new b(this, textView, typeface, style));
                } else {
                    textView.setTypeface(typeface, this.j);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f218b;
        public final /* synthetic */ Typeface c;
        public final /* synthetic */ int d;

        public b(z this$0, TextView textView, Typeface typeface, int i) {
            this.f218b = textView;
            this.c = typeface;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f218b.setTypeface(this.c, this.d);
        }
    }

    public void q(Context context, int resId) {
        String fontVariation;
        ColorStateList textColorHint;
        ColorStateList textColorLink;
        ColorStateList textColor;
        x0 a2 = x0.t(context, resId, a.b.a.v);
        int[] iArr = a.b.a.f11a;
        if (a2.s(14)) {
            s(a2.a(14, false));
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            if (a2.s(3) && (textColor = a2.c(3)) != null) {
                this.f214a.setTextColor(textColor);
            }
            if (a2.s(5) && (textColorLink = a2.c(5)) != null) {
                this.f214a.setLinkTextColor(textColorLink);
            }
            if (a2.s(4) && (textColorHint = a2.c(4)) != null) {
                this.f214a.setHintTextColor(textColorHint);
            }
        }
        if (a2.s(0) && a2.f(0, -1) == 0) {
            this.f214a.setTextSize(0, 0.0f);
        }
        C(context, a2);
        if (i >= 26 && a2.s(13) && (fontVariation = a2.o(13)) != null) {
            this.f214a.setFontVariationSettings(fontVariation);
        }
        a2.w();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f214a.setTypeface(typeface, this.j);
        }
    }

    public void s(boolean allCaps) {
        this.f214a.setAllCaps(allCaps);
    }

    public void p() {
        b();
    }

    public void b() {
        if (this.f215b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.f214a.getCompoundDrawables();
            a(compoundDrawables[0], this.f215b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f != null || this.g != null) {
                Drawable[] compoundDrawables2 = this.f214a.getCompoundDrawablesRelative();
                a(compoundDrawables2[0], this.f);
                a(compoundDrawables2[2], this.g);
            }
        }
    }

    public final void a(Drawable drawable, v0 info) {
        if (drawable != null && info != null) {
            j.i(drawable, info, this.f214a.getDrawableState());
        }
    }

    public static v0 d(Context context, j drawableManager, int drawableId) {
        ColorStateList tintList = drawableManager.f(context, drawableId);
        if (tintList != null) {
            v0 tintInfo = new v0();
            tintInfo.d = true;
            tintInfo.f198a = tintList;
            return tintInfo;
        }
        return null;
    }

    public void o() {
        if (!a.h.l.b.f495a) {
            c();
        }
    }

    public void A(int unit, float size) {
        if (!a.h.l.b.f495a && !l()) {
            B(unit, size);
        }
    }

    public void c() {
        this.i.a();
    }

    public boolean l() {
        return this.i.p();
    }

    public final void B(int unit, float size) {
        this.i.v(unit, size);
    }

    public void v(int autoSizeTextType) {
        this.i.t(autoSizeTextType);
    }

    public void t(int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) {
        this.i.r(autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, unit);
    }

    public void u(int[] presetSizes, int unit) {
        this.i.s(presetSizes, unit);
    }

    public int i() {
        return this.i.l();
    }

    public int g() {
        return this.i.j();
    }

    public int f() {
        return this.i.i();
    }

    public int e() {
        return this.i.h();
    }

    public int[] h() {
        return this.i.k();
    }

    public ColorStateList j() {
        v0 v0Var = this.h;
        if (v0Var != null) {
            return v0Var.f198a;
        }
        return null;
    }

    public void w(ColorStateList tintList) {
        if (this.h == null) {
            this.h = new v0();
        }
        v0 v0Var = this.h;
        v0Var.f198a = tintList;
        v0Var.d = tintList != null;
        z();
    }

    public PorterDuff.Mode k() {
        v0 v0Var = this.h;
        if (v0Var != null) {
            return v0Var.f199b;
        }
        return null;
    }

    public void x(PorterDuff.Mode tintMode) {
        if (this.h == null) {
            this.h = new v0();
        }
        v0 v0Var = this.h;
        v0Var.f199b = tintMode;
        v0Var.c = tintMode != null;
        z();
    }

    public final void z() {
        v0 v0Var = this.h;
        this.f215b = v0Var;
        this.c = v0Var;
        this.d = v0Var;
        this.e = v0Var;
        this.f = v0Var;
        this.g = v0Var;
    }

    public final void y(Drawable drawableLeft, Drawable drawableTop, Drawable drawableRight, Drawable drawableBottom, Drawable drawableStart, Drawable drawableEnd) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17 && (drawableStart != null || drawableEnd != null)) {
            Drawable[] existingRel = this.f214a.getCompoundDrawablesRelative();
            this.f214a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart != null ? drawableStart : existingRel[0], drawableTop != null ? drawableTop : existingRel[1], drawableEnd != null ? drawableEnd : existingRel[2], drawableBottom != null ? drawableBottom : existingRel[3]);
            return;
        }
        if (drawableLeft != null || drawableTop != null || drawableRight != null || drawableBottom != null) {
            if (i >= 17) {
                Drawable[] existingRel2 = this.f214a.getCompoundDrawablesRelative();
                if (existingRel2[0] != null || existingRel2[2] != null) {
                    this.f214a.setCompoundDrawablesRelativeWithIntrinsicBounds(existingRel2[0], drawableTop != null ? drawableTop : existingRel2[1], existingRel2[2], drawableBottom != null ? drawableBottom : existingRel2[3]);
                    return;
                }
            }
            Drawable[] existingAbs = this.f214a.getCompoundDrawables();
            this.f214a.setCompoundDrawablesWithIntrinsicBounds(drawableLeft != null ? drawableLeft : existingAbs[0], drawableTop != null ? drawableTop : existingAbs[1], drawableRight != null ? drawableRight : existingAbs[2], drawableBottom != null ? drawableBottom : existingAbs[3]);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            a.h.k.f0.a.f(editorInfo, textView.getText());
        }
    }
}
