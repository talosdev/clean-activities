package talosdev.clean.features.location.presentation;

public interface LocationContract {

    interface View {

        void showLatitude(String latitude);

        void showLongitude(String longitude);

        void showNoLocationAvailable();

        void showGenericError();

        void showSoftDenied();

        void showHardDenied();

        void hidePermissionDeniedWarning();
    }

    interface Presenter {

        void init();

        void cleanup();

        void requestPermissionIfRequired();
    }

}
