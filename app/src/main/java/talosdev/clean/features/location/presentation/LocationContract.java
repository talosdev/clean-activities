package talosdev.clean.features.location.presentation;

public interface LocationContract {

    interface View {

        void showLatitude(String latitude);

        void showLongitude(String longitude);

        void showNoLocationAvailable();

        void showGenericError();
    }

    interface Presenter {

        void getLocation();

        void cleanup();
    }

}
