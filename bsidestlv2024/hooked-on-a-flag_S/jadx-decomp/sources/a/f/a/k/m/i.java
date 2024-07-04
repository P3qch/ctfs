package a.f.a.k.m;

import a.f.a.k.d;
import a.f.a.k.e;
import a.f.a.k.m.b;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class i {
    public static boolean d(e.a layoutHorizontal, e.a layoutVertical, e.a widgetHorizontal, e.a widgetVertical) {
        e.a aVar;
        e.a aVar2;
        e.a aVar3 = e.a.FIXED;
        boolean fixedHorizontal = widgetHorizontal == aVar3 || widgetHorizontal == (aVar2 = e.a.WRAP_CONTENT) || (widgetHorizontal == e.a.MATCH_PARENT && layoutHorizontal != aVar2);
        boolean fixedVertical = widgetVertical == aVar3 || widgetVertical == (aVar = e.a.WRAP_CONTENT) || (widgetVertical == e.a.MATCH_PARENT && layoutVertical != aVar);
        return fixedHorizontal || fixedVertical;
    }

    public static boolean c(a.f.a.k.f layout, b.InterfaceC0012b measurer) {
        ArrayList<a.f.a.k.e> h1 = layout.h1();
        int count = h1.size();
        ArrayList<Guideline> verticalGuidelines = null;
        ArrayList<Guideline> horizontalGuidelines = null;
        ArrayList<HelperWidget> horizontalBarriers = null;
        ArrayList<HelperWidget> verticalBarriers = null;
        ArrayList<ConstraintWidget> isolatedHorizontalChildren = null;
        ArrayList<ConstraintWidget> isolatedVerticalChildren = null;
        for (int i = 0; i < count; i++) {
            a.f.a.k.e child = h1.get(i);
            if (!d(layout.w(), layout.M(), child.w(), child.M())) {
                return false;
            }
        }
        layout.getClass();
        for (int i2 = 0; i2 < count; i2++) {
            a.f.a.k.e child2 = h1.get(i2);
            if (!d(layout.w(), layout.M(), child2.w(), child2.M())) {
                a.f.a.k.f.H1(child2, measurer, layout.P0, 0);
            }
            if (child2 instanceof a.f.a.k.g) {
                a.f.a.k.g guideline = (a.f.a.k.g) child2;
                if (guideline.h1() == 0) {
                    if (horizontalGuidelines == null) {
                        horizontalGuidelines = new ArrayList<>();
                    }
                    horizontalGuidelines.add(guideline);
                }
                if (guideline.h1() == 1) {
                    if (verticalGuidelines == null) {
                        verticalGuidelines = new ArrayList<>();
                    }
                    verticalGuidelines.add(guideline);
                }
            }
            if (child2 instanceof a.f.a.k.i) {
                if (child2 instanceof a.f.a.k.a) {
                    a.f.a.k.a barrier = (a.f.a.k.a) child2;
                    if (barrier.o1() == 0) {
                        if (horizontalBarriers == null) {
                            horizontalBarriers = new ArrayList<>();
                        }
                        horizontalBarriers.add(barrier);
                    }
                    if (barrier.o1() == 1) {
                        if (verticalBarriers == null) {
                            verticalBarriers = new ArrayList<>();
                        }
                        verticalBarriers.add(barrier);
                    }
                } else {
                    a.f.a.k.i helper = (a.f.a.k.i) child2;
                    if (horizontalBarriers == null) {
                        horizontalBarriers = new ArrayList<>();
                    }
                    horizontalBarriers.add(helper);
                    if (verticalBarriers == null) {
                        verticalBarriers = new ArrayList<>();
                    }
                    verticalBarriers.add(helper);
                }
            }
            if (child2.L.f == null && child2.N.f == null && !(child2 instanceof a.f.a.k.g) && !(child2 instanceof a.f.a.k.a)) {
                if (isolatedHorizontalChildren == null) {
                    isolatedHorizontalChildren = new ArrayList<>();
                }
                isolatedHorizontalChildren.add(child2);
            }
            if (child2.M.f == null && child2.O.f == null && child2.P.f == null && !(child2 instanceof a.f.a.k.g) && !(child2 instanceof a.f.a.k.a)) {
                if (isolatedVerticalChildren == null) {
                    isolatedVerticalChildren = new ArrayList<>();
                }
                isolatedVerticalChildren.add(child2);
            }
        }
        ArrayList<o> arrayList = new ArrayList<>();
        if (verticalGuidelines != null) {
            Iterator<Guideline> it = verticalGuidelines.iterator();
            while (it.hasNext()) {
                a.f.a.k.g guideline2 = (a.f.a.k.g) it.next();
                a(guideline2, 0, arrayList, null);
            }
        }
        if (horizontalBarriers != null) {
            Iterator<HelperWidget> it2 = horizontalBarriers.iterator();
            while (it2.hasNext()) {
                a.f.a.k.i barrier2 = (a.f.a.k.i) it2.next();
                ArrayList<Guideline> verticalGuidelines2 = verticalGuidelines;
                o group = a(barrier2, 0, arrayList, null);
                barrier2.h1(arrayList, 0, group);
                group.b(arrayList);
                verticalGuidelines = verticalGuidelines2;
            }
        }
        a.f.a.k.d left = layout.k(d.a.LEFT);
        if (left.c() != null) {
            Iterator<a.f.a.k.d> it3 = left.c().iterator();
            while (it3.hasNext()) {
                a.f.a.k.d first = it3.next();
                a(first.d, 0, arrayList, null);
                left = left;
            }
        }
        a.f.a.k.d right = layout.k(d.a.RIGHT);
        if (right.c() != null) {
            Iterator<a.f.a.k.d> it4 = right.c().iterator();
            while (it4.hasNext()) {
                a.f.a.k.d first2 = it4.next();
                a(first2.d, 0, arrayList, null);
                right = right;
            }
        }
        a.f.a.k.d center = layout.k(d.a.CENTER);
        if (center.c() != null) {
            Iterator<a.f.a.k.d> it5 = center.c().iterator();
            while (it5.hasNext()) {
                a.f.a.k.d first3 = it5.next();
                a(first3.d, 0, arrayList, null);
                center = center;
            }
        }
        if (isolatedHorizontalChildren != null) {
            Iterator<ConstraintWidget> it6 = isolatedHorizontalChildren.iterator();
            while (it6.hasNext()) {
                a.f.a.k.e widget = (a.f.a.k.e) it6.next();
                a(widget, 0, arrayList, null);
            }
        }
        if (horizontalGuidelines != null) {
            Iterator<Guideline> it7 = horizontalGuidelines.iterator();
            while (it7.hasNext()) {
                a.f.a.k.g guideline3 = (a.f.a.k.g) it7.next();
                a(guideline3, 1, arrayList, null);
            }
        }
        if (verticalBarriers != null) {
            Iterator<HelperWidget> it8 = verticalBarriers.iterator();
            while (it8.hasNext()) {
                a.f.a.k.i barrier3 = (a.f.a.k.i) it8.next();
                o group2 = a(barrier3, 1, arrayList, null);
                barrier3.h1(arrayList, 1, group2);
                group2.b(arrayList);
            }
        }
        a.f.a.k.d top = layout.k(d.a.TOP);
        if (top.c() != null) {
            Iterator<a.f.a.k.d> it9 = top.c().iterator();
            while (it9.hasNext()) {
                a.f.a.k.d first4 = it9.next();
                a(first4.d, 1, arrayList, null);
                horizontalGuidelines = horizontalGuidelines;
            }
        }
        a.f.a.k.d baseline = layout.k(d.a.BASELINE);
        if (baseline.c() != null) {
            Iterator<a.f.a.k.d> it10 = baseline.c().iterator();
            while (it10.hasNext()) {
                a.f.a.k.d first5 = it10.next();
                a(first5.d, 1, arrayList, null);
                baseline = baseline;
            }
        }
        a.f.a.k.d bottom = layout.k(d.a.BOTTOM);
        if (bottom.c() != null) {
            Iterator<a.f.a.k.d> it11 = bottom.c().iterator();
            while (it11.hasNext()) {
                a.f.a.k.d first6 = it11.next();
                a(first6.d, 1, arrayList, null);
                bottom = bottom;
            }
        }
        a.f.a.k.d center2 = layout.k(d.a.CENTER);
        if (center2.c() != null) {
            Iterator<a.f.a.k.d> it12 = center2.c().iterator();
            while (it12.hasNext()) {
                a.f.a.k.d first7 = it12.next();
                a(first7.d, 1, arrayList, null);
                center2 = center2;
            }
        }
        if (isolatedVerticalChildren != null) {
            Iterator<ConstraintWidget> it13 = isolatedVerticalChildren.iterator();
            while (it13.hasNext()) {
                a.f.a.k.e widget2 = (a.f.a.k.e) it13.next();
                a(widget2, 1, arrayList, null);
            }
        }
        for (int i3 = 0; i3 < count; i3++) {
            a.f.a.k.e child3 = h1.get(i3);
            if (child3.l0()) {
                o horizontalGroup = b(arrayList, child3.s0);
                o verticalGroup = b(arrayList, child3.t0);
                if (horizontalGroup != null && verticalGroup != null) {
                    horizontalGroup.g(0, verticalGroup);
                    verticalGroup.i(2);
                    arrayList.remove(horizontalGroup);
                }
            }
        }
        int i4 = arrayList.size();
        if (i4 <= 1) {
            return false;
        }
        o horizontalPick = null;
        o verticalPick = null;
        if (layout.w() == e.a.WRAP_CONTENT) {
            int maxWrap = 0;
            o picked = null;
            Iterator<o> it14 = arrayList.iterator();
            while (it14.hasNext()) {
                o list = it14.next();
                ArrayList<a.f.a.k.e> arrayList2 = h1;
                if (list.d() == 1) {
                    h1 = arrayList2;
                } else {
                    list.h(false);
                    int wrap = list.f(layout.A1(), 0);
                    if (wrap > maxWrap) {
                        maxWrap = wrap;
                        picked = list;
                    }
                    h1 = arrayList2;
                }
            }
            if (picked != null) {
                layout.E0(e.a.FIXED);
                layout.Z0(maxWrap);
                picked.h(true);
                horizontalPick = picked;
            }
        }
        if (layout.M() == e.a.WRAP_CONTENT) {
            int maxWrap2 = 0;
            o picked2 = null;
            Iterator<o> it15 = arrayList.iterator();
            while (it15.hasNext()) {
                o list2 = it15.next();
                if (list2.d() != 0) {
                    list2.h(false);
                    int wrap2 = list2.f(layout.A1(), 1);
                    if (wrap2 > maxWrap2) {
                        picked2 = list2;
                        maxWrap2 = wrap2;
                    }
                }
            }
            if (picked2 != null) {
                layout.V0(e.a.FIXED);
                layout.A0(maxWrap2);
                picked2.h(true);
                verticalPick = picked2;
            }
        }
        return (horizontalPick == null && verticalPick == null) ? false : true;
    }

    public static o b(ArrayList<o> arrayList, int groupId) {
        int count = arrayList.size();
        for (int i = 0; i < count; i++) {
            o group = arrayList.get(i);
            if (groupId == group.c) {
                return group;
            }
        }
        return null;
    }

    public static o a(a.f.a.k.e constraintWidget, int orientation, ArrayList<o> arrayList, o group) {
        int groupId;
        if (orientation == 0) {
            groupId = constraintWidget.s0;
        } else {
            groupId = constraintWidget.t0;
        }
        if (groupId != -1 && (group == null || groupId != group.c)) {
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                }
                o widgetGroup = arrayList.get(i);
                if (widgetGroup.c() != groupId) {
                    i++;
                } else {
                    if (group != null) {
                        group.g(orientation, widgetGroup);
                        arrayList.remove(group);
                    }
                    group = widgetGroup;
                }
            }
        } else if (groupId != -1) {
            return group;
        }
        if (group == null) {
            if (constraintWidget instanceof a.f.a.k.i) {
                a.f.a.k.i helper = (a.f.a.k.i) constraintWidget;
                int groupId2 = helper.i1(orientation);
                if (groupId2 != -1) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        o widgetGroup2 = arrayList.get(i2);
                        if (widgetGroup2.c() != groupId2) {
                            i2++;
                        } else {
                            group = widgetGroup2;
                            break;
                        }
                    }
                }
            }
            if (group == null) {
                group = new o(orientation);
            }
            arrayList.add(group);
        }
        if (group.a(constraintWidget)) {
            if (constraintWidget instanceof a.f.a.k.g) {
                a.f.a.k.g guideline = (a.f.a.k.g) constraintWidget;
                guideline.g1().b(guideline.h1() == 0 ? 1 : 0, arrayList, group);
            }
            if (orientation == 0) {
                constraintWidget.s0 = group.c();
                constraintWidget.L.b(orientation, arrayList, group);
                constraintWidget.N.b(orientation, arrayList, group);
            } else {
                constraintWidget.t0 = group.c();
                constraintWidget.M.b(orientation, arrayList, group);
                constraintWidget.P.b(orientation, arrayList, group);
                constraintWidget.O.b(orientation, arrayList, group);
            }
            constraintWidget.S.b(orientation, arrayList, group);
        }
        return group;
    }
}
