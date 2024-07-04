package b.b.a.a.l;

import a.h.k.v;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.a.a.l.a;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public final class i<S> extends a.k.b.d {
    public static final Object n0 = "CONFIRM_BUTTON_TAG";
    public static final Object o0 = "CANCEL_BUTTON_TAG";
    public static final Object p0 = "TOGGLE_BUTTON_TAG";
    public CharSequence A0;
    public boolean B0;
    public int C0;
    public TextView D0;
    public CheckableImageButton E0;
    public b.b.a.a.x.g F0;
    public Button G0;
    public final LinkedHashSet<j<? super S>> q0 = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> r0 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnCancelListener> s0 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> t0 = new LinkedHashSet<>();
    public int u0;
    public b.b.a.a.l.d<S> v0;
    public p<S> w0;
    public b.b.a.a.l.a x0;
    public h<S> y0;
    public int z0;

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    public String T1() {
        return this.v0.d(q());
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    @Override // a.k.b.d, androidx.fragment.app.Fragment
    public final void B0(Bundle bundle) {
        super.B0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.u0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.v0);
        a.b constraintsBuilder = new a.b(this.x0);
        if (this.y0.I1() != null) {
            constraintsBuilder.b(this.y0.I1().g);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", constraintsBuilder.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.z0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.A0);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    @Override // a.k.b.d, androidx.fragment.app.Fragment
    public final void j0(Bundle bundle) {
        super.j0(bundle);
        Bundle activeBundle = bundle == null ? o() : bundle;
        this.u0 = activeBundle.getInt("OVERRIDE_THEME_RES_ID");
        this.v0 = (b.b.a.a.l.d) activeBundle.getParcelable("DATE_SELECTOR_KEY");
        this.x0 = (b.b.a.a.l.a) activeBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.z0 = activeBundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.A0 = activeBundle.getCharSequence("TITLE_TEXT_KEY");
        this.C0 = activeBundle.getInt("INPUT_MODE_KEY");
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    public final int W1(Context context) {
        int i = this.u0;
        if (i != 0) {
            return i;
        }
        return this.v0.f(context);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    @Override // a.k.b.d
    public final Dialog D1(Bundle bundle) {
        Dialog dialog = new Dialog(f1(), W1(f1()));
        Context context = dialog.getContext();
        this.B0 = Y1(context);
        int surfaceColor = b.b.a.a.u.b.c(context, R.attr.colorSurface, i.class.getCanonicalName());
        b.b.a.a.x.g gVar = new b.b.a.a.x.g(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.F0 = gVar;
        gVar.L(context);
        this.F0.V(ColorStateList.valueOf(surfaceColor));
        this.F0.U(v.w(dialog.getWindow().getDecorView()));
        return dialog;
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    @Override // androidx.fragment.app.Fragment
    public final View m0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int layout = this.B0 ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog;
        View root = layoutInflater.inflate(layout, viewGroup);
        Context context = root.getContext();
        if (this.B0) {
            View frame = root.findViewById(R.id.mtrl_calendar_frame);
            frame.setLayoutParams(new LinearLayout.LayoutParams(U1(context), -2));
        } else {
            View pane = root.findViewById(R.id.mtrl_calendar_main_pane);
            View frame2 = root.findViewById(R.id.mtrl_calendar_frame);
            pane.setLayoutParams(new LinearLayout.LayoutParams(U1(context), -1));
            frame2.setMinimumHeight(S1(f1()));
        }
        TextView textView = (TextView) root.findViewById(R.id.mtrl_picker_header_selection_text);
        this.D0 = textView;
        v.q0(textView, 1);
        this.E0 = (CheckableImageButton) root.findViewById(R.id.mtrl_picker_header_toggle);
        TextView titleTextView = (TextView) root.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.A0;
        if (charSequence != null) {
            titleTextView.setText(charSequence);
        } else {
            titleTextView.setText(this.z0);
        }
        X1(context);
        this.G0 = (Button) root.findViewById(R.id.confirm_button);
        if (this.v0.b()) {
            this.G0.setEnabled(true);
        } else {
            this.G0.setEnabled(false);
        }
        this.G0.setTag("CONFIRM_BUTTON_TAG");
        this.G0.setOnClickListener(new a());
        Button cancelButton = (Button) root.findViewById(R.id.cancel_button);
        cancelButton.setTag("CANCEL_BUTTON_TAG");
        cancelButton.setOnClickListener(new b());
        return root;
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.j != com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener<? super S> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Iterator it = i.this.q0.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(i.this.V1());
            }
            i.this.z1();
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Iterator it = i.this.r0.iterator();
            while (it.hasNext()) {
                View.OnClickListener listener = (View.OnClickListener) it.next();
                listener.onClick(v);
            }
            i.this.z1();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    @Override // a.k.b.d, androidx.fragment.app.Fragment
    public void C0() {
        super.C0();
        Window window = H1().getWindow();
        if (this.B0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.F0);
        } else {
            window.setLayout(-2, -2);
            int inset = J().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect insets = new Rect(inset, inset, inset, inset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.F0, inset, inset, inset, inset));
            window.getDecorView().setOnTouchListener(new b.b.a.a.m.a(H1(), insets));
        }
        b2();
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    @Override // a.k.b.d, androidx.fragment.app.Fragment
    public void D0() {
        this.w0.x1();
        super.D0();
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    @Override // a.k.b.d, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.s0.iterator();
        while (it.hasNext()) {
            DialogInterface.OnCancelListener listener = it.next();
            listener.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    @Override // a.k.b.d, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.t0.iterator();
        while (it.hasNext()) {
            DialogInterface.OnDismissListener listener = it.next();
            listener.onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) R();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    public final S V1() {
        return this.v0.a();
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    public final void c2() {
        String headerText = T1();
        this.D0.setContentDescription(String.format(P(R.string.mtrl_picker_announce_current_selection), headerText));
        this.D0.setText(headerText);
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    public final void b2() {
        int themeResId = W1(f1());
        this.y0 = h.M1(this.v0, themeResId, this.x0);
        this.w0 = this.E0.isChecked() ? k.y1(this.v0, themeResId, this.x0) : this.y0;
        c2();
        a.k.b.v fragmentTransaction = p().j();
        fragmentTransaction.l(R.id.mtrl_calendar_frame, this.w0);
        fragmentTransaction.g();
        this.w0.w1(new c());
    }

    /* loaded from: classes.dex */
    public class c extends o<S> {
        public c() {
        }

        @Override // b.b.a.a.l.o
        public void a(S selection) {
            i.this.c2();
            i.this.G0.setEnabled(i.this.v0.b());
        }
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    public final void X1(Context context) {
        this.E0.setTag("TOGGLE_BUTTON_TAG");
        this.E0.setImageDrawable(R1(context));
        this.E0.setChecked(this.C0 != 0);
        v.o0(this.E0, null);
        d2(this.E0);
        this.E0.setOnClickListener(new d());
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            i.this.G0.setEnabled(i.this.v0.b());
            i.this.E0.toggle();
            i iVar = i.this;
            iVar.d2(iVar.E0);
            i.this.b2();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: b.b.a.a.l.i != com.google.android.material.datepicker.MaterialDatePicker<S> */
    public final void d2(CheckableImageButton toggle) {
        String contentDescription;
        if (this.E0.isChecked()) {
            contentDescription = toggle.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            contentDescription = toggle.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.E0.setContentDescription(contentDescription);
    }

    public static Drawable R1(Context context) {
        StateListDrawable toggleDrawable = new StateListDrawable();
        toggleDrawable.addState(new int[]{android.R.attr.state_checked}, a.b.c.a.a.d(context, R.drawable.material_ic_calendar_black_24dp));
        toggleDrawable.addState(new int[0], a.b.c.a.a.d(context, R.drawable.material_ic_edit_black_24dp));
        return toggleDrawable;
    }

    public static boolean Y1(Context context) {
        return a2(context, android.R.attr.windowFullscreen);
    }

    public static boolean Z1(Context context) {
        return a2(context, R.attr.nestedScrollable);
    }

    public static boolean a2(Context context, int attributeResId) {
        int calendarStyle = b.b.a.a.u.b.c(context, R.attr.materialCalendarStyle, h.class.getCanonicalName());
        int[] attrs = {attributeResId};
        TypedArray a2 = context.obtainStyledAttributes(calendarStyle, attrs);
        boolean attributeValue = a2.getBoolean(0, false);
        a2.recycle();
        return attributeValue;
    }

    public static int S1(Context context) {
        Resources resources = context.getResources();
        int navigationHeight = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int daysOfWeekHeight = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i = m.f1040b;
        int calendarHeight = (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i) + ((i - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding));
        int calendarPadding = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
        return navigationHeight + daysOfWeekHeight + calendarHeight + calendarPadding;
    }

    public static int U1(Context context) {
        Resources resources = context.getResources();
        int padding = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int daysInWeek = l.m().e;
        int dayWidth = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width);
        int horizontalSpace = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
        return (padding * 2) + (daysInWeek * dayWidth) + ((daysInWeek - 1) * horizontalSpace);
    }
}
