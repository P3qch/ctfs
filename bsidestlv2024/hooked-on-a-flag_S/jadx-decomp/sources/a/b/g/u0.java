package a.b.g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class u0 extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f195a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<WeakReference<u0>> f196b;
    public final Resources c;
    public final Resources.Theme d;

    public static Context b(Context context) {
        if (a(context)) {
            synchronized (f195a) {
                ArrayList<WeakReference<u0>> arrayList = f196b;
                if (arrayList == null) {
                    f196b = new ArrayList<>();
                } else {
                    for (int i = arrayList.size() - 1; i >= 0; i--) {
                        WeakReference<u0> weakReference = f196b.get(i);
                        if (weakReference == null || weakReference.get() == null) {
                            f196b.remove(i);
                        }
                    }
                    for (int i2 = f196b.size() - 1; i2 >= 0; i2--) {
                        WeakReference<u0> weakReference2 = f196b.get(i2);
                        u0 wrapper = weakReference2 != null ? weakReference2.get() : null;
                        if (wrapper != null && wrapper.getBaseContext() == context) {
                            return wrapper;
                        }
                    }
                }
                u0 wrapper2 = new u0(context);
                f196b.add(new WeakReference<>(wrapper2));
                return wrapper2;
            }
        }
        return context;
    }

    public static boolean a(Context context) {
        if ((context instanceof u0) || (context.getResources() instanceof w0) || (context.getResources() instanceof d1)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        d1.b();
        return false;
    }

    public u0(Context base) {
        super(base);
        d1.b();
        this.c = new w0(this, base.getResources());
        this.d = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int resid) {
        super.setTheme(resid);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.c.getAssets();
    }
}
