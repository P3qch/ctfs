package com.example.addflag;

import a.b.b.c;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import b.a.a.d;
import com.example.addflag.MainActivity;
import java.io.IOException;
import net.sqlcipher.R;

/* loaded from: classes.dex */
public class MainActivity extends c {
    @Override // a.k.b.e, androidx.activity.ComponentActivity, a.h.b.d, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.myprefs, false);
        d dbHelper = new d(this);
        try {
            dbHelper.c();
            Button btnAddFlag = (Button) findViewById(R.id.btnAddFlag);
            Button btnDisplayFlags = (Button) findViewById(R.id.btnDisplayFlags);
            btnAddFlag.setOnClickListener(new View.OnClickListener() { // from class: b.a.a.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.L(view);
                }
            });
            btnDisplayFlags.setOnClickListener(new View.OnClickListener() { // from class: b.a.a.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.N(view);
                }
            });
        } catch (IOException e) {
            throw new Error("Error copying database");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(View view) {
        Intent intent = new Intent(this, (Class<?>) addFlag.class);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(View view) {
        Intent intent = new Intent(this, (Class<?>) DisplayFlagsActivity.class);
        startActivity(intent);
    }
}
