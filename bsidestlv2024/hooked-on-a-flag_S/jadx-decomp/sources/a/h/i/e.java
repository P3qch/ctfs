package a.h.i;

import java.util.Locale;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a.h.i.d f420a = new C0027e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final a.h.i.d f421b = new C0027e(null, true);
    public static final a.h.i.d c;
    public static final a.h.i.d d;

    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    static {
        b bVar = b.f424a;
        c = new C0027e(bVar, false);
        d = new C0027e(bVar, true);
        new C0027e(a.f422a, false);
        f fVar = f.f427b;
    }

    public static int a(int directionality) {
        switch (directionality) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    public static int b(int directionality) {
        switch (directionality) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
            case 17:
                return 0;
            default:
                return 2;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d implements a.h.i.d {

        /* renamed from: a, reason: collision with root package name */
        public final c f425a;

        public abstract boolean a();

        public d(c algorithm) {
            this.f425a = algorithm;
        }

        public boolean c(CharSequence cs, int start, int count) {
            if (cs == null || start < 0 || count < 0 || cs.length() - count < start) {
                throw new IllegalArgumentException();
            }
            if (this.f425a == null) {
                return a();
            }
            return b(cs, start, count);
        }

        public final boolean b(CharSequence cs, int start, int count) {
            switch (this.f425a.a(cs, start, count)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return a();
            }
        }
    }

    /* renamed from: a.h.i.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027e extends d {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f426b;

        public C0027e(c algorithm, boolean defaultIsRtl) {
            super(algorithm);
            this.f426b = defaultIsRtl;
        }

        @Override // a.h.i.e.d
        public boolean a() {
            return this.f426b;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f424a = new b();

        @Override // a.h.i.e.c
        public int a(CharSequence cs, int start, int count) {
            int result = 2;
            int e = start + count;
            for (int i = start; i < e && result == 2; i++) {
                result = e.b(Character.getDirectionality(cs.charAt(i)));
            }
            return result;
        }
    }

    /* loaded from: classes.dex */
    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f422a = new a(true);

        /* renamed from: b, reason: collision with root package name */
        public final boolean f423b;

        @Override // a.h.i.e.c
        public int a(CharSequence cs, int start, int count) {
            boolean haveUnlookedFor = false;
            int e = start + count;
            for (int i = start; i < e; i++) {
                switch (e.a(Character.getDirectionality(cs.charAt(i)))) {
                    case 0:
                        return 0;
                    case 1:
                        haveUnlookedFor = true;
                        break;
                }
            }
            if (haveUnlookedFor) {
                return 1;
            }
            return 2;
        }

        public a(boolean lookForRtl) {
            this.f423b = lookForRtl;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends d {

        /* renamed from: b, reason: collision with root package name */
        public static final f f427b = new f();

        public f() {
            super(null);
        }

        @Override // a.h.i.e.d
        public boolean a() {
            int dir = a.h.i.f.b(Locale.getDefault());
            return dir == 1;
        }
    }
}
