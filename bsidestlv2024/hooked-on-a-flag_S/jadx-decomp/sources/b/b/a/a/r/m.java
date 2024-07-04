package b.b.a.a.r;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class m extends ImageButton {

    /* renamed from: b, reason: collision with root package name */
    public int f1081b;

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int visibility) {
        b(visibility, true);
    }

    public final void b(int visibility, boolean fromUser) {
        super.setVisibility(visibility);
        if (fromUser) {
            this.f1081b = visibility;
        }
    }

    public final int getUserSetVisibility() {
        return this.f1081b;
    }
}
