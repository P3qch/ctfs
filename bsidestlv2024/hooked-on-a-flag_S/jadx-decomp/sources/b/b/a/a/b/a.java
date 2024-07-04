package b.b.a.a.b;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f977a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f978b = new a.l.a.a.b();
    public static final TimeInterpolator c = new a.l.a.a.a();
    public static final TimeInterpolator d = new a.l.a.a.c();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static float a(float startValue, float endValue, float fraction) {
        return ((endValue - startValue) * fraction) + startValue;
    }
}
