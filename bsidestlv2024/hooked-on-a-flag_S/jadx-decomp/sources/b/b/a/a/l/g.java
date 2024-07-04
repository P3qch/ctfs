package b.b.a.a.l;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class g extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    public static final int f1023b;
    public final Calendar c;
    public final int d;
    public final int e;

    static {
        f1023b = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public g() {
        Calendar k = s.k();
        this.c = k;
        this.d = k.getMaximum(7);
        this.e = k.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int position) {
        if (position >= this.d) {
            return null;
        }
        return Integer.valueOf(b(position));
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView dayOfWeek = (TextView) convertView;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            dayOfWeek = (TextView) layoutInflater.inflate(R.layout.mtrl_calendar_day_of_week, parent, false);
        }
        this.c.set(7, b(position));
        Locale locale = dayOfWeek.getResources().getConfiguration().locale;
        dayOfWeek.setText(this.c.getDisplayName(7, f1023b, locale));
        dayOfWeek.setContentDescription(String.format(parent.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), this.c.getDisplayName(7, 2, Locale.getDefault())));
        return dayOfWeek;
    }

    public final int b(int position) {
        int dayConstant = this.e + position;
        int i = this.d;
        if (dayConstant > i) {
            return dayConstant - i;
        }
        return dayConstant;
    }
}
