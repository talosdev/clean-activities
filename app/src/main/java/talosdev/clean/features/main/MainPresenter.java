package talosdev.permission.features.main;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {


    private final WeakReference<MainContract.View> viewWeakReference;

    @Inject
    public MainPresenter(MainContract.View view) {
        viewWeakReference = new WeakReference<>(view);
    }

    @Override
    public void onLocationClicked() {
        MainContract.View view = viewWeakReference.get();
        if (view != null) {
           view.navigateToLocation();
        }
    }

    @Override
    public void onPhoneClicked() {
        MainContract.View view = viewWeakReference.get();
        if (view != null) {
            view.navigateToPhone();
        }
    }
}
