package a.f.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import net.sqlcipher.IBulkCursor;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f303a;

    /* renamed from: b, reason: collision with root package name */
    public String f304b;
    public EnumC0014a c;
    public int d;
    public float e;
    public String f;
    public boolean g;
    public int h;

    /* renamed from: a.f.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0014a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public a(String name, EnumC0014a attributeType, Object value, boolean method) {
        this.f303a = false;
        this.f304b = name;
        this.c = attributeType;
        this.f303a = method;
        d(value);
    }

    public a(a source, Object value) {
        this.f303a = false;
        this.f304b = source.f304b;
        this.c = source.c;
        d(value);
    }

    public void d(Object value) {
        switch (this.c.ordinal()) {
            case 0:
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                this.d = ((Integer) value).intValue();
                return;
            case 1:
                this.e = ((Float) value).floatValue();
                return;
            case 2:
            case 3:
                this.h = ((Integer) value).intValue();
                return;
            case 4:
                this.f = (String) value;
                return;
            case 5:
                this.g = ((Boolean) value).booleanValue();
                return;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                this.e = ((Float) value).floatValue();
                return;
            default:
                return;
        }
    }

    public static HashMap<String, a> a(HashMap<String, a> hashMap, View view) {
        HashMap<String, a> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String name : hashMap.keySet()) {
            a constraintAttribute = hashMap.get(name);
            try {
                if (name.equals("BackgroundColor")) {
                    ColorDrawable viewColor = (ColorDrawable) view.getBackground();
                    Object val = Integer.valueOf(viewColor.getColor());
                    hashMap2.put(name, new a(constraintAttribute, val));
                } else {
                    Method method = cls.getMethod("getMap" + name, new Class[0]);
                    Object val2 = method.invoke(view, new Object[0]);
                    hashMap2.put(name, new a(constraintAttribute, val2));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return hashMap2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0042. Please report as an issue. */
    public static void c(View view, HashMap<String, a> hashMap) {
        Class<?> cls = view.getClass();
        for (String name : hashMap.keySet()) {
            a constraintAttribute = hashMap.get(name);
            String methodName = name;
            if (!constraintAttribute.f303a) {
                methodName = "set" + methodName;
            }
            try {
                switch (constraintAttribute.c.ordinal()) {
                    case 0:
                        Method method = cls.getMethod(methodName, Integer.TYPE);
                        method.invoke(view, Integer.valueOf(constraintAttribute.d));
                        break;
                    case 1:
                        Method method2 = cls.getMethod(methodName, Float.TYPE);
                        method2.invoke(view, Float.valueOf(constraintAttribute.e));
                        break;
                    case 2:
                        Method method3 = cls.getMethod(methodName, Integer.TYPE);
                        method3.invoke(view, Integer.valueOf(constraintAttribute.h));
                        break;
                    case 3:
                        Method method4 = cls.getMethod(methodName, Drawable.class);
                        ColorDrawable drawable = new ColorDrawable();
                        drawable.setColor(constraintAttribute.h);
                        method4.invoke(view, drawable);
                        break;
                    case 4:
                        Method method5 = cls.getMethod(methodName, CharSequence.class);
                        method5.invoke(view, constraintAttribute.f);
                        break;
                    case 5:
                        Method method6 = cls.getMethod(methodName, Boolean.TYPE);
                        method6.invoke(view, Boolean.valueOf(constraintAttribute.g));
                        break;
                    case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                        Method method7 = cls.getMethod(methodName, Float.TYPE);
                        method7.invoke(view, Float.valueOf(constraintAttribute.e));
                        break;
                    case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                        Method method8 = cls.getMethod(methodName, Integer.TYPE);
                        method8.invoke(view, Integer.valueOf(constraintAttribute.d));
                        break;
                }
            } catch (IllegalAccessException e) {
                Log.e("TransitionLayout", " Custom Attribute \"" + name + "\" not found on " + cls.getName());
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Log.e("TransitionLayout", e2.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + name + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(methodName);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e3) {
                Log.e("TransitionLayout", " Custom Attribute \"" + name + "\" not found on " + cls.getName());
                e3.printStackTrace();
            }
        }
    }

    public static void b(Context context, XmlPullParser parser, HashMap<String, a> hashMap) {
        AttributeSet attributeSet = Xml.asAttributeSet(parser);
        TypedArray a2 = context.obtainStyledAttributes(attributeSet, i.e);
        String name = null;
        boolean method = false;
        Object value = null;
        EnumC0014a type = null;
        int N = a2.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a2.getIndex(i);
            int[] iArr = i.f329a;
            if (attr == 0) {
                name = a2.getString(attr);
                if (name != null && name.length() > 0) {
                    name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
                }
            } else if (attr == 10) {
                method = true;
                name = a2.getString(attr);
            } else if (attr == 1) {
                value = Boolean.valueOf(a2.getBoolean(attr, false));
                type = EnumC0014a.BOOLEAN_TYPE;
            } else if (attr == 3) {
                type = EnumC0014a.COLOR_TYPE;
                value = Integer.valueOf(a2.getColor(attr, 0));
            } else if (attr == 2) {
                type = EnumC0014a.COLOR_DRAWABLE_TYPE;
                value = Integer.valueOf(a2.getColor(attr, 0));
            } else if (attr == 7) {
                type = EnumC0014a.DIMENSION_TYPE;
                value = Float.valueOf(TypedValue.applyDimension(1, a2.getDimension(attr, 0.0f), context.getResources().getDisplayMetrics()));
            } else if (attr == 4) {
                type = EnumC0014a.DIMENSION_TYPE;
                value = Float.valueOf(a2.getDimension(attr, 0.0f));
            } else if (attr == 5) {
                type = EnumC0014a.FLOAT_TYPE;
                value = Float.valueOf(a2.getFloat(attr, Float.NaN));
            } else if (attr == 6) {
                type = EnumC0014a.INT_TYPE;
                value = Integer.valueOf(a2.getInteger(attr, -1));
            } else if (attr == 9) {
                type = EnumC0014a.STRING_TYPE;
                value = a2.getString(attr);
            } else if (attr == 8) {
                type = EnumC0014a.REFERENCE_TYPE;
                int tmp = a2.getResourceId(attr, -1);
                if (tmp == -1) {
                    tmp = a2.getInt(attr, -1);
                }
                value = Integer.valueOf(tmp);
            }
        }
        if (name != null && value != null) {
            hashMap.put(name, new a(name, type, value, method));
        }
        a2.recycle();
    }
}
