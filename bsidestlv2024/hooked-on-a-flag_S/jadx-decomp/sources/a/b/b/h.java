package a.b.b;

import a.b.g.a0;
import a.b.g.c0;
import a.b.g.o;
import a.b.g.p;
import a.b.g.s;
import a.b.g.t;
import a.b.g.u0;
import a.b.g.v;
import a.b.g.x;
import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.IBulkCursor;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?>[] f39a = {Context.class, AttributeSet.class};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f40b = {R.attr.onClick};
    public static final String[] c = {"android.widget.", "android.view.", "android.webkit."};
    public static final a.e.g<String, Constructor<? extends View>> d = new a.e.g<>();
    public final Object[] e = new Object[2];

    public final View q(View parent, String name, Context context, AttributeSet attrs, boolean inheritContext, boolean readAndroidTheme, boolean readAppTheme, boolean wrapContext) {
        View view;
        if (inheritContext && parent != null) {
            context = parent.getContext();
        }
        if (readAndroidTheme || readAppTheme) {
            context = t(context, attrs, readAndroidTheme, readAppTheme);
        }
        if (wrapContext) {
            context = u0.b(context);
        }
        char c2 = 65535;
        switch (name.hashCode()) {
            case -1946472170:
                if (name.equals("RatingBar")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1455429095:
                if (name.equals("CheckedTextView")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -1346021293:
                if (name.equals("MultiAutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -938935918:
                if (name.equals("TextView")) {
                    c2 = 0;
                    break;
                }
                break;
            case -937446323:
                if (name.equals("ImageButton")) {
                    c2 = 5;
                    break;
                }
                break;
            case -658531749:
                if (name.equals("SeekBar")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -339785223:
                if (name.equals("Spinner")) {
                    c2 = 4;
                    break;
                }
                break;
            case 776382189:
                if (name.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 799298502:
                if (name.equals("ToggleButton")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 1125864064:
                if (name.equals("ImageView")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1413872058:
                if (name.equals("AutoCompleteTextView")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1601505219:
                if (name.equals("CheckBox")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1666676343:
                if (name.equals("EditText")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2001146706:
                if (name.equals("Button")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                view = n(context, attrs);
                u(view, name);
                break;
            case 1:
                view = h(context, attrs);
                u(view, name);
                break;
            case 2:
                view = c(context, attrs);
                u(view, name);
                break;
            case 3:
                view = f(context, attrs);
                u(view, name);
                break;
            case 4:
                view = m(context, attrs);
                u(view, name);
                break;
            case 5:
                view = g(context, attrs);
                u(view, name);
                break;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                view = d(context, attrs);
                u(view, name);
                break;
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                view = j(context, attrs);
                u(view, name);
                break;
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                view = e(context, attrs);
                u(view, name);
                break;
            case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                view = b(context, attrs);
                u(view, name);
                break;
            case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                view = i(context, attrs);
                u(view, name);
                break;
            case IBulkCursor.RESPOND_TRANSACTION /* 11 */:
                view = k(context, attrs);
                u(view, name);
                break;
            case IBulkCursor.CLOSE_TRANSACTION /* 12 */:
                view = l(context, attrs);
                u(view, name);
                break;
            case '\r':
                view = o(context, attrs);
                u(view, name);
                break;
            default:
                view = p();
                break;
        }
        if (view == null && context != context) {
            view = s(context, name, attrs);
        }
        if (view != null) {
            a(view, attrs);
        }
        return view;
    }

    public a0 n(Context context, AttributeSet attrs) {
        return new a0(context, attrs);
    }

    public o h(Context context, AttributeSet attrs) {
        return new o(context, attrs);
    }

    public a.b.g.f c(Context context, AttributeSet attrs) {
        return new a.b.g.f(context, attrs);
    }

    public a.b.g.k f(Context context, AttributeSet attrs) {
        return new a.b.g.k(context, attrs);
    }

    public x m(Context context, AttributeSet attrs) {
        return new x(context, attrs);
    }

    public a.b.g.m g(Context context, AttributeSet attrs) {
        return new a.b.g.m(context, attrs);
    }

    public a.b.g.g d(Context context, AttributeSet attrs) {
        return new a.b.g.g(context, attrs);
    }

    public s j(Context context, AttributeSet attrs) {
        return new s(context, attrs);
    }

    public a.b.g.h e(Context context, AttributeSet attrs) {
        return new a.b.g.h(context, attrs);
    }

    public a.b.g.d b(Context context, AttributeSet attrs) {
        return new a.b.g.d(context, attrs);
    }

    public p i(Context context, AttributeSet attrs) {
        return new p(context, attrs);
    }

    public t k(Context context, AttributeSet attrs) {
        return new t(context, attrs);
    }

    public v l(Context context, AttributeSet attrs) {
        return new v(context, attrs);
    }

    public c0 o(Context context, AttributeSet attrs) {
        return new c0(context, attrs);
    }

    public final void u(View view, String name) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + name + ">, but returned null");
        }
    }

    public View p() {
        return null;
    }

    public final View s(Context context, String name, AttributeSet attrs) {
        if (name.equals("view")) {
            name = attrs.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.e;
            objArr[0] = context;
            objArr[1] = attrs;
            if (-1 != name.indexOf(46)) {
                return r(context, name, null);
            }
            int i = 0;
            while (true) {
                String[] strArr = c;
                if (i >= strArr.length) {
                    return null;
                }
                View view = r(context, name, strArr[i]);
                if (view != null) {
                    return view;
                }
                i++;
            }
        } catch (Exception e) {
            return null;
        } finally {
            Object[] objArr2 = this.e;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    public final void a(View view, AttributeSet attrs) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper) || !a.h.k.v.O(view)) {
            return;
        }
        TypedArray a2 = context.obtainStyledAttributes(attrs, f40b);
        String handlerName = a2.getString(0);
        if (handlerName != null) {
            view.setOnClickListener(new a(view, handlerName));
        }
        a2.recycle();
    }

    public final View r(Context context, String name, String prefix) {
        String str;
        a.e.g<String, Constructor<? extends View>> gVar = d;
        Constructor<? extends View> constructor = gVar.get(name);
        if (constructor == null) {
            if (prefix != null) {
                try {
                    str = prefix + name;
                } catch (Exception e) {
                    return null;
                }
            } else {
                str = name;
            }
            constructor = Class.forName(str, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f39a);
            gVar.put(name, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.e);
    }

    public static Context t(Context context, AttributeSet attrs, boolean useAndroidTheme, boolean useAppTheme) {
        TypedArray a2 = context.obtainStyledAttributes(attrs, a.b.a.x, 0, 0);
        int themeId = 0;
        if (useAndroidTheme) {
            int[] iArr = a.b.a.f11a;
            themeId = a2.getResourceId(0, 0);
        }
        if (useAppTheme && themeId == 0) {
            int[] iArr2 = a.b.a.f11a;
            themeId = a2.getResourceId(4, 0);
            if (themeId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        a2.recycle();
        if (themeId != 0) {
            if (!(context instanceof a.b.f.d) || ((a.b.f.d) context).c() != themeId) {
                return new a.b.f.d(context, themeId);
            }
            return context;
        }
        return context;
    }

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final View f41b;
        public final String c;
        public Method d;
        public Context e;

        public a(View hostView, String methodName) {
            this.f41b = hostView;
            this.c = methodName;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (this.d == null) {
                a(this.f41b.getContext());
            }
            try {
                this.d.invoke(this.e, v);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        public final void a(Context context) {
            String idText;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.c, View.class)) != null) {
                        this.d = method;
                        this.e = context;
                        return;
                    }
                } catch (NoSuchMethodException e) {
                }
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    context = null;
                }
            }
            int id = this.f41b.getId();
            if (id == -1) {
                idText = BuildConfig.FLAVOR;
            } else {
                idText = " with id '" + this.f41b.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.c + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f41b.getClass() + idText);
        }
    }
}
