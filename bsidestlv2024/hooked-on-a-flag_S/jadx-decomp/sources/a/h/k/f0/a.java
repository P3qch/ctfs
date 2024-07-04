package a.h.k.f0;

import a.h.j.i;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f461a = new String[0];

    public static void d(EditorInfo editorInfo, String[] contentMimeTypes) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = contentMimeTypes;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", contentMimeTypes);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", contentMimeTypes);
    }

    public static String[] a(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] result = editorInfo.contentMimeTypes;
            return result != null ? result : f461a;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return f461a;
        }
        String[] result2 = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (result2 == null) {
            result2 = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        }
        return result2 != null ? result2 : f461a;
    }

    public static void f(EditorInfo editorInfo, CharSequence sourceText) {
        if (Build.VERSION.SDK_INT >= 30) {
            C0032a.a(editorInfo, sourceText, 0);
        } else {
            e(editorInfo, sourceText, 0);
        }
    }

    public static void e(EditorInfo editorInfo, CharSequence subText, int subTextStart) {
        int subTextSelStart;
        int subTextSelEnd;
        i.e(subText);
        if (Build.VERSION.SDK_INT >= 30) {
            C0032a.a(editorInfo, subText, subTextStart);
            return;
        }
        int i = editorInfo.initialSelStart;
        int i2 = editorInfo.initialSelEnd;
        if (i > i2) {
            subTextSelStart = i2 - subTextStart;
        } else {
            subTextSelStart = i - subTextStart;
        }
        if (i > i2) {
            subTextSelEnd = i - subTextStart;
        } else {
            subTextSelEnd = i2 - subTextStart;
        }
        int subTextLength = subText.length();
        if (subTextStart < 0 || subTextSelStart < 0 || subTextSelEnd > subTextLength) {
            g(editorInfo, null, 0, 0);
            return;
        }
        if (c(editorInfo.inputType)) {
            g(editorInfo, null, 0, 0);
        } else if (subTextLength <= 2048) {
            g(editorInfo, subText, subTextSelStart, subTextSelEnd);
        } else {
            h(editorInfo, subText, subTextSelStart, subTextSelEnd);
        }
    }

    public static void h(EditorInfo editorInfo, CharSequence subText, int selStart, int selEnd) {
        CharSequence newInitialSurroundingText;
        int sourceSelLength = selEnd - selStart;
        int newSelLength = sourceSelLength > 1024 ? 0 : sourceSelLength;
        int subTextAfterCursorLength = subText.length() - selEnd;
        int maxLengthMinusSelection = 2048 - newSelLength;
        double d = maxLengthMinusSelection;
        Double.isNaN(d);
        int possibleMaxBeforeCursorLength = Math.min(selStart, (int) (d * 0.8d));
        int newAfterCursorLength = Math.min(subTextAfterCursorLength, maxLengthMinusSelection - possibleMaxBeforeCursorLength);
        int newBeforeCursorLength = Math.min(selStart, maxLengthMinusSelection - newAfterCursorLength);
        int newBeforeCursorHead = selStart - newBeforeCursorLength;
        if (b(subText, selStart - newBeforeCursorLength, 0)) {
            newBeforeCursorHead++;
            newBeforeCursorLength--;
        }
        if (b(subText, (selEnd + newAfterCursorLength) - 1, 1)) {
            newAfterCursorLength--;
        }
        int newTextLength = newBeforeCursorLength + newSelLength + newAfterCursorLength;
        if (newSelLength != sourceSelLength) {
            CharSequence beforeCursor = subText.subSequence(newBeforeCursorHead, newBeforeCursorHead + newBeforeCursorLength);
            CharSequence afterCursor = subText.subSequence(selEnd, selEnd + newAfterCursorLength);
            newInitialSurroundingText = TextUtils.concat(beforeCursor, afterCursor);
        } else {
            newInitialSurroundingText = subText.subSequence(newBeforeCursorHead, newBeforeCursorHead + newTextLength);
        }
        int newSelHead = 0 + newBeforeCursorLength;
        g(editorInfo, newInitialSurroundingText, newSelHead, newSelHead + newSelLength);
    }

    public static boolean b(CharSequence sourceText, int cutPosition, int policy) {
        switch (policy) {
            case 0:
                return Character.isLowSurrogate(sourceText.charAt(cutPosition));
            case 1:
                return Character.isHighSurrogate(sourceText.charAt(cutPosition));
            default:
                return false;
        }
    }

    public static boolean c(int inputType) {
        int variation = inputType & 4095;
        return variation == 129 || variation == 225 || variation == 18;
    }

    public static void g(EditorInfo editorInfo, CharSequence surroundingText, int selectionHead, int selectionEnd) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        CharSequence surroundingTextCopy = surroundingText != null ? new SpannableStringBuilder(surroundingText) : null;
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", surroundingTextCopy);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", selectionHead);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", selectionEnd);
    }

    /* renamed from: a.h.k.f0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0032a {
        public static void a(EditorInfo editorInfo, CharSequence sourceText, int subTextStart) {
            editorInfo.setInitialSurroundingSubText(sourceText, subTextStart);
        }
    }
}
