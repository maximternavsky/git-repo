package com.maximternavsky.fragmentadd;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.maximternavsky.fragmentadd.fragment.OneFragment;
import com.maximternavsky.fragmentadd.fragment.TwoFragment;

/**
 * Created by Максим on 01.12.2017.
 */

public class MainActivity extends FragmentActivity {

    private Button buttonAdd;
    private Button buttonDel;
    private Button buttonRemove;

    private OneFragment mOneFragment;
    private TwoFragment mTwoFragment;

    private FragmentManager manager;
    private FragmentTransaction mTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        mOneFragment = new OneFragment();
        mTwoFragment = new TwoFragment();

        buttonAdd = (Button) findViewById(R.id.btnAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mTransaction = manager.beginTransaction();

                if(manager.findFragmentByTag(OneFragment.TAG) == null) {
                    mTransaction.add(R.id.container, mOneFragment, mOneFragment.TAG);
                }

                mTransaction.commit();
            }
        });

        buttonDel = (Button) findViewById(R.id.btnDel);
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTransaction = manager.beginTransaction();

                if(manager.findFragmentByTag(OneFragment.TAG) != null) {
                    mTransaction.remove(mOneFragment);
                }

                if(manager.findFragmentByTag(TwoFragment.TAG) != null) {
                    mTransaction.remove(mTwoFragment);
                }

                mTransaction.commit();
            }
        });

        buttonRemove = (Button) findViewById(R.id.btnReplace);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTransaction = manager.beginTransaction();

                if(manager.findFragmentByTag(OneFragment.TAG) != null) {
                    mTransaction.replace(R.id.container, mTwoFragment);
                }

                if(manager.findFragmentByTag(TwoFragment.TAG) != null) {
                    mTransaction.replace(R.id.container, mOneFragment);
                }

                mTransaction.commit();
            }
        });

    }
}
