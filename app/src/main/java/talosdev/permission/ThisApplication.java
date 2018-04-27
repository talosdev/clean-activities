package talosdev.permission;


import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import talosdev.permission.di.DaggerAppComponent;

public class ThisApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder()
                .application(this)
                .build();
    }
}
