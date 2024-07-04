package androidx.appcompat.app;

import a.b.g.j0;
import a.h.k.v;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;
import net.sqlcipher.R;
import net.sqlcipher.database.SQLiteCursor;

/* loaded from: classes.dex */
public class AlertController {
    public NestedScrollView A;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public Handler R;

    /* renamed from: a, reason: collision with root package name */
    public final Context f783a;

    /* renamed from: b, reason: collision with root package name */
    public final a.b.b.g f784b;
    public final Window c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public ListView g;
    public View h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Button o;
    public CharSequence p;
    public Message q;
    public Drawable r;
    public Button s;
    public CharSequence t;
    public Message u;
    public Drawable v;
    public Button w;
    public CharSequence x;
    public Message y;
    public Drawable z;
    public boolean n = false;
    public int B = 0;
    public int I = -1;
    public int Q = 0;
    public final View.OnClickListener S = new a();

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Message m;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (v == alertController.o && (message3 = alertController.q) != null) {
                m = Message.obtain(message3);
            } else if (v == alertController.s && (message2 = alertController.u) != null) {
                m = Message.obtain(message2);
            } else if (v == alertController.w && (message = alertController.y) != null) {
                m = Message.obtain(message);
            } else {
                m = null;
            }
            if (m != null) {
                m.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f784b).sendToTarget();
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f796a;

