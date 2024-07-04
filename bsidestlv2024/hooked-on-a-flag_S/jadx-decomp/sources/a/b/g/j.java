package a.b.g;

import a.b.g.n0;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final PorterDuff.Mode f158a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public static j f159b;
    public n0 c;

    public static synchronized void h() {
        synchronized (j.class) {
            if (f159b == null) {
                j jVar = new j();
                f159b = jVar;
                jVar.c = n0.h();
                f159b.c.t(new a());
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements n0.f {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f160a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        public final int[] f161b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
        public final int[] c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
        public final int[] d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        public final int[] e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        public final int[] f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        public final ColorStateList e(Context context) {
            return c(context, s0.c(context, R.attr.colorButtonNormal));
        }

        public final ColorStateList b(Context context) {
            return c(context, 0);
        }

        public final ColorStateList d(Context context) {
            return c(context, s0.c(context, R.attr.colorAccent));
        }

        public final ColorStateList c(Context context, int baseColor) {
            int[][] states = new int[4];
            int[] colors = new int[4];
            int colorControlHighlight = s0.c(context, R.attr.colorControlHighlight);
            int disabledColor = s0.b(context, R.attr.colorButtonNormal);
            states[0] = s0.f192b;
            colors[0] = disabledColor;
            int i = 0 + 1;
            states[i] = s0.d;
            colors[i] = a.h.d.a.b(colorControlHighlight, baseColor);
            int i2 = i + 1;
            states[i2] = s0.c;
            colors[i2] = a.h.d.a.b(colorControlHighlight, baseColor);
            int i3 = i2 + 1;
            states[i3] = s0.f;
            colors[i3] = baseColor;
            int i4 = i3 + 1;
            return new ColorStateList(states, colors);
        }

        public final ColorStateList g(Context context) {
            int[][] states = new int[3];
            int[] colors = new int[3];
            ColorStateList thumbColor = s0.e(context, R.attr.colorSwitchThumbNormal);
            if (thumbColor == null || !thumbColor.isStateful()) {
                states[0] = s0.f192b;
                colors[0] = s0.b(context, R.attr.colorSwitchThumbNormal);
                int i = 0 + 1;
                states[i] = s0.e;
                colors[i] = s0.c(context, R.attr.colorControlActivated);
                int i2 = i + 1;
                states[i2] = s0.f;
                colors[i2] = s0.c(context, R.attr.colorSwitchThumbNormal);
                int i3 = i2 + 1;
            } else {
                states[0] = s0.f192b;
                colors[0] = thumbColor.getColorForState(states[0], 0);
                int i4 = 0 + 1;
                states[i4] = s0.e;
                colors[i4] = s0.c(context, R.attr.colorControlActivated);
                int i5 = i4 + 1;
                states[i5] = s0.f;
                colors[i5] = thumbColor.getDefaultColor();
                int i6 = i5 + 1;
            }
            return new ColorStateList(states, colors);
        }

        public Drawable f(n0 resourceManager, Context context, int resId) {
            if (resId == R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{resourceManager.j(context, R.drawable.abc_cab_background_internal_bg), resourceManager.j(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (resId == R.drawable.abc_ratingbar_material) {
                return h(resourceManager, context, R.dimen.abc_star_big);
            }
            if (resId == R.drawable.abc_ratingbar_indicator_material) {
                return h(resourceManager, context, R.dimen.abc_star_medium);
            }
            if (resId == R.drawable.abc_ratingbar_small_material) {
                return h(resourceManager, context, R.dimen.abc_star_small);
            }
            return null;
        }

        public final LayerDrawable h(n0 resourceManager, Context context, int dimenResId) {
            BitmapDrawable starBitmapDrawable;
            BitmapDrawable tiledStarBitmapDrawable;
            BitmapDrawable halfStarBitmapDrawable;
            int starSize = context.getResources().getDimensionPixelSize(dimenResId);
            Drawable star = resourceManager.j(context, R.drawable.abc_star_black_48dp);
            Drawable halfStar = resourceManager.j(context, R.drawable.abc_star_half_black_48dp);
            if ((star instanceof BitmapDrawable) && star.getIntrinsicWidth() == starSize && star.getIntrinsicHeight() == starSize) {
                starBitmapDrawable = (BitmapDrawable) star;
                tiledStarBitmapDrawable = new BitmapDrawable(starBitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapStar = Bitmap.createBitmap(starSize, starSize, Bitmap.Config.ARGB_8888);
                Canvas canvasStar = new Canvas(bitmapStar);
                star.setBounds(0, 0, starSize, starSize);
                star.draw(canvasStar);
                BitmapDrawable starBitmapDrawable2 = new BitmapDrawable(bitmapStar);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapStar);
                starBitmapDrawable = starBitmapDrawable2;
                tiledStarBitmapDrawable = bitmapDrawable;
            }
            tiledStarBitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((halfStar instanceof BitmapDrawable) && halfStar.getIntrinsicWidth() == starSize && halfStar.getIntrinsicHeight() == starSize) {
                halfStarBitmapDrawable = (BitmapDrawable) halfStar;
            } else {
                Bitmap bitmapHalfStar = Bitmap.createBitmap(starSize, starSize, Bitmap.Config.ARGB_8888);
                Canvas canvasHalfStar = new Canvas(bitmapHalfStar);
                halfStar.setBounds(0, 0, starSize, starSize);
                halfStar.draw(canvasHalfStar);
                halfStarBitmapDrawable = new BitmapDrawable(bitmapHalfStar);
            }
            LayerDrawable result = new LayerDrawable(new Drawable[]{starBitmapDrawable, halfStarBitmapDrawable, tiledStarBitmapDrawable});
            result.setId(0, android.R.id.background);
            result.setId(1, android.R.id.secondaryProgress);
            result.setId(2, android.R.id.progress);
            return result;
        }

        public final void k(Drawable d, int color, PorterDuff.Mode mode) {
            PorterDuff.Mode mode2;
            if (f0.a(d)) {
                d = d.mutate();
            }
            if (mode == null) {
                mode2 = j.f158a;
            } else {
                mode2 = mode;
            }
            d.setColorFilter(j.e(color, mode2));
        }

        public boolean l(Context context, int resId, Drawable drawable) {
            if (resId == R.drawable.abc_seekbar_track_material) {
                LayerDrawable ld = (LayerDrawable) drawable;
                k(ld.findDrawableByLayerId(android.R.id.background), s0.c(context, R.attr.colorControlNormal), j.f158a);
                k(ld.findDrawableByLayerId(android.R.id.secondaryProgress), s0.c(context, R.attr.colorControlNormal), j.f158a);
                k(ld.findDrawableByLayerId(android.R.id.progress), s0.c(context, R.attr.colorControlActivated), j.f158a);
                return true;
            }
            if (resId == R.drawable.abc_ratingbar_material || resId == R.drawable.abc_ratingbar_indicator_material || resId == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable ld2 = (LayerDrawable) drawable;
                k(ld2.findDrawableByLayerId(android.R.id.background), s0.b(context, R.attr.colorControlNormal), j.f158a);
                k(ld2.findDrawableByLayerId(android.R.id.secondaryProgress), s0.c(context, R.attr.colorControlActivated), j.f158a);
                k(ld2.findDrawableByLayerId(android.R.id.progress), s0.c(context, R.attr.colorControlActivated), j.f158a);
                return true;
            }
            return false;
        }

        public final boolean a(int[] array, int value) {
            for (int id : array) {
                if (id == value) {
                    return true;
                }
            }
            return false;
        }

        public ColorStateList i(Context context, int resId) {
            if (resId == R.drawable.abc_edit_text_material) {
                return a.b.c.a.a.c(context, R.color.abc_tint_edittext);
            }
            if (resId == R.drawable.abc_switch_track_mtrl_alpha) {
                return a.b.c.a.a.c(context, R.color.abc_tint_switch_track);
            }
            if (resId == R.drawable.abc_switch_thumb_material) {
                return g(context);
            }
            if (resId == R.drawable.abc_btn_default_mtrl_shape) {
                return e(context);
            }
            if (resId == R.drawable.abc_btn_borderless_material) {
                return b(context);
            }
            if (resId == R.drawable.abc_btn_colored_material) {
                return d(context);
            }
            if (resId == R.drawable.abc_spinner_mtrl_am_alpha || resId == R.drawable.abc_spinner_textfield_background_material) {
                return a.b.c.a.a.c(context, R.color.abc_tint_spinner);
            }
            if (a(this.f161b, resId)) {
                return s0.e(context, R.attr.colorControlNormal);
            }
            if (a(this.e, resId)) {
                return a.b.c.a.a.c(context, R.color.abc_tint_default);
            }
            if (a(this.f, resId)) {
                return a.b.c.a.a.c(context, R.color.abc_tint_btn_checkable);
            }
            if (resId == R.drawable.abc_seekbar_thumb_material) {
                return a.b.c.a.a.c(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }

        public boolean m(Context context, int resId, Drawable drawable) {
            PorterDuff.Mode tintMode = j.f158a;
            boolean colorAttrSet = false;
            int colorAttr = 0;
            int alpha = -1;
            if (a(this.f160a, resId)) {
                colorAttr = R.attr.colorControlNormal;
                colorAttrSet = true;
            } else if (a(this.c, resId)) {
                colorAttr = R.attr.colorControlActivated;
                colorAttrSet = true;
            } else if (a(this.d, resId)) {
                colorAttr = android.R.attr.colorBackground;
                colorAttrSet = true;
                tintMode = PorterDuff.Mode.MULTIPLY;
            } else if (resId == R.drawable.abc_list_divider_mtrl_alpha) {
                colorAttr = android.R.attr.colorForeground;
                colorAttrSet = true;
                alpha = Math.round(40.8f);
            } else if (resId == R.drawable.abc_dialog_material_background) {
                colorAttr = android.R.attr.colorBackground;
                colorAttrSet = true;
            }
            if (colorAttrSet) {
                if (f0.a(drawable)) {
                    drawable = drawable.mutate();
                }
                int color = s0.c(context, colorAttr);
                drawable.setColorFilter(j.e(color, tintMode));
                if (alpha != -1) {
                    drawable.setAlpha(alpha);
                    return true;
                }
                return true;
            }
            return false;
        }

        public PorterDuff.Mode j(int resId) {
            if (resId != R.drawable.abc_switch_thumb_material) {
                return null;
            }
            PorterDuff.Mode mode = PorterDuff.Mode.MULTIPLY;
            return mode;
        }
    }

    public static synchronized j b() {
        j jVar;
        synchronized (j.class) {
            if (f159b == null) {
                h();
            }
            jVar = f159b;
        }
        return jVar;
    }

    public synchronized Drawable c(Context context, int resId) {
        return this.c.j(context, resId);
    }

    public synchronized Drawable d(Context context, int resId, boolean failIfNotKnown) {
        return this.c.k(context, resId, failIfNotKnown);
    }

    public synchronized void g(Context context) {
        this.c.s(context);
    }

    public synchronized ColorStateList f(Context context, int resId) {
        return this.c.m(context, resId);
    }

    public static void i(Drawable drawable, v0 tint, int[] state) {
        n0.v(drawable, tint, state);
    }

    public static synchronized PorterDuffColorFilter e(int color, PorterDuff.Mode mode) {
        PorterDuffColorFilter l;
        synchronized (j.class) {
            l = n0.l(color, mode);
        }
        return l;
    }
}
