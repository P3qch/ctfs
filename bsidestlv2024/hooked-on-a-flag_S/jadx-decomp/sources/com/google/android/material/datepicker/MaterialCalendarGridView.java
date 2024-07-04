package com.google.android.material.datepicker;

import a.h.j.e;
import a.h.k.e0.c;
import a.h.k.v;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import b.b.a.a.l.d;
import b.b.a.a.l.i;
import b.b.a.a.l.m;
import b.b.a.a.l.s;
import java.util.Calendar;
import java.util.Iterator;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: b, reason: collision with root package name */
    public final Calendar f1179b;
    public final boolean c;

    public MaterialCalendarGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f1179b = s.k();
        if (i.Y1(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.c = i.Z1(getContext());
        v.o0(this, new a(this));
    }

    /* loaded from: classes.dex */
    public class a extends a.h.k.a {
        public a(MaterialCalendarGridView this$0) {
        }

        @Override // a.h.k.a
        public void g(View view, c accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.Y(null);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int position) {
        if (position < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(position);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean result = super.onKeyDown(keyCode, event);
        if (!result) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != keyCode) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public m getAdapter2() {
        return (m) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter adapter) {
        if (!(adapter instanceof m)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), m.class.getCanonicalName()));
        }
        super.setAdapter(adapter);
    }

    /* JADX WARN: Generic types in debug info not equals: a.h.j.e != androidx.core.util.Pair<java.lang.Long, java.lang.Long> */
    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.d != com.google.android.material.datepicker.DateSelector<?> */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m monthAdapter = getAdapter();
        d<?> dVar = monthAdapter.d;
        b.b.a.a.l.c cVar = monthAdapter.f;
        monthAdapter.getItem(monthAdapter.b());
        monthAdapter.getItem(monthAdapter.g());
        Iterator<e<Long, Long>> it = dVar.g().iterator();
        while (it.hasNext()) {
            it.next().getClass();
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.c) {
            int expandSpec = View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE);
            super.onMeasure(widthMeasureSpec, expandSpec);
            ViewGroup.LayoutParams params = getLayoutParams();
            params.height = getMeasuredHeight();
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        if (gainFocus) {
            a(direction, previouslyFocusedRect);
        } else {
            super.onFocusChanged(false, direction, previouslyFocusedRect);
        }
    }

    public final void a(int direction, Rect previouslyFocusedRect) {
        if (direction == 33) {
            setSelection(getAdapter().g());
        } else if (direction == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, direction, previouslyFocusedRect);
        }
    }
}
