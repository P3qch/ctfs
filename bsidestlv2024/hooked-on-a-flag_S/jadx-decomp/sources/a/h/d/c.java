package a.h.d;

import android.graphics.Path;
import android.util.Log;
import androidx.core.graphics.PathParser;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f365a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f366b;
    }

    public static float[] c(float[] original, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        float[] result = new float[resultLength];
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    public static Path e(String pathData) {
        Path path = new Path();
        b[] nodes = d(pathData);
        if (nodes != null) {
            try {
                b.e(nodes, path);
                return path;
            } catch (RuntimeException e) {
                throw new RuntimeException("Error in parsing " + pathData, e);
            }
        }
        return null;
    }

    public static b[] d(String pathData) {
        if (pathData == null) {
            return null;
        }
        int start = 0;
        int end = 1;
        ArrayList<PathParser.PathDataNode> list = new ArrayList<>();
        while (end < pathData.length()) {
            int end2 = i(pathData, end);
            String s = pathData.substring(start, end2).trim();
            if (s.length() > 0) {
                float[] val = h(s);
                a(list, s.charAt(0), val);
            }
            start = end2;
            end = end2 + 1;
        }
        if (end - start == 1 && start < pathData.length()) {
            a(list, pathData.charAt(start), new float[0]);
        }
        return (b[]) list.toArray(new b[list.size()]);
    }

    public static b[] f(b[] source) {
        if (source == null) {
            return null;
        }
        b[] copy = new b[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = new b(source[i]);
        }
        return copy;
    }

    public static boolean b(b[] nodesFrom, b[] nodesTo) {
        if (nodesFrom == null || nodesTo == null || nodesFrom.length != nodesTo.length) {
            return false;
        }
        for (int i = 0; i < nodesFrom.length; i++) {
            if (nodesFrom[i].f367a != nodesTo[i].f367a || nodesFrom[i].f368b.length != nodesTo[i].f368b.length) {
                return false;
            }
        }
        return true;
    }

    public static void j(b[] target, b[] source) {
        for (int i = 0; i < source.length; i++) {
            target[i].f367a = source[i].f367a;
            for (int j = 0; j < source[i].f368b.length; j++) {
                target[i].f368b[j] = source[i].f368b[j];
            }
        }
    }

    public static int i(String s, int end) {
        while (end < s.length()) {
            char c = s.charAt(end);
            if (((c - 'A') * (c - 'Z') <= 0 || (c - 'a') * (c - 'z') <= 0) && c != 'e' && c != 'E') {
                return end;
            }
            end++;
        }
        return end;
    }

    public static void a(ArrayList<b> arrayList, char cmd, float[] val) {
        arrayList.add(new b(cmd, val));
    }

    public static float[] h(String s) {
        if (s.charAt(0) == 'z' || s.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] results = new float[s.length()];
            int count = 0;
            int startPosition = 1;
            a result = new a();
            int totalLength = s.length();
            while (startPosition < totalLength) {
                g(s, startPosition, result);
                int endPosition = result.f365a;
                if (startPosition < endPosition) {
                    results[count] = Float.parseFloat(s.substring(startPosition, endPosition));
                    count++;
                }
                if (result.f366b) {
                    startPosition = endPosition;
                } else {
                    startPosition = endPosition + 1;
                }
            }
            return c(results, 0, count);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + s + "\"", e);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0014. Please report as an issue. */
    public static void g(String s, int start, a result) {
        boolean foundSeparator = false;
        result.f366b = false;
        boolean secondDot = false;
        boolean isExponential = false;
        for (int currentIndex = start; currentIndex < s.length(); currentIndex++) {
            boolean isPrevExponential = isExponential;
            isExponential = false;
            char currentChar = s.charAt(currentIndex);
            switch (currentChar) {
                case ' ':
                case ',':
                    foundSeparator = true;
                    break;
                case '-':
                    if (currentIndex != start && !isPrevExponential) {
                        foundSeparator = true;
                        result.f366b = true;
                        break;
                    }
                    break;
                case '.':
                    if (!secondDot) {
                        secondDot = true;
                        break;
                    } else {
                        foundSeparator = true;
                        result.f366b = true;
                        break;
                    }
                case 'E':
                case 'e':
                    isExponential = true;
                    break;
            }
            if (foundSeparator) {
                result.f365a = currentIndex;
            }
        }
        result.f365a = currentIndex;
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public char f367a;

        /* renamed from: b, reason: collision with root package name */
        public float[] f368b;

        public b(char type, float[] params) {
            this.f367a = type;
            this.f368b = params;
        }

        public b(b n) {
            this.f367a = n.f367a;
            float[] fArr = n.f368b;
            this.f368b = c.c(fArr, 0, fArr.length);
        }

        public static void e(b[] node, Path path) {
            float[] current = new float[6];
            char previousCommand = 'm';
            for (int i = 0; i < node.length; i++) {
                a(path, current, previousCommand, node[i].f367a, node[i].f368b);
                previousCommand = node[i].f367a;
            }
        }

        public void d(b nodeFrom, b nodeTo, float fraction) {
            this.f367a = nodeFrom.f367a;
            int i = 0;
            while (true) {
                float[] fArr = nodeFrom.f368b;
                if (i < fArr.length) {
                    this.f368b[i] = (fArr[i] * (1.0f - fraction)) + (nodeTo.f368b[i] * fraction);
                    i++;
                } else {
                    return;
                }
            }
        }

        public static void a(Path path, float[] current, char previousCmd, char cmd, float[] val) {
            int incr;
            int k;
            float reflectiveCtrlPointX;
            float reflectiveCtrlPointY;
            float reflectiveCtrlPointX2;
            float reflectiveCtrlPointY2;
            Path path2 = path;
            float currentX = current[0];
            float currentY = current[1];
            float ctrlPointX = current[2];
            float ctrlPointY = current[3];
            float currentSegmentStartX = current[4];
            float currentSegmentStartY = current[5];
            switch (cmd) {
                case 'A':
                case 'a':
                    incr = 7;
                    break;
                case 'C':
                case 'c':
                    incr = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    incr = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                    incr = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    incr = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    currentX = currentSegmentStartX;
                    currentY = currentSegmentStartY;
                    ctrlPointX = currentSegmentStartX;
                    ctrlPointY = currentSegmentStartY;
                    path2.moveTo(currentX, currentY);
                    incr = 2;
                    break;
                default:
                    incr = 2;
                    break;
            }
            char previousCmd2 = previousCmd;
            int k2 = 0;
            float currentX2 = currentX;
            float ctrlPointX2 = ctrlPointX;
            float ctrlPointY2 = ctrlPointY;
            float currentSegmentStartX2 = currentSegmentStartX;
            float currentSegmentStartY2 = currentSegmentStartY;
            float currentSegmentStartY3 = currentY;
            while (k2 < val.length) {
                switch (cmd) {
                    case 'A':
                        k = k2;
                        c(path, currentX2, currentSegmentStartY3, val[k + 5], val[k + 6], val[k + 0], val[k + 1], val[k + 2], val[k + 3] != 0.0f, val[k + 4] != 0.0f);
                        float currentX3 = val[k + 5];
                        float currentY2 = val[k + 6];
                        currentX2 = currentX3;
                        currentSegmentStartY3 = currentY2;
                        ctrlPointX2 = currentX3;
                        ctrlPointY2 = currentY2;
                        break;
                    case 'C':
                        k = k2;
                        path.cubicTo(val[k + 0], val[k + 1], val[k + 2], val[k + 3], val[k + 4], val[k + 5]);
                        currentX2 = val[k + 4];
                        currentSegmentStartY3 = val[k + 5];
                        ctrlPointX2 = val[k + 2];
                        ctrlPointY2 = val[k + 3];
                        break;
                    case 'H':
                        k = k2;
                        path2.lineTo(val[k + 0], currentSegmentStartY3);
                        currentX2 = val[k + 0];
                        break;
                    case 'L':
                        k = k2;
                        path2.lineTo(val[k + 0], val[k + 1]);
                        currentX2 = val[k + 0];
                        currentSegmentStartY3 = val[k + 1];
                        break;
                    case 'M':
                        k = k2;
                        float currentX4 = val[k + 0];
                        float currentY3 = val[k + 1];
                        if (k > 0) {
                            path2.lineTo(val[k + 0], val[k + 1]);
                            currentX2 = currentX4;
                            currentSegmentStartY3 = currentY3;
                            break;
                        } else {
                            path2.moveTo(val[k + 0], val[k + 1]);
                            currentX2 = currentX4;
                            currentSegmentStartY3 = currentY3;
                            currentSegmentStartX2 = currentX4;
                            currentSegmentStartY2 = currentY3;
                            break;
                        }
                    case 'Q':
                        k = k2;
                        path2.quadTo(val[k + 0], val[k + 1], val[k + 2], val[k + 3]);
                        ctrlPointX2 = val[k + 0];
                        ctrlPointY2 = val[k + 1];
                        currentX2 = val[k + 2];
                        currentSegmentStartY3 = val[k + 3];
                        break;
                    case 'S':
                        float currentY4 = currentSegmentStartY3;
                        k = k2;
                        char previousCmd3 = previousCmd2;
                        float currentX5 = currentX2;
                        if (previousCmd3 != 'c' && previousCmd3 != 's' && previousCmd3 != 'C' && previousCmd3 != 'S') {
                            reflectiveCtrlPointX = currentX5;
                            reflectiveCtrlPointY = currentY4;
                        } else {
                            float reflectiveCtrlPointX3 = (currentX5 * 2.0f) - ctrlPointX2;
                            float reflectiveCtrlPointY3 = (currentY4 * 2.0f) - ctrlPointY2;
                            reflectiveCtrlPointX = reflectiveCtrlPointX3;
                            reflectiveCtrlPointY = reflectiveCtrlPointY3;
                        }
                        path.cubicTo(reflectiveCtrlPointX, reflectiveCtrlPointY, val[k + 0], val[k + 1], val[k + 2], val[k + 3]);
                        ctrlPointX2 = val[k + 0];
                        ctrlPointY2 = val[k + 1];
                        currentX2 = val[k + 2];
                        currentSegmentStartY3 = val[k + 3];
                        break;
                    case 'T':
                        float currentY5 = currentSegmentStartY3;
                        k = k2;
                        char previousCmd4 = previousCmd2;
                        float currentX6 = currentX2;
                        float reflectiveCtrlPointX4 = currentX6;
                        float reflectiveCtrlPointY4 = currentY5;
                        if (previousCmd4 == 'q' || previousCmd4 == 't' || previousCmd4 == 'Q' || previousCmd4 == 'T') {
                            reflectiveCtrlPointX4 = (currentX6 * 2.0f) - ctrlPointX2;
                            reflectiveCtrlPointY4 = (currentY5 * 2.0f) - ctrlPointY2;
                        }
                        path2.quadTo(reflectiveCtrlPointX4, reflectiveCtrlPointY4, val[k + 0], val[k + 1]);
                        ctrlPointX2 = reflectiveCtrlPointX4;
                        ctrlPointY2 = reflectiveCtrlPointY4;
                        currentX2 = val[k + 0];
                        currentSegmentStartY3 = val[k + 1];
                        break;
                    case 'V':
                        float currentX7 = currentX2;
                        k = k2;
                        path2 = path;
                        path2.lineTo(currentX7, val[k + 0]);
                        currentSegmentStartY3 = val[k + 0];
                        currentX2 = currentX7;
                        break;
                    case 'a':
                        float currentY6 = currentSegmentStartY3;
                        k = k2;
                        c(path, currentX2, currentY6, val[k2 + 5] + currentX2, val[k2 + 6] + currentY6, val[k2 + 0], val[k2 + 1], val[k2 + 2], val[k2 + 3] != 0.0f, val[k2 + 4] != 0.0f);
                        currentX2 += val[k + 5];
                        currentSegmentStartY3 = currentY6 + val[k + 6];
                        path2 = path;
                        ctrlPointX2 = currentX2;
                        ctrlPointY2 = currentSegmentStartY3;
                        break;
                    case 'c':
                        float currentY7 = currentSegmentStartY3;
                        path.rCubicTo(val[k2 + 0], val[k2 + 1], val[k2 + 2], val[k2 + 3], val[k2 + 4], val[k2 + 5]);
                        float ctrlPointX3 = val[k2 + 2] + currentX2;
                        float ctrlPointY3 = currentY7 + val[k2 + 3];
                        currentX2 += val[k2 + 4];
                        ctrlPointX2 = ctrlPointX3;
                        ctrlPointY2 = ctrlPointY3;
                        k = k2;
                        currentSegmentStartY3 = val[k2 + 5] + currentY7;
                        break;
                    case 'h':
                        path2.rLineTo(val[k2 + 0], 0.0f);
                        currentX2 += val[k2 + 0];
                        k = k2;
                        break;
                    case 'l':
                        path2.rLineTo(val[k2 + 0], val[k2 + 1]);
                        currentX2 += val[k2 + 0];
                        currentSegmentStartY3 += val[k2 + 1];
                        k = k2;
                        break;
                    case 'm':
                        currentX2 += val[k2 + 0];
                        currentSegmentStartY3 += val[k2 + 1];
                        if (k2 > 0) {
                            path2.rLineTo(val[k2 + 0], val[k2 + 1]);
                            k = k2;
                            break;
                        } else {
                            path2.rMoveTo(val[k2 + 0], val[k2 + 1]);
                            currentSegmentStartX2 = currentX2;
                            currentSegmentStartY2 = currentSegmentStartY3;
                            k = k2;
                            break;
                        }
                    case 'q':
                        float currentY8 = currentSegmentStartY3;
                        path2.rQuadTo(val[k2 + 0], val[k2 + 1], val[k2 + 2], val[k2 + 3]);
                        float ctrlPointX4 = val[k2 + 0] + currentX2;
                        float ctrlPointY4 = currentY8 + val[k2 + 1];
                        currentX2 += val[k2 + 2];
                        ctrlPointX2 = ctrlPointX4;
                        ctrlPointY2 = ctrlPointY4;
                        k = k2;
                        currentSegmentStartY3 = val[k2 + 3] + currentY8;
                        break;
                    case 's':
                        if (previousCmd2 != 'c' && previousCmd2 != 's' && previousCmd2 != 'C' && previousCmd2 != 'S') {
                            reflectiveCtrlPointX2 = 0.0f;
                            reflectiveCtrlPointY2 = 0.0f;
                        } else {
                            float reflectiveCtrlPointX5 = currentX2 - ctrlPointX2;
                            float reflectiveCtrlPointY5 = currentSegmentStartY3 - ctrlPointY2;
                            reflectiveCtrlPointX2 = reflectiveCtrlPointX5;
                            reflectiveCtrlPointY2 = reflectiveCtrlPointY5;
                        }
                        float currentY9 = currentSegmentStartY3;
                        path.rCubicTo(reflectiveCtrlPointX2, reflectiveCtrlPointY2, val[k2 + 0], val[k2 + 1], val[k2 + 2], val[k2 + 3]);
                        float ctrlPointX5 = val[k2 + 0] + currentX2;
                        float ctrlPointY5 = currentY9 + val[k2 + 1];
                        currentX2 += val[k2 + 2];
                        ctrlPointX2 = ctrlPointX5;
                        ctrlPointY2 = ctrlPointY5;
                        k = k2;
                        currentSegmentStartY3 = val[k2 + 3] + currentY9;
                        break;
                    case 't':
                        float reflectiveCtrlPointX6 = 0.0f;
                        float reflectiveCtrlPointY6 = 0.0f;
                        if (previousCmd2 == 'q' || previousCmd2 == 't' || previousCmd2 == 'Q' || previousCmd2 == 'T') {
                            reflectiveCtrlPointX6 = currentX2 - ctrlPointX2;
                            reflectiveCtrlPointY6 = currentSegmentStartY3 - ctrlPointY2;
                        }
                        path2.rQuadTo(reflectiveCtrlPointX6, reflectiveCtrlPointY6, val[k2 + 0], val[k2 + 1]);
                        float ctrlPointX6 = currentX2 + reflectiveCtrlPointX6;
                        float ctrlPointY6 = currentSegmentStartY3 + reflectiveCtrlPointY6;
                        currentX2 += val[k2 + 0];
                        currentSegmentStartY3 += val[k2 + 1];
                        ctrlPointX2 = ctrlPointX6;
                        ctrlPointY2 = ctrlPointY6;
                        k = k2;
                        break;
                    case 'v':
                        path2.rLineTo(0.0f, val[k2 + 0]);
                        currentSegmentStartY3 += val[k2 + 0];
                        k = k2;
                        break;
                    default:
                        k = k2;
                        break;
                }
                previousCmd2 = cmd;
                k2 = k + incr;
            }
            current[0] = currentX2;
            current[1] = currentSegmentStartY3;
            current[2] = ctrlPointX2;
            current[3] = ctrlPointY2;
            current[4] = currentSegmentStartX2;
            current[5] = currentSegmentStartY2;
        }

        public static void c(Path p, float x0, float y0, float x1, float y1, float a2, float b2, float theta, boolean isMoreThanHalf, boolean isPositiveArc) {
            double cx;
            double cy;
            double thetaD = Math.toRadians(theta);
            double cosTheta = Math.cos(thetaD);
            double sinTheta = Math.sin(thetaD);
            double d = x0;
            Double.isNaN(d);
            double d2 = y0;
            Double.isNaN(d2);
            double d3 = (d * cosTheta) + (d2 * sinTheta);
            double d4 = a2;
            Double.isNaN(d4);
            double x0p = d3 / d4;
            double d5 = -x0;
            Double.isNaN(d5);
            double d6 = y0;
            Double.isNaN(d6);
            double d7 = (d5 * sinTheta) + (d6 * cosTheta);
            double d8 = b2;
            Double.isNaN(d8);
            double y0p = d7 / d8;
            double d9 = x1;
            Double.isNaN(d9);
            double d10 = y1;
            Double.isNaN(d10);
            double d11 = (d9 * cosTheta) + (d10 * sinTheta);
            double d12 = a2;
            Double.isNaN(d12);
            double x1p = d11 / d12;
            double d13 = -x1;
            Double.isNaN(d13);
            double d14 = y1;
            Double.isNaN(d14);
            double d15 = (d13 * sinTheta) + (d14 * cosTheta);
            double d16 = b2;
            Double.isNaN(d16);
            double y1p = d15 / d16;
            double dx = x0p - x1p;
            double dy = y0p - y1p;
            double xm = (x0p + x1p) / 2.0d;
            double ym = (y0p + y1p) / 2.0d;
            double dsq = (dx * dx) + (dy * dy);
            if (dsq == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double disc = (1.0d / dsq) - 0.25d;
            if (disc < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + dsq);
                float adjust = (float) (Math.sqrt(dsq) / 1.99999d);
                c(p, x0, y0, x1, y1, a2 * adjust, b2 * adjust, theta, isMoreThanHalf, isPositiveArc);
                return;
            }
            double s = Math.sqrt(disc);
            double sdx = s * dx;
            double sdy = s * dy;
            if (isMoreThanHalf == isPositiveArc) {
                cx = xm - sdy;
                cy = ym + sdx;
            } else {
                cx = xm + sdy;
                cy = ym - sdx;
            }
            double eta0 = Math.atan2(y0p - cy, x0p - cx);
            double sweep = Math.atan2(y1p - cy, x1p - cx) - eta0;
            if (isPositiveArc != (sweep >= 0.0d)) {
                if (sweep > 0.0d) {
                    sweep -= 6.283185307179586d;
                } else {
                    sweep += 6.283185307179586d;
                }
            }
            double eta1 = a2;
            Double.isNaN(eta1);
            double cx2 = cx * eta1;
            double d17 = b2;
            Double.isNaN(d17);
            double cy2 = d17 * cy;
            double cx3 = (cx2 * cosTheta) - (cy2 * sinTheta);
            double cy3 = (cx2 * sinTheta) + (cy2 * cosTheta);
            double cy4 = a2;
            b(p, cx3, cy3, cy4, b2, x0, y0, thetaD, eta0, sweep);
        }

        public static void b(Path p, double cx, double cy, double a2, double b2, double e1x, double e1y, double theta, double start, double sweep) {
            double d = a2;
            int numSegments = (int) Math.ceil(Math.abs((sweep * 4.0d) / 3.141592653589793d));
            double cosTheta = Math.cos(theta);
            double sinTheta = Math.sin(theta);
            double cosEta1 = Math.cos(start);
            double sinEta1 = Math.sin(start);
            double ep1x = (((-d) * cosTheta) * sinEta1) - ((b2 * sinTheta) * cosEta1);
            double ep1x2 = -d;
            double ep1y = (ep1x2 * sinTheta * sinEta1) + (b2 * cosTheta * cosEta1);
            double ep1y2 = ep1y;
            double ep1y3 = numSegments;
            Double.isNaN(ep1y3);
            double anglePerSegment = sweep / ep1y3;
            double eta1 = start;
            int i = 0;
            double eta12 = e1x;
            double ep1x3 = ep1x;
            double e1y2 = e1y;
            while (i < numSegments) {
                double eta2 = eta1 + anglePerSegment;
                double sinEta2 = Math.sin(eta2);
                double cosEta2 = Math.cos(eta2);
                double anglePerSegment2 = anglePerSegment;
                double anglePerSegment3 = (cx + ((d * cosTheta) * cosEta2)) - ((b2 * sinTheta) * sinEta2);
                double cosEta12 = cosEta1;
                double cosEta13 = cy + (d * sinTheta * cosEta2) + (b2 * cosTheta * sinEta2);
                double sinEta12 = sinEta1;
                double ep2x = (((-d) * cosTheta) * sinEta2) - ((b2 * sinTheta) * cosEta2);
                double e2y = -d;
                double ep2y = (e2y * sinTheta * sinEta2) + (b2 * cosTheta * cosEta2);
                double tanDiff2 = Math.tan((eta2 - eta1) / 2.0d);
                double alpha = (Math.sin(eta2 - eta1) * (Math.sqrt(((tanDiff2 * 3.0d) * tanDiff2) + 4.0d) - 1.0d)) / 3.0d;
                double q1x = eta12 + (alpha * ep1x3);
                int numSegments2 = numSegments;
                double q1y = e1y2 + (alpha * ep1y2);
                double q2x = anglePerSegment3 - (alpha * ep2x);
                double q2y = cosEta13 - (alpha * ep2y);
                p.rLineTo(0.0f, 0.0f);
                p.cubicTo((float) q1x, (float) q1y, (float) q2x, (float) q2y, (float) anglePerSegment3, (float) cosEta13);
                eta1 = eta2;
                eta12 = anglePerSegment3;
                e1y2 = cosEta13;
                ep1x3 = ep2x;
                ep1y2 = ep2y;
                i++;
                numSegments = numSegments2;
                sinEta1 = sinEta12;
                anglePerSegment = anglePerSegment2;
                cosEta1 = cosEta12;
                cosTheta = cosTheta;
                sinTheta = sinTheta;
                d = a2;
            }
        }
    }
}
