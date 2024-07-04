package b.b.a.a.c0;

import android.text.InputFilter;
import android.text.Spanned;
import net.sqlcipher.BuildConfig;

/* loaded from: classes.dex */
public class a implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public int f999a;

    public a(int max) {
        this.f999a = max;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            StringBuilder builder = new StringBuilder(dest);
            builder.replace(dstart, dend, source.subSequence(start, end).toString());
            String newVal = builder.toString();
            int input = Integer.parseInt(newVal);
            if (input <= this.f999a) {
                return null;
            }
            return BuildConfig.FLAVOR;
        } catch (NumberFormatException e) {
            return BuildConfig.FLAVOR;
        }
    }
}
