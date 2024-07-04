package com.example.addflag;

import a.b.b.c;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import b.a.a.d;
import b.a.a.e;
import com.example.addflag.addFlag;
import net.sqlcipher.R;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class addFlag extends c {
    public EditText p;
    public Button q;

    @Override // a.k.b.e, androidx.activity.ComponentActivity, a.h.b.d, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flag);
        this.p = (EditText) findViewById(R.id.flagInput);
        Button button = (Button) findViewById(R.id.submitFlagButton);
        this.q = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: b.a.a.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                addFlag.this.M(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(View view) {
        String flag = this.p.getText().toString();
        K(flag);
        this.p.getText().clear();
    }

    public final void K(String flag) {
        d dbHelper = d.f(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase(e.b().d(this));
        ContentValues values = new ContentValues();
        values.put("owner", "user");
        String encryptedFlag = dbHelper.e(flag);
        values.put("flag", encryptedFlag);
        values.put("length", Integer.valueOf(encryptedFlag.length()));
        String tag = dbHelper.g();
        values.put("tag", tag);
        db.insert("FLAGS", (String) null, values);
    }
}
