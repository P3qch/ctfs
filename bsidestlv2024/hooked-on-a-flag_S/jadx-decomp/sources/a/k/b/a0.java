package a.k.b;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public final class a0 extends Writer {

    /* renamed from: b, reason: collision with root package name */
    public final String f514b;
    public StringBuilder c = new StringBuilder(128);

    public a0(String tag) {
        this.f514b = tag;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] buf, int offset, int count) {
        for (int i = 0; i < count; i++) {
            char c = buf[offset + i];
            if (c == '\n') {
                a();
            } else {
                this.c.append(c);
            }
        }
    }

    public final void a() {
        if (this.c.length() > 0) {
            Log.d(this.f514b, this.c.toString());
            StringBuilder sb = this.c;
            sb.delete(0, sb.length());
        }
    }
}
