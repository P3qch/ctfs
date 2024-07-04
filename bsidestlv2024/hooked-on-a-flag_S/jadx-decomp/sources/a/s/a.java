package a.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a.s.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0050a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    public static void a(Animator animator, AnimatorListenerAdapter listener) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(listener);
        }
    }

    public static void b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener listener = listeners.get(i);
                if (listener instanceof InterfaceC0050a) {
                    ((InterfaceC0050a) listener).onAnimationPause(animator);
                }
            }
        }
    }

    public static void c(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener listener = listeners.get(i);
                if (listener instanceof InterfaceC0050a) {
                    ((InterfaceC0050a) listener).onAnimationResume(animator);
                }
            }
        }
    }
}
