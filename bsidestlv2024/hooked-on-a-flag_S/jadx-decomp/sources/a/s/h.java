package a.s;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
public class h<T> extends Property<T, Float> {

    /* renamed from: a, reason: collision with root package name */
    public final Property<T, PointF> f715a;

    /* renamed from: b, reason: collision with root package name */
    public final PathMeasure f716b;
    public final float c;
    public final float[] d;
    public final PointF e;
    public float f;

    /* JADX WARN: Generic types in debug info not equals: a.s.h != androidx.transition.PathProperty<T> */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object obj) {
        return a();
    }

    /* JADX WARN: Generic types in debug info not equals: a.s.h != androidx.transition.PathProperty<T> */
    public h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.d = new float[2];
        this.e = new PointF();
        this.f715a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f716b = pathMeasure;
        this.c = pathMeasure.getLength();
    }

    /* JADX WARN: Generic types in debug info not equals: a.s.h != androidx.transition.PathProperty<T> */
    public Float a() {
        return Float.valueOf(this.f);
    }

    /* JADX WARN: Generic types in debug info not equals: a.s.h != androidx.transition.PathProperty<T> */
    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(T target, Float fraction) {
        this.f = fraction.floatValue();
        this.f716b.getPosTan(this.c * fraction.floatValue(), this.d, null);
        PointF pointF = this.e;
        float[] fArr = this.d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f715a.set(target, pointF);
    }
}
