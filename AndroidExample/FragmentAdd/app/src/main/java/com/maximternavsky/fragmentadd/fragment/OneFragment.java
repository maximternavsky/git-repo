package com.maximternavsky.fragmentadd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maximternavsky.fragmentadd.R;

/**
 * Created by Максим on 01.12.2017.
 */

public class OneFragment extends Fragment {

    public static final String TAG = "OneFragmentTag";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg1, null);
    }
}
