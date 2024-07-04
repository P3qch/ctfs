package a.h.d;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class h extends g {
    @Override // a.h.d.g
    public Typeface l(Object family) {
        try {
            Object familyArray = Array.newInstance(this.g, 1);
            Array.set(familyArray, 0, family);
            return (Typeface) this.m.invoke(null, familyArray, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // a.h.d.g
    public Method x(Class<?> fontFamily) {
        Object familyArray = Array.newInstance(fontFamily, 1);
        Class cls = Integer.TYPE;
        Method m = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", familyArray.getClass(), String.class, cls, cls);
        m.setAccessible(true);
        return m;
    }
}
