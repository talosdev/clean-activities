package talosdev.clean.features.location.presentation;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import talosdev.clean.R;

public class LocationActivity extends AppCompatActivity
        implements LocationContract.View {


    private static final int REQ_CODE = 111;

    @BindView(R.id.latitudeTextView)
    TextView latitudeTextView;

    @BindView(R.id.longitudeTextView)
    TextView longitudeTextView;

    @BindView(R.id.softDenyTextView)
    TextView softDeniedWarningTextView;

    @BindView(R.id.hardDenyTextView)
    TextView hardDeniedWarningTextView;

    @BindViews({R.id.softDenyTextView, R.id.hardDenyTextView})
    List<TextView> deniedTextViews;

    private static ButterKnife.Action<View> VISIBLE =
            (v, index) -> v.setVisibility(View.VISIBLE);
    private static ButterKnife.Action<View> GONE =
            (v, index) -> v.setVisibility(View.GONE);

    @Inject
    LocationContract.Presenter presenter;



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

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            hidePermissionDeniedWarning();
            presenter.getLocation();
        } else {
            requestPermission();
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

    @Override
    public void showNoLocationAvailable() {
        Toast.makeText(LocationActivity.this, R.string.error_accessing_location,
                                            Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGenericError() {
        Toast.makeText(LocationActivity.this, R.string.error_generic,
                Toast.LENGTH_SHORT).show();
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                REQ_CODE);
    }

    @Override
    @SuppressWarnings({"MissingPermission"})
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQ_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                hidePermissionDeniedWarning();
                presenter.getLocation();
            } else {
                handlePermissionDenied();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void handlePermissionDenied() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            showSoftPermissionDeniedWarning();
        } else {
            // user has checked the "Do not ask again" checkbox
            showHardPermissionDeniedWarning();
        }
    }

    private void hidePermissionDeniedWarning() {
        ButterKnife.apply(deniedTextViews, GONE);
    }

    private void showSoftPermissionDeniedWarning() {
        ButterKnife.apply(softDeniedWarningTextView, VISIBLE);
        ButterKnife.apply(hardDeniedWarningTextView, GONE);
    }

    private void showHardPermissionDeniedWarning() {
        ButterKnife.apply(hardDeniedWarningTextView, VISIBLE);
        ButterKnife.apply(softDeniedWarningTextView, GONE);
    }

    @OnClick(R.id.softDenyTextView)
    void softDenyTextViewClicked(View view) {
        requestPermission();
    }

    @OnClick(R.id.hardDenyTextView)
    void hardDenyTextViewClicked(View view) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.cleanup();
    }
}