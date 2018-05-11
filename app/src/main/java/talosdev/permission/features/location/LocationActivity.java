package talosdev.permission.features.location;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import talosdev.permission.R;

public class LocationActivity extends AppCompatActivity implements LocationContract.View {


    private static final int REQ_CODE = 111;

    @BindView(R.id.latitudeTextView)
    TextView latitudeTextView;

    @BindView(R.id.longitudeTextView)
    TextView longitudeTextView;

    @Inject
    LocationContract.Presenter presenter;

    private FusedLocationProviderClient fusedLocationProviderClient;


    public static Intent newIntent(Context context) {
        Intent i = new Intent(context, LocationActivity.class);
        Bundle b = new Bundle();

        i.putExtras(b);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_activity);

        ButterKnife.bind(this);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getLocation();
        } else {
            requestPermission();
        }
    }

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    @SuppressWarnings({"MissingPermission"})
    private void getLocation() {
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            presenter.onLocationAvailable(location.getLatitude(), location.getLongitude());
                        } else {
                            //TODO
                        }
                    }
                });
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {

            // TODO

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQ_CODE);

        }
    }


    @Override
    @SuppressWarnings({"MissingPermission"})
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQ_CODE &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getLocation();
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void showLatitude(String latitude) {
        latitudeTextView.setText(latitude);
    }

    @Override
    public void showLongitude(String longitude) {
        longitudeTextView.setText(longitude);
    }
}
