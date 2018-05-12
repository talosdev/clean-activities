package talosdev.permission.features.phone.sms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import talosdev.permission.R;

public class SMSFragment extends Fragment {


    public SMSFragment() {
        // Required empty public constructor
    }


    public static SMSFragment newInstance() {
        SMSFragment fragment = new SMSFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.phone_sms_fragment, container, false);
    }




}
