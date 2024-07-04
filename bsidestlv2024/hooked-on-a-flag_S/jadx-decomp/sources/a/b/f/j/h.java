package a.b.f.j;

import a.b.b.b;
import a.b.f.j.e;
import a.b.f.j.m;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* renamed from: b, reason: collision with root package name */
    public g f109b;
    public a.b.b.b c;
    public e d;

    public h(g menu) {
        this.f109b = menu;
    }

    public void d(IBinder windowToken) {
        g menu = this.f109b;
        b.a builder = new b.a(menu.u());
        e eVar = new e(builder.b(), R.layout.abc_list_menu_item_layout);
        this.d = eVar;
        eVar.d(this);
        this.f109b.b(this.d);
        builder.c(this.d.a(), this);
        View headerView = menu.y();
        if (headerView != null) {
            builder.d(headerView);
        } else {
            builder.e(menu.w());
            builder.h(menu.x());
        }
        builder.f(this);
        a.b.b.b a2 = builder.a();
        this.c = a2;
        a2.setOnDismissListener(this);
        WindowManager.LayoutParams lp = this.c.getWindow().getAttributes();
        lp.type = 1003;
        if (windowToken != null) {
            lp.token = windowToken;
        }
        lp.flags |= 131072;
        this.c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        Window win;
        View decor;
        KeyEvent.DispatcherState ds;
        View decor2;
        KeyEvent.DispatcherState ds2;
        if (keyCode == 82 || keyCode == 4) {
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                Window win2 = this.c.getWindow();
                if (win2 != null && (decor2 = win2.getDecorView()) != null && (ds2 = decor2.getKeyDispatcherState()) != null) {
                    ds2.startTracking(event, this);
                    return true;
                }
            } else if (event.getAction() == 1 && !event.isCanceled() && (win = this.c.getWindow()) != null && (decor = win.getDecorView()) != null && (ds = decor.getKeyDispatcherState()) != null && ds.isTracking(event)) {
                this.f109b.e(true);
                dialog.dismiss();
                return true;
            }
        }
        return this.f109b.performShortcut(keyCode, event, 0);
    }

    public void a() {
        a.b.b.b bVar = this.c;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        this.d.b(this.f109b, true);
    }

    @Override // a.b.f.j.m.a
    public void b(g menu, boolean allMenusAreClosing) {
        if (allMenusAreClosing || menu == this.f109b) {
            a();
        }
    }

    @Override // a.b.f.j.m.a
    public boolean c(g subMenu) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        this.f109b.L((i) ((e.a) this.d.a()).getItem(which), 0);
    }
}
