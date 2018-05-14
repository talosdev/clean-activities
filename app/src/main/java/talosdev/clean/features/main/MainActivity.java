package talosdev.clean.features.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import talosdev.clean.features.location.presentation.LocationActivity;
import talosdev.clean.R;
import talosdev.clean.features.phone.PhoneActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {


    @Inject
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.locationButton)
    public void locationButtonClicked(View view) {
        presenter.onLocationClicked();
    }

    @OnClick(R.id.phoneButton)
    public void phoneButtonClicked(View view) {
        presenter.onPhoneClicked();
    }

    @Override
    public void navigateToLocation() {
        Intent intent = LocationActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void navigateToPhone() {
        Intent intent = PhoneActivity.newIntent(this);
        startActivity(intent);
    }
}
