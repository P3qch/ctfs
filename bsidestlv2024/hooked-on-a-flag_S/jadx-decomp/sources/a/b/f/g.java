package a.b.f;

import a.b.f.j.j;
import a.b.g.f0;
import a.b.g.x0;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?>[] f82a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f83b;
    public final Object[] c;
    public final Object[] d;
    public Context e;
    public Object f;

    static {
        Class<?>[] clsArr = {Context.class};
        f82a = clsArr;
        f83b = clsArr;
    }

    public g(Context context) {
        super(context);
        this.e = context;
        Object[] objArr = {context};
        this.c = objArr;
        this.d = objArr;
    }

    @Override // android.view.MenuInflater
    public void inflate(int menuRes, Menu menu) {
        if (!(menu instanceof a.h.e.a.a)) {
            super.inflate(menuRes, menu);
            return;
        }
        XmlResourceParser parser = null;
        try {
            try {
                parser = this.e.getResources().getLayout(menuRes);
                AttributeSet attrs = Xml.asAttributeSet(parser);
                c(parser, attrs, menu);
                parser.close();
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
    
        switch(r1) {
            case 1: goto L57;
            case 2: goto L38;
            case 3: goto L17;
            default: goto L70;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        r8 = r11.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004d, code lost:
    
        if (r2 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        if (r8.equals(r3) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        r2 = false;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00bd, code lost:
    
        r1 = r11.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
    
        if (r8.equals("group") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
    
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        if (r8.equals("item") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
    
        if (r0.d() != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        r6 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        if (r6 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0077, code lost:
    
        if (r6.a() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        if (r8.equals("menu") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0089, code lost:
    
        if (r2 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008c, code lost:
    
        r8 = r11.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
    
        if (r8.equals("group") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
    
        r0.f(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009e, code lost:
    
        if (r8.equals("item") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a0, code lost:
    
        r0.g(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
    
        if (r8.equals("menu") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00aa, code lost:
    
        r6 = r0.b();
        c(r11, r12, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b2, code lost:
    
        r2 = true;
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00bc, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c3, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003d, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
    
        if (r4 != false) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
            r10 = this;
            a.b.f.g$b r0 = new a.b.f.g$b
            r0.<init>(r13)
            int r1 = r11.getEventType()
            r2 = 0
            r3 = 0
        Lb:
            r4 = 2
            java.lang.String r5 = "menu"
            if (r1 != r4) goto L36
            java.lang.String r4 = r11.getName()
            boolean r6 = r4.equals(r5)
            if (r6 == 0) goto L1f
            int r1 = r11.next()
            goto L3d
        L1f:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Expecting menu, got "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L36:
            int r1 = r11.next()
            r4 = 1
            if (r1 != r4) goto Lb
        L3d:
            r4 = 0
        L3e:
            if (r4 != 0) goto Lc3
            java.lang.String r6 = "item"
            java.lang.String r7 = "group"
            switch(r1) {
                case 1: goto Lb5;
                case 2: goto L89;
                case 3: goto L49;
                default: goto L47;
            }
        L47:
            goto Lbd
        L49:
            java.lang.String r8 = r11.getName()
            if (r2 == 0) goto L59
            boolean r9 = r8.equals(r3)
            if (r9 == 0) goto L59
            r2 = 0
            r3 = 0
            goto Lbd
        L59:
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L63
            r0.h()
            goto Lbd
        L63:
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L81
            boolean r6 = r0.d()
            if (r6 != 0) goto Lbd
            a.h.k.b r6 = r0.A
            if (r6 == 0) goto L7d
            boolean r6 = r6.a()
            if (r6 == 0) goto L7d
            r0.b()
            goto Lbd
        L7d:
            r0.a()
            goto Lbd
        L81:
            boolean r6 = r8.equals(r5)
            if (r6 == 0) goto Lbd
            r4 = 1
            goto Lbd
        L89:
            if (r2 == 0) goto L8c
            goto Lbd
        L8c:
            java.lang.String r8 = r11.getName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L9a
            r0.f(r12)
            goto Lbd
        L9a:
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto La4
            r0.g(r12)
            goto Lbd
        La4:
            boolean r6 = r8.equals(r5)
            if (r6 == 0) goto Lb2
            android.view.SubMenu r6 = r0.b()
            r10.c(r11, r12, r6)
            goto Lbd
        Lb2:
            r2 = 1
            r3 = r8
            goto Lbd
        Lb5:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "Unexpected end of document"
            r5.<init>(r6)
            throw r5
        Lbd:
            int r1 = r11.next()
            goto L3e
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.f.g.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    public Object b() {
        if (this.f == null) {
            this.f = a(this.e);
        }
        return this.f;
    }

    public final Object a(Object owner) {
        if (owner instanceof Activity) {
            return owner;
        }
        if (owner instanceof ContextWrapper) {
            return a(((ContextWrapper) owner).getBaseContext());
        }
        return owner;
    }

    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public static final Class<?>[] f84a = {MenuItem.class};

        /* renamed from: b, reason: collision with root package name */
        public Object f85b;
        public Method c;

        public a(Object realOwner, String methodName) {
            this.f85b = realOwner;
            Class<?> c = realOwner.getClass();
            try {
                this.c = c.getMethod(methodName, f84a);
            } catch (Exception e) {
                InflateException ex = new InflateException("Couldn't resolve menu item onClick handler " + methodName + " in class " + c.getName());
                ex.initCause(e);
                throw ex;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem item) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.f85b, item)).booleanValue();
                }
                this.c.invoke(this.f85b, item);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public a.h.k.b A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* renamed from: a, reason: collision with root package name */
        public Menu f86a;

        /* renamed from: b, reason: collision with root package name */
        public int f87b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;
        public int i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public b(Menu menu) {
            this.f86a = menu;
            h();
        }

        public void h() {
            this.f87b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        public void f(AttributeSet attrs) {
            TypedArray a2 = g.this.e.obtainStyledAttributes(attrs, a.b.a.o);
            int[] iArr = a.b.a.f11a;
            this.f87b = a2.getResourceId(1, 0);
            this.c = a2.getInt(3, 0);
            this.d = a2.getInt(4, 0);
            this.e = a2.getInt(5, 0);
            this.f = a2.getBoolean(2, true);
            this.g = a2.getBoolean(0, true);
            a2.recycle();
        }

        public void g(AttributeSet attributeSet) {
            x0 u = x0.u(g.this.e, attributeSet, a.b.a.p);
            int[] iArr = a.b.a.f11a;
            this.i = u.n(2, 0);
            this.j = ((-65536) & u.k(5, this.c)) | (65535 & u.k(6, this.d));
            this.k = u.p(7);
            this.l = u.p(8);
            this.m = u.n(0, 0);
            this.n = c(u.o(9));
            this.o = u.k(16, 4096);
            this.p = c(u.o(10));
            this.q = u.k(20, 4096);
            if (u.s(11)) {
                this.r = u.a(11, false) ? 1 : 0;
            } else {
                this.r = this.e;
            }
            this.s = u.a(3, false);
            this.t = u.a(4, this.f);
            this.u = u.a(1, this.g);
            this.v = u.k(21, -1);
            this.z = u.o(12);
            this.w = u.n(13, 0);
            this.x = u.o(15);
            String o = u.o(14);
            this.y = o;
            boolean z = o != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (a.h.k.b) e(o, g.f83b, g.this.d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u.p(17);
            this.C = u.p(22);
            if (u.s(19)) {
                this.E = f0.d(u.k(19, -1), this.E);
            } else {
                this.E = null;
            }
            if (u.s(18)) {
                this.D = u.c(18);
            } else {
                this.D = null;
            }
            u.w();
            this.h = false;
        }

        public final char c(String shortcutString) {
            if (shortcutString == null) {
                return (char) 0;
            }
            return shortcutString.charAt(0);
        }

        public final void i(MenuItem item) {
            item.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                item.setShowAsAction(i);
            }
            if (this.z != null) {
                if (g.this.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                item.setOnMenuItemClickListener(new a(g.this.b(), this.z));
            }
            if (this.r >= 2) {
                if (item instanceof a.b.f.j.i) {
                    ((a.b.f.j.i) item).t(true);
                } else if (item instanceof j) {
                    ((j) item).h(true);
                }
            }
            boolean actionViewSpecified = false;
            String str = this.x;
            if (str != null) {
                View actionView = (View) e(str, g.f82a, g.this.c);
                item.setActionView(actionView);
                actionViewSpecified = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (!actionViewSpecified) {
                    item.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            a.h.k.b bVar = this.A;
            if (bVar != null) {
                a.h.k.i.a(item, bVar);
            }
            a.h.k.i.c(item, this.B);
            a.h.k.i.g(item, this.C);
            a.h.k.i.b(item, this.n, this.o);
            a.h.k.i.f(item, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                a.h.k.i.e(item, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                a.h.k.i.d(item, colorStateList);
            }
        }

        public void a() {
            this.h = true;
            i(this.f86a.add(this.f87b, this.i, this.j, this.k));
        }

        public SubMenu b() {
            this.h = true;
            SubMenu subMenu = this.f86a.addSubMenu(this.f87b, this.i, this.j, this.k);
            i(subMenu.getItem());
            return subMenu;
        }

        public boolean d() {
            return this.h;
        }

        public final <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
