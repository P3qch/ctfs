package a.h.c.c;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import net.sqlcipher.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class a {
    public static ColorStateList c(Resources resources, int resId, Resources.Theme theme) {
        try {
            XmlPullParser parser = resources.getXml(resId);
            return a(resources, parser, theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    public static ColorStateList a(Resources r, XmlPullParser parser, Resources.Theme theme) {
        int type;
        AttributeSet attrs = Xml.asAttributeSet(parser);
        do {
            type = parser.next();
            if (type == 2) {
                break;
            }
        } while (type != 1);
        if (type != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return b(r, parser, attrs, theme);
    }

    public static ColorStateList b(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        String name = parser.getName();
        if (!name.equals("selector")) {
            throw new XmlPullParserException(parser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        return d(r, parser, attrs, theme);
    }

    public static ColorStateList d(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        int depth;
        int innerDepth;
        int i = 1;
        int innerDepth2 = parser.getDepth() + 1;
        int[][] stateSpecList = new int[20];
        int[] colorList = new int[stateSpecList.length];
        int listSize = 0;
        while (true) {
            int next = parser.next();
            int type = next;
            if (next != i && ((depth = parser.getDepth()) >= innerDepth2 || type != 3)) {
                if (type != 2 || depth > innerDepth2) {
                    innerDepth = innerDepth2;
                } else if (parser.getName().equals("item")) {
                    TypedArray a2 = f(r, theme, attrs, a.h.a.f337a);
                    int[] iArr = a.h.a.f337a;
                    int baseColor = a2.getColor(0, -65281);
                    float alphaMod = 1.0f;
                    if (a2.hasValue(i)) {
                        alphaMod = a2.getFloat(i, 1.0f);
                    } else if (a2.hasValue(2)) {
                        alphaMod = a2.getFloat(2, 1.0f);
                    }
                    a2.recycle();
                    int j = 0;
                    int numAttrs = attrs.getAttributeCount();
                    int[] stateSpec = new int[numAttrs];
                    int i2 = 0;
                    while (i2 < numAttrs) {
                        int innerDepth3 = innerDepth2;
                        int stateResId = attrs.getAttributeNameResource(i2);
                        int type2 = type;
                        if (stateResId != 16843173 && stateResId != 16843551 && stateResId != R.attr.alpha) {
                            int j2 = j + 1;
                            stateSpec[j] = attrs.getAttributeBooleanValue(i2, false) ? stateResId : -stateResId;
                            j = j2;
                        }
                        i2++;
                        innerDepth2 = innerDepth3;
                        type = type2;
                    }
                    int innerDepth4 = innerDepth2;
                    int[] stateSpec2 = StateSet.trimStateSet(stateSpec, j);
                    int color = e(baseColor, alphaMod);
                    colorList = e.a(colorList, listSize, color);
                    stateSpecList = (int[][]) e.b(stateSpecList, listSize, stateSpec2);
                    listSize++;
                    innerDepth2 = innerDepth4;
                    i = 1;
                } else {
                    innerDepth = innerDepth2;
                }
                innerDepth2 = innerDepth;
                i = 1;
            }
        }
        int[] colors = new int[listSize];
        int[][] stateSpecs = new int[listSize];
        System.arraycopy(colorList, 0, colors, 0, listSize);
        System.arraycopy(stateSpecList, 0, stateSpecs, 0, listSize);
        return new ColorStateList(stateSpecs, colors);
    }

    public static TypedArray f(Resources res, Resources.Theme theme, AttributeSet set, int[] attrs) {
        return theme == null ? res.obtainAttributes(set, attrs) : theme.obtainStyledAttributes(set, attrs, 0, 0);
    }

    public static int e(int color, float alphaMod) {
        int alpha = Math.round(Color.alpha(color) * alphaMod);
        return (16777215 & color) | (alpha << 24);
    }
}
