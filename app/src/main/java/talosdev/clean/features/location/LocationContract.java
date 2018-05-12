package talosdev.permission.features.location;

public interface LocationContract {

    interface View {

        void showLatitude(String latitude);

        void showLongitude(String longitude);

    }

    interface Presenter {

        void onLocationAvailable(double latitude, double longitude);

    }

}
