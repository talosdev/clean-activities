package talosdev.permission.features.location.di;

import dagger.Binds;
import dagger.Module;
import talosdev.permission.features.location.LocationActivity;
import talosdev.permission.features.location.LocationContract;
import talosdev.permission.features.location.LocationPresenter;

@Module
public abstract class LocationModule {

    @Binds
    abstract LocationContract.View provideView(LocationActivity activity);


    @Binds
    abstract LocationContract.Presenter providePresenter(LocationPresenter presenter);
}
