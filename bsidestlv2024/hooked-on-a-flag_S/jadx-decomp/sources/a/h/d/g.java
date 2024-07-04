package a.h.d;

import a.h.c.c.c;
import a.h.h.f;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes.dex */
public class g extends e {
    public final Class<?> g;
    public final Constructor<?> h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public g() {
        Class<?> fontFamily;
        Constructor<?> fontFamilyCtor;
        Method addFontFromAssetManager;
        Method addFontFromAssetManager2;
        Method addFontFromBuffer;
        Method freeze;
        Method abortCreation;
        try {
            fontFamily = y();
            fontFamilyCtor = z(fontFamily);
            addFontFromAssetManager = v(fontFamily);
            addFontFromAssetManager2 = w(fontFamily);
            addFontFromBuffer = A(fontFamily);
            freeze = u(fontFamily);
            abortCreation = x(fontFamily);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            fontFamily = null;
            fontFamilyCtor = null;
            addFontFromAssetManager = null;
            addFontFromAssetManager2 = null;
            addFontFromBuffer = null;
            freeze = null;
            abortCreation = null;
        }
        this.g = fontFamily;
        this.h = fontFamilyCtor;
        this.i = addFontFromAssetManager;
        this.j = addFontFromAssetManager2;
        this.k = addFontFromBuffer;
        this.l = freeze;
        this.m = abortCreation;
    }

    public final boolean t() {
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    private Object o() {
        try {
            return this.h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            return null;
        }
    }

    public final boolean q(Context context, Object family, String fileName, int ttcIndex, int weight, int style, FontVariationAxis[] axes) {
        try {
            return ((Boolean) this.i.invoke(family, context.getAssets(), fileName, 0, false, Integer.valueOf(ttcIndex), Integer.valueOf(weight), Integer.valueOf(style), axes)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public final boolean r(Object family, ByteBuffer buffer, int ttcIndex, int weight, int style) {
        try {
            return ((Boolean) this.j.invoke(family, buffer, Integer.valueOf(ttcIndex), null, Integer.valueOf(weight), Integer.valueOf(style))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public Typeface l(Object family) {
        try {
            Object familyArray = Array.newInstance(this.g, 1);
            Array.set(familyArray, 0, family);
            return (Typeface) this.m.invoke(null, familyArray, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    public final boolean s(Object family) {
        try {
            return ((Boolean) this.k.invoke(family, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public final void p(Object family) {
        try {
            this.l.invoke(family, new Object[0]);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
    }

    @Override // a.h.d.e, a.h.d.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        if (!t()) {
            return super.b(context, bVar, resources, i);
        }
        Object o = o();
        if (o == null) {
            return null;
        }
        for (c.C0019c c0019c : bVar.a()) {
            if (!q(context, o, c0019c.a(), c0019c.c(), c0019c.e(), c0019c.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0019c.d()))) {
                p(o);
                return null;
            }
        }
        if (!s(o)) {
            return null;
        }
        return l(o);
    }

    @Override // a.h.d.e, a.h.d.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        Typeface l;
        int i2;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!t()) {
            f.b h = h(bVarArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(h.d(), "r", cancellationSignal);
                if (openFileDescriptor != null) {
                    try {
                        Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(h.e()).setItalic(h.f()).build();
                        openFileDescriptor.close();
                        return build;
                    } finally {
                    }
                } else {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
            } catch (IOException e) {
                return null;
            }
        } else {
            Map<Uri, ByteBuffer> h2 = k.h(context, bVarArr, cancellationSignal);
            Object o = o();
            if (o == null) {
                return null;
            }
            int length = bVarArr.length;
            boolean z = false;
            int i3 = 0;
            while (i3 < length) {
                f.b bVar = bVarArr[i3];
                ByteBuffer byteBuffer = h2.get(bVar.d());
                if (byteBuffer == null) {
                    i2 = i3;
                } else {
                    i2 = i3;
                    if (!r(o, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                        p(o);
                        return null;
                    }
                    z = true;
                }
                i3 = i2 + 1;
                z = z;
            }
            if (!z) {
                p(o);
                return null;
            }
            if (s(o) && (l = l(o)) != null) {
                return Typeface.create(l, i);
            }
            return null;
        }
    }

    @Override // a.h.d.j
    public Typeface e(Context context, Resources resources, int id, String path, int style) {
        if (!t()) {
            return super.e(context, resources, id, path, style);
        }
        Object fontFamily = o();
        if (fontFamily == null) {
            return null;
        }
        if (!q(context, fontFamily, path, 0, -1, -1, null)) {
            p(fontFamily);
            return null;
        }
        if (!s(fontFamily)) {
            return null;
        }
        return l(fontFamily);
    }

    public Class<?> y() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor<?> z(Class<?> fontFamily) {
        return fontFamily.getConstructor(new Class[0]);
    }

    public Method v(Class<?> fontFamily) {
        Class<?> cls = Integer.TYPE;
        return fontFamily.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls, Boolean.TYPE, cls, cls, cls, FontVariationAxis[].class);
    }

    public Method w(Class<?> fontFamily) {
        Class<?> cls = Integer.TYPE;
        return fontFamily.getMethod("addFontFromBuffer", ByteBuffer.class, cls, FontVariationAxis[].class, cls, cls);
    }

    public Method A(Class<?> fontFamily) {
        return fontFamily.getMethod("freeze", new Class[0]);
    }

    public Method u(Class<?> fontFamily) {
        return fontFamily.getMethod("abortCreation", new Class[0]);
    }

    public Method x(Class<?> fontFamily) {
        Object familyArray = Array.newInstance(fontFamily, 1);
        Class cls = Integer.TYPE;
        Method m = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", familyArray.getClass(), cls, cls);
        m.setAccessible(true);
        return m;
    }
}
