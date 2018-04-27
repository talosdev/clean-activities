package talosdev.permission.features.phone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import talosdev.permission.R;

public class PhoneActivity extends AppCompatActivity implements PhoneContract.View {

    @Inject
    PhoneContract.Presenter presenter;


    public static Intent newIntent(Context context) {
        Intent i = new Intent(context, PhoneActivity.class);
        Bundle b = new Bundle();

        i.putExtras(b);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_activity);
    }
}
