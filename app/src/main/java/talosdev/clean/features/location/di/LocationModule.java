package talosdev.clean.features.location.di;

import android.Manifest;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import talosdev.clean.common.PermissionRequestHandler;
import talosdev.clean.common.RuntimePermissionRequestHandler;
import talosdev.clean.features.location.details.AndroidLocationProvider;
import talosdev.clean.features.location.domain.LocationProvider;
import talosdev.clean.features.location.presentation.LocationActivity;
import talosdev.clean.features.location.presentation.LocationContract;
import talosdev.clean.features.location.presentation.LocationPresenter;

import javax.inject.Named;

@Module
public abstract class LocationModule {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 144;

    @Binds
    abstract LocationContract.View provideView(LocationActivity activity);


    @Binds
    abstract LocationContract.Presenter providePresenter(LocationPresenter presenter);

    @Binds
    abstract LocationProvider providerLocationProvider(AndroidLocationProvider locationProvider);

    @Provides
    @Named("locationReqCode")
    static Integer provideLocationReqCode() {
        return LOCATION_PERMISSION_REQUEST_CODE;
    }

    @Provides
    static PermissionRequestHandler providePermissionRequestHandler(LocationActivity activity, @Named("locationReqCode") Integer reqCode) {
        return new RuntimePermissionRequestHandler(activity, Manifest.permission.ACCESS_FINE_LOCATION, reqCode);
    }
}
