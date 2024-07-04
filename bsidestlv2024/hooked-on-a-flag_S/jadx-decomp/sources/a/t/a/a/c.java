package a.t.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {
    public static Interpolator b(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator(context, id);
        }
        XmlResourceParser parser = null;
        try {
            try {
                if (id == 17563663) {
                    return new a.l.a.a.a();
                }
                if (id == 17563661) {
                    a.l.a.a.b bVar = new a.l.a.a.b();
                    if (0 != 0) {
                        parser.close();
                    }
                    return bVar;
                }
                if (id == 17563662) {
                    a.l.a.a.c cVar = new a.l.a.a.c();
                    if (0 != 0) {
                        parser.close();
                    }
                    return cVar;
                }
                XmlResourceParser parser2 = context.getResources().getAnimation(id);
                context.getResources();
                context.getTheme();
                Interpolator a2 = a(context, parser2);
                if (parser2 != null) {
                    parser2.close();
                }
                return a2;
            } catch (IOException ex) {
                Resources.NotFoundException rnf = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
                rnf.initCause(ex);
                throw rnf;
            } catch (XmlPullParserException ex2) {
                Resources.NotFoundException rnf2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
                rnf2.initCause(ex2);
                throw rnf2;
            }
        } finally {
            if (0 != 0) {
                parser.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x00d9, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.view.animation.Interpolator a(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r0 = 0
            r1 = 0
            r2 = 0
            int r3 = r11.getDepth()
        L7:
            int r4 = r11.next()
            r5 = r4
            r6 = 3
            if (r4 != r6) goto L15
            int r4 = r11.getDepth()
            if (r4 <= r3) goto Ld9
        L15:
            r4 = 1
            if (r5 == r4) goto Ld9
            r4 = 2
            if (r5 == r4) goto L1c
            goto L7
        L1c:
            android.util.AttributeSet r4 = android.util.Xml.asAttributeSet(r11)
            java.lang.String r6 = r11.getName()
            java.lang.String r7 = "linearInterpolator"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L34
            android.view.animation.LinearInterpolator r7 = new android.view.animation.LinearInterpolator
            r7.<init>()
            r2 = r7
            goto Lbc
        L34:
            java.lang.String r7 = "accelerateInterpolator"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L44
            android.view.animation.AccelerateInterpolator r7 = new android.view.animation.AccelerateInterpolator
            r7.<init>(r10, r4)
            r2 = r7
            goto Lbc
        L44:
            java.lang.String r7 = "decelerateInterpolator"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L54
            android.view.animation.DecelerateInterpolator r7 = new android.view.animation.DecelerateInterpolator
            r7.<init>(r10, r4)
            r2 = r7
            goto Lbc
        L54:
            java.lang.String r7 = "accelerateDecelerateInterpolator"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L63
            android.view.animation.AccelerateDecelerateInterpolator r7 = new android.view.animation.AccelerateDecelerateInterpolator
            r7.<init>()
            r2 = r7
            goto Lbc
        L63:
            java.lang.String r7 = "cycleInterpolator"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L72
            android.view.animation.CycleInterpolator r7 = new android.view.animation.CycleInterpolator
            r7.<init>(r10, r4)
            r2 = r7
            goto Lbc
        L72:
            java.lang.String r7 = "anticipateInterpolator"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L81
            android.view.animation.AnticipateInterpolator r7 = new android.view.animation.AnticipateInterpolator
            r7.<init>(r10, r4)
            r2 = r7
            goto Lbc
        L81:
            java.lang.String r7 = "overshootInterpolator"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L90
            android.view.animation.OvershootInterpolator r7 = new android.view.animation.OvershootInterpolator
            r7.<init>(r10, r4)
            r2 = r7
            goto Lbc
        L90:
            java.lang.String r7 = "anticipateOvershootInterpolator"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L9f
            android.view.animation.AnticipateOvershootInterpolator r7 = new android.view.animation.AnticipateOvershootInterpolator
            r7.<init>(r10, r4)
            r2 = r7
            goto Lbc
        L9f:
            java.lang.String r7 = "bounceInterpolator"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto Lae
            android.view.animation.BounceInterpolator r7 = new android.view.animation.BounceInterpolator
            r7.<init>()
            r2 = r7
            goto Lbc
        Lae:
            java.lang.String r7 = "pathInterpolator"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto Lbe
            a.t.a.a.f r7 = new a.t.a.a.f
            r7.<init>(r10, r4, r11)
            r2 = r7
        Lbc:
            goto L7
        Lbe:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Unknown interpolator name: "
            r8.append(r9)
            java.lang.String r9 = r11.getName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        Ld9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.t.a.a.c.a(android.content.Context, org.xmlpull.v1.XmlPullParser):android.view.animation.Interpolator");
    }
}
