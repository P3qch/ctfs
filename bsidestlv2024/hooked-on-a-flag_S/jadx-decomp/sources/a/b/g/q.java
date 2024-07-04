package a.b.g;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public class q extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f182a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f183b;

    static {
        f182a = Build.VERSION.SDK_INT < 21;
    }

    public q(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        a(context, attrs, defStyleAttr, defStyleRes);
    }

    public final void a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        x0 a2 = x0.v(context, attrs, a.b.a.r, defStyleAttr, defStyleRes);
        int[] iArr = a.b.a.f11a;
        if (a2.s(2)) {
            b(a2.a(2, false));
        }
        setBackgroundDrawable(a2.g(0));
        a2.w();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        if (f182a && this.f183b) {
            yoff -= anchor.getHeight();
        }
        super.showAsDropDown(anchor, xoff, yoff);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        if (f182a && this.f183b) {
            yoff -= anchor.getHeight();
        }
        super.showAsDropDown(anchor, xoff, yoff, gravity);
    }

    @Override // android.widget.PopupWindow
    public void update(View anchor, int xoff, int yoff, int width, int height) {
        if (f182a && this.f183b) {
            yoff -= anchor.getHeight();
        }
        super.update(anchor, xoff, yoff, width, height);
    }

    public final void b(boolean overlapAnchor) {
        if (f182a) {
            this.f183b = overlapAnchor;
        } else {
            a.h.l.h.a(this, overlapAnchor);
        }
    }
}
