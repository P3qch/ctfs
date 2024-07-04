package a.b.g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class o extends ImageView implements a.h.k.u, a.h.l.m {

    /* renamed from: b, reason: collision with root package name */
    public final e f177b;
    public final n c;

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public o(Context context, AttributeSet attrs, int defStyleAttr) {
        super(u0.b(context), attrs, defStyleAttr);
        s0.a(this, getContext());
        e eVar = new e(this);
        this.f177b = eVar;
        eVar.e(attrs, defStyleAttr);
        n nVar = new n(this);
        this.c = nVar;
        nVar.f(attrs, defStyleAttr);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int resId) {
        n nVar = this.c;
        if (nVar != null) {
            nVar.g(resId);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        n nVar = this.c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        n nVar = this.c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n nVar = this.c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        e eVar = this.f177b;
        if (eVar != null) {
            eVar.g(resId);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        e eVar = this.f177b;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintList(ColorStateList tint) {
        e eVar = this.f177b;
        if (eVar != null) {
            eVar.i(tint);
        }
    }

    @Override // a.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f177b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode tintMode) {
        e eVar = this.f177b;
        if (eVar != null) {
            eVar.j(tintMode);
        }
    }

    @Override // a.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f177b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // a.h.l.m
    public void setSupportImageTintList(ColorStateList tint) {
        n nVar = this.c;
        if (nVar != null) {
            nVar.h(tint);
        }
    }

    @Override // a.h.l.m
    public ColorStateList getSupportImageTintList() {
        n nVar = this.c;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    @Override // a.h.l.m
    public void setSupportImageTintMode(PorterDuff.Mode tintMode) {
        n nVar = this.c;
        if (nVar != null) {
            nVar.i(tintMode);
        }
    }

    @Override // a.h.l.m
    public PorterDuff.Mode getSupportImageTintMode() {
        n nVar = this.c;
        if (nVar != null) {
            return nVar.d();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f177b;
        if (eVar != null) {
            eVar.b();
        }
        n nVar = this.c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.c.e() && super.hasOverlappingRendering();
    }
}
