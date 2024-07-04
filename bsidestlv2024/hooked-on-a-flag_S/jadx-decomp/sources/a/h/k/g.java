package a.h.k;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static Field f468a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f469b;

    public static void a(LayoutInflater inflater, LayoutInflater.Factory2 factory) {
        if (!f469b) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f468a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f469b = true;
        }
        Field field = f468a;
        if (field != null) {
            try {
                field.set(inflater, factory);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + inflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void b(LayoutInflater inflater, LayoutInflater.Factory2 factory) {
        inflater.setFactory2(factory);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory f = inflater.getFactory();
            if (f instanceof LayoutInflater.Factory2) {
                a(inflater, (LayoutInflater.Factory2) f);
            } else {
                a(inflater, factory);
            }
        }
    }
}
