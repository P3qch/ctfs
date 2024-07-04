package a.b.b;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class b extends g implements DialogInterface {
    public final AlertController d;

    public b(Context context, int themeResId) {
        super(context, i(context, themeResId));
        this.d = new AlertController(getContext(), this, getWindow());
    }

    public static int i(Context context, int resid) {
        if (((resid >>> 24) & 255) >= 1) {
            return resid;
        }
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, outValue, true);
        return outValue.resourceId;
    }

    public ListView g() {
        return this.d.c();
    }

    @Override // a.b.b.g, android.app.Dialog
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        this.d.m(title);
    }

    @Override // a.b.b.g, android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.d.d();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.d.f(event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.d.g(event)) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final AlertController.f f14a;

        /* renamed from: b, reason: collision with root package name */
        public final int f15b;

        public a(Context context) {
            this(context, b.i(context, 0));
        }

        public a(Context context, int themeResId) {
            this.f14a = new AlertController.f(new ContextThemeWrapper(context, b.i(context, themeResId)));
            this.f15b = themeResId;
        }

        public Context b() {
            return this.f14a.f793a;
        }

        public a h(CharSequence title) {
            this.f14a.f = title;
            return this;
        }

        public a d(View customTitleView) {
            this.f14a.g = customTitleView;
            return this;
        }

        public a e(Drawable icon) {
            this.f14a.d = icon;
            return this;
        }

        public a f(DialogInterface.OnKeyListener onKeyListener) {
            this.f14a.i = onKeyListener;
            return this;
        }

        public a c(ListAdapter adapter, DialogInterface.OnClickListener listener) {
            AlertController.f fVar = this.f14a;
            fVar.j = adapter;
            fVar.k = listener;
            return this;
        }

        public a g(ListAdapter adapter, int checkedItem, DialogInterface.OnClickListener listener) {
            AlertController.f fVar = this.f14a;
            fVar.j = adapter;
            fVar.k = listener;
            fVar.n = checkedItem;
            fVar.m = true;
            return this;
        }

        public b a() {
            b dialog = new b(this.f14a.f793a, this.f15b);
            this.f14a.a(dialog.d);
            this.f14a.getClass();
            dialog.setCancelable(true);
            this.f14a.getClass();
            dialog.setCanceledOnTouchOutside(true);
            this.f14a.getClass();
            dialog.setOnCancelListener(null);
            this.f14a.getClass();
            dialog.setOnDismissListener(null);
            DialogInterface.OnKeyListener onKeyListener = this.f14a.i;
            if (onKeyListener != null) {
                dialog.setOnKeyListener(onKeyListener);
            }
            return dialog;
        }
    }
}
