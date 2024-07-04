package com.example.addflag;

/* loaded from: classes.dex */
public class utility {

    /* renamed from: a, reason: collision with root package name */
    public static utility f1130a = null;

    public native int decrypt(byte[] bArr, int i, String str, String str2, byte[] bArr2, byte[] bArr3);

    public native int encrypt(String str, int i, String str2, String str3, byte[] bArr, byte[] bArr2);

    static {
        System.loadLibrary("Utility");
    }

    public static synchronized utility a() {
        utility utility;
        synchronized (utility.class) {
            synchronized (utility.class) {
                if (f1130a == null) {
                    f1130a = new utility();
                }
                utility = f1130a;
            }
            return utility;
        }
        return utility;
    }
}
