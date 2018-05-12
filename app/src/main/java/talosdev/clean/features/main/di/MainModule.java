package talosdev.permission.features.main.di;

import dagger.Binds;
import dagger.Module;
import talosdev.permission.features.main.MainActivity;
import talosdev.permission.features.main.MainContract;
import talosdev.permission.features.main.MainPresenter;

@Module
public abstract class MainModule {

    @Binds
    abstract MainContract.View provideView(MainActivity activity);


    @Binds
    abstract MainContract.Presenter providePresenter(MainPresenter presenter);
}
