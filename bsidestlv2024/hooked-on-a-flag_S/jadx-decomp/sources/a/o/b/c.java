package a.o.b;

import a.h.k.v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c extends m {
    public static TimeInterpolator h;
    public ArrayList<RecyclerView.c0> i = new ArrayList<>();
    public ArrayList<RecyclerView.c0> j = new ArrayList<>();
    public ArrayList<j> k = new ArrayList<>();
    public ArrayList<i> l = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.c0>> m = new ArrayList<>();
    public ArrayList<ArrayList<j>> n = new ArrayList<>();
    public ArrayList<ArrayList<i>> o = new ArrayList<>();
    public ArrayList<RecyclerView.c0> p = new ArrayList<>();
    public ArrayList<RecyclerView.c0> q = new ArrayList<>();
    public ArrayList<RecyclerView.c0> r = new ArrayList<>();
    public ArrayList<RecyclerView.c0> s = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.c0 f659a;

        /* renamed from: b, reason: collision with root package name */
        public int f660b;
        public int c;
        public int d;
        public int e;

        public j(RecyclerView.c0 holder, int fromX, int fromY, int toX, int toY) {
            this.f659a = holder;
            this.f660b = fromX;
            this.c = fromY;
            this.d = toX;
            this.e = toY;
        }
    }

    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.c0 f657a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.c0 f658b;
        public int c;
        public int d;
        public int e;
        public int f;

        public i(RecyclerView.c0 oldHolder, RecyclerView.c0 newHolder) {
            this.f657a = oldHolder;
            this.f658b = newHolder;
        }

        public i(RecyclerView.c0 oldHolder, RecyclerView.c0 newHolder, int fromX, int fromY, int toX, int toY) {
            this(oldHolder, newHolder);
            this.c = fromX;
            this.d = fromY;
            this.e = toX;
            this.f = toY;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f657a + ", newHolder=" + this.f658b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void u() {
        boolean removalsPending = !this.i.isEmpty();
        boolean movesPending = !this.k.isEmpty();
        boolean changesPending = !this.l.isEmpty();
        boolean additionsPending = !this.j.isEmpty();
        if (!removalsPending && !movesPending && !additionsPending && !changesPending) {
            return;
        }
        Iterator<RecyclerView.c0> it = this.i.iterator();
        while (it.hasNext()) {
            RecyclerView.c0 holder = it.next();
            T(holder);
        }
        this.i.clear();
        if (movesPending) {
            ArrayList<j> arrayList = new ArrayList<>();
            arrayList.addAll(this.k);
            this.n.add(arrayList);
            this.k.clear();
            Runnable mover = new a(arrayList);
            if (removalsPending) {
                View view = arrayList.get(0).f659a.f889b;
                v.h0(view, mover, o());
            } else {
                mover.run();
            }
        }
        if (changesPending) {
            ArrayList<i> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.l);
            this.o.add(arrayList2);
            this.l.clear();
            Runnable changer = new b(arrayList2);
            if (removalsPending) {
                RecyclerView.c0 holder2 = arrayList2.get(0).f657a;
                v.h0(holder2.f889b, changer, o());
            } else {
                changer.run();
            }
        }
        if (additionsPending) {
            ArrayList<RecyclerView.c0> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.j);
            this.m.add(arrayList3);
            this.j.clear();
            Runnable adder = new RunnableC0048c(arrayList3);
            if (removalsPending || movesPending || changesPending) {
                long removeDuration = removalsPending ? o() : 0L;
                long moveDuration = movesPending ? n() : 0L;
                long changeDuration = changesPending ? m() : 0L;
                long totalDelay = Math.max(moveDuration, changeDuration) + removeDuration;
                View view2 = arrayList3.get(0).f889b;
                v.h0(view2, adder, totalDelay);
                return;
            }
            adder.run();
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f644b;

        public a(ArrayList arrayList) {
            this.f644b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f644b.iterator();
            while (it.hasNext()) {
                j moveInfo = (j) it.next();
                c.this.S(moveInfo.f659a, moveInfo.f660b, moveInfo.c, moveInfo.d, moveInfo.e);
            }
            this.f644b.clear();
            c.this.n.remove(this.f644b);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f645b;

        public b(ArrayList arrayList) {
            this.f645b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f645b.iterator();
            while (it.hasNext()) {
                i change = (i) it.next();
                c.this.R(change);
            }
            this.f645b.clear();
            c.this.o.remove(this.f645b);
        }
    }

    /* renamed from: a.o.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0048c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f646b;

        public RunnableC0048c(ArrayList arrayList) {
            this.f646b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f646b.iterator();
            while (it.hasNext()) {
                RecyclerView.c0 holder = (RecyclerView.c0) it.next();
                c.this.Q(holder);
            }
            this.f646b.clear();
            c.this.m.remove(this.f646b);
        }
    }

    @Override // a.o.b.m
    public boolean z(RecyclerView.c0 holder) {
        Z(holder);
        this.i.add(holder);
        return true;
    }

    public final void T(RecyclerView.c0 holder) {
        View view = holder.f889b;
        ViewPropertyAnimator animation = view.animate();
        this.r.add(holder);
        animation.setDuration(o()).alpha(0.0f).setListener(new d(holder, animation, view)).start();
    }

    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.c0 f647a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f648b;
        public final /* synthetic */ View c;

        public d(RecyclerView.c0 c0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f647a = c0Var;
            this.f648b = viewPropertyAnimator;
            this.c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.H(this.f647a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f648b.setListener(null);
            this.c.setAlpha(1.0f);
            c.this.G(this.f647a);
            c.this.r.remove(this.f647a);
            c.this.V();
        }
    }

    @Override // a.o.b.m
    public boolean w(RecyclerView.c0 holder) {
        Z(holder);
        holder.f889b.setAlpha(0.0f);
        this.j.add(holder);
        return true;
    }

    public void Q(RecyclerView.c0 holder) {
        View view = holder.f889b;
        ViewPropertyAnimator animation = view.animate();
        this.p.add(holder);
        animation.alpha(1.0f).setDuration(l()).setListener(new e(holder, view, animation)).start();
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.c0 f649a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f650b;
        public final /* synthetic */ ViewPropertyAnimator c;

        public e(RecyclerView.c0 c0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f649a = c0Var;
            this.f650b = view;
            this.c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.B(this.f649a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f650b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.c.setListener(null);
            c.this.A(this.f649a);
            c.this.p.remove(this.f649a);
            c.this.V();
        }
    }

    @Override // a.o.b.m
    public boolean y(RecyclerView.c0 holder, int fromX, int fromY, int toX, int toY) {
        View view = holder.f889b;
        int fromX2 = fromX + ((int) holder.f889b.getTranslationX());
        int fromY2 = fromY + ((int) holder.f889b.getTranslationY());
        Z(holder);
        int deltaX = toX - fromX2;
        int deltaY = toY - fromY2;
        if (deltaX == 0 && deltaY == 0) {
            E(holder);
            return false;
        }
        if (deltaX != 0) {
            view.setTranslationX(-deltaX);
        }
        if (deltaY != 0) {
            view.setTranslationY(-deltaY);
        }
        this.k.add(new j(holder, fromX2, fromY2, toX, toY));
        return true;
    }

    public void S(RecyclerView.c0 holder, int fromX, int fromY, int toX, int toY) {
        View view = holder.f889b;
        int deltaX = toX - fromX;
        int deltaY = toY - fromY;
        if (deltaX != 0) {
            view.animate().translationX(0.0f);
        }
        if (deltaY != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animation = view.animate();
        this.q.add(holder);
        animation.setDuration(n()).setListener(new f(holder, deltaX, view, deltaY, animation)).start();
    }

    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.c0 f651a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f652b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ViewPropertyAnimator e;

        public f(RecyclerView.c0 c0Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.f651a = c0Var;
            this.f652b = i;
            this.c = view;
            this.d = i2;
            this.e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.F(this.f651a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f652b != 0) {
                this.c.setTranslationX(0.0f);
            }
            if (this.d != 0) {
                this.c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.e.setListener(null);
            c.this.E(this.f651a);
            c.this.q.remove(this.f651a);
            c.this.V();
        }
    }

    @Override // a.o.b.m
    public boolean x(RecyclerView.c0 oldHolder, RecyclerView.c0 newHolder, int fromX, int fromY, int toX, int toY) {
        if (oldHolder == newHolder) {
            return y(oldHolder, fromX, fromY, toX, toY);
        }
        float prevTranslationX = oldHolder.f889b.getTranslationX();
        float prevTranslationY = oldHolder.f889b.getTranslationY();
        float prevAlpha = oldHolder.f889b.getAlpha();
        Z(oldHolder);
        int deltaX = (int) ((toX - fromX) - prevTranslationX);
        int deltaY = (int) ((toY - fromY) - prevTranslationY);
        oldHolder.f889b.setTranslationX(prevTranslationX);
        oldHolder.f889b.setTranslationY(prevTranslationY);
        oldHolder.f889b.setAlpha(prevAlpha);
        if (newHolder != null) {
            Z(newHolder);
            newHolder.f889b.setTranslationX(-deltaX);
            newHolder.f889b.setTranslationY(-deltaY);
            newHolder.f889b.setAlpha(0.0f);
        }
        this.l.add(new i(oldHolder, newHolder, fromX, fromY, toX, toY));
        return true;
    }

    public void R(i changeInfo) {
        RecyclerView.c0 holder = changeInfo.f657a;
        View view = holder == null ? null : holder.f889b;
        RecyclerView.c0 newHolder = changeInfo.f658b;
        View newView = newHolder != null ? newHolder.f889b : null;
        if (view != null) {
            ViewPropertyAnimator oldViewAnim = view.animate().setDuration(m());
            this.s.add(changeInfo.f657a);
            oldViewAnim.translationX(changeInfo.e - changeInfo.c);
            oldViewAnim.translationY(changeInfo.f - changeInfo.d);
            oldViewAnim.alpha(0.0f).setListener(new g(changeInfo, oldViewAnim, view)).start();
        }
        if (newView != null) {
            ViewPropertyAnimator newViewAnimation = newView.animate();
            this.s.add(changeInfo.f658b);
            newViewAnimation.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(changeInfo, newViewAnimation, newView)).start();
        }
    }

    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f653a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f654b;
        public final /* synthetic */ View c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f653a = iVar;
            this.f654b = viewPropertyAnimator;
            this.c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f653a.f657a, true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f654b.setListener(null);
            this.c.setAlpha(1.0f);
            this.c.setTranslationX(0.0f);
            this.c.setTranslationY(0.0f);
            c.this.C(this.f653a.f657a, true);
            c.this.s.remove(this.f653a.f657a);
            c.this.V();
        }
    }

    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f655a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f656b;
        public final /* synthetic */ View c;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f655a = iVar;
            this.f656b = viewPropertyAnimator;
            this.c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f655a.f658b, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f656b.setListener(null);
            this.c.setAlpha(1.0f);
            this.c.setTranslationX(0.0f);
            this.c.setTranslationY(0.0f);
            c.this.C(this.f655a.f658b, false);
            c.this.s.remove(this.f655a.f658b);
            c.this.V();
        }
    }

    public final void W(List<i> list, RecyclerView.c0 item) {
        for (int i2 = list.size() - 1; i2 >= 0; i2--) {
            i changeInfo = list.get(i2);
            if (Y(changeInfo, item) && changeInfo.f657a == null && changeInfo.f658b == null) {
                list.remove(changeInfo);
            }
        }
    }

    public final void X(i changeInfo) {
        RecyclerView.c0 c0Var = changeInfo.f657a;
        if (c0Var != null) {
            Y(changeInfo, c0Var);
        }
        RecyclerView.c0 c0Var2 = changeInfo.f658b;
        if (c0Var2 != null) {
            Y(changeInfo, c0Var2);
        }
    }

    public final boolean Y(i changeInfo, RecyclerView.c0 item) {
        boolean oldItem = false;
        if (changeInfo.f658b == item) {
            changeInfo.f658b = null;
        } else if (changeInfo.f657a == item) {
            changeInfo.f657a = null;
            oldItem = true;
        } else {
            return false;
        }
        item.f889b.setAlpha(1.0f);
        item.f889b.setTranslationX(0.0f);
        item.f889b.setTranslationY(0.0f);
        C(item, oldItem);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.c0 item) {
        View view = item.f889b;
        view.animate().cancel();
        int i2 = this.k.size();
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            j moveInfo = this.k.get(i2);
            if (moveInfo.f659a == item) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(item);
                this.k.remove(i2);
            }
        }
        W(this.l, item);
        if (this.i.remove(item)) {
            view.setAlpha(1.0f);
            G(item);
        }
        if (this.j.remove(item)) {
            view.setAlpha(1.0f);
            A(item);
        }
        for (int i3 = this.o.size() - 1; i3 >= 0; i3--) {
            ArrayList<i> arrayList = this.o.get(i3);
            W(arrayList, item);
            if (arrayList.isEmpty()) {
                this.o.remove(i3);
            }
        }
        for (int i4 = this.n.size() - 1; i4 >= 0; i4--) {
            ArrayList<j> arrayList2 = this.n.get(i4);
            int j2 = arrayList2.size() - 1;
            while (true) {
                if (j2 >= 0) {
                    j moveInfo2 = arrayList2.get(j2);
                    if (moveInfo2.f659a != item) {
                        j2--;
                    } else {
                        view.setTranslationY(0.0f);
                        view.setTranslationX(0.0f);
                        E(item);
                        arrayList2.remove(j2);
                        if (arrayList2.isEmpty()) {
                            this.n.remove(i4);
                        }
                    }
                }
            }
        }
        for (int i5 = this.m.size() - 1; i5 >= 0; i5--) {
            ArrayList<RecyclerView.c0> arrayList3 = this.m.get(i5);
            if (arrayList3.remove(item)) {
                view.setAlpha(1.0f);
                A(item);
                if (arrayList3.isEmpty()) {
                    this.m.remove(i5);
                }
            }
        }
        this.r.remove(item);
        this.p.remove(item);
        this.s.remove(item);
        this.q.remove(item);
        V();
    }

    public final void Z(RecyclerView.c0 holder) {
        if (h == null) {
            h = new ValueAnimator().getInterpolator();
        }
        holder.f889b.animate().setInterpolator(h);
        j(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.j.isEmpty() && this.l.isEmpty() && this.k.isEmpty() && this.i.isEmpty() && this.q.isEmpty() && this.r.isEmpty() && this.p.isEmpty() && this.s.isEmpty() && this.n.isEmpty() && this.m.isEmpty() && this.o.isEmpty()) ? false : true;
    }

    public void V() {
        if (!p()) {
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int count = this.k.size();
        for (int i2 = count - 1; i2 >= 0; i2--) {
            j item = this.k.get(i2);
            View view = item.f659a.f889b;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(item.f659a);
            this.k.remove(i2);
        }
        int count2 = this.i.size();
        for (int i3 = count2 - 1; i3 >= 0; i3--) {
            G(this.i.get(i3));
            this.i.remove(i3);
        }
        int count3 = this.j.size();
        for (int i4 = count3 - 1; i4 >= 0; i4--) {
            RecyclerView.c0 item2 = this.j.get(i4);
            item2.f889b.setAlpha(1.0f);
            A(item2);
            this.j.remove(i4);
        }
        int count4 = this.l.size();
        for (int i5 = count4 - 1; i5 >= 0; i5--) {
            X(this.l.get(i5));
        }
        this.l.clear();
        if (!p()) {
            return;
        }
        int listCount = this.n.size();
        for (int i6 = listCount - 1; i6 >= 0; i6--) {
            ArrayList<j> arrayList = this.n.get(i6);
            int count5 = arrayList.size();
            for (int j2 = count5 - 1; j2 >= 0; j2--) {
                j moveInfo = arrayList.get(j2);
                View view2 = moveInfo.f659a.f889b;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                E(moveInfo.f659a);
                arrayList.remove(j2);
                if (arrayList.isEmpty()) {
                    this.n.remove(arrayList);
                }
            }
        }
        int listCount2 = this.m.size();
        for (int i7 = listCount2 - 1; i7 >= 0; i7--) {
            ArrayList<RecyclerView.c0> arrayList2 = this.m.get(i7);
            int count6 = arrayList2.size();
            for (int j3 = count6 - 1; j3 >= 0; j3--) {
                RecyclerView.c0 item3 = arrayList2.get(j3);
                item3.f889b.setAlpha(1.0f);
                A(item3);
                arrayList2.remove(j3);
                if (arrayList2.isEmpty()) {
                    this.m.remove(arrayList2);
                }
            }
        }
        int listCount3 = this.o.size();
        for (int i8 = listCount3 - 1; i8 >= 0; i8--) {
            ArrayList<i> arrayList3 = this.o.get(i8);
            int count7 = arrayList3.size();
            for (int j4 = count7 - 1; j4 >= 0; j4--) {
                X(arrayList3.get(j4));
                if (arrayList3.isEmpty()) {
                    this.o.remove(arrayList3);
                }
            }
        }
        U(this.r);
        U(this.q);
        U(this.p);
        U(this.s);
        i();
    }

    public void U(List<RecyclerView.c0> list) {
        for (int i2 = list.size() - 1; i2 >= 0; i2--) {
            list.get(i2).f889b.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.c0 viewHolder, List<Object> payloads) {
        return !payloads.isEmpty() || super.g(viewHolder, payloads);
    }
}
