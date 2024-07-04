package a.b.g;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public TextView f211a;

    /* renamed from: b, reason: collision with root package name */
    public TextClassifier f212b;

    public y(TextView textView) {
        a.h.j.i.e(textView);
        this.f211a = textView;
    }

    public void b(TextClassifier textClassifier) {
        this.f212b = textClassifier;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f212b;
        if (textClassifier == null) {
            TextClassificationManager tcm = (TextClassificationManager) this.f211a.getContext().getSystemService(TextClassificationManager.class);
            if (tcm != null) {
                return tcm.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
        return textClassifier;
    }
}
