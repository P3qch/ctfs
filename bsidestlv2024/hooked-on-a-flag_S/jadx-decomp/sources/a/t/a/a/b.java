package a.t.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class b extends g implements Animatable {
    public C0053b c;
    public Context d;
    public ArgbEvaluator e;
    public final Drawable.Callback f;

    public b() {
        this(null, null, null);
    }

    public b(Context context) {
        this(context, null, null);
    }

    public b(Context context, C0053b state, Resources res) {
        this.e = null;
        a aVar = new a();
        this.f = aVar;
        this.d = context;
        if (state != null) {
            this.c = state;
        } else {
            this.c = new C0053b(state, aVar, res);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public static b a(Context context, Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        b drawable = new b(context);
        drawable.inflate(r, parser, attrs, theme);
        return drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f756b != null && Build.VERSION.SDK_INT >= 24) {
            return new c(this.f756b.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.c.f749a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.c.f750b.draw(canvas);
        if (this.c.c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.setBounds(bounds);
        } else {
            this.c.f750b.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] state) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.setState(state);
        }
        return this.c.f750b.setState(state);
    }

    @Override // a.t.a.a.g, android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.setLevel(level);
        }
        return this.c.f750b.setLevel(level);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return a.h.d.l.a.d(drawable);
        }
        return this.c.f750b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.setAlpha(alpha);
        } else {
            this.c.f750b.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.c.f750b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return a.h.d.l.a.e(drawable);
        }
        return this.c.f750b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTint(int tint) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.n(drawable, tint);
        } else {
            this.c.f750b.setTint(tint);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintList(ColorStateList tint) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.o(drawable, tint);
        } else {
            this.c.f750b.setTintList(tint);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.d.l.b
    public void setTintMode(PorterDuff.Mode tintMode) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.p(drawable, tintMode);
        } else {
            this.c.f750b.setTintMode(tintMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.setVisible(visible, restart);
        }
        this.c.f750b.setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.c.f750b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.c.f750b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.c.f750b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.c.f750b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return a.h.d.l.a.h(drawable);
        }
        return this.c.f750b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.j(drawable, mirrored);
        } else {
            this.c.f750b.setAutoMirrored(mirrored);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.g(drawable, res, parser, attrs, theme);
            return;
        }
        int eventType = parser.getEventType();
        int innerDepth = parser.getDepth() + 1;
        while (eventType != 1 && (parser.getDepth() >= innerDepth || eventType != 3)) {
            if (eventType == 2) {
                String tagName = parser.getName();
                if ("animated-vector".equals(tagName)) {
                    TypedArray a2 = a.h.c.c.g.k(res, theme, attrs, a.t.a.a.a.e);
                    int drawableRes = a2.getResourceId(0, 0);
                    if (drawableRes != 0) {
                        h vectorDrawable = h.b(res, drawableRes, theme);
                        vectorDrawable.h(false);
                        vectorDrawable.setCallback(this.f);
                        h hVar = this.c.f750b;
                        if (hVar != null) {
                            hVar.setCallback(null);
                        }
                        this.c.f750b = vectorDrawable;
                    }
                    a2.recycle();
                } else if ("target".equals(tagName)) {
                    TypedArray a3 = res.obtainAttributes(attrs, a.t.a.a.a.f);
                    String target = a3.getString(0);
                    int id = a3.getResourceId(1, 0);
                    if (id != 0) {
                        Context context = this.d;
                        if (context != null) {
                            Animator objectAnimator = d.i(context, id);
                            b(target, objectAnimator);
                        } else {
                            a3.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a3.recycle();
                } else {
                    continue;
                }
            }
            eventType = parser.next();
        }
        this.c.a();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs) {
        inflate(res, parser, attrs, null);
    }

    @Override // a.t.a.a.g, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme t) {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            a.h.d.l.a.a(drawable, t);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return a.h.d.l.a.b(drawable);
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f751a;

        public c(Drawable.ConstantState state) {
            this.f751a = state;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b drawableCompat = new b();
            Drawable newDrawable = this.f751a.newDrawable();
            drawableCompat.f756b = newDrawable;
            newDrawable.setCallback(drawableCompat.f);
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            b drawableCompat = new b();
            Drawable newDrawable = this.f751a.newDrawable(res);
            drawableCompat.f756b = newDrawable;
            newDrawable.setCallback(drawableCompat.f);
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res, Resources.Theme theme) {
            b drawableCompat = new b();
            Drawable newDrawable = this.f751a.newDrawable(res, theme);
            drawableCompat.f756b = newDrawable;
            newDrawable.setCallback(drawableCompat.f);
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f751a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f751a.getChangingConfigurations();
        }
    }

    /* renamed from: a.t.a.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0053b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f749a;

        /* renamed from: b, reason: collision with root package name */
        public h f750b;
        public AnimatorSet c;
        public ArrayList<Animator> d;
        public a.e.a<Animator, String> e;

        public C0053b(C0053b copy, Drawable.Callback owner, Resources res) {
            if (copy != null) {
                this.f749a = copy.f749a;
                h hVar = copy.f750b;
                if (hVar != null) {
                    Drawable.ConstantState cs = hVar.getConstantState();
                    if (res != null) {
                        this.f750b = (h) cs.newDrawable(res);
                    } else {
                        this.f750b = (h) cs.newDrawable();
                    }
                    h hVar2 = this.f750b;
                    hVar2.mutate();
                    h hVar3 = hVar2;
                    this.f750b = hVar3;
                    hVar3.setCallback(owner);
                    this.f750b.setBounds(copy.f750b.getBounds());
                    this.f750b.h(false);
                }
                ArrayList<Animator> arrayList = copy.d;
                if (arrayList != null) {
                    int numAnimators = arrayList.size();
                    this.d = new ArrayList<>(numAnimators);
                    this.e = new a.e.a<>(numAnimators);
                    for (int i = 0; i < numAnimators; i++) {
                        Animator anim = copy.d.get(i);
                        Animator animClone = anim.clone();
                        String targetName = copy.e.get(anim);
                        Object targetObject = this.f750b.d(targetName);
                        animClone.setTarget(targetObject);
                        this.d.add(animClone);
                        this.e.put(animClone, targetName);
                    }
                    a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f749a;
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }
    }

    public final void c(Animator animator) {
        List<Animator> childAnimators;
        if ((animator instanceof AnimatorSet) && (childAnimators = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimators.size(); i++) {
                c(childAnimators.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnim = (ObjectAnimator) animator;
            String propertyName = objectAnim.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.e == null) {
                    this.e = new ArgbEvaluator();
                }
                objectAnim.setEvaluator(this.e);
            }
        }
    }

    public final void b(String name, Animator animator) {
        Object target = this.c.f750b.d(name);
        animator.setTarget(target);
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        C0053b c0053b = this.c;
        if (c0053b.d == null) {
            c0053b.d = new ArrayList<>();
            this.c.e = new a.e.a<>();
        }
        this.c.d.add(animator);
        this.c.e.put(animator, name);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.c.c.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.c.c.isStarted()) {
                return;
            }
            this.c.c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f756b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.c.c.end();
        }
    }

    /* loaded from: classes.dex */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable who) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
            b.this.scheduleSelf(what, when);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable who, Runnable what) {
            b.this.unscheduleSelf(what);
        }
    }
}
