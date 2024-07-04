package b.a.a;

import android.content.Context;
import android.util.Base64;
import com.example.addflag.utility;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import net.sqlcipher.BuildConfig;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/* loaded from: classes.dex */
public class d extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static d f939a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f940b = BuildConfig.FLAVOR;
    public Context c;
    public String d;

    public static synchronized d f(Context context) {
        d databaseHelper;
        synchronized (d.class) {
            synchronized (d.class) {
                if (f939a == null) {
                    f939a = new d(context);
                }
                databaseHelper = f939a;
            }
            return databaseHelper;
        }
        return databaseHelper;
    }

    public d(Context context) {
        super(context, "flags.ty", null, 1);
        SQLiteDatabase.loadLibs(context);
        this.c = context;
        f940b = context.getDatabasePath("flags.ty").getPath();
    }

    public void c() {
        boolean dbExist = a();
        if (!dbExist) {
            try {
                b();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    public final boolean a() {
        File dbFile = new File(f940b);
        return dbFile.exists();
    }

    public final void b() {
        InputStream myInput = this.c.getAssets().open("flags.ty");
        OutputStream myOutput = new FileOutputStream(f940b);
        byte[] buffer = new byte[1024];
        while (true) {
            int length = myInput.read(buffer);
            if (length > 0) {
                myOutput.write(buffer, 0, length);
            } else {
                myOutput.flush();
                myOutput.close();
                myInput.close();
                return;
            }
        }
    }

    @Override // net.sqlcipher.database.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
    }

    public String e(String flag) {
        int cipher_len = ((flag.length() + 16) / 16) * 16;
        byte[] cipherFlag = new byte[cipher_len];
        byte[] tag = new byte[16];
        utility.a().encrypt(flag, flag.length(), e.b().c(this.c), e.b().a(this.c), cipherFlag, tag);
        this.d = Base64.encodeToString(tag, 0);
        String base64_flag = Base64.encodeToString(cipherFlag, 0);
        return base64_flag;
    }

    public String d(String cipherFlag, String encode_tag) {
        byte[] ciphertext = Base64.decode(cipherFlag, 0);
        byte[] tag = Base64.decode(encode_tag, 0);
        int clen = ciphertext.length;
        while (clen != 0 && ciphertext[clen - 1] == 0) {
            clen--;
        }
        if (clen <= 0) {
            return BuildConfig.FLAVOR;
        }
        byte[] pt = new byte[clen];
        int pt_len = utility.a().decrypt(ciphertext, clen, e.b().c(this.c), e.b().a(this.c), pt, tag);
        if (pt_len < 0) {
            return null;
        }
        String flag = new String(Arrays.copyOfRange(pt, 0, pt_len), StandardCharsets.UTF_8);
        return flag;
    }

    @Override // net.sqlcipher.database.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS FLAGS");
        onCreate(db);
    }

    public String g() {
        return this.d;
    }
}
