package a.b.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f74a;

    public static a b(Context context) {
        return new a(context);
    }

    public a(Context context) {
        this.f74a = context;
    }

    public int d() {
        Configuration configuration = this.f74a.getResources().getConfiguration();
        int widthDp = configuration.screenWidthDp;
        int heightDp = configuration.screenHeightDp;
        int smallest = configuration.smallestScreenWidthDp;
        if (smallest > 600 || widthDp > 600) {
            return 5;
        }
        if (widthDp > 960 && heightDp > 720) {
            return 5;
        }
        if (widthDp > 720 && heightDp > 960) {
            return 5;
        }
        if (widthDp >= 500) {
            return 4;
        }
        if (widthDp > 640 && heightDp > 480) {
            return 4;
        }
        if (widthDp > 480 && heightDp > 640) {
            return 4;
        }
        if (widthDp >= 360) {
            return 3;
        }
        return 2;
    }

    public boolean h() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f74a).hasPermanentMenuKey();
    }

    public int c() {
        return this.f74a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean g() {
        return this.f74a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public int f() {
        TypedArray a2 = this.f74a.obtainStyledAttributes(null, a.b.a.f11a, R.attr.actionBarStyle, 0);
        int[] iArr = a.b.a.f11a;
        int height = a2.getLayoutDimension(13, 0);
        Resources r = this.f74a.getResources();
        if (!g()) {
            height = Math.min(height, r.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        a2.recycle();
        return height;
    }

    public boolean a() {
        return this.f74a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int e() {
        return this.f74a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
