package a.b.f;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public int f76a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f77b;
    public LayoutInflater c;
    public Configuration d;
    public Resources e;

    public d() {
        super(null);
    }

    public d(Context base, int themeResId) {
        super(base);
        this.f76a = themeResId;
    }

    public d(Context base, Resources.Theme theme) {
        super(base);
        this.f77b = theme;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    public void a(Configuration overrideConfiguration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.d = new Configuration(overrideConfiguration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    public final Resources b() {
        if (this.e == null) {
            Configuration configuration = this.d;
            if (configuration == null) {
                this.e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                Context resContext = createConfigurationContext(configuration);
                this.e = resContext.getResources();
            } else {
                Resources res = super.getResources();
                Configuration newConfig = new Configuration(res.getConfiguration());
                newConfig.updateFrom(this.d);
                this.e = new Resources(res.getAssets(), res.getDisplayMetrics(), newConfig);
            }
        }
        return this.e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int resid) {
        if (this.f76a != resid) {
            this.f76a = resid;
            d();
        }
    }

    public int c() {
        return this.f76a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f77b;
        if (theme != null) {
            return theme;
        }
        if (this.f76a == 0) {
            this.f76a = R.style.Theme_AppCompat_Light;
        }
        d();
        return this.f77b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        if ("layout_inflater".equals(name)) {
            if (this.c == null) {
                this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.c;
        }
        return getBaseContext().getSystemService(name);
    }

    public void e(Resources.Theme theme, int resid) {
        theme.applyStyle(resid, true);
    }

    public final void d() {
        boolean first = this.f77b == null;
        if (first) {
            this.f77b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f77b.setTo(theme);
            }
        }
        e(this.f77b, this.f76a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
