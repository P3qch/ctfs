package b.b.a.a.d;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public class a extends FloatingActionButton.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1002a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f1003b;

    public a(BottomAppBar this$0, int i) {
        this.f1003b = this$0;
        this.f1002a = i;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
    public void a(FloatingActionButton fab) {
        float j0;
        j0 = this.f1003b.j0(this.f1002a);
        fab.setTranslationX(j0);
        fab.q(new C0063a());
    }

    /* renamed from: b.b.a.a.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0063a extends FloatingActionButton.b {
        public C0063a() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void b(FloatingActionButton fab) {
            a.this.f1003b.e0();
        }
    }
}
