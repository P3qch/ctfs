package a.k.b;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class y {
    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object g(Object obj);

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);

    public void k(View view, Rect epicenter) {
        if (!a.h.k.v.S(view)) {
            return;
        }
        RectF rect = new RectF();
        rect.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getMatrix().mapRect(rect);
        rect.offset(view.getLeft(), view.getTop());
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View parentView = (View) parent;
            rect.offset(-parentView.getScrollX(), -parentView.getScrollY());
            parentView.getMatrix().mapRect(rect);
            rect.offset(parentView.getLeft(), parentView.getTop());
            parent = parentView.getParent();
        }
        int[] loc = new int[2];
        view.getRootView().getLocationOnScreen(loc);
        rect.offset(loc[0], loc[1]);
        epicenter.set(Math.round(rect.left), Math.round(rect.top), Math.round(rect.right), Math.round(rect.bottom));
    }

    public ArrayList<String> o(ArrayList<View> sharedElementsIn) {
        ArrayList<String> names = new ArrayList<>();
        int numSharedElements = sharedElementsIn.size();
        for (int i = 0; i < numSharedElements; i++) {
            View view = sharedElementsIn.get(i);
            names.add(a.h.k.v.L(view));
            a.h.k.v.C0(view, null);
        }
        return names;
    }

    public void y(View sceneRoot, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn, ArrayList<String> inNames, Map<String, String> nameOverrides) {
        int numSharedElements = sharedElementsIn.size();
        ArrayList<String> outNames = new ArrayList<>();
        for (int i = 0; i < numSharedElements; i++) {
            View view = sharedElementsOut.get(i);
            String name = a.h.k.v.L(view);
            outNames.add(name);
            if (name != null) {
                a.h.k.v.C0(view, null);
                String inName = nameOverrides.get(name);
                int j = 0;
                while (true) {
                    if (j >= numSharedElements) {
                        break;
                    }
                    if (!inName.equals(inNames.get(j))) {
                        j++;
                    } else {
                        a.h.k.v.C0(sharedElementsIn.get(j), name);
                        break;
                    }
                }
            }
        }
        a.h.k.t.a(sceneRoot, new a(this, numSharedElements, sharedElementsIn, inNames, sharedElementsOut, outNames));
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f608b;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ ArrayList e;
        public final /* synthetic */ ArrayList f;

        public a(y this$0, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f608b = i;
            this.c = arrayList;
            this.d = arrayList2;
            this.e = arrayList3;
            this.f = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f608b; i++) {
                a.h.k.v.C0((View) this.c.get(i), (String) this.d.get(i));
                a.h.k.v.C0((View) this.e.get(i), (String) this.f.get(i));
            }
        }
    }

    public void f(ArrayList<View> transitioningViews, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (a.h.k.x.a(viewGroup)) {
                    transitioningViews.add(viewGroup);
                    return;
                }
                int count = viewGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    View child = viewGroup.getChildAt(i);
                    f(transitioningViews, child);
                }
                return;
            }
            transitioningViews.add(view);
        }
    }

    public void j(Map<String, View> namedViews, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = a.h.k.v.L(view);
            if (transitionName != null) {
                namedViews.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int count = viewGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    View child = viewGroup.getChildAt(i);
                    j(namedViews, child);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f609b;
        public final /* synthetic */ Map c;

        public b(y this$0, ArrayList arrayList, Map map) {
            this.f609b = arrayList;
            this.c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int numSharedElements = this.f609b.size();
            for (int i = 0; i < numSharedElements; i++) {
                View view = (View) this.f609b.get(i);
                String name = a.h.k.v.L(view);
                if (name != null) {
                    String inName = y.i(this.c, name);
                    a.h.k.v.C0(view, inName);
                }
            }
        }
    }

    public void x(View sceneRoot, ArrayList<View> sharedElementsIn, Map<String, String> nameOverrides) {
        a.h.k.t.a(sceneRoot, new b(this, sharedElementsIn, nameOverrides));
    }

    public void w(Fragment outFragment, Object transition, a.h.g.b signal, Runnable transitionCompleteRunnable) {
        transitionCompleteRunnable.run();
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f610b;
        public final /* synthetic */ Map c;

        public c(y this$0, ArrayList arrayList, Map map) {
            this.f610b = arrayList;
            this.c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int numSharedElements = this.f610b.size();
            for (int i = 0; i < numSharedElements; i++) {
                View view = (View) this.f610b.get(i);
                String name = a.h.k.v.L(view);
                String inName = (String) this.c.get(name);
                a.h.k.v.C0(view, inName);
            }
        }
    }

    public void s(ViewGroup sceneRoot, ArrayList<View> sharedElementsIn, Map<String, String> nameOverrides) {
        a.h.k.t.a(sceneRoot, new c(this, sharedElementsIn, nameOverrides));
    }

    public static void d(List<View> views, View startView) {
        int startIndex = views.size();
        if (h(views, startView, startIndex)) {
            return;
        }
        if (a.h.k.v.L(startView) != null) {
            views.add(startView);
        }
        for (int index = startIndex; index < views.size(); index++) {
            View view = views.get(index);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int childIndex = 0; childIndex < childCount; childIndex++) {
                    View child = viewGroup.getChildAt(childIndex);
                    if (!h(views, child, startIndex) && a.h.k.v.L(child) != null) {
                        views.add(child);
                    }
                }
            }
        }
    }

    public static boolean h(List<View> views, View view, int maxIndex) {
        for (int i = 0; i < maxIndex; i++) {
            if (views.get(i) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public static String i(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
