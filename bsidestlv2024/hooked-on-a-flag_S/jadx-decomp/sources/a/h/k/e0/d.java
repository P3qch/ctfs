package a.h.k.e0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f457a;

    /* loaded from: classes.dex */
    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        public final d f458a;

        public a(d compat) {
            this.f458a = compat;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            a.h.k.e0.c compatInfo = this.f458a.b(virtualViewId);
            if (compatInfo == null) {
                return null;
            }
            return compatInfo.u0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text, int virtualViewId) {
            this.f458a.c();
            List<AccessibilityNodeInfoCompat> compatInfos = null;
            if (0 == 0) {
                return null;
            }
            List<AccessibilityNodeInfo> infoList = new ArrayList<>();
            int infoCount = compatInfos.size();
            for (int i = 0; i < infoCount; i++) {
                a.h.k.e0.c infoCompat = (a.h.k.e0.c) compatInfos.get(i);
                infoList.add(infoCompat.u0());
            }
            return infoList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return this.f458a.f(virtualViewId, action, arguments);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public b(d compat) {
            super(compat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int focus) {
            a.h.k.e0.c compatInfo = this.f458a.d(focus);
            if (compatInfo == null) {
                return null;
            }
            return compatInfo.u0();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public c(d compat) {
            super(compat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
            d dVar = this.f458a;
            a.h.k.e0.c.v0(info);
            dVar.a();
        }
    }

    public d() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f457a = new c(this);
        } else if (i >= 19) {
            this.f457a = new b(this);
        } else {
            this.f457a = new a(this);
        }
    }

    public d(Object provider) {
        this.f457a = provider;
    }

    public Object e() {
        return this.f457a;
    }

    public a.h.k.e0.c b(int virtualViewId) {
        return null;
    }

    public boolean f(int virtualViewId, int action, Bundle arguments) {
        return false;
    }

    public List c() {
        return null;
    }

    public a.h.k.e0.c d(int focus) {
        return null;
    }

    public void a() {
    }
}
