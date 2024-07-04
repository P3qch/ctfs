package b.b.a.a.q;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b extends a {
    public b(FloatingActionButton view, b.b.a.a.w.b shadowViewDelegate) {
        super(view, shadowViewDelegate);
    }

    @Override // b.b.a.a.q.a
    public void R(ColorStateList rippleColor) {
        super.R(rippleColor);
    }

    @Override // b.b.a.a.q.a
    public void D(float elevation, float hoveredFocusedTranslationZ, float pressedTranslationZ) {
        int i = Build.VERSION.SDK_INT;
        if (i == 21) {
            this.z.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(a.f1050b, e0(elevation, pressedTranslationZ));
            stateListAnimator.addState(a.c, e0(elevation, hoveredFocusedTranslationZ));
            stateListAnimator.addState(a.d, e0(elevation, hoveredFocusedTranslationZ));
            stateListAnimator.addState(a.e, e0(elevation, hoveredFocusedTranslationZ));
            AnimatorSet set = new AnimatorSet();
            List<Animator> animators = new ArrayList<>();
            animators.add(ObjectAnimator.ofFloat(this.z, "elevation", elevation).setDuration(0L));
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.z;
                animators.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            animators.add(ObjectAnimator.ofFloat(this.z, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            set.playSequentially((Animator[]) animators.toArray(new Animator[0]));
            set.setInterpolator(a.f1049a);
            stateListAnimator.addState(a.f, set);
            stateListAnimator.addState(a.g, e0(0.0f, 0.0f));
            this.z.setStateListAnimator(stateListAnimator);
        }
        if (V()) {
            b0();
            throw null;
        }
    }

    public final Animator e0(float elevation, float translationZ) {
        AnimatorSet set = new AnimatorSet();
        set.play(ObjectAnimator.ofFloat(this.z, "elevation", elevation).setDuration(0L)).with(ObjectAnimator.ofFloat(this.z, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, translationZ).setDuration(100L));
        set.setInterpolator(a.f1049a);
        return set;
    }

    @Override // b.b.a.a.q.a
    public float m() {
        return this.z.getElevation();
    }

    @Override // b.b.a.a.q.a
    public void A() {
        b0();
        throw null;
    }

    @Override // b.b.a.a.q.a
    public boolean V() {
        return ((FloatingActionButton.c) this.A).a() || !X();
    }

    @Override // b.b.a.a.q.a
    public void C(int[] state) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.z.isEnabled()) {
                this.z.setElevation(this.k);
                if (this.z.isPressed()) {
                    this.z.setTranslationZ(this.m);
                    return;
                } else if (this.z.isFocused() || this.z.isHovered()) {
                    this.z.setTranslationZ(this.l);
                    return;
                } else {
                    this.z.setTranslationZ(0.0f);
                    return;
                }
            }
            this.z.setElevation(0.0f);
            this.z.setTranslationZ(0.0f);
        }
    }

    @Override // b.b.a.a.q.a
    public void y() {
    }

    @Override // b.b.a.a.q.a
    public void Z() {
    }

    @Override // b.b.a.a.q.a
    public boolean I() {
        return false;
    }

    @Override // b.b.a.a.q.a
    public void r(Rect rect) {
        if (((FloatingActionButton.c) this.A).a()) {
            super.r(rect);
        } else if (!X()) {
            int minPadding = (0 - this.z.getSizeDimension()) / 2;
            rect.set(minPadding, minPadding, minPadding, minPadding);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }
}
