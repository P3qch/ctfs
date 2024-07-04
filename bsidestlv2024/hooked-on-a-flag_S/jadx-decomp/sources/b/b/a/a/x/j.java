package b.b.a.a.x;

/* loaded from: classes.dex */
public class j extends d {

    /* renamed from: a, reason: collision with root package name */
    public float f1107a = -1.0f;

    @Override // b.b.a.a.x.d
    public void a(m shapePath, float angle, float interpolation, float radius) {
        shapePath.o(0.0f, radius * interpolation, 180.0f, 180.0f - angle);
        shapePath.a(0.0f, 0.0f, radius * 2.0f * interpolation, 2.0f * radius * interpolation, 180.0f, angle);
    }
}
