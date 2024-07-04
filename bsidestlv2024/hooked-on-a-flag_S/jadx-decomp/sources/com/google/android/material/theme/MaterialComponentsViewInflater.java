package com.google.android.material.theme;

import a.b.b.h;
import a.b.g.a0;
import a.b.g.d;
import a.b.g.f;
import a.b.g.g;
import a.b.g.s;
import android.content.Context;
import android.util.AttributeSet;
import b.b.a.a.h.a;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends h {
    @Override // a.b.b.h
    public f c(Context context, AttributeSet attrs) {
        return new MaterialButton(context, attrs);
    }

    @Override // a.b.b.h
    public g d(Context context, AttributeSet attrs) {
        return new a(context, attrs);
    }

    @Override // a.b.b.h
    public s j(Context context, AttributeSet attrs) {
        return new b.b.a.a.t.a(context, attrs);
    }

    @Override // a.b.b.h
    public a0 n(Context context, AttributeSet attrs) {
        return new MaterialTextView(context, attrs);
    }

    @Override // a.b.b.h
    public d b(Context context, AttributeSet attrs) {
        return new b.b.a.a.a0.g(context, attrs);
    }
}
