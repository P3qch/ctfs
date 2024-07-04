package com.google.android.material.transformation;

import a.h.k.v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.a.a.b.h;
import b.b.a.a.b.j;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.R;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    public Map<View, Integer> i;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public FabTransformationBehavior.e e0(Context context, boolean expanded) {
        int specRes;
        if (expanded) {
            specRes = R.animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            specRes = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.e spec = new FabTransformationBehavior.e();
        spec.f1217a = h.c(context, specRes);
        spec.f1218b = new j(17, 0.0f, 0.0f);
        return spec;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean H(View dependency, View child, boolean expanded, boolean animated) {
        g0(child, expanded);
        super.H(dependency, child, expanded, animated);
        return true;
    }

    public final void g0(View sheet, boolean expanded) {
        ViewParent viewParent = sheet.getParent();
        if (!(viewParent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout parent = (CoordinatorLayout) viewParent;
        int childCount = parent.getChildCount();
        if (expanded) {
            this.i = new HashMap(childCount);
        }
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            boolean hasScrimBehavior = (child.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) child.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
            if (child != sheet && !hasScrimBehavior) {
                if (!expanded) {
                    Map<View, Integer> map = this.i;
                    if (map != null && map.containsKey(child)) {
                        v.x0(child, this.i.get(child).intValue());
                    }
                } else {
                    this.i.put(child, Integer.valueOf(child.getImportantForAccessibility()));
                    v.x0(child, 4);
                }
            }
        }
        if (!expanded) {
            this.i = null;
        }
    }
}
