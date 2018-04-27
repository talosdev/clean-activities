package talosdev.permission.features.phone;

import java.lang.ref.WeakReference;

import javax.inject.Inject;


public class PhonePresenter implements PhoneContract.Presenter {


    private final WeakReference<PhoneContract.View> viewWeakReference;

    @Inject
    public PhonePresenter(PhoneContract.View view) {
        viewWeakReference = new WeakReference<>(view);
    }
}
