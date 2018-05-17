package talosdev.clean.common;

import io.reactivex.Observable;

public interface PermissionRequestHandler {
    
    boolean checkHasPermission();
    
    void requestPermission();
    
    /**
     * This delegates to {@link Activity#shouldShowRequestPermissionRationale(String)}.
     * This will return <code>false</code> if the permission has not been requested,
     * <code>true</code> if the permission has been denied, and <code>false</code> if it has been
     * denied with "do not ask again". <p>
     * If you are sure that the permission has been requested once, you can use the return value to
     * decide whether you should request again (<code>true</code>) or redirect to app settings
     * (<code>false</code>)
     * @return
     */
    boolean shouldShowRationale();
    
    /**
     * Observable, and not a Single, because the user might initiate the permission request process
     * multiple times.
     * @return
     */
    Observable<Boolean> getResultStream();
    
    /**
     * To be called from {@link Activity#onRequestPermissionsResult(int, String[], int[])}
     */
    void onPermissionGranted();
    
    
    /**
     * To be called from {@link Activity#onRequestPermissionsResult(int, String[], int[])}
     */
    void onPermissionDenied();
}