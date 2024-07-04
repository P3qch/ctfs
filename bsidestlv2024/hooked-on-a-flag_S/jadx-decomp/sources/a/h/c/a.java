package a.h.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f349a = new Object();

    public static boolean e(Context context, Intent[] intents, Bundle options) {
        context.startActivities(intents, options);
        return true;
    }

    public static Drawable d(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(id);
        }
        return context.getResources().getDrawable(id);
    }

    public static ColorStateList c(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(id);
        }
        return context.getResources().getColorStateList(id);
    }

    public static int b(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(id);
        }
        return context.getResources().getColor(id);
    }

    public static int a(Context context, String permission) {
        if (permission == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(permission, Process.myPid(), Process.myUid());
    }
}
