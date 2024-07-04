package a.d.a;

import a.d.a.h;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class d implements f {

    /* renamed from: a, reason: collision with root package name */
    public final RectF f233a = new RectF();

    /* loaded from: classes.dex */
    public class a implements h.a {
        public a() {
        }
    }

    @Override // a.d.a.f
    public void l() {
        h.f238b = new a();
    }

    public void o(e cardView) {
        Rect shadowPadding = new Rect();
        n(cardView).g(shadowPadding);
        cardView.e((int) Math.ceil(g(cardView)), (int) Math.ceil(e(cardView)));
        cardView.c(shadowPadding.left, shadowPadding.top, shadowPadding.right, shadowPadding.bottom);
    }

    @Override // a.d.a.f
    public void h(e cardView) {
    }

    @Override // a.d.a.f
    public void c(e cardView) {
        n(cardView).l(cardView.f());
        o(cardView);
    }

    @Override // a.d.a.f
    public void d(e cardView, ColorStateList color) {
        n(cardView).n(color);
        throw null;
    }

    @Override // a.d.a.f
    public ColorStateList i(e cardView) {
        return n(cardView).e();
    }

    @Override // a.d.a.f
    public void m(e cardView, float radius) {
        n(cardView).o(radius);
        o(cardView);
    }

    @Override // a.d.a.f
    public float b(e cardView) {
        return n(cardView).f();
    }

    @Override // a.d.a.f
    public void j(e cardView, float elevation) {
        n(cardView).q(elevation);
    }

    @Override // a.d.a.f
    public float f(e cardView) {
        return n(cardView).k();
    }

    @Override // a.d.a.f
    public void k(e cardView, float maxElevation) {
        n(cardView).p(maxElevation);
        o(cardView);
    }

    @Override // a.d.a.f
    public float a(e cardView) {
        return n(cardView).h();
    }

    @Override // a.d.a.f
    public float g(e cardView) {
        return n(cardView).j();
    }

    @Override // a.d.a.f
    public float e(e cardView) {
        return n(cardView).i();
    }

    public final h n(e cardView) {
        return (h) cardView.d();
    }
}
