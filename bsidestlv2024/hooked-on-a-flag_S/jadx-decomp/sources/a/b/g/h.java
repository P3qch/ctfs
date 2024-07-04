package a.b.g;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* loaded from: classes.dex */
public class h extends CheckedTextView {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f152b = {R.attr.checkMark};
    public final z c;

    public h(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.checkedTextViewStyle);
    }

    public h(Context context, AttributeSet attrs, int defStyleAttr) {
        super(u0.b(context), attrs, defStyleAttr);
        s0.a(this, getContext());
        z zVar = new z(this);
        this.c = zVar;
        zVar.m(attrs, defStyleAttr);
        zVar.b();
        x0 a2 = x0.v(getContext(), attrs, f152b, defStyleAttr, 0);
        setCheckMarkDrawable(a2.g(0));
        a2.w();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int resId) {
        setCheckMarkDrawable(a.b.c.a.a.d(getContext(), resId));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        z zVar = this.c;
        if (zVar != null) {
            zVar.q(context, resId);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        z zVar = this.c;
        if (zVar != null) {
            zVar.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(outAttrs);
        l.a(onCreateInputConnection, outAttrs, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        super.setCustomSelectionActionModeCallback(a.h.l.i.p(this, actionModeCallback));
    }
}
