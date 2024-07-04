package a.a.e.f;

import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b extends a<String[], Map<String, Boolean>> {
    @Override // a.a.e.f.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map<String, Boolean> a(int resultCode, Intent intent) {
        if (resultCode == -1 && intent != null) {
            String[] permissions = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] grantResults = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (grantResults == null || permissions == null) {
                return Collections.emptyMap();
            }
            Map<String, Boolean> result = new HashMap<>();
            int size = permissions.length;
            for (int i = 0; i < size; i++) {
                result.put(permissions[i], Boolean.valueOf(grantResults[i] == 0));
            }
            return result;
        }
        return Collections.emptyMap();
    }
}
