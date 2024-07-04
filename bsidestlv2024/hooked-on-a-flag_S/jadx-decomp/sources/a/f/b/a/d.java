package a.f.b.a;

import a.f.b.a.e;
import a.h.k.n;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class d extends ConstraintLayout implements n {
    public static final /* synthetic */ int v = 0;
    public int A;
    public boolean B;
    public long C;
    public float D;
    public float E;
    public float F;
    public long G;
    public float H;
    public boolean I;
    public boolean J;
    public c K;
    public int L;
    public boolean M;
    public a.f.b.a.b N;
    public boolean O;
    public float P;
    public float Q;
    public long R;
    public float S;
    public boolean T;
    public ArrayList<a.f.b.a.c> U;
    public ArrayList<a.f.b.a.c> V;
    public CopyOnWriteArrayList<c> W;
    public int a0;
    public float b0;
    public float c0;
    public boolean d0;
    public b e0;
    public Runnable f0;
    public boolean g0;
    public EnumC0013d h0;
    public boolean i0;
    public Interpolator w;
    public float x;
    public int y;
    public int z;

    /* loaded from: classes.dex */
    public interface c {
        void a(d dVar, int i, int i2);

        void b(d dVar, int i, int i2, float f);
    }

    /* renamed from: a.f.b.a.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0013d {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public void setState(EnumC0013d newState) {
        EnumC0013d enumC0013d = EnumC0013d.FINISHED;
        if (newState == enumC0013d && this.z == -1) {
            return;
        }
        EnumC0013d oldState = this.h0;
        this.h0 = newState;
        EnumC0013d enumC0013d2 = EnumC0013d.MOVING;
        if (oldState == enumC0013d2 && newState == enumC0013d2) {
            G();
        }
        switch (oldState) {
            case UNDEFINED:
            case SETUP:
                if (newState == enumC0013d2) {
                    G();
                }
                if (newState == enumC0013d) {
                    H();
                    return;
                }
                return;
            case MOVING:
                if (newState == enumC0013d) {
                    H();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setStartState(int beginId) {
        if (!isAttachedToWindow()) {
            if (this.e0 == null) {
                this.e0 = new b();
            }
            this.e0.f(beginId);
            this.e0.d(beginId);
            return;
        }
        this.z = beginId;
    }

    public void M(int beginId, int endId) {
        if (!isAttachedToWindow()) {
            if (this.e0 == null) {
                this.e0 = new b();
            }
            this.e0.f(beginId);
            this.e0.d(endId);
        }
    }

    public void setTransition(int transitionId) {
    }

    public void setTransition(e.a transition) {
        e eVar = null;
        eVar.g(transition);
        throw null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        return getWindowToken() != null;
    }

    public void L(int id, int screenWidth, int screenHeight) {
        setState(EnumC0013d.SETUP);
        this.z = id;
        this.y = -1;
        this.A = -1;
        a.f.c.c cVar = this.m;
        if (cVar != null) {
            cVar.d(id, screenWidth, screenHeight);
        }
    }

    public void setInterpolatedProgress(float pos) {
        setProgress(pos);
    }

    public void K(float pos, float velocity) {
        if (!isAttachedToWindow()) {
            if (this.e0 == null) {
                this.e0 = new b();
            }
            this.e0.e(pos);
            this.e0.h(velocity);
            return;
        }
        setProgress(pos);
        setState(EnumC0013d.MOVING);
        this.x = velocity;
        E(1.0f);
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public float f300a = Float.NaN;

        /* renamed from: b, reason: collision with root package name */
        public float f301b = Float.NaN;
        public int c = -1;
        public int d = -1;

        public b() {
        }

        public void a() {
            int i = this.c;
            if (i != -1 || this.d != -1) {
                if (i == -1) {
                    d.this.O(this.d);
                } else {
                    int i2 = this.d;
                    if (i2 == -1) {
                        d.this.L(i, -1, -1);
                    } else {
                        d.this.M(i, i2);
                    }
                }
                d.this.setState(EnumC0013d.SETUP);
            }
            if (Float.isNaN(this.f301b)) {
                if (Float.isNaN(this.f300a)) {
                    return;
                }
                d.this.setProgress(this.f300a);
            } else {
                d.this.K(this.f300a, this.f301b);
                this.f300a = Float.NaN;
                this.f301b = Float.NaN;
                this.c = -1;
                this.d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f300a);
            bundle.putFloat("motion.velocity", this.f301b);
            bundle.putInt("motion.StartState", this.c);
            bundle.putInt("motion.EndState", this.d);
            return bundle;
        }

        public void g(Bundle bundle) {
            this.f300a = bundle.getFloat("motion.progress");
            this.f301b = bundle.getFloat("motion.velocity");
            this.c = bundle.getInt("motion.StartState");
            this.d = bundle.getInt("motion.EndState");
        }

        public void e(float progress) {
            this.f300a = progress;
        }

        public void d(int endState) {
            this.d = endState;
        }

        public void h(float mVelocity) {
            this.f301b = mVelocity;
        }

        public void f(int startState) {
            this.c = startState;
        }

        public void c() {
            this.d = d.this.A;
            this.c = d.this.y;
            this.f301b = d.this.getVelocity();
            this.f300a = d.this.getProgress();
        }
    }

    public void setTransitionState(Bundle bundle) {
        if (this.e0 == null) {
            this.e0 = new b();
        }
        this.e0.g(bundle);
        if (isAttachedToWindow()) {
            this.e0.a();
        }
    }

    public Bundle getTransitionState() {
        if (this.e0 == null) {
            this.e0 = new b();
        }
        this.e0.c();
        return this.e0.b();
    }

    public void setProgress(float pos) {
        if (pos < 0.0f || pos > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.e0 == null) {
                this.e0 = new b();
            }
            this.e0.e(pos);
            return;
        }
        if (pos <= 0.0f) {
            if (this.F == 1.0f && this.z == this.A) {
                setState(EnumC0013d.MOVING);
            }
            this.z = this.y;
            if (this.F == 0.0f) {
                setState(EnumC0013d.FINISHED);
                return;
            }
            return;
        }
        if (pos >= 1.0f) {
            if (this.F == 0.0f && this.z == this.y) {
                setState(EnumC0013d.MOVING);
            }
            this.z = this.A;
            if (this.F == 1.0f) {
                setState(EnumC0013d.FINISHED);
                return;
            }
            return;
        }
        this.z = -1;
        setState(EnumC0013d.MOVING);
    }

    public void E(float position) {
    }

    public void N() {
        E(1.0f);
        this.f0 = null;
    }

    public void O(int id) {
        if (!isAttachedToWindow()) {
            if (this.e0 == null) {
                this.e0 = new b();
            }
            this.e0.d(id);
            return;
        }
        P(id, -1, -1);
    }

    public void P(int id, int screenWidth, int screenHeight) {
        Q(id, screenWidth, screenHeight, -1);
    }

    public void Q(int id, int screenWidth, int screenHeight, int duration) {
        int i = this.z;
        if (i == id) {
            return;
        }
        if (this.y == id) {
            E(0.0f);
            if (duration > 0) {
                this.D = duration / 1000.0f;
                return;
            }
            return;
        }
        if (this.A == id) {
            E(1.0f);
            if (duration > 0) {
                this.D = duration / 1000.0f;
                return;
            }
            return;
        }
        this.A = id;
        if (i != -1) {
            M(i, id);
            E(1.0f);
            this.F = 0.0f;
            N();
            if (duration > 0) {
                this.D = duration / 1000.0f;
                return;
            }
            return;
        }
        this.M = false;
        this.H = 1.0f;
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = getNanoTime();
        this.C = getNanoTime();
        this.I = false;
        e eVar = null;
        this.w = null;
        if (duration == -1) {
            eVar.b();
            throw null;
        }
        this.y = -1;
        eVar.f(-1, this.A);
        throw null;
    }

    public float getVelocity() {
        return this.x;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.z == -1) {
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return a.f.b.a.a.a(context, this.y) + "->" + a.f.b.a.a.a(context, this.A) + " (pos:" + this.F + " Dpos/Dt:" + this.x;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // a.h.k.m
    public boolean o(View child, View target, int axes, int type) {
        return false;
    }

    @Override // a.h.k.m
    public void i(View child, View target, int axes, int type) {
        this.R = getNanoTime();
        this.S = 0.0f;
        this.P = 0.0f;
        this.Q = 0.0f;
    }

    @Override // a.h.k.m
    public void m(View target, int type) {
    }

    @Override // a.h.k.n
    public void k(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (this.O || dxConsumed != 0 || dyConsumed != 0) {
            consumed[0] = consumed[0] + dxUnconsumed;
            consumed[1] = consumed[1] + dyUnconsumed;
        }
        this.O = false;
    }

    @Override // a.h.k.m
    public void l(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
    }

    @Override // a.h.k.m
    public void n(View target, int dx, int dy, int[] consumed, int type) {
        int regionId;
        e scene = null;
        if (0 == 0) {
            return;
        }
        scene.getClass();
        e.a currentTransition = null;
        if (0 == 0 || !currentTransition.b()) {
            return;
        }
        if (currentTransition.b()) {
            currentTransition.a();
            f touchResponse = null;
            if (0 != 0 && (regionId = touchResponse.b()) != -1 && target.getId() != regionId) {
                return;
            }
        }
        if (scene.c()) {
            currentTransition.a();
            f touchResponse2 = null;
            int vert = -1;
            if (0 != 0 && (touchResponse2.a() & 4) != 0) {
                vert = dy;
            }
            float f = this.E;
            if ((f == 1.0f || f == 0.0f) && target.canScrollVertically(vert)) {
                return;
            }
        }
        currentTransition.a();
        float progress = this.E;
        long time = getNanoTime();
        this.P = dx;
        this.Q = dy;
        double d = time - this.R;
        Double.isNaN(d);
        this.S = (float) (d * 1.0E-9d);
        this.R = time;
        scene.d(dx, dy);
        if (progress != this.E) {
            consumed[0] = dx;
            consumed[1] = dy;
        }
        F(false);
        if (consumed[0] != 0 || consumed[1] != 0) {
            this.O = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.k.o
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        F(false);
        super.dispatchDraw(canvas);
    }

    public void F(boolean force) {
        boolean newState;
        int i;
        boolean newState2;
        if (this.G == -1) {
            this.G = getNanoTime();
        }
        float f = this.F;
        if (f > 0.0f && f < 1.0f) {
            this.z = -1;
        }
        if (this.T || (this.J && (force || this.H != f))) {
            float dir = Math.signum(this.H - f);
            long currentTime = getNanoTime();
            float deltaPos = ((((float) (currentTime - this.G)) * dir) * 1.0E-9f) / this.D;
            float position = this.F + deltaPos;
            if ((dir > 0.0f && position >= this.H) || (dir <= 0.0f && position <= this.H)) {
                position = this.H;
                this.J = false;
            }
            this.F = position;
            this.E = position;
            this.G = currentTime;
            this.x = deltaPos;
            if (Math.abs(deltaPos) > 1.0E-5f) {
                setState(EnumC0013d.MOVING);
            }
            if (0 != 1) {
                if ((dir > 0.0f && position >= this.H) || (dir <= 0.0f && position <= this.H)) {
                    position = this.H;
                    this.J = false;
                }
                if (position >= 1.0f || position <= 0.0f) {
                    this.J = false;
                    setState(EnumC0013d.FINISHED);
                }
            }
            int n = getChildCount();
            this.T = false;
            getNanoTime();
            this.c0 = position;
            if (0 < n) {
                View child = getChildAt(0);
                HashMap hashMap = null;
                hashMap.get(child);
                throw null;
            }
            boolean end = (dir > 0.0f && position >= this.H) || (dir <= 0.0f && position <= this.H);
            if (!this.T && !this.J && end) {
                setState(EnumC0013d.FINISHED);
            }
            boolean z = this.T | (!end);
            this.T = z;
            if (position <= 0.0f && (i = this.y) != -1 && this.z != i) {
                this.z = i;
                e eVar = null;
                eVar.a(i);
                throw null;
            }
            newState = false;
            if (position >= 1.0d) {
                int i2 = this.z;
                int i3 = this.A;
                if (i2 != i3) {
                    this.z = i3;
                    e eVar2 = null;
                    eVar2.a(i3);
                    throw null;
                }
            }
            if (z || this.J) {
                invalidate();
            } else if ((dir > 0.0f && position == 1.0f) || (dir < 0.0f && position == 0.0f)) {
                setState(EnumC0013d.FINISHED);
            }
            if (!this.T && !this.J && ((dir > 0.0f && position == 1.0f) || (dir < 0.0f && position == 0.0f))) {
                I();
            }
        } else {
            newState = false;
        }
        float dir2 = this.F;
        if (dir2 >= 1.0f) {
            int i4 = this.z;
            int i5 = this.A;
            if (i4 == i5) {
                newState2 = newState;
            } else {
                newState2 = true;
            }
            this.z = i5;
        } else if (dir2 > 0.0f) {
            newState2 = newState;
        } else {
            int i6 = this.z;
            int i7 = this.y;
            if (i6 == i7) {
                newState2 = newState;
            } else {
                newState2 = true;
            }
            this.z = i7;
        }
        this.i0 |= newState2;
        if (newState2 && !this.d0) {
            requestLayout();
        }
        this.E = this.F;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.d0 = true;
        try {
            super.onLayout(changed, left, top, right, bottom);
        } finally {
            this.d0 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void t(int id) {
        this.m = null;
    }

    public void setScene(e scene) {
        e eVar = null;
        eVar.e(r());
        throw null;
    }

    public e getScene() {
        return null;
    }

    public void setDebugMode(int debugMode) {
        this.L = debugMode;
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Display display;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 17 && (display = getDisplay()) != null) {
            display.getRotation();
        }
        I();
        b bVar = this.e0;
        if (bVar != null) {
            if (this.g0) {
                post(new a());
            } else {
                bVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.e0.a();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
    }

    public void I() {
    }

    public int getCurrentState() {
        return this.z;
    }

    public float getProgress() {
        return this.F;
    }

    public long getTransitionTimeMs() {
        return this.D * 1000.0f;
    }

    public void setTransitionListener(c listener) {
        this.K = listener;
    }

    public final void G() {
        CopyOnWriteArrayList<c> copyOnWriteArrayList;
        if ((this.K != null || ((copyOnWriteArrayList = this.W) != null && !copyOnWriteArrayList.isEmpty())) && this.b0 != this.E) {
            if (this.a0 != -1) {
                c cVar = this.K;
                if (cVar != null) {
                    cVar.a(this, this.y, this.A);
                }
                CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.W;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<c> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        c listeners = it.next();
                        listeners.a(this, this.y, this.A);
                    }
                }
            }
            this.a0 = -1;
            float f = this.E;
            this.b0 = f;
            c cVar2 = this.K;
            if (cVar2 != null) {
                cVar2.b(this, this.y, this.A, f);
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList3 = this.W;
            if (copyOnWriteArrayList3 != null) {
                Iterator<c> it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    c listeners2 = it2.next();
                    listeners2.b(this, this.y, this.A, this.E);
                }
            }
        }
    }

    public void H() {
        CopyOnWriteArrayList<c> copyOnWriteArrayList;
        if ((this.K != null || ((copyOnWriteArrayList = this.W) != null && !copyOnWriteArrayList.isEmpty())) && this.a0 == -1) {
            this.a0 = this.z;
            ArrayList arrayList = null;
            arrayList.isEmpty();
            throw null;
        }
        J();
    }

    public final void J() {
        CopyOnWriteArrayList<c> copyOnWriteArrayList;
        if (this.K == null && ((copyOnWriteArrayList = this.W) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        ArrayList arrayList = null;
        arrayList.iterator();
        throw null;
    }

    public a.f.b.a.b getDesignTool() {
        if (this.N == null) {
            this.N = new a.f.b.a.b(this);
        }
        return this.N;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof a.f.b.a.c) {
            a.f.b.a.c helper = (a.f.b.a.c) view;
            if (this.W == null) {
                this.W = new CopyOnWriteArrayList<>();
            }
            this.W.add(helper);
            if (helper.u()) {
                if (this.U == null) {
                    this.U = new ArrayList<>();
                }
                this.U.add(helper);
            }
            if (helper.t()) {
                if (this.V == null) {
                    this.V = new ArrayList<>();
                }
                this.V.add(helper);
            }
            helper.s();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<a.f.b.a.c> arrayList = this.U;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<a.f.b.a.c> arrayList2 = this.V;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void setOnShow(float progress) {
        ArrayList<a.f.b.a.c> arrayList = this.U;
        if (arrayList != null) {
            int count = arrayList.size();
            for (int i = 0; i < count; i++) {
                a.f.b.a.c helper = this.U.get(i);
                helper.setProgress(progress);
            }
        }
    }

    public void setOnHide(float progress) {
        ArrayList<a.f.b.a.c> arrayList = this.V;
        if (arrayList != null) {
            int count = arrayList.size();
            for (int i = 0; i < count; i++) {
                a.f.b.a.c helper = this.V.get(i);
                helper.setProgress(progress);
            }
        }
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public ArrayList<e.a> getDefinedTransitions() {
        return null;
    }

    public int getStartState() {
        return this.y;
    }

    public int getEndState() {
        return this.A;
    }

    public float getTargetPosition() {
        return this.H;
    }

    public void setTransitionDuration(int milliseconds) {
        Log.e("MotionLayout", "MotionScene not defined");
    }

    public void setInteractionEnabled(boolean enabled) {
        this.B = enabled;
    }

    public void setDelayedApplicationOfInitialState(boolean delayedApply) {
        this.g0 = delayedApply;
    }
}
