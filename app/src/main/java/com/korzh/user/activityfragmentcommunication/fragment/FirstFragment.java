package com.korzh.user.activityfragmentcommunication.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.korzh.user.activityfragmentcommunication.R;
import com.korzh.user.activityfragmentcommunication.callback.SetSecondFragment;

import static com.korzh.user.activityfragmentcommunication.general.Const.COLOR_KEY;


public class FirstFragment extends Fragment {

    private static final String TAG = "FirstFragment";

    private int mColor;

    public static FirstFragment newInstance(int color) {

        Log.d(TAG, "newInstance() called with: color = [" + color + "]");

        Bundle bundle = new Bundle();
        bundle.putInt(COLOR_KEY, color);
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private SetSecondFragment mSetSecondFRgagmentCallBAck;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mSetSecondFRgagmentCallBAck = (SetSecondFragment)getContext();
        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey(COLOR_KEY)){
            mColor = bundle.getInt(COLOR_KEY);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSetSecondFRgagmentCallBAck = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button mButton = (Button) view.findViewById(R.id.btn_click);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetSecondFRgagmentCallBAck.setSecondFragment();
            }
        });
        if(mColor != 0){
            mButton.setBackgroundColor(mColor);
        }
        return view;
    }
}
