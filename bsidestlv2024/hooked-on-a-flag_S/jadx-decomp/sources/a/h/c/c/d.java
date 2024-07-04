package a.h.c.c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class d {
    public static Shader b(Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        String name = parser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(parser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray a2 = g.k(resources, theme, attrs, a.h.a.d);
        int[] iArr = a.h.a.f337a;
        float startX = g.f(a2, parser, "startX", 8, 0.0f);
        float startY = g.f(a2, parser, "startY", 9, 0.0f);
        float endX = g.f(a2, parser, "endX", 10, 0.0f);
        float endY = g.f(a2, parser, "endY", 11, 0.0f);
        float centerX = g.f(a2, parser, "centerX", 3, 0.0f);
        float centerY = g.f(a2, parser, "centerY", 4, 0.0f);
        int type = g.g(a2, parser, "type", 2, 0);
        int startColor = g.b(a2, parser, "startColor", 0, 0);
        boolean hasCenterColor = g.j(parser, "centerColor");
        int centerColor = g.b(a2, parser, "centerColor", 7, 0);
        int endColor = g.b(a2, parser, "endColor", 1, 0);
        int tileMode = g.g(a2, parser, "tileMode", 6, 0);
        float gradientRadius = g.f(a2, parser, "gradientRadius", 5, 0.0f);
        a2.recycle();
        a colorStops = a(c(resources, parser, attrs, theme), startColor, endColor, hasCenterColor, centerColor);
        switch (type) {
            case 1:
                if (gradientRadius <= 0.0f) {
                    throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                }
                return new RadialGradient(centerX, centerY, gradientRadius, colorStops.f357a, colorStops.f358b, d(tileMode));
            case 2:
                return new SweepGradient(centerX, centerY, colorStops.f357a, colorStops.f358b);
            default:
                return new LinearGradient(startX, startY, endX, endY, colorStops.f357a, colorStops.f358b, d(tileMode));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r13.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a.h.c.c.d.a c(android.content.res.Resources r12, org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.content.res.Resources.Theme r15) {
        /*
            int r0 = r13.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
            r3 = r4
        L13:
            int r4 = r13.next()
            r5 = r4
            if (r4 == r1) goto L82
            int r4 = r13.getDepth()
            r6 = r4
            if (r4 >= r0) goto L24
            r4 = 3
            if (r5 == r4) goto L82
        L24:
            r4 = 2
            if (r5 == r4) goto L28
            goto L13
        L28:
            if (r6 > r0) goto L13
            java.lang.String r4 = r13.getName()
            java.lang.String r7 = "item"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L37
            goto L13
        L37:
            int[] r4 = a.h.a.e
            android.content.res.TypedArray r4 = a.h.c.c.g.k(r12, r15, r14, r4)
            int[] r7 = a.h.a.f337a
            r7 = 0
            boolean r8 = r4.hasValue(r7)
            boolean r9 = r4.hasValue(r1)
            if (r8 == 0) goto L67
            if (r9 == 0) goto L67
            int r7 = r4.getColor(r7, r7)
            r10 = 0
            float r10 = r4.getFloat(r1, r10)
            r4.recycle()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            r3.add(r11)
            java.lang.Float r11 = java.lang.Float.valueOf(r10)
            r2.add(r11)
            goto L13
        L67:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = r13.getPositionDescription()
            r7.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            r1.<init>(r7)
            throw r1
        L82:
            int r1 = r3.size()
            if (r1 <= 0) goto L8e
            a.h.c.c.d$a r1 = new a.h.c.c.d$a
            r1.<init>(r3, r2)
            return r1
        L8e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.h.c.c.d.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):a.h.c.c.d$a");
    }

    public static a a(a colorItems, int startColor, int endColor, boolean hasCenterColor, int centerColor) {
        if (colorItems != null) {
            return colorItems;
        }
        if (hasCenterColor) {
            return new a(startColor, centerColor, endColor);
        }
        return new a(startColor, endColor);
    }

    public static Shader.TileMode d(int tileMode) {
        switch (tileMode) {
            case 1:
                return Shader.TileMode.REPEAT;
            case 2:
                return Shader.TileMode.MIRROR;
            default:
                return Shader.TileMode.CLAMP;
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f357a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f358b;

        public a(List<Integer> colorsList, List<Float> offsetsList) {
            int size = colorsList.size();
            this.f357a = new int[size];
            this.f358b = new float[size];
            for (int i = 0; i < size; i++) {
                this.f357a[i] = colorsList.get(i).intValue();
                this.f358b[i] = offsetsList.get(i).floatValue();
            }
        }

        public a(int startColor, int endColor) {
            this.f357a = new int[]{startColor, endColor};
            this.f358b = new float[]{0.0f, 1.0f};
        }

        public a(int startColor, int centerColor, int endColor) {
            this.f357a = new int[]{startColor, centerColor, endColor};
            this.f358b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
