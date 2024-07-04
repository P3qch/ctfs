package a.h.d;

import a.h.c.c.c;
import a.h.h.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public ConcurrentHashMap<Long, c.b> f374a = new ConcurrentHashMap<>();

    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    /* JADX WARN: Generic types in debug info not equals: a.h.d.j$c != androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor<T> */
    public static <T> T g(T[] fonts, int style, c<T> cVar) {
        int targetWeight = (style & 1) == 0 ? 400 : 700;
        boolean isTargetItalic = (style & 2) != 0;
        T best = null;
        int bestScore = Integer.MAX_VALUE;
        for (T font : fonts) {
            int score = (Math.abs(cVar.a(font) - targetWeight) * 2) + (cVar.b(font) == isTargetItalic ? 0 : 1);
            if (best == null || bestScore > score) {
                best = font;
                bestScore = score;
            }
        }
        return best;
    }

    public static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field field = Typeface.class.getDeclaredField("native_instance");
            field.setAccessible(true);
            Number num = (Number) field.get(typeface);
            return num.longValue();
        } catch (IllegalAccessException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    /* loaded from: classes.dex */
    public class a implements c<f.b> {
        public a(j this$0) {
        }

        @Override // a.h.d.j.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(f.b info) {
            return info.e();
        }

        @Override // a.h.d.j.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(f.b info) {
            return info.f();
        }
    }

    public f.b h(f.b[] fonts, int style) {
        return (f.b) g(fonts, style, new a(this));
    }

    public Typeface d(Context context, InputStream is) {
        File tmpFile = k.e(context);
        if (tmpFile == null) {
            return null;
        }
        try {
            if (k.d(tmpFile, is)) {
                return Typeface.createFromFile(tmpFile.getPath());
            }
            return null;
        } catch (RuntimeException e) {
            return null;
        } finally {
            tmpFile.delete();
        }
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] fonts, int style) {
        if (fonts.length < 1) {
            return null;
        }
        f.b font = h(fonts, style);
        InputStream is = null;
        try {
            is = context.getContentResolver().openInputStream(font.d());
            return d(context, is);
        } catch (IOException e) {
            return null;
        } finally {
            k.a(is);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c<c.C0019c> {
        public b(j this$0) {
        }

        @Override // a.h.d.j.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(c.C0019c entry) {
            return entry.e();
        }

        @Override // a.h.d.j.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(c.C0019c entry) {
            return entry.f();
        }
    }

    public final c.C0019c f(c.b entry, int style) {
        return (c.C0019c) g(entry.a(), style, new b(this));
    }

    public Typeface b(Context context, c.b entry, Resources resources, int style) {
        c.C0019c best = f(entry, style);
        if (best == null) {
            return null;
        }
        Typeface typeface = d.d(context, resources, best.b(), best.a(), style);
        a(typeface, entry);
        return typeface;
    }

    public Typeface e(Context context, Resources resources, int id, String path, int style) {
        File tmpFile = k.e(context);
        if (tmpFile == null) {
            return null;
        }
        try {
            if (k.c(tmpFile, resources, id)) {
                return Typeface.createFromFile(tmpFile.getPath());
            }
            return null;
        } catch (RuntimeException e) {
            return null;
        } finally {
            tmpFile.delete();
        }
    }

    public c.b i(Typeface typeface) {
        long key = j(typeface);
        if (key == 0) {
            return null;
        }
        return this.f374a.get(Long.valueOf(key));
    }

    public final void a(Typeface typeface, c.b entry) {
        long key = j(typeface);
        if (key != 0) {
            this.f374a.put(Long.valueOf(key), entry);
        }
    }
}
