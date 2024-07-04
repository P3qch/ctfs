package a.h.k;

import android.os.Build;
import android.view.ViewGroup;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class x {
    public static boolean a(ViewGroup group) {
        if (Build.VERSION.SDK_INT >= 21) {
            return group.isTransitionGroup();
        }
        Boolean explicit = (Boolean) group.getTag(R.id.tag_transition_group);
        return ((explicit == null || !explicit.booleanValue()) && group.getBackground() == null && v.L(group) == null) ? false : true;
    }
}
