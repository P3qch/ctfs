package b.b.a.a.l;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class m extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    public static final int f1040b = s.k().getMaximum(4);
    public final l c;
    public final d<?> d;
    public Collection<Long> e;
    public c f;
    public final a g;

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.d != com.google.android.material.datepicker.DateSelector<?> */
    public m(l month, d<?> dVar, a calendarConstraints) {
        this.c = month;
        this.d = dVar;
        this.g = calendarConstraints;
        this.e = dVar.h();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int position) {
        if (position < this.c.n() || position > g()) {
            return null;
        }
        return Long.valueOf(this.c.o(h(position)));
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position / this.c.e;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.f + b();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
        /*
            r10 = this;
            android.content.Context r0 = r13.getContext()
            r10.e(r0)
            r0 = r12
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r12 != 0) goto L1f
            android.content.Context r2 = r13.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            r3 = 2131427396(0x7f0b0044, float:1.8476407E38)
            android.view.View r3 = r2.inflate(r3, r13, r1)
            r0 = r3
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1f:
            int r2 = r10.b()
            int r2 = r11 - r2
            if (r2 < 0) goto L77
            b.b.a.a.l.l r3 = r10.c
            int r4 = r3.f
            if (r2 < r4) goto L2e
            goto L77
        L2e:
            int r4 = r2 + 1
            r0.setTag(r3)
            android.content.res.Resources r3 = r0.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            java.util.Locale r3 = r3.locale
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r6[r1] = r7
            java.lang.String r7 = "%d"
            java.lang.String r6 = java.lang.String.format(r3, r7, r6)
            r0.setText(r6)
            b.b.a.a.l.l r6 = r10.c
            long r6 = r6.o(r4)
            b.b.a.a.l.l r8 = r10.c
            int r8 = r8.d
            b.b.a.a.l.l r9 = b.b.a.a.l.l.m()
            int r9 = r9.d
            if (r8 != r9) goto L69
            java.lang.String r8 = b.b.a.a.l.e.a(r6)
            r0.setContentDescription(r8)
            goto L70
        L69:
            java.lang.String r8 = b.b.a.a.l.e.d(r6)
            r0.setContentDescription(r8)
        L70:
            r0.setVisibility(r1)
            r0.setEnabled(r5)
            goto L7f
        L77:
            r3 = 8
            r0.setVisibility(r3)
            r0.setEnabled(r1)
        L7f:
            java.lang.Long r1 = r10.getItem(r11)
            if (r1 != 0) goto L86
            return r0
        L86:
            long r3 = r1.longValue()
            r10.i(r0, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.a.l.m.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    public void k(MaterialCalendarGridView monthGrid) {
        for (Long date : this.e) {
            j(monthGrid, date.longValue());
        }
        d<?> dVar = this.d;
        if (dVar != null) {
            for (Long date2 : dVar.h()) {
                j(monthGrid, date2.longValue());
            }
            this.e = this.d.h();
        }
    }

    public final void j(MaterialCalendarGridView monthGrid, long date) {
        if (l.l(date).equals(this.c)) {
            int day = this.c.p(date);
            i((TextView) monthGrid.getChildAt(monthGrid.getAdapter().a(day) - monthGrid.getFirstVisiblePosition()), date);
        }
    }

    public final void i(TextView day, long date) {
        b style;
        if (day == null) {
            return;
        }
        if (this.g.o().i(date)) {
            day.setEnabled(true);
            if (f(date)) {
                style = this.f.f1021b;
            } else if (s.i().getTimeInMillis() == date) {
                style = this.f.c;
            } else {
                style = this.f.f1020a;
            }
        } else {
            day.setEnabled(false);
            style = this.f.g;
        }
        style.b(day);
    }

    public final boolean f(long date) {
        Iterator<Long> it = this.d.h().iterator();
        while (it.hasNext()) {
            long selectedDay = it.next().longValue();
            if (s.a(date) == s.a(selectedDay)) {
                return true;
            }
        }
        return false;
    }

    public final void e(Context context) {
        if (this.f == null) {
            this.f = new c(context);
        }
    }

    public int b() {
        return this.c.n();
    }

    public int g() {
        return (this.c.n() + this.c.f) - 1;
    }

    public int h(int position) {
        return (position - this.c.n()) + 1;
    }

    public int a(int day) {
        int offsetFromFirst = day - 1;
        return b() + offsetFromFirst;
    }

    public boolean l(int position) {
        return position >= b() && position <= g();
    }
}
