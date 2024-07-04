package a.h.k.e0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: b, reason: collision with root package name */
    public final int f450b;
    public final c c;
    public final int d;

    public a(int originalClickableSpanId, c nodeInfoCompat, int clickableSpanActionId) {
        this.f450b = originalClickableSpanId;
        this.c = nodeInfoCompat;
        this.d = clickableSpanActionId;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View unused) {
        Bundle arguments = new Bundle();
        arguments.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f450b);
        this.c.N(this.d, arguments);
    }
}
