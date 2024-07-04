package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: b, reason: collision with root package name */
    public int f834b;
    public int c;
    public WeakReference<View> d;
    public LayoutInflater e;
    public a f;

    /* loaded from: classes.dex */
    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f834b = 0;
        TypedArray a2 = context.obtainStyledAttributes(attrs, a.b.a.z, defStyle, 0);
        int[] iArr = a.b.a.f11a;
        this.c = a2.getResourceId(2, -1);
        this.f834b = a2.getResourceId(1, 0);
        setId(a2.getResourceId(0, -1));
        a2.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.c;
    }

    public void setInflatedId(int inflatedId) {
        this.c = inflatedId;
    }

    public int getLayoutResource() {
        return this.f834b;
    }

    public void setLayoutResource(int layoutResource) {
        this.f834b = layoutResource;
    }

    public void setLayoutInflater(LayoutInflater inflater) {
        this.e = inflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.e;
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        WeakReference<View> weakReference = this.d;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(visibility);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(visibility);
        if (visibility == 0 || visibility == 4) {
            a();
        }
    }

    public View a() {
        LayoutInflater factory;
        ViewParent viewParent = getParent();
        if (viewParent instanceof ViewGroup) {
            if (this.f834b != 0) {
                ViewGroup parent = (ViewGroup) viewParent;
                if (this.e != null) {
                    factory = this.e;
                } else {
                    factory = LayoutInflater.from(getContext());
                }
                View view = factory.inflate(this.f834b, parent, false);
                int i = this.c;
                if (i != -1) {
                    view.setId(i);
                }
                int index = parent.indexOfChild(this);
                parent.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    parent.addView(view, index, layoutParams);
                } else {
                    parent.addView(view, index);
                }
                this.d = new WeakReference<>(view);
                a aVar = this.f;
                if (aVar != null) {
                    aVar.a(this, view);
                }
                return view;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public void setOnInflateListener(a inflateListener) {
        this.f = inflateListener;
    }
}
