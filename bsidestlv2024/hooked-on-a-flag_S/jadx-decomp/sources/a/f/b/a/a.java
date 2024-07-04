package a.f.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

@SuppressLint({"LogConditional"})
/* loaded from: classes.dex */
public class a {
    public static String b(View view) {
        try {
            Context context = view.getContext();
            return context.getResources().getResourceEntryName(view.getId());
        } catch (Exception e) {
            return "UNKNOWN";
        }
    }

    public static String a(Context context, int id) {
        if (id != -1) {
            try {
                return context.getResources().getResourceEntryName(id);
            } catch (Exception e) {
                return "?" + id;
            }
        }
        return "UNKNOWN";
    }
}
