package a.h.k;

import a.h.k.a;
import a.h.k.d0;
import a.h.k.e0.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.sqlcipher.R;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class v {

    /* renamed from: b, reason: collision with root package name */
    public static WeakHashMap<View, String> f476b;
    public static Field d;
    public static ThreadLocal<Rect> f;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f475a = new AtomicInteger(1);
    public static WeakHashMap<View, z> c = null;
    public static boolean e = false;
    public static final int[] g = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final s h = new a();

    /* loaded from: classes.dex */
    public interface k {
        boolean a(View view, KeyEvent keyEvent);
    }

    static {
        new f();
    }

    public static Rect x() {
        if (f == null) {
            f = new ThreadLocal<>();
        }
        Rect rect = f.get();
        if (rect == null) {
            rect = new Rect();
            f.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void m0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] styleable, AttributeSet attrs, TypedArray t, int defStyleAttr, int defStyleRes) {
        if (Build.VERSION.SDK_INT >= 29) {
            j.a(view, context, styleable, attrs, t, defStyleAttr, defStyleRes);
        }
    }

    public static void b0(View v, a.h.k.e0.c info) {
        v.onInitializeAccessibilityNodeInfo(info.u0());
    }

    public static void o0(View v, a.h.k.a delegate) {
        if (delegate == null && (m(v) instanceof a.C0028a)) {
            delegate = new a.h.k.a();
        }
        v.setAccessibilityDelegate(delegate == null ? null : delegate.d());
    }

    @SuppressLint({"InlinedApi"})
    public static int B(View v) {
        if (Build.VERSION.SDK_INT >= 26) {
            return v.getImportantForAutofill();
        }
        return 0;
    }

    public static void y0(View v, int mode) {
        if (Build.VERSION.SDK_INT >= 26) {
            v.setImportantForAutofill(mode);
        }
    }

    public static a.h.k.a l(View view) {
        View.AccessibilityDelegate delegate = m(view);
        if (delegate == null) {
            return null;
        }
        if (delegate instanceof a.C0028a) {
            return ((a.C0028a) delegate).f433a;
        }
        return new a.h.k.a(delegate);
    }

    public static a.h.k.a G(View v) {
        a.h.k.a delegateCompat = l(v);
        if (delegateCompat == null) {
            delegateCompat = new a.h.k.a();
        }
        o0(v, delegateCompat);
        return delegateCompat;
    }

    public static View.AccessibilityDelegate m(View v) {
        if (Build.VERSION.SDK_INT >= 29) {
            return v.getAccessibilityDelegate();
        }
        return n(v);
    }

    public static View.AccessibilityDelegate n(View v) {
        if (e) {
            return null;
        }
        if (d == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                d = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                e = true;
                return null;
            }
        }
        try {
            Object o = d.get(v);
            if (o instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) o;
            }
            return null;
        } catch (Throwable th2) {
            e = true;
            return null;
        }
    }

    public static boolean Q(View view) {
        return view.hasTransientState();
    }

    public static void w0(View view, boolean hasTransientState) {
        view.setHasTransientState(hasTransientState);
    }

    public static void f0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void g0(View view, Runnable action) {
        view.postOnAnimation(action);
    }

    public static void h0(View view, Runnable action, long delayMillis) {
        view.postOnAnimationDelayed(action, delayMillis);
    }

    public static int A(View view) {
        return view.getImportantForAccessibility();
    }

    public static void x0(View view, int mode) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(mode);
            return;
        }
        if (mode == 4) {
            mode = 2;
        }
        view.setImportantForAccessibility(mode);
    }

    public static boolean d0(View view, int action, Bundle arguments) {
        return view.performAccessibilityAction(action, arguments);
    }

    public static int b(View view, CharSequence label, a.h.k.e0.f command) {
        int actionId = r(view);
        if (actionId != -1) {
            c.a action = new c.a(actionId, label, command);
            c(view, action);
        }
        return actionId;
    }

    public static int r(View view) {
        int result = -1;
        List<c.a> q = q(view);
        int i2 = 0;
        while (true) {
            int[] iArr = g;
            if (i2 >= iArr.length || result != -1) {
                break;
            }
            int id = iArr[i2];
            boolean idAvailable = true;
            for (int j2 = 0; j2 < q.size(); j2++) {
                idAvailable &= q.get(j2).b() != id;
            }
            if (idAvailable) {
                result = id;
            }
            i2++;
        }
        return result;
    }

    public static void k0(View view, c.a replacedAction, CharSequence label, a.h.k.e0.f command) {
        if (command == null && label == null) {
            i0(view, replacedAction.b());
        } else {
            c(view, replacedAction.a(label, command));
        }
    }

    public static void c(View view, c.a action) {
        if (Build.VERSION.SDK_INT >= 21) {
            G(view);
            j0(action.b(), view);
            q(view).add(action);
            X(view, 0);
        }
    }

    public static void i0(View view, int actionId) {
        if (Build.VERSION.SDK_INT >= 21) {
            j0(actionId, view);
            X(view, 0);
        }
    }

    public static void j0(int actionId, View view) {
        List<c.a> q = q(view);
        for (int i2 = 0; i2 < q.size(); i2++) {
            if (q.get(i2).b() == actionId) {
                q.remove(i2);
                return;
            }
        }
    }

    public static List<c.a> q(View view) {
        ArrayList<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actions = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (actions == null) {
            ArrayList<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actions2 = new ArrayList<>();
            view.setTag(R.id.tag_accessibility_actions, actions2);
            return actions2;
        }
        return actions;
    }

    public static final CharSequence K(View view) {
        return E0().f(view);
    }

    public static int C(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void q0(View view, int mode) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(mode);
        }
    }

    public static int I(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static int H(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static void A0(View view, int start, int top, int end, int bottom) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(start, top, end, bottom);
        } else {
            view.setPadding(start, top, end, bottom);
        }
    }

    public static int E(View view) {
        return view.getMinimumWidth();
    }

    public static int D(View view) {
        return view.getMinimumHeight();
    }

    public static z d(View view) {
        if (c == null) {
            c = new WeakHashMap<>();
        }
        z vpa = c.get(view);
        if (vpa == null) {
            z vpa2 = new z(view);
            c.put(view, vpa2);
            return vpa2;
        }
        return vpa;
    }

    public static void v0(View view, float elevation) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(elevation);
        }
    }

    public static float w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void C0(View view, String transitionName) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(transitionName);
            return;
        }
        if (f476b == null) {
            f476b = new WeakHashMap<>();
        }
        f476b.put(view, transitionName);
    }

    public static String L(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f476b;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int M(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static void l0(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else {
            view.requestFitSystemWindows();
        }
    }

    public static boolean z(View v) {
        return v.getFitsSystemWindows();
    }

    public static void z0(View v, q listener) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.d(v, listener);
        }
    }

    public static d0 a0(View view, d0 insets) {
        WindowInsets unwrapped;
        if (Build.VERSION.SDK_INT >= 21 && (unwrapped = insets.r()) != null) {
            WindowInsets result = view.onApplyWindowInsets(unwrapped);
            if (!result.equals(unwrapped)) {
                return d0.t(result, view);
            }
        }
        return insets;
    }

    public static d0 h(View view, d0 insets) {
        WindowInsets unwrapped;
        if (Build.VERSION.SDK_INT >= 21 && (unwrapped = insets.r()) != null) {
            WindowInsets result = view.dispatchApplyWindowInsets(unwrapped);
            if (!result.equals(unwrapped)) {
                return d0.t(result, view);
            }
        }
        return insets;
    }

    public static d0 J(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return i.a(view);
        }
        if (i2 >= 21) {
            return h.c(view);
        }
        return null;
    }

    public static d0 g(View view, d0 insets, Rect outLocalInsets) {
        if (Build.VERSION.SDK_INT >= 21) {
            return h.b(view, insets, outLocalInsets);
        }
        return insets;
    }

    public static String[] F(View view) {
        return (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static a.h.k.c e0(View view, a.h.k.c payload) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + payload + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        r listener = (r) view.getTag(R.id.tag_on_receive_content_listener);
        if (listener != null) {
            a.h.k.c remaining = listener.a(view, payload);
            if (remaining == null) {
                return null;
            }
            return y(view).a(remaining);
        }
        return y(view).a(payload);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static s y(View view) {
        if (view instanceof s) {
            return (s) view;
        }
        return h;
    }

    /* loaded from: classes.dex */
    public class a implements s {
        @Override // a.h.k.s
        public a.h.k.c a(a.h.k.c payload) {
            return payload;
        }
    }

    public static boolean P(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean V(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static void r0(View view, Drawable background) {
        view.setBackground(background);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList s(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof u) {
            return ((u) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void s0(View view, ColorStateList tintList) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            view.setBackgroundTintList(tintList);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean hasTint = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && hasTint) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                    return;
                }
                return;
            }
            return;
        }
        if (view instanceof u) {
            ((u) view).setSupportBackgroundTintList(tintList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof u) {
            return ((u) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void t0(View view, PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            view.setBackgroundTintMode(mode);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean hasTint = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && hasTint) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                    return;
                }
                return;
            }
            return;
        }
        if (view instanceof u) {
            ((u) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean U(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof a.h.k.k) {
            return ((a.h.k.k) view).isNestedScrollingEnabled();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void F0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof a.h.k.k) {
            ((a.h.k.k) view).stopNestedScroll();
        }
    }

    public static boolean T(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float N(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void Z(View view, int offset) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetTopAndBottom(offset);
            return;
        }
        if (i2 >= 21) {
            Rect parentRect = x();
            boolean needInvalidateWorkaround = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View p = (View) parent;
                parentRect.set(p.getLeft(), p.getTop(), p.getRight(), p.getBottom());
                needInvalidateWorkaround = !parentRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            f(view, offset);
            if (needInvalidateWorkaround && parentRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(parentRect);
                return;
            }
            return;
        }
        f(view, offset);
    }

    public static void f(View view, int offset) {
        view.offsetTopAndBottom(offset);
        if (view.getVisibility() == 0) {
            G0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                G0((View) parent);
            }
        }
    }

    public static void Y(View view, int offset) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetLeftAndRight(offset);
            return;
        }
        if (i2 >= 21) {
            Rect parentRect = x();
            boolean needInvalidateWorkaround = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View p = (View) parent;
                parentRect.set(p.getLeft(), p.getTop(), p.getRight(), p.getBottom());
                needInvalidateWorkaround = !parentRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            e(view, offset);
            if (needInvalidateWorkaround && parentRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(parentRect);
                return;
            }
            return;
        }
        e(view, offset);
    }

    public static void e(View view, int offset) {
        view.offsetLeftAndRight(offset);
        if (view.getVisibility() == 0) {
            G0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                G0((View) parent);
            }
        }
    }

    public static void G0(View view) {
        float y = view.getTranslationY();
        view.setTranslationY(1.0f + y);
        view.setTranslationY(y);
    }

    public static void u0(View view, Rect clipBounds) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(clipBounds);
        }
    }

    public static Rect u(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean S(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean O(View view) {
        return view.hasOnClickListeners();
    }

    public static void B0(View view, int indicators, int mask) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(indicators, mask);
        }
    }

    public static Display v(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (S(view)) {
            WindowManager wm = (WindowManager) view.getContext().getSystemService("window");
            return wm.getDefaultDisplay();
        }
        return null;
    }

    public static int k() {
        AtomicInteger atomicInteger;
        int result;
        int newValue;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f475a;
            result = atomicInteger.get();
            newValue = result + 1;
            if (newValue > 16777215) {
                newValue = 1;
            }
        } while (!atomicInteger.compareAndSet(result, newValue));
        return result;
    }

    public static boolean j(View root, KeyEvent evt) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(root).f(evt);
    }

    public static boolean i(View root, KeyEvent evt) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(root).b(root, evt);
    }

    public static boolean W(View view) {
        Boolean result = n0().f(view);
        if (result == null) {
            return false;
        }
        return result.booleanValue();
    }

    /* loaded from: classes.dex */
    public class b extends g<Boolean> {
        public b(int tagKey, Class cls, int frameworkMinimumSdk) {
            super(tagKey, cls, frameworkMinimumSdk);
        }

        @Override // a.h.k.v.g
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        @Override // a.h.k.v.g
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean value) {
            view.setScreenReaderFocusable(value.booleanValue());
        }

        @Override // a.h.k.v.g
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean oldValue, Boolean newValue) {
            return !a(oldValue, newValue);
        }
    }

    public static g<Boolean> n0() {
        return new b(R.id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static CharSequence p(View view) {
        return c0().f(view);
    }

    /* loaded from: classes.dex */
    public class c extends g<CharSequence> {
        public c(int tagKey, Class cls, int contentChangeType, int frameworkMinimumSdk) {
            super(tagKey, cls, contentChangeType, frameworkMinimumSdk);
        }

        @Override // a.h.k.v.g
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @Override // a.h.k.v.g
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence value) {
            view.setAccessibilityPaneTitle(value);
        }

        @Override // a.h.k.v.g
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence oldValue, CharSequence newValue) {
            return !TextUtils.equals(oldValue, newValue);
        }
    }

    public static g<CharSequence> c0() {
        return new c(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    /* loaded from: classes.dex */
    public class d extends g<CharSequence> {
        public d(int tagKey, Class cls, int contentChangeType, int frameworkMinimumSdk) {
            super(tagKey, cls, contentChangeType, frameworkMinimumSdk);
        }

        @Override // a.h.k.v.g
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return view.getStateDescription();
        }

        @Override // a.h.k.v.g
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence value) {
            view.setStateDescription(value);
        }

        @Override // a.h.k.v.g
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence oldValue, CharSequence newValue) {
            return !TextUtils.equals(oldValue, newValue);
        }
    }

    public static g<CharSequence> E0() {
        return new d(R.id.tag_state_description, CharSequence.class, 64, 30);
    }

    public static boolean R(View view) {
        Boolean result = a().f(view);
        if (result == null) {
            return false;
        }
        return result.booleanValue();
    }

    public static void p0(View view, boolean isHeading) {
        a().g(view, Boolean.valueOf(isHeading));
    }

    /* loaded from: classes.dex */
    public class e extends g<Boolean> {
        public e(int tagKey, Class cls, int frameworkMinimumSdk) {
            super(tagKey, cls, frameworkMinimumSdk);
        }

        @Override // a.h.k.v.g
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        @Override // a.h.k.v.g
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean value) {
            view.setAccessibilityHeading(value.booleanValue());
        }

        @Override // a.h.k.v.g
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean oldValue, Boolean newValue) {
            return !a(oldValue, newValue);
        }
    }

    public static g<Boolean> a() {
        return new e(R.id.tag_accessibility_heading, Boolean.class, 28);
    }

    /* loaded from: classes.dex */
    public static abstract class g<T> {

        /* renamed from: a, reason: collision with root package name */
        public final int f478a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<T> f479b;
        public final int c;
        public final int d;

        public abstract T d(View view);

        public abstract void e(View view, T t);

        public abstract boolean h(T t, T t2);

        /* JADX WARN: Generic types in debug info not equals: a.h.k.v$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public g(int tagKey, Class<T> type, int frameworkMinimumSdk) {
            this(tagKey, type, 0, frameworkMinimumSdk);
        }

        /* JADX WARN: Generic types in debug info not equals: a.h.k.v$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public g(int tagKey, Class<T> type, int contentChangeType, int frameworkMinimumSdk) {
            this.f478a = tagKey;
            this.f479b = type;
            this.d = contentChangeType;
            this.c = frameworkMinimumSdk;
        }

        /* JADX WARN: Generic types in debug info not equals: a.h.k.v$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public void g(View view, T value) {
            if (c()) {
                e(view, value);
            } else if (b() && h(f(view), value)) {
                v.G(view);
                view.setTag(this.f478a, value);
                v.X(view, this.d);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: a.h.k.v$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public T f(View view) {
            if (c()) {
                return d(view);
            }
            if (b()) {
                T t = (T) view.getTag(this.f478a);
                if (this.f479b.isInstance(t)) {
                    return t;
                }
                return null;
            }
            return null;
        }

        /* JADX WARN: Generic types in debug info not equals: a.h.k.v$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public final boolean c() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        /* JADX WARN: Generic types in debug info not equals: a.h.k.v$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        /* JADX WARN: Generic types in debug info not equals: a.h.k.v$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public boolean a(Boolean a2, Boolean b2) {
            boolean aBool = a2 == null ? false : a2.booleanValue();
            boolean bBool = b2 == null ? false : b2.booleanValue();
            return aBool == bBool;
        }
    }

    public static void X(View view, int changeType) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        boolean isVisibleAccessibilityPane = p(view) != null && view.getVisibility() == 0;
        if (o(view) != 0 || isVisibleAccessibilityPane) {
            AccessibilityEvent event = AccessibilityEvent.obtain();
            event.setEventType(isVisibleAccessibilityPane ? 32 : 2048);
            event.setContentChangeTypes(changeType);
            if (isVisibleAccessibilityPane) {
                event.getText().add(p(view));
                D0(view);
            }
            view.sendAccessibilityEventUnchecked(event);
            return;
        }
        if (changeType == 32) {
            AccessibilityEvent event2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(event2);
            event2.setEventType(32);
            event2.setContentChangeTypes(changeType);
            event2.setSource(view);
            view.onPopulateAccessibilityEvent(event2);
            event2.getText().add(p(view));
            accessibilityManager.sendAccessibilityEvent(event2);
            return;
        }
        if (view.getParent() != null) {
            try {
                view.getParent().notifySubtreeAccessibilityStateChanged(view, view, changeType);
            } catch (AbstractMethodError e2) {
                Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
            }
        }
    }

    public static void D0(View view) {
        if (A(view) == 0) {
            x0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (A((View) parent) == 4) {
                x0(view, 2);
                return;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public WeakHashMap<View, Boolean> f477b = new WeakHashMap<>();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f477b.entrySet()) {
                    a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        public final void a(View pane, boolean oldVisibility) {
            int contentChangeType;
            boolean newVisibility = pane.getVisibility() == 0;
            if (oldVisibility != newVisibility) {
                if (newVisibility) {
                    contentChangeType = 16;
                } else {
                    contentChangeType = 32;
                }
                v.X(pane, contentChangeType);
                this.f477b.put(pane, Boolean.valueOf(newVisibility));
            }
        }

        public final void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f482a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public WeakHashMap<View, Boolean> f483b = null;
        public SparseArray<WeakReference<View>> c = null;
        public WeakReference<KeyEvent> d = null;

        public final SparseArray<WeakReference<View>> d() {
            if (this.c == null) {
                this.c = new SparseArray<>();
            }
            return this.c;
        }

        public static l a(View root) {
            l manager = (l) root.getTag(R.id.tag_unhandled_key_event_manager);
            if (manager == null) {
                l manager2 = new l();
                root.setTag(R.id.tag_unhandled_key_event_manager, manager2);
                return manager2;
            }
            return manager;
        }

        public boolean b(View root, KeyEvent event) {
            if (event.getAction() == 0) {
                g();
            }
            View consumer = c(root, event);
            if (event.getAction() == 0) {
                int keycode = event.getKeyCode();
                if (consumer != null && !KeyEvent.isModifierKey(keycode)) {
                    d().put(keycode, new WeakReference<>(consumer));
                }
            }
            return consumer != null;
        }

        public final View c(View view, KeyEvent event) {
            WeakHashMap<View, Boolean> weakHashMap = this.f483b;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                for (int i = vg.getChildCount() - 1; i >= 0; i--) {
                    View v = vg.getChildAt(i);
                    View consumer = c(v, event);
                    if (consumer != null) {
                        return consumer;
                    }
                }
            }
            if (e(view, event)) {
                return view;
            }
            return null;
        }

        public boolean f(KeyEvent event) {
            int idx;
            WeakReference<KeyEvent> weakReference = this.d;
            if (weakReference != null && weakReference.get() == event) {
                return false;
            }
            this.d = new WeakReference<>(event);
            WeakReference<View> currentReceiver = null;
            SparseArray<WeakReference<View>> capturedKeys = d();
            if (event.getAction() == 1 && (idx = capturedKeys.indexOfKey(event.getKeyCode())) >= 0) {
                currentReceiver = capturedKeys.valueAt(idx);
                capturedKeys.removeAt(idx);
            }
            if (currentReceiver == null) {
                currentReceiver = capturedKeys.get(event.getKeyCode());
            }
            if (currentReceiver == null) {
                return false;
            }
            View target = currentReceiver.get();
            if (target != null && v.S(target)) {
                e(target, event);
            }
            return true;
        }

        public final boolean e(View v, KeyEvent event) {
            ArrayList<ViewCompat.OnUnhandledKeyEventListenerCompat> viewListeners = (ArrayList) v.getTag(R.id.tag_unhandled_key_listeners);
            if (viewListeners != null) {
                for (int i = viewListeners.size() - 1; i >= 0; i--) {
                    if (((k) viewListeners.get(i)).a(v, event)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        public final void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f483b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f482a;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f483b == null) {
                    this.f483b = new WeakHashMap<>();
                }
                for (int i = arrayList.size() - 1; i >= 0; i--) {
                    ArrayList<WeakReference<View>> arrayList2 = f482a;
                    WeakReference<View> vw = arrayList2.get(i);
                    View v = vw.get();
                    if (v == null) {
                        arrayList2.remove(i);
                    } else {
                        this.f483b.put(v, Boolean.TRUE);
                        for (ViewParent nxt = v.getParent(); nxt instanceof View; nxt = nxt.getParent()) {
                            this.f483b.put((View) nxt, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h {
        public static d0 c(View v) {
            return d0.a.a(v);
        }

        public static d0 b(View v, d0 insets, Rect outLocalInsets) {
            WindowInsets platformInsets = insets.r();
            if (platformInsets != null) {
                return d0.t(v.computeSystemWindowInsets(platformInsets, outLocalInsets), v);
            }
            outLocalInsets.setEmpty();
            return insets;
        }

        public static void d(View v, q listener) {
            if (Build.VERSION.SDK_INT < 30) {
                v.setTag(R.id.tag_on_apply_window_listener, listener);
            }
            if (listener == null) {
                View.OnApplyWindowInsetsListener compatInsetsAnimationCallback = (View.OnApplyWindowInsetsListener) v.getTag(R.id.tag_window_insets_animation_callback);
                v.setOnApplyWindowInsetsListener(compatInsetsAnimationCallback);
            } else {
                v.setOnApplyWindowInsetsListener(new a(v, listener));
            }
        }

        /* loaded from: classes.dex */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            public d0 f480a = null;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f481b;
            public final /* synthetic */ q c;

            public a(View view, q qVar) {
                this.f481b = view;
                this.c = qVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                d0 compatInsets = d0.t(insets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    h.a(insets, this.f481b);
                    if (compatInsets.equals(this.f480a)) {
                        return this.c.a(view, compatInsets).r();
                    }
                }
                this.f480a = compatInsets;
                d0 compatInsets2 = this.c.a(view, compatInsets);
                if (i >= 30) {
                    return compatInsets2.r();
                }
                v.l0(view);
                return compatInsets2.r();
            }
        }

        public static void a(WindowInsets insets, View v) {
            View.OnApplyWindowInsetsListener insetsAnimationCallback = (View.OnApplyWindowInsetsListener) v.getTag(R.id.tag_window_insets_animation_callback);
            if (insetsAnimationCallback != null) {
                insetsAnimationCallback.onApplyWindowInsets(v, insets);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i {
        public static d0 a(View v) {
            WindowInsets wi = v.getRootWindowInsets();
            if (wi == null) {
                return null;
            }
            d0 insets = d0.s(wi);
            insets.p(insets);
            insets.d(v.getRootView());
            return insets;
        }
    }

    /* loaded from: classes.dex */
    public static class j {
        public static void a(View view, Context context, int[] styleable, AttributeSet attrs, TypedArray t, int defStyleAttr, int defStyleRes) {
            view.saveAttributeDataForStyleable(context, styleable, attrs, t, defStyleAttr, defStyleRes);
        }
    }
}
