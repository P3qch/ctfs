package androidx.activity;

import a.m.d;
import a.m.e;
import a.m.g;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class ImmLeaksCleaner implements e {

    /* renamed from: a, reason: collision with root package name */
    public static int f775a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static Field f776b;
    public static Field c;
    public static Field d;
    public Activity e;

    public ImmLeaksCleaner(Activity activity) {
        this.e = activity;
    }

    @Override // a.m.e
    public void g(g source, d.a event) {
        if (event != d.a.ON_DESTROY) {
            return;
        }
        if (f775a == 0) {
            h();
        }
        if (f775a == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.e.getSystemService("input_method");
            try {
                Object lock = f776b.get(inputMethodManager);
                if (lock == null) {
                    return;
                }
                synchronized (lock) {
                    try {
                        try {
                            View servedView = (View) c.get(inputMethodManager);
                            if (servedView == null) {
                                return;
                            }
                            if (servedView.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                d.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException e) {
                            }
                        } catch (ClassCastException e2) {
                        } catch (IllegalAccessException e3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException e4) {
            }
        }
    }

    public static void h() {
        try {
            f775a = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            d = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f776b = declaredField3;
            declaredField3.setAccessible(true);
            f775a = 1;
        } catch (NoSuchFieldException e) {
        }
    }
}
