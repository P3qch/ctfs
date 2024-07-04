package a.b.f;

import a.b.f.b;
import a.b.f.j.j;
import a.b.f.j.o;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f78a;

    /* renamed from: b, reason: collision with root package name */
    public final b f79b;

    public f(Context context, b supportActionMode) {
        this.f78a = context;
        this.f79b = supportActionMode;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f79b.h();
    }

    @Override // android.view.ActionMode
    public void setTag(Object tag) {
        this.f79b.p(tag);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence title) {
        this.f79b.r(title);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence subtitle) {
        this.f79b.o(subtitle);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f79b.k();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f79b.c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new o(this.f78a, (a.h.e.a.a) this.f79b.e());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f79b.i();
    }

    @Override // android.view.ActionMode
    public void setTitle(int resId) {
        this.f79b.q(resId);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f79b.g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int resId) {
        this.f79b.n(resId);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f79b.d();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f79b.m(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f79b.f();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f79b.j();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean titleOptional) {
        this.f79b.s(titleOptional);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f79b.l();
    }

    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f80a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f81b;
        public final ArrayList<f> c = new ArrayList<>();
        public final a.e.g<Menu, Menu> d = new a.e.g<>();

        public a(Context context, ActionMode.Callback supportCallback) {
            this.f81b = context;
            this.f80a = supportCallback;
        }

        @Override // a.b.f.b.a
        public boolean d(b mode, Menu menu) {
            return this.f80a.onCreateActionMode(e(mode), f(menu));
        }

        @Override // a.b.f.b.a
        public boolean a(b mode, Menu menu) {
            return this.f80a.onPrepareActionMode(e(mode), f(menu));
        }

        @Override // a.b.f.b.a
        public boolean c(b mode, MenuItem item) {
            return this.f80a.onActionItemClicked(e(mode), new j(this.f81b, (a.h.e.a.b) item));
        }

        @Override // a.b.f.b.a
        public void b(b mode) {
            this.f80a.onDestroyActionMode(e(mode));
        }

        public final Menu f(Menu menu) {
            Menu wrapper = this.d.get(menu);
            if (wrapper == null) {
                Menu wrapper2 = new o(this.f81b, (a.h.e.a.a) menu);
                this.d.put(menu, wrapper2);
                return wrapper2;
            }
            return wrapper;
        }

        public ActionMode e(b mode) {
            int count = this.c.size();
            for (int i = 0; i < count; i++) {
                f wrapper = this.c.get(i);
                if (wrapper != null && wrapper.f79b == mode) {
                    return wrapper;
                }
            }
            f wrapper2 = new f(this.f81b, mode);
            this.c.add(wrapper2);
            return wrapper2;
        }
    }
}
