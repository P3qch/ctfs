package a.b.b;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static k f45a;

    /* renamed from: b, reason: collision with root package name */
    public long f46b;
    public long c;
    public int d;

    public static k b() {
        if (f45a == null) {
            f45a = new k();
        }
        return f45a;
    }

    public void a(long time, double latitude, double longitude) {
        float daysSince2000 = ((float) (time - 946728000000L)) / 8.64E7f;
        float meanAnomaly = (0.01720197f * daysSince2000) + 6.24006f;
        double d = meanAnomaly;
        double sin = Math.sin(meanAnomaly) * 0.03341960161924362d;
        Double.isNaN(d);
        double trueAnomaly = d + sin + (Math.sin(2.0f * meanAnomaly) * 3.4906598739326E-4d) + (Math.sin(3.0f * meanAnomaly) * 5.236000106378924E-6d);
        double solarLng = 1.796593063d + trueAnomaly + 3.141592653589793d;
        double arcLongitude = (-longitude) / 360.0d;
        double d2 = daysSince2000 - 9.0E-4f;
        Double.isNaN(d2);
        float n = (float) Math.round(d2 - arcLongitude);
        double d3 = 9.0E-4f + n;
        Double.isNaN(d3);
        double trueAnomaly2 = meanAnomaly;
        double solarTransitJ2000 = d3 + arcLongitude + (Math.sin(trueAnomaly2) * 0.0053d) + (Math.sin(2.0d * solarLng) * (-0.0069d));
        double solarDec = Math.asin(Math.sin(solarLng) * Math.sin(0.4092797040939331d));
        double latRad = 0.01745329238474369d * latitude;
        double cosHourAngle = (Math.sin(-0.10471975803375244d) - (Math.sin(latRad) * Math.sin(solarDec))) / (Math.cos(latRad) * Math.cos(solarDec));
        if (cosHourAngle >= 1.0d) {
            this.d = 1;
            this.f46b = -1L;
            this.c = -1L;
            return;
        }
        if (cosHourAngle <= -1.0d) {
            this.d = 0;
            this.f46b = -1L;
            this.c = -1L;
            return;
        }
        float hourAngle = (float) (Math.acos(cosHourAngle) / 6.283185307179586d);
        double d4 = hourAngle;
        Double.isNaN(d4);
        this.f46b = Math.round((d4 + solarTransitJ2000) * 8.64E7d) + 946728000000L;
        double d5 = hourAngle;
        Double.isNaN(d5);
        long round = Math.round((solarTransitJ2000 - d5) * 8.64E7d) + 946728000000L;
        this.c = round;
        if (round >= time || this.f46b <= time) {
            this.d = 1;
        } else {
            this.d = 0;
        }
    }
}
