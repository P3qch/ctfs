package a.b.g;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class r0 extends a.i.a.c implements View.OnClickListener {
    public final SearchView m;
    public final SearchableInfo n;
    public final Context o;
    public final WeakHashMap<String, Drawable.ConstantState> p;
    public final int q;
    public boolean r;
    public int s;
    public ColorStateList t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public r0(Context context, SearchView searchView, SearchableInfo searchable, WeakHashMap<String, Drawable.ConstantState> outsideDrawablesCache) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.r = false;
        this.s = 1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        this.m = searchView;
        this.n = searchable;
        this.q = searchView.getSuggestionCommitIconResId();
        this.o = context;
        this.p = outsideDrawablesCache;
    }

    public void x(int refineWhat) {
        this.s = refineWhat;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public Cursor w(CharSequence constraint) {
        String query = constraint == null ? BuildConfig.FLAVOR : constraint.toString();
        if (this.m.getVisibility() != 0 || this.m.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursor = u(this.n, query, 50);
            if (cursor != null) {
                cursor.getCount();
                return cursor;
            }
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(d());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(d());
    }

    public final void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // a.i.a.a
    public void b(Cursor c) {
        try {
            super.b(c);
            if (c != null) {
                this.u = c.getColumnIndex("suggest_text_1");
                this.v = c.getColumnIndex("suggest_text_2");
                this.w = c.getColumnIndex("suggest_text_2_url");
                this.x = c.getColumnIndex("suggest_icon_1");
                this.y = c.getColumnIndex("suggest_icon_2");
                this.z = c.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // a.i.a.c, a.i.a.a
    public View g(Context context, Cursor cursor, ViewGroup parent) {
        View v = super.g(context, cursor, parent);
        v.setTag(new a(v));
        ImageView iconRefine = (ImageView) v.findViewById(R.id.edit_query);
        iconRefine.setImageResource(this.q);
        return v;
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f188a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f189b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;

        public a(View v) {
            this.f188a = (TextView) v.findViewById(android.R.id.text1);
            this.f189b = (TextView) v.findViewById(android.R.id.text2);
            this.c = (ImageView) v.findViewById(android.R.id.icon1);
            this.d = (ImageView) v.findViewById(android.R.id.icon2);
            this.e = (ImageView) v.findViewById(R.id.edit_query);
        }
    }

    @Override // a.i.a.a
    public void a(View view, Context context, Cursor cursor) {
        CharSequence text2;
        a views = (a) view.getTag();
        int flags = 0;
        int i = this.z;
        if (i != -1) {
            flags = cursor.getInt(i);
        }
        if (views.f188a != null) {
            String text1 = v(cursor, this.u);
            z(views.f188a, text1);
        }
        if (views.f189b != null) {
            CharSequence text22 = v(cursor, this.w);
            if (text22 != null) {
                text2 = k(text22);
            } else {
                text2 = v(cursor, this.v);
            }
            if (TextUtils.isEmpty(text2)) {
                TextView textView = views.f188a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    views.f188a.setMaxLines(2);
                }
            } else {
                TextView textView2 = views.f188a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    views.f188a.setMaxLines(1);
                }
            }
            z(views.f189b, text2);
        }
        ImageView imageView = views.c;
        if (imageView != null) {
            y(imageView, s(cursor), 4);
        }
        ImageView imageView2 = views.d;
        if (imageView2 != null) {
            y(imageView2, t(cursor), 8);
        }
        int i2 = this.s;
        if (i2 == 2 || (i2 == 1 && (flags & 1) != 0)) {
            views.e.setVisibility(0);
            views.e.setTag(views.f188a.getText());
            views.e.setOnClickListener(this);
            return;
        }
        views.e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Object tag = v.getTag();
        if (tag instanceof CharSequence) {
            this.m.U((CharSequence) tag);
        }
    }

    public final CharSequence k(CharSequence url) {
        if (this.t == null) {
            TypedValue colorValue = new TypedValue();
            this.o.getTheme().resolveAttribute(R.attr.textColorSearchUrl, colorValue, true);
            this.t = this.o.getResources().getColorStateList(colorValue.resourceId);
        }
        SpannableString text = new SpannableString(url);
        text.setSpan(new TextAppearanceSpan(null, 0, 0, this.t, null), 0, url.length(), 33);
        return text;
    }

    public final void z(TextView v, CharSequence text) {
        v.setText(text);
        if (TextUtils.isEmpty(text)) {
            v.setVisibility(8);
        } else {
            v.setVisibility(0);
        }
    }

    public final Drawable s(Cursor cursor) {
        int i = this.x;
        if (i == -1) {
            return null;
        }
        String value = cursor.getString(i);
        Drawable drawable = r(value);
        if (drawable != null) {
            return drawable;
        }
        return o();
    }

    public final Drawable t(Cursor cursor) {
        int i = this.y;
        if (i == -1) {
            return null;
        }
        String value = cursor.getString(i);
        return r(value);
    }

    public final void y(ImageView v, Drawable drawable, int nullVisibility) {
        v.setImageDrawable(drawable);
        if (drawable == null) {
            v.setVisibility(nullVisibility);
            return;
        }
        v.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // a.i.a.a
    public CharSequence c(Cursor cursor) {
        String text1;
        String data;
        if (cursor == null) {
            return null;
        }
        String query = n(cursor, "suggest_intent_query");
        if (query != null) {
            return query;
        }
        if (this.n.shouldRewriteQueryFromData() && (data = n(cursor, "suggest_intent_data")) != null) {
            return data;
        }
        if (!this.n.shouldRewriteQueryFromText() || (text1 = n(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return text1;
    }

    @Override // a.i.a.a, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            return super.getView(position, convertView, parent);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View v = g(this.o, d(), parent);
            a views = (a) v.getTag();
            TextView tv = views.f188a;
            tv.setText(e.toString());
            return v;
        }
    }

    @Override // a.i.a.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        try {
            return super.getDropDownView(position, convertView, parent);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View v = f(this.o, d(), parent);
            if (v != null) {
                a views = (a) v.getTag();
                TextView tv = views.f188a;
                tv.setText(e.toString());
            }
            return v;
        }
    }

    public final Drawable r(String drawableId) {
        if (drawableId == null || drawableId.isEmpty() || "0".equals(drawableId)) {
            return null;
        }
        try {
            int resourceId = Integer.parseInt(drawableId);
            String drawableUri = "android.resource://" + this.o.getPackageName() + "/" + resourceId;
            Drawable drawable = j(drawableUri);
            if (drawable != null) {
                return drawable;
            }
            Drawable drawable2 = a.h.c.a.d(this.o, resourceId);
            A(drawableUri, drawable2);
            return drawable2;
        } catch (Resources.NotFoundException e) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + drawableId);
            return null;
        } catch (NumberFormatException e2) {
            Drawable drawable3 = j(drawableId);
            if (drawable3 != null) {
                return drawable3;
            }
            Uri uri = Uri.parse(drawableId);
            Drawable drawable4 = p(uri);
            A(drawableId, drawable4);
            return drawable4;
        }
    }

    public final Drawable p(Uri uri) {
        try {
            String scheme = uri.getScheme();
            if ("android.resource".equals(scheme)) {
                try {
                    return q(uri);
                } catch (Resources.NotFoundException e) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream stream = this.o.getContentResolver().openInputStream(uri);
            if (stream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(stream, null);
            } finally {
                try {
                    stream.close();
                } catch (IOException ex) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, ex);
                }
            }
        } catch (FileNotFoundException fnfe) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + fnfe.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + fnfe.getMessage());
        return null;
    }

    public final Drawable j(String resourceUri) {
        Drawable.ConstantState cached = this.p.get(resourceUri);
        if (cached == null) {
            return null;
        }
        return cached.newDrawable();
    }

    public final void A(String resourceUri, Drawable drawable) {
        if (drawable != null) {
            this.p.put(resourceUri, drawable.getConstantState());
        }
    }

    public final Drawable o() {
        Drawable drawable = m(this.n.getSearchActivity());
        if (drawable != null) {
            return drawable;
        }
        return this.o.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable m(ComponentName component) {
        String componentIconKey = component.flattenToShortString();
        if (this.p.containsKey(componentIconKey)) {
            Drawable.ConstantState cached = this.p.get(componentIconKey);
            if (cached == null) {
                return null;
            }
            return cached.newDrawable(this.o.getResources());
        }
        Drawable drawable = l(component);
        Drawable.ConstantState toCache = drawable != null ? drawable.getConstantState() : null;
        this.p.put(componentIconKey, toCache);
        return drawable;
    }

    public final Drawable l(ComponentName component) {
        PackageManager pm = this.o.getPackageManager();
        try {
            ActivityInfo activityInfo = pm.getActivityInfo(component, 128);
            int iconId = activityInfo.getIconResource();
            if (iconId == 0) {
                return null;
            }
            String pkg = component.getPackageName();
            Drawable drawable = pm.getDrawable(pkg, iconId, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconId + " for " + component.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException ex) {
            Log.w("SuggestionsAdapter", ex.toString());
            return null;
        }
    }

    public static String n(Cursor cursor, String columnName) {
        int col = cursor.getColumnIndex(columnName);
        return v(cursor, col);
    }

    public static String v(Cursor cursor, int col) {
        if (col == -1) {
            return null;
        }
        try {
            return cursor.getString(col);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    public Drawable q(Uri uri) {
        int id;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources r = this.o.getPackageManager().getResourcesForApplication(authority);
            List<String> path = uri.getPathSegments();
            if (path == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int len = path.size();
            if (len == 1) {
                try {
                    id = Integer.parseInt(path.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (len == 2) {
                id = r.getIdentifier(path.get(1), path.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (id == 0) {
                throw new FileNotFoundException("No resource found for: " + uri);
            }
            return r.getDrawable(id);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public Cursor u(SearchableInfo searchable, String query, int limit) {
        String authority;
        String[] selArgs;
        if (searchable == null || (authority = searchable.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder uriBuilder = new Uri.Builder().scheme("content").authority(authority).query(BuildConfig.FLAVOR).fragment(BuildConfig.FLAVOR);
        String contentPath = searchable.getSuggestPath();
        if (contentPath != null) {
            uriBuilder.appendEncodedPath(contentPath);
        }
        uriBuilder.appendPath("search_suggest_query");
        String selection = searchable.getSuggestSelection();
        if (selection != null) {
            String[] selArgs2 = {query};
            selArgs = selArgs2;
        } else {
            uriBuilder.appendPath(query);
            selArgs = null;
        }
        if (limit > 0) {
            uriBuilder.appendQueryParameter("limit", String.valueOf(limit));
        }
        Uri uri = uriBuilder.build();
        return this.o.getContentResolver().query(uri, null, selection, selArgs, null);
    }
}
