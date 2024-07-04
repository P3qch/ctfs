package b.b.a.a.b;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final a.e.g<String, i> f986a = new a.e.g<>();

    /* renamed from: b, reason: collision with root package name */
    public final a.e.g<String, PropertyValuesHolder[]> f987b = new a.e.g<>();

    public boolean g(String name) {
        return this.f986a.get(name) != null;
    }

    public i e(String name) {
        if (!g(name)) {
            throw new IllegalArgumentException();
        }
        return this.f986a.get(name);
    }

    public void i(String name, i timing) {
        this.f986a.put(name, timing);
    }

    public void h(String name, PropertyValuesHolder[] values) {
        this.f987b.put(name, values);
    }

    public long f() {
        long duration = 0;
        int count = this.f986a.size();
        for (int i = 0; i < count; i++) {
            i timing = this.f986a.m(i);
            duration = Math.max(duration, timing.c() + timing.d());
        }
        return duration;
    }

    public static h b(Context context, TypedArray attributes, int index) {
        int resourceId;
        if (attributes.hasValue(index) && (resourceId = attributes.getResourceId(index, 0)) != 0) {
            return c(context, resourceId);
        }
        return null;
    }

    public static h c(Context context, int id) {
        try {
            Animator animator = AnimatorInflater.loadAnimator(context, id);
            if (animator instanceof AnimatorSet) {
                AnimatorSet set = (AnimatorSet) animator;
                return d(set.getChildAnimations());
            }
            if (animator == null) {
                return null;
            }
            List<Animator> animators = new ArrayList<>();
            animators.add(animator);
            return d(animators);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(id), e);
            return null;
        }
    }

    public static h d(List<Animator> animators) {
        h spec = new h();
        int count = animators.size();
        for (int i = 0; i < count; i++) {
            a(spec, animators.get(i));
        }
        return spec;
    }

    public static void a(h spec, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator anim = (ObjectAnimator) animator;
            spec.h(anim.getPropertyName(), anim.getValues());
            spec.i(anim.getPropertyName(), i.b(anim));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof h)) {
            return false;
        }
        h that = (h) o;
        return this.f986a.equals(that.f986a);
    }

    public int hashCode() {
        return this.f986a.hashCode();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f986a + "}\n";
    }
}
