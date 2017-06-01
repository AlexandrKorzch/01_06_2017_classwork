package com.korzh.user.activityfragmentcommunication;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.korzh.user.activityfragmentcommunication.callback.SetFirstFragment;
import com.korzh.user.activityfragmentcommunication.callback.SetSecondFragment;
import com.korzh.user.activityfragmentcommunication.callback.SetThirdFragment;
import com.korzh.user.activityfragmentcommunication.fragment.FirstFragment;
import com.korzh.user.activityfragmentcommunication.fragment.SecondFragment;
import com.korzh.user.activityfragmentcommunication.fragment.ThirdFragment;

import static com.korzh.user.activityfragmentcommunication.general.Const.FIRST;
import static com.korzh.user.activityfragmentcommunication.general.Const.SECOND;
import static com.korzh.user.activityfragmentcommunication.general.Const.THIRD;

public class MainActivity extends AppCompatActivity
        implements SetFirstFragment, SetSecondFragment, SetThirdFragment {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFirstFragment();
    }

    @Override
    public void setFirstFragment() {
        setFragment(FirstFragment.newInstance(Color.BLUE));
    }

    @Override
    public void setThirdFragment() {
        setFragment(ThirdFragment.newInstance());
    }

    @Override
    public void setSecondFragment() {
        setFragment(SecondFragment.newInstance());
    }

    private void setFragment(final Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(fragment.getClass().getSimpleName())
                .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                .commit();

    }
}
