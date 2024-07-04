package androidx.activity.result;

import a.m.d;
import a.m.e;
import a.m.g;

/* loaded from: classes.dex */
public class ActivityResultRegistry$1 implements e {
    @Override // a.m.e
    public void g(g lifecycleOwner, d.a event) {
        a.a.e.d dVar = null;
        if (d.a.ON_START.equals(event)) {
            throw null;
        }
        if (d.a.ON_STOP.equals(event)) {
            throw null;
        }
        if (d.a.ON_DESTROY.equals(event)) {
            dVar.i(null);
            throw null;
        }
    }
}
