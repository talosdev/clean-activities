package talosdev.clean.features.phone.di;

import dagger.Binds;
import dagger.Module;
import talosdev.clean.features.phone.PhoneActivity;
import talosdev.clean.features.phone.PhoneContract;
import talosdev.clean.features.phone.PhonePresenter;

@Module
public abstract class PhoneModule {

    @Binds
    abstract PhoneContract.View provideView(PhoneActivity activity);


    @Binds
    abstract PhoneContract.Presenter providePresenter(PhonePresenter presenter);
}
