package a.f.c;

import a.f.c.e;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import net.sqlcipher.IBulkCursor;
import net.sqlcipher.database.SQLiteCursor;
import net.sqlcipher.database.SQLiteDatabase;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f313a = {0, 4, 8};

    /* renamed from: b, reason: collision with root package name */
    public static SparseIntArray f314b = new SparseIntArray();
    public static SparseIntArray c = new SparseIntArray();
    public HashMap<String, a.f.c.a> d = new HashMap<>();
    public boolean e = true;
    public HashMap<Integer, a> f = new HashMap<>();

    static {
        SparseIntArray sparseIntArray = f314b;
        int[] iArr = i.f329a;
        sparseIntArray.append(81, 25);
        f314b.append(82, 26);
        f314b.append(84, 29);
        f314b.append(85, 30);
        f314b.append(91, 36);
        f314b.append(90, 35);
        f314b.append(62, 4);
        f314b.append(61, 3);
        f314b.append(57, 1);
        f314b.append(59, 91);
        f314b.append(58, 92);
        f314b.append(100, 6);
        f314b.append(101, 7);
        f314b.append(69, 17);
        f314b.append(70, 18);
        f314b.append(71, 19);
        f314b.append(0, 27);
        f314b.append(86, 32);
        f314b.append(87, 33);
        f314b.append(68, 10);
        f314b.append(67, 9);
        f314b.append(105, 13);
        f314b.append(108, 16);
        f314b.append(106, 14);
        f314b.append(103, 11);
        f314b.append(107, 15);
        f314b.append(104, 12);
        f314b.append(94, 40);
        f314b.append(79, 39);
        f314b.append(78, 41);
        f314b.append(93, 42);
        f314b.append(77, 20);
        f314b.append(92, 37);
        f314b.append(66, 5);
        f314b.append(80, 87);
        f314b.append(89, 87);
        f314b.append(83, 87);
        f314b.append(60, 87);
        f314b.append(56, 87);
        f314b.append(5, 24);
        f314b.append(7, 28);
        f314b.append(23, 31);
        f314b.append(24, 8);
        f314b.append(6, 34);
        f314b.append(8, 2);
        f314b.append(3, 23);
        f314b.append(4, 21);
        f314b.append(95, 95);
        f314b.append(72, 96);
        f314b.append(2, 22);
        f314b.append(13, 43);
        f314b.append(26, 44);
        f314b.append(21, 45);
        f314b.append(22, 46);
        f314b.append(20, 60);
        f314b.append(18, 47);
        f314b.append(19, 48);
        f314b.append(14, 49);
        f314b.append(15, 50);
        f314b.append(16, 51);
        f314b.append(17, 52);
        f314b.append(25, 53);
        f314b.append(96, 54);
        f314b.append(73, 55);
        f314b.append(97, 56);
        f314b.append(74, 57);
        f314b.append(98, 58);
        f314b.append(75, 59);
        f314b.append(63, 61);
        f314b.append(65, 62);
        f314b.append(64, 63);
        f314b.append(28, 64);
        f314b.append(120, 65);
        f314b.append(35, 66);
        f314b.append(121, 67);
        f314b.append(112, 79);
        f314b.append(1, 38);
        f314b.append(111, 68);
        f314b.append(99, 69);
        f314b.append(76, 70);
        f314b.append(110, 97);
        f314b.append(32, 71);
        f314b.append(30, 72);
        f314b.append(31, 73);
        f314b.append(33, 74);
        f314b.append(29, 75);
        f314b.append(113, 76);
        f314b.append(88, 77);
        f314b.append(122, 78);
        f314b.append(55, 80);
        f314b.append(54, 81);
        f314b.append(115, 82);
        f314b.append(119, 83);
        f314b.append(118, 84);
        f314b.append(117, 85);
        f314b.append(116, 86);
        c.append(84, 6);
        c.append(84, 7);
        c.append(0, 27);
        c.append(88, 13);
        c.append(91, 16);
        c.append(89, 14);
        c.append(86, 11);
        c.append(90, 15);
        c.append(87, 12);
        c.append(77, 40);
        c.append(70, 39);
        c.append(69, 41);
        c.append(76, 42);
        c.append(68, 20);
        c.append(75, 37);
        c.append(59, 5);
        c.append(71, 87);
        c.append(74, 87);
        c.append(72, 87);
        c.append(56, 87);
        c.append(55, 87);
        c.append(5, 24);
        c.append(7, 28);
        c.append(23, 31);
        c.append(24, 8);
        c.append(6, 34);
        c.append(8, 2);
        c.append(3, 23);
        c.append(4, 21);
        c.append(78, 95);
        c.append(63, 96);
        c.append(2, 22);
        c.append(13, 43);
        c.append(26, 44);
        c.append(21, 45);
        c.append(22, 46);
        c.append(20, 60);
        c.append(18, 47);
        c.append(19, 48);
        c.append(14, 49);
        c.append(15, 50);
        c.append(16, 51);
        c.append(17, 52);
        c.append(25, 53);
        c.append(79, 54);
        c.append(64, 55);
        c.append(80, 56);
        c.append(65, 57);
        c.append(81, 58);
        c.append(66, 59);
        c.append(58, 62);
        c.append(57, 63);
        c.append(28, 64);
        c.append(104, 65);
        c.append(34, 66);
        c.append(105, 67);
        c.append(95, 79);
        c.append(1, 38);
        c.append(96, 98);
        c.append(94, 68);
        c.append(82, 69);
        c.append(67, 70);
        c.append(32, 71);
        c.append(30, 72);
        c.append(31, 73);
        c.append(33, 74);
        c.append(29, 75);
        c.append(97, 76);
        c.append(73, 77);
        c.append(106, 78);
        c.append(54, 80);
        c.append(53, 81);
        c.append(99, 82);
        c.append(103, 83);
        c.append(102, 84);
        c.append(101, 85);
        c.append(100, 86);
        c.append(93, 97);
    }

    public static void p(Object data, TypedArray a2, int attr, int orientation) {
        if (data == null) {
            return;
        }
        TypedValue v = a2.peekValue(attr);
        int type = v.type;
        int finalValue = 0;
        boolean finalConstrained = false;
        switch (type) {
            case 3:
                q(data, a2.getString(attr), orientation);
                return;
            case 4:
            default:
                int value = a2.getInt(attr, 0);
                switch (value) {
                    case -4:
                        finalValue = -2;
                        finalConstrained = true;
                        break;
                    case -3:
                        finalValue = 0;
                        break;
                    case -2:
                    case SQLiteCursor.NO_COUNT /* -1 */:
                        finalValue = value;
                        break;
                }
            case 5:
                finalValue = a2.getDimensionPixelSize(attr, 0);
                break;
        }
        if (data instanceof ConstraintLayout.a) {
            ConstraintLayout.a params = (ConstraintLayout.a) data;
            if (orientation == 0) {
                ((ViewGroup.MarginLayoutParams) params).width = finalValue;
                params.V = finalConstrained;
                return;
            } else {
                ((ViewGroup.MarginLayoutParams) params).height = finalValue;
                params.W = finalConstrained;
                return;
            }
        }
        if (data instanceof b) {
            b params2 = (b) data;
            if (orientation == 0) {
                params2.d = finalValue;
                params2.m0 = finalConstrained;
                return;
            } else {
                params2.e = finalValue;
                params2.n0 = finalConstrained;
                return;
            }
        }
        if (data instanceof a.C0015a) {
            a.C0015a params3 = (a.C0015a) data;
            if (orientation == 0) {
                params3.b(23, finalValue);
                params3.d(80, finalConstrained);
            } else {
                params3.b(21, finalValue);
                params3.d(81, finalConstrained);
            }
        }
    }

    public static void r(ConstraintLayout.a params, String value) {
        int commaIndex;
        int dimensionRatioSide = -1;
        if (value != null) {
            int len = value.length();
            int commaIndex2 = value.indexOf(44);
            if (commaIndex2 > 0 && commaIndex2 < len - 1) {
                String dimension = value.substring(0, commaIndex2);
                if (dimension.equalsIgnoreCase("W")) {
                    dimensionRatioSide = 0;
                } else if (dimension.equalsIgnoreCase("H")) {
                    dimensionRatioSide = 1;
                }
                commaIndex = commaIndex2 + 1;
            } else {
                commaIndex = 0;
            }
            int colonIndex = value.indexOf(58);
            if (colonIndex >= 0 && colonIndex < len - 1) {
                String nominator = value.substring(commaIndex, colonIndex);
                String denominator = value.substring(colonIndex + 1);
                if (nominator.length() > 0 && denominator.length() > 0) {
                    try {
                        float nominatorValue = Float.parseFloat(nominator);
                        float denominatorValue = Float.parseFloat(denominator);
                        if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                            if (dimensionRatioSide == 1) {
                                Math.abs(denominatorValue / nominatorValue);
                            } else {
                                Math.abs(nominatorValue / denominatorValue);
                            }
                        }
                    } catch (NumberFormatException e2) {
                    }
                }
            } else {
                String r = value.substring(commaIndex);
                if (r.length() > 0) {
                    try {
                        Float.parseFloat(r);
                    } catch (NumberFormatException e3) {
                    }
                }
            }
        }
        params.F = value;
        params.getClass();
        params.getClass();
    }

    public static void q(Object data, String value, int orientation) {
        if (value == null) {
            return;
        }
        int equalIndex = value.indexOf(61);
        int len = value.length();
        if (equalIndex > 0 && equalIndex < len - 1) {
            String key = value.substring(0, equalIndex);
            String val = value.substring(equalIndex + 1);
            if (val.length() > 0) {
                String key2 = key.trim();
                String val2 = val.trim();
                if ("ratio".equalsIgnoreCase(key2)) {
                    if (data instanceof ConstraintLayout.a) {
                        ConstraintLayout.a params = (ConstraintLayout.a) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) params).width = 0;
                        } else {
                            ((ViewGroup.MarginLayoutParams) params).height = 0;
                        }
                        r(params, val2);
                        return;
                    }
                    if (data instanceof b) {
                        ((b) data).z = val2;
                        return;
                    } else {
                        if (data instanceof a.C0015a) {
                            ((a.C0015a) data).c(5, val2);
                            return;
                        }
                        return;
                    }
                }
                if ("weight".equalsIgnoreCase(key2)) {
                    try {
                        float weight = Float.parseFloat(val2);
                        if (data instanceof ConstraintLayout.a) {
                            ConstraintLayout.a params2 = (ConstraintLayout.a) data;
                            if (orientation == 0) {
                                ((ViewGroup.MarginLayoutParams) params2).width = 0;
                                params2.G = weight;
                            } else {
                                ((ViewGroup.MarginLayoutParams) params2).height = 0;
                                params2.H = weight;
                            }
                            return;
                        }
                        if (data instanceof b) {
                            b params3 = (b) data;
                            if (orientation == 0) {
                                params3.d = 0;
                                params3.V = weight;
                                return;
                            } else {
                                params3.e = 0;
                                params3.U = weight;
                                return;
                            }
                        }
                        if (data instanceof a.C0015a) {
                            a.C0015a params4 = (a.C0015a) data;
                            if (orientation == 0) {
                                params4.b(23, 0);
                                params4.a(39, weight);
                                return;
                            } else {
                                params4.b(21, 0);
                                params4.a(40, weight);
                                return;
                            }
                        }
                        return;
                    } catch (NumberFormatException e2) {
                        return;
                    }
                }
                if ("parent".equalsIgnoreCase(key2)) {
                    try {
                        float percent = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(val2)));
                        if (data instanceof ConstraintLayout.a) {
                            ConstraintLayout.a params5 = (ConstraintLayout.a) data;
                            if (orientation == 0) {
                                ((ViewGroup.MarginLayoutParams) params5).width = 0;
                                params5.Q = percent;
                                params5.K = 2;
                            } else {
                                ((ViewGroup.MarginLayoutParams) params5).height = 0;
                                params5.R = percent;
                                params5.L = 2;
                            }
                            return;
                        }
                        if (data instanceof b) {
                            b params6 = (b) data;
                            if (orientation == 0) {
                                params6.d = 0;
                                params6.e0 = percent;
                                params6.Y = 2;
                                return;
                            } else {
                                params6.e = 0;
                                params6.f0 = percent;
                                params6.Z = 2;
                                return;
                            }
                        }
                        if (data instanceof a.C0015a) {
                            a.C0015a params7 = (a.C0015a) data;
                            if (orientation == 0) {
                                params7.b(23, 0);
                                params7.b(54, 2);
                            } else {
                                params7.b(21, 0);
                                params7.b(55, 2);
                            }
                        }
                    } catch (NumberFormatException e3) {
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f319a;
        public int d;
        public int e;
        public int[] j0;
        public String k0;
        public String l0;

        /* renamed from: b, reason: collision with root package name */
        public boolean f320b = false;
        public boolean c = false;
        public int f = -1;
        public int g = -1;
        public float h = -1.0f;
        public int i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public float x = 0.5f;
        public float y = 0.5f;
        public String z = null;
        public int A = -1;
        public int B = 0;
        public float C = 0.0f;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public float U = -1.0f;
        public float V = -1.0f;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;
        public int a0 = -1;
        public int b0 = -1;
        public int c0 = -1;
        public int d0 = -1;
        public float e0 = 1.0f;
        public float f0 = 1.0f;
        public int g0 = -1;
        public int h0 = 0;
        public int i0 = -1;
        public boolean m0 = false;
        public boolean n0 = false;
        public boolean o0 = true;
        public int p0 = 0;

        public void a(b src) {
            this.f320b = src.f320b;
            this.d = src.d;
            this.c = src.c;
            this.e = src.e;
            this.f = src.f;
            this.g = src.g;
            this.h = src.h;
            this.i = src.i;
            this.j = src.j;
            this.k = src.k;
            this.l = src.l;
            this.m = src.m;
            this.n = src.n;
            this.o = src.o;
            this.p = src.p;
            this.q = src.q;
            this.r = src.r;
            this.s = src.s;
            this.t = src.t;
            this.u = src.u;
            this.v = src.v;
            this.w = src.w;
            this.x = src.x;
            this.y = src.y;
            this.z = src.z;
            this.A = src.A;
            this.B = src.B;
            this.C = src.C;
            this.D = src.D;
            this.E = src.E;
            this.F = src.F;
            this.G = src.G;
            this.H = src.H;
            this.I = src.I;
            this.J = src.J;
            this.K = src.K;
            this.L = src.L;
            this.M = src.M;
            this.N = src.N;
            this.O = src.O;
            this.P = src.P;
            this.Q = src.Q;
            this.R = src.R;
            this.S = src.S;
            this.T = src.T;
            this.U = src.U;
            this.V = src.V;
            this.W = src.W;
            this.X = src.X;
            this.Y = src.Y;
            this.Z = src.Z;
            this.a0 = src.a0;
            this.b0 = src.b0;
            this.c0 = src.c0;
            this.d0 = src.d0;
            this.e0 = src.e0;
            this.f0 = src.f0;
            this.g0 = src.g0;
            this.h0 = src.h0;
            this.i0 = src.i0;
            this.l0 = src.l0;
            int[] iArr = src.j0;
            if (iArr != null && src.k0 == null) {
                this.j0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.j0 = null;
            }
            this.k0 = src.k0;
            this.m0 = src.m0;
            this.n0 = src.n0;
            this.o0 = src.o0;
            this.p0 = src.p0;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f319a = sparseIntArray;
            int[] iArr = i.f329a;
            sparseIntArray.append(42, 24);
            f319a.append(43, 25);
            f319a.append(45, 28);
            f319a.append(46, 29);
            f319a.append(51, 35);
            f319a.append(50, 34);
            f319a.append(23, 4);
            f319a.append(22, 3);
            f319a.append(18, 1);
            f319a.append(60, 6);
            f319a.append(61, 7);
            f319a.append(30, 17);
            f319a.append(31, 18);
            f319a.append(32, 19);
            f319a.append(0, 26);
            f319a.append(47, 31);
            f319a.append(48, 32);
            f319a.append(29, 10);
            f319a.append(28, 9);
            f319a.append(65, 13);
            f319a.append(68, 16);
            f319a.append(66, 14);
            f319a.append(63, 11);
            f319a.append(67, 15);
            f319a.append(64, 12);
            f319a.append(54, 38);
            f319a.append(40, 37);
            f319a.append(39, 39);
            f319a.append(53, 40);
            f319a.append(38, 20);
            f319a.append(52, 36);
            f319a.append(27, 5);
            f319a.append(41, 76);
            f319a.append(49, 76);
            f319a.append(44, 76);
            f319a.append(21, 76);
            f319a.append(17, 76);
            f319a.append(3, 23);
            f319a.append(5, 27);
            f319a.append(7, 30);
            f319a.append(8, 8);
            f319a.append(4, 33);
            f319a.append(6, 2);
            f319a.append(1, 22);
            f319a.append(2, 21);
            f319a.append(55, 41);
            f319a.append(33, 42);
            f319a.append(16, 41);
            f319a.append(15, 42);
            f319a.append(70, 97);
            f319a.append(24, 61);
            f319a.append(26, 62);
            f319a.append(25, 63);
            f319a.append(59, 69);
            f319a.append(37, 70);
            f319a.append(12, 71);
            f319a.append(10, 72);
            f319a.append(11, 73);
            f319a.append(13, 74);
            f319a.append(9, 75);
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray a2 = context.obtainStyledAttributes(attrs, i.f);
            this.c = true;
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                switch (f319a.get(attr)) {
                    case 1:
                        this.q = d.o(a2, attr, this.q);
                        break;
                    case 2:
                        this.J = a2.getDimensionPixelSize(attr, this.J);
                        break;
                    case 3:
                        this.p = d.o(a2, attr, this.p);
                        break;
                    case 4:
                        this.o = d.o(a2, attr, this.o);
                        break;
                    case 5:
                        this.z = a2.getString(attr);
                        break;
                    case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                        this.D = a2.getDimensionPixelOffset(attr, this.D);
                        break;
                    case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                        this.E = a2.getDimensionPixelOffset(attr, this.E);
                        break;
                    case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.K = a2.getDimensionPixelSize(attr, this.K);
                            break;
                        } else {
                            break;
                        }
                    case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                        this.w = d.o(a2, attr, this.w);
                        break;
                    case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                        this.v = d.o(a2, attr, this.v);
                        break;
                    case IBulkCursor.RESPOND_TRANSACTION /* 11 */:
                        this.Q = a2.getDimensionPixelSize(attr, this.Q);
                        break;
                    case IBulkCursor.CLOSE_TRANSACTION /* 12 */:
                        this.R = a2.getDimensionPixelSize(attr, this.R);
                        break;
                    case 13:
                        this.N = a2.getDimensionPixelSize(attr, this.N);
                        break;
                    case 14:
                        this.P = a2.getDimensionPixelSize(attr, this.P);
                        break;
                    case 15:
                        this.S = a2.getDimensionPixelSize(attr, this.S);
                        break;
                    case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                        this.O = a2.getDimensionPixelSize(attr, this.O);
                        break;
                    case 17:
                        this.f = a2.getDimensionPixelOffset(attr, this.f);
                        break;
                    case 18:
                        this.g = a2.getDimensionPixelOffset(attr, this.g);
                        break;
                    case 19:
                        this.h = a2.getFloat(attr, this.h);
                        break;
                    case 20:
                        this.x = a2.getFloat(attr, this.x);
                        break;
                    case 21:
                        this.e = a2.getLayoutDimension(attr, this.e);
                        break;
                    case 22:
                        this.d = a2.getLayoutDimension(attr, this.d);
                        break;
                    case 23:
                        this.G = a2.getDimensionPixelSize(attr, this.G);
                        break;
                    case 24:
                        this.i = d.o(a2, attr, this.i);
                        break;
                    case 25:
                        this.j = d.o(a2, attr, this.j);
                        break;
                    case 26:
                        this.F = a2.getInt(attr, this.F);
                        break;
                    case 27:
                        this.H = a2.getDimensionPixelSize(attr, this.H);
                        break;
                    case 28:
                        this.k = d.o(a2, attr, this.k);
                        break;
                    case 29:
                        this.l = d.o(a2, attr, this.l);
                        break;
                    case 30:
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.L = a2.getDimensionPixelSize(attr, this.L);
                            break;
                        } else {
                            break;
                        }
                    case 31:
                        this.t = d.o(a2, attr, this.t);
                        break;
                    case 32:
                        this.u = d.o(a2, attr, this.u);
                        break;
                    case 33:
                        this.I = a2.getDimensionPixelSize(attr, this.I);
                        break;
                    case 34:
                        this.n = d.o(a2, attr, this.n);
                        break;
                    case 35:
                        this.m = d.o(a2, attr, this.m);
                        break;
                    case 36:
                        this.y = a2.getFloat(attr, this.y);
                        break;
                    case 37:
                        this.V = a2.getFloat(attr, this.V);
                        break;
                    case 38:
                        this.U = a2.getFloat(attr, this.U);
                        break;
                    case 39:
                        this.W = a2.getInt(attr, this.W);
                        break;
                    case 40:
                        this.X = a2.getInt(attr, this.X);
                        break;
                    case 41:
                        d.p(this, a2, attr, 0);
                        break;
                    case 42:
                        d.p(this, a2, attr, 1);
                        break;
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 60:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 78:
                    case 79:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 95:
                    case 96:
                    default:
                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(attr) + "   " + f319a.get(attr));
                        break;
                    case 54:
                        this.Y = a2.getInt(attr, this.Y);
                        break;
                    case 55:
                        this.Z = a2.getInt(attr, this.Z);
                        break;
                    case 56:
                        this.a0 = a2.getDimensionPixelSize(attr, this.a0);
                        break;
                    case 57:
                        this.b0 = a2.getDimensionPixelSize(attr, this.b0);
                        break;
                    case 58:
                        this.c0 = a2.getDimensionPixelSize(attr, this.c0);
                        break;
                    case 59:
                        this.d0 = a2.getDimensionPixelSize(attr, this.d0);
                        break;
                    case 61:
                        this.A = d.o(a2, attr, this.A);
                        break;
                    case 62:
                        this.B = a2.getDimensionPixelSize(attr, this.B);
                        break;
                    case 63:
                        this.C = a2.getFloat(attr, this.C);
                        break;
                    case 69:
                        this.e0 = a2.getFloat(attr, 1.0f);
                        break;
                    case 70:
                        this.f0 = a2.getFloat(attr, 1.0f);
                        break;
                    case 71:
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        this.g0 = a2.getInt(attr, this.g0);
                        break;
                    case 73:
                        this.h0 = a2.getDimensionPixelSize(attr, this.h0);
                        break;
                    case 74:
                        this.k0 = a2.getString(attr);
                        break;
                    case 75:
                        this.o0 = a2.getBoolean(attr, this.o0);
                        break;
                    case 76:
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(attr) + "   " + f319a.get(attr));
                        break;
                    case 77:
                        this.l0 = a2.getString(attr);
                        break;
                    case 80:
                        this.m0 = a2.getBoolean(attr, this.m0);
                        break;
                    case 81:
                        this.n0 = a2.getBoolean(attr, this.n0);
                        break;
                    case 91:
                        this.r = d.o(a2, attr, this.r);
                        break;
                    case 92:
                        this.s = d.o(a2, attr, this.s);
                        break;
                    case 93:
                        this.M = a2.getDimensionPixelSize(attr, this.M);
                        break;
                    case 94:
                        this.T = a2.getDimensionPixelSize(attr, this.T);
                        break;
                    case 97:
                        this.p0 = a2.getInt(attr, this.p0);
                        break;
                }
            }
            a2.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f325a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f326b = false;
        public float c = 0.0f;
        public float d = 0.0f;
        public float e = 0.0f;
        public float f = 1.0f;
        public float g = 1.0f;
        public float h = Float.NaN;
        public float i = Float.NaN;
        public int j = -1;
        public float k = 0.0f;
        public float l = 0.0f;
        public float m = 0.0f;
        public boolean n = false;
        public float o = 0.0f;

        public void a(e src) {
            this.f326b = src.f326b;
            this.c = src.c;
            this.d = src.d;
            this.e = src.e;
            this.f = src.f;
            this.g = src.g;
            this.h = src.h;
            this.i = src.i;
            this.j = src.j;
            this.k = src.k;
            this.l = src.l;
            this.m = src.m;
            this.n = src.n;
            this.o = src.o;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f325a = sparseIntArray;
            int[] iArr = i.f329a;
            sparseIntArray.append(6, 1);
            f325a.append(7, 2);
            f325a.append(8, 3);
            f325a.append(4, 4);
            f325a.append(5, 5);
            f325a.append(0, 6);
            f325a.append(1, 7);
            f325a.append(2, 8);
            f325a.append(3, 9);
            f325a.append(9, 10);
            f325a.append(10, 11);
            f325a.append(11, 12);
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray a2 = context.obtainStyledAttributes(attrs, i.k);
            this.f326b = true;
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                switch (f325a.get(attr)) {
                    case 1:
                        this.c = a2.getFloat(attr, this.c);
                        break;
                    case 2:
                        this.d = a2.getFloat(attr, this.d);
                        break;
                    case 3:
                        this.e = a2.getFloat(attr, this.e);
                        break;
                    case 4:
                        this.f = a2.getFloat(attr, this.f);
                        break;
                    case 5:
                        this.g = a2.getFloat(attr, this.g);
                        break;
                    case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                        this.h = a2.getDimension(attr, this.h);
                        break;
                    case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                        this.i = a2.getDimension(attr, this.i);
                        break;
                    case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                        this.k = a2.getDimension(attr, this.k);
                        break;
                    case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                        this.l = a2.getDimension(attr, this.l);
                        break;
                    case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.m = a2.getDimension(attr, this.m);
                            break;
                        } else {
                            break;
                        }
                    case IBulkCursor.RESPOND_TRANSACTION /* 11 */:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.n = true;
                            this.o = a2.getDimension(attr, this.o);
                            break;
                        } else {
                            break;
                        }
                    case IBulkCursor.CLOSE_TRANSACTION /* 12 */:
                        this.j = d.o(a2, attr, this.j);
                        break;
                }
            }
            a2.recycle();
        }
    }

    /* renamed from: a.f.c.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f323a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f324b = 0;
        public int c = 0;
        public float d = 1.0f;
        public float e = Float.NaN;

        public void a(C0016d src) {
            this.f323a = src.f323a;
            this.f324b = src.f324b;
            this.d = src.d;
            this.e = src.e;
            this.c = src.c;
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray a2 = context.obtainStyledAttributes(attrs, i.i);
            this.f323a = true;
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                int[] iArr = i.f329a;
                if (attr == 1) {
                    this.d = a2.getFloat(attr, this.d);
                } else if (attr == 0) {
                    this.f324b = a2.getInt(attr, this.f324b);
                    int[] unused = d.f313a;
                    this.f324b = d.f313a[this.f324b];
                } else if (attr == 4) {
                    this.c = a2.getInt(attr, this.c);
                } else if (attr == 3) {
                    this.e = a2.getFloat(attr, this.e);
                }
            }
            a2.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f321a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f322b = false;
        public int c = -1;
        public int d = 0;
        public String e = null;
        public int f = -1;
        public int g = 0;
        public float h = Float.NaN;
        public int i = -1;
        public float j = Float.NaN;
        public float k = Float.NaN;
        public int l = -1;
        public String m = null;
        public int n = -3;
        public int o = -1;

        public void a(c src) {
            this.f322b = src.f322b;
            this.c = src.c;
            this.e = src.e;
            this.f = src.f;
            this.g = src.g;
            this.j = src.j;
            this.h = src.h;
            this.i = src.i;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f321a = sparseIntArray;
            int[] iArr = i.f329a;
            sparseIntArray.append(3, 1);
            f321a.append(5, 2);
            f321a.append(9, 3);
            f321a.append(2, 4);
            f321a.append(1, 5);
            f321a.append(0, 6);
            f321a.append(4, 7);
            f321a.append(8, 8);
            f321a.append(7, 9);
            f321a.append(6, 10);
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray a2 = context.obtainStyledAttributes(attrs, i.g);
            this.f322b = true;
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                switch (f321a.get(attr)) {
                    case 1:
                        this.j = a2.getFloat(attr, this.j);
                        break;
                    case 2:
                        this.f = a2.getInt(attr, this.f);
                        break;
                    case 3:
                        TypedValue type = a2.peekValue(attr);
                        if (type.type == 3) {
                            this.e = a2.getString(attr);
                            break;
                        } else {
                            this.e = a.f.a.i.a.a.f269b[a2.getInteger(attr, 0)];
                            break;
                        }
                    case 4:
                        this.g = a2.getInt(attr, 0);
                        break;
                    case 5:
                        this.c = d.o(a2, attr, this.c);
                        break;
                    case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                        this.d = a2.getInteger(attr, this.d);
                        break;
                    case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                        this.h = a2.getFloat(attr, this.h);
                        break;
                    case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                        this.l = a2.getInteger(attr, this.l);
                        break;
                    case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                        this.k = a2.getFloat(attr, this.k);
                        break;
                    case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                        TypedValue type2 = a2.peekValue(attr);
                        int i2 = type2.type;
                        if (i2 == 1) {
                            int resourceId = a2.getResourceId(attr, -1);
                            this.o = resourceId;
                            if (resourceId != -1) {
                                this.n = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i2 == 3) {
                            String string = a2.getString(attr);
                            this.m = string;
                            if (string.indexOf("/") > 0) {
                                this.o = a2.getResourceId(attr, -1);
                                this.n = -2;
                                break;
                            } else {
                                this.n = -1;
                                break;
                            }
                        } else {
                            this.n = a2.getInteger(attr, this.o);
                            break;
                        }
                }
            }
            a2.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f315a;

        /* renamed from: b, reason: collision with root package name */
        public final C0016d f316b = new C0016d();
        public final c c = new c();
        public final b d = new b();
        public final e e = new e();
        public HashMap<String, a.f.c.a> f = new HashMap<>();
        public C0015a g;

        /* renamed from: a.f.c.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0015a {

            /* renamed from: a, reason: collision with root package name */
            public int[] f317a = new int[10];

            /* renamed from: b, reason: collision with root package name */
            public int[] f318b = new int[10];
            public int c = 0;
            public int[] d = new int[10];
            public float[] e = new float[10];
            public int f = 0;
            public int[] g = new int[5];
            public String[] h = new String[5];
            public int i = 0;
            public int[] j = new int[4];
            public boolean[] k = new boolean[4];
            public int l = 0;

            public void b(int type, int value) {
                int i = this.c;
                int[] iArr = this.f317a;
                if (i >= iArr.length) {
                    this.f317a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f318b;
                    this.f318b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f317a;
                int i2 = this.c;
                iArr3[i2] = type;
                int[] iArr4 = this.f318b;
                this.c = i2 + 1;
                iArr4[i2] = value;
            }

            public void a(int type, float value) {
                int i = this.f;
                int[] iArr = this.d;
                if (i >= iArr.length) {
                    this.d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.e;
                    this.e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.d;
                int i2 = this.f;
                iArr2[i2] = type;
                float[] fArr2 = this.e;
                this.f = i2 + 1;
                fArr2[i2] = value;
            }

            public void c(int type, String value) {
                int i = this.i;
                int[] iArr = this.g;
                if (i >= iArr.length) {
                    this.g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.h;
                    this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.g;
                int i2 = this.i;
                iArr2[i2] = type;
                String[] strArr2 = this.h;
                this.i = i2 + 1;
                strArr2[i2] = value;
            }

            public void d(int type, boolean value) {
                int i = this.l;
                int[] iArr = this.j;
                if (i >= iArr.length) {
                    this.j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.k;
                    this.k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.j;
                int i2 = this.l;
                iArr2[i2] = type;
                boolean[] zArr2 = this.k;
                this.l = i2 + 1;
                zArr2[i2] = value;
            }
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a clone = new a();
            clone.d.a(this.d);
            clone.c.a(this.c);
            clone.f316b.a(this.f316b);
            clone.e.a(this.e);
            clone.f315a = this.f315a;
            clone.g = this.g;
            return clone;
        }

        public final void h(a.f.c.b helper, int viewId, e.a param) {
            g(viewId, param);
            if (helper instanceof Barrier) {
                b bVar = this.d;
                bVar.i0 = 1;
                Barrier barrier = (Barrier) helper;
                bVar.g0 = barrier.getType();
                this.d.j0 = barrier.getReferencedIds();
                this.d.h0 = barrier.getMargin();
            }
        }

        public final void g(int viewId, e.a param) {
            f(viewId, param);
            this.f316b.d = param.r0;
            e eVar = this.e;
            eVar.c = param.u0;
            eVar.d = param.v0;
            eVar.e = param.w0;
            eVar.f = param.x0;
            eVar.g = param.y0;
            eVar.h = param.z0;
            eVar.i = param.A0;
            eVar.k = param.B0;
            eVar.l = param.C0;
            eVar.m = param.D0;
            eVar.o = param.t0;
            eVar.n = param.s0;
        }

        public final void f(int viewId, ConstraintLayout.a param) {
            this.f315a = viewId;
            b bVar = this.d;
            bVar.i = param.d;
            bVar.j = param.e;
            bVar.k = param.f;
            bVar.l = param.g;
            bVar.m = param.h;
            bVar.n = param.i;
            bVar.o = param.j;
            bVar.p = param.k;
            bVar.q = param.l;
            bVar.r = param.m;
            bVar.s = param.n;
            bVar.t = param.r;
            bVar.u = param.s;
            bVar.v = param.t;
            bVar.w = param.u;
            bVar.x = param.D;
            bVar.y = param.E;
            bVar.z = param.F;
            bVar.A = param.o;
            bVar.B = param.p;
            bVar.C = param.q;
            bVar.D = param.S;
            bVar.E = param.T;
            bVar.F = param.U;
            bVar.h = param.c;
            b bVar2 = this.d;
            bVar2.f = param.f836a;
            bVar2.g = param.f837b;
            bVar2.d = ((ViewGroup.MarginLayoutParams) param).width;
            bVar2.e = ((ViewGroup.MarginLayoutParams) param).height;
            bVar2.G = ((ViewGroup.MarginLayoutParams) param).leftMargin;
            bVar2.H = ((ViewGroup.MarginLayoutParams) param).rightMargin;
            bVar2.I = ((ViewGroup.MarginLayoutParams) param).topMargin;
            bVar2.J = ((ViewGroup.MarginLayoutParams) param).bottomMargin;
            bVar2.M = param.C;
            bVar2.U = param.H;
            bVar2.V = param.G;
            bVar2.X = param.J;
            bVar2.W = param.I;
            bVar2.m0 = param.V;
            bVar2.n0 = param.W;
            bVar2.Y = param.K;
            bVar2.Z = param.L;
            bVar2.a0 = param.O;
            bVar2.b0 = param.P;
            bVar2.c0 = param.M;
            bVar2.d0 = param.N;
            bVar2.e0 = param.Q;
            bVar2.f0 = param.R;
            bVar2.l0 = param.X;
            bVar2.O = param.w;
            b bVar3 = this.d;
            bVar3.Q = param.y;
            bVar3.N = param.v;
            bVar3.P = param.x;
            bVar3.S = param.z;
            bVar3.R = param.A;
            bVar3.T = param.B;
            bVar3.p0 = param.Y;
            int currentApiVersion = Build.VERSION.SDK_INT;
            if (currentApiVersion >= 17) {
                bVar3.K = param.getMarginEnd();
                this.d.L = param.getMarginStart();
            }
        }

        public void d(ConstraintLayout.a param) {
            b bVar = this.d;
            param.d = bVar.i;
            param.e = bVar.j;
            param.f = bVar.k;
            param.g = bVar.l;
            param.h = bVar.m;
            param.i = bVar.n;
            param.j = bVar.o;
            param.k = bVar.p;
            param.l = bVar.q;
            param.m = bVar.r;
            param.n = bVar.s;
            param.r = bVar.t;
            param.s = bVar.u;
            param.t = bVar.v;
            param.u = bVar.w;
            ((ViewGroup.MarginLayoutParams) param).leftMargin = bVar.G;
            ((ViewGroup.MarginLayoutParams) param).rightMargin = bVar.H;
            ((ViewGroup.MarginLayoutParams) param).topMargin = bVar.I;
            ((ViewGroup.MarginLayoutParams) param).bottomMargin = bVar.J;
            param.z = bVar.S;
            param.A = bVar.R;
            param.w = bVar.O;
            param.y = bVar.Q;
            param.D = bVar.x;
            param.E = bVar.y;
            b bVar2 = this.d;
            param.o = bVar2.A;
            param.p = bVar2.B;
            param.q = bVar2.C;
            param.F = bVar2.z;
            param.S = bVar2.D;
            param.T = bVar2.E;
            param.H = bVar2.U;
            param.G = bVar2.V;
            param.J = bVar2.X;
            param.I = bVar2.W;
            param.V = bVar2.m0;
            param.W = bVar2.n0;
            param.K = bVar2.Y;
            param.L = bVar2.Z;
            param.O = bVar2.a0;
            param.P = bVar2.b0;
            param.M = bVar2.c0;
            param.N = bVar2.d0;
            param.Q = bVar2.e0;
            param.R = bVar2.f0;
            param.U = bVar2.F;
            param.c = bVar2.h;
            param.f836a = bVar2.f;
            param.f837b = bVar2.g;
            ((ViewGroup.MarginLayoutParams) param).width = bVar2.d;
            b bVar3 = this.d;
            ((ViewGroup.MarginLayoutParams) param).height = bVar3.e;
            String str = bVar3.l0;
            if (str != null) {
                param.X = str;
            }
            param.Y = bVar3.p0;
            if (Build.VERSION.SDK_INT >= 17) {
                param.setMarginStart(bVar3.L);
                param.setMarginEnd(this.d.K);
            }
            param.a();
        }
    }

    public void f(Context context, int constraintLayoutId) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(constraintLayoutId, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int count = constraintLayout.getChildCount();
        this.f.clear();
        for (int i = 0; i < count; i++) {
            View view = constraintLayout.getChildAt(i);
            ConstraintLayout.a param = (ConstraintLayout.a) view.getLayoutParams();
            int id = view.getId();
            if (this.e && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f.containsKey(Integer.valueOf(id))) {
                this.f.put(Integer.valueOf(id), new a());
            }
            a constraint = this.f.get(Integer.valueOf(id));
            if (constraint != null) {
                constraint.f = a.f.c.a.a(this.d, view);
                constraint.f(id, param);
                constraint.f316b.f324b = view.getVisibility();
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 17) {
                    constraint.f316b.d = view.getAlpha();
                    constraint.e.c = view.getRotation();
                    constraint.e.d = view.getRotationX();
                    constraint.e.e = view.getRotationY();
                    constraint.e.f = view.getScaleX();
                    constraint.e.g = view.getScaleY();
                    float pivotX = view.getPivotX();
                    float pivotY = view.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        e eVar = constraint.e;
                        eVar.h = pivotX;
                        eVar.i = pivotY;
                    }
                    constraint.e.k = view.getTranslationX();
                    constraint.e.l = view.getTranslationY();
                    if (i2 >= 21) {
                        constraint.e.m = view.getTranslationZ();
                        e eVar2 = constraint.e;
                        if (eVar2.n) {
                            eVar2.o = view.getElevation();
                        }
                    }
                }
                if (view instanceof Barrier) {
                    Barrier barrier = (Barrier) view;
                    constraint.d.o0 = barrier.getAllowsGoneWidget();
                    constraint.d.j0 = barrier.getReferencedIds();
                    constraint.d.g0 = barrier.getType();
                    constraint.d.h0 = barrier.getMargin();
                }
            }
        }
    }

    public void h(a.f.c.e constraints) {
        int count = constraints.getChildCount();
        this.f.clear();
        for (int i = 0; i < count; i++) {
            View view = constraints.getChildAt(i);
            e.a param = (e.a) view.getLayoutParams();
            int id = view.getId();
            if (this.e && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f.containsKey(Integer.valueOf(id))) {
                this.f.put(Integer.valueOf(id), new a());
            }
            a constraint = this.f.get(Integer.valueOf(id));
            if (constraint != null) {
                if (view instanceof a.f.c.b) {
                    a.f.c.b helper = (a.f.c.b) view;
                    constraint.h(helper, id, param);
                }
                constraint.g(id, param);
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void d(ConstraintLayout constraintLayout, boolean applyPostLayout) {
        int count = constraintLayout.getChildCount();
        HashSet<Integer> used = new HashSet<>(this.f.keySet());
        for (int i = 0; i < count; i++) {
            View view = constraintLayout.getChildAt(i);
            int id = view.getId();
            if (this.f.containsKey(Integer.valueOf(id))) {
                if (this.e && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f.containsKey(Integer.valueOf(id))) {
                        used.remove(Integer.valueOf(id));
                        a constraint = this.f.get(Integer.valueOf(id));
                        if (constraint != null) {
                            if (view instanceof Barrier) {
                                constraint.d.i0 = 1;
                                Barrier barrier = (Barrier) view;
                                barrier.setId(id);
                                barrier.setType(constraint.d.g0);
                                barrier.setMargin(constraint.d.h0);
                                barrier.setAllowsGoneWidget(constraint.d.o0);
                                b bVar = constraint.d;
                                int[] iArr = bVar.j0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.k0;
                                    if (str != null) {
                                        bVar.j0 = j(barrier, str);
                                        barrier.setReferencedIds(constraint.d.j0);
                                    }
                                }
                            }
                            ConstraintLayout.a param = (ConstraintLayout.a) view.getLayoutParams();
                            param.a();
                            constraint.d(param);
                            if (applyPostLayout) {
                                a.f.c.a.c(view, constraint.f);
                            }
                            view.setLayoutParams(param);
                            C0016d c0016d = constraint.f316b;
                            if (c0016d.c == 0) {
                                view.setVisibility(c0016d.f324b);
                            }
                            int i2 = Build.VERSION.SDK_INT;
                            if (i2 >= 17) {
                                view.setAlpha(constraint.f316b.d);
                                view.setRotation(constraint.e.c);
                                view.setRotationX(constraint.e.d);
                                view.setRotationY(constraint.e.e);
                                view.setScaleX(constraint.e.f);
                                view.setScaleY(constraint.e.g);
                                e eVar = constraint.e;
                                if (eVar.j != -1) {
                                    View layout = (View) view.getParent();
                                    View center = layout.findViewById(constraint.e.j);
                                    if (center != null) {
                                        float cy = (center.getTop() + center.getBottom()) / 2.0f;
                                        float cx = (center.getLeft() + center.getRight()) / 2.0f;
                                        if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                                            float px = cx - view.getLeft();
                                            float py = cy - view.getTop();
                                            view.setPivotX(px);
                                            view.setPivotY(py);
                                        }
                                    }
                                } else {
                                    if (!Float.isNaN(eVar.h)) {
                                        view.setPivotX(constraint.e.h);
                                    }
                                    if (!Float.isNaN(constraint.e.i)) {
                                        view.setPivotY(constraint.e.i);
                                    }
                                }
                                view.setTranslationX(constraint.e.k);
                                view.setTranslationY(constraint.e.l);
                                if (i2 >= 21) {
                                    view.setTranslationZ(constraint.e.m);
                                    e eVar2 = constraint.e;
                                    if (eVar2.n) {
                                        view.setElevation(eVar2.o);
                                    }
                                }
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            } else {
                Log.w("ConstraintSet", "id unknown " + a.f.b.a.a.b(view));
            }
        }
        Iterator<Integer> it = used.iterator();
        while (it.hasNext()) {
            Integer id2 = it.next();
            a constraint2 = this.f.get(id2);
            if (constraint2 != null) {
                if (constraint2.d.i0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(id2.intValue());
                    b bVar2 = constraint2.d;
                    int[] iArr2 = bVar2.j0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar2.k0;
                        if (str2 != null) {
                            bVar2.j0 = j(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.d.j0);
                        }
                    }
                    barrier2.setType(constraint2.d.g0);
                    barrier2.setMargin(constraint2.d.h0);
                    ConstraintLayout.a param2 = constraintLayout.generateDefaultLayoutParams();
                    barrier2.r();
                    constraint2.d(param2);
                    constraintLayout.addView(barrier2, param2);
                }
                if (constraint2.d.f320b) {
                    Guideline g = new Guideline(constraintLayout.getContext());
                    g.setId(id2.intValue());
                    ConstraintLayout.a param3 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.d(param3);
                    constraintLayout.addView(g, param3);
                }
            }
        }
        for (int i3 = 0; i3 < count; i3++) {
            View view2 = constraintLayout.getChildAt(i3);
            if (view2 instanceof a.f.c.b) {
                a.f.c.b constraintHelper = (a.f.c.b) view2;
                constraintHelper.h(constraintLayout);
            }
        }
    }

    public void e(int viewId, int anchor) {
        a constraint;
        if (!this.f.containsKey(Integer.valueOf(viewId)) || (constraint = this.f.get(Integer.valueOf(viewId))) == null) {
            return;
        }
        switch (anchor) {
            case 1:
                b bVar = constraint.d;
                bVar.j = -1;
                bVar.i = -1;
                bVar.G = -1;
                bVar.N = Integer.MIN_VALUE;
                return;
            case 2:
                b bVar2 = constraint.d;
                bVar2.l = -1;
                bVar2.k = -1;
                bVar2.H = -1;
                bVar2.P = Integer.MIN_VALUE;
                return;
            case 3:
                b bVar3 = constraint.d;
                bVar3.n = -1;
                bVar3.m = -1;
                bVar3.I = 0;
                bVar3.O = Integer.MIN_VALUE;
                return;
            case 4:
                b bVar4 = constraint.d;
                bVar4.o = -1;
                bVar4.p = -1;
                bVar4.J = 0;
                bVar4.Q = Integer.MIN_VALUE;
                return;
            case 5:
                b bVar5 = constraint.d;
                bVar5.q = -1;
                bVar5.r = -1;
                bVar5.s = -1;
                bVar5.M = 0;
                bVar5.T = Integer.MIN_VALUE;
                return;
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                b bVar6 = constraint.d;
                bVar6.t = -1;
                bVar6.u = -1;
                bVar6.L = 0;
                bVar6.S = Integer.MIN_VALUE;
                return;
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                b bVar7 = constraint.d;
                bVar7.v = -1;
                bVar7.w = -1;
                bVar7.K = 0;
                bVar7.R = Integer.MIN_VALUE;
                return;
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                b bVar8 = constraint.d;
                bVar8.C = -1.0f;
                bVar8.B = -1;
                bVar8.A = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void i(int viewId, int id, int radius, float angle) {
        a constraint = l(viewId);
        b bVar = constraint.d;
        bVar.A = id;
        bVar.B = radius;
        bVar.C = angle;
    }

    public final a l(int id) {
        if (!this.f.containsKey(Integer.valueOf(id))) {
            this.f.put(Integer.valueOf(id), new a());
        }
        return this.f.get(Integer.valueOf(id));
    }

    public void m(Context context, int resourceId) {
        Resources res = context.getResources();
        XmlPullParser parser = res.getXml(resourceId);
        try {
            for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                switch (eventType) {
                    case 0:
                        parser.getName();
                        break;
                    case 2:
                        String tagName = parser.getName();
                        a constraint = k(context, Xml.asAttributeSet(parser), false);
                        if (tagName.equalsIgnoreCase("Guideline")) {
                            constraint.d.f320b = true;
                        }
                        this.f.put(Integer.valueOf(constraint.f315a), constraint);
                        break;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0021. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x00d8. Please report as an issue. */
    public void n(Context context, XmlPullParser parser) {
        a constraint = null;
        try {
            int eventType = parser.getEventType();
            while (true) {
                char c2 = 1;
                if (eventType != 1) {
                    char c3 = 3;
                    switch (eventType) {
                        case 0:
                            parser.getName();
                            break;
                        case 2:
                            String tagName = parser.getName();
                            switch (tagName.hashCode()) {
                                case -2025855158:
                                    if (tagName.equals("Layout")) {
                                        c3 = 6;
                                        break;
                                    }
                                    break;
                                case -1984451626:
                                    if (tagName.equals("Motion")) {
                                        c3 = 7;
                                        break;
                                    }
                                    break;
                                case -1962203927:
                                    if (tagName.equals("ConstraintOverride")) {
                                        c3 = 1;
                                        break;
                                    }
                                    break;
                                case -1269513683:
                                    if (tagName.equals("PropertySet")) {
                                        c3 = 4;
                                        break;
                                    }
                                    break;
                                case -1238332596:
                                    if (tagName.equals("Transform")) {
                                        c3 = 5;
                                        break;
                                    }
                                    break;
                                case -71750448:
                                    if (tagName.equals("Guideline")) {
                                        c3 = 2;
                                        break;
                                    }
                                    break;
                                case 366511058:
                                    if (tagName.equals("CustomMethod")) {
                                        c3 = '\t';
                                        break;
                                    }
                                    break;
                                case 1331510167:
                                    if (tagName.equals("Barrier")) {
                                        break;
                                    }
                                    break;
                                case 1791837707:
                                    if (tagName.equals("CustomAttribute")) {
                                        c3 = '\b';
                                        break;
                                    }
                                    break;
                                case 1803088381:
                                    if (tagName.equals("Constraint")) {
                                        c3 = 0;
                                        break;
                                    }
                                    break;
                            }
                            c3 = 65535;
                            switch (c3) {
                                case 0:
                                    constraint = k(context, Xml.asAttributeSet(parser), false);
                                    break;
                                case 1:
                                    constraint = k(context, Xml.asAttributeSet(parser), true);
                                    break;
                                case 2:
                                    constraint = k(context, Xml.asAttributeSet(parser), false);
                                    b bVar = constraint.d;
                                    bVar.f320b = true;
                                    bVar.c = true;
                                    break;
                                case 3:
                                    constraint = k(context, Xml.asAttributeSet(parser), false);
                                    constraint.d.i0 = 1;
                                    break;
                                case 4:
                                    if (constraint == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + parser.getLineNumber());
                                    }
                                    constraint.f316b.b(context, Xml.asAttributeSet(parser));
                                    break;
                                case 5:
                                    if (constraint == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + parser.getLineNumber());
                                    }
                                    constraint.e.b(context, Xml.asAttributeSet(parser));
                                    break;
                                case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                                    if (constraint == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + parser.getLineNumber());
                                    }
                                    constraint.d.b(context, Xml.asAttributeSet(parser));
                                    break;
                                case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                                    if (constraint == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + parser.getLineNumber());
                                    }
                                    constraint.c.b(context, Xml.asAttributeSet(parser));
                                    break;
                                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                                case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                                    if (constraint == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + parser.getLineNumber());
                                    }
                                    a.f.c.a.b(context, parser, constraint.f);
                                    break;
                            }
                        case 3:
                            String lowerCase = parser.getName().toLowerCase(Locale.ROOT);
                            switch (lowerCase.hashCode()) {
                                case -2075718416:
                                    if (lowerCase.equals("guideline")) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -190376483:
                                    if (lowerCase.equals("constraint")) {
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 426575017:
                                    if (lowerCase.equals("constraintoverride")) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 2146106725:
                                    if (lowerCase.equals("constraintset")) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    return;
                                case 1:
                                case 2:
                                case 3:
                                    this.f.put(Integer.valueOf(constraint.f315a), constraint);
                                    constraint = null;
                                    break;
                            }
                            break;
                    }
                    eventType = parser.next();
                } else {
                    return;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    public static int o(TypedArray a2, int index, int def) {
        int ret = a2.getResourceId(index, def);
        if (ret == -1) {
            return a2.getInt(index, -1);
        }
        return ret;
    }

    public final a k(Context context, AttributeSet attrs, boolean override) {
        a c2 = new a();
        TypedArray a2 = context.obtainStyledAttributes(attrs, override ? i.c : i.f329a);
        s(context, c2, a2, override);
        a2.recycle();
        return c2;
    }

    public static void t(a c2, TypedArray a2) {
        int N = a2.getIndexCount();
        a.C0015a delta = new a.C0015a();
        c2.g = delta;
        int i = 0;
        c2.c.f322b = false;
        c2.d.c = false;
        c2.f316b.f323a = false;
        c2.e.f326b = false;
        int i2 = 0;
        while (i2 < N) {
            int attr = a2.getIndex(i2);
            int attrType = c.get(attr);
            switch (attrType) {
                case 2:
                    delta.b(2, a2.getDimensionPixelSize(attr, c2.d.J));
                    break;
                case 3:
                case 4:
                case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(attr) + "   " + f314b.get(attr));
                    break;
                case 5:
                    delta.c(5, a2.getString(attr));
                    break;
                case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                    delta.b(6, a2.getDimensionPixelOffset(attr, c2.d.D));
                    break;
                case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                    delta.b(7, a2.getDimensionPixelOffset(attr, c2.d.E));
                    break;
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        delta.b(8, a2.getDimensionPixelSize(attr, c2.d.K));
                        break;
                    }
                case IBulkCursor.RESPOND_TRANSACTION /* 11 */:
                    delta.b(11, a2.getDimensionPixelSize(attr, c2.d.Q));
                    break;
                case IBulkCursor.CLOSE_TRANSACTION /* 12 */:
                    delta.b(12, a2.getDimensionPixelSize(attr, c2.d.R));
                    break;
                case 13:
                    delta.b(13, a2.getDimensionPixelSize(attr, c2.d.N));
                    break;
                case 14:
                    delta.b(14, a2.getDimensionPixelSize(attr, c2.d.P));
                    break;
                case 15:
                    delta.b(15, a2.getDimensionPixelSize(attr, c2.d.S));
                    break;
                case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                    delta.b(16, a2.getDimensionPixelSize(attr, c2.d.O));
                    break;
                case 17:
                    delta.b(17, a2.getDimensionPixelOffset(attr, c2.d.f));
                    break;
                case 18:
                    delta.b(18, a2.getDimensionPixelOffset(attr, c2.d.g));
                    break;
                case 19:
                    delta.a(19, a2.getFloat(attr, c2.d.h));
                    break;
                case 20:
                    delta.a(20, a2.getFloat(attr, c2.d.x));
                    break;
                case 21:
                    delta.b(21, a2.getLayoutDimension(attr, c2.d.e));
                    break;
                case 22:
                    delta.b(22, f313a[a2.getInt(attr, c2.f316b.f324b)]);
                    break;
                case 23:
                    delta.b(23, a2.getLayoutDimension(attr, c2.d.d));
                    break;
                case 24:
                    delta.b(24, a2.getDimensionPixelSize(attr, c2.d.G));
                    break;
                case 27:
                    delta.b(27, a2.getInt(attr, c2.d.F));
                    break;
                case 28:
                    delta.b(28, a2.getDimensionPixelSize(attr, c2.d.H));
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        delta.b(31, a2.getDimensionPixelSize(attr, c2.d.L));
                        break;
                    }
                case 34:
                    delta.b(34, a2.getDimensionPixelSize(attr, c2.d.I));
                    break;
                case 37:
                    delta.a(37, a2.getFloat(attr, c2.d.y));
                    break;
                case 38:
                    int resourceId = a2.getResourceId(attr, c2.f315a);
                    c2.f315a = resourceId;
                    delta.b(38, resourceId);
                    break;
                case 39:
                    delta.a(39, a2.getFloat(attr, c2.d.V));
                    break;
                case 40:
                    delta.a(40, a2.getFloat(attr, c2.d.U));
                    break;
                case 41:
                    delta.b(41, a2.getInt(attr, c2.d.W));
                    break;
                case 42:
                    delta.b(42, a2.getInt(attr, c2.d.X));
                    break;
                case 43:
                    delta.a(43, a2.getFloat(attr, c2.f316b.d));
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        delta.d(44, true);
                        delta.a(44, a2.getDimension(attr, c2.e.o));
                        break;
                    }
                case 45:
                    delta.a(45, a2.getFloat(attr, c2.e.d));
                    break;
                case 46:
                    delta.a(46, a2.getFloat(attr, c2.e.e));
                    break;
                case 47:
                    delta.a(47, a2.getFloat(attr, c2.e.f));
                    break;
                case 48:
                    delta.a(48, a2.getFloat(attr, c2.e.g));
                    break;
                case 49:
                    delta.a(49, a2.getDimension(attr, c2.e.h));
                    break;
                case 50:
                    delta.a(50, a2.getDimension(attr, c2.e.i));
                    break;
                case 51:
                    delta.a(51, a2.getDimension(attr, c2.e.k));
                    break;
                case 52:
                    delta.a(52, a2.getDimension(attr, c2.e.l));
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        delta.a(53, a2.getDimension(attr, c2.e.m));
                        break;
                    }
                case 54:
                    delta.b(54, a2.getInt(attr, c2.d.Y));
                    break;
                case 55:
                    delta.b(55, a2.getInt(attr, c2.d.Z));
                    break;
                case 56:
                    delta.b(56, a2.getDimensionPixelSize(attr, c2.d.a0));
                    break;
                case 57:
                    delta.b(57, a2.getDimensionPixelSize(attr, c2.d.b0));
                    break;
                case 58:
                    delta.b(58, a2.getDimensionPixelSize(attr, c2.d.c0));
                    break;
                case 59:
                    delta.b(59, a2.getDimensionPixelSize(attr, c2.d.d0));
                    break;
                case 60:
                    delta.a(60, a2.getFloat(attr, c2.e.c));
                    break;
                case 62:
                    delta.b(62, a2.getDimensionPixelSize(attr, c2.d.B));
                    break;
                case 63:
                    delta.a(63, a2.getFloat(attr, c2.d.C));
                    break;
                case 64:
                    delta.b(64, o(a2, attr, c2.c.c));
                    break;
                case 65:
                    TypedValue type = a2.peekValue(attr);
                    if (type.type == 3) {
                        delta.c(65, a2.getString(attr));
                        break;
                    } else {
                        delta.c(65, a.f.a.i.a.a.f269b[a2.getInteger(attr, 0)]);
                        break;
                    }
                case 66:
                    delta.b(66, a2.getInt(attr, 0));
                    break;
                case 67:
                    delta.a(67, a2.getFloat(attr, c2.c.j));
                    break;
                case 68:
                    delta.a(68, a2.getFloat(attr, c2.f316b.e));
                    break;
                case 69:
                    delta.a(69, a2.getFloat(attr, 1.0f));
                    break;
                case 70:
                    delta.a(70, a2.getFloat(attr, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.b(72, a2.getInt(attr, c2.d.g0));
                    break;
                case 73:
                    delta.b(73, a2.getDimensionPixelSize(attr, c2.d.h0));
                    break;
                case 74:
                    delta.c(74, a2.getString(attr));
                    break;
                case 75:
                    delta.d(75, a2.getBoolean(attr, c2.d.o0));
                    break;
                case 76:
                    delta.b(76, a2.getInt(attr, c2.c.f));
                    break;
                case 77:
                    delta.c(77, a2.getString(attr));
                    break;
                case 78:
                    delta.b(78, a2.getInt(attr, c2.f316b.c));
                    break;
                case 79:
                    delta.a(79, a2.getFloat(attr, c2.c.h));
                    break;
                case 80:
                    delta.d(80, a2.getBoolean(attr, c2.d.m0));
                    break;
                case 81:
                    delta.d(81, a2.getBoolean(attr, c2.d.n0));
                    break;
                case 82:
                    delta.b(82, a2.getInteger(attr, c2.c.d));
                    break;
                case 83:
                    delta.b(83, o(a2, attr, c2.e.j));
                    break;
                case 84:
                    delta.b(84, a2.getInteger(attr, c2.c.l));
                    break;
                case 85:
                    delta.a(85, a2.getFloat(attr, c2.c.k));
                    break;
                case 86:
                    TypedValue type2 = a2.peekValue(attr);
                    int i3 = type2.type;
                    if (i3 == 1) {
                        c2.c.o = a2.getResourceId(attr, -1);
                        delta.b(89, c2.c.o);
                        c cVar = c2.c;
                        if (cVar.o == -1) {
                            break;
                        } else {
                            cVar.n = -2;
                            delta.b(88, -2);
                            break;
                        }
                    } else if (i3 == 3) {
                        c2.c.m = a2.getString(attr);
                        delta.c(90, c2.c.m);
                        if (c2.c.m.indexOf("/") > 0) {
                            c2.c.o = a2.getResourceId(attr, -1);
                            delta.b(89, c2.c.o);
                            c2.c.n = -2;
                            delta.b(88, -2);
                            break;
                        } else {
                            c2.c.n = -1;
                            delta.b(88, -1);
                            break;
                        }
                    } else {
                        c cVar2 = c2.c;
                        cVar2.n = a2.getInteger(attr, cVar2.o);
                        delta.b(88, c2.c.n);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(attr) + "   " + f314b.get(attr));
                    break;
                case 93:
                    delta.b(93, a2.getDimensionPixelSize(attr, c2.d.M));
                    break;
                case 94:
                    delta.b(94, a2.getDimensionPixelSize(attr, c2.d.T));
                    break;
                case 95:
                    p(delta, a2, attr, i);
                    break;
                case 96:
                    p(delta, a2, attr, 1);
                    break;
                case 97:
                    delta.b(97, a2.getInt(attr, c2.d.p0));
                    break;
                case 98:
                    int i4 = a.f.b.a.d.v;
                    if (a2.peekValue(attr).type == 3) {
                        a2.getString(attr);
                        c2.getClass();
                        break;
                    } else {
                        c2.f315a = a2.getResourceId(attr, c2.f315a);
                        break;
                    }
            }
            i2++;
            i = 0;
        }
    }

    public final void s(Context ctx, a c2, TypedArray a2, boolean override) {
        if (override) {
            t(c2, a2);
            return;
        }
        int N = a2.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a2.getIndex(i);
            int[] iArr = i.f329a;
            if (attr != 1 && 23 != attr && 24 != attr) {
                c2.c.f322b = true;
                c2.d.c = true;
                c2.f316b.f323a = true;
                c2.e.f326b = true;
            }
            switch (f314b.get(attr)) {
                case 1:
                    b bVar = c2.d;
                    bVar.q = o(a2, attr, bVar.q);
                    break;
                case 2:
                    b bVar2 = c2.d;
                    bVar2.J = a2.getDimensionPixelSize(attr, bVar2.J);
                    break;
                case 3:
                    b bVar3 = c2.d;
                    bVar3.p = o(a2, attr, bVar3.p);
                    break;
                case 4:
                    b bVar4 = c2.d;
                    bVar4.o = o(a2, attr, bVar4.o);
                    break;
                case 5:
                    c2.d.z = a2.getString(attr);
                    break;
                case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                    b bVar5 = c2.d;
                    bVar5.D = a2.getDimensionPixelOffset(attr, bVar5.D);
                    break;
                case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                    b bVar6 = c2.d;
                    bVar6.E = a2.getDimensionPixelOffset(attr, bVar6.E);
                    break;
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar7 = c2.d;
                        bVar7.K = a2.getDimensionPixelSize(attr, bVar7.K);
                        break;
                    } else {
                        break;
                    }
                case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                    b bVar8 = c2.d;
                    bVar8.w = o(a2, attr, bVar8.w);
                    break;
                case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                    b bVar9 = c2.d;
                    bVar9.v = o(a2, attr, bVar9.v);
                    break;
                case IBulkCursor.RESPOND_TRANSACTION /* 11 */:
                    b bVar10 = c2.d;
                    bVar10.Q = a2.getDimensionPixelSize(attr, bVar10.Q);
                    break;
                case IBulkCursor.CLOSE_TRANSACTION /* 12 */:
                    b bVar11 = c2.d;
                    bVar11.R = a2.getDimensionPixelSize(attr, bVar11.R);
                    break;
                case 13:
                    b bVar12 = c2.d;
                    bVar12.N = a2.getDimensionPixelSize(attr, bVar12.N);
                    break;
                case 14:
                    b bVar13 = c2.d;
                    bVar13.P = a2.getDimensionPixelSize(attr, bVar13.P);
                    break;
                case 15:
                    b bVar14 = c2.d;
                    bVar14.S = a2.getDimensionPixelSize(attr, bVar14.S);
                    break;
                case SQLiteDatabase.NO_LOCALIZED_COLLATORS /* 16 */:
                    b bVar15 = c2.d;
                    bVar15.O = a2.getDimensionPixelSize(attr, bVar15.O);
                    break;
                case 17:
                    b bVar16 = c2.d;
                    bVar16.f = a2.getDimensionPixelOffset(attr, bVar16.f);
                    break;
                case 18:
                    b bVar17 = c2.d;
                    bVar17.g = a2.getDimensionPixelOffset(attr, bVar17.g);
                    break;
                case 19:
                    b bVar18 = c2.d;
                    bVar18.h = a2.getFloat(attr, bVar18.h);
                    break;
                case 20:
                    b bVar19 = c2.d;
                    bVar19.x = a2.getFloat(attr, bVar19.x);
                    break;
                case 21:
                    b bVar20 = c2.d;
                    bVar20.e = a2.getLayoutDimension(attr, bVar20.e);
                    break;
                case 22:
                    C0016d c0016d = c2.f316b;
                    c0016d.f324b = a2.getInt(attr, c0016d.f324b);
                    C0016d c0016d2 = c2.f316b;
                    c0016d2.f324b = f313a[c0016d2.f324b];
                    break;
                case 23:
                    b bVar21 = c2.d;
                    bVar21.d = a2.getLayoutDimension(attr, bVar21.d);
                    break;
                case 24:
                    b bVar22 = c2.d;
                    bVar22.G = a2.getDimensionPixelSize(attr, bVar22.G);
                    break;
                case 25:
                    b bVar23 = c2.d;
                    bVar23.i = o(a2, attr, bVar23.i);
                    break;
                case 26:
                    b bVar24 = c2.d;
                    bVar24.j = o(a2, attr, bVar24.j);
                    break;
                case 27:
                    b bVar25 = c2.d;
                    bVar25.F = a2.getInt(attr, bVar25.F);
                    break;
                case 28:
                    b bVar26 = c2.d;
                    bVar26.H = a2.getDimensionPixelSize(attr, bVar26.H);
                    break;
                case 29:
                    b bVar27 = c2.d;
                    bVar27.k = o(a2, attr, bVar27.k);
                    break;
                case 30:
                    b bVar28 = c2.d;
                    bVar28.l = o(a2, attr, bVar28.l);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar29 = c2.d;
                        bVar29.L = a2.getDimensionPixelSize(attr, bVar29.L);
                        break;
                    } else {
                        break;
                    }
                case 32:
                    b bVar30 = c2.d;
                    bVar30.t = o(a2, attr, bVar30.t);
                    break;
                case 33:
                    b bVar31 = c2.d;
                    bVar31.u = o(a2, attr, bVar31.u);
                    break;
                case 34:
                    b bVar32 = c2.d;
                    bVar32.I = a2.getDimensionPixelSize(attr, bVar32.I);
                    break;
                case 35:
                    b bVar33 = c2.d;
                    bVar33.n = o(a2, attr, bVar33.n);
                    break;
                case 36:
                    b bVar34 = c2.d;
                    bVar34.m = o(a2, attr, bVar34.m);
                    break;
                case 37:
                    b bVar35 = c2.d;
                    bVar35.y = a2.getFloat(attr, bVar35.y);
                    break;
                case 38:
                    c2.f315a = a2.getResourceId(attr, c2.f315a);
                    break;
                case 39:
                    b bVar36 = c2.d;
                    bVar36.V = a2.getFloat(attr, bVar36.V);
                    break;
                case 40:
                    b bVar37 = c2.d;
                    bVar37.U = a2.getFloat(attr, bVar37.U);
                    break;
                case 41:
                    b bVar38 = c2.d;
                    bVar38.W = a2.getInt(attr, bVar38.W);
                    break;
                case 42:
                    b bVar39 = c2.d;
                    bVar39.X = a2.getInt(attr, bVar39.X);
                    break;
                case 43:
                    C0016d c0016d3 = c2.f316b;
                    c0016d3.d = a2.getFloat(attr, c0016d3.d);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar = c2.e;
                        eVar.n = true;
                        eVar.o = a2.getDimension(attr, eVar.o);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    e eVar2 = c2.e;
                    eVar2.d = a2.getFloat(attr, eVar2.d);
                    break;
                case 46:
                    e eVar3 = c2.e;
                    eVar3.e = a2.getFloat(attr, eVar3.e);
                    break;
                case 47:
                    e eVar4 = c2.e;
                    eVar4.f = a2.getFloat(attr, eVar4.f);
                    break;
                case 48:
                    e eVar5 = c2.e;
                    eVar5.g = a2.getFloat(attr, eVar5.g);
                    break;
                case 49:
                    e eVar6 = c2.e;
                    eVar6.h = a2.getDimension(attr, eVar6.h);
                    break;
                case 50:
                    e eVar7 = c2.e;
                    eVar7.i = a2.getDimension(attr, eVar7.i);
                    break;
                case 51:
                    e eVar8 = c2.e;
                    eVar8.k = a2.getDimension(attr, eVar8.k);
                    break;
                case 52:
                    e eVar9 = c2.e;
                    eVar9.l = a2.getDimension(attr, eVar9.l);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar10 = c2.e;
                        eVar10.m = a2.getDimension(attr, eVar10.m);
                        break;
                    } else {
                        break;
                    }
                case 54:
                    b bVar40 = c2.d;
                    bVar40.Y = a2.getInt(attr, bVar40.Y);
                    break;
                case 55:
                    b bVar41 = c2.d;
                    bVar41.Z = a2.getInt(attr, bVar41.Z);
                    break;
                case 56:
                    b bVar42 = c2.d;
                    bVar42.a0 = a2.getDimensionPixelSize(attr, bVar42.a0);
                    break;
                case 57:
                    b bVar43 = c2.d;
                    bVar43.b0 = a2.getDimensionPixelSize(attr, bVar43.b0);
                    break;
                case 58:
                    b bVar44 = c2.d;
                    bVar44.c0 = a2.getDimensionPixelSize(attr, bVar44.c0);
                    break;
                case 59:
                    b bVar45 = c2.d;
                    bVar45.d0 = a2.getDimensionPixelSize(attr, bVar45.d0);
                    break;
                case 60:
                    e eVar11 = c2.e;
                    eVar11.c = a2.getFloat(attr, eVar11.c);
                    break;
                case 61:
                    b bVar46 = c2.d;
                    bVar46.A = o(a2, attr, bVar46.A);
                    break;
                case 62:
                    b bVar47 = c2.d;
                    bVar47.B = a2.getDimensionPixelSize(attr, bVar47.B);
                    break;
                case 63:
                    b bVar48 = c2.d;
                    bVar48.C = a2.getFloat(attr, bVar48.C);
                    break;
                case 64:
                    c cVar = c2.c;
                    cVar.c = o(a2, attr, cVar.c);
                    break;
                case 65:
                    TypedValue type = a2.peekValue(attr);
                    if (type.type == 3) {
                        c2.c.e = a2.getString(attr);
                        break;
                    } else {
                        c2.c.e = a.f.a.i.a.a.f269b[a2.getInteger(attr, 0)];
                        break;
                    }
                case 66:
                    c2.c.g = a2.getInt(attr, 0);
                    break;
                case 67:
                    c cVar2 = c2.c;
                    cVar2.j = a2.getFloat(attr, cVar2.j);
                    break;
                case 68:
                    C0016d c0016d4 = c2.f316b;
                    c0016d4.e = a2.getFloat(attr, c0016d4.e);
                    break;
                case 69:
                    c2.d.e0 = a2.getFloat(attr, 1.0f);
                    break;
                case 70:
                    c2.d.f0 = a2.getFloat(attr, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = c2.d;
                    bVar49.g0 = a2.getInt(attr, bVar49.g0);
                    break;
                case 73:
                    b bVar50 = c2.d;
                    bVar50.h0 = a2.getDimensionPixelSize(attr, bVar50.h0);
                    break;
                case 74:
                    c2.d.k0 = a2.getString(attr);
                    break;
                case 75:
                    b bVar51 = c2.d;
                    bVar51.o0 = a2.getBoolean(attr, bVar51.o0);
                    break;
                case 76:
                    c cVar3 = c2.c;
                    cVar3.f = a2.getInt(attr, cVar3.f);
                    break;
                case 77:
                    c2.d.l0 = a2.getString(attr);
                    break;
                case 78:
                    C0016d c0016d5 = c2.f316b;
                    c0016d5.c = a2.getInt(attr, c0016d5.c);
                    break;
                case 79:
                    c cVar4 = c2.c;
                    cVar4.h = a2.getFloat(attr, cVar4.h);
                    break;
                case 80:
                    b bVar52 = c2.d;
                    bVar52.m0 = a2.getBoolean(attr, bVar52.m0);
                    break;
                case 81:
                    b bVar53 = c2.d;
                    bVar53.n0 = a2.getBoolean(attr, bVar53.n0);
                    break;
                case 82:
                    c cVar5 = c2.c;
                    cVar5.d = a2.getInteger(attr, cVar5.d);
                    break;
                case 83:
                    e eVar12 = c2.e;
                    eVar12.j = o(a2, attr, eVar12.j);
                    break;
                case 84:
                    c cVar6 = c2.c;
                    cVar6.l = a2.getInteger(attr, cVar6.l);
                    break;
                case 85:
                    c cVar7 = c2.c;
                    cVar7.k = a2.getFloat(attr, cVar7.k);
                    break;
                case 86:
                    TypedValue type2 = a2.peekValue(attr);
                    int i2 = type2.type;
                    if (i2 == 1) {
                        c2.c.o = a2.getResourceId(attr, -1);
                        c cVar8 = c2.c;
                        if (cVar8.o != -1) {
                            cVar8.n = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i2 == 3) {
                        c2.c.m = a2.getString(attr);
                        if (c2.c.m.indexOf("/") > 0) {
                            c2.c.o = a2.getResourceId(attr, -1);
                            c2.c.n = -2;
                            break;
                        } else {
                            c2.c.n = -1;
                            break;
                        }
                    } else {
                        c cVar9 = c2.c;
                        cVar9.n = a2.getInteger(attr, cVar9.o);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(attr) + "   " + f314b.get(attr));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(attr) + "   " + f314b.get(attr));
                    break;
                case 91:
                    b bVar54 = c2.d;
                    bVar54.r = o(a2, attr, bVar54.r);
                    break;
                case 92:
                    b bVar55 = c2.d;
                    bVar55.s = o(a2, attr, bVar55.s);
                    break;
                case 93:
                    b bVar56 = c2.d;
                    bVar56.M = a2.getDimensionPixelSize(attr, bVar56.M);
                    break;
                case 94:
                    b bVar57 = c2.d;
                    bVar57.T = a2.getDimensionPixelSize(attr, bVar57.T);
                    break;
                case 95:
                    p(c2.d, a2, attr, 0);
                    break;
                case 96:
                    p(c2.d, a2, attr, 1);
                    break;
                case 97:
                    b bVar58 = c2.d;
                    bVar58.p0 = a2.getInt(attr, bVar58.p0);
                    break;
            }
        }
        b bVar59 = c2.d;
        if (bVar59.k0 != null) {
            bVar59.j0 = null;
        }
    }

    public final int[] j(View view, String referenceIdString) {
        String[] split = referenceIdString.split(",");
        Context context = view.getContext();
        int[] tags = new int[split.length];
        int count = 0;
        int i = 0;
        while (i < split.length) {
            String idString = split[i].trim();
            int tag = 0;
            try {
                Field field = h.class.getField(idString);
                tag = field.getInt(null);
            } catch (Exception e2) {
            }
            if (tag == 0) {
                tag = context.getResources().getIdentifier(idString, "id", context.getPackageName());
            }
            if (tag == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view.getParent();
                Object value = constraintLayout.g(0, idString);
                if (value != null && (value instanceof Integer)) {
                    tag = ((Integer) value).intValue();
                }
            }
            tags[count] = tag;
            i++;
            count++;
        }
        int i2 = split.length;
        if (count != i2) {
            return Arrays.copyOf(tags, count);
        }
        return tags;
    }
}
