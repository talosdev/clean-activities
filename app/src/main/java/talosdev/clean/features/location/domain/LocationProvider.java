package talosdev.clean.features.location.domain;

import android.support.annotation.Nullable;

import talosdev.clean.features.location.model.Location;

public interface LocationProvider {

    @Nullable
    Location getLocation();

}
