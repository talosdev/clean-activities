package talosdev.clean.features.location.presentation;

public interface LocationContract {

    interface View {

        void showLatitude(String latitude);

        void showLongitude(String longitude);

        void showNoLocationAvailable();

        void showGenericError();
    }

    interface Presenter {

        void onLocationAvailable(double latitude, double longitude);

        void getLocation();

        void cleanup();
    }

}
