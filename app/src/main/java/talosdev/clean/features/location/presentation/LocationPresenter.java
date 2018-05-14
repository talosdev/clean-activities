package talosdev.clean.features.location.presentation;

import android.util.Log;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import talosdev.clean.features.location.domain.LocationProvider;
import talosdev.clean.features.location.model.Location;
import talosdev.clean.features.location.model.NoLocationAvailableException;


public class LocationPresenter implements LocationContract.Presenter {

    private static final String TAG = "LOCATION";

    private final WeakReference<LocationContract.View> viewWeakReference;
    private final LocationProvider locationProvider;
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    public LocationPresenter(LocationContract.View view, LocationProvider locationProvider) {
        this.viewWeakReference = new WeakReference<>(view);
        this.locationProvider = locationProvider;
    }

    @Override
    public void onLocationAvailable(double latitude, double longitude) {
        LocationContract.View view = viewWeakReference.get();
        if (view != null) {
            view.showLatitude(String.valueOf(latitude));
            view.showLongitude(String.valueOf(longitude));
        }
    }

    @Override
    public void getLocation() {
        disposables.add(
                locationProvider.getLocation()
                        .subscribe(
                                location -> {
                                    LocationContract.View view = viewWeakReference.get();
                                    if (view != null) {
                                        view.showLatitude(String.valueOf(location.latitude()));
                                        view.showLongitude(String.valueOf(location.longitude()));
                                    }
                                },
                                throwable -> {
                                    LocationContract.View view = viewWeakReference.get();
                                    if (view != null) {
                                        Log.e(TAG,"Error while getting location", throwable);
                                        if (throwable instanceof NoLocationAvailableException) {
                                            view.showNoLocationAvailable();
                                        } else {
                                            view.showGenericError();
                                        }

                                    }
                                }

                        )
        );
    }


    @Override
    public void cleanup() {
        disposables.clear();
//        locationProvider.unregister();
    }
}
