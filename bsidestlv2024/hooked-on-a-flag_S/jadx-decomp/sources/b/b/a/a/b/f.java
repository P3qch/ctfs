package b.b.a.a.b;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class f extends Property<ImageView, Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f983a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f983a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ImageView object, Matrix value) {
        object.setImageMatrix(value);
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView object) {
        this.f983a.set(object.getImageMatrix());
        return this.f983a;
    }
}
