package a.b.b;

import a.b.f.b;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class a {

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract void a();
    }

    public abstract boolean b();

    public abstract void c(boolean z);

    public abstract int d();

    public abstract Context e();

    public abstract void g(Configuration configuration);

    public abstract boolean i(int i, KeyEvent keyEvent);

    public abstract void l(boolean z);

    public abstract void m(boolean z);

    public abstract void n(CharSequence charSequence);

    public abstract a.b.f.b o(b.a aVar);

    public boolean k() {
        return false;
    }

    public boolean a() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean j() {
        return false;
    }

    public void h() {
    }

    /* renamed from: a.b.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0001a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f13a;

        public C0001a(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.f13a = 0;
            TypedArray a2 = c.obtainStyledAttributes(attrs, a.b.a.f12b);
            int[] iArr = a.b.a.f11a;
            this.f13a = a2.getInt(0, 0);
            a2.recycle();
        }

        public C0001a(int width, int height) {
            super(width, height);
            this.f13a = 0;
            this.f13a = 8388627;
        }

        public C0001a(C0001a source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.f13a = 0;
            this.f13a = source.f13a;
        }

        public C0001a(ViewGroup.LayoutParams source) {
            super(source);
            this.f13a = 0;
        }
    }
}
