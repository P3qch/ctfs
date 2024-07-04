package b.b.a.a.y;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* loaded from: classes.dex */
public class a {
    public a(SwipeDismissBehavior<?> behavior) {
        behavior.K(0.1f);
        behavior.J(0.6f);
        behavior.L(0);
    }

    public boolean a(View child) {
        return child instanceof d;
    }

    public void b(CoordinatorLayout parent, View child, MotionEvent event) {
        switch (event.getActionMasked()) {
            case 0:
                if (parent.B(child, (int) event.getX(), (int) event.getY())) {
                    e.b().e(null);
                    return;
                }
                return;
            case 1:
            case 3:
                e.b().f(null);
                return;
            case 2:
            default:
                return;
        }
    }
}
