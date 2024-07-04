package b.b.a.a.t;

import a.b.g.s;
import a.h.l.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.b.a.a.r.j;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class a extends s {
    public static final int e = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;
    public static final int[][] f = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList g;
    public boolean h;

    public a(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.radioButtonStyle);
    }

    public a(Context context, AttributeSet attrs, int defStyleAttr) {
        super(b.b.a.a.b0.a.a.c(context, attrs, defStyleAttr, R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attrs, defStyleAttr);
        Context context2 = getContext();
        TypedArray attributes = j.h(context2, attrs, b.b.a.a.a.q, defStyleAttr, R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        int[] iArr = b.b.a.a.a.f942a;
        if (attributes.hasValue(0)) {
            c.c(this, b.b.a.a.u.c.a(context2, attributes, 0));
        }
        this.h = attributes.getBoolean(1, false);
        attributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean useMaterialThemeColors) {
        this.h = useMaterialThemeColors;
        if (useMaterialThemeColors) {
            c.c(this, getMaterialThemeColorsTintList());
        } else {
            c.c(this, null);
        }
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.g == null) {
            int colorControlActivated = b.b.a.a.k.a.c(this, R.attr.colorControlActivated);
            int colorOnSurface = b.b.a.a.k.a.c(this, R.attr.colorOnSurface);
            int colorSurface = b.b.a.a.k.a.c(this, R.attr.colorSurface);
            int[][] iArr = f;
            int[] radioButtonColorList = new int[iArr.length];
            radioButtonColorList[0] = b.b.a.a.k.a.f(colorSurface, colorControlActivated, 1.0f);
            radioButtonColorList[1] = b.b.a.a.k.a.f(colorSurface, colorOnSurface, 0.54f);
            radioButtonColorList[2] = b.b.a.a.k.a.f(colorSurface, colorOnSurface, 0.38f);
            radioButtonColorList[3] = b.b.a.a.k.a.f(colorSurface, colorOnSurface, 0.38f);
            this.g = new ColorStateList(iArr, radioButtonColorList);
        }
        return this.g;
    }
}
