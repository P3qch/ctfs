package net.sqlcipher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.IContentObserver;

/* loaded from: classes.dex */
public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    public BulkCursorNative() {
        attachInterface(this, IBulkCursor.descriptor);
    }

    public static IBulkCursor asInterface(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IBulkCursor in = (IBulkCursor) obj.queryLocalInterface(IBulkCursor.descriptor);
        if (in != null) {
            return in;
        }
        return new BulkCursorProxy(obj);
    }

    @Override // android.os.Binder
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
        try {
            switch (code) {
                case 1:
                    data.enforceInterface(IBulkCursor.descriptor);
                    int startPos = data.readInt();
                    CursorWindow window = getWindow(startPos);
                    if (window == null) {
                        reply.writeInt(0);
                        return true;
                    }
                    reply.writeNoException();
                    reply.writeInt(1);
                    window.writeToParcel(reply, 0);
                    return true;
                case 2:
                    data.enforceInterface(IBulkCursor.descriptor);
                    int count = count();
                    reply.writeNoException();
                    reply.writeInt(count);
                    return true;
                case 3:
                    data.enforceInterface(IBulkCursor.descriptor);
                    String[] columnNames = getColumnNames();
                    reply.writeNoException();
                    reply.writeInt(columnNames.length);
                    for (String str : columnNames) {
                        reply.writeString(str);
                    }
                    return true;
                case 4:
                    data.enforceInterface(IBulkCursor.descriptor);
                    HashMap<Long, Map<String, Object>> values = data.readHashMap(null);
                    boolean result = updateRows(values);
                    reply.writeNoException();
                    reply.writeInt(result ? 1 : 0);
                    return true;
                case 5:
                    data.enforceInterface(IBulkCursor.descriptor);
                    int position = data.readInt();
                    boolean result2 = deleteRow(position);
                    reply.writeNoException();
                    reply.writeInt(result2 ? 1 : 0);
                    return true;
                case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                    data.enforceInterface(IBulkCursor.descriptor);
                    deactivate();
                    reply.writeNoException();
                    return true;
                case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                    data.enforceInterface(IBulkCursor.descriptor);
                    IContentObserver observer = IContentObserver.Stub.asInterface(data.readStrongBinder());
                    int count2 = requery(observer, CursorWindow.CREATOR.createFromParcel(data));
                    reply.writeNoException();
                    reply.writeInt(count2);
                    reply.writeBundle(getExtras());
                    return true;
                case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                    data.enforceInterface(IBulkCursor.descriptor);
                    int position2 = data.readInt();
                    onMove(position2);
                    reply.writeNoException();
                    return true;
                case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                    data.enforceInterface(IBulkCursor.descriptor);
                    boolean result3 = getWantsAllOnMoveCalls();
                    reply.writeNoException();
                    reply.writeInt(result3 ? 1 : 0);
                    return true;
                case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                    data.enforceInterface(IBulkCursor.descriptor);
                    Bundle extras = getExtras();
                    reply.writeNoException();
                    reply.writeBundle(extras);
                    return true;
                case IBulkCursor.RESPOND_TRANSACTION /* 11 */:
                    data.enforceInterface(IBulkCursor.descriptor);
                    Bundle extras2 = data.readBundle(getClass().getClassLoader());
                    Bundle returnExtras = respond(extras2);
                    reply.writeNoException();
                    reply.writeBundle(returnExtras);
                    return true;
                case IBulkCursor.CLOSE_TRANSACTION /* 12 */:
                    data.enforceInterface(IBulkCursor.descriptor);
                    close();
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        } catch (Exception e) {
            DatabaseUtils.writeExceptionToParcel(reply, e);
            return true;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
