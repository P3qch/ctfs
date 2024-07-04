package a.d.a;

import android.content.res.ColorStateList;

/* loaded from: classes.dex */
public class c implements f {
    @Override // a.d.a.f
    public void m(e cardView, float radius) {
        n(cardView).h(radius);
    }

    @Override // a.d.a.f
    public void l() {
    }

    @Override // a.d.a.f
    public void k(e cardView, float maxElevation) {
        n(cardView).g(maxElevation, cardView.b(), cardView.f());
        o(cardView);
    }

    @Override // a.d.a.f
    public float a(e cardView) {
        return n(cardView).c();
    }

    @Override // a.d.a.f
    public float g(e cardView) {
        return b(cardView) * 2.0f;
    }

    @Override // a.d.a.f
    public float e(e cardView) {
        return b(cardView) * 2.0f;
    }

    @Override // a.d.a.f
    public float b(e cardView) {
        return n(cardView).d();
    }

    @Override // a.d.a.f
    public void j(e cardView, float elevation) {
        cardView.a().setElevation(elevation);
    }

    @Override // a.d.a.f
    public float f(e cardView) {
        return cardView.a().getElevation();
    }

    public void o(e cardView) {
        if (!cardView.b()) {
            cardView.c(0, 0, 0, 0);
            return;
        }
        float elevation = a(cardView);
        float radius = b(cardView);
        int hPadding = (int) Math.ceil(h.b(elevation, radius, cardView.f()));
        int vPadding = (int) Math.ceil(h.c(elevation, radius, cardView.f()));
        cardView.c(hPadding, vPadding, hPadding, vPadding);
    }

    @Override // a.d.a.f
    public void h(e cardView) {
        k(cardView, a(cardView));
    }

    @Override // a.d.a.f
    public void c(e cardView) {
        k(cardView, a(cardView));
    }

    @Override // a.d.a.f
    public void d(e cardView, ColorStateList color) {
        n(cardView).f(color);
        throw null;
    }

    @Override // a.d.a.f
    public ColorStateList i(e cardView) {
        return n(cardView).b();
    }

    public final g n(e cardView) {
        return (g) cardView.d();
    }
}
