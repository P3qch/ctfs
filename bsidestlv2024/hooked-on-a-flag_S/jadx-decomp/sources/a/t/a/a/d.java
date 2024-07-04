package a.t.a.a;

import a.h.d.c;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.animation.Interpolator;
import java.io.IOException;
import java.util.ArrayList;
import net.sqlcipher.BuildConfig;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class d {
    public static Animator i(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 24) {
            Animator objectAnimator = AnimatorInflater.loadAnimator(context, id);
            return objectAnimator;
        }
        Animator objectAnimator2 = j(context, context.getResources(), context.getTheme(), id);
        return objectAnimator2;
    }

    public static Animator j(Context context, Resources resources, Resources.Theme theme, int id) {
        return k(context, resources, theme, id, 1.0f);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, int id, float pathErrorScale) {
        XmlResourceParser parser = null;
        try {
            try {
                try {
                    parser = resources.getAnimation(id);
                    Animator animator = a(context, resources, theme, parser, pathErrorScale);
                    return animator;
                } catch (IOException ex) {
                    Resources.NotFoundException rnf = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
                    rnf.initCause(ex);
                    throw rnf;
                }
            } catch (XmlPullParserException ex2) {
                Resources.NotFoundException rnf2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
                rnf2.initCause(ex2);
                throw rnf2;
            }
        } finally {
            if (parser != null) {
                parser.close();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a implements TypeEvaluator<c.b[]> {

        /* renamed from: a, reason: collision with root package name */
        public c.b[] f752a;

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c.b[] evaluate(float fraction, c.b[] startPathData, c.b[] endPathData) {
            if (!a.h.d.c.b(startPathData, endPathData)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!a.h.d.c.b(this.f752a, startPathData)) {
                this.f752a = a.h.d.c.f(startPathData);
            }
            for (int i = 0; i < startPathData.length; i++) {
                this.f752a[i].d(startPathData[i], endPathData[i], fraction);
            }
            return this.f752a;
        }
    }

    public static PropertyValuesHolder e(TypedArray styledAttributes, int valueType, int valueFromId, int valueToId, String propertyName) {
        int valueType2;
        PropertyValuesHolder returnValue;
        char c;
        int valueTo;
        int valueFrom;
        char c2;
        int valueTo2;
        float valueTo3;
        float valueFrom2;
        int toType;
        PropertyValuesHolder propertyValuesHolder;
        TypedValue tvFrom = styledAttributes.peekValue(valueFromId);
        boolean hasFrom = tvFrom != null;
        int fromType = hasFrom ? tvFrom.type : 0;
        TypedValue tvTo = styledAttributes.peekValue(valueToId);
        boolean hasTo = tvTo != null;
        int toType2 = hasTo ? tvTo.type : 0;
        if (valueType != 4) {
            valueType2 = valueType;
        } else if ((hasFrom && h(fromType)) || (hasTo && h(toType2))) {
            valueType2 = 3;
        } else {
            valueType2 = 0;
        }
        boolean getFloats = valueType2 == 0;
        if (valueType2 == 2) {
            String fromString = styledAttributes.getString(valueFromId);
            String toString = styledAttributes.getString(valueToId);
            c.b[] nodesFrom = a.h.d.c.d(fromString);
            c.b[] nodesTo = a.h.d.c.d(toString);
            if (nodesFrom == null && nodesTo == null) {
                toType = toType2;
                propertyValuesHolder = null;
            } else if (nodesFrom == null) {
                toType = toType2;
                propertyValuesHolder = null;
                if (nodesTo != null) {
                    returnValue = PropertyValuesHolder.ofObject(propertyName, new a(), nodesTo);
                }
            } else {
                TypeEvaluator evaluator = new a();
                if (nodesTo == null) {
                    toType = toType2;
                    returnValue = PropertyValuesHolder.ofObject(propertyName, evaluator, nodesFrom);
                } else {
                    if (!a.h.d.c.b(nodesFrom, nodesTo)) {
                        throw new InflateException(" Can't morph from " + fromString + " to " + toString);
                    }
                    returnValue = PropertyValuesHolder.ofObject(propertyName, evaluator, nodesFrom, nodesTo);
                    toType = toType2;
                }
            }
            returnValue = propertyValuesHolder;
        } else {
            int toType3 = toType2;
            TypeEvaluator evaluator2 = valueType2 == 3 ? e.a() : null;
            if (getFloats) {
                if (!hasFrom) {
                    if (toType3 == 5) {
                        valueTo3 = styledAttributes.getDimension(valueToId, 0.0f);
                    } else {
                        valueTo3 = styledAttributes.getFloat(valueToId, 0.0f);
                    }
                    returnValue = PropertyValuesHolder.ofFloat(propertyName, valueTo3);
                } else {
                    if (fromType == 5) {
                        valueFrom2 = styledAttributes.getDimension(valueFromId, 0.0f);
                    } else {
                        valueFrom2 = styledAttributes.getFloat(valueFromId, 0.0f);
                    }
                    if (hasTo) {
                        float valueTo4 = toType3 == 5 ? styledAttributes.getDimension(valueToId, 0.0f) : styledAttributes.getFloat(valueToId, 0.0f);
                        returnValue = PropertyValuesHolder.ofFloat(propertyName, valueFrom2, valueTo4);
                    } else {
                        returnValue = PropertyValuesHolder.ofFloat(propertyName, valueFrom2);
                    }
                }
            } else if (hasFrom) {
                if (fromType == 5) {
                    valueFrom = (int) styledAttributes.getDimension(valueFromId, 0.0f);
                } else {
                    valueFrom = h(fromType) ? styledAttributes.getColor(valueFromId, 0) : styledAttributes.getInt(valueFromId, 0);
                }
                if (hasTo) {
                    if (toType3 == 5) {
                        valueTo2 = (int) styledAttributes.getDimension(valueToId, 0.0f);
                        c2 = 0;
                    } else if (h(toType3)) {
                        c2 = 0;
                        valueTo2 = styledAttributes.getColor(valueToId, 0);
                    } else {
                        c2 = 0;
                        valueTo2 = styledAttributes.getInt(valueToId, 0);
                    }
                    int[] iArr = new int[2];
                    iArr[c2] = valueFrom;
                    iArr[1] = valueTo2;
                    returnValue = PropertyValuesHolder.ofInt(propertyName, iArr);
                } else {
                    returnValue = PropertyValuesHolder.ofInt(propertyName, valueFrom);
                }
            } else if (!hasTo) {
                returnValue = null;
            } else {
                if (toType3 == 5) {
                    valueTo = (int) styledAttributes.getDimension(valueToId, 0.0f);
                    c = 0;
                } else if (h(toType3)) {
                    c = 0;
                    valueTo = styledAttributes.getColor(valueToId, 0);
                } else {
                    c = 0;
                    valueTo = styledAttributes.getInt(valueToId, 0);
                }
                int[] iArr2 = new int[1];
                iArr2[c] = valueTo;
                returnValue = PropertyValuesHolder.ofInt(propertyName, iArr2);
            }
            if (returnValue != null && evaluator2 != null) {
                returnValue.setEvaluator(evaluator2);
            }
        }
        return returnValue;
    }

    public static void q(ValueAnimator anim, TypedArray arrayAnimator, TypedArray arrayObjectAnimator, float pixelSize, XmlPullParser parser) {
        long duration = a.h.c.c.g.g(arrayAnimator, parser, "duration", 1, 300);
        long startDelay = a.h.c.c.g.g(arrayAnimator, parser, "startOffset", 2, 0);
        int valueType = a.h.c.c.g.g(arrayAnimator, parser, "valueType", 7, 4);
        if (a.h.c.c.g.j(parser, "valueFrom") && a.h.c.c.g.j(parser, "valueTo")) {
            if (valueType == 4) {
                valueType = f(arrayAnimator, 5, 6);
            }
            PropertyValuesHolder pvh = e(arrayAnimator, valueType, 5, 6, BuildConfig.FLAVOR);
            if (pvh != null) {
                anim.setValues(pvh);
            }
        }
        anim.setDuration(duration);
        anim.setStartDelay(startDelay);
        anim.setRepeatCount(a.h.c.c.g.g(arrayAnimator, parser, "repeatCount", 3, 0));
        anim.setRepeatMode(a.h.c.c.g.g(arrayAnimator, parser, "repeatMode", 4, 1));
        if (arrayObjectAnimator != null) {
            r(anim, arrayObjectAnimator, valueType, pixelSize, parser);
        }
    }

    public static void r(ValueAnimator anim, TypedArray arrayObjectAnimator, int valueType, float pixelSize, XmlPullParser parser) {
        ObjectAnimator oa = (ObjectAnimator) anim;
        String pathData = a.h.c.c.g.i(arrayObjectAnimator, parser, "pathData", 1);
        if (pathData != null) {
            String propertyXName = a.h.c.c.g.i(arrayObjectAnimator, parser, "propertyXName", 2);
            String propertyYName = a.h.c.c.g.i(arrayObjectAnimator, parser, "propertyYName", 3);
            if (valueType == 2 || valueType == 4) {
            }
            if (propertyXName == null && propertyYName == null) {
                throw new InflateException(arrayObjectAnimator.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            Path path = a.h.d.c.e(pathData);
            s(path, oa, 0.5f * pixelSize, propertyXName, propertyYName);
            return;
        }
        String propertyName = a.h.c.c.g.i(arrayObjectAnimator, parser, "propertyName", 0);
        oa.setPropertyName(propertyName);
    }

    public static void s(Path path, ObjectAnimator oa, float precision, String propertyXName, String propertyYName) {
        Path path2 = path;
        boolean z = false;
        PathMeasure measureForTotalLength = new PathMeasure(path2, false);
        float totalLength = 0.0f;
        ArrayList<Float> contourLengths = new ArrayList<>();
        contourLengths.add(Float.valueOf(0.0f));
        while (true) {
            float pathLength = measureForTotalLength.getLength();
            totalLength += pathLength;
            contourLengths.add(Float.valueOf(totalLength));
            if (!measureForTotalLength.nextContour()) {
                break;
            }
            z = false;
            path2 = path;
        }
        PathMeasure pathMeasure = new PathMeasure(path2, z);
        int numPoints = Math.min(100, ((int) (totalLength / precision)) + 1);
        float[] mX = new float[numPoints];
        float[] mY = new float[numPoints];
        float[] position = new float[2];
        int contourIndex = 0;
        float step = totalLength / (numPoints - 1);
        float currentDistance = 0.0f;
        for (int i = 0; i < numPoints; i++) {
            pathMeasure.getPosTan(currentDistance - contourLengths.get(contourIndex).floatValue(), position, null);
            mX[i] = position[0];
            mY[i] = position[1];
            currentDistance += step;
            if (contourIndex + 1 < contourLengths.size() && currentDistance > contourLengths.get(contourIndex + 1).floatValue()) {
                contourIndex++;
                pathMeasure.nextContour();
            }
        }
        PropertyValuesHolder x = null;
        PropertyValuesHolder y = null;
        if (propertyXName != null) {
            x = PropertyValuesHolder.ofFloat(propertyXName, mX);
        }
        if (propertyYName != null) {
            y = PropertyValuesHolder.ofFloat(propertyYName, mY);
        }
        if (x == null) {
            oa.setValues(y);
        } else if (y == null) {
            oa.setValues(x);
        } else {
            oa.setValues(x, y);
        }
    }

    public static Animator a(Context context, Resources res, Resources.Theme theme, XmlPullParser parser, float pixelSize) {
        return b(context, res, theme, parser, Xml.asAttributeSet(parser), null, 0, pixelSize);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00f6, code lost:
    
        r0 = new android.animation.Animator[r13.size()];
        r2 = 0;
        r3 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0105, code lost:
    
        if (r3.hasNext() == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0107, code lost:
    
        r0[r2] = r3.next();
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0113, code lost:
    
        if (r25 != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0115, code lost:
    
        r24.playTogether(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0119, code lost:
    
        r24.playSequentially(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x011c, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00f2, code lost:
    
        if (r24 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00f4, code lost:
    
        if (r13 == null) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator b(android.content.Context r19, android.content.res.Resources r20, android.content.res.Resources.Theme r21, org.xmlpull.v1.XmlPullParser r22, android.util.AttributeSet r23, android.animation.AnimatorSet r24, int r25, float r26) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.t.a.a.d.b(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static PropertyValuesHolder[] p(Context context, Resources res, Resources.Theme theme, XmlPullParser parser, AttributeSet attrs) {
        ArrayList<PropertyValuesHolder> values = null;
        while (true) {
            int type = parser.getEventType();
            if (type == 3 || type == 1) {
                break;
            }
            if (type != 2) {
                parser.next();
            } else {
                String name = parser.getName();
                if (name.equals("propertyValuesHolder")) {
                    TypedArray a2 = a.h.c.c.g.k(res, theme, attrs, a.t.a.a.a.i);
                    String propertyName = a.h.c.c.g.i(a2, parser, "propertyName", 3);
                    int valueType = a.h.c.c.g.g(a2, parser, "valueType", 2, 4);
                    PropertyValuesHolder pvh = o(context, res, theme, parser, propertyName, valueType);
                    if (pvh == null) {
                        pvh = e(a2, valueType, 0, 1, propertyName);
                    }
                    if (pvh != null) {
                        if (values == null) {
                            values = new ArrayList<>();
                        }
                        values.add(pvh);
                    }
                    a2.recycle();
                }
                parser.next();
            }
        }
        PropertyValuesHolder[] valuesArray = null;
        if (values != null) {
            int count = values.size();
            valuesArray = new PropertyValuesHolder[count];
            for (int i = 0; i < count; i++) {
                valuesArray[i] = values.get(i);
            }
        }
        return valuesArray;
    }

    public static int g(Resources res, Resources.Theme theme, AttributeSet attrs, XmlPullParser parser) {
        int valueType;
        TypedArray a2 = a.h.c.c.g.k(res, theme, attrs, a.t.a.a.a.j);
        TypedValue keyframeValue = a.h.c.c.g.l(a2, parser, "value", 0);
        boolean hasValue = keyframeValue != null;
        if (hasValue && h(keyframeValue.type)) {
            valueType = 3;
        } else {
            valueType = 0;
        }
        a2.recycle();
        return valueType;
    }

    public static int f(TypedArray styledAttributes, int valueFromId, int valueToId) {
        TypedValue tvFrom = styledAttributes.peekValue(valueFromId);
        boolean hasFrom = tvFrom != null;
        int fromType = hasFrom ? tvFrom.type : 0;
        TypedValue tvTo = styledAttributes.peekValue(valueToId);
        boolean hasTo = tvTo != null;
        int toType = hasTo ? tvTo.type : 0;
        if ((hasFrom && h(fromType)) || (hasTo && h(toType))) {
            return 3;
        }
        return 0;
    }

    public static PropertyValuesHolder o(Context context, Resources res, Resources.Theme theme, XmlPullParser parser, String propertyName, int valueType) {
        int type;
        PropertyValuesHolder value;
        PropertyValuesHolder value2;
        ArrayList<Keyframe> keyframes;
        int type2;
        PropertyValuesHolder value3 = null;
        ArrayList<Keyframe> keyframes2 = null;
        int valueType2 = valueType;
        while (true) {
            int next = parser.next();
            type = next;
            if (next == 3 || type == 1) {
                break;
            }
            String name = parser.getName();
            if (name.equals("keyframe")) {
                if (valueType2 == 4) {
                    valueType2 = g(res, theme, Xml.asAttributeSet(parser), parser);
                }
                Keyframe keyframe = m(context, res, theme, Xml.asAttributeSet(parser), valueType2, parser);
                if (keyframe != null) {
                    if (keyframes2 == null) {
                        keyframes2 = new ArrayList<>();
                    }
                    keyframes2.add(keyframe);
                }
                parser.next();
            }
        }
        if (keyframes2 != null) {
            int size = keyframes2.size();
            int count = size;
            if (size <= 0) {
                value = null;
            } else {
                Keyframe firstKeyframe = keyframes2.get(0);
                Keyframe lastKeyframe = keyframes2.get(count - 1);
                float endFraction = lastKeyframe.getFraction();
                float f = 0.0f;
                if (endFraction < 1.0f) {
                    if (endFraction >= 0.0f) {
                        keyframes2.add(keyframes2.size(), c(lastKeyframe, 1.0f));
                        count++;
                    } else {
                        lastKeyframe.setFraction(1.0f);
                    }
                }
                float startFraction = firstKeyframe.getFraction();
                if (startFraction != 0.0f) {
                    if (startFraction >= 0.0f) {
                        keyframes2.add(0, c(firstKeyframe, 0.0f));
                        count++;
                    } else {
                        firstKeyframe.setFraction(0.0f);
                    }
                }
                Keyframe[] keyframeArray = new Keyframe[count];
                keyframes2.toArray(keyframeArray);
                int i = 0;
                while (i < count) {
                    Keyframe keyframe2 = keyframeArray[i];
                    if (keyframe2.getFraction() >= f) {
                        value2 = value3;
                        keyframes = keyframes2;
                        type2 = type;
                    } else if (i == 0) {
                        keyframe2.setFraction(f);
                        value2 = value3;
                        keyframes = keyframes2;
                        type2 = type;
                    } else if (i == count - 1) {
                        keyframe2.setFraction(1.0f);
                        value2 = value3;
                        keyframes = keyframes2;
                        type2 = type;
                    } else {
                        int startIndex = i;
                        int endIndex = i;
                        value2 = value3;
                        int j = startIndex + 1;
                        keyframes = keyframes2;
                        int endIndex2 = endIndex;
                        while (true) {
                            type2 = type;
                            if (j >= count - 1 || keyframeArray[j].getFraction() >= 0.0f) {
                                break;
                            }
                            endIndex2 = j;
                            j++;
                            type = type2;
                        }
                        int j2 = endIndex2 + 1;
                        float gap = keyframeArray[j2].getFraction() - keyframeArray[startIndex - 1].getFraction();
                        d(keyframeArray, gap, startIndex, endIndex2);
                    }
                    i++;
                    keyframes2 = keyframes;
                    type = type2;
                    value3 = value2;
                    f = 0.0f;
                }
                PropertyValuesHolder value4 = PropertyValuesHolder.ofKeyframe(propertyName, keyframeArray);
                if (valueType2 != 3) {
                    return value4;
                }
                value4.setEvaluator(e.a());
                return value4;
            }
        } else {
            value = null;
        }
        return value;
    }

    public static Keyframe c(Keyframe sampleKeyframe, float fraction) {
        if (sampleKeyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(fraction);
        }
        if (sampleKeyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(fraction);
        }
        return Keyframe.ofObject(fraction);
    }

    public static void d(Keyframe[] keyframes, float gap, int startIndex, int endIndex) {
        int count = (endIndex - startIndex) + 2;
        float increment = gap / count;
        for (int i = startIndex; i <= endIndex; i++) {
            keyframes[i].setFraction(keyframes[i - 1].getFraction() + increment);
        }
    }

    public static Keyframe m(Context context, Resources res, Resources.Theme theme, AttributeSet attrs, int valueType, XmlPullParser parser) {
        TypedArray a2 = a.h.c.c.g.k(res, theme, attrs, a.t.a.a.a.j);
        Keyframe keyframe = null;
        float fraction = a.h.c.c.g.f(a2, parser, "fraction", 3, -1.0f);
        TypedValue keyframeValue = a.h.c.c.g.l(a2, parser, "value", 0);
        boolean hasValue = keyframeValue != null;
        if (valueType == 4) {
            if (hasValue && h(keyframeValue.type)) {
                valueType = 3;
            } else {
                valueType = 0;
            }
        }
        if (hasValue) {
            switch (valueType) {
                case 0:
                    float value = a.h.c.c.g.f(a2, parser, "value", 0, 0.0f);
                    keyframe = Keyframe.ofFloat(fraction, value);
                    break;
                case 1:
                case 3:
                    int intValue = a.h.c.c.g.g(a2, parser, "value", 0, 0);
                    keyframe = Keyframe.ofInt(fraction, intValue);
                    break;
            }
        } else {
            keyframe = valueType == 0 ? Keyframe.ofFloat(fraction) : Keyframe.ofInt(fraction);
        }
        int resID = a.h.c.c.g.h(a2, parser, "interpolator", 1, 0);
        if (resID > 0) {
            Interpolator interpolator = c.b(context, resID);
            keyframe.setInterpolator(interpolator);
        }
        a2.recycle();
        return keyframe;
    }

    public static ObjectAnimator n(Context context, Resources res, Resources.Theme theme, AttributeSet attrs, float pathErrorScale, XmlPullParser parser) {
        ObjectAnimator anim = new ObjectAnimator();
        l(context, res, theme, attrs, anim, pathErrorScale, parser);
        return anim;
    }

    public static ValueAnimator l(Context context, Resources res, Resources.Theme theme, AttributeSet attrs, ValueAnimator anim, float pathErrorScale, XmlPullParser parser) {
        TypedArray arrayAnimator = a.h.c.c.g.k(res, theme, attrs, a.t.a.a.a.g);
        TypedArray arrayObjectAnimator = a.h.c.c.g.k(res, theme, attrs, a.t.a.a.a.k);
        if (anim == null) {
            anim = new ValueAnimator();
        }
        q(anim, arrayAnimator, arrayObjectAnimator, pathErrorScale, parser);
        int resID = a.h.c.c.g.h(arrayAnimator, parser, "interpolator", 0, 0);
        if (resID > 0) {
            Interpolator interpolator = c.b(context, resID);
            anim.setInterpolator(interpolator);
        }
        arrayAnimator.recycle();
        if (arrayObjectAnimator != null) {
            arrayObjectAnimator.recycle();
        }
        return anim;
    }

    public static boolean h(int type) {
        return type >= 28 && type <= 31;
    }
}
