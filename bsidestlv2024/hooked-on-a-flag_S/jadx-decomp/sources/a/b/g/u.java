package a.b.g;

import a.h.k.c;
import a.h.k.f0.b;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class u {
    public static boolean c(TextView view, int menuItemId) {
        if ((menuItemId != 16908322 && menuItemId != 16908337) || a.h.k.v.F(view) == null) {
            return false;
        }
        ClipboardManager cm = (ClipboardManager) view.getContext().getSystemService("clipboard");
        ClipData clip = cm == null ? null : cm.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            c.a aVar = new c.a(clip, 1);
            aVar.c(menuItemId != 16908322 ? 1 : 0);
            a.h.k.c payload = aVar.a();
            a.h.k.v.e0(view, payload);
        }
        return true;
    }

    public static boolean b(View view, DragEvent event) {
        if (Build.VERSION.SDK_INT < 24 || event.getLocalState() != null || a.h.k.v.F(view) == null) {
            return false;
        }
        Activity activity = d(view);
        if (activity == null) {
            Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
            return false;
        }
        if (event.getAction() == 1) {
            return !(view instanceof TextView);
        }
        if (event.getAction() != 3) {
            return false;
        }
        if (view instanceof TextView) {
            b.a(event, (TextView) view, activity);
        } else {
            b.b(event, view, activity);
        }
        return true;
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static boolean a(DragEvent event, TextView view, Activity activity) {
            activity.requestDragAndDropPermissions(event);
            int offset = view.getOffsetForPosition(event.getX(), event.getY());
            view.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) view.getText(), offset);
                a.h.k.c payload = new c.a(event.getClipData(), 3).a();
                a.h.k.v.e0(view, payload);
                view.endBatchEdit();
                return true;
            } catch (Throwable th) {
                view.endBatchEdit();
                throw th;
            }
        }

        public static boolean b(DragEvent event, View view, Activity activity) {
            activity.requestDragAndDropPermissions(event);
            a.h.k.c payload = new c.a(event.getClipData(), 3).a();
            a.h.k.v.e0(view, payload);
            return true;
        }
    }

    public static Activity d(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f194a;

        public a(View view) {
            this.f194a = view;
        }

        public boolean a(a.h.k.f0.c inputContentInfo, int flags, Bundle opts) {
            Bundle extras = opts;
            if (Build.VERSION.SDK_INT >= 25 && (flags & 1) != 0) {
                try {
                    inputContentInfo.d();
                    InputContentInfo inputContentInfoFmk = (InputContentInfo) inputContentInfo.e();
                    extras = opts == null ? new Bundle() : new Bundle(opts);
                    extras.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfoFmk);
                } catch (Exception e) {
                    Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e);
                    return false;
                }
            }
            ClipData clip = new ClipData(inputContentInfo.b(), new ClipData.Item(inputContentInfo.a()));
            c.a aVar = new c.a(clip, 2);
            aVar.d(inputContentInfo.c());
            aVar.b(extras);
            a.h.k.c payload = aVar.a();
            return a.h.k.v.e0(this.f194a, payload) == null;
        }
    }

    public static b.c a(View view) {
        return new a(view);
    }
}
