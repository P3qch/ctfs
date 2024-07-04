package b.a.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static e f941a = null;

    public static synchronized e b() {
        e internalLibrary;
        synchronized (e.class) {
            synchronized (e.class) {
                if (f941a == null) {
                    f941a = new e();
                }
                internalLibrary = f941a;
            }
            return internalLibrary;
        }
        return internalLibrary;
    }

    public String c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.example.addflag_preferences", 0);
        String value = sharedPreferences.getString("string_0", "Default Value");
        return value;
    }

    public String a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.example.addflag_preferences", 0);
        String value = sharedPreferences.getString("string_1", "Default Value");
        return value;
    }

    public String d(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.example.addflag_preferences", 0);
        String value = sharedPreferences.getString("string_2", "Default Value");
        return value;
    }
}
