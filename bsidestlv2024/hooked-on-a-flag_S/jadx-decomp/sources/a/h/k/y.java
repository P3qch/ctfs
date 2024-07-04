package a.h.k;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public final class y {
    @Deprecated
    public static boolean h(ViewParent parent, View child, AccessibilityEvent event) {
        return parent.requestSendAccessibilityEvent(child, event);
    }

    public static boolean f(ViewParent parent, View child, View target, int nestedScrollAxes, int type) {
        if (parent instanceof m) {
            return ((m) parent).o(child, target, nestedScrollAxes, type);
        }
        if (type == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return parent.onStartNestedScroll(child, target, nestedScrollAxes);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                    return false;
                }
            }
            if (parent instanceof o) {
                return ((o) parent).onStartNestedScroll(child, target, nestedScrollAxes);
            }
            return false;
        }
        return false;
    }

    public static void e(ViewParent parent, View child, View target, int nestedScrollAxes, int type) {
        if (parent instanceof m) {
            ((m) parent).i(child, target, nestedScrollAxes, type);
            return;
        }
        if (type == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    parent.onNestedScrollAccepted(child, target, nestedScrollAxes);
                    return;
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e);
                    return;
                }
            }
            if (parent instanceof o) {
                ((o) parent).onNestedScrollAccepted(child, target, nestedScrollAxes);
            }
        }
    }

    public static void g(ViewParent parent, View target, int type) {
        if (parent instanceof m) {
            ((m) parent).m(target, type);
            return;
        }
        if (type == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    parent.onStopNestedScroll(target);
                    return;
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStopNestedScroll", e);
                    return;
                }
            }
            if (parent instanceof o) {
                ((o) parent).onStopNestedScroll(target);
            }
        }
    }

    public static void d(ViewParent parent, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (parent instanceof n) {
            ((n) parent).k(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
            return;
        }
        consumed[0] = consumed[0] + dxUnconsumed;
        consumed[1] = consumed[1] + dyUnconsumed;
        if (parent instanceof m) {
            ((m) parent).l(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
            return;
        }
        if (type == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    parent.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
                    return;
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScroll", e);
                    return;
                }
            }
            if (parent instanceof o) {
                ((o) parent).onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
            }
        }
    }

    public static void c(ViewParent parent, View target, int dx, int dy, int[] consumed, int type) {
        if (parent instanceof m) {
            ((m) parent).n(target, dx, dy, consumed, type);
            return;
        }
        if (type == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    parent.onNestedPreScroll(target, dx, dy, consumed);
                    return;
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedPreScroll", e);
                    return;
                }
            }
            if (parent instanceof o) {
                ((o) parent).onNestedPreScroll(target, dx, dy, consumed);
            }
        }
    }

    public static boolean a(ViewParent parent, View target, float velocityX, float velocityY, boolean consumed) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return parent.onNestedFling(target, velocityX, velocityY, consumed);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedFling", e);
                return false;
            }
        }
        if (parent instanceof o) {
            return ((o) parent).onNestedFling(target, velocityX, velocityY, consumed);
        }
        return false;
    }

    public static boolean b(ViewParent parent, View target, float velocityX, float velocityY) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return parent.onNestedPreFling(target, velocityX, velocityY);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        }
        if (parent instanceof o) {
            return ((o) parent).onNestedPreFling(target, velocityX, velocityY);
        }
        return false;
    }
}
