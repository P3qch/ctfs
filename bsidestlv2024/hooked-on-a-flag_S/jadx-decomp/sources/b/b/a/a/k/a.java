package b.b.a.a.k;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import b.b.a.a.u.b;

/* loaded from: classes.dex */
public class a {
    public static int c(View view, int colorAttributeResId) {
        return b.d(view, colorAttributeResId);
    }

    public static int b(Context context, int colorAttributeResId, String errorMessageComponent) {
        return b.c(context, colorAttributeResId, errorMessageComponent);
    }

    public static int d(View view, int colorAttributeResId, int defaultValue) {
        return a(view.getContext(), colorAttributeResId, defaultValue);
    }

    public static int a(Context context, int colorAttributeResId, int defaultValue) {
        TypedValue typedValue = b.a(context, colorAttributeResId);
        if (typedValue != null) {
            return typedValue.data;
        }
        return defaultValue;
    }

    public static int g(View view, int backgroundColorAttributeResId, int overlayColorAttributeResId, float overlayAlpha) {
        int backgroundColor = c(view, backgroundColorAttributeResId);
        int overlayColor = c(view, overlayColorAttributeResId);
        return f(backgroundColor, overlayColor, overlayAlpha);
    }

    public static int f(int backgroundColor, int overlayColor, float overlayAlpha) {
        int computedAlpha = Math.round(Color.alpha(overlayColor) * overlayAlpha);
        int computedOverlayColor = a.h.d.a.d(overlayColor, computedAlpha);
        return e(backgroundColor, computedOverlayColor);
    }

    public static int e(int backgroundColor, int overlayColor) {
        return a.h.d.a.b(overlayColor, backgroundColor);
    }
}
