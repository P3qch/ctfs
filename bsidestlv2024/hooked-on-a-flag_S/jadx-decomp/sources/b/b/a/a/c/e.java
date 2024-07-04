package b.b.a.a.c;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.view.View;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class e {
    public static void a(View view, float elevation) {
        int dur = view.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
        StateListAnimator sla = new StateListAnimator();
        sla.addState(new int[]{android.R.attr.enabled, R.attr.state_liftable, -2130903841}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(dur));
        sla.addState(new int[]{android.R.attr.enabled}, ObjectAnimator.ofFloat(view, "elevation", elevation).setDuration(dur));
        sla.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(sla);
    }
}
