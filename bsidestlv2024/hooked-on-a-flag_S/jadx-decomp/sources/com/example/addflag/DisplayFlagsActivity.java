package com.example.addflag;

import a.b.b.c;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class DisplayFlagsActivity extends c {
    public ListView p;
    public ArrayAdapter<String> q;
    public ArrayList<String> r;

    @Override // a.k.b.e, androidx.activity.ComponentActivity, a.h.b.d, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_flags);
        this.p = (ListView) findViewById(R.id.flagsListView);
        this.r = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.list_items, this.r);
        this.q = arrayAdapter;
        this.p.setAdapter((ListAdapter) arrayAdapter);
        K();
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0038, code lost:
    
        if (r2.moveToFirst() != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x003a, code lost:
    
        r3 = r2.getString(r2.getColumnIndex("flag"));
        r4 = r2.getString(r2.getColumnIndex("tag"));
        r5 = r0.d(r3, r4);
        r12.r.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0057, code lost:
    
        if (r2.moveToNext() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0059, code lost:
    
        r2.close();
        r12.q.notifyDataSetChanged();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0061, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K() {
        /*
            r12 = this;
            b.a.a.d r0 = b.a.a.d.f(r12)
            b.a.a.e r1 = b.a.a.e.b()
            java.lang.String r1 = r1.d(r12)
            net.sqlcipher.database.SQLiteDatabase r1 = r0.getReadableDatabase(r1)
            r2 = 3
            java.lang.String[] r4 = new java.lang.String[r2]
            r2 = 0
            java.lang.String r10 = "flag"
            r4[r2] = r10
            java.lang.String r3 = "length"
            r5 = 1
            r4[r5] = r3
            r3 = 2
            java.lang.String r11 = "tag"
            r4[r3] = r11
            java.lang.String[] r6 = new java.lang.String[r5]
            java.lang.String r3 = "user"
            r6[r2] = r3
            java.lang.String r3 = "FLAGS"
            java.lang.String r5 = "owner=?"
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r1
            net.sqlcipher.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)
            boolean r3 = r2.moveToFirst()
            if (r3 == 0) goto L59
        L3a:
            int r3 = r2.getColumnIndex(r10)
            java.lang.String r3 = r2.getString(r3)
            int r4 = r2.getColumnIndex(r11)
            java.lang.String r4 = r2.getString(r4)
            java.lang.String r5 = r0.d(r3, r4)
            java.util.ArrayList<java.lang.String> r6 = r12.r
            r6.add(r5)
            boolean r3 = r2.moveToNext()
            if (r3 != 0) goto L3a
        L59:
            r2.close()
            android.widget.ArrayAdapter<java.lang.String> r3 = r12.q
            r3.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.addflag.DisplayFlagsActivity.K():void");
    }
}
