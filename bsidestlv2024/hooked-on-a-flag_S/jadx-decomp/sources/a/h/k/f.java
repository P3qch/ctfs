package a.h.k;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f459a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Method f460b = null;
    public static boolean c = false;
    public static Field d = null;

    /* loaded from: classes.dex */
    public interface a {
        boolean i(KeyEvent keyEvent);
    }

    public static boolean d(View root, KeyEvent event) {
        return v.j(root, event);
    }

    public static boolean e(a component, View root, Window.Callback callback, KeyEvent event) {
        if (component == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return component.i(event);
        }
        if (callback instanceof Activity) {
            return b((Activity) callback, event);
        }
        if (callback instanceof Dialog) {
            return c((Dialog) callback, event);
        }
        return (root != null && v.i(root, event)) || component.i(event);
    }

    public static boolean a(ActionBar actionBar, KeyEvent event) {
        if (!f459a) {
            try {
                f460b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException e) {
            }
            f459a = true;
        }
        Method method = f460b;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, event)).booleanValue();
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
        return false;
    }

    public static boolean b(Activity activity, KeyEvent event) {
        activity.onUserInteraction();
        Window win = activity.getWindow();
        if (win.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            int keyCode = event.getKeyCode();
            if (keyCode == 82 && actionBar != null && a(actionBar, event)) {
                return true;
            }
        }
        if (win.superDispatchKeyEvent(event)) {
            return true;
        }
        View decor = win.getDecorView();
        if (v.i(decor, event)) {
            return true;
        }
        return event.dispatch(activity, decor != null ? decor.getKeyDispatcherState() : null, activity);
    }

    public static DialogInterface.OnKeyListener f(Dialog dialog) {
        if (!c) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            c = true;
        }
        Field field = d;
        if (field != null) {
            try {
                return (DialogInterface.OnKeyListener) field.get(dialog);
            } catch (IllegalAccessException e2) {
                return null;
            }
        }
        return null;
    }

    public static boolean c(Dialog dialog, KeyEvent event) {
        DialogInterface.OnKeyListener onKeyListener = f(dialog);
        if (onKeyListener != null && onKeyListener.onKey(dialog, event.getKeyCode(), event)) {
            return true;
        }
        Window win = dialog.getWindow();
        if (win.superDispatchKeyEvent(event)) {
            return true;
        }
        View decor = win.getDecorView();
        if (v.i(decor, event)) {
            return true;
        }
        return event.dispatch(dialog, decor != null ? decor.getKeyDispatcherState() : null, dialog);
    }
}
