package b.b.a.a.b;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public long f988a;

    /* renamed from: b, reason: collision with root package name */
    public long f989b;
    public TimeInterpolator c;
    public int d;
    public int e;

    public i(long delay, long duration) {
        this.f988a = 0L;
        this.f989b = 300L;
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.f988a = delay;
        this.f989b = duration;
    }

    public i(long delay, long duration, TimeInterpolator interpolator) {
        this.f988a = 0L;
        this.f989b = 300L;
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.f988a = delay;
        this.f989b = duration;
        this.c = interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ((ValueAnimator) animator).setRepeatCount(g());
            ((ValueAnimator) animator).setRepeatMode(h());
        }
    }

    public long c() {
        return this.f988a;
    }

    public long d() {
        return this.f989b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : a.f978b;
    }

    public int g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public static i b(ValueAnimator animator) {
        i timing = new i(animator.getStartDelay(), animator.getDuration(), f(animator));
        timing.d = animator.getRepeatCount();
        timing.e = animator.getRepeatMode();
        return timing;
    }

    public static TimeInterpolator f(ValueAnimator animator) {
        TimeInterpolator interpolator = animator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f978b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.c;
        }
        if (interpolator instanceof DecelerateInterpolator) {
            return a.d;
        }
        return interpolator;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof i)) {
            return false;
        }
        i that = (i) o;
        if (c() == that.c() && d() == that.d() && g() == that.g() && h() == that.h()) {
            return e().getClass().equals(that.e().getClass());
        }
        return false;
    }

    public int hashCode() {
        int result = (int) (c() ^ (c() >>> 32));
        return (((((((result * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
