package b.b.a.a.m;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class a implements View.OnTouchListener {

    /* renamed from: b, reason: collision with root package name */
    public final Dialog f1046b;
    public final int c;
    public final int d;
    public final int e;

    public a(Dialog dialog, Rect insets) {
        this.f1046b = dialog;
        this.c = insets.left;
        this.d = insets.top;
        this.e = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        View insetView = view.findViewById(R.id.content);
        int insetLeft = this.c + insetView.getLeft();
        int insetRight = insetView.getWidth() + insetLeft;
        int insetTop = this.d + insetView.getTop();
        int insetBottom = insetView.getHeight() + insetTop;
        RectF dialogWindow = new RectF(insetLeft, insetTop, insetRight, insetBottom);
        if (dialogWindow.contains(event.getX(), event.getY())) {
            return false;
        }
        MotionEvent outsideEvent = MotionEvent.obtain(event);
        if (event.getAction() == 1) {
            outsideEvent.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            outsideEvent.setAction(0);
            int i = this.e;
            outsideEvent.setLocation((-i) - 1, (-i) - 1);
        }
        view.performClick();
        return this.f1046b.onTouchEvent(outsideEvent);
    }
}
