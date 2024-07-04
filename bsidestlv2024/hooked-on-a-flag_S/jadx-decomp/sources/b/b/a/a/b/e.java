package b.b.a.a.b;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class e extends Property<Drawable, Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final Property<Drawable, Integer> f981a = new e();

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap<Drawable, Integer> f982b;

    public e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f982b = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable object) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(object.getAlpha());
        }
        if (this.f982b.containsKey(object)) {
            return this.f982b.get(object);
        }
        return 255;
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Drawable object, Integer value) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f982b.put(object, value);
        }
        object.setAlpha(value.intValue());
    }
}
