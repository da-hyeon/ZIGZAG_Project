package com.zigzag_hwang.user.zigzag_project.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zigzag_hwang.user.zigzag_project.Activity.Popup.Pop_Filter;
import com.zigzag_hwang.user.zigzag_project.Adapter.ShopListAdapter;
import com.zigzag_hwang.user.zigzag_project.Class.Data.Load_Json;
import com.zigzag_hwang.user.zigzag_project.Class.ShopData;
import com.zigzag_hwang.user.zigzag_project.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingMall extends Fragment {

    private ShopListAdapter adapter;
    private  List<ShopData> shopList;

    private ListView listView;
    private Button buttonFilter;
    private Button buttonSearch;
    private TextView text_filterList;
    private LinearLayout layout_filterList;

    public static Load_Json load_json;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopping_mall, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = (ListView) getView().findViewById(R.id.listView);
        buttonFilter = (Button) getView().findViewById(R.id.buttonFilter);
        buttonSearch = (Button) getView().findViewById(R.id.buttonSearch);
        text_filterList = (TextView) getView().findViewById(R.id.text_filterList);
        layout_filterList = (LinearLayout) getView().findViewById(R.id.layout_filterList);

        shopList = new ArrayList<>();

        load_json = new Load_Json(getContext() , shopList);
        load_json.goJson();

        adapter = new ShopListAdapter(getContext().getApplicationContext(), shopList, this);
        listView.setAdapter(adapter);

        text_filterList.setSelected(true);

        Compare_Two();

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonFilter:
                        Intent intent = new Intent(getContext(), Pop_Filter.class);
                        startActivity(intent);

                        Log.d("필터", "클릭");
                        break;
                    case R.id.buttonSearch:
                        Log.d("검색", "클릭");
                        break;
                }
            }
        };

        buttonFilter.setOnClickListener(onClickListener);
        buttonSearch.setOnClickListener(onClickListener);
    }

    public static ShoppingMall newInstance() {
        Bundle args = new Bundle();

        ShoppingMall fragment = new ShoppingMall();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
        Compare_Two();
    }

    private void Compare_Two(){
        //나이대 , 스타일이 둘다 선택되지 않았다면
        if(load_json.sharedData.getAge_String().equals("") && load_json.sharedData.getStyle_String().equals("")) {
            layout_filterList.setVisibility(View.GONE);
        }

        //나이대 , 스타일이 둘다 선택되었다면
        else if(!load_json.sharedData.getAge_String().equals("") && !load_json.sharedData.getStyle_String().equals("")){
            text_filterList.setText(load_json.sharedData.getAge_String() + " / " + load_json.sharedData.getStyle_String());
            layout_filterList.setVisibility(View.VISIBLE);
        }

        //나이대만 선택이 되었다면
        else if(!load_json.sharedData.getAge_String().equals("") && load_json.sharedData.getStyle_String().equals("")){
            text_filterList.setText(load_json.sharedData.getAge_String());
            layout_filterList.setVisibility(View.VISIBLE);
        }
        //스타일만 선택이 되었다면
        else{
            text_filterList.setText(load_json.sharedData.getStyle_String());
            layout_filterList.setVisibility(View.VISIBLE);
        }
    }
}
