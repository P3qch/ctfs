package b.b.a.a.o;

import android.content.Context;
import android.graphics.Color;
import b.b.a.a.u.b;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1047a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1048b;
    public final int c;
    public final float d;

    public a(Context context) {
        this.f1047a = b.b(context, R.attr.elevationOverlayEnabled, false);
        this.f1048b = b.b.a.a.k.a.a(context, R.attr.elevationOverlayColor, 0);
        this.c = b.b.a.a.k.a.a(context, R.attr.colorSurface, 0);
        this.d = context.getResources().getDisplayMetrics().density;
    }

    public int c(int backgroundColor, float elevation) {
        if (this.f1047a && e(backgroundColor)) {
            return b(backgroundColor, elevation);
        }
        return backgroundColor;
    }

    public int b(int backgroundColor, float elevation) {
        float overlayAlphaFraction = a(elevation);
        int backgroundAlpha = Color.alpha(backgroundColor);
        int backgroundColorOpaque = a.h.d.a.d(backgroundColor, 255);
        int overlayColorOpaque = b.b.a.a.k.a.f(backgroundColorOpaque, this.f1048b, overlayAlphaFraction);
        return a.h.d.a.d(overlayColorOpaque, backgroundAlpha);
    }

    public float a(float elevation) {
        float f = this.d;
        if (f <= 0.0f || elevation <= 0.0f) {
            return 0.0f;
        }
        float elevationDp = elevation / f;
        float alphaFraction = ((((float) Math.log1p(elevationDp)) * 4.5f) + 2.0f) / 100.0f;
        return Math.min(alphaFraction, 1.0f);
    }

    public boolean d() {
        return this.f1047a;
    }

    public final boolean e(int color) {
        return a.h.d.a.d(color, 255) == this.c;
    }
}
