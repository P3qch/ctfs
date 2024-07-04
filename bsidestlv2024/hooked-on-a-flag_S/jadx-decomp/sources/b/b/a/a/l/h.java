package b.b.a.a.l;

import a.h.k.v;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class h<S> extends p<S> {
    public static final Object Y = "MONTHS_VIEW_GROUP_TAG";
    public static final Object Z = "NAVIGATION_PREV_TAG";
    public static final Object a0 = "NAVIGATION_NEXT_TAG";
    public static final Object b0 = "SELECTOR_TOGGLE_TAG";
    public int c0;
    public b.b.a.a.l.d<S> d0;
    public b.b.a.a.l.a e0;
    public b.b.a.a.l.l f0;
    public k g0;
    public b.b.a.a.l.c h0;
    public RecyclerView i0;
    public RecyclerView j0;
    public View k0;
    public View l0;

    /* loaded from: classes.dex */
    public enum k {
        DAY,
        YEAR
    }

    /* loaded from: classes.dex */
    public interface l {
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.d != com.google.android.material.datepicker.DateSelector<T> */
    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<T> */
    public static <T> h<T> M1(b.b.a.a.l.d<T> dVar, int themeResId, b.b.a.a.l.a calendarConstraints) {
        h<T> hVar = new h<>();
        Bundle args = new Bundle();
        args.putInt("THEME_RES_ID_KEY", themeResId);
        args.putParcelable("GRID_SELECTOR_KEY", dVar);
        args.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        args.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.r());
        hVar.n1(args);
        return hVar;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.c0);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.d0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.e0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f0);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    @Override // androidx.fragment.app.Fragment
    public void j0(Bundle bundle) {
        super.j0(bundle);
        Bundle activeBundle = bundle == null ? o() : bundle;
        this.c0 = activeBundle.getInt("THEME_RES_ID_KEY");
        this.d0 = (b.b.a.a.l.d) activeBundle.getParcelable("GRID_SELECTOR_KEY");
        this.e0 = (b.b.a.a.l.a) activeBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f0 = (b.b.a.a.l.l) activeBundle.getParcelable("CURRENT_MONTH_KEY");
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    @Override // androidx.fragment.app.Fragment
    public View m0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int layout;
        int orientation;
        ContextThemeWrapper themedContext = new ContextThemeWrapper(q(), this.c0);
        this.h0 = new b.b.a.a.l.c(themedContext);
        LayoutInflater themedInflater = layoutInflater.cloneInContext(themedContext);
        b.b.a.a.l.l earliestMonth = this.e0.s();
        if (b.b.a.a.l.i.Y1(themedContext)) {
            layout = R.layout.mtrl_calendar_vertical;
            orientation = 1;
        } else {
            layout = R.layout.mtrl_calendar_horizontal;
            orientation = 0;
        }
        View root = themedInflater.inflate(layout, viewGroup, false);
        GridView daysHeader = (GridView) root.findViewById(R.id.mtrl_calendar_days_of_week);
        v.o0(daysHeader, new b(this));
        daysHeader.setAdapter((ListAdapter) new b.b.a.a.l.g());
        daysHeader.setNumColumns(earliestMonth.e);
        daysHeader.setEnabled(false);
        this.j0 = (RecyclerView) root.findViewById(R.id.mtrl_calendar_months);
        q layoutManager = new c(q(), orientation, false, orientation);
        this.j0.setLayoutManager(layoutManager);
        this.j0.setTag("MONTHS_VIEW_GROUP_TAG");
        n monthsPagerAdapter = new n(themedContext, this.d0, this.e0, new d());
        this.j0.setAdapter(monthsPagerAdapter);
        int columns = themedContext.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.i0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.i0.setLayoutManager(new GridLayoutManager((Context) themedContext, columns, 1, false));
            this.i0.setAdapter(new t(this));
            this.i0.h(F1());
        }
        if (root.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            E1(root, monthsPagerAdapter);
        }
        if (!b.b.a.a.l.i.Y1(themedContext)) {
            new a.o.b.j().b(this.j0);
        }
        this.j0.g1(monthsPagerAdapter.x(this.f0));
        return root;
    }

    /* loaded from: classes.dex */
    public class b extends a.h.k.a {
        public b(h this$0) {
        }

        @Override // a.h.k.a
        public void g(View view, a.h.k.e0.c accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.Y(null);
        }
    }

    /* loaded from: classes.dex */
    public class c extends q {
        public final /* synthetic */ int H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int orientation, boolean reverseLayout, int i) {
            super(context, orientation, reverseLayout);
            this.H = i;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void M1(RecyclerView.z state, int[] ints) {
            if (this.H == 0) {
                ints[0] = h.this.j0.getWidth();
                ints[1] = h.this.j0.getWidth();
            } else {
                ints[0] = h.this.j0.getHeight();
                ints[1] = h.this.j0.getHeight();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements l {
        public d() {
        }

        /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.o != com.google.android.material.datepicker.OnSelectionChangedListener<S> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(long j) {
            if (h.this.e0.o().i(j)) {
                h.this.d0.c(j);
                Iterator<o<S>> it = h.this.X.iterator();
                while (it.hasNext()) {
                    it.next().a(h.this.d0.a());
                }
                h.this.j0.getAdapter().h();
                if (h.this.i0 != null) {
                    h.this.i0.getAdapter().h();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends RecyclerView.n {

        /* renamed from: a, reason: collision with root package name */
        public final Calendar f1026a = s.k();

        /* renamed from: b, reason: collision with root package name */
        public final Calendar f1027b = s.k();

        public e() {
        }

        /* JADX WARN: Generic types in debug info not equals: a.h.j.e != androidx.core.util.Pair<java.lang.Long, java.lang.Long> */
        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.z state) {
            if (!(recyclerView.getAdapter() instanceof t) || !(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                return;
            }
            Iterator<a.h.j.e<Long, Long>> it = h.this.d0.g().iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public final RecyclerView.n F1() {
        return new e();
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public b.b.a.a.l.l I1() {
        return this.f0;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public b.b.a.a.l.a G1() {
        return this.e0;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public void O1(b.b.a.a.l.l moveTo) {
        n adapter = (n) this.j0.getAdapter();
        int moveToPosition = adapter.x(moveTo);
        int distance = moveToPosition - adapter.x(this.f0);
        boolean jump = Math.abs(distance) > 3;
        boolean isForward = distance > 0;
        this.f0 = moveTo;
        if (jump && isForward) {
            this.j0.g1(moveToPosition - 3);
            N1(moveToPosition);
        } else if (jump) {
            this.j0.g1(moveToPosition + 3);
            N1(moveToPosition);
        } else {
            N1(moveToPosition);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public b.b.a.a.l.d<S> J1() {
        return this.d0;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public b.b.a.a.l.c H1() {
        return this.h0;
    }

    public static int K1(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public void P1(k selector) {
        this.g0 = selector;
        if (selector == k.YEAR) {
            this.i0.getLayoutManager().x1(((t) this.i0.getAdapter()).w(this.f0.d));
            this.k0.setVisibility(0);
            this.l0.setVisibility(8);
        } else if (selector == k.DAY) {
            this.k0.setVisibility(8);
            this.l0.setVisibility(0);
            O1(this.f0);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public void Q1() {
        k kVar = this.g0;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            P1(k.DAY);
        } else if (kVar == k.DAY) {
            P1(kVar2);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public final void E1(View root, n monthsPagerAdapter) {
        MaterialButton monthDropSelect = (MaterialButton) root.findViewById(R.id.month_navigation_fragment_toggle);
        monthDropSelect.setTag("SELECTOR_TOGGLE_TAG");
        v.o0(monthDropSelect, new f());
        MaterialButton monthPrev = (MaterialButton) root.findViewById(R.id.month_navigation_previous);
        monthPrev.setTag("NAVIGATION_PREV_TAG");
        MaterialButton monthNext = (MaterialButton) root.findViewById(R.id.month_navigation_next);
        monthNext.setTag("NAVIGATION_NEXT_TAG");
        this.k0 = root.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.l0 = root.findViewById(R.id.mtrl_calendar_day_selector_frame);
        P1(k.DAY);
        monthDropSelect.setText(this.f0.q(root.getContext()));
        this.j0.k(new g(monthsPagerAdapter, monthDropSelect));
        monthDropSelect.setOnClickListener(new ViewOnClickListenerC0069h());
        monthNext.setOnClickListener(new i(monthsPagerAdapter));
        monthPrev.setOnClickListener(new j(monthsPagerAdapter));
    }

    /* loaded from: classes.dex */
    public class f extends a.h.k.a {
        public f() {
        }

        @Override // a.h.k.a
        public void g(View view, a.h.k.e0.c accessibilityNodeInfoCompat) {
            String P;
            super.g(view, accessibilityNodeInfoCompat);
            if (h.this.l0.getVisibility() == 0) {
                P = h.this.P(R.string.mtrl_picker_toggle_to_year_selection);
            } else {
                P = h.this.P(R.string.mtrl_picker_toggle_to_day_selection);
            }
            accessibilityNodeInfoCompat.g0(P);
        }
    }

    /* loaded from: classes.dex */
    public class g extends RecyclerView.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f1028a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaterialButton f1029b;

        public g(n nVar, MaterialButton materialButton) {
            this.f1028a = nVar;
            this.f1029b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int dx, int dy) {
            int currentItem;
            if (dx < 0) {
                currentItem = h.this.L1().Z1();
            } else {
                currentItem = h.this.L1().c2();
            }
            h.this.f0 = this.f1028a.v(currentItem);
            this.f1029b.setText(this.f1028a.w(currentItem));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int newState) {
            if (newState == 0) {
                CharSequence announcementText = this.f1029b.getText();
                recyclerView.announceForAccessibility(announcementText);
            }
        }
    }

    /* renamed from: b.b.a.a.l.h$h, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0069h implements View.OnClickListener {
        public ViewOnClickListenerC0069h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.Q1();
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f1031b;

        public i(n nVar) {
            this.f1031b = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int currentItem = h.this.L1().Z1();
            if (currentItem + 1 < h.this.j0.getAdapter().c()) {
                h.this.O1(this.f1031b.v(currentItem + 1));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f1032b;

        public j(n nVar) {
            this.f1032b = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int currentItem = h.this.L1().c2();
            if (currentItem - 1 >= 0) {
                h.this.O1(this.f1032b.v(currentItem - 1));
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1024b;

        public a(int i) {
            this.f1024b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.j0.o1(this.f1024b);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public final void N1(int position) {
        this.j0.post(new a(position));
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    public LinearLayoutManager L1() {
        return (LinearLayoutManager) this.j0.getLayoutManager();
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<S> */
    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.o != com.google.android.material.datepicker.OnSelectionChangedListener<S> */
    @Override // b.b.a.a.l.p
    public boolean w1(o<S> oVar) {
        return super.w1(oVar);
    }
}
