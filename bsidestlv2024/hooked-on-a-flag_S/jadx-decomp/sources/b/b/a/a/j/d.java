package b.b.a.a.j;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: classes.dex */
public interface d {
    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public float f1013a;

        /* renamed from: b, reason: collision with root package name */
        public float f1014b;
        public float c;

        public e() {
        }

        public e(float centerX, float centerY, float radius) {
            this.f1013a = centerX;
            this.f1014b = centerY;
            this.c = radius;
        }

        public void a(float centerX, float centerY, float radius) {
            this.f1013a = centerX;
            this.f1014b = centerY;
            this.c = radius;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Property<d, e> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<d, e> f1011a = new c("circularReveal");

        public c(String name) {
            super(e.class, name);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(d object) {
            return object.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d object, e value) {
            object.setRevealInfo(value);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: a, reason: collision with root package name */
        public static final TypeEvaluator<e> f1009a = new b();

        /* renamed from: b, reason: collision with root package name */
        public final e f1010b = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float fraction, e startValue, e endValue) {
            this.f1010b.a(b.b.a.a.s.a.c(startValue.f1013a, endValue.f1013a, fraction), b.b.a.a.s.a.c(startValue.f1014b, endValue.f1014b, fraction), b.b.a.a.s.a.c(startValue.c, endValue.c, fraction));
            return this.f1010b;
        }
    }

    /* renamed from: b.b.a.a.j.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0067d extends Property<d, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<d, Integer> f1012a = new C0067d("circularRevealScrimColor");

        public C0067d(String name) {
            super(Integer.class, name);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d object) {
            return Integer.valueOf(object.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d object, Integer value) {
            object.setCircularRevealScrimColor(value.intValue());
        }
    }
}
