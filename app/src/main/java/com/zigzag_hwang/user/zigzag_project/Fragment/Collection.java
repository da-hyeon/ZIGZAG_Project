package com.zigzag_hwang.user.zigzag_project.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zigzag_hwang.user.zigzag_project.R;


public class Collection extends Fragment {

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collection, container, false);
    }

    public static Collection newInstance() {
        Bundle args = new Bundle();

        Collection fragment = new Collection();
        fragment.setArguments(args);
        return fragment;
    }
}
