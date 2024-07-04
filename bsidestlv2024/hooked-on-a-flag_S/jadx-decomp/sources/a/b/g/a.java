package a.b.g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public final C0007a f125b;
    public final Context c;
    public ActionMenuView d;
    public c e;
    public int f;
    public a.h.k.z g;
    public boolean h;
    public boolean i;

    public abstract void setContentHeight(int i);

    public a(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public a(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f125b = new C0007a();
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, tv, true) && tv.resourceId != 0) {
            this.c = new ContextThemeWrapper(context, tv.resourceId);
        } else {
            this.c = context;
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        TypedArray a2 = getContext().obtainStyledAttributes(null, a.b.a.f11a, R.attr.actionBarStyle, 0);
        int[] iArr = a.b.a.f11a;
        setContentHeight(a2.getLayoutDimension(13, 0));
        a2.recycle();
        c cVar = this.e;
        if (cVar != null) {
            cVar.F();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 0) {
            this.h = false;
        }
        if (!this.h) {
            boolean handled = super.onTouchEvent(ev);
            if (action == 0 && !handled) {
                this.h = true;
            }
        }
        if (action == 1 || action == 3) {
            this.h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 9) {
            this.i = false;
        }
        if (!this.i) {
            boolean handled = super.onHoverEvent(ev);
            if (action == 9 && !handled) {
                this.i = true;
            }
        }
        if (action == 10 || action == 3) {
            this.i = false;
        }
        return true;
    }

    public int getContentHeight() {
        return this.f;
    }

    public int getAnimatedVisibility() {
        if (this.g != null) {
            return this.f125b.f127b;
        }
        return getVisibility();
    }

    public a.h.k.z f(int visibility, long duration) {
        a.h.k.z zVar = this.g;
        if (zVar != null) {
            zVar.b();
        }
        if (visibility != 0) {
            a.h.k.z a2 = a.h.k.v.d(this).a(0.0f);
            a2.d(duration);
            C0007a c0007a = this.f125b;
            c0007a.d(a2, visibility);
            a2.f(c0007a);
            return a2;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        a.h.k.z a3 = a.h.k.v.d(this).a(1.0f);
        a3.d(duration);
        C0007a c0007a2 = this.f125b;
        c0007a2.d(a3, visibility);
        a3.f(c0007a2);
        return a3;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility != getVisibility()) {
            a.h.k.z zVar = this.g;
            if (zVar != null) {
                zVar.b();
            }
            super.setVisibility(visibility);
        }
    }

    public int c(View child, int availableWidth, int childSpecHeight, int spacing) {
        child.measure(View.MeasureSpec.makeMeasureSpec(availableWidth, Integer.MIN_VALUE), childSpecHeight);
        return Math.max(0, (availableWidth - child.getMeasuredWidth()) - spacing);
    }

    public static int d(int x, int val, boolean isRtl) {
        return isRtl ? x - val : x + val;
    }

    public int e(View child, int x, int y, int contentHeight, boolean reverse) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = ((contentHeight - childHeight) / 2) + y;
        if (reverse) {
            child.layout(x - childWidth, childTop, x, childTop + childHeight);
        } else {
            child.layout(x, childTop, x + childWidth, childTop + childHeight);
        }
        return reverse ? -childWidth : childWidth;
    }

    /* renamed from: a.b.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0007a implements a.h.k.a0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f126a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f127b;

        public C0007a() {
        }

        public C0007a d(a.h.k.z animation, int visibility) {
            a.this.g = animation;
            this.f127b = visibility;
            return this;
        }

        @Override // a.h.k.a0
        public void b(View view) {
            a.super.setVisibility(0);
            this.f126a = false;
        }

        @Override // a.h.k.a0
        public void a(View view) {
            if (this.f126a) {
                return;
            }
            a aVar = a.this;
            aVar.g = null;
            a.super.setVisibility(this.f127b);
        }

        @Override // a.h.k.a0
        public void c(View view) {
            this.f126a = true;
        }
    }
}
