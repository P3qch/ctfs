package a.i.a;

import a.b.g.r0;
import android.database.Cursor;
import android.widget.Filter;

/* loaded from: classes.dex */
public class b extends Filter {

    /* renamed from: a, reason: collision with root package name */
    public a f505a;

    /* loaded from: classes.dex */
    public interface a {
    }

    public b(a client) {
        this.f505a = client;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object resultValue) {
        return ((r0) this.f505a).c((Cursor) resultValue);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence constraint) {
        Cursor cursor = ((r0) this.f505a).w(constraint);
        Filter.FilterResults results = new Filter.FilterResults();
        if (cursor != null) {
            results.count = cursor.getCount();
            results.values = cursor;
        } else {
            results.count = 0;
            results.values = null;
        }
        return results;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence constraint, Filter.FilterResults results) {
        Cursor oldCursor = ((a.i.a.a) this.f505a).d();
        Object obj = results.values;
        if (obj != null && obj != oldCursor) {
            ((r0) this.f505a).b((Cursor) obj);
        }
    }
}
