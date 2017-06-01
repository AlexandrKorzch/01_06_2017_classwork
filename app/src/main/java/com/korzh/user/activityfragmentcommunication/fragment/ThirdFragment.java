package com.korzh.user.activityfragmentcommunication.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.korzh.user.activityfragmentcommunication.R;
import com.korzh.user.activityfragmentcommunication.callback.SetFirstFragment;

import static com.korzh.user.activityfragmentcommunication.general.Const.FIRST;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {


    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }


    private SetFirstFragment mSetFirstFragmentCallBAck;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mSetFirstFragmentCallBAck = (SetFirstFragment) getContext();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSetFirstFragmentCallBAck = null;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        Button button = (Button) view.findViewById(R.id.btn_click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetFirstFragmentCallBAck.setFirstFragment();
            }
        });

        return view;
    }

}
