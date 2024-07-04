package b.b.a.a.l;

import a.h.k.v;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f1018a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f1019b;
    public final ColorStateList c;
    public final ColorStateList d;
    public final int e;
    public final b.b.a.a.x.k f;

    public b(ColorStateList backgroundColor, ColorStateList textColor, ColorStateList strokeColor, int strokeWidth, b.b.a.a.x.k itemShape, Rect insets) {
        a.h.j.i.c(insets.left);
        a.h.j.i.c(insets.top);
        a.h.j.i.c(insets.right);
        a.h.j.i.c(insets.bottom);
        this.f1018a = insets;
        this.f1019b = textColor;
        this.c = backgroundColor;
        this.d = strokeColor;
        this.e = strokeWidth;
        this.f = itemShape;
    }

    public static b a(Context context, int materialCalendarItemStyle) {
        a.h.j.i.a(materialCalendarItemStyle != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray styleableArray = context.obtainStyledAttributes(materialCalendarItemStyle, b.b.a.a.a.o);
        int[] iArr = b.b.a.a.a.f942a;
        int insetLeft = styleableArray.getDimensionPixelOffset(0, 0);
        int insetTop = styleableArray.getDimensionPixelOffset(2, 0);
        int insetRight = styleableArray.getDimensionPixelOffset(1, 0);
        int insetBottom = styleableArray.getDimensionPixelOffset(3, 0);
        Rect insets = new Rect(insetLeft, insetTop, insetRight, insetBottom);
        ColorStateList backgroundColor = b.b.a.a.u.c.a(context, styleableArray, 4);
        ColorStateList textColor = b.b.a.a.u.c.a(context, styleableArray, 9);
        ColorStateList strokeColor = b.b.a.a.u.c.a(context, styleableArray, 7);
        int strokeWidth = styleableArray.getDimensionPixelSize(8, 0);
        int shapeAppearanceResId = styleableArray.getResourceId(5, 0);
        int shapeAppearanceOverlayResId = styleableArray.getResourceId(6, 0);
        b.b.a.a.x.k itemShape = b.b.a.a.x.k.b(context, shapeAppearanceResId, shapeAppearanceOverlayResId).m();
        styleableArray.recycle();
        return new b(backgroundColor, textColor, strokeColor, strokeWidth, itemShape, insets);
    }

    public void b(TextView item) {
        Drawable d;
        b.b.a.a.x.g backgroundDrawable = new b.b.a.a.x.g();
        b.b.a.a.x.g shapeMask = new b.b.a.a.x.g();
        backgroundDrawable.setShapeAppearanceModel(this.f);
        shapeMask.setShapeAppearanceModel(this.f);
        backgroundDrawable.V(this.c);
        backgroundDrawable.a0(this.e, this.d);
        item.setTextColor(this.f1019b);
        if (Build.VERSION.SDK_INT >= 21) {
            d = new RippleDrawable(this.f1019b.withAlpha(30), backgroundDrawable, shapeMask);
        } else {
            d = backgroundDrawable;
        }
        Rect rect = this.f1018a;
        v.r0(item, new InsetDrawable(d, rect.left, rect.top, rect.right, rect.bottom));
    }
}
