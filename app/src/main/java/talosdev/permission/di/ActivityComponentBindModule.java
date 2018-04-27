package talosdev.permission.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import talosdev.permission.features.location.LocationActivity;
import talosdev.permission.features.location.di.LocationModule;
import talosdev.permission.features.main.MainActivity;
import talosdev.permission.features.main.di.MainModule;

@Module
public abstract class ActivityComponentBindModule {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainsActivity();


    @ContributesAndroidInjector(modules = LocationModule.class)
    abstract LocationActivity bindLocationActivity();

}
