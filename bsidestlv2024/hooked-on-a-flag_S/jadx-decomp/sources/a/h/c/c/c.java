package a.h.c.c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.content.res.FontResourcesParserCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static final class d implements a {

        /* renamed from: a, reason: collision with root package name */
        public final a.h.h.d f355a;

        /* renamed from: b, reason: collision with root package name */
        public final int f356b;
        public final int c;
        public final String d;

        public d(a.h.h.d request, int strategy, int timeoutMs, String systemFontFamilyName) {
            this.f355a = request;
            this.c = strategy;
            this.f356b = timeoutMs;
            this.d = systemFontFamilyName;
        }

        public a.h.h.d b() {
            return this.f355a;
        }

        public int a() {
            return this.c;
        }

        public int d() {
            return this.f356b;
        }

        public String c() {
            return this.d;
        }
    }

    /* renamed from: a.h.c.c.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0019c {

        /* renamed from: a, reason: collision with root package name */
        public final String f353a;

        /* renamed from: b, reason: collision with root package name */
        public int f354b;
        public boolean c;
        public String d;
        public int e;
        public int f;

        public C0019c(String fileName, int weight, boolean italic, String variationSettings, int ttcIndex, int resourceId) {
            this.f353a = fileName;
            this.f354b = weight;
            this.c = italic;
            this.d = variationSettings;
            this.e = ttcIndex;
            this.f = resourceId;
        }

        public String a() {
            return this.f353a;
        }

        public int e() {
            return this.f354b;
        }

        public boolean f() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public int c() {
            return this.e;
        }

        public int b() {
            return this.f;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final C0019c[] f352a;

        public b(C0019c[] entries) {
            this.f352a = entries;
        }

        public C0019c[] a() {
            return this.f352a;
        }
    }

    public static a b(XmlPullParser parser, Resources resources) {
        int type;
        do {
            type = parser.next();
            if (type == 2) {
                break;
            }
        } while (type != 1);
        if (type != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return d(parser, resources);
    }

    public static a d(XmlPullParser parser, Resources resources) {
        parser.require(2, null, "font-family");
        String tag = parser.getName();
        if (tag.equals("font-family")) {
            return e(parser, resources);
        }
        g(parser);
        return null;
    }

    public static a e(XmlPullParser parser, Resources resources) {
        AttributeSet attrs = Xml.asAttributeSet(parser);
        TypedArray array = resources.obtainAttributes(attrs, a.h.a.f338b);
        int[] iArr = a.h.a.f337a;
        String authority = array.getString(0);
        String providerPackage = array.getString(4);
        String query = array.getString(5);
        int certsId = array.getResourceId(1, 0);
        int strategy = array.getInteger(2, 1);
        int timeoutMs = array.getInteger(3, 500);
        String systemFontFamilyName = array.getString(6);
        array.recycle();
        if (authority != null && providerPackage != null && query != null) {
            while (parser.next() != 3) {
                g(parser);
            }
            List<List<byte[]>> certs = c(resources, certsId);
            return new d(new a.h.h.d(authority, providerPackage, query, certs), strategy, timeoutMs, systemFontFamilyName);
        }
        List<FontResourcesParserCompat.FontFileResourceEntry> fonts = new ArrayList<>();
        while (parser.next() != 3) {
            if (parser.getEventType() == 2) {
                String tag = parser.getName();
                if (tag.equals("font")) {
                    fonts.add(f(parser, resources));
                } else {
                    g(parser);
                }
            }
        }
        if (fonts.isEmpty()) {
            return null;
        }
        return new b((C0019c[]) fonts.toArray(new C0019c[fonts.size()]));
    }

    public static int a(TypedArray typedArray, int index) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(index);
        }
        TypedValue tv = new TypedValue();
        typedArray.getValue(index, tv);
        return tv.type;
    }

    public static List<List<byte[]>> c(Resources resources, int certsId) {
        if (certsId == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArray = resources.obtainTypedArray(certsId);
        try {
            if (typedArray.length() == 0) {
                return Collections.emptyList();
            }
            List<List<byte[]>> result = new ArrayList<>();
            if (a(typedArray, 0) == 1) {
                for (int i = 0; i < typedArray.length(); i++) {
                    int certId = typedArray.getResourceId(i, 0);
                    if (certId != 0) {
                        result.add(h(resources.getStringArray(certId)));
                    }
                }
            } else {
                result.add(h(resources.getStringArray(certsId)));
            }
            return result;
        } finally {
            typedArray.recycle();
        }
    }

    public static List<byte[]> h(String[] stringArray) {
        List<byte[]> result = new ArrayList<>();
        for (String item : stringArray) {
            result.add(Base64.decode(item, 0));
        }
        return result;
    }

    public static C0019c f(XmlPullParser parser, Resources resources) {
        AttributeSet attrs = Xml.asAttributeSet(parser);
        TypedArray array = resources.obtainAttributes(attrs, a.h.a.c);
        int[] iArr = a.h.a.f337a;
        int weightAttr = array.hasValue(8) ? 8 : 1;
        int weight = array.getInt(weightAttr, 400);
        int i = 6;
        if (!array.hasValue(6)) {
            i = 2;
        }
        int styleAttr = i;
        boolean isItalic = 1 == array.getInt(styleAttr, 0);
        int ttcIndexAttr = 9;
        if (!array.hasValue(9)) {
            ttcIndexAttr = 3;
        }
        int i2 = 7;
        if (!array.hasValue(7)) {
            i2 = 4;
        }
        int variationSettingsAttr = i2;
        String variationSettings = array.getString(variationSettingsAttr);
        int ttcIndex = array.getInt(ttcIndexAttr, 0);
        int i3 = 5;
        if (!array.hasValue(5)) {
            i3 = 0;
        }
        int resourceAttr = i3;
        int resourceId = array.getResourceId(resourceAttr, 0);
        String filename = array.getString(resourceAttr);
        array.recycle();
        while (parser.next() != 3) {
            g(parser);
        }
        return new C0019c(filename, weight, isItalic, variationSettings, ttcIndex, resourceId);
    }

    public static void g(XmlPullParser parser) {
        int depth = 1;
        while (depth > 0) {
            switch (parser.next()) {
                case 2:
                    depth++;
                    break;
                case 3:
                    depth--;
                    break;
            }
        }
    }
}
