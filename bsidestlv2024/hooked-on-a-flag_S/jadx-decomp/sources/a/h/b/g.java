package a.h.b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g implements Iterable<Intent> {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<Intent> f348b = new ArrayList<>();
    public final Context c;

    /* loaded from: classes.dex */
    public interface a {
        Intent j();
    }

    public g(Context a2) {
        this.c = a2;
    }

    public static g d(Context context) {
        return new g(context);
    }

    public g a(Intent nextIntent) {
        this.f348b.add(nextIntent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g b(Activity activity) {
        Intent parent = null;
        if (activity instanceof a) {
            parent = ((a) activity).j();
        }
        if (parent == null) {
            parent = e.a(activity);
        }
        if (parent != null) {
            ComponentName target = parent.getComponent();
            if (target == null) {
                target = parent.resolveActivity(this.c.getPackageManager());
            }
            c(target);
            a(parent);
        }
        return this;
    }

    public g c(ComponentName sourceActivityName) {
        int insertAt = this.f348b.size();
        try {
            Intent parent = e.b(this.c, sourceActivityName);
            while (parent != null) {
                this.f348b.add(insertAt, parent);
                parent = e.b(this.c, parent.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f348b.iterator();
    }

    public void e() {
        f(null);
    }

    public void f(Bundle options) {
        if (this.f348b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f348b;
        Intent[] intents = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intents[0] = new Intent(intents[0]).addFlags(268484608);
        a.h.c.a.e(this.c, intents, options);
    }
}
