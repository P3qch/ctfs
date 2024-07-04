package a.f.c;

import a.f.a.k.e;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class g extends View {

    /* renamed from: b, reason: collision with root package name */
    public int f328b;
    public View c;
    public int d;

    public void setEmptyVisibility(int visibility) {
        this.d = visibility;
    }

    public int getEmptyVisibility() {
        return this.d;
    }

    public View getContent() {
        return this.c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect r = new Rect();
            canvas.getClipBounds(r);
            paint.setTextSize(r.height());
            int cHeight = r.height();
            int cWidth = r.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, "?".length(), r);
            float x = ((cWidth / 2.0f) - (r.width() / 2.0f)) - r.left;
            float y = ((cHeight / 2.0f) + (r.height() / 2.0f)) - r.bottom;
            canvas.drawText("?", x, y, paint);
        }
    }

    public void b(ConstraintLayout container) {
        if (this.f328b == -1 && !isInEditMode()) {
            setVisibility(this.d);
        }
        View findViewById = container.findViewById(this.f328b);
        this.c = findViewById;
        if (findViewById != null) {
            ConstraintLayout.a layoutParamsContent = (ConstraintLayout.a) findViewById.getLayoutParams();
            layoutParamsContent.e0 = true;
            this.c.setVisibility(0);
            setVisibility(0);
        }
    }

    public void setContentId(int id) {
        View v;
        if (this.f328b == id) {
            return;
        }
        View view = this.c;
        if (view != null) {
            view.setVisibility(0);
            ConstraintLayout.a layoutParamsContent = (ConstraintLayout.a) this.c.getLayoutParams();
            layoutParamsContent.e0 = false;
            this.c = null;
        }
        this.f328b = id;
        if (id != -1 && (v = ((View) getParent()).findViewById(id)) != null) {
            v.setVisibility(8);
        }
    }

    public void a() {
        if (this.c == null) {
            return;
        }
        ConstraintLayout.a layoutParams = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a layoutParamsContent = (ConstraintLayout.a) this.c.getLayoutParams();
        layoutParamsContent.q0.Y0(0);
        e.a w = layoutParams.q0.w();
        e.a aVar = e.a.FIXED;
        if (w != aVar) {
            layoutParams.q0.Z0(layoutParamsContent.q0.P());
        }
        if (layoutParams.q0.M() != aVar) {
            layoutParams.q0.A0(layoutParamsContent.q0.t());
        }
        layoutParamsContent.q0.Y0(8);
    }
}
