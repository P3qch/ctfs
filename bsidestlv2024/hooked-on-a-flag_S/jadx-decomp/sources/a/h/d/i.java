package a.h.d;

import a.h.c.c.c;
import a.h.h.f;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class i extends j {
    @Override // a.h.d.j
    public f.b h(f.b[] fonts, int style) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // a.h.d.j
    public Typeface d(Context context, InputStream is) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // a.h.d.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] fonts, int style) {
        FontFamily.Builder familyBuilder = null;
        ContentResolver resolver = context.getContentResolver();
        try {
            int length = fonts.length;
            int i = 0;
            while (true) {
                int i2 = 1;
                if (i < length) {
                    f.b font = fonts[i];
                    try {
                        ParcelFileDescriptor pfd = resolver.openFileDescriptor(font.d(), "r", cancellationSignal);
                        if (pfd != null) {
                            try {
                                Font.Builder weight = new Font.Builder(pfd).setWeight(font.e());
                                if (!font.f()) {
                                    i2 = 0;
                                }
                                Font platformFont = weight.setSlant(i2).setTtcIndex(font.c()).build();
                                if (familyBuilder == null) {
                                    familyBuilder = new FontFamily.Builder(platformFont);
                                } else {
                                    familyBuilder.addFont(platformFont);
                                }
                                pfd.close();
                            } catch (Throwable th) {
                                try {
                                    pfd.close();
                                } catch (Throwable th2) {
                                }
                                throw th;
                                break;
                            }
                        } else if (pfd != null) {
                            pfd.close();
                        }
                    } catch (IOException e) {
                    }
                    i++;
                } else {
                    if (familyBuilder == null) {
                        return null;
                    }
                    FontStyle defaultStyle = new FontStyle((style & 1) != 0 ? 700 : 400, (style & 2) != 0 ? 1 : 0);
                    return new Typeface.CustomFallbackBuilder(familyBuilder.build()).setStyle(defaultStyle).build();
                }
            }
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // a.h.d.j
    public Typeface b(Context context, c.b familyEntry, Resources resources, int style) {
        FontFamily.Builder familyBuilder = null;
        try {
            c.C0019c[] a2 = familyEntry.a();
            int length = a2.length;
            int i = 0;
            while (true) {
                int i2 = 1;
                if (i >= length) {
                    break;
                }
                c.C0019c entry = a2[i];
                try {
                    Font.Builder weight = new Font.Builder(resources, entry.b()).setWeight(entry.e());
                    if (!entry.f()) {
                        i2 = 0;
                    }
                    Font platformFont = weight.setSlant(i2).setTtcIndex(entry.c()).setFontVariationSettings(entry.d()).build();
                    if (familyBuilder == null) {
                        familyBuilder = new FontFamily.Builder(platformFont);
                    } else {
                        familyBuilder.addFont(platformFont);
                    }
                } catch (IOException e) {
                }
                i++;
            }
            if (familyBuilder == null) {
                return null;
            }
            FontStyle defaultStyle = new FontStyle((style & 1) != 0 ? 700 : 400, (style & 2) != 0 ? 1 : 0);
            return new Typeface.CustomFallbackBuilder(familyBuilder.build()).setStyle(defaultStyle).build();
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // a.h.d.j
    public Typeface e(Context context, Resources resources, int id, String path, int style) {
        try {
            Font font = new Font.Builder(resources, id).build();
            FontFamily family = new FontFamily.Builder(font).build();
            return new Typeface.CustomFallbackBuilder(family).setStyle(font.getStyle()).build();
        } catch (Exception e) {
            return null;
        }
    }
}
