package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* loaded from: classes.dex */
public class CoreComponentFactory extends AppComponentFactory {

    /* loaded from: classes.dex */
    public interface a {
        Object a();
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader cl, String className, Intent intent) {
        return (Activity) a(super.instantiateActivity(cl, className, intent));
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader cl, String className) {
        return (Application) a(super.instantiateApplication(cl, className));
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader cl, String className, Intent intent) {
        return (BroadcastReceiver) a(super.instantiateReceiver(cl, className, intent));
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader cl, String className) {
        return (ContentProvider) a(super.instantiateProvider(cl, className));
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader cl, String className, Intent intent) {
        return (Service) a(super.instantiateService(cl, className, intent));
    }

    public static <T> T a(T t) {
        T t2;
        if ((t instanceof a) && (t2 = (T) ((a) t).a()) != null) {
            return t2;
        }
        return t;
    }
}
