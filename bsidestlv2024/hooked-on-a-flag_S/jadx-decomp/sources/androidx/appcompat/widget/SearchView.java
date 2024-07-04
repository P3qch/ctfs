package androidx.appcompat.widget;

import a.b.g.a1;
import a.b.g.e1;
import a.b.g.j0;
import a.b.g.r0;
import a.b.g.x0;
import a.h.k.v;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.R;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class SearchView extends j0 implements a.b.f.c {
    public static final n q;
    public p A;
    public Rect B;
    public Rect C;
    public int[] D;
    public int[] E;
    public final ImageView F;
    public final Drawable G;
    public final int H;
    public final int I;
    public final Intent J;
    public final Intent K;
    public final CharSequence L;
    public l M;
    public k N;
    public View.OnFocusChangeListener O;
    public m P;
    public View.OnClickListener Q;
    public boolean R;
    public boolean S;
    public a.i.a.a T;
    public boolean U;
    public CharSequence V;
    public boolean W;
    public boolean a0;
    public int b0;
    public boolean c0;
    public CharSequence d0;
    public CharSequence e0;
    public boolean f0;
    public int g0;
    public SearchableInfo h0;
    public Bundle i0;
    public final Runnable j0;
    public Runnable k0;
    public final WeakHashMap<String, Drawable.ConstantState> l0;
    public final View.OnClickListener m0;
    public View.OnKeyListener n0;
    public final TextView.OnEditorActionListener o0;
    public final AdapterView.OnItemClickListener p0;
    public final AdapterView.OnItemSelectedListener q0;
    public final SearchAutoComplete r;
    public TextWatcher r0;
    public final View s;
    public final View t;
    public final View u;
    public final ImageView v;
    public final ImageView w;
    public final ImageView x;
    public final ImageView y;
    public final View z;

    /* loaded from: classes.dex */
    public interface k {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface l {
        boolean a(String str);

        boolean b(String str);
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean a(int i);

        boolean b(int i);
    }

    static {
        q = Build.VERSION.SDK_INT < 29 ? new n() : null;
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.f0();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.i.a.a aVar = SearchView.this.T;
            if (aVar instanceof r0) {
                aVar.b(null);
            }
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.B = new Rect();
        this.C = new Rect();
        this.D = new int[2];
        this.E = new int[2];
        this.j0 = new b();
        this.k0 = new c();
        this.l0 = new WeakHashMap<>();
        f fVar = new f();
        this.m0 = fVar;
        this.n0 = new g();
        h hVar = new h();
        this.o0 = hVar;
        i iVar = new i();
        this.p0 = iVar;
        j jVar = new j();
        this.q0 = jVar;
        this.r0 = new a();
        x0 a2 = x0.v(context, attrs, a.b.a.t, defStyleAttr, 0);
        LayoutInflater inflater = LayoutInflater.from(context);
        int[] iArr = a.b.a.f11a;
        int layoutResId = a2.n(9, R.layout.abc_search_view);
        inflater.inflate(layoutResId, (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.r = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.s = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.t = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.u = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.v = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.w = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.x = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.y = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.F = imageView5;
        v.r0(findViewById, a2.g(10));
        v.r0(findViewById2, a2.g(14));
        imageView.setImageDrawable(a2.g(13));
        imageView2.setImageDrawable(a2.g(7));
        imageView3.setImageDrawable(a2.g(4));
        imageView4.setImageDrawable(a2.g(16));
        imageView5.setImageDrawable(a2.g(13));
        this.G = a2.g(12);
        a1.a(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.H = a2.n(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.I = a2.n(5, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.r0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.n0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(a2.a(8, true));
        int maxWidth = a2.f(1, -1);
        if (maxWidth != -1) {
            setMaxWidth(maxWidth);
        }
        this.L = a2.p(6);
        this.V = a2.p(11);
        int imeOptions = a2.k(3, -1);
        if (imeOptions != -1) {
            setImeOptions(imeOptions);
        }
        int inputType = a2.k(2, -1);
        if (inputType != -1) {
            setInputType(inputType);
        }
        boolean focusable = a2.a(0, true);
        setFocusable(focusable);
        a2.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.J = intent;
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.K = intent2;
        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.z = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        k0(this.R);
        g0();
    }

    /* loaded from: classes.dex */
    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View v, boolean hasFocus) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.O;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, hasFocus);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            SearchView.this.B();
        }
    }

    public int getSuggestionRowLayout() {
        return this.H;
    }

    public int getSuggestionCommitIconResId() {
        return this.I;
    }

    public void setSearchableInfo(SearchableInfo searchable) {
        this.h0 = searchable;
        if (searchable != null) {
            h0();
            g0();
        }
        boolean K = K();
        this.c0 = K;
        if (K) {
            this.r.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setAppSearchData(Bundle appSearchData) {
        this.i0 = appSearchData;
    }

    public void setImeOptions(int imeOptions) {
        this.r.setImeOptions(imeOptions);
    }

    public int getImeOptions() {
        return this.r.getImeOptions();
    }

    public void setInputType(int inputType) {
        this.r.setInputType(inputType);
    }

    public int getInputType() {
        return this.r.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        if (this.a0 || !isFocusable()) {
            return false;
        }
        if (!L()) {
            boolean result = this.r.requestFocus(direction, previouslyFocusedRect);
            if (result) {
                k0(false);
            }
            return result;
        }
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.a0 = true;
        super.clearFocus();
        this.r.clearFocus();
        this.r.setImeVisibility(false);
        this.a0 = false;
    }

    public void setOnQueryTextListener(l listener) {
        this.M = listener;
    }

    public void setOnCloseListener(k listener) {
        this.N = listener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener listener) {
        this.O = listener;
    }

    public void setOnSuggestionListener(m listener) {
        this.P = listener;
    }

    public void setOnSearchClickListener(View.OnClickListener listener) {
        this.Q = listener;
    }

    public CharSequence getQuery() {
        return this.r.getText();
    }

    public void d0(CharSequence query, boolean submit) {
        this.r.setText(query);
        if (query != null) {
            SearchAutoComplete searchAutoComplete = this.r;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.e0 = query;
        }
        if (submit && !TextUtils.isEmpty(query)) {
            W();
        }
    }

    public void setQueryHint(CharSequence hint) {
        this.V = hint;
        g0();
    }

    public CharSequence getQueryHint() {
        if (this.V != null) {
            CharSequence hint = this.V;
            return hint;
        }
        SearchableInfo searchableInfo = this.h0;
        if (searchableInfo != null && searchableInfo.getHintId() != 0) {
            CharSequence hint2 = getContext().getText(this.h0.getHintId());
            return hint2;
        }
        CharSequence hint3 = this.L;
        return hint3;
    }

    public void setIconifiedByDefault(boolean iconified) {
        if (this.R == iconified) {
            return;
        }
        this.R = iconified;
        k0(iconified);
        g0();
    }

    public void setIconified(boolean iconify) {
        if (iconify) {
            R();
        } else {
            V();
        }
    }

    public boolean L() {
        return this.S;
    }

    public void setSubmitButtonEnabled(boolean enabled) {
        this.U = enabled;
        k0(L());
    }

    public void setQueryRefinementEnabled(boolean enable) {
        this.W = enable;
        a.i.a.a aVar = this.T;
        if (aVar instanceof r0) {
            ((r0) aVar).x(enable ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(a.i.a.a adapter) {
        this.T = adapter;
        this.r.setAdapter(adapter);
    }

    public a.i.a.a getSuggestionsAdapter() {
        return this.T;
    }

    public void setMaxWidth(int maxpixels) {
        this.b0 = maxpixels;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.b0;
    }

    @Override // a.b.g.j0, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (L()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        switch (widthMode) {
            case Integer.MIN_VALUE:
                int i2 = this.b0;
                if (i2 > 0) {
                    width = Math.min(i2, width);
                    break;
                } else {
                    width = Math.min(getPreferredWidth(), width);
                    break;
                }
            case 0:
                int i3 = this.b0;
                if (i3 <= 0) {
                    i3 = getPreferredWidth();
                }
                width = i3;
                break;
            case 1073741824:
                int i4 = this.b0;
                if (i4 > 0) {
                    width = Math.min(i4, width);
                    break;
                }
                break;
        }
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        switch (heightMode) {
            case Integer.MIN_VALUE:
                height = Math.min(getPreferredHeight(), height);
                break;
            case 0:
                height = getPreferredHeight();
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
    }

    @Override // a.b.g.j0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            I(this.r, this.B);
            Rect rect = this.C;
            Rect rect2 = this.B;
            rect.set(rect2.left, 0, rect2.right, bottom - top);
            p pVar = this.A;
            if (pVar == null) {
                p pVar2 = new p(this.C, this.B, this.r);
                this.A = pVar2;
                setTouchDelegate(pVar2);
                return;
            }
            pVar.a(this.C, this.B);
        }
    }

    public final void I(View view, Rect rect) {
        view.getLocationInWindow(this.D);
        getLocationInWindow(this.E);
        int[] iArr = this.D;
        int i2 = iArr[1];
        int[] iArr2 = this.E;
        int top = i2 - iArr2[1];
        int left = iArr[0] - iArr2[0];
        rect.set(left, top, view.getWidth() + left, view.getHeight() + top);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    public final void k0(boolean collapsed) {
        int iconVisibility;
        this.S = collapsed;
        int visCollapsed = collapsed ? 0 : 8;
        boolean hasText = !TextUtils.isEmpty(this.r.getText());
        this.v.setVisibility(visCollapsed);
        j0(hasText);
        this.s.setVisibility(collapsed ? 8 : 0);
        if (this.F.getDrawable() == null || this.R) {
            iconVisibility = 8;
        } else {
            iconVisibility = 0;
        }
        this.F.setVisibility(iconVisibility);
        e0();
        l0(hasText ? false : true);
        i0();
    }

    public final boolean K() {
        SearchableInfo searchableInfo = this.h0;
        if (searchableInfo != null && searchableInfo.getVoiceSearchEnabled()) {
            Intent testIntent = null;
            if (this.h0.getVoiceSearchLaunchWebSearch()) {
                testIntent = this.J;
            } else if (this.h0.getVoiceSearchLaunchRecognizer()) {
                testIntent = this.K;
            }
            if (testIntent != null) {
                ResolveInfo ri = getContext().getPackageManager().resolveActivity(testIntent, 65536);
                return ri != null;
            }
        }
        return false;
    }

    public final boolean N() {
        return (this.U || this.c0) && !L();
    }

    public final void j0(boolean hasText) {
        int visibility = 8;
        if (this.U && N() && hasFocus() && (hasText || !this.c0)) {
            visibility = 0;
        }
        this.w.setVisibility(visibility);
    }

    public final void i0() {
        int visibility = 8;
        if (N() && (this.w.getVisibility() == 0 || this.y.getVisibility() == 0)) {
            visibility = 0;
        }
        this.u.setVisibility(visibility);
    }

    public final void e0() {
        boolean showClose = true;
        boolean hasText = !TextUtils.isEmpty(this.r.getText());
        if (!hasText && (!this.R || this.f0)) {
            showClose = false;
        }
        this.x.setVisibility(showClose ? 0 : 8);
        Drawable closeButtonImg = this.x.getDrawable();
        if (closeButtonImg != null) {
            closeButtonImg.setState(hasText ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void b0() {
        post(this.j0);
    }

    public void f0() {
        boolean focused = this.r.hasFocus();
        int[] stateSet = focused ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable searchPlateBg = this.t.getBackground();
        if (searchPlateBg != null) {
            searchPlateBg.setState(stateSet);
        }
        Drawable submitAreaBg = this.u.getBackground();
        if (submitAreaBg != null) {
            submitAreaBg.setState(stateSet);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.j0);
        post(this.k0);
        super.onDetachedFromWindow();
    }

    public void U(CharSequence queryText) {
        setQuery(queryText);
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            SearchView searchView = SearchView.this;
            if (v == searchView.v) {
                searchView.V();
                return;
            }
            if (v == searchView.x) {
                searchView.R();
                return;
            }
            if (v == searchView.w) {
                searchView.W();
            } else if (v == searchView.y) {
                searchView.a0();
            } else if (v == searchView.r) {
                searchView.H();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            SearchView searchView = SearchView.this;
            if (searchView.h0 == null) {
                return false;
            }
            if (searchView.r.isPopupShowing() && SearchView.this.r.getListSelection() != -1) {
                return SearchView.this.X(keyCode, event);
            }
            if (SearchView.this.r.b() || !event.hasNoModifiers() || event.getAction() != 1 || keyCode != 66) {
                return false;
            }
            v.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, null, searchView2.r.getText().toString());
            return true;
        }
    }

    public boolean X(int keyCode, KeyEvent event) {
        if (this.h0 != null && this.T != null && event.getAction() == 0 && event.hasNoModifiers()) {
            if (keyCode == 66 || keyCode == 84 || keyCode == 61) {
                int position = this.r.getListSelection();
                return S(position);
            }
            if (keyCode == 21 || keyCode == 22) {
                int selPoint = keyCode == 21 ? 0 : this.r.length();
                this.r.setSelection(selPoint);
                this.r.setListSelection(0);
                this.r.clearListSelection();
                this.r.a();
                return true;
            }
            if (keyCode != 19 || this.r.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    public final CharSequence J(CharSequence hintText) {
        if (!this.R || this.G == null) {
            return hintText;
        }
        double textSize = this.r.getTextSize();
        Double.isNaN(textSize);
        int textSize2 = (int) (textSize * 1.25d);
        this.G.setBounds(0, 0, textSize2, textSize2);
        SpannableStringBuilder ssb = new SpannableStringBuilder("   ");
        ssb.setSpan(new ImageSpan(this.G), 1, 2, 33);
        ssb.append(hintText);
        return ssb;
    }

    public final void g0() {
        CharSequence hint = getQueryHint();
        this.r.setHint(J(hint == null ? BuildConfig.FLAVOR : hint));
    }

    public final void h0() {
        this.r.setThreshold(this.h0.getSuggestThreshold());
        this.r.setImeOptions(this.h0.getImeOptions());
        int inputType = this.h0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.h0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.r.setInputType(inputType);
        a.i.a.a aVar = this.T;
        if (aVar != null) {
            aVar.b(null);
        }
        if (this.h0.getSuggestAuthority() != null) {
            r0 r0Var = new r0(getContext(), this, this.h0, this.l0);
            this.T = r0Var;
            this.r.setAdapter(r0Var);
            ((r0) this.T).x(this.W ? 2 : 1);
        }
    }

    public final void l0(boolean empty) {
        int visibility = 8;
        if (this.c0 && !L() && empty) {
            visibility = 0;
            this.w.setVisibility(8);
        }
        this.y.setVisibility(visibility);
    }

    /* loaded from: classes.dex */
    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            SearchView.this.W();
            return true;
        }
    }

    public void Y(CharSequence newText) {
        CharSequence text = this.r.getText();
        this.e0 = text;
        boolean hasText = !TextUtils.isEmpty(text);
        j0(hasText);
        l0(hasText ? false : true);
        e0();
        i0();
        if (this.M != null && !TextUtils.equals(newText, this.d0)) {
            this.M.b(newText.toString());
        }
        this.d0 = newText.toString();
    }

    public void W() {
        CharSequence query = this.r.getText();
        if (query != null && TextUtils.getTrimmedLength(query) > 0) {
            l lVar = this.M;
            if (lVar == null || !lVar.a(query.toString())) {
                if (this.h0 != null) {
                    P(0, null, query.toString());
                }
                this.r.setImeVisibility(false);
                G();
            }
        }
    }

    public final void G() {
        this.r.dismissDropDown();
    }

    public void R() {
        CharSequence text = this.r.getText();
        if (TextUtils.isEmpty(text)) {
            if (this.R) {
                k kVar = this.N;
                if (kVar == null || !kVar.a()) {
                    clearFocus();
                    k0(true);
                    return;
                }
                return;
            }
            return;
        }
        this.r.setText(BuildConfig.FLAVOR);
        this.r.requestFocus();
        this.r.setImeVisibility(true);
    }

    public void V() {
        k0(false);
        this.r.requestFocus();
        this.r.setImeVisibility(true);
        View.OnClickListener onClickListener = this.Q;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void a0() {
        if (this.h0 == null) {
            return;
        }
        SearchableInfo searchable = this.h0;
        try {
            if (searchable.getVoiceSearchLaunchWebSearch()) {
                Intent webSearchIntent = F(this.J, searchable);
                getContext().startActivity(webSearchIntent);
            } else if (searchable.getVoiceSearchLaunchRecognizer()) {
                Intent appSearchIntent = E(this.K, searchable);
                getContext().startActivity(appSearchIntent);
            }
        } catch (ActivityNotFoundException e2) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public void Z() {
        k0(L());
        b0();
        if (this.r.hasFocus()) {
            H();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        b0();
    }

    @Override // a.b.f.c
    public void f() {
        d0(BuildConfig.FLAVOR, false);
        clearFocus();
        k0(true);
        this.r.setImeOptions(this.g0);
        this.f0 = false;
    }

    @Override // a.b.f.c
    public void a() {
        if (this.f0) {
            return;
        }
        this.f0 = true;
        int imeOptions = this.r.getImeOptions();
        this.g0 = imeOptions;
        this.r.setImeOptions(imeOptions | 33554432);
        this.r.setText(BuildConfig.FLAVOR);
        setIconified(false);
    }

    /* loaded from: classes.dex */
    public static class o extends a.j.a.a {
        public static final Parcelable.Creator<o> CREATOR = new a();
        public boolean d;

        public o(Parcelable superState) {
            super(superState);
        }

        public o(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.d = ((Boolean) source.readValue(null)).booleanValue();
        }

        @Override // a.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeValue(Boolean.valueOf(this.d));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.d + "}";
        }

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<o> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public o createFromParcel(Parcel in, ClassLoader loader) {
                return new o(in, loader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public o createFromParcel(Parcel in) {
                return new o(in, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public o[] newArray(int size) {
                return new o[size];
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        o ss = new o(superState);
        ss.d = L();
        return ss;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof o)) {
            super.onRestoreInstanceState(state);
            return;
        }
        o ss = (o) state;
        super.onRestoreInstanceState(ss.j());
        k0(ss.d);
        requestLayout();
    }

    public void B() {
        int iconOffset;
        int offset;
        if (this.z.getWidth() > 1) {
            Resources res = getContext().getResources();
            int anchorPadding = this.t.getPaddingLeft();
            Rect dropDownPadding = new Rect();
            boolean isLayoutRtl = e1.b(this);
            if (this.R) {
                iconOffset = res.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + res.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
            } else {
                iconOffset = 0;
            }
            this.r.getDropDownBackground().getPadding(dropDownPadding);
            if (isLayoutRtl) {
                offset = -dropDownPadding.left;
            } else {
                int offset2 = dropDownPadding.left;
                offset = anchorPadding - (offset2 + iconOffset);
            }
            this.r.setDropDownHorizontalOffset(offset);
            int width = (((this.z.getWidth() + dropDownPadding.left) + dropDownPadding.right) + iconOffset) - anchorPadding;
            this.r.setDropDownWidth(width);
        }
    }

    public boolean S(int position) {
        m mVar = this.P;
        if (mVar != null && mVar.b(position)) {
            return false;
        }
        Q(position, 0, null);
        this.r.setImeVisibility(false);
        G();
        return true;
    }

    public boolean T(int position) {
        m mVar = this.P;
        if (mVar == null || !mVar.a(position)) {
            c0(position);
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            SearchView.this.S(position);
        }
    }

    /* loaded from: classes.dex */
    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SearchView.this.T(position);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    public final void c0(int position) {
        CharSequence oldQuery = this.r.getText();
        Cursor c2 = this.T.d();
        if (c2 == null) {
            return;
        }
        if (c2.moveToPosition(position)) {
            CharSequence newQuery = this.T.c(c2);
            if (newQuery != null) {
                setQuery(newQuery);
                return;
            } else {
                setQuery(oldQuery);
                return;
            }
        }
        setQuery(oldQuery);
    }

    public final boolean Q(int position, int actionKey, String actionMsg) {
        Cursor c2 = this.T.d();
        if (c2 != null && c2.moveToPosition(position)) {
            Intent intent = D(c2, actionKey, actionMsg);
            O(intent);
            return true;
        }
        return false;
    }

    public final void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException ex) {
            Log.e("SearchView", "Failed launch activity: " + intent, ex);
        }
    }

    private void setQuery(CharSequence query) {
        this.r.setText(query);
        this.r.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
    }

    public void P(int actionKey, String actionMsg, String query) {
        Intent intent = C("android.intent.action.SEARCH", null, null, query, actionKey, actionMsg);
        getContext().startActivity(intent);
    }

    public final Intent C(String action, Uri data, String extraData, String query, int actionKey, String actionMsg) {
        Intent intent = new Intent(action);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (data != null) {
            intent.setData(data);
        }
        intent.putExtra("user_query", this.e0);
        if (query != null) {
            intent.putExtra("query", query);
        }
        if (extraData != null) {
            intent.putExtra("intent_extra_data_key", extraData);
        }
        Bundle bundle = this.i0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (actionKey != 0) {
            intent.putExtra("action_key", actionKey);
            intent.putExtra("action_msg", actionMsg);
        }
        intent.setComponent(this.h0.getSearchActivity());
        return intent;
    }

    public final Intent F(Intent baseIntent, SearchableInfo searchable) {
        Intent voiceIntent = new Intent(baseIntent);
        ComponentName searchActivity = searchable.getSearchActivity();
        voiceIntent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return voiceIntent;
    }

    public final Intent E(Intent baseIntent, SearchableInfo searchable) {
        ComponentName searchActivity = searchable.getSearchActivity();
        Intent queryIntent = new Intent("android.intent.action.SEARCH");
        queryIntent.setComponent(searchActivity);
        PendingIntent pending = PendingIntent.getActivity(getContext(), 0, queryIntent, 1073741824);
        Bundle queryExtras = new Bundle();
        Bundle bundle = this.i0;
        if (bundle != null) {
            queryExtras.putParcelable("app_data", bundle);
        }
        Intent voiceIntent = new Intent(baseIntent);
        String languageModel = "free_form";
        String prompt = null;
        String language = null;
        int maxResults = 1;
        Resources resources = getResources();
        if (searchable.getVoiceLanguageModeId() != 0) {
            languageModel = resources.getString(searchable.getVoiceLanguageModeId());
        }
        if (searchable.getVoicePromptTextId() != 0) {
            prompt = resources.getString(searchable.getVoicePromptTextId());
        }
        if (searchable.getVoiceLanguageId() != 0) {
            language = resources.getString(searchable.getVoiceLanguageId());
        }
        if (searchable.getVoiceMaxResults() != 0) {
            maxResults = searchable.getVoiceMaxResults();
        }
        voiceIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", languageModel);
        voiceIntent.putExtra("android.speech.extra.PROMPT", prompt);
        voiceIntent.putExtra("android.speech.extra.LANGUAGE", language);
        voiceIntent.putExtra("android.speech.extra.MAX_RESULTS", maxResults);
        voiceIntent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        voiceIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", pending);
        voiceIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", queryExtras);
        return voiceIntent;
    }

    public final Intent D(Cursor c2, int actionKey, String actionMsg) {
        int rowNum;
        String data;
        String id;
        try {
            String action = r0.n(c2, "suggest_intent_action");
            if (action == null) {
                action = this.h0.getSuggestIntentAction();
            }
            if (action == null) {
                action = "android.intent.action.SEARCH";
            }
            String data2 = r0.n(c2, "suggest_intent_data");
            if (data2 == null) {
                data2 = this.h0.getSuggestIntentData();
            }
            if (data2 != null && (id = r0.n(c2, "suggest_intent_data_id")) != null) {
                data = data2 + "/" + Uri.encode(id);
            } else {
                data = data2;
            }
            Uri dataUri = data == null ? null : Uri.parse(data);
            String query = r0.n(c2, "suggest_intent_query");
            String extraData = r0.n(c2, "suggest_intent_extra_data");
            return C(action, dataUri, extraData, query, actionKey, actionMsg);
        } catch (RuntimeException e2) {
            try {
                rowNum = c2.getPosition();
            } catch (RuntimeException e3) {
                rowNum = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + rowNum + " returned exception.", e2);
            return null;
        }
    }

    public void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.r.refreshAutoCompleteResults();
            return;
        }
        n nVar = q;
        nVar.b(this.r);
        nVar.a(this.r);
    }

    public static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int before, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int after) {
            SearchView.this.Y(s);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }
    }

    /* loaded from: classes.dex */
    public static class p extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final View f826a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f827b;
        public final Rect c;
        public final Rect d;
        public final int e;
        public boolean f;

        public p(Rect targetBounds, Rect actualBounds, View delegateView) {
            super(targetBounds, delegateView);
            this.e = ViewConfiguration.get(delegateView.getContext()).getScaledTouchSlop();
            this.f827b = new Rect();
            this.d = new Rect();
            this.c = new Rect();
            a(targetBounds, actualBounds);
            this.f826a = delegateView;
        }

        public void a(Rect desiredBounds, Rect actualBounds) {
            this.f827b.set(desiredBounds);
            this.d.set(desiredBounds);
            Rect rect = this.d;
            int i = this.e;
            rect.inset(-i, -i);
            this.c.set(actualBounds);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            boolean sendToDelegate = false;
            boolean hit = true;
            switch (event.getAction()) {
                case 0:
                    if (this.f827b.contains(x, y)) {
                        this.f = true;
                        sendToDelegate = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                    sendToDelegate = this.f;
                    if (sendToDelegate && !this.d.contains(x, y)) {
                        hit = false;
                        break;
                    }
                    break;
                case 3:
                    sendToDelegate = this.f;
                    this.f = false;
                    break;
            }
            if (!sendToDelegate) {
                return false;
            }
            if (hit && !this.c.contains(x, y)) {
                event.setLocation(this.f826a.getWidth() / 2, this.f826a.getHeight() / 2);
            } else {
                Rect rect = this.c;
                event.setLocation(x - rect.left, y - rect.top);
            }
            boolean handled = this.f826a.dispatchTouchEvent(event);
            return handled;
        }
    }

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends a.b.g.d {
        public int e;
        public SearchView f;
        public boolean g;
        public final Runnable h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attrs) {
            this(context, attrs, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            this.h = new a();
            this.e = getThreshold();
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), metrics));
        }

        public void setSearchView(SearchView searchView) {
            this.f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int threshold) {
            super.setThreshold(threshold);
            this.e = threshold;
        }

        public boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence text) {
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean hasWindowFocus) {
            super.onWindowFocusChanged(hasWindowFocus);
            if (hasWindowFocus && this.f.hasFocus() && getVisibility() == 0) {
                this.g = true;
                if (SearchView.M(getContext())) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            this.f.Z();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.e <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int keyCode, KeyEvent event) {
            if (keyCode == 4) {
                if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state != null) {
                        state.startTracking(event, this);
                    }
                    return true;
                }
                if (event.getAction() == 1) {
                    KeyEvent.DispatcherState state2 = getKeyDispatcherState();
                    if (state2 != null) {
                        state2.handleUpEvent(event);
                    }
                    if (event.isTracking() && !event.isCanceled()) {
                        this.f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(keyCode, event);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration config = getResources().getConfiguration();
            int widthDp = config.screenWidthDp;
            int heightDp = config.screenHeightDp;
            if (widthDp >= 960 && heightDp >= 720 && config.orientation == 2) {
                return 256;
            }
            if (widthDp >= 600) {
                return 192;
            }
            if (widthDp >= 640 && heightDp >= 480) {
                return 192;
            }
            return 160;
        }

        @Override // a.b.g.d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection ic = super.onCreateInputConnection(editorInfo);
            if (this.g) {
                removeCallbacks(this.h);
                post(this.h);
            }
            return ic;
        }

        public void c() {
            if (this.g) {
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
                imm.showSoftInput(this, 0);
                this.g = false;
            }
        }

        public void setImeVisibility(boolean visible) {
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
            if (!visible) {
                this.g = false;
                removeCallbacks(this.h);
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (imm.isActive(this)) {
                    this.g = false;
                    removeCallbacks(this.h);
                    imm.showSoftInput(this, 0);
                    return;
                }
                this.g = true;
            }
        }

        public void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.q.c(this);
        }
    }

    /* loaded from: classes.dex */
    public static class n {

        /* renamed from: a, reason: collision with root package name */
        public Method f824a;

        /* renamed from: b, reason: collision with root package name */
        public Method f825b;
        public Method c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public n() {
            this.f824a = null;
            this.f825b = null;
            this.c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f824a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f825b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
        }

        public void b(AutoCompleteTextView view) {
            d();
            Method method = this.f824a;
            if (method != null) {
                try {
                    method.invoke(view, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        public void a(AutoCompleteTextView view) {
            d();
            Method method = this.f825b;
            if (method != null) {
                try {
                    method.invoke(view, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        public void c(AutoCompleteTextView view) {
            d();
            Method method = this.c;
            if (method != null) {
                try {
                    method.invoke(view, true);
                } catch (Exception e) {
                }
            }
        }

        public static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }
}
