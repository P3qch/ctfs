package b.b.a.a.r;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class h {
    public float c;
    public b.b.a.a.u.d f;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f1072a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final b.b.a.a.u.f f1073b = new a();
    public boolean d = true;
    public WeakReference<b> e = new WeakReference<>(null);

    /* loaded from: classes.dex */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    /* loaded from: classes.dex */
    public class a extends b.b.a.a.u.f {
        public a() {
        }

        @Override // b.b.a.a.u.f
        public void b(Typeface typeface, boolean fontResolvedSynchronously) {
            if (!fontResolvedSynchronously) {
                h.this.d = true;
                b textDrawableDelegate = (b) h.this.e.get();
                if (textDrawableDelegate != null) {
                    textDrawableDelegate.a();
                }
            }
        }

        @Override // b.b.a.a.u.f
        public void a(int reason) {
            h.this.d = true;
            b textDrawableDelegate = (b) h.this.e.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.a();
            }
        }
    }

    public h(b delegate) {
        g(delegate);
    }

    public void g(b delegate) {
        this.e = new WeakReference<>(delegate);
    }

    public TextPaint e() {
        return this.f1072a;
    }

    public void i(boolean dirty) {
        this.d = dirty;
    }

    public float f(String text) {
        if (!this.d) {
            return this.c;
        }
        float c = c(text);
        this.c = c;
        this.d = false;
        return c;
    }

    public final float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f1072a.measureText(charSequence, 0, charSequence.length());
    }

    public b.b.a.a.u.d d() {
        return this.f;
    }

    public void h(b.b.a.a.u.d textAppearance, Context context) {
        if (this.f != textAppearance) {
            this.f = textAppearance;
            if (textAppearance != null) {
                textAppearance.k(context, this.f1072a, this.f1073b);
                b textDrawableDelegate = this.e.get();
                if (textDrawableDelegate != null) {
                    this.f1072a.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.j(context, this.f1072a, this.f1073b);
                this.d = true;
            }
            b textDrawableDelegate2 = this.e.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.a();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    public void j(Context context) {
        this.f.j(context, this.f1072a, this.f1073b);
    }
}
