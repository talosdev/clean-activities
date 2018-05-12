package talosdev.clean.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import talosdev.permission.features.location.LocationActivity;
import talosdev.permission.features.location.di.LocationModule;
import talosdev.permission.features.main.MainActivity;
import talosdev.permission.features.main.di.MainModule;
import talosdev.permission.features.phone.PhoneActivity;
import talosdev.permission.features.phone.di.PhoneModule;

@Module
public abstract class ActivityComponentBindModule {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainsActivity();


    @ContributesAndroidInjector(modules = LocationModule.class)
    abstract LocationActivity bindLocationActivity();

    @ContributesAndroidInjector(modules = PhoneModule.class)
    abstract PhoneActivity bindPhoneActivity();

}
