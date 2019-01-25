package com.zigzag_hwang.user.zigzag_project.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zigzag_hwang.user.zigzag_project.R;

public class SearchProduct extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_serch_product, container, false);
    }

    public static SearchProduct newInstance() {
        Bundle args = new Bundle();

        SearchProduct fragment = new SearchProduct();
        fragment.setArguments(args);
        return fragment;
    }
}
