package b.b.a.a.q;

import a.h.k.v;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f1049a = b.b.a.a.b.a.c;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1050b = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] c = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] d = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] e = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] f = {R.attr.state_enabled};
    public static final int[] g = new int[0];
    public final b.b.a.a.w.b A;
    public ViewTreeObserver.OnPreDrawListener F;
    public b.b.a.a.x.k h;
    public boolean i;
    public float k;
    public float l;
    public float m;
    public final b.b.a.a.r.f n;
    public b.b.a.a.b.h o;
    public b.b.a.a.b.h p;
    public Animator q;
    public b.b.a.a.b.h r;
    public b.b.a.a.b.h s;
    public float t;
    public ArrayList<Animator.AnimatorListener> w;
    public ArrayList<Animator.AnimatorListener> x;
    public ArrayList<i> y;
    public final FloatingActionButton z;
    public boolean j = true;
    public float u = 1.0f;
    public int v = 0;
    public final Rect B = new Rect();
    public final RectF C = new RectF();
    public final RectF D = new RectF();
    public final Matrix E = new Matrix();

    /* loaded from: classes.dex */
    public interface i {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface j {
    }

    public a(FloatingActionButton view, b.b.a.a.w.b shadowViewDelegate) {
        this.z = view;
        this.A = shadowViewDelegate;
        b.b.a.a.r.f fVar = new b.b.a.a.r.f();
        this.n = fVar;
        fVar.a(f1050b, i(new h()));
        fVar.a(c, i(new g()));
        fVar.a(d, i(new g()));
        fVar.a(e, i(new g()));
        fVar.a(f, i(new k()));
        fVar.a(g, i(new f(this)));
        this.t = view.getRotation();
    }

    public void J(ColorStateList tint) {
    }

    public void K(PorterDuff.Mode tintMode) {
    }

    public void R(ColorStateList rippleColor) {
    }

    public final void L(float elevation) {
        if (this.k != elevation) {
            this.k = elevation;
            D(elevation, this.l, this.m);
        }
    }

    public float m() {
        return this.k;
    }

    public float p() {
        return this.l;
    }

    public float s() {
        return this.m;
    }

    public final void O(float translationZ) {
        if (this.l != translationZ) {
            this.l = translationZ;
            D(this.k, translationZ, this.m);
        }
    }

    public final void Q(float translationZ) {
        if (this.m != translationZ) {
            this.m = translationZ;
            D(this.k, this.l, translationZ);
        }
    }

    public final void a0() {
        P(this.u);
    }

    public final void P(float scale) {
        this.u = scale;
        Matrix matrix = this.E;
        g(scale, matrix);
        this.z.setImageMatrix(matrix);
    }

    public final void g(float scale, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.z.getDrawable();
        if (drawable != null) {
        }
    }

    public final void T(b.b.a.a.x.k shapeAppearance) {
        this.h = shapeAppearance;
    }

    public final b.b.a.a.x.k t() {
        return this.h;
    }

    public final b.b.a.a.b.h u() {
        return this.r;
    }

    public final void U(b.b.a.a.b.h spec) {
        this.r = spec;
    }

    public final b.b.a.a.b.h o() {
        return this.s;
    }

    public final void N(b.b.a.a.b.h spec) {
        this.s = spec;
    }

    public final boolean X() {
        return !this.i || this.z.getSizeDimension() >= 0;
    }

    public boolean n() {
        return this.i;
    }

    public void M(boolean flag) {
        this.i = flag;
    }

    public void S(boolean shadowPaddingEnabled) {
        this.j = shadowPaddingEnabled;
        b0();
        throw null;
    }

    public void D(float elevation, float hoveredFocusedTranslationZ, float pressedTranslationZ) {
        b0();
        throw null;
    }

    public void c0(float elevation) {
    }

    public void C(int[] state) {
        this.n.d(state);
    }

    public void y() {
        this.n.c();
    }

    public void e(Animator.AnimatorListener listener) {
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.add(listener);
    }

    public void d(Animator.AnimatorListener listener) {
        if (this.x == null) {
            this.x = new ArrayList<>();
        }
        this.x.add(listener);
    }

    public void v(j listener, boolean fromUser) {
        if (w()) {
            return;
        }
        Animator animator = this.q;
        if (animator != null) {
            animator.cancel();
        }
        if (W()) {
            b.b.a.a.b.h hVar = this.s;
            if (hVar == null) {
                hVar = k();
            }
            AnimatorSet set = h(hVar, 0.0f, 0.0f, 0.0f);
            set.addListener(new C0070a(fromUser, listener));
            ArrayList<Animator.AnimatorListener> arrayList = this.x;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    Animator.AnimatorListener l2 = it.next();
                    set.addListener(l2);
                }
            }
            set.start();
            return;
        }
        this.z.b(fromUser ? 8 : 4, fromUser);
        if (listener != null) {
            ((FloatingActionButton.a) listener).a();
        }
    }

    /* renamed from: b.b.a.a.q.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0070a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1051a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f1052b;
        public final /* synthetic */ j c;

        public C0070a(boolean z, j jVar) {
            this.f1052b = z;
            this.c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            a.this.z.b(0, this.f1052b);
            a.this.v = 1;
            a.this.q = animation;
            this.f1051a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.f1051a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            a.this.v = 0;
            a.this.q = null;
            if (!this.f1051a) {
                FloatingActionButton floatingActionButton = a.this.z;
                boolean z = this.f1052b;
                floatingActionButton.b(z ? 8 : 4, z);
                j jVar = this.c;
                if (jVar != null) {
                    ((FloatingActionButton.a) jVar).a();
                }
            }
        }
    }

    public void Y(j listener, boolean fromUser) {
        if (x()) {
            return;
        }
        Animator animator = this.q;
        if (animator != null) {
            animator.cancel();
        }
        if (W()) {
            if (this.z.getVisibility() != 0) {
                this.z.setAlpha(0.0f);
                this.z.setScaleY(0.0f);
                this.z.setScaleX(0.0f);
                P(0.0f);
            }
            b.b.a.a.b.h hVar = this.r;
            if (hVar == null) {
                hVar = l();
            }
            AnimatorSet set = h(hVar, 1.0f, 1.0f, 1.0f);
            set.addListener(new b(fromUser, listener));
            ArrayList<Animator.AnimatorListener> arrayList = this.w;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    Animator.AnimatorListener l2 = it.next();
                    set.addListener(l2);
                }
            }
            set.start();
            return;
        }
        this.z.b(0, fromUser);
        this.z.setAlpha(1.0f);
        this.z.setScaleY(1.0f);
        this.z.setScaleX(1.0f);
        P(1.0f);
        if (listener != null) {
            ((FloatingActionButton.a) listener).b();
        }
    }

    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1053a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f1054b;

        public b(boolean z, j jVar) {
            this.f1053a = z;
            this.f1054b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            a.this.z.b(0, this.f1053a);
            a.this.v = 2;
            a.this.q = animation;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            a.this.v = 0;
            a.this.q = null;
            j jVar = this.f1054b;
            if (jVar != null) {
                ((FloatingActionButton.a) jVar).b();
            }
        }
    }

    public final b.b.a.a.b.h l() {
        if (this.o == null) {
            this.o = b.b.a.a.b.h.c(this.z.getContext(), net.sqlcipher.R.animator.design_fab_show_motion_spec);
        }
        b.b.a.a.b.h hVar = this.o;
        a.h.j.i.e(hVar);
        return hVar;
    }

    public final b.b.a.a.b.h k() {
        if (this.p == null) {
            this.p = b.b.a.a.b.h.c(this.z.getContext(), net.sqlcipher.R.animator.design_fab_hide_motion_spec);
        }
        b.b.a.a.b.h hVar = this.p;
        a.h.j.i.e(hVar);
        return hVar;
    }

    public final AnimatorSet h(b.b.a.a.b.h spec, float opacity, float scale, float iconScale) {
        List<Animator> animators = new ArrayList<>();
        ObjectAnimator animatorOpacity = ObjectAnimator.ofFloat(this.z, (Property<FloatingActionButton, Float>) View.ALPHA, opacity);
        spec.e("opacity").a(animatorOpacity);
        animators.add(animatorOpacity);
        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(this.z, (Property<FloatingActionButton, Float>) View.SCALE_X, scale);
        spec.e("scale").a(animatorScaleX);
        d0(animatorScaleX);
        animators.add(animatorScaleX);
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(this.z, (Property<FloatingActionButton, Float>) View.SCALE_Y, scale);
        spec.e("scale").a(animatorScaleY);
        d0(animatorScaleY);
        animators.add(animatorScaleY);
        g(iconScale, this.E);
        ObjectAnimator animatorIconScale = ObjectAnimator.ofObject(this.z, new b.b.a.a.b.f(), new c(), new Matrix(this.E));
        spec.e("iconScale").a(animatorIconScale);
        animators.add(animatorIconScale);
        AnimatorSet set = new AnimatorSet();
        b.b.a.a.b.b.a(set, animators);
        return set;
    }

    /* loaded from: classes.dex */
    public class c extends b.b.a.a.b.g {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float fraction, Matrix startValue, Matrix endValue) {
            a.this.u = fraction;
            return super.evaluate(fraction, startValue, endValue);
        }
    }

    public final void d0(ObjectAnimator animator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        animator.setEvaluator(new d(this));
    }

    /* loaded from: classes.dex */
    public class d implements TypeEvaluator<Float> {

        /* renamed from: a, reason: collision with root package name */
        public FloatEvaluator f1055a = new FloatEvaluator();

        public d(a this$0) {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float fraction, Float startValue, Float endValue) {
            float evaluated = this.f1055a.evaluate(fraction, (Number) startValue, (Number) endValue).floatValue();
            return Float.valueOf(evaluated < 0.1f ? 0.0f : evaluated);
        }
    }

    public void f(i listener) {
        if (this.y == null) {
            this.y = new ArrayList<>();
        }
        this.y.add(listener);
    }

    public void H() {
        ArrayList<i> arrayList = this.y;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i l2 = it.next();
                l2.b();
            }
        }
    }

    public void G() {
        ArrayList<i> arrayList = this.y;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i l2 = it.next();
                l2.a();
            }
        }
    }

    public final Drawable j() {
        return null;
    }

    public void A() {
    }

    public final void b0() {
        Rect rect = this.B;
        r(rect);
        E(rect);
        ((FloatingActionButton.c) this.A).c(rect.left, rect.top, rect.right, rect.bottom);
        throw null;
    }

    public void r(Rect rect) {
        int minPadding = this.i ? (0 - this.z.getSizeDimension()) / 2 : 0;
        float maxShadowSize = this.j ? m() + this.m : 0.0f;
        int hPadding = Math.max(minPadding, (int) Math.ceil(maxShadowSize));
        int vPadding = Math.max(minPadding, (int) Math.ceil(1.5f * maxShadowSize));
        rect.set(hPadding, vPadding, hPadding, vPadding);
    }

    public void E(Rect padding) {
        a.h.j.i.f(null, "Didn't initialize content background");
        if (!V()) {
            ((FloatingActionButton.c) this.A).b(null);
        } else {
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) null, padding.left, padding.top, padding.right, padding.bottom);
            ((FloatingActionButton.c) this.A).b(insetDrawable);
        }
    }

    public boolean V() {
        return true;
    }

    public void z() {
        if (I()) {
            this.z.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }

    public void B() {
        ViewTreeObserver viewTreeObserver = this.z.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.F;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.F = null;
        }
    }

    public boolean I() {
        return true;
    }

    public void F() {
        float rotation = this.z.getRotation();
        if (this.t != rotation) {
            this.t = rotation;
            Z();
        }
    }

    public final ViewTreeObserver.OnPreDrawListener q() {
        if (this.F == null) {
            this.F = new e();
        }
        return this.F;
    }

    /* loaded from: classes.dex */
    public class e implements ViewTreeObserver.OnPreDrawListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.F();
            return true;
        }
    }

    public boolean x() {
        return this.z.getVisibility() != 0 ? this.v == 2 : this.v != 1;
    }

    public boolean w() {
        return this.z.getVisibility() == 0 ? this.v == 1 : this.v != 2;
    }

    public final ValueAnimator i(l impl) {
        ValueAnimator animator = new ValueAnimator();
        animator.setInterpolator(f1049a);
        animator.setDuration(100L);
        animator.addListener(impl);
        animator.addUpdateListener(impl);
        animator.setFloatValues(0.0f, 1.0f);
        return animator;
    }

    /* loaded from: classes.dex */
    public abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1057a;

        /* renamed from: b, reason: collision with root package name */
        public float f1058b;
        public float c;

        public abstract float a();

        public l() {
        }

        public /* synthetic */ l(a x0, C0070a x1) {
            this();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animator) {
            if (!this.f1057a) {
                a.this.getClass();
                this.f1058b = 0.0f;
                this.c = a();
                this.f1057a = true;
            }
            a aVar = a.this;
            float f = this.f1058b;
            aVar.c0((int) (f + ((this.c - f) * animator.getAnimatedFraction())));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.c0((int) this.c);
            this.f1057a = false;
        }
    }

    /* loaded from: classes.dex */
    public class k extends l {
        public k() {
            super(a.this, null);
        }

        @Override // b.b.a.a.q.a.l
        public float a() {
            return a.this.k;
        }
    }

    /* loaded from: classes.dex */
    public class g extends l {
        public g() {
            super(a.this, null);
        }

        @Override // b.b.a.a.q.a.l
        public float a() {
            a aVar = a.this;
            return aVar.k + aVar.l;
        }
    }

    /* loaded from: classes.dex */
    public class h extends l {
        public h() {
            super(a.this, null);
        }

        @Override // b.b.a.a.q.a.l
        public float a() {
            a aVar = a.this;
            return aVar.k + aVar.m;
        }
    }

    /* loaded from: classes.dex */
    public class f extends l {
        public f(a aVar) {
            super(aVar, null);
        }

        @Override // b.b.a.a.q.a.l
        public float a() {
            return 0.0f;
        }
    }

    public final boolean W() {
        return v.T(this.z) && !this.z.isInEditMode();
    }

    public void Z() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.t % 90.0f != 0.0f) {
                if (this.z.getLayerType() != 1) {
                    this.z.setLayerType(1, null);
                }
            } else if (this.z.getLayerType() != 0) {
                this.z.setLayerType(0, null);
            }
        }
    }
}
