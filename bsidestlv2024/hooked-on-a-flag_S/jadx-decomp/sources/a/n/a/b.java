package a.n.a;

import a.e.h;
import a.m.g;
import a.m.l;
import a.m.m;
import a.m.q;
import a.m.r;
import a.m.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class b extends a.n.a.a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f632a = false;

    /* renamed from: b, reason: collision with root package name */
    public final g f633b;
    public final C0045b c;

    /* loaded from: classes.dex */
    public static class a<D> extends l<D> {
        public g k;

        /* JADX WARN: Generic types in debug info not equals: a.n.a.b$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        @Override // androidx.lifecycle.LiveData
        public void g() {
            a.n.b.a aVar = null;
            aVar.c();
            throw null;
        }

        /* JADX WARN: Generic types in debug info not equals: a.n.a.b$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        @Override // androidx.lifecycle.LiveData
        public void h() {
            a.n.b.a aVar = null;
            aVar.d();
            throw null;
        }

        /* JADX WARN: Generic types in debug info not equals: a.n.a.b$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        public void m() {
            if (0 != 0 && 0 != 0) {
                super.i(null);
                e(null, null);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: a.m.m != androidx.lifecycle.Observer<? super D> */
        /* JADX WARN: Generic types in debug info not equals: a.n.a.b$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void i(m<? super D> mVar) {
            super.i(mVar);
            this.k = null;
        }

        /* JADX WARN: Generic types in debug info not equals: a.n.a.b$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        /* JADX WARN: Incorrect return type in method signature: (Z)La/n/b/a<TD;>; */
        public void k(boolean reset) {
            a.n.b.a aVar = null;
            aVar.a();
            throw null;
        }

        /* JADX WARN: Generic types in debug info not equals: a.n.a.b$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        @Override // a.m.l, androidx.lifecycle.LiveData
        public void j(D value) {
            super.j(value);
        }

        /* JADX WARN: Generic types in debug info not equals: a.n.a.b$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(0);
            sb.append(" : ");
            a.h.j.b.a(null, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* JADX WARN: Generic types in debug info not equals: a.n.a.b$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        public void l(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            writer.print(prefix);
            writer.print("mId=");
            writer.print(0);
            writer.print(" mArgs=");
            a.n.b.a aVar = null;
            writer.println((Object) null);
            writer.print(prefix);
            writer.print("mLoader=");
            writer.println((Object) null);
            aVar.b(prefix + "  ", fd, writer, args);
            throw null;
        }
    }

    /* renamed from: a.n.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0045b extends q {

        /* renamed from: b, reason: collision with root package name */
        public static final r.a f634b = new a();
        public h<a> c = new h<>();

        /* renamed from: a.n.a.b$b$a */
        /* loaded from: classes.dex */
        public static class a implements r.a {
            @Override // a.m.r.a
            public <T extends q> T a(Class<T> modelClass) {
                return new C0045b();
            }
        }

        public static C0045b f(s viewModelStore) {
            return (C0045b) new r(viewModelStore, f634b).a(C0045b.class);
        }

        public void g() {
            int size = this.c.j();
            for (int index = 0; index < size; index++) {
                a info = this.c.k(index);
                info.m();
            }
        }

        @Override // a.m.q
        public void d() {
            super.d();
            int size = this.c.j();
            if (0 < size) {
                a info = this.c.k(0);
                info.k(true);
                throw null;
            }
            this.c.b();
        }

        public void e(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            if (this.c.j() > 0) {
                writer.print(prefix);
                writer.println("Loaders:");
                String str = prefix + "    ";
                if (0 < this.c.j()) {
                    a info = this.c.k(0);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(this.c.h(0));
                    writer.print(": ");
                    writer.println(info.toString());
                    info.l(str, fd, writer, args);
                    throw null;
                }
            }
        }
    }

    public b(g lifecycleOwner, s viewModelStore) {
        this.f633b = lifecycleOwner;
        this.c = C0045b.f(viewModelStore);
    }

    @Override // a.n.a.a
    public void c() {
        this.c.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        a.h.j.b.a(this.f633b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // a.n.a.a
    @Deprecated
    public void a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        this.c.e(prefix, fd, writer, args);
    }
}
