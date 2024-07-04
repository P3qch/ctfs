package b.b.a.a.l;

import a.h.k.v;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.a.a.l.h;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class n extends RecyclerView.g<b> {
    public final Context c;
    public final b.b.a.a.l.a d;
    public final d<?> e;
    public final h.l f;
    public final int g;

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public /* bridge */ /* synthetic */ b l(ViewGroup viewGroup, int i) {
        return z(viewGroup);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.d != com.google.android.material.datepicker.DateSelector<?> */
    public n(Context context, d<?> dVar, b.b.a.a.l.a calendarConstraints, h.l onDayClickListener) {
        l firstPage = calendarConstraints.s();
        l lastPage = calendarConstraints.p();
        l currentPage = calendarConstraints.r();
        if (firstPage.compareTo(currentPage) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (currentPage.compareTo(lastPage) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int daysHeight = m.f1040b * h.K1(context);
        int labelHeight = i.Y1(context) ? h.K1(context) : 0;
        this.c = context;
        this.g = daysHeight + labelHeight;
        this.d = calendarConstraints;
        this.e = dVar;
        this.f = onDayClickListener;
        s(true);
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.c0 {
        public final TextView t;
        public final MaterialCalendarGridView u;

        public b(LinearLayout container, boolean showLabel) {
            super(container);
            TextView textView = (TextView) container.findViewById(R.id.month_title);
            this.t = textView;
            v.p0(textView, true);
            this.u = (MaterialCalendarGridView) container.findViewById(R.id.month_grid);
            if (!showLabel) {
                textView.setVisibility(8);
            }
        }
    }

    public b z(ViewGroup viewGroup) {
        LinearLayout container = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (i.Y1(viewGroup.getContext())) {
            container.setLayoutParams(new RecyclerView.p(-1, this.g));
            return new b(container, true);
        }
        return new b(container, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void j(b viewHolder, int position) {
        l month = this.d.s().s(position);
        viewHolder.t.setText(month.q(viewHolder.f889b.getContext()));
        MaterialCalendarGridView monthGrid = (MaterialCalendarGridView) viewHolder.u.findViewById(R.id.month_grid);
        if (monthGrid.getAdapter() != null && month.equals(monthGrid.getAdapter().c)) {
            monthGrid.invalidate();
            monthGrid.getAdapter().k(monthGrid);
        } else {
            m monthAdapter = new m(month, this.e, this.d);
            monthGrid.setNumColumns(month.e);
            monthGrid.setAdapter((ListAdapter) monthAdapter);
        }
        monthGrid.setOnItemClickListener(new a(monthGrid));
    }

    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarGridView f1041b;

        public a(MaterialCalendarGridView materialCalendarGridView) {
            this.f1041b = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (this.f1041b.getAdapter().l(position)) {
                ((h.d) n.this.f).a(this.f1041b.getAdapter().getItem(position).longValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long d(int position) {
        return this.d.s().s(position).r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.d.q();
    }

    public CharSequence w(int position) {
        return v(position).q(this.c);
    }

    public l v(int position) {
        return this.d.s().s(position);
    }

    public int x(l month) {
        return this.d.s().t(month);
    }
}
