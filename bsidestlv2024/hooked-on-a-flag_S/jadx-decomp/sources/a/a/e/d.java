package a.a.e;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public Random f5a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Integer, String> f6b = new HashMap();
    public final Map<String, Integer> c = new HashMap();
    public final Map<String, c> d = new HashMap();
    public ArrayList<String> e = new ArrayList<>();
    public final transient Map<String, b<?>> f = new HashMap();
    public final Map<String, Object> g = new HashMap();
    public final Bundle h = new Bundle();

    /* JADX WARN: Generic types in debug info not equals: a.a.e.b != androidx.activity.result.ActivityResultCallback<O> */
    /* JADX WARN: Generic types in debug info not equals: a.a.e.f.a != androidx.activity.result.contract.ActivityResultContract<I, O> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> a.a.e.c<I> g(String key, a.a.e.f.a<I, O> aVar, a.a.e.b<O> bVar) {
        int requestCode = h(key);
        this.f.put(key, new b<>(bVar, aVar));
        if (this.g.containsKey(key)) {
            Object obj = this.g.get(key);
            this.g.remove(key);
            bVar.a(obj);
        }
        a.a.e.a pendingResult = (a.a.e.a) this.h.getParcelable(key);
        if (pendingResult != null) {
            this.h.remove(key);
            bVar.a(aVar.a(pendingResult.k(), pendingResult.j()));
        }
        return new a(key, requestCode, aVar);
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* loaded from: classes.dex */
    public class a<I> extends a.a.e.c<I> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7a;

        public a(String str, int i, a.a.e.f.a aVar) {
            this.f7a = str;
        }

        @Override // a.a.e.c
        public void a() {
            d.this.i(this.f7a);
        }
    }

    public final void i(String key) {
        Integer rc;
        if (!this.e.contains(key) && (rc = this.c.remove(key)) != null) {
            this.f6b.remove(rc);
        }
        this.f.remove(key);
        if (this.g.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + this.g.get(key));
            this.g.remove(key);
        }
        if (this.h.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + this.h.getParcelable(key));
            this.h.remove(key);
        }
        c lifecycleContainer = this.d.get(key);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
            throw null;
        }
    }

    public final void f(Bundle outState) {
        outState.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.c.values()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.c.keySet()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.e));
        outState.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.h.clone());
        outState.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f5a);
    }

    public final void e(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        ArrayList<Integer> rcs = savedInstanceState.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> keys = savedInstanceState.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (keys == null || rcs == null) {
            return;
        }
        this.e = savedInstanceState.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f5a = (Random) savedInstanceState.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.h.putAll(savedInstanceState.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if (this.c.containsKey(key)) {
                Integer newRequestCode = this.c.remove(key);
                if (!this.h.containsKey(key)) {
                    this.f6b.remove(newRequestCode);
                }
            }
            Integer newRequestCode2 = rcs.get(i);
            a(newRequestCode2.intValue(), keys.get(i));
        }
    }

    public final boolean b(int requestCode, int resultCode, Intent data) {
        String key = this.f6b.get(Integer.valueOf(requestCode));
        if (key == null) {
            return false;
        }
        this.e.remove(key);
        c(key, resultCode, data, this.f.get(key));
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: a.a.e.b != androidx.activity.result.ActivityResultCallback<O> */
    /* JADX WARN: Generic types in debug info not equals: a.a.e.d$b != androidx.activity.result.ActivityResultRegistry$CallbackAndContract<O> */
    /* JADX WARN: Generic types in debug info not equals: a.a.e.f.a != androidx.activity.result.contract.ActivityResultContract<?, O> */
    public final <O> void c(String key, int resultCode, Intent data, b<O> bVar) {
        if (bVar != null && bVar.f9a != null) {
            ActivityResultCallback<O> callback = bVar.f9a;
            callback.a(bVar.f10b.a(resultCode, data));
        } else {
            this.g.remove(key);
            this.h.putParcelable(key, new a.a.e.a(resultCode, data));
        }
    }

    public final int h(String key) {
        Integer existing = this.c.get(key);
        if (existing != null) {
            return existing.intValue();
        }
        int rc = d();
        a(rc, key);
        return rc;
    }

    public final int d() {
        int number = this.f5a.nextInt(2147418112) + 65536;
        while (this.f6b.containsKey(Integer.valueOf(number))) {
            number = this.f5a.nextInt(2147418112) + 65536;
        }
        return number;
    }

    public final void a(int rc, String key) {
        this.f6b.put(Integer.valueOf(rc), key);
        this.c.put(key, Integer.valueOf(rc));
    }

    /* loaded from: classes.dex */
    public static class b<O> {

        /* renamed from: a, reason: collision with root package name */
        public final a.a.e.b<O> f9a;

        /* renamed from: b, reason: collision with root package name */
        public final a.a.e.f.a<?, O> f10b;

        /* JADX WARN: Generic types in debug info not equals: a.a.e.b != androidx.activity.result.ActivityResultCallback<O> */
        /* JADX WARN: Generic types in debug info not equals: a.a.e.d$b != androidx.activity.result.ActivityResultRegistry$CallbackAndContract<O> */
        /* JADX WARN: Generic types in debug info not equals: a.a.e.f.a != androidx.activity.result.contract.ActivityResultContract<?, O> */
        public b(a.a.e.b<O> bVar, a.a.e.f.a<?, O> aVar) {
            this.f9a = bVar;
            this.f10b = aVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public void a() {
            ArrayList arrayList = null;
            arrayList.iterator();
            throw null;
        }
    }
}
