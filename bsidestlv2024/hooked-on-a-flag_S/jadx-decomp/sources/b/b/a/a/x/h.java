package b.b.a.a.x;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
public class h {
    public static d a(int cornerFamily) {
        switch (cornerFamily) {
            case 0:
                return new j();
            case 1:
                return new e();
            default:
                return b();
        }
    }

    public static d b() {
        return new j();
    }

    public static f c() {
        return new f();
    }

    public static void d(View view, float elevation) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            ((g) background).U(elevation);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            f(view, (g) background);
        }
    }

    public static void f(View view, g materialShapeDrawable) {
        if (materialShapeDrawable.N()) {
            materialShapeDrawable.Y(b.b.a.a.r.l.c(view));
        }
    }
}
