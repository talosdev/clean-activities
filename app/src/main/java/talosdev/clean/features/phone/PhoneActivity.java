package talosdev.clean.features.phone;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import talosdev.clean.R;

public class PhoneActivity extends AppCompatActivity implements PhoneContract.View {

    @Inject
    PhoneContract.Presenter presenter;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

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
        ButterKnife.bind(this);

        viewPager.setAdapter(new PhonePageAdapter(getSupportFragmentManager(), getResources()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
