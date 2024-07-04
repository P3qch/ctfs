package a.n.a;

import a.m.g;
import a.m.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class a {
    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();

    public static <T extends g & t> a b(T owner) {
        return new b(owner, owner.e());
    }
}
