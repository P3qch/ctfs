package b.b.a.a.v;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import b.b.a.a.x.g;
import b.b.a.a.x.k;
import b.b.a.a.x.n;

/* loaded from: classes.dex */
public class a extends Drawable implements n, a.h.d.l.b {

    /* renamed from: b, reason: collision with root package name */
    public b f1090b;

    @Override // android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable mutate() {
        a();
        return this;
    }

    public a(k shapeAppearanceModel) {
        this(new b(new g(shapeAppearanceModel)));
    }

    public a(b state) {
        this.f1090b = state;
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTint(int tintColor) {
        this.f1090b.f1091a.setTint(tintColor);
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintMode(PorterDuff.Mode tintMode) {
        this.f1090b.f1091a.setTintMode(tintMode);
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintList(ColorStateList tintList) {
        this.f1090b.f1091a.setTintList(tintList);
    }

    @Override // b.b.a.a.x.n
    public void setShapeAppearanceModel(k shapeAppearanceModel) {
        this.f1090b.f1091a.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        boolean changed = super.onStateChange(stateSet);
        if (this.f1090b.f1091a.setState(stateSet)) {
            changed = true;
        }
        boolean shouldDrawRipple = b.b.a.a.v.b.b(stateSet);
        b bVar = this.f1090b;
        if (bVar.f1092b != shouldDrawRipple) {
            bVar.f1092b = shouldDrawRipple;
            return true;
        }
        return changed;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f1090b;
        if (bVar.f1092b) {
            bVar.f1091a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.f1090b.f1091a.setBounds(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f1090b;
    }

    public a a() {
        b newDrawableState = new b(this.f1090b);
        this.f1090b = newDrawableState;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.f1090b.f1091a.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1090b.f1091a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1090b.f1091a.getOpacity();
    }

    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public g f1091a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1092b;

        public b(g delegate) {
            this.f1091a = delegate;
            this.f1092b = false;
        }

        public b(b orig) {
            this.f1091a = (g) orig.f1091a.getConstantState().newDrawable();
            this.f1092b = orig.f1092b;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }
}
