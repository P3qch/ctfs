package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.a.a.y.a;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final a i = new a(this);

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public boolean E(View child) {
        return this.i.a(child);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout parent, View child, MotionEvent event) {
        this.i.b(parent, child, event);
        return super.k(parent, child, event);
    }
}
