package talosdev.clean.features.location.domain;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Single;
import talosdev.clean.features.location.domain.model.Location;

public interface LocationProvider {

    @NonNull
    Single<Location> getLocation();

}
