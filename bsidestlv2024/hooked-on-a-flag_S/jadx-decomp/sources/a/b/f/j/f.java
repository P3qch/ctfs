package a.b.f.j;

import a.b.f.j.n;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    public g f106b;
    public int c = -1;
    public boolean d;
    public final boolean e;
    public final LayoutInflater f;
    public final int g;

    public f(g menu, LayoutInflater inflater, boolean overflowOnly, int itemLayoutRes) {
        this.e = overflowOnly;
        this.f = inflater;
        this.f106b = menu;
        this.g = itemLayoutRes;
        a();
    }

    public void d(boolean forceShow) {
        this.d = forceShow;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> z = this.e ? this.f106b.z() : this.f106b.E();
        if (this.c < 0) {
            return z.size();
        }
        return z.size() - 1;
    }

    public g b() {
        return this.f106b;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i getItem(int position) {
        ArrayList<i> z = this.e ? this.f106b.z() : this.f106b.E();
        int i = this.c;
        if (i >= 0 && position >= i) {
            position++;
        }
        return z.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.f.inflate(this.g, parent, false);
        }
        int currGroupId = getItem(position).getGroupId();
        int prevGroupId = position + (-1) >= 0 ? getItem(position - 1).getGroupId() : currGroupId;
        ((ListMenuItemView) convertView).setGroupDividerEnabled(this.f106b.F() && currGroupId != prevGroupId);
        n.a itemView = (n.a) convertView;
        if (this.d) {
            ((ListMenuItemView) convertView).setForceShowIcon(true);
        }
        itemView.e(getItem(position), 0);
        return convertView;
    }

    public void a() {
        i expandedItem = this.f106b.v();
        if (expandedItem != null) {
            ArrayList<i> z = this.f106b.z();
            int count = z.size();
            for (int i = 0; i < count; i++) {
                i item = z.get(i);
                if (item == expandedItem) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
