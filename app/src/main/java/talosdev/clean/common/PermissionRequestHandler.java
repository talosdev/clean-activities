package talosdev.clean.common;

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
    

    enum PermissionRequestResult {
        GRANTED,
        DENIED_SOFT,
        DENIED_HARD
    }
}