package b.b.a.a.u;

import android.graphics.Typeface;
import b.b.a.a.r.a;

/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f1082a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0072a f1083b;
    public boolean c;

    /* renamed from: b.b.a.a.u.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072a {
    }

    public a(InterfaceC0072a applyFont, Typeface fallbackFont) {
        this.f1082a = fallbackFont;
        this.f1083b = applyFont;
    }

    @Override // b.b.a.a.u.f
    public void b(Typeface font, boolean fontResolvedSynchronously) {
        d(font);
    }

    @Override // b.b.a.a.u.f
    public void a(int reason) {
        d(this.f1082a);
    }

    public void c() {
        this.c = true;
    }

    public final void d(Typeface updatedFont) {
        if (!this.c) {
            ((a.C0071a) this.f1083b).a(updatedFont);
        }
    }
}
