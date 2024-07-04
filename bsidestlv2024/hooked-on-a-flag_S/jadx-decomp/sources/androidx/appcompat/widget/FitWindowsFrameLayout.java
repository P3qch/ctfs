package androidx.appcompat.widget;

import a.b.b.f;
import a.b.g.h0;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements h0 {

    /* renamed from: b, reason: collision with root package name */
    public h0.a f811b;

    public FitWindowsFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // a.b.g.h0
    public void setOnFitSystemWindowsListener(h0.a listener) {
        this.f811b = listener;
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect insets) {
        h0.a aVar = this.f811b;
        if (aVar != null) {
            ((f.d) aVar).a(insets);
        }
        return super.fitSystemWindows(insets);
    }
}
