package a.h.k;

import a.h.k.e0.c;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final View.AccessibilityDelegate f431a = new View.AccessibilityDelegate();

    /* renamed from: b, reason: collision with root package name */
    public final View.AccessibilityDelegate f432b;
    public final View.AccessibilityDelegate c;

    /* renamed from: a.h.k.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0028a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final a f433a;

        public C0028a(a compat) {
            this.f433a = compat;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            return this.f433a.a(host, event);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            this.f433a.f(host, event);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            a.h.k.e0.c nodeInfoCompat = a.h.k.e0.c.v0(info);
            nodeInfoCompat.m0(v.W(host));
            nodeInfoCompat.f0(v.R(host));
            nodeInfoCompat.j0(v.p(host));
            nodeInfoCompat.q0(v.K(host));
            this.f433a.g(host, nodeInfoCompat);
            nodeInfoCompat.e(info.getText(), host);
            List<c.a> c = a.c(host);
            for (int i = 0; i < c.size(); i++) {
                nodeInfoCompat.b(c.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            this.f433a.h(host, event);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
            return this.f433a.i(host, child, event);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View host, int eventType) {
            this.f433a.l(host, eventType);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
            this.f433a.m(host, event);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View host) {
            a.h.k.e0.d provider = this.f433a.b(host);
            if (provider != null) {
                return (AccessibilityNodeProvider) provider.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            return this.f433a.j(host, action, args);
        }
    }

    public a() {
        this(f431a);
    }

    public a(View.AccessibilityDelegate originalDelegate) {
        this.f432b = originalDelegate;
        this.c = new C0028a(this);
    }

    public View.AccessibilityDelegate d() {
        return this.c;
    }

    public void l(View host, int eventType) {
        this.f432b.sendAccessibilityEvent(host, eventType);
    }

    public void m(View host, AccessibilityEvent event) {
        this.f432b.sendAccessibilityEventUnchecked(host, event);
    }

    public boolean a(View host, AccessibilityEvent event) {
        return this.f432b.dispatchPopulateAccessibilityEvent(host, event);
    }

    public void h(View host, AccessibilityEvent event) {
        this.f432b.onPopulateAccessibilityEvent(host, event);
    }

    public void f(View host, AccessibilityEvent event) {
        this.f432b.onInitializeAccessibilityEvent(host, event);
    }

    public void g(View host, a.h.k.e0.c info) {
        this.f432b.onInitializeAccessibilityNodeInfo(host, info.u0());
    }

    public boolean i(ViewGroup host, View child, AccessibilityEvent event) {
        return this.f432b.onRequestSendAccessibilityEvent(host, child, event);
    }

    public a.h.k.e0.d b(View host) {
        Object provider = this.f432b.getAccessibilityNodeProvider(host);
        if (provider != null) {
            return new a.h.k.e0.d(provider);
        }
        return null;
    }

    public boolean j(View host, int action, Bundle args) {
        boolean success = false;
        List<c.a> c = c(host);
        int i = 0;
        while (true) {
            if (i >= c.size()) {
                break;
            }
            c.a actionCompat = c.get(i);
            if (actionCompat.b() != action) {
                i++;
            } else {
                success = actionCompat.d(host, args);
                break;
            }
        }
        if (!success) {
            success = this.f432b.performAccessibilityAction(host, action, args);
        }
        if (!success && action == R.id.accessibility_action_clickable_span) {
            boolean success2 = k(args.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), host);
            return success2;
        }
        return success;
    }

    public final boolean k(int clickableSpanId, View host) {
        WeakReference<ClickableSpan> reference;
        SparseArray<WeakReference<ClickableSpan>> spans = (SparseArray) host.getTag(R.id.tag_accessibility_clickable_spans);
        if (spans != null && (reference = spans.get(clickableSpanId)) != null) {
            ClickableSpan span = reference.get();
            if (e(span, host)) {
                span.onClick(host);
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean e(ClickableSpan span, View view) {
        if (span != null) {
            AccessibilityNodeInfo info = view.createAccessibilityNodeInfo();
            ClickableSpan[] spans = a.h.k.e0.c.p(info.getText());
            for (int i = 0; spans != null && i < spans.length; i++) {
                if (span.equals(spans[i])) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static List<c.a> c(View view) {
        List<c.a> list = (List) view.getTag(R.id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }
}
