package a.j.b;

import a.e.h;
import a.h.k.e0.d;
import a.h.k.e0.e;
import a.h.k.v;
import a.h.k.y;
import a.j.b.b;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteCursor;

/* loaded from: classes.dex */
public abstract class a extends a.h.k.a {
    public static final Rect d = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final b.a<a.h.k.e0.c> e = new C0038a();
    public static final b.InterfaceC0039b<h<a.h.k.e0.c>, a.h.k.e0.c> f = new b();
    public final AccessibilityManager k;
    public final View l;
    public c m;
    public final Rect g = new Rect();
    public final Rect h = new Rect();
    public final Rect i = new Rect();
    public final int[] j = new int[2];
    public int n = Integer.MIN_VALUE;
    public int o = Integer.MIN_VALUE;
    public int p = Integer.MIN_VALUE;

    public abstract int B(float f2, float f3);

    public abstract void C(List<Integer> list);

    public abstract boolean J(int i, int i2, Bundle bundle);

    public abstract void N(int i, a.h.k.e0.c cVar);

    public a(View host) {
        if (host == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.l = host;
        Context context = host.getContext();
        this.k = (AccessibilityManager) context.getSystemService("accessibility");
        host.setFocusable(true);
        if (v.A(host) == 0) {
            v.x0(host, 1);
        }
    }

    @Override // a.h.k.a
    public d b(View host) {
        if (this.m == null) {
            this.m = new c();
        }
        return this.m;
    }

    public final boolean v(MotionEvent event) {
        if (!this.k.isEnabled() || !this.k.isTouchExplorationEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
            case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                int virtualViewId = B(event.getX(), event.getY());
                V(virtualViewId);
                return virtualViewId != Integer.MIN_VALUE;
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
            default:
                return false;
            case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                if (this.p == Integer.MIN_VALUE) {
                    return false;
                }
                V(Integer.MIN_VALUE);
                return true;
        }
    }

    public final boolean w(KeyEvent event) {
        boolean handled = false;
        int action = event.getAction();
        if (action == 1) {
            return false;
        }
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case 19:
            case 20:
            case 21:
            case 22:
                if (!event.hasNoModifiers()) {
                    return false;
                }
                int direction = F(keyCode);
                int count = event.getRepeatCount() + 1;
                for (int i = 0; i < count && G(direction, null); i++) {
                    handled = true;
                }
                return handled;
            case 23:
            case 66:
                if (!event.hasNoModifiers() || event.getRepeatCount() != 0) {
                    return false;
                }
                p();
                return true;
            case 61:
                if (event.hasNoModifiers()) {
                    boolean handled2 = G(2, null);
                    return handled2;
                }
                if (!event.hasModifiers(1)) {
                    return false;
                }
                boolean handled3 = G(1, null);
                return handled3;
            default:
                return false;
        }
    }

    public final void I(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        int i = this.o;
        if (i != Integer.MIN_VALUE) {
            o(i);
        }
        if (gainFocus) {
            G(direction, previouslyFocusedRect);
        }
    }

    public final int x() {
        return this.n;
    }

    public final int A() {
        return this.o;
    }

    public static int F(int keyCode) {
        switch (keyCode) {
            case 19:
                return 33;
            case 20:
            default:
                return 130;
            case 21:
                return 17;
            case 22:
                return 66;
        }
    }

    public final void z(int virtualViewId, Rect outBounds) {
        a.h.k.e0.c node = H(virtualViewId);
        node.l(outBounds);
    }

