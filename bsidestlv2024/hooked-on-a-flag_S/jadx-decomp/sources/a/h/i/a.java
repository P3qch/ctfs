package a.h.i;

import a.h.i.e;
import android.text.SpannableStringBuilder;
import java.util.Locale;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final d f408a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f409b;
    public static final String c;
    public static final a d;
    public static final a e;
    public final boolean f;
    public final int g;
    public final d h;

    static {
        d dVar = e.c;
        f408a = dVar;
        f409b = Character.toString((char) 8206);
        c = Character.toString((char) 8207);
        d = new a(false, 2, dVar);
        e = new a(true, 2, dVar);
    }

    /* renamed from: a.h.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0025a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f410a;

        /* renamed from: b, reason: collision with root package name */
        public int f411b;
        public d c;

        public C0025a() {
            c(a.e(Locale.getDefault()));
        }

        public final void c(boolean isRtlContext) {
            this.f410a = isRtlContext;
            this.c = a.f408a;
            this.f411b = 2;
        }

        public static a b(boolean isRtlContext) {
            return isRtlContext ? a.e : a.d;
        }

        public a a() {
            if (this.f411b == 2 && this.c == a.f408a) {
                return b(this.f410a);
            }
            return new a(this.f410a, this.f411b, this.c);
        }
    }

    public static a c() {
        return new C0025a().a();
    }

    public a(boolean isRtlContext, int flags, d heuristic) {
        this.f = isRtlContext;
        this.g = flags;
        this.h = heuristic;
    }

    public boolean d() {
        return (this.g & 2) != 0;
    }

    public final String f(CharSequence str, d heuristic) {
        boolean isRtl = ((e.d) heuristic).c(str, 0, str.length());
        if (!this.f && (isRtl || b(str) == 1)) {
            return f409b;
        }
        if (!this.f) {
            return BuildConfig.FLAVOR;
        }
        if (!isRtl || b(str) == -1) {
            return c;
        }
        return BuildConfig.FLAVOR;
    }

    public final String g(CharSequence str, d heuristic) {
        boolean isRtl = ((e.d) heuristic).c(str, 0, str.length());
        if (!this.f && (isRtl || a(str) == 1)) {
            return f409b;
        }
        if (!this.f) {
            return BuildConfig.FLAVOR;
        }
        if (!isRtl || a(str) == -1) {
            return c;
        }
        return BuildConfig.FLAVOR;
    }

    public String k(String str, d heuristic, boolean isolate) {
        if (str == null) {
            return null;
        }
        return i(str, heuristic, isolate).toString();
    }

    public CharSequence i(CharSequence str, d heuristic, boolean isolate) {
        if (str == null) {
            return null;
        }
        boolean isRtl = ((e.d) heuristic).c(str, 0, str.length());
        SpannableStringBuilder result = new SpannableStringBuilder();
        if (d() && isolate) {
            result.append((CharSequence) g(str, isRtl ? e.f421b : e.f420a));
        }
        if (isRtl != this.f) {
            result.append(isRtl ? (char) 8235 : (char) 8234);
            result.append(str);
            result.append((char) 8236);
        } else {
            result.append(str);
        }
        if (isolate) {
            result.append((CharSequence) f(str, isRtl ? e.f421b : e.f420a));
        }
        return result;
    }

    public String j(String str) {
        return k(str, this.h, true);
    }

    public CharSequence h(CharSequence str) {
        return i(str, this.h, true);
    }

    public static boolean e(Locale locale) {
        return f.b(locale) == 1;
    }

    public static int b(CharSequence str) {
        return new b(str, false).e();
    }

    public static int a(CharSequence str) {
        return new b(str, false).d();
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final byte[] f412a = new byte[1792];

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f413b;
        public final boolean c;
        public final int d;
        public int e;
        public char f;

        static {
            for (int i = 0; i < 1792; i++) {
                f412a[i] = Character.getDirectionality(i);
            }
        }

        public b(CharSequence text, boolean isHtml) {
            this.f413b = text;
            this.c = isHtml;
            this.d = text.length();
        }

        public int d() {
            this.e = 0;
            int embeddingLevel = 0;
            int embeddingLevelDir = 0;
            int firstNonEmptyEmbeddingLevel = 0;
            while (this.e < this.d && firstNonEmptyEmbeddingLevel == 0) {
                switch (b()) {
                    case 0:
                        if (embeddingLevel != 0) {
                            firstNonEmptyEmbeddingLevel = embeddingLevel;
                            break;
                        } else {
                            return -1;
                        }
                    case 1:
                    case 2:
                        if (embeddingLevel != 0) {
                            firstNonEmptyEmbeddingLevel = embeddingLevel;
                            break;
                        } else {
                            return 1;
                        }
                    case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                        break;
                    case 14:
                    case 15:
                        embeddingLevel++;
                        embeddingLevelDir = -1;
                        break;
                    case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                    case 17:
                        embeddingLevel++;
                        embeddingLevelDir = 1;
                        break;
                    case 18:
                        embeddingLevel--;
                        embeddingLevelDir = 0;
                        break;
                    default:
                        firstNonEmptyEmbeddingLevel = embeddingLevel;
                        break;
                }
            }
            if (firstNonEmptyEmbeddingLevel == 0) {
                return 0;
            }
            if (embeddingLevelDir != 0) {
                return embeddingLevelDir;
            }
            while (this.e > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (firstNonEmptyEmbeddingLevel != embeddingLevel) {
                            embeddingLevel--;
                            break;
                        } else {
                            return -1;
                        }
                    case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                    case 17:
                        if (firstNonEmptyEmbeddingLevel != embeddingLevel) {
                            embeddingLevel--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        embeddingLevel++;
                        break;
                }
            }
            return 0;
        }

        public int e() {
            this.e = this.d;
            int embeddingLevel = 0;
            int lastNonEmptyEmbeddingLevel = 0;
            while (this.e > 0) {
                switch (a()) {
                    case 0:
                        if (embeddingLevel != 0) {
                            if (lastNonEmptyEmbeddingLevel != 0) {
                                break;
                            } else {
                                lastNonEmptyEmbeddingLevel = embeddingLevel;
                                break;
                            }
                        } else {
                            return -1;
                        }
                    case 1:
                    case 2:
                        if (embeddingLevel != 0) {
                            if (lastNonEmptyEmbeddingLevel != 0) {
                                break;
                            } else {
                                lastNonEmptyEmbeddingLevel = embeddingLevel;
                                break;
                            }
                        } else {
                            return 1;
                        }
                    case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                        break;
                    case 14:
                    case 15:
                        if (lastNonEmptyEmbeddingLevel != embeddingLevel) {
                            embeddingLevel--;
                            break;
                        } else {
                            return -1;
                        }
                    case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                    case 17:
                        if (lastNonEmptyEmbeddingLevel != embeddingLevel) {
                            embeddingLevel--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        embeddingLevel++;
                        break;
                    default:
                        if (lastNonEmptyEmbeddingLevel != 0) {
                            break;
                        } else {
                            lastNonEmptyEmbeddingLevel = embeddingLevel;
                            break;
                        }
                }
            }
            return 0;
        }

        public static byte c(char c) {
            return c < 1792 ? f412a[c] : Character.getDirectionality(c);
        }

        public byte b() {
            char charAt = this.f413b.charAt(this.e);
            this.f = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePoint = Character.codePointAt(this.f413b, this.e);
                this.e += Character.charCount(codePoint);
                return Character.getDirectionality(codePoint);
            }
            this.e++;
            byte dirType = c(this.f);
            if (this.c) {
                char c = this.f;
                if (c == '<') {
                    return i();
                }
                if (c == '&') {
                    g();
                    return (byte) 12;
                }
                return dirType;
            }
            return dirType;
        }

        public byte a() {
            char charAt = this.f413b.charAt(this.e - 1);
            this.f = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePoint = Character.codePointBefore(this.f413b, this.e);
                this.e -= Character.charCount(codePoint);
                return Character.getDirectionality(codePoint);
            }
            this.e--;
            byte dirType = c(this.f);
            if (this.c) {
                char c = this.f;
                if (c == '>') {
                    return h();
                }
                if (c == ';') {
                    return f();
                }
                return dirType;
            }
            return dirType;
        }

        public final byte i() {
            char charAt;
            int initialCharIndex = this.e;
            while (true) {
                int i = this.e;
                if (i < this.d) {
                    CharSequence charSequence = this.f413b;
                    this.e = i + 1;
                    char charAt2 = charSequence.charAt(i);
                    this.f = charAt2;
                    if (charAt2 == '>') {
                        return (byte) 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        char quote = this.f;
                        do {
                            int i2 = this.e;
                            if (i2 < this.d) {
                                CharSequence charSequence2 = this.f413b;
                                this.e = i2 + 1;
                                charAt = charSequence2.charAt(i2);
                                this.f = charAt;
                            }
                        } while (charAt != quote);
                    }
                } else {
                    this.e = initialCharIndex;
                    this.f = '<';
                    return (byte) 13;
                }
            }
        }

        public final byte h() {
            char charAt;
            int initialCharIndex = this.e;
            while (true) {
                int i = this.e;
                if (i <= 0) {
                    break;
                }
                CharSequence charSequence = this.f413b;
                int i2 = i - 1;
                this.e = i2;
                char charAt2 = charSequence.charAt(i2);
                this.f = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    char quote = this.f;
                    do {
                        int i3 = this.e;
                        if (i3 > 0) {
                            CharSequence charSequence2 = this.f413b;
                            int i4 = i3 - 1;
                            this.e = i4;
                            charAt = charSequence2.charAt(i4);
                            this.f = charAt;
                        }
                    } while (charAt != quote);
                }
            }
            this.e = initialCharIndex;
            this.f = '>';
            return (byte) 13;
        }

        public final byte g() {
            char charAt;
            do {
                int i = this.e;
                if (i >= this.d) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f413b;
                this.e = i + 1;
                charAt = charSequence.charAt(i);
                this.f = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        public final byte f() {
            char charAt;
            int initialCharIndex = this.e;
            do {
                int i = this.e;
                if (i <= 0) {
                    break;
                }
                CharSequence charSequence = this.f413b;
                int i2 = i - 1;
                this.e = i2;
                charAt = charSequence.charAt(i2);
                this.f = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.e = initialCharIndex;
            this.f = ';';
            return (byte) 13;
        }
    }
}
