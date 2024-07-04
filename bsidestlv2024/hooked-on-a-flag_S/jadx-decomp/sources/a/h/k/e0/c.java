package a.h.k.e0;

import a.h.k.e0.f;
import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f451a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final AccessibilityNodeInfo f452b;
    public int c = -1;
    public int d = -1;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f453a;

        /* renamed from: b, reason: collision with root package name */
        public static final a f454b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public final Object i;
        public final int j;
        public final Class<? extends f.a> k;
        public final f l;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            new a(1, null);
            new a(2, null);
            new a(4, null);
            new a(8, null);
            f453a = new a(16, null);
            new a(32, null);
            new a(64, null);
            new a(128, null);
            new a(256, (CharSequence) null, (Class<? extends f.a>) f.b.class);
            new a(512, (CharSequence) null, (Class<? extends f.a>) f.b.class);
            new a(1024, (CharSequence) null, (Class<? extends f.a>) f.c.class);
            new a(2048, (CharSequence) null, (Class<? extends f.a>) f.c.class);
            f454b = new a(4096, null);
            c = new a(8192, null);
            new a(16384, null);
            new a(32768, null);
            new a(65536, null);
            new a(131072, (CharSequence) null, (Class<? extends f.a>) f.g.class);
            d = new a(262144, null);
            e = new a(524288, null);
            f = new a(1048576, null);
            new a(2097152, (CharSequence) null, (Class<? extends f.a>) f.h.class);
            int i = Build.VERSION.SDK_INT;
            new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            if (i >= 23) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
            } else {
                accessibilityAction = null;
            }
            new a(accessibilityAction, R.id.accessibilityActionScrollToPosition, null, null, f.e.class);
            g = new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            h = new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            new a(i >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, f.C0031f.class);
            new a(i >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, f.d.class);
            new a(i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            new a(i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            new a(i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            new a(i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        }

        public a(int actionId, CharSequence label) {
            this(null, actionId, label, null, null);
        }

        public a(int actionId, CharSequence label, f command) {
            this(null, actionId, label, command, null);
        }

        public a(Object action) {
            this(action, 0, null, null, null);
        }

        public a(int actionId, CharSequence label, Class<? extends f.a> cls) {
            this(null, actionId, label, null, cls);
        }

        public a(Object action, int id, CharSequence label, f command, Class<? extends f.a> cls) {
            this.j = id;
            this.l = command;
            if (Build.VERSION.SDK_INT >= 21 && action == null) {
                this.i = new AccessibilityNodeInfo.AccessibilityAction(id, label);
            } else {
                this.i = action;
            }
            this.k = cls;
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.i).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.i).getLabel();
            }
            return null;
        }

        public boolean d(View view, Bundle arguments) {
            if (this.l == null) {
                return false;
            }
            f.a viewCommandArgument = null;
            Class<? extends f.a> cls = this.k;
            if (cls != null) {
                try {
                    viewCommandArgument = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    viewCommandArgument.a(arguments);
                } catch (Exception e2) {
                    Class<? extends f.a> cls2 = this.k;
                    String className = cls2 == null ? "null" : cls2.getName();
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + className, e2);
                }
            }
            return this.l.a(view, viewCommandArgument);
        }

        public a a(CharSequence label, f command) {
            return new a(null, this.j, label, command, this.k);
        }

        public int hashCode() {
            Object obj = this.i;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a other = (a) obj;
            Object obj2 = this.i;
            if (obj2 == null) {
                if (other.i != null) {
                    return false;
                }
                return true;
            }
            if (!obj2.equals(other.i)) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Object f455a;

        public static b a(int rowCount, int columnCount, boolean hierarchical, int selectionMode) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(rowCount, columnCount, hierarchical, selectionMode));
            }
            if (i >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(rowCount, columnCount, hierarchical));
            }
            return new b(null);
        }

        public b(Object info) {
            this.f455a = info;
        }
    }

    /* renamed from: a.h.k.e0.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0030c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f456a;

        public static C0030c a(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading, boolean selected) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                return new C0030c(AccessibilityNodeInfo.CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading, selected));
            }
            if (i >= 19) {
                return new C0030c(AccessibilityNodeInfo.CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading));
            }
            return new C0030c(null);
        }

        public C0030c(Object info) {
            this.f456a = info;
        }
    }

    public c(AccessibilityNodeInfo info) {
        this.f452b = info;
    }

    public static c v0(AccessibilityNodeInfo info) {
        return new c(info);
    }

    public AccessibilityNodeInfo u0() {
        return this.f452b;
    }

    public static c L(View source) {
        return v0(AccessibilityNodeInfo.obtain(source));
    }

    public static c K() {
        return v0(AccessibilityNodeInfo.obtain());
    }

    public static c M(c info) {
        return v0(AccessibilityNodeInfo.obtain(info.f452b));
    }

    public void p0(View root, int virtualDescendantId) {
        this.d = virtualDescendantId;
        this.f452b.setSource(root, virtualDescendantId);
    }

    public int n() {
        return this.f452b.getChildCount();
    }

    public void c(View root, int virtualDescendantId) {
        this.f452b.addChild(root, virtualDescendantId);
    }

    public int j() {
        return this.f452b.getActions();
    }

    public void a(int action) {
        this.f452b.addAction(action);
    }

    public final List<Integer> g(String key) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> list = this.f452b.getExtras().getIntegerArrayList(key);
        if (list == null) {
            ArrayList<Integer> list2 = new ArrayList<>();
            this.f452b.getExtras().putIntegerArrayList(key, list2);
            return list2;
        }
        return list;
    }

    public void b(a action) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f452b.addAction((AccessibilityNodeInfo.AccessibilityAction) action.i);
        }
    }

    public boolean N(int action, Bundle arguments) {
        return this.f452b.performAction(action, arguments);
    }

    public void k0(View parent) {
        this.c = -1;
        this.f452b.setParent(parent);
    }

    public void l0(View root, int virtualDescendantId) {
        this.c = virtualDescendantId;
        this.f452b.setParent(root, virtualDescendantId);
    }

    @Deprecated
    public void l(Rect outBounds) {
        this.f452b.getBoundsInParent(outBounds);
    }

    @Deprecated
    public void S(Rect bounds) {
        this.f452b.setBoundsInParent(bounds);
    }

    public void m(Rect outBounds) {
        this.f452b.getBoundsInScreen(outBounds);
    }

    public void T(Rect bounds) {
        this.f452b.setBoundsInScreen(bounds);
    }

    public boolean z() {
        return this.f452b.isCheckable();
    }

    public void U(boolean checkable) {
        this.f452b.setCheckable(checkable);
    }

    public boolean A() {
        return this.f452b.isChecked();
    }

    public void V(boolean checked) {
        this.f452b.setChecked(checked);
    }

    public boolean D() {
        return this.f452b.isFocusable();
    }

    public void d0(boolean focusable) {
        this.f452b.setFocusable(focusable);
    }

    public boolean E() {
        return this.f452b.isFocused();
    }

    public void e0(boolean focused) {
        this.f452b.setFocused(focused);
    }

    public void t0(boolean visibleToUser) {
        this.f452b.setVisibleToUser(visibleToUser);
    }

    public void Q(boolean focused) {
        this.f452b.setAccessibilityFocused(focused);
    }

    public boolean I() {
        return this.f452b.isSelected();
    }

    public boolean B() {
        return this.f452b.isClickable();
    }

    public void X(boolean clickable) {
        this.f452b.setClickable(clickable);
    }

    public boolean F() {
        return this.f452b.isLongClickable();
    }

    public boolean C() {
        return this.f452b.isEnabled();
    }

    public void b0(boolean enabled) {
        this.f452b.setEnabled(enabled);
    }

    public boolean G() {
        return this.f452b.isPassword();
    }

    public boolean H() {
        return this.f452b.isScrollable();
    }

    public void n0(boolean scrollable) {
        this.f452b.setScrollable(scrollable);
    }

    public CharSequence t() {
        return this.f452b.getPackageName();
    }

    public void i0(CharSequence packageName) {
        this.f452b.setPackageName(packageName);
    }

    public CharSequence o() {
        return this.f452b.getClassName();
    }

    public void W(CharSequence className) {
        this.f452b.setClassName(className);
    }

    public CharSequence v() {
        if (x()) {
            List<Integer> starts = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> ends = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> flags = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> ids = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            Spannable spannable = new SpannableString(TextUtils.substring(this.f452b.getText(), 0, this.f452b.getText().length()));
            for (int i = 0; i < starts.size(); i++) {
                spannable.setSpan(new a.h.k.e0.a(ids.get(i).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), starts.get(i).intValue(), ends.get(i).intValue(), flags.get(i).intValue());
            }
            return spannable;
        }
        return this.f452b.getText();
    }

    public void r0(CharSequence text) {
        this.f452b.setText(text);
    }

    public void e(CharSequence text, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && i < 26) {
            f();
            P(view);
            ClickableSpan[] spans = p(text);
            if (spans != null && spans.length > 0) {
                r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", net.sqlcipher.R.id.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> tagSpans = s(view);
                for (int i2 = 0; i2 < spans.length; i2++) {
                    int id = y(spans[i2], tagSpans);
                    tagSpans.put(id, new WeakReference<>(spans[i2]));
                    d(spans[i2], (Spanned) text, id);
                }
            }
        }
    }

    public final SparseArray<WeakReference<ClickableSpan>> s(View host) {
        SparseArray<WeakReference<ClickableSpan>> spans = u(host);
        if (spans == null) {
            SparseArray<WeakReference<ClickableSpan>> spans2 = new SparseArray<>();
            host.setTag(net.sqlcipher.R.id.tag_accessibility_clickable_spans, spans2);
            return spans2;
        }
        return spans;
    }

    public final SparseArray<WeakReference<ClickableSpan>> u(View host) {
        return (SparseArray) host.getTag(net.sqlcipher.R.id.tag_accessibility_clickable_spans);
    }

    public static ClickableSpan[] p(CharSequence text) {
        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            return (ClickableSpan[]) spanned.getSpans(0, text.length(), ClickableSpan.class);
        }
        return null;
    }

    public final int y(ClickableSpan span, SparseArray<WeakReference<ClickableSpan>> spans) {
        if (spans != null) {
            for (int i = 0; i < spans.size(); i++) {
                ClickableSpan aSpan = spans.valueAt(i).get();
                if (span.equals(aSpan)) {
                    return spans.keyAt(i);
                }
            }
        }
        int i2 = f451a;
        f451a = i2 + 1;
        return i2;
    }

    public final boolean x() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public final void f() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f452b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f452b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f452b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f452b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    public final void d(ClickableSpan span, Spanned spanned, int id) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(span)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(span)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(span)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(id));
    }

    public final void P(View view) {
        SparseArray<WeakReference<ClickableSpan>> spans = u(view);
        if (spans != null) {
            List<Integer> toBeRemovedIndices = new ArrayList<>();
            for (int i = 0; i < spans.size(); i++) {
                if (spans.valueAt(i).get() == null) {
                    toBeRemovedIndices.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < toBeRemovedIndices.size(); i2++) {
                spans.remove(toBeRemovedIndices.get(i2).intValue());
            }
        }
    }

    public CharSequence q() {
        return this.f452b.getContentDescription();
    }

    public void a0(CharSequence contentDescription) {
        this.f452b.setContentDescription(contentDescription);
    }

    public void q0(CharSequence stateDescription) {
        if (a.h.g.a.a()) {
            this.f452b.setStateDescription(stateDescription);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f452b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", stateDescription);
        }
    }

    public void O() {
        this.f452b.recycle();
    }

    public String w() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f452b.getViewIdResourceName();
        }
        return null;
    }

    public void Y(Object collectionInfo) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f452b.setCollectionInfo(collectionInfo == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) collectionInfo).f455a);
        }
    }

    public void Z(Object collectionItemInfo) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f452b.setCollectionItemInfo(collectionItemInfo == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0030c) collectionItemInfo).f456a);
        }
    }

    public List<a> h() {
        List<Object> actions = null;
        if (Build.VERSION.SDK_INT >= 21) {
            actions = this.f452b.getActionList();
        }
        if (actions != null) {
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> result = new ArrayList<>();
            int actionCount = actions.size();
            for (int i = 0; i < actionCount; i++) {
                Object action = actions.get(i);
                result.add(new a(action));
            }
            return result;
        }
        return Collections.emptyList();
    }

    public void g0(CharSequence hintText) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f452b.setHintText(hintText);
        } else if (i >= 19) {
            this.f452b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", hintText);
        }
    }

    public void c0(CharSequence error) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f452b.setError(error);
        }
    }

    public Bundle r() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f452b.getExtras();
        }
        return new Bundle();
    }

    public void h0(int max) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f452b.setMaxTextLength(max);
        }
    }

    public void s0(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f452b.setTraversalAfter(view);
        }
    }

    public void j0(CharSequence paneTitle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f452b.setPaneTitle(paneTitle);
        } else if (i >= 19) {
            this.f452b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", paneTitle);
        }
    }

    public void m0(boolean screenReaderFocusable) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f452b.setScreenReaderFocusable(screenReaderFocusable);
        } else {
            R(1, screenReaderFocusable);
        }
    }

    public boolean J() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f452b.isShowingHintText();
        }
        return k(4);
    }

    public void o0(boolean showingHintText) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f452b.setShowingHintText(showingHintText);
        } else {
            R(4, showingHintText);
        }
    }

    public void f0(boolean isHeading) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f452b.setHeading(isHeading);
        } else {
            R(2, isHeading);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f452b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c other = (c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f452b;
        if (accessibilityNodeInfo == null) {
            if (other.f452b != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(other.f452b)) {
            return false;
        }
        if (this.d == other.d && this.c == other.c) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        Rect bounds = new Rect();
        l(bounds);
        builder.append("; boundsInParent: " + bounds);
        m(bounds);
        builder.append("; boundsInScreen: " + bounds);
        builder.append("; packageName: ");
        builder.append(t());
        builder.append("; className: ");
        builder.append(o());
        builder.append("; text: ");
        builder.append(v());
        builder.append("; contentDescription: ");
        builder.append(q());
        builder.append("; viewId: ");
        builder.append(w());
        builder.append("; checkable: ");
        builder.append(z());
        builder.append("; checked: ");
        builder.append(A());
        builder.append("; focusable: ");
        builder.append(D());
        builder.append("; focused: ");
        builder.append(E());
        builder.append("; selected: ");
        builder.append(I());
        builder.append("; clickable: ");
        builder.append(B());
        builder.append("; longClickable: ");
        builder.append(F());
        builder.append("; enabled: ");
        builder.append(C());
        builder.append("; password: ");
        builder.append(G());
        builder.append("; scrollable: " + H());
        builder.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> h = h();
            for (int i = 0; i < h.size(); i++) {
                a action = h.get(i);
                String actionName = i(action.b());
                if (actionName.equals("ACTION_UNKNOWN") && action.c() != null) {
                    actionName = action.c().toString();
                }
                builder.append(actionName);
                if (i != h.size() - 1) {
                    builder.append(", ");
                }
            }
        } else {
            int actionBits = j();
            while (actionBits != 0) {
                int action2 = 1 << Integer.numberOfTrailingZeros(actionBits);
                actionBits &= action2 ^ (-1);
                builder.append(i(action2));
                if (actionBits != 0) {
                    builder.append(", ");
                }
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public final void R(int property, boolean value) {
        Bundle extras = r();
        if (extras != null) {
            int booleanProperties = extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
            extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", (value ? property : 0) | (booleanProperties & (property ^ (-1))));
        }
    }

    public final boolean k(int property) {
        Bundle extras = r();
        return extras != null && (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & property) == property;
    }

    public static String i(int action) {
        switch (action) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                return "ACTION_CLEAR_SELECTION";
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionShowOnScreen:
                return "ACTION_SHOW_ON_SCREEN";
            case R.id.accessibilityActionScrollToPosition:
                return "ACTION_SCROLL_TO_POSITION";
            case R.id.accessibilityActionScrollUp:
                return "ACTION_SCROLL_UP";
            case R.id.accessibilityActionScrollLeft:
                return "ACTION_SCROLL_LEFT";
            case R.id.accessibilityActionScrollDown:
                return "ACTION_SCROLL_DOWN";
            case R.id.accessibilityActionScrollRight:
                return "ACTION_SCROLL_RIGHT";
            case R.id.accessibilityActionContextClick:
                return "ACTION_CONTEXT_CLICK";
            case R.id.accessibilityActionSetProgress:
                return "ACTION_SET_PROGRESS";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionShowTooltip:
                return "ACTION_SHOW_TOOLTIP";
            case R.id.accessibilityActionHideTooltip:
                return "ACTION_HIDE_TOOLTIP";
            case R.id.accessibilityActionPageUp:
                return "ACTION_PAGE_UP";
            case R.id.accessibilityActionPageDown:
                return "ACTION_PAGE_DOWN";
            case R.id.accessibilityActionPageLeft:
                return "ACTION_PAGE_LEFT";
            case R.id.accessibilityActionPageRight:
                return "ACTION_PAGE_RIGHT";
            case R.id.accessibilityActionPressAndHold:
                return "ACTION_PRESS_AND_HOLD";
            case R.id.accessibilityActionImeEnter:
                return "ACTION_IME_ENTER";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
