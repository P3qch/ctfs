package b.b.a.a.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class c<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public d f995a;

    /* renamed from: b, reason: collision with root package name */
    public int f996b;
    public int c;

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.c != com.google.android.material.appbar.ViewOffsetBehavior<V extends android.view.View> */
    public c() {
        this.f996b = 0;
        this.c = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.c != com.google.android.material.appbar.ViewOffsetBehavior<V extends android.view.View> */
    public c(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f996b = 0;
        this.c = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.c != com.google.android.material.appbar.ViewOffsetBehavior<V extends android.view.View> */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout parent, V child, int layoutDirection) {
        F(parent, child, layoutDirection);
        if (this.f995a == null) {
            this.f995a = new d(child);
        }
        this.f995a.c();
        this.f995a.a();
        int i = this.f996b;
        if (i != 0) {
            this.f995a.e(i);
            this.f996b = 0;
        }
        int i2 = this.c;
        if (i2 != 0) {
            this.f995a.d(i2);
            this.c = 0;
            return true;
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.c != com.google.android.material.appbar.ViewOffsetBehavior<V extends android.view.View> */
    public void F(CoordinatorLayout parent, V child, int layoutDirection) {
        parent.I(child, layoutDirection);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.c != com.google.android.material.appbar.ViewOffsetBehavior<V extends android.view.View> */
    public boolean G(int offset) {
        d dVar = this.f995a;
        if (dVar != null) {
            return dVar.e(offset);
        }
        this.f996b = offset;
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.c.c != com.google.android.material.appbar.ViewOffsetBehavior<V extends android.view.View> */
    public int E() {
        d dVar = this.f995a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }
}
