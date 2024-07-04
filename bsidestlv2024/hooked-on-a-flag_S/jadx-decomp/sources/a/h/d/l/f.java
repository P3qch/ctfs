package a.h.d.l;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* loaded from: classes.dex */
public final class f extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f378a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable.ConstantState f379b;
    public ColorStateList c;
    public PorterDuff.Mode d;

    public f(f orig) {
        this.c = null;
        this.d = d.f377b;
        if (orig != null) {
            this.f378a = orig.f378a;
            this.f379b = orig.f379b;
            this.c = orig.c;
            this.d = orig.d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources res) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new e(this, res);
        }
        return new d(this, res);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.f378a;
        Drawable.ConstantState constantState = this.f379b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public boolean a() {
        return this.f379b != null;
    }
}