    /* renamed from: a.j.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0038a implements b.a<a.h.k.e0.c> {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(a.h.k.e0.c node, Rect outBounds) {
            node.l(outBounds);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements b.InterfaceC0039b<h<a.h.k.e0.c>, a.h.k.e0.c> {
        /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a.h.k.e0.c b(h<a.h.k.e0.c> hVar, int index) {
            return hVar.k(index);
        }

        /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int d(h<a.h.k.e0.c> hVar) {
            return hVar.j();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> */
    public final boolean G(int direction, Rect previouslyFocusedRect) {
        a.h.k.e0.c nextFocusedNode;
        int index;
        h<a.h.k.e0.c> y = y();
        int focusedNodeId = this.o;
        a.h.k.e0.c focusedNode = focusedNodeId == Integer.MIN_VALUE ? null : y.e(focusedNodeId);
        switch (direction) {
            case 1:
            case 2:
                boolean isLayoutRtl = v.C(this.l) == 1;
                nextFocusedNode = (a.h.k.e0.c) a.j.b.b.d(y, f, e, focusedNode, direction, isLayoutRtl, false);
                break;
            case 17:
            case 33:
            case 66:
            case 130:
                Rect selectedRect = new Rect();
                int i = this.o;
                if (i != Integer.MIN_VALUE) {
                    z(i, selectedRect);
                } else if (previouslyFocusedRect != null) {
                    selectedRect.set(previouslyFocusedRect);
                } else {
                    D(this.l, direction, selectedRect);
                }
                nextFocusedNode = (a.h.k.e0.c) a.j.b.b.c(y, f, e, focusedNode, selectedRect, direction);
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (nextFocusedNode == null) {
            index = Integer.MIN_VALUE;
        } else {
            int index2 = y.g(nextFocusedNode);
            index = y.h(index2);
        }
        return T(index);
    }

    /* JADX WARN: Generic types in debug info not equals: a.e.h != androidx.collection.SparseArrayCompat<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> */
    public final h<a.h.k.e0.c> y() {
        List<Integer> virtualViewIds = new ArrayList<>();
        C(virtualViewIds);
        h<a.h.k.e0.c> hVar = new h<>();
        for (int virtualViewId = 0; virtualViewId < virtualViewIds.size(); virtualViewId++) {
            a.h.k.e0.c virtualView = t(virtualViewId);
            hVar.i(virtualViewId, virtualView);
        }
        return hVar;
    }

    public static Rect D(View host, int direction, Rect outBounds) {
        int w = host.getWidth();
        int h = host.getHeight();
        switch (direction) {
            case 17:
                outBounds.set(w, 0, w, h);
                return outBounds;
            case 33:
                outBounds.set(0, h, w, h);
                return outBounds;
            case 66:
                outBounds.set(-1, 0, -1, h);
                return outBounds;
            case 130:
                outBounds.set(0, -1, w, -1);
                return outBounds;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public final boolean p() {
        int i = this.o;
        return i != Integer.MIN_VALUE && J(i, 16, null);
    }

    public final boolean U(int virtualViewId, int eventType) {
        ViewParent parent;
        if (virtualViewId == Integer.MIN_VALUE || !this.k.isEnabled() || (parent = this.l.getParent()) == null) {
            return false;
        }
        AccessibilityEvent event = q(virtualViewId, eventType);
        return y.h(parent, this.l, event);
    }

    public void O(int virtualViewId, boolean hasFocus) {
    }

    public final void V(int virtualViewId) {
        if (this.p == virtualViewId) {
            return;
        }
        int previousVirtualViewId = this.p;
        this.p = virtualViewId;
        U(virtualViewId, 128);
        U(previousVirtualViewId, 256);
    }

    public final AccessibilityEvent q(int virtualViewId, int eventType) {
        switch (virtualViewId) {
            case SQLiteCursor.NO_COUNT /* -1 */:
                return s(eventType);
            default:
                return r(virtualViewId, eventType);
        }
    }

    public final AccessibilityEvent s(int eventType) {
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        this.l.onInitializeAccessibilityEvent(event);
        return event;
    }

    @Override // a.h.k.a
    public void f(View host, AccessibilityEvent event) {
        super.f(host, event);
        K();
    }

    public final AccessibilityEvent r(int virtualViewId, int eventType) {
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        a.h.k.e0.c node = H(virtualViewId);
        event.getText().add(node.v());
        event.setContentDescription(node.q());
        event.setScrollable(node.H());
        event.setPassword(node.G());
        event.setEnabled(node.C());
        event.setChecked(node.A());
        L();
        if (event.getText().isEmpty() && event.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        event.setClassName(node.o());
        e.c(event, this.l, virtualViewId);
        event.setPackageName(this.l.getContext().getPackageName());
        return event;
    }

    public a.h.k.e0.c H(int virtualViewId) {
        if (virtualViewId == -1) {
            return u();
        }
        return t(virtualViewId);
    }

    public final a.h.k.e0.c u() {
        a.h.k.e0.c info = a.h.k.e0.c.L(this.l);
        v.b0(this.l, info);
        ArrayList<Integer> virtualViewIds = new ArrayList<>();
        C(virtualViewIds);
        int realNodeCount = info.n();
        if (realNodeCount > 0 && virtualViewIds.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int count = virtualViewIds.size();
        for (int i = 0; i < count; i++) {
            info.c(this.l, virtualViewIds.get(i).intValue());
        }
        return info;
    }

    @Override // a.h.k.a
    public void g(View host, a.h.k.e0.c info) {
        super.g(host, info);
        M(info);
    }

    public final a.h.k.e0.c t(int virtualViewId) {
        a.h.k.e0.c node = a.h.k.e0.c.K();
        node.b0(true);
        node.d0(true);
        node.W("android.view.View");
        Rect rect = d;
        node.S(rect);
        node.T(rect);
        node.k0(this.l);
        N(virtualViewId, node);
        if (node.v() == null && node.q() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        node.l(this.h);
        if (this.h.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = node.j();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        node.i0(this.l.getContext().getPackageName());
        node.p0(this.l, virtualViewId);
        if (this.n == virtualViewId) {
            node.Q(true);
            node.a(128);
        } else {
            node.Q(false);
            node.a(64);
        }
        boolean isFocused = this.o == virtualViewId;
        if (isFocused) {
            node.a(2);
        } else if (node.D()) {
            node.a(1);
        }
        node.e0(isFocused);
        this.l.getLocationOnScreen(this.j);
        node.m(this.g);
        if (this.g.equals(rect)) {
            node.l(this.g);
            if (node.c != -1) {
                a.h.k.e0.c parentNode = a.h.k.e0.c.K();
                for (int virtualDescendantId = node.c; virtualDescendantId != -1; virtualDescendantId = parentNode.c) {
                    parentNode.l0(this.l, -1);
                    parentNode.S(d);
                    N(virtualDescendantId, parentNode);
                    parentNode.l(this.h);
                    Rect rect2 = this.g;
                    Rect rect3 = this.h;
                    rect2.offset(rect3.left, rect3.top);
                }
                parentNode.O();
            }
            this.g.offset(this.j[0] - this.l.getScrollX(), this.j[1] - this.l.getScrollY());
        }
        if (this.l.getLocalVisibleRect(this.i)) {
            this.i.offset(this.j[0] - this.l.getScrollX(), this.j[1] - this.l.getScrollY());
            boolean intersects = this.g.intersect(this.i);
            if (intersects) {
                node.T(this.g);
                if (E(this.g)) {
                    node.t0(true);
                }
            }
        }
        return node;
    }

    public boolean P(int virtualViewId, int action, Bundle arguments) {
        switch (virtualViewId) {
            case SQLiteCursor.NO_COUNT /* -1 */:
                return R(action, arguments);
            default:
                return Q(virtualViewId, action, arguments);
        }
    }

    public final boolean R(int action, Bundle arguments) {
        return v.d0(this.l, action, arguments);
    }

    public final boolean Q(int virtualViewId, int action, Bundle arguments) {
        switch (action) {
            case 1:
                return T(virtualViewId);
            case 2:
                return o(virtualViewId);
            case 64:
                return S(virtualViewId);
            case 128:
                return n(virtualViewId);
            default:
                return J(virtualViewId, action, arguments);
        }
    }

    public final boolean E(Rect localRect) {
        if (localRect == null || localRect.isEmpty() || this.l.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent viewParent = this.l.getParent();
        while (viewParent instanceof View) {
            View view = (View) viewParent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            viewParent = view.getParent();
        }
        return viewParent != null;
    }

    public final boolean S(int virtualViewId) {
        int i;
        if (!this.k.isEnabled() || !this.k.isTouchExplorationEnabled() || (i = this.n) == virtualViewId) {
            return false;
        }
        if (i != Integer.MIN_VALUE) {
            n(i);
        }
        this.n = virtualViewId;
        this.l.invalidate();
        U(virtualViewId, 32768);
        return true;
    }

    public final boolean n(int virtualViewId) {
        if (this.n == virtualViewId) {
            this.n = Integer.MIN_VALUE;
            this.l.invalidate();
            U(virtualViewId, 65536);
            return true;
        }
        return false;
    }

    public final boolean T(int virtualViewId) {
        int i;
        if ((!this.l.isFocused() && !this.l.requestFocus()) || (i = this.o) == virtualViewId) {
            return false;
        }
        if (i != Integer.MIN_VALUE) {
            o(i);
        }
        this.o = virtualViewId;
        O(virtualViewId, true);
        U(virtualViewId, 8);
        return true;
    }

    public final boolean o(int virtualViewId) {
        if (this.o != virtualViewId) {
            return false;
        }
        this.o = Integer.MIN_VALUE;
        O(virtualViewId, false);
        U(virtualViewId, 8);
        return true;
    }

    public void L() {
    }

    public void K() {
    }

    public void M(a.h.k.e0.c node) {
    }

    /* loaded from: classes.dex */
    public class c extends d {
        public c() {
        }

        @Override // a.h.k.e0.d
        public a.h.k.e0.c b(int virtualViewId) {
            a.h.k.e0.c node = a.this.H(virtualViewId);
            return a.h.k.e0.c.M(node);
        }

        @Override // a.h.k.e0.d
        public boolean f(int virtualViewId, int action, Bundle arguments) {
            return a.this.P(virtualViewId, action, arguments);
        }

        @Override // a.h.k.e0.d
        public a.h.k.e0.c d(int focusType) {
            int focusedId = focusType == 2 ? a.this.n : a.this.o;
            if (focusedId == Integer.MIN_VALUE) {
                return null;
            }
            return b(focusedId);
        }
    }
}
