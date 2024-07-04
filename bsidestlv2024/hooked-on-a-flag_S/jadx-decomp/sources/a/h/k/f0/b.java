package a.h.k.f0;

import a.b.g.u;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class b {

    /* loaded from: classes.dex */
    public interface c {
    }

    public static boolean b(String action, Bundle data, c onCommitContentListener) {
        boolean interop;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (data == null) {
            return false;
        }
        if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", action)) {
            interop = false;
        } else {
            if (!TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", action)) {
                return false;
            }
            interop = true;
        }
        ResultReceiver resultReceiver = null;
        boolean result = false;
        if (interop) {
            str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
        } else {
            str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
        }
        try {
            resultReceiver = (ResultReceiver) data.getParcelable(str);
            if (interop) {
                str2 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
            } else {
                str2 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
            }
            Uri contentUri = (Uri) data.getParcelable(str2);
            if (interop) {
                str3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
            } else {
                str3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
            }
            ClipDescription description = (ClipDescription) data.getParcelable(str3);
            if (interop) {
                str4 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
            } else {
                str4 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
            }
            Uri linkUri = (Uri) data.getParcelable(str4);
            if (interop) {
                str5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
            } else {
                str5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
            }
            int flags = data.getInt(str5);
            if (interop) {
                str6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
            } else {
                str6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
            }
            Bundle opts = (Bundle) data.getParcelable(str6);
            if (contentUri != null && description != null) {
                a.h.k.f0.c inputContentInfo = new a.h.k.f0.c(contentUri, description, linkUri);
                result = ((u.a) onCommitContentListener).a(inputContentInfo, flags, opts);
            }
            if (resultReceiver != null) {
                resultReceiver.send(result ? 1 : 0, null);
            }
            return result;
        } catch (Throwable th) {
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            }
            throw th;
        }
    }

    public static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo, c onCommitContentListener) {
        if (inputConnection == null) {
            throw new IllegalArgumentException("inputConnection must be non-null");
        }
        if (editorInfo == null) {
            throw new IllegalArgumentException("editorInfo must be non-null");
        }
        if (onCommitContentListener == null) {
            throw new IllegalArgumentException("onCommitContentListener must be non-null");
        }
        if (Build.VERSION.SDK_INT >= 25) {
            return new a(inputConnection, false, onCommitContentListener);
        }
        String[] contentMimeTypes = a.h.k.f0.a.a(editorInfo);
        if (contentMimeTypes.length == 0) {
            return inputConnection;
        }
        return new C0033b(inputConnection, false, onCommitContentListener);
    }

    /* loaded from: classes.dex */
    public class a extends InputConnectionWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f462a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InputConnection target, boolean mutable, c cVar) {
            super(target, mutable);
            this.f462a = cVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int flags, Bundle opts) {
            if (((u.a) this.f462a).a(a.h.k.f0.c.f(inputContentInfo), flags, opts)) {
                return true;
            }
            return super.commitContent(inputContentInfo, flags, opts);
        }
    }

    /* renamed from: a.h.k.f0.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0033b extends InputConnectionWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f463a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0033b(InputConnection target, boolean mutable, c cVar) {
            super(target, mutable);
            this.f463a = cVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String action, Bundle data) {
            if (b.b(action, data, this.f463a)) {
                return true;
            }
            return super.performPrivateCommand(action, data);
        }
    }
}
