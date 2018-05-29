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
        
        /**
         * Signals the presenter to start the process for fetching the location.
         * If permissions are required, requesting them will be handled inside this process
         */
        void loadData();

        void cleanup();
    }

}
