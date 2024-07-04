package b.b.a.a.l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f1020a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1021b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;
    public final Paint h;

    public c(Context context) {
        int calendarStyle = b.b.a.a.u.b.c(context, R.attr.materialCalendarStyle, h.class.getCanonicalName());
        TypedArray calendarAttributes = context.obtainStyledAttributes(calendarStyle, b.b.a.a.a.n);
        int[] iArr = b.b.a.a.a.f942a;
        this.f1020a = b.a(context, calendarAttributes.getResourceId(3, 0));
        this.g = b.a(context, calendarAttributes.getResourceId(1, 0));
        this.f1021b = b.a(context, calendarAttributes.getResourceId(2, 0));
        this.c = b.a(context, calendarAttributes.getResourceId(4, 0));
        ColorStateList rangeFillColorList = b.b.a.a.u.c.a(context, calendarAttributes, 6);
        this.d = b.a(context, calendarAttributes.getResourceId(8, 0));
        this.e = b.a(context, calendarAttributes.getResourceId(7, 0));
        this.f = b.a(context, calendarAttributes.getResourceId(9, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(rangeFillColorList.getDefaultColor());
        calendarAttributes.recycle();
    }
}
