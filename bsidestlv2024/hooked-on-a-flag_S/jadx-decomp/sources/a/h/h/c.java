package a.h.h;

import a.h.h.f;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator<byte[]> f386a = new a();

    public static f.a d(Context context, d request, CancellationSignal cancellationSignal) {
        ProviderInfo providerInfo = e(context.getPackageManager(), request, context.getResources());
        if (providerInfo == null) {
            return f.a.a(1, null);
        }
        f.b[] fonts = f(context, request, providerInfo.authority, cancellationSignal);
        return f.a.a(0, fonts);
    }

    public static ProviderInfo e(PackageManager packageManager, d request, Resources resources) {
        String providerAuthority = request.e();
        ProviderInfo info = packageManager.resolveContentProvider(providerAuthority, 0);
        if (info == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        }
        if (!info.packageName.equals(request.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + request.f());
        }
        PackageInfo packageInfo = packageManager.getPackageInfo(info.packageName, 64);
        List<byte[]> signatures = a(packageInfo.signatures);
        Collections.sort(signatures, f386a);
        List<List<byte[]>> requestCertificatesList = c(request, resources);
        for (int i = 0; i < requestCertificatesList.size(); i++) {
            List<byte[]> requestSignatures = new ArrayList<>(requestCertificatesList.get(i));
            Collections.sort(requestSignatures, f386a);
            if (b(signatures, requestSignatures)) {
                return info;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a.h.h.f.b[] f(android.content.Context r20, a.h.h.d r21, java.lang.String r22, android.os.CancellationSignal r23) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.h.h.c.f(android.content.Context, a.h.h.d, java.lang.String, android.os.CancellationSignal):a.h.h.f$b[]");
    }

    public static List<List<byte[]>> c(d request, Resources resources) {
        if (request.b() != null) {
            return request.b();
        }
        request.c();
        return a.h.c.c.c.c(resources, 0);
    }

    /* loaded from: classes.dex */
    public class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] l, byte[] r) {
            if (l.length != r.length) {
                return l.length - r.length;
            }
            for (int i = 0; i < l.length; i++) {
                if (l[i] != r[i]) {
                    return l[i] - r[i];
                }
            }
            return 0;
        }
    }

    public static boolean b(List<byte[]> signatures, List<byte[]> requestSignatures) {
        if (signatures.size() != requestSignatures.size()) {
            return false;
        }
        for (int i = 0; i < signatures.size(); i++) {
            if (!Arrays.equals(signatures.get(i), requestSignatures.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<byte[]> a(Signature[] signatures) {
        List<byte[]> shaList = new ArrayList<>();
        for (Signature signature : signatures) {
            shaList.add(signature.toByteArray());
        }
        return shaList;
    }
}
