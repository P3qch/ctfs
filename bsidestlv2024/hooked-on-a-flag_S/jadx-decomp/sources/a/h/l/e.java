package a.h.l;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList a(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintList();
        }
        if (imageView instanceof m) {
            return ((m) imageView).getSupportImageTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(ImageView imageView, ColorStateList tintList) {
        Drawable imageViewDrawable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            imageView.setImageTintList(tintList);
            if (i == 21 && (imageViewDrawable = imageView.getDrawable()) != null && imageView.getImageTintList() != null) {
                if (imageViewDrawable.isStateful()) {
                    imageViewDrawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(imageViewDrawable);
                return;
            }
            return;
        }
        if (imageView instanceof m) {
            ((m) imageView).setSupportImageTintList(tintList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode b(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintMode();
        }
        if (imageView instanceof m) {
            return ((m) imageView).getSupportImageTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(ImageView imageView, PorterDuff.Mode mode) {
        Drawable imageViewDrawable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            imageView.setImageTintMode(mode);
            if (i == 21 && (imageViewDrawable = imageView.getDrawable()) != null && imageView.getImageTintList() != null) {
                if (imageViewDrawable.isStateful()) {
                    imageViewDrawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(imageViewDrawable);
                return;
            }
            return;
        }
        if (imageView instanceof m) {
            ((m) imageView).setSupportImageTintMode(mode);
        }
    }
}
