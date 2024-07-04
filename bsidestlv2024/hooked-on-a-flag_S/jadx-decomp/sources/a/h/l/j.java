package a.h.l;

import a.h.k.r;
import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class j implements r {
    @Override // a.h.k.r
    public a.h.k.c a(View view, a.h.k.c payload) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + payload);
        }
        int source = payload.d();
        if (source == 2) {
            return payload;
        }
        if (source == 3) {
            d((TextView) view, payload);
            return null;
        }
        ClipData clip = payload.b();
        int flags = payload.c();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean didFirst = false;
        for (int i = 0; i < clip.getItemCount(); i++) {
            CharSequence itemText = c(context, clip.getItemAt(i), flags);
            if (itemText != null) {
                if (!didFirst) {
                    e(editable, itemText);
                    didFirst = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), itemText);
                }
            }
        }
        return null;
    }

    public static void d(TextView view, a.h.k.c payload) {
        CharSequence text = b(payload.b(), view.getContext(), payload.c());
        e((Editable) view.getText(), text);
    }

    public static CharSequence b(ClipData clip, Context context, int flags) {
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        for (int i = 0; i < clip.getItemCount(); i++) {
            CharSequence itemText = c(context, clip.getItemAt(i), flags);
            if (itemText != null) {
                ssb.append(itemText);
            }
        }
        return ssb;
    }

    public static CharSequence c(Context context, ClipData.Item item, int flags) {
        return a.a(context, item, flags);
    }

    public static void e(Editable editable, CharSequence replacement) {
        int selStart = Selection.getSelectionStart(editable);
        int selEnd = Selection.getSelectionEnd(editable);
        int start = Math.max(0, Math.min(selStart, selEnd));
        int end = Math.max(0, Math.max(selStart, selEnd));
        Selection.setSelection(editable, end);
        editable.replace(start, end, replacement);
    }

    /* loaded from: classes.dex */
    public static final class a {
        public static CharSequence a(Context context, ClipData.Item item, int flags) {
            if ((flags & 1) != 0) {
                CharSequence text = item.coerceToText(context);
                return text instanceof Spanned ? text.toString() : text;
            }
            return item.coerceToStyledText(context);
        }
    }
}
