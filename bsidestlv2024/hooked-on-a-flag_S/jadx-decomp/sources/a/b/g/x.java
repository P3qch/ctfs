package a.b.g;

import a.b.b.b;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* loaded from: classes.dex */
public class x extends Spinner implements a.h.k.u {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f201b = {R.attr.spinnerMode};
    public final a.b.g.e c;
    public final Context d;
    public i0 e;
    public SpinnerAdapter f;
    public final boolean g;
    public g h;
    public int i;
    public final Rect j;

    /* loaded from: classes.dex */
    public interface g {
        boolean a();

        CharSequence b();

        void c(int i);

        int d();

        void dismiss();

        void f(int i, int i2);

        void h(CharSequence charSequence);

        int j();

        void l(Drawable drawable);

        void m(int i);

        Drawable n();

        void o(ListAdapter listAdapter);

        void p(int i);
    }

    public x(Context context, AttributeSet attrs) {
        this(context, attrs, net.sqlcipher.R.attr.spinnerStyle);
    }

    public x(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public x(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        this(context, attrs, defStyleAttr, mode, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
    
        if (r2 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x(android.content.Context r9, android.util.AttributeSet r10, int r11, int r12, android.content.res.Resources.Theme r13) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r8.j = r0
            android.content.Context r0 = r8.getContext()
            a.b.g.s0.a(r8, r0)
            int[] r0 = a.b.a.u
            r1 = 0
            a.b.g.x0 r0 = a.b.g.x0.v(r9, r10, r0, r11, r1)
            a.b.g.e r2 = new a.b.g.e
            r2.<init>(r8)
            r8.c = r2
            if (r13 == 0) goto L29
            a.b.f.d r2 = new a.b.f.d
            r2.<init>(r9, r13)
            r8.d = r2
            goto L3c
        L29:
            int[] r2 = a.b.a.f11a
            r2 = 4
            int r2 = r0.n(r2, r1)
            if (r2 == 0) goto L3a
            a.b.f.d r3 = new a.b.f.d
            r3.<init>(r9, r2)
            r8.d = r3
            goto L3c
        L3a:
            r8.d = r9
        L3c:
            r2 = -1
            if (r12 != r2) goto L6b
            r2 = 0
            int[] r3 = a.b.g.x.f201b     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            android.content.res.TypedArray r3 = r9.obtainStyledAttributes(r10, r3, r11, r1)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r2 = r3
            boolean r3 = r2.hasValue(r1)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            if (r3 == 0) goto L52
            int r3 = r2.getInt(r1, r1)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r12 = r3
        L52:
        L53:
            r2.recycle()
            goto L6b
        L57:
            r1 = move-exception
            goto L65
        L59:
            r3 = move-exception
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto L6b
            goto L53
        L65:
            if (r2 == 0) goto L6a
            r2.recycle()
        L6a:
            throw r1
        L6b:
            r2 = 1
            r3 = 2
            switch(r12) {
                case 0: goto La6;
                case 1: goto L71;
                default: goto L70;
            }
        L70:
            goto Lb7
        L71:
            a.b.g.x$e r4 = new a.b.g.x$e
            android.content.Context r5 = r8.d
            r4.<init>(r5, r10, r11)
            android.content.Context r5 = r8.d
            int[] r6 = a.b.a.u
            a.b.g.x0 r5 = a.b.g.x0.v(r5, r10, r6, r11, r1)
            int[] r6 = a.b.a.f11a
            r6 = 3
            r7 = -2
            int r6 = r5.m(r6, r7)
            r8.i = r6
            android.graphics.drawable.Drawable r6 = r5.g(r2)
            r4.l(r6)
            java.lang.String r3 = r0.o(r3)
            r4.h(r3)
            r5.w()
            r8.h = r4
            a.b.g.x$a r3 = new a.b.g.x$a
            r3.<init>(r8, r4)
            r8.e = r3
            goto Lb7
        La6:
            a.b.g.x$c r4 = new a.b.g.x$c
            r4.<init>()
            r8.h = r4
            int[] r5 = a.b.a.f11a
            java.lang.String r3 = r0.o(r3)
            r4.h(r3)
        Lb7:
            int[] r3 = a.b.a.f11a
            java.lang.CharSequence[] r1 = r0.q(r1)
            if (r1 == 0) goto Ld0
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r9, r4, r1)
            r4 = 2131427428(0x7f0b0064, float:1.8476472E38)
            r3.setDropDownViewResource(r4)
            r8.setAdapter(r3)
        Ld0:
            r0.w()
            r8.g = r2
            android.widget.SpinnerAdapter r2 = r8.f
            if (r2 == 0) goto Ldf
            r8.setAdapter(r2)
            r2 = 0
            r8.f = r2
        Ldf:
            a.b.g.e r2 = r8.c
            r2.e(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.x.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    /* loaded from: classes.dex */
    public class a extends i0 {
        public final /* synthetic */ e k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View src, e eVar) {
            super(src);
            this.k = eVar;
        }

        @Override // a.b.g.i0
        public a.b.f.j.p b() {
            return this.k;
        }

        @Override // a.b.g.i0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (!x.this.getInternalPopup().a()) {
                x.this.b();
                return true;
            }
            return true;
        }
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.d;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable background) {
        g gVar = this.h;
        if (gVar != null) {
            gVar.l(background);
        } else {
            super.setPopupBackgroundDrawable(background);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int resId) {
        setPopupBackgroundDrawable(a.b.c.a.a.d(getPopupContext(), resId));
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.h;
        if (gVar != null) {
            return gVar.n();
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int pixels) {
        g gVar = this.h;
        if (gVar != null) {
            gVar.m(pixels);
        } else {
            super.setDropDownVerticalOffset(pixels);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.h;
        if (gVar != null) {
            return gVar.j();
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int pixels) {
        g gVar = this.h;
        if (gVar != null) {
            gVar.p(pixels);
            this.h.c(pixels);
        } else {
            super.setDropDownHorizontalOffset(pixels);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.h;
        if (gVar != null) {
            return gVar.d();
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int pixels) {
        if (this.h != null) {
            this.i = pixels;
        } else {
            super.setDropDownWidth(pixels);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.h != null) {
            return this.i;
        }
        return super.getDropDownWidth();
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter adapter) {
        if (!this.g) {
            this.f = adapter;
            return;
        }
        super.setAdapter(adapter);
        if (this.h != null) {
            Context popupContext = this.d;
            if (popupContext == null) {
                popupContext = getContext();
            }
            this.h.o(new d(adapter, popupContext.getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.h;
        if (gVar != null && gVar.a()) {
            this.h.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        i0 i0Var = this.e;
        if (i0Var != null && i0Var.onTouch(this, event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.h != null && View.MeasureSpec.getMode(widthMeasureSpec) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            setMeasuredDimension(Math.min(Math.max(measuredWidth, a(getAdapter(), getBackground())), View.MeasureSpec.getSize(widthMeasureSpec)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.h;
        if (gVar != null) {
            if (!gVar.a()) {
                b();
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence prompt) {
        g gVar = this.h;
        if (gVar != null) {
            gVar.h(prompt);
        } else {
            super.setPrompt(prompt);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.h;
        return gVar != null ? gVar.b() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        a.b.g.e eVar = this.c;
        if (eVar != null) {
            eVar.g(resId);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        a.b.g.e eVar = this.c;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintList(ColorStateList tint) {
        a.b.g.e eVar = this.c;
        if (eVar != null) {
            eVar.i(tint);
        }
    }

    @Override // a.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        a.b.g.e eVar = this.c;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode tintMode) {
        a.b.g.e eVar = this.c;
        if (eVar != null) {
            eVar.j(tintMode);
        }
    }

    @Override // a.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        a.b.g.e eVar = this.c;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        a.b.g.e eVar = this.c;
        if (eVar != null) {
            eVar.b();
        }
    }

    public int a(SpinnerAdapter adapter, Drawable background) {
        if (adapter == null) {
            return 0;
        }
        int width = 0;
        View itemView = null;
        int itemType = 0;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int start = Math.max(0, getSelectedItemPosition());
        int end = Math.min(adapter.getCount(), start + 15);
        int count = end - start;
        for (int i = Math.max(0, start - (15 - count)); i < end; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            itemView = adapter.getView(i, itemView, this);
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        if (background != null) {
            background.getPadding(this.j);
            Rect rect = this.j;
            return width + rect.left + rect.right;
        }
        return width;
    }

    public final g getInternalPopup() {
        return this.h;
    }

    public void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.h.f(getTextDirection(), getTextAlignment());
        } else {
            this.h.f(-1, -1);
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        f ss = new f(super.onSaveInstanceState());
        g gVar = this.h;
        ss.f208b = gVar != null && gVar.a();
        return ss;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        ViewTreeObserver vto;
        f ss = (f) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if (ss.f208b && (vto = getViewTreeObserver()) != null) {
            ViewTreeObserver.OnGlobalLayoutListener listener = new b();
            vto.addOnGlobalLayoutListener(listener);
        }
    }

    /* loaded from: classes.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!x.this.getInternalPopup().a()) {
                x.this.b();
            }
            ViewTreeObserver vto = x.this.getViewTreeObserver();
            if (vto != null) {
                vto.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public boolean f208b;

        public f(Parcelable superState) {
            super(superState);
        }

        public f(Parcel in) {
            super(in);
            this.f208b = in.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f208b ? (byte) 1 : (byte) 0);
        }

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<f> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel in) {
                return new f(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int size) {
                return new f[size];
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public SpinnerAdapter f204b;
        public ListAdapter c;

        public d(SpinnerAdapter adapter, Resources.Theme dropDownTheme) {
            this.f204b = adapter;
            if (adapter instanceof ListAdapter) {
                this.c = (ListAdapter) adapter;
            }
            if (dropDownTheme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (adapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedAdapter = (ThemedSpinnerAdapter) adapter;
                    if (themedAdapter.getDropDownViewTheme() != dropDownTheme) {
                        themedAdapter.setDropDownViewTheme(dropDownTheme);
                        return;
                    }
                    return;
                }
                if (adapter instanceof t0) {
                    t0 themedAdapter2 = (t0) adapter;
                    if (themedAdapter2.getDropDownViewTheme() == null) {
                        themedAdapter2.setDropDownViewTheme(dropDownTheme);
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f204b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            SpinnerAdapter spinnerAdapter = this.f204b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            SpinnerAdapter spinnerAdapter = this.f204b;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(position);
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            return getDropDownView(position, convertView, parent);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            SpinnerAdapter spinnerAdapter = this.f204b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(position, convertView, parent);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f204b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver observer) {
            SpinnerAdapter spinnerAdapter = this.f204b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(observer);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver observer) {
            SpinnerAdapter spinnerAdapter = this.f204b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(observer);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter adapter = this.c;
            if (adapter != null) {
                return adapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int position) {
            ListAdapter adapter = this.c;
            if (adapter != null) {
                return adapter.isEnabled(position);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* loaded from: classes.dex */
    public class c implements g, DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public a.b.b.b f203b;
        public ListAdapter c;
        public CharSequence d;

        public c() {
        }

        @Override // a.b.g.x.g
        public void dismiss() {
            a.b.b.b bVar = this.f203b;
            if (bVar != null) {
                bVar.dismiss();
                this.f203b = null;
            }
        }

        @Override // a.b.g.x.g
        public boolean a() {
            a.b.b.b bVar = this.f203b;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        @Override // a.b.g.x.g
        public void o(ListAdapter adapter) {
            this.c = adapter;
        }

        @Override // a.b.g.x.g
        public void h(CharSequence hintText) {
            this.d = hintText;
        }

        @Override // a.b.g.x.g
        public CharSequence b() {
            return this.d;
        }

        @Override // a.b.g.x.g
        public void f(int textDirection, int textAlignment) {
            if (this.c == null) {
                return;
            }
            b.a builder = new b.a(x.this.getPopupContext());
            CharSequence charSequence = this.d;
            if (charSequence != null) {
                builder.h(charSequence);
            }
            builder.g(this.c, x.this.getSelectedItemPosition(), this);
            a.b.b.b a2 = builder.a();
            this.f203b = a2;
            ListView listView = a2.g();
            if (Build.VERSION.SDK_INT >= 17) {
                listView.setTextDirection(textDirection);
                listView.setTextAlignment(textAlignment);
            }
            this.f203b.show();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            x.this.setSelection(which);
            if (x.this.getOnItemClickListener() != null) {
                x.this.performItemClick(null, which, this.c.getItemId(which));
            }
            dismiss();
        }

        @Override // a.b.g.x.g
        public void l(Drawable bg) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // a.b.g.x.g
        public void m(int px) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // a.b.g.x.g
        public void c(int px) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // a.b.g.x.g
        public Drawable n() {
            return null;
        }

        @Override // a.b.g.x.g
        public int j() {
            return 0;
        }

        @Override // a.b.g.x.g
        public int d() {
            return 0;
        }

        @Override // a.b.g.x.g
        public void p(int px) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    /* loaded from: classes.dex */
    public class e extends k0 implements g {
        public CharSequence G;
        public ListAdapter H;
        public final Rect I;
        public int J;

        public e(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            this.I = new Rect();
            D(x.this);
            J(true);
            O(0);
            L(new a(x.this));
        }

        /* loaded from: classes.dex */
        public class a implements AdapterView.OnItemClickListener {
            public a(x xVar) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                x.this.setSelection(position);
                if (x.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    x.this.performItemClick(v, position, eVar.H.getItemId(position));
                }
                e.this.dismiss();
            }
        }

        @Override // a.b.g.k0, a.b.g.x.g
        public void o(ListAdapter adapter) {
            super.o(adapter);
            this.H = adapter;
        }

        @Override // a.b.g.x.g
        public CharSequence b() {
            return this.G;
        }

        @Override // a.b.g.x.g
        public void h(CharSequence hintText) {
            this.G = hintText;
        }

        public void S() {
            int hOffset;
            Drawable background = n();
            int hOffset2 = 0;
            if (background != null) {
                background.getPadding(x.this.j);
                hOffset2 = e1.b(x.this) ? x.this.j.right : -x.this.j.left;
            } else {
                Rect rect = x.this.j;
                rect.right = 0;
                rect.left = 0;
            }
            int spinnerPaddingLeft = x.this.getPaddingLeft();
            int spinnerPaddingRight = x.this.getPaddingRight();
            int spinnerWidth = x.this.getWidth();
            x xVar = x.this;
            int i = xVar.i;
            if (i == -2) {
                int contentWidth = xVar.a((SpinnerAdapter) this.H, n());
                int i2 = x.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = x.this.j;
                int contentWidthLimit = (i2 - rect2.left) - rect2.right;
                if (contentWidth > contentWidthLimit) {
                    contentWidth = contentWidthLimit;
                }
                F(Math.max(contentWidth, (spinnerWidth - spinnerPaddingLeft) - spinnerPaddingRight));
            } else if (i == -1) {
                F((spinnerWidth - spinnerPaddingLeft) - spinnerPaddingRight);
            } else {
                F(i);
            }
            if (e1.b(x.this)) {
                hOffset = hOffset2 + (((spinnerWidth - spinnerPaddingRight) - z()) - T());
            } else {
                hOffset = hOffset2 + T() + spinnerPaddingLeft;
            }
            c(hOffset);
        }

        @Override // a.b.g.x.g
        public void f(int textDirection, int textAlignment) {
            ViewTreeObserver vto;
            boolean wasShowing = a();
            S();
            I(2);
            i();
            ListView listView = e();
            listView.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                listView.setTextDirection(textDirection);
                listView.setTextAlignment(textAlignment);
            }
            P(x.this.getSelectedItemPosition());
            if (!wasShowing && (vto = x.this.getViewTreeObserver()) != null) {
                ViewTreeObserver.OnGlobalLayoutListener layoutListener = new b();
                vto.addOnGlobalLayoutListener(layoutListener);
                K(new c(layoutListener));
            }
        }

        /* loaded from: classes.dex */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.U(x.this)) {
                    e.this.dismiss();
                } else {
                    e.this.S();
                    e.this.i();
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f207b;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f207b = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver vto = x.this.getViewTreeObserver();
                if (vto != null) {
                    vto.removeGlobalOnLayoutListener(this.f207b);
                }
            }
        }

        public boolean U(View view) {
            return a.h.k.v.S(view) && view.getGlobalVisibleRect(this.I);
        }

        @Override // a.b.g.x.g
        public void p(int px) {
            this.J = px;
        }

        public int T() {
            return this.J;
        }
    }
}
