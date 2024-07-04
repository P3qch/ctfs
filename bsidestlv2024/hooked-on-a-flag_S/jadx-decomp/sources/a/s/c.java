package a.s;

import a.s.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* loaded from: classes.dex */
public class c extends k {
    public static final String[] I = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<Drawable, PointF> J = new a(PointF.class, "boundsOrigin");
    public static final Property<i, PointF> K = new b(PointF.class, "topLeft");
    public static final Property<i, PointF> L = new C0051c(PointF.class, "bottomRight");
    public static final Property<View, PointF> M = new d(PointF.class, "bottomRight");
    public static final Property<View, PointF> N = new e(PointF.class, "topLeft");
    public static final Property<View, PointF> O = new f(PointF.class, "position");
    public static a.s.i P = new a.s.i();
    public int[] Q = new int[2];
    public boolean R = false;
    public boolean S = false;

    /* loaded from: classes.dex */
    public static class a extends Property<Drawable, PointF> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f694a;

        public a(Class cls, String x1) {
            super(cls, x1);
            this.f694a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable object, PointF value) {
            object.copyBounds(this.f694a);
            this.f694a.offsetTo(Math.round(value.x), Math.round(value.y));
            object.setBounds(this.f694a);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable object) {
            object.copyBounds(this.f694a);
            Rect rect = this.f694a;
            return new PointF(rect.left, rect.top);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Property<i, PointF> {
        public b(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(i iVar) {
            a();
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i viewBounds, PointF topLeft) {
            viewBounds.c(topLeft);
        }

        public PointF a() {
            return null;
        }
    }

    /* renamed from: a.s.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0051c extends Property<i, PointF> {
        public C0051c(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(i iVar) {
            a();
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i viewBounds, PointF bottomRight) {
            viewBounds.a(bottomRight);
        }

        public PointF a() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends Property<View, PointF> {
        public d(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            a();
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF bottomRight) {
            int left = view.getLeft();
            int top = view.getTop();
            int right = Math.round(bottomRight.x);
            int bottom = Math.round(bottomRight.y);
            y.e(view, left, top, right, bottom);
        }

        public PointF a() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends Property<View, PointF> {
        public e(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            a();
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF topLeft) {
            int left = Math.round(topLeft.x);
            int top = Math.round(topLeft.y);
            int right = view.getRight();
            int bottom = view.getBottom();
            y.e(view, left, top, right, bottom);
        }

        public PointF a() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends Property<View, PointF> {
        public f(Class cls, String x1) {
            super(cls, x1);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            a();
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF topLeft) {
            int left = Math.round(topLeft.x);
            int top = Math.round(topLeft.y);
            int right = view.getWidth() + left;
            int bottom = view.getHeight() + top;
            y.e(view, left, top, right, bottom);
        }

        public PointF a() {
            return null;
        }
    }

    @Override // a.s.k
    public String[] D() {
        return I;
    }

    public final void c0(q values) {
        View view = values.f735b;
        if (a.h.k.v.T(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            values.f734a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            values.f734a.put("android:changeBounds:parent", values.f735b.getParent());
        }
    }

    @Override // a.s.k
    public void j(q transitionValues) {
        c0(transitionValues);
    }

    @Override // a.s.k
    public void g(q transitionValues) {
        c0(transitionValues);
    }

    public final boolean d0(View startParent, View endParent) {
        return true;
    }

    @Override // a.s.k
    public Animator n(ViewGroup sceneRoot, q startValues, q endValues) {
        c cVar;
        Animator anim;
        if (startValues != null && endValues != null) {
            Map<String, Object> startParentVals = startValues.f734a;
            Map<String, Object> endParentVals = endValues.f734a;
            ViewGroup startParent = (ViewGroup) startParentVals.get("android:changeBounds:parent");
            ViewGroup endParent = (ViewGroup) endParentVals.get("android:changeBounds:parent");
            if (startParent != null && endParent != null) {
                View view = endValues.f735b;
                d0(startParent, endParent);
                Rect startBounds = (Rect) startValues.f734a.get("android:changeBounds:bounds");
                Rect endBounds = (Rect) endValues.f734a.get("android:changeBounds:bounds");
                int startLeft = startBounds.left;
                int endLeft = endBounds.left;
                int startTop = startBounds.top;
                int endTop = endBounds.top;
                int startRight = startBounds.right;
                int endRight = endBounds.right;
                int startBottom = startBounds.bottom;
                int endBottom = endBounds.bottom;
                int startWidth = startRight - startLeft;
                int startHeight = startBottom - startTop;
                int endWidth = endRight - endLeft;
                int endHeight = endBottom - endTop;
                Rect startClip = (Rect) startValues.f734a.get("android:changeBounds:clip");
                Rect endClip = (Rect) endValues.f734a.get("android:changeBounds:clip");
                if ((startWidth != 0 && startHeight != 0) || (endWidth != 0 && endHeight != 0)) {
                    numChanges = (startLeft == endLeft && startTop == endTop) ? 0 : 0 + 1;
                    if (startRight != endRight || startBottom != endBottom) {
                        numChanges++;
                    }
                }
                if ((startClip != null && !startClip.equals(endClip)) || (startClip == null && endClip != null)) {
                    numChanges++;
                }
                if (numChanges > 0) {
                    y.e(view, startLeft, startTop, startRight, startBottom);
                    if (numChanges == 2) {
                        if (startWidth != endWidth || startHeight != endHeight) {
                            i viewBounds = new i(view);
                            Path topLeftPath = v().a(startLeft, startTop, endLeft, endTop);
                            ObjectAnimator topLeftAnimator = a.s.f.a(viewBounds, K, topLeftPath);
                            Path bottomRightPath = v().a(startRight, startBottom, endRight, endBottom);
                            ObjectAnimator bottomRightAnimator = a.s.f.a(viewBounds, L, bottomRightPath);
                            AnimatorSet set = new AnimatorSet();
                            set.playTogether(topLeftAnimator, bottomRightAnimator);
                            cVar = this;
                            set.addListener(new g(cVar, viewBounds));
                            anim = set;
                        } else {
                            Path topLeftPath2 = v().a(startLeft, startTop, endLeft, endTop);
                            Animator anim2 = a.s.f.a(view, O, topLeftPath2);
                            anim = anim2;
                            cVar = this;
                        }
                    } else {
                        cVar = this;
                        if (startLeft != endLeft || startTop != endTop) {
                            Path topLeftPath3 = v().a(startLeft, startTop, endLeft, endTop);
                            anim = a.s.f.a(view, N, topLeftPath3);
                        } else {
                            Path bottomRight = v().a(startRight, startBottom, endRight, endBottom);
                            anim = a.s.f.a(view, M, bottomRight);
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        ViewGroup parent = (ViewGroup) view.getParent();
                        v.c(parent, true);
                        k.f transitionListener = new h(cVar, parent);
                        cVar.a(transitionListener);
                    }
                    return anim;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f695a;
        private i mViewBounds;

        public g(c this$0, i iVar) {
            this.f695a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* loaded from: classes.dex */
    public class h extends l {

        /* renamed from: a, reason: collision with root package name */
        public boolean f696a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f697b;

        public h(c this$0, ViewGroup viewGroup) {
            this.f697b = viewGroup;
        }

        @Override // a.s.l, a.s.k.f
        public void b(k transition) {
            v.c(this.f697b, false);
            this.f696a = true;
        }

        @Override // a.s.k.f
        public void c(k transition) {
            if (!this.f696a) {
                v.c(this.f697b, false);
            }
            transition.P(this);
        }

        @Override // a.s.l, a.s.k.f
        public void d(k transition) {
            v.c(this.f697b, false);
        }

        @Override // a.s.l, a.s.k.f
        public void e(k transition) {
            v.c(this.f697b, true);
        }
    }

    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public int f698a;

        /* renamed from: b, reason: collision with root package name */
        public int f699b;
        public int c;
        public int d;
        public View e;
        public int f;
        public int g;

        public i(View view) {
            this.e = view;
        }

        public void c(PointF topLeft) {
            this.f698a = Math.round(topLeft.x);
            this.f699b = Math.round(topLeft.y);
            int i = this.f + 1;
            this.f = i;
            if (i == this.g) {
                b();
            }
        }

        public void a(PointF bottomRight) {
            this.c = Math.round(bottomRight.x);
            this.d = Math.round(bottomRight.y);
            int i = this.g + 1;
            this.g = i;
            if (this.f == i) {
                b();
            }
        }

        public final void b() {
            y.e(this.e, this.f698a, this.f699b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }
    }
}
