package talosdev.clean.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import talosdev.clean.di.scope.ActivityScope;
import talosdev.clean.features.location.presentation.LocationActivity;
import talosdev.clean.features.location.di.LocationModule;
import talosdev.clean.features.main.MainActivity;
import talosdev.clean.features.main.di.MainModule;
import talosdev.clean.features.phone.PhoneActivity;
import talosdev.clean.features.phone.di.PhoneModule;

@Module
public abstract class ActivityComponentBindModule {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainsActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = LocationModule.class)
    abstract LocationActivity bindLocationActivity();

    @ContributesAndroidInjector(modules = PhoneModule.class)
    abstract PhoneActivity bindPhoneActivity();

}
