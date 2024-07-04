package b.b.a.a.b0.a;

import a.b.f.d;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f992a = {R.attr.theme, net.sqlcipher.R.attr.theme};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f993b = {net.sqlcipher.R.attr.materialThemeOverlay};

    public static Context c(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        int materialThemeOverlayId = b(context, attrs, defStyleAttr, defStyleRes);
        boolean contextHasOverlay = (context instanceof d) && ((d) context).c() == materialThemeOverlayId;
        if (materialThemeOverlayId == 0 || contextHasOverlay) {
            return context;
        }
        Context contextThemeWrapper = new d(context, materialThemeOverlayId);
        int androidThemeOverlayId = a(context, attrs);
        if (androidThemeOverlayId != 0) {
            contextThemeWrapper.getTheme().applyStyle(androidThemeOverlayId, true);
        }
        return contextThemeWrapper;
    }

    public static int a(Context context, AttributeSet attrs) {
        TypedArray a2 = context.obtainStyledAttributes(attrs, f992a);
        int androidThemeId = a2.getResourceId(0, 0);
        int appThemeId = a2.getResourceId(1, 0);
        a2.recycle();
        return androidThemeId != 0 ? androidThemeId : appThemeId;
    }

    public static int b(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a2 = context.obtainStyledAttributes(attrs, f993b, defStyleAttr, defStyleRes);
        int materialThemeOverlayId = a2.getResourceId(0, 0);
        a2.recycle();
        return materialThemeOverlayId;
    }
}
