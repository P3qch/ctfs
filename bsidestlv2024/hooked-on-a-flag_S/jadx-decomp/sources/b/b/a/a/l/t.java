package b.b.a.a.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.a.a.l.h;
import java.util.Calendar;
import java.util.Locale;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class t extends RecyclerView.g<b> {
    public final h<?> c;

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public /* bridge */ /* synthetic */ b l(ViewGroup viewGroup, int i) {
        return z(viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.c0 {
        public final TextView t;

        public b(TextView view) {
            super(view);
            this.t = view;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.h != com.google.android.material.datepicker.MaterialCalendar<?> */
    public t(h<?> hVar) {
        this.c = hVar;
    }

    public b z(ViewGroup viewGroup) {
        TextView yearTextView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false);
        return new b(yearTextView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void j(b viewHolder, int position) {
        int year = x(position);
        String navigateYear = viewHolder.t.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        viewHolder.t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(year)));
        viewHolder.t.setContentDescription(String.format(navigateYear, Integer.valueOf(year)));
        c styles = this.c.H1();
        Calendar calendar = s.i();
        b.b.a.a.l.b style = calendar.get(1) == year ? styles.f : styles.d;
        for (Long day : this.c.J1().h()) {
            calendar.setTimeInMillis(day.longValue());
            if (calendar.get(1) == year) {
                style = styles.e;
            }
        }
        style.b(viewHolder.t);
        viewHolder.t.setOnClickListener(v(year));
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1045b;

        public a(int i) {
            this.f1045b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l current = l.k(this.f1045b, t.this.c.I1().c);
            b.b.a.a.l.a calendarConstraints = t.this.c.G1();
            l moveTo = calendarConstraints.n(current);
            t.this.c.O1(moveTo);
            t.this.c.P1(h.k.DAY);
        }
    }

    public final View.OnClickListener v(int year) {
        return new a(year);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.c.G1().t();
    }

    public int w(int year) {
        return year - this.c.G1().s().d;
    }

    public int x(int position) {
        return this.c.G1().s().d + position;
    }
}
