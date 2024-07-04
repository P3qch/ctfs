package a.h.k.f0;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0034c f464a;

    /* renamed from: a.h.k.f0.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0034c {
        ClipDescription a();

        void b();

        Uri c();

        Object d();

        Uri e();
    }

    /* loaded from: classes.dex */
    public static final class b implements InterfaceC0034c {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f466a;

        /* renamed from: b, reason: collision with root package name */
        public final ClipDescription f467b;
        public final Uri c;

        public b(Uri contentUri, ClipDescription description, Uri linkUri) {
            this.f466a = contentUri;
            this.f467b = description;
            this.c = linkUri;
        }

        @Override // a.h.k.f0.c.InterfaceC0034c
        public Uri e() {
            return this.f466a;
        }

        @Override // a.h.k.f0.c.InterfaceC0034c
        public ClipDescription a() {
            return this.f467b;
        }

        @Override // a.h.k.f0.c.InterfaceC0034c
        public Uri c() {
            return this.c;
        }

        @Override // a.h.k.f0.c.InterfaceC0034c
        public Object d() {
            return null;
        }

        @Override // a.h.k.f0.c.InterfaceC0034c
        public void b() {
        }
    }

    /* loaded from: classes.dex */
    public static final class a implements InterfaceC0034c {

        /* renamed from: a, reason: collision with root package name */
        public final InputContentInfo f465a;

        public a(Object inputContentInfo) {
            this.f465a = (InputContentInfo) inputContentInfo;
        }

        public a(Uri contentUri, ClipDescription description, Uri linkUri) {
            this.f465a = new InputContentInfo(contentUri, description, linkUri);
        }

        @Override // a.h.k.f0.c.InterfaceC0034c
        public Uri e() {
            return this.f465a.getContentUri();
        }

        @Override // a.h.k.f0.c.InterfaceC0034c
        public ClipDescription a() {
            return this.f465a.getDescription();
        }

        @Override // a.h.k.f0.c.InterfaceC0034c
        public Uri c() {
            return this.f465a.getLinkUri();
        }

        @Override // a.h.k.f0.c.InterfaceC0034c
        public Object d() {
            return this.f465a;
        }

        @Override // a.h.k.f0.c.InterfaceC0034c
        public void b() {
            this.f465a.requestPermission();
        }
    }

    public c(Uri contentUri, ClipDescription description, Uri linkUri) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f464a = new a(contentUri, description, linkUri);
        } else {
            this.f464a = new b(contentUri, description, linkUri);
        }
    }

    public c(InterfaceC0034c impl) {
        this.f464a = impl;
    }

    public Uri a() {
        return this.f464a.e();
    }

    public ClipDescription b() {
        return this.f464a.a();
    }

    public Uri c() {
        return this.f464a.c();
    }

    public static c f(Object inputContentInfo) {
        if (inputContentInfo == null || Build.VERSION.SDK_INT < 25) {
            return null;
        }
        return new c(new a(inputContentInfo));
    }

    public Object e() {
        return this.f464a.d();
    }

    public void d() {
        this.f464a.b();
    }
}
