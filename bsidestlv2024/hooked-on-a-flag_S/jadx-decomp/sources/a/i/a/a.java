package a.i.a;

import a.i.a.b;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: b, reason: collision with root package name */
    public boolean f502b;
    public boolean c;
    public Cursor d;
    public Context e;
    public int f;
    public C0036a g;
    public DataSetObserver h;
    public a.i.a.b i;

    public abstract void a(View view, Context context, Cursor cursor);

    public abstract CharSequence c(Cursor cursor);

    public abstract View f(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    public a(Context context, Cursor c, boolean autoRequery) {
        e(context, c, autoRequery ? 1 : 2);
    }

    public void e(Context context, Cursor c, int flags) {
        if ((flags & 1) == 1) {
            flags |= 2;
            this.c = true;
        } else {
            this.c = false;
        }
        boolean cursorPresent = c != null;
        this.d = c;
        this.f502b = cursorPresent;
        this.e = context;
        this.f = cursorPresent ? c.getColumnIndexOrThrow("_id") : -1;
        if ((flags & 2) == 2) {
            this.g = new C0036a();
            this.h = new b();
        } else {
            this.g = null;
            this.h = null;
        }
        if (cursorPresent) {
            C0036a c0036a = this.g;
            if (c0036a != null) {
                c.registerContentObserver(c0036a);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver != null) {
                c.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public Cursor d() {
        return this.d;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (this.f502b && (cursor = this.d) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        Cursor cursor;
        if (this.f502b && (cursor = this.d) != null) {
            cursor.moveToPosition(position);
            return this.d;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        Cursor cursor;
        if (this.f502b && (cursor = this.d) != null && cursor.moveToPosition(position)) {
            return this.d.getLong(this.f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (!this.f502b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.d.moveToPosition(position)) {
            throw new IllegalStateException("couldn't move cursor to position " + position);
        }
        if (convertView == null) {
            v = g(this.e, this.d, parent);
        } else {
            v = convertView;
        }
        a(v, this.e, this.d);
        return v;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v;
        if (this.f502b) {
            this.d.moveToPosition(position);
            if (convertView == null) {
                v = f(this.e, this.d, parent);
            } else {
                v = convertView;
            }
            a(v, this.e, this.d);
            return v;
        }
        return null;
    }

    public void b(Cursor cursor) {
        Cursor old = i(cursor);
        if (old != null) {
            old.close();
        }
    }

    public Cursor i(Cursor newCursor) {
        if (newCursor == this.d) {
            return null;
        }
        Cursor oldCursor = this.d;
        if (oldCursor != null) {
            C0036a c0036a = this.g;
            if (c0036a != null) {
                oldCursor.unregisterContentObserver(c0036a);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver != null) {
                oldCursor.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.d = newCursor;
        if (newCursor != null) {
            C0036a c0036a2 = this.g;
            if (c0036a2 != null) {
                newCursor.registerContentObserver(c0036a2);
            }
            DataSetObserver dataSetObserver2 = this.h;
            if (dataSetObserver2 != null) {
                newCursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f = newCursor.getColumnIndexOrThrow("_id");
            this.f502b = true;
            notifyDataSetChanged();
        } else {
            this.f = -1;
            this.f502b = false;
            notifyDataSetInvalidated();
        }
        return oldCursor;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i == null) {
            this.i = new a.i.a.b(this);
        }
        return this.i;
    }

    public void h() {
        Cursor cursor;
        if (this.c && (cursor = this.d) != null && !cursor.isClosed()) {
            this.f502b = this.d.requery();
        }
    }

    /* renamed from: a.i.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0036a extends ContentObserver {
        public C0036a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            a.this.h();
        }
    }

    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f502b = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f502b = false;
            aVar.notifyDataSetInvalidated();
        }
    }
}
