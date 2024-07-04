package a.b.d.a;

import a.b.d.a.b;
import a.b.d.a.d;
import a.e.h;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class a extends a.b.d.a.d implements a.h.d.l.b {
    public c p;
    public g q;
    public int r;
    public int s;
    public boolean t;

    static {
        a.class.getSimpleName();
    }

    public a() {
        this(null, null);
    }

    public a(c state, Resources res) {
        super(null);
        this.r = -1;
        this.s = -1;
        c newState = new c(state, this, res);
        h(newState);
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a m(Context context, Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        String name = parser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(parser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        a asl = new a();
        asl.n(context, resources, parser, attrs, theme);
        return asl;
    }

    public void n(Context context, Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        TypedArray a2 = a.h.c.c.g.k(resources, theme, attrs, a.b.e.a.f72a);
        int[] iArr = a.b.e.a.f72a;
        setVisible(a2.getBoolean(1, true), true);
        t(a2);
        i(resources);
        a2.recycle();
        o(context, resources, parser, attrs, theme);
        p();
    }

    @Override // a.b.d.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        g gVar = this.q;
        if (gVar != null && (changed || restart)) {
            if (visible) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return changed;
    }

    @Override // a.b.d.a.d, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // a.b.d.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.q;
        if (gVar != null) {
            gVar.d();
            this.q = null;
            g(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    @Override // a.b.d.a.d, a.b.d.a.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        int targetIndex = this.p.F(stateSet);
        boolean changed = targetIndex != c() && (s(targetIndex) || g(targetIndex));
        Drawable current = getCurrent();
        if (current != null) {
            return changed | current.setState(stateSet);
        }
        return changed;
    }

    public final boolean s(int toIndex) {
        int fromIndex;
        int transitionIndex;
        g transition;
        g currentTransition = this.q;
        if (currentTransition != null) {
            if (toIndex == this.r) {
                return true;
            }
            if (toIndex == this.s && currentTransition.a()) {
                currentTransition.b();
                this.r = this.s;
                this.s = toIndex;
                return true;
            }
            fromIndex = this.r;
            currentTransition.d();
        } else {
            fromIndex = c();
        }
        this.q = null;
        this.s = -1;
        this.r = -1;
        c state = this.p;
        int fromId = state.E(fromIndex);
        int toId = state.E(toIndex);
        if (toId == 0 || fromId == 0 || (transitionIndex = state.G(fromId, toId)) < 0) {
            return false;
        }
        boolean hasReversibleFlag = state.I(fromId, toId);
        g(transitionIndex);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            boolean reversed = state.H(fromId, toId);
            transition = new e((AnimationDrawable) current, reversed, hasReversibleFlag);
        } else if (current instanceof a.t.a.a.b) {
            transition = new d((a.t.a.a.b) current);
        } else {
            if (!(current instanceof Animatable)) {
                return false;
            }
            transition = new b((Animatable) current);
        }
        transition.c();
        this.q = transition;
        this.s = fromIndex;
        this.r = toIndex;
        return true;
    }

    /* loaded from: classes.dex */
    public static abstract class g {
        public abstract void c();

        public abstract void d();

        public g() {
        }

        public void b() {
        }

        public boolean a() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: a, reason: collision with root package name */
        public final Animatable f60a;

        public b(Animatable a2) {
            super();
            this.f60a = a2;
        }

        @Override // a.b.d.a.a.g
        public void c() {
            this.f60a.start();
        }

        @Override // a.b.d.a.a.g
        public void d() {
            this.f60a.stop();
        }
    }

    /* loaded from: classes.dex */
    public static class e extends g {

        /* renamed from: a, reason: collision with root package name */
        public final ObjectAnimator f62a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f63b;

        public e(AnimationDrawable ad, boolean reversed, boolean hasReversibleFlag) {
            super();
            int frameCount = ad.getNumberOfFrames();
            int fromFrame = reversed ? frameCount - 1 : 0;
            int toFrame = reversed ? 0 : frameCount - 1;
            f interp = new f(ad, reversed);
            ObjectAnimator anim = ObjectAnimator.ofInt(ad, "currentIndex", fromFrame, toFrame);
            if (Build.VERSION.SDK_INT >= 18) {
                anim.setAutoCancel(true);
            }
            anim.setDuration(interp.a());
            anim.setInterpolator(interp);
            this.f63b = hasReversibleFlag;
            this.f62a = anim;
        }

        @Override // a.b.d.a.a.g
        public boolean a() {
            return this.f63b;
        }

        @Override // a.b.d.a.a.g
        public void c() {
            this.f62a.start();
        }

        @Override // a.b.d.a.a.g
        public void b() {
            this.f62a.reverse();
        }

        @Override // a.b.d.a.a.g
        public void d() {
            this.f62a.cancel();
        }
    }

    /* loaded from: classes.dex */
    public static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        public final a.t.a.a.b f61a;

        public d(a.t.a.a.b avd) {
            super();
            this.f61a = avd;
        }

        @Override // a.b.d.a.a.g
        public void c() {
            this.f61a.start();
        }

        @Override // a.b.d.a.a.g
        public void d() {
            this.f61a.stop();
        }
    }

    public final void t(TypedArray a2) {
        c state = this.p;
        if (Build.VERSION.SDK_INT >= 21) {
            state.d |= a2.getChangingConfigurations();
        }
        int[] iArr = a.b.e.a.f72a;
        state.x(a2.getBoolean(2, state.i));
        state.t(a2.getBoolean(3, state.l));
        state.u(a2.getInt(4, state.A));
        state.v(a2.getInt(5, state.B));
        setDither(a2.getBoolean(0, state.x));
    }

    public final void p() {
        onStateChange(getState());
    }

    public final void o(Context context, Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        int innerDepth = parser.getDepth() + 1;
        while (true) {
            int type = parser.next();
            if (type != 1) {
                int depth = parser.getDepth();
                if (depth >= innerDepth || type != 3) {
                    if (type == 2 && depth <= innerDepth) {
                        if (parser.getName().equals("item")) {
                            q(context, resources, parser, attrs, theme);
                        } else if (parser.getName().equals("transition")) {
                            r(context, resources, parser, attrs, theme);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004f, code lost:
    
        if (r19.getName().equals("animated-vector") == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
    
        r8 = a.t.a.a.b.a(r17, r18, r19, r20, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 21) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
    
        r8 = android.graphics.drawable.Drawable.createFromXmlInner(r18, r19, r20, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        r8 = android.graphics.drawable.Drawable.createFromXmlInner(r18, r19, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007e, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r19.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
    
        if (r8 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0081, code lost:
    
        if (r6 == (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
    
        if (r7 == (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008d, code lost:
    
        return r16.p.C(r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00aa, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r19.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c6, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r19.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0038, code lost:
    
        if (r8 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003a, code lost:
    
        r13 = r19.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0040, code lost:
    
        if (r13 != 4) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0043, code lost:
    
        if (r13 != 2) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int r(android.content.Context r17, android.content.res.Resources r18, org.xmlpull.v1.XmlPullParser r19, android.util.AttributeSet r20, android.content.res.Resources.Theme r21) {
        /*
            r16 = this;
            int[] r0 = a.b.e.a.c
            r1 = r18
            r2 = r20
            r3 = r21
            android.content.res.TypedArray r0 = a.h.c.c.g.k(r1, r3, r2, r0)
            int[] r4 = a.b.e.a.f72a
            r4 = 2
            r5 = -1
            int r6 = r0.getResourceId(r4, r5)
            r7 = 1
            int r7 = r0.getResourceId(r7, r5)
            r8 = 0
            r9 = 0
            int r10 = r0.getResourceId(r9, r5)
            if (r10 <= 0) goto L2c
            a.b.g.n0 r11 = a.b.g.n0.h()
            r12 = r17
            android.graphics.drawable.Drawable r8 = r11.j(r12, r10)
            goto L2e
        L2c:
            r12 = r17
        L2e:
            r11 = 3
            boolean r9 = r0.getBoolean(r11, r9)
            r0.recycle()
            java.lang.String r11 = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"
            if (r8 != 0) goto L7f
        L3a:
            int r13 = r19.next()
            r14 = r13
            r15 = 4
            if (r13 != r15) goto L43
            goto L3a
        L43:
            if (r14 != r4) goto L66
            java.lang.String r4 = r19.getName()
            java.lang.String r13 = "animated-vector"
            boolean r4 = r4.equals(r13)
            if (r4 == 0) goto L56
            a.t.a.a.b r8 = a.t.a.a.b.a(r17, r18, r19, r20, r21)
            goto L7f
        L56:
            int r4 = android.os.Build.VERSION.SDK_INT
            r13 = 21
            if (r4 < r13) goto L61
            android.graphics.drawable.Drawable r8 = android.graphics.drawable.Drawable.createFromXmlInner(r18, r19, r20, r21)
            goto L7f
        L61:
            android.graphics.drawable.Drawable r8 = android.graphics.drawable.Drawable.createFromXmlInner(r18, r19, r20)
            goto L7f
        L66:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r13 = r19.getPositionDescription()
            r5.append(r13)
            r5.append(r11)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L7f:
            if (r8 == 0) goto Lab
            if (r6 == r5) goto L8e
            if (r7 == r5) goto L8e
            r4 = r16
            a.b.d.a.a$c r5 = r4.p
            int r5 = r5.C(r6, r7, r8, r9)
            return r5
        L8e:
            r4 = r16
            org.xmlpull.v1.XmlPullParserException r5 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = r19.getPositionDescription()
            r11.append(r13)
            java.lang.String r13 = ": <transition> tag requires 'fromId' & 'toId' attributes"
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            r5.<init>(r11)
            throw r5
        Lab:
            r4 = r16
            org.xmlpull.v1.XmlPullParserException r5 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = r19.getPositionDescription()
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r5.<init>(r11)
            goto Lc7
        Lc6:
            throw r5
        Lc7:
            goto Lc6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.d.a.a.r(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        if (r6 != 2) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        if (r13.getName().equals("vector") == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        r2 = a.t.a.a.h.c(r12, r13, r14, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 21) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        r2 = android.graphics.drawable.Drawable.createFromXmlInner(r12, r13, r14, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        r2 = android.graphics.drawable.Drawable.createFromXmlInner(r12, r13, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r13.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        return r10.p.B(r4, r2, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r13.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0028, code lost:
    
        if (r2 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
    
        r6 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        if (r6 != 4) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int q(android.content.Context r11, android.content.res.Resources r12, org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.content.res.Resources.Theme r15) {
        /*
            r10 = this;
            int[] r0 = a.b.e.a.f73b
            android.content.res.TypedArray r0 = a.h.c.c.g.k(r12, r15, r14, r0)
            int[] r1 = a.b.e.a.f72a
            r1 = 0
            int r1 = r0.getResourceId(r1, r1)
            r2 = 0
            r3 = 1
            r4 = -1
            int r3 = r0.getResourceId(r3, r4)
            if (r3 <= 0) goto L1f
            a.b.g.n0 r4 = a.b.g.n0.h()
            android.graphics.drawable.Drawable r2 = r4.j(r11, r3)
        L1f:
            r0.recycle()
            int[] r4 = r10.k(r14)
            java.lang.String r5 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"
            if (r2 != 0) goto L70
        L2a:
            int r6 = r13.next()
            r7 = r6
            r8 = 4
            if (r6 != r8) goto L33
            goto L2a
        L33:
            r6 = 2
            if (r7 != r6) goto L57
            java.lang.String r6 = r13.getName()
            java.lang.String r8 = "vector"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L47
            a.t.a.a.h r2 = a.t.a.a.h.c(r12, r13, r14, r15)
            goto L70
        L47:
            int r6 = android.os.Build.VERSION.SDK_INT
            r8 = 21
            if (r6 < r8) goto L52
            android.graphics.drawable.Drawable r2 = android.graphics.drawable.Drawable.createFromXmlInner(r12, r13, r14, r15)
            goto L70
        L52:
            android.graphics.drawable.Drawable r2 = android.graphics.drawable.Drawable.createFromXmlInner(r12, r13, r14)
            goto L70
        L57:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r13.getPositionDescription()
            r8.append(r9)
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r6.<init>(r5)
            throw r6
        L70:
            if (r2 == 0) goto L79
            a.b.d.a.a$c r5 = r10.p
            int r5 = r5.B(r4, r2, r1)
            return r5
        L79:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r13.getPositionDescription()
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            goto L93
        L92:
            throw r6
        L93:
            goto L92
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.d.a.a.q(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):int");
    }

    @Override // a.b.d.a.d, a.b.d.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.p.r();
                this.t = true;
            }
        }
        return this;
    }

    @Override // a.b.d.a.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c b() {
        return new c(this.p, this, null);
    }

    /* loaded from: classes.dex */
    public static class c extends d.a {
        public a.e.d<Long> K;
        public h<Integer> L;

        public c(c orig, a owner, Resources res) {
            super(orig, owner, res);
            if (orig != null) {
                this.K = orig.K;
                this.L = orig.L;
            } else {
                this.K = new a.e.d<>();
                this.L = new h<>();
            }
        }

        @Override // a.b.d.a.d.a, a.b.d.a.b.d
        public void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public int C(int fromId, int toId, Drawable anim, boolean reversible) {
            int pos = a(anim);
            long keyFromTo = D(fromId, toId);
            long reversibleBit = 0;
            if (reversible) {
                reversibleBit = 8589934592L;
            }
            this.K.a(keyFromTo, Long.valueOf(pos | reversibleBit));
            if (reversible) {
                long keyToFrom = D(toId, fromId);
                this.K.a(keyToFrom, Long.valueOf(pos | 4294967296L | reversibleBit));
            }
            return pos;
        }

        public int B(int[] stateSet, Drawable drawable, int id) {
            int index = z(stateSet, drawable);
            this.L.i(index, Integer.valueOf(id));
            return index;
        }

        public int F(int[] stateSet) {
            int index = A(stateSet);
            if (index >= 0) {
                return index;
            }
            return A(StateSet.WILD_CARD);
        }

        public int E(int index) {
            if (index < 0) {
                return 0;
            }
            return this.L.f(index, 0).intValue();
        }

        public int G(int fromId, int toId) {
            long keyFromTo = D(fromId, toId);
            return (int) this.K.f(keyFromTo, -1L).longValue();
        }

        public boolean H(int fromId, int toId) {
            long keyFromTo = D(fromId, toId);
            return (this.K.f(keyFromTo, -1L).longValue() & 4294967296L) != 0;
        }

        public boolean I(int fromId, int toId) {
            long keyFromTo = D(fromId, toId);
            return (this.K.f(keyFromTo, -1L).longValue() & 8589934592L) != 0;
        }

        @Override // a.b.d.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // a.b.d.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            return new a(this, res);
        }

        public static long D(int fromId, int toId) {
            return (fromId << 32) | toId;
        }
    }

    @Override // a.b.d.a.d, a.b.d.a.b
    public void h(b.d state) {
        super.h(state);
        if (state instanceof c) {
            this.p = (c) state;
        }
    }

    /* loaded from: classes.dex */
    public static class f implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        public int[] f64a;

        /* renamed from: b, reason: collision with root package name */
        public int f65b;
        public int c;

        public f(AnimationDrawable d, boolean reversed) {
            b(d, reversed);
        }

        public int b(AnimationDrawable d, boolean reversed) {
            int frameCount = d.getNumberOfFrames();
            this.f65b = frameCount;
            int[] iArr = this.f64a;
            if (iArr == null || iArr.length < frameCount) {
                this.f64a = new int[frameCount];
            }
            int[] frameTimes = this.f64a;
            int totalDuration = 0;
            for (int i = 0; i < frameCount; i++) {
                int duration = d.getDuration(reversed ? (frameCount - i) - 1 : i);
                frameTimes[i] = duration;
                totalDuration += duration;
            }
            this.c = totalDuration;
            return totalDuration;
        }

        public int a() {
            return this.c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            float frameElapsed;
            int elapsed = (int) ((this.c * input) + 0.5f);
            int frameCount = this.f65b;
            int[] frameTimes = this.f64a;
            int remaining = elapsed;
            int i = 0;
            while (i < frameCount && remaining >= frameTimes[i]) {
                remaining -= frameTimes[i];
                i++;
            }
            if (i < frameCount) {
                frameElapsed = remaining / this.c;
            } else {
                frameElapsed = 0.0f;
            }
            return (i / frameCount) + frameElapsed;
        }
    }
}
