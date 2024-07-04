package a.b.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static l f47a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f48b;
    public final LocationManager c;
    public final a d = new a();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f49a;

        /* renamed from: b, reason: collision with root package name */
        public long f50b;
    }

    public static l a(Context context) {
        if (f47a == null) {
            Context context2 = context.getApplicationContext();
            f47a = new l(context2, (LocationManager) context2.getSystemService("location"));
        }
        return f47a;
    }

    public l(Context context, LocationManager locationManager) {
        this.f48b = context;
        this.c = locationManager;
    }

    public boolean d() {
        a state = this.d;
        if (e()) {
            return state.f49a;
        }
        Location location = b();
        if (location != null) {
            f(location);
            return state.f49a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(11);
        return hour < 6 || hour >= 22;
    }

    @SuppressLint({"MissingPermission"})
    public final Location b() {
        Location coarseLoc = null;
        Location fineLoc = null;
        int permission = a.h.c.b.b(this.f48b, "android.permission.ACCESS_COARSE_LOCATION");
        if (permission == 0) {
            coarseLoc = c("network");
        }
        int permission2 = a.h.c.b.b(this.f48b, "android.permission.ACCESS_FINE_LOCATION");
        if (permission2 == 0) {
            fineLoc = c("gps");
        }
        return (fineLoc == null || coarseLoc == null) ? fineLoc != null ? fineLoc : coarseLoc : fineLoc.getTime() > coarseLoc.getTime() ? fineLoc : coarseLoc;
    }

    public final Location c(String provider) {
        try {
            if (this.c.isProviderEnabled(provider)) {
                return this.c.getLastKnownLocation(provider);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    public final boolean e() {
        return this.d.f50b > System.currentTimeMillis();
    }

    public final void f(Location location) {
        long nextUpdate;
        long nextUpdate2;
        a state = this.d;
        long now = System.currentTimeMillis();
        k calculator = k.b();
        calculator.a(now - 86400000, location.getLatitude(), location.getLongitude());
        long j = calculator.f46b;
        calculator.a(now, location.getLatitude(), location.getLongitude());
        boolean isNight = calculator.d == 1;
        long todaySunrise = calculator.c;
        long todaySunset = calculator.f46b;
        calculator.a(86400000 + now, location.getLatitude(), location.getLongitude());
        long tomorrowSunrise = calculator.c;
        if (todaySunrise == -1 || todaySunset == -1) {
            nextUpdate = now + 43200000;
        } else {
            if (now > todaySunset) {
                nextUpdate2 = 0 + tomorrowSunrise;
            } else if (now > todaySunrise) {
                nextUpdate2 = 0 + todaySunset;
            } else {
                nextUpdate2 = 0 + todaySunrise;
            }
            nextUpdate = nextUpdate2 + 60000;
        }
        state.f49a = isNight;
        state.getClass();
        state.getClass();
        state.getClass();
        state.getClass();
        state.f50b = nextUpdate;
    }
}
