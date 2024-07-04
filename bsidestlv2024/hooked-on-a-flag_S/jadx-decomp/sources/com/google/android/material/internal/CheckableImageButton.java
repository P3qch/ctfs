package com.google.android.material.internal;

import a.b.g.m;
import a.h.k.e0.c;
import a.h.k.v;
import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;

/* loaded from: classes.dex */
public class CheckableImageButton extends m implements Checkable {
    public static final int[] d = {R.attr.state_checked};
    public boolean e;
    public boolean f;
    public boolean g;

    public CheckableImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, net.sqlcipher.R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f = true;
        this.g = true;
        v.o0(this, new a());
    }

    /* loaded from: classes.dex */
    public class a extends a.h.k.a {
        public a() {
        }

        @Override // a.h.k.a
        public void f(View host, AccessibilityEvent event) {
            super.f(host, event);
            event.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // a.h.k.a
        public void g(View host, c info) {
            super.g(host, info);
            info.U(CheckableImageButton.this.a());
            info.V(CheckableImageButton.this.isChecked());
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (this.f && this.e != checked) {
            this.e = checked;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.e;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.e);
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        if (this.g) {
            super.setPressed(pressed);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        if (this.e) {
            int[] iArr = d;
            return ImageButton.mergeDrawableStates(super.onCreateDrawableState(iArr.length + extraSpace), iArr);
        }
        return super.onCreateDrawableState(extraSpace);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        b savedState = new b(superState);
        savedState.d = this.e;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof b)) {
            super.onRestoreInstanceState(state);
            return;
        }
        b savedState = (b) state;
        super.onRestoreInstanceState(savedState.j());
        setChecked(savedState.d);
    }

    public void setCheckable(boolean checkable) {
        if (this.f != checkable) {
            this.f = checkable;
            sendAccessibilityEvent(0);
        }
    }

    public boolean a() {
        return this.f;
    }

    public void setPressable(boolean pressable) {
        this.g = pressable;
    }

    /* loaded from: classes.dex */
    public static class b extends a.j.a.a {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public boolean d;

        public b(Parcelable superState) {
            super(superState);
        }

        public b(Parcel source, ClassLoader loader) {
            super(source, loader);
            k(source);
        }

        @Override // a.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.d ? 1 : 0);
        }

        public final void k(Parcel in) {
            this.d = in.readInt() == 1;
        }

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<b> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel in, ClassLoader loader) {
                return new b(in, loader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel in) {
                return new b(in, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int size) {
                return new b[size];
            }
        }
    }
}
