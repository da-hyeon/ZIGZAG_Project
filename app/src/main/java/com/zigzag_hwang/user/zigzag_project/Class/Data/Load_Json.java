package com.zigzag_hwang.user.zigzag_project.Class.Data;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.zigzag_hwang.user.zigzag_project.Class.ShopData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Load_Json {

    private Context context;
    private List<ShopData> shopList;
    public Shared_Data sharedData;

    public Load_Json(Context context, List<ShopData> shopList) {
        this.context = context;
        this.shopList = shopList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void goJson() {
        shopList_jsonParser(context, loadJSONFromAsset(context), shopList);
        //shopList에 저장되어있음


        Collections.reverse(shopList);
        Comparator<ShopData> cmp = Comparator.comparing(ShopData::getShopStyle_MatchCount)
                .thenComparing(ShopData::getShopScore);
        Collections.sort(shopList, cmp);
        Collections.reverse(shopList);
    }


    private void shopList_jsonParser(Context context, String jsonString, List<ShopData> shopList) {
        shopList.clear();

        int shopScore;
        String shopName;
        String shopAddress;
        String shopStyle[];
        String shopAge[];
        String shopImageAddress;

        ShopData shopData;

        sharedData = new Shared_Data(context);

        try {
            JSONArray jarray = new JSONObject(jsonString).getJSONArray("list");
            Log.d("json", "파싱시작");
            for (int i = 0; i < jarray.length(); i++) {

                JSONObject jObject = jarray.getJSONObject(i);
                shopScore = Integer.parseInt(jObject.optString("0"));

                shopName = jObject.optString("n");
                shopAddress = jObject.optString("u");

                shopImageAddress = shopAddress.replace("http://www.", "");
                shopImageAddress = shopImageAddress.replace("http://", "");
                String shopImageAddressTemp[] = shopImageAddress.split("\\.");
                shopImageAddress = "https://cf.shop.s.zigzag.kr/images/" + shopImageAddressTemp[0] + ".jpg";

                shopStyle = jObject.optString("S").split(",");

                String temp = jObject.optString("A").replace("[", "");
                temp = temp.replace("]", "");
                shopAge = temp.split(",");

                //필터부분 -> 우선 전부 Data를 넣어놓고 나이
                shopData = new ShopData(shopScore, shopName, shopStyle, shopAge, shopImageAddress);

                //스타일을 2개이상 골랐다면
                if (sharedData.getButton_Style_check_Length() >= 2) {
                    //스타일이 같은것을 찾아 getShopStyle_MatchCount를 증가시킨다.
                    for (int shopStyleIndex0 = 0; shopStyleIndex0 < shopStyle.length; shopStyleIndex0++) {
                        for (int shopStyleIndex = 0; shopStyleIndex < sharedData.getButton_Style_check_Length(); shopStyleIndex++) {
                            if (shopStyle[shopStyleIndex0].equals(sharedData.getShopStyle_Comparison_Target(shopStyleIndex))) {
                                shopData.setShopStyle_MatchCount(shopData.getShopStyle_MatchCount() + 1);
                            }
                        }
                    }
                }

                //나이대 , 스타일이 골라져있다면
                if (sharedData.getAge_Check_Count() != 0 && sharedData.getButton_Style_check_Length() != 0) {
                    //중복방지
                    boolean findCheck = false;
                    //나이대가 같은것을 찾는다.
                    for (int shopAgeIndex = 0; shopAgeIndex < sharedData.getButton_Age_Check_Length(); shopAgeIndex++) {
                        if (shopAge[shopAgeIndex].equals("1") && sharedData.getShopAge_Comparison_Target(shopAgeIndex).equals("1")) {
                            //스타일이 같은것을 찾는다.
                            for (int shopStyleIndex0 = 0; shopStyleIndex0 < shopStyle.length; shopStyleIndex0++) {
                                for (int shopStyleIndex = 0; shopStyleIndex < sharedData.getButton_Style_check_Length(); shopStyleIndex++) {
                                    if (shopStyle[shopStyleIndex0].equals(sharedData.getShopStyle_Comparison_Target(shopStyleIndex))) {
                                        shopList.add(shopData);
                                        findCheck = true;
                                        break;
                                    }
                                }
                                if (findCheck)
                                    break;
                            }
                        }
                        if (findCheck)
                            break;
                    }
                }

                //나이대 , 스타일이 골라져있지 않다면
                else if (sharedData.getAge_Check_Count() == 0 && sharedData.getButton_Style_check_Length() == 0) {
                    shopList.add(shopData);
                }

                //나이대는 골라져있고 , 스타일이 골라져 있지 않다면.
                else if (sharedData.getAge_Check_Count() != 0 && sharedData.getButton_Style_check_Length() == 0) {
                    //나이대가 같은것을 찾는다.
                    for (int shopAgeIndex = 0; shopAgeIndex < sharedData.getButton_Age_Check_Length(); shopAgeIndex++) {
                        if (shopAge[shopAgeIndex].equals("1") && sharedData.getShopAge_Comparison_Target(shopAgeIndex).equals("1")) {
                            shopList.add(shopData);
                            break;
                        }
                    }
                }

                //나이대는 골라져 있지 않고 , 스타일이 골라져 있다면.
                else {
                    //스타일이 같은것을 찾는다.
                    boolean findCheck = false;
                    for (int shopStyleIndex0 = 0; shopStyleIndex0 < shopStyle.length; shopStyleIndex0++) {
                        for (int shopStyleIndex = 0; shopStyleIndex < sharedData.getButton_Style_check_Length(); shopStyleIndex++) {
                            if (shopStyle[shopStyleIndex0].equals(sharedData.getShopStyle_Comparison_Target(shopStyleIndex))) {
                                shopList.add(shopData);
                                findCheck = true;
                                break;
                            }
                        }
                        if (findCheck)
                            break;
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset(Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open("json/shop_list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