        public g(DialogInterface dialog) {
            this.f796a = new WeakReference<>(dialog);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case -3:
                case -2:
                case SQLiteCursor.NO_COUNT /* -1 */:
                    ((DialogInterface.OnClickListener) msg.obj).onClick(this.f796a.get(), msg.what);
                    return;
                case 0:
                default:
                    return;
                case 1:
                    ((DialogInterface) msg.obj).dismiss();
                    return;
            }
        }
    }

    public static boolean s(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, outValue, true);
        return outValue.data != 0;
    }

    public AlertController(Context context, a.b.b.g di, Window window) {
        this.f783a = context;
        this.f784b = di;
        this.c = window;
        this.R = new g(di);
        TypedArray a2 = context.obtainStyledAttributes(null, a.b.a.e, R.attr.alertDialogStyle, 0);
        int[] iArr = a.b.a.f11a;
        this.J = a2.getResourceId(0, 0);
        this.K = a2.getResourceId(2, 0);
        this.L = a2.getResourceId(4, 0);
        this.M = a2.getResourceId(5, 0);
        this.N = a2.getResourceId(7, 0);
        this.O = a2.getResourceId(3, 0);
        this.P = a2.getBoolean(6, true);
        this.d = a2.getDimensionPixelSize(1, 0);
        a2.recycle();
        di.e(1);
    }

    public static boolean a(View v) {
        if (v.onCheckIsTextEditor()) {
            return true;
        }
        if (!(v instanceof ViewGroup)) {
            return false;
        }
        ViewGroup vg = (ViewGroup) v;
        int i = vg.getChildCount();
        while (i > 0) {
            i--;
            if (a(vg.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    public void d() {
        int contentView = i();
        this.f784b.setContentView(contentView);
        r();
    }

    public final int i() {
        if (this.K == 0) {
            return this.J;
        }
        return this.J;
    }

    public void m(CharSequence title) {
        this.e = title;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(title);
        }
    }

    public void j(View customTitleView) {
        this.G = customTitleView;
    }

    public void k(Drawable icon) {
        this.C = icon;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (icon != null) {
                imageView.setVisibility(0);
                this.D.setImageDrawable(icon);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public ListView c() {
        return this.g;
    }

    public boolean f(KeyEvent event) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(event);
    }

    public boolean g(KeyEvent event) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(event);
    }

    public final ViewGroup h(View customPanel, View defaultPanel) {
        if (customPanel == null) {
            if (defaultPanel instanceof ViewStub) {
                defaultPanel = ((ViewStub) defaultPanel).inflate();
            }
            return (ViewGroup) defaultPanel;
        }
        if (defaultPanel != null) {
            ViewParent parent = defaultPanel.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(defaultPanel);
            }
        }
        if (customPanel instanceof ViewStub) {
            customPanel = ((ViewStub) customPanel).inflate();
        }
        return (ViewGroup) customPanel;
    }

    public final void r() {
        ListAdapter listAdapter;
        View spacer;
        View parentPanel = this.c.findViewById(R.id.parentPanel);
        View defaultTopPanel = parentPanel.findViewById(R.id.topPanel);
        View defaultContentPanel = parentPanel.findViewById(R.id.contentPanel);
        View defaultButtonPanel = parentPanel.findViewById(R.id.buttonPanel);
        ViewGroup customPanel = (ViewGroup) parentPanel.findViewById(R.id.customPanel);
        p(customPanel);
        View customTopPanel = customPanel.findViewById(R.id.topPanel);
        View customContentPanel = customPanel.findViewById(R.id.contentPanel);
        View customButtonPanel = customPanel.findViewById(R.id.buttonPanel);
        ViewGroup topPanel = h(customTopPanel, defaultTopPanel);
        ViewGroup contentPanel = h(customContentPanel, defaultContentPanel);
        ViewGroup buttonPanel = h(customButtonPanel, defaultButtonPanel);
        o(contentPanel);
        n(buttonPanel);
        q(topPanel);
        boolean hasCustomPanel = customPanel.getVisibility() != 8;
        boolean hasTopPanel = (topPanel == null || topPanel.getVisibility() == 8) ? false : true;
        boolean hasButtonPanel = buttonPanel.getVisibility() != 8;
        if (!hasButtonPanel && (spacer = contentPanel.findViewById(R.id.textSpacerNoButtons)) != null) {
            spacer.setVisibility(0);
        }
        if (hasTopPanel) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View divider = null;
            if (this.f != null || this.g != null) {
                divider = topPanel.findViewById(R.id.titleDividerNoCustom);
            }
            if (divider != null) {
                divider.setVisibility(0);
            }
        } else {
            View spacer2 = contentPanel.findViewById(R.id.textSpacerNoTitle);
            if (spacer2 != null) {
                spacer2.setVisibility(0);
            }
        }
        View spacer3 = this.g;
        if (spacer3 instanceof RecycleListView) {
            ((RecycleListView) spacer3).a(hasTopPanel, hasButtonPanel);
        }
        if (!hasCustomPanel) {
            View content = this.g;
            if (content == null) {
                content = this.A;
            }
            if (content != null) {
                int indicators = (hasTopPanel ? 1 : 0) | (hasButtonPanel ? 2 : 0);
                l(contentPanel, content, indicators, 3);
            }
        }
        ListView listView = this.g;
        if (listView != null && (listAdapter = this.H) != null) {
            listView.setAdapter(listAdapter);
            int checkedItem = this.I;
            if (checkedItem > -1) {
                listView.setItemChecked(checkedItem, true);
                listView.setSelection(checkedItem);
            }
        }
    }

    public final void l(ViewGroup contentPanel, View content, int indicators, int mask) {
        View indicatorUp = this.c.findViewById(R.id.scrollIndicatorUp);
        View indicatorDown = this.c.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            v.B0(content, indicators, mask);
            if (indicatorUp != null) {
                contentPanel.removeView(indicatorUp);
            }
            if (indicatorDown != null) {
                contentPanel.removeView(indicatorDown);
                return;
            }
            return;
        }
        if (indicatorUp != null && (indicators & 1) == 0) {
            contentPanel.removeView(indicatorUp);
            indicatorUp = null;
        }
        if (indicatorDown != null && (indicators & 2) == 0) {
            contentPanel.removeView(indicatorDown);
            indicatorDown = null;
        }
        if (indicatorUp != null || indicatorDown != null) {
            View top = indicatorUp;
            View bottom = indicatorDown;
            if (this.f != null) {
                this.A.setOnScrollChangeListener(new b(this, top, bottom));
                this.A.post(new c(top, bottom));
                return;
            }
            ListView listView = this.g;
            if (listView != null) {
                listView.setOnScrollListener(new d(this, top, bottom));
                this.g.post(new e(top, bottom));
                return;
            }
            if (top != null) {
                contentPanel.removeView(top);
            }
            if (bottom != null) {
                contentPanel.removeView(bottom);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements NestedScrollView.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f787a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f788b;

        public b(AlertController this$0, View view, View view2) {
            this.f787a = view;
            this.f788b = view2;
        }

        public void a(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            AlertController.e(v, this.f787a, this.f788b);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f789b;
        public final /* synthetic */ View c;

        public c(View view, View view2) {
            this.f789b = view;
            this.c = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.e(AlertController.this.A, this.f789b, this.c);
        }
    }

    /* loaded from: classes.dex */
    public class d implements AbsListView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f790a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f791b;

        public d(AlertController this$0, View view, View view2) {
            this.f790a = view;
            this.f791b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView view, int scrollState) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView v, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            AlertController.e(v, this.f790a, this.f791b);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f792b;
        public final /* synthetic */ View c;

        public e(View view, View view2) {
            this.f792b = view;
            this.c = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.e(AlertController.this.g, this.f792b, this.c);
        }
    }

    public final void p(ViewGroup customPanel) {
        View customView;
        if (this.h != null) {
            customView = this.h;
        } else if (this.i != 0) {
            LayoutInflater inflater = LayoutInflater.from(this.f783a);
            customView = inflater.inflate(this.i, customPanel, false);
        } else {
            customView = null;
        }
        boolean hasCustomView = customView != null;
        if (!hasCustomView || !a(customView)) {
            this.c.setFlags(131072, 131072);
        }
        if (hasCustomView) {
            FrameLayout custom = (FrameLayout) this.c.findViewById(R.id.custom);
            custom.addView(customView, new ViewGroup.LayoutParams(-1, -1));
            if (this.n) {
                custom.setPadding(this.j, this.k, this.l, this.m);
            }
            if (this.g != null) {
                ((LinearLayout.LayoutParams) ((j0.a) customPanel.getLayoutParams())).weight = 0.0f;
                return;
            }
            return;
        }
        customPanel.setVisibility(8);
    }

    public final void q(ViewGroup topPanel) {
        if (this.G != null) {
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(-1, -2);
            topPanel.addView(this.G, 0, lp);
            View titleTemplate = this.c.findViewById(R.id.title_template);
            titleTemplate.setVisibility(8);
            return;
        }
        this.D = (ImageView) this.c.findViewById(android.R.id.icon);
        boolean hasTextTitle = !TextUtils.isEmpty(this.e);
        if (hasTextTitle && this.P) {
            TextView textView = (TextView) this.c.findViewById(R.id.alertTitle);
            this.E = textView;
            textView.setText(this.e);
            int i = this.B;
            if (i != 0) {
                this.D.setImageResource(i);
                return;
            }
            Drawable drawable = this.C;
            if (drawable != null) {
                this.D.setImageDrawable(drawable);
                return;
            } else {
                this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                this.D.setVisibility(8);
                return;
            }
        }
        View titleTemplate2 = this.c.findViewById(R.id.title_template);
        titleTemplate2.setVisibility(8);
        this.D.setVisibility(8);
        topPanel.setVisibility(8);
    }

    public final void o(ViewGroup contentPanel) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.c.findViewById(R.id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) contentPanel.findViewById(android.R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.g != null) {
            ViewGroup scrollParent = (ViewGroup) this.A.getParent();
            int childIndex = scrollParent.indexOfChild(this.A);
            scrollParent.removeViewAt(childIndex);
            scrollParent.addView(this.g, childIndex, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        contentPanel.setVisibility(8);
    }

    public static void e(View v, View upIndicator, View downIndicator) {
        if (upIndicator != null) {
            upIndicator.setVisibility(v.canScrollVertically(-1) ? 0 : 4);
        }
        if (downIndicator != null) {
            downIndicator.setVisibility(v.canScrollVertically(1) ? 0 : 4);
        }
    }

    public final void n(ViewGroup buttonPanel) {
        int whichButtons = 0;
        Button button = (Button) buttonPanel.findViewById(android.R.id.button1);
        this.o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.o.setVisibility(8);
        } else {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i = this.d;
                drawable.setBounds(0, 0, i, i);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            whichButtons = 0 | 1;
        }
        Button button2 = (Button) buttonPanel.findViewById(android.R.id.button2);
        this.s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i2 = this.d;
                drawable2.setBounds(0, 0, i2, i2);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            whichButtons |= 2;
        }
        Button button3 = (Button) buttonPanel.findViewById(android.R.id.button3);
        this.w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.z;
            if (drawable3 != null) {
                int i3 = this.d;
                drawable3.setBounds(0, 0, i3, i3);
                this.w.setCompoundDrawables(this.z, null, null, null);
            }
            this.w.setVisibility(0);
            whichButtons |= 4;
        }
        if (s(this.f783a)) {
            if (whichButtons == 1) {
                b(this.o);
            } else if (whichButtons == 2) {
                b(this.s);
            } else if (whichButtons == 4) {
                b(this.w);
            }
        }
        boolean hasButtons = whichButtons != 0;
        if (!hasButtons) {
            buttonPanel.setVisibility(8);
        }
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        params.gravity = 1;
        params.weight = 0.5f;
        button.setLayoutParams(params);
    }

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: b, reason: collision with root package name */
        public final int f785b;
        public final int c;

        public RecycleListView(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray ta = context.obtainStyledAttributes(attrs, a.b.a.s);
            int[] iArr = a.b.a.f11a;
            this.c = ta.getDimensionPixelOffset(0, -1);
            this.f785b = ta.getDimensionPixelOffset(1, -1);
        }

        public void a(boolean hasTitle, boolean hasButtons) {
            if (!hasButtons || !hasTitle) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = hasTitle ? getPaddingTop() : this.f785b;
                int paddingRight = getPaddingRight();
                int paddingBottom = hasButtons ? getPaddingBottom() : this.c;
                setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final Context f793a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f794b;
        public Drawable d;
        public CharSequence f;
        public View g;
        public DialogInterface.OnKeyListener i;
        public ListAdapter j;
        public DialogInterface.OnClickListener k;
        public boolean m;
        public int c = 0;
        public int e = 0;
        public boolean l = false;
        public int n = -1;
        public boolean h = true;

        public f(Context context) {
            this.f793a = context;
            this.f794b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController dialog) {
            View view = this.g;
            if (view != null) {
                dialog.j(view);
            } else {
                CharSequence charSequence = this.f;
                if (charSequence != null) {
                    dialog.m(charSequence);
                }
                Drawable drawable = this.d;
                if (drawable != null) {
                    dialog.k(drawable);
                }
            }
            if (this.j != null) {
                b(dialog);
            }
        }

        public final void b(AlertController dialog) {
            int layout;
            ListAdapter adapter;
            RecycleListView listView = (RecycleListView) this.f794b.inflate(dialog.L, (ViewGroup) null);
            if (this.m) {
                layout = dialog.N;
            } else {
                layout = dialog.O;
            }
            if (this.j != null) {
                adapter = this.j;
            } else {
                adapter = new h(this.f793a, layout, android.R.id.text1, null);
            }
            dialog.H = adapter;
            dialog.I = this.n;
            if (this.k != null) {
                listView.setOnItemClickListener(new a(dialog));
            }
            if (this.m) {
                listView.setChoiceMode(1);
            }
            dialog.g = listView;
        }

        /* loaded from: classes.dex */
        public class a implements AdapterView.OnItemClickListener {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AlertController f795b;

            public a(AlertController alertController) {
                this.f795b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                f.this.k.onClick(this.f795b.f784b, position);
                if (!f.this.m) {
                    this.f795b.f784b.dismiss();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int resource, int textViewResourceId, CharSequence[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }
    }
}
