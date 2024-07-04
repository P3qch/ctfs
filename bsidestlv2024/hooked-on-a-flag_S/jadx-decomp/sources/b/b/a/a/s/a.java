package b.b.a.a.s;

/* loaded from: classes.dex */
public final class a {
    public static float a(float x1, float y1, float x2, float y2) {
        float x = x2 - x1;
        float y = y2 - y1;
        return (float) Math.hypot(x, y);
    }

    public static float c(float start, float stop, float amount) {
        return ((1.0f - amount) * start) + (amount * stop);
    }

    public static float b(float pointX, float pointY, float rectLeft, float rectTop, float rectRight, float rectBottom) {
        return d(a(pointX, pointY, rectLeft, rectTop), a(pointX, pointY, rectRight, rectTop), a(pointX, pointY, rectRight, rectBottom), a(pointX, pointY, rectLeft, rectBottom));
    }

    public static float d(float a2, float b2, float c, float d) {
        return (a2 <= b2 || a2 <= c || a2 <= d) ? (b2 <= c || b2 <= d) ? c > d ? c : d : b2 : a2;
    }
}
