package a.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f307a;

    /* renamed from: b, reason: collision with root package name */
    public int f308b = -1;
    public int c = -1;
    public SparseArray<a> d = new SparseArray<>();
    public SparseArray<d> e = new SparseArray<>();

    public c(Context context, ConstraintLayout layout, int resourceID) {
        this.f307a = layout;
        a(context, resourceID);
    }

    public void d(int id, float width, float height) {
        a state;
        int match;
        int i = this.f308b;
        if (i == id) {
            if (id == -1) {
                state = this.d.valueAt(0);
            } else {
                state = this.d.get(i);
            }
            int i2 = this.c;
            if ((i2 != -1 && state.f310b.get(i2).a(width, height)) || this.c == (match = state.b(width, height))) {
                return;
            }
            d constraintSet = match == -1 ? null : state.f310b.get(match).f;
            if (match == -1) {
                int i3 = state.c;
            } else {
                int i4 = state.f310b.get(match).e;
            }
            if (constraintSet == null) {
                return;
            }
            this.c = match;
            constraintSet.c(this.f307a);
            return;
        }
        this.f308b = id;
        a state2 = this.d.get(id);
        int match2 = state2.b(width, height);
        d constraintSet2 = match2 == -1 ? state2.d : state2.f310b.get(match2).f;
        if (match2 == -1) {
            int i5 = state2.c;
        } else {
            int i6 = state2.f310b.get(match2).e;
        }
        if (constraintSet2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + id + ", dim =" + width + ", " + height);
            return;
        }
        this.c = match2;
        constraintSet2.c(this.f307a);
    }

    public void c(f constraintsChangedListener) {
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f309a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<b> f310b = new ArrayList<>();
        public int c;
        public d d;

        public a(Context context, XmlPullParser parser) {
            this.c = -1;
            AttributeSet attrs = Xml.asAttributeSet(parser);
            TypedArray a2 = context.obtainStyledAttributes(attrs, i.j);
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                int[] iArr = i.f329a;
                if (attr == 0) {
                    this.f309a = a2.getResourceId(attr, this.f309a);
                } else if (attr == 1) {
                    this.c = a2.getResourceId(attr, this.c);
                    String type = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(type)) {
                        d dVar = new d();
                        this.d = dVar;
                        dVar.f(context, this.c);
                    }
                }
            }
            a2.recycle();
        }

        public void a(b size) {
            this.f310b.add(size);
        }

        public int b(float width, float height) {
            for (int i = 0; i < this.f310b.size(); i++) {
                if (this.f310b.get(i).a(width, height)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public float f311a;

        /* renamed from: b, reason: collision with root package name */
        public float f312b;
        public float c;
        public float d;
        public int e;
        public d f;

        public b(Context context, XmlPullParser parser) {
            this.f311a = Float.NaN;
            this.f312b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            AttributeSet attrs = Xml.asAttributeSet(parser);
            TypedArray a2 = context.obtainStyledAttributes(attrs, i.l);
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                int[] iArr = i.f329a;
                if (attr == 0) {
                    this.e = a2.getResourceId(attr, this.e);
                    String type = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(type)) {
                        d dVar = new d();
                        this.f = dVar;
                        dVar.f(context, this.e);
                    }
                } else if (attr == 1) {
                    this.d = a2.getDimension(attr, this.d);
                } else if (attr == 2) {
                    this.f312b = a2.getDimension(attr, this.f312b);
                } else if (attr == 3) {
                    this.c = a2.getDimension(attr, this.c);
                } else if (attr == 4) {
                    this.f311a = a2.getDimension(attr, this.f311a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            a2.recycle();
        }

        public boolean a(float widthDp, float heightDp) {
            if (!Float.isNaN(this.f311a) && widthDp < this.f311a) {
                return false;
            }
            if (!Float.isNaN(this.f312b) && heightDp < this.f312b) {
                return false;
            }
            if (Float.isNaN(this.c) || widthDp <= this.c) {
                return Float.isNaN(this.d) || heightDp <= this.d;
            }
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(Context context, int resourceId) {
        Resources res = context.getResources();
        XmlPullParser parser = res.getXml(resourceId);
        a state = null;
        try {
            int eventType = parser.getEventType();
            while (true) {
                char c = 1;
                if (eventType != 1) {
                    switch (eventType) {
                        case 0:
                            parser.getName();
                            break;
                        case 2:
                            String tagName = parser.getName();
                            switch (tagName.hashCode()) {
                                case -1349929691:
                                    if (tagName.equals("ConstraintSet")) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                                case 80204913:
                                    if (tagName.equals("State")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 1382829617:
                                    if (tagName.equals("StateSet")) {
                                        break;
                                    }
                                    break;
                                case 1657696882:
                                    if (tagName.equals("layoutDescription")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 1901439077:
                                    if (tagName.equals("Variant")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                            }
                            c = 65535;
                            switch (c) {
                                case 2:
                                    state = new a(context, parser);
                                    this.d.put(state.f309a, state);
                                    break;
                                case 3:
                                    b match = new b(context, parser);
                                    if (state != null) {
                                        state.a(match);
                                        break;
                                    }
                                    break;
                                case 4:
                                    b(context, parser);
                                    break;
                            }
                    }
                    eventType = parser.next();
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public final void b(Context context, XmlPullParser parser) {
        d set = new d();
        int count = parser.getAttributeCount();
        for (int i = 0; i < count; i++) {
            String name = parser.getAttributeName(i);
            String s = parser.getAttributeValue(i);
            if (name != null && s != null && "id".equals(name)) {
                int id = -1;
                if (s.contains("/")) {
                    String tmp = s.substring(s.indexOf(47) + 1);
                    id = context.getResources().getIdentifier(tmp, "id", context.getPackageName());
                }
                if (id == -1) {
                    if (s.length() > 1) {
                        id = Integer.parseInt(s.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                set.n(context, parser);
                this.e.put(id, set);
                return;
            }
        }
    }
}
