package talosdev.clean;


import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import talosdev.clean.di.DaggerAppComponent;

public class ThisApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder()
                .application(this)
                .build();
    }
}
