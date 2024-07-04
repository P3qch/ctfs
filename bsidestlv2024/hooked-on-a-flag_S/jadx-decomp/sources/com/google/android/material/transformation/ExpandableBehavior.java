package com.google.android.material.transformation;

import a.h.k.v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a, reason: collision with root package name */
    public int f1207a;

    public abstract boolean H(View view, View view2, boolean z, boolean z2);

    public ExpandableBehavior() {
        this.f1207a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1207a = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout parent, View child, int layoutDirection) {
        b.b.a.a.p.a dep;
        if (!v.T(child) && (dep = G(parent, child)) != null && F(dep.a())) {
            this.f1207a = dep.a() ? 1 : 2;
            int expectedState = this.f1207a;
            child.getViewTreeObserver().addOnPreDrawListener(new a(child, expectedState, dep));
            return false;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1208b;
        public final /* synthetic */ int c;
        public final /* synthetic */ b.b.a.a.p.a d;

        public a(View view, int i, b.b.a.a.p.a aVar) {
            this.f1208b = view;
            this.c = i;
            this.d = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f1208b.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f1207a == this.c) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                b.b.a.a.p.a aVar = this.d;
                expandableBehavior.H((View) aVar, this.f1208b, aVar.a(), false);
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout parent, View child, View view) {
        b.b.a.a.p.a aVar = (b.b.a.a.p.a) view;
        boolean expanded = aVar.a();
        if (F(expanded)) {
            this.f1207a = aVar.a() ? 1 : 2;
            return H((View) aVar, child, aVar.a(), true);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b.b.a.a.p.a G(CoordinatorLayout parent, View child) {
        List<View> dependencies = parent.r(child);
        int size = dependencies.size();
        for (int i = 0; i < size; i++) {
            View view = dependencies.get(i);
            if (e(parent, child, view)) {
                return (b.b.a.a.p.a) view;
            }
        }
        return null;
    }

    public final boolean F(boolean expanded) {
        if (!expanded) {
            return this.f1207a == 1;
        }
        int i = this.f1207a;
        return i == 0 || i == 2;
    }
}
