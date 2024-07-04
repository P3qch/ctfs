package a.b.g;

import a.h.k.f0.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class k extends EditText implements a.h.k.u, a.h.k.s {

    /* renamed from: b, reason: collision with root package name */
    public final e f163b;
    public final z c;
    public final y d;
    public final a.h.l.j e;

    public k(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.editTextStyle);
    }

    public k(Context context, AttributeSet attrs, int defStyleAttr) {
        super(u0.b(context), attrs, defStyleAttr);
        s0.a(this, getContext());
        e eVar = new e(this);
        this.f163b = eVar;
        eVar.e(attrs, defStyleAttr);
        z zVar = new z(this);
        this.c = zVar;
        zVar.m(attrs, defStyleAttr);
        zVar.b();
        this.d = new y(this);
        this.e = new a.h.l.j();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        e eVar = this.f163b;
        if (eVar != null) {
            eVar.g(resId);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        e eVar = this.f163b;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintList(ColorStateList tint) {
        e eVar = this.f163b;
        if (eVar != null) {
            eVar.i(tint);
        }
    }

    @Override // a.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f163b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // a.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode tintMode) {
        e eVar = this.f163b;
        if (eVar != null) {
            eVar.j(tintMode);
        }
    }

    @Override // a.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f163b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f163b;
        if (eVar != null) {
            eVar.b();
        }
        z zVar = this.c;
        if (zVar != null) {
            zVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        z zVar = this.c;
        if (zVar != null) {
            zVar.q(context, resId);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection ic = super.onCreateInputConnection(outAttrs);
        this.c.r(this, ic, outAttrs);
        InputConnection ic2 = l.a(ic, outAttrs, this);
        String[] mimeTypes = a.h.k.v.F(this);
        if (ic2 != null && mimeTypes != null) {
            a.h.k.f0.a.d(outAttrs, mimeTypes);
            b.c onCommitContentListener = u.a(this);
            return a.h.k.f0.b.a(ic2, outAttrs, onCommitContentListener);
        }
        return ic2;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        super.setCustomSelectionActionModeCallback(a.h.l.i.p(this, actionModeCallback));
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        y yVar;
        if (Build.VERSION.SDK_INT >= 28 || (yVar = this.d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            yVar.b(textClassifier);
        }
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        y yVar;
        if (Build.VERSION.SDK_INT >= 28 || (yVar = this.d) == null) {
            return super.getTextClassifier();
        }
        return yVar.a();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent event) {
        if (u.b(this, event)) {
            return true;
        }
        return super.onDragEvent(event);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int id) {
        if (u.c(this, id)) {
            return true;
        }
        return super.onTextContextMenuItem(id);
    }

    @Override // a.h.k.s
    public a.h.k.c a(a.h.k.c payload) {
        return this.e.a(this, payload);
    }
}
