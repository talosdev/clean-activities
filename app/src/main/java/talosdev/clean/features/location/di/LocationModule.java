package talosdev.clean.features.location.di;

import dagger.Binds;
import dagger.Module;
import talosdev.clean.features.location.LocationActivity;
import talosdev.clean.features.location.LocationContract;
import talosdev.clean.features.location.LocationPresenter;

@Module
public abstract class LocationModule {

    @Binds
    abstract LocationContract.View provideView(LocationActivity activity);


    @Binds
    abstract LocationContract.Presenter providePresenter(LocationPresenter presenter);
}
