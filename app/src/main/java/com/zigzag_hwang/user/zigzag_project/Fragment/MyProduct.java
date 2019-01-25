package com.zigzag_hwang.user.zigzag_project.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zigzag_hwang.user.zigzag_project.R;

public class MyProduct extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_product, container, false);
    }

    public static MyProduct newInstance() {
        Bundle args = new Bundle();

        MyProduct fragment = new MyProduct();
        fragment.setArguments(args);
        return fragment;
    }
}
