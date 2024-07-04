package a.h.h;

import a.h.j.i;
import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f387a;

    /* renamed from: b, reason: collision with root package name */
    public final String f388b;
    public final String c;
    public final List<List<byte[]>> d;
    public final int e;
    public final String f;

    public d(String providerAuthority, String providerPackage, String query, List<List<byte[]>> certificates) {
        i.e(providerAuthority);
        this.f387a = providerAuthority;
        i.e(providerPackage);
        this.f388b = providerPackage;
        i.e(query);
        this.c = query;
        i.e(certificates);
        this.d = certificates;
        this.e = 0;
        this.f = a(providerAuthority, providerPackage, query);
    }

    public final String a(String providerAuthority, String providerPackage, String query) {
        return providerAuthority + "-" + providerPackage + "-" + query;
    }

    public String e() {
        return this.f387a;
    }

    public String f() {
        return this.f388b;
    }

    public String g() {
        return this.c;
    }

    public List<List<byte[]>> b() {
        return this.d;
    }

    public int c() {
        return 0;
    }

    public String d() {
        return this.f;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FontRequest {mProviderAuthority: " + this.f387a + ", mProviderPackage: " + this.f388b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.d.size(); i++) {
            builder.append(" [");
            List<byte[]> set = this.d.get(i);
            for (int j = 0; j < set.size(); j++) {
                builder.append(" \"");
                byte[] array = set.get(j);
                builder.append(Base64.encodeToString(array, 0));
                builder.append("\"");
            }
            builder.append(" ]");
        }
        builder.append("}");
        builder.append("mCertificatesArray: 0");
        return builder.toString();
    }
}
