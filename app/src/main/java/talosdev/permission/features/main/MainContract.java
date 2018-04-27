package talosdev.permission.features.main;
/*
 * Copyright (c) 2018 FutureWorkshops. All rights reserved.
 */

public interface MainContract {

    interface View {
        void navigateToLocation();

        void navigateToPhone();
    }

    interface Presenter {
        void onLocationClicked();

        void onPhoneClicked();
    }

}
