package a.s;

import android.view.ViewGroup;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class j {
    public void a() {
        b(null);
        throw null;
    }

    public static void c(ViewGroup sceneRoot, j scene) {
        sceneRoot.setTag(R.id.transition_current_scene, scene);
    }

    public static j b(ViewGroup sceneRoot) {
        return (j) sceneRoot.getTag(R.id.transition_current_scene);
    }
}
