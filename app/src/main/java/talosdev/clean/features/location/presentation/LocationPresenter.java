package talosdev.clean.features.location.presentation;

import java.lang.ref.WeakReference;

import javax.inject.Inject;


public class LocationPresenter implements LocationContract.Presenter {

    private final WeakReference<LocationContract.View> viewWeakReference;

    @Inject
    public LocationPresenter(LocationContract.View view) {
        viewWeakReference = new WeakReference<>(view);
    }

    @Override
    public void onLocationAvailable(double latitude, double longitude) {
        LocationContract.View view = viewWeakReference.get();
        if (view != null) {
           view.showLatitude(String.valueOf(latitude));
           view.showLongitude(String.valueOf(longitude));
        }
    }
}
