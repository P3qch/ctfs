package b.b.a.a.l;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public abstract class p<S> extends Fragment {
    public final LinkedHashSet<o<S>> X = new LinkedHashSet<>();

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.o != com.google.android.material.datepicker.OnSelectionChangedListener<S> */
    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.p != com.google.android.material.datepicker.PickerFragment<S> */
    public boolean w1(o<S> oVar) {
        return this.X.add(oVar);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.p != com.google.android.material.datepicker.PickerFragment<S> */
    public void x1() {
        this.X.clear();
    }
}
