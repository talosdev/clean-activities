package talosdev.clean.features.location.domain;

import javax.inject.Inject;

import io.reactivex.Single;
import talosdev.clean.features.location.domain.model.Location;

public class LocationInteractor {

    private final LocationProvider locationProvider;

    @Inject
    public LocationInteractor(LocationProvider locationProvider) {
        this.locationProvider = locationProvider;
    }


    public Single<Location> getLocation() {
        return locationProvider.getLocation();
    }
}
