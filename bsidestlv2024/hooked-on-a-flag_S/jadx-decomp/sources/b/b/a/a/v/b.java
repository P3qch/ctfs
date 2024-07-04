package b.b.a.a.v;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f1093a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1094b;
    public static final String c;

    static {
        f1093a = Build.VERSION.SDK_INT >= 21;
        new int[1][0] = 16842919;
        int[] iArr = {R.attr.state_hovered, R.attr.state_focused};
        new int[1][0] = 16842908;
        new int[1][0] = 16843623;
        int[] iArr2 = {R.attr.state_selected, R.attr.state_pressed};
        int[] iArr3 = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        int[] iArr4 = {R.attr.state_selected, R.attr.state_focused};
        int[] iArr5 = {R.attr.state_selected, R.attr.state_hovered};
        new int[1][0] = 16842913;
        f1094b = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        c = b.class.getSimpleName();
    }

    public static ColorStateList a(ColorStateList rippleColor) {
        if (rippleColor != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 27 && Color.alpha(rippleColor.getDefaultColor()) == 0 && Color.alpha(rippleColor.getColorForState(f1094b, 0)) != 0) {
                Log.w(c, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return rippleColor;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean b(int[] stateSet) {
        boolean enabled = false;
        boolean interactedState = false;
        for (int state : stateSet) {
            if (state == 16842910) {
                enabled = true;
            } else if (state == 16842908) {
                interactedState = true;
            } else if (state == 16842919) {
                interactedState = true;
            } else if (state == 16843623) {
                interactedState = true;
            }
        }
        return enabled && interactedState;
    }
}
