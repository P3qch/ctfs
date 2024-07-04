package b.b.a.a.l;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class k<S> extends p<S> {
    public int Y;
    public d<S> Z;
    public b.b.a.a.l.a a0;

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.d != com.google.android.material.datepicker.DateSelector<T> */
    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.k != com.google.android.material.datepicker.MaterialTextInputPicker<T> */
    public static <T> k<T> y1(d<T> dVar, int themeResId, b.b.a.a.l.a calendarConstraints) {
        k<T> kVar = new k<>();
        Bundle args = new Bundle();
        args.putInt("THEME_RES_ID_KEY", themeResId);
        args.putParcelable("DATE_SELECTOR_KEY", dVar);
        args.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        kVar.n1(args);
        return kVar;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.k != com.google.android.material.datepicker.MaterialTextInputPicker<S> */
    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.Y);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.Z);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.a0);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.k != com.google.android.material.datepicker.MaterialTextInputPicker<S> */
    @Override // androidx.fragment.app.Fragment
    public void j0(Bundle bundle) {
        super.j0(bundle);
        Bundle activeBundle = bundle == null ? o() : bundle;
        this.Y = activeBundle.getInt("THEME_RES_ID_KEY");
        this.Z = (d) activeBundle.getParcelable("DATE_SELECTOR_KEY");
        this.a0 = (b.b.a.a.l.a) activeBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.k != com.google.android.material.datepicker.MaterialTextInputPicker<S> */
    @Override // androidx.fragment.app.Fragment
    public View m0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ContextThemeWrapper themedContext = new ContextThemeWrapper(q(), this.Y);
        LayoutInflater themedInflater = layoutInflater.cloneInContext(themedContext);
        return this.Z.e(themedInflater, viewGroup, bundle, this.a0, new a());
    }

    /* loaded from: classes.dex */
    public class a extends o<S> {
        public a() {
        }

        /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.o != com.google.android.material.datepicker.OnSelectionChangedListener<S> */
        @Override // b.b.a.a.l.o
        public void a(S selection) {
            Iterator<o<S>> it = k.this.X.iterator();
            while (it.hasNext()) {
                it.next().a(selection);
            }
        }
    }
}
