package a.s;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f732a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f733b;
    public static final boolean c;

    static {
        int i = Build.VERSION.SDK_INT;
        f732a = i >= 19;
        f733b = i >= 18;
        c = i >= 28;
    }

    public static View a(ViewGroup sceneRoot, View view, View parent) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-parent.getScrollX(), -parent.getScrollY());
        y.h(view, matrix);
        y.i(sceneRoot, matrix);
        RectF bounds = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(bounds);
        int left = Math.round(bounds.left);
        int top = Math.round(bounds.top);
        int right = Math.round(bounds.right);
        int bottom = Math.round(bounds.bottom);
        ImageView copy = new ImageView(view.getContext());
        copy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmap = b(view, matrix, bounds, sceneRoot);
        if (bitmap != null) {
            copy.setImageBitmap(bitmap);
        }
        int widthSpec = View.MeasureSpec.makeMeasureSpec(right - left, 1073741824);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(bottom - top, 1073741824);
        copy.measure(widthSpec, heightSpec);
        copy.layout(left, top, right, bottom);
        return copy;
    }

    public static Bitmap b(View view, Matrix matrix, RectF bounds, ViewGroup sceneRoot) {
        boolean addToOverlay;
        boolean sceneRootIsAttached;
        if (f732a) {
            addToOverlay = !view.isAttachedToWindow();
            sceneRootIsAttached = sceneRoot == null ? false : sceneRoot.isAttachedToWindow();
        } else {
            addToOverlay = false;
            sceneRootIsAttached = false;
        }
        ViewGroup parent = null;
        int indexInParent = 0;
        boolean z = f733b;
        if (z && addToOverlay) {
            if (!sceneRootIsAttached) {
                return null;
            }
            parent = (ViewGroup) view.getParent();
            indexInParent = parent.indexOfChild(view);
            sceneRoot.getOverlay().add(view);
        }
        Bitmap bitmap = null;
        int bitmapWidth = Math.round(bounds.width());
        int bitmapHeight = Math.round(bounds.height());
        if (bitmapWidth > 0 && bitmapHeight > 0) {
            float scale = Math.min(1.0f, 1048576.0f / (bitmapWidth * bitmapHeight));
            int bitmapWidth2 = Math.round(bitmapWidth * scale);
            int bitmapHeight2 = Math.round(bitmapHeight * scale);
            matrix.postTranslate(-bounds.left, -bounds.top);
            matrix.postScale(scale, scale);
            if (c) {
                Picture picture = new Picture();
                Canvas canvas = picture.beginRecording(bitmapWidth2, bitmapHeight2);
                canvas.concat(matrix);
                view.draw(canvas);
                picture.endRecording();
                bitmap = Bitmap.createBitmap(picture);
            } else {
                bitmap = Bitmap.createBitmap(bitmapWidth2, bitmapHeight2, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmap);
                canvas2.concat(matrix);
                view.draw(canvas2);
            }
        }
        if (z && addToOverlay) {
            sceneRoot.getOverlay().remove(view);
            parent.addView(view, indexInParent);
        }
        return bitmap;
    }
}
