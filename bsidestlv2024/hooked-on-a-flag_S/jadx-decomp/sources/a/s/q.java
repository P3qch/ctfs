package a.s;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class q {

    /* renamed from: b, reason: collision with root package name */
    public View f735b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f734a = new HashMap();
    public final ArrayList<k> c = new ArrayList<>();

    @Deprecated
    public q() {
    }

    public q(View view) {
        this.f735b = view;
    }

    public boolean equals(Object other) {
        if ((other instanceof q) && this.f735b == ((q) other).f735b && this.f734a.equals(((q) other).f734a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f735b.hashCode() * 31) + this.f734a.hashCode();
    }

    public String toString() {
        String returnValue = "TransitionValues@" + Integer.toHexString(hashCode()) + ":\n";
        String returnValue2 = (returnValue + "    view = " + this.f735b + "\n") + "    values:";
        for (String s : this.f734a.keySet()) {
            returnValue2 = returnValue2 + "    " + s + ": " + this.f734a.get(s) + "\n";
        }
        return returnValue2;
    }
}
