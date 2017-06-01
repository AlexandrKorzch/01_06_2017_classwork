package com.korzh.user.activityfragmentcommunication.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.korzh.user.activityfragmentcommunication.R;
import com.korzh.user.activityfragmentcommunication.callback.SetThirdFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    private SetThirdFragment mSetThirdFragmentCallBAck;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mSetThirdFragmentCallBAck = (SetThirdFragment)getContext();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSetThirdFragmentCallBAck = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Button button = (Button) view.findViewById(R.id.btn_click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetThirdFragmentCallBAck.setThirdFragment();
            }
        });

        return view;
    }

}
