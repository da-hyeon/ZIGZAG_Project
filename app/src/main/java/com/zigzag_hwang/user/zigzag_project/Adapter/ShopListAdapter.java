package com.zigzag_hwang.user.zigzag_project.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zigzag_hwang.user.zigzag_project.Class.UI.CircleTransform;
import com.zigzag_hwang.user.zigzag_project.Class.ShopData;
import com.zigzag_hwang.user.zigzag_project.R;
import java.util.List;

public class ShopListAdapter extends ArrayAdapter<ShopData> {

    private Context context;
    private List shopList;
    private Fragment parent;

    private ShopData shopData;

    class CustomViewHolder {
        public TextView rank;
        public ImageView imageView;
        public TextView shopName;
        public TextView shopAge;
        public TextView shopStyle;
    }

    public ShopListAdapter(Context context, List<ShopData> shopList, Fragment parent) {
        super(context, 0, shopList);
        this.context = context;
        this.shopList = shopList;
        this.parent = parent;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parentViewGroup) {
        CustomViewHolder viewHolder;
        shopData = (ShopData) shopList.get(i);

        View rowView = convertView; // 코드 가독성을 위해서 rowView 변수를 사용합니다.

        if (rowView == null) {
            rowView = LayoutInflater.from(getContext()).inflate(R.layout.shop_data, parentViewGroup, false);

            viewHolder = new CustomViewHolder();
            viewHolder.rank = (TextView) rowView.findViewById(R.id.rank);
            viewHolder.imageView = (ImageView) rowView.findViewById(R.id.imageView);
            viewHolder.shopName = (TextView) rowView.findViewById(R.id.shopName);
            viewHolder.shopAge = (TextView) rowView.findViewById(R.id.shopAge);
            viewHolder.shopStyle = (TextView) rowView.findViewById(R.id.shopStyle);

            rowView.setTag(viewHolder);
        } else {
            viewHolder = (CustomViewHolder) rowView.getTag();
        }

        shopData.setShopRank(i + 1);

        Picasso.get().load(shopData.getShsopImageAddress()).resize(200 ,200).transform(new CircleTransform()).into(viewHolder.imageView);

        viewHolder.rank.setText(shopData.getShopRank() + "");

        if(shopData.getShopRank() < 10)
            viewHolder.rank.setTextSize(20);
        else if (shopData.getShopRank() >= 10 && shopData.getShopRank() < 100)
            viewHolder.rank.setTextSize(15);
        else
            viewHolder.rank.setTextSize(10);

        viewHolder.shopName.setText(shopData.getShopName());
        viewHolder.shopAge.setText(shopData.getShopAge());
        viewHolder.shopStyle.setText(shopData.getShopStyle() + " " + shopData.getShopScore());

        return rowView;
    }
}
