package a.k.b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public abstract class g {
    public abstract View h(int i);

    public abstract boolean i();

    @Deprecated
    public Fragment f(Context context, String className, Bundle arguments) {
        return Fragment.V(context, className, arguments);
    }
}
