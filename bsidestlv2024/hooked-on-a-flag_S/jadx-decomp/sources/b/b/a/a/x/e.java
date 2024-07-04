package b.b.a.a.x;

/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: a, reason: collision with root package name */
    public float f1100a = -1.0f;

    @Override // b.b.a.a.x.d
    public void a(m shapePath, float angle, float interpolation, float radius) {
        shapePath.o(0.0f, radius * interpolation, 180.0f, 180.0f - angle);
        double sin = Math.sin(Math.toRadians(angle));
        double d = radius;
        Double.isNaN(d);
        double d2 = sin * d;
        double d3 = interpolation;
        Double.isNaN(d3);
        double sin2 = Math.sin(Math.toRadians(90.0f - angle));
        double d4 = radius;
        Double.isNaN(d4);
        double d5 = sin2 * d4;
        double d6 = interpolation;
        Double.isNaN(d6);
        shapePath.m((float) (d2 * d3), (float) (d5 * d6));
    }
}
