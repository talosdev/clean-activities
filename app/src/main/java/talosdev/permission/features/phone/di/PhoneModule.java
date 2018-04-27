package talosdev.permission.features.phone.di;

import dagger.Binds;
import dagger.Module;
import talosdev.permission.features.phone.PhoneActivity;
import talosdev.permission.features.phone.PhoneContract;
import talosdev.permission.features.phone.PhonePresenter;

@Module
public abstract class PhoneModule {

    @Binds
    abstract PhoneContract.View provideView(PhoneActivity activity);


    @Binds
    abstract PhoneContract.Presenter providePresenter(PhonePresenter presenter);
}
