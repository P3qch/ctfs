package a.h.d;

import a.h.c.c.c;
import a.h.h.f;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class e extends j {

    /* renamed from: b, reason: collision with root package name */
    public static Class<?> f372b;
    public static Constructor<?> c;
    public static Method d;
    public static Method e;
    public static boolean f = false;

    public static void n() {
        Class<?> fontFamilyClass;
        Constructor<?> fontFamilyCtor;
        Method addFontMethod;
        Method createFromFamiliesWithDefaultMethod;
        if (f) {
            return;
        }
        f = true;
        try {
            fontFamilyClass = Class.forName("android.graphics.FontFamily");
            fontFamilyCtor = fontFamilyClass.getConstructor(new Class[0]);
            addFontMethod = fontFamilyClass.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            Object familyArray = Array.newInstance(fontFamilyClass, 1);
            createFromFamiliesWithDefaultMethod = Typeface.class.getMethod("createFromFamiliesWithDefault", familyArray.getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            fontFamilyClass = null;
            fontFamilyCtor = null;
            addFontMethod = null;
            createFromFamiliesWithDefaultMethod = null;
        }
        c = fontFamilyCtor;
        f372b = fontFamilyClass;
        d = addFontMethod;
        e = createFromFamiliesWithDefaultMethod;
    }

    public final File m(ParcelFileDescriptor fd) {
        try {
            String path = Os.readlink("/proc/self/fd/" + fd.getFd());
            if (!OsConstants.S_ISREG(Os.stat(path).st_mode)) {
                return null;
            }
            return new File(path);
        } catch (ErrnoException e2) {
            return null;
        }
    }

    public static Object o() {
        n();
        try {
            return c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Typeface l(Object family) {
        n();
        try {
            Object familyArray = Array.newInstance(f372b, 1);
            Array.set(familyArray, 0, family);
            return (Typeface) e.invoke(null, familyArray);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean k(Object family, String name, int weight, boolean style) {
        n();
        try {
            Boolean result = (Boolean) d.invoke(family, name, Integer.valueOf(weight), Boolean.valueOf(style));
            return result.booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // a.h.d.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] fonts, int style) {
        if (fonts.length < 1) {
            return null;
        }
        f.b bestFont = h(fonts, style);
        ContentResolver resolver = context.getContentResolver();
        try {
            ParcelFileDescriptor pfd = resolver.openFileDescriptor(bestFont.d(), "r", cancellationSignal);
            if (pfd == null) {
                if (pfd != null) {
                    pfd.close();
                }
                return null;
            }
            try {
                File file = m(pfd);
                if (file != null && file.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(file);
                    pfd.close();
                    return createFromFile;
                }
                FileInputStream fis = new FileInputStream(pfd.getFileDescriptor());
                try {
                    Typeface d2 = d(context, fis);
                    fis.close();
                    pfd.close();
                    return d2;
                } catch (Throwable th) {
                    try {
                        fis.close();
                    } catch (Throwable th2) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    pfd.close();
                } catch (Throwable th4) {
                }
                throw th3;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    @Override // a.h.d.j
    public Typeface b(Context context, c.b entry, Resources resources, int style) {
        Object family = o();
        for (c.C0019c e2 : entry.a()) {
            File tmpFile = k.e(context);
            if (tmpFile == null) {
                return null;
            }
            try {
                if (!k.c(tmpFile, resources, e2.b())) {
                    return null;
                }
                if (!k(family, tmpFile.getPath(), e2.e(), e2.f())) {
                    return null;
                }
                tmpFile.delete();
            } catch (RuntimeException e3) {
                return null;
            } finally {
                tmpFile.delete();
            }
        }
        return l(family);
    }
}
