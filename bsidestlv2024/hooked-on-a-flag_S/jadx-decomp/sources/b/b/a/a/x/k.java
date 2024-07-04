package b.b.a.a.x;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import b.b.a.a.x.g;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public d f1108a;

    /* renamed from: b, reason: collision with root package name */
    public d f1109b;
    public d c;
    public d d;
    public b.b.a.a.x.c e;
    public b.b.a.a.x.c f;
    public b.b.a.a.x.c g;
    public b.b.a.a.x.c h;
    public f i;
    public f j;
    public f k;
    public f l;

    /* loaded from: classes.dex */
    public interface c {
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public d f1110a;

        /* renamed from: b, reason: collision with root package name */
        public d f1111b;
        public d c;
        public d d;
        public b.b.a.a.x.c e;
        public b.b.a.a.x.c f;
        public b.b.a.a.x.c g;
        public b.b.a.a.x.c h;
        public f i;
        public f j;
        public f k;
        public f l;

        public b() {
            this.f1110a = h.b();
            this.f1111b = h.b();
            this.c = h.b();
            this.d = h.b();
            this.e = new b.b.a.a.x.a(0.0f);
            this.f = new b.b.a.a.x.a(0.0f);
            this.g = new b.b.a.a.x.a(0.0f);
            this.h = new b.b.a.a.x.a(0.0f);
            this.i = h.c();
            this.j = h.c();
            this.k = h.c();
            this.l = h.c();
        }

        public b(k other) {
            this.f1110a = h.b();
            this.f1111b = h.b();
            this.c = h.b();
            this.d = h.b();
            this.e = new b.b.a.a.x.a(0.0f);
            this.f = new b.b.a.a.x.a(0.0f);
            this.g = new b.b.a.a.x.a(0.0f);
            this.h = new b.b.a.a.x.a(0.0f);
            this.i = h.c();
            this.j = h.c();
            this.k = h.c();
            this.l = h.c();
            this.f1110a = other.f1108a;
            this.f1111b = other.f1109b;
            this.c = other.c;
            this.d = other.d;
            this.e = other.e;
            this.f = other.f;
            this.g = other.g;
            this.h = other.h;
            this.i = other.i;
            this.j = other.j;
            this.k = other.k;
            this.l = other.l;
        }

        public b p(b.b.a.a.x.c cornerSize) {
            B(cornerSize);
            F(cornerSize);
            x(cornerSize);
            t(cornerSize);
            return this;
        }

        public b o(float cornerSize) {
            A(cornerSize);
            E(cornerSize);
            w(cornerSize);
            s(cornerSize);
            return this;
        }

        public b A(float cornerSize) {
            this.e = new b.b.a.a.x.a(cornerSize);
            return this;
        }

        public b B(b.b.a.a.x.c cornerSize) {
            this.e = cornerSize;
            return this;
        }

        public b E(float cornerSize) {
            this.f = new b.b.a.a.x.a(cornerSize);
            return this;
        }

        public b F(b.b.a.a.x.c cornerSize) {
            this.f = cornerSize;
            return this;
        }

        public b w(float cornerSize) {
            this.g = new b.b.a.a.x.a(cornerSize);
            return this;
        }

        public b x(b.b.a.a.x.c cornerSize) {
            this.g = cornerSize;
            return this;
        }

        public b s(float cornerSize) {
            this.h = new b.b.a.a.x.a(cornerSize);
            return this;
        }

        public b t(b.b.a.a.x.c cornerSize) {
            this.h = cornerSize;
            return this;
        }

        public b y(int cornerFamily, b.b.a.a.x.c cornerSize) {
            z(h.a(cornerFamily));
            B(cornerSize);
            return this;
        }

        public b z(d topLeftCorner) {
            this.f1110a = topLeftCorner;
            float size = n(topLeftCorner);
            if (size != -1.0f) {
                A(size);
            }
            return this;
        }

        public b C(int cornerFamily, b.b.a.a.x.c cornerSize) {
            D(h.a(cornerFamily));
            F(cornerSize);
            return this;
        }

        public b D(d topRightCorner) {
            this.f1111b = topRightCorner;
            float size = n(topRightCorner);
            if (size != -1.0f) {
                E(size);
            }
            return this;
        }

        public b u(int cornerFamily, b.b.a.a.x.c cornerSize) {
            v(h.a(cornerFamily));
            x(cornerSize);
            return this;
        }

        public b v(d bottomRightCorner) {
            this.c = bottomRightCorner;
            float size = n(bottomRightCorner);
            if (size != -1.0f) {
                w(size);
            }
            return this;
        }

        public b q(int cornerFamily, b.b.a.a.x.c cornerSize) {
            r(h.a(cornerFamily));
            t(cornerSize);
            return this;
        }

        public b r(d bottomLeftCorner) {
            this.d = bottomLeftCorner;
            float size = n(bottomLeftCorner);
            if (size != -1.0f) {
                s(size);
            }
            return this;
        }

        public static float n(d treatment) {
            if (treatment instanceof j) {
                return ((j) treatment).f1107a;
            }
            if (treatment instanceof e) {
                return ((e) treatment).f1100a;
            }
            return -1.0f;
        }

        public k m() {
            return new k(this);
        }
    }

    public static b a() {
        return new b();
    }

    public static b e(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        return f(context, attrs, defStyleAttr, defStyleRes, 0);
    }

    public static b f(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, int defaultCornerSize) {
        return g(context, attrs, defStyleAttr, defStyleRes, new b.b.a.a.x.a(defaultCornerSize));
    }

    public static b g(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, b.b.a.a.x.c defaultCornerSize) {
        TypedArray a2 = context.obtainStyledAttributes(attrs, b.b.a.a.a.r, defStyleAttr, defStyleRes);
        int[] iArr = b.b.a.a.a.f942a;
        int shapeAppearanceResId = a2.getResourceId(0, 0);
        int shapeAppearanceOverlayResId = a2.getResourceId(1, 0);
        a2.recycle();
        return d(context, shapeAppearanceResId, shapeAppearanceOverlayResId, defaultCornerSize);
    }

    public static b b(Context context, int shapeAppearanceResId, int shapeAppearanceOverlayResId) {
        return c(context, shapeAppearanceResId, shapeAppearanceOverlayResId, 0);
    }

    public static b c(Context context, int shapeAppearanceResId, int shapeAppearanceOverlayResId, int defaultCornerSize) {
        return d(context, shapeAppearanceResId, shapeAppearanceOverlayResId, new b.b.a.a.x.a(defaultCornerSize));
    }

    public static b d(Context context, int shapeAppearanceResId, int shapeAppearanceOverlayResId, b.b.a.a.x.c defaultCornerSize) {
        if (shapeAppearanceOverlayResId != 0) {
            context = new ContextThemeWrapper(context, shapeAppearanceResId);
            shapeAppearanceResId = shapeAppearanceOverlayResId;
        }
        TypedArray a2 = context.obtainStyledAttributes(shapeAppearanceResId, b.b.a.a.a.x);
        try {
            int[] iArr = b.b.a.a.a.f942a;
            int cornerFamily = a2.getInt(0, 0);
            int cornerFamilyTopLeft = a2.getInt(3, cornerFamily);
            int cornerFamilyTopRight = a2.getInt(4, cornerFamily);
            int cornerFamilyBottomRight = a2.getInt(2, cornerFamily);
            int cornerFamilyBottomLeft = a2.getInt(1, cornerFamily);
            b.b.a.a.x.c cornerSize = m(a2, 5, defaultCornerSize);
            b.b.a.a.x.c cornerSizeTopLeft = m(a2, 8, cornerSize);
            b.b.a.a.x.c cornerSizeTopRight = m(a2, 9, cornerSize);
            b.b.a.a.x.c cornerSizeBottomRight = m(a2, 7, cornerSize);
            b.b.a.a.x.c cornerSizeBottomLeft = m(a2, 6, cornerSize);
            b bVar = new b();
            bVar.y(cornerFamilyTopLeft, cornerSizeTopLeft);
            bVar.C(cornerFamilyTopRight, cornerSizeTopRight);
            bVar.u(cornerFamilyBottomRight, cornerSizeBottomRight);
            bVar.q(cornerFamilyBottomLeft, cornerSizeBottomLeft);
            return bVar;
        } finally {
            a2.recycle();
        }
    }

    public static b.b.a.a.x.c m(TypedArray a2, int index, b.b.a.a.x.c defaultValue) {
        TypedValue value = a2.peekValue(index);
        if (value == null) {
            return defaultValue;
        }
        int i = value.type;
        if (i == 5) {
            return new b.b.a.a.x.a(TypedValue.complexToDimensionPixelSize(value.data, a2.getResources().getDisplayMetrics()));
        }
        if (i == 6) {
            return new i(value.getFraction(1.0f, 1.0f));
        }
        return defaultValue;
    }

    static {
        new i(0.5f);
    }

    public k(b builder) {
        this.f1108a = builder.f1110a;
        this.f1109b = builder.f1111b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
    }

    public k() {
        this.f1108a = h.b();
        this.f1109b = h.b();
        this.c = h.b();
        this.d = h.b();
        this.e = new b.b.a.a.x.a(0.0f);
        this.f = new b.b.a.a.x.a(0.0f);
        this.g = new b.b.a.a.x.a(0.0f);
        this.h = new b.b.a.a.x.a(0.0f);
        this.i = h.c();
        this.j = h.c();
        this.k = h.c();
        this.l = h.c();
    }

    public d q() {
        return this.f1108a;
    }

    public d s() {
        return this.f1109b;
    }

    public d k() {
        return this.c;
    }

    public d i() {
        return this.d;
    }

    public b.b.a.a.x.c r() {
        return this.e;
    }

    public b.b.a.a.x.c t() {
        return this.f;
    }

    public b.b.a.a.x.c l() {
        return this.g;
    }

    public b.b.a.a.x.c j() {
        return this.h;
    }

    public f n() {
        return this.l;
    }

    public f p() {
        return this.i;
    }

    public f o() {
        return this.j;
    }

    public f h() {
        return this.k;
    }

    public b v() {
        return new b(this);
    }

    public k w(float cornerSize) {
        b v = v();
        v.o(cornerSize);
        return v.m();
    }

    public k x(b.b.a.a.x.c cornerSize) {
        b v = v();
        v.p(cornerSize);
        return v.m();
    }

    public k y(c op) {
        b v = v();
        v.B(((g.b) op).a(r()));
        v.F(((g.b) op).a(t()));
        v.t(((g.b) op).a(j()));
        v.x(((g.b) op).a(l()));
        return v.m();
    }

    public boolean u(RectF bounds) {
        boolean hasDefaultEdges = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float cornerSize = this.e.a(bounds);
        boolean cornersHaveSameSize = this.f.a(bounds) == cornerSize && this.h.a(bounds) == cornerSize && this.g.a(bounds) == cornerSize;
        boolean hasRoundedCorners = (this.f1109b instanceof j) && (this.f1108a instanceof j) && (this.c instanceof j) && (this.d instanceof j);
        return hasDefaultEdges && cornersHaveSameSize && hasRoundedCorners;
    }
}
