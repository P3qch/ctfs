package b.b.a.a.r;

import a.h.k.d0;
import a.h.k.q;
import a.h.k.v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class l {

    /* loaded from: classes.dex */
    public interface c {
    }

    public static PorterDuff.Mode e(int value, PorterDuff.Mode defaultMode) {
        switch (value) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                return PorterDuff.Mode.ADD;
            default:
                return defaultMode;
        }
    }

    public static boolean d(View view) {
        return v.C(view) == 1;
    }

    public static float b(Context context, int dp) {
        Resources r = context.getResources();
        return TypedValue.applyDimension(1, dp, r.getDisplayMetrics());
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f1079a;

        /* renamed from: b, reason: collision with root package name */
        public int f1080b;
        public int c;
        public int d;

        public d(int start, int top, int end, int bottom) {
            this.f1079a = start;
            this.f1080b = top;
            this.c = end;
            this.d = bottom;
        }

        public d(d other) {
            this.f1079a = other.f1079a;
            this.f1080b = other.f1080b;
            this.c = other.c;
            this.d = other.d;
        }
    }

    public static void a(View view, c listener) {
        d initialPadding = new d(v.I(view), view.getPaddingTop(), v.H(view), view.getPaddingBottom());
        v.z0(view, new a(listener, initialPadding));
        f(view);
    }

    /* loaded from: classes.dex */
    public static class a implements q {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1077a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f1078b;

        public a(c cVar, d dVar) {
            this.f1077a = cVar;
            this.f1078b = dVar;
        }

        @Override // a.h.k.q
        public d0 a(View view, d0 insets) {
            ((BottomSheetBehavior.d) this.f1077a).a(view, insets, new d(this.f1078b));
            return insets;
        }
    }

    public static void f(View view) {
        if (v.S(view)) {
            v.l0(view);
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    /* loaded from: classes.dex */
    public static class b implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            v.removeOnAttachStateChangeListener(this);
            v.l0(v);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
        }
    }

    public static float c(View view) {
        float absoluteElevation = 0.0f;
        for (ViewParent viewParent = view.getParent(); viewParent instanceof View; viewParent = viewParent.getParent()) {
            absoluteElevation += v.w((View) viewParent);
        }
        return absoluteElevation;
    }
}
