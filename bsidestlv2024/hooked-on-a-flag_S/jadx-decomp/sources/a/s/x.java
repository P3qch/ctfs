package a.s;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public a f742a;

    public x(Context context, ViewGroup hostView, View requestingView) {
        this.f742a = new a(context, hostView, requestingView, this);
    }

    public static ViewGroup d(View view) {
        View parent = view;
        while (parent != null) {
            if (parent.getId() == 16908290 && (parent instanceof ViewGroup)) {
                return (ViewGroup) parent;
            }
            if (parent.getParent() instanceof ViewGroup) {
                parent = (ViewGroup) parent.getParent();
            }
        }
        return null;
    }

    public static x c(View view) {
        ViewGroup contentView = d(view);
        if (contentView != null) {
            int numChildren = contentView.getChildCount();
            for (int i = 0; i < numChildren; i++) {
                View child = contentView.getChildAt(i);
                if (child instanceof a) {
                    return ((a) child).e;
                }
            }
            return new s(contentView.getContext(), contentView, view);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class a extends ViewGroup {

        /* renamed from: b, reason: collision with root package name */
        public ViewGroup f743b;
        public View c;
        public ArrayList<Drawable> d;
        public x e;
        public boolean f;

        static {
            try {
                Class cls = Integer.TYPE;
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException e) {
            }
        }

        public a(Context context, ViewGroup hostView, View requestingView, x viewOverlay) {
            super(context);
            this.d = null;
            this.f743b = hostView;
            this.c = requestingView;
            setRight(hostView.getWidth());
            setBottom(hostView.getHeight());
            hostView.addView(this);
            this.e = viewOverlay;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable who) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(who) || ((arrayList = this.d) != null && arrayList.contains(who));
        }

        public void a(View child) {
            b();
            if (child.getParent() instanceof ViewGroup) {
                ViewGroup parent = (ViewGroup) child.getParent();
                if (parent != this.f743b && parent.getParent() != null && a.h.k.v.S(parent)) {
                    int[] parentLocation = new int[2];
                    int[] hostViewLocation = new int[2];
                    parent.getLocationOnScreen(parentLocation);
                    this.f743b.getLocationOnScreen(hostViewLocation);
                    a.h.k.v.Y(child, parentLocation[0] - hostViewLocation[0]);
                    a.h.k.v.Z(child, parentLocation[1] - hostViewLocation[1]);
                }
                parent.removeView(child);
                if (child.getParent() != null) {
                    parent.removeView(child);
                }
            }
            addView(child);
        }

        public void e(View view) {
            removeView(view);
            c();
        }

        public final void b() {
            if (this.f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        public final void c() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f = true;
                    this.f743b.removeView(this);
                }
            }
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            int[] contentViewLocation = new int[2];
            int[] hostViewLocation = new int[2];
            this.f743b.getLocationOnScreen(contentViewLocation);
            this.c.getLocationOnScreen(hostViewLocation);
            canvas.translate(hostViewLocation[0] - contentViewLocation[0], hostViewLocation[1] - contentViewLocation[1]);
            canvas.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.d;
            int numDrawables = arrayList != null ? arrayList.size() : 0;
            for (int i = 0; i < numDrawables; i++) {
                this.d.get(i).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean changed, int l, int t, int r, int b2) {
        }

        public final void d(int[] offset) {
            int[] contentViewLocation = new int[2];
            int[] hostViewLocation = new int[2];
            this.f743b.getLocationOnScreen(contentViewLocation);
            this.c.getLocationOnScreen(hostViewLocation);
            offset[0] = hostViewLocation[0] - contentViewLocation[0];
            offset[1] = hostViewLocation[1] - contentViewLocation[1];
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
            if (this.f743b != null) {
                dirty.offset(location[0], location[1]);
                if (this.f743b instanceof ViewGroup) {
                    location[0] = 0;
                    location[1] = 0;
                    int[] offset = new int[2];
                    d(offset);
                    dirty.offset(offset[0], offset[1]);
                    return super.invalidateChildInParent(location, dirty);
                }
                invalidate(dirty);
                return null;
            }
            return null;
        }
    }
}
