package talosdev.clean.features.location.domain;

import android.support.annotation.Nullable;

import io.reactivex.Single;
import talosdev.clean.features.location.model.Location;

public interface LocationProvider {

    @Nullable
    Single<Location> getLocation();

}
