package talosdev.permission.features.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import talosdev.permission.R;

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
        Toast.makeText(this, "LOCATION", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToPhone() {
        Toast.makeText(this, "PHONE", Toast.LENGTH_SHORT).show();

    }
}
