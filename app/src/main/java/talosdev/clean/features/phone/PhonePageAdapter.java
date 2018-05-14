package talosdev.clean.features.phone;

import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import talosdev.clean.features.phone.contacts.ContactsFragment;
import talosdev.clean.features.phone.sms.SMSFragment;
import talosdev.clean.R;

class PhonePageAdapter extends FragmentPagerAdapter {


    private Resources resources;

    public PhonePageAdapter(FragmentManager fm, Resources resources) {
        super(fm);
        this.resources = resources;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return resources.getString(R.string.contacts_title);
            case 1:
                return resources.getString(R.string.sms_title);
            default:
                return "";
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return ContactsFragment.newInstance();
            case 1:
                return SMSFragment.newInstance();
            default:
                throw new IllegalArgumentException("Illegal fragment adapter position");
        }
    }
}
