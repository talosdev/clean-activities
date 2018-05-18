package talosdev.clean.common;

import android.app.Activity;

import io.reactivex.Observable;

public interface PermissionRequestHandler {
    
    boolean checkHasPermission();
    
    void requestPermission();
    
    /**
     * Observable, and not a Single, because the user might initiate the permission request process
     * multiple times.
     * @return
     */
    Observable<PermissionRequestResult> getResultStream();
    
    /**
     * To be called from {@link Activity#onRequestPermissionsResult(int, String[], int[])}
     */
    void onPermissionGranted();
    
    
    /**
     * To be called from {@link Activity#onRequestPermissionsResult(int, String[], int[])}
     */
    void onPermissionDenied();


    enum PermissionRequestResult {
        GRANTED,
        DENIED_SOFT,
        DENIED_HARD
    }
}