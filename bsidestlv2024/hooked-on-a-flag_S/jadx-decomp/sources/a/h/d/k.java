package a.h.d;

import a.h.h.f;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k {
    public static File e(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String prefix = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, prefix + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static ByteBuffer g(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            try {
                FileChannel channel = fis.getChannel();
                long size = channel.size();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, size);
                fis.close();
                return map;
            } catch (Throwable th) {
                try {
                    fis.close();
                } catch (Throwable th2) {
                }
                throw th;
            }
        } catch (IOException e) {
            return null;
        }
    }

    public static ByteBuffer f(Context context, CancellationSignal cancellationSignal, Uri uri) {
        ContentResolver resolver = context.getContentResolver();
        try {
            ParcelFileDescriptor pfd = resolver.openFileDescriptor(uri, "r", cancellationSignal);
            if (pfd != null) {
                try {
                    FileInputStream fis = new FileInputStream(pfd.getFileDescriptor());
                    try {
                        FileChannel channel = fis.getChannel();
                        long size = channel.size();
                        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, size);
                        fis.close();
                        pfd.close();
                        return map;
                    } catch (Throwable th) {
                        try {
                            fis.close();
                        } catch (Throwable th2) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        pfd.close();
                    } catch (Throwable th4) {
                    }
                    throw th3;
                }
            }
            if (pfd != null) {
                pfd.close();
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public static ByteBuffer b(Context context, Resources res, int id) {
        File tmpFile = e(context);
        if (tmpFile == null) {
            return null;
        }
        try {
            if (!c(tmpFile, res, id)) {
                return null;
            }
            return g(tmpFile);
        } finally {
            tmpFile.delete();
        }
    }

    public static boolean d(File file, InputStream is) {
        FileOutputStream os = null;
        StrictMode.ThreadPolicy old = StrictMode.allowThreadDiskWrites();
        try {
            os = new FileOutputStream(file, false);
            byte[] buffer = new byte[1024];
            while (true) {
                int readLen = is.read(buffer);
                if (readLen == -1) {
                    return true;
                }
                os.write(buffer, 0, readLen);
            }
        } catch (IOException e) {
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            return false;
        } finally {
            a(os);
            StrictMode.setThreadPolicy(old);
        }
    }

    public static boolean c(File file, Resources res, int id) {
        InputStream is = null;
        try {
            is = res.openRawResource(id);
            return d(file, is);
        } finally {
            a(is);
        }
    }

    public static void a(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
            }
        }
    }

    public static Map<Uri, ByteBuffer> h(Context context, f.b[] fonts, CancellationSignal cancellationSignal) {
        HashMap<Uri, ByteBuffer> out = new HashMap<>();
        for (f.b font : fonts) {
            if (font.b() == 0) {
                Uri uri = font.d();
                if (!out.containsKey(uri)) {
                    ByteBuffer buffer = f(context, cancellationSignal, uri);
                    out.put(uri, buffer);
                }
            }
        }
        return Collections.unmodifiableMap(out);
    }
}
