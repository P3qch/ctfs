package a.b.g;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f186a = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: b, reason: collision with root package name */
    public final ProgressBar f187b;
    public Bitmap c;

    public r(ProgressBar view) {
        this.f187b = view;
    }

    public void c(AttributeSet attrs, int defStyleAttr) {
        x0 a2 = x0.v(this.f187b.getContext(), attrs, f186a, defStyleAttr, 0);
        Drawable drawable = a2.h(0);
        if (drawable != null) {
            this.f187b.setIndeterminateDrawable(e(drawable));
        }
        Drawable drawable2 = a2.h(1);
        if (drawable2 != null) {
            this.f187b.setProgressDrawable(d(drawable2, false));
        }
        a2.w();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable d(Drawable drawable, boolean clip) {
        if (drawable instanceof a.h.d.l.c) {
            Drawable inner = ((a.h.d.l.c) drawable).a();
            if (inner != null) {
                ((a.h.d.l.c) drawable).b(d(inner, clip));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable background = (LayerDrawable) drawable;
                int N = background.getNumberOfLayers();
                Drawable[] outDrawables = new Drawable[N];
                for (int i = 0; i < N; i++) {
                    int id = background.getId(i);
                    outDrawables[i] = d(background.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable newBg = new LayerDrawable(outDrawables);
                for (int i2 = 0; i2 < N; i2++) {
                    newBg.setId(i2, background.getId(i2));
                }
                return newBg;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap tileBitmap = bitmapDrawable.getBitmap();
                if (this.c == null) {
                    this.c = tileBitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(a());
                BitmapShader bitmapShader = new BitmapShader(tileBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
                shapeDrawable.getPaint().setShader(bitmapShader);
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return clip ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public final Drawable e(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable background = (AnimationDrawable) drawable;
            int N = background.getNumberOfFrames();
            AnimationDrawable newBg = new AnimationDrawable();
            newBg.setOneShot(background.isOneShot());
            for (int i = 0; i < N; i++) {
                Drawable frame = d(background.getFrame(i), true);
                frame.setLevel(10000);
                newBg.addFrame(frame, background.getDuration(i));
            }
            newBg.setLevel(10000);
            return newBg;
        }
        return drawable;
    }

    public final Shape a() {
        float[] roundedCorners = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
        return new RoundRectShape(roundedCorners, null, null);
    }

    public Bitmap b() {
        return this.c;
    }
}
