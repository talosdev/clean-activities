package talosdev.clean.features.location.domain;

import android.support.annotation.Nullable;

import talosdev.clean.features.location.model.Location;

public class AndroidLocationProvider implements LocationProvider {
    @Nullable
    @Override
    public Location getLocation() {
        return null;
    }
}
