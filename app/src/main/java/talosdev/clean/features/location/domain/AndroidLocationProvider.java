package talosdev.clean.features.location.domain;

import android.Manifest;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import javax.inject.Inject;

import io.reactivex.Single;
import talosdev.clean.features.location.model.Location;
import talosdev.clean.features.location.model.NoLocationAvailableException;

public class AndroidLocationProvider implements LocationProvider {

    private FusedLocationProviderClient fusedLocationProviderClient;

    @Inject
    public AndroidLocationProvider(Context context) {
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
    }

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    @SuppressWarnings({"MissingPermission"})
    @Nullable
    @Override
    public Single<Location> getLocation() {

        return Single.create(
                emitter -> fusedLocationProviderClient
                        .getLastLocation()
                        .addOnSuccessListener(location -> {
                                    if (location != null) {
                                        emitter.onSuccess(Location.create(location.getLatitude(), location.getLongitude()));
                                    } else {
                                        Log.w("LOCATION", "Are you using an emulator? " +
                                                "Make sure you send a dummy location to the emulator through the emulator settings");
                                        emitter.onError(new NoLocationAvailableException());
                                    }
                                }
                        )
        );

    }
}