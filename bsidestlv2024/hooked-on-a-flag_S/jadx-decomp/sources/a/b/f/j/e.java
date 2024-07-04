package a.b.f.j;

import a.b.f.j.m;
import a.b.f.j.n;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ExpandedMenuView;
import java.util.ArrayList;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public Context f104b;
    public LayoutInflater c;
    public g d;
    public ExpandedMenuView e;
    public int f;
    public int g;
    public m.a h;
    public a i;

    public e(Context context, int itemLayoutRes) {
        this(itemLayoutRes, 0);
        this.f104b = context;
        this.c = LayoutInflater.from(context);
    }

    public e(int itemLayoutRes, int themeRes) {
        this.g = itemLayoutRes;
        this.f = themeRes;
    }

    @Override // a.b.f.j.m
    public void j(Context context, g menu) {
        if (this.f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f);
            this.f104b = contextThemeWrapper;
            this.c = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f104b != null) {
            this.f104b = context;
            if (this.c == null) {
                this.c = LayoutInflater.from(context);
            }
        }
        this.d = menu;
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public n e(ViewGroup root) {
        if (this.e == null) {
            this.e = (ExpandedMenuView) this.c.inflate(R.layout.abc_expanded_menu_layout, root, false);
            if (this.i == null) {
                this.i = new a();
            }
            this.e.setAdapter((ListAdapter) this.i);
            this.e.setOnItemClickListener(this);
        }
        return this.e;
    }

    public ListAdapter a() {
        if (this.i == null) {
            this.i = new a();
        }
        return this.i;
    }

    @Override // a.b.f.j.m
    public void h(boolean cleared) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // a.b.f.j.m
    public void d(m.a cb) {
        this.h = cb;
    }

    @Override // a.b.f.j.m
    public boolean f(r subMenu) {
        if (!subMenu.hasVisibleItems()) {
            return false;
        }
        new h(subMenu).d(null);
        m.a aVar = this.h;
        if (aVar != null) {
            aVar.c(subMenu);
            return true;
        }
        return true;
    }

    @Override // a.b.f.j.m
    public void b(g menu, boolean allMenusAreClosing) {
        m.a aVar = this.h;
        if (aVar != null) {
            aVar.b(menu, allMenusAreClosing);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.d.M(this.i.getItem(position), this, 0);
    }

    @Override // a.b.f.j.m
    public boolean g() {
        return false;
    }

    @Override // a.b.f.j.m
    public boolean c(g menu, i item) {
        return false;
    }

    @Override // a.b.f.j.m
    public boolean k(g menu, i item) {
        return false;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: b, reason: collision with root package name */
        public int f105b = -1;

        public a() {
            a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.d.z().size();
            e.this.getClass();
            int count = size + 0;
            if (this.f105b < 0) {
                return count;
            }
            return count - 1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i getItem(int position) {
            ArrayList<i> z = e.this.d.z();
            e.this.getClass();
            int position2 = position + 0;
            int i = this.f105b;
            if (i >= 0 && position2 >= i) {
                position2++;
            }
            return z.get(position2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                e eVar = e.this;
                convertView = eVar.c.inflate(eVar.g, parent, false);
            }
            n.a itemView = (n.a) convertView;
            itemView.e(getItem(position), 0);
            return convertView;
        }

        public void a() {
            i expandedItem = e.this.d.v();
            if (expandedItem != null) {
                ArrayList<i> z = e.this.d.z();
                int count = z.size();
                for (int i = 0; i < count; i++) {
                    i item = z.get(i);
                    if (item == expandedItem) {
                        this.f105b = i;
                        return;
                    }
                }
            }
            this.f105b = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }
}
