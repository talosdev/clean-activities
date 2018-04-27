package talosdev.permission.features.location;

import java.lang.ref.WeakReference;

import javax.inject.Inject;


public class LocationPresenter implements LocationContract.Presenter {

    private final WeakReference<LocationContract.View> viewWeakReference;

    @Inject
    public LocationPresenter(LocationContract.View view) {
        viewWeakReference = new WeakReference<>(view);
    }
}
