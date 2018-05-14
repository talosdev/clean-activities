package talosdev.clean.features.main.di;

import dagger.Binds;
import dagger.Module;
import talosdev.clean.features.main.MainActivity;
import talosdev.clean.features.main.MainContract;
import talosdev.clean.features.main.MainPresenter;

@Module
public abstract class MainModule {

    @Binds
    abstract MainContract.View provideView(MainActivity activity);


    @Binds
    abstract MainContract.Presenter providePresenter(MainPresenter presenter);
}
