package talosdev.clean.features.location.di;

import dagger.Binds;
import dagger.Module;
import talosdev.clean.features.location.details.AndroidLocationProvider;
import talosdev.clean.features.location.domain.LocationProvider;
import talosdev.clean.features.location.presentation.LocationActivity;
import talosdev.clean.features.location.presentation.LocationContract;
import talosdev.clean.features.location.presentation.LocationPresenter;

@Module
public abstract class LocationModule {

    @Binds
    abstract LocationContract.View provideView(LocationActivity activity);


    @Binds
    abstract LocationContract.Presenter providePresenter(LocationPresenter presenter);

    @Binds
    abstract LocationProvider providerLocationProvider(AndroidLocationProvider locationProvider);
}
