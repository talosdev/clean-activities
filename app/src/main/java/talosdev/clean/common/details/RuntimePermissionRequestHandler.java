package talosdev.clean.common.details;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import talosdev.clean.common.PermissionRequestHandler;

public class RuntimePermissionRequestHandler implements PermissionRequestHandler {
    
    private final WeakReference<Activity> activityWeakReference;
    private final String permission;
    private final int requestCode;
    private final PublishSubject<PermissionRequestResult> publishSubject;
    
    // TODO - think about supporting multiple permissions
    public RuntimePermissionRequestHandler(Activity activity, String permission, int requestCode) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.permission = permission;
        this.requestCode = requestCode;
        publishSubject = PublishSubject.create();
    }
    
    @Override
    public boolean checkHasPermission() {
        if (activityWeakReference.get() != null) {
            Activity activity = activityWeakReference.get();
            return ContextCompat.checkSelfPermission(activity, permission)
                    == PackageManager.PERMISSION_GRANTED;
        }
        
        return false;
    }
    
    @Override
    public void requestPermission() {
        if (activityWeakReference.get() != null) {
            ActivityCompat.requestPermissions(
                    activityWeakReference.get(),
                    new String[] {permission},
                    requestCode);
        }
    }

    @Override
    public Observable<PermissionRequestResult> getResultStream() {
        return publishSubject;
    }
    
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onPermissionRequestResult(boolean granted) {
        if (granted) {
            publishSubject.onNext(PermissionRequestResult.GRANTED);
        } else {
            Activity activity = activityWeakReference.get();
            if (activity != null) {
                publishSubject.onNext(
                    activity.shouldShowRequestPermissionRationale(permission)
                        ? PermissionRequestResult.DENIED_SOFT
                        : PermissionRequestResult.DENIED_HARD
                );
            }
        }
    }
    
    
}