package talosdev.permission.features.main;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import talosdev.permission.R;
import talosdev.permission.features.location.LocationActivity;
import talosdev.permission.features.phone.PhoneActivity;

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
